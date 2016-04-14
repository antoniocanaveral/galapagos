/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_kdx_transferencia.
 * @param {String} IN_SENTENCIA_CGG_KDX_TRANSFERENCIA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_KDX_TRANSFERENCIA Registro de datos de la tabla Cgg_kdx_transferencia.
 * @constructor
 * @base FrmListadoCgg_kdx_transferencia
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_kdx_transferencia(IN_SENTENCIA_CGG_KDX_TRANSFERENCIA,IN_RECORD_CGG_KDX_TRANSFERENCIA){
    var inSentenciaCgg_kdx_transferencia = IN_SENTENCIA_CGG_KDX_TRANSFERENCIA;
    var inRecordCgg_kdx_transferencia=IN_RECORD_CGG_KDX_TRANSFERENCIA;
    var urlCgg_kdx_transferencia=URL_WS+"Cgg_kdx_transferencia";
    var tituloCgg_kdx_transferencia='Transferencia especies';
    var descCgg_kdx_transferencia='El formulario permite administrar la informaci\u00f3n de Transferencia especies';
    var isEdit = false;
    var tmpStockActual = null;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE LA TRANSFERENCIA
     */
    var txtCktrn_codigo = new Ext.form.TextField({
        id:'txtCktrn_codigo',
        name:'txtCktrn_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA
     */
    var txtCkpvt_codigo = new Ext.form.TextField({
        id:'txtCkpvt_codigo',
        name:'txtCkpvt_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :true
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA
     */
    var txtCkpvt_nombre = new Ext.form.TextField({
        id:'txtCkpvt_nombre',
        name:'txtCkpvt_nombre',
        fieldLabel :'Punto de venta:',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA
     */
    var btnCkpvt_codigoCgg_kdx_transferencia = new Ext.Button({
        id:'btnCkpvt_codigoCgg_kdx_transferencia',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_kdx_punto_venta = new FrmListadoCgg_kdx_punto_venta();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_kdx_punto_venta.getStore(),tmpFLCgg_kdx_punto_venta.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                    {
                        txtCkpvt_codigo.setValue(tmpRecord.get('CKPVT_CODIGO'));
                        txtCkpvt_nombre.setValue(tmpRecord.get('CKPVT_NOMBRE'));
                    }
                });
                objBusqueda.show();
            }}
    });


    /**
     * Ext.data.Store Seleccion de registros de la tabla Cgg_res_estado_civil
     */
    var gsCgg_kdx_especie = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_especie",
            method:"selectAll",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
        },[
            {name:'CKESP_CODIGO'},
            {name:'CKESP_NOMBRE'},
            {name:'CKESP_PRECIO'}
        ]),
        baseParams:{
            format:TypeFormat.JSON,
            inCkesp_tipo:-1
        },
        listeners:{
            load:function()
            {
                if(isEdit)
                    cbxCkesp_codigo.setValue(inRecordCgg_kdx_transferencia.get('CKESP_CODIGO'));
            }
        }
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DEL ESTADO CIVIL
     */
    var cbxCkesp_codigo = new Ext.form.ComboBox({
        id:'cbxCkesp_codigo ',
        store: gsCgg_kdx_especie,
        displayField:'CKESP_NOMBRE',
        fieldLabel :'Especie',
        typeAhead: true,
        lazyRender:true,
        mode: 'local',
        forceSelection:true,
        anchor:'70%',
        triggerAction:'all',
        emptyText:'Seleccione un tipo especie',
        selectOnFocus:true,
        //tpl: '<tpl for="."><div ext:qtip="{CRECV_DESCRPCION}. {CRECV_DESCRPCION}" class="x-combo-list-item">{CRECV_DESCRPCION}</div></tpl>
        valueField:'CKESP_CODIGO',
        listeners:{
            select:function(combo,record)
            {

                try
                {
                    var param = new SOAPClientParameters();
                    param.add('inCkesp_codigo',combo.getValue());
                    param.add('format',TypeFormat.JSON);
                    tmpStockActual = null;
                    var  r =   SOAPClient.invoke(URL_WS+"Cgg_kdx_kardex",'selectStockActual',param, false, false);
                    tmpStockActual = Ext.util.JSON.decode(r);
                    if(tmpStockActual.length>0)
                    {
                        if(tmpStockActual[0].CKKRD_TOTAL_CANTIDAD>0)
                        {
                            numCktrn_precio_unitario.setValue(record.get('CKESP_PRECIO'));
                        }
                        else
                        {
                            Ext.Msg.show({
                                title:tituloCgg_kdx_transferencia,
                                msg: 'El tipo de especie seleccionada no tiene stock disponible. ',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                            combo.reset();
                            numCktrn_precio_unitario.reset();

                        }
                    }
                    else
                    {
                        Ext.Msg.show({
                            title:tituloCgg_kdx_transferencia,
                            msg: 'El tipo de especie seleccionada no tiene registrado su inventario inicial. ',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.ERROR
                        });
                        combo.reset();
                        numCktrn_precio_unitario.reset();
                    }
                }
                catch(Exception)
                {

                }
            }
        }
    });
    gsCgg_kdx_especie.load();
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES
     */
    var txtCkesp_codigo = new Ext.form.TextField({
        id:'txtCkesp_codigo',
        name:'txtCkesp_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES
     */
    var btnCkesp_codigoCgg_kdx_transferencia = new Ext.Button({
        id:'btnCkesp_codigoCgg_kdx_transferencia',
        text:'Ckesp_codigo',
        iconCls:'iconCkesp_codigo',
        listeners:{
            click:function(){
                var tmpFLCgg_kdx_especie = new FrmListadoCgg_kdx_especie();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_kdx_especie.getStore(),tmpFLCgg_kdx_especie.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                        txtCkesp_codigo.setValue(tmpRecord.get('CKESP_CODIGO'));
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA TRANSFERENCIA
     */
    var txtCktrn_numero_transferencia = new Ext.form.TextField({
        id:'txtCktrn_numero_transferencia',
        name:'txtCktrn_numero_transferencia',
        fieldLabel :'No. transferencia',
        anchor:'70%',
        allowBlank :false
    });
    /**
     * Ext.form.DateField FECHA DE RECEPCION DE LAS ESPECIES
     */
    var dtCktrn_fecha_recepcion = new Ext.form.DateField({
        id:'dtCktrn_fecha_recepcion',
        name:'dtCktrn_fecha_recepcion',
        fieldLabel :'Fecha transf.',
        allowBlank :false,
        // disabled :true,
        // readOnly:true,
        maxValue : new Date(),
        format :'d/m/Y',
        value:new Date()
    });
    /**
     * Ext.form.NumberField CANTIDAD DE ESPECIES
     */
    var numCktrn_cantidad = new Ext.form.NumberField({
        id:'numCktrn_cantidad',
        name:'numCktrn_cantidad',
        fieldLabel :'Cantidad',
        allowBlank :false,
        disabled :false,
        readOnly : true
    });

    /**
     * Ext.form.TextArea COMENTARIO AFIN A LA TRANSFERENCIA
     */
    var txtCktrn_observacion = new Ext.form.TextArea({
        id:'txtCktrn_observacion',
        name:'txtCktrn_observacion',
        fieldLabel :'Observacion',
        width:'90%',
        allowBlank :false
    });
    function calcularTotal()
    {
        if (numCktrn_serie_fin.getValue() && numCktrn_serie_inicio.getValue())
        {
            numCktrn_cantidad.setValue(numCktrn_serie_fin.getValue() - numCktrn_serie_inicio.getValue() + 1);
            if (numCktrn_cantidad.getValue()>0)
            {

                if(numCktrn_cantidad.getValue() <= tmpStockActual[0].CKKRD_TOTAL_CANTIDAD)
                {
                    numCktrn_total.setValue(numCktrn_cantidad.getValue()*numCktrn_precio_unitario.getValue());
                }
                else
                {
                    Ext.Msg.show({
                        title:tituloCgg_kdx_transferencia,
                        msg: 'El stock disponible es inferior al requerido.<br> <span><b>Stock actual: </b></span> '+ tmpStockActual[0].CKKRD_TOTAL_CANTIDAD +'.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.ERROR
                    });
                    //numCktrn_cantidad.reset();
                }
            }
            else
            {
                Ext.Msg.show({
                    title:tituloCgg_kdx_transferencia,
                    msg: 'La cantidad ingresada no es v\u00e1lida.',
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.ERROR
                });
            }
        }


    }
    /**
     * Ext.form.NumberField PRECIO DE VENTA DE LA ESPECIE
     */
    var numCktrn_precio_unitario = new Ext.form.NumberField({
        id:'numCktrn_precio_unitario',
        name:'numCktrn_precio_unitario',
        fieldLabel :'Precio unitario',
        allowBlank :false,
        disabled : true
    });
    /**
     * Ext.form.NumberField PRECIO DE VENTA DE LA ESPECIE
     */
    var numCktrn_total = new Ext.form.NumberField({
        id:'numCktrn_total',
        name:'numCktrn_total',
        fieldLabel :'Total',
        allowBlank :false,
        disabled : true
    });
    /**
     * Ext.form.NumberField SERIE DE INICIO DE LAS ESPECIES
     */
    var numCktrn_serie_inicio = new Ext.form.NumberField({
        id:'numCktrn_serie_inicio',
        name:'numCktrn_serie_inicio',
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
    var numCktrn_serie_fin = new Ext.form.NumberField({
        id:'numCktrn_serie_fin',
        name:'numCktrn_serie_fin',
        fieldLabel :'Serie fin',
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
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_kdx_transferencia
     */
    var btnGuardarCgg_kdx_transferencia = new Ext.Button({
        id:'btnGuardarCgg_kdx_transferencia',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_kdx_transferencia.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_kdx_transferencia(r){
                        winFrmCgg_kdx_transferencia.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_kdx_transferencia,
                                msg: 'La informaci\u00f3n de Transferencia especies ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_kdx_transferencia.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_kdx_transferencia,
                                msg: 'La informaci\u00f3n de Transferencia especies no ha podido ser almacenada. '+(r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_kdx_transferencia.getEl().mask('Guardando...', 'x-mask-loading');
					//VERIFICACION DE LA SERIE PARA EL INGRESO DE LA TRANSFERENCIA
					var paramControl = new SOAPClientParameters();
					var respControl;
                   paramControl.add('inCkesp_codigo',cbxCkesp_codigo.getValue());
                    paramControl.add('inCkesp_tipo_control',TypeControlSerie.TRANSFERENCIA);
                    paramControl.add('inCkesp_serie_inicio',numCktrn_serie_inicio.getValue());
                    paramControl.add('inCkesp_serie_fin',numCktrn_serie_fin.getValue());
                    respControl =  SOAPClient.invoke(urlCgg_kdx_transferencia,'controlSerie',paramControl, false, false);
					if (respControl == 'false')
					{
						var param = new SOAPClientParameters();
						if(isEdit)
							param.add('inCktrn_codigo',txtCktrn_codigo.getValue());
						param.add('inCkpvt_codigo',txtCkpvt_codigo.getValue());
						param.add('inCkesp_codigo',cbxCkesp_codigo.getValue());
						param.add('inCktrn_numero_transferencia',txtCktrn_numero_transferencia.getValue());
						param.add('inCktrn_fecha_recepcion',dtCktrn_fecha_recepcion.getValue().format(TypeDateFormat.Custom));
						param.add('inCktrn_cantidad',numCktrn_cantidad.getValue());
						param.add('inCktrn_precio_unitario',numCktrn_precio_unitario.getValue());
						param.add('inCktrn_serie_inicio',numCktrn_serie_inicio.getValue());
						param.add('inCktrn_serie_fin',numCktrn_serie_fin.getValue());
						param.add('inCktrn_observacion',txtCktrn_observacion.getValue());
						param.add('inCktrn_cantidad_disponible  ',numCktrn_cantidad.getValue());
						param.add('inCktrn_estado_transferencia',TypeEstadoTransferencia.EJECUTADA);
						SOAPClient.invoke(urlCgg_kdx_transferencia,IN_SENTENCIA_CGG_KDX_TRANSFERENCIA+'1',param, true, CallBackCgg_kdx_transferencia);
					}
					else if  (respControl == 'true')
					{
						 Ext.Msg.show({
                                title:tituloCgg_kdx_transferencia,
                                msg: 'La serie ingresada no es v\u00e1lida para completar la operaci\u00f3n. ',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
							  winFrmCgg_kdx_transferencia.getEl().unmask();
					}
					else{
						Ext.Msg.show({
                                title:tituloCgg_kdx_transferencia,
                                msg: 'Ha ocurrido un error en la verificaci\u00f3n de la serie. ' + respControl,
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
							  winFrmCgg_kdx_transferencia.getEl().unmask();
					}
					
                }catch(inErr){
                    winFrmCgg_kdx_transferencia.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_kdx_transferencia.
     */
    var btnCancelarCgg_kdx_transferencia = new Ext.Button({
        id:'btnCancelarCgg_kdx_transferencia',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_kdx_transferencia.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_kdx_transferencia.
     */
    var btnCerrarCgg_kdx_transferencia = new Ext.Button({
        id:'btnCerrarCgg_kdx_transferencia',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_kdx_transferencia.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_kdx_transferencia.
     */
    var pnlCgg_kdx_transferencia = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCktrn_codigo,txtCktrn_numero_transferencia,dtCktrn_fecha_recepcion,
            {xtype:'panel',layout:'column',items:[{columnWidth:.9,layout:'form',items:[txtCkpvt_nombre]},
                {columnWidth:.1,layout:'form',items:[btnCkpvt_codigoCgg_kdx_transferencia]}]},
            cbxCkesp_codigo,numCktrn_serie_inicio,numCktrn_serie_fin,numCktrn_cantidad,numCktrn_precio_unitario,numCktrn_total,txtCktrn_observacion]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_kdx_transferencia.
     */
    var winFrmCgg_kdx_transferencia = new Ext.Window({
        id:'winFrmCgg_kdx_transferencia',
        title:tituloCgg_kdx_transferencia,
        width:400,
        minWidth:400,
        maximizable:false,
        minimizable:false,
        modal:true,
        constrain:true,
        tbar:getPanelTitulo(tituloCgg_kdx_transferencia,descCgg_kdx_transferencia),
        items:[pnlCgg_kdx_transferencia],
        bbar:[btnGuardarCgg_kdx_transferencia,btnCancelarCgg_kdx_transferencia,'->',btnCerrarCgg_kdx_transferencia]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_kdx_transferencia.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_kdx_transferenciaCtrls(inEstado){
        estado=!inEstado;
        txtCktrn_codigo.setDisabled(estado);
        txtCkpvt_codigo.setDisabled(estado);
        txtCkpvt_nombre.setDisabled(estado);
        txtCkesp_codigo.setDisabled(estado);
        txtCktrn_numero_transferencia.setDisabled(estado);
        dtCktrn_fecha_recepcion.setDisabled(estado);
        numCktrn_cantidad.setDisabled(estado);
        txtCktrn_observacion.setDisabled(estado);
        numCktrn_precio_unitario.setDisabled(estado);
        numCktrn_serie_inicio.setDisabled(estado);
        numCktrn_serie_fin.setDisabled(estado);
        btnGuardarCgg_kdx_transferencia.setDisabled(true);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_kdx_transferencia.
     */
    function cargarCgg_kdx_transferenciaCtrls(){
        if(inRecordCgg_kdx_transferencia){
            txtCktrn_codigo.setValue(inRecordCgg_kdx_transferencia.get('CKTRN_CODIGO'));
            txtCkpvt_codigo.setValue(inRecordCgg_kdx_transferencia.get('CKPVT_CODIGO'));
            txtCkpvt_nombre.setValue(inRecordCgg_kdx_transferencia.get('CKPVT_NOMBRE'));  //DESCOMENTAR PAR VISUALIZAR NOMBRE PUNTO VENTA
            txtCktrn_numero_transferencia.setValue(inRecordCgg_kdx_transferencia.get('CKTRN_NUMERO_TRANSFERENCIA'));
            dtCktrn_fecha_recepcion.setValue(truncDate(inRecordCgg_kdx_transferencia.get('CKTRN_FECHA_RECEPCION')));
            numCktrn_cantidad.setValue(inRecordCgg_kdx_transferencia.get('CKTRN_CANTIDAD'));
            txtCktrn_observacion.setValue(inRecordCgg_kdx_transferencia.get('CKTRN_OBSERVACION'));
            numCktrn_precio_unitario.setValue(inRecordCgg_kdx_transferencia.get('CKTRN_PRECIO_UNITARIO'));
            numCktrn_total.setValue(numCktrn_cantidad.getValue()*numCktrn_precio_unitario.getValue());
            numCktrn_serie_inicio.setValue(inRecordCgg_kdx_transferencia.get('CKTRN_SERIE_INICIO'));
            numCktrn_serie_fin.setValue(inRecordCgg_kdx_transferencia.get('CKTRN_SERIE_FIN'));
            txtCktrn_observacion.setValue(inRecordCgg_kdx_transferencia.get('CKTRN_OBSERVACION'));
            isEdit = true;
            habilitarCgg_kdx_transferenciaCtrls(true);
        }

    }


    /**
     * Funcion que permite mostrar el numero de transferencia
     */
    function numeroTransferencia()
    {

        try{
            function callBacknumeroTransferencia(r){
                txtCktrn_numero_transferencia.setValue(r);
            }
            SOAPClient.invoke(urlCgg_kdx_transferencia,"numeroTransferencia",false, false, callBacknumeroTransferencia);

        }catch(inErr){
            winFrmCgg_kdx_transferencia.getEl().unmask();
        }

    }



    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_kdx_transferencia.
     * @returns ventana winFrmCgg_kdx_transferencia.
     * @base FrmCgg_kdx_transferencia.prototype.show
     */
    this.getWindow = function(){
        if(!isEdit)
            numeroTransferencia();
        return winFrmCgg_kdx_transferencia;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_kdx_transferencia.
     * @base FrmCgg_kdx_transferencia.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_kdx_transferenciaCtrls();
    }}

/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_kdx_transferencia desde una instancia.
 */
FrmCgg_kdx_transferencia.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_kdx_transferencia desde una instancia.
 */
FrmCgg_kdx_transferencia.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_kdx_transferencia,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_kdx_transferencia.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_kdx_transferencia desde una instancia.
 */
FrmCgg_kdx_transferencia.prototype.loadData = function(){
    this.loadData();
}
