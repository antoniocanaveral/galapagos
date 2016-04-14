/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_regla_validacion.
* @param {String} IN_SENTENCIA_CGG_REGLA_VALIDACION Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_REGLA_VALIDACION Registro de datos de la tabla Cgg_regla_validacion.
* @constructor
* @base FrmListadoCgg_regla_validacion
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_regla_validacion(IN_SENTENCIA_CGG_REGLA_VALIDACION,IN_RECORD_CGG_REGLA_VALIDACION){
    var inSentenciaCgg_regla_validacion = IN_SENTENCIA_CGG_REGLA_VALIDACION;
    var inRecordCgg_regla_validacion=IN_RECORD_CGG_REGLA_VALIDACION;    
    var urlCgg_regla_validacion=URL_WS+"Cgg_regla_validacion";
    var tituloCgg_regla_validacion='Regla de validaci\u00f3n';
    var descCgg_regla_validacion='El formulario permite establecer informaci\u00f3n de una regla de validaci\u00f3n.';
    var isEdit = false;
    var tmpCgcnfCodigo = null;
    /**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
*/
    var txtCrval_codigo = new Ext.form.TextField({
        id:'txtCrval_codigo',
        name:'txtCrval_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PARAMETRO DE CONFIGURACION
*/
    var txtCgcnf_codigo = new Ext.form.TextField({
        id:'txtCgcnf_codigo',
        name:'txtCgcnf_codigo',
        fieldLabel :'Parametro',
        anchor:'98%',
        readOnly:'true'        
    });
    /**
* IDENTIFICATIVO UNICO DE REGISTRO DE PARAMETRO DE CONFIGURACION
*/
    var btnCgcnf_codigoCgg_regla_validacion = new Ext.Button({
        id:'btnCgcnf_codigoCgg_regla_validacion',        
        iconCls:'iconBuscar',        
        listeners:{
            click:function(){
                var tmpFLCgg_configuracion = new FrmListadoCgg_configuracion();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_configuracion.getStore(),tmpFLCgg_configuracion.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord!==null && tmpRecord!==undefined){
                        tmpCgcnfCodigo = tmpRecord.get('CGCNF_CODIGO');
                        txtCgcnf_codigo.setValue(tmpRecord.get('CGCNF_CONFIGURACION'));
                    }
                });
                objBusqueda.show();
            }
        }
    });
    /**
* Ext.form.TextField NOMBRE DE LA REGLA DE VALIDACION
*/
    var txtCrval_nombre = new Ext.form.TextField({
        id:'txtCrval_nombre',
        name:'txtCrval_nombre',
        fieldLabel :'Nombre',
        anchor:'98%',
        allowBlank :false
    });
    /**
* Ext.form.TextArea CADENA DE TEXTO DE DESCRIPCION DE LA REGLA DE VALIDACION.
*/
    var txtCrval_descripcion = new Ext.form.TextArea({
        id:'txtCrval_descripcion',
        name:'txtCrval_descripcion',
        fieldLabel :'Descripci\u00F3n',
        width:'98%',
        allowBlank :false
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO de seleccion de funcion.
     */   
    var txtCgg_regla_fn_nombre = new Ext.form.TextField({
        id:'txtCgg_regla_fn_nombre',
        name:'txtCgg_regla_fn_nombre',
        fieldLabel :'Funci\u00f3n',
        anchor:'98%',
        readOnly:true,
        allowBlank :false
    });
    var btnCgg_regla_fn_select = new Ext.Button({
        id:'btnCgg_regla_fn_select',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var funciones = new FuncionSQL();
                var objBusqueda = new DlgBusqueda(funciones.getStore(),funciones.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        txtCgg_regla_fn_nombre.setValue(tmpRecord.get('PRONAME'));
                    }
                });
                objBusqueda.show();
            }
        }
    });
    
/**
* Ext.form.ComboBox CADENA QUE IDENTIFICA EL OPERADOR COMPARADOR CON EL CUAL SE VA A EVALUAR LOS VALORES OBTENIDOS DE LS FUNCION DE VALIDACION.
*/
var cbxCrval_operador_comparador = new Ext.form.ComboBox({
    id:'cbxCrval_operador_comparador',
    name:'cbxCrval_operador_comparador',
    fieldLabel :'Comparador',
    anchor:'60%',
    store:dsOperador,
    typeAhead: true,
    forceSelection:true,
	editable:false,
    mode:'local',
    triggerAction:'all',
    allowBlank:false
});
      
