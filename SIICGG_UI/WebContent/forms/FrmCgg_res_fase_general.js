/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_fase.
 * @param {String} INSENTENCIA_CGG_RES_FASE Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_FASE Registro de datos de la tabla Cgg_res_fase.
 * @constructor
 * @base FrmListadoCgg_res_fase_general
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_fase_general(inDesktop){
    // var inSentenciaCgg_res_fase_general = INSENTENCIA_CGG_RES_FASE_GENERAL;
    // var inRecordCgg_res_fase_general=INRECORD_CGG_RES_FASE_GENERAL;
    var urlCgg_res_fase_general=URL_WS+"Cgg_res_fase";
    var tituloCgg_res_fase_general='Definici\u00f3n de proceso';
    var descCgg_res_fase_general='El formulario permite administrar informaci\u00f3n de los procesos y fases que formaran parte del seguimiento de tramites';
    var isEdit = false;
    //
    var coleccionSeguimientos = [];
    var desplazamientoX=250;
    var desplazamientoY = 100;
    var indexColeccionFigurasX =0;
    var indexColeccionFigurasY =0;
    var workflow = null;
    var coleccionFiguras = [];
    // var NIVEL_Y=0;
    var hu=false;
    var recorreY = false;
    var recordProceso = null;

    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_fase.
     */
    var btnAgregarProceso = new Ext.Button({
        id:'btnAgregarProceso',
        text:'Agregar proceso',
        iconCls:'iconAgregarProceso',
        listeners:{
            click:function(){
                var tmpFLCgg_res_proceso = new FrmListadoCgg_res_proceso();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_proceso.getStore(),tmpFLCgg_res_proceso.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                    {
                        recordProceso = tmpRecord
                        viewdiagram();
                    }
                    else
                    {
                        recordProceso = null;
                    }
                });
                objBusqueda.show();
            }
        }
    });

/**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_fase.
     */
var btnRecargarCgg_res_fase_general = new Ext.Button({
    id:'btnRecargarCgg_res_fase_general',
    text:'Recargar',
    iconCls:'iconRecargar',
    listeners:{
        click:function(){
            viewdiagram();
        }
    }
});


/**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_fase_general.
     */
var btnCancelarCgg_res_fase_general = new Ext.Button({
    id:'btnCancelarCgg_res_fase_general',
    text:'Cancelar',
    iconCls:'iconCancelar',
    listeners:{
        click:function(){
            pnlCgg_res_fase_general.getForm().reset();
        }
    }
});
/**
     * Boton que permite cerrar la ventana winFrmCgg_res_fase_general.
     */
var btnCerrarCgg_res_fase_general = new Ext.Button({
    id:'btnCerrarCgg_res_fase_general',
    text:'Cerrar',
    iconCls:'iconCerrar',
    listeners:{
        click:function(){
            winFrmCgg_res_fase_general.close();
        }
    }
});
/**
     * Ext.Button Boton para obtener reportes, general o individual.
     */
    var btnOpcionesCgg_res_proceso = new Ext.Button({     
    id:'btnOpcionesCgg_res_proceso',
    name:'btnOpcionesCgg_res_proceso',
    text:'Opciones proceso',
    //iconCls:'iconImprimir',
    menu:[
    {
        text:'Nuevo',
        iconCls:'iconNuevo',
        handler:function(){
            var objCgg_res_proceso = new FrmCgg_res_proceso("insert");
            objCgg_res_proceso.closeHandler(function(){
                //gsCgg_res_proceso.reload();
                });
            objCgg_res_proceso.show();
        }
    }

    ]
});
/**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_fase_general.
     */
var pnlCgg_res_fase_general = new Ext.form.FormPanel({
    id:'pnlCgg_res_fase_general',
    title:'Diagrama',
    frame:true,
    labelWidth :100,
    anchor:'100% 100%',
    autoScroll:true,
    height:450,
    html:'<div id="divDiagrama" style="position:absolute;left:0px;top:0px;width:100%"/>' +
'<div id="divMenu" style="position:absolute;left:50px;top:50px;"></div></div>'

});
/**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_fase_general.
     */
var winFrmCgg_res_fase_general;
if(inDesktop !== null && inDesktop!==undefined){
    winFrmCgg_res_fase_general = inDesktop.createWindow({
        id:'winFrmCgg_res_fase_general',
        title:tituloCgg_res_fase_general,
        tbar:getPanelTitulo(tituloCgg_res_fase_general,descCgg_res_fase_general),
        items:[pnlCgg_res_fase_general],
        layout:'anchor',
        iconCls:'iconProcesoFase',
        width:900,
        minWidth:400,
        heigth:450,
        minheigth:450,
        maximizable:true,
        minimizable:true,
        constrain:true,
        modal:false,
        bbar:[btnAgregarProceso,btnOpcionesCgg_res_proceso,btnRecargarCgg_res_fase_general,btnCancelarCgg_res_fase_general,'->',btnCerrarCgg_res_fase_general]
    });
}
else
{
    winFrmCgg_res_fase_general = new Ext.Window({
        id:'winFrmCgg_res_fase_general',
        title:tituloCgg_res_fase_general,
        tbar:getPanelTitulo(tituloCgg_res_fase_general,descCgg_res_fase_general),
        items:[pnlCgg_res_fase_general],
        layout:'anchor',
        width:900,
        minWidth:400,
        heigth:450,
        minheigth:450,
        maximizable:true,
        minimizable:true,
        //constrain:true,
        modal:false,
        bbar:[btnAgregarProceso,btnRecargarCgg_res_fase_general,btnCancelarCgg_res_fase_general,'->',btnCerrarCgg_res_fase_general],
        listeners:{
            show:function()
            {
            //alert('Empezando');

            }
        }
    });
}

