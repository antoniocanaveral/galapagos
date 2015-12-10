function FrmAdministradorPersonaUsuario(inDesktop){
	var optMenu = 'Control de Residencia/Usuarios';
	var urlCgg_res_persona_contacto=URL_WS+"Cgg_res_persona_contacto";
	var urlListadoCgg_res_carnet = URL_WS + "Cgg_res_carnet";
	var urlListadoAdministradorPersonaUsuario = URL_WS + "Cgg_res_carnet";
    var tituloListadoAdministradorPersonaUsuario = 'Control de usuarios';
    var descListadoAdministradorPersonaUsuario = 'El formulario permite administrar los usuarios asignados a los residentes permanentes y temporales.';
	var tmpPersona;
	var tmpResidencia;
	var tmpCarnet;
	var tmpLocal = false;
	var tmpAdjuntosPersonal;
	var tmpUserSession = new UserSession();
	
	var gsCgg_res_documento_identificacio = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_documento_identificacio",
            method:"selectAll",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
        },[
            {name:'CRDID_CODIGO'},
            {name:'CRDID_DESCRIPCION'
            }
        ]),
        baseParams:{
            format:TypeFormat.JSON
        }
    });
	gsCgg_res_documento_identificacio.load();
	
	var tmpInfoPersona = new Ext.XTemplate(
		'<table width="100%" height="100%" cellpadding="0">'+
		'<tr rowspan="0">'+
			'<td><div class="tituloTemplate">Residencia</div></td>'+
			'<td><div class="itemTemplate">{CRPER_NUMERO_RESIDENCIA}</div></td>'+
			'<td><div class="tituloTemplate"> Tipo:</div></td>'+
			'<td><div class="itemTemplate"><div id="divTipoResidencia"></div></div></td>'+
			'</tr>'+
		'<tr rowspan="0">'+
			'<td><div class="tituloTemplate">Nombres:</div></td>'+
			'<td><div class="itemTemplate">{CRPER_NOMBRES}</div></td>'+
			'<td><div class="tituloTemplate"> Apellidos:</div></td>'+
			'<td><div class="itemTemplate">{CRPER_APELLIDO_PATERNO} {CRPER_APELLIDO_MATERNO}</div></td></tr>'+
		'<tr rowspan="0">'+
			'<td><div class="tituloTemplate">Motivo:</div></td>'+
			'<td colspan="3"><div class="itemTemplate"><div id="divMotivoResidencia"></div></div></td></tr>'+
		'<tr id="trInfoTempAuspiciante" rowspan="0">'+
			'<td><div class="tituloTemplate">Auspiciante:</div></td>'+
			'<td colspan="3"><div class="itemTemplate"><div id="divAuspiciante"></div></div></td></tr>'+
		'<tr id="trInfoTempOcupacion" rowspan="0">'+
			'<td><div class="tituloTemplate">Ocupaci\u00f3n:</div></td>'+
			'<td colspan="3"><div class="itemTemplate"><div id="divOcupacion"></div></div></td></tr>'+
		'</table>',
		{myTipoDoc:function(inTipoDoc){
                for(i = 0; i < tmpStoreTipoDocumento.getTotalCount(); i++){
                    tmpRecord = tmpStoreTipoDocumento.getAt(i);
                    if(tmpRecord.data.CRDID_CODIGO = inTipoDoc)
                        return tmpRecord.data.CRDID_DESCRIPCION
                }
            }
		}
	);
	
	var strPersona = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_persona",
            method:"selectPageLite",
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
            {name:'CRPER_NOMBRES'},
            {name:'CRPER_APELLIDO_PATERNO'},
            {name:'CRPER_APELLIDO_MATERNO'},
            {name:'CRPER_NUM_DOC_IDENTIFIC'},
            {name:'CRPER_FECHA_NACIMIENTO'},
            {name:'CRPER_LUGAR_NACIMIENTO'},
            {name:'CRPER_GENERO'},
            {name:'CRPER_OBSERVACIONES'},
            {name:'CRPER_NUMERO_RESIDENCIA'},
            {name:'CRPER_AUTORIZADO'},
            {name:'CRPER_NUMERO_EXPEDIENTE'}
        ]),
        sortInfo:{
            field: 'CRPER_APELLIDO_PATERNO',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON",
            inCrtst_codigo:TypeResidencia.NINGUNA,
            inCarnet:false,
			inIdentificacion:''
        },
		listeners:{
			load:function(inSource, inRecords, inOptions){
				if(inRecords.length > 0 && tmpLocal){
					tmpPersona = inRecords[0];
					loadPersona(tmpPersona);
					tmpLocal = false;
					winFrmAdministradorPersonaUsuario.getEl().unmask();
				}
			}
		}
    });
	
	var txtAPUCrper_codigo = new Ext.form.TextField({
		id:'txtAPUCrper_codigo',
		anchor:'100%',
		fieldLabel:'Numero de documento',
		listeners:{
			specialkey:function(inSource, inEvent){
				if(inEvent.getKey() == inEvent.ENTER){
					strPersona.baseParams.start = 0;
					strPersona.baseParams.limit = RECORD_PAGE;
					strPersona.baseParams.inCarnet = true;
					strPersona.baseParams.inIdentificacion = txtAPUCrper_codigo.getValue();
					strPersona.reload();
					tmpLocal = true;
					winFrmAdministradorPersonaUsuario.getEl().mask('Cargando datos...', 'x-mask-loading');
				}
			}
		}
	});
	
	var pnlPersona = new Ext.Panel({
		layout:'border',
		frame:true,
		region:'north',
		height:200,
		items:[
				{	xtype:'fieldset',
					title:'Datos personales',
					region:'center',
					layout:'border',
					items:[
						{region:'center',layout:'form',items:[
							{xtype:'panel',layout:'column',items:[
								{layout:'form',labelWidth:140,columnWidth:0.92,items:[txtAPUCrper_codigo]},
								{layout:'form',columnWidth:0.08,items:[{xtype:'button',iconCls:'iconBuscar',handler:function(){
									var tmpTimeout = Ext.Ajax.timeout;
									Ext.Ajax.timeout = 90000;
									var tmpObjPersona = new Persona();
									strPersona.baseParams.inCarnet = true;
									strPersona.baseParams.inIdentificacion = '';
									var objBusqueda = new DlgBusqueda(strPersona, tmpObjPersona.getColumnModel());
									objBusqueda.closeHandler(function () {
										tmpCarnet = false;
										Ext.Ajax.timeout = tmpTimeout;
										tmpPersona = objBusqueda.getSelectedRow();
										if (tmpPersona) {
											loadPersona(tmpPersona);
										}
									});
									objBusqueda.show();
								}}]}
							]},
							{xtype:'panel', height:130,html:'<div id="divAPUPersona"></div>'}
						]},
						{region:'east',width:138,layout:'form',items:[{xtype:'panel',html:'<img id="imgFotoPersonaAPU" height="128" width="128" src="resources/images/male_avatar.jpeg"/>'}]}
				]}
		]
	});
	
	function loadPersona(inPersona){
		function CallBackResidencia(inResponse){
			if(inResponse.length == 0){
				Ext.MessageBox.alert(tituloListadoAdministradorPersonaUsuario, 'La persona seleccionada no tiene una residencia vigente.');
				return;
			}
			//btnNuevoCgg_res_carnet.setDisabled(false);
			tmpResidencia = Ext.util.JSON.decode(inResponse);
			
			if(tmpResidencia.CRRSD_MODALIDAD == 0){
				document.getElementById('divTipoResidencia').innerHTML = "Permanente";
				document.getElementById('trInfoTempAuspiciante').style.display = 'none';
				document.getElementById('trInfoTempOcupacion').style.display = 'none';
				
			}else if(tmpResidencia.CRRSD_MODALIDAD == 1){
				document.getElementById('divTipoResidencia').innerHTML = "Temporal";
				document.getElementById('divAuspiciante').innerHTML = tmpResidencia.AUSPICIANTE;
				document.getElementById('divOcupacion').innerHTML = tmpResidencia.OCUPACION;
			}
			document.getElementById('divMotivoResidencia').innerHTML = tmpResidencia.MOTIVO;
		}
		
		function CallbackAdjuntoPersonal(inResponse){
			tmpAdjuntosPersonal = Ext.util.JSON.decode(inResponse);
			if(tmpAdjuntosPersonal[0].CRPER_FOTO){
				var tmpImgFoto = document.getElementById("imgFotoPersonaAPU");
				tmpImgFoto.src = 'data:image/jpg;base64,'+tmpAdjuntosPersonal[0].CRPER_FOTO;
			}
			
		}
		gsCgg_res_persona_contacto.baseParams.inCrper_codigo = tmpPersona.data.CRPER_CODIGO;
		gsCgg_res_persona_contacto.reload();
		
		gsCgg_usuario.baseParams.start = 0;
		gsCgg_usuario.baseParams.limit = 1000;
		gsCgg_usuario.baseParams.inCrper_codigo = tmpPersona.data.CRPER_CODIGO;
		gsCgg_usuario.reload();
		
		document.getElementById('divAPUPersona').innerHTML =tmpInfoPersona.apply(inPersona.json);
		
		txtAPUCrper_codigo.setValue(inPersona.get('CRPER_NUM_DOC_IDENTIFIC'));
		
		var param = new SOAPClientParameters();
		param.add('inCrper_codigo', inPersona.get('CRPER_CODIGO'));
		param.add('format', TypeFormat.JSON);
		SOAPClient.invoke(urlListadoCgg_res_carnet, "selectResidencia", param, true, CallBackResidencia);
		
		var param = new SOAPClientParameters();
		param.add('inCrper_codigo', inPersona.get('CRPER_CODIGO'));
		param.add('format', TypeFormat.JSON);
		SOAPClient.invoke(URL_WS+'Cgg_res_persona', "selectAdjuntosIdentificacionById", param, true, CallbackAdjuntoPersonal);
	
	}
	
	var btnAPUCerrar = new Ext.Button({
		id:'btnAPUCerrar',
		text:'Cerrar',
		iconCls:'iconSalir',
		listeners:{
			click:function(){
				winFrmAdministradorPersonaUsuario.close();
			}
		}
	});
	
	/**
     * Ext.ux.grid.RowEditor Edito de filas personalizado para utilización en el grid de contacto
     */
    var reContacto= new Ext.ux.grid.RowEditor({
        saveText: 'Aceptar',
        cancelText:'Cancelar',
		errorSummary: false,
        listeners:{
            afteredit:function(inRowEditor,inObject,inRecord,inRowIndex){
				var tmpSentencia = 'insert';
				var param = new SOAPClientParameters();
				
				function CallBackCgg_res_persona_contacto(r){
					if(r == 'true'){
						Ext.Msg.show({
							title:tituloListadoAdministradorPersonaUsuario,
							msg: 'La informaci\u00f3n de contacto ha sido almacenada.',
							buttons: Ext.Msg.OK,
							icon: Ext.MessageBox.INFO
						});
						gsCgg_res_persona_contacto.reload();
					}else{
						Ext.Msg.show({
							title:tituloListadoAdministradorPersonaUsuario,
							msg: 'La informaci\u00f3n de contacto no ha podido ser almacenada.'+(r.message?r.message:r),
							buttons: Ext.Msg.OK,
							icon: Ext.MessageBox.ERROR
						});
					}
				}
					
				if(inRecord.data.CRPRC_CODIGO != 'KEYGEN'){
					tmpSentencia = 'update';
					param.add('inCrprc_codigo',inRecord.data.CRPRC_CODIGO);
				}
				param.add('inCrtco_codigo',inRecord.data.CRTCO_CODIGO);
				param.add('inCrper_codigo',tmpPersona.data.CRPER_CODIGO);                    
				param.add('inCrprc_descripcion',inRecord.data.CRPRC_DESCRIPCION);
				param.add('inCrprc_contacto',inRecord.data.CRPRC_CONTACTO);
				SOAPClient.invoke(urlCgg_res_persona_contacto,tmpSentencia,param, true, CallBackCgg_res_persona_contacto);
            },
            canceledit:function(inRowEditor,inFlag,inRecord){
                var inRecord=dtgCgg_res_persona_contacto.getStore().getAt(0);
                if (inRecord.get('CRPRC_CODIGO') == 'KEYGEN')
                    dtgCgg_res_persona_contacto.getStore().remove(inRecord);
            }
        }
    });
	
	/**
     *Ext.form.ComboBox Combo para edicion de tipo de contacto.
     */
    var cbxAPUCRTCO_CODIGO = new Ext.form.ComboBox({
        id:'cbxAPUCRTCO_CODIGO',
        store: SCGG_RES_TIPO_CONTACTO,
        displayField:'CRTCO_NOMBRE',
        typeAhead: true,
        mode:'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione un tipo',
        selectOnFocus:true,
        valueField:'CRTCO_CODIGO',
		allowBlank:false
    });
	
	var txtAPU_CINTC_CONTACTO = new Ext.form.TextField({
        id:'txtAPU_CINTC_CONTACTO',
        emptyText:'Establezca una descripci\u00F3n',
		allowBlank:false
    });
	/**
     * Ext.ColumnModel Agrupacion de registros de la tabla Cgg_res_persona_contacto por un campo especifico.
     */
    var cmCgg_res_persona_contacto = new Ext.grid.ColumnModel([
        {dataIndex:'CRPRC_CODIGO',hidden:true,header:'Codigo',width:150,sortable:true},
        {dataIndex:'CRPER_CODIGO',hidden:true,header:'Codigo',width:150,sortable:true},
        {dataIndex:'CRTCO_CODIGO',header:'Contacto',width:40,sortable:true,
            editor:cbxAPUCRTCO_CODIGO,renderer:
                function(value, metaData, record){
                    if (value){
                        var tmpHtml = null;
                        var tmpNombreImagen = null;
                        var rTipoContaco= record;
                        try{
                            if (rTipoContaco.get('CRTCO_NOMBRE_IMAGEN').length == 0)
                            {
                                rTipoContaco=SCGG_RES_TIPO_CONTACTO.getAt(SCGG_RES_TIPO_CONTACTO.findExact('CRTCO_CODIGO',value));
                            }
                            tmpNombreImagen = rTipoContaco.get('CRTCO_NOMBRE_IMAGEN');
                            new Ajax.Request(URL_DOC_VIEWER, {
                                onSuccess: function(response) {
                                    tmpHtml = '<div><img src="/siiws/tmp/'+tmpUserSession.getUserName().trim()+'/'+ tmpNombreImagen +'"/></div>';
                                },
                                onFailure:function(response){

                                },
                                asynchronous:false,
                                parameters:{
                                    table:'cgg_res_tipo_contacto',
                                    keyc:'crtco_codigo',
                                    keyv:rTipoContaco.get('CRTCO_CODIGO'),
                                    column:'crtco_imagen',
                                    fn:tmpNombreImagen,
                                    request:'view'
                                }
                            });
                            return tmpHtml;
                        }
                        catch(inError)
                        {
                            return 'codigo';
                        }
                    }
                }},
        {dataIndex:'CRPRC_CONTACTO',header:'Descripci\u00f3n',width:150,sortable:true,editor:txtAPU_CINTC_CONTACTO}
    ]);
	/**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_persona_contacto por un campo especifico.
     */
    var gsCgg_res_persona_contacto = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_persona_contacto",
            method:"selectPersonaContacto",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
        },[
            {name:'CRPRC_CODIGO'},
            {name:'CRPER_CODIGO'},
            {name:'CRTCO_CODIGO',allowBlank:false},
            {name:'CRPRC_DESCRIPCION'},
            {name:'CRPRC_CONTACTO',allowBlank:false},
            {name:'CRTCO_NOMBRE'},
            {name:'CRTCO_NOMBRE_IMAGEN'},


        ]),
        baseParams:{inCrper_codigo:'',format:TypeFormat.JSON}
    });
	/**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_persona_contacto en un formato tabular de filas y columnas.
     */
    var dtgCgg_res_persona_contacto = new Ext.grid.EditorGridPanel({
		title:'Contactos',
        cm:cmCgg_res_persona_contacto,
        store:gsCgg_res_persona_contacto,
        viewConfig:{forceFit:true},
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: ['->',{
            xtype:'button',
            iconCls:'iconNuevo',
            tooltip:'Agregar contacto',
            handler:function(){
                var tmpRecordCriterio = dtgCgg_res_persona_contacto.getStore().recordType;
                reContacto.stopEditing();
                dtgCgg_res_persona_contacto.getStore().insert(0,
                        new tmpRecordCriterio({
                            CRPRC_CODIGO: 'KEYGEN',
                            CRPER_CODIGO: 'KEYGEN',
                            CRTCO_CODIGO: '',
                            CRPRC_DESCRIPCION: '',
                            CRPRC_CONTACTO: '',
                            CRTCO_NOMBRE: '',
                            CRTCO_NOMBRE_IMAGEN: ''
                        })
                        );
                dtgCgg_res_persona_contacto.getView().refresh();
                dtgCgg_res_persona_contacto.getSelectionModel().selectRow(0);
                reContacto.startEditing(0);
            }
        },
            {
                iconCls:'iconEliminar',
                tooltip:'Eliminar contacto',
                handler:function(){
                    Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_perfil_prof,icon: Ext.MessageBox.QUESTION});
                    function SWRCgg_perfil_prof(btn){
                        if (btn=='yes'){
                            try{
                                var seleccionado = dtgCgg_res_persona_contacto.getSelectionModel().getSelected();
                                if(seleccionado){
                                    function CallBackCgg_res_persona_contacto(r){
                                        winFrmAdministradorPersonaUsuario.getEl().unmask();
                                        if(r=='true'){
                                            Ext.Msg.show({
                                                title:tituloListadoAdministradorPersonaUsuario,
                                                msg: 'La informaci\u00f3n de contacto ha sido eliminada.',
                                                buttons: Ext.Msg.OK,
                                                icon: Ext.MessageBox.INFO
                                            });
                                            dtgCgg_res_persona_contacto.getStore().remove(seleccionado);
                                        }else{
                                            Ext.Msg.show({
                                                title:tituloListadoAdministradorPersonaUsuario,
                                                msg: 'La informaci\u00f3n de contacto no ha podido ser eliminada.',
                                                buttons: Ext.Msg.OK,
                                                icon: Ext.MessageBox.ERROR
                                            });
                                        }}
                                    winFrmAdministradorPersonaUsuario.getEl().mask('Eliminando...', 'x-mask-loading');
                                    if(seleccionado.get('CRPRC_CODIGO') == 'KEYGEN'){
                                        dtgCgg_res_persona_contacto.getStore().remove(seleccionado);
                                        winFrmAdministradorPersonaUsuario.getEl().unmask();
                                    }else{
                                        var param = new SOAPClientParameters();
                                        param.add('inCrprc_codigo',dtgCgg_res_persona_contacto.getSelectionModel().getSelected().get('CRPRC_CODIGO'));
                                        SOAPClient.invoke(URL_WS + 'Cgg_res_persona_contacto',"delete",param, true, CallBackCgg_res_persona_contacto);
                                    }
                                }
                            }catch(inErr){
                                winFrmCgg_res_persona.getEl().unmask();
                            }
                        }
                    }
                }

            }
        ],
        plugins:[reContacto]
    });
	/**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_usuario.
     */
    var chkCaducaClave = new Ext.grid.CheckColumn(
		{dataIndex:'CUSU_CADUCA_CLAVE',header:'Caduca clave',width:150,sortable:true}
	);
    var chkCusu_activo = new Ext.grid.CheckColumn(
		{dataIndex:'CUSU_ACTIVO',header:'Activo',width:150,sortable:true}
	);
    var cmCgg_usuario = new Ext.grid.ColumnModel([
		{dataIndex:'CUSU_NOMBRE_USUARIO',header:'Nombre usuario',width:150,sortable:true},
        {dataIndex:'CISLA_NOMBRE',header:'Isla',width:150,sortable:true},
        {dataIndex:'EMPRESA',header:'Empresa',width:150,sortable:true},
		chkCaducaClave,
        chkCusu_activo
    ]);
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
			inCusu_usuario_interno:'-1',
			inCrper_codigo:''
        },
        listeners:{
            load:function(inStore, inRecords, inOptions){
                for (var i = 0; i < inRecords.length; i++){
                    var tmpCaduca = inRecords[i].get('CUSU_CADUCA_CLAVE');
                    if(tmpCaduca){
                        var tmpVigencia = inRecords[i].get('VIGENCIA');
                        var tmpTranscurrido = inRecords[i].get('TRANSCURRIDO');
                        grdCgg_usuario.getView().getRow(i).style.backgroundColor = Fade(255,255,255,255,0,0,tmpVigencia,tmpTranscurrido);
                    }

                }
            }
        }
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_usuario en un formato tabular de filas y columnas.
     */
    var grdCgg_usuario = new Ext.grid.GridPanel({
        cm:cmCgg_usuario,
        store:gsCgg_usuario,
        title:'Usuarios',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        loadMask:{
            msg:"Cargando..."
        },
		tbar:['->',{iconCls:'iconNuevo',tooltip:'Agregar nuevo usuario',handler:function(){
				var objCgg_usuario = new FrmCgg_usuario("insert");
                objCgg_usuario.closeHandler(function(){
                    gsCgg_usuario.reload();
                });
				objCgg_usuario.loadInfoPersona(tmpPersona);
                objCgg_usuario.setStoreTipoDoc(gsCgg_res_documento_identificacio);
                objCgg_usuario.show();
			}},{id:'btnAPUEditar',iconCls:'iconEditar',listeners:{
				click:function(){
					var tmpRecord = grdCgg_usuario.getSelectionModel().getSelected();
					if(tmpRecord){
						var objCgg_usuario = new FrmCgg_usuario("update",tmpRecord);
						objCgg_usuario.closeHandler(function(){
							gsCgg_usuario.reload();
						});
						objCgg_usuario.loadInfoPersona(tmpPersona);
						objCgg_usuario.setStoreTipoDoc(gsCgg_res_documento_identificacio);
						objCgg_usuario.loadData();
						objCgg_usuario.show();
					}
				}
			}
			},{iconCls:'iconEliminar',tooltip:'Deshabilitar usuario',handler:function(){
				var tmpRecord = grdCgg_usuario.getSelectionModel().getSelected();
				if(!tmpRecord)
					return;
				 Ext.Msg.show({
                    title:'Aviso',
                    msg:'Est\u00e1 seguro de eliminar?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_usuario,
                    icon: Ext.MessageBox.QUESTION
                });
                function SWRCgg_usuario(btn){
					if (btn=='yes'){
						function CallBackCgg_usuario_delete(r){
							if(r == 'true'){
								Ext.Msg.show({
									title:tituloListadoAdministradorPersonaUsuario,
									msg: 'La informaci\u00f3n de usuario ha sido eliminada.',
									buttons: Ext.Msg.OK,
									icon: Ext.MessageBox.INFO
								});
								gsCgg_usuario.reload();
							}else{
								Ext.Msg.show({
									title:tituloListadoAdministradorPersonaUsuario,
									msg: 'La informaci\u00f3n de usuario no ha podido ser eliminada. '+(r.message?r.message:r),
									buttons: Ext.Msg.OK,
									icon: Ext.MessageBox.ERROR
								});
							}
						}
						var param = new SOAPClientParameters();
						param.add('inCusu_codigo',tmpRecord.data.CUSU_CODIGO);
						SOAPClient.invoke(URL_WS+'Cgg_usuario','deleteHard',param,true,CallBackCgg_usuario_delete);
					}
				}
			}},'-',{iconCls:'iconClave',tooltip:'Reestablecer clave',handler:function(){
					var tmpRecord = grdCgg_usuario.getSelectionModel().getSelected();
					if(tmpRecord){
						var tmpDlg = new DlgUsuarioAC();
						tmpDlg.setCrper_codigo(tmpPersona.data.CRPER_CODIGO);
						tmpDlg.setUserID(tmpRecord.get('CUSU_CODIGO'));
						tmpDlg.setUserName(tmpRecord.get('CUSU_NOMBRE_USUARIO'));
						tmpDlg.setOp();
						tmpDlg.show();
					}
				}
			}
		],
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
				if(!Ext.getCmp('btnAPUEditar').hidden)
				Ext.getCmp('btnAPUEditar').fireEvent('click', Ext.getCmp('btnAPUEditar'));
            }
        }
    });
	
	var tabMisc = new Ext.TabPanel({
		activeTab:0,
		region:'center',
		items:[dtgCgg_res_persona_contacto,grdCgg_usuario]
	});
	
	var winFrmAdministradorPersonaUsuario = inDesktop.createWindow({
		id:'winFrmAdministradorPersonaUsuario',
		tbar: getPanelTitulo(tituloListadoAdministradorPersonaUsuario, descListadoAdministradorPersonaUsuario),
		layout:'border',
		title:tituloListadoAdministradorPersonaUsuario,
		maximizable: true,
		minimizable: true,
		constrain: true,
		width:600,
		height:500,
		items:[pnlPersona,tabMisc],
		bbar:['->',btnAPUCerrar]
	});
	
	/**
     * Funcion miembro que devuelve la ventana winFrmAdministradorPersonaUsuario.
     * @returns ventana winFrmAdministradorPersonaUsuario.
     * @base FrmAdministradorPersonaUsuario.prototype.show
     */
    this.getWindow = function () {
        return winFrmAdministradorPersonaUsuario;
    }
}

/**
 * Funcion prototipo. Permite mostrar la ventana winFrmAdministradorPersonaUsuario desde una instancia.
 */
FrmAdministradorPersonaUsuario.prototype.show = function () {
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmAdministradorPersonaUsuario desde una instancia.
 */
FrmAdministradorPersonaUsuario.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmAdministradorPersonaUsuario,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmAdministradorPersonaUsuario.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}