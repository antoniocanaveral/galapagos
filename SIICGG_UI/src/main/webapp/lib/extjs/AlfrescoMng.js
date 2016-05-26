/**
 * Created by acanaveral on 20/5/16.
 */

var activityIndicator = undefined;

function AlfrescoMng(_tableName, _recordID, _filter){

    var tableName = _tableName;
    var recordID = _recordID;
    var filter = _filter;

    if(tableName && recordID) {
        //Hacemos la llamada al WS para obtener la estructura de la ventana.
        var param = new SOAPClientParameters();
        param.add('tableName', tableName);
        param.add('recordID', recordID);
        param.add('filter', filter);
        activityIndicator = new Ext.LoadMask(Ext.getBody(), {msg:"Cargando..."});
        activityIndicator.show();
        var alfrescoResponse = SOAPClient.invoke(URL_WS + 'Alf_query', "getAttachmentMetadata", param, false, null);

        if (alfrescoResponse) {
            alfrescoResponse = eval("(" + alfrescoResponse + ')'); //Convierte string a Objeto JSON
            activityIndicator.msg="Inicializando Ventana";
            init(alfrescoResponse);
        } else {
            Ext.Msg.alert('Alfresco', 'No se ha definido un esquema de archivos para la ventana');
        }
    }else{
        Ext.Msg.alert('Configuracion', 'No es posible iniciar el esquema de archivos. No se han definido los parámetros');
    }
}