function viewdiagram(){
    // if(inDMRE_CODIGO !=null){
    limpiarDatosDiagrama();
    var objFiguraProceso = null;
    if(workflow ==null){
        workflow  = new draw2d.MyWorkflow("divDiagrama");
        workflow.setGridWidth(10,10);
        workflow.setSnapToGrid(false);
    }else{
        workflow.clear();
    }
    //Ext.MessageBox.wait('Espere por favor.','Historial del movimiento del tramite');
    annotationWindow = new draw2d.Annotation();
    annotationWindow.setStyledText("<b>Nota:</b> Si desea puede arrastrar los graficos para mayor comodidad.");
    annotationWindow.setDimension(250,100);
    //annotationWindow.setDimension(350,350);
    annotationWindow.onDoubleClick=function(){};
    annotationWindow.setSelectable(false);
    workflow.addFigure(annotationWindow,700,25);

    var srpParams = new SOAPClientParameters();
    srpParams.add('inCrpro_codigo',recordProceso.get('CRPRO_CODIGO'));
    srpParams.add('format',TypeFormat.JSON);
    try{
        coleccionSeguimientos = eval(SOAPClient.invoke(urlCgg_res_fase_general,'selectFaseProcesoContent',srpParams, false,null));
    //alert(coleccionSeguimientos);
    }catch(inErr){
        coleccionSeguimientos ="[]";
    }
    if(recordProceso)
    {
        objFiguraProceso = new draw2d.Start(recordProceso);
        workflow.addFigure(objFiguraProceso,75,75);
        objFiguraProceso.updateLabel();
    }
    if(coleccionSeguimientos.length >= 1){

        recorrerColeccionFases(coleccionSeguimientos[0]['CGG_CRFAS_CODIGO'],objFiguraProceso);
    }
//hasta aqui

};

function recorrerColeccionFases(inCRFAS_CODIGO_ANTERIOR,parentFigure){
    recorreY = false;
    for (var i=0; i<coleccionSeguimientos.length; i++){
        if(coleccionSeguimientos[i]['CGG_CRFAS_CODIGO'] == inCRFAS_CODIGO_ANTERIOR){
            desplazamientoX=desplazamientoX+150;
            if(hu == true){
                desplazamientoY+=150;
                hu=false;
            }
            var childFigure = new draw2d.End(coleccionSeguimientos[i],recordProceso);
            workflow.addFigure(childFigure,desplazamientoX,desplazamientoY);
            childFigure.updateLabel();
            var objConectorAnidado = new draw2d.ContextmenuConnection();
            objConectorAnidado.setRouter(new draw2d.ManhattanConnectionRouter());
            objConectorAnidado.setSource(parentFigure.outputPort);
            objConectorAnidado.setTarget(childFigure.inputPort);
            objConectorAnidado.setTargetDecorator(new draw2d.ArrowConnectionDecorator());
            workflow.addFigure(objConectorAnidado);
            recorrerColeccionFases(coleccionSeguimientos[i]['CRFAS_CODIGO'],childFigure);
            desplazamientoX=desplazamientoX-150;
            hu=true;
            recorreY = true;
        }
    }
}

function limpiarDatosDiagrama(){
    coleccionFiguras = [];
    coleccionSeguimientos = [];
    desplazamientoX=250;
    desplazamientoY = 100;
    indexColeccionFigurasX =0;
    indexColeccionFigurasY =0;
    hu = false;
    recorreY = false;
}

/**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_fase_general.
     * @returns ventana winFrmCgg_res_fase_general.
     * @base FrmCgg_res_fase_general.prototype.show
     */
this.getWindow = function(){
    return winFrmCgg_res_fase_general;
}
/**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_fase_general.
     * @base FrmCgg_res_fase_general.prototype.loadData
     */
this.loadData = function(){
    cargarCgg_res_fase_generalCtrls();
}
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_fase_general desde una instancia.
 */
FrmCgg_res_fase_general.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_fase_general desde una instancia.
 */
FrmCgg_res_fase_general.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_fase_general,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_fase_general.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_fase_general desde una instancia.
 */
FrmCgg_res_fase_general.prototype.loadData = function(){
    this.loadData();
}
