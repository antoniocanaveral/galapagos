/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_gem_vacante_admin.
 * @param {String} IN_SENTENCIA_Cgg_gem_vacante_admin Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_Cgg_gem_vacante_admin Registro de datos de la tabla Cgg_gem_vacante_admin.
 * @constructor
 * @base FrmListadoCgg_gem_vacante_admin
 * @author Besixplus Cia. Ltda.
 */

function FrmCgg_gem_vacante_admin(IN_SENTENCIA_Cgg_gem_vacante_admin, IN_RECORD_Cgg_gem_vacante_admin,USUARIO) {
	var x = IN_RECORD_Cgg_gem_vacante_admin.data;
	var inSentenciaCgg_gem_vacante_admin = IN_SENTENCIA_Cgg_gem_vacante_admin;
	var inRecordCgg_gem_vacante_admin = IN_RECORD_Cgg_gem_vacante_admin;
	var urlCgg_gem_vacante_admin = URL_WS + "Cgg_gem_vacante";
	var tituloCgg_gem_vacante_admin = 'Aprobar oferta de empleo';
	var descCgg_gem_vacante_admin = 'El formulario permite aprobar una oferta de empleo';
	var diasValidezOferta = SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact("CGCNF_CODIGO","CONFGE1")).get("CGCNF_VALOR_NUMERICO");	
	var diasValidezComunicado = SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact("CGCNF_CODIGO","CONFGE2")).get("CGCNF_VALOR_NUMERICO");	
	var flagAceptar=false;
	/**
	 * Ext.form.DateField FECHA DE PUBLICACION DEL COMUNICADO RADIAL
	 */
	var dtCgvcn_fecha_publicacion = new Ext.form.DateField({
		id: 'dtCgvcn_fecha_publicacion',
		name: 'dtCgvcn_fecha_publicacion',
		fieldLabel: 'Fecha publicaci\u00f3n',
		format: 'd/m/Y H:i:s.u',
		value: new Date(),
		readOnly:true
	});	
	/**
	 * Ext.form.DateField FECHA DE PUBLICACION DE LA OFERTA
	 */
	var dtCgvcn_fecha_publicacionOferta = new Ext.form.DateField({
		id: 'dtCgvcn_fecha_publicacionOferta',
		name: 'dtCgvcn_fecha_publicacionOferta',
		fieldLabel: 'Fecha publicaci\u00f3n',
		format: 'd/m/Y H:i:s.u',
		value: new Date(),
		readOnly:true
	});	
	/**
	 * Ext.form.NumberField TIEMPO DEFINIDO DE VIGENCIA PARA LA OFERTA (DIAS)
	 */
	var numCgvcn_duracion_oferta = new Ext.form.NumberField({
		id: 'numCgvcn_duracion_oferta',
		name: 'numCgvcn_duracion_oferta',
		fieldLabel: 'Duraci\u00f3n',		
		width:"95%",
		value:diasValidezOferta,
		readOnly:false,
		listeners:{
			change:function(){
				var tmpDate = new Date().add(Date.DAY, numCgvcn_duracion_oferta.getValue());
				dtCgvcn_fecha_expiracionOferta.setValue(tmpDate);
			}
		}
	});
	
	/**
	 * Ext.form.NumberField TIEMPO DEFINIDO DE VIGENCIA PARA LA OFERTA (DIAS)
	 */
	var numCgvcn_duracion_comunicado = new Ext.form.NumberField({
		id: 'numCgvcn_duracion_comunicado',
		name: 'numCgvcn_duracion_comunicado',
		fieldLabel: 'Duraci\u00f3n',
		disabled: false,
		width:"95%",
		value:diasValidezComunicado,
		readOnly:true
	});	
	/**
	 * Ext.form.DateField FECHA EXPIRACION DE LA PUBLICACION
	 */
	var dtCgvcn_fecha_expiracion = new Ext.form.DateField({
		id: 'dtCgvcn_fecha_expiracion',
		name: 'dtCgvcn_fecha_expiracion',
		fieldLabel: 'Fecha expiraci\u00f3n',
		allowBlank: false,
		format: 'd/m/Y H:i:s.u',		
		value:new Date().add(Date.DAY, diasValidezComunicado),
		readOnly:true
	});	
	/**
	 * Ext.form.DateField FECHA EXPIRACION DE LA PUBLICACION
	 */
	var dtCgvcn_fecha_expiracionOferta = new Ext.form.DateField({
		id: 'dtCgvcn_fecha_expiracionOferta',
		name: 'dtCgvcn_fecha_expiracionOferta',
		fieldLabel: 'Fecha expiraci\u00f3n',
		allowBlank: false,
		format: 'd/m/Y H:i:s.u',		
		value:new Date().add(Date.DAY, diasValidezOferta),
		readOnly:false
	});	
	/**
	 * Boton que permite almacenar la informacion de la ventana winFrmCgg_gem_vacante_admin
	 */
	var btnAceptarCgg_gem_vacante_admin = new Ext.Button({
		id: 'btnAceptarCgg_gem_vacante_admin',
		text: 'Aceptar',
		iconCls: 'iconAceptar',
		listeners: {
			click: function () {
				function CallBackCgg_gem_vacante_admin(r){
					if (r == 'false') {
						Ext.Msg.show({
							title: tituloCgg_gem_vacante_admin,						
							msg: 'No se pudo registrar la aprobaci\u00f3n de la oferta.',
							buttons: Ext.Msg.OK,
							icon: Ext.MessageBox.ERROR
						});
					} else{
						Ext.Msg.show({
							title: tituloCgg_gem_vacante_admin,
							msg: 'La oferta fu\u00e9 aprobada y publicada exitosamente.<br/><br/><b>COMUNICADO RADIAL No. ' + r +'</b>',
							buttons: Ext.Msg.OK,
							icon: Ext.MessageBox.INFO
						});						
						new Reporte("rptComunicadoRadial", '/Reports/sii/gem', {
							P_CGVCN_CODIGO:IN_RECORD_Cgg_gem_vacante_admin.get('CGVCN_CODIGO')							
						}).show();	
						flagAceptar = true;
						winFrmCgg_gem_vacante_admin.close();
					}
				}
				var param = new SOAPClientParameters();
				param.add('inCgvcn_codigo', inRecordCgg_gem_vacante_admin.get("CGVCN_CODIGO"));
				param.add('inCgvcn_fecha_publicacion', dtCgvcn_fecha_publicacion.getValue().format(TypeDateFormat.Custom));
				param.add('inCgvcn_duracion_oferta', numCgvcn_duracion_oferta.getValue());
				param.add('inCgvcn_fecha_expiracion', dtCgvcn_fecha_expiracion.getValue().format(TypeDateFormat.Custom));
				SOAPClient.invoke(urlCgg_gem_vacante_admin, 'aprobarOfertaVacante' , param, true, CallBackCgg_gem_vacante_admin);
			}
		}
	});	
	/**
	 * Boton que permite cerrar la ventana winFrmCgg_gem_vacante_admin.
	 */
	var btnCerrarCgg_gem_vacante_admin = new Ext.Button({
		id: 'btnCerrarCgg_gem_vacante_admin',
		text: 'Cerrar',
		iconCls: 'iconCerrar',
		listeners: {
			click: function () {
				winFrmCgg_gem_vacante_admin.close();
			}
		}
	});		 
	/**
	*Ext.form.FormPanel Panel contenedor de los componentes.
	*/
	var pnlVacanteAdmin = new Ext.form.FormPanel({
		frame:true,		
		id:"pnlVacanteAdmin",
		items:[{
			xtype:'panel',
			layout:"column",			
			items:[{				
				xtype:'fieldset',
				title:"Del comunicado radial",
				columnWidth:0.5,
				bodyStyle:"padding:3;padding-left:10",
				layout:"form",			
				items:[dtCgvcn_fecha_publicacion,
					dtCgvcn_fecha_expiracion,{
						xtype:'panel',
						layout:"column",
						items:[{
							width:150,
							layout:"form",
							items:[numCgvcn_duracion_comunicado]
						},{
							layout:"form",
							html:'<div style="padding-top:5px;font-size:12px">d\u00edas<div>'
						}]
					}]
			},{
				 xtype:'fieldset',
				columnWidth:0.5,
				bodyStyle:"padding:3;padding-left:10",
				layout:"form",
				title:"De la oferta",				
				items:[dtCgvcn_fecha_publicacionOferta,
					dtCgvcn_fecha_expiracionOferta,{
						xtype:'panel',
						layout:"column",
						items:[{
							width:150,
							layout:"form",
							items:[numCgvcn_duracion_oferta]
						},{
							layout:"form",
							html:'<div style="padding-top:5px;font-size:12px">d\u00edas<div>'
						}]
					}]
			}]
		}]
	});
	/**
	 * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_gem_vacante_admin.
	 */
	var winFrmCgg_gem_vacante_admin = new Ext.Window({
		id: 'winFrmCgg_gem_vacante_admin',
		title: tituloCgg_gem_vacante_admin,		
		resizable:false,
		constrainHeader: true,
		width:550,
		modal:true,
		tbar: getPanelTitulo(tituloCgg_gem_vacante_admin, descCgg_gem_vacante_admin),
		items: [pnlVacanteAdmin],
		bbar: [btnAceptarCgg_gem_vacante_admin,  '->', btnCerrarCgg_gem_vacante_admin]		
	});
	/**
	 * Funcion que aplica los privilegios del usuario.
	 */
	/*applyGrants(winFrmCgg_gem_vacante_admin.getBottomToolbar());*/
	/**
	 * Funcion miembro que devuelve la ventana winFrmCgg_gem_vacante_admin.
	 * @returns ventana winFrmCgg_gem_vacante_admin.
	 * @base FrmCgg_gem_vacante_admin.prototype.show
	 */
	this.getWindow = function () {
		return winFrmCgg_gem_vacante_admin;
	}	
	this.getFlagAceptar = function () {
		return flagAceptar;
	}
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_gem_vacante_admin desde una instancia.
 */
FrmCgg_gem_vacante_admin.prototype.show = function () {
	this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_gem_vacante_admin desde una instancia.
 */
FrmCgg_gem_vacante_admin.prototype.close = function () {
	this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_gem_vacante_admin,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_gem_vacante_admin.prototype.closeHandler = function (inFunctionHandler) {
	this.getWindow().on('close', inFunctionHandler);
}