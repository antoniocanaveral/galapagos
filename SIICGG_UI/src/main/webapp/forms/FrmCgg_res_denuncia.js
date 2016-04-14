/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_denuncia.
 * @param {String} INSENTENCIA_CGG_RES_DENUNCIA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_DENUNCIA Registro de datos de la tabla Cgg_res_denuncia.
 * @constructor
 * @base FrmListadoCgg_res_denuncia
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_denuncia(INSENTENCIA_CGG_RES_DENUNCIA,INRECORD_CGG_RES_DENUNCIA,inCrdenTipo) {
    var inSentenciaCgg_res_denuncia = INSENTENCIA_CGG_RES_DENUNCIA;
    var inRecordCgg_res_denuncia = INRECORD_CGG_RES_DENUNCIA;
    var urlCgg_res_denuncia = URL_WS + "Cgg_res_denuncia";
    var tituloCgg_res_denuncia = 'Denuncia';
    var descCgg_res_denuncia = 'Formulario para el ingreso de la informaci\u00f3n de las denuncias ';
    var isEdit = false;
    
    /**
     * Ext.form.TextField NUMERO DE DOCUMENTO DE IDENTIFICACION DEL DENUNCIANTE
     */
    var txtCrden_numero_doc_ident = new Ext.form.TextField({
        id:'txtCrden_numero_doc_ident',
        name:'txtCrden_numero_doc_ident',
        fieldLabel :'Cedula/pasaporte',
        anchor:'98%'
    });
    /**
     * Ext.form.TextField NOMBRES DEL DENUNCIANTE
     */
    var txtCrden_nombres = new Ext.form.TextField({
        id:'txtCrden_nombres',
        name:'txtCrden_nombres',
        fieldLabel :'Person denunciante',
        anchor:'98%'
    });
    /**
     * Ext.form.TextField NOMBRES DEL DENUNCIANTE
     */
    var txtCrden_nombre_denunciante = new Ext.form.TextField({
        id:'txtCrden_nombre_denunciante',
        name:'txtCrden_nombre_denunciante',
        fieldLabel :'Denunciante',
        anchor:'98%'
    });
    /**
     * Ext.form.TextField APELLIDOS DEL DENUNCIANTE
     */
    var txtCrden_apellidos = new Ext.form.TextField({
        id:'txtCrden_apellidos',
        name:'txtCrden_apellidos',
        fieldLabel :'Apellidos',
        anchor:'98%'
    });
    var btnCrper_codigoCgg_res_persona = new Ext.Button({
        id:'btnCrper_codigoCgg_res_persona',
        iconCls:'iconBuscar',
        tooltip:'Formulario persona',
        listeners:{
            click:function() {
                var persona = new Persona();                
                var objBusqueda = new DlgBusqueda(persona.getStore(),persona.getCm());
                objBusqueda.closeHandler(function() {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord){
                        txtCrden_nombre_denunciante.setValue(tmpRecord.get('CRPER_NOMBRES') + " " + tmpRecord.get('CRPER_APELLIDO_PATERNO') + " " + tmpRecord.get('CRPER_APELLIDO_MATERNO'));
                        txtCrden_nombres.setValue(tmpRecord.get('CRPER_NOMBRES'));
                        txtCrden_apellidos.setValue(tmpRecord.get('CRPER_APELLIDO_PATERNO') + " " + tmpRecord.get('CRPER_APELLIDO_MATERNO'))
                        txtCrden_numero_doc_ident.setValue(tmpRecord.get('CRPER_NUM_DOC_IDENTIFIC'));
                    }
                });
                objBusqueda.show();
            }
        }
    });

