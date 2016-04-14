/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_sesion_miembro.
 * @param {String} INSENTENCIA_CGG_RES_SESION_MIEMBRO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_SESION_MIEMBRO Registro de datos de la tabla Cgg_res_sesion_miembro.
 * @constructor
 * @base FrmListadoCgg_res_sesion_miembro
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_sesion_miembro(INSENTENCIA_CGG_RES_SESION_MIEMBRO,INRECORD_CGG_RES_SESION_MIEMBRO){
    var inSentenciaCgg_res_sesion_miembro = INSENTENCIA_CGG_RES_SESION_MIEMBRO;
    var inRecordCgg_res_sesion_miembro=INRECORD_CGG_RES_SESION_MIEMBRO;
    var urlCgg_res_sesion_miembro=URL_WS+"Cgg_res_sesion_miembro";
    var tituloCgg_res_sesion_miembro='Asistencia Sesi\u00f3n';
    var descCgg_res_sesion_miembro='El formulario permite administrar informaci\u00f3n de la Asistencia Sesi\u00f3n';
    var isEdit = false;
    var tmpCrssc_codigo;
    var tmpCrmbc_codigo;
    var tmpCgg_crmbc_codigo;
     var tmpinCrcom_codigo;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE SESION MIEMBRO
     */
    var txtCrsmb_codigo = new Ext.form.TextField({
        id:'txtCrsmb_codigo',
        name:'txtCrsmb_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_sesion_comite por un campo especifico.
     */
    var gsCgg_res_sesion_comite1 = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_sesion_miembro",
            method:"selectSesion",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRSSC_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRSSC_CODIGO'},
            {name:'CISLA_CODIGO'},
            {name:'ISLA'},
            {name:'CRCOM_CODIGO'},
            {name:'COMITE'},
            {name:'CRSSC_FECHA_REUNION'},
            {name:'CRSSC_FECHA_FINALIZACION'},
            {name:'CRSSC_NUMERO_SESION'},
            {name:'CRSSC_EXTRACTO'},
            {name:'CRSSC_OBSERVACION'},
            {name:'CRSSC_FECHA_CONVOCATORIA'},
            {name:'CRSSC_MOTIVO_CONVOCATORIA'},
            {name:'CRSSC_DESCRIPCION_ADJUNTO'},
            {name:'CRSSC_NOMBRE_ADJUNTO'},
            {name:'CRSSC_ESTADO_CONVOCATORIA'}
        ]),
        sortInfo:{field: 'CRSSC_NUMERO_SESION', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON", inCrcom_codigo:''}
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE SESION
     */
    var txtCrssc_codigo = new Ext.form.TextField({
        id:'txtCrssc_codigo',
        name:'txtCrssc_codigo',
        fieldLabel :'Sesi\u00f3n',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE SESION
     */
    var btnCrssc_codigoCgg_res_sesion_miembro = new Ext.Button({
        id:'btnCrssc_codigoCgg_res_sesion_miembro',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
				/**
				 * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_sesion_comite.
				 */
				var cmCgg_res_sesion_comite1 = new Ext.grid.ColumnModel([
					{dataIndex:'ISLA',header:'Isla',width:150,sortable:true},
					{dataIndex:'COMITE',header:'Comit\u00e9',width:150,sortable:true},
					{dataIndex:'CRSSC_FECHA_REUNION',header:'Fecha reuni\u00f3n',width:150,sortable:true,renderer:truncDate},
					{dataIndex:'CRSSC_FECHA_FINALIZACION',header:'Fecha finalizaci\u00f3n',width:150,sortable:true,renderer:truncDate},
					{dataIndex:'CRSSC_NUMERO_SESION',header:'Numero sesi\u00f3n',width:150,sortable:true},
					{dataIndex:'CRSSC_EXTRACTO',header:'Extracto',width:150,sortable:true},
					{dataIndex:'CRSSC_OBSERVACION',header:'Observaci\u00f3n',width:150,sortable:true,hidden:true},
					{dataIndex:'CRSSC_FECHA_CONVOCATORIA',header:'Fecha convocatoria',width:150,sortable:true,renderer:truncDate},
					{dataIndex:'CRSSC_ESTADO_CONVOCATORIA',header:'Estado convocatoria',width:150,sortable:true,renderer:function(inCrsscestadoConvocatoria){
						return dsEstadoConvocatoria[inCrsscestadoConvocatoria][1];
					}
					}]);
                var objBusqueda = new DlgBusqueda(gsCgg_res_sesion_comite1,cmCgg_res_sesion_comite1);
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpCrssc_codigo= tmpRecord.get('CRSSC_CODIGO');                        
                        txtCrssc_codigo.setValue(tmpRecord.get('CRSSC_NUMERO_SESION'));
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE MIEMBRO ASISTENTE
     */
    var txtCrmbc_codigo = new Ext.form.TextField({
        id:'txtCrmbc_codigo',
        name:'txtCrmbc_codigo',
        fieldLabel :'Titular',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE MIEMBRO ASISTENTE
     */
    var btnCrmbc_codigoCgg_res_sesion_miembro = new Ext.Button({
        id:'btnCrmbc_codigoCgg_res_sesion_miembro',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                //  var tmpFLCgg_res_miembro_comite = new FrmListadoCgg_res_miembro_comite();
                var objBusqueda = new DlgBusqueda(seleccionarMiembroStore(),seleccionarMiembroColumn());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
					if(!tmpRecord)
						return;
                    if(tmpRecord && tmpRecord.data.CRMBC_AUTORIZADO){
                        tmpCrmbc_codigo=tmpRecord.data.CRMBC_CODIGO;
                        txtCrmbc_codigo.setValue(tmpRecord.get('CRPER_NOMBRES')+" "+tmpRecord.get('APELLIDO'));
                    }else if(!tmpRecord.data.CRMBC_AUTORIZADO){
						Ext.Msg.show({
                                title:tituloCgg_res_sesion_miembro,
                                msg: 'La persona seleccionada no esta autorizada a ser parte del comite. ',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.WARNING
                            });
					}
					
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE MIEMBRO TITULAR
     */
    var txtCgg_crmbc_codigo = new Ext.form.TextField({
        id:'txtCgg_crmbc_codigo',
        name:'txtCgg_crmbc_codigo',
        fieldLabel :'Suplente',
        anchor:'98%',
        readOnly:'true'
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE MIEMBRO TITULAR
     */
    var btnCgg_crmbc_codigoCgg_res_sesion_miembro = new Ext.Button({
        id:'btnCgg_crmbc_codigoCgg_res_sesion_miembro',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                // var tmpFLCgg_res_miembro_comite = new FrmListadoCgg_res_miembro_comite();
                var objBusqueda = new DlgBusqueda(seleccionarMiembroStore(),seleccionarMiembroColumn());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpCgg_crmbc_codigo=tmpRecord.get('CRMBC_CODIGO');
                        txtCgg_crmbc_codigo .setValue(tmpRecord.get('CRPER_NOMBRES')+" "+tmpRecord.get('APELLIDO'));
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.Checkbox DETERMINAR EL PRESIDENTE DE LA SESION
     */
    var chkCrsmb_presidente = new Ext.form.Checkbox({
        id:'chkCrsmb_presidente',
        name:'chkCrsmb_presidente',
        fieldLabel :'Presidente',
        allowBlank :false
    });
    /**
     * Ext.form.Checkbox DETERMINA SI EL MIEMBRO SE ENCUENTRA PRESENTE EN LA SESION
     */
    var chkCrsmb_presente = new Ext.form.Checkbox({
        id:'chkCrsmb_presente',
        name:'chkCrsmb_presente',
        fieldLabel :'Presente',
        allowBlank :false
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_sesion_miembro
     */
    var btnGuardarCgg_res_sesion_miembro = new Ext.Button({
        id:'btnGuardarCgg_res_sesion_miembro',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_res_sesion_miembro.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_res_sesion_miembro(r){
                        winFrmCgg_res_sesion_miembro.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_res_sesion_miembro,
                                msg: 'La informaci\u00f3n de Sesi\u00f3n Miembro ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_res_sesion_miembro.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_res_sesion_miembro,
                                msg: 'La informaci\u00f3n de Sesi\u00f3n Miembro no ha podido ser almacenada. '+(r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_res_sesion_miembro.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCrsmb_codigo',txtCrsmb_codigo.getValue());
                    param.add('inCrssc_codigo',tmpCrssc_codigo);
                    param.add('inCrmbc_codigo',tmpCrmbc_codigo);
                    param.add('inCgg_crmbc_codigo',tmpCgg_crmbc_codigo?tmpCgg_crmbc_codigo:null);
                    param.add('inCrsmb_presente',chkCrsmb_presente.getValue());
                    param.add('inCrsmb_presidente',chkCrsmb_presidente.getValue());
                    SOAPClient.invoke(urlCgg_res_sesion_miembro,INSENTENCIA_CGG_RES_SESION_MIEMBRO,param, true, CallBackCgg_res_sesion_miembro);
                }catch(inErr){
                    winFrmCgg_res_sesion_miembro.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_sesion_miembro.
     */
    var btnCancelarCgg_res_sesion_miembro = new Ext.Button({
        id:'btnCancelarCgg_res_sesion_miembro',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_res_sesion_miembro.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_sesion_miembro.
     */
    var btnCerrarCgg_res_sesion_miembro = new Ext.Button({
        id:'btnCerrarCgg_res_sesion_miembro',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_res_sesion_miembro.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_sesion_miembro.
     */
    var pnlCgg_res_sesion_miembro = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCrsmb_codigo,
            {xtype:'panel',layout:'column',
                items:[{columnWidth:.92,layout:'form',
                    items:[txtCrssc_codigo]},{columnWidth:.08,layout:'form',
                    items:[btnCrssc_codigoCgg_res_sesion_miembro]}]},
            {xtype:'panel',layout:'column',
                items:[{columnWidth:.92,layout:'form',
                    items:[txtCrmbc_codigo]},{columnWidth:.08,layout:'form',
                    items:[btnCrmbc_codigoCgg_res_sesion_miembro]}]},{xtype:'panel',layout:'column',
                items:[{columnWidth:.92,layout:'form',
                    items:[txtCgg_crmbc_codigo]},{columnWidth:.08,layout:'form',
                    items:[btnCgg_crmbc_codigoCgg_res_sesion_miembro]}]},chkCrsmb_presidente,chkCrsmb_presente]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_sesion_miembro.
     */
    var winFrmCgg_res_sesion_miembro = new Ext.Window({
        id:'winFrmCgg_res_sesion_miembro',
        title:tituloCgg_res_sesion_miembro,
        tbar:getPanelTitulo(tituloCgg_res_sesion_miembro,descCgg_res_sesion_miembro),
        items:[pnlCgg_res_sesion_miembro],
        width:400,
        minWidth:400,
        modal:true,
        resizable:false,
        maximizable:false,
        minimizable:false,
        constrain:true,
        bbar:[btnGuardarCgg_res_sesion_miembro,btnCancelarCgg_res_sesion_miembro,'->',btnCerrarCgg_res_sesion_miembro]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_sesion_miembro.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_res_sesion_miembroCtrls(inEstado){
        estado=!inEstado;
        txtCrsmb_codigo.setDisabled(estado);
        txtCrssc_codigo.setDisabled(estado);
        txtCrmbc_codigo.setDisabled(estado);
        txtCgg_crmbc_codigo.setDisabled(estado);
        chkCrsmb_presidente.setDisabled(estado);
        chkCrsmb_presente.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_sesion_miembro.
     */
    function cargarCgg_res_sesion_miembroCtrls(){
        if(inRecordCgg_res_sesion_miembro){
            txtCrsmb_codigo.setValue(inRecordCgg_res_sesion_miembro.get('CRSMB_CODIGO'));
            tmpCrssc_codigo=inRecordCgg_res_sesion_miembro.get('CRSSC_CODIGO');
            txtCrssc_codigo.setValue(inRecordCgg_res_sesion_miembro.get('SESION'));
            tmpCrmbc_codigo=inRecordCgg_res_sesion_miembro.get('CRMBC_CODIGO');
            txtCrmbc_codigo.setValue(inRecordCgg_res_sesion_miembro.get('PRINCIPAL'));
            tmpCgg_crmbc_codigo=inRecordCgg_res_sesion_miembro.get('CGG_CRMBC_CODIGO');
            txtCgg_crmbc_codigo.setValue(inRecordCgg_res_sesion_miembro.get('SUPLENTE'));
            chkCrsmb_presidente.setValue(inRecordCgg_res_sesion_miembro.get('CRSMB_PRESIDENTE'));
            chkCrsmb_presente.setValue(inRecordCgg_res_sesion_miembro.get('CRSMB_PRESENTE'));
            isEdit = true;
            habilitarCgg_res_sesion_miembroCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_sesion_miembro.
     * @returns ventana winFrmCgg_res_sesion_miembro.
     * @base FrmCgg_res_sesion_miembro.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_sesion_miembro;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_sesion_miembro.
     * @base FrmCgg_res_sesion_miembro.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_sesion_miembroCtrls();
    }
    ////////////////////////////////////////////////////////
    function seleccionarMiembroColumn(){
	
        /**
         * Ext.data.ColumnModel volumnas para el registros de la tabla Cgg_res_miembro_comite
         */
		var chkCrmbc_autorizado = new Ext.grid.CheckColumn(
		{dataIndex:'CRMBC_AUTORIZADO',header:'Autorizado',width:50,sortable:true});
		
        var cmCgg_res_miembro_usuario = new Ext.grid.ColumnModel([
            {dataIndex:'DOCUMENTO',header:'Tipo Documento',width:150,sortable:true},
            {dataIndex:'CRPER_NUM_DOC_IDENTIFIC',header:'Num. Documento',width:150,sortable:true},
            {dataIndex:'CRPER_NOMBRES',header:'Nombre',width:150,sortable:true},
            {dataIndex:'APELLIDO',header:'Apellido',width:150,sortable:true},
			{dataIndex:'CUSU_NOMBRE_USUARIO',header:'Usuario',width:70,sortable:true},
			{dataIndex:'CARGO',header:'Cargo',width:90,sortable:true},
			chkCrmbc_autorizado,
            {dataIndex:'CRMBC_FECHA_INICIO_FUNCIONES',header:'Inicio',width:150,sortable:true,renderer:truncDate},
            {dataIndex:'PARROQUIA',header:'Parroquia',width:150,sortable:true},
            {dataIndex:'CANTON',header:'Canton',width:150,sortable:true}
        ]);

        return cmCgg_res_miembro_usuario;
    }

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_miembro_comite por un campo especifico.
     */
    function seleccionarMiembroStore(){
        var  gsCgg_res_miembro_usuario = new Ext.data.Store({
            proxy:new Ext.ux.bsx.SoapProxy({
                url:URL_WS+"Cgg_res_miembro_comite",
                method:"selectPageDirect",
                pagin:true
            }),
            remoteSort:true,
            reader:new Ext.data.JsonReader({
                id:'CRPER_CODIGO',
                root:'dataSet',
                totalProperty: 'totalCount'
            },[
                {name:'CRMBC_CODIGO'},
                {name:'CRPER_CODIGO'},
                {name:'CUSU_CODIGO'},
                {name:'CUSU_EMPRESA'},
                {name:'CRDID_CODIGO'},
				{name:'CUSU_NOMBRE_USUARIO'},
				{name:'CARGO'},
                {name:'DOCUMENTO'},
                {name:'CRPER_NUM_DOC_IDENTIFIC'},
                {name:'CRPER_NOMBRES'},
                {name:'APELLIDO'},
                {name:'CRPER_GENERO'},
                {name:'CPRR_CODIGO'},
                {name:'PARROQUIA'},
                {name:'CCTN_CODIGO'},
				{name:'CRMBC_FECHA_INICIO_FUNCIONES'},
				{name:'CRMBC_FECHA_FIN_FUNCIONES'},
                {name:'CRMBC_AUTORIZADO'},
				{name:'CANTON'}
            ]),
            sortInfo:{field: 'CRPER_CODIGO', direction: 'ASC'},
            baseParams:{
				keyword:"",
				format:"JSON",
				inCrcom_codigo:tmpinCrcom_codigo,
				inShowAll:false
			}
        });

        return gsCgg_res_miembro_usuario;

    }
     /**
         * Funcion que permite cargar la codigo de los controles de la ventana winFrmListadoCgg_res_matrimonio.
         */
        function cargarComite(inCrcom_codigo){
            gsCgg_res_sesion_comite1.baseParams.inCrcom_codigo= inCrcom_codigo;
           tmpinCrcom_codigo=inCrcom_codigo;
        }
    /**
     * Funcion que permite cargar la codgi de los controles de la ventana winFrmListadoCgg_res_matrimonio.
     */
    this.setLoadCargarComite = function(inCrcom_codigo){
        cargarComite(inCrcom_codigo);
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_sesion_miembro desde una instancia.
 */
FrmCgg_res_sesion_miembro.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_sesion_miembro desde una instancia.
 */
FrmCgg_res_sesion_miembro.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_sesion_miembro,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_sesion_miembro.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_sesion_miembro desde una instancia.
 */
FrmCgg_res_sesion_miembro.prototype.loadData = function(){
    this.loadData();
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_miembro_comite desde una instancia.
 */
FrmCgg_res_sesion_miembro.prototype.setLoadCargarComite = function(inCrcom_codigo){
    this.setLoadCargarComite(inCrcom_codigo);
}