init = function(json){
    //Agregamos la libreria de visualizacion de PDFs
    LoadJs("lib/pipwerks/pdfobject.min.js");

    var tituloAlfrescoMng='Administración de Adjuntos';
    var descAlfrescoMng='El formulario permite administrar sus adjuntos con el repositorio de Alfresco';

    var testData = {"files":[
        {name:"archivo1", fileName:"cedula.pdf", version:undefined, id:undefined},
        {name:"archivo2", fileName:"pasaporte.pdf", version:undefined, id:"unIdTotototeParaElArchivo"},
        {name:"archivo3", fileName:"papeleta.pdf", version:undefined, id:undefined}
    ]};


    var store = new Ext.data.Store({
        root:"files",
        reader:new Ext.data.JsonReader({
            id:'id',
            root:'files'
        },[{name:"name"},{name:"fileName"}, {name:"version"},{name:"id"}]),
        fields:["name","fileName", "version", "id"]
    });

    store.loadData(testData);

    var comps=[];
    var freePanel = new Ext.Panel({
        layout:'fit',
        items:[new Ext.Button({text:'Subir'}),new Ext.Button({text:'Descargar'})]
    });
    comps.push(freePanel);

    var renderedData = store.reader.jsonData;
    var files = renderedData.files;

    var lastSelected=undefined;
    for(var i=0;i<files.length;i++){
        var fileName = new Ext.Button({
            text:files[i].name,
            prentPanelId:"tarjet_"+i,
            width: 120,
            height:30
        });
        fileName.on('click',fileSelected);
        var btnAction = new Ext.Button({
            text:files[i].id==undefined?'Subir':'Actualizar',
            fileName:files[i].fileName,
            margins: '0 0 5 15'
        });
        btnAction.on('click',subirArchivo);
        var fileRecord = new Ext.Panel({
            id:"tarjet_"+i,
            height:50,
            border:true,
            layout:'hbox',
            overCls:'selected-file-record',
            padding:10,
            items: [fileName,btnAction]
        });
        comps.push(fileRecord);
    }

    var listView = new Ext.list.ListView({
        store:store,
        multiSelect:false,
        emptyText:"No ha configurado esta ventana en el gestor de archivos",
        reserveScrollOffset: true,
        columns: [{
            header: 'Archivo',
            width: .5,
            dataIndex: 'name'
        },{
            header: 'Acciones',
            width: .35,
            dataIndex: 'id'
        }]
    });

    var west = new Ext.Panel({
        // xtype: 'panel' implied by default
        title: 'Archivos Disponibles',
        region:'west',
        margins: '5 0 0 5',
        width: 200,
        collapsible: false,   // make collapsible
        cmargins: '5 5 0 5', // adjust top margin when collapsed
        id: 'west-region-container',
        items: comps
    });

    var east = new Ext.Panel({
        title: 'Propiedades',
        region: 'east',     // position for region
        width: 200,
        collapsible: true,
        split: true,         // enable resizing
        minSize: 100,         // defaults to 50
        maxSize: 300,
        margins: '5 5 0 5'
    });

    var center = new Ext.Panel({
        title: 'Visor',
        id: 'alfresco_center_pdf_viewer',
        region: 'center',     // center region is required, no width/height specified
        xtype: 'container',
        layout: 'fit',
        margins: '5 5 0 0'
    });

    var mainPanel = new Ext.Panel({
        width: 800,
        height: 600,
        layout: 'border',
        items: [east,west,center]
    });


    // little bit of feedback
    listView.on('selectionchange', function(view, nodes){
        var l = nodes.length;
        var s = l != 1 ? 's' : '';
        west.setTitle('Simple ListView ('+l+' item'+s+' selected)');
    });


    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar los adjuntos en Alfresco
     */
    var winFrmSubirAdjunto = new Ext.Window({
        id:'winAlfrescoMng',
        title:tituloAlfrescoMng,
        tbar:getPanelTitulo(tituloAlfrescoMng,descAlfrescoMng),
        items:[mainPanel],
        //width:400,
        //minWidth:400,
        constrain:true,
        modal:true
        //bbar:[btnGuardarCgg_res_adjunto,'->',btnCerrarCgg_res_adjunto]
    });


    /**
     * Funcion miembro que devuelve la ventana winFrmSubirAdjunto.
     * @returns ventana winFrmSubirAdjunto.
     * @base FrmSubirAdjunto.prototype.show
     */
    this.getWindow = function(){
        return winFrmSubirAdjunto;
    }

    function subirArchivo(_this, e){
        alert(_this.fileName);
    }

    function fileSelected(_this, e){
        var pnl = _this;
        if(lastSelected!=undefined)
            lastSelected.class= 'x-panel';
        lastSelected = pnl;
        lastSelected.class= 'x-panel selected-file-record';
        var oldPdfViewer = document.getElementById('pdf_viewer');
        if(oldPdfViewer){
            var viewer = document.getElementById("pdf_viewer");
            viewer.parentNode.removeChild(viewer);
        }

        var options = {
            id:'pdf_viewer',
            fallbackLink: '<p>Su navegador no soporta visualización de PDFs en línea. Descargue el archivo para visualizarlo: <a href="[url]">Descargar PDF</a></p>'
        };

        //Mostrar cargador
        activityIndicator = new Ext.LoadMask(Ext.getBody(), {msg:"Cargando Archivo..."});
        activityIndicator.show();
        PDFObject.embed("file:///Users/acanaveral/Downloads/ficha-carnivalR.pdf", '#'+Ext.getCmp('alfresco_center_pdf_viewer').getEl().dom.lastChild.lastChild.id, options);
        var pdfViewer = document.getElementById('pdf_viewer');
        pdfViewer.onload = function(state) {
            console.log('file loaded');
            if(activityIndicator)
                activityIndicator.hide();
            activityIndicator = null;
        }
    }

    activityIndicator.hide();
    activityIndicator = null;
};

/**
 * Funcion prototipo. Permite mostrar la ventana AlfrescoMng desde una instancia.
 */
AlfrescoMng.prototype.show = function(){
    if(this.getWindow())
        this.getWindow().show();
};
/**
 *Funcion prototipo. Permite cerrar la ventana AlfrescoMng desde una instancia.
 */
AlfrescoMng.prototype.close = function(){
    this.getWindow().close();
};
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana AlfrescoMng,
 * con el fin de realizar otras acciones desde una instancia.
 */
AlfrescoMng.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
};
/**
 * Funcion prototipo. Permite cargar los controles de la ventana AlfrescoMng desde una instancia.
 */
AlfrescoMng.prototype.loadData = function(){
    this.loadData();
};


function LoadJs(url){
    var js = document.createElement('script');

    js.type = "text/javascript";
    js.src = url;

    document.body.appendChild(js);

}