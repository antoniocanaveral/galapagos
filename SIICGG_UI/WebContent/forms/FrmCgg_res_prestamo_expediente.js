/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_prestamo_expediente.
 * @param {String} IN_SENTENCIA_CGG_RES_PRESTAMO_EXPEDIENTE Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_RES_PRESTAMO_EXPEDIENTE Registro de datos de la tabla Cgg_res_prestamo_expediente.
 * @constructor
 * @base FrmListadoCgg_res_prestamo_expediente
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_prestamo_expediente(IN_SENTENCIA_CGG_RES_PRESTAMO_EXPEDIENTE,IN_RECORD_CGG_RES_PRESTAMO_EXPEDIENTE){
    var inSentenciaCgg_res_prestamo_expediente = IN_SENTENCIA_CGG_RES_PRESTAMO_EXPEDIENTE;
    var inRecordCgg_res_prestamo_expediente=IN_RECORD_CGG_RES_PRESTAMO_EXPEDIENTE;
    var urlCgg_res_prestamo_expediente=URL_WS+"Cgg_res_prestamo_expediente";
    var tituloCgg_res_prestamo_expediente='Movimiento de prestamos expedientes';
    var descCgg_res_prestamo_expediente='El formulario permite administrar la informaci\u00f3n de  prestamo expediente';
    var isEdit = false;
    var tmpMovimiento;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCrpex_codigo = new Ext.form.TextField({
        id:'txtCrpex_codigo',
        name:'txtCrpex_codigo',
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
        hidden:true,
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true'
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO
     */
    var btnCusu_codigoCgg_res_prestamo_expediente = new Ext.Button({
        id:'btnCusu_codigoCgg_res_prestamo_expediente',
        text:'Cusu_codigo',
        iconCls:'iconCusu_codigo',
        listeners:{
            click:function(){
                var tmpFLCgg_usuario = new FrmListadoCgg_usuario();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_usuario.getStore(),tmpFLCgg_usuario.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        txtCusu_codigo.setValue(tmpRecord.get('CUSU_CODIGO'));
                    }
                });
                objBusqueda.show();
            }}
    });
    /**  /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO
     */
    var txtCrper_codigo = new Ext.form.TextField({
        id:'txtCrper_codigo',
        name:'txtCrper_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        hidden:true
    });
    
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
     */
    var txtCgg_crper_codigo = new Ext.form.TextField({
        id:'txtCgg_crper_codigo',
        name:'txtCgg_crper_codigo',
        fieldLabel :'Crper codigo',
        hidden:true,
        anchor:'98%',
        readOnly:'true'
    });
    /**
     * Ext.form.TextField REGISTRO DE PERSONA QUIEN ENTREGA EL EXPEDIENTE
     */
    var txtCgg_crper_nombre_entrega = new Ext.form.TextField({
        id:'txtCgg_crper_nombre_entrega',
        name:'txtCgg_crper_nombre_entrega',
        fieldLabel :'Nombre',
        anchor:'98%',
        readOnly:'true'
    });


    /**
     * CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
     */
    var btnCgg_crper_codigoCgg_res_prestamo_expediente = new Ext.Button({
        id:'btnCgg_crper_codigoCgg_res_prestamo_expediente',
        iconCls:'iconBuscar',
        tooltip:TypeTooltip.BUSCAR + ' residente',
        listeners:{
            click:function(){
                var tmpFLCgg_res_persona = new Persona();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona.getStore(),tmpFLCgg_res_persona.getCm());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        txtCgg_crper_codigo.setValue(tmpRecord.get('CRPER_CODIGO'));
                    txtCgg_crper_nombre_entrega.setValue(tmpRecord.get('CRPER_NOMBRES')+" "+tmpRecord.get('CRPER_APELLIDO_PATERNO')+" "+tmpRecord.get('CRPER_APELLIDO_MATERNO'));
                    }
                });
                objBusqueda.show();
            }}
    });

    /**
     * Ext.form.DateField FECHA REGISTRADA DE ULTIMO MOVIMIENTO ENTRADA/SALIDA
     */
    var dtCrpex_fecha_operacion = new Ext.form.DateField({
        id:'dtCrpex_fecha_operacion',
        name:'dtCrpex_fecha_operacion',
        fieldLabel :'Fecha',
        allowBlank :false,
        format :'d/m/Y',
        value:new Date()
    
    });
    /**
     * Ext.form.NumberField TIPO DE OPERACION REALIZADA ENTRADA/SALIDA
     */
    var numCrpex_movimiento = new Ext.form.NumberField({
        id:'numCrpex_movimiento',
        name:'numCrpex_movimiento',
        fieldLabel :'Movimiento'

    });
   
    /**
     * Ext.form.TextField OBSERVACION DE LA OPERACION REALIZADA
     */
    var txtCrpex_observacion = new Ext.form.TextArea({
        id:'txtCrpex_observacion',
        name:'txtCrpex_observacion',
        fieldLabel :'Observacion',
        anchor:'98%',
        width:'98%'
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_prestamo_expediente
     */
    var btnGuardarCgg_res_prestamo_expediente = new Ext.Button({
        id:'btnGuardarCgg_res_prestamo_expediente',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:TypeTooltip.GUARDAR,
        listeners:{
            click:function(){
                if (pnlCgg_res_prestamo_expediente.getForm().isValid()==false){
                    return;
                }

                if((numCrpex_movimiento.getValue()==TypeMovimientoExpediente.ARCHIVO) || (numCrpex_movimiento.getValue()==TypeMovimientoExpediente.INGRESO) ){
                    tmpMovimiento=TypeMovimientoExpediente.SALIDA;
                }else{
                    if(numCrpex_movimiento.getValue()==TypeMovimientoExpediente.SALIDA){
                        tmpMovimiento=TypeMovimientoExpediente.INGRESO;
                    }

                }
                try{
                    function CallBackCgg_res_prestamo_expediente(r){
                        winFrmCgg_res_prestamo_expediente.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_res_prestamo_expediente,
                                msg: 'La informaci\u00f3n  ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_res_prestamo_expediente.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_res_prestamo_expediente,
                                msg: 'La informaci\u00f3n  no ha podido ser almacenada. '+r,
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_res_prestamo_expediente.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCrpex_codigo',txtCrpex_codigo.getValue());
                    param.add('inCusu_codigo',null);
                    param.add('inCrper_codigo',txtCrper_codigo.getValue());
                    param.add('inCgg_crper_codigo',txtCgg_crper_codigo.getValue());
                    param.add('inCrpex_fecha_operacion',Date.parseDate(dtCrpex_fecha_operacion.getValue().format('d/m/Y')+' '+new Date().format('H:i:s'),'d/m/Y H:i:s').format('c'));
                    param.add('inCrpex_movimiento',tmpMovimiento);
                    param.add('inCrpex_observacion',txtCrpex_observacion.getValue());
                    SOAPClient.invoke(urlCgg_res_prestamo_expediente,IN_SENTENCIA_CGG_RES_PRESTAMO_EXPEDIENTE,param, true, CallBackCgg_res_prestamo_expediente);
                }catch(inErr){
                    winFrmCgg_res_prestamo_expediente.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_prestamo_expediente.
     */
    var btnCancelarCgg_res_prestamo_expediente = new Ext.Button({
        id:'btnCancelarCgg_res_prestamo_expediente',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:'Cancela el registro',
        listeners:{
            click:function(){
                pnlCgg_res_prestamo_expediente.getForm().reset();
               //alert(Date.parseDate(dtCrpex_fecha_operacion.getValue().format('d/m/Y')+' '+new Date().format('H:i:s'),'d/m/Y H:i:s').format('c'));

            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_prestamo_expediente.
     */
    var btnCerrarCgg_res_prestamo_expediente = new Ext.Button({
        id:'btnCerrarCgg_res_prestamo_expediente',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:'Salir',
        listeners:{
            click:function(){
                winFrmCgg_res_prestamo_expediente.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_prestamo_expediente.
     */
    var pnlCgg_res_prestamo_expediente = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCrpex_codigo,
            {xtype:'panel',layout:'column',
                items:[{columnWidth:.95,layout:'form',
                    items:[txtCgg_crper_nombre_entrega]},{columnWidth:.05,layout:'form',
                    items:[btnCgg_crper_codigoCgg_res_prestamo_expediente]}]},
            {xtype:'panel',layout:'column',
                items:[{columnWidth:.6,layout:'form',
                    items:[dtCrpex_fecha_operacion]}]},
            txtCrpex_observacion]
    });
    var tmpInfoPersonaExpediente = new Ext.XTemplate(
            '<table width="100%" height="100%" cellpadding="0">' +
                    '<tr rowspan="0"><td><div class="tituloTemplate">No.</div></td>' +
                    '<td><div class="itemTemplate">{CRPER_NUMERO_EXPEDIENTE}</div></td>' +
                    '<td><div class="tituloTemplate">Fecha de archivo:</div></td>' +
                    '<td><div class="itemTemplate">{[this.myDate(values.CRPER_FECHA_ARCHIVO)]}</div></td></tr>' +
                    '<tr rowspan="0"><td><div class="tituloTemplate">Nombres:</div></td>' +
                    '<td><div class="itemTemplate">{CRPEX_NOMBRE}</div></td>'+
                    '<tr rowspan="0"><td><div class="tituloTemplate">No. de identidad:</div></td>' +
                    '<td><div class="itemTemplate">{CRPER_NUM_DOC_IDENTIFIC}</div></td></tr></table>',
              {
            // XTemplate configuration:
            compiled: true,
            disableFormats: true,
            // member functions:
            myDate: function(CRPER_FECHA_ARCHIVO){
                return truncDate(CRPER_FECHA_ARCHIVO);
            }});
    
    var pnlPersona= new Ext.Panel({
        frame:true,
        items:[
            {xtype:'panel',//layout:'column',
                defaults: {      // defaults applied to items
                    // layout: 'form',
                    // border: false,
                    bodyStyle: 'padding:4px'
                },
                items:[
                    {
                        xtype:'fieldset',
                        // columnWidth: 0.75,
                        layout:'form',

                        title:'Datos personales',
                        //tpl:tplInfoPersona,
                        items:[
                            {xtype:'panel', id :'pnlPersonaConsultaExpediente',tpl:tmpInfoPersonaExpediente}]
} ]
}]
    });





    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_prestamo_expediente.
     */
    var winFrmCgg_res_prestamo_expediente = new Ext.Window({
        id:'winFrmCgg_res_prestamo_expediente',
        title:tituloCgg_res_prestamo_expediente,
        width:500,
        modal:true,
        minWidth:500,
        height:300,
        minheight:300,
        autoHeight:true,
        constrain:true,
        resizable:false,
        tbar:getPanelTitulo(tituloCgg_res_prestamo_expediente,descCgg_res_prestamo_expediente),
        items:[pnlPersona,pnlCgg_res_prestamo_expediente],
        bbar:[btnGuardarCgg_res_prestamo_expediente,btnCancelarCgg_res_prestamo_expediente,'->',btnCerrarCgg_res_prestamo_expediente],
        listeners:{
            show:function(){
                if(IN_RECORD_CGG_RES_PRESTAMO_EXPEDIENTE)
                {
                    tmpInfoPersonaExpediente.overwrite(pnlPersona.body, inRecordCgg_res_prestamo_expediente.json)
                    txtCrper_codigo.setValue(inRecordCgg_res_prestamo_expediente.get('CRPER_CODIGO'));
                    numCrpex_movimiento.setValue(inRecordCgg_res_prestamo_expediente.get('CRPEX_MOVIMIENTO'));



                }
                else
                {
                    alert('NO EXISTE INFORMACION PARA VIZUALIZAR');
                }
            }
        }
    });    
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_prestamo_expediente.
     */
    function cargarCgg_res_prestamo_expedienteCtrls(){
        if(inRecordCgg_res_prestamo_expediente){
            txtCrpex_codigo.setValue(inRecordCgg_res_prestamo_expediente.get('CRPEX_CODIGO'));
            txtCusu_codigo.setValue(inRecordCgg_res_prestamo_expediente.get('CUSU_CODIGO'));
            txtCgg_crper_nombre_entrega.setValue(inRecordCgg_res_prestamo_expediente.get('CRPER_NOMBRES'));
            txtCgg_crper_codigo.setValue(inRecordCgg_res_prestamo_expediente.get('CRPER_CODIGO'));
            dtCrpex_fecha_operacion.setValue(inRecordCgg_res_prestamo_expediente.get('CRPEX_FECHA_OPERACION'));
            numCrpex_movimiento.setValue(inRecordCgg_res_prestamo_expediente.get('CRPEX_MOVIMIENTO'));
            txtCrpex_observacion.setValue(inRecordCgg_res_prestamo_expediente.get('CRPEX_OBSERVACION'))
            isEdit = true;            
        }
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_prestamo_expediente.
     * @returns ventana winFrmCgg_res_prestamo_expediente.
     * @base FrmCgg_res_prestamo_expediente.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_prestamo_expediente;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_prestamo_expediente.
     * @base FrmCgg_res_prestamo_expediente.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_prestamo_expedienteCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_prestamo_expediente desde una instancia.
 */
FrmCgg_res_prestamo_expediente.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_prestamo_expediente desde una instancia.
 */
FrmCgg_res_prestamo_expediente.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_prestamo_expediente,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_prestamo_expediente.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_prestamo_expediente desde una instancia.
 */
FrmCgg_res_prestamo_expediente.prototype.loadData = function(){
    this.loadData();
}
