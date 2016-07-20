/**
 * Created by acanaveral on 20/5/16.
 */

var activityIndicator = null;

var tableName;
var recordID;
var filter;
var alfrescoResponse = null;
var readOnly = false;
//Panel de Propiedades
var east;
var isList;

function AlfrescoMng(_tableName, _recordID, _filter, isReadOnly){

    tableName = _tableName;
    recordID = _recordID;
    filter = _filter;
    readOnly = (isReadOnly!=null && isReadOnly==true)?true:false;

    var comps=[]; //variable donde pondremos los componentes
    var store;

    var west; // Panel izquierdo

    var lastSelected; //Ultimo archivo seleccionado

    //Agregamos la libreria de visualizacion de PDFs
    LoadJs("lib/pipwerks/pdfobject.min.js");
    LoadJs("lib/extjs/AlfrescoUploader.js");


    freeUpload = function(_this, e){
        if(readOnly){
            Ext.Msg.alert('Alfresco', 'No se permite actualizar ni cargar archivos');
            return;
        }
        var btnUpload = _this;
        var uploader = null;
        if(isList && btnUpload.fileObj){
            uploader = new AlfrescoUploader(_this.fileObj,tableName,recordID);
            uploader.on('hide',function(_that){
                var result = uploader.result();
                console.log("HIDE: "+result);
                if(btnUpload.fileContainer){
                    btnUpload.setIconClass('ecmRefresh');
                    btnUpload.fileContainer.fileObj.fileResult = result;
                }
                uploader.destroy();
            });
            uploader.on('close',function(p){
                console.log("CLOSE!!");
            });
            uploader.show();
        }else{//Es subida Libre
            var indexes = [];
            indexes.push(
                {
                    "code": "IDX_IDN",
                    "name": "Identificable",
                    "itemList": [
                        {
                            "code": "ITEM_TABLA",
                            "itemName": "TABLE_NAME_NAME",
                            "itemDataType": "STRING",
                            "itemLabel": "Nombre de la Tabla SII",
                            "isMandatory": true,
                            "estado": true
                        },
                        {
                            "code": "ITEM_RECORD_ID",
                            "itemName": "RECORD_ID_NAME",
                            "itemDataType": "STRING",
                            "itemLabel": "Identificador del Registro",
                            "isMandatory": true,
                            "estado": true
                        }
                    ],
                    "estado": true
                }
            );
            var jsonFile = {"code":"FREE", "documentType": "D:sii:personales", "fileRepository":alfrescoResponse.filesRepository ,"indexDefinitionList":indexes};
            uploader = new AlfrescoUploader(jsonFile,tableName,recordID);
            uploader.on('hide',function(_that){
                var result = uploader.result();
                console.log("HIDE: "+result);
                if(btnUpload.fileContainer){
                    btnUpload.setIconClass('ecmRefresh');
                    btnUpload.fileContainer.fileObj.fileResult = result;
                }
                uploader.destroy();
                refreshPannels();
            });
            uploader.on('close',function(p){
                console.log("CLOSE!!");
            });
            uploader.show();
        }
        //alert(_this.fileName);
    };

    fileSelected = function(_this, e) {
        var pnl = _this;
        if (!isList || (pnl.fileObj && pnl.fileObj.fileResult)) {
            //traemos las propiedades
            activityIndicator = new Ext.LoadMask(Ext.getBody(), {msg: "Cargando Propiedades..."});
            activityIndicator.show();
            var param = new SOAPClientParameters();
            param.add('fileId', (isList?pnl.fileObj.fileResult.id:pnl.fileObj.id));
            param.add('versionInfo', false);
            var fileProperties = SOAPClient.invoke(URL_WS + 'Alf_query', "getFullFileInfo", param, false, null);
            if (fileProperties) {
                fileProperties = eval("(" + fileProperties + ')'); //Convierte string a Objeto JSON
                buildFileProperties(fileProperties);
            }
            activityIndicator.hide();
            activityIndicator = null;

            if (lastSelected != null)
                lastSelected.class = 'x-panel';
            lastSelected = pnl;
            lastSelected.class = 'x-panel selected-file-record';
            var oldPdfViewer = document.getElementById('pdf_viewer');
            if (oldPdfViewer) {
                var viewer = document.getElementById("pdf_viewer");
                viewer.parentNode.removeChild(viewer);
            }

            var options = {
                id: 'pdf_viewer',
                fallbackLink: '<p>Su navegador no soporta visualizaci&oacute;n de PDFs en l&iacute;nea. Descargue el archivo para visualizarlo: <a href="[url]">Descargar PDF</a></p>'
            };

            //Mostrar cargador
            activityIndicator = new Ext.LoadMask(Ext.getBody(), {msg: "Cargando Archivo..."});
            activityIndicator.show();
            //Timer para que no se quede eternamente pensando
            setTimeout(function(){
                if(activityIndicator){
                    Ext.MsgPopup.msg(tituloAlfrescoMng, "Tiempo de espera agotado. Puede que no exista el documento.",MsgPopup.INFO);
                    activityIndicator.hide();
                    activityIndicator=null;
                }
            }, ALF_VIEWER_TIMER?ALF_VIEWER_TIMER:5000);
            PDFObject.embed(URL_WS+"AlfrescoDownloaderSVR?documentID="+(isList?pnl.fileObj.fileResult.id:pnl.fileObj.id), '#'+Ext.getCmp('alfresco_center_pdf_viewer').getEl().dom.lastChild.lastChild.id, options);
            //PDFObject.embed("https://localhost:8443/siiws/AlfrescoDownloaderSVR?documentID=" + (isList?pnl.fileObj.fileResult.id:pnl.fileObj.id), '#' + Ext.getCmp('alfresco_center_pdf_viewer').getEl().dom.lastChild.lastChild.id, options);
            var pdfViewer = document.getElementById('pdf_viewer');
            pdfViewer.onload = function (state) {
                console.log('file loaded');
                if (activityIndicator)
                    activityIndicator.hide();
                activityIndicator = null;
            }
        }
    };

    loadStoreFromServer = function() {
        activityIndicator = new Ext.LoadMask(Ext.getBody(), {msg:"Cargando..."});
        activityIndicator.show();
        //Hacemos la llamada al WS para obtener la estructura de la ventana.
        var param = new SOAPClientParameters();
        param.add('tableName', tableName);
        param.add('recordID', recordID);
        param.add('filter', filter);
        isList = false;
        //alfrescoResponse = {"code":"TEST1","tableName":"TABLA_PRUEBA","isList":true,"fileList":[{"code":"FILE_TEST2","fileName":"papeleta","fileDescription":"Documento de Votación","documentType":"D:sii:personales","fileRepository":"test/listas/carpeta_usuario","overrideName":true,"indexDefinitionList":[{"code":"IDX_ALM","name":"Almacenable","description":"Permite relacionar el adjunto con el archivo físico","itemList":[{"code":"ITEM_CAJA","itemName":"CAJA_NAME","itemDataType":"STRING","itemLabel":"Número de Caja","isMandatory":true,"estado":true,"usuario_insert":"ADMIN","usuario_update":"ADMIN"},{"code":"ITEM_CARPETA","itemName":"CARPETA_NAME","itemDataType":"STRING","itemLabel":"Número de Carpeta","isMandatory":true,"estado":true,"usuario_insert":"ADMIN","usuario_update":"ADMIN"},{"code":"ITEM_DESCRIPCION","itemName":"DESCRIPCION_NAME","itemDataType":"TEXT","itemLabel":"Descripción del Almacenamiento","isMandatory":false,"estado":true,"usuario_insert":"ADMIN","usuario_update":"ADMIN"}],"estado":true,"usuario_insert":"ADMIN","usuario_update":"ADMIN"}],"estado":true,"usuario_insert":"ADMIN","usuario_update":"ADMIN"},{"code":"FILE_TEST1","fileName":"cedula","fileDescription":"Documento de Identidad","documentType":"D:sii:respaldo","fileRepository":"test/listas/carpeta_usuario","overrideName":true,"indexDefinitionList":[{"code":"IDX_ALM","name":"Almacenable","description":"Permite relacionar el adjunto con el archivo físico","itemList":[{"code":"ITEM_CAJA","itemName":"CAJA_NAME","itemDataType":"STRING","itemLabel":"Número de Caja","isMandatory":true,"estado":true,"usuario_insert":"ADMIN","usuario_update":"ADMIN"},{"code":"ITEM_CARPETA","itemName":"CARPETA_NAME","itemDataType":"STRING","itemLabel":"Número de Carpeta","isMandatory":true,"estado":true,"usuario_insert":"ADMIN","usuario_update":"ADMIN"},{"code":"ITEM_DESCRIPCION","itemName":"DESCRIPCION_NAME","itemDataType":"TEXT","itemLabel":"Descripción del Almacenamiento","isMandatory":false,"estado":true,"usuario_insert":"ADMIN","usuario_update":"ADMIN"}],"estado":true,"usuario_insert":"ADMIN","usuario_update":"ADMIN"},{"code":"IDX_IDN","name":"Identificable","description":"Relaciona el adjunto en Alfresco, con la base de datos de SII","itemList":[{"code":"ITEM_TABLA","itemName":"TABLE_NAME_NAME","itemDataType":"STRING","itemLabel":"Nombre de la Tabla SII","isMandatory":true,"estado":true,"usuario_insert":"ADMIN","usuario_update":"ADMIN"},{"code":"ITEM_RECORD_ID","itemName":"RECORD_ID_NAME","itemDataType":"STRING","itemLabel":"Identificador del Registro","isMandatory":true,"estado":true,"usuario_insert":"ADMIN","usuario_update":"ADMIN"}],"estado":true,"usuario_insert":"ADMIN","usuario_update":"ADMIN"},{"code":"IDX_CAD","name":"Caducable","description":"Añade una fecha de caducidad del adjunto","itemList":[{"code":"ITEM_FECHA","itemName":"CADUCIDAD_NAME","itemDataType":"DATE","itemLabel":"Fecha de Caducidad del Documento","isMandatory":true,"estado":true,"usuario_insert":"ADMIN","usuario_update":"ADMIN"}],"estado":true,"usuario_insert":"ADMIN","usuario_update":"ADMIN"}],"estado":true,"usuario_insert":"ADMIN","usuario_update":"ADMIN","fileResult":{"displayName":"Documentos Personales SII","name":"cedula.pdf","id":"64011ae2-1a0e-4747-93c2-508a908dd4c7;1.0"}}],"estado":true,"usuario_insert":"ADMIN","usuario_update":"ADMIN"};
        if(alfrescoResponse==null || alfrescoResponse.trim() == "")
            alfrescoResponse = SOAPClient.invoke(URL_WS + 'Alf_query', "getAttachmentMetadata", param, false, null);
        if (alfrescoResponse) {
            if (alfrescoResponse !== null && typeof alfrescoResponse !== 'object')
                alfrescoResponse = eval("(" + alfrescoResponse + ')'); //Convierte string a Objeto JSON

            isList = alfrescoResponse.isList;
            var filteredData = null;
            if (isList) {
                filteredData = {"files": alfrescoResponse.fileList};
                store = new Ext.data.Store({
                    root: "files",
                    reader: new Ext.data.JsonReader({
                        id: 'code',
                        root: 'files'
                    }, [{name: "fileDescription"}, {name: "fileName"}, {name:"fileRepository"}]),
                    fields: ["fileDescription", "fileName", "fileRepository"]
                });
                store.loadData(filteredData);
            }else{
                if(alfrescoResponse.folderResult){//Hay documentos previamente subidos.
                    //cargamos el store.
                    console.log("Hay archivos en el servidor");
                    filteredData = {"files": alfrescoResponse.folderResult};
                    store = new Ext.data.Store({
                        root: "files",
                        reader: new Ext.data.JsonReader({
                            id: 'id',
                            root: 'files'
                        }, [{name: "name"}, {name: "displayName"}, {name:"id"}]),
                        fields: ["name", "displayName", "id"]
                    });
                    store.loadData(filteredData);
                }
            }

            //Barra para cuando no es lista
            var btnDownload = new Ext.Button({iconCls:'ecmDownload', height: '32px', width: '32px', listeners:{click:fileDownload}, disabled:true});
            var freePanel = null;
            if(!alfrescoResponse.isList){
                var btnUpload = new Ext.Button({iconCls:'ecmUpload', height: '32px', width: '32px',listeners:{click:freeUpload}, disabled:false});
                freePanel = new Ext.Panel({
                    layout:'hbox',
                    cls: 'ecmTransparentBtn',
                    items: [btnUpload,btnDownload]
                });
            }else
                freePanel = new Ext.Panel({
                    layout:'hbox',
                    cls: 'ecmTransparentBtn',
                    items: btnDownload
                });

            comps.push(freePanel);

            //STORE DE DATA
            if(store){
                var renderedData = store.reader.jsonData;
                var files = isList?renderedData.files:renderedData.files.files;
                lastSelected=null;
                for(var i=0;i<files.length;i++){
                    var btnAction;
                    var updateable = true;
                    var insertable = true;
                    var mandatory = false;
                    if(isList){
                        updateable = files[i].updateable;
                        insertable = files[i].insertable;
                        mandatory = files[i].mandatory;
                    }
                    var fileName = new Ext.Button({
                        xtype: 'button',
                        text:(mandatory?"* ":"")+(isList?files[i].fileDescription:files[i].name),
                        fileObj: files[i],
                        prentPanelId:"tarjet_"+i,
                        width: 120,
                        height:30
                    });
                    fileName.on('click',fileSelected);
                    if(files[i].fileResult || !isList){
                        btnAction = new Ext.Button({
                            iconCls:'ecmRefresh',
                            fileObj: files[i],
                            fileContainer:fileName,
                            fileName:isList?files[i].fileName:files[i].name,
                            margins: '0 0 5 15',
                            listeners:{click:freeUpload}
                        });
                        if(!updateable)
                            btnAction.hide();
                    }else{
                        btnAction = new Ext.Button({
                            iconCls:'ecmUpload',
                            fileObj: files[i],
                            fileContainer:fileName,
                            fileRecord:fileRecord,
                            fileName:files[i].fileName,
                            margins: '0 0 5 15',
                            listeners:{click:freeUpload}
                        });
                        if(!insertable)
                            btnAction.hide();
                    }

                    var fileRecord = new Ext.Panel({
                        id:"tarjet_"+i,
                        cls: 'ecmTransparentBtn',
                        height:50,
                        border:true,
                        layout:'hbox',
                        overCls:'selected-file-record',
                        padding:10,
                        items: [fileName,btnAction]
                    });
                    //Lo quitamos de la lista cuando no tiene adjunto y no es insertable.
                    if(isList && (files[i].fileResult==null && !insertable)){
                        var kk=0; //NO HACEMOS NADA.
                    }else
                        comps.push(fileRecord);
                }
            }
        }else {
            activityIndicator.hide();
            activityIndicator = null;
            Ext.Msg.alert('Alfresco', 'No se ha definido un esquema de archivos para la ventana');
            return false;
        }

        activityIndicator.hide();
        activityIndicator = null;
        return true;
    };

    refreshPannels = function(){
        if(west!=null){
            comps = [];
            alfrescoResponse = null;
            if(loadStoreFromServer()){//Recargamos los datos
                west.removeAll();
                west.add(comps);
                west.doLayout();
            }
        }
    };

    if(tableName!=null && recordID!=null) {
        if (loadStoreFromServer()) {
            var tituloAlfrescoMng = 'Administraci&oacute;n de Adjuntos';
            var descAlfrescoMng = 'El formulario permite administrar sus adjuntos con el repositorio de Alfresco';


            west = new Ext.Panel({
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

            east = new Ext.Panel({
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
                modal:true,
                resizable   :false,
                maximizable :false,
                minimizable :false,
                closable    : true
                //bbar:[btnGuardarCgg_res_adjunto,'->',btnCerrarCgg_res_adjunto]
            });


            /**
             * Funcion miembro que devuelve la ventana winFrmSubirAdjunto.
             * @returns ventana winFrmSubirAdjunto.
             * @base FrmSubirAdjunto.prototype.show
             */
            this.getWindow = function(){
                return winFrmSubirAdjunto;
            };

            this.getWindow().on('close',this.beforeClose);

            if(activityIndicator!=null)
                activityIndicator.hide();
            activityIndicator = null;
            //-->>FIN
        }
    }else{
        Ext.Msg.alert('Configuracion', 'No es posible iniciar el esquema de archivos. No se han definido los parámetros');
    }
}

/**
 * Funcion prototipo. Permite mostrar la ventana AlfrescoMng desde una instancia.
 */
AlfrescoMng.prototype.show = function(){
    try{
        if(this.getWindow())
            this.getWindow().show();
    }catch (e){
        console.log("No se han definido adjuntos");
    }
};

AlfrescoMng.prototype.beforeClose = function(){
    activityIndicator = null;
    tableName = null;
    recordID = null;
    filter = null;
    alfrescoResponse = null;
};
/**
 *Funcion prototipo. Permite cerrar la ventana AlfrescoMng desde una instancia.
 */
AlfrescoMng.prototype.close = function(){
    this.beforeClose();
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

function fileDownload(_this, e){
    alert(_this.fileName);
    console.log("fileDownload");
}

function buildFileProperties(properties){
    if(east){
        east.removeAll();
        //Construimos las propiedades generales:
        if(properties){
            var propData = [];
            propData.push(["Nombre de Despliegue",  properties.displayName, "General"]);
            propData.push(["Nombre",                properties.name, "General"]);
            propData.push(["Identificador",      properties.id, "General"]);
            propData.push(["Versi&oacute;n",      properties.versionLabel, "General"]);

            for(var i=0;i<properties.aspects.length;i++){
                var aspect = properties.aspects[i];
                for (var property in aspect) {
                    if (aspect.hasOwnProperty(property) && property!="prefix" && !property.toString().endsWith("NAME")) {
                        propData.push([Ext.util.Format.capitalize(property), aspect[property], "Idx. "+Ext.util.Format.capitalize(aspect.ASPECT_NAME.toString().replace("P:sii:",""))]);
                    }
                }
            }

            // shared reader
            var reader = new Ext.data.ArrayReader({}, [
                {name: 'propiedad'},
                {name: 'valor'},
                {name: 'tipo'}
            ]);

            var store = new Ext.data.GroupingStore({
                reader: reader,
                data: propData,
                groupField:'tipo'
            });

            var grid = new Ext.grid.GridPanel({
                store: store,
                columns: [
                    {
                        id       :'propiedad',
                        header   : 'Propiedad',
                        flex     : 2,
                        sortable : false,
                        dataIndex: 'propiedad'
                    },
                    {
                        header   : 'Valor',
                        flex     : 2,
                        sortable : false,
                        dataIndex: 'valor'
                    },
                    {
                        header   : 'Tipo',
                        sortable : false,
                        dataIndex: 'tipo',
                        hidden   : true
                    }
                ],
                view: new Ext.grid.GroupingView({
                    showGroupName:false,
                    groupTextTpl: '{text}'
                }),
                height: 500,
                flex:4
            });
            east.add(grid);
            east.doLayout();
        }
    }
}