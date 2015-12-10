/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_gem_vacante_detalle.
 * @param {String} IN_SENTENCIA_CGG_gem_vacante_detalle Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} inRecVacante Registro de datos de la tabla Cgg_gem_vacante_detalle.
 * @constructor
 * @base FrmListadoCgg_gem_vacante_detalle
 * @author Besixplus Cia. Ltda.
 */

function FrmCgg_gem_vacante_detalle(SEG_GES_EMP,inRecVacante,storeCgg_gem_tipo_contrato,storeCgg_sector_productivo) {
	var urlCgg_gem_vacante_detalle = URL_WS + "Cgg_gem_vacante_detalle";
	var tituloCgg_gem_vacante_detalle = 'Detalle de oferta vacante';
	var descCgg_gem_vacante_detalle = 'El formulario detalla la informaci\u00f3n de la oferta vacante seleccionada';
		
	var btnsVacanteDetalle = "[";
	var estadoOferta = inRecVacante.get ("CGVCN_ESTADO_OFERTA");
	if (estadoOferta=="1" && inRecVacante.get ("CGVCN_OFERTA_APROBADA")!=2){
		var fechaPublicacion = inRecVacante.get ("CGVCN_FECHA_PUBLICACION");
		var duracionOferta = inRecVacante.get ("CGVCN_DURACION_OFERTA");
		var fechaReal= fechaPublicacion.add(Date.DAY, duracionOferta);
	}
	if (estadoOferta!="-1"){
		if (SEG_GES_EMP == "CSROL_GEADM"){
			if (estadoOferta=="0")
				btnsVacanteDetalle+="btnAprobarCgg_gem_vacante,btnRevisarCgg_gem_vacante,btnRechazarCgg_gem_vacante,";
			else if (estadoOferta=="1")
				if (new Date<=fechaReal)
					btnsVacanteDetalle+="btnCandidatosCgg_gem_vacante,";
				else
					btnsVacanteDetalle+="btnCandidatosCgg_gem_vacante,";
			else if (estadoOferta=="5")
				btnsVacanteDetalle+="btnCandidatosCgg_gem_vacante,btnSeleccionarCgg_gem_vacante,";
			if (estadoOferta=="4" || estadoOferta=="6" || estadoOferta=="7" || estadoOferta=="8" || estadoOferta=="3")
				btnsVacanteDetalle+="btnCandidatosCgg_gem_vacante,btnSeleccionarCgg_gem_vacante,"
			else if (estadoOferta=="2")
				btnsVacanteDetalle+="";
			else
				if (estadoOferta!="0")
					btnsVacanteDetalle+="'-',btnFinalizarCgg_gem_vacante,";
		}else if (SEG_GES_EMP == "CSROL_GEEMP" || SEG_GES_EMP == "CSROL_GEAPL"){
			if (estadoOferta=="0")
				btnsVacanteDetalle+="";
			else if (estadoOferta=="1")
				btnsVacanteDetalle+="btnCandidatosCgg_gem_vacante,";
			else if (estadoOferta=="5" || estadoOferta=="4" || estadoOferta=="6" || estadoOferta=="7" || estadoOferta=="8" || estadoOferta=="3")
				btnsVacanteDetalle+="btnCandidatosCgg_gem_vacante,btnSeleccionarCgg_gem_vacante,";
			if (estadoOferta=="2")
				btnsVacanteDetalle+="";
		}
	}
	btnsVacanteDetalle+="'->',btnCerrarCgg_gem_vacante_detalle]";	
	/**
	 * Ext.Button Boton que permite aprobar publicar y generar un comunicado radial para la oferta.
	 */
	var btnAprobarCgg_gem_vacante = new Ext.Button({
		id: 'btnAprobarCgg_gem_vacante',
		text: 'Aprobar',
		iconCls: 'iconAceptar',
		tooltip: "Aprueba, publica y genera el comunicado radial correspondiente",
		listeners: {
			click: function () {
				var tmpMsg = "La informaci\u00f3n registrada correspondiente a: <b>";
				var tmpC = 0;
				if (inRecVacante.get("CGCRG_CODIGO")=='CGCRG0'){
					tmpC++;
					tmpMsg+="Cargo";
				}
				if (inRecVacante.get("CGTPR_CODIGO")=='CGTPR0'){
					tmpC++;
					tmpMsg+=" y T\u00edtulo profesional,<br>";
				}
				tmpMsg += "</b><br>no est\u00e1n registrados como valores v\u00e1lidos.<br> ";
				tmpMsg += "Para continuar por favor registre la nueva informaci\u00F3n o seleccione una diferente.";
				
				if (tmpC>0){
					Ext.Msg.show({
						title:'Importante',
						msg: tmpMsg,
						buttons: Ext.Msg.OK						
					});		
				}else{
					var objCgg_gem_vacante_admin = new FrmCgg_gem_vacante_admin("update", inRecVacante);					
					objCgg_gem_vacante_admin.closeHandler(function () {
						if (objCgg_gem_vacante_admin.getFlagAceptar())
							winFrmCgg_gem_vacante_detalle.close();
					});
					objCgg_gem_vacante_admin.show();
				}				
			}			
		}
	});	
	var btnCandidatosCgg_gem_vacante = new Ext.Button({
		id: 'btnCandidatosCgg_gem_vacante',
		text: 'Candidatos',
		iconCls: 'iconPersona',
		listeners: {
			click: function () {
				var objListadoCgg_gem_candidato = new FrmListadoCgg_gem_candidato(inRecVacante);
				objListadoCgg_gem_candidato.show();
				objListadoCgg_gem_candidato.closeHandler(function () {
					if (objListadoCgg_gem_candidato.getFlagGenerado()==true)
						winFrmCgg_gem_vacante_detalle.close();
				});
			}
		}
	});
	
	var btnSeleccionarCgg_gem_vacante = new Ext.Button({
		id: 'btnSeleccionarCgg_gem_vacante',
		text: 'Entrevistas y contrataciones',
		iconCls: 'iconSeleccionar',
		listeners: {
			click: function () {
				var objCgg_gem_vacante_seleccionar = new FrmCgg_gem_vacante_seleccionar(inRecVacante);
				objCgg_gem_vacante_seleccionar.show();
				objCgg_gem_vacante_seleccionar.closeHandler(function () {
					if (objCgg_gem_vacante_seleccionar.getFlagAceptar())
						winFrmCgg_gem_vacante_detalle.close();
				});
			}
		}
	});
	/**
     * Ext.form.TextArea DESCRIPCION QUE REGISTRA EL ADMINISTRADOR DE GESTION DE EMPLEO CUANDO SE RECHAZA O ACEPTA UN APLICANTE
     */
    var txtFinalizarCgcnd_descripcion = new Ext.form.TextArea({
        id: 'txtFinalizarCgcnd_descripcion',
        name: 'txtFinalizarCgcnd_descripcion',
        fieldLabel: 'Descripci\u00f3n',
        width: '90%'
    });
    
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_gem_vacante_finalizar
     */
    var btnFinalizarCgg_gem_vacante = new Ext.Button({
        id: 'btnFinalizarCgg_gem_vacante',
        text: 'Cancelar oferta',
        iconCls: 'iconCancelar',
        listeners: {
            click: function () {
				Ext.Msg.prompt('Cancelaci\u00F3n del proceso', 'El proceso de la oferta <b>'+inRecVacante.get("CGVCN_NUMERO")+'</b> va ha ser cancelado.<br>Por favor ingrese una observaci\u00f3n sobre el motivo de cancelaci\u00F3n del proceso:',
					function(btn, text){
						if (btn == 'ok')finalizarTramiteOferta(text,8);
					},null,true
				);
            }
        }
    });
	/**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_gem_vacante_finalizar
     */
    var btnRevisarCgg_gem_vacante = new Ext.Button({
        id: 'btnRevisarCgg_gem_vacante',
        text: 'Enviar para revisi\u00f3n',
        iconCls: 'iconEditar',
        listeners: {
            click: function () {
				Ext.Msg.prompt('Envio para revisi\u00F3n de oferta', 
					'Esta seguro que desea enviar la oferta <b>N\u00ba '+inRecVacante.get("CGVCN_NUMERO")+'</b> para revisi\u00F3n?<br>'+
					'Si esta seguro por favor ingrese una detalle del motivo de la revisi\u00F3n:',
					function(btn, text){
						if (btn == 'ok'){
							try {
							function CallBackCgg_gem_vacante_revisar(r){
								winFrmCgg_gem_vacante_detalle.getEl().unmask();
								if (r == 'true') {
									Ext.Msg.show({
										title: "Revisar",msg: 'Se ha enviado una solicitud de revisi\u00f3n de la oferta.',
										buttons: Ext.Msg.OK,icon: Ext.MessageBox.INFO
									});
									winFrmCgg_gem_vacante_detalle.close()
								} else {
									Ext.Msg.show({
										title: 'Revisar',msg: 'La informaci\u00f3n no ha podido ser almacenada. ' + r,
										buttons: Ext.Msg.OK,icon: Ext.MessageBox.ERROR
									});
								}
							}
							var tmpJson = eval("("+inRecVacante.get("CGVCN_TITULO")+")");
							
							tmpJson.msg = text;
							var textJson = "{cargo:'"+tmpJson.cargo+"',titulo:'"+tmpJson.titulo+"',msg:'"+tmpJson.msg+"'}";
							winFrmCgg_gem_vacante_detalle.getEl().mask('Guardando...', 'x-mask-loading');
							var param = new SOAPClientParameters();
							param.add('inCgvcn_codigo', inRecVacante.get("CGVCN_CODIGO"));
							param.add('inCgvcn_estado_oferta', '-1' );
							param.add('inMsgRevision', textJson);
							SOAPClient.invoke( URL_WS + "Cgg_gem_vacante", "enviarParaRevision", param, true, CallBackCgg_gem_vacante_revisar);
							} catch (inErr) {  alert(inErr);
							winFrmCgg_gem_vacante_detalle.getEl().unmask();
							}
						}
					},null,true
				);					
            }
        }
    });
	/**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_gem_vacante_finalizar
     */
    var btnRechazarCgg_gem_vacante = new Ext.Button({
        id: 'btnRechazarCgg_gem_vacante',
        text: 'Rechazar',
        iconCls: 'iconCancelar',
        listeners: {
            click: function () {
				Ext.Msg.prompt('Rechazar oferta', 
					'Esta seguro que desea rechazar la oferta <b>N\u00ba '+inRecVacante.get("CGVCN_NUMERO")+'</b>?<br>'+
					'Si esta seguro por favor ingrese una descripci\u00f3n del motivo del rechazo:',
					function(btn, text){
						if (btn == 'ok')finalizarTramiteOferta(text,2);
					},null,true
				);
            }
        }
    });
	function finalizarTramiteOferta(txt,tp){
		try {
			function CallBackCgg_gem_vacante_finalizar(r){
				winFrmCgg_gem_vacante_detalle.getEl().unmask();
				if (r == 'true') {
					Ext.Msg.show({
						title: "Finalizaci\u00f3n",
						msg: 'El proceso de la oferta ha sido cancelado.',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.INFO
					});
					winFrmCgg_gem_vacante_detalle.close()
				} else {
					Ext.Msg.show({
						title: 'Finalizaci\u00f3n',
						msg: 'La informaci\u00f3n no ha podido ser almacenada. ' + r,
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.ERROR
					});
				}
			}
			winFrmCgg_gem_vacante_detalle.getEl().mask('Guardando...', 'x-mask-loading');
			
			var param = new SOAPClientParameters();
			param.add('inCgvcn_codigo', inRecVacante.get("CGVCN_CODIGO"));
			param.add('inCgvcn_estado_oferta', tp );
			param.add('inCgvcn_justificacion_no_contrat', txt);
			SOAPClient.invoke( URL_WS + "Cgg_gem_vacante", "finalizarProceso", param, true, CallBackCgg_gem_vacante_finalizar);
		} catch (inErr) {  alert(inErr);
			winFrmCgg_gem_vacante_detalle.getEl().unmask();
		}
	}
	/**
	 * Boton que permite cerrar la ventana winFrmCgg_gem_vacante_detalle.
	 */
	var btnCerrarCgg_gem_vacante_detalle = new Ext.Button({
		id: 'btnCerrarCgg_gem_vacante_detalle',
		text: 'Cerrar',
		iconCls: 'iconCerrar',
		listeners: {
			click: function () {
				winFrmCgg_gem_vacante_detalle.close();
			}
		}
	});		   
		
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_gem_requisito_vacante.
	*/	
	var cmCgg_gem_requisito_vacante_detalle = new Ext.grid.ColumnModel([
		new Ext.grid.RowNumberer(),		
		{dataIndex:'CGRVC_REQUISITO',header:'Requisito',width:500,sortable:true,editor:{xtype:'textfield',allowBlank:false}},
		{dataIndex: 'CGRVC_OBLIGATORIO',header: 'Obligatorio?',width: 80,sortable: true,editor:{xtype:'checkbox',x:100,align:'center',bodyStyle:"padding-Left:30;"},align:'center',renderer:function(v){return (v)?"si":"no"}}
	]);
	  /**
	 * Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_requisito_vacante por un campo especifico.
	 */
	var gsCgg_gem_requisito_vacante_detalle =new Ext.data.GroupingStore({
		proxy: new Ext.ux.bsx.SoapProxy({
			url: URL_WS + "Cgg_gem_requisito_vacante",
			method: "selectFKVacante"
		}),        
		reader: new Ext.data.JsonReader({},[
		{name:'CGRVC_CODIGO'},
		{name:'CGVCN_CODIGO'},
		{name:'CGRVC_REQUISITO'},
		{name:'CGRVC_OBLIGATORIO'}
	]),
		baseParams:{inCgvcn_codigo: inRecVacante.get("CGVCN_CODIGO")}		
	});
	gsCgg_gem_requisito_vacante_detalle.reload();
	/**
	 * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_gem_requisito_vacante en un formato tabular de filas y columnas.
	 */
	var grdCgg_gem_requisito_vacante_detalle = new Ext.grid.GridPanel({
		cm: cmCgg_gem_requisito_vacante_detalle,
		store: gsCgg_gem_requisito_vacante_detalle,
		region:"center",
		loadMask: {msg: "Cargando..."}
	});
	
	/**
	* new Ext.Panel Panel que contiene el template para visualizar la informacion de la vacante.
	*/
	var pnlVacanteDetalleGeneral = new Ext.Panel({
		id:"pnlVacanteDetalleGeneral",
		html:"cargando...",		
		bodyStyle:'	background-color:#F7EFD5',
		region:'center',
		flex:2,
		autoScroll : true
	});
	
	/**
	* new Ext.Panel Panel que contiene el template para visualizar la informacion de la vacante.
	*/
	var pnlUsuarioDetalle = new Ext.Panel({
		id:"pnlUsuarioDetalle",		
		html:"cargando...",
		height:100,
		flex:1,
		region:'south'
	});
	/**
	* new Ext.Panel Panel que contiene el template para visualizar la informacion de la vacante.
	*/
	var pnlVacante = new Ext.Panel({
		id:"pnlVacante",
		title:"Datos generales",
		anchor:"100%",
		layout:'vbox',
		layoutConfig: {
			align : 'stretch'			
		},
		region:'center',
		items:[pnlVacanteDetalleGeneral,pnlUsuarioDetalle]
	});
	/**
	* new Ext.Panel Panel que contiene el template para visualizar la informacion de la vacante.
	*/
	var pnlVacanteDetalleRequisitos = new Ext.Panel({
		id:"pnlVacanteDetalleRequisitos",
		title:"Requisitos a cumplir",
		layout:'border',
		items:[grdCgg_gem_requisito_vacante_detalle]
	});	
	/**
	* new Ext.Panel Panel que contiene el template para visualizar la informacion de la vacante.
	*/
	var pnlVacanteDetalle = new Ext.TabPanel({
		id:"pnlVacanteDetalle",
		height:500,
		activeTab: 0,
		height:350,		
		items:[pnlVacante,pnlVacanteDetalleRequisitos]
	});
	/**
	 * new Ext.Template Templete que da formatoa a la fisualización de la información de la vacante.
	 */
	 	
	var filaTipoContrato = storeCgg_gem_tipo_contrato.findExact("CGTCN_CODIGO",inRecVacante.get("CGTCN_CODIGO"));
	var filSectorProductivo = storeCgg_sector_productivo.findExact("CSCTP_CODIGO",inRecVacante.get("CSCTP_CODIGO"));	
	
	var tplVacanteDetalle = new Ext.Template(        
		'<table width="100%" class="CggTemplate"><tr>'+
			'<td width="55%" valign="top"><div style="font-size:11px"><b>DATOS GENERALES DE LA OFERTA</b></div><table class="CggTemplate"  cellspacing=8>'+
				'<tr><th>N\u00FAmero:</th><td><span><b>{CGVCN_NUMERO}</b></span></td></tr>',
				'<tr><th>Cargo:				</th><td> {CGCRG_NOMBRE}	</td></tr>',
				'<tr><th>T\u00EDtulo profesional:	</th><td> {CGTPR_DESCRIPCION}		</td></tr>',
				'<tr><th>Fecha registro:</th><td><span> {CGVCN_FECHA_INGRESO:date("d/m/Y H:i")}<span></td></tr>',				
				'<tr><th>Isla empleo:</th><td> {CGVCN_DIRECCION}</td></tr>'+
			'</table></td>'+
			'<td width="45%" valign="top"><table class="CggTemplate"  cellspacing=8>'+
				'<tr><th>Tipo de contrato:	</th><td> '+storeCgg_gem_tipo_contrato.getAt(filaTipoContrato).get("CGTCN_DESCRIPCION")+' 		</td></tr>'+
				'<tr><th>N\u00FAmero vacantes:	</td><td> {CGVCN_NUMERO_VACANTES}		</td></tr>',
				'<tr><th>Salario:			</th><td> {CGVCN_SALARIO}',' {CGTSA_NOMBRE}	</td></tr>',
				'<tr><th>Duraci\u00f3n empleo:	</th><td> {CGVCN_DURACION_TIEMPO}',' {CGVCN_DURACION:this.formatDuracion} </td></tr>',
				'<tr><th>Funciones:</th><td> {CGVCN_DESCRIPCION}	</td></tr>',
			'</table></td>'+
		'</tr></table>'		
	);
	tplVacanteDetalle.formatDuracion =function(v){				
		switch (v){
			case 0:v= "Hora(s)";break;
			case 1:v= "D\u00eda(s)";break;
			case 2:v= "Mes(s)";break;
			case 3:v= "A\u00f1o(s)";break;
		}		
		return v;
	}
	var tplPersonaNatural = new Ext.Template(		
		'<table width="100%" class="fondoPanelTmpUsr"><tr>'+
			'<td width="50%" valign="top"><div style="font-size:11px"><b>DATOS DEL OFERENTE </b></div><table class="vacanteTemplate"  cellspacing=8>'+
				'<tr><th>Nombre:</th><td><span> {CRPER_NOMBRES} ','{CRPER_APELLIDO_PATERNO}','{CRPER_APELLIDO_MATERNO} </span></td></tr>',
				'<tr><th>Fecha. nac:</th><td><span> {CRPER_FECHA_NACIMIENTO:date("d/m/Y")}</span></td></tr>'+				
			'</table></td>'+			
		'</tr></table>'		
	);
	var tplEmpresa = new Ext.Template(		
		'<table width="100%" class="fondoPanelTmpUsr"><tr>'+
			'<td width="50%" valign="top"><div style="font-size:11px"><b>DATOS DEL OFERENTE </b></div><table class="vacanteTemplate"  cellspacing=5>'+
				'<tr><th>RUC:</th><td><span> {CRPJR_NUMERO_IDENTIFICACION} </span></td></tr>',
				'<tr><th>Direcci\u00f3n:</th><td><span> {CRPJR_DIRECCION}</span></td></tr>',
			'</table></td>'+
			'<td width="50%" valign="top"><table class="vacanteTemplate"  cellspacing=8>'+				
				'<tr><th>Raz\u00f3n social:</th><td><span> {CRPJR_RAZON_SOCIAL}</span></td></tr>',
				'<tr><th>Actividad:</th><td><span> {CRPJR_ACTIVIDAD}</span></td></tr>'+
			'</table></td>'+
		'</tr></table>'		
	);       	
	
	/**
	 * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_gem_vacante_detalle.
	 */
	var winFrmCgg_gem_vacante_detalle = new Ext.Window({
		id: 'winFrmCgg_gem_vacante_detalle',
		title: tituloCgg_gem_vacante_detalle,
		minWidth: 600,
		bodyStyle:'padding:0px;margin:0px',
		width: 650,
		maximizable: true,
		minimizable: true,
		modal:true,
		constrainHeader: true,
		frame:true,
		layout:'fit',
		tbar: getPanelTitulo(tituloCgg_gem_vacante_detalle, descCgg_gem_vacante_detalle),
		items: [pnlVacanteDetalle],
		listeners:{
			show:function(){
				tplVacanteDetalle.overwrite(pnlVacanteDetalleGeneral.body, inRecVacante.data);	
				function CallBackCgg_gem_usuario_info(r){
					var r1 = eval(r);
					var r2 = r1[0];					
					if (r2.CRPJR_CODIGO == null)
						tplPersonaNatural.overwrite(pnlUsuarioDetalle.body, r2);
					else
						tplEmpresa.overwrite(pnlUsuarioDetalle.body, r2);
				}
				var param = new SOAPClientParameters();
				param.add("inCusu_codigo",inRecVacante.get("CUSU_CODIGO"));
				param.add("format","JSON");
				SOAPClient.invoke(URL_WS + "Cgg_gem_vacante", "selectInformacionUsuario", param, true, CallBackCgg_gem_usuario_info);
			}
		},
		bbar: eval(btnsVacanteDetalle)
	});    
	/**
	 * Funcion que aplica los privilegios del usuario.
	 */
	/*applyGrants(winFrmCgg_gem_vacante_detalle.getBottomToolbar());*/
	/**
	 * Funcion miembro que devuelve la ventana winFrmCgg_gem_vacante_detalle.
	 * @returns ventana winFrmCgg_gem_vacante_detalle.
	 * @base FrmCgg_gem_vacante_detalle.prototype.show
	 */
	this.getWindow = function () {
		return winFrmCgg_gem_vacante_detalle;
	}
	/**
	 * Funcion miembro que carga los controles de la ventana winFrmCgg_gem_vacante_detalle.
	 * @base FrmCgg_gem_vacante_detalle.prototype.loadData
	 */
	this.loadData = function () {
		cargarCgg_gem_vacante_detalleCtrls();
	}
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_gem_vacante_detalle desde una instancia.
 */
FrmCgg_gem_vacante_detalle.prototype.show = function () {
	this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_gem_vacante_detalle desde una instancia.
 */
FrmCgg_gem_vacante_detalle.prototype.close = function () {
	this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_gem_vacante_detalle,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_gem_vacante_detalle.prototype.closeHandler = function (inFunctionHandler) {
	this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_gem_vacante_detalle desde una instancia.
 */
FrmCgg_gem_vacante_detalle.prototype.loadData = function () {
   // this.loadData();
}
