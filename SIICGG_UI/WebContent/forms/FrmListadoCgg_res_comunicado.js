/* *
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_comunicado.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_comunicado(inDesktop){
    var optMenu = 'Control de Residencia/Comunicaciones';
    var urlListadoCgg_res_comunicado = URL_WS + "Cgg_res_comunicado";
    var tituloListadoCgg_res_comunicado = 'Listado de comunicaciones';
    var descListadoCgg_res_comunicado = 'El formulario permite administrar informaci\u00f3n de comunicaciones u oficios recibidos.';
    /* *
    * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_comunicado.
    */
    var btnNuevoCgg_res_comunicado = new Ext.Button({
        id : 'btnNuevoCgg_res_comunicado',
        text : 'Nuevo',
        iconCls : 'iconNuevo',
        listeners : {
            click : function(){
                var objCgg_res_comunicado = new FrmCgg_res_comunicado("insert");
                objCgg_res_comunicado.closeHandler(function(){
                    gsCgg_res_comunicado.reload();
                }
                );
                objCgg_res_comunicado.show();
            }
        }
    }
    );
    /* *
    * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_comunicado.
    */
    var btnEditarCgg_res_comunicado = new Ext.Button({
        id : 'btnEditarCgg_res_comunicado',
        text : 'Editar',
        iconCls : 'iconEditar',
        listeners : {
            click : function(){
                var r = grdCgg_res_comunicado.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_comunicado = new FrmCgg_res_comunicado("update", r);
                    objCgg_res_comunicado.closeHandler(function(){
                        gsCgg_res_comunicado.reload();
                    }
                    );
                    objCgg_res_comunicado.loadData();
                    objCgg_res_comunicado.show();
                }
            }
        }
    }
    );
    /* *
    * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_comunicado.
    */
    var btnEliminarCgg_res_comunicado = new Ext.Button({
        id : 'btnEliminarCgg_res_comunicado',
        text : 'Eliminar',
        iconCls : 'iconEliminar',
        listeners : {
            click : function(){
                Ext.Msg.show({
                    title : 'Aviso', msg : 'Seguro de eliminar el registro seleccionado?', buttons : Ext.Msg.YESNO, fn : SWRCgg_res_comunicado, icon : Ext.MessageBox.QUESTION
                }
                );
                function SWRCgg_res_comunicado(btn){
                    if (btn == 'yes'){
                        try{
                            function CallBackCgg_res_comunicado(r){
                                winFrmListadoCgg_res_comunicado.getEl().unmask();
                                if(r == 'true'){
                                    Ext.Msg.show({
                                        title : tituloListadoCgg_res_comunicado,
                                        msg : 'La informaci\u00f3n de la comunicaci\u00f3n ha sido eliminada.',
                                        buttons : Ext.Msg.OK,
                                        icon : Ext.MessageBox.INFO
                                    }
                                    );
                                    gsCgg_res_comunicado.reload();
                                }
                                else{
                                    Ext.Msg.show({
                                        title : tituloListadoCgg_res_comunicado,
                                        msg : 'La informaci\u00f3n de la comunicaci\u00f3n no ha podido ser eliminada.',
                                        buttons : Ext.Msg.OK,
                                        icon : Ext.MessageBox.ERROR
                                    }
                                    );
                                }
                            }
                            winFrmListadoCgg_res_comunicado.getEl().mask('Eliminando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCrcom_codigo', grdCgg_res_comunicado.getSelectionModel().getSelected().get('CRCOM_CODIGO'));
                            SOAPClient.invoke(urlListadoCgg_res_comunicado, "delete", param, true, CallBackCgg_res_comunicado);
                        }
                        catch(inErr){
                            winFrmListadoCgg_res_comunicado.getEl().unmask();
                        }
                    }
                }
            }
        }
    }
    );
    /**
    * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_comunicado.
    */
    var btnSalirCgg_res_comunicado = new Ext.Button({
        id : 'btnSalirCgg_res_comunicado',
        text : 'Salir',
        iconCls : 'iconSalir',
        listeners : {
            click : function(){
                winFrmListadoCgg_res_comunicado.close();
            }
        }
    }
    );
   
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_adjunto.
	*/
