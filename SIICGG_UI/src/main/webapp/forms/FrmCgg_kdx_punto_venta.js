/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_kdx_punto_venta.
 * @param {String} IN_SENTENCIA_CGG_KDX_PUNTO_VENTA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_KDX_PUNTO_VENTA Registro de datos de la tabla Cgg_kdx_punto_venta.
 * @constructor
 * @base FrmListadoCgg_kdx_punto_venta
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_kdx_punto_venta(IN_SENTENCIA_CGG_KDX_PUNTO_VENTA,IN_RECORD_CGG_KDX_PUNTO_VENTA){
    var inSentenciaCgg_kdx_punto_venta = IN_SENTENCIA_CGG_KDX_PUNTO_VENTA;
    var inRecordCgg_kdx_punto_venta=IN_RECORD_CGG_KDX_PUNTO_VENTA;
    var urlCgg_kdx_punto_venta=URL_WS+"Cgg_kdx_punto_venta";
    var tituloCgg_kdx_punto_venta='Punto de venta especies';
    var descCgg_kdx_punto_venta='El formulario permite administrar la informaci\u00f3n de Puntos de venta de especies';
    var isEdit = false;

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA
     */
    var txtCkpvt_codigo = new Ext.form.TextField({
        id:'txtCkpvt_codigo',
        name:'txtCkpvt_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CANTON / CIUDAD
     */
    var txtCctn_codigo = new Ext.form.TextField({
        id:'txtCctn_codigo',
        name:'txtCctn_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CANTON / CIUDAD
     */
    var txtCctn_nombre = new Ext.form.TextField({
        id:'txtCctn_nombre',
        name:'txtCctn_nombre',
        fieldLabel :'Ciudad',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE CANTON / CIUDAD
     */
    var btnCctn_codigoCgg_kdx_punto_venta = new Ext.Button({
        id:'btnCctn_codigoCgg_kdx_punto_venta',
        text:'Ciudad',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_canton = new FrmListadoCgg_canton();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_canton.getStore(),tmpFLCgg_canton.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                    {
                        txtCctn_codigo.setValue(tmpRecord.get('CCTN_CODIGO'));
                        txtCctn_nombre.setValue(tmpRecord.get('CCTN_NOMBRE'));
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField NOMBRE DEL PUNTO DE VENTA
     */
    var txtCkpvt_nombre = new Ext.form.TextField({
        id:'txtCkpvt_nombre',
        name:'txtCkpvt_nombre',
        fieldLabel :'Nombre',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Ext.form.TextField OBSERVACION DEL PUNTO DE VENTA
     */
    var txtCkpvt_observacion = new Ext.form.TextArea({
        id:'txtCkpvt_observacion',
        name:'txtCkpvt_observacion',
        fieldLabel :'Observacion',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_kdx_punto_venta
     */
    var btnGuardarCgg_kdx_punto_venta = new Ext.Button({
        id:'btnGuardarCgg_kdx_punto_venta',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:TypeTooltip.GUARDAR,
        listeners:{
            click:function(){
                if (validarDatos()==false){
                    return;
                }
                try{
                    if (grdCgg_kdx_usuario_pv.getStore().getCount()>0)
                    {
                        guardarPuntoVenta();
                    }
                    else
                    {
                        function SWRCgg_kdx_usuario_pv(btn){
                            if (btn=='yes'){
                                guardarPuntoVenta();
                            }
                        }
                        Ext.Msg.show({
                            title:'Aviso',
                            msg:'No se ha asignado usuarios al punto de venta. \n Est\u00e1 seguro que desea continuar?',
                            buttons: Ext.Msg.YESNO,
                            fn: SWRCgg_kdx_usuario_pv,
                            icon: Ext.MessageBox.QUESTION
                        });


                    }

                }catch(inErr){
                    winFrmCgg_kdx_punto_venta.getEl().unmask();
                }
            }}
    });

    function guardarPuntoVenta()
    {
        try
        {
            function CallBackCgg_kdx_punto_venta(r){
                winFrmCgg_kdx_punto_venta.getEl().unmask();
                if(r=='true'){
                    Ext.Msg.show({
                        title:tituloCgg_kdx_punto_venta,
                        msg: 'La informaci\u00f3n de Punto de venta ha sido almacenada.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.INFO
                    });winFrmCgg_kdx_punto_venta.close()
                }else{
                    Ext.Msg.show({
                        title:tituloCgg_kdx_punto_venta,
                        msg: 'La informaci\u00f3n de Punto de venta no ha podido ser almacenada. '+r,
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.ERROR
                    });
                }
            }
            winFrmCgg_kdx_punto_venta.getEl().mask('Guardando...', 'x-mask-loading');
            var param = new SOAPClientParameters();
            if(isEdit)
                param.add('inCkpvt_codigo',txtCkpvt_codigo.getValue());
            param.add('inCctn_codigo',txtCctn_codigo.getValue());
            param.add('inCkpvt_nombre',txtCkpvt_nombre.getValue());
            param.add('inCkpvt_observacion',txtCkpvt_observacion.getValue());
            param.add('inUsuarioPuntoVenta_JSON',grdCgg_kdx_usuario_pv.getStore().getJsonData());
            SOAPClient.invoke(urlCgg_kdx_punto_venta,IN_SENTENCIA_CGG_KDX_PUNTO_VENTA+'1',param, true, CallBackCgg_kdx_punto_venta);
        }catch(inErr){
            winFrmCgg_kdx_punto_venta.getEl().unmask();
        }
    }
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_kdx_punto_venta.
     */
    var btnCancelarCgg_kdx_punto_venta = new Ext.Button({
        id:'btnCancelarCgg_kdx_punto_venta',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:TypeTooltip.CANCELAR,
        listeners:{
            click:function(){
                pnlCgg_kdx_punto_venta.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_kdx_punto_venta.
     */
    var btnCerrarCgg_kdx_punto_venta = new Ext.Button({
        id:'btnCerrarCgg_kdx_punto_venta',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:TypeTooltip.CERRAR,
        listeners:{
            click:function(){
                winFrmCgg_kdx_punto_venta.close();
            }}
    });
    var cbcCKPVT_ACTIVO =  new Ext.grid.CheckColumn({
        dataIndex:'CKPVT_ACTIVO',
        header:'Activo',
        width:90
    });
    var cbcCKUPV_SUPERVISOR =  new Ext.grid.CheckColumn({
        dataIndex:'CKUPV_SUPERVISOR',
        header:'Supervisor',
        width:90,
        value:false
    });
    ///
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_kdx_usuario_pv.
     */
    var cmCgg_kdx_usuario_pv = new Ext.grid.ColumnModel([
        {dataIndex:'CKUPV_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CKPVT_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CUSU_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CUSU_NOMBRE_USUARIO',header:'Identificaci\u00f3n',width:150,sortable:true},
        {dataIndex:'CRPER_NOMBRES',header:'Nombre',width:150,sortable:true},
        cbcCKPVT_ACTIVO,
        cbcCKUPV_SUPERVISOR
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_kdx_usuario_pv por un campo especifico.
     */
    var gsCgg_kdx_usuario_pv = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_usuario_pv",
            method:"selectUsuarioPuntoVenta",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
        },[
            {name:'CKUPV_CODIGO'},
            {name:'CKPVT_CODIGO'},
            {name:'CUSU_CODIGO'},
            {name:'CKPVT_ACTIVO'},
            {name:'CKUPV_SUPERVISOR'},
            {name:'CUSU_NOMBRE_USUARIO'},
            {name:'CRPER_NOMBRES'}
        ]),
        //sortInfo:{field: 'CKPVT_CODIGO', direction: 'ASC'},
        baseParams:{inCkpvt_codigo:"",format:TypeFormat.JSON}
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_kdx_usuario_pv en un formato tabular de filas y columnas.
     */
    var grdCgg_kdx_usuario_pv = new Ext.grid.GridPanel({
        cm:cmCgg_kdx_usuario_pv,
        store:gsCgg_kdx_usuario_pv,
        region:'center',
        anchor:'100% 100%',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        viewConfig:{forceFit:true},
        plugins:[cbcCKPVT_ACTIVO,cbcCKUPV_SUPERVISOR],
        loadMask:{msg:"Cargando..."},
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                /*if(!btnEditarCgg_kdx_usuario_pv.disabled){
                 btnEditarCgg_kdx_usuario_pv.fireEvent('click', btnEditarCgg_kdx_usuario_pv);
                 }*/
            }}});

    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_kdx_punto_venta.
     */
    var pnlCgg_kdx_punto_venta_datos = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        region:'north',
        height:130,
        //frame:true,
        //layout:'form',
        items:[
            txtCkpvt_codigo,
            txtCkpvt_nombre,
            {
                xtype:'panel',layout:'column',items:[
                {columnWidth:.6,layout:'form',items:[txtCctn_nombre]},
                {columnWidth:.4,layout:'form',items:[btnCctn_codigoCgg_kdx_punto_venta]}]
            },
            txtCkpvt_observacion
        ]
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_kdx_punto_venta.
     */
    var  pnlCgg_kdx_punto_venta_usuarios = new Ext.Panel({
        title:'Usuarios punto de venta',
        region:'center',
        layout:'border',
        items:[grdCgg_kdx_usuario_pv],
        tbar:[
            {
                iconCls:'iconNuevo',
                listeners:{
                    click:function(){
                        var tmpUsuarioAsignado;
                        var tmpPuntoVentaUsuario = new FrmListadoCgg_usuario();
                        var objBusquedaUsuario = new DlgBusqueda(tmpPuntoVentaUsuario.getStore(),tmpPuntoVentaUsuario.getColumnModel());
                        objBusquedaUsuario.closeHandler(function(){
                            var tmpRecordUsuario = objBusquedaUsuario.getSelectedRow();

                            if(tmpRecordUsuario)
                            {
                                var tmpUsuarioExist = gsCgg_kdx_usuario_pv.getAt(gsCgg_kdx_usuario_pv.findExact('CUSU_CODIGO',tmpRecordUsuario.get('CUSU_CODIGO')));
                                if (!tmpUsuarioExist)
                                {
                                    tmpUsuarioAsignado = verificarUsuarioPuntoVenta( tmpRecordUsuario.get('CUSU_NOMBRE_USUARIO'));
                                    if(tmpUsuarioAsignado =='true')
                                    {
                                        var tmpRecordPuntoVentaUsuario = grdCgg_kdx_usuario_pv.getStore().recordType;
                                        grdCgg_kdx_usuario_pv.getStore().insert(0,
                                                new tmpRecordPuntoVentaUsuario({
                                                    CKUPV_CODIGO: 'KEYGEN',
                                                    CKPVT_CODIGO:'',
                                                    CUSU_CODIGO: tmpRecordUsuario.get('CUSU_CODIGO'),
                                                    CUSU_NOMBRE_USUARIO: tmpRecordUsuario.get('CUSU_NOMBRE_USUARIO'),
                                                    CRPER_NOMBRES: tmpRecordUsuario.get('CRPER_NOMBRES') + ' '+ tmpRecordUsuario.get('CRPER_APELLIDO_PATERNO'),
                                                    CKPVT_ACTIVO: true,
                                                    CKUPV_SUPERVISOR:false
                                                })
                                                );
                                        grdCgg_kdx_usuario_pv.getView().refresh();
                                    }
                                    else
                                    {
                                         Ext.Msg.show({
                                                title:tituloCgg_kdx_punto_venta,
                                                msg: 'El usuario ' + tmpRecordUsuario.get('CRPER_NOMBRES') + ' '+ tmpRecordUsuario.get('CRPER_APELLIDO_PATERNO') +' ya se halla registrado en otro Punto de Venta.' ,
                                                buttons: Ext.Msg.OK,
                                                icon: Ext.MessageBox.ERROR
                                            });
                                    }
                                }
                            }
                        });
                        objBusquedaUsuario.show();
                    }
                }
            },
            {
                iconCls:'iconEliminar',
                listeners:{
                    click:function(){
                        if(grdCgg_kdx_usuario_pv.getSelectionModel().getSelected().get('CKUPV_CODIGO') != 'KEYGEN')
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
                                    SOAPClient.invoke(URL_WS+"Cgg_kdx_usuario_pv","deleteTrusted",param, true, CallBackCgg_kdx_usuario_pv);
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
                        }

                    }}
            }
        ]
    });


    function verificarUsuarioPuntoVenta(inUserName)
    {
        var tmpResult;
        var param = new SOAPClientParameters();
        param.add('inUserName',inUserName);
        tmpResult = SOAPClient.invoke(URL_WS+"Cgg_kdx_usuario_pv","verificarUsuarioAsignado",param, false, false);
        return tmpResult;
    }
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_kdx_punto_venta.
     */
    var winFrmCgg_kdx_punto_venta = new Ext.Window({
        id:'winFrmCgg_kdx_punto_venta',
        title:tituloCgg_kdx_punto_venta,
        width:500,
        minWidth:450,
        height:450,
        maximizable:false,
        minimizable:false,
        layout:'border',
        constrain:true,
        modal:true,
        tbar:getPanelTitulo(tituloCgg_kdx_punto_venta,descCgg_kdx_punto_venta),
        items:[pnlCgg_kdx_punto_venta_datos,pnlCgg_kdx_punto_venta_usuarios],
        bbar:[btnGuardarCgg_kdx_punto_venta,btnCancelarCgg_kdx_punto_venta,'->',btnCerrarCgg_kdx_punto_venta]
    });
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_kdx_punto_venta.
     */
    function cargarCgg_kdx_punto_ventaCtrls(){
        if(inRecordCgg_kdx_punto_venta){
            txtCkpvt_codigo.setValue(inRecordCgg_kdx_punto_venta.get('CKPVT_CODIGO'));
            txtCctn_codigo.setValue(inRecordCgg_kdx_punto_venta.get('CCTN_CODIGO'));
            var rCiudad=SCGG_CANTON.getAt(SCGG_CANTON.findExact('CCTN_CODIGO',inRecordCgg_kdx_punto_venta.get('CCTN_CODIGO')));
            txtCctn_nombre.setValue(rCiudad.get('CCTN_NOMBRE'));
            txtCkpvt_nombre.setValue(inRecordCgg_kdx_punto_venta.get('CKPVT_NOMBRE'));
            txtCkpvt_observacion.setValue(inRecordCgg_kdx_punto_venta.get('CKPVT_OBSERVACION'));
            isEdit = true;
            gsCgg_kdx_usuario_pv.reload({params:{
                inCkpvt_codigo:inRecordCgg_kdx_punto_venta.get('CKPVT_CODIGO'),
                format:TypeFormat.JSON
            }
            });
        }}
    function validarDatos()
    {
        if (pnlCgg_kdx_punto_venta_datos.getForm().isValid() == false)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_kdx_punto_venta.
     * @returns ventana winFrmCgg_kdx_punto_venta.
     * @base FrmCgg_kdx_punto_venta.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_kdx_punto_venta;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_kdx_punto_venta.
     * @base FrmCgg_kdx_punto_venta.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_kdx_punto_ventaCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_kdx_punto_venta desde una instancia.
 */
FrmCgg_kdx_punto_venta.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_kdx_punto_venta desde una instancia.
 */
FrmCgg_kdx_punto_venta.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_kdx_punto_venta,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_kdx_punto_venta.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_kdx_punto_venta desde una instancia.
 */
FrmCgg_kdx_punto_venta.prototype.loadData = function(){
    this.loadData();
}

