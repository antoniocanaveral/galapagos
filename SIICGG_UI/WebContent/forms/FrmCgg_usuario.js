/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_usuario.
 * @param {String} INSENTENCIA_CGG_USUARIO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_USUARIO Registro de datos de la tabla Cgg_usuario.
 * @constructor
 * @base FrmListadoCgg_usuario
 * @author Besixplus Cia. Ltda.
 */

function FrmCgg_usuario(INSENTENCIA_CGG_USUARIO, INRECORD_CGG_USUARIO) {
    var inSentenciaCgg_usuario = INSENTENCIA_CGG_USUARIO;
    var inRecordCgg_usuario = INRECORD_CGG_USUARIO;
    var urlCgg_usuario = URL_WS + "Cgg_usuario";
    var urlCgg_res_persona = URL_WS + "Cgg_res_persona";
    var tituloCgg_usuario = 'Usuario';
    var descCgg_usuario = 'El formulario permite administrar informaci\u00f3n de usuarios';
    var isEdit = false;
    var isNew = false;
    var tmpDependencias = new Array(6);
	var tmpContactosEliminados = new Array();
	var tmpPerfilesEliminados = new Array();
	var tmpUserSession = new UserSession();
    var tmpPersona;
    var tmpStoreTipoDocumento;
    var rFilaBeneficiarioNuevo = Ext.data.Record.create(['CRPER_CODIGO', 'CRDID_CODIGO', 'CRPER_NUM_DOC_IDENTIFIC', 'CRPER_NOMBRES', 'CRPER_APELLIDO_PATERNO', 'CRPER_APELLIDO_MATERNO', 'CRPER_GENERO', 'CRECV_CODIGO', 'CRPER_FECHA_NACIMIENTO']);
    var tmpRecordPersona = new rFilaBeneficiarioNuevo({
        CRPER_CODIGO: '',
        CRDID_CODIGO: '',
        CRPER_NUM_DOC_IDENTIFIC: '',
        CRPER_NOMBRES: '',
        CRPER_APELLIDO_PATERNO: '',
        CRPER_APELLIDO_MATERNO: '',
        CRPER_GENERO: 0,
        CRECV_CODIGO: '',
        CRPER_FECHA_NACIMIENTO: ''
    });
    
    var tmpInfoUsuario = new Ext.XTemplate(
        '<table width="100%" height="100%" cellpadding="0"> <tr> <td style="width:25%"><div class="tituloTemplate">Identificaci\u00f3n</div></td> <td style="width:25%"><div class="itemTemplate">{CRPER_NUM_DOC_IDENTIFIC}</div></td> <td style="width:25%"><div class="tituloTemplate"> Fecha Nacimiento</div></td> <td style="width:25%"><div class="itemTemplate">{[this.myDate(values.CRPER_FECHA_NACIMIENTO)]}</div> </tr> <tr> <td><div class="tituloTemplate">Nombres</div></td> <td><div class="itemTemplate">{CRPER_NOMBRES}</div></td> <td><div class="tituloTemplate">Apellidos</div></td> <td><div class="itemTemplate">{CRPER_APELLIDO_PATERNO} {CRPER_APELLIDO_MATERNO}</div></td> </tr> <tr> <td><div class="tituloTemplate">Genero</div></td> <td><div class="itemTemplate">{[this.myTipoSexo(values.CRPER_GENERO)]}</div></td> <td></td> <td></td> </tr> </table>',
        {
            disableFormats: true,
            myDate: function(CRPER_FECHA_NACIMIENTO){
                var outVal = truncDate(CRPER_FECHA_NACIMIENTO);
                if(outVal)
                    return outVal;
                return CRPER_FECHA_NACIMIENTO;
            },            
            myTipoSexo:function(inTipoSexo){
                if(inTipoSexo == TypeGenero.MASCULINO)
                    return 'MASCULINO';
                else
                    return 'FEMENINO';
            }
        }
	);
	
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
	
    var btnAddNuevaPersona = new Ext.Button({
        id: 'btnAddNuevaPersona',
        iconCls: 'iconAdjunto',
        listeners: {
            click: function () {
                var tmpInforPersona = new FrmCgg_res_beneficiario(tmpRecordPersona);
                tmpInforPersona.closeHandler(function(){
                    isNew = true;
                    txtCrper_codigo.setValue(tmpRecordPersona.get('CRPER_NUM_DOC_IDENTIFIC'));
                    document.getElementById('divInfoUsuario').innerHTML =tmpInfoUsuario.apply(tmpRecordPersona.data);
                });
                tmpInforPersona.show();
            }
        }
    });
	
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
     */
    var txtCusu_codigo = new Ext.form.TextField({
        id: 'txtCusu_codigo',
        name: 'txtCusu_codigo',
        fieldLabel: 'Codigo',
        anchor: '98%',
        allowBlank: false,
        value: "KEYGEN",
        hidden: true,
        hideLabel: true
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
     */
    var txtCrcrg_codigo = new Ext.form.TextField({
        id: 'txtCrcrg_codigo',
        name: 'txtCrcrg_codigo',
        fieldLabel: 'Cargo',
        anchor: '98%',
        readOnly: 'true'
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
     */
    var btnCrcrg_codigoCgg_usuario = new Ext.Button({
        id: 'btnCrcrg_codigoCgg_usuario',
        iconCls: 'iconBuscar',
        listeners: {
            click: function () {
                var tmpFLCgg_res_cargo = new FrmListadoCgg_res_cargo();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_cargo.getStore(), tmpFLCgg_res_cargo.getColumnModel());
                objBusqueda.closeHandler(function () {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord) {
                        txtCrcrg_codigo.setValue(tmpRecord.get('CRCRG_NOMBRE'));
                        tmpDependencias['CARGO'] = tmpRecord.get('CRCRG_CODIGO');
                    }
                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
     */
    var txtCrper_codigo = new Ext.form.TextField({
        id: 'txtCrper_codigo',
        name: 'txtCrper_codigo',
        fieldLabel: 'Numero de doc.',
        anchor: '100%',
		allowBlank:false,
        enableKeyEvents:true,
        listeners:{
            specialkey:function(inObject, inEvent){
                if (inEvent.getKey() == inEvent.ENTER) {
                    loadInfoUsuario(txtCrper_codigo.getValue());
                }
            }
        }
    });
    function loadInfoUsuario(inCRPER_CODIGO){
        function CallBackPersona(inR){
            tmpPersona = Ext.util.JSON.decode(inR);
            tmpPersona = new Ext.data.Record(tmpPersona[0]);
			tmpDependencias['PERSONA'] = tmpPersona.data.CRPER_CODIGO;
            if(tmpPersona.data.CRPER_NOMBRES){
                isNew = false;
                document.getElementById('divInfoUsuario').innerHTML =tmpInfoUsuario.apply(tmpPersona.data);
            }
        }
        var param = new SOAPClientParameters();
        param.add('inCrper_num_doc_identific', inCRPER_CODIGO);
        param.add('format', TypeFormat.JSON);
        SOAPClient.invoke(urlCgg_res_persona, 'selectNumDoc', param, true, CallBackPersona);
    }
    /**
     * CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
     */
    var btnCrper_codigoCgg_usuario = new Ext.Button({
        id: 'btnCrper_codigoCgg_usuario',
        iconCls: 'iconBuscar',
        listeners: {
            click: function () {
                var tmpFLCgg_res_persona = new Persona();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona.getStore(), tmpFLCgg_res_persona.getColumnModel());
                objBusqueda.closeHandler(function () {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord) {
                        txtCrper_codigo.setValue(tmpRecord.get('CRPER_NUM_DOC_IDENTIFIC'));
                        tmpDependencias['PERSONA'] = tmpRecord.get('CRPER_CODIGO');
                        loadInfoUsuario(txtCrper_codigo.getValue());
                    }
                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
     */
    var txtCrpjr_codigo = new Ext.form.TextField({
        id: 'txtCrpjr_codigo',
        name: 'txtCrpjr_codigo',
        fieldLabel: 'Empresa',
        anchor: '98%',
        readOnly: 'true'
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
     */
    var btnCrpjr_codigoCgg_usuario = new Ext.Button({
        id: 'btnCrpjr_codigoCgg_usuario',
        iconCls: 'iconBuscar',
        listeners: {
            click: function () {
                var tmpFLCgg_res_persona_juridica = new FrmListadoCgg_res_persona_juridica();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona_juridica.getStore(), tmpFLCgg_res_persona_juridica.getColumnModel());
                objBusqueda.closeHandler(function () {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord) {
                        txtCrpjr_codigo.setValue(tmpRecord.get('CRPJR_RAZON_SOCIAL'));
                        tmpDependencias['EMPRESA'] = tmpRecord.get('CRPJR_CODIGO');
                    }
                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
     */
    var txtCctn_codigo = new Ext.form.TextField({
        id: 'txtCctn_codigo',
        name: 'txtCctn_codigo',
        fieldLabel: 'Cant\u00f3n',
        anchor: '98%',
        readOnly: 'true',
		allowBlank:false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
     */
    var btnCctn_codigoCgg_usuario = new Ext.Button({
        id: 'btnCctn_codigoCgg_usuario',
        iconCls: 'iconBuscar',
        listeners: {
            click: function () {
                var tmpFLCgg_canton = new FrmListadoCgg_canton();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_canton.getStore(), tmpFLCgg_canton.getColumnModel());
                objBusqueda.closeHandler(function () {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord) {
                        txtCctn_codigo.setValue(tmpRecord.get('CCTN_NOMBRE'));
                        tmpDependencias['CANTON'] = tmpRecord.get('CCTN_CODIGO');
                    }
                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO VALIDO PARA INGRESO AL SISTEMA
     */
    var txtCusu_nombre_usuario = new Ext.form.TextField({
        id: 'txtCusu_nombre_usuario',
        name: 'txtCusu_nombre_usuario',
        fieldLabel: 'Nombre de usuario',
        anchor: '98%',
        allowBlank: false,
        maxLength: 20
    });
    /**
     * Ext.form.TextArea CLAVE DE ACCESO
     */
    var txtCusu_clave_acceso = new Ext.form.TextField({
        id: 'txtCusu_clave_acceso',
        name: 'txtCusu_clave_acceso',
        fieldLabel: 'Clave de acceso',
        width: '98%',
        allowBlank: false,
        inputType: 'password'
    });
    /**
     * Ext.form.TextArea CLAVE DE ACCESO
     */
    var txtConfirmarClave = new Ext.form.TextField({
        id: 'txtConfirmarClave',
        name: 'txtConfirmarClave',
        fieldLabel: 'Confirmar clave',
        width: '98%',
        allowBlank: false,
        inputType: 'password'
    });
    /**
     * Ext.form.Checkbox TIPO DE USUARIO DEFINIDO PARA ACCESO AL SISTEMA
     INTERNO
     EXTERNO
     */
    var chkCusu_usuario_interno = new Ext.form.Checkbox({
        id: 'chkCusu_usuario_interno',
        name: 'chkCusu_usuario_interno',
        fieldLabel: 'Usuario interno',
        allowBlank: false,
        checked: true
    });
    /**
     * Ext.form.Checkbox SI LA CLAVE DEL USUARIO CADUCA
     */
    var chkCusu_caduca_clave = new Ext.form.Checkbox({
        id: 'chkCusu_caduca_clave',
        name: 'chkCusu_caduca_clave',
        fieldLabel: 'Caduca clave',
        allowBlank: false,
        checked: true
    });
    /**
     * Ext.form.Checkbox SI ESTA AUTORIZO EL ACCESO AL SISTEMA O ESTA SUSPENDIDO.
     */
    var chkCusu_activo = new Ext.form.Checkbox({
        id: 'chkCusu_activo',
        name: 'chkCusu_activo',
        fieldLabel: 'Activo',
        allowBlank: false,
        checked: true
    });
	
	/**
     * Ext.form.Checkbox SI EL USUARIO DEBE CAMBIAR LA CLAVE DE ACCESO EN EL SIGUIENTE INGRESO.
     */
    var chkCusu_cambiar_clave = new Ext.form.Checkbox({
        id: 'chkCusu_cambiar_clave',
        name: 'chkCusu_cambiar_clave',
        fieldLabel: 'Debe cambiar clave',
        checked: true
    });

    /**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ISLA O CIUDAD
	*/
    var txtCisla_codigo = new Ext.form.TextField({
        id:'txtCisla_codigo',
        name:'txtCisla_codigo',
        fieldLabel :'Isla',
        anchor:'98%',
        readOnly:'true'
    });
    /**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ISLA O CIUDAD
	*/
    var btnCisla_codigoCgg_usuario = new Ext.Button({
        id:'btnCisla_codigoCgg_usuario',        
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_isla = new FrmListadoCgg_isla();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_isla.getStore(),tmpFLCgg_isla.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpDependencias['ISLA'] = tmpRecord.get('CISLA_CODIGO');
                        txtCisla_codigo.setValue(tmpRecord.get('CISLA_NOMBRE'));

                    }
                });
                objBusqueda.show();
            }
        }
    });

    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_usuario
     */
    var btnGuardarCgg_usuario = new Ext.Button({
        id: 'btnGuardarCgg_usuario',
        text: 'Guardar',
        iconCls: 'iconGuardar',
        listeners: {
            click: function () {
                if (pnlCgg_usuario.getForm().isValid() == false) {
                    return;
                }
				if(!isEdit){
					var cmContactosEmails = new Ext.grid.ColumnModel([
						{dataIndex:'email',header:'E-mail',width:200,sortable:true}
					]);
					strContactosEmails.baseParams.inCrper_codigo = tmpDependencias['PERSONA'];
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
			winFrmCgg_usuario.getEl().unmask();
			if (r == 'true') {
				Ext.Msg.show({
					title: tituloCgg_usuario,
					msg: 'La informaci\u00f3n de Usuario ha sido almacenada.',
					buttons: Ext.Msg.OK,
					icon: Ext.MessageBox.INFO
				});
				winFrmCgg_usuario.close()
			} else {
				Ext.Msg.show({
					title: tituloCgg_usuario,
					msg: 'La informaci\u00f3n de Usuario no ha podido ser almacenada. '+(r.message?r.message:r),
					buttons: Ext.Msg.OK,
					icon: Ext.MessageBox.ERROR
				});
			}
		}
		if(txtCusu_clave_acceso.getValue() != txtConfirmarClave.getValue() && !isEdit){
			Ext.Msg.show({
				title: tituloCgg_usuario,
				msg: 'Las claves no coinciden. Por favor vuelva a intentarlo.',
				buttons: Ext.Msg.OK,
				icon: Ext.MessageBox.ERROR
			});
			return;
		}
		winFrmCgg_usuario.getEl().mask('Guardando...', 'x-mask-loading');
		var param = new SOAPClientParameters();
		if (isEdit) param.add('inCusu_codigo', txtCusu_codigo.getValue());
		if (tmpDependencias['CARGO']) param.add('inCrcrg_codigo', tmpDependencias['CARGO']);
		else param.add('inCrcrg_codigo', null);
		if (tmpDependencias['PERSONA'] && !isNew) param.add('inCrper_codigo', tmpDependencias['PERSONA'])
		else param.add('inCrper_codigo', null);
		if (tmpDependencias['EMPRESA']) param.add('inCrpjr_codigo', tmpDependencias['EMPRESA']);
		else param.add('inCrpjr_codigo', null);
		if (tmpDependencias['CANTON']) param.add('inCctn_codigo', tmpDependencias['CANTON']);
		else param.add('inCctn_codigo', null);
		param.add('inCisla_codigo', tmpDependencias['ISLA']?tmpDependencias['ISLA']:null);
		param.add('inCusu_nombre_usuario', txtCusu_nombre_usuario.getValue());
		param.add('inCusu_clave_acceso', txtCusu_clave_acceso.getValue());
		param.add('inCusu_usuario_interno', chkCusu_usuario_interno.getValue());
		param.add('inCusu_caduca_clave', chkCusu_caduca_clave.getValue());
		param.add('inCusu_activo', chkCusu_activo.getValue());
		param.add('inCusu_cambiar_clave',chkCusu_cambiar_clave.getValue());
		param.add('inContactos', gsCgg_sec_usuario_contacto.getJsonData());
		param.add('inContactosEliminados', tmpContactosEliminados.toJSON());
		param.add('inPerfiles', gsCgg_usuario_rol.getJsonData());
		param.add('inPerfilesEliminados', tmpPerfilesEliminados.toJSON());
		if(!isEdit){
			param.add('inPersona', Ext.util.JSON.encode(tmpRecordPersona.data));
		}
		param.add('inNotificaciones',tmpEmailsJson);
		SOAPClient.invoke(urlCgg_usuario, INSENTENCIA_CGG_USUARIO, param, true, CallBackCgg_usuario);
	}
	
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_usuario.
     */
    var btnCancelarCgg_usuario = new Ext.Button({
        id: 'btnCancelarCgg_usuario',
        text: 'Cancelar',
        iconCls: 'iconCancelar',
        listeners: {
            click: function () {
                pnlCgg_usuario.getForm().reset();
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_usuario.
     */
    var btnCerrarCgg_usuario = new Ext.Button({
        id: 'btnCerrarCgg_usuario',
        text: 'Cerrar',
        iconCls: 'iconCerrar',
        listeners: {
            click: function () {
                winFrmCgg_usuario.close();
            }
        }
    });
    var pnlAcceso = new Ext.Panel({
        title: 'Acceso',
        layout: 'form',
        frame: true,
        labelWidth: 110,
        items: [txtCusu_nombre_usuario, 
        txtCusu_clave_acceso,
        txtConfirmarClave]
    });
	var pnlUsuarioOpciones = new Ext.Panel({
		id:'pnlUsuarioOpciones',
        title: 'Opciones',
        layout: 'form',
        frame: true,
        labelWidth: 120,
        items: [chkCusu_activo,
			chkCusu_caduca_clave,
			chkCusu_usuario_interno,
			chkCusu_cambiar_clave]
    });
    var pnlDependencias = new Ext.Panel({
        title: 'Dependencias',
        labelWidth: 100,
        frame: true,
        items: [{
            xtype: 'panel',
            layout: 'column',
            items: [{
                columnWidth: .9,
                layout: 'form',
                items: [txtCrcrg_codigo]
            },

            {
                columnWidth: .1,
                layout: 'form',
                items: [btnCrcrg_codigoCgg_usuario]
            }]
        },

        {
            xtype: 'panel',
            layout: 'column',
            items: [{
                columnWidth: .9,
                layout: 'form',
                items: [txtCrpjr_codigo]
            },

            {
                columnWidth: .1,
                layout: 'form',
                items: [btnCrpjr_codigoCgg_usuario]
            }]
        },
        {
            xtype: 'panel',
            layout: 'column',
            items: [{
                columnWidth: .9,
                layout: 'form',
                items: [txtCctn_codigo]
            },
            {columnWidth: .1,layout: 'form',items: [btnCctn_codigoCgg_usuario]}]
        },{
            xtype: 'panel',
            layout: 'column',
            items: [{columnWidth: .9,layout: 'form',items: [txtCisla_codigo]},
            {columnWidth: .1,layout: 'form',items: [btnCisla_codigoCgg_usuario]}]
        }]
    });
	/**
     * Ext.ux.grid.RowEditor Edito de filas personalizado para utilizaci�n en el grid de contacto
     */
    var reContacto= new Ext.ux.grid.RowEditor({
        saveText: 'Aceptar',
        cancelText:'Cancelar',
		errorSummary: false,
        listeners:{
            afteredit:function(inRowEditor,inObject,inRecord,inRowIndex){
			},
            canceledit:function(inRowEditor,inFlag,inRecord){
                var inRecord = grdCgg_sec_usuario_contacto.getStore().getAt(0);
                if (inRecord.get('CSUCT_CODIGO') == 'KEYGEN')
                    grdCgg_sec_usuario_contacto.getStore().remove(inRecord);
            }
        }
    });
	/**
     *Ext.form.ComboBox Combo para edicion de tipo de contacto.
     */
    var cbxCRTCO_CODIGOEditor = new Ext.form.ComboBox({
        id:'cbxCRTCO_CODIGOEditor',
        store: SCGG_RES_TIPO_CONTACTO,
        displayField:'CRTCO_NOMBRE',
        typeAhead: true,
        mode:'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione un tipo',
        selectOnFocus:true,
        valueField:'CRTCO_CODIGO'
    });

	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_sec_usuario_contacto.
	*/
	var cmCgg_sec_usuario_contacto = new Ext.grid.ColumnModel([
		{dataIndex:'CRTCO_CODIGO',header:'Tipo',width:100,sortable:true,editor:cbxCRTCO_CODIGOEditor,renderer:
                function(value, metaData, record){
                    if (value){
                        var tmpHtml = null;
                        var tmpNombreImagen = null;
                        var rTipoContaco= record;
                        try{
                            rTipoContaco=SCGG_RES_TIPO_CONTACTO.getAt(SCGG_RES_TIPO_CONTACTO.findExact('CRTCO_CODIGO',value));
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
		{dataIndex:'CSUCT_CONTACTO',header:'Contacto',width:150,sortable:true,editor:new Ext.form.TextField({allowBlank:false,maxLength:100})},
		{dataIndex:'CSUCT_OBSERVACION',header:'Observaci\u00f3n',width:150,sortable:true,editor:new Ext.form.TextField({})}
	]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_sec_usuario_contacto por un campo especifico.
	*/
	var gsCgg_sec_usuario_contacto = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_sec_usuario_contacto",
					method:"selectPageDirect",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CSUCT_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CSUCT_CODIGO'},
				{name:'CUSU_CODIGO'},
				{name:'CRTCO_CODIGO'},
				{name:'CSUCT_CONTACTO'},
				{name:'CSUCT_OBSERVACION'}
			]),
			sortInfo:{field: 'CUSU_CODIGO', direction: 'ASC'},
			baseParams:{keyword:'',format:'JSON',inCusu_codigo:''}
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_sec_usuario_contacto en un formato tabular de filas y columnas.
	*/
	var grdCgg_sec_usuario_contacto = new Ext.grid.GridPanel({
		title:'Contactos',
			cm:cmCgg_sec_usuario_contacto,
			store:gsCgg_sec_usuario_contacto,
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
			tbar: [{iconCls:'iconNuevo',tooltip:'Agregar contacto',handler:function(){
				var tmpRecordCriterio = grdCgg_sec_usuario_contacto.getStore().recordType;
                reContacto.stopEditing();
                grdCgg_sec_usuario_contacto.getStore().insert(0,
                        new tmpRecordCriterio({
                            CSUCT_CODIGO: 'KEYGEN',
                            CUSU_CODIGO: txtCusu_codigo.getValue(),
                            CRTCO_CODIGO: '',
							CSUCT_CONTACTO: '',
                            CSUCT_OBSERVACION: ''
                        })
                        );
                grdCgg_sec_usuario_contacto.getSelectionModel().selectRow(0);
                reContacto.startEditing(0);
			}},{iconCls:'iconEliminar',handler:function(){
				var tmpRecord = grdCgg_sec_usuario_contacto.getSelectionModel().getSelected();
				if(tmpRecord && tmpRecord.data.CSUCT_CODIGO != 'KEYGEN')
					tmpContactosEliminados.push(tmpRecord.data.CSUCT_CODIGO);
				grdCgg_sec_usuario_contacto.getStore().remove(tmpRecord);
				}
			}
			],
			listeners:{
				rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
					if(!btnEditarCgg_sec_usuario_contacto.disabled){
						btnEditarCgg_sec_usuario_contacto.fireEvent('click', btnEditarCgg_sec_usuario_contacto);
					}
				}				
			},
			plugins:[reContacto]
	});
	/**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_sec_perfil_rol.
     */
    var cmCgg_sec_perfil_rol = new Ext.grid.ColumnModel([
		{dataIndex: 'ROL',header: 'Rol',width: 250,sortable: true}
	]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_sec_perfil_rol por un campo especifico.
     */
    var gsCgg_usuario_rol = new Ext.data.Store({
        proxy: new Ext.ux.bsx.SoapProxy({
            url: URL_WS + "Cgg_sec_usuario_rol",
            method: "selectPageUsuario",
            pagin: true
        }),
        remoteSort: true,
        reader: new Ext.data.JsonReader({
            id: 'CSPER_CODIGO',
            root: 'dataSet',
            totalProperty: 'totalCount'
        }, [
            {name: 'CSPER_CODIGO'},
			{name: 'CSROL_CODIGO'},
			{name: 'ROL'}
        ]),
        sortInfo: {
            field: 'ROL',
            direction: 'ASC'
        },
        baseParams: {
            keyword: "",
            format: 'JSON',
			inCusu_codigo:''
        }
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_sec_perfil_rol en un formato tabular de filas y columnas.
     */
    var grdCgg_usuario_rol = new Ext.grid.GridPanel({
		title:'Roles',
        cm: cmCgg_sec_perfil_rol,
        store: gsCgg_usuario_rol,
        region: 'center',
        sm: new Ext.grid.RowSelectionModel({
            singleSelect: true
        }),
        loadMask: {
            msg: "Cargando..."
        },
		tbar:[{iconCls:'iconNuevo',handler:function(){
				var tmpFLCgg_sec_rol = new FrmListadoCgg_sec_rol();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_sec_rol.getStore(), tmpFLCgg_sec_rol.getColumnModel());
                objBusqueda.closeHandler(function () {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord && !gsCgg_usuario_rol.getAt(gsCgg_usuario_rol.findExact('ROL',tmpRecord.data.CSROL_NOMBRE))){
						var tmpRecordRol = grdCgg_usuario_rol.getStore().recordType;
						grdCgg_usuario_rol.getStore().insert(0,
							new tmpRecordRol({
								CSPER_CODIGO: 'KEYGEN',
								CSROL_CODIGO: tmpRecord.data.CSROL_CODIGO,
								ROL:tmpRecord.data.CSROL_NOMBRE
							})
                        );
					}
                });
                objBusqueda.show();
			}},{iconCls:'iconEliminar',handler:function(){
				var tmpRecord = grdCgg_usuario_rol.getSelectionModel().getSelected();
				if(tmpRecord && tmpRecord.data.CSPER_CODIGO != 'KEYGEN')
					tmpPerfilesEliminados.push(tmpRecord.data.CSPER_CODIGO);
				grdCgg_usuario_rol.getStore().remove(tmpRecord);
			}}
		]
    });
    gsCgg_usuario_rol.reload({
        params: {
            start: 0,
            limit: RECORD_PAGE,
			inCusu_codigo:''
        }
    });
    var tblUsuario = new Ext.TabPanel({
        region: 'center',
        activeTab: 0,
        height: 170,
        items: [pnlAcceso, pnlUsuarioOpciones, pnlDependencias,grdCgg_sec_usuario_contacto,grdCgg_usuario_rol]
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_usuario.
     */
    var pnlCgg_usuario = new Ext.form.FormPanel({
        region: 'north',
        layout: 'form',
        frame: true,
        border: false,
        labelWidth: 100,
		height:140,
        items: [{
            xtype: 'panel',
            layout: 'column',
            items: [{columnWidth: .86,layout: 'form',items: [txtCrper_codigo]},
				{columnWidth: .07,layout: 'form',items: [btnCrper_codigoCgg_usuario]},
				{columnWidth: .07,layout: 'form',items: [btnAddNuevaPersona]}
			]
		},{
			xtype:'panel',
			height:90,
            html:'<div id="divInfoUsuario" style="padding:0px 0px 0px 0px;"></div>'
        }
        ]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_usuario.
     */
    var winFrmCgg_usuario = new Ext.Window({
        id: 'winFrmCgg_usuario',
        title: tituloCgg_usuario,
        tbar: getPanelTitulo(tituloCgg_usuario, descCgg_usuario),
        layout: 'border',
        items: [pnlCgg_usuario, tblUsuario],
        width: 460,
        minWidth: 400,
        height: 400,
        minHeight: 300,
        resizable: true,
        modal: true,
        constrain: true,
        bbar: [btnGuardarCgg_usuario, btnCancelarCgg_usuario, '->', btnCerrarCgg_usuario]
    });
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_usuario.
     */
    function cargarCgg_usuarioCtrls() {
        if (inRecordCgg_usuario) {
            tmpDependencias['CARGO'] = inRecordCgg_usuario.get('CRCRG_CODIGO');
            tmpDependencias['PERSONA'] = inRecordCgg_usuario.get('CRPER_CODIGO');
            tmpDependencias['EMPRESA'] = inRecordCgg_usuario.get('CRPJR_CODIGO');
            tmpDependencias['CANTON'] = inRecordCgg_usuario.get('CCTN_CODIGO');
            tmpDependencias['ISLA'] = inRecordCgg_usuario.get('CISLA_CODIGO');
            txtCusu_codigo.setValue(inRecordCgg_usuario.get('CUSU_CODIGO'));
            txtCrcrg_codigo.setValue(inRecordCgg_usuario.get('CRCRG_NOMBRE'));
            txtCrper_codigo.setValue(inRecordCgg_usuario.get('CRPER_NUM_DOC_IDENTIFIC'));
            txtCrpjr_codigo.setValue(inRecordCgg_usuario.get('CRPJR_RAZON_SOCIAL'));
            txtCctn_codigo.setValue(inRecordCgg_usuario.get('CCTN_NOMBRE'));
            txtCusu_nombre_usuario.setValue(inRecordCgg_usuario.get('CUSU_NOMBRE_USUARIO'));
            txtCusu_clave_acceso.setValue(inRecordCgg_usuario.get('CUSU_CLAVE_ACCESO'));
            chkCusu_usuario_interno.setValue(inRecordCgg_usuario.get('CUSU_USUARIO_INTERNO'));
            chkCusu_caduca_clave.setValue(inRecordCgg_usuario.get('CUSU_CADUCA_CLAVE'));
            chkCusu_activo.setValue(inRecordCgg_usuario.get('CUSU_ACTIVO'));
			chkCusu_cambiar_clave.setValue(inRecordCgg_usuario.get('CUSU_CAMBIAR_CLAVE'));
			txtCisla_codigo.setValue(inRecordCgg_usuario.get('CISLA_NOMBRE'));
            isEdit = true;
            txtCusu_nombre_usuario.setReadOnly(isEdit);
            txtCusu_clave_acceso.setReadOnly(isEdit);
            txtConfirmarClave.setReadOnly(isEdit);
            loadInfoUsuario(inRecordCgg_usuario.get('CRPER_NUM_DOC_IDENTIFIC'));
			
			gsCgg_sec_usuario_contacto.baseParams.start = 0;
			gsCgg_sec_usuario_contacto.baseParams.limit = 1000;
			gsCgg_sec_usuario_contacto.baseParams.inCusu_codigo = inRecordCgg_usuario.data.CUSU_CODIGO;
			gsCgg_sec_usuario_contacto.reload();
			
			gsCgg_usuario_rol.reload({
							params: {
								start: 0,
								limit: RECORD_PAGE,
								format: 'JSON',
								inCusu_codigo:inRecordCgg_usuario.data.CUSU_CODIGO
							}
						});
        }
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_usuario.
     * @returns ventana winFrmCgg_usuario.
     * @base FrmCgg_usuario.prototype.show
     */
    this.getWindow = function () {
        return winFrmCgg_usuario;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_usuario.
     * @base FrmCgg_usuario.prototype.loadData
     */
    this.loadData = function () {
        cargarCgg_usuarioCtrls();
    }
    
    this.setStoreTipoDoc = function(inStore){
        tmpStoreTipoDocumento = inStore;
    }
	
	this.loadInfoPersona = function(inPersona){
		tmpDependencias['PERSONA'] = inPersona.data.CRPER_CODIGO;
		txtCrper_codigo.setValue(inPersona.data.CRPER_NUM_DOC_IDENTIFIC);
		loadInfoUsuario(inPersona.data.CRPER_NUM_DOC_IDENTIFIC);
		btnAddNuevaPersona.setDisabled(true);
		btnCrper_codigoCgg_usuario.setDisabled(true);
		chkCusu_usuario_interno.setValue(false);
		chkCusu_usuario_interno.setDisabled(true);
		txtCrper_codigo.setReadOnly(true);
	}
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_usuario desde una instancia.
 */
FrmCgg_usuario.prototype.show = function () {
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_usuario desde una instancia.
 */
FrmCgg_usuario.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_usuario,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_usuario.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_usuario desde una instancia.
 */
FrmCgg_usuario.prototype.loadData = function () {
    this.loadData();
}
/**
 * Funcion prototipo. Carga la informacion de la persona indicada.
 */
FrmCgg_usuario.prototype.loadInfoPersona = function(inIdentificacion){
	this.loadInfoPersona(inIdentificacion);
}

FrmCgg_usuario.prototype.setStoreTipoDoc = function (inStore) {
    this.setStoreTipoDoc(inStore);
}
