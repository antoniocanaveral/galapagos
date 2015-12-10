/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_jur_criterio.
 * @param {String} INSENTENCIA_CGG_JUR_CRITERIO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_JUR_CRITERIO Registro de datos de la tabla Cgg_jur_criterio.
 * @constructor
 * @base FrmListadoCgg_jur_criterio
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_jur_criterio(INSENTENCIA_CGG_JUR_CRITERIO,INRECORD_CGG_JUR_CRITERIO){
    var inSentenciaCgg_jur_criterio = INSENTENCIA_CGG_JUR_CRITERIO;
    var inRecordCgg_jur_criterio=INRECORD_CGG_JUR_CRITERIO;
    var urlCgg_jur_criterio=URL_WS+"Cgg_jur_criterio";
    var tituloCgg_jur_criterio='Ingreso de criterios';
    var descCgg_jur_criterio='Formulario para administrar informaci\u00f3n de criterios';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCjcri_codigo = new Ext.form.TextField({
        id:'txtCjcri_codigo',
        name:'txtCjcri_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE FASES
     */
    var txtCrfas_codigo = new Ext.form.TextField({
        id:'txtCrfas_codigo',
        name:'txtCrfas_codigo',
        fieldLabel :'Codigo fase',
        anchor:'98%',
        allowBlank :false,
        hidden:true,
        maxLength :20
    });
    var txtCrfas_nombre = new Ext.form.TextField({
        id:'txtCrfas_nombre',
        name:'txtCrfas_nombre',
        fieldLabel :'Nombre fase',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE FASES
     */
    var btnCrfas_codigoCgg_jur_criterio = new Ext.Button({
        id:'btnCrfas_codigoCgg_jur_criterio',
        text:'Fase',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_res_fase = new FrmListadoCgg_res_fase();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_fase.getStore(),tmpFLCgg_res_fase.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                        txtCrfas_codigo.setValue(tmpRecord.get('CRFAS_CODIGO'));
                    txtCrfas_nombre.setValue(tmpRecord.get('CRFAS_NOMBRE'));
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField INFORMACION A SER VERIFICADA
     */
    var txtCjcri_requerimiento = new Ext.form.TextField({
        id:'txtCjcri_requerimiento',
        name:'txtCjcri_requerimiento',
        fieldLabel :'Requerimiento',
        anchor:'98%',
        allowBlank :false,
        maxLength :20
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_jur_criterio
     */
    var btnGuardarCgg_jur_criterio = new Ext.Button({
        id:'btnGuardarCgg_jur_criterio',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:'Almacena la informaci\u00f3n de criterio',
        listeners:{
            click:function(){
                if (pnlCgg_jur_criterio.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_jur_criterio(r){
                        winFrmCgg_jur_criterio.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_jur_criterio,
                                msg: 'La informaci\u00f3n de criterio ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_jur_criterio.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_jur_criterio,
                                msg: 'La informaci\u00f3n de criterio no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_jur_criterio.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCjcri_codigo',txtCjcri_codigo.getValue());
                    param.add('inCrfas_codigo',txtCrfas_codigo.getValue());
                    param.add('inCjcri_requerimiento',grdCgg_jur_criterio.getValue());
                    SOAPClient.invoke(urlCgg_jur_criterio,INSENTENCIA_CGG_JUR_CRITERIO,param, true, CallBackCgg_jur_criterio);
                }catch(inErr){
                    winFrmCgg_jur_criterio.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_jur_criterio.
     */
    var btnCancelarCgg_jur_criterio = new Ext.Button({
        id:'btnCancelarCgg_jur_criterio',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:'Cancela la informaci\u00f3n almacenar',
        listeners:{
            click:function(){
                pnlCgg_jur_criterio.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_jur_criterio.
     */
    var btnCerrarCgg_jur_criterio = new Ext.Button({
        id:'btnCerrarCgg_jur_criterio',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:'Salir',
        listeners:{
            click:function(){
                winFrmCgg_jur_criterio.close();
            }}
    });
    //Deifine las columnas de la tabla cgg_pra_contacto.
    var cmCgg_jur_criterio = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
        {dataIndex:'CJCRI_CODIGO',hidden:true,header:'Codigo',width:150,sortable:true,editor:new Ext.form.TextField({})},
        {dataIndex:'CRFAS_CODIGO',hidden:true,header:'Codigo',width:150,sortable:true,editor:new Ext.form.TextField({})},
        {dataIndex:'CJCRI_REQUERIMIENTO',header:'Requerimiento',width:400,sortable:true,editor:new Ext.form.TextField({})}]);

    //Agrupacion de registros de la tabla Cgg_pra_contacto por un campo especifico.*/
    var gsCgg_jur_criterio = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_jur_criterio",
            method:"selectPage",
            pagin: true
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
            id:'CJCRI_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CJCRI_CODIGO'},
            {name:'CRFAS_CODIGO'},
            {name:'CJCRI_REQUERIMIENTO'}
        ]),
        sortInfo:{field: 'CRFAS_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });

    //* Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_pra_curso.

    var pgBarCgg_jur_criterio= new Ext.PagingToolbar({
        store: gsCgg_jur_criterio,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    //Reprentacion de datos de la tabla Cgg_pra_contacto en un formato tabular de filas y columnas.*/

    var grdCgg_jur_criterio = new Ext.grid.EditorGridPanel({
        cm:cmCgg_jur_criterio,
        store:gsCgg_jur_criterio,
        region:'center',
        bodyStyle:'padding:5px 5px 5',
        autoHeight:true,
        layout: 'anchor',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_jur_criterio,
                width:200



            })
        ],
        tbar: [{
            text: 'Nuevo',
            iconCls:'iconNuevo',
            handler : function(){
                var Llenar = grdCgg_jur_criterio.getStore().recordType;
                var p = new Llenar({
                    CJCRI_CODIGO: 'Codigo',
                    CRFAS_CODIGO: 'Codigo',
                    CJCRI_REQUERIMIENTO: 'Requerimiento'
                });
                grdCgg_jur_criterio.stopEditing()
                gsCgg_jur_criterio.insert(0, p);
                grdCgg_jur_criterio.getView().refresh();
            }


        },{text: 'Eliminar',
            iconCls:'iconEliminar',
            handler : function(){
                var rec = grdCgg_jur_criterio.getSelectionModel().getSelected();
                if (!rec) {
                    return false;
                }
                gsCgg_jur_criterio.remove(rec);
            }}],
        bbar:pgBarCgg_jur_criterio,
        viewConfig: {
            forceFit: true
        },
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_jur_criterio.hidden){
                    btnEditarCgg_jur_criterio.fireEvent('click', btnEditarCgg_jur_criterio);
                }
            }}});
    gsCgg_jur_criterio.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });


    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_jur_criterio.
     */
    var pnlCriterio = new Ext.form.FormPanel({
        frame:true,
        labelWidth : 100,
        layout: 'form',
        bodyStyle:'padding:5px 5px 5',
        items:[txtCjcri_codigo,{xtype:'panel',layout:'column',items:[{columnWidth:.8,layout:'form',items:[txtCrfas_nombre]},{columnWidth:.2,layout:'form',items:[btnCrfas_codigoCgg_jur_criterio]}]}]
    });
    var pnlCgg_jur_criterio = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[grdCgg_jur_criterio]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_jur_criterio.
     */
    var winFrmCgg_jur_criterio = new Ext.Window({
        id:'winFrmCgg_jur_criterio',
        title:tituloCgg_jur_criterio,
        tbar:getPanelTitulo(tituloCgg_jur_criterio,descCgg_jur_criterio),
        items:[pnlCriterio, pnlCgg_jur_criterio],
        width:400,
        minWidth:400,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        modal: true,
        resizable: false,
        constrain:true,
        bbar:[btnGuardarCgg_jur_criterio,btnCancelarCgg_jur_criterio,'->',btnCerrarCgg_jur_criterio]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_jur_criterio.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_jur_criterioCtrls(inEstado){
        estado=!inEstado;
        txtCjcri_codigo.setDisabled(estado);
        txtCrfas_codigo.setDisabled(estado);
        grdCgg_jur_criterio.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_jur_criterio.
     */
    function cargarCgg_jur_criterioCtrls(){
        if(inRecordCgg_jur_criterio){
            txtCjcri_codigo.setValue(inRecordCgg_jur_criterio.get('CJCRI_CODIGO'));
            txtCrfas_codigo.setValue(inRecordCgg_jur_criterio.get('CRFAS_CODIGO'));
            grdCgg_jur_criterio.setValue(inRecordCgg_jur_criterio.get('CJCRI_REQUERIMIENTO'));
            isEdit = true;
            habilitarCgg_jur_criterioCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_jur_criterio.
     * @returns ventana winFrmCgg_jur_criterio.
     * @base FrmCgg_jur_criterio.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_jur_criterio;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_jur_criterio.
     * @base FrmCgg_jur_criterio.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_jur_criterioCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_jur_criterio desde una instancia.
 */
FrmCgg_jur_criterio.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_jur_criterio desde una instancia.
 */
FrmCgg_jur_criterio.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_jur_criterio,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_jur_criterio.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_jur_criterio desde una instancia.
 */
FrmCgg_jur_criterio.prototype.loadData = function(){
    this.loadData();
}
