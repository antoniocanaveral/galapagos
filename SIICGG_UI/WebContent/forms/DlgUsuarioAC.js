/**
 *FUNCION QUE PERMITE CREAR UN FORMULARIO PARA ACTUALIZAR LAS CLAVES DE USUARIO
 *@param inUser USUARIO
 *@param inOP COMPRUEBA SI DEBE O NO INGRESAR LA CLAVE ANTERIOR
 */
function DlgUsuarioAC(inUser, inOP){	
	var tituloCgg_usuario = 'Actualizar clave';
	var urlCgg_usuario = URL_WS + "Cgg_usuario";
	var tmpUserSession = inUser;
	var tmpUserID;
	var tmpUserName;
	var tmpCrper_codigo;
	var tmpCambiaClave;
	var tmpOP = inOP?true:false;
	
	var strContactosEmails = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_persona",
            method:"selectEmails",
            pagin:false
        }),
		reader:new Ext.data.JsonReader({
			},[
				{name:'email'}
			]),
        remoteSort:false,
        baseParams:{
            format:"JSON",
            inSW:0,
			inCrper_codigo:''
        }
    });
	
	if(inUser){
		tmpUserID = inUser.getUserID();
		tmpUserName = inUser.getUserName();
		tmpCambiaClave = inUser.isCambiarClave();
	}
	/**
     * Ext.form.TextField IDENTIFICATIVO VALIDO PARA INGRESO AL SISTEMA
     */
    var txtCusu_nombre_usuarioAC = new Ext.form.TextField({
        id: 'txtCusu_nombre_usuarioAC',
        name: 'txtCusu_nombre_usuarioAC',
        fieldLabel: 'Nombre de usuario',
        anchor: '98%',
        allowBlank: false,
		readOnly : true
    });
	
	/**
     * Ext.form.TextArea CLAVE DE ACCESO ANTERIOR
     */
    var txtCusu_clave_acceso_actualAC = new Ext.form.TextField({
        id: 'txtCusu_clave_acceso_actualAC',
        name: 'txtCusu_clave_acceso_actualAC',
        fieldLabel: 'Clave actual',
        width: '98%',
        allowBlank: false,
        inputType: 'password'
    });
	/**
     * Ext.form.TextArea CLAVE DE ACCESO
     */
    var txtCusu_clave_accesoAC = new Ext.form.TextField({
        id: 'txtCusu_clave_accesoAC',
        name: 'txtCusu_clave_accesoAC',
        fieldLabel: 'Clave de acceso',
        width: '98%',
        allowBlank: false,
        inputType: 'password'
    });
    /**
     * Ext.form.TextArea CLAVE DE ACCESO
     */
    var txtConfirmarClaveAC = new Ext.form.TextField({
        id: 'txtConfirmarClaveAC',
        name: 'txtConfirmarClaveAC',
        fieldLabel: 'Confirmar clave',
        width: '98%',
        allowBlank: false,
        inputType: 'password'
    });
	/**
     * Ext.form.Checkbox SI EL USUARIO DEBE CAMBIAR LA CLAVE DE ACCESO EN EL SIGUIENTE INGRESO.
     */
    var chkCusu_cambiar_claveAC = new Ext.form.Checkbox({
        id: 'chkCusu_cambiar_claveAC',
        name: 'chkCusu_cambiar_claveAC',
        fieldLabel: 'Debe cambiar la clave',
        checked: tmpOP
    });
	
	var chkEnviarNotificacion = new Ext.form.Checkbox({
        id: 'chkEnviarNotificacion',
        name: 'chkEnviarNotificacion',
        fieldLabel: 'Enviar notificaci\u00f3n',
        checked: tmpOP
    });
	
    var btnAceptarUsuarioAC = new Ext.Button({
        id:'btnAceptarUsuarioAC',
        text:'Aceptar',
        iconCls:'iconAceptar',
        handler:function (){
			if(chkEnviarNotificacion.getValue()){
					var cmContactosEmails = new Ext.grid.ColumnModel([
						{dataIndex:'email',header:'E-mail',width:200,sortable:true}
					]);
					strContactosEmails.baseParams.inCrper_codigo = tmpCrper_codigo;
					var tmpDlgBusqueda = new DlgBusquedaNoPaginado(strContactosEmails, cmContactosEmails, true);
					tmpDlgBusqueda.setTitle('Notificar a ...');
					tmpDlgBusqueda.closeHandler(function(){
						var tmpRecords = tmpDlgBusqueda.getSelectedRows();
						saveData(tmpRecords);
					});
					tmpDlgBusqueda.show();
			}else
				saveData();
			
        }
    });

	function saveData(inNotificaciones){
		var tmpEmailsJson = '[';
		if(inNotificaciones){
			for(i=0;i<inNotificaciones.length;i++){
				if(i>0)
					tmpEmailsJson += ',';
				tmpEmailsJson += Ext.util.JSON.encode(inNotificaciones[i].json);
			}
		}
		tmpEmailsJson += ']';
		function CallBackCgg_usuario(r) {
			winUsuarioAC.getEl().unmask();
			if (r == 'true') {
				Ext.Msg.show({
					title: tituloCgg_usuario,
					msg: 'La informaci\u00f3n de Usuario ha sido almacenada.',
					buttons: Ext.Msg.OK,
					icon: Ext.MessageBox.INFO
				});
				winUsuarioAC.close();
				if(!tmpOP){
					window.location="SessionManager?request=logout";
				}
			}else{
				Ext.Msg.show({
					title: tituloCgg_usuario,
					msg: 'La informaci\u00f3n de Usuario no ha podido ser almacenada. '+(r.message?r.message:r),
					buttons: Ext.Msg.OK,
					icon: Ext.MessageBox.ERROR
				});
			}
		}
		if(!(txtCusu_clave_accesoAC.getValue() == txtConfirmarClaveAC.getValue())){
			Ext.Msg.show({
				title: tituloCgg_usuario,
				msg: 'Las claves no coinciden. Por favor vuelva a intentarlo.',
				buttons: Ext.Msg.OK,
				icon: Ext.MessageBox.ERROR
			});
			return;
		}
		winUsuarioAC.getEl().mask('Guardando...', 'x-mask-loading');
		var param = new SOAPClientParameters();
		param.add('inCusu_codigo', tmpUserID);
		param.add('inCusu_clave_acceso_anterior', (tmpOP?null:txtCusu_clave_acceso_actualAC.getValue()));
		param.add('inCusu_clave_acceso', txtCusu_clave_accesoAC.getValue());
		param.add('inCusu_cambiar_clave', chkCusu_cambiar_claveAC.getValue());
		param.add('inNotificaciones', tmpEmailsJson);
		SOAPClient.invoke(urlCgg_usuario, 'updateClave', param, true, CallBackCgg_usuario);
	}
	
    var btnCancelarUsuarioAC = new Ext.Button({
        id:'btnCancelarUsuarioAC',
        text:'Cancelar',
        iconCls:'iconCancelar',
        handler:function (){
            winUsuarioAC.close();
			/*if(!tmpOP)
			window.location="SessionManager?request=logout";*/
        }
    });
	
	var pnlUsuarioAC = new Ext.form.FormPanel({
		labelWidth:110,
		frame:true,
		items:[txtCusu_nombre_usuarioAC,txtCusu_clave_acceso_actualAC,txtCusu_clave_accesoAC,txtConfirmarClaveAC]
	});
	
    var winUsuarioAC = new Ext.Window({
        id:'winUsuarioAC',
        title:tituloCgg_usuario,
        items:[pnlUsuarioAC],
        modal:true,
		resizable:false,
		width:300,
		constraint:true,
		closable:false,
        bbar:[btnAceptarUsuarioAC,'->',btnCancelarUsuarioAC],
		listeners:{
			show:function(){
				txtCusu_nombre_usuarioAC.setValue(tmpUserName);
			}
		}
    });
	
    /**
     *FUNCION MIEMBRO QUE DEVUELVE LA VENTANA winUsuarioAC
     * @returns VENTANA winUsuarioAC.
     */ 
    this.getWindow = function(){
        return winUsuarioAC;
    }
    /**
     *FUNCION QUE PERMITE ESTABLECER EL ID DE USUARIO.
     *@param inUserID ID DE USUARIO
     */
	this.setUserID = function(inUserID){
		tmpUserID = inUserID;
	}
	 /**
     *FUNCION QUE PERMITE ESTABLECER EL NOMBRE DE  USUARIO.
     *@param inUserName NOMBRE USUARIO
     */
	this.setUserName = function(inUserName){
		tmpUserName = inUserName;
		txtCusu_nombre_usuarioAC.setValue(tmpUserName);
	}
	 /**
     *FUNCION QUE PERMITE ESTABLECER LA CLAVE ANTERIOR
     */
	this.setOp = function(){
		pnlUsuarioAC.add(chkCusu_cambiar_claveAC);
		pnlUsuarioAC.add(chkEnviarNotificacion);
		chkCusu_cambiar_claveAC.setValue(true);
		chkEnviarNotificacion.setValue(true);
		tmpOP = true;
		winUsuarioAC.setTitle('Reestablecer clave');
		txtCusu_clave_acceso_actualAC.setDisabled(true);
	}
	 /**
     *FUNCION QUE PERMITE ESTABLECER CODIGO DE PERSONA.
     *@param inCrper_codigo CODIGO DE PERSONA
     */
	this.setCrper_codigo = function(inCrper_codigo){
		tmpCrper_codigo = inCrper_codigo;
	}
}

