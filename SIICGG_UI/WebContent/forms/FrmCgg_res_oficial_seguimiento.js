/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_oficial_seguimiento.
 * @param {String} INSENTENCIA_CGG_RES_OFICIAL_SEGUIMIENTO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_OFICIAL_SEGUIMIENTO Registro de datos de la tabla Cgg_res_oficial_seguimiento.
 * @constructor
 * @base FrmListadoCgg_res_oficial_seguimiento
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_oficial_seguimiento(INSENTENCIA_CGG_RES_OFICIAL_SEGUIMIENTO,INRECORD_CGG_RES_OFICIAL_SEGUIMIENTO){
    var inSentenciaCgg_res_oficial_seguimiento = INSENTENCIA_CGG_RES_OFICIAL_SEGUIMIENTO;
    var inRecordCgg_res_oficial_seguimiento=INRECORD_CGG_RES_OFICIAL_SEGUIMIENTO;
    var urlCgg_res_oficial_seguimiento=URL_WS+"Cgg_res_oficial_seguimiento";
    var tituloCgg_res_oficial_seguimiento='Oficial seguimiento';
    var descCgg_res_oficial_seguimiento='El formulario permite administrar informaci\u00f3n de los oficiales seguimiento.';
    var isEdit = false;
    var tmpUsuario;
	
	/**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_usuario por un campo especifico.
     */
    var gsCgg_usuario = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_usuario",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CUSU_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CUSU_CODIGO'},
            {name:'CRCRG_CODIGO'},
            {name:'CRCRG_NOMBRE'},
            {name:'CRPER_CODIGO'},
            {name:'CRPER_NOMBRES'},
            {name:'CRPER_APELLIDO_PATERNO'},
            {name:'CRPER_APELLIDO_MATERNO'},
            {name:'CRPER_NUM_DOC_IDENTIFIC'},
            {name:'CRPJR_CODIGO'},
            {name:'CRPJR_RAZON_SOCIAL'},
            {name:'CTAGV_NOMBRE'},
            {name:'CCTN_CODIGO'},
            {name:'CCTN_NOMBRE'},
            {name:'NOMBRES'},
            {name:'APELLIDOS'},
            {name:'EMPRESA'},
            {name:'CUSU_NOMBRE_USUARIO'},
            {name:'CUSU_CLAVE_ACCESO'},
            {name:'CUSU_USUARIO_INTERNO'},
            {name:'CUSU_CADUCA_CLAVE'},
            {name:'CUSU_ACTIVO'},
            {name:'CUSU_CAMBIAR_CLAVE'},
            {name:'VIGENCIA'},
            {name:'TRANSCURRIDO'},
            {name:'CISLA_CODIGO'},
			{name:'CISLA_NOMBRE'}
        ]),
        sortInfo:{
            field: 'CUSU_NOMBRE_USUARIO',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON",
			inCusu_usuario_interno:'1',
			inCrper_codigo:''
        }
    });
	
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCrosg_codigo = new Ext.form.TextField({
        id:'txtCrosg_codigo',
        name:'txtCrosg_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCusu_codigo = new Ext.form.TextField({
        id:'txtCusu_codigo',
        name:'txtCusu_codigo',
        fieldLabel :'Usuario',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true'
    });
    /**
     * Ext.form.Checkbox TIPO DE OFICIAL DE SEGUIMIENTO
     */
    var chkcCrosg_tipo_oficial = new Ext.form.Checkbox({
        id:'chkcCrosg_tipo_oficial',
        fieldLabel :'Jefe seguim.',
        tooltip:'Si cumple funciones de jefatura de seguimiento',
        allowBlank :false,
        checked:false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO
     */
    var btnCusu_codigoCgg_res_oficial_seguimiento = new Ext.Button({
        id:'btnCusu_codigoCgg_res_oficial_seguimiento',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_usuario = new FrmListadoCgg_usuario();
                var objBusqueda = new DlgBusqueda(gsCgg_usuario,tmpFLCgg_usuario.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpUsuario = tmpRecord.get('CUSU_CODIGO');
                        txtCusu_codigo.setValue(tmpRecord.get('NOMBRES')+' '+tmpRecord.get('APELLIDOS'));
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_oficial_seguimiento
     */
    var btnGuardarCgg_res_oficial_seguimiento = new Ext.Button({
        id:'btnGuardarCgg_res_oficial_seguimiento',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_res_oficial_seguimiento.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_res_oficial_seguimiento(r){
                        winFrmCgg_res_oficial_seguimiento.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_res_oficial_seguimiento,
                                msg: 'La informaci\u00f3n del oficial seguimiento ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_res_oficial_seguimiento.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_res_oficial_seguimiento,
                                msg: 'La informaci\u00f3n del oficial seguimiento no ha podido ser almacenada. '+r,
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_res_oficial_seguimiento.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCrosg_codigo',txtCrosg_codigo.getValue());
                    param.add('inCusu_codigo',tmpUsuario);
                    param.add('inCrosg_tipo_oficial',chkcCrosg_tipo_oficial.getValue()==true || chkcCrosg_tipo_oficial.getValue() == TypeOficialSeguimiento.Jefe ?TypeOficialSeguimiento.Jefe:TypeOficialSeguimiento.Oficial)
                    SOAPClient.invoke(urlCgg_res_oficial_seguimiento,INSENTENCIA_CGG_RES_OFICIAL_SEGUIMIENTO,param, true, CallBackCgg_res_oficial_seguimiento);
                }catch(inErr){
                    winFrmCgg_res_oficial_seguimiento.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_oficial_seguimiento.
     */
    var btnCancelarCgg_res_oficial_seguimiento = new Ext.Button({
        id:'btnCancelarCgg_res_oficial_seguimiento',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_res_oficial_seguimiento.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_oficial_seguimiento.
     */
    var btnCerrarCgg_res_oficial_seguimiento = new Ext.Button({
        id:'btnCerrarCgg_res_oficial_seguimiento',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_res_oficial_seguimiento.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_oficial_seguimiento.
     */
    var pnlCgg_res_oficial_seguimiento = new Ext.form.FormPanel({
        frame:true,
        labelWidth:100,
        items:[txtCrosg_codigo,{xtype:'panel',layout:'column',items:[{columnWidth:.9,layout:'form',items:[txtCusu_codigo]},{columnWidth:.1,layout:'form',items:[btnCusu_codigoCgg_res_oficial_seguimiento]}]},
        chkcCrosg_tipo_oficial]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_oficial_seguimiento.
     */
    var winFrmCgg_res_oficial_seguimiento = new Ext.Window({
        id:'winFrmCgg_res_oficial_seguimiento',
        title:tituloCgg_res_oficial_seguimiento,
        tbar:getPanelTitulo(tituloCgg_res_oficial_seguimiento,descCgg_res_oficial_seguimiento),
        items:[pnlCgg_res_oficial_seguimiento],
        width:400,
        minWidth:400,
        maximizable:false,
        minimizable:false,
        resizable:false,
        constrain:true,
		modal:true,
        bbar:[btnGuardarCgg_res_oficial_seguimiento,btnCancelarCgg_res_oficial_seguimiento,'->',btnCerrarCgg_res_oficial_seguimiento]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_oficial_seguimiento.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_res_oficial_seguimientoCtrls(inEstado){
        estado=!inEstado;
        txtCrosg_codigo.setDisabled(estado);
        txtCusu_codigo.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_oficial_seguimiento.
     */
    function cargarCgg_res_oficial_seguimientoCtrls(){
        if(inRecordCgg_res_oficial_seguimiento){
            tmpUsuario = inRecordCgg_res_oficial_seguimiento.get('CUSU_CODIGO');
            txtCrosg_codigo.setValue(inRecordCgg_res_oficial_seguimiento.get('CROSG_CODIGO'));
            txtCusu_codigo.setValue(inRecordCgg_res_oficial_seguimiento.get('NOMBRES')+' '+inRecordCgg_res_oficial_seguimiento.get('APELLIDOS'));
            chkcCrosg_tipo_oficial.setValue(inRecordCgg_res_oficial_seguimiento.get('CROSG_TIPO_OFICIAL'));
            isEdit = true;
            habilitarCgg_res_oficial_seguimientoCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_oficial_seguimiento.
     * @returns ventana winFrmCgg_res_oficial_seguimiento.
     * @base FrmCgg_res_oficial_seguimiento.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_oficial_seguimiento;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_oficial_seguimiento.
     * @base FrmCgg_res_oficial_seguimiento.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_oficial_seguimientoCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_oficial_seguimiento desde una instancia.
 */
FrmCgg_res_oficial_seguimiento.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_oficial_seguimiento desde una instancia.
 */
FrmCgg_res_oficial_seguimiento.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_oficial_seguimiento,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_oficial_seguimiento.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_oficial_seguimiento desde una instancia.
 */
FrmCgg_res_oficial_seguimiento.prototype.loadData = function(){
    this.loadData();
}
