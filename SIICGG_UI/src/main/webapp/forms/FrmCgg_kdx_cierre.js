/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_kdx_cierre.
 * @param {String} IN_SENTENCIA_CGG_KDX_CIERRE Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_KDX_CIERRE Registro de datos de la tabla Cgg_kdx_cierre.
 * @constructor
 * @base FrmListadoCgg_kdx_cierre
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_kdx_cierre(IN_SENTENCIA_CGG_KDX_CIERRE,IN_RECORD_CGG_KDX_CIERRE){
    var inSentenciaCgg_kdx_cierre = IN_SENTENCIA_CGG_KDX_CIERRE;
    var inRecordCgg_kdx_cierre=IN_RECORD_CGG_KDX_CIERRE;
    var urlCgg_kdx_cierre=URL_WS+"Cgg_kdx_cierre";
    var tituloCgg_kdx_cierre='Cierre caja';
    var descCgg_kdx_cierre='El formulario permite administrar la informaci\u00f3n de cierre caja';
    var isEdit = false;
    var cierre;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CIERRE DE CAJA
     */
    var txtCkcrr_codigo = new Ext.form.TextField({
        id:'txtCkcrr_codigo',
        name:'txtCkcrr_codigo',
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
        allowBlank :false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA
     */
    var btnCkpvt_codigoCgg_kdx_cierre = new Ext.Button({
        id:'btnCkpvt_codigoCgg_kdx_cierre',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_kdx_punto_venta = new FrmListadoCgg_kdx_punto_venta();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_kdx_punto_venta.getStore(),tmpFLCgg_kdx_punto_venta.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                        txtCkpvt_codigo.setValue(tmpRecord.get('CKPVT_CODIGO'));
                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE VENTA
     */
    var txtCkvnt_codigo = new Ext.form.TextField({
        id:'txtCkvnt_codigo',
        name:'txtCkvnt_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false

    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE VENTA
     */
    var txtCkvnt_numero_venta = new Ext.form.TextField({
        id:'txtCkvnt_numero_venta',
        name:'txtCkvnt_numero_venta',
        fieldLabel :'No. venta',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE VENTA
     */
    var btnCkvnt_codigoCgg_kdx_cierre = new Ext.Button({
        id:'btnCkvnt_codigoCgg_kdx_cierre',
        iconCls:'iconBuscar',
        tooltip:'Buscar ventas',
        listeners:{
            click:function(){
                var tmpFLCgg_kdx_venta = new Cgg_kdx_Venta_estado(TypeEstadoVenta.CONFIRMADA);
                var objBusqueda = new DlgBusqueda(tmpFLCgg_kdx_venta.getStore(),tmpFLCgg_kdx_venta.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                    {
                        txtCkvnt_codigo.setValue(tmpRecord.get('CKVNT_CODIGO'));
                        txtCkvnt_numero_venta.setValue(tmpRecord.get('CKVNT_NUMERO_VENTA'));
                        numCkcrr_total_venta.setValue(tmpRecord.get('CKVNT_TOTAL'));
                    }
                });
                objBusqueda.show();
            }
        }
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
     * IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
     */
    var btnCkupv_codigoCgg_kdx_cierre = new Ext.Button({
        id:'btnCkupv_codigoCgg_kdx_cierre',
        text:'Ckupv_codigo',
        iconCls:'iconCkupv_codigo',
        listeners:{
            click:function(){
                var tmpFLCgg_kdx_usuario_pv = new FrmListadoCgg_kdx_usuario_pv();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_kdx_usuario_pv.getStore(),tmpFLCgg_kdx_usuario_pv.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                        txtCkupv_codigo.setValue(tmpRecord.get('CKUPV_CODIGO'));
                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Ext.form.DateField FECHA DE REALIZACION DEL CIERRE
     */
    var dtCkcrr_fecha_cierre = new Ext.form.DateField({
        id:'dtCkcrr_fecha_cierre',
        name:'dtCkcrr_fecha_cierre',
        fieldLabel :'Fecha cierre',
        allowBlank :false,
        format :'d/m/Y',
        value:new Date()
    });
    /**
     * Ext.form.TextField NUMERO SECUENCIAL IDENTIFICATIVO
     */
    var txtCkcrr_numero_cierre = new Ext.form.TextField({
        id:'txtCkcrr_numero_cierre',
        name:'txtCkcrr_numero_cierre',
        fieldLabel :'Numero cierre',
        anchor:'98%',
        allowBlank :false
        //readOnly:'true'
    });
    /**
     * Ext.form.NumberField VALOR TOTAL REGISTRADO EN LA VENTA
     */
    var numCkcrr_total_venta = new Ext.form.NumberField({
        id:'numCkcrr_total_venta',
        name:'numCkcrr_total_venta',
        fieldLabel :'Total reportado',
        allowBlank :false,
        disabled :false,
        value:0,
        readOnly:'true'
    });
    /**
     * Ext.form.NumberField VALOR TOTAL CONTABILIZADO EN EL CIERRE
     */
    var numCkcrr_total = new Ext.form.NumberField({
        id:'numCkcrr_total',
        name:'numCkcrr_total',
        fieldLabel :'Total contabilizado',
        allowBlank :false,
        disabled :false,
        readOnly:'true'
    });
    /**
     * Ext.form.TextArea INFORMACION ADICIONAL
     */
    var txtCkcrr_observacion = new Ext.form.TextArea({
        id:'txtCkcrr_observacion',
        name:'txtCkcrr_observacion',
        fieldLabel :'Observacion',
        width:'90%',
        allowBlank :false
    });
    /**
     * Ext.form.NumberField VALOR DE DIFERENCIA
     */
    var numCkcrr_diferencia = new Ext.form.NumberField({
        id:'numCkcrr_diferencia',
        name:'numCkcrr_diferencia',
        fieldLabel :'Diferencia',
        allowBlank :false,
        disabled :false,
        readOnly:'true'
    });
    /**
     * Ext.form.NumberField ESTADO DEL REGISTRO DE CIERRE PARA CONTROL DE INFORMACION
     0.- REGISTRADA
     1.- CONFIRMADA
     */
    var numCkcrr_estado_cierre = new Ext.form.NumberField({
        id:'numCkcrr_estado_cierre',
        name:'numCkcrr_estado_cierre',
        fieldLabel :'Estado cierre',
        allowBlank :false,
        disabled :false
    });

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_kdx_cierre_detalle.
     */
    var cmCgg_kdx_cierre_detalle = new Ext.grid.ColumnModel([
    {
        dataIndex:'CKCDT_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },
    {
        dataIndex:'CKDNM_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },
    {
        dataIndex:'CKDNM_DENOMINACION',
        header:'Denominaci\u00f3n',
        width:170,
        sortable:true
    },
    {
        dataIndex:'CKCRR_CODIGO',
        header:'Codigo',
        width:120,
        sortable:true,
        hidden:true
    },
    {
        dataIndex:'CKCDT_CANTIDAD',
        header:'Cantidad',
        width:120,
        sortable:true
    },
    {
        dataIndex:'CKCDT_VALOR',
        header:'Valor',
        width:120,
        sortable:true
    },
    {
        dataIndex:'CKCDT_TOTAL',
        header:'Total',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CKCDT_OBSERVACION',
        header:'Doc. referencia',
        width:100,
        sortable:true
    }
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_kdx_cierre_detalle por un campo especifico.
     */
    var gsCgg_kdx_cierre_detalle = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_cierre_detalle",
            method:"selectCierreAll",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
            },[
            {
                name:'CKCDT_CODIGO'
            },

            {
                name:'CKDNM_CODIGO'
            },

            {
                name:'CKDNM_DENOMINACION'
            },

            {
                name:'CKDNM_VALOR_MONETARIO'
            },

            {
                name:'CKCRR_CODIGO'
            },

            {
                name:'CKCDT_CANTIDAD'
            },

            {
                name:'CKCDT_VALOR'
            },

            {
                name:'CKCDT_TOTAL'
            },

            {
                name:'CKCDT_OBSERVACION'
            }
            ]),
        // sortInfo:{field: 'CKDNM_CODIGO', direction: 'ASC'},
        baseParams:{
            inCkcrr_codigo:"",
            format:'JSON'
        }
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_kdx_cierre_detalle en un formato tabular de filas y columnas.
     */
    var grdCgg_kdx_cierre_detalle = new Ext.grid.GridPanel({
        cm:cmCgg_kdx_cierre_detalle,
        store:gsCgg_kdx_cierre_detalle,
        region:'center',
        anchor:'100% 100%',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        viewConfig:{
            forceFit:true
        },
        loadMask:{
            msg:"Cargando..."
        }
    });


    Ext.ux.grid.GroupSummary.Calculations['total'] = function(v, record, field){
        return v + record.data.CKVNT_TOTAL;
    };


    var summary = new Ext.ux.grid.GroupSummary();
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_kdx_venta_cierre.
     */
    var cmCgg_kdx_venta_cierre = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
        {
            dataIndex:'CKVTC_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true
        },

        {
            dataIndex:'CKVNT_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true
        },

        {
            dataIndex:'CKCRR_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true
        },

        {
            dataIndex:'CKVNT_NUMERO_VENTA',
            header:'No. Venta',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CKESP_NOMBRE',
            header:'Especie',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CKVNT_CANTIDAD',
            header:'Cantidad',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CKASG_PRECIO_UNITARIO',
            header:'PU',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CKVNT_TOTAL',
            header:'Total',
            width:150,
            sortable:true,
            summaryType: 'sum',
            summaryRenderer: Ext.util.Format.usMoney
        }
        ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_kdx_venta_cierre por un campo especifico.
     */
    var gsCgg_kdx_venta_cierre = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_venta_cierre",
            method:"selectVentaCierreAll",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({

            },[
            {
                name:'CKVTC_CODIGO'
            },

            {
                name:'CKVNT_CODIGO'
            },

            {
                name:'CKCRR_CODIGO'
            },

            {
                name:'CKVNT_NUMERO_VENTA'
            },

            {
                name:'CKESP_NOMBRE'
            },

            {
                name:'CKVNT_CANTIDAD'
            },

            {
                name:'CKASG_PRECIO_UNITARIO'
            },

            {
                name:'CKVNT_TOTAL'
            }

            ]),
        // sortInfo:{field: 'CKVNT_CODIGO', direction: 'ASC'},
        baseParams:{
            inCkcrr_codigo:"",
            format:'JSON'
        }
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_kdx_cierre_detalle en un formato tabular de filas y columnas.
     */
    var grdCgg_kdx_venta_cierre = new Ext.grid.GridPanel({
        cm:cmCgg_kdx_venta_cierre,
        store:gsCgg_kdx_venta_cierre,
        frame:true,
        region:'center',
        plugins: summary,
        tbar:[
        {
            iconCls:'iconNuevo',
            tooltip:'Agregar registro de venta',
            listeners:{
                click:function()
                {
                    var tmpFLCgg_kdx_venta = new Cgg_kdx_Venta_estado(TypeEstadoVenta.CONFIRMADA);
                    var objBusqueda = new DlgBusqueda(tmpFLCgg_kdx_venta.getStore(),tmpFLCgg_kdx_venta.getColumnModel(),true);
                    objBusqueda.closeHandler(function(){
                        var tmpRecordVenta = objBusqueda.getSelectedRows();
                        var tmpExist = -1;
                        if(tmpRecordVenta)
                        {

                            var tmpRecordVentaCierre= grdCgg_kdx_venta_cierre.getStore().recordType;
                            for(var i=0;i<tmpRecordVenta.length;i++)
                            {
                                tmpExist = -1;
                                tmpExist = gsCgg_kdx_venta_cierre.findExact('CKVNT_NUMERO_VENTA',tmpRecordVenta[i].get("CKVNT_NUMERO_VENTA"));
                                if (tmpExist < 0)
                                {
                                    grdCgg_kdx_venta_cierre.getStore().insert(0,
                                        new tmpRecordVentaCierre({
                                            CKVTC_CODIGO: 'KEYGEN',
                                            CKVNT_CODIGO:tmpRecordVenta[i].get("CKVNT_CODIGO"),
                                            CKCRR_CODIGO: '',
                                            CKVNT_NUMERO_VENTA: tmpRecordVenta[i].get("CKVNT_NUMERO_VENTA"),
                                            CKESP_NOMBRE: tmpRecordVenta[i].get("CKESP_NOMBRE"),
                                            CKVNT_CANTIDAD: tmpRecordVenta[i].get("CKVNT_CANTIDAD"),
                                            CKASG_PRECIO_UNITARIO:tmpRecordVenta[i].get("CKASG_PRECIO_UNITARIO"),
                                            CKVNT_TOTAL:tmpRecordVenta[i].get("CKVNT_TOTAL")
                                        })
                                        );
                                    numCkcrr_total_venta.setValue(tmpRecordVenta[i].get("CKVNT_TOTAL")*1+numCkcrr_total_venta.getValue());
                                }
                            /* txtCkvnt_codigo.setValue(tmpRecord.get('CKVNT_CODIGO'));
                                     txtCkvnt_numero_venta.setValue(tmpRecord.get('CKVNT_NUMERO_VENTA'));
                                     numCkcrr_total_venta.setValue(tmpRecord.get('CKVNT_TOTAL'));*/
                            }
                            grdCgg_kdx_venta_cierre.getView().refresh();
                        }
                    });
                    objBusqueda.show();
                }
            }
        },
        {
            iconCls:'iconEliminar',
            tooltip:'Eliminar registro de venta'
        }
        ],
        //   region:'center',
        anchor:'100% 100%',
        //height:50,
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        viewConfig:{
            forceFit:true
        },
        loadMask:{
            msg:"Cargando..."
        }
    });



    /*gsCgg_kdx_cierre_detalle.reload({params:{
     start:0,
     limit:RECORD_PAGE,
     format:'JSON'
     }
     });*/
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_kdx_cierre
     */
    var btnGuardarCgg_kdx_cierre = new Ext.Button({
        id:'btnGuardarCgg_kdx_cierre',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (!pnlCgg_kdx_cierre.getForm().isValid()){
                    return;
                }
                if (numCkcrr_diferencia.getValue()==0)
                {
                    guardarCierre();
                }
                else
                {
                    function Guardar(btn)
                    {
                        if (btn=='yes'){

                            guardarCierre();
                        }
                        else
                        {
                            return;
                        }
                    }
                    Ext.Msg.show({
                        title:tituloCgg_kdx_cierre,
                        msg: 'Los datos reportados y contabilizados no coinciden.<br> Esta seguro que sea continuar?',
                        buttons: Ext.Msg.YESNO,
                        fn:Guardar,
                        icon: Ext.MessageBox.INFO
                    });


                }

            }
        }
    });

    function guardarCierre(){
        try{
            function CallBackCgg_kdx_cierre(r){
                winFrmCgg_kdx_cierre.getEl().unmask();
                var cierre = null;
                try{
                    cierre = Ext.util.JSON.decode(r);
                    if(cierre.success == true)
                        cierre = cierre.objData;
                    else
                        cierre = null;
                }catch(inErr){
                    cierre = null;
                }
				
                if(cierre !== null && cierre.CKCRR_CODIGO !== undefined && cierre.CKCRR_CODIGO !== null){                    

                    Ext.MsgPopup.msg(tituloCgg_kdx_cierre, 'La informaci\u00f3n de cierre caja ha sido almacenada.', MsgPopup.INFO);
                    
                    var pReport = [];
                    pReport[0]=
                    {
                        objectName:'FrmListadoCgg_usuario',
                        label:'Para',
                        valueField:'CUSU_CODIGO',
                        displayField:'CUSU_NOMBRE_USUARIO',
                        paramName:'P_CUSU_CODIGO',
                        paramValue:'',
                        type:'searchable'
                    };

                    pReport[1]={
                        label:'N. Cierre',
                        paramName:'P_CKCRR_CODIGO',
                        paramValue:cierre.CKCRR_CODIGO,
                        value:cierre.CRCRR_NUMERO_CIERRE,
                        type:'direct'
                    };

                    pReport[2]=
                    {
                        label:'N. guia blindado',
                        paramName:'P_NUMERO_GUIA',
                        paramValue:'',
                        type:'input',
                        required:true											
                    };
                    pReport[3]=
                    {
                        label:'No. funda entregado',
                        paramName:'P_NUMERO_FUNDA',
                        paramValue:'',
                        type:'input',
                        required:true
                    };
                    pReport[4]=
                    {
                        label:'Recibo caja',
                        paramName:'P_RECIBO_CAJA',
                        paramValue:'',
                        type:'input',
                        required:true
                    };
                    var reporte = new FrmCriterioReporte('rptCierreCaja', '/Reports/sii/kardex', null);
                    reporte.addParams(pReport);
                    reporte.show();
                    winFrmCgg_kdx_cierre.close();
                }else{
                    Ext.Msg.show({
                        title:tituloCgg_kdx_cierre,
                        msg: 'La informaci\u00f3n de cierre caja no ha podido ser almacenada.<br>'+ERR_MESSAGE,
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.ERROR
                    });
                }
            }
            winFrmCgg_kdx_cierre.getEl().mask('Guardando...', 'x-mask-loading');
            var param = new SOAPClientParameters();
            if(isEdit)
                param.add('inCkcrr_codigo',txtCkcrr_codigo.getValue());
            param.add('inCkpvt_codigo',txtCkpvt_codigo.getValue());
            param.add('inCkupv_codigo',txtCkupv_codigo.getValue());
            param.add('inCkcrr_fecha_cierre',dtCkcrr_fecha_cierre.getValue().format(TypeDateFormat.Custom));
            param.add('inCkcrr_numero_cierre',txtCkcrr_numero_cierre.getValue());
            param.add('inCkcrr_total_venta',numCkcrr_total_venta.getValue());
            param.add('inCkcrr_total',numCkcrr_total.getValue());
            param.add('inCkcrr_observacion',txtCkcrr_observacion.getValue());
            param.add('inCkcrr_diferencia',numCkcrr_diferencia.getValue());
            param.add('inCkcrr_estado_cierre',TypeEstadoCierre.CONFIRMADA);
            param.add('inCierreDetalle_JSON',grdCgg_kdx_cierre_detalle.getStore().getJsonData());
            param.add('inVentaCierre_JSON',grdCgg_kdx_venta_cierre.getStore().getJsonData());
            SOAPClient.invoke(urlCgg_kdx_cierre,IN_SENTENCIA_CGG_KDX_CIERRE + '1',param, true, CallBackCgg_kdx_cierre);
        }catch(inErr){
            winFrmCgg_kdx_cierre.getEl().unmask();
        }
    }
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_kdx_cierre.
     */
    var btnCancelarCgg_kdx_cierre = new Ext.Button({
        id:'btnCancelarCgg_kdx_cierre',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                // pnlCgg_kdx_cierre.getForm().reset();
                alert(r);
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_kdx_cierre.
     */
    var btnCerrarCgg_kdx_cierre = new Ext.Button({
        id:'btnCerrarCgg_kdx_cierre',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_kdx_cierre.close();
            }
        }
    });


    var pnlCgg_kdx_cierre_detalle = new Ext.TabPanel({
        activeTab: 0,
        region:'center',
        //layout :'fit',
        // collapsible: true,
        height:170,
        //anchor:'100% 50%',
        items:[
        {
            //xtype:'panel',

            frame:false,
            labelWidth :100,
            title:'Detalle recaudaci\u00f3n',
            region:'center',
            layout :'border',
            tbar:[
            {
                iconCls:'iconNuevo',
                tooltip:'Agregar denominacion monetaria',
                listeners:{
                    click:function()
                    {
                        if(grdCgg_kdx_venta_cierre.getStore().getCount()>0)
                        {
                            var objCgg_kdx_cierre_detalle = new FrmCgg_kdx_cierre_detalle("insert");
                            objCgg_kdx_cierre_detalle.closeHandler(function(){
                                var tmpRecordCierreDetalle = objCgg_kdx_cierre_detalle.getData();
                                if(tmpRecordCierreDetalle)
                                {
                                    var recId = grdCgg_kdx_cierre_detalle.getStore().getCount() + 2;
                                    grdCgg_kdx_cierre_detalle.stopEditing();
                                    grdCgg_kdx_cierre_detalle.getStore().insert(0, new gsCgg_kdx_cierre_detalle.recordType(tmpRecordCierreDetalle, recId));
                                    grdCgg_kdx_cierre_detalle.getView().refresh();
                                    grdCgg_kdx_cierre_detalle.getSelectionModel().selectRow(0);
                                    numCkcrr_total.setValue(gsCgg_kdx_cierre_detalle.sum('CKCDT_TOTAL'));
                                    numCkcrr_diferencia.setValue(numCkcrr_total_venta.getValue() - numCkcrr_total.getValue());

                                }

                            });
                            objCgg_kdx_cierre_detalle.show();
                        }
                        else
                        {
                            Ext.Msg.show({
                                title:tituloCgg_kdx_cierre,
                                msg: 'Es necesario ingresar el detalle de las ventas para continuar.!!',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.WARNING
                            });

                        }

                    }
                }
            },
            {
                xtype:'button',
                id:'btnEditarCgg_gem_perfil_prof',
                iconCls:'iconEditar',
                listeners:{
                    click:function(){
                        var r = grdCgg_kdx_cierre_detalle.getSelectionModel().getSelected();
                        var index = 0;
                        if (r) {
                            var objCgg_kdx_cierre_detalle = new FrmCgg_kdx_cierre_detalle("update",r);
                            objCgg_kdx_cierre_detalle.closeHandler(function(){

                                var tmpRecordCierreDetalle = objCgg_kdx_cierre_detalle.getData();
                                if(tmpRecordCierreDetalle)
                                {
                                    r.set('CKCDT_CODIGO',tmpRecordCierreDetalle.CKCDT_CODIGO);
                                    r.set('CKDNM_CODIGO',tmpRecordCierreDetalle.CKDNM_CODIGO);
                                    r.set('CKDNM_DENOMINACION',tmpRecordCierreDetalle.CKDNM_DENOMINACION);
                                    r.set('CKDNM_VALOR_MONETARIO',tmpRecordCierreDetalle.CKDNM_VALOR_MONETARIO);
                                    r.set('CKCRR_CODIGO',tmpRecordCierreDetalle.CKCRR_CODIGO);
                                    r.set('CKCDT_CANTIDAD',tmpRecordCierreDetalle.CKCDT_CANTIDAD);
                                    r.set('CKCDT_VALOR',tmpRecordCierreDetalle.CKCDT_VALOR);
                                    r.set('CKCDT_TOTAL',tmpRecordCierreDetalle.CKCDT_TOTAL);
                                    r.set('CKCDT_VALOR',tmpRecordCierreDetalle.CKCDT_VALOR);
                                    r.set('CKCDT_OBSERVACION',tmpRecordCierreDetalle.CKCDT_OBSERVACION);
                                    numCkcrr_total.setValue(gsCgg_kdx_cierre_detalle.sum('CKCDT_TOTAL'));
                                    numCkcrr_diferencia.setValue(numCkcrr_total_venta.getValue() - numCkcrr_total.getValue());
                                }

                            });
                            objCgg_kdx_cierre_detalle.loadData();
                            objCgg_kdx_cierre_detalle.show();
                        }
                    }
                }
            },
            {
                iconCls:'iconEliminar',
                tooltip:'Eliminar denominacion monetaria'

            }
            ],
            items:[grdCgg_kdx_cierre_detalle]

        },
        {
            xtype:'panel',
            layout:'form',
            frame:true,
            title:'Resumen',
            labelWidth:120,
            items:[numCkcrr_total_venta,numCkcrr_total,numCkcrr_diferencia,txtCkcrr_observacion]
        // items:[grdCgg_jur_criterio]
        }
        ]
    });


    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_kdx_venta.
     */
    var pnlCgg_kdx_venta = new Ext.form.FieldSet({
        labelWidth :100,
        title:'Ventas reportadas',
        layout :'fit',
        collapsible: true,
        height:170,
        items:[grdCgg_kdx_venta_cierre],
        listeners:
        {
            collapse:function(){
                pnlCgg_kdx_cierre.setHeight(pnlCgg_kdx_cierre.getHeight()-120);
                winFrmCgg_kdx_cierre.doLayout();
            },
            expand:function(){
                pnlCgg_kdx_cierre.setHeight(pnlCgg_kdx_cierre.getHeight()+120);
                winFrmCgg_kdx_cierre.doLayout();
            }
        }
    });

    var objUsuarioPVCierre={
        CKPVT_NOMBRE:'',
        CRPER_NOMBRES:'',
        CKUPV_CODIGO:'',
        CKPVT_CODIGO:''
    }
    var tplInfoPuntoVentaCierre = new Ext.Template(
        '<table width="100%"  cellpadding="10" class="cggTemplate" >' +
        '<tr rowspan="0">' +
        '<td width="17%" ><div class="tituloTemplate">Punto de Venta:</div></td>' +
        '<td width="33%"  ><div class="itemTemplate">{CKPVT_NOMBRE}</div></td>' +
        '<td width="17%" ><div class="tituloTemplate">Supervisor:</div></td>' +
        '<td width="33%" ><div class="itemTemplate">{CRPER_NOMBRES}</div></td>' +
        '</tr>' +
        '</table>'
        );

    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_kdx_cierre.
     */
    var pnlCgg_kdx_cierre = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        region:'north',
        height:250,
        layout:'form',
        items:[txtCkcrr_codigo,{
            xtype:'panel',
            layout:'column',
            items:[{
                columnWidth:.5,
                layout:'form',
                items:[txtCkcrr_numero_cierre]
            },{
                columnWidth:.5,
                layout:'form',
                items:[dtCkcrr_fecha_cierre]
            }]
        },

        {
            xtype:'panel',
            id :'pnlPuntoVentaCierre',
            style: {
                padding: '0 0 5 0'
            },
            data:objUsuarioPVCierre,
            tpl:tplInfoPuntoVentaCierre
        },

        //{xtype:'panel',layout:'column',items:[{columnWidth:.9,layout:'form',items:[grdCgg_kdx_venta_cierregrdCgg_kdx_venta_cierre/*txtCkvnt_numero_venta*/]},{columnWidth:.1,layout:'form',items:[btnCkvnt_codigoCgg_kdx_cierre]}]},
        /*numCkcrr_total_venta,numCkcrr_total,txtCkcrr_observacion,numCkcrr_diferencia*/pnlCgg_kdx_venta]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_kdx_cierre.
     */
    var winFrmCgg_kdx_cierre = new Ext.Window({
        id:'winFrmCgg_kdx_cierre',
        title:tituloCgg_kdx_cierre,
        iconCls:'iconAplicacion',
        width:650,
        minWidth:400,
        height:550,
        maximizable:false,
        minimizable:false,
        modal:true,
        constrain:true,
        layout:'border',
        tbar:getPanelTitulo(tituloCgg_kdx_cierre,descCgg_kdx_cierre),
        items:[pnlCgg_kdx_cierre,pnlCgg_kdx_cierre_detalle],
        bbar:[btnGuardarCgg_kdx_cierre,btnCancelarCgg_kdx_cierre,'->',btnCerrarCgg_kdx_cierre],
        listeners:{
            show:function()
            {
                if(!isEdit)
                {
                    numeroCierre();
                    usuarioPuntoventa();

                }
            }
        }

    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmCgg_kdx_cierre.getBottomToolbar());
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_kdx_cierre.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_kdx_cierreCtrls(inEstado){
        estado=!inEstado;
        txtCkcrr_codigo.setDisabled(estado);
        txtCkpvt_codigo.setDisabled(estado);
        txtCkvnt_codigo.setDisabled(estado);
        txtCkvnt_numero_venta.setDisabled(estado);
        txtCkupv_codigo.setDisabled(estado);
        dtCkcrr_fecha_cierre.setDisabled(estado);
        txtCkcrr_numero_cierre.setDisabled(estado);
        numCkcrr_total_venta.setDisabled(estado);
        numCkcrr_total.setDisabled(estado);
        txtCkcrr_observacion.setDisabled(estado);
        numCkcrr_diferencia.setDisabled(estado);
        numCkcrr_estado_cierre.setDisabled(estado);
        btnGuardarCgg_kdx_cierre.setDisabled(true);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_kdx_cierre.
     */
    function cargarCgg_kdx_cierreCtrls(){
        if(inRecordCgg_kdx_cierre){
            txtCkcrr_codigo.setValue(inRecordCgg_kdx_cierre.get('CKCRR_CODIGO'));
            txtCkpvt_codigo.setValue(inRecordCgg_kdx_cierre.get('CKPVT_CODIGO'));
            txtCkvnt_codigo.setValue(inRecordCgg_kdx_cierre.get('CKVNT_CODIGO'));
            txtCkvnt_numero_venta.setValue(inRecordCgg_kdx_cierre.get('CKVNT_NUMERO_VENTA'));
            txtCkupv_codigo.setValue(inRecordCgg_kdx_cierre.get('CKUPV_CODIGO'));
            dtCkcrr_fecha_cierre.setValue(truncDate(inRecordCgg_kdx_cierre.get('CKCRR_FECHA_CIERRE')));
            txtCkcrr_numero_cierre.setValue(inRecordCgg_kdx_cierre.get('CKCRR_NUMERO_CIERRE'));
            numCkcrr_total_venta.setValue(inRecordCgg_kdx_cierre.get('CKCRR_TOTAL_VENTA'));
            numCkcrr_total.setValue(inRecordCgg_kdx_cierre.get('CKCRR_TOTAL'));
            txtCkcrr_observacion.setValue(inRecordCgg_kdx_cierre.get('CKCRR_OBSERVACION'));
            numCkcrr_diferencia.setValue(inRecordCgg_kdx_cierre.get('CKCRR_DIFERENCIA'));
            numCkcrr_estado_cierre.setValue(inRecordCgg_kdx_cierre.get('CKCRR_ESTADO_CIERRE'));
            isEdit = true;
            gsCgg_kdx_cierre_detalle.reload({
                params:{
                    inCkcrr_codigo:inRecordCgg_kdx_cierre.get('CKCRR_CODIGO'),
                    format:TypeFormat.JSON
                }
            });
            gsCgg_kdx_venta_cierre.reload({
                params:{
                    inCkcrr_codigo:inRecordCgg_kdx_cierre.get('CKCRR_CODIGO'),
                    format:TypeFormat.JSON
                }
            });
            habilitarCgg_kdx_cierreCtrls(true);
        }
    }
    /**
     * Funcion que permite mostrar el numero de cierre de caja
     */
    function numeroCierre(){
        function callBacknumeroCierre(r){
            txtCkcrr_numero_cierre.setValue(r);
        }
        SOAPClient.invoke(urlCgg_kdx_cierre,'numeroCierre',false, false, callBacknumeroCierre);
    }
    /**
     * Funcion que permite mostrar el numero de transferencia
     */
    function usuarioPuntoventa()
    {

        try{
            function callBackUsuarioPuntoVenta(r){
                var res = Ext.util.JSON.decode(r)[0];
                objUsuarioPVCierre.CKPVT_NOMBRE = res.CKPVT_NOMBRE;
                objUsuarioPVCierre.CRPER_NOMBRES = res.CRPER_NOMBRES;

                txtCkupv_codigo.setValue(res.CKUPV_CODIGO);
                txtCkpvt_codigo.setValue(res.CKPVT_CODIGO);
                objUsuarioPVCierre.CKUPV_CODIGO = res.CKUPV_CODIGO;
                objUsuarioPVCierre.CKPVT_CODIGO = res.CKPVT_CODIGO;
                tplInfoPuntoVentaCierre.overwrite(Ext.getCmp('pnlPuntoVentaCierre').body,objUsuarioPVCierre);

            }
            var param = new SOAPClientParameters();
            param.add('format',TypeFormat.JSON);
            SOAPClient.invoke(URL_WS + 'Cgg_kdx_asignacion',"selectUsuarioPuntoVenta",param, true, callBackUsuarioPuntoVenta);

        }catch(inErr){
            winFrmCgg_kdx_cierre.getEl().unmask();
        }

    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_kdx_cierre.
     * @returns ventana winFrmCgg_kdx_cierre.
     * @base FrmCgg_kdx_cierre.prototype.show
     */
    this.getWindow = function(){
        //if(!isEdit)
        //   numeroCierre();
        return winFrmCgg_kdx_cierre;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_kdx_cierre.
     * @base FrmCgg_kdx_cierre.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_kdx_cierreCtrls();
    }

}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_kdx_cierre desde una instancia.
 */
FrmCgg_kdx_cierre.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_kdx_cierre desde una instancia.
 */
FrmCgg_kdx_cierre.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_kdx_cierre,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_kdx_cierre.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_kdx_cierre desde una instancia.
 */
FrmCgg_kdx_cierre.prototype.loadData = function(){
    this.loadData();
}