/**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
var txtCrden_codigo = new Ext.form.TextField({
    id:'txtCrden_codigo',
    name:'txtCrden_codigo',
    fieldLabel :'Codigo',
    anchor:'98%',
    value:"KEYGEN",
    hidden:true,
    hideLabel:true
});
/**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
var txtCusu_codigo = new Ext.form.TextField({
    id:'txtCusu_codigo',
    name:'txtCusu_codigo',
    fieldLabel :'Codigo',
    anchor:'98%',
    readOnly:'true'
});
var txtCusu_nombre = new Ext.form.TextField({
    id:'txtCusu_nombre',
    name:'txtCusu_nombre',
    fieldLabel :'Nombre usuario',
    anchor:'75%',
    readOnly:'true'
});
/**
     * IDENTIFICATIVO UNICO DE REGISTRO
     */
var btnCusu_codigoCgg_res_denuncia = new Ext.Button({
    id:'btnCusu_codigoCgg_res_denuncia',
    iconCls:'iconBuscar',
    listeners:{
        click:function() {
            var tmpFLCgg_usuario = new FrmListadoCgg_usuario();
            var objBusqueda = new DlgBusqueda(tmpFLCgg_usuario.getStore(), tmpFLCgg_usuario.getColumnModel());
            objBusqueda.closeHandler(function() {
                var tmpRecord = objBusqueda.getSelectedRow();
                if (tmpRecord)
                    txtCusu_codigo.setValue(tmpRecord.get('CUSU_CODIGO'));
                txtCusu_codigo.setValue(tmpRecord.get('CUSU_NOMBRES') + " " + tmpRecord.get('CUSU_APELLIDOS'));
            });
            objBusqueda.show();
        }
    }
});
/**
     * Ext.form.TextField ANIO DE LA DENUNCIA
     */
var txtCrden_anio = new Ext.form.TextField({
    id:'txtCrden_anio',
    name:'txtCrden_anio',
    fieldLabel :'Anio',
    anchor:'98%'
});
/**
     * Ext.form.TextField NUMERO DE LA DENUNCIA
     */
var txtCrden_numero = new Ext.form.TextField({
    id:'txtCrden_numero',
    name:'txtCrden_numero',
    fieldLabel :'Numero denuncia',
    anchor:'75%'

});
txtCrden_numero.disable();
/**
     * Ext.form.DateField FECHA DE RECEPCION DE LA  DENUNCIA
     */
var dtCrden_fecha_recepcion = new Ext.form.DateField({
    id:'dtCrden_fecha_recepcion',
    name:'dtCrden_fecha_recepcion',
    fieldLabel :'Recepci\u00f3n',
    width:'150',
    format :'d/m/Y',
    value:new Date(),
    minValue:new Date(),
    maxValue:new Date(),
    anchor:'98%'
});

/**
     * Ext.form.TextArea MOTIVO DE LA DENUNCIA
     */
var txtCrden_descripcion = new Ext.form.TextArea({
    id:'txtCrden_descripcion',
    name:'txtCrden_descripcion',
    fieldLabel :'Denuncia Sugerencia',
    width:'98%',
    allowBlank:false
});
/**
     * Ext.form.TextField PARA CORREO ELECTRONICO O NUMERO TELEFONICO DEL DENUNCIANTE
     */
var txtCrden_contacto = new Ext.form.TextField({
    id:'txtCrden_contacto',
    name:'txtCrden_contacto',
    fieldLabel :'Contacto',
    anchor:'98%'
});
/**
     * Ext.form.NumberField TIPO DE DENUNCIA
     RESIDENCIA ->   0
     GESTION EMPLEO ->  1
     */
var numCrden_tipo = new Ext.form.NumberField({
    id:'numCrden_tipo',
    name:'numCrden_tipo',
    fieldLabel :'Tipo'
});

var storeDenuncia = (inCrdenTipo == '0')?[[true,'Telef\u00f3nico'],[false,'Presencial']]:[[true,'Denuncia'],[false,'Sugerencia']];
/**
     * Ext.form.Checkbox ESTADO QUE DETERMINA EL ORIGEN DE LA INFORMACION
     DENUNCIA/SUGERENCIA
     */	 
