/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_expulsion.
 * @param {String} IN_SENTENCIA_CGG_RES_EXPULSION Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_RES_EXPULSION Registro de datos de la tabla Cgg_res_expulsion.
 * @constructor
 * @base FrmListadoCgg_res_expulsion
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_expulsion(IN_SENTENCIA_CGG_RES_EXPULSION,IN_RECORD_CGG_RES_EXPULSION){
    var inSentenciaCgg_res_expulsion = IN_SENTENCIA_CGG_RES_EXPULSION;
    var inRecordCgg_res_expulsion=IN_RECORD_CGG_RES_EXPULSION;
    var urlCgg_res_expulsion=URL_WS+"Cgg_res_expulsion";
    var tituloCgg_res_expulsion='Salida Especial';
    var descCgg_res_expulsion='El formulario permite administrar la informaci\u00f3n de la Salida Especial de la Persona';
    var isEdit = false;
    var tmpCtfsl_codigo;
    var tmpCrnot_codigo;
    var tmpCrper_codigo;
    var tmpCrmov_codigo;
    var tmpCrosg_codigo;
	
    /**
 * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_comite.
 */
    function Cgg_res_salida_persona(){
        var cmCgg_res_salida_persona = null;
        cmCgg_res_salida_persona = new Ext.grid.ColumnModel([
        {
            dataIndex:'DOCUMENTO',
            header:'Tipo Documento',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CRPER_NOMBRES',
            header:'Nombre',
            width:150,
            sortable:true
        },
        {
            dataIndex:'CRPER_NUM_DOC_IDENTIFIC',
            header:'Num. Documento',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CRPER_FECHA_NACIMIENTO',
            header:'Fecha Nacimiento',
            width:150,
            sortable:true,
            renderer:truncDate
        },

        {
            dataIndex:'CRPER_GENERO',
            header:'Genero',
            width:150,
            sortable:true,
            renderer:function(inCRPER_GENERO){
                var tmp = '';
                if(inCRPER_GENERO==0){
                    tmp = 'MASCULINO';
                }else{
                    tmp = 'FEMENINO';
                }
                return tmp;
            }
        },
        {
            dataIndex:'CRMOV_NUMERO_VUELO',
            header:'Numero Vuelo',
            width:150,
            sortable:true
        },
       {
            dataIndex:'CRMOV_FECHA_VIAJE',
            header:'F. Salida',
            width:80,
            sortable:true,
            renderer:function(inCRMOV_FECHA_VIAJE){
             return Date.parse(inCRMOV_FECHA_VIAJE).toString('dd/MM/yyyy') ;  
            }
        }                
        ]);
        this.getColumnSalidaPersona =function(){
            return cmCgg_res_salida_persona;
        }
    }
    Cgg_res_salida_persona.prototype.getColumnModel=function(){
        return this.getColumnSalidaPersona();
    }
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_comite por un campo especifico.
     */
    gsCgg_res_salida_persona = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_expulsion",
            method:"selectPersonaSalida",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRPER_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CRPER_CODIGO'
        },

        {
            name:'CRDID_CODIGO'
        },

        {
            name:'DOCUMENTO'
        },

        {
            name:'CPRR_CODIGO'
        },

        {
            name:'PARROQUIA'
        },

        {
            name:'CCTN_CODIGO'
        },

        {
            name:'CANTON'
        },

        {
            name:'CRPER_NOMBRES'
        },

        {
            name:'APELLIDOS'
        },

        {
            name:'CRPER_NUM_DOC_IDENTIFIC'
        },

        {
            name:'CRPER_FECHA_NACIMIENTO'
        },

        {
            name:'CRPER_GENERO'
        },

        {
            name:'CRMOV_CODIGO'
        },

        {
            name:'CGG_CARPT_CODIGO'
        },

        {
            name:'AEROPUERTO'
        },

        {
            name:'CRMOV_NUMERO_VUELO'
        },

        {
            name:'CRNOT_CODIGO'
        },

        {
            name:'CRNOT_NUMERO_NOTIFICACION'
        },

        {
            name:'FECHA'
        },
        {
            name:'CRMOV_FECHA_VIAJE'
        }
        ]),
        sortInfo:{
            field: 'CRPER_CODIGO',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON"
        }
    });
    gsCgg_res_salida_persona.reload({
        params:{
            start:0,
            limit:RECORD_PAGE
        }
    });

    var pnlPersonaExpulsion = new Ext.Panel({
        tbar:[{
            type:'button',
            id:'btnPersonaExpulsion',
            text:'Persona ',
            iconCls:'iconBuscar',
            handler:function(){
                var tmpPersonaExpulsion = new Cgg_res_salida_persona();
                var objBusqueda = new DlgBusqueda(gsCgg_res_salida_persona, tmpPersonaExpulsion.getColumnSalidaPersona());
                objBusqueda.closeHandler(function () {
                    tmpPersonaExpulsion = objBusqueda.getSelectedRow();
                    if (tmpPersonaExpulsion) {
                        document.getElementById('divInfoPersonaExpulsion').innerHTML =tmpInfoPersonaExpulsion.apply(tmpPersonaExpulsion.json);
                        tmpCrper_codigo=tmpPersonaExpulsion.get('CRPER_CODIGO');
                        tmpCrmov_codigo=tmpPersonaExpulsion.get('CRMOV_CODIGO');
                        tmpCrnot_codigo=tmpPersonaExpulsion.get('CRNOT_CODIGO');                                                
                        dtCrexp_fecha_expulsion.setValue(Date.parse(tmpPersonaExpulsion.get('CRMOV_FECHA_VIAJE')));                        
                    }
                });
                objBusqueda.show();
            }
        }],
        //bodyStyle:'padding:0px 0px 0px 0px;',
        frame:true,
        height:180,
        html:'<div id="divInfoPersonaExpulsion" style="padding:0px 0px 0px 0px;"></div>'
    });
    var tmpInfoPersonaExpulsion = new Ext.XTemplate(
        '<table width="100%" height="50%" cellpadding="0">' +
        '<tr rowspan="0"><td>' +
        '<div class="tituloTemplate">Documento:</div></td>' +
        '<td><div class="itemTemplate">{DOCUMENTO}</div></td>' +
        '<td><div class="tituloTemplate"> Num. Ident:</div></td>' +
        '<td><div class="itemTemplate">{CRPER_NUM_DOC_IDENTIFIC}</div></td></tr>' +
        '<tr rowspan="0">' +
        '<td><div class="tituloTemplate">Nombres:</div></td>' +
        '<td><div class="itemTemplate">{CRPER_NOMBRES}</div></td>' +
        '<tr rowspan="0">' +
        '<td><div class="tituloTemplate"> Fecha Nac:</div></td>' +
        '<td><div class="itemTemplate">{[this.myDate(values.CRPER_FECHA_NACIMIENTO)]}</div>' +
        '<tr rowspan="0" >' +
        '</td></tr>'+
		'<tr><div class="tituloTemplate"><FONT COLOR="4169E1">Para mayor informaci&oacuten consulte el historial de personas.</font>	</div></tr>' +
		'</table>',
        {
            // XTemplate configuration:
            disableFormats: true,
            // member functions:
            myDate: function(CRPER_FECHA_NACIMIENTO){
                return truncDate(CRPER_FECHA_NACIMIENTO);
            },
            myDate1: function(inFecha){
                if(inFecha)
                    return truncDate(inFecha);
                else
                    return '';
            }
        }
        );
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCrexp_codigo = new Ext.form.TextField({
        id:'txtCrexp_codigo',
        name:'txtCrexp_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.form.NumberField TIPO DE PAGO
     0 - PROPIO
     1 - CGG
     */

    var cbxCrexp_tipo_pago = new Ext.form.ComboBox({
        id:'cbxCrexp_tipo_pago',
        name:'cbxCrexp_tipo_pago',
        store: dsTipoPagoSalida,
        fieldLabel :'Tipo Pago',
        width:130,
        displayField: 'tipo_pago',
        valueField: 'id',
        mode:'local',
        editable: false,
        triggerAction:'all',
        allowBlank :false,
        emptyText : 'Seleccione un Tipo de Pago'
    });
    /**
     * Ext.form.NumberField COSTO DEL VUELO
     */
    var numCrexp_valor_vuelo = new Ext.form.NumberField({
        id:'numCrexp_valor_vuelo',
        name:'numCrexp_valor_vuelo',
        fieldLabel :'Valor vuelo',
        allowBlank :false,
        disabled :false
    });
    /**
     * Ext.form.TextArea OBSERVACION DE LA EXPULSION
     */
    var txtCrexp_observacion = new Ext.form.TextArea({
        id:'txtCrexp_observacion',
        name:'txtCrexp_observacion',
        fieldLabel :'Observacion',
        width:'98%'
    });
    /**
     * Ext.form.TextField NO ESPECIFICADO
     */
    var txtCrper_codigo = new Ext.form.TextField({
        id:'txtCrper_codigo',
        name:'txtCrper_codigo',
        fieldLabel :'Testigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * NO ESPECIFICADO
     */
    var btnCrper_codigoCgg_res_expulsion = new Ext.Button({
        id:'btnCrper_codigoCgg_res_expulsion',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_res_persona = new Persona();
                var tmpStore = tmpFLCgg_res_persona.getStore();
                //tmpStore.baseParams.inCarnet = false;
                var objBusqueda = new DlgBusqueda(tmpStore,tmpFLCgg_res_persona.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpCrper_codigo=tmpRecord.get('CRPER_CODIGO');
                        txtCrper_codigo.setValue(tmpRecord.get('CRPER_NOMBRES')+" "+tmpRecord.get('CRPER_APELLIDO_PATERNO')+" "+tmpRecord.get('CRPER_APELLIDO_MATERNO'));
                    }
                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Ext.form.TextField NO ESPECIFICADO
     */
    var txtCrosg_codigo = new Ext.form.TextField({
        id:'txtCrosg_codigo',
        name:'txtCrosg_codigo',
        fieldLabel :'Oficial',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * NO ESPECIFICADO
     */
    var btnCrosg_codigoCgg_res_expulsion = new Ext.Button({
        id:'btnCrosg_codigoCgg_res_expulsion',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_res_oficial_seguimiento = new FrmListadoCgg_res_oficial_seguimiento();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_oficial_seguimiento.getStore(),tmpFLCgg_res_oficial_seguimiento.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpCrosg_codigo= tmpRecord.get('CROSG_CODIGO');
                        txtCrosg_codigo.setValue(tmpRecord.get('NOMBRES')+" "+tmpRecord.get('APELLIDOS'));
                    }

                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Ext.form.DateField NO ESPECIFICADO
     */
    var dtCrexp_fecha_expulsion = new Ext.form.DateField({
        id:'dtCrexp_fecha_expulsion',
        name:'dtCrexp_fecha_expulsion',
        fieldLabel :'Fecha expulsion',
        allowBlank :false,
        format :'d/m/Y',
        disabled:true,
        value:new Date()
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DEL REGISTRO DE  FORMA SALIDA
     */
    var txtCtfsl_codigo = new Ext.form.TextField({
        id:'txtCtfsl_codigo',
        name:'txtCtfsl_codigo',
        fieldLabel :'Forma Salida',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * IDENTIFICATIVO UNICO DEL REGISTRO DE  FORMA SALIDA
     */
    var btnCtfsl_codigoCgg_res_expulsion = new Ext.Button({
        id:'btnCtfsl_codigoCgg_res_expulsion',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_tct_forma_salida = new FrmListadoCgg_tct_forma_salida();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_tct_forma_salida.getStore(),tmpFLCgg_tct_forma_salida.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpCtfsl_codigo=tmpRecord.get('CTFSL_CODIGO');
                        txtCtfsl_codigo.setValue(tmpRecord.get('CTFSL_NOMBRE'));
                    }
                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_expulsion
     */
    var btnGuardarCgg_res_expulsion = new Ext.Button({
        id:'btnGuardarCgg_res_expulsion',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_res_expulsion.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_res_expulsion(r){
                        winFrmCgg_res_expulsion.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_res_expulsion,
                                msg: 'La informaci\u00f3n de la Salida Especial ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            winFrmCgg_res_expulsion.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_res_expulsion,
                                msg: 'La informaci\u00f3n de de la Salida Especial no ha podido ser almacenada. '+r,
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_res_expulsion.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCrexp_codigo',txtCrexp_codigo.getValue());
                    param.add('inCrmov_codigo',tmpCrmov_codigo);
                    param.add('inCrexp_tipo_pago',cbxCrexp_tipo_pago.getValue());
                    param.add('inCrexp_valor_vuelo',numCrexp_valor_vuelo.getValue());
                    param.add('inCrexp_observacion',txtCrexp_observacion.getValue());
                    param.add('inCrnot_codigo',tmpCrnot_codigo.length>0?tmpCrnot_codigo:null);
                    param.add('inCrper_codigo',tmpCrper_codigo);
                    param.add('inCrosg_codigo',tmpCrosg_codigo);
                    param.add('inCrexp_fecha_expulsion',dtCrexp_fecha_expulsion.getValue().format('c'));
                    param.add('inCtfsl_codigo',tmpCtfsl_codigo);
                    SOAPClient.invoke(urlCgg_res_expulsion,IN_SENTENCIA_CGG_RES_EXPULSION,param, true, CallBackCgg_res_expulsion);
                }catch(inErr){
                    winFrmCgg_res_expulsion.getEl().unmask();
                }
            }
        }
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_expulsion.
     */
    var btnCancelarCgg_res_expulsion = new Ext.Button({
        id:'btnCancelarCgg_res_expulsion',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_res_expulsion.getForm().reset();
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_expulsion.
     */
    var btnCerrarCgg_res_expulsion = new Ext.Button({
        id:'btnCerrarCgg_res_expulsion',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_res_expulsion.close();
            }
        }
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_expulsion.
     */
    var pnlCgg_res_expulsion = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCrexp_codigo,
        {
            xtype:'panel',
            layout:'column',
            items:[

            {
                columnWidth:.92,
                layout:'form',
                items:[txtCrosg_codigo]
            },

            {
                columnWidth:.08,
                layout:'form',
                items:[btnCrosg_codigoCgg_res_expulsion]
            }]
        },

        {
            xtype:'panel',
            layout:'column',
            items:[

            {
                columnWidth:.92,
                layout:'form',
                items:[txtCrper_codigo]
            },

            {
                columnWidth:.08,
                layout:'form',
                items:[btnCrper_codigoCgg_res_expulsion]
            }]
        },

        {
            xtype:'panel',
            layout:'column',
            items:[

            {
                columnWidth:.92,
                layout:'form',
                items:[txtCtfsl_codigo]
            },

            {
                columnWidth:.08,
                layout:'form',
                items:[btnCtfsl_codigoCgg_res_expulsion]
            }]
        },
        dtCrexp_fecha_expulsion,cbxCrexp_tipo_pago,numCrexp_valor_vuelo,txtCrexp_observacion,
        ]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_expulsion.
     */
    var winFrmCgg_res_expulsion = new Ext.Window({
        id:'winFrmCgg_res_expulsion',
        title:tituloCgg_res_expulsion,
        width:430,
        minWidth:430,
        maximizable:false,
        minimizable:true,
        modal:true,
        resizable:false,
        constrain:true,
        tbar:getPanelTitulo(tituloCgg_res_expulsion,descCgg_res_expulsion),
        items:[pnlPersonaExpulsion,pnlCgg_res_expulsion],
        bbar:[btnGuardarCgg_res_expulsion,btnCancelarCgg_res_expulsion,'->',btnCerrarCgg_res_expulsion]
    });
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_expulsion.
     */
    function cargarCgg_res_expulsionCtrls(){
        if(inRecordCgg_res_expulsion){
            txtCrexp_codigo.setValue(inRecordCgg_res_expulsion.get('CREXP_CODIGO'));
            tmpCrosg_codigo=inRecordCgg_res_expulsion.get('CROSG_CODIGO');
            txtCrosg_codigo.setValue(inRecordCgg_res_expulsion.get('OFICIAL_SEGUIMIENTO'));
            tmpCrper_codigo=inRecordCgg_res_expulsion.get('CRPER_CODIGO');
            txtCrper_codigo.setValue(inRecordCgg_res_expulsion.get('TESTIGO'));
            tmpCtfsl_codigo=inRecordCgg_res_expulsion.get('CTFSL_CODIGO');
            txtCtfsl_codigo.setValue(inRecordCgg_res_expulsion.get('FORMA_SALIDA'));
            cbxCrexp_tipo_pago.setValue(inRecordCgg_res_expulsion.get('CREXP_TIPO_PAGO'));
            numCrexp_valor_vuelo.setValue(inRecordCgg_res_expulsion.get('CREXP_VALOR_VUELO'));
            txtCrexp_observacion.setValue(inRecordCgg_res_expulsion.get('CREXP_OBSERVACION'));
            dtCrexp_fecha_expulsion.setValue(truncDate(inRecordCgg_res_expulsion.get('CREXP_FECHA_EXPULSION')));
            isEdit = true;
        }
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_expulsion.
     * @returns ventana winFrmCgg_res_expulsion.
     * @base FrmCgg_res_expulsion.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_expulsion;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_expulsion.
     * @base FrmCgg_res_expulsion.prototype.loadData
     */
    this.loadData = function(inDatosExpulsion){
        cargarCgg_res_expulsionCtrls();
        document.getElementById('divInfoPersonaExpulsion').innerHTML =tmpInfoPersonaExpulsion.apply(inDatosExpulsion.json);
        tmpCrper_codigo=inDatosExpulsion.get('CRPER_CODIGO');
        tmpCrmov_codigo=inDatosExpulsion.get('CRMOV_CODIGO');
        tmpCrnot_codigo=inDatosExpulsion.get('CRNOT_CODIGO');
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_expulsion desde una instancia.
 */
FrmCgg_res_expulsion.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_expulsion desde una instancia.
 */
FrmCgg_res_expulsion.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_expulsion,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_expulsion.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_expulsion desde una instancia.
 */
FrmCgg_res_expulsion.prototype.loadData = function(){
    this.loadData();
}
