/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_informe_testigo.
 * @param {String} INSENTENCIA_CGG_RES_INFORME_TESTIGO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_INFORME_TESTIGO Registro de datos de la tabla Cgg_res_informe_testigo.
 * @constructor
 * @base FrmListadoCgg_res_informe_testigo
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_informe_testigo(INSENTENCIA_CGG_RES_INFORME_TESTIGO,INRECORD_CGG_RES_INFORME_TESTIGO){
    var inSentenciaCgg_res_informe_testigo = INSENTENCIA_CGG_RES_INFORME_TESTIGO;
    var inRecordCgg_res_informe_testigo=INRECORD_CGG_RES_INFORME_TESTIGO;
    var urlCgg_res_informe_testigo=URL_WS+"Cgg_res_informe_testigo";
    var tituloCgg_res_informe_testigo='Informe testigo';
    var descCgg_res_informe_testigo='El formulario permite administrar informaci\u00f3n del Informe Testigo';
    var isEdit = false;
    var Crper_codigoTestigo;
    var tmpCrper_codigoTestigo = new Array();
    var tmpEliminados = new Array();
    var tmpTestigos = new Array();

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE INFORME TESTIGO
     */
    var txtCrint_codigo = new Ext.form.TextField({
        id:'txtCrint_codigo',
        name:'txtCrint_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCrmtr_codigo = new Ext.form.TextField({
        id:'txtCrmtr_codigo',
        name:'txtCrmtr_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true'
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO
     */
    var btnCrmtr_codigoCgg_res_informe_testigo = new Ext.Button({
        id:'btnCrmtr_codigoCgg_res_informe_testigo',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_res_matrimonio = new FrmListadoCgg_res_matrimonio();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_matrimonio.getStore(),tmpFLCgg_res_matrimonio.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                        txtCrmtr_codigo.setValue(tmpRecord.get('CRMTR_CODIGO'));
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.NumberField NUMERO DE INFORME TESTIGOS
     */
    var numCrint_numero = new Ext.form.TextField({
        id:'numCrint_numero',
        name:'numCrint_numero',
        fieldLabel :'N\u00famero',
        allowBlank :false,
        disabled :false,
        anchor:'97%',
        readOnly:true
    });
    /**
     * Ext.form.TextArea INFORMACION ADICIONAL - HISTORIAL JSON
     */
    var txtCrint_observacion = new Ext.form.TextArea({
        id:'txtCrint_observacion',
        name:'txtCrint_observacion',
        fieldLabel :'Observaciones Generales',
        width:'96%',
        allowBlank :false
    });
    /*
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TESTIGO
     */
    var txtCrtst_codigo = new Ext.form.TextField({
        id:'txtCrtst_codigo',
        name:'txtCrtst_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true

    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE INFORME TESTIGO
     */
    var btnCrint_codigoCgg_res_testigo = new Ext.Button({
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_res_informe_testigo = new FrmListadoCgg_res_informe_testigo();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_informe_testigo.getStore(),tmpFLCgg_res_informe_testigo.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                        txtCrint_codigo.setValue(tmpRecord.get('CRINT_CODIGO'));
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
     */
    var txtCrper_codigo = new Ext.form.TextField({
        fieldLabel :'Nombre',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true'
    });
    /**
     * CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
     */
    var btnCrper_codigoCgg_res_testigo = new Ext.Button({
        //id:'btnCrper_codigoCgg_res_testigo',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_res_persona = new Persona();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona.getStore(),tmpFLCgg_res_persona.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpCrper_codigoTestigo[tblTestigos.getActiveTab().getId()] = tmpRecord.get('CRPER_CODIGO');
                        txtCrper_codigo.setValue(tmpRecord.get('CRPER_NOMBRES')+" "+tmpRecord.get('CRPER_APELLIDO_PATERNO'));
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextArea INFORMACION ADICIONAL
     */
    var txtCrtst_observacion = new Ext.form.TextArea({
        fieldLabel :'Observaci\u00f3n',
        width:'95%',
        allowBlank :false
    });
    /**
     * Ext.form.TextArea TESTIMONIO DE UN PERSONA
     */
    var txtCrtst_testimonio = new Ext.form.TextArea({
        fieldLabel :'Testimonio',
        width:'95%',
        allowBlank :false
    });

    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_testigo.
     */
    var btnNuevoCgg_res_testigo = new Ext.Button({
        id:'btnNuevoCgg_res_testigo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                /*
                 * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TESTIGO
                 */
                var txtCrtst_codigo = new Ext.form.TextField({
                    fieldLabel :'Codigo',
                    anchor:'98%',
                    allowBlank :false,
                    value:"KEYGEN",
                    hidden:true,
                    hideLabel:true
                });
                /**
                 * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
                 */
                var txtCrper_codigo = new Ext.form.TextField({
                    fieldLabel :'Nombre',
                    anchor:'98%',
                    allowBlank :false,
                    readOnly:'true'
                });
                /**
                 * CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
                 */
                var btnCrper_codigoCgg_res_testigo = new Ext.Button({
                    //id:'btnCrper_codigoCgg_res_testigo',
                    iconCls:'iconBuscar',
                    listeners:{
                        click:function(){
                             var tmpFLCgg_res_persona = new Persona();
                            var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona.getStore(),tmpFLCgg_res_persona.getColumnModel());
                            objBusqueda.closeHandler(function(){
                                var tmpRecord = objBusqueda.getSelectedRow();
                                if(tmpRecord){
                                    tmpCrper_codigoTestigo[tblTestigos.getActiveTab().getId()]= (tmpRecord.get('CRPER_CODIGO'));
                                    txtCrper_codigo.setValue(tmpRecord.get('CRPER_NOMBRES')+" "+tmpRecord.get('CRPER_APELLIDO_PATERNO')+" "+tmpRecord.get('CRPER_APELLIDO_MATERNO'));
                                }
                            });
                            objBusqueda.show();
                        }}
                });
                /**
                 * Ext.form.TextArea INFORMACION ADICIONAL
                 */
                var txtCrtst_observacion = new Ext.form.TextArea({
                    fieldLabel :'Observaci\u00f3n',
                    width:'95%',
                    allowBlank :false
                });
                /**
                 * Ext.form.TextArea TESTIMONIO DE UN PERSONA
                 */
                var txtCrtst_testimonio = new Ext.form.TextArea({
                    fieldLabel :'Testimonio',
                    width:'95%',
                    allowBlank :false
                });

                var pnlCgg_res_testigo = new Ext.form.FormPanel({
                    frame:true,
                    region:'center',
                    title:'Testigo',
                    labelWidth :100,
                    height:180,
                    closable:true,
                    items:[txtCrtst_codigo,
                        {xtype:'panel',layout:'column',
                            items:[{columnWidth:.9,layout:'form',
                                items:[txtCrper_codigo]},{columnWidth:.1,layout:'form',
                                items:[btnCrper_codigoCgg_res_testigo]}]},
                        txtCrtst_testimonio,
                        txtCrtst_observacion]
                });
                tblTestigos.add(pnlCgg_res_testigo);
            }}
    });

    ////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_informe_testigo
     */
    var btnGuardarCgg_res_informe_testigo = new Ext.Button({
        id:'btnGuardarCgg_res_informe_testigo',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_res_informe_testigo.getForm().isValid()==false){
                    return;
                }
                if (pnlCgg_res_testigo.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_res_informe_testigo(r){
                        winFrmCgg_res_informe_testigo.getEl().unmask();
                        if(r!='false'){
                            var tmpIsAll = false;
                            var resultado = true;
                            var tmpSentencia = INSENTENCIA_CGG_RES_INFORME_TESTIGO;
                            function CallBackInsertTestigo(r){
                                resultado = resultado && r;
                                if(tmpIsAll)
                                    if (resultado){
                                        Ext.Msg.show({
                                            title:tituloCgg_res_informe_testigo,
                                            msg: 'La informaci\u00f3n del Informe Testigo ha sido almacenada.',
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.INFO
                                        });winFrmCgg_res_informe_testigo.close()
                                    }else{
                                        Ext.Msg.show({
                                            title:tituloCgg_res_informe_testigo,
                                            msg: 'La informaci\u00f3n de Informe Testigo no ha podido ser almacenada.',
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.ERROR
                                        });
                                    }
                            }

                            for(i = 0; i < tblTestigos.items.length; i++){
                                var param1 = new SOAPClientParameters();
                                var tmpObj = tblTestigos.items.get(i);
                                tmpIsAll = (i == tblTestigos.items.length - 1);
                                if(tmpCrper_codigoTestigo[tmpObj.getId()]){
                                    if(isEdit){
                                        param1.add('inCrint_codigo',txtCrint_codigo.getValue());
                                        if(tmpObj.items.get(0).getValue() == 'KEYGEN')
                                            tmpSentencia = 'insert';
                                        else
                                            param1.add('inCrtst_codigo',tmpObj.items.get(0).getValue());
                                    }else{
                                        param1.add('inCrint_codigo',r);
                                    }

                                    param1.add('inCrper_codigo', tmpCrper_codigoTestigo[tmpObj.getId()]);
                                    param1.add('inCrtst_testimonio',tmpObj.items.get(2).getValue());
                                    param1.add('inCrtst_observacion', tmpObj.items.get(3).getValue());
                                    SOAPClient.invoke(URL_WS+"Cgg_res_testigo",tmpSentencia,param1, true, CallBackInsertTestigo);
                                }
                            }
                        }
                    }
                    winFrmCgg_res_informe_testigo.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCrint_codigo',txtCrint_codigo.getValue());
                    param.add('inCrmtr_codigo',txtCrmtr_codigo.getValue());
                    param.add('inCrint_numero',numCrint_numero.getValue());
                    param.add('inCrint_observacion',txtCrint_observacion.getValue());
                    SOAPClient.invoke(urlCgg_res_informe_testigo,INSENTENCIA_CGG_RES_INFORME_TESTIGO,param, true, CallBackCgg_res_informe_testigo);
                }catch(inErr){
                    winFrmCgg_res_informe_testigo.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_informe_testigo.
     */
    var btnCancelarCgg_res_informe_testigo = new Ext.Button({
        id:'btnCancelarCgg_res_informe_testigo',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_res_informe_testigo.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_informe_testigo.
     */
    var btnCerrarCgg_res_informe_testigo = new Ext.Button({
        id:'btnCerrarCgg_res_informe_testigo',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_res_informe_testigo.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_testigo.
     */
    var pnlCgg_res_testigo = new Ext.form.FormPanel({
        frame:true,
        region:'center',
        title:'Testigo',
        labelWidth :100,
        height:180,
        items:[txtCrtst_codigo,
            {xtype:'panel',layout:'column',
                items:[{columnWidth:.9,layout:'form',
                    items:[txtCrper_codigo]},{columnWidth:.1,layout:'form',
                    items:[btnCrper_codigoCgg_res_testigo]}]},
            txtCrtst_testimonio,
            txtCrtst_observacion]

    });
    var tblTestigos = new Ext.TabPanel({
        region:'south',
        activeTab:0,
        enableTabScroll:true,
        tbar:[btnNuevoCgg_res_testigo],
        items:[pnlCgg_res_testigo],
        listeners:{
            remove:function(inContainer, inComponent){
                function CallBackCgg_res_cargar_testigo(r){
                    Ext.MessageBox.alert('Matrimimonio', 'Testigo Eliminado');
                }
                tmpEliminados[inComponent.getId()] = tmpTestigos[inComponent.getId()];
                var param = new SOAPClientParameters();
                param.add('inCrtst_codigo',tmpEliminados[inComponent.getId()]);
                SOAPClient.invoke(URL_WS+"Cgg_res_testigo","delete",param, true, CallBackCgg_res_cargar_testigo);

            }
        }
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_informe_testigo.
     */
    var pnlCgg_res_informe_testigo = new Ext.form.FormPanel({
        region:'center',
        frame:true,
        labelWidth :100,
        height:150,
        items:[{xtype:'panel',layout:'column',
            items:[{columnWidth:.6,layout:'form',
                items:[]},{columnWidth:.4,layout:'form',
                items:[]}]},numCrint_numero,txtCrint_observacion]
    });
    /**
     * Funcion que permite cargar el  codigo del documento generado
     */
    function generarNumeroDocumento(){
        function callBackGenerarNumero(r){
            numCrint_numero.setValue(r);
        }
        SOAPClient.invoke(urlCgg_res_informe_testigo,'numeroDocumento',false, false, callBackGenerarNumero);
    }
    generarNumeroDocumento();

    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_informe_testigo.
     */
    var winFrmCgg_res_informe_testigo = new Ext.Window({
        id:'winFrmCgg_res_informe_testigo',
        title:tituloCgg_res_informe_testigo,
        tbar:getPanelTitulo(tituloCgg_res_informe_testigo,descCgg_res_informe_testigo),
        layout:'border',
        items:[pnlCgg_res_informe_testigo,tblTestigos],
        height:470,
        minHeight:400,
        width:400,
        modal:true,
        resizable:false,
        minWidth:400,
        maximizable:false,
        minimizable:false,
        constrain:true,
        bbar:[btnGuardarCgg_res_informe_testigo,btnCancelarCgg_res_informe_testigo,'->',btnCerrarCgg_res_informe_testigo]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_informe_testigo.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_res_informe_testigoCtrls(inEstado){
        estado=!inEstado;
        txtCrint_codigo.setDisabled(estado);
        txtCrmtr_codigo.setDisabled(estado);
        numCrint_numero.setDisabled(estado);
        txtCrint_observacion.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_informe_testigo.
     */
    function cargarCgg_res_informe_testigoCtrls(){
        if(inRecordCgg_res_informe_testigo){
            txtCrint_codigo.setValue(inRecordCgg_res_informe_testigo.get('CRINT_CODIGO'));
            txtCrmtr_codigo.setValue(inRecordCgg_res_informe_testigo.get('CRMTR_CODIGO'));
            numCrint_numero.setValue(inRecordCgg_res_informe_testigo.get('CRINT_NUMERO'));
            txtCrint_observacion.setValue(inRecordCgg_res_informe_testigo.get('CRINT_OBSERVACION'));
            isEdit = true;
            habilitarCgg_res_informe_testigoCtrls(true);
        }}

    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_informe_testigo.
     * @returns ventana winFrmCgg_res_informe_testigo.
     * @base FrmCgg_res_informe_testigo.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_informe_testigo;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_informe_testigo.
     * @base FrmCgg_res_informe_testigo.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_informe_testigoCtrls();
    }
    /**
     * Funcion que permite cargar la codigo de los controles de la ventana winFrmListadoCgg_res_matrimonio.
     */
    function cargarCgg_res_matrimonioCtrls(inCodigo){
        txtCrmtr_codigo.setValue(inCodigo);
    }
    /**
     * Funcion que permite cargar la codgi de los controles de la ventana winFrmListadoCgg_res_matrimonio.
     */
    this.loadMatrimonio = function(inCodigo){
        cargarCgg_res_matrimonioCtrls(inCodigo);
    }
    /*/**
     * Funcion que permite cargar la codigo de los controles de la ventana winFrmListadoCgg_res_matrimonio.
     */
    function cargarCgg_res_testigo(inTestigo){
        function CallBackCgg_res_cargar_testigo(res){
            var tmpJSON = Ext.util.JSON.decode(res);
            for(i = 0; i<tmpJSON.length; i++){
                if(i>0){

                    txtCrtst_codigo = new Ext.form.TextField({
                        fieldLabel :'Codigo',
                        anchor:'98%',
                        allowBlank :false,
                        value:"KEYGEN",
                        hidden:true,
                        hideLabel:true
                    });
                    ///////////////////////////////////}
                    /**
                     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
                     */
                    txtCrper_codigo = new Ext.form.TextField({
                        fieldLabel :'Testigo',
                        anchor:'98%',
                        allowBlank :false,
                        readOnly:'true'
                    });
                    /**
                     * CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
                     */
                    btnCrper_codigoCgg_res_testigo = new Ext.Button({
                        //id:'btnCrper_codigoCgg_res_testigo',
                        iconCls:'iconBuscar',
                        listeners:{
                            click:function(){
                                var tmpFLCgg_res_persona = new FrmListadoCgg_res_persona();
                                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona.getStore(),tmpFLCgg_res_persona.getColumnModel());
                                objBusqueda.closeHandler(function(){
                                    var tmpRecord = objBusqueda.getSelectedRow();
                                    if(tmpRecord){
                                        Crper_codigoTestigo = (tmpRecord.get('CRPER_CODIGO'));
                                        txtCrper_codigo.setValue(tmpRecord.get('CRPER_NOMBRES')+" "+tmpRecord.get('CRPER_APELLIDO_PATERNO'));}
                                });
                                objBusqueda.show();
                            }}
                    });
                    /**
                     * Ext.form.TextArea INFORMACION ADICIONAL
                     */
                    txtCrtst_observacion = new Ext.form.TextArea({
                        fieldLabel :'Observacion',
                        width:'95%',
                        allowBlank :false
                    });
                    /**
                     * Ext.form.TextArea TESTIMONIO DE UN PERSONA
                     */
                    txtCrtst_testimonio = new Ext.form.TextArea({
                        //id:'txtCrtst_testimonio',
                        //name:'txtCrtst_testimonio',
                        fieldLabel :'Testimonio',
                        width:'95%',
                        allowBlank :false
                    });

                    pnlCgg_res_testigo = new Ext.form.FormPanel({
                        frame:true,
                        region:'center',
                        title:'Testigo',
                        labelWidth :100,
                        height:200,
                        closable:true,
                        items:[txtCrtst_codigo,
                            {xtype:'panel',layout:'column',
                                items:[{columnWidth:.9,layout:'form',
                                    items:[txtCrper_codigo]},{columnWidth:.1,layout:'form',
                                    items:[btnCrper_codigoCgg_res_testigo]}]},txtCrtst_testimonio,txtCrtst_observacion]
                    });

                    tblTestigos.add(pnlCgg_res_testigo);
                    //////////////////////////////////////////
                }
                var tmpTest = tmpJSON[i];
                if(tmpTest){

                    //tblTestigos.add(pnlCgg_res_testigo);
                    txtCrint_codigo.setValue(tmpTest['CRINT_CODIGO']);
                    txtCrtst_codigo.setValue(tmpTest['CRTST_CODIGO']);
                    Crper_codigoTestigo=tmpTest['CRPER_CODIGO'];
                    txtCrper_codigo.setValue(tmpTest['TESTIGO']);
                    txtCrtst_testimonio.setValue(tmpTest['CRTST_TESTIMONIO']);
                    txtCrtst_observacion.setValue(tmpTest['CRTST_OBSERVACION']);
                    tmpCrper_codigoTestigo[pnlCgg_res_testigo.getId()] = tmpTest['CRPER_CODIGO'];
                    tmpTestigos[pnlCgg_res_testigo.getId()] = tmpTest['CRTST_CODIGO'];
                }
            }
        }
        var param = new SOAPClientParameters();
        param.add('inTestigo',inTestigo);
        param.add('start',0);
        param.add('limit',100);
        param.add('sort','CRTST_CODIGO');
        param.add('dir','ASC');
        param.add('keyword','');
        param.add('format','JSON');
        SOAPClient.invoke(URL_WS+"Cgg_res_testigo","selectPage",param, true, CallBackCgg_res_cargar_testigo);
    }
    /**
     * Funcion que permite cargar la codgi de los controles de la ventana winFrmListadoCgg_res_matrimonio.
     */
    this.loadTestigo = function(inTestigo){
        cargarCgg_res_testigo(inTestigo);
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_informe_testigo desde una instancia.
 */
FrmCgg_res_informe_testigo.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_informe_testigo desde una instancia.
 */
FrmCgg_res_informe_testigo.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_informe_testigo,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_informe_testigo.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_informe_testigo desde una instancia.
 */
FrmCgg_res_informe_testigo.prototype.loadData = function(){
    this.loadData();
}

FrmCgg_res_informe_testigo.prototype.loadMatrimonio = function(inCodigo){
    this.loadMatrimonio(inCodigo);
}
FrmCgg_res_informe_testigo.prototype.loadMatrimonio = function(inTestigo){
    this.loadTestigo(inTestigo);
}