var btnVerCgg_res_adjunto = new Ext.Button({
    id:'btnVerCgg_res_adjunto',
    text:'Ver',
    iconCls:'iconVer',
    listeners:{
        click:function(){
            var r=grdCgg_res_comunicado.getSelectionModel().getSelected();
            if(r)
                window.open(URL_DOC_VIEWER+'?table=Cgg_res_comunicado&keyc=crcom_codigo&keyv='+r.get('CRCOM_CODIGO')+'&column=crcom_adjunto&fn='+r.get('CRCOM_NOMBRE_ADJUNTO')+'&request=view');
        }
    }
});
/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_adjunto.
	*/
var btnDescargarCgg_res_adjunto = new Ext.Button({
    id:'btnDescargarCgg_res_adjunto',
    text:'Descargar',
    iconCls:'iconDescargar',
    listeners:{
        click:function(){
            var r=grdCgg_res_comunicado.getSelectionModel().getSelected();
            if(r)
                window.open(URL_DOC_VIEWER+'?table=Cgg_res_comunicado&keyc=crcom_codigo&keyv='+r.get('CRCOM_CODIGO')+'&column=crcom_adjunto&fn='+r.get('CRCOM_NOMBRE_ADJUNTO')+'&request=download');
        }
    }
});
    /* *
    * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_comunicado.
    */
    var cmCgg_res_comunicado = new Ext.grid.ColumnModel([
        {dataIndex : 'CRCOM_DESTINATARIO', header : 'Destinatario', width : 180, sortable : true},
		{dataIndex : 'CRCOM_REMITENTE', header : 'Remitente', width : 180, sortable : true},
        {dataIndex : 'CRCOM_ASUNTO', header : 'Asunto', width : 150, sortable : true},
        {dataIndex : 'CRCOM_FECHA_RECEPCION', header : 'Fecha recepci\u00f3n', width : 80, sortable : true,renderer:truncDate},
        {dataIndex : 'CRCOM_FECHA_REVISION', header : 'Fecha revisi\u00f3n', width : 80, sortable : true,renderer:truncDate},
        {dataIndex : 'CRCOM_NUMERO_DOCUMENTO', header : 'No. documento', width : 80, sortable : true},
		{dataIndex : 'CRRES_NUMERO_RESOLUCION', header : 'No. Resolucion', width : 80, sortable : true},
        {dataIndex : 'CRCOM_DESCRIPCION', header : 'Descripci\u00f3n', width : 150, sortable : true}
    ]);
    /* *
    * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_comunicado por un campo especifico.
    * 
    */
    var gsCgg_res_comunicado = new Ext.data.Store({
        proxy : new Ext.ux.bsx.SoapProxy({
            url : URL_WS + "Cgg_res_comunicado",
            method : "selectPageRemitenteAll"
        }
        ),
        remoteSort : true,
        reader : new Ext.data.JsonReader({
            id : 'CRCOM_CODIGO',
            root : 'dataSet',
            totalProperty : 'totalCount'
        }
        , [
        {name : 'CRCOM_CODIGO'},
        {name : 'CRRES_CODIGO'},
        {name : 'CRRES_NUMERO_RESOLUCION'},
        {name : 'CRPER_CODIGO'},
        {name : 'CGG_CRPER_CODIGO'},
        {name : 'CRCOM_REMITENTE'},
        {name : 'CRCOM_DESTINATARIO'},
        {name : 'CRCOM_ASUNTO'},
        {name : 'CRCOM_FECHA_RECEPCION'},
        {name : 'CRCOM_FECHA_REVISION'},
        {name : 'CRCOM_NUMERO_DOCUMENTO'},
        {name : 'CRCOM_DESCRIPCION'},
        {name : 'CRCOM_NOMBRE_ADJUNTO'},
		{name : 'CRCOM_OBSERVACION'},
		{name : 'CRCOM_DESCRIPCION_ADJUNTO'},
        {name : 'CRCOM_ESTADO_COMUNICADO'}       
        ]),
        sortInfo : {
            field : 'CRRES_CODIGO', direction : 'ASC'
        }
        ,
        baseParams : {
            keyword : "", format : TypeFormat.JSON
        }
    }
    );
    /* *
    * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_comunicado.
    */
    var pgBarCgg_res_comunicado = new Ext.PagingToolbar({
        store : gsCgg_res_comunicado,
        displayInfo : true,
        pageSize : RECORD_PAGE,
        displayMsg : 'Mostrando {0} - {1} de {2}',
        temptyMsg : 'No hay informaci\u00f3n para mostrar'
    }
    );
    /* *
    * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_comunicado en un formato tabular de filas y columnas.
    */
    var grdCgg_res_comunicado = new Ext.grid.GridPanel({
        cm : cmCgg_res_comunicado,
        store : gsCgg_res_comunicado,
        region : 'center',
        sm : new Ext.grid.RowSelectionModel({
            singleSelect : true
        }
        ),
        loadMask : {
            msg : "Cargando..."
        }
        ,
        tbar : [
        'Buscar: ',
        new Ext.ux.bsx.SearchField({
            store : gsCgg_res_comunicado,
            width : 200
        }
        )
        ],
        bbar : pgBarCgg_res_comunicado,
        listeners : {
            rowdblclick : function(inGridComponent, inRowIndex, inEventObject){
                if( ! btnEditarCgg_res_comunicado.disabled){
                    btnEditarCgg_res_comunicado.fireEvent('click', btnEditarCgg_res_comunicado);
                }
            }
        }
    }
    );
    gsCgg_res_comunicado.reload({
        params : {
            start : 0,
            limit : RECORD_PAGE,
            format : 'JSON'
        }
    }
    );
    /* *
    * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_comunicado.
    */
    if(inDesktop){
        var winFrmListadoCgg_res_comunicado = inDesktop.createWindow({
            id : 'winFrmListadoCgg_res_comunicado',
            title : tituloListadoCgg_res_comunicado,
            width : 600,
            minWidth : 600,
            height : 400,
            minHeight : 400,
            maximizable : true,
            minimizable : true,
            constrainHeader : true,
            layout : 'border',			
            tbar : getPanelTitulo(tituloListadoCgg_res_comunicado, descListadoCgg_res_comunicado),
            items : [grdCgg_res_comunicado],
            bbar : [btnNuevoCgg_res_comunicado, btnEditarCgg_res_comunicado, btnEliminarCgg_res_comunicado,'-',btnVerCgg_res_adjunto,btnDescargarCgg_res_adjunto, '->', btnSalirCgg_res_comunicado]
        }
        );
        /* *
        * Funcion que aplica los privilegios del usuario.
        */
        applyGrants(winFrmListadoCgg_res_comunicado.getBottomToolbar());
    }
    /* *
    * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_comunicado.
    * @returns ventana winFrmCgg_res_comunicado.
    * @base FrmListadoCgg_res_comunicado.prototype.show
    */
    this.getWindow = function(){
        return winFrmListadoCgg_res_comunicado;
    }
    /* *
    * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_comunicado.
    * @base FrmListadoCgg_res_comunicado.prototype.loadData
    */
    this.loadData = function(){
        gsCgg_res_comunicado.load();
    }
    /* *
    * Funcion miembro que develve el ColumnModel utilizado en el listado.
    */
    this.getColumnModel = function(){
        return cmCgg_res_comunicado;
    }
    /* *
    * Funcion miembro que develve el Store utilizado en el listado.
    */
    this.getStore = function(){
        return gsCgg_res_comunicado;
    }
}
/* *
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_comunicado.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/* *
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_comunicado.prototype.getStore = function(){
    this.getStore();
}
/* *
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_comunicado desde una instancia.
 */
FrmListadoCgg_res_comunicado.prototype.show = function(){
    this.getWindow().show();
}
/* *
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_comunicado desde una instancia.
 */
FrmListadoCgg_res_comunicado.prototype.close = function(){
    this.getWindow().close();
}
/* *
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_comunicado,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_comunicado.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close', inFunctionHandler);
}
/* *
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_comunicado desde una instancia.
 */
FrmListadoCgg_res_comunicado.prototype.loadData = function(){
    this.loadData();
}
