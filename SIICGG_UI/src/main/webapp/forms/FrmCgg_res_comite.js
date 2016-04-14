/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_comite.
 * @param {String} INSENTENCIA_CGG_RES_COMITE Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_COMITE Registro de datos de la tabla Cgg_res_comite.
 * @constructor
 * @base FrmListadoCgg_res_comite
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_comite(INSENTENCIA_CGG_RES_COMITE,INRECORD_CGG_RES_COMITE){
    var inSentenciaCgg_res_comite = INSENTENCIA_CGG_RES_COMITE;
    var inRecordCgg_res_comite=INRECORD_CGG_RES_COMITE;
    var urlCgg_res_comite=URL_WS+"Cgg_res_comite";
    var tituloCgg_res_comite='Comit\u00e9';
    var descCgg_res_comite='El formulario permite administrar informaci\u00f3n del Comit\u00e9';
    var isEdit = false;
    var tmpTramiteComite;
	var myFormTST = new FrmListadoCgg_res_tipo_solicitud_tramite();
	var myStoreTST = myFormTST.getStore();
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCrcom_codigo = new Ext.form.TextField({
        id:'txtCrcom_codigo',
        name:'txtCrcom_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField NOMBRE DEL COMITE
     */
    var txtCrcom_nombre = new Ext.form.TextField({
        id:'txtCrcom_nombre',
        name:'txtCrcom_nombre',
        fieldLabel :'Nombre',
        anchor:'98%',
        allowBlank :false,
        maxLength :50
    });
    /**
     * Ext.form.TextField NOMBRE DEL COMITE
     */
    var txtCrcom_descripcion = new Ext.form.TextField({
        id:'txtCrcom_descripcion',
        name:'txtCrcom_descripcion',
        fieldLabel :'Descripci\u00f3n',
        anchor:'98%'
    });
	/**
	* Ext.form.TextField ABREVIIATURA DEL NOMBRE DE COMITE UTILIZADO PARA EL NUMERO DE RESOLUCIONES.
	*/
	var txtCrcom_abreviatura = new Ext.form.TextField({
			id:'txtCrcom_abreviatura',
			name:'txtCrcom_abreviatura',
			fieldLabel :'Abreviatura',
			anchor:'98%',
			allowBlank :false,
			maxLength:5
	});
    /**
     * Boton que permite cargar todos tipos de solicitud tramite de la tabla Cgg_res_tipo_solicitud_tramite
     */
    var btnTodosSolicitud_tramite = new Ext.Button({
        id:'btnTodosTramites',
        text:'Todos',
        iconCls:'iconTodo',
        listeners:{
            click:function(){
                function CallBackTipoSolicitudTramite(inResponse){
					var tmpRecords = Ext.util.JSON.decode(inResponse).dataSet;
					var tmpSW = false;
					for(i=0; i < tmpRecords.length; i++){
						if(tmpRecords[i].CRRES_CODIGO)
							tmpSW = true;
						else if(!gsCgg_res_tramite_comite.getAt(gsCgg_res_tramite_comite.findExact('CRTST_CODIGO',tmpRecords[i].CRTST_CODIGO))){
							var tmpRecord = gsCgg_res_tramite_comite.recordType;
							gsCgg_res_tramite_comite.add(new tmpRecord({
								CRTST_CODIGO:tmpRecords[i].CRTST_CODIGO,
								CGG_CRTST_CODIGO:tmpRecords[i].CGG_CRTST_CODIGO,
								CRTPT_CODIGO:tmpRecords[i].CRTPT_CODIGO,
								CRTST_DESCRIPCION:tmpRecords[i].CRTST_DESCRIPCION,
								CRTST_OBSERVACION:tmpRecords[i].CRTST_OBSERVACION,
								CRTST_NUMERO_DIAS:tmpRecords[i].CRTST_NUMERO_DIAS
							}));
						}
					}
					if(tmpSW)
						Ext.Msg.alert(tituloCgg_res_comite, 'Algunos tipos de solicitud tienen asignado una resoluci\u00f3n de aprobaci\u00f3n y no fueron agregados.');
				}
				var param = new SOAPClientParameters();
				param.add('start',0);
				param.add('limit',10000);
				param.add('sort','CGG_CRTST_CODIGO');
				param.add('dir','ASC');
				param.add('keyword','');
				param.add('format','JSON');
				param.add('inSW',true);
				param.add('inCrtst_codigo','');
                SOAPClient.invoke(URL_WS+"Cgg_res_tipo_solicitud_tramite","selectPageDirect",param, true, CallBackTipoSolicitudTramite);
            }}
    });
    /**
     * Boton que permite cargar todos los tramites que estan listos para entrar a comite
     */
    var btnSeleccionSolicitud_tramite = new Ext.Button({
        id:'btnSeleccionTramite',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
				myStoreTST.baseParams.inSW = true;
                var objCgg_res_seleccionSolicitudTramite = new DlgBusqueda(myStoreTST, new FrmListadoCgg_res_tipo_solicitud_tramite().getColumnModel(), true);
                objCgg_res_seleccionSolicitudTramite.closeHandler(function(){
                    var tmpRows = objCgg_res_seleccionSolicitudTramite.getSelectedRows();
					var tmpSW = false;
                    if(tmpRows){
						for(i=0; i < tmpRows.length; i++){
							if(tmpRows[i].data.CRRES_CODIGO)
								tmpSW = true;
							if(!gsCgg_res_tramite_comite.getAt(gsCgg_res_tramite_comite.findExact('CRTST_CODIGO',tmpRows[i].data.CRTST_CODIGO)))
								gsCgg_res_tramite_comite.add(tmpRows[i]);
						}
						if(tmpSW)
							Ext.Msg.alert(tituloCgg_res_comite, 'Algunos tipos de solicitud tienen asignado una resoluci\u00f3n de aprobaci\u00f3n y no fueron agregados.');
					}
                });
                objCgg_res_seleccionSolicitudTramite.show();
            }}

    });

    /**
     * Boton que permite eliminar los tipos de solicitud tramite de la tabla Cgg_res_tipo_solicitud_tramite
     */
    var btnEliminarSolicitud_tramite = new Ext.Button({
        id:'btnEliminarSolicitud_tramite',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                var seleccionado = grdCgg_res_tipo_solicitud_tramite.getSelectionModel().getSelected();
                if(seleccionado !=null){
                    grdCgg_res_tipo_solicitud_tramite.getStore().remove(seleccionado);
                }else{
                    Ext.Msg.show({title:'Aviso', msg:'Seleccione un tipo de solicitud a eliminar', buttons: Ext.Msg.OK,icon: Ext.MessageBox.QUESTION});
                }
            }
        }
    });

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_tipo_solicitud_tramite.
     */
    var cmCgg_res_tipo_solicitud_tramite = new Ext.grid.ColumnModel([
		{dataIndex:'PADRE',header:'Categor\u00eda',width:150,sortable:true},
        {dataIndex:'CRTST_DESCRIPCION',header:'Descripci\u00f3n',width:150,sortable:true},
        {dataIndex:'CRTST_OBSERVACION',header:'Observaci\u00f3n',width:200,sortable:true},
        {dataIndex:'CRTPT_NOMBRE',header:'Tipo tramite',width:150,sortable:true},
        {dataIndex:'CRTST_NUMERO_DIAS',header:'Numero dias',width:150,sortable:true}
    ]);
    ////////////////////////
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_tipo_solicitud_tramite por un campo especifico.
     */
    var gsCgg_res_tramite_comite = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_comite",
            method:"selectSolicitud_Tramite",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
            id:'CRTST_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[{name:'CRTST_CODIGO'},
            {name:'CGG_CRTSR_CODIGO'},
            {name:'CRTPT_CODIGO'},
            {name:'CRTPT_NOMBRE'},
			{name:'PADRE'},
            {name:'CRTST_DESCRIPCION'},
            {name:'CRTST_OBSERVACION'},
            {name:'CRTST_APLICA_GARANTIA'},
            {name:'CRTST_APLICA_TRAMITE'},
            {name:'CRTST_APLICA_GRUPO'},
            {name:'CRTST_ATENCION_CLIENTE'},
            {name:'CRTST_RESTRINGIDO'},
            {name:'CRTST_COMUNICADO_RADIAL'},
            {name:'CRTST_NUMERO_DIAS'},
			{name:'CRTST_VEHICULO'},
			{name:'CRTST_UNANIMIDAD'}
        ]),
        sortInfo:{
            field: 'CGG_CRTSR_CODIGO'

        },
        baseParams:{
            inCrcom_codigo:"",
            format:"JSON"
        }
    });
    ///////////////////////
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_tipo_solicitud_tramite en un formato tabular de filas y columnas.
     */
    var grdCgg_res_tipo_solicitud_tramite = new Ext.grid.GridPanel({
        cm:cmCgg_res_tipo_solicitud_tramite,
        height:180,
        region:'center',
        store:gsCgg_res_tramite_comite,
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        loadMask:{
            msg:"Cargando..."
        }
    });

    /////////////////////////////////////////////////////////////////////////


    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_comite
     */
    var btnGuardarCgg_res_comite = new Ext.Button({
        id:'btnGuardarCgg_res_comite',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_res_comite.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_res_comite(r){
                        winFrmCgg_res_comite.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_res_comite,
                                msg: 'La informaci\u00f3n del Comit\u00e9 ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_res_comite.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_res_comite,
                                msg: 'La informaci\u00f3n del Comit\u00e9 no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_res_comite.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCrcom_codigo',txtCrcom_codigo.getValue());
                    param.add('inCrcom_nombre',txtCrcom_nombre.getValue());
                    param.add('inCrcom_descripcion',txtCrcom_descripcion.getValue());
					param.add('inCrcom_abreviatura',txtCrcom_abreviatura.getValue());
                    param.add('inTramiteComite',grdCgg_res_tipo_solicitud_tramite.getStore().getJsonData());
                    SOAPClient.invoke(urlCgg_res_comite,INSENTENCIA_CGG_RES_COMITE,param, true, CallBackCgg_res_comite);
                }catch(inErr){
                    winFrmCgg_res_comite.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_comite.
     */
    var btnCancelarCgg_res_comite = new Ext.Button({
        id:'btnCancelarCgg_res_comite',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_res_comite.getForm().reset();
                gsCgg_res_tramite_comite.removeAll();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_comite.
     */
    var btnCerrarCgg_res_comite = new Ext.Button({
        id:'btnCerrarCgg_res_comite',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_res_comite.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_comite.
     */
    var pnlCgg_res_solicitud_tramite = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        tbar:[btnTodosSolicitud_tramite,'-',btnSeleccionSolicitud_tramite,btnEliminarSolicitud_tramite],
        items:[grdCgg_res_tipo_solicitud_tramite]
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_comite.
     */
    var pnlCgg_res_comite = new Ext.form.FormPanel({
        frame:true,
        labelWidth :70,
        items:[txtCrcom_codigo,txtCrcom_nombre,txtCrcom_descripcion,txtCrcom_abreviatura]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_comite.
     */
    var winFrmCgg_res_comite = new Ext.Window({
        id:'winFrmCgg_res_comite',
        title:tituloCgg_res_comite,
        tbar:getPanelTitulo(tituloCgg_res_comite,descCgg_res_comite),
        items:[pnlCgg_res_comite,pnlCgg_res_solicitud_tramite],
        resizeable:'false',
        modal:true,
        resizable:true,
        width:500,
        height:400,
        minWidth:400,
        maximizable:true,
        minimizable:false,
        constrain:true,
        bbar:[btnGuardarCgg_res_comite,btnCancelarCgg_res_comite,'->',btnCerrarCgg_res_comite]
    });
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_comite.
     */
    function cargarCgg_res_comiteCtrls(){
        if(inRecordCgg_res_comite){
            txtCrcom_codigo.setValue(inRecordCgg_res_comite.get('CRCOM_CODIGO'));
            txtCrcom_nombre.setValue(inRecordCgg_res_comite.get('CRCOM_NOMBRE'));
            txtCrcom_descripcion.setValue(inRecordCgg_res_comite.get('CRCOM_DESCRIPCION'));
			txtCrcom_abreviatura.setValue(inRecordCgg_res_comite.get('CRCOM_ABREVIATURA'));
            isEdit = true;
            gsCgg_res_tramite_comite.reload();
        }}
    /**
     * Funcion que permite cargar la codigo de los controles de la ventana winFrmListadoCgg_res_matrimonio.
     */
    function cargarCgg_res_tipo_solicitud(inCodigo){
        gsCgg_res_tramite_comite.reload({params:{
            inCrcom_codigo:inCodigo,
            format:"JSON"

        }
        });
    }
    /**
     * Funcion que permite cargar la codgi de los controles de la ventana winFrmListadoCgg_res_matrimonio.
     */
    this.loadtipo_solicitud = function(inCodigo){
        cargarCgg_res_tipo_solicitud(inCodigo);
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_comite.
     * @returns ventana winFrmCgg_res_comite.
     * @base FrmCgg_res_comite.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_comite;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_comite.
     * @base FrmCgg_res_comite.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_comiteCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_comite desde una instancia.
 */
FrmCgg_res_comite.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_comite desde una instancia.
 */
FrmCgg_res_comite.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_comite,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_comite.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_comite desde una instancia.
 */
FrmCgg_res_comite.prototype.loadData = function(){
    this.loadData();
}