/**
 *Funcion prototipo. Permite mostrar la ventana winUsuarioAC desde una instancia.
 */
DlgUsuarioAC.prototype.show = function(){
    this.getWindow().show();
}

/**
 *Funcion prototipo. Permite cerrar la ventana winUsuarioAC desde una instancia.
 */
DlgUsuarioAC.prototype.close = function(){
    this.getWindow().close();
}

/**
 *Funcion prototipo. Permite saber si se ha cerrado la ventana winUsuarioAC,
 *con el fin de realizar otras acciones desde una instancia.
 */
DlgUsuarioAC.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 *Funcion prototipo. Permite establecer el ID de usuario.
 *@param inUserID ID DE USUARIO
 */
DlgUsuarioAC.prototype.setUserID = function(inUserID){
	this.setUserID(inUserID);
}
/**
 *Funcion prototipo. Permite establecer el nombre de usuario.
 *@param inUserName NOMBRE USUARIO
 */
DlgUsuarioAC.prototype.setUserName = function(inUserName){
	this.setUserName(inUserName);
}
/**
 *FUNCION QUE PERMITE ESTABLECER LA CLAVE ANTERIOR
 */
DlgUsuarioAC.prototype.setOp = function(){
	this.setOp();
}
/**
 *Funcion prototipo. Permite establecer el codigo de la persona
 *@param inCrper_codigo codigo de persona
 */
DlgUsuarioAC.prototype.setCrper_codigo = function(inCrper_codigo){
	this.setCrper_codigo(inCrper_codigo);
}