/**
* Ext.form.TextArea CADENA DE TEXTO CON UN VALOR LIBRE SOBRE EL CUAL LA REGLA SE VALIDA, USAR ESTE CAMPO SOLO PARA REGLAS CUYO VALOR NO SE DESEE MANEJAR A TRAVEZ DE UN PARAMETRO DE CONFIGURACION
*/
var txtCrval_valor_libre = new Ext.form.TextField({
    id:'txtCrval_valor_libre',
    name:'txtCrval_valor_libre',
    fieldLabel :'Valor',
    anchor:'60%'
});
/**
* Ext.form.TextField CADENA DE TEXTO QUE IDENTIFICA EL VALOR POR EL CUAL SE COMPARA LA REGLA Y SE DA POR ACEPTADO.
*/
var txtCrval_resultado_aceptacion = new Ext.form.TextField({
    id:'txtCrval_resultado_aceptacion',
    name:'txtCrval_resultado_aceptacion',
    fieldLabel :'Aceptaci\u00f3n',
    anchor:'60%',
    allowBlank:false
});
/**
* Ext.form.TextArea CADENA DE TEXTO DE SUGERENCIA DEL PORQUE UNA REGLA FUE INVALIDA Y POSIBLE SOLUCIONES PARA ACEPCION DE LA REGLA
*/
var txtCrval_sugerencia = new Ext.form.TextArea({
    id:'txtCrval_sugerencia',
    name:'txtCrval_sugerencia',
    fieldLabel :'Sugerencia',
    width:'98%'
});

/**
* Ext.form.NumberField TIPO DE REGLA DE VALIDACION
0 - TEMPORAL
1 - INDEFINIDA
*/
var cbxCrval_tipo = new Ext.form.ComboBox({
    id:'cbxCrval_tipo',
    fieldLabel:'Tipo',
    store:dsModalidad,
    typeAhead: true,
    anchor:'60%',
    mode: 'local',
    triggerAction:'all',
    value:1,
    listeners:{
        select:function(inThis,inRecord,inIndex){
            if(inIndex==0){
                dtCrvar_fecha_fin.disable();
            }else{
                dtCrvar_fecha_fin.enable();
            }
        }
    }
});

/**
* Ext.form.DateField FECHA DE INICIO DEL PERIODO DE VIGENCIA DE LA REGLA DE VALIDACION.
*/
var dtCrvar_fecha_inicio = new Ext.form.DateField({
    id:'dtCrvar_fecha_inicio',
    name:'dtCrvar_fecha_inicio',
    fieldLabel :'Fecha inicio',
    format :'d/m/Y',
    value:new Date()
});
/**
* Ext.form.DateField FECHA DE FIN DEL PERIODO DE VIGENCIA DE LA REGLA DE VALIDACION.
*/
var dtCrvar_fecha_fin = new Ext.form.DateField({
    id:'dtCrvar_fecha_fin',
    name:'dtCrvar_fecha_fin',
    fieldLabel :'Fecha fin',
    format :'d/m/Y',
    value:new Date()
});
/**
* Ext.form.TextArea CADENA DE TEXTO DE VALOR ADICIONAL EN CASO DE ADECUACIONES A LAS REGLAS DE VALIDACION
*/
var txtCrval_valor_1 = new Ext.form.TextArea({
    id:'txtCrval_valor_1',
    name:'txtCrval_valor_1',
    fieldLabel :'Valor 1',
    width:'90%',
    allowBlank :false
});
/**
* Ext.form.TextArea NO ESPECIFICADO
*/
var txtCrval_valor_2 = new Ext.form.TextArea({
    id:'txtCrval_valor_2',
    name:'txtCrval_valor_2',
    fieldLabel :'Valor 2',
    width:'90%',
    allowBlank :false
});
/**
* Boton que permite almacenar la informacion de la ventana winFrmCgg_regla_validacion
*/
var btnGuardarCgg_regla_validacion = new Ext.Button({
    id:'btnGuardarCgg_regla_validacion',
    text:'Guardar',
    iconCls:'iconGuardar',
    listeners:{
        click:function(){
            if (pnlCgg_regla_validacion.getForm().isValid()==false){
                return;
            }
            try{
                function CallBackCgg_regla_validacion(r){
                    winFrmCgg_regla_validacion.getEl().unmask();
                    if(r=='true'){
                        Ext.Msg.show({
                            title:tituloCgg_regla_validacion,
                            msg: 'La informaci\u00f3n de Regla validacion ha sido almacenada.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.INFO
                        });
                        winFrmCgg_regla_validacion.close()
                    }else{
                        Ext.Msg.show({
                            title:tituloCgg_regla_validacion,
                            msg: 'La informaci\u00f3n de Regla validacion no ha podido ser almacenada. '+r,
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.ERROR
                        });
                    }
                }
                winFrmCgg_regla_validacion.getEl().mask('Guardando...', 'x-mask-loading');
                var param = new SOAPClientParameters();
                if(isEdit)
                    param.add('inCrval_codigo',txtCrval_codigo.getValue());
                param.add('inCgcnf_codigo',tmpCgcnfCodigo?tmpCgcnfCodigo:null);
                param.add('inCrval_nombre',txtCrval_nombre.getValue());
                param.add('inCrval_descripcion',txtCrval_descripcion.getValue());
                param.add('inCrval_funcion_validacion',txtCgg_regla_fn_nombre.getValue());
                param.add('inCrval_operador_comparador',cbxCrval_operador_comparador.getValue());
                param.add('inCrval_valor_libre',txtCrval_valor_libre.getValue());
                param.add('inCrval_resultado_aceptacion',txtCrval_resultado_aceptacion.getValue());
                param.add('inCrval_sugerencia',txtCrval_sugerencia.getValue());
                param.add('inCrval_tipo',cbxCrval_tipo.getValue());
                param.add('inCrvar_fecha_inicio',dtCrvar_fecha_inicio.getValue().format('c'));
                param.add('inCrvar_fecha_fin',dtCrvar_fecha_fin.getValue().format('c'));
                param.add('inCrval_valor_1',null);
                param.add('inCrval_valor_2',null);
                SOAPClient.invoke(urlCgg_regla_validacion,IN_SENTENCIA_CGG_REGLA_VALIDACION,param, true, CallBackCgg_regla_validacion);
            }catch(inErr){
                Ext.MsgPopup.msg(tituloCgg_regla_validacion, "Su regla no ha sido guardada.\nError:"+inErr);
                winFrmCgg_regla_validacion.getEl().unmask();
            }
        }
    }
});
/**
* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_regla_validacion.
*/
var btnCancelarCgg_regla_validacion = new Ext.Button({
    id:'btnCancelarCgg_regla_validacion',
    text:'Cancelar',
    iconCls:'iconCancelar',
    listeners:{
        click:function(){
            pnlCgg_regla_validacion.getForm().reset();
        }
    }
});
/**
* Boton que permite cerrar la ventana winFrmCgg_regla_validacion.
*/
var btnCerrarCgg_regla_validacion = new Ext.Button({
    id:'btnCerrarCgg_regla_validacion',
    text:'Cerrar',
    iconCls:'iconCerrar',
    listeners:{
        click:function(){
            winFrmCgg_regla_validacion.close();
        }
    }
});
/**
* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_regla_validacion.
*/
var pnlCgg_regla_validacion = new Ext.form.FormPanel({
    frame:true,
    labelWidth:100,
    items:[txtCrval_nombre,txtCrval_descripcion,
    {
        xtype:'panel',
        layout:'column',
        items:[

        {
            columnWidth:.92,
            layout:'form',
            items:[txtCgg_regla_fn_nombre]
            },

            {
            columnWidth:.08,
            layout:'form',
            items:[btnCgg_regla_fn_select]
            }]
        },
    cbxCrval_operador_comparador,{
        xtype:'panel',
        layout:'column',
        anchor:'98%',
        items:[{
            columnWidth:.93,
            layout:'form',
            items:[txtCgcnf_codigo]
        },{
            columnWidth:.07,
            layout:'form',
            items:[btnCgcnf_codigoCgg_regla_validacion]
        }]
    },txtCrval_valor_libre,txtCrval_resultado_aceptacion,txtCrval_sugerencia,cbxCrval_tipo,dtCrvar_fecha_inicio,dtCrvar_fecha_fin]
});
/**
* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_regla_validacion.
*/
var winFrmCgg_regla_validacion = new Ext.Window({
    id:'winFrmCgg_regla_validacion',
    title:tituloCgg_regla_validacion,
    width:400,
    minWidth:400,
    modal:true,
    resizable:false,
    constrain:true,
    iconCls:'iconRegla',
    tbar:getPanelTitulo(tituloCgg_regla_validacion,descCgg_regla_validacion),
    items:[pnlCgg_regla_validacion],
    bbar:[btnGuardarCgg_regla_validacion,btnCancelarCgg_regla_validacion,'->',btnCerrarCgg_regla_validacion]
});
/**
* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_regla_validacion.
* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
*/
function habilitarCgg_regla_validacionCtrls(inEstado){
    estado=!inEstado;
    txtCrval_codigo.setDisabled(estado);
    txtCgcnf_codigo.setDisabled(estado);
    txtCrval_nombre.setDisabled(estado);
    txtCrval_descripcion.setDisabled(estado);
    txtCgg_regla_fn_nombre.setDisabled(estado);
    cbxCrval_operador_comparador.setDisabled(estado);
    txtCrval_valor_libre.setDisabled(estado);
    txtCrval_resultado_aceptacion.setDisabled(estado);
    txtCrval_sugerencia.setDisabled(estado);
    cbxCrval_tipo.setDisabled(estado);
    dtCrvar_fecha_inicio.setDisabled(estado);
    dtCrvar_fecha_fin.setDisabled(estado);
    txtCrval_valor_1.setDisabled(estado);
    txtCrval_valor_2.setDisabled(estado);
}
/**
* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_regla_validacion.
*/
function cargarCgg_regla_validacionCtrls(){
    if(inRecordCgg_regla_validacion){
        txtCrval_codigo.setValue(inRecordCgg_regla_validacion.get('CRVAL_CODIGO'));
            
        tmpCgcnfCodigo = inRecordCgg_regla_validacion.get('CGCNF_CODIGO');

        var scpConfiguracion = new SOAPClientParameters();
        scpConfiguracion.add('inCgcnf_codigo',tmpCgcnfCodigo);
        scpConfiguracion.add('format',TypeFormat.JSON);
        SOAPClient.invoke(URL_WS+"Cgg_configuracion", 'select', scpConfiguracion, false, function(inServiceResponse){
            var configuracionResult = null;
            try{
                configuracionResult = Ext.util.JSON.decode(inServiceResponse);
                configuracionResult=configuracionResult[0];
                txtCgcnf_codigo.setValue(configuracionResult.CGCNF_CONFIGURACION);
            }catch(inErr){
                tmpCgcnfCodigo = null;
                txtCgcnf_codigo.setValue('');
            }
        });
                        
        txtCrval_nombre.setValue(inRecordCgg_regla_validacion.get('CRVAL_NOMBRE'));
        txtCrval_descripcion.setValue(inRecordCgg_regla_validacion.get('CRVAL_DESCRIPCION'));
        txtCgg_regla_fn_nombre.setValue(inRecordCgg_regla_validacion.get('CRVAL_FUNCION_VALIDACION'));
        cbxCrval_operador_comparador.setValue(inRecordCgg_regla_validacion.get('CRVAL_OPERADOR_COMPARADOR'));
        txtCrval_valor_libre.setValue(inRecordCgg_regla_validacion.get('CRVAL_VALOR_LIBRE'));
        txtCrval_resultado_aceptacion.setValue(inRecordCgg_regla_validacion.get('CRVAL_RESULTADO_ACEPTACION'));
        txtCrval_sugerencia.setValue(inRecordCgg_regla_validacion.get('CRVAL_SUGERENCIA'));
        cbxCrval_tipo.setValue(inRecordCgg_regla_validacion.get('CRVAL_TIPO'));
        dtCrvar_fecha_inicio.setValue(inRecordCgg_regla_validacion.get('CRVAR_FECHA_INICIO')?formatShortDate(inRecordCgg_regla_validacion.get('CRVAR_FECHA_INICIO')):null);
        dtCrvar_fecha_fin.setValue(inRecordCgg_regla_validacion.get('CRVAR_FECHA_FIN')?formatShortDate(inRecordCgg_regla_validacion.get('CRVAR_FECHA_FIN')):null);
        txtCrval_valor_1.setValue(inRecordCgg_regla_validacion.get('CRVAL_VALOR_1'));
        txtCrval_valor_2.setValue(inRecordCgg_regla_validacion.get('CRVAL_VALOR_2'));
        isEdit = true;
        habilitarCgg_regla_validacionCtrls(true);
    }
}
/**
* Funcion miembro que devuelve la ventana winFrmCgg_regla_validacion.
* @returns ventana winFrmCgg_regla_validacion.
* @base FrmCgg_regla_validacion.prototype.show
*/
this.getWindow = function(){
    return winFrmCgg_regla_validacion;
}
/**
* Funcion miembro que carga los controles de la ventana winFrmCgg_regla_validacion.
* @base FrmCgg_regla_validacion.prototype.loadData
*/
this.loadData = function(){
    cargarCgg_regla_validacionCtrls();
}
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_regla_validacion desde una instancia.
*/
FrmCgg_regla_validacion.prototype.show = function(){
    this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_regla_validacion desde una instancia.
*/
FrmCgg_regla_validacion.prototype.close = function(){
    this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_regla_validacion,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_regla_validacion.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_regla_validacion desde una instancia.
*/
FrmCgg_regla_validacion.prototype.loadData = function(){
    this.loadData();
}
