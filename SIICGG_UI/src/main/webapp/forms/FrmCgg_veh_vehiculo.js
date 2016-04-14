/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_veh_vehiculo.
* @param {String} IN_SENTENCIA_CGG_VEH_VEHICULO Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_VEH_VEHICULO Registro de datos de la tabla Cgg_veh_vehiculo.
* @constructor
* @base FrmListadoCgg_veh_vehiculo
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_veh_vehiculo(IN_SENTENCIA_CGG_VEH_VEHICULO,IN_RECORD_CGG_VEH_VEHICULO){
	var inSentenciaCgg_veh_vehiculo = IN_SENTENCIA_CGG_VEH_VEHICULO;
	var inRecordCgg_veh_vehiculo=IN_RECORD_CGG_VEH_VEHICULO;
	var urlCgg_veh_vehiculo=URL_WS+"Cgg_veh_vehiculo";
	var tituloCgg_veh_vehiculo='Veh\u00edculo';
	var descCgg_veh_vehiculo='El formulario permite administrar la informaci\u00f3n del veh\u00edculo.';
	var isEdit = false;
	var tmpDatos = new Array();
	var tmpRemMotores = new Array();
	var tmpUserSession = new UserSession();
	var tmpFrmListMotores = new FrmListadoCgg_veh_motor();
	var grdCgg_veh_vehiculo_motor = tmpFrmListMotores.getGridPanel();
	var myStoreColor;
	grdCgg_veh_vehiculo_motor.getTopToolbar().setVisible(false);
	grdCgg_veh_vehiculo_motor.getBottomToolbar().setVisible(false);
	/**
	* Ext.form.TextField IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	*/
	var txtCvveh_codigo = new Ext.form.TextField({
			id:'txtCvveh_codigo',
			name:'txtCvveh_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			value:"KEYGEN",
			hidden:true,
			hideLabel:true
	});
	/**
	* Ext.form.TextField IDENTIFICADOR UNICO DE REGISTRO DE MARCA
	*/
	var txtVehCvmrc_codigo = new Ext.form.TextField({
			id:'txtVehCvmrc_codigo',
			name:'txtVehCvmrc_codigo',
			fieldLabel :'Marca',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICADOR UNICO DE REGISTRO DE MARCA
	*/
	var btnCvmrc_codigoCgg_veh_vehiculo = new Ext.Button({
			id:'btnCvmrc_codigoCgg_veh_vehiculo',
			iconCls:'iconBuscar',
			listeners:{
				click:function(){
					var tmpFLCgg_veh_marca = new FrmListadoCgg_veh_marca();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_veh_marca.getStore(),tmpFLCgg_veh_marca.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord){
								tmpDatos['MARCA'] = tmpRecord.get('CVMRC_CODIGO');
								txtVehCvmrc_codigo.setValue(tmpRecord.get('CVMRC_NOMBRE'));
							}
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.ComboBox REGISTRO DE COLOR 1
	*/
	var cbxCvclr_codigo = new Ext.form.ComboBox({
        id:'cbxCvclr_codigo',
        fieldLabel :'Color 1',
        displayField:'CVCLR_NOMBRE',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
		editable:false,
        triggerAction:'all',
        emptyText:'Seleccione el color ...',
        selectOnFocus:true,
        valueField:'CVCLR_CODIGO',
        anchor:'98%',
		allowBlank:false
    });
	/**
	* Ext.form.TextField IDENTIFICADOR UNICO DE REGISTRO DE CATEGORIA.
	*/
	var txtCvctg_codigo = new Ext.form.TextField({
			id:'txtCvctg_codigo',
			name:'txtCvctg_codigo',
			fieldLabel :'Categor\u00eda',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICADOR UNICO DE REGISTRO DE CATEGORIA.
	*/
	var btnCvctg_codigoCgg_veh_vehiculo = new Ext.Button({
			id:'btnCvctg_codigoCgg_veh_vehiculo',
			iconCls:'iconBuscar',
			listeners:{
				click:function(){
					var tmpFLCgg_veh_categoria = new FrmListadoCgg_veh_categoria();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_veh_categoria.getStore(),tmpFLCgg_veh_categoria.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord){
								tmpDatos['CATEGORIA'] = tmpRecord.get('CVCTG_CODIGO');
								txtCvctg_codigo.setValue(tmpRecord.get('CVCTG_NOMBRE'));
							}
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
	*/
	var txtCsctp_codigo = new Ext.form.TextField({
			id:'txtCsctp_codigo',
			name:'txtCsctp_codigo',
			fieldLabel :'Sct. productivo',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
	*/
	var btnCsctp_codigoCgg_veh_vehiculo = new Ext.Button({
			id:'btnCsctp_codigoCgg_veh_vehiculo',
			iconCls:'iconBuscar',
			listeners:{
				click:function(){
					var tmpFLCgg_sector_productivo = new FrmListadoCgg_sector_productivo();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_sector_productivo.getStore(),tmpFLCgg_sector_productivo.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord){
								tmpDatos['PRODUCTIVO'] = tmpRecord.get('CSCTP_CODIGO');
								txtCsctp_codigo.setValue(tmpRecord.get('CSCTP_NOMBRE'));
							}
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR
	*/
	var txtCvsct_codigo = new Ext.form.TextField({
			id:'txtCvsct_codigo',
			name:'txtCvsct_codigo',
			fieldLabel :'Sector',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR
	*/
	var btnCvsct_codigoCgg_veh_vehiculo = new Ext.Button({
			id:'btnCvsct_codigoCgg_veh_vehiculo',
			iconCls:'iconBuscar',
			listeners:{
				click:function(){
					var tmpFLCgg_veh_sector = new FrmListadoCgg_veh_sector();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_veh_sector.getStore(),tmpFLCgg_veh_sector.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord){
								tmpDatos['SECTOR'] = tmpRecord.get('CVSCT_CODIGO');
								txtCvsct_codigo.setValue(tmpRecord.get('CVSCT_NOMBRE'));
							}
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.ComboBox REGISTRO DE COLOR 2
	*/
	var cbxCgg_cvclr_codigo = new Ext.form.ComboBox({
        id:'Cgg_cvclr_codigo',
        fieldLabel :'Color 2',
        displayField:'CVCLR_NOMBRE',
        typeAhead: true,
        mode: 'local',
		editable:false,
        triggerAction:'all',
        emptyText:'Seleccione el color ...',
        valueField:'CVCLR_CODIGO',
        anchor:'98%'
    });
	/**
	* Ext.form.TextField NOMBRE DE LA EMBARCACION (APLICA SOLO A VEHICULOS MARITIMOS)
	*/
	var txtCvveh_nombre = new Ext.form.TextField({
			id:'txtCvveh_nombre',
			name:'txtCvveh_nombre',
			fieldLabel :'Nombre',
			anchor:'98%'
	});
	/**
	* Ext.form.TextField NOMBRE DEL MODELO DEL VEHICULO
	*/
	var txtCvveh_modelo = new Ext.form.TextField({
			id:'txtCvveh_modelo',
			name:'txtCvveh_modelo',
			fieldLabel :'Modelo',
			anchor:'98%',
			maxLength:50
	});
	/**
	* Ext.form.NumberField TIPO DE VEHICULO
	0 - TERRESTRE
	1 - MARITIMO
	2 - AEREO
	*/
	var cbxTipoVehiculo = new Ext.form.ComboBox({
		fieldLabel :'Tipo',
		typeAhead: true,
		triggerAction: 'all',
		lazyRender:true,
		forceSelection:true,
		editable:false,
		mode: 'local',
		anchor:'98%',
		emptyText:'Seleccione el tipo ...',
		store:dsTipoVehiculo,
		listeners:{
			select:function(inSource, inRecord, inIndex){
				pnlTerrestres.setDisabled(inIndex!=0);
				pnlMaritimos.setDisabled(inIndex!=1);
			}
		}
	});
	cbxTipoVehiculo.setValue(0);
	/**
	* Ext.form.NumberField ANIO DE FABRICACION DEL VEHICULO
	*/
	var numCvveh_anio_produccion = new Ext.form.NumberField({
			id:'numCvveh_anio_produccion',
			name:'numCvveh_anio_produccion',
			fieldLabel :'A\u00f1o de fab.',
			allowBlank :false,
			disabled :false,
			anchor:'98%'
	});
	/**
	* Ext.form.TextField SERIE DEL CHASIS DEL VEHICULO
	*/
	var txtCvveh_chasis = new Ext.form.TextField({
			id:'txtCvveh_chasis',
			name:'txtCvveh_chasis',
			fieldLabel :'Chasis',
			anchor:'98%'
	});
	/**
	* Ext.form.TextField PLACA DEL VEHICULO
	*/
	var txtCvveh_placa = new Ext.form.TextField({
			id:'txtCvveh_placa',
			name:'txtCvveh_placa',
			fieldLabel :'Placa',
			anchor:'98%'
	});
	/**
	* Ext.form.DateField FECHA DE INICIO DEL ESTADO
	*/
	var dtCvsvh_fecha = new Ext.form.DateField({
			id:'dtCvsvh_fecha',
			name:'dtCvsvh_fecha',
			fieldLabel :'Fecha',
			allowBlank :false,
			format :'d/m/Y',
			value:new Date()
	});
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_veh_vehiculo_estado.
	*/
	var cmCgg_veh_vehiculo_estado = new Ext.grid.ColumnModel([
			{dataIndex:'ESTADO',header:'Estado',width:200,sortable:true},
			{dataIndex:'CVSVH_FECHA',header:'Fecha',width:80,sortable:true,renderer:truncDate,editor:dtCvsvh_fecha},
	{dataIndex:'CVSVH_OBSERVACION',header:'Observaci\u00f3n',width:250,sortable:true,editor:new Ext.form.TextField({})}]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_veh_vehiculo_estado por un campo especifico.
	*/
	var gsCgg_veh_vehiculo_estado = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_veh_vehiculo_estado",
					method:"selectCGG_VEH_VEHICULO",
					pagin:false
			}),
			remoteSort:false,
			reader:new Ext.data.JsonReader({
					id:'CVSVH_CODIGO'
			},[
				{name:'CVSVH_CODIGO'},
				{name:'CVVEH_CODIGO'},
				{name:'CVSVM_CODIGO'},
				{name:'ESTADO'},
				{name:'CVSVH_FECHA'},
				{name:'CVSVH_OBSERVACION'}
			]),
			sortInfo:{field: 'CVVEH_CODIGO', direction: 'ASC'},
			baseParams:{format:'JSON',inCvveh_codigo:''}
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_veh_vehiculo_estado en un formato tabular de filas y columnas.
	*/
	var grdCgg_veh_vehiculo_estado = new Ext.grid.EditorGridPanel({
		title:'Estado',
			cm:cmCgg_veh_vehiculo_estado,
			store:gsCgg_veh_vehiculo_estado,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
			tbar:[{iconCls:'iconNuevo',handler:function(){
					var tmpFLCgg_veh_estado_vhmt = new FrmListadoCgg_veh_estado_vhmt();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_veh_estado_vhmt.getStore(),tmpFLCgg_veh_estado_vhmt.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord){
								var tmpRecordEstado = gsCgg_veh_vehiculo_estado.recordType;
								gsCgg_veh_vehiculo_estado.insert(0, new tmpRecordEstado({
									CVSVH_CODIGO:'KEYGEN',
									CVVEH_CODIGO:txtCvveh_codigo.getValue(),
									CVSVM_CODIGO:tmpRecord.get('CVSVM_CODIGO'),
									ESTADO:tmpRecord.get('CVSVM_NOMBRE'),
									CVSVH_FECHA:new Date(),
									CVSVH_OBSERVACION:''
								}));
							}
					});
					objBusqueda.show();
				}}],
		listeners:{
			beforeedit:function(inObject){
					if(inObject.record.get('CVSVH_CODIGO') != 'KEYGEN')
						return false;
				}
	}});
	/**
	* FOTO DEL VEHICULO
	*/
	var filCvveh_foto = new Ext.form.FileUploadField({
			id:'filCvveh_foto',
			name:'filCvveh_foto',
			fieldLabel :'Foto',
			anchor:'98%',
			disabled:false,
			buttonCfg: {
				text: '',
				iconCls: 'iconAdjunto'
			}
	});
	/**
	* Ext.form.NumberField INFORMACION DE VEHICULOS MARITIMOS (METROS)
	*/
	var numCvveh_eslora = new Ext.form.NumberField({
			id:'numCvveh_eslora',
			name:'numCvveh_eslora',
			fieldLabel :'Eslora',
			disabled :false,
			anchor:'98%'
	});
	/**
	* Ext.form.NumberField INFORMACION DE VEHICULOS MARITIMOS (METROS)
	*/
	var numCvveh_manga = new Ext.form.NumberField({
			id:'numCvveh_manga',
			name:'numCvveh_manga',
			fieldLabel :'Manga',
			anchor:'98%',
			disabled :false
	});
	/**
	* Ext.form.NumberField INFORMACION DE VEHICULOS MARITIMOS (METROS)
	*/
	var numCvveh_puntal = new Ext.form.NumberField({
			id:'numCvveh_puntal',
			name:'numCvveh_puntal',
			fieldLabel :'Puntal',
			anchor:'98%',
			disabled :false
	});
	/**
	* Ext.form.TextField MATERIAL DE CONSTRUCCION PARA VEHICULOS MARITIMOS
	*/
	var txtCvveh_material = new Ext.form.TextField({
			id:'txtCvveh_material',
			name:'txtCvveh_material',
			fieldLabel :'Material',
			anchor:'98%'
	});
	/**
	* Ext.form.TextArea INFORMACION ADICIONAL
	*/
	var txtCvveh_observacion = new Ext.form.TextArea({
			title:'Observaci\u00f3n',
			id:'txtCvveh_observacion',
			name:'txtCvveh_observacion',
			fieldLabel :'Observaci\u00f3n',
			width:'90%'
	});
	/**
	* Boton que permite almacenar la informacion de la ventana winFrmCgg_veh_vehiculo
	*/
	var btnGuardarCgg_veh_vehiculo = new Ext.Button({
			id:'btnGuardarCgg_veh_vehiculo',
			text:'Guardar',
			iconCls:'iconGuardar',
			listeners:{
				click:function(){
					if(!validarFormulario())
						return;
					if (!pnlCgg_veh_vehiculo.getForm().isValid()){
						return;
					}
					var tmpJSONEstados = '[';
					for(i = 0; i < gsCgg_veh_vehiculo_estado.getCount(); i++){
						if(gsCgg_veh_vehiculo_estado.getAt(i).get('CVSVH_CODIGO') == 'KEYGEN'){
							if(tmpJSONEstados.length > 1)
								tmpJSONEstados += ',';
							tmpJSONEstados = tmpJSONEstados + '{CVSVM_CODIGO:"'+gsCgg_veh_vehiculo_estado.getAt(i).get('CVSVM_CODIGO')+'",CVSVH_FECHA:"'+gsCgg_veh_vehiculo_estado.getAt(i).get('CVSVH_FECHA').format('Y-m-d H:i:s')+'",CVSVH_OBSERVACION:"'+gsCgg_veh_vehiculo_estado.getAt(i).get('CVSVH_OBSERVACION')+'"}';
						}
					}
					tmpJSONEstados += ']';
					var tmpJSONMotores = '[]';
					tmpJSONMotores += ']';
					pnlCgg_veh_vehiculo.getEl().mask('Espere un momento por favor.<br>El tiempo de respuesta depender\u00E1 del tama\u00F1o de sus archivos adjuntos.', 'x-mask-loading');
					pnlCgg_veh_vehiculo.getForm().submit({
							url: URL_WS+"Cgg_veh_vehiculoSRV",
							success: function(fp, o){
								Ext.Msg.show({
										title:tituloCgg_veh_vehiculo,
										msg: 'La informaci\u00f3n del veh\u00edculo ha sido almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
								});
								winFrmCgg_veh_vehiculo.close();
							},
							failure:function(o, inO){
								Ext.Msg.show({
										title:tituloCgg_veh_vehiculo,
										msg: 'La informaci\u00f3n del veh\u00edculo no ha podido ser almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
								});
								pnlCgg_veh_vehiculo.getEl().unmask();
							},
							params:{
								cvmrc_codigo:tmpDatos['MARCA'],
								cvclr_codigo:cbxCvclr_codigo.getValue(),
								cvctg_codigo:tmpDatos['CATEGORIA'],
								csctp_codigo:tmpDatos['PRODUCTIVO'],
								cvsct_codigo:tmpDatos['SECTOR'],
								cgg_cvclr_codigo:cbxCgg_cvclr_codigo.getValue(),
								cvveh_ingreso:chkCvveh_ingreso.getValue(),
								cvveh_salio:chkCvveh_salio.getValue(),
								cvveh_fecha_ingreso:(dtCvveh_fecha_ingreso.getValue()?dtCvveh_fecha_ingreso.getValue().format('Y-m-d H:i:s'):''),
								cvveh_tipo_ingreso:cbxCvveh_tipo_ingreso.getValue(),
								cvveh_fecha_salida:(dtCvveh_fecha_salida.getValue()?dtCvveh_fecha_salida.getValue().format('Y-m-d H:i:s'):''),
								request:IN_SENTENCIA_CGG_VEH_VEHICULO,
								cvveh_tipo:cbxTipoVehiculo.getValue(),
								numCvveh_tiempo_estadia:numCvveh_tiempo_estadia.getValue(),
								estados:tmpJSONEstados,
								motores:tmpJSONMotores
							}
					});
			}}
	});
	/**
	* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_veh_vehiculo.
	*/
	var btnCancelarCgg_veh_vehiculo = new Ext.Button({
			id:'btnCancelarCgg_veh_vehiculo',
			text:'Cancelar',
			iconCls:'iconCancelar',
			listeners:{
				click:function(){
					pnlCgg_veh_vehiculo.getForm().reset();
			}}
	});
	/**
	* Boton que permite cerrar la ventana winFrmCgg_veh_vehiculo.
	*/
	var btnCerrarCgg_veh_vehiculo = new Ext.Button({
			id:'btnCerrarCgg_veh_vehiculo',
			text:'Cerrar',
			iconCls:'iconCerrar',
			listeners:{
				click:function(){
					winFrmCgg_veh_vehiculo.close();
			}}
	});
	var btnAddVehiculoMotor = new Ext.Button({
			id:'btnAddVehiculoMotor',
			iconCls:'iconNuevo',
			listeners:{
				click:function(){
					tmpFrmListMotores.addMotor();
			}}
	});
	var btnEditVehiculoMotor = new Ext.Button({
			id:'btnEditVehiculoMotor',
			iconCls:'iconEditar',
			listeners:{
				click:function(){
					tmpFrmListMotores.editMotor();
				}
			}
	});
	var btnRemVehiculoMotor = new Ext.Button({
			id:'btnRemVehiculoMotor',
			iconCls:'iconEliminar',
			listeners:{
				click:function(){
					tmpRemMotores.push(grdCgg_veh_vehiculo_motor.getSelectionModel().getSelected().get('CVMTR_CODIGO'));
					grdCgg_veh_vehiculo_motor.getStore().remove(grdCgg_veh_vehiculo_motor.getSelectionModel().getSelected());
					
			}}
	});
	
	var cmVehiculoAdjunto = new Ext.grid.ColumnModel([
        {dataIndex:'CRADJ_CODIGO',header:'Codigo',width:150,sortable:true,hideable:false,hidden:true},
        {dataIndex:'CRADJ_NOMBRE_ADJUNTO',header:'Nombre adjunto',width:300,sortable:true}
    ]);

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_adjunto por un campo especifico.
     */
    var gsVehiculoAdjunto = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_adjunto",
            method:"selectCGG_VEH_VEHICULO",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
            id:'CRADJ_CODIGO'
        },[{name:'CRADJ_CODIGO'},
			{name:'CRADJ_NOMBRE_ADJUNTO'}
        ]),
        baseParams:{
            inCvveh_codigo :'',
            format:"JSON"
        }
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_adjunto en un formato tabular de filas y columnas.
     */
    var grdVehiculoAdjunto = new Ext.grid.EditorGridPanel({
    	title:'Adjuntos',
        id: 'grdVehiculoAdjunto',
        cm: cmVehiculoAdjunto,
        height:250,
        store:gsVehiculoAdjunto,
        sm: new Ext.grid.RowSelectionModel({
            singleSelect: true,
            moveEditorOnEnter: false
        }),
        loadMask: {msg: "Cargando..."},
        trackMouseOver: true,
        tbar: [{
            id: 'btnAddVehiculoAdjunto',
            iconCls: 'iconNuevo',
            handler: function(){
                var coleccion = {};
                var datos = "<div width='100%'><INPUT TYPE='file' id='ful" + grdVehiculoAdjunto.getStore().getCount() + "' size='25' name='inVehiculoAdjuntos'/></div> ";
                coleccion['CRADJ_CODIGO'] =  "KEYGEN";
                coleccion['CRADJ_NOMBRE_ADJUNTO'] = datos;
                var recordAdjunto = new Ext.data.Record(coleccion, grdVehiculoAdjunto.getStore().getCount());
                grdVehiculoAdjunto.getStore().add(recordAdjunto);
            }
        },{
            id:'btnVerVehiculoAdjunto',
            iconCls:'iconVer',
            listeners:{
                click:function(){
                    var r=grdVehiculoAdjunto.getSelectionModel().getSelected();
                    if(r)
                        window.open(URL_DOC_VIEWER+'?table=cgg_res_adjunto&keyc=cradj_codigo&keyv='+r.get('CRADJ_CODIGO')+'&column=cradj_archivo_adjunto&fn='+r.get('CRADJ_NOMBRE_ADJUNTO')+'&request=view');
                }
            }

        },{id:'btnDescargarVehiculoAdjunto',
            iconCls:'iconDescargar',
            listeners:{
                click:function(){
                    var r=grdVehiculoAdjunto.getSelectionModel().getSelected();
                    if(r)
                        window.open(URL_DOC_VIEWER+'?table=cgg_res_adjunto&keyc=cradj_codigo&keyv='+r.get('CRADJ_CODIGO')+'&column=cradj_archivo_adjunto&fn='+r.get('CRADJ_NOMBRE_ADJUNTO')+'&request=download');
                }
            }
        }]

    });
	/**
	* Ext.form.Checkbox IDENTIFICA SI EL VEHICULO ESTA DENTRO DE LA PROVINCIA
	*/
	var chkCvveh_ingreso = new Ext.form.Checkbox({
			id:'chkCvveh_ingreso',
			name:'chkCvveh_ingreso',
			fieldLabel :'Ingreso',
			allowBlank :false,
			checked:false,
			submitValue:false,
			listeners:{
				check:function(inObject, inChecked){
					dtCvveh_fecha_ingreso.setDisabled(!inChecked);
					dtCvveh_fecha_ingreso.maxValue = CURRENT_DATE;
				}
			}
	});
	/**
	* Ext.form.DateField FECHA CUANDO EL VEHICULO INGRESO A LA PROVINCIA.
	*/
	var dtCvveh_fecha_ingreso = new Ext.form.DateField({
			id:'dtCvveh_fecha_ingreso',
			name:'dtCvveh_fecha_ingreso',
			fieldLabel :'Fecha de ingreso',
			allowBlank :false,
			submitValue:false,
			format :'d/m/Y',
			value:new Date(),
			disabled:true
	});
	/**
	* Ext.form.NumberField MODALIDAD DE INGRESO DE VEHICULO
	0 - PERMANENTE
	1 - TEMPORAL
	*/
	var cbxCvveh_tipo_ingreso = new Ext.form.ComboBox({
		fieldLabel :'Tipo',
		typeAhead: true,
		triggerAction: 'all',
		lazyRender:true,
		forceSelection:true,
		disabled:true,
		submitValue:false,
		editable:false,
		mode: 'local',
		anchor:'98%',
		emptyText:'Seleccione el tipo ...',
		store:dsTipoIngresoVehiculo,
		listeners:{
			select:function(inSource, inRecord, inIndex){
				numCvveh_tiempo_estadia.setDisabled(inIndex==0);
			}
		}
	});
	/**
	* Ext.form.NumberField PERIODO DE TIEMPO EN DIAS DE PERMANENCIA DEL VEHICULO DENTRO DE LA PROVINCIA
	*/
	var numCvveh_tiempo_estadia = new Ext.form.NumberField({
			id:'numCvveh_tiempo_estadia',
			name:'numCvveh_tiempo_estadia',
			fieldLabel :'Tiempo de estadia',
			disabled :true,
			submitValue:false
	});
	/**
	* Ext.form.Checkbox SI EL VALIO NO ESTA DENTRO DE LA PROVINCIA
	*/
	var chkCvveh_salio = new Ext.form.Checkbox({
			id:'chkCvveh_salio',
			name:'chkCvveh_salio',
			fieldLabel :'Salida',
			allowBlank :false,
			submitValue:false,
			checked:false,
			listeners:{
				check:function(inObject, inChecked){
					dtCvveh_fecha_salida.setDisabled(!inChecked);
				}
			}
	});
	/**
	* Ext.form.DateField FECHA CUANDO EL VEHICULO SALIO
	*/
	var dtCvveh_fecha_salida = new Ext.form.DateField({
			id:'dtCvveh_fecha_salida',
			name:'dtCvveh_fecha_salida',
			fieldLabel :'Fecha de salida',
			allowBlank :false,
			submitValue:false,
			format :'d/m/Y',
			disabled:true,
			value:new Date()
	});
	var pnlVehGeneral = new Ext.form.FieldSet({
		region:'center',
		title:'General',
		items:[txtCvveh_codigo,
			cbxTipoVehiculo,
			{xtype:'panel',layout:'column',items:[
				{columnWidth:.92,layout:'form',items:[txtVehCvmrc_codigo]},
				{columnWidth:.08,layout:'form',items:[btnCvmrc_codigoCgg_veh_vehiculo]}]},
			{xtype:'panel',layout:'column',items:[
				{columnWidth:.92,layout:'form',items:[txtCvctg_codigo]},
				{columnWidth:.08,layout:'form',items:[btnCvctg_codigoCgg_veh_vehiculo]}]},
			{xtype:'panel',layout:'column',items:[
				{columnWidth:.92,layout:'form',items:[txtCsctp_codigo]},
				{columnWidth:.08,layout:'form',items:[btnCsctp_codigoCgg_veh_vehiculo]}]},
			{xtype:'panel',layout:'column',items:[
				{columnWidth:.92,layout:'form',items:[txtCvsct_codigo]},
				{columnWidth:.08,layout:'form',items:[btnCvsct_codigoCgg_veh_vehiculo]}]},
			numCvveh_anio_produccion,
			cbxCvclr_codigo,
			cbxCgg_cvclr_codigo
		]
	});
	var pnlTerrestres = new Ext.Panel({
		frame:true,
		layout:'form',
		title:'Terrestre',
		items:[txtCvveh_modelo,txtCvveh_chasis,txtCvveh_placa]
	});
	var pnlMaritimos = new Ext.Panel({
		frame:true,
		layout:'form',
		disabled:true,
		title:'Mar\u00edtimo',
		items:[txtCvveh_nombre,
			numCvveh_eslora,
			numCvveh_manga,
			numCvveh_puntal,
			txtCvveh_material]
	});
	var pnlPermanencia = new Ext.Panel({
		title:'Permanencia',
		frame:true,
		layout:'form',
		items:[cbxCvveh_tipo_ingreso,numCvveh_tiempo_estadia,
			{xtype:'panel',layout:'column',items:[
				{columnWidth:.5,layout:'form',items:[chkCvveh_ingreso]},
				{columnWidth:.5,layout:'form',items:[dtCvveh_fecha_ingreso]}]},
			{xtype:'panel',layout:'column',items:[
				{columnWidth:.5,layout:'form',items:[chkCvveh_salio]},
				{columnWidth:.5,layout:'form',items:[dtCvveh_fecha_salida]}]}]
	});
	var pnlVehMotor = new Ext.Panel({
		title:'Motores',
		layout:'border',
		disabled:true,
		tbar:[btnAddVehiculoMotor, btnEditVehiculoMotor],
		items:[grdCgg_veh_vehiculo_motor]
	});
	var tbTiposVehiculo = new Ext.TabPanel({
		region:'center',
		activeTab:0,
		height:180,
		items:[pnlPermanencia,grdCgg_veh_vehiculo_estado,pnlTerrestres,pnlMaritimos,pnlVehMotor, grdVehiculoAdjunto,txtCvveh_observacion]
	});
	var pnlVehiculoFoto = new Ext.Panel({
		id:'pnlVehiculoFoto',
		title:'Foto',
		region:'center',
		border:true,
		width:216,
		height:216,
		frame:true,
		html:'<img id="ftFotoVehiculo" width="204" height="181" src="resources/images/48x48/auto.png" />',
		style:{marginBottom:'6px'}
	});
	/**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_veh_vehiculo.
	*/
	var pnlCgg_veh_vehiculo = new Ext.form.FormPanel({
			frame:true,
			labelWidth :100,
			layout:'border',
			region:'center',
			fileUpload:true,
			items:[{xtype:'panel',layout:'column',height:250,region:'north',items:[
				{columnWidth:.6,layout:'form',items:[pnlVehGeneral]},
				{columnWidth:.4,layout:'form',labelWidth:30,style:{marginLeft:'6px'},items:[pnlVehiculoFoto,filCvveh_foto]}]},
				tbTiposVehiculo
				]
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_veh_vehiculo.
	*/
	var winFrmCgg_veh_vehiculo = new Ext.Window({
			id:'winFrmCgg_veh_vehiculo',
			title:tituloCgg_veh_vehiculo,
			width:600,
			minWidth:400,
			height:560,
			maximizable:false,
			minimizable:true,
			constrain:true,
			layout:'border',
			modal:true,
			tbar:getPanelTitulo(tituloCgg_veh_vehiculo,descCgg_veh_vehiculo),
			items:[pnlCgg_veh_vehiculo],
			bbar:[btnGuardarCgg_veh_vehiculo,btnCancelarCgg_veh_vehiculo,'->',btnCerrarCgg_veh_vehiculo],
			listeners:{
				show:function(){
					function CallBackFotoVehiculo(inResponse){
						if(inResponse.length > 0)
							document.getElementById('ftFotoVehiculo').src = 'data:image/jpg;base64,'+inResponse;
					}
					
					for (i = 0; i < tbTiposVehiculo.items.length; i++) {
						tbTiposVehiculo.setActiveTab(i);
					}
					tbTiposVehiculo.setActiveTab(0);
					
					var param = new SOAPClientParameters();			
					param.add('inCvveh_codigo',txtCvveh_codigo.getValue());
					SOAPClient.invoke(urlCgg_veh_vehiculo,'selectFoto',param, true, CallBackFotoVehiculo);
				}
			}
	});
	applyGrants(pnlVehMotor.getTopToolbar());
	/**
	* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_veh_vehiculo.
	*/
	function cargarCgg_veh_vehiculoCtrls(){
		if(inRecordCgg_veh_vehiculo){
			tmpDatos['MARCA'] = inRecordCgg_veh_vehiculo.get('CVMRC_CODIGO');
			tmpDatos['CATEGORIA'] = inRecordCgg_veh_vehiculo.get('CVCTG_CODIGO');
			tmpDatos['PRODUCTIVO'] = inRecordCgg_veh_vehiculo.get('CSCTP_CODIGO');
			tmpDatos['SECTOR'] = inRecordCgg_veh_vehiculo.get('CVSCT_CODIGO');
			txtCvveh_codigo.setValue(inRecordCgg_veh_vehiculo.get('CVVEH_CODIGO'));
			txtVehCvmrc_codigo.setValue(inRecordCgg_veh_vehiculo.get('MARCA'));
			cbxCvclr_codigo.setValue(inRecordCgg_veh_vehiculo.get('CVCLR_CODIGO'));
			txtCvctg_codigo.setValue(inRecordCgg_veh_vehiculo.get('CATEGORIA'));
			txtCsctp_codigo.setValue(inRecordCgg_veh_vehiculo.get('PRODUCTIVO'));
			txtCvsct_codigo.setValue(inRecordCgg_veh_vehiculo.get('SECTOR'));
			cbxCgg_cvclr_codigo.setValue(inRecordCgg_veh_vehiculo.get('CGG_CVCLR_CODIGO'));
			txtCvveh_nombre.setValue(inRecordCgg_veh_vehiculo.get('CVVEH_NOMBRE'));
			txtCvveh_modelo.setValue(inRecordCgg_veh_vehiculo.get('CVVEH_MODELO'));
			cbxTipoVehiculo.setValue(inRecordCgg_veh_vehiculo.get('CVVEH_TIPO'));
			numCvveh_anio_produccion.setValue(inRecordCgg_veh_vehiculo.get('CVVEH_ANIO_PRODUCCION'));
			txtCvveh_chasis.setValue(inRecordCgg_veh_vehiculo.get('CVVEH_CHASIS'));
			txtCvveh_placa.setValue(inRecordCgg_veh_vehiculo.get('CVVEH_PLACA'));
			numCvveh_eslora.setValue(inRecordCgg_veh_vehiculo.get('CVVEH_ESLORA'));
			numCvveh_manga.setValue(inRecordCgg_veh_vehiculo.get('CVVEH_MANGA'));
			numCvveh_puntal.setValue(inRecordCgg_veh_vehiculo.get('CVVEH_PUNTAL'));
			txtCvveh_material.setValue(inRecordCgg_veh_vehiculo.get('CVVEH_MATERIAL'));
			chkCvveh_ingreso.setValue(inRecordCgg_veh_vehiculo.get('CVVEH_INGRESO'));
			dtCvveh_fecha_ingreso.setValue(truncDate(inRecordCgg_veh_vehiculo.get('CVVEH_FECHA_INGRESO')));
			cbxCvveh_tipo_ingreso.setValue(inRecordCgg_veh_vehiculo.get('CVVEH_TIPO_INGRESO'));
			numCvveh_tiempo_estadia.setValue(inRecordCgg_veh_vehiculo.get('CVVEH_TIEMPO_ESTADIA'));
			chkCvveh_salio.setValue(inRecordCgg_veh_vehiculo.get('CVVEH_SALIO'));
			dtCvveh_fecha_salida.setValue(truncDate(inRecordCgg_veh_vehiculo.get('CVVEH_FECHA_SALIDA')));
			txtCvveh_observacion.setValue(inRecordCgg_veh_vehiculo.get('CVVEH_OBSERVACION'));
			isEdit = true;
			gsCgg_veh_vehiculo_estado.reload({params:{
					format:'JSON',
					inCvveh_codigo:inRecordCgg_veh_vehiculo.get('CVVEH_CODIGO')
				}
			});
			grdCgg_veh_vehiculo_motor.getStore().baseParams.inCvveh_codigo = inRecordCgg_veh_vehiculo.get('CVVEH_CODIGO')
			grdCgg_veh_vehiculo_motor.getStore().reload();
			
			gsVehiculoAdjunto.reload({params:{
				format:"JSON",inCvveh_codigo:inRecordCgg_veh_vehiculo.get('CVVEH_CODIGO')
				}
			});
			pnlVehMotor.setDisabled(!isEdit);
	}}
	
	function validarFormulario(){
		var outResult = true;
		if(chkCvveh_ingreso.getValue() && !chkCvveh_ingreso.getValue()){
			chkCvveh_ingreso.markInvalid('Establezca la fecha de ingreso del veh\u00edculo.');
			tbTiposVehiculo.setActiveTab(0);
			outResult = false;
		}
		return outResult;
	}
	
	/**
	* Funcion miembro que devuelve la ventana winFrmCgg_veh_vehiculo.
	* @returns ventana winFrmCgg_veh_vehiculo.
	* @base FrmCgg_veh_vehiculo.prototype.show
	*/
	this.getWindow = function(){
		return winFrmCgg_veh_vehiculo;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmCgg_veh_vehiculo.
	* @base FrmCgg_veh_vehiculo.prototype.loadData
	*/
	this.loadData = function(){
		cargarCgg_veh_vehiculoCtrls();
	}
	
	this.setStoreColor = function(inStoreColor){
		myStoreColor = inStoreColor;
		cbxCgg_cvclr_codigo.store = myStoreColor;
		cbxCvclr_codigo.store = myStoreColor;
	}
}

FrmCgg_veh_vehiculo.prototype.setStoreColor = function(inStoreColor){
	this.setStoreColor(inStoreColor);
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_veh_vehiculo desde una instancia.
*/
FrmCgg_veh_vehiculo.prototype.show = function(){
	this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_veh_vehiculo desde una instancia.
*/
FrmCgg_veh_vehiculo.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_veh_vehiculo,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_veh_vehiculo.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_veh_vehiculo desde una instancia.
*/
FrmCgg_veh_vehiculo.prototype.loadData = function(){
	this.loadData();
}