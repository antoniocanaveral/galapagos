/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_gem_candidato.
 * @param {String} IN_SENTENCIA_Cgg_gem_candidato Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_Cgg_gem_candidato Registro de datos de la tabla Cgg_gem_candidato.
 * @constructor
 * @base FrmListadoCgg_gem_candidato
 * @author Besixplus Cia. Ltda.
 */

function FrmCgg_gem_vacante_aplicar(IN_SENTENCIA_Cgg_gem_candidato, IN_RECORD_Cgg_gem_candidato,USUARIO) {
	var x = IN_RECORD_Cgg_gem_candidato.data;
	var inSentenciaCgg_gem_candidato = IN_SENTENCIA_Cgg_gem_candidato;
	var inRecordCgg_gem_candidato = IN_RECORD_Cgg_gem_candidato;
	var urlCgg_gem_candidato = URL_WS + "Cgg_gem_candidato";
	var tituloCgg_gem_candidato = 'Aplicar a oferta vacante';
	var descCgg_gem_candidato = 'El formulario permite registrar informaci\u00f3n para aplicar para una oferta.';
	var txtCusu_codigo_COD=userSessionData.CUSU_CODIGO;
	/**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
     */
    var txtCusu_codigo = new Ext.form.TextField({
        id: 'txtCusu_codigo',
        name: 'txtCusu_codigo',
        fieldLabel: 'Usuario',
        readOnly: 'true',
		value:(SEG_GES_EMP == "CSROL_GEAPL")?txtCusu_codigo_COD:"",
        allowBlank: false,
		hidden:(SEG_GES_EMP == "CSROL_GEADM")?false:true,
		width:'98%'
	});
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
     */
    var btnCusu_codigoCgg_gem_vacante = new Ext.Button({
        id: 'btnCusu_codigoCgg_gem_vacante',
        text: '',
        iconCls: 'iconNuevo',
		hidden:(SEG_GES_EMP == "CSROL_GEADM")?false:true,
        listeners: {
            click: function () {
                var tmpFLCgg_usuario = new Cgg_gem_candidato_lite();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_usuario.store, tmpFLCgg_usuario.columnModel);
                objBusqueda.closeHandler(function () {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord){						
						txtCusu_codigo.setValue(tmpRecord.get('CRPER_APELLIDO_PATERNO')+" "+tmpRecord.get('CRPER_APELLIDO_MATERNO')+" "+tmpRecord.get('CRPER_NOMBRES'));
						txtCusu_codigo_COD = tmpRecord.get('CUSU_CODIGO');
					}
                });
                objBusqueda.show();
            }
        }
    });
	/**
	* Ext.form.NumberField VALOR APROXIMADO A PERCIBIR POR EL TRABAJO REALIZADO
	*/
	var numCgcnd_aspiracion_salarial = new Ext.form.NumberField({
		id:'numCgcnd_aspiracion_salarial',
		name:'numCgcnd_aspiracion_salarial',
		fieldLabel :'Aspiracion salarial',
		allowBlank :false,
		disabled :false,
		width:75,
		value:inRecordCgg_gem_candidato.get("CGVCN_SALARIO")
	});
	/**
	* Ext.form.TextArea NO ESPECIFICADO
	*/
	var txtCgcnd_observacion = new Ext.form.TextArea({
		id:'txtCgcnd_observacion',
		name:'txtCgcnd_observacion',
		fieldLabel :'Observacion',
		width:'95%',
		allowBlank :false
	});
	/**
	* Boton que permite almacenar la informacion de la ventana winFrmCgg_gem_vacante_aplicar
	*/
	var flagAplicar = false;
	var btnGuardarCgg_gem_candidato = new Ext.Button({
		id:'btnGuardarCgg_gem_candidato',
		text:'Guardar',
		iconCls:'iconGuardar',
		listeners:{
		click:function(){
		if (pnlCgg_gem_candidato.getForm().isValid()==false)return;
		try{
			function CallBackCgg_gem_candidato(r){
				winFrmCgg_gem_vacante_aplicar.getEl().unmask();
				if(r=='true'){
					Ext.Msg.show({
						title:tituloCgg_gem_candidato,
						msg: 'La informaci\u00f3n a sido registrada exitosamente.<br>Usted forma parte de la lista de candidatos para esta oferta.',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.INFO
					});
					flagAplicar = true;
					winFrmCgg_gem_vacante_aplicar.close();
				}else{
					Ext.Msg.show({
						title:tituloCgg_gem_candidato,
						msg: 'La informaci\u00f3n no ha podido ser almacenada. '+r,
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.ERROR
					});
				}
			}
			winFrmCgg_gem_vacante_aplicar.getEl().mask('Guardando...', 'x-mask-loading');
			var param = new SOAPClientParameters();			
			param.add('inCusu_codigo',txtCusu_codigo_COD);
			param.add('inCgvcn_codigo',inRecordCgg_gem_candidato.get("CGVCN_CODIGO"));
			param.add('inCgcnd_aspiracion_salarial',numCgcnd_aspiracion_salarial.getValue());
			param.add('inCgcnd_observacion',txtCgcnd_observacion.getValue());
			SOAPClient.invoke(urlCgg_gem_candidato,'insert',param, true, CallBackCgg_gem_candidato);
		}catch(inErr){
		winFrmCgg_gem_vacante_aplicar.getEl().unmask();
		}
		}}
	});	
	/**
	* Boton que permite cerrar la ventana winFrmCgg_gem_vacante_aplicar.
	*/
	var btnCerrarCgg_gem_candidato = new Ext.Button({
		id:'btnCerrarCgg_gem_candidato',
		text:'Cerrar',
		iconCls:'iconCerrar',
		listeners:{
		click:function(){
			winFrmCgg_gem_vacante_aplicar.close();
		}}
	});
	/**
	* Ext.form.FormPanel Panel contenedor de los componentes de la ventana.
	*/
	var pnlCgg_gem_candidato = new Ext.form.FormPanel({
		id:"pnlCgg_gem_candidato",
		bodyStyle:'padding:10px',
		frame:true,			
		items:[{
				xtype: 'panel',
				layout: 'column',
				items: [{
					columnWidth: .9,
					layout: 'form',
					items: [txtCusu_codigo]
				},
				{
					columnWidth: .1,
					layout: 'form',
					items: [btnCusu_codigoCgg_gem_vacante]
				}]
			},
			numCgcnd_aspiracion_salarial,
			txtCgcnd_observacion
		]
	});
	/**
	 * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_gem_candidato.
	 */
	var winFrmCgg_gem_vacante_aplicar = new Ext.Window({
		id: 'winFrmCgg_gem_vacante_aplicar',
		title: tituloCgg_gem_candidato,
		minWidth: 450,
		bodyStyle:'padding:0px;margin:0px',
		width: 450,
		modal:true,
		resizable:false,
		constrainHeader: true,		
		tbar: getPanelTitulo(tituloCgg_gem_candidato, descCgg_gem_candidato),
		items: [pnlCgg_gem_candidato],
		bbar: [btnGuardarCgg_gem_candidato,'->', btnCerrarCgg_gem_candidato],
		listeners:{
			show:function(){
				var tmpRec = IN_RECORD_Cgg_gem_candidato.get("CGVCN_DURACION");
				var tmpD = dsDuracionTrabajo;
				for (k=0;k<tmpD.length;k++){
					if (tmpD[k][0] == tmpRec){
						IN_RECORD_Cgg_gem_candidato.set("CGVCN_DURACION_TIEMPO",IN_RECORD_Cgg_gem_candidato.get("CGVCN_DURACION_TIEMPO")+" "+tmpD[k][1]);
						break;
					}
				}
			}
		}
	});	
	/**
	 * Funcion que aplica los privilegios del usuario.
	 */
	/*applyGrants(winFrmCgg_gem_vacante_aplicar.getBottomToolbar());*/
	/**
	 * Funcion miembro que devuelve la ventana winFrmCgg_gem_vacante_aplicar.
	 * @returns ventana winFrmCgg_gem_vacante_aplicar.
	 * @base FrmCgg_gem_vacante_aplicar.prototype.show
	 */
	this.getWindow = function () {
		return winFrmCgg_gem_vacante_aplicar;
	}
	/**
	 * Funcion miembro que carga los controles de la ventana winFrmCgg_gem_vacante_aplicar.
	 * @base FrmCgg_gem_vacante_aplicar.prototype.loadData
	 */
	this.loadData = function () {
		cargarCgg_gem_candidatoCtrls();
	}
	this.getFlagAplicar = function(){
		return flagAplicar;
	}
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_gem_vacante_aplicar desde una instancia.
 */
FrmCgg_gem_vacante_aplicar.prototype.show = function () {
	this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_gem_vacante_aplicar desde una instancia.
 */
FrmCgg_gem_vacante_aplicar.prototype.close = function () {
	this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_gem_vacante_aplicar,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_gem_vacante_aplicar.prototype.closeHandler = function (inFunctionHandler) {
	this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_gem_vacante_aplicar desde una instancia.
 */
FrmCgg_gem_vacante_aplicar.prototype.loadData = function () {
	this.loadData();
}