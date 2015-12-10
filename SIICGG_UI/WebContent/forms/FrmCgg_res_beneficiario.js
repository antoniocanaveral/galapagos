/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_beneficiario.
* @param {Ext.data.Record} inRecordCgg_res_beneficiario Record con informacion del beneficiario a registrarse.
* @constructor
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_res_beneficiario(inRecordCgg_res_beneficiario){
    
    var tituloCgg_res_beneficiario='Beneficiario';
    var descCgg_res_beneficiario='Ingreso de informaci\u00f3n del beneficiario';
    var isEdit = false;
    /**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DEL BENEFICIARIO
	*/
    var txtCrben_codigo = new Ext.form.TextField({
        id:'txtCrben_codigo',
        name:'txtCrben_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
* Ext.form.TextField NOMBRES DEL BENEFICIARIO
*/
    var txtCrben_nombres = new Ext.form.TextField({
        id:'txtCrben_nombres',
        name:'txtCrben_nombres',
        fieldLabel :'Nombres',
        anchor:'98%',
        allowBlank :false
    });
    /**
* Ext.form.TextField APELLIDO PATERNO DE BENEFICIARIO
*/
    var txtCrben_apellido_paterno = new Ext.form.TextField({
        id:'txtCrben_apellido_paterno',
        name:'txtCrben_apellido_paterno',
        fieldLabel :'Apellido paterno',
        anchor:'98%',
        allowBlank :false
    });

    var txtCrben_apellido_materno = new Ext.form.TextField({
        id:'txtCrben_apellido_materno',
        name:'txtCrben_apellido_materno',
        fieldLabel :'Apellido materno',
        anchor:'98%',
        allowBlank :false
    });
    
    /**
* Ext.form.TextField NUMERO DE IDENTIFICACION DE BENEFICIARIO
*/
    var txtCrben_num_doc_identific = new Ext.form.TextField({
        id:'txtCrben_num_doc_identific',
        name:'txtCrben_num_doc_identific',
        fieldLabel :'Identificaci\u00f3n',
        anchor:'100%',
        allowBlank :false,
        listeners:{            
            specialkey: function(inThis, e){
                if (e.getKey() == e.ENTER) {
                    if(cbxCrdid_codigo.getValue() == SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','CONF33')).get('CGCNF_VALOR_CADENA')){
                        var tmp = validarCedula(inThis.getValue());
                        if (tmp== true)
                            consultarDatosPersona(inThis.getValue());
                        else
                            Ext.MessageBox.alert(tituloCgg_res_beneficiario, 'El n\u00famero de identificaci\u00f3n no es valido, verifiquelo por favor.');
                    }else{
                        consultarDatosPersona(inThis.getValue());
                    }
                }
            },
            change : function(inThis, valn, valo) {
                if(cbxCrdid_codigo.getValue() == SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','CONF33')).get('CGCNF_VALOR_CADENA')){
                    var tmp = validarCedula(valn);
                    if (tmp== true)
                        consultarDatosPersona(inThis.getValue());
                    else
                        Ext.MessageBox.alert(tituloCgg_res_beneficiario, 'N\u00famero de identificaci\u00f3n no valido');
                }else{
                    consultarDatosPersona(inThis.getValue());
                }
            }
        }
    });   

    /**
     *Ext.form.ComboBox GENERO DEL BENEFICIARIO
     */
    var cbxCrben_genero = new Ext.form.ComboBox({
        id:'cbxCrben_genero',
        fieldLabel:'Genero',
        store:dsGeneroPersona,        
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione un genero',
        selectOnFocus:true,
        anchor:'60%',
        value:0
    });

    /**
     * Ext.data.Store Seleccion de registros de la tabla Cgg_res_estado_civil
     */
    var gsCgg_res_estado_civil = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_estado_civil",
            method:"selectAll",
            pagin:false
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            },[
            {
                name:'CRECV_CODIGO'
            },

            {
                name:'CRECV_DESCRPCION'
            }
            ]),
        baseParams:{
            format:TypeFormat.JSON
        },
        listeners:{
            load:function(inThis,inRecords,inObject){
                if(inRecordCgg_res_beneficiario.get('CRECV_CODIGO')!== null && inRecordCgg_res_beneficiario.get('CRECV_CODIGO').trim().length!==0 ){
                    cbxCrecv_codigo.setValue(inRecordCgg_res_beneficiario.get('CRECV_CODIGO'));
                }else{                    
                    if(new ManagerCookies().read('CRECV_CODIGO')!=null){                                                
                        cbxCrecv_codigo.setValue(new ManagerCookies().read('CRECV_CODIGO'));
                    }
                }
            }
        }
    });
    gsCgg_res_estado_civil.load();
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DEL ESTADO CIVIL
     */
    var cbxCrecv_codigo = new Ext.form.ComboBox({
        id:'cbxCrecv_codigo',
        name:'cbxCrecv_codigo',
        fieldLabel :'Estado civil',
        anchor:'60%',
        store: gsCgg_res_estado_civil,
        displayField:'CRECV_DESCRPCION',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
		allowBlank:false,
        triggerAction:'all',
        emptyText:'Seleccione un estado civil',
        selectOnFocus:true,
        valueField:'CRECV_CODIGO',
        listeners:{
            change:function(inThis,inNewValue,inOldValue){
                new ManagerCookies().erase('CRECV_CODIGO');
                new ManagerCookies().create('CRECV_CODIGO',inNewValue, 168);
            }
        }
    });    

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_documento_identificacio por un campo especifico.
     */
    var gsCgg_res_documento_identificacio = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_documento_identificacio",
            method:"selectAll"
        }),        
        reader:new Ext.data.JsonReader({
            },[
            {
                name:'CRDID_CODIGO'
            },

            {
                name:'CRDID_DESCRIPCION'
            }
            ]),        
        baseParams:{
            format:"JSON"
        },
        listeners:{
            load:function(inThis,inRecords,inObject){
                if(inRecordCgg_res_beneficiario.get('CRDID_CODIGO')!== null && inRecordCgg_res_beneficiario.get('CRDID_CODIGO').trim().length!==0 ){
                    cbxCrdid_codigo.setValue(inRecordCgg_res_beneficiario.get('CRDID_CODIGO'));
                    txtCrben_num_doc_identific.focus();
                }else{
                    if(new ManagerCookies().read('CRDID_CODIGO')!=null){
                        cbxCrdid_codigo.setValue(new ManagerCookies().read('CRDID_CODIGO'));
                        txtCrben_num_doc_identific.focus();
                    }
                }
            }
        }
    });
    gsCgg_res_documento_identificacio.load();

    var cbxCrdid_codigo = new Ext.form.ComboBox({
        id:'cbxCrdid_codigo',
        name:'cbxCrdid_codigo',
        fieldLabel :'Documento',
        anchor:'98%',
        store: gsCgg_res_documento_identificacio,
        displayField:'CRDID_DESCRIPCION',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione un tipo documento identidad',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CRDID_DESCRIPCION}" class="x-combo-list-item">{CRDID_DESCRIPCION}</div></tpl>',
        valueField:'CRDID_CODIGO',
        allowBlank:false,
        listeners:{
            change:function(inThis,inNewValue,inOldValue){
                new ManagerCookies().erase('CRDID_CODIGO');
                new ManagerCookies().create('CRDID_CODIGO',inNewValue, 168);
            }
        }
    });
    gsCgg_res_documento_identificacio.load();

    /**
     * Ext.form.DateField FECHA DE NACIMIENTO
     */
    var dtCrper_fecha_nacimiento = new Ext.form.DateField({
        id:'dtCrper_fecha_nacimiento',
        name:'dtCrper_fecha_nacimiento',
        fieldLabel :'Fecha nacimiento',        
        format :'d/m/Y',        
        anchor:'50%',
        value:new Date(),
        maxValue:new Date(),
        allowBlank:false
    });

    /**
* Boton que permite almacenar la informacion de la ventana winFrmCgg_res_beneficiario
*/
    var btnAceptarCgg_res_beneficiario = new Ext.Button({
        id:'btnAceptarCgg_res_beneficiario',
        text:'Aceptar',
        iconCls:'iconGuardar',
        tooltip:'Guardar beneficiario',
        listeners:{
            click:function(){
                if (pnlCgg_res_beneficiario.getForm().isValid()==false){
                    return;
                }else{
                    inRecordCgg_res_beneficiario.set('CRPER_CODIGO',txtCrben_codigo.getValue());
                    inRecordCgg_res_beneficiario.set('CRPER_NOMBRES',ucFirst(txtCrben_nombres.getValue()));                    
                    inRecordCgg_res_beneficiario.set('CRPER_APELLIDO_PATERNO',txtCrben_apellido_paterno.getValue());
                    inRecordCgg_res_beneficiario.set('CRPER_APELLIDO_MATERNO',txtCrben_apellido_materno.getValue());
                    inRecordCgg_res_beneficiario.set('CRPER_NUM_DOC_IDENTIFIC',txtCrben_num_doc_identific.getValue());
                    inRecordCgg_res_beneficiario.set('CRPER_GENERO',cbxCrben_genero.getValue());
                    inRecordCgg_res_beneficiario.set('CRDID_CODIGO',cbxCrdid_codigo.getValue());
                    inRecordCgg_res_beneficiario.set('CRECV_CODIGO',cbxCrecv_codigo.getValue());
                    inRecordCgg_res_beneficiario.set('CRPER_FECHA_NACIMIENTO',dtCrper_fecha_nacimiento.getValue().format('d/m/Y'));
                    winFrmCgg_res_beneficiario.close();
                }              
            }
        }
    });
 
    /**
* Boton que permite cerrar la ventana winFrmCgg_res_beneficiario.
*/
    var btnCerrarCgg_res_beneficiario = new Ext.Button({
        id:'btnCerrarCgg_res_beneficiario',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:'Cerrar formulario',
        listeners:{
            click:function(){
                winFrmCgg_res_beneficiario.close();
            }
        }
    });
    /**
* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_beneficiario.
*/
    var pnlCgg_res_beneficiario = new Ext.form.FormPanel({
        frame:true,
        anchor:'100%',
        items:[{
            layout:'column',
            anchor:'100%',
            items:[{
                columnWidth:.6,
                layout:'form',
                items:[cbxCrdid_codigo]
            },{
                columnWidth:.4,                
                items:[txtCrben_num_doc_identific]
            }]
        },
        txtCrben_nombres,
        txtCrben_apellido_paterno,
        txtCrben_apellido_materno,
        cbxCrben_genero,
        cbxCrecv_codigo,
        dtCrper_fecha_nacimiento
        ]
    });
    /**
* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_beneficiario.
*/
    var winFrmCgg_res_beneficiario = new Ext.Window({        
        title:tituloCgg_res_beneficiario,
        tbar:getPanelTitulo(tituloCgg_res_beneficiario,descCgg_res_beneficiario),
        items:[pnlCgg_res_beneficiario],
        width:425,
        resizable:false,
        constrain:true,
        modal:true,
        bbar:[btnAceptarCgg_res_beneficiario,'->',btnCerrarCgg_res_beneficiario]
    });

    /**
* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_beneficiario.
*/
    function cargarCgg_res_beneficiarioCtrls(){
        if(inRecordCgg_res_beneficiario!== null){
            txtCrben_codigo.setValue(inRecordCgg_res_beneficiario.get('CRPER_CODIGO'));
            txtCrben_nombres.setValue(inRecordCgg_res_beneficiario.get('CRPER_NOMBRES'));            
            txtCrben_apellido_paterno.setValue(inRecordCgg_res_beneficiario.get('CRPER_APELLIDO_PATERNO'));
            txtCrben_apellido_materno.setValue(inRecordCgg_res_beneficiario.get('CRPER_APELLIDO_MATERNO'));
            txtCrben_num_doc_identific.setValue(inRecordCgg_res_beneficiario.get('CRPER_NUM_DOC_IDENTIFIC'));
            cbxCrben_genero.setValue(inRecordCgg_res_beneficiario.get('CRPER_GENERO'));
            cbxCrdid_codigo.setValue(inRecordCgg_res_beneficiario.get('CRDID_CODIGO'));
            cbxCrecv_codigo.setValue(inRecordCgg_res_beneficiario.get('CRECV_CODIGO'));
            var tmpFecha = null;
            if(inRecordCgg_res_beneficiario.get('CRPER_FECHA_NACIMIENTO')== null || inRecordCgg_res_beneficiario.get('CRPER_FECHA_NACIMIENTO').trim().length ==0){
                tmpFecha = new Date();
            }else{
                tmpFecha = inRecordCgg_res_beneficiario.get('CRPER_FECHA_NACIMIENTO');
            }
            dtCrper_fecha_nacimiento.setValue(tmpFecha);
        }
    }

    function consultarDatosPersona(inValue){              
        var param = new SOAPClientParameters();
        param.add('inCrper_num_doc_identific',inValue) ;
        param.add('format',TypeFormat.JSON);
        SOAPClient.invoke(URL_WS+"Cgg_res_persona",'selectNumDoc',param, true, function (r){
            var tmpRecordPersona = Ext.util.JSON.decode(r);
            if(tmpRecordPersona[0].CRPER_CODIGO != undefined && tmpRecordPersona[0].CRPER_CODIGO!==null){
                txtCrben_codigo.setValue(tmpRecordPersona[0].CRPER_CODIGO);
                txtCrben_nombres.setValue(tmpRecordPersona[0].CRPER_NOMBRES);
                if(tmpRecordPersona[0].CRPER_APELLIDO_MATERNO)
                    txtCrben_apellido_materno.setValue(tmpRecordPersona[0].CRPER_APELLIDO_MATERNO);
                txtCrben_apellido_paterno.setValue(tmpRecordPersona[0].CRPER_APELLIDO_PATERNO);
                cbxCrecv_codigo.setValue(tmpRecordPersona[0].CRECV_CODIGO);
                cbxCrben_genero.setValue(tmpRecordPersona[0].CRPER_GENERO);
                dtCrper_fecha_nacimiento.setValue(tmpRecordPersona[0].CRPER_FECHA_NACIMIENTO?truncDate(tmpRecordPersona[0].CRPER_FECHA_NACIMIENTO):new Date());
            //COMENTARIO : revisar relacion con pais
            }else{
                txtCrben_codigo.setValue('KEYGEN');
                txtCrben_nombres.setValue('');
                txtCrben_apellido_materno.setValue('');
                txtCrben_apellido_paterno.setValue('');                
                dtCrper_fecha_nacimiento.setValue(new Date());
            }
        });                    
    }
    
    /**
* Funcion miembro que devuelve la ventana winFrmCgg_res_beneficiario.
* @returns ventana winFrmCgg_res_beneficiario.
* @base FrmCgg_res_beneficiario.prototype.show
*/
    this.getWindow = function(){
        return winFrmCgg_res_beneficiario;
    }
    /**
* Funcion miembro que carga los controles de la ventana winFrmCgg_res_beneficiario.
* @base FrmCgg_res_beneficiario.prototype.loadData
*/
    this.loadData = function(){
        cargarCgg_res_beneficiarioCtrls();
    }

    this.data = function(){
        return inRecordCgg_res_beneficiario;
    }
	
    this.setTitle=function(inTitle){
        winFrmCgg_res_beneficiario.setTitle(inTitle);
        winFrmCgg_res_beneficiario.tbar = getPanelTitulo(tituloCgg_res_beneficiario,descCgg_res_beneficiario);
    }
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_beneficiario desde una instancia.
*/
FrmCgg_res_beneficiario.prototype.show = function(){
    this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_beneficiario desde una instancia.
*/
FrmCgg_res_beneficiario.prototype.close = function(){
    this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_beneficiario,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_res_beneficiario.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_beneficiario desde una instancia.
*/
FrmCgg_res_beneficiario.prototype.loadData = function(){
    this.loadData();
}

FrmCgg_res_beneficiario.prototype.getData = function(){
    return this.data();
}

FrmCgg_res_beneficiario.prototype.setTitle = function(inTitle){
    return this.setTitle(inTitle);
}