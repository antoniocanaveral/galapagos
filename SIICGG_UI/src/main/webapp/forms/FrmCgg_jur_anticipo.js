/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_jur_anticipo.
 * @param {String} IN_SENTENCIA_CGG_JUR_ANTICIPO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_JUR_ANTICIPO Registro de datos de la tabla Cgg_jur_anticipo.
 * @constructor
 * @base FrmListadoCgg_jur_anticipo
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_jur_anticipo(IN_SENTENCIA_CGG_JUR_ANTICIPO,IN_RECORD_CGG_JUR_ANTICIPO){
    var inSentenciaCgg_jur_anticipo = IN_SENTENCIA_CGG_JUR_ANTICIPO;
    var inRecordCgg_jur_anticipo=IN_RECORD_CGG_JUR_ANTICIPO;
    var urlCgg_jur_anticipo=URL_WS+"Cgg_jur_anticipo";
    var tituloCgg_jur_anticipo='Anticipo';
    var descCgg_jur_anticipo='El formulario permite administrar la informaci\u00f3n de Anticipo';
    var isEdit = false;
    var tmpCjacu_codigo;
    var tmpValor;
    var tmpCjacu_costo;
    var tmpOffValue = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ANTICIPO DE ACUERDO
     */
    var txtCjaac_codigo = new Ext.form.TextField({
        id:'txtCjaac_codigo',
        name:'txtCjaac_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * new Ext.Panel PANEL PARA LA VISUALIZACION DE LOS ACUERDOS
     */
    var pnlAcuerdo = new Ext.Panel({
        tbar:[
            {
                xtype:'label',
                text:'Seleccionar:'
            },
            {
                type:'button',
                id:'btnAcuerdo',
                text:'Contrato - Convenio ',
                iconCls:'iconBuscar',
                tooltip:'Buscar contrato convenio',
                handler:function(){
            var tmpAcuerdo = new Cgg_jur_acuerdo();
            var objBusqueda = new DlgBusqueda(tmpAcuerdo.getStoreAcuerdo(), tmpAcuerdo.getColumnAcuerdo());
            objBusqueda.closeHandler(function () {
                tmpAcuerdo = objBusqueda.getSelectedRow();

                if (tmpAcuerdo!=null) {
                    document.getElementById('divInfoAcuerdo').innerHTML =tmpInfoAcuerdo.apply(tmpAcuerdo.json);
                    tmpCjacu_codigo=tmpAcuerdo.get('CJACU_CODIGO');
                    tmpCjacu_costo=tmpAcuerdo.get('CJACU_COSTO');
                    numCjaac_monto.setValue(tmpCjacu_costo);
                    numCjaac_pagos.setValue(tmpAcuerdo.get('PAGOS'));
                    pnlCgg_jur_anticipo.enable();
                    btnGuardarCgg_jur_anticipo.enable();
                }
            });
            objBusqueda.show();
        }}],
        //bodyStyle:'padding:0px 0px 0px 0px;',
        frame:true,
        height:160,
        html:'<div id="divInfoAcuerdo" style="padding:0px 0px 0px 0px;"></div>'
    });
    /**
     * new Ext.XTemplate XTEMPLATE PARA LA VISUALIZACION DE LA INFORMACION  DE LOS ACUERDOS EN EL PANEL pnlAcuerdo
     */
    var tmpInfoAcuerdo = new Ext.XTemplate(
            '<table width="100%" height="100%" cellpadding="0">' +
                    '<tr rowspan="0"><td>' +
                    '<div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Tipo Persona</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">' +
                    '<tpl if="CJACU_TIPO_PERSONA ==TypeAdversario.PERSONA_NATURAL">'+
                        '<span style="font-weight: bold;">Persona Natural</span>',
                    '</tpl>',
                        '<tpl if="CJACU_TIPO_PERSONA ==TypeAdversario.PERSONA_JURIDICA">',
                    '<b>Persona Juridica</b>',
                    '</tpl>',
                    '</font></td></tr>' +
                    '<tr rowspan="0">' +
                     '<tpl if="CJACU_TIPO_PERSONA ==TypeAdversario.PERSONA_NATURAL">'+
                        '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Persona Natural</font></div></td>' +
                        '<td><div class="itemTemplate"><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{PERSONA}</span></div></td>' +
                    '</tpl>',
                     '<tpl if="CJACU_TIPO_PERSONA ==TypeAdversario.PERSONA_JURIDICA">',
                        '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Persona Juridica</font></div></td>' +
                        '<td><div class="itemTemplate"><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{RAZON_SOCIAL}</span></div></td>' +
                    '</tpl>',                                     
                    '</tr>' +
                    '<tr rowspan="0">' +
                    '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Acuerdo</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">' +
                    '<tpl if="CJACU_TIPO ==TypeTipoAcuerdo.Contrato">'+
                    '<span style="font-weight: bold;">Contrato</span>',
            '</tpl>',
            '<tpl if="CJACU_TIPO ==TypeTipoAcuerdo.Convenio">',
            '<b>Convenio</b>',
            '</tpl>',
            '</font></td>' +
                    '<div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Tipo</font></div></td>' +
                    '<td><div class="itemTemplate"><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{NOMBRE_PROCESO}</span></div></td></tr>' +
                    '<tr rowspan="0">' +
                    '<div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Numero</font></div></td>' +
                    '<td><div class="itemTemplate"><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{CJACU_NUMERO}</span></div></td>' +
                    '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">A\u00f1o</font></div></td>' +
                    '<td><div class="itemTemplate"><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{CJACU_ANIO}</span></div></td></tr>' +
                    '<tr rowspan="0">' +
                    '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif"> Fecha Inicio</font></div></td>' +
                    '<td><div class="itemTemplate"><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{[this.myFecha_Inicio(values.CJACU_FECHA_INICIO)]}</span></div>' +
                    '<td><div class="tituloTemplate"> <font face="Arial, Helvetica, sans-serif">Fecha Finalizaci\u00f3n</font></div></td>' +
                    '<td><div class="itemTemplate"><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{[this.myFecha_Finalizacion(values.CJACU_FECHA_FINALIZACION)]}</span></div></td></tr>' +
                    '</td></tr></table>',
    {
        // XTemplate configuration:
        disableFormats: true,
        // member functions:
        myFecha_Inicio: function(CJACU_FECHA_INICIO){
            return truncDate(CJACU_FECHA_INICIO);
        },
        myFecha_Suscripcion: function(CJACU_FECHA_SUSCRIPCION){
            return truncDate(CJACU_FECHA_SUSCRIPCION);
        },
        myFecha_Finalizacion: function(CJACU_FECHA_FINALIZACION){
            return truncDate(CJACU_FECHA_FINALIZACION);
        }

    }
            );

    /**
     * Ext.form.NumberField VALOR NUMERICO DEL PORCENAJE CORRESPONDIENTE(EJM. 50%)
     */
    var numCjaac_porcentaje = new Ext.form.NumberField({
        id:'numCjaac_porcentaje',
        name:'numCjaac_porcentaje',
        fieldLabel :'Porcentaje %',
        allowBlank :false,
        anchor:'90%',
        disabled :false,
        value:0,
        listeners:{
            blur :function (inField){
                valorAnticipo();
                var tmpDsembolso = (numCjaac_pagos.getValue()*1) + (txtCjaac_valor_1.getValue() *1) ;
                var tmp = tmpCjacu_costo *1;
                if ( tmpDsembolso > tmp)
                {
                    tmpOffValue = true;
                }

            }
        }
    });
    /**
     * Ext.form.TextArea CADENA DE TEXTO DE DESCRIPCION DEL PROCESO DE CONTRATACION.
     */
    var txtCjaac_observacion = new Ext.form.TextArea({
        id:'txtCjaac_observacion',
        name:'txtCjaac_observacion',
        fieldLabel :'Observaci\u00f3n',
        width:'98%',
        allowBlank :false

    });
    /**
     * Ext.form.DateField FECHA DE REALIZACION DEL ANTICIPO
     */
    var dtCjaac_fecha = new Ext.form.DateField({
        id:'dtCjaac_fecha',
        name:'dtCjaac_fecha',
        fieldLabel :'Fecha',
        allowBlank :false,
        format :'d/m/Y',
        value:new Date()
    });
    /**
     * Ext.form.NumberField MONTO DEL ANTICIPO
     */
    var numCjaac_monto = new Ext.form.NumberField({
        id:'numCjaac_monto',
        name:'numCjaac_monto',
        fieldLabel :'Monto',
        allowBlank :false,
        disabled :false,
        anchor:'90%',
        value:0,
        readOnly:true

    });

    var numCjaac_pagos = new Ext.form.NumberField({
        id:'numCjaac_pagos',
        name:'numCjaac_pagos',
        fieldLabel :'Pagos realizados',
        allowBlank :true,
        disabled :false,
        anchor:'90%',
        value:0,
        readOnly:true
    });
    /**
     * Ext.form.TextField VALOR AUXILIAR DE ANTICIPO
     */
    var txtCjaac_valor_1 = new Ext.form.TextField({
        id:'txtCjaac_valor_1',
        name:'txtCjaac_valor_1',
        fieldLabel :'Valor',
        anchor:'90%',
        allowBlank :false,
        readOnly:true
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_jur_anticipo
     */
    var btnGuardarCgg_jur_anticipo = new Ext.Button({
        id:'btnGuardarCgg_jur_anticipo',
        text:'Guardar',
        iconCls:'iconGuardar',
        disabled:true,
        listeners:{
            click:function(){
                if (!pnlCgg_jur_anticipo.getForm().isValid()){
                    return;
                }
                if(tmpOffValue == true)
                {
                    Ext.Msg.show({
                                title:tituloCgg_jur_anticipo,
                                msg: 'El valor por asignar supera el costo total del acuerdo.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                    return;
                }
                try{
                    function CallBackCgg_jur_anticipo(r){
                        winFrmCgg_jur_anticipo.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_jur_anticipo,
                                msg: 'La informaci\u00f3n de Anticipo ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            winFrmCgg_jur_anticipo.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_jur_anticipo,
                                msg: 'La informaci\u00f3n de Anticipo no ha podido ser almacenada. '+(r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_jur_anticipo.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCjaac_codigo',txtCjaac_codigo.getValue());
                    param.add('inCjacu_codigo',tmpCjacu_codigo);
                    param.add('inCjaac_porcentaje',numCjaac_porcentaje.getValue());
                    param.add('inCjaac_observacion',txtCjaac_observacion.getValue());
                    param.add('inCjaac_fecha',dtCjaac_fecha.getValue().format('c'));
                    param.add('inCjaac_monto',numCjaac_monto.getValue());
                    param.add('inCjaac_valor_1',txtCjaac_valor_1.getValue());
                    SOAPClient.invoke(urlCgg_jur_anticipo,IN_SENTENCIA_CGG_JUR_ANTICIPO,param, true, CallBackCgg_jur_anticipo);
                }catch(inErr){
                    winFrmCgg_jur_anticipo.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_jur_anticipo.
     */
    var btnCancelarCgg_jur_anticipo = new Ext.Button({
        id:'btnCancelarCgg_jur_anticipo',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_jur_anticipo.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_jur_anticipo.
     */
    var btnCerrarCgg_jur_anticipo = new Ext.Button({
        id:'btnCerrarCgg_jur_anticipo',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_jur_anticipo.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_jur_anticipo.
     */
    var pnlCgg_jur_anticipo = new Ext.form.FormPanel({
        frame:true,
        labelWidth :70,
        disabled:true,
        items:[txtCjaac_codigo,
            {xtype:'panel',layout:'column',
                items:[
                    {columnWidth:.33,layout:'form',items:[numCjaac_monto]},
                    {columnWidth:.33,layout:'form',labelWidth :80,items:[numCjaac_porcentaje]},
                    {columnWidth:.33,layout:'form',items:[txtCjaac_valor_1]}]},
                {xtype:'panel',layout:'column',
                items:[
                    {columnWidth:.5,layout:'form',items:[dtCjaac_fecha]},
                    {columnWidth:.5,layout:'form',items:[numCjaac_pagos]}
                    ]},
            txtCjaac_observacion]
    });

    function valorAnticipo(){
        tmpValor= Math.round(((numCjaac_monto.getValue()*numCjaac_porcentaje.getValue())/100));
        txtCjaac_valor_1.setValue(tmpValor);
    }
    valorAnticipo();
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_jur_anticipo.
     */
    var winFrmCgg_jur_anticipo = new Ext.Window({
        id:'winFrmCgg_jur_anticipo',
        title:tituloCgg_jur_anticipo,
        iconCls:'iconAplicacion',
        width:600,
        minWidth:600,
        maximizable:false,
        minimizable:true,
        modal:true,
        resizable:false,
        constrain:true,
        tbar:getPanelTitulo(tituloCgg_jur_anticipo,descCgg_jur_anticipo),
        items:[pnlAcuerdo,pnlCgg_jur_anticipo],
        bbar:[btnGuardarCgg_jur_anticipo,btnCancelarCgg_jur_anticipo,'->',btnCerrarCgg_jur_anticipo]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmCgg_jur_anticipo.getBottomToolbar());
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_jur_anticipo.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_jur_anticipoCtrls(inEstado){
        estado=!inEstado;
        txtCjaac_codigo.setDisabled(estado);
        numCjaac_porcentaje.setDisabled(estado);
        txtCjaac_observacion.setDisabled(estado);
        dtCjaac_fecha.setDisabled(estado);
        numCjaac_monto.setDisabled(estado);
        txtCjaac_valor_1.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_jur_anticipo.
     */
    function cargarCgg_jur_anticipoCtrls(){
        if(inRecordCgg_jur_anticipo){
            txtCjaac_codigo.setValue(inRecordCgg_jur_anticipo.get('CJAAC_CODIGO'));
            numCjaac_porcentaje.setValue(inRecordCgg_jur_anticipo.get('CJAAC_PORCENTAJE'));
            txtCjaac_observacion.setValue(inRecordCgg_jur_anticipo.get('CJAAC_OBSERVACION'));
            dtCjaac_fecha.setValue(truncDate(inRecordCgg_jur_anticipo.get('CJAAC_FECHA')));
            numCjaac_monto.setValue(inRecordCgg_jur_anticipo.get('CJAAC_MONTO'));
            txtCjaac_valor_1.setValue(inRecordCgg_jur_anticipo.get('CJAAC_VALOR_1'));
            pnlCgg_jur_anticipo.enable();
            isEdit = true;

            habilitarCgg_jur_anticipoCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_jur_anticipo.
     * @returns ventana winFrmCgg_jur_anticipo.
     * @base FrmCgg_jur_anticipo.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_jur_anticipo;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_jur_anticipo.
     * @base FrmCgg_jur_anticipo.prototype.loadData
     */
    this.loadData = function(inAcuerdo){
        cargarCgg_jur_anticipoCtrls();
        document.getElementById('divInfoAcuerdo').innerHTML =tmpInfoAcuerdo.apply(inAcuerdo.json);
        tmpCjacu_codigo=inAcuerdo.get('CJACU_CODIGO');
        tmpCjacu_costo=inAcuerdo.get('CJACU_COSTO');

    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_jur_anticipo desde una instancia.
 */
FrmCgg_jur_anticipo.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_jur_anticipo desde una instancia.
 */
FrmCgg_jur_anticipo.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_jur_anticipo,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_jur_anticipo.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_jur_anticipo desde una instancia.
 */
FrmCgg_jur_anticipo.prototype.loadData = function(){
    this.loadData();
}