var cbxCrden_denuncia = new Ext.form.ComboBox({
    id:'cbxCrden_denuncia',
    name:'cbxCrden_denuncia',
    fieldLabel :'Tipo denuncia',
    width: 150,
    store: storeDenuncia,
    allowBlank :false,
    blankText:"Seleccione...",		
    mode:'local',
    typeAhead: true,
    forceSelection:true,
    triggerAction:'all'		
});
    
/**
     * Ext.form.TextField CAMPO DE REGISTRO DE SEGUIMIENTO DE LA DENUNCIA
     */
var txtCrden_seguimiento = new Ext.form.TextField({
    id:'txtCrden_seguimiento',
    name:'txtCrden_seguimiento',
    fieldLabel :(inCrdenTipo == 1)?'Observaci\u00f3n':'Denunciado',
    anchor:'98%'
});


/**
     * Ext.form.Checkbox ESTADO QUE DETERMINA EL ORIGEN DE LA INFORMACION
     DENUNCIA/SUGERENCIA
     */

var chkCrden_estado = new Ext.form.Checkbox({
    id:'chkCrden_estado',
    name:'chkCrden_estado',
    allowBlank :false,
    checked:false,
    fielLabel:'Anulada'

});
//chkCrden_estado.setVisible(false);
/** Boton que permite almacenar la informacion de la ventana winFrmCgg_res_denuncia
     */
var btnGuardarCgg_res_denuncia = new Ext.Button({
    id:'btnGuardarCgg_res_denuncia',
    text:'Guardar',
    iconCls:'iconGuardar',
    listeners:{
        click:function() {
            if (pnlCgg_res_denuncia.getForm().isValid() == false) {
                return;
            }
            try {
                function CallBackCgg_res_denuncia(r) {
                    winFrmCgg_res_denuncia.getEl().unmask();
                    if (r == 'true') {

                        Ext.Msg.show({
                            title:tituloCgg_res_denuncia,
                            msg: 'La informaci\u00f3n sobre denuncia ha sido almacenada.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.INFO
                        });

                        winFrmCgg_res_denuncia.close()
                    } else {
                        Ext.Msg.show({
                            title:tituloCgg_res_denuncia,
                            msg: 'La informaci\u00f3n sobre denuncia no ha podido ser almacenada.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.ERROR
                        });
                    }
                    if(r == 'true'){

                        Ext.Msg.show({
                            title:tituloCgg_res_denuncia,
                            msg: 'La denuncia se registr\u00f3 sin datos del denunciante',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.INFO
                        });
                        winFrmCgg_res_denuncia.close()
                    }
                }

                winFrmCgg_res_denuncia.getEl().mask('Guardando...', 'x-mask-loading');
                var param = new SOAPClientParameters();
                    
                var inEstadoDenuncia = 0;
                if (isEdit){
                    inEstadoDenuncia = chkCrden_estado.getValue() == true ?1:2;
                    param.add('inCrden_codigo', txtCrden_codigo.getValue());
                }
                param.add('inCusu_codigo',null);
                param.add('inCrden_anio',new Date().getFullYear());
                param.add('inCrden_numero', txtCrden_numero.getValue());
                param.add('inCrden_fecha_recepcion', dtCrden_fecha_recepcion.getValue().format(TypeDateFormat.Custom));
                param.add('inCrden_numero_doc_ident',txtCrden_numero_doc_ident.getValue()||null);
                param.add('inCrden_nombres', txtCrden_nombres.getValue()||null);
                param.add('inCrden_apellidos', txtCrden_apellidos.getValue()||null);
                param.add('inCrden_descripcion', txtCrden_descripcion.getValue());
                param.add('inCrden_contacto',txtCrden_contacto.getValue()||null );
                param.add('inCrden_tipo', inCrdenTipo);
                param.add('inCrden_denuncia', cbxCrden_denuncia.getValue());
                param.add('inCrden_seguimiento',txtCrden_seguimiento.getValue()||null);
                param.add('inCrden_estado_denuncia',inEstadoDenuncia);
                SOAPClient.invoke(urlCgg_res_denuncia, INSENTENCIA_CGG_RES_DENUNCIA, param, true, CallBackCgg_res_denuncia);
            } catch(inErr) {
                winFrmCgg_res_denuncia.getEl().unmask();
            }
        }
    }
});
/**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_denuncia.
     */
var btnCancelarCgg_res_denuncia = new Ext.Button({
    id:'btnCancelarCgg_res_denuncia',
    text:'Cancelar',
    iconCls:'iconCancelar',
    listeners:{
        click:function(){
            pnlCgg_res_denuncia.getForm().reset();
        }
    }
});
/**
     * Boton que permite cerrar la ventana winFrmCgg_res_denuncia.
     */
var btnCerrarCgg_res_denuncia = new Ext.Button({
    id:'btnCerrarCgg_res_denuncia',
    text:'Cerrar',
    iconCls:'iconCerrar',
    listeners:{
        click:function(){
            winFrmCgg_res_denuncia.close();
        }
    }
});
/**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_denuncia.
     */
var pnlCgg_res_denuncia= new Ext.form.FormPanel({
    frame:true,
    labelWidth:110,
    layout:'form',
    items:[txtCrden_codigo,{
        xtype:'panel',
        layout:'column',
        items:[{
            columnWidth:.6,
            labelWidth:110,
            layout:'form',
            items:[txtCrden_numero]
            },

            {
            columnWidth:.4,
            labelWidth:110,
            layout:'form',
            items:[dtCrden_fecha_recepcion]
            }]
        },


        {
        xtype:'panel',
        labelWidth:110,
        layout:'column',
        items:[
        {
            columnWidth:.55,
            layout:'form',
            items:[txtCrden_nombre_denunciante]
            },

            {
            columnWidth:.05,
            layout:'form',
            items:[btnCrper_codigoCgg_res_persona]
            },

            {
            columnWidth:.4,
            labelWidth:110,
            layout:'form',
            items:[txtCrden_numero_doc_ident]
            }]
        },
    txtCrden_contacto,
    txtCrden_descripcion,
    txtCrden_seguimiento,
    cbxCrden_denuncia
    ]
});     
/**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_denuncia.
     */
var winFrmCgg_res_denuncia = new Ext.Window({
    id:'winFrmCgg_res_denuncia',
    title:tituloCgg_res_denuncia,
    tbar:getPanelTitulo(tituloCgg_res_denuncia,descCgg_res_denuncia),
    items:[pnlCgg_res_denuncia],
    width:600,
    minWidth:600,
    modal:true,
    resizable:false,
    constrain:true,
    bbar:[btnGuardarCgg_res_denuncia,btnCancelarCgg_res_denuncia,'->',btnCerrarCgg_res_denuncia]
});
/**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_denuncia.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
function habilitarCgg_res_denunciaCtrls(inEstado){
    estado=!inEstado;
    txtCrden_codigo.setDisabled(estado);
    txtCusu_codigo.setDisabled(estado);
    txtCrden_anio.setDisabled(estado);
    txtCrden_numero.setDisabled(estado);
    dtCrden_fecha_recepcion.setDisabled(estado);
    txtCrden_numero_doc_ident.setDisabled(estado);
    txtCrden_nombres.setDisabled(estado);
    txtCrden_apellidos.setDisabled(estado);
    txtCrden_descripcion.setDisabled(estado);
    txtCrden_contacto.setDisabled(estado);
    numCrden_tipo.setDisabled(estado);
    cbxCrden_denuncia.setDisabled(estado);
    txtCrden_seguimiento.setDisabled(estado);
    chkCrden_estado.setDisabled(estado);
    if(inCrdenTipo == '1'){
        dtCrden_fecha_recepcion.setValue(new Date());
        dtCrden_fecha_recepcion.readOnly = !estado;
        txtCrden_codigo.setDisabled(!estado);
        txtCusu_codigo.setDisabled(!estado);
        txtCrden_anio.setDisabled(!estado);
        txtCrden_numero.readOnly = !estado;			
        txtCrden_numero_doc_ident.readOnly = !estado;
        txtCrden_nombres.setDisabled(!estado);
        txtCrden_apellidos.setDisabled(!estado);
        txtCrden_descripcion.readOnly = !estado;
        txtCrden_contacto.readOnly = !estado;
        numCrden_tipo.setDisabled(!estado);
        cbxCrden_denuncia.setDisabled(!estado);
        txtCrden_seguimiento.setDisabled(estado);
        chkCrden_estado.setDisabled(!estado);
        txtCrden_nombre_denunciante.readOnly = !estado;
        btnCrper_codigoCgg_res_persona.setDisabled(!estado);
    }
		
}
/**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_denuncia.
     */
