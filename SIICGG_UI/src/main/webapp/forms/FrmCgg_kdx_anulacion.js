/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_kdx_anulacion.
 * @param {String} IN_SENTENCIA_CGG_KDX_ANULACION Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_KDX_ANULACION Registro de datos de la tabla Cgg_kdx_anulacion.
 * @constructor
 * @base FrmListadoCgg_kdx_anulacion
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_kdx_anulacion(IN_SENTENCIA_CGG_KDX_ANULACION,IN_RECORD_CGG_KDX_ANULACION){
    var inSentenciaCgg_kdx_anulacion = IN_SENTENCIA_CGG_KDX_ANULACION;
    var inRecordCgg_kdx_anulacion=IN_RECORD_CGG_KDX_ANULACION;
    var urlCgg_kdx_anulacion=URL_WS+"Cgg_kdx_anulacion";
    var tituloCgg_kdx_anulacion='Anulaci\u00f3n de especies';
    var descCgg_kdx_anulacion='El formulario permite administrar la informaci\u00f3n de Anulaci\u00f3n de especies';
    var isEdit = false;
    var tmpCantidadDisponible;
    var tmpSerieInicio;
    var tmpSerieFin;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE UNA ANULACION
     */
    var txtCkanl_codigo = new Ext.form.TextField({
        id:'txtCkanl_codigo',
        name:'txtCkanl_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION
     */
    var txtCkasg_codigo = new Ext.form.TextField({
        id:'txtCkasg_codigo',
        name:'txtCkasg_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION
     */
    var txtCkasg_numero = new Ext.form.TextField({
        id:'txtCkasg_numero',
        name:'txtCkasg_numero',
        fieldLabel :'No. asiganci\u00f3n',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION
     */
    var btnCkasg_codigoCgg_kdx_anulacion = new Ext.Button({
        id:'btnCkasg_codigoCgg_kdx_anulacion',
        iconCls:'iconBuscar',
        tooltip:'Buscar asignaci\u00f3n',
        listeners:{
            click:function(){
                /*var tmpFLCgg_kdx_asignacion = new FrmListadoCgg_kdx_asignacion();
                 var objBusqueda = new DlgBusqueda(tmpFLCgg_kdx_asignacion.getStore(),tmpFLCgg_kdx_asignacion.getColumnModel());
                 objBusqueda.closeHandler(function(){
                 var tmpRecord = objBusqueda.getSelectedRow();
                 if(tmpRecord)
                 txtCkasg_codigo.setValue(tmpRecord.get('CKASG_CODIGO'));
                 });
                 objBusqueda.show();*/

                var tmpFLCgg_kdx_transferencia = new Cgg_kdx_asignacion_usuario(txtCkupv_codigo.getValue());
                var objBusqueda = new DlgBusqueda(tmpFLCgg_kdx_transferencia.getStore(),tmpFLCgg_kdx_transferencia.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                    {
                        txtCkasg_codigo.setValue(tmpRecord.get('CKASG_CODIGO'));
                        txtCkasg_numero.setValue(tmpRecord.get('CKASG_NUMERO_ASIGNACION'));
                        numCkanl_precio_unitario.setValue(tmpRecord.get('CKASG_PRECIO_UNITARIO'));
                        txtEspecie_asignacion.setValue(tmpRecord.get('CKESP_NOMBRE'));
                        tmpCantidadDisponible = tmpRecord.get('CKASG_CANTIDAD_DISPONIBLE');
                        tmpSerieInicio = tmpRecord.get('CKASG_SERIE_INICIO');
                        tmpSerieFin = tmpRecord.get('CKASG_SERIE_FIN');
                    }
                });
                objBusqueda.show();

            }}
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
     */
    var txtCkupv_codigo = new Ext.form.TextField({
        id:'txtCkupv_codigo',
        name:'txtCkupv_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });

    /**
     * Ext.form.TextField NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA ASIGNACION
     */
    var txtCkanl_numero_anulacion = new Ext.form.TextField({
        id:'txtCkanl_numero_anulacion',
        name:'txtCkanl_numero_anulacion',
        fieldLabel :'No. anulaci\u00f3n',
        anchor:'98%',
        allowBlank :false,
        readOnly:true
    });
    /**
     * Ext.form.DateField FECHA DE RECEPCION DE LAS ESPECIES
     */
    var dtCkanl_fecha_anulacion = new Ext.form.DateField({
        id:'dtCkanl_fecha_anulacion',
        name:'dtCkanl_fecha_anulacion',
        fieldLabel :'Fecha anulacion',
        allowBlank :false,
        format :'d/m/Y',
        value:new Date()
    });

    /**
     * Ext.form.TextField NOMBRE DE LA ESPECIE DE LA CUAL SE REALIZARA LA ASIGNACION
     */
    var txtEspecie_asignacion = new Ext.form.TextField({
        id:'txtEspecie_asignacion',
        name:'txtEspecie_asignacion',
        fieldLabel :'Especie',
        anchor:'98%',
        disabled:true
    });
    /**
     * Ext.form.NumberField CANTIDAD DE ESPECIES
     */
    var numCkanl_cantidad = new Ext.form.NumberField({
        id:'numCkanl_cantidad',
        name:'numCkanl_cantidad',
        fieldLabel :'Cantidad',
        allowBlank :false,
        disabled :false,
        readOnly:true
    });
    /**
     * Ext.form.NumberField PRECIO DE VENTA DE LA ESPECIE
     */
    var numCkanl_precio_unitario = new Ext.form.NumberField({
        id:'numCkanl_precio_unitario',
        name:'numCkanl_precio_unitario',
        fieldLabel :'Precio unitario',
        allowBlank :false,
        disabled :false
    });
    /**
     * Ext.form.NumberField VALOR TOTAL DE LA ANULACION
     */
    var numCkanl_precio_total = new Ext.form.NumberField({
        id:'numCkanl_precio_total',
        name:'numCkanl_precio_total',
        fieldLabel :'Precio total',
        allowBlank :false,
        disabled :false
    });
    /**
     * Ext.form.NumberField SERIE DE INICIO DE LAS ESPECIES
     */
    var numCkanl_serie_inicio = new Ext.form.NumberField({
        id:'numCkanl_serie_inicio',
        name:'numCkanl_serie_inicio',
        fieldLabel :'Serie inicio',
        allowBlank :false,
        disabled :false,
        enableKeyEvents:true,
        listeners:{
            change:function(ctrl,newValue,oldValue){
                calcularTotal();
            },
            specialkey: function(field, e){
                if (e.getKey() == e.ENTER) {
                    calcularTotal();
                }
            }

        }
    });
    /**
     * Ext.form.NumberField SERIE DE FIN DE LAS ESPECIES
     */
    var numCkanl_serie_fin = new Ext.form.NumberField({
        id:'numCkanl_serie_fin',
        name:'numCkanl_serie_fin',
        fieldLabel :'Serie fin',
        allowBlank :false,
        disabled :false,
        enableKeyEvents:true,
        minValue:numCkanl_serie_inicio.getValue(),
        listeners:{
            change:function(ctrl,newValue,oldValue){
                calcularTotal();
            },
            specialkey: function(field, e){
                if (e.getKey() == e.ENTER) {
                    calcularTotal();
                }
            }

        }
    });

    function calcularTotal()
    {
        if (numCkanl_serie_inicio.getValue()&&numCkanl_serie_fin.getValue())
        {
            numCkanl_cantidad.setValue(numCkanl_serie_fin.getValue() -numCkanl_serie_inicio.getValue() + 1);
            numCkanl_precio_total.setValue(numCkanl_cantidad.getValue()*numCkanl_precio_unitario.getValue());
        }
        else
        {
            if (numCkanl_serie_inicio.getValue())
            {
                if (numCkanl_serie_inicio.getValue() <= tmpSerieInicio || numCkanl_serie_inicio.getValue()>= tmpSerieFin)
                {
                    Ext.Msg.show({
                                title:tituloCgg_kdx_anulacion,
                                msg: 'Las serie ingresada no corresponde al rango registrado en la asignacion',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                    numCkanl_serie_inicio.focus();
                }
            }
            if (numCkanl_serie_fin.getValue())
            {
                if (numCkanl_serie_fin.getValue() <= tmpSerieInicio || numCkanl_serie_fin.getValue()>= tmpSerieFin ||numCkanl_serie_fin.getValue()<numCkanl_serie_inicio.getValue())
                {
                    Ext.Msg.show({
                                title:tituloCgg_kdx_anulacion,
                                msg: 'Las serie ingresada no corresponde al rango registrado en la asignacion. \nVerique su informacion por favor.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                }
            }

        }
    }
    /**
     * Ext.form.TextArea COMENTARIO AFIN A LA ASIGNACION
     */
    var txtCkanl_observacion = new Ext.form.TextArea({
        id:'txtCkanl_observacion',
        name:'txtCkanl_observacion',
        fieldLabel :'Observacion',
        width:'90%',
        allowBlank :false
    });
    /**
     * Ext.form.TextArea DESCRIPCION DE LA JUSTIFICACION QUE MOTIVO LA ANULACION
     */
    var txtCkanl_justificacion = new Ext.form.TextArea({
        id:'txtCkanl_justificacion',
        name:'txtCkanl_justificacion',
        fieldLabel :'Justificacion',
        width:'90%',
        allowBlank :false
    });
    /**
     * Ext.form.NumberField TIPO DE ANULACION:
     0.- DEFECTO FABRICA
     1.- OTRAS
     */
    var numCkanl_tipo_anulacion = new Ext.form.NumberField({
        id:'numCkanl_tipo_anulacion',
        name:'numCkanl_tipo_anulacion',
        fieldLabel :'Tipo anulacion',
        allowBlank :false,
        disabled :false
    });
    var cbxCkanl_tipo_anulacion = new Ext.form.ComboBox({
        id:'cbxCkanl_tipo_anulacion',
        name:'cbxCkanl_tipo_anulacion',
        store: dsTipoAnulacion,
        anchor:'75%',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        editable: false,
        allowBlank :false,
        triggerAction:'all',
        emptyText : 'Seleccione el tipo de anulacion',
		value:0
    });
    /**
     * Ext.form.NumberField ESTADO DEL REGISTRO DE VENTA UTILIZADO PARA OPERACIONES
     0.-  REGISTRADA
     1.-  CONFIRMADA
     */
    var numCkanl_estado_anulacion = new Ext.form.NumberField({
        id:'numCkanl_estado_anulacion',
        name:'numCkanl_estado_anulacion',
        fieldLabel :'Estado anulacion',
        allowBlank :false,
        disabled :false
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_kdx_anulacion
     */
    var btnGuardarCgg_kdx_anulacion = new Ext.Button({
        id:'btnGuardarCgg_kdx_anulacion',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (!pnlCgg_kdx_anulacion.getForm().isValid()){
                    return;
                }
                try{
                    function CallBackCgg_kdx_anulacion(r){
                        winFrmCgg_kdx_anulacion.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_kdx_anulacion,
                                msg: 'La informaci\u00f3n de Anulaci\u00f3n de especies ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_kdx_anulacion.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_kdx_anulacion,
                                msg: 'La informaci\u00f3n de Anulaci\u00f3n de especies no ha podido ser almacenada. '+(r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_kdx_anulacion.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCkanl_codigo',txtCkanl_codigo.getValue());
                    param.add('inCkasg_codigo',txtCkasg_codigo.getValue());
                    param.add('inCkupv_codigo',txtCkupv_codigo.getValue());
                    param.add('inCkanl_numero_anulacion',txtCkanl_numero_anulacion.getValue());
                    param.add('inCkanl_fecha_anulacion',dtCkanl_fecha_anulacion.getValue().format('c'));
                    param.add('inCkanl_cantidad',numCkanl_cantidad.getValue());
                    param.add('inCkanl_precio_unitario',numCkanl_precio_unitario.getValue());
                    param.add('inCkanl_precio_total',numCkanl_precio_total.getValue());
                    param.add('inCkanl_serie_inicio',numCkanl_serie_inicio.getValue());
                    param.add('inCkanl_serie_fin',numCkanl_serie_fin.getValue());
                    param.add('inCkanl_observacion',txtCkanl_observacion.getValue());
                    param.add('inCkanl_justificacion',txtCkanl_justificacion.getValue());
                    param.add('inCkanl_tipo_anulacion',cbxCkanl_tipo_anulacion.getValue());
                    param.add('inCkanl_estado_anulacion',TypeEstadoAnulacion.CONFIRMADA);
                    SOAPClient.invoke(urlCgg_kdx_anulacion,IN_SENTENCIA_CGG_KDX_ANULACION+'1',param, true, CallBackCgg_kdx_anulacion);
                }catch(inErr){
                    winFrmCgg_kdx_anulacion.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_kdx_anulacion.
     */
    var btnCancelarCgg_kdx_anulacion = new Ext.Button({
        id:'btnCancelarCgg_kdx_anulacion',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_kdx_anulacion.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_kdx_anulacion.
     */
    var btnCerrarCgg_kdx_anulacion = new Ext.Button({
        id:'btnCerrarCgg_kdx_anulacion',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_kdx_anulacion.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_kdx_anulacion.
     */
    var pnlCgg_kdx_anulacion = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCkanl_numero_anulacion,dtCkanl_fecha_anulacion,{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCkasg_numero]},{columnWidth:.4,layout:'form',items:[btnCkasg_codigoCgg_kdx_anulacion]}]},
            txtEspecie_asignacion,numCkanl_serie_inicio,numCkanl_serie_fin,numCkanl_cantidad,numCkanl_precio_unitario,numCkanl_precio_total,cbxCkanl_tipo_anulacion,txtCkanl_justificacion,txtCkanl_observacion]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_kdx_anulacion.
     */
    var winFrmCgg_kdx_anulacion = new Ext.Window({
        id:'winFrmCgg_kdx_anulacion',
        title:tituloCgg_kdx_anulacion,
        iconCls:'iconAplicacion',
        width:400,
        minWidth:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        tbar:getPanelTitulo(tituloCgg_kdx_anulacion,descCgg_kdx_anulacion),
        items:[pnlCgg_kdx_anulacion],
        bbar:[btnGuardarCgg_kdx_anulacion,btnCancelarCgg_kdx_anulacion,'->',btnCerrarCgg_kdx_anulacion],
        listeners:{
            show:function()
            {
                if (!isEdit)
                {
                    usuarioPuntoventa();
                    numeroAnulacion();
                }
            }
        }
    });
     /**
     * Funcion que permite mostrar el numero de anulacion
     */
    function numeroAnulacion()
    {

        try{
            function callBacknumeroAnulacion(r){
                txtCkanl_numero_anulacion.setValue(r);
            }
            SOAPClient.invoke(urlCgg_kdx_anulacion,"numeroAnulacion",false, false, callBacknumeroAnulacion);

        }catch(inErr){
            // winFrmCgg_kdx_asignacion.getEl().unmask();
        }

    }
    /**
     * Funcion que permite mostrar el numero de transferencia
     */
    function usuarioPuntoventa()
    {

        //try{
        function callBackUsuarioPuntoVenta(r){
            var res = Ext.util.JSON.decode(r)[0];
            txtCkupv_codigo.setValue(res.CKUPV_CODIGO);
        }
        var param = new SOAPClientParameters();
        param.add('format',TypeFormat.JSON);
        SOAPClient.invoke(URL_WS+'Cgg_kdx_asignacion',"selectUsuarioPuntoVenta",param, true, callBackUsuarioPuntoVenta);

        //}catch(inErr){
        // winFrmCgg_kdx_asignacion.getEl().unmask();
        //}

    }
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmCgg_kdx_anulacion.getBottomToolbar());
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_kdx_anulacion.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_kdx_anulacionCtrls(inEstado){
        estado=!inEstado;
        txtCkanl_codigo.setDisabled(estado);
        txtCkasg_codigo.setDisabled(estado);
        txtCkupv_codigo.setDisabled(estado);
        txtCkanl_numero_anulacion.setDisabled(estado);
        dtCkanl_fecha_anulacion.setDisabled(estado);
        numCkanl_cantidad.setDisabled(estado);
        numCkanl_precio_unitario.setDisabled(estado);
        numCkanl_precio_total.setDisabled(estado);
        numCkanl_serie_inicio.setDisabled(estado);
        numCkanl_serie_fin.setDisabled(estado);
        txtCkanl_observacion.setDisabled(estado);
        txtCkanl_justificacion.setDisabled(estado);
        cbxCkanl_tipo_anulacion.setDisabled(estado);
        numCkanl_estado_anulacion.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_kdx_anulacion.
     */
    function cargarCgg_kdx_anulacionCtrls(){
        if(inRecordCgg_kdx_anulacion){
            txtCkanl_codigo.setValue(inRecordCgg_kdx_anulacion.get('CKANL_CODIGO'));
            txtCkasg_codigo.setValue(inRecordCgg_kdx_anulacion.get('CKASG_CODIGO'));
            txtCkupv_codigo.setValue(inRecordCgg_kdx_anulacion.get('CKUPV_CODIGO'));
            txtCkanl_numero_anulacion.setValue(inRecordCgg_kdx_anulacion.get('CKANL_NUMERO_ANULACION'));
            dtCkanl_fecha_anulacion.setValue(truncDate(inRecordCgg_kdx_anulacion.get('CKANL_FECHA_ANULACION')));
            numCkanl_cantidad.setValue(inRecordCgg_kdx_anulacion.get('CKANL_CANTIDAD'));
            numCkanl_precio_unitario.setValue(inRecordCgg_kdx_anulacion.get('CKANL_PRECIO_UNITARIO'));
            numCkanl_precio_total.setValue(inRecordCgg_kdx_anulacion.get('CKANL_PRECIO_TOTAL'));
            numCkanl_serie_inicio.setValue(inRecordCgg_kdx_anulacion.get('CKANL_SERIE_INICIO'));
            numCkanl_serie_fin.setValue(inRecordCgg_kdx_anulacion.get('CKANL_SERIE_FIN'));
            txtCkanl_observacion.setValue(inRecordCgg_kdx_anulacion.get('CKANL_OBSERVACION'));
            txtCkanl_justificacion.setValue(inRecordCgg_kdx_anulacion.get('CKANL_JUSTIFICACION'));
            cbxCkanl_tipo_anulacion.setValue(inRecordCgg_kdx_anulacion.get('CKANL_TIPO_ANULACION'));
            numCkanl_estado_anulacion.setValue(inRecordCgg_kdx_anulacion.get('CKANL_ESTADO_ANULACION'));
            isEdit = true;
            habilitarCgg_kdx_anulacionCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_kdx_anulacion.
     * @returns ventana winFrmCgg_kdx_anulacion.
     * @base FrmCgg_kdx_anulacion.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_kdx_anulacion;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_kdx_anulacion.
     * @base FrmCgg_kdx_anulacion.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_kdx_anulacionCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_kdx_anulacion desde una instancia.
 */
FrmCgg_kdx_anulacion.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_kdx_anulacion desde una instancia.
 */
FrmCgg_kdx_anulacion.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_kdx_anulacion,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_kdx_anulacion.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_kdx_anulacion desde una instancia.
 */
FrmCgg_kdx_anulacion.prototype.loadData = function(){
    this.loadData();
}
