/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_movilidad.
 * @param {String} INSENTENCIA_CGG_RES_MOVILIDAD Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_MOVILIDAD Registro de datos de la tabla Cgg_res_movilidad.
 * @constructor
 * @base FrmListadoCgg_res_movilidad
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_movilidad_residentes(INSENTENCIA_CGG_RES_MOVILIDAD,INRECORD_CGG_RES_MOVILIDAD) {
    var inSentenciaCgg_res_movilidad = INSENTENCIA_CGG_RES_MOVILIDAD;
    var inRecordCgg_res_movilidad = INRECORD_CGG_RES_MOVILIDAD;
    var urlCgg_res_movilidad = URL_WS + "Cgg_res_movilidad";
    var tituloCgg_res_movilidad = 'Registro de ingreso/salida de residentes';
    var descCgg_res_movilidad = 'El formulario permite administrar la informaci\u00f3n del Registro de ingreso/salida de residentes';
    var isEdit = false;
    var tmpcrmov_codigo3;
    var tmpCrper_codigo3;
    var tmpCraln_codigosalida3;
    var tmCtfsl_codigo3;
    var tmpCarpt_codigo_salida3;
    var tmpPlugin;
	var tmpSW = false;
	var tmpUserSession;
	var tmpSaveAndClose;
	var tmpCrrsd_codigo;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCrmov_codigo3 = new Ext.form.TextField({
        id:'txtCrmov_codigo3',
        name:'txtCrmov_codigo3',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });

    /**
     * Ext.form.NumberField CODIGO DE BARRAS GENERADO PARA EL REGISTRO DE TCT
     */
    var txtCrper_numero3 = new Ext.form.TextField({
        id:'txtCrper_numero3',
        name:'txtCrper_numero3',
        anchor:'98%',
        fieldLabel :'Num. Identificaci\u00f3n',
        style: {
            color:'#004A95',
            background:'#FFFFE6'
        },
        listeners:{
            specialkey :function(inField, e){
                if (e.getKey() == e.ENTER) {
					tmpSW = true;
					gsCgg_res_buscar_residente.baseParams.inIdentificacion = txtCrper_numero3.getValue();
					gsCgg_res_buscar_residente.baseParams.start = 0;
					gsCgg_res_buscar_residente.baseParams.limit = 100;
                    gsCgg_res_buscar_residente.reload();
                }
            }
        }
    });

    function BuscarResidente(){
        var cmCgg_res_buscar_residente = new Ext.grid.ColumnModel([
            {dataIndex:'CRPER_NUMERO_RESIDENCIA',header:'Numero Residencia',width:150,sortable:true,hidden:true},
            {dataIndex:'CRPER_NUM_DOC_IDENTIFIC',header:'Numero Documento',width:150,sortable:true},
            {dataIndex:'CRPER_NOMBRES',header:'Nombres',width:150,sortable:true},
            {dataIndex:'CRPER_APELLIDO_PATERNO',header:'Apellido',width:150,sortable:true},
            {dataIndex:'CRPER_GENERO',header:'Genero',width:150,sortable:true,renderer:function(inCrper_genero){
                    return dsGeneroPersona[inCrper_genero][1];
                }
            },
            {dataIndex:'CRPER_FECHA_NACIMIENTO',header:'Fecha Nacimiento',width:150,sortable:true,renderer:truncDate},
            {dataIndex:'CGNCN_NACIONALIDAD',header:'Nacionalidad',width:150,sortable:true},
            {dataIndex:'TIPO_RESIDENCIA',header:'Tipo Residencia',width:150,sortable:true}
        ]);
		this.getCm = function() {
            return cmCgg_res_buscar_residente;
        };
    }
    BuscarResidente.prototype.getColumnModel = function() {
        return this.getCm();
    };
	
		/**
         * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_movilidad por un campo especifico.
         */
        var gsCgg_res_buscar_residente = new  Ext.data.Store({
            proxy:new Ext.ux.bsx.SoapProxy({
                url:URL_WS+"Cgg_res_movilidad",
                method:"selectPageResidentes",
                pagin:true
            }),
            remoteSort:true,
            reader:new Ext.data.JsonReader({
                id:'CRPER_CODIGO',
                root:'dataSet',
                totalProperty: 'totalCount'
            },[
                {name:'CRPER_CODIGO'},
                {name:'CRDID_CODIGO'},
                {name:'CRDID_DESCRIPCION'},
                {name:'CRPER_NUM_DOC_IDENTIFIC'},
                {name:'CRPER_NUM_DOC_IDENTIFIC'},
                {name:'CRPER_NOMBRES'},
                {name:'CRPER_APELLIDO_PATERNO'},
				{name:'CRPER_APELLIDO_MATERNO'},
                {name:'CRPER_GENERO'},
                {name:'CRPER_FECHA_NACIMIENTO'},
                {name:'CGNCN_CODIGO'},
                {name:'CGNCN_NACIONALIDAD'},
				{name:'CRRSD_CODIGO'},
                {name:'TIPO_RESIDENCIA'}
            ]),
            sortInfo:{
                field: 'CRPER_CODIGO',
                direction: 'ASC'
            },
            baseParams:{
                keyword:'',
                format:'JSON',
				inIdentificacion:''
            },
			listeners:{
				load:function(inStore, inRecords, inOptions){
					if(tmpSW && inRecords.length == 1){
						tmpSW = false;
						inRecordCgg_res_movilidad = inRecords[0].data;
						cargarCgg_res_movilidadCtrls();
					}
				}
			}
        });

    var btnMoviBuscarHuella = new Ext.Button({
        id:'btnMoviBuscarHuella',
        iconCls:'iconHand',
        listeners:{
            click:function(){
                if(!tmpPlugin)
                    tmpPlugin = document.getElementById("bsxMoviBiometric");
                var tmpRes = tmpPlugin.capture();
                if(tmpRes ==0){
					Ext.Ajax.request({
						url: URL_WS+'Biometrico',
						success: function(inResponse){
							var tmpJSON = Ext.util.JSON.decode(inResponse.responseText);
							if(tmpJSON.success == false)
							{
								Ext.Msg.show({
									title: tituloCgg_res_movilidad,
									msg: tmpJSON.msg,
									buttons: Ext.Msg.OK,
									icon: Ext.MessageBox.ERROR
								});
							}
							else
							{
								Ext.Msg.show({
									title: tituloCgg_res_movilidad,
									msg: "Informaci\u00f3n validada correctamente",
									buttons: Ext.Msg.OK,
									icon: Ext.MessageBox.INFO
								});

								txtCrper_numero3.setValue(tmpJSON.msg);
								//cargaDatosPersonales(tmpJSON.msg);
							}


						},
						failure: function(inResponse){
							var tmpJSON = Ext.util.JSON.decode(inResponse.responseText)
						   // alert(tmpJSON.msg);
						},
						params: {
							op: 'verify',
							data: tmpPlugin.firText,
							id:txtCrper_numero3.getValue()
						}
					});
                }else{
					Ext.Msg.show({
						title: tituloCgg_res_movilidad,
						msg: tmpPlugin.message,
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.ERROR
					});
                }
            }
        }
    });
    /**
     * Boton que permite buscar las pesonas que estan preregistradas para el ingreso a la provincia
     */
    var btnBuscarCodigoBarras3 = new Ext.Button({
        id:'btnBuscarCodigoBarras3',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_res_residentes = new BuscarResidente();
                var objBusqueda = new DlgBusqueda(gsCgg_res_buscar_residente,tmpFLCgg_res_residentes.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
						inRecordCgg_res_movilidad = tmpRecord.data;
						cargarCgg_res_movilidadCtrls();
                    }
                });
                objBusqueda.show();
            }
        }
    });
	
    /**
     * Ext.form.ComboBox Tipo Operacion
     */
    var cbxCtreg_tipo_operacion3 = new Ext.form.ComboBox({
        id:'cbxCtreg_tipo_operacion3',
        name:'cbxCtreg_tipo_operacion3',
        store: dsTipoOperacion,
        fieldLabel:'<b>Modo<b>',
        anchor:'98%',
        mode:'local',
        editable: false,
        triggerAction:'all',
        allowBlank :false,
        emptyText : 'Seleccione una opci\u00f3n.'
    });

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_aerolinea por un campo especifico.
     */
    var gsCgg_res_aerolinea3 = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_aerolinea",
            method:"selectAll"
        }),
        reader:new Ext.data.JsonReader({},[
            {name:'CRALN_CODIGO'},
            {name:'CRALN_NOMBRE'},
            {name:'CRALN_TIPO_AEROLINEA'}
        ]),
        baseParams:{
            format:"JSON"
        },
		listeners:{
			load:function(){
				loadDefaultData();
			}
		}
    });

    /**
     * Ext.form.ComboBox Aereolinea de la tct.
     */
    var cbxCraln_codigo3 = new Ext.form.ComboBox({
        id:'cbxCraln_codigo3',
        fieldLabel :'Aerol\u00ednea',
        displayField:'CRALN_NOMBRE',
        store:gsCgg_res_aerolinea3,
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
		editable:false,
        triggerAction:'all',
        allowBlank :false,
        emptyText:'Seleccione la aerol\u00ednea',
        selectOnFocus:true,
        valueField:'CRALN_CODIGO',
		anchor:'98%'
    });
    gsCgg_res_aerolinea3.load();
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_aeropuerto por un campo especifico.
     */
    var gsCgg_res_aeropuerto3 = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_aeropuerto",
            method:"selectAll"
        }),
        reader:new Ext.data.JsonReader({},[
            {name:'CARPT_CODIGO'},
            {name:'CCTN_CODIGO'},
            {name:'CANTON'},
            {name:'CARPT_NOMBRE'},
            {name:'CARPT_TIPO_AEREOPUERTO'}
        ]),
        baseParams:{
            format:"JSON"
        },
		listeners:{
			load:function(){
				loadDefaultData();
			}
		}
    });
    /**
     * Ext.form.ComboBox IDENTIFICATIVO UNICO DE REGISTRO
     */
    var cbxCarpt_codigo3= new Ext.form.ComboBox({
        id:'cbxCarpt_codigo3',
        fieldLabel :'Aeropuerto',
        displayField:'CARPT_NOMBRE',
        store:gsCgg_res_aeropuerto3,
        typeAhead: true,
        mode:'local',
        readOnly:true,
        allowBlank :false,
        triggerAction:'all',
        emptyText:'Seleccione la salida',
        selectOnFocus:true,
        valueField:'CARPT_CODIGO',
        anchor:'98%'
    });
    gsCgg_res_aeropuerto3.reload();
    ///////////////////////////////////////////////////////////////
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
     */
    var txtCrper_codigo3 = new Ext.form.TextField({
        id:'txtCrper_codigo3',
        name:'txtCrper_codigo3',
        fieldLabel :'Codigo',
        width:200,
        hidden:true,
        hideLabel:true

    });
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
     */
    var txtCtreg_codigo3 = new Ext.form.TextField({
        id:'txtCtreg_codigo3',
        name:'txtCtreg_codigo3',
        fieldLabel :'Codigo',
        width:200,
        hidden:true,
        hideLabel:true

    });
    /**
     * Ext.form.TextField TIPO DOCUMENTO
     */
    var txtCrdid_codigo3 = new Ext.form.TextField({
        id:'txtCrdid_codigo3',
        name:'txtCrdid_codigo3',
        fieldLabel :'Tipo Documento',
        width:200,
        readOnly:'true'
    });
    /**
     * Ext.form.TextField NOMBRES DE LA PERSONA
     */
    var txtCrper_nombres3 = new Ext.form.TextField({
        id:'txtCrper_nombres3',
        name:'txtCrper_nombres3',
        fieldLabel :'Nombres',
        width:200,
        readOnly:'true'
    });
    /**
     * Ext.form.TextField APELLIDO PATERNO
     */
    var txtCrper_apellido_paterno3 = new Ext.form.TextField({
        id:'txtCrper_apellido_paterno3',
        name:'txtCrper_apellido_paterno3',
        fieldLabel :'Apellidos',
        width:200,
        readOnly:'true'
    });

    /**
     * Ext.form.TextField NUMERO DE DOCUEMNTO DE IDENTIFICACION
     */
    var txtCrper_num_doc_identific3 = new Ext.form.TextField({
        id:'txtCrper_num_doc_identific3',
        name:'txtCrper_num_doc_identific3',
        fieldLabel :'No. identificaci\u00f3n',
        width:200,
        allowBlank :false,
        readOnly:'true'

    });
    /**
     * Ext.form.TextField APELLIDO PATERNO
     */
    var txtCrres_tipo_residencia3 = new Ext.form.TextField({
        id:'txtCrres_tipo_residencia3',
        name:'txtCrres_tipo_residencia3',
        fieldLabel :'Residencia',
        width:200,
        readOnly:'true'
    });

    /**
     * Ext.form.TextField GENERO DE LA PERSONA
     */
    var txtCrper_genero3 = new Ext.form.TextField({
        id:'txtCrper_genero3',
        name:'txtCrper_genero3',
        fieldLabel :'Genero',
        width:200,
        readOnly:'true'
    });
    /**
     * Ext.form.TextField GENERO DE LA PERSONA
     */
    var txtCgncn_codigo3 = new Ext.form.TextField({
        id:'txtCgncn_codigo3',
        name:'txtCgncn_codigo3',
        fieldLabel :'Nacionalidad',
        width:200,
        readOnly:'true'
    });

    /**
     * Ext.form.DateField FECHA DE NACIMIENTO
     */
    var dtCrper_fecha_nacimiento3 = new Ext.form.DateField({
        id:'dtCrper_fecha_nacimiento3',
        name:'dtCrper_fecha_nacimiento3',
        fieldLabel :'Fecha nacimiento',
        format:'d/m/Y',
        readOnly:true
    });
    /**
     * Ext.form.DateField FECHA DE VIAJE
     */
    var dtCrmov_fecha_viaje3 = new Ext.form.DateField({
        id:'dtCrmov_fecha_viaje3',
        name:'dtCrmov_fecha_viaje3',
        fieldLabel :'Viaje',
        format:'d/m/Y',
        value:CURRENT_DATE,
        maxValue:CURRENT_DATE
    });
    /**
     * Ext.form.TextField NUMERO DE VUELO
     */
    var txtCrmov_numero_vuelo3 = new Ext.form.TextField({
        id:'txtCrmov_numero_vuelo3',
        name:'txtCrmov_numero_vuelo3',
        fieldLabel :'Vuelo',
        width:80,
        allowBlank :false
    });
    /**
     * Ext.form.TextField DESCRIPCION CORTA DE LA OPERACION
     */
    var txtCrmov_observacion3 = new Ext.form.TextArea({
        id:'txtCrmov_observacion3',
        name:'txtCrmov_observacion3',
        fieldLabel :'Observaci\u00f3n',
        anchor:'98%',
		height:30
    });
    
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_movilidad_residentes
     */
    var btnGuardarCgg_res_movilidad3 = new Ext.Toolbar.SplitButton({
        id:'btnGuardarCgg_res_movilidad3',
        text:'Guardar',
        iconCls:'iconGuardar',
		menu:[{text:'Guardar y salir',handler:function(){
			tmpSaveAndClose = true;
			btnGuardarCgg_res_movilidad3.fireEvent('click', btnGuardarCgg_res_movilidad3);
		}}],
        listeners:{
            click:function() {
                if (pnlCgg_res_movilidad3.getForm().isValid() == false) {
                    return;
                }
                try {
					var tmpMsg = 'entrada';
					if (cbxCtreg_tipo_operacion3.getValue() == 1 )
						tmpMsg = 'salida';
                    function CallBackCgg_res_movilidad(r) {
                        winFrmCgg_res_movilidad_residentes.getEl().unmask();
                        if (r == 'true') {
							Ext.MsgPopup.msg(tituloCgg_res_movilidad, 'La informaci\u00f3n de '+tmpMsg+' de la persona ha sido almacenada.', MsgPopup.INFO);
							if(tmpSaveAndClose)
								winFrmCgg_res_movilidad_residentes.close();
							else{
								pnlCgg_res_movilidad3.getForm().reset();
							}
							tmpSaveAndClose = false;
                        } else {
                            Ext.Msg.show({
                                title:tituloCgg_res_movilidad,
                                msg: 'La informaci\u00f3n de '+tmpMsg+' de la persona no ha podido ser almacenada. '+ (r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
					if(new ManagerCookies().read('MOVILIDAD_VUELO'))
						new ManagerCookies().erase('MOVILIDAD_VUELO');
					new ManagerCookies().create('MOVILIDAD_VUELO', txtCrmov_numero_vuelo3.getValue(), 168);
					
					if(new ManagerCookies().read('MOVILIDAD_AEROLINEA'))
						new ManagerCookies().erase('MOVILIDAD_AEROLINEA');
					new ManagerCookies().create('MOVILIDAD_AEROLINEA', cbxCraln_codigo3.getValue(), 168);
					
					if(new ManagerCookies().read('MOVILIDAD_MODO'))
						new ManagerCookies().erase('MOVILIDAD_MODO');
					new ManagerCookies().create('MOVILIDAD_MODO', cbxCtreg_tipo_operacion3.getValue(), 168);
					
                    winFrmCgg_res_movilidad_residentes.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if (isEdit){
                        param.add('inCrmov_codigo', tmpcrmov_codigo3);
                    }
                    param.add('inCraln_codigo', cbxCraln_codigo3.getValue());
                    param.add('inCarpt_codigo', cbxCtreg_tipo_operacion3.getValue()==0?null:cbxCarpt_codigo3.getValue());
                    param.add('inCgg_carpt_codigo', cbxCtreg_tipo_operacion3.getValue()==0?cbxCarpt_codigo3.getValue():null);
                    param.add('inCrper_codigo', tmpCrper_codigo3);
                    param.add('inCtreg_codigo', null);
					param.add('inCrrsd_codigo', tmpCrrsd_codigo.length>0?tmpCrrsd_codigo:null);
                    param.add('inCrmov_fecha_viaje', dtCrmov_fecha_viaje3.getValue().format('Y-m-d'));
                    param.add('inCrmov_tipo_operacion', cbxCtreg_tipo_operacion3.getValue());
                    param.add('inCrmov_numero_vuelo', txtCrmov_numero_vuelo3.getValue());
                    param.add('inCrmov_observacion', txtCrmov_observacion3.getValue());
                    param.add('inCrmov_tipo_salida', 0);
                    param.add('inCrmov_filtro_interno',true);
					param.add('inPersonaJSON',null);
					param.add('inActividadesJSON',null);
					param.add('inHospedajesJSON',null);
                    SOAPClient.invoke(urlCgg_res_movilidad, INSENTENCIA_CGG_RES_MOVILIDAD, param, true, CallBackCgg_res_movilidad);
                } catch(inErr) {
                    winFrmCgg_res_movilidad_residentes.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_movilidad_residentes.
     */
    var btnCancelarCgg_res_movilidad3 = new Ext.Button({
        id:'btnCancelarCgg_res_movilidad3',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function() {
                pnlCgg_res_movilidad3.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_movilidad_residentes.
     */
    var btnCerrarCgg_res_movilidad3 = new Ext.Button({
        id:'btnCerrarCgg_res_movilidad3',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function() {
                winFrmCgg_res_movilidad_residentes.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel para los Aeropuertos
     */
    var pnlCgg_tct_codigo_barras3 = new Ext.Panel({
		layout:'form',
        labelWidth :110,
        items:[
			cbxCtreg_tipo_operacion3,
            {xtype:'panel',layout:'column',
                items:[
                    {columnWidth:.84,layout:'form',items:[txtCrper_numero3]},
                    {columnWidth:.08,layout:'form', items:[btnBuscarCodigoBarras3]},
                    {columnWidth:.08,layout:'form', items:[btnMoviBuscarHuella]}
                ]}
        ],
        html:'<object id="bsxMoviBiometric" type="' + SII_mimeType + '" width="0" height="0"></object>'
    });

    /**
     * Ext.Panel Panel que contiene los controles de la actividad y el  tipo hospedaje
     */
    var pnlCgg_res_aerolinea_vuelo3 = new  Ext.form.FieldSet({
        id:'pnlCgg_res_aerolinea_vuelo3',
        title:'Datos',
        layout:'column',
        labelWidth:80,
        items:[ {columnWidth:.5,layout:'form',items:[
				txtCrmov_numero_vuelo3,
				{xtype:'panel',id:'pnlMovResFechas',layout:'form',items:[dtCrmov_fecha_viaje3]}
			]},
			{columnWidth:.5,layout:'form',items:[
				cbxCarpt_codigo3,cbxCraln_codigo3
			]}
        ]
    });

    /**
     * Ext.Panel Panel que contiene los controles de la actividad y el  tipo hospedaje
     */
    var pnlCgg_res_persona3 = new Ext.form.FieldSet({
        id:'pnlCgg_res_persona3',
        title:'Persona',
        collapsible:false,
        labelWidth :120,
        region:'center',
        items:[
            {xtype:'panel',layout:'column',
                items:[
                    {columnWidth:.50,layout:'form',
                        items:[txtCrdid_codigo3,txtCrper_nombres3,txtCrper_genero3,txtCgncn_codigo3]},
                    {columnWidth:.50,layout:'form',
                        items:[txtCrper_num_doc_identific3,txtCrper_apellido_paterno3,dtCrper_fecha_nacimiento3,txtCrres_tipo_residencia3]}
                ]}
        ]
    });

    /**
     * Ext.form.FormPanel Panel que contiene todos los controles de winFrmCgg_res_movilidad_residentes
     */

    var pnlCgg_res_movilidad3 = new Ext.form.FormPanel({
        id:'pnlCgg_res_movilidad',
        frame:true,
        labelWidth :100,
        items:[txtCrmov_codigo3,
            pnlCgg_tct_codigo_barras3,pnlCgg_res_aerolinea_vuelo3,pnlCgg_res_persona3,
            txtCrmov_observacion3
        ]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_movilidad.
     */
    var winFrmCgg_res_movilidad_residentes = new Ext.Window({
        id:'winFrmCgg_res_movilidad_residentes',
        title:tituloCgg_res_movilidad,
        tbar:getPanelTitulo(tituloCgg_res_movilidad, descCgg_res_movilidad),
        items:[pnlCgg_res_movilidad3],
        width:720,
        minWidth:400,
        maximizable:false,
        modal:true,
        resizable:false,
        minimizable:true,
        constrain:true,
        bbar:[btnGuardarCgg_res_movilidad3,btnCancelarCgg_res_movilidad3,'->',btnCerrarCgg_res_movilidad3],
		listeners:{
			show:function(){
				loadDefaultData();
			}
		}
    });
	/**
	 * Funcion que aplica los privilegios del usuario.
	 */
    applyGrants(winFrmCgg_res_movilidad_residentes.getBottomToolbar());
	applyGrants(Ext.getCmp('pnlMovResFechas'), true);
	
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_movilidad_residentes.
     */
    function cargarCgg_res_movilidadCtrls() {
        if (inRecordCgg_res_movilidad) {
			txtCrper_numero3.setValue(inRecordCgg_res_movilidad.CRPER_NUM_DOC_IDENTIFIC);
            tmpCrper_codigo3 = inRecordCgg_res_movilidad.CRPER_CODIGO;
            txtCrdid_codigo3.setValue(inRecordCgg_res_movilidad.CRDID_DESCRIPCION);
            txtCrper_num_doc_identific3.setValue(inRecordCgg_res_movilidad.CRPER_NUM_DOC_IDENTIFIC);
            txtCrper_nombres3.setValue(inRecordCgg_res_movilidad.CRPER_NOMBRES);
            txtCrper_apellido_paterno3.setValue(inRecordCgg_res_movilidad.CRPER_APELLIDO_PATERNO+' '+inRecordCgg_res_movilidad.CRPER_APELLIDO_MATERNO);
            txtCrper_genero3.setValue(dsGeneroPersona[inRecordCgg_res_movilidad.CRPER_GENERO][1]);
            dtCrper_fecha_nacimiento3.setValue(truncDate(inRecordCgg_res_movilidad.CRPER_FECHA_NACIMIENTO));
            txtCgncn_codigo3.setValue(inRecordCgg_res_movilidad.CGNCN_NACIONALIDAD);
            txtCrres_tipo_residencia3.setValue(inRecordCgg_res_movilidad.TIPO_RESIDENCIA);
            cbxCraln_codigo3.setValue(inRecordCgg_res_movilidad.CRALN_CODIGO);
            txtCrmov_observacion3.setValue(inRecordCgg_res_movilidad.CRMOV_OBSERVACION);
			tmpCrrsd_codigo = inRecordCgg_res_movilidad.CRRSD_CODIGO;
			gsCgg_res_buscar_residente.baseParams.inIdentificacion = '';
			gsCgg_res_buscar_residente.reload();
			loadDefaultData();
        }
    }
	
	function loadDefaultData(){
		if(new ManagerCookies().read('MOVILIDAD_VUELO'))
			txtCrmov_numero_vuelo3.setValue(new ManagerCookies().read('MOVILIDAD_VUELO'));
		if(new ManagerCookies().read('MOVILIDAD_MODO'))
			cbxCtreg_tipo_operacion3.setValue(new ManagerCookies().read('MOVILIDAD_MODO'));
		if(new ManagerCookies().read('MOVILIDAD_AEROLINEA'))
			cbxCraln_codigo3.setValue(new ManagerCookies().read('MOVILIDAD_AEROLINEA'));
		cbxCarpt_codigo3.setValue(tmpUserSession.getUserData().CARPT_CODIGO);
	}

    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_movilidad_residentes.
     * @returns ventana winFrmCgg_res_movilidad_residentes.
     * @base FrmCgg_res_movilidad_residentes.prototype.show
     */
    this.getWindow = function() {
        return winFrmCgg_res_movilidad_residentes;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_movilidad_residentes.
     * @base FrmCgg_res_movilidad_residentes.prototype.loadData
     */
    this.loadData = function() {
        cargarCgg_res_movilidadCtrls();
    }
	
	this.setUserSession = function(inUserSession){
		tmpUserSession = inUserSession;
	}
	
}
FrmCgg_res_movilidad_residentes.prototype.setUserSession = function(inUserSession){
    this.setUserSession(inUserSession);
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_movilidad_residentes desde una instancia.
 */
FrmCgg_res_movilidad_residentes.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_movilidad_residentes_salida desde una instancia.
 */
FrmCgg_res_movilidad_residentes.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_movilidad_residentes_salida,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_movilidad_residentes.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_movilidad_residentes_salida desde una instancia.
 */
FrmCgg_res_movilidad_residentes.prototype.loadData = function(){
    this.loadData();
}