function cargarCgg_res_denunciaCtrls(){		
    if(inRecordCgg_res_denuncia){
        txtCrden_codigo.setValue(inRecordCgg_res_denuncia.get('CRDEN_CODIGO'));
        if (inRecordCgg_res_denuncia.get('CRDEN_ESTADO_DENUNCIA') == 0 ){
            var param = new SOAPClientParameters();
            param.add('inCrden_codigo',txtCrden_codigo.getValue());
            param.add('inCrden_estado_denuncia',1);
            SOAPClient.invoke(urlCgg_res_denuncia,"updateDenunciaEstado",param, false, function(r){
                chkCrden_estado.setValue(true);
            });				
        }
        txtCusu_codigo.setValue(inRecordCgg_res_denuncia.get('CUSU_CODIGO'));
        txtCrden_anio.setValue(inRecordCgg_res_denuncia.get('CRDEN_ANIO'));
        txtCrden_numero.setValue(inRecordCgg_res_denuncia.get('CRDEN_NUMERO'));
        dtCrden_fecha_recepcion.setValue(truncDate(inRecordCgg_res_denuncia.get('CRDEN_FECHA_RECEPCION')));
        txtCrden_nombre_denunciante.setValue(inRecordCgg_res_denuncia.get('CRDEN_NOMBRES')+" "+inRecordCgg_res_denuncia.get('CRDEN_APELLIDOS'));
        txtCrden_numero_doc_ident.setValue(inRecordCgg_res_denuncia.get('CRDEN_NUMERO_DOC_IDENT'));
        txtCrden_nombres.setValue(inRecordCgg_res_denuncia.get('CRDEN_NOMBRES'));
        txtCrden_apellidos.setValue(inRecordCgg_res_denuncia.get('CRDEN_APELLIDOS'));
        txtCrden_descripcion.setValue(inRecordCgg_res_denuncia.get('CRDEN_DESCRIPCION'));
        txtCrden_contacto.setValue(inRecordCgg_res_denuncia.get('CRDEN_CONTACTO'));
        numCrden_tipo.setValue(inRecordCgg_res_denuncia.get('CRDEN_TIPO'));
        cbxCrden_denuncia.setValue(inRecordCgg_res_denuncia.get('CRDEN_DENUNCIA'));
        txtCrden_seguimiento.setValue(inRecordCgg_res_denuncia.get('CRDEN_SEGUIMIENTO'));			
        isEdit = true;
        habilitarCgg_res_denunciaCtrls(true);
    // HABILITAR EL CONTROL EL  cbxCrres_estado_denuncia

    }
}
/**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_denuncia.
     * @returns ventana winFrmCgg_res_denuncia.
     * @base FrmCgg_res_denuncia.prototype.show
     */
this.getWindow = function(){
    return winFrmCgg_res_denuncia;
}
/**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_denuncia.
     * @base FrmCgg_res_denuncia.prototype.loadData
     */
this.loadData = function(){
    cargarCgg_res_denunciaCtrls();
}
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_denuncia desde una instancia.
 */
FrmCgg_res_denuncia.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_denuncia desde una instancia.
 */
FrmCgg_res_denuncia.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_denuncia,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_denuncia.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_denuncia desde una instancia.
 */
FrmCgg_res_denuncia.prototype.loadData = function(){
    this.loadData();
}
