/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_deposito_garantia.
 * @param {String} INSENTENCIA_CGG_RES_DEPOSITO_GARANTIA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_DEPOSITO_GARANTIA Registro de datos de la tabla Cgg_res_deposito_garantia.
 * @constructor
 * @base FrmListadoCgg_res_deposito_garantia
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_deposito_garantia(INSENTENCIA_CGG_RES_DEPOSITO_GARANTIA,INRECORD_CGG_RES_DEPOSITO_GARANTIA){
    var inSentenciaCgg_res_deposito_garantia = INSENTENCIA_CGG_RES_DEPOSITO_GARANTIA;
    var inRecordCgg_res_deposito_garantia=INRECORD_CGG_RES_DEPOSITO_GARANTIA;
    var urlCgg_res_deposito_garantia=URL_WS+"Cgg_res_deposito_garantia";
    var tituloCgg_res_deposito_garantia='Dep\u00F3sito garant\u00EDa';
    var descCgg_res_deposito_garantia='El formulario permite administrar informaci\u00f3n de dep\u00F3sito por garant\u00EDas para residencia';
    var isEdit = false;
    var tmpTotal = 0;
    var tmpCuenta;
    var tmpPersonaJuridica;
    var tmpPersonaAuspiciante;
    var tmpEmpresaAuspiciante;
    var dialogResult = null;
    var valor =0;
    var esTmp = false;
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO DE GARANTIA
     */
    var txtCrdpt_codigo = new Ext.form.TextField({
        id:'txtCrdpt_codigo',
        name:'txtCrdpt_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CUENTA
     */
    var txtCrcpj_codigo = new Ext.form.TextField({
        id:'txtCrcpj_codigo',
        name:'txtCrcpj_codigo',
        fieldLabel :'Cuenta',
        anchor:'100%',
        readOnly:'true'
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE CUENTA
     */
    var btnCrcpj_codigoCgg_res_deposito_garantia = new Ext.Button({
        id:'btnCrcpj_codigoCgg_res_deposito_garantia',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_res_cuenta_personajuridica = new FrmListadoCgg_res_cuenta_personajuridica();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_cuenta_personajuridica.getStore(),tmpFLCgg_res_cuenta_personajuridica.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpCuenta = tmpRecord.get('CRCPJ_CODIGO');
                        tmpPersonaJuridica = tmpRecord.get('CGG_CRPJR_CODIGO');
                        txtCrcpj_codigo.setValue(tmpRecord.get('CRCPJ_NUMERO_CUENTA'));
                        txtDPTCrpjr_codigo.setValue(tmpRecord.get('CRPJR_RAZON_SOCIAL'));
                    }
                });
                objBusqueda.show();
            }
        }
    });
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	*/
	var txtDPTCrpjr_codigo = new Ext.form.TextField({
		id:'txtDPTCrpjr_codigo',
		name:'txtDPTCrpjr_codigo',
		fieldLabel :'Entidad',
		anchor:'100%',
		readOnly:'true'
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	*/
	var btnCrpjr_codigoCgg_res_deposito_garantia = new Ext.Button({
		id:'btnCrpjr_codigoCgg_res_deposito_garantia',
		iconCls:'iconBuscar',
		listeners:{
		click:function(){
			var tmpFLCgg_res_persona_juridica = new FrmListadoCgg_res_persona_juridica();
			var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona_juridica.getStore(),tmpFLCgg_res_persona_juridica.getColumnModel());
			objBusqueda.closeHandler(function(){
				var tmpRecord = objBusqueda.getSelectedRow();
				if(tmpRecord){
					tmpCuenta = null;
					tmpPersonaJuridica = tmpRecord.get('CRPJR_CODIGO');
					txtDPTCrpjr_codigo.setValue(tmpRecord.get('CRPJR_RAZON_SOCIAL'));
					txtCrcpj_codigo.setValue(null);
				}
			});
			objBusqueda.show();
		}}
	});
        /**
        * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA NATURAL QUE REALIZO 
        */
        var txtDPTCrper_codigo = new Ext.form.TextField({
                        id:'txtDPTCrper_codigo',
                        name:'txtDPTCrper_codigo',
                        fieldLabel :'Persona',
                        anchor:'100%',
                        readOnly:'true'
        });
        /**
        * CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA NATURAL QUE REALIZO 
        */
        var btnCrper_codigoCgg_res_deposito_garantia = new Ext.Button({
                        id:'btnCrper_codigoCgg_res_deposito_garantia',
                        iconCls:'iconBuscar',
                        listeners:{
                                click:function(){
                                        var tmpFLCgg_res_persona = new Persona();
                                        var tmpStore = tmpFLCgg_res_persona.getStore();
                                        tmpStore.baseParams.inCarnet = true;
                                        var objBusqueda = new DlgBusqueda(tmpStore,tmpFLCgg_res_persona.getColumnModel());
                                        objBusqueda.closeHandler(function(){
                                                        var tmpRecord = objBusqueda.getSelectedRow();
                                                        if(tmpRecord){
                                                                tmpEmpresaAuspiciante = null;
                                                                tmpPersonaAuspiciante = tmpRecord.get('CRPER_CODIGO');
                                                                txtDPTCrper_codigo.setValue(tmpRecord.data.CRPER_NOMBRES+' '+tmpRecord.data.CRPER_APELLIDO_PATERNO+' '+tmpRecord.data.CRPER_APELLIDO_MATERNO);
                                                                txtCgg_crpjr_codigo.setValue(null);
                                                        }
                                        });
                                        objBusqueda.show();
                        }}
        });
        /**
        * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA QUE REALIZO EL DEPOSITO
        */
        var txtCgg_crpjr_codigo = new Ext.form.TextField({
                        id:'txtCgg_crpjr_codigo',
                        name:'txtCgg_crpjr_codigo',
                        fieldLabel :'Empresa',
                        anchor:'100%',
                        readOnly:'true'
        });
        /**
        * IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA QUE REALIZO EL DEPOSITO
        */
        var btnCgg_crpjr_codigoCgg_res_deposito_garantia = new Ext.Button({
                        id:'btnCgg_crpjr_codigoCgg_res_deposito_garantia',
                        iconCls:'iconBuscar',
                        listeners:{
                                click:function(){
                                        var tmpFLCgg_res_persona_juridica = new FrmListadoCgg_res_persona_juridica();
                                        var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona_juridica.getStore(),tmpFLCgg_res_persona_juridica.getColumnModel());
                                        objBusqueda.closeHandler(function(){
                                                        var tmpRecord = objBusqueda.getSelectedRow();
                                                        if(tmpRecord){
                                                                tmpEmpresaAuspiciante = tmpRecord.get('CRPJR_CODIGO');
                                                                txtCgg_crpjr_codigo.setValue(tmpRecord.data.CRPJR_RAZON_SOCIAL);
                                                                
                                                                //Consulta el representante legal
                                                                var scpRepresentante = new SOAPClientParameters({
                                                                        inCrpjr_codigo:tmpRecord.data.CRPJR_CODIGO,
                                                                        format:TypeFormat.JSON
                                                                });
                                        
                                                                var tmpRepresentante = SOAPClient.invoke(URL_WS+'Cgg_res_representante_legal', 'selectRepresentantePersona', scpRepresentante, false, null);
                                                                tmpRepresentante = Ext.util.JSON.decode(tmpRepresentante);
                                                                if(tmpRepresentante.length > 0){
                                                                        tmpPersonaAuspiciante = tmpRepresentante[0].CRPER_CODIGO;
                                                                        txtDPTCrper_codigo.setValue(tmpRepresentante[0].CRPER_NOMBRES);
                                                                }else{
                                                                        tmpPersonaAuspiciante = null;
                                                                        txtDPTCrper_codigo.setValue(null);
                                                                }
                                                        }
                                        });
                                        objBusqueda.show();
                        }}
        });       
    /**
	* Ext.form.TextField NUMERO ALFANUMERICO SECUENCIAL GENERADO CON FINES DE INDICAR A QUE REFERENCIA HACE UN TRAMITE AL MOMENTO DE SU CREACION.
	*/
    var txtCrdpt_numero = new Ext.form.TextField({
        id:'txtCrdpt_numero',
        name:'txtCrdpt_numero',
        fieldLabel :'N\u00FAmero',
        anchor:'98%',
        value:0,
        readOnly:true
    });
        
    /**
     * Ext.form.TextField NUMERO DE DOCUMENTO DE DEPOSITO
     */
    var txtCrdpt_numero_documento = new Ext.form.TextField({
        id:'txtCrdpt_numero_documento',
        name:'txtCrdpt_numero_documento',
        fieldLabel :'Num. documento',
        anchor:'98%',
        maxLength:20
    });
	/**
	* Ext.form.Checkbox SI LA GARANTIA CADUCA
	*/
	var chkCrdpt_caduca = new Ext.form.Checkbox({
			id:'chkCrdpt_caduca',
			name:'chkCrdpt_caduca',
			fieldLabel :'Caduca',
			allowBlank :false,
			listeners:{
				check:function(inSource, inChecked){
					dtCrdpt_fecha_caducidad.setDisabled(!inChecked);
				}
			}
	});
    /**
     * Ext.form.NumberField VALOR DEPOSITADO POR GARANTIA
     */
    var numCrdpt_valor_deposito = new Ext.form.NumberField({
        id:'numCrdpt_valor_deposito',
        nname:'numCrdpt_valor_deposito',
        fieldLabel :'Valor dep\u00F3sito',
        allowBlank :false,
        disabled:false,
        anchor:'98%',
        value:valor
    });
    /**
     * Ext.form.DateField FECHA DE REALIZACION DE DEPOSITO
     */
    var dtCrdpt_fecha_deposito = new Ext.form.DateField({
        id:'dtCrdpt_fecha_deposito',
        name:'dtCrdpt_fecha_deposito',
        fieldLabel :'Dep\u00F3sito',
        anchor:'98%',
        allowBlank :false,
        format:'d/m/Y',
        value:CURRENT_DATE
    });
    /**
     * Ext.form.DateField FECHA DE ENTREGA DE COMPROBANTE DE DEPOSITO
     */
    var dtCrdpt_fecha_entrega = new Ext.form.DateField({
        id:'dtCrdpt_fecha_entrega',
        name:'dtCrdpt_fecha_entrega',
        fieldLabel :'Recepci\u00F3n',
        anchor:'98%',
        allowBlank :false,
        format:'d/m/Y',
        value:CURRENT_DATE,
		maxValue:CURRENT_DATE
    });
    /**
     * Ext.form.DateField FECHA DE CADUCIDAD DEL DEPOSITO DE GARANTIA
     */
    var dtCrdpt_fecha_caducidad = new Ext.form.DateField({
        id:'dtCrdpt_fecha_caducidad',
        name:'dtCrdpt_fecha_caducidad',
        fieldLabel :'Caducidad',
        anchor:'98%',
        allowBlank :false,
        format:'d/m/Y',
        value:CURRENT_DATE,
		disabled:true
    });
    /**
     * Ext.form.DateField FECHA DE INGRESO A CUSTODIA DEL DEPARTAMENTO FINANCIERO
     */
    var dtCrdpt_fecha_contabilizacion = new Ext.form.DateField({
        id:'dtCrdpt_fecha_contabilizacion',
        name:'dtCrdpt_fecha_contabilizacion',
        fieldLabel :'Contabilizaci\u00F3n',
        anchor:'98%',
        allowBlank :true,
        format:'d/m/Y',
        value:CURRENT_DATE
    });
    /**
     * Ext.form.DateField FECHA DE SOLICITUD DE DEVOLUCION DE GARANTIA
     */
    var dtCrdpt_fecha_solic_devolucion = new Ext.form.DateField({
        id:'dtCrdpt_fecha_solic_devolucion',
        name:'dtCrdpt_fecha_solic_devolucion',
        fieldLabel :'Devoluci\u00F3n',
        anchor:'98%',
        allowBlank :true,
        format:'d/m/Y',
        value:CURRENT_DATE
    });
    /**
     * Ext.form.DateField FECHA DE DEVOLUCION DE LA GARANTIA AL TITULAR
     */
    var dtCrdpt_fecha_devolucion_definiti = new Ext.form.DateField({
        id:'dtCrdpt_fecha_devolucion_definiti',
        name:'dtCrdpt_fecha_devolucion_definiti',
        fieldLabel :'Devoluci\u00F3n efectiva',
        anchor:'98%',
        format:'d/m/Y',
        allowBlank :true,
        value:CURRENT_DATE
    });
    /**
     * Ext.form.Checkbox ESTADO QUE DETERMINA SI UNA GARANTIA ESTA AUN ACTIVA
     * SI
     * NO
     */
    var chkCrdpt_devuelto = new Ext.form.Checkbox({
        id:'chkCrdpt_devuelto',
        name:'chkCrdpt_devuelto',
        fieldLabel :'Devuelto',
        allowBlank :false,
        checked:false,
        disabled:true
    });
    /**
     * Ext.form.NumberField ESTADO DE CONTROL DEL DEPOSITO
REGISTRADO
AUTORIZADO
DEVUELTO
     */
    
    var cbxEstadoDeposito = new Ext.form.ComboBox({
        fieldLabel :'Estado dep\u00F3sito',
        typeAhead: true,
        triggerAction: 'all',
        lazyRender:true,
        mode: 'local',
        anchor:'98%',
        disabled:true,
        editable:false,
        emptyText:'Seleccione estado...',
        store: dsEstadoDeposito,
        value:0
    });
	/**
	* Ext.form.NumberField TIPO DE GARANTIA
	0 - DEPOSITO
	1 - CHEQUE
	2 - POLIZA
	3 - OTROS
	*/
	var cbxCrdpt_tipo = new Ext.form.ComboBox({
        fieldLabel :'Tipo',
        typeAhead: true,
        triggerAction: 'all',
        lazyRender:true,
        mode: 'local',
        anchor:'98%',
        editable:false,
        forceSelection:true,
        emptyText:'Seleccione tipo...',
        store:dsTipoGarantia
    });
	cbxCrdpt_tipo.setValue(0);

    /**
     * Ext.form.TextArea OBSERVACION DEL DEPOSITO DE GARANTIA
     */
    var txtCrdpt_observacion = new Ext.form.TextArea({
        title:'Observaciones',
        id:'txtCrdpt_observacion',
        name:'txtCrdpt_observacion',
        fieldLabel :'Observaci\u00F3n',
        width:'98%'
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_deposito_garantia
     */
    var btnGuardarCgg_res_deposito_garantia = new Ext.Button({
        id:'btnGuardarCgg_res_deposito_garantia',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_res_deposito_garantia.getForm().isValid()==false){
                    return;
                }
                if(tmpTotal > 0 && numCrdpt_valor_deposito.getValue() < tmpTotal ){
                    Ext.Msg.show({
                        title:tituloCgg_res_deposito_garantia,
                        msg: 'El valor de la garant\u00eda no cubre todos los tramites asociados.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.INFO
                    });
                    return;
                }
                if(!txtCrcpj_codigo.getValue() && !txtDPTCrpjr_codigo.getValue() ){
                    Ext.Msg.show({
                        title:tituloCgg_res_deposito_garantia,
                        msg: 'Por favor especifique la entidad financiera.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.INFO
                    });
                    return;
                }
                if(!txtDPTCrper_codigo.getValue() && !txtCgg_crpjr_codigo.getValue() ){
                    Ext.Msg.show({
                        title:tituloCgg_res_deposito_garantia,
                        msg: 'Por favor especifique el propietario de la garant\u00EDa.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.INFO
                    });
                    return;
                }
                try{
                    function CallBackCgg_res_deposito_garantia(r){
                        winFrmCgg_res_deposito_garantia.getEl().unmask();
                        r = Ext.util.JSON.decode(r);
                        if(r.success == true || (isEdit && r)){
                            Ext.Msg.show({
                                title:tituloCgg_res_deposito_garantia,
                                msg: 'La informaci\u00f3n de dep\u00F3sito garant\u00EDa ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            dialogResult = r.objData;
                            winFrmCgg_res_deposito_garantia.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_res_deposito_garantia,
                                msg: 'La informaci\u00f3n de dep\u00F3sito garant\u00EDa no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_res_deposito_garantia.getEl().mask('Guardando...', 'x-mask-loading');

                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCrdpt_codigo',txtCrdpt_codigo.getValue());
                    param.add('inCrcpj_codigo',(tmpCuenta == undefined || tmpCuenta.length==0)?null:tmpCuenta);
                    param.add('inCrpjr_codigo',(tmpPersonaJuridica?tmpPersonaJuridica:null));
                    param.add('inCrper_codigo',(tmpPersonaAuspiciante?tmpPersonaAuspiciante:null));
                    param.add('inCgg_crpjr_codigo',(tmpEmpresaAuspiciante?tmpEmpresaAuspiciante:null));
                    param.add('inCrdpt_numero',txtCrdpt_numero.getValue());
					param.add('inCrdpt_caduca',chkCrdpt_caduca.getValue());
					param.add('inCrdpt_tipo',cbxCrdpt_tipo.getValue());
                    param.add('inCrdpt_numero_documento',txtCrdpt_numero_documento.getValue());
                    param.add('inCrdpt_valor_deposito',numCrdpt_valor_deposito.getValue());
                    param.add('inCrdpt_fecha_deposito',dtCrdpt_fecha_deposito.getValue().format('c'));
                    param.add('inCrdpt_fecha_entrega',dtCrdpt_fecha_entrega.getValue().format('c'));
                    param.add('inCrdpt_fecha_caducidad',chkCrdpt_caduca.getValue()?dtCrdpt_fecha_caducidad.getValue().format('c'):null);
                    param.add('inCrdpt_fecha_contabilizacion',dtCrdpt_fecha_contabilizacion.getValue().format('c'));
                    param.add('inCrdpt_fecha_solic_devolucion',dtCrdpt_fecha_solic_devolucion.getValue().format('c'));
                    param.add('inCrdpt_fecha_devolucion_definiti',dtCrdpt_fecha_devolucion_definiti.getValue().format('c'));
                    param.add('inCrdpt_devuelto',chkCrdpt_devuelto.getValue());
                    param.add('inCrdpt_estado_deposito',cbxEstadoDeposito.getValue());
                    param.add('inCrdpt_observacion',txtCrdpt_observacion.getValue());
                    SOAPClient.invoke(urlCgg_res_deposito_garantia,INSENTENCIA_CGG_RES_DEPOSITO_GARANTIA,param, true, CallBackCgg_res_deposito_garantia);
                }catch(inErr){
                    winFrmCgg_res_deposito_garantia.getEl().unmask();
                }
            }
        }
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_deposito_garantia.
     */
    var btnCancelarCgg_res_deposito_garantia = new Ext.Button({
        id:'btnCancelarCgg_res_deposito_garantia',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_res_deposito_garantia.getForm().reset();
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_deposito_garantia.
     */
    var btnCerrarCgg_res_deposito_garantia = new Ext.Button({
        id:'btnCerrarCgg_res_deposito_garantia',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_res_deposito_garantia.close();
            }
        }
    });
	
    var pnlCgg_res_deposito_garantia= new Ext.form.FormPanel({
        id:'pnlCgg_res_deposito_garantia',
        frame:true,
        layout:'form',
        title:'General',
        items:[{
                xtype:'fieldset',
                title: 'Auspiciante',
                items :[{xtype:'panel',layout:'column',items:[
                        {xtype:'panel',columnWidth:.5,layout:'column',items:[
                                        {xtype:'panel',labelWidth:60,columnWidth:.9,layout:'form',items:[txtDPTCrper_codigo]},
                                        {xtype:'panel',columnWidth:.1,layout:'form',items:[btnCrper_codigoCgg_res_deposito_garantia]}
                        ]},
                        {xtype:'panel',columnWidth:.5,layout:'column',items:[
                                {xtype:'panel',labelWidth:60,columnWidth:.9,layout:'form',items:[txtCgg_crpjr_codigo]},
                                {xtype:'panel',columnWidth:.1,layout:'form',items:[btnCgg_crpjr_codigoCgg_res_deposito_garantia]}
                        ]}
                ]}
                ]
        },{
            xtype:'panel',
            layout:'column',
            items:[
            {
                columnWidth:0.5,
                layout:'form',
                items:[txtCrdpt_numero,txtCrdpt_numero_documento,
				cbxCrdpt_tipo,
				{
                    xtype:'panel',
                    layout:'column',
                    items:[{
                        columnWidth:.9,
                        layout:'form',
                        items:[txtCrcpj_codigo]
                    },{
                        columnWidth:.1,
                        layout:'form',
                        items:[btnCrcpj_codigoCgg_res_deposito_garantia]
                    }]
                },{
                    xtype:'panel',
                    layout:'column',
                    items:[{
                        columnWidth:.9,
                        layout:'form',
                        items:[txtDPTCrpjr_codigo]
                    },{
                        columnWidth:.1,
                        layout:'form',
                        items:[btnCrpjr_codigoCgg_res_deposito_garantia]
                    }]
                },
                numCrdpt_valor_deposito,cbxEstadoDeposito
                ]
            },{
                columnWidth:0.5,
                layout:'form',
                items:[dtCrdpt_fecha_deposito,
                dtCrdpt_fecha_entrega,
                chkCrdpt_caduca,
                dtCrdpt_fecha_caducidad
                ]
            }]
        }
        ]
    });
	
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_deposito_garantia.
     */
    var tabCgg_res_deposito_garantia = new Ext.TabPanel({
        region:'center',
        activeTab:0,
        items:[pnlCgg_res_deposito_garantia, txtCrdpt_observacion]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_deposito_garantia.
     */
    var winFrmCgg_res_deposito_garantia = new Ext.Window({
        id:'winFrmCgg_res_deposito_garantia',
        title:tituloCgg_res_deposito_garantia,
        tbar:getPanelTitulo(tituloCgg_res_deposito_garantia,descCgg_res_deposito_garantia),
        layout:'border',
        items:[tabCgg_res_deposito_garantia],
        width:600,
        minWidth:600,
        height:420,
        minHeight:400,
        resizable: true,
        maximizable:false,
        minimizable:false,
        modal:true,
        constrain:true,
        bbar:[btnGuardarCgg_res_deposito_garantia,btnCancelarCgg_res_deposito_garantia,'->',btnCerrarCgg_res_deposito_garantia]
    });
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_deposito_garantia.
     */
    function cargarCgg_res_deposito_garantiaCtrls(){
        if(inRecordCgg_res_deposito_garantia){
            tmpCuenta = inRecordCgg_res_deposito_garantia.get('CRCPJ_CODIGO');
            tmpPersonaJuridica = inRecordCgg_res_deposito_garantia.get('CRPJR_CODIGO');
            tmpPersonaAuspiciante = inRecordCgg_res_deposito_garantia.get('CRPER_CODIGO');
            tmpEmpresaAuspiciante = inRecordCgg_res_deposito_garantia.get('CGG_CRPJR_CODIGO');
			//btnCgg_crpjr_codigoCgg_res_deposito_garantia.setDisabled(inRecordCgg_res_deposito_garantia.data.TRAMITES.length > 0);
			//btnCrper_codigoCgg_res_deposito_garantia.setDisabled(inRecordCgg_res_deposito_garantia.data.TRAMITES.length > 0);
            txtCrcpj_codigo.setValue(inRecordCgg_res_deposito_garantia.get('CRCPJ_NUMERO_CUENTA'));
            txtDPTCrpjr_codigo.setValue(inRecordCgg_res_deposito_garantia.get('CRPJR_RAZON_SOCIAL'));
            txtCrdpt_codigo.setValue(inRecordCgg_res_deposito_garantia.get('CRDPT_CODIGO'));
            txtCrdpt_numero.setValue(inRecordCgg_res_deposito_garantia.get('CRDPT_NUMERO'));
            txtCrdpt_numero_documento.setValue(inRecordCgg_res_deposito_garantia.get('CRDPT_NUMERO_DOCUMENTO'));
            txtDPTCrper_codigo.setValue(inRecordCgg_res_deposito_garantia.data.CRPER_NOMBRES);
            txtCgg_crpjr_codigo.setValue(inRecordCgg_res_deposito_garantia.data.EMPRESA);
            numCrdpt_valor_deposito.setValue(inRecordCgg_res_deposito_garantia.get('CRDPT_VALOR_DEPOSITO'));
			chkCrdpt_caduca.setValue(inRecordCgg_res_deposito_garantia.get('CRDPT_CADUCA'));
	        if(inRecordCgg_res_deposito_garantia.data.CRDPT_TIPO > 0)
		        cbxCrdpt_tipo.setValue(inRecordCgg_res_deposito_garantia.get('CRDPT_TIPO'));
            var tmpFechaRegistro = truncDate(inRecordCgg_res_deposito_garantia.get('CRDPT_FECHA_DEPOSITO'));
            if(tmpFechaRegistro == null)
                tmpFechaRegistro = new Date();
            dtCrdpt_fecha_deposito.setValue(tmpFechaRegistro);
            tmpFechaRegistro = truncDate(inRecordCgg_res_deposito_garantia.get('CRDPT_FECHA_ENTREGA'));
            if(tmpFechaRegistro == null)
                tmpFechaRegistro = new Date();
            dtCrdpt_fecha_entrega.setValue(tmpFechaRegistro);
            tmpFechaRegistro = truncDate(inRecordCgg_res_deposito_garantia.get('CRDPT_FECHA_CADUCIDAD'));
            if(tmpFechaRegistro == null)
                tmpFechaRegistro = new Date();
            dtCrdpt_fecha_caducidad.setValue(tmpFechaRegistro);
            tmpFechaRegistro = truncDate(inRecordCgg_res_deposito_garantia.get('CRDPT_FECHA_CONTABILIZACION'));
            if(tmpFechaRegistro == null)
                tmpFechaRegistro = new Date();
            dtCrdpt_fecha_contabilizacion.setValue(tmpFechaRegistro);
            tmpFechaRegistro = truncDate(inRecordCgg_res_deposito_garantia.get('CRDPT_FECHA_SOLIC_DEVOLUCION'));
            if(tmpFechaRegistro == null)
                tmpFechaRegistro = new Date();
            dtCrdpt_fecha_solic_devolucion.setValue(tmpFechaRegistro);
            tmpFechaRegistro = truncDate(inRecordCgg_res_deposito_garantia.get('CRDPT_FECHA_DEVOLUCION_DEFINITI'));
            if(tmpFechaRegistro == null)
                tmpFechaRegistro = new Date();
            dtCrdpt_fecha_devolucion_definiti.setValue(tmpFechaRegistro);
            chkCrdpt_devuelto.setValue(inRecordCgg_res_deposito_garantia.get('CRDPT_DEVUELTO'));
            if(inRecordCgg_res_deposito_garantia.data.CRDPT_ESTADO_DEPOSITO == 4)
            	cbxEstadoDeposito.setValue(0);
            else
            	cbxEstadoDeposito.setValue(inRecordCgg_res_deposito_garantia.get('CRDPT_ESTADO_DEPOSITO'));
            txtCrdpt_observacion.setValue(inRecordCgg_res_deposito_garantia.get('CRDPT_OBSERVACION'));
            isEdit = true;
        }
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_deposito_garantia.
     * @returns ventana winFrmCgg_res_deposito_garantia.
     * @base FrmCgg_res_deposito_garantia.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_deposito_garantia;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_deposito_garantia.
     * @base FrmCgg_res_deposito_garantia.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_deposito_garantiaCtrls();
    }

    this.dialogResult = function(){
        return dialogResult;
    }

    this.setValue = function(inValue){
        if(inValue){
            valor = inValue;
        }else{
            valor = 0;
        }
        numCrdpt_valor_deposito.setValue(valor);
        numCrdpt_valor_deposito.setMinValue(valor);
        isTmp = true;
        cbxEstadoDeposito.setValue(4);
		txtCrdpt_numero_documento.setVisible(false);
		dtCrdpt_fecha_caducidad.setVisible(false);
		dtCrdpt_fecha_contabilizacion.setVisible(false);
		dtCrdpt_fecha_deposito.setVisible(false);
		dtCrdpt_fecha_entrega.setVisible(false);
		dtCrdpt_fecha_solic_devolucion.setVisible(false);
		dtCrdpt_fecha_devolucion_definiti.setVisible(false);
		chkCrdpt_caduca.setVisible(false);
    }

    this.setObservacion=function(inObservacion){
        txtCrdpt_observacion.setValue(inObservacion);
    }
    
    this.setPersona = function(inPersonaRecord){
        tmpPersonaAuspiciante = inPersonaRecord.data.CRPER_CODIGO;
        txtDPTCrper_codigo.setValue(inPersonaRecord.data.CRPER_NOMBRES+' '+inPersonaRecord.data.CRPER_APELLIDO_PATERNO+' '+(inPersonaRecord.data.CRPER_APELLIDO_MATERNO?inPersonaRecord.data.CRPER_APELLIDO_MATERNO:''));
        //btnCrper_codigoCgg_res_deposito_garantia.setDisabled(true);
        //btnCgg_crpjr_codigoCgg_res_deposito_garantia.setDisabled(true);
    }
    
    this.setEmpresa = function(inEmpresaRecord){
        tmpEmpresaAuspiciante = inEmpresaRecord.data.CRPJR_CODIGO;
        txtCgg_crpjr_codigo.setValue(inEmpresaRecord.data.CRPJR_RAZON_SOCIAL);
        //btnCgg_crpjr_codigoCgg_res_deposito_garantia.setDisabled(true);
        //btnCrper_codigoCgg_res_deposito_garantia.setDisabled(true);
    }
	
	this.setTotal = function(inTotal){
		tmpTotal = inTotal;
	}
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_deposito_garantia desde una instancia.
 */
FrmCgg_res_deposito_garantia.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_deposito_garantia desde una instancia.
 */
FrmCgg_res_deposito_garantia.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_deposito_garantia,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_deposito_garantia.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_deposito_garantia desde una instancia.
 */
FrmCgg_res_deposito_garantia.prototype.loadData = function(){
    this.loadData();
}

FrmCgg_res_deposito_garantia.prototype.dialogResult= function(){
    return this.dialogResult();
}

FrmCgg_res_deposito_garantia.prototype.setValue= function(inValue){
    return this.setValue(inValue);
}

FrmCgg_res_deposito_garantia.prototype.setObservacion= function(inObservacion){
    return this.setObservacion(inObservacion);
}

FrmCgg_res_deposito_garantia.prototype.setPersona = function(inPersonaRecord){
    return this.setPersona(inPersonaRecord);
}

FrmCgg_res_deposito_garantia.prototype.setEmpresa = function(inEmpresaRecord){
    return this.setPersona(inEmpresaRecord);
}

FrmCgg_res_deposito_garantia.prototype.setTotal = function(inTotal){
    return this.setTotal(inTotal);
}