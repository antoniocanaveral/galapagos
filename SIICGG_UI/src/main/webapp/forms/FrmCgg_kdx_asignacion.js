/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_kdx_asignacion.
 * @param {String} IN_SENTENCIA_CGG_KDX_ASIGNACION Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_KDX_ASIGNACION Registro de datos de la tabla Cgg_kdx_asignacion.
 * @constructor
 * @base FrmListadoCgg_kdx_asignacion
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_kdx_asignacion(IN_SENTENCIA_CGG_KDX_ASIGNACION,INTIPO_ASIGNACION,IN_RECORD_CGG_KDX_ASIGNACION){
    var inSentenciaCgg_kdx_asignacion = IN_SENTENCIA_CGG_KDX_ASIGNACION;
    var inRecordCgg_kdx_asignacion=IN_RECORD_CGG_KDX_ASIGNACION;
    var urlCgg_kdx_asignacion=URL_WS+"Cgg_kdx_asignacion";
    var tituloCgg_kdx_asignacion='Asignaci\u00f3n de especies';
    var descCgg_kdx_asignacion='El formulario permite administrar la informaci\u00f3n de Asignaci\u00f3n de especies a usuarios';
    var isEdit = false;
	var tmpCkesp_codigo; //Valriable que almacena la informacion del codigo de la especie seleccionada para su posterior verificacion
    var tmpCantidadDisponible = 0;//Variable que almacena la informacion del maximo valor que podria se asignado sea desde la agencia o entre usuarios
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION
     */
    var txtCkasg_codigo = new Ext.form.TextField({
        id:'txtCkasg_codigo',
        name:'txtCkasg_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE LA TRANSFERENCIA
     */
    var txtCktrn_codigo = new Ext.form.TextField({
        id:'txtCktrn_codigo',
        name:'txtCktrn_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank : true
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE LA TRANSFERENCIA
     */
    var txtCktrn_numero_transferencia = new Ext.form.TextField({
        id:'txtCktrn_numero_transferencia',
        name:'txtCktrn_numero_transferencia',
        fieldLabel :'No. transferencia',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });

    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE LA TRANSFERENCIA
     */
    var btnCktrn_codigoCgg_kdx_asignacion = new Ext.Button({
        id:'btnCktrn_codigoCgg_kdx_asignacion',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                tmpCantidadDisponible=0;
                var tmpFLCgg_kdx_transferencia = new Cgg_kdx_transferencia_disponible(objUsuarioPV.CKPVT_CODIGO);
                var objBusqueda = new DlgBusqueda(tmpFLCgg_kdx_transferencia.getStore(),tmpFLCgg_kdx_transferencia.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                    {
                        txtCktrn_codigo.setValue(tmpRecord.get('CKTRN_CODIGO'));
                        txtCktrn_numero_transferencia.setValue(tmpRecord.get('CKTRN_NUMERO_TRANSFERENCIA'));
                        numCkasg_precio_unitario.setValue(tmpRecord.get('CKTRN_PRECIO_UNITARIO'));
                        txtEspecie_asignacion.setValue(tmpRecord.get('CKESP_NOMBRE'));
                        tmpCantidadDisponible = tmpRecord.get('CKTRN_CANTIDAD_DISPONIBLE');
						tmpCkesp_codigo=tmpRecord.get('CKESP_CODIGO');
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION ANTERIOR
     */
    var txtCgg_ckasg_codigo = new Ext.form.TextField({
        id:'txtCgg_ckasg_codigo',
        name:'txtCgg_ckasg_codigo',
        fieldLabel :'Ckasg codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE LA TRANSFERENCIA
     */
    var txtCkasg_numero_asignacion_anterior = new Ext.form.TextField({
        id:'txtCkasg_numero_asignacion_anterior',
        name:'txtCkasg_numero_asignacion_anterior',
        fieldLabel :'No. asig. anterior',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });

    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE LA TRANSFERENCIA
     */
    var btnCgg_kdx_asignacion_anterior = new Ext.Button({
        id:'btnCgg_kdx_asignacion_anterior',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                tmpCantidadDisponible=0;
                var tmpFLCgg_kdx_transferencia = new Cgg_kdx_asignacion_usuario(objUsuarioPV.CKUPV_CODIGO);
                var objBusqueda = new DlgBusqueda(tmpFLCgg_kdx_transferencia.getStore(),tmpFLCgg_kdx_transferencia.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                    {
                        txtCktrn_codigo.setValue(tmpRecord.get('CKTRN_CODIGO'));
                        txtCgg_ckasg_codigo.setValue(tmpRecord.get('CKASG_CODIGO'));
                        txtCkasg_numero_asignacion_anterior.setValue(tmpRecord.get('CKASG_NUMERO_ASIGNACION'));
                        numCkasg_precio_unitario.setValue(tmpRecord.get('CKASG_PRECIO_UNITARIO'));
                        txtEspecie_asignacion.setValue(tmpRecord.get('CKESP_NOMBRE'));
                        numCkasg_cantidad.setValue(tmpRecord.get('CKASG_CANTIDAD_DISPONIBLE'));
                        numCkasg_serie_fin.setValue(tmpRecord.get('CKASG_SERIE_FIN'));
                        numCkasg_serie_inicio.setValue(tmpRecord.get('CKASG_SERIE_FIN')*1 - tmpRecord.get('CKASG_CANTIDAD_DISPONIBLE')*1 +1);
                        numCkasg_valor_total.setValue(numCkasg_cantidad.getValue()*numCkasg_precio_unitario.getValue())
                        tmpCantidadDisponible = tmpRecord.get('CKASG_CANTIDAD_DISPONIBLE');
						//tmpCkesp_codigo=tmpRecord.get('CKESP_CODIGO');
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA QUIEN REALIZA LA ASIGNACION
     */
    var txtCkupv_codigo = new Ext.form.TextField({
        id:'txtCkupv_codigo',
        name:'txtCkupv_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :true
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA QUIEN RECIBE LA ASIGNACION
     */
    var txtCgg_ckupv_codigo = new Ext.form.TextField({
        id:'txtCgg_ckupv_codigo',
        name:'txtCgg_ckupv_codigo',
        fieldLabel :'Ckupv codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
     */
    var txtCgg_ckupv_nombre = new Ext.form.TextField({
        id:'txtCgg_ckupv_nombre',
        name:'txtCgg_ckupv_nombre',
        fieldLabel :'Nombre',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
     */
    var btnCgg_ckupv_codigoCgg_kdx_asignacion = new Ext.Button({
        id:'btnCgg_ckupv_codigoCgg_kdx_asignacion',
        iconCls:'iconBuscar',
        tooltip:'Buscar usuario punto de venta',
        listeners:{
            click:function(){
                var tmpFLCgg_kdx_usuario_pv =  new Cgg_kdx_usuario_pv(objUsuarioPV.CKPVT_CODIGO);
                var objBusqueda = new DlgBusquedaNoPaginado(tmpFLCgg_kdx_usuario_pv.getStore(),tmpFLCgg_kdx_usuario_pv.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                    {
                        txtCgg_ckupv_codigo.setValue(tmpRecord.get('CKUPV_CODIGO'));
                        txtCgg_ckupv_nombre.setValue(tmpRecord.get('CRPER_NOMBRES'));
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA ASIGNACION
     */
    var txtCkasg_numero_asignacion = new Ext.form.TextField({
        id:'txtCkasg_numero_asignacion',
        name:'txtCkasg_numero_asignacion',
        fieldLabel :'No. asignacion',
        anchor:'60%',
        allowBlank :false
    });
    /**
     * Ext.form.DateField FECHA DE RECEPCION DE LAS ESPECIES
     */
    var dtCkasg_fecha_recepcion = new Ext.form.DateField({
        id:'dtCkasg_fecha_recepcion',
        name:'dtCkasg_fecha_recepcion',
        fieldLabel :'Fecha recepcion',
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
    var numCkasg_cantidad = new Ext.form.NumberField({
        id:'numCkasg_cantidad',
        name:'numCkasg_cantidad',
        fieldLabel :'Cantidad',
        allowBlank :false,
        disabled :false
    });
    /**
     * Ext.form.NumberField PRECIO DE VENTA DE LA ESPECIE
     */
    var numCkasg_precio_unitario = new Ext.form.NumberField({
        id:'numCkasg_precio_unitario',
        name:'numCkasg_precio_unitario',
        fieldLabel :'Precio unitario',
        allowBlank :false,
        disabled : true
    });

    /**
     * Ext.form.NumberField PRECIO DE VENTA DE LA ESPECIE
     */
    var numCkasg_valor_total = new Ext.form.NumberField({
        id:'numCkasg_valor_total',
        name:'numCkasg_valor_total',
        fieldLabel :'Total',
        allowBlank :false,
        readOnly : true
    });
    /**
     * Ext.form.NumberField SERIE DE INICIO DE LAS ESPECIES
     */
    var numCkasg_serie_inicio = new Ext.form.NumberField({
        id:'numCkasg_serie_inicio',
        name:'numCkasg_serie_inicio',
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
    var numCkasg_serie_fin = new Ext.form.NumberField({
        id:'numCkasg_serie_fin',
        name:'numCkasg_serie_fin',
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
    function calcularTotal()
    {
        if (numCkasg_serie_fin.getValue() && numCkasg_serie_inicio.getValue())
        {
            numCkasg_cantidad.setValue(numCkasg_serie_fin.getValue() - numCkasg_serie_inicio.getValue() + 1);
            if (numCkasg_cantidad.getValue()>0)
            {

                if(numCkasg_cantidad.getValue() <= tmpCantidadDisponible)
                {
                    numCkasg_valor_total.setValue(numCkasg_cantidad.getValue()*numCkasg_precio_unitario.getValue());
                }
                else
                {
                    Ext.Msg.show({
                        title:tituloCgg_kdx_asignacion,
                        msg: 'El stock disponible es inferior al requerido.<br> <span>Stock actual: </span> '+ tmpCantidadDisponible +'.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.ERROR
                    });
                    //numCktrn_cantidad.reset();
                }
            }
            else
            {
                Ext.Msg.show({
                    title:tituloCgg_kdx_asignacion,
                    msg: 'La cantidad ingresada no es v\u00e1lida.',
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.ERROR
                });
            }
        }

    }
    /**
     * Ext.form.TextArea COMENTARIO AFIN A LA ASIGNACION
     */
    var txtCkasg_observacion = new Ext.form.TextArea({
        id:'txtCkasg_observacion',
        name:'txtCkasg_observacion',
        fieldLabel :'Observaci\u00F3n',
        width:'90%',
        allowBlank :false
    });
    /**
     * Ext.form.NumberField CANTIDAD DE ESPECIES DISPONIBLES PARA ASIGNACIONES
     */
    var numCkasg_cantidad_disponible = new Ext.form.NumberField({
        id:'numCkasg_cantidad_disponible',
        name:'numCkasg_cantidad_disponible',
        fieldLabel :'Cantidad disponible',
        allowBlank :false,
        disabled :false
    });
    /**
     * Ext.form.NumberField ESTADO DEL REGISTRO DE VENTA UTILIZADO PARA OPERACIONES
     0.-  REGISTRADA
     1.-  REASIGNADA
     2.-  FINALIZADA
     */
    var numCkasg_estado_asignacion = new Ext.form.NumberField({
        id:'numCkasg_estado_asignacion',
        name:'numCkasg_estado_asignacion',
        fieldLabel :'Estado asignacion',
        allowBlank :false,
        disabled :false,
        value:TypeEstadoAsignacion.REGISTRADA
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_kdx_asignacion
     */
    var btnGuardarCgg_kdx_asignacion = new Ext.Button({
        id:'btnGuardarCgg_kdx_asignacion',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                /*if (!pnlCgg_kdx_asignacion.getForm().isValid()){
                 return;
                 }*/
                try{
                    function CallBackCgg_kdx_asignacion(r){
                        winFrmCgg_kdx_asignacion.getEl().unmask();
                        if(r.substring(0,5) =='CKASG'){
                            Ext.Msg.show({
                                title:tituloCgg_kdx_asignacion,
                                msg: 'La informaci\u00f3n de Asignaci\u00f3n ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });

                            var urlReport = new Reporte('rptActaEntregaRecepcion','/Reports/sii/kardex',{P_CKASG_CODIGO:r});
                            urlReport.show();
                            winFrmCgg_kdx_asignacion.close();
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_kdx_asignacion,
                                msg: 'La informaci\u00f3n de Asignaci\u00f3n no ha podido ser almacenada. '+(r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_kdx_asignacion.getEl().mask('Guardando...', 'x-mask-loading');
                   
					var respControl = 'false';
					if(INTIPO_ASIGNACION == TypeAsignacion.TRANSFERENCIA)
                    {
                       //VERIFICACION DE LA SERIE PARA EL INGRESO DE LA TRANSFERENCIA
					var paramControl = new SOAPClientParameters();
					 paramControl.add('inCkesp_codigo',tmpCkesp_codigo);
                    paramControl.add('inCkesp_tipo_control',TypeControlSerie.ASIGNACION);
                    paramControl.add('inCkesp_serie_inicio',numCkasg_serie_inicio.getValue());
                    paramControl.add('inCkesp_serie_fin',numCkasg_serie_fin.getValue());
                    respControl =  SOAPClient.invoke(URL_WS+"Cgg_kdx_transferencia",'controlSerie',paramControl, false, false);
                    }            
					if (respControl == 'false')
					{
						 var param = new SOAPClientParameters();
						if(isEdit)
							param.add('inCkasg_codigo',txtCkasg_codigo.getValue());
						param.add('inCktrn_codigo',txtCktrn_codigo.getValue());
						param.add('inCkupv_codigo',txtCkupv_codigo.getValue()?txtCkupv_codigo.getValue():null);
						param.add('inCgg_ckupv_codigo',txtCgg_ckupv_codigo.getValue());
						param.add('inCgg_ckasg_codigo',txtCgg_ckasg_codigo.getValue()?txtCgg_ckasg_codigo.getValue():null);
						param.add('inCkasg_numero_asignacion',txtCkasg_numero_asignacion.getValue());
						param.add('inCkasg_fecha_recepcion',dtCkasg_fecha_recepcion.getValue().format(TypeDateFormat.Custom));
						param.add('inCkasg_cantidad',numCkasg_cantidad.getValue());
						param.add('inCkasg_precio_unitario',numCkasg_precio_unitario.getValue());
						param.add('inCkasg_serie_inicio',numCkasg_serie_inicio.getValue());
						param.add('inCkasg_serie_fin',numCkasg_serie_fin.getValue());
						param.add('inCkasg_observacion',txtCkasg_observacion.getValue());
						param.add('inCkasg_cantidad_disponible',numCkasg_cantidad.getValue());
						param.add('inCkasg_estado_asignacion',numCkasg_estado_asignacion.getValue());
						SOAPClient.invoke(urlCgg_kdx_asignacion,IN_SENTENCIA_CGG_KDX_ASIGNACION + "1",param, true, CallBackCgg_kdx_asignacion);
					}
					else if  (respControl == 'true')
					{
						 Ext.Msg.show({
                                title:tituloCgg_kdx_asignacion,
                                msg: 'La serie ingresada no es v\u00e1lida para completar la operaci\u00f3n. ',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
							  winFrmCgg_kdx_asignacion.getEl().unmask();
					}
					else{
						Ext.Msg.show({
                                title:tituloCgg_kdx_asignacion,
                                msg: 'Ha ocurrido un error en la verificaci\u00f3n de la serie. ' + respControl,
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
							  winFrmCgg_kdx_asignacion.getEl().unmask();
					}
					
					
                }catch(inErr){
                    winFrmCgg_kdx_asignacion.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_kdx_asignacion.
     */
    var btnCancelarCgg_kdx_asignacion = new Ext.Button({
        id:'btnCancelarCgg_kdx_asignacion',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_kdx_asignacion.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_kdx_asignacion.
     */
    var btnCerrarCgg_kdx_asignacion = new Ext.Button({
        id:'btnCerrarCgg_kdx_asignacion',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_kdx_asignacion.close();
            }}
    });
    var objUsuarioPV={
        CKPVT_NOMBRE:'Aeropuerto Mariscal sucre',
        CRPER_NOMBRES:'William Giovanny Lozada',
        CKUPV_CODIGO:'',
        CKPVT_CODIGO:''
    }
    var tplInfoPuntoVenta = new Ext.Template(
            '<table width="100%" height="100%" cellpadding="0">' +
                    '<tr rowspan="0">' +
                    '<td width="17%" ><div class="tituloTemplate">Punto de Venta:</div></td>' +
                    '<td width="50%"  ><div class="itemTemplate">{CKPVT_NOMBRE}</div></td>' +
                    '</tr>' +
                    '<tr rowspan="0">' +
                    '<td width="17%" ><div class="tituloTemplate">Entrega:</div></td>' +
                    '<td width="50%" ><div class="itemTemplate">{CRPER_NOMBRES}</div></td>' +
                    '</tr>' +
                    '</table>'
            );
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_kdx_asignacion.
     */
    var pnlCgg_kdx_asignacion = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCkasg_codigo,txtCkasg_numero_asignacion,dtCkasg_fecha_recepcion,
            {xtype:'panel',id:'pnlAsignacionPuntoVenta',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCktrn_numero_transferencia]},{columnWidth:.4,layout:'form',items:[btnCktrn_codigoCgg_kdx_asignacion]}]},
            {xtype:'panel',id:'pnlAsignacionUsuarios',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCkasg_numero_asignacion_anterior]},{columnWidth:.4,layout:'form',items:[btnCgg_kdx_asignacion_anterior]}]},
            {xtype:'panel', id :'pnlPuntoVenta',data:objUsuarioPV,tpl:tplInfoPuntoVenta},{xtype:'panel',layout:'column',items:[{columnWidth:.8,layout:'form',items:[txtCgg_ckupv_nombre]},{columnWidth:.2,layout:'form',items:[btnCgg_ckupv_codigoCgg_kdx_asignacion]}]},
            txtEspecie_asignacion,numCkasg_serie_inicio,numCkasg_serie_fin,numCkasg_cantidad,numCkasg_precio_unitario,numCkasg_valor_total,txtCkasg_observacion]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_kdx_asignacion.
     */
    var winFrmCgg_kdx_asignacion = new Ext.Window({
        id:'winFrmCgg_kdx_asignacion',
        title:tituloCgg_kdx_asignacion,
        iconCls:'iconAplicacion',
        width:400,
        minWidth:400,
        maximizable:false,
        minimizable:false,
        resizable:false,
        constrain:true,
        modal:true,
        shadow : false,
        tbar:getPanelTitulo(tituloCgg_kdx_asignacion,descCgg_kdx_asignacion),
        items:[pnlCgg_kdx_asignacion],
        bbar:[btnGuardarCgg_kdx_asignacion,btnCancelarCgg_kdx_asignacion,'->',btnCerrarCgg_kdx_asignacion],
        listeners:{
            show:function()
            {
                if(!isEdit)
                {
                    if(INTIPO_ASIGNACION == TypeAsignacion.TRANSFERENCIA)
                    {
                        Ext.getCmp('pnlAsignacionPuntoVenta').setVisible(true);
                        Ext.getCmp('pnlAsignacionUsuarios').setVisible(false);

                    }
                    else
                    {
                        Ext.getCmp('pnlAsignacionPuntoVenta').setVisible(false);
                        Ext.getCmp('pnlAsignacionUsuarios').setVisible(true);


                    }
                    winFrmCgg_kdx_asignacion.doLayout();
                    numeroAsignacion();
                    usuarioPuntoventa();

                }
            }
        }
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmCgg_kdx_asignacion.getBottomToolbar());
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_kdx_asignacion.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_kdx_asignacionCtrls(inEstado){
        estado=!inEstado;
        txtCkasg_codigo.setDisabled(estado);
        txtCktrn_codigo.setDisabled(estado);
        txtCkupv_codigo.setDisabled(estado);
        txtCgg_ckupv_codigo.setDisabled(estado);
        txtCkasg_numero_asignacion.setDisabled(estado);
        dtCkasg_fecha_recepcion.setDisabled(estado);
        numCkasg_cantidad.setDisabled(estado);
        numCkasg_precio_unitario.setDisabled(estado);
        numCkasg_serie_inicio.setDisabled(estado);
        numCkasg_serie_fin.setDisabled(estado);
        numCkasg_cantidad_disponible.setDisabled(estado);
        numCkasg_estado_asignacion.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_kdx_asignacion.
     */
    function cargarCgg_kdx_asignacionCtrls(){
        if(inRecordCgg_kdx_asignacion){
            txtCkasg_codigo.setValue(inRecordCgg_kdx_asignacion.get('CKASG_CODIGO'));
            txtCktrn_codigo.setValue(inRecordCgg_kdx_asignacion.get('CKTRN_CODIGO'));
            txtCktrn_numero_transferencia.setValue(inRecordCgg_kdx_asignacion.get('CKTRN_NUMERO_TRANSFERENCIA'));
            txtCkupv_codigo.setValue(inRecordCgg_kdx_asignacion.get('CKUPV_CODIGO'));
            txtCgg_ckupv_codigo.setValue(inRecordCgg_kdx_asignacion.get('CGG_CKUPV_CODIGO'));
            //txtCgg_ckupv_nombre.setValue(inRecordCgg_kdx_asignacion.get('CGG_CKUPV_CODIGO'));
            txtCgg_ckasg_codigo.setValue(inRecordCgg_kdx_asignacion.get('CGG_CKASG_CODIGO'));
            txtCkasg_numero_asignacion.setValue(inRecordCgg_kdx_asignacion.get('CKASG_NUMERO_ASIGNACION'));
            dtCkasg_fecha_recepcion.setValue(inRecordCgg_kdx_asignacion.get('CKASG_FECHA_RECEPCION'));
            numCkasg_cantidad.setValue(inRecordCgg_kdx_asignacion.get('CKASG_CANTIDAD'));
            numCkasg_precio_unitario.setValue(inRecordCgg_kdx_asignacion.get('CKASG_PRECIO_UNITARIO'));
            numCkasg_serie_inicio.setValue(inRecordCgg_kdx_asignacion.get('CKASG_SERIE_INICIO'));
            numCkasg_serie_fin.setValue(inRecordCgg_kdx_asignacion.get('CKASG_SERIE_FIN'));
            numCkasg_cantidad_disponible.setValue(inRecordCgg_kdx_asignacion.get('CKASG_CANTIDAD_DISPONIBLE'));
            numCkasg_estado_asignacion.setValue(inRecordCgg_kdx_asignacion.get('CKASG_ESTADO_ASIGNACION'));
            isEdit = true;
            habilitarCgg_kdx_asignacionCtrls(true);
        }}
    /**
     * Funcion que permite mostrar el numero de transferencia
     */
    function numeroAsignacion()
    {

        try{
            function callBacknumeroAsignacion(r){
                txtCkasg_numero_asignacion.setValue(r);
            }
            SOAPClient.invoke(urlCgg_kdx_asignacion,"numeroAsignacion",false, false, callBacknumeroAsignacion);

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
            objUsuarioPV.CKPVT_NOMBRE = res.CKPVT_NOMBRE;
            if(INTIPO_ASIGNACION == TypeAsignacion.TRANSFERENCIA)
                objUsuarioPV.CRPER_NOMBRES = res.CKPVT_NOMBRE;

            else
            {
                objUsuarioPV.CRPER_NOMBRES = res.CRPER_NOMBRES;

            }
            txtCkupv_codigo.setValue(res.CKUPV_CODIGO);
            objUsuarioPV.CKUPV_CODIGO = res.CKUPV_CODIGO;
            objUsuarioPV.CKPVT_CODIGO = res.CKPVT_CODIGO;
            tplInfoPuntoVenta.overwrite(Ext.getCmp('pnlPuntoVenta').body,objUsuarioPV);

        }
        var param = new SOAPClientParameters();
        param.add('format',TypeFormat.JSON);
        SOAPClient.invoke(urlCgg_kdx_asignacion,"selectUsuarioPuntoVenta",param, true, callBackUsuarioPuntoVenta);

        //}catch(inErr){
        // winFrmCgg_kdx_asignacion.getEl().unmask();
        //}

    }


    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_kdx_asignacion.
     * @returns ventana winFrmCgg_kdx_asignacion.
     * @base FrmCgg_kdx_asignacion.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_kdx_asignacion;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_kdx_asignacion.
     * @base FrmCgg_kdx_asignacion.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_kdx_asignacionCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_kdx_asignacion desde una instancia.
 */
FrmCgg_kdx_asignacion.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_kdx_asignacion desde una instancia.
 */
FrmCgg_kdx_asignacion.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_kdx_asignacion,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_kdx_asignacion.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_kdx_asignacion desde una instancia.
 */
FrmCgg_kdx_asignacion.prototype.loadData = function(){
    this.loadData();
}
