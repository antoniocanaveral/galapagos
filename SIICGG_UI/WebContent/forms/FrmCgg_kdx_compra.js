/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_kdx_compra.
 * @param {String} IN_SENTENCIA_CGG_KDX_COMPRA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_KDX_COMPRA Registro de datos de la tabla Cgg_kdx_compra.
 * @constructor
 * @base FrmListadoCgg_kdx_compra
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_kdx_compra(IN_SENTENCIA_CGG_KDX_COMPRA,IN_RECORD_CGG_KDX_COMPRA){
    var inSentenciaCgg_kdx_compra = IN_SENTENCIA_CGG_KDX_COMPRA;
    var inRecordCgg_kdx_compra=IN_RECORD_CGG_KDX_COMPRA;
    var urlCgg_kdx_compra=URL_WS+"Cgg_kdx_compra";
    var tituloCgg_kdx_compra='Registro compra';
    var descCgg_kdx_compra='El formulario permite administrar la informaci\u00f3n de Compras de especies';
    var isEdit = false;
    var cantidadCompra ;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE COMPRA
     */
    var txtCkcmp_codigo = new Ext.form.TextField({
        id:'txtCkcmp_codigo',
        name:'txtCkcmp_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.form.NumberField LOTE AL QUE CORRESPONDE LA COMPRA
     */
    var numCkcmp_lote = new Ext.form.NumberField({
        id:'numCkcmp_lote',
        name:'numCkcmp_lote',
        fieldLabel :'Lote compra',
        allowBlank :false,
        anchor:'55%',
        disabled :false
    });
    /**
     * Ext.form.DateField FECHA DE INGRESO DE LAS ESPECIES
     */
    var dtCkcmp_fecha_ingreso = new Ext.form.DateField({
        id:'dtCkcmp_fecha_ingreso',
        name:'dtCkcmp_fecha_ingreso',
        fieldLabel :'Fecha ingreso',
        allowBlank :false,
        format :'d/m/Y',
        value:new Date(),
        maxValue:new Date()
    });
    /**
     * Ext.form.TextField SERIE DEL LOTE DE ESPECIES
     */
    var txtCkcmp_serie = new Ext.form.NumberField({
        id:'txtCkcmp_serie',
        name:'txtCkcmp_serie',
        fieldLabel :'Serie inicio',
        anchor:'55%',
        allowBlank :false,
        enableKeyEvents:true,
        listeners:{
            change:function(){
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
     * Ext.form.TextField SERIE DEL LOTE DE ESPECIES
     */
    var txtCkcmp_serie_fin = new Ext.form.NumberField({
        id:'txtCkcmp_serie_fin',
        name:'txtCkcmp_serie_fin',
        fieldLabel :'Serie fin',
        anchor:'55%',
        allowBlank :false,
        enableKeyEvents:true,
        listeners:{
            change:function(){
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
        cantidadCompra = ((txtCkcmp_serie_fin.getValue())*1 - (txtCkcmp_serie.getValue()*1)) + 1;

        if(grdCgg_kdx_compra_detalle.getStore().getCount()>0)
        {
            grdCgg_kdx_compra_detalle.getSelectionModel().selectRow(0);
            var r=grdCgg_kdx_compra_detalle.getSelectionModel().getSelected();
            r.set('CKCMD_CANTIDAD',cantidadCompra);
            r.set('CKCMD_TOTAL',r.get('CKCMD_PRECIO_UNITARIO')*cantidadCompra);
            txtCkcmp_total.setValue(r.get('CKCMD_PRECIO_UNITARIO')*cantidadCompra);

        }

    }

    /**
     * Ext.form.TextField NOMBRE DE PROCEDENCIA DE LAS ESPECIES
     */
    var txtCkcmp_procedencia = new Ext.form.TextField({
        id:'txtCkcmp_procedencia',
        name:'txtCkcmp_procedencia',
        fieldLabel :'Procedencia',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Ext.form.NumberField TOTAL DE ESPECIES DE LA FACTURA
     */
    var numCkcmp_cantidad = new Ext.form.NumberField({
        id:'numCkcmp_cantidad',
        name:'numCkcmp_cantidad',
        fieldLabel :'Cantidad',
        allowBlank :false,
        disabled :false
    });
    /**
     * Ext.form.TextField NUMERO DE FACTURA DE LA COMPRA.
     */
    var txtCkcmp_factura = new Ext.form.TextField({
        id:'txtCkcmp_factura',
        name:'txtCkcmp_factura',
        fieldLabel :'N\u00famero',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Ext.form.TextField TOTAL DE LA FACTURA
     */
    var txtCkcmp_total = new Ext.form.TextField({
        id:'txtCkcmp_total',
        name:'txtCkcmp_total',
        fieldLabel :'Total',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_kdx_compra
     */
    var btnGuardarCgg_kdx_compra = new Ext.Button({
        id:'btnGuardarCgg_kdx_compra',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_kdx_compra.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_kdx_compra(r){
                        winFrmCgg_kdx_compra.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_kdx_compra,
                                msg: 'La informaci\u00f3n de Compra ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_kdx_compra.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_kdx_compra,
                                msg: 'La informaci\u00f3n de Compra no ha podido ser almacenada. '+(r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_kdx_compra.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCkcmp_codigo',txtCkcmp_codigo.getValue());
                    param.add('inCkcmp_lote',numCkcmp_lote.getValue());
                    param.add('inCkcmp_fecha_ingreso',dtCkcmp_fecha_ingreso.getValue().format(TypeDateFormat.Custom));
                    param.add('inCkcmp_serie',txtCkcmp_serie.getValue());
                    param.add('inCkcmp_procedencia',txtCkcmp_procedencia.getValue());
                    param.add('inCkcmp_cantidad',numCkcmp_cantidad.getValue()?numCkcmp_cantidad.getValue():cantidadCompra);
                    param.add('inCkcmp_factura',txtCkcmp_factura.getValue()?txtCkcmp_factura.getValue():0);
                    param.add('inCkcmp_total',txtCkcmp_total.getValue());
                    param.add('inCompraDetalle_JSON',grdCgg_kdx_compra_detalle.getStore().getJsonData());
                    SOAPClient.invoke(urlCgg_kdx_compra,IN_SENTENCIA_CGG_KDX_COMPRA + '1',param, true, CallBackCgg_kdx_compra);
                }catch(inErr){
                    winFrmCgg_kdx_compra.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_kdx_compra.
     */
    var btnCancelarCgg_kdx_compra = new Ext.Button({
        id:'btnCancelarCgg_kdx_compra',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_kdx_compra.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_kdx_compra.
     */
    var btnCerrarCgg_kdx_compra = new Ext.Button({
        id:'btnCerrarCgg_kdx_compra',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_kdx_compra.close();
            }}
    });
    /*
     * Ext.ux.grid.RowEditor Editor de filas personalizado para utilización en el grid de criterio
     */
    var reDetalleCompra = new Ext.ux.grid.RowEditor({
        saveText: 'Aceptar',
        cancelText:'Cancelar',
        listeners:{
            validateedit:function(inRowEditor,inObject,inRecord,inRowIndex){
                var inRecord = grdCgg_kdx_compra_detalle.getStore().getAt(0);
                var recordExist = gsCgg_kdx_compra_detalle.getAt(gsCgg_kdx_compra_detalle.findExact('CKESP_CODIGO',inObject.CKESP_CODIGO));//cbxEditorTipoEspecie.getValue()));
                if(recordExist)
                {
                    Ext.Msg.show({
                        title:tituloCgg_kdx_compra,
                        msg: 'El tipo de espcecie seleccionado ya esta establecido.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.WARNING
                    });
                    grdCgg_kdx_compra_detalle.getStore().remove(inRecord);
                }
            },
            canceledit:function(inRowEditor,inFlag){
                var inRecord= grdCgg_kdx_compra_detalle.getStore().getAt(0);
                if(inRecord.get('CKCMD_CODIGO') == 'KEYGEN')
                {
                    if (inRecord.get('CKESP_CODIGO').length == 0 && inRecord.get('CKCMD_CANTIDAD').length == 0)
                    {
                        grdCgg_kdx_compra_detalle.getStore().remove(inRecord);
                    }
                }
            }
        }
    });

    var txtEditorCantidad = new Ext.form.TextField({
        id:'txtEditorCantidad',
        allowBlank :false
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
                if (isEdit)
                {
                    gsCgg_kdx_compra_detalle.reload({
                        params:{
                            inCkcmp_codigo:inRecordCgg_kdx_compra.get('CKCMP_CODIGO'),
                            format:TypeFormat.JSON
                        }
                    })
                }
            }
        }
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DEL ESTADO CIVIL
     */
    var cbxEditorTipoEspecie = new Ext.form.ComboBox({
        store: gsCgg_kdx_especie,
        displayField:'CKESP_NOMBRE',
        typeAhead: true,
        lazyRender:true,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione un tipo especie',
        selectOnFocus:true,
        //tpl: '<tpl for="."><div ext:qtip="{CRECV_DESCRPCION}. {CRECV_DESCRPCION}" class="x-combo-list-item">{CRECV_DESCRPCION}</div></tpl>
        valueField:'CKESP_CODIGO'

    });
    gsCgg_kdx_especie.load();



    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_kdx_compra_detalle.
     */
    var cmCgg_kdx_compra_detalle = new Ext.grid.ColumnModel([
        {dataIndex:'CKCMD_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CKCMP_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CKESP_CODIGO',header:'Tipo especie',width:250,sortable:true,editor:cbxEditorTipoEspecie,
            renderer:function(value,metadata,record)
            {
                if (value)
                {

                    var rTipoEspecie= gsCgg_kdx_especie.getAt(gsCgg_kdx_especie.findExact('CKESP_CODIGO',value));
                    record.set('CKCMD_PRECIO_UNITARIO',rTipoEspecie.get('CKESP_PRECIO'));
                    if (cantidadCompra)
                    {
                        record.set('CKCMD_CANTIDAD',cantidadCompra);
                        record.set('CKCMD_TOTAL',record.get('CKCMD_PRECIO_UNITARIO')*cantidadCompra);
                        txtCkcmp_total.setValue(record.get('CKCMD_PRECIO_UNITARIO')*cantidadCompra);
                    }
                    else
                    {
                        txtCkcmp_serie.setValue(record.get('CKCMD_SERIE_INICIO'));
                        txtCkcmp_serie_fin.setValue(record.get('CKCMD_SERIE_FIN'));
                    }
                    return rTipoEspecie.data.CKESP_NOMBRE;
                }
                return value;
            }
        },
        {dataIndex:'CKCMD_SERIE_INICIO',header:'Serie Inicio',width:150,sortable:true,hidden:true},
        {dataIndex:'CKCMD_SERIE_FIN',header:'Serie Fin',width:150,sortable:true,hidden:true},
        {dataIndex:'CKCMD_CANTIDAD',header:'Cantidad',width:150,sortable:true/*,editor:txtEditorCantidad,
         renderer: function(value,metadata,record)
         {
         if (value)
         {
         record.set('CKCMD_TOTAL',record.get('CKCMD_PRECIO_UNITARIO')*value);
         }
         return value;
         }*/
        },
        {dataIndex:'CKCMD_PRECIO_UNITARIO',header:'Precio unitario',width:150,sortable:true},
        {dataIndex:'CKCMD_TOTAL',header:'Total',width:150,sortable:true}]);


    /*{CKCMD_CODIGO&quot;:&quot;CKCMD2&quot;,
     CKCMD_USUARIO_UPDATE&quot;:null,
     CKESP_CODIGO&quot;:&quot;CKESP1&quot;,&quot;
     CKCMD_ESTADO&quot;:true,&quot;
     CKCMD_SERIE_INICIO&quot;:120001,&quot;
     CKCMD_TOTAL&quot;:&quot;300000&quot;,&quot;
     CKCMD_PRECIO_UNITARIO&quot;:&quot;10&quot;,&quot;
     CKCMD_CANTIDAD&quot;:30000,&quot;
     CKCMD_USUARIO_INSERT&quot;:null,&quot;
     CKCMD_SERIE_FIN&quot;:150000,&quot;
     CKCMP_CODIGO&quot;:&quot;CKCMP2&quot;}*/
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_kdx_compra_detalle por un campo especifico.
     */
    var gsCgg_kdx_compra_detalle = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_compra_detalle",
            method:"selectCompraDetalleByCompra",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
        },[
            {name:'CKCMD_CODIGO'},
            {name:'CKCMP_CODIGO'},
            {name:'CKESP_CODIGO'},
            {name:'CKCMD_SERIE_INICIO'},
            {name:'CKCMD_SERIE_FIN'},
            {name:'CKCMD_CANTIDAD'},
            {name:'CKCMD_PRECIO_UNITARIO'},
            {name:'CKCMD_TOTAL'}
        ]),
        //sortInfo:{field: 'CKCMP_CODIGO', direction: 'ASC'},
        baseParams:{inCkcmp_codigo:'',format:'JSON'}
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_kdx_compra_detalle en un formato tabular de filas y columnas.
     */
    var grdCgg_kdx_compra_detalle = new Ext.grid.EditorGridPanel({
    	title:'Detalle',
        cm:cmCgg_kdx_compra_detalle,
        store:gsCgg_kdx_compra_detalle,
        region:'center',
        anchor:'100% 100%',
        viewConfig:{forceFit:true},
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        plugins:[reDetalleCompra],
        tbar:[{id:'btnKdxCompraIngreso',
                iconCls:'iconNuevo',
                listeners:{
                    click:function(){
                        if ( txtCkcmp_serie.getValue() && txtCkcmp_serie_fin.getValue()&&cantidadCompra>0)
                        {
                            var tmpRecordDetalleVenta = grdCgg_kdx_compra_detalle.getStore().recordType;
                            reDetalleCompra.stopEditing();
                            grdCgg_kdx_compra_detalle.getStore().insert(0,
                                    new tmpRecordDetalleVenta({
                                        CKCMD_CODIGO: 'KEYGEN',
                                        CKCMP_CODIGO:'',
                                        CKESP_CODIGO: '',
                                        CKCMD_SERIE_INICIO:txtCkcmp_serie.getValue(),
                                        CKCMD_SERIE_FIN: txtCkcmp_serie_fin.getValue(),
                                        CKCMD_CANTIDAD: cantidadCompra,
                                        CKCMD_PRECIO_UNITARIO: 0,
                                        CKCMD_TOTAL: 0
                                    })
                                    );
                            grdCgg_kdx_compra_detalle.getView().refresh();
                            grdCgg_kdx_compra_detalle.getSelectionModel().selectRow(0);
                            reDetalleCompra.startEditing(0);
                            Ext.getCmp('btnKdxCompraIngreso').setDisabled(true);
                            Ext.getCmp('btnKdxCompraEliminar').setDisabled(false);
                        }
                        else
                        {
                            Ext.Msg.show({
                                title:tituloCgg_kdx_compra,
                                msg: 'Es necesario definir la serie de compra de las especies!!!.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                            txtCkcmp_serie.focus();
                        }

                    }
                }
            },
            {id:'btnKdxCompraEliminar',
            	disabled:true,
                iconCls:'iconEliminar',
                listeners:{
                    click:function(){
                    	Ext.getCmp('btnKdxCompraIngreso').setDisabled(false);
                    	Ext.getCmp('btnKdxCompraEliminar').setDisabled(true);
                    	gsCgg_kdx_compra_detalle.removeAt(0);
                        /* if(grdCgg_kdx_usuario_pv.getSelectionModel().getSelected().get('CKUPV_CODIGO') != 'KEYGEN')
                         {

                         function SWRCgg_kdx_usuario_pv(btn){if (btn=='yes'){
                         try{
                         function CallBackCgg_kdx_usuario_pv(r){
                         winFrmCgg_kdx_punto_venta.getEl().unmask();
                         if(r=='true'){
                         grdCgg_kdx_usuario_pv.stopEditing();
                         grdCgg_kdx_usuario_pv.getStore().remove(grdCgg_kdx_usuario_pv.getSelectionModel().getSelected());
                         grdCgg_kdx_usuario_pv.getView().refresh();
                         grdCgg_kdx_usuario_pv.getSelectionModel().selectRow(0);
                         //gsCgg_kdx_usuario_pv.reload();
                         }else{
                         Ext.Msg.show({
                         title:tituloCgg_kdx_punto_venta,
                         msg: 'La informaci\u00f3n de usuario no ha podido ser eliminada.',
                         buttons: Ext.Msg.OK,
                         icon: Ext.MessageBox.ERROR
                         });
                         }}
                         winFrmCgg_kdx_punto_venta.getEl().mask('Eliminando...', 'x-mask-loading');
                         var param = new SOAPClientParameters();
                         param.add('inCkupv_codigo',grdCgg_kdx_usuario_pv.getSelectionModel().getSelected().get('CKUPV_CODIGO'));
                         SOAPClient.invoke(URL_WS+"Cgg_kdx_usuario_pv","delete",param, true, CallBackCgg_kdx_usuario_pv);
                         }catch(inErr){
                         winFrmCgg_kdx_punto_venta.getEl().unmask();
                         }}}
                         Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_kdx_usuario_pv,icon: Ext.MessageBox.QUESTION});
                         }
                         else
                         {
                         grdCgg_kdx_usuario_pv.stopEditing();
                         grdCgg_kdx_usuario_pv.getStore().remove(grdCgg_kdx_usuario_pv.getSelectionModel().getSelected());
                         grdCgg_kdx_usuario_pv.getView().refresh();
                         grdCgg_kdx_usuario_pv.getSelectionModel().selectRow(0);
                         }*/

                    }}
            }
        ]
    });

    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_kdx_compra.
     */
    var pnlCgg_kdx_compra = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        region:'north',
        layout:'form',
        height:185,
        items:[{
            xtype:'fieldset',
            title:'Datos factura',
            items:[
                {
                    xtype:'panel',
                    layout:'column',
                    items:[
                        {
                            columnWidth:.55,
                            layout:'form',
                            items:[txtCkcmp_factura]
                        },
                        {
                            columnWidth:.45,
                            layout:'form',
                            items:[dtCkcmp_fecha_ingreso]
                        }
                    ]
                },
                txtCkcmp_codigo,
                numCkcmp_lote,
                txtCkcmp_serie,
                txtCkcmp_serie_fin,
                txtCkcmp_procedencia
            ]
        }]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_kdx_compra.
     */
    var winFrmCgg_kdx_compra = new Ext.Window({
        id:'winFrmCgg_kdx_compra',
        title:tituloCgg_kdx_compra,
        width:600,
        minWidth:550,
        height:450,
        maximizable:true,
        minimizable:true,
        layout:'border',
        constrain:true,
        tbar:getPanelTitulo(tituloCgg_kdx_compra,descCgg_kdx_compra),
        items:[pnlCgg_kdx_compra,grdCgg_kdx_compra_detalle],
        bbar:[btnGuardarCgg_kdx_compra,btnCancelarCgg_kdx_compra,'->',btnCerrarCgg_kdx_compra]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_kdx_compra.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_kdx_compraCtrls(inEstado){
        estado=!inEstado;
        txtCkcmp_codigo.setDisabled(estado);
        numCkcmp_lote.setDisabled(estado);
        dtCkcmp_fecha_ingreso.setDisabled(estado);
        txtCkcmp_serie.setDisabled(estado);
        txtCkcmp_procedencia.setDisabled(estado);
        numCkcmp_cantidad.setDisabled(estado);
        txtCkcmp_factura.setDisabled(estado);
        txtCkcmp_total.setDisabled(estado);
        btnGuardarCgg_kdx_compra.setDisabled(true);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_kdx_compra.
     */
    function cargarCgg_kdx_compraCtrls(){
        if(inRecordCgg_kdx_compra){
            txtCkcmp_codigo.setValue(inRecordCgg_kdx_compra.get('CKCMP_CODIGO'));
            numCkcmp_lote.setValue(inRecordCgg_kdx_compra.get('CKCMP_LOTE'));
            dtCkcmp_fecha_ingreso.setValue(truncDate(inRecordCgg_kdx_compra.get('CKCMP_FECHA_INGRESO')));
            txtCkcmp_serie.setValue(inRecordCgg_kdx_compra.get('CKCMP_SERIE'));
            txtCkcmp_procedencia.setValue(inRecordCgg_kdx_compra.get('CKCMP_PROCEDENCIA'));
            numCkcmp_cantidad.setValue(inRecordCgg_kdx_compra.get('CKCMP_CANTIDAD'));
            txtCkcmp_factura.setValue(inRecordCgg_kdx_compra.get('CKCMP_FACTURA'));
            txtCkcmp_total.setValue(inRecordCgg_kdx_compra.get('CKCMP_TOTAL'));
            isEdit = true;
            habilitarCgg_kdx_compraCtrls(true);
            gsCgg_kdx_especie.load();
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_kdx_compra.
     * @returns ventana winFrmCgg_kdx_compra.
     * @base FrmCgg_kdx_compra.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_kdx_compra;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_kdx_compra.
     * @base FrmCgg_kdx_compra.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_kdx_compraCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_kdx_compra desde una instancia.
 */
FrmCgg_kdx_compra.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_kdx_compra desde una instancia.
 */
FrmCgg_kdx_compra.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_kdx_compra,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_kdx_compra.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_kdx_compra desde una instancia.
 */
FrmCgg_kdx_compra.prototype.loadData = function(){
    this.loadData();
}
