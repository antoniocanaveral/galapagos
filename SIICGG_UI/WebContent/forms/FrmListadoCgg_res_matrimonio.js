/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_matrimonio.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_matrimonio(inDesktop){
    var optMenu = 'Control de Residencia/Operativos de seguimiento/Matrimonio';
    var urlListadoCgg_res_matrimonio=URL_WS+"Cgg_res_matrimonio";
    var tituloListadoCgg_res_matrimonio='Matrimonio';
    var descListadoCgg_res_matrimonio='El formulario permite administrar informaci\u00f3n del Matrimonio';


    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_matrimonio.
     */
    var btnEditarCgg_res_matrimonio = new Ext.Button({
        id:'btnEditarCgg_res_matrimonio',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_res_matrimonio.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_matrimonio = new FrmCgg_res_matrimonio("update",r);
                    objCgg_res_matrimonio.loadMatrimonio(grdCgg_res_matrimonio.getSelectionModel().getSelected().get('CRMTR_CODIGO'));
                    objCgg_res_matrimonio.closeHandler(function(){
                        gsCgg_res_matrimonio.reload();
                    });
                    objCgg_res_matrimonio.loadData();
                    objCgg_res_matrimonio.show();
                }
                else{
                    Ext.MessageBox.alert(tituloListadoCgg_res_matrimonio, 'Seleccione un registro para continuar');
                }


            }
        }
    });
/**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_matrimonio.
     */
var btnSalirCgg_res_matrimonio = new Ext.Button({
    id:'btnSalirCgg_res_matrimonio',
    text:'Salir',
    iconCls:'iconSalir',
    listeners:{
        click:function(){
            winFrmListadoCgg_res_matrimonio.close();
        }
    }
});
/**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winCgg_res_informe_pareja.
     */
var btnListadoNuevoCgg_res_informe_pareja = new Ext.Button({
    id:'btnListadoNuevoCgg_res_informe_pareja',
    text:' Listado Informe',
    iconCls:'iconListado',
    listeners:{
        click:function(){
            var r=grdCgg_res_matrimonio.getSelectionModel().getSelected();
            if(r){
                var objListadoCgg_res_informe_pareja = new FrmListadoCgg_res_informe_pareja();
                objListadoCgg_res_informe_pareja.loadMatrimonio(grdCgg_res_matrimonio.getSelectionModel().getSelected().get('CRMTR_CODIGO'));
                objListadoCgg_res_informe_pareja.closeHandler(function(){
                    gsCgg_res_matrimonio.reload();
                });
                objListadoCgg_res_informe_pareja.show();
            }
            else{
                Ext.MessageBox.alert('Matrimimonio', 'Seleccione un registro para continuar');
            }
        }
    }
});

/**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winCgg_res_informe_pareja.
     */
var btnListadoNuevoCgg_res_informe_testigo= new Ext.Button({
    id:'btnListadoNuevoCgg_res_informe_testigo',
    text:'Listado Testigo',
    iconCls:'iconListado',
    listeners:{
        click:function(){
            var r=grdCgg_res_matrimonio.getSelectionModel().getSelected();
            if(r){
                var objListadoCgg_res_informe_testigo = new FrmListadoCgg_res_informe_testigo();
                objListadoCgg_res_informe_testigo.loadMatrimonio(grdCgg_res_matrimonio.getSelectionModel().getSelected().get('CRMTR_CODIGO'));
                objListadoCgg_res_informe_testigo.closeHandler(function(){
                    gsCgg_res_matrimonio.reload();
                });
                objListadoCgg_res_informe_testigo.show();
            }else{
                Ext.MessageBox.alert('Matrimimonio', 'Seleccione un registro para continuar');
            }
        }
    }
});
/*
     *  Ext.ux.grid.RowExpander Expandir fila
     **/
var expanderMatrimonio = new Ext.ux.grid.RowExpander({
    tpl : new Ext.XTemplate(
        '<SPAN style="color:blue"><b>Oficiales:</b><br></SPAN>',
        '<tpl for="OFICIALES">',
        '<table cborder="0" align="rigth">' +
        '<tbody>' +
        '<tr>' +
        '<td style="width:5%;"></td>' +
        '<td><b>{#}.</b>{CUSU_NOMBRES} {CUSU_APELLIDOS}</td>' +
        '</tr></tbody>' +
        '</table>',
        '</tpl>'
        )
});

/**
     /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_matrimonio.
     */
var cmCgg_res_matrimonio = new Ext.grid.ColumnModel([
    expanderMatrimonio,
    {
        dataIndex:'CRMTR_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CRTRA_CODIGO',
        header:'Crtra_codigo',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'RESIDENTE',
        header:'Residente',
        width:230,
        sortable:true
    },

    {
        dataIndex:'CONYUGE',
        header:'C\u00f3nyuge',
        width:230,
        sortable:true
    },

    {
        dataIndex:'CRTRA_NUMERO',
        header:'No. tramite',
        width:150,
        align:'right',
        sortable:true
    },

    {
        dataIndex:'CRMTR_FECHA_MATRIMONIO',
        header:'Fecha matrimonio',
        width:100,
        sortable:true,
        renderer:truncDate
    },

    {
        dataIndex:'CRMTR_TIPO',
        header:'Tipo',
        width:100,
        sortable:true, 
        renderer:function(inCrmtr_Tipo){
            if (inCrmtr_Tipo==1){
                return('MATRIMONIO')
            }else if (inCrmtr_Tipo==2)
            {
                return('UNI\u00D3N DE HECHO')
            }
            else
            {
                return ''
            }
        }
    }

]);
/**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_matrimonio por un campo especifico.
     */
var gsCgg_res_matrimonio = new Ext.data.Store({
    proxy:new Ext.ux.bsx.SoapProxy({
        url:URL_WS+"Cgg_res_matrimonio",
        method:"selectPage",
        pagin:true
    }),
    remoteSort:true,
    reader:new Ext.data.JsonReader({
        id:'CRMTR_CODIGO',
        root:'dataSet',
        totalProperty: 'totalCount'
    },[
    {
        name:'CRMTR_CODIGO'
    },

    {
        name:'CRTRA_CODIGO'
    },

    {
        name:'CRTRA_NUMERO'
    },

    {
        name:'RESIDENTE'
    },

    {
        name:'CONYUGE'
    },

    {
        name:'CRMTR_FECHA_MATRIMONIO'
    },

    {
        name:'OFICIALES'
    },

    {
        name:'CRMTR_TIPO'
    }

    ]),
    sortInfo:{
        field: 'CRMTR_CODIGO', 
        direction: 'ASC'
    },
    baseParams:{
        keyword:"",
        format:"JSON"
    }
});



/**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_matrimonio.
     */
var pgBarCgg_res_matrimonio= new Ext.PagingToolbar({
    store: gsCgg_res_matrimonio,
    displayInfo: true,
    pageSize:RECORD_PAGE,
    displayMsg: 'Mostrando {0} - {1} de {2}',
    temptyMsg: 'No hay informaci\u00f3n para mostrar'
});
/**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_matrimonio en un formato tabular de filas y columnas.
     */
var grdCgg_res_matrimonio = new Ext.grid.GridPanel({
    cm:cmCgg_res_matrimonio,
    store:gsCgg_res_matrimonio,
    region:'center',
    sm:new Ext.grid.RowSelectionModel({
        singleSelect:true
    }),
    viewConfig:{
        forceFit:true
    },
    loadMask:{
        msg:"Cargando..."
    },
    tbar: [
    'Buscar: ', ' ',
    new Ext.ux.bsx.SearchField({
        store:gsCgg_res_matrimonio,
        width:200
    })
    ],
    bbar:pgBarCgg_res_matrimonio,
    listeners:{
        rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
            if(!btnEditarCgg_res_matrimonio.hidden){
                btnEditarCgg_res_matrimonio.fireEvent('click', btnEditarCgg_res_matrimonio);
            }
        }
    },
plugins:[expanderMatrimonio]
});
gsCgg_res_matrimonio.reload({
    params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
});


/**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_matrimonio.
     */
var btnNuevoCgg_res_matrimonio = new Ext.Button({
    id:'btnNuevoCgg_res_matrimonio',
    text:'Nuevo',
    iconCls:'iconNuevo',
    menu:[
    {
        text:'Informe Pareja',
        iconCls:'iconInforme',
        listeners:{
            click:function(){
                var r=grdCgg_res_matrimonio.getSelectionModel().getSelected();
                if(r){

                    var objCgg_res_informe_pareja = new FrmCgg_res_informe_pareja('insert');
                    objCgg_res_informe_pareja.loadMatrimonio(grdCgg_res_matrimonio.getSelectionModel().getSelected().get('CRMTR_CODIGO'));
                    objCgg_res_informe_pareja.closeHandler(function(){
                        gsCgg_res_matrimonio.reload();
                    });
                    // objCgg_res_informe_pareja.loadMatrimonio();
                    objCgg_res_informe_pareja.show();
                }else{
                    Ext.MessageBox.alert('Matrimimonio', 'Seleccione un registro para continuar');
                }

            }
        }
    },{
    text:'Informe Testigo',
    iconCls:'iconInforme',
    listeners:{
        click:function(){
            var r=grdCgg_res_matrimonio.getSelectionModel().getSelected();
            if(r){
                var objCgg_res_informe_testigo = new FrmCgg_res_informe_testigo('insert');
                objCgg_res_informe_testigo.loadMatrimonio(grdCgg_res_matrimonio.getSelectionModel().getSelected().get('CRMTR_CODIGO'));
                objCgg_res_informe_testigo.closeHandler(function(){
                    gsCgg_res_matrimonio.reload();
                });
                objCgg_res_informe_testigo.show();
            }else{
                Ext.MessageBox.alert('Matrimimonio', 'Seleccione un registro para continuar');
            }
        }
    }
}
]
});

grdCgg_res_matrimonio.getSelectionModel().on("rowselect",function(selectionModel){
    var tmpRecordMatrimonio= selectionModel.getSelected();
    var tmpFlag =  false
    tmpFlag = tmpRecordMatrimonio.get('CRMTR_FECHA_MATRIMONIO')?true:false;
    btnNuevoCgg_res_matrimonio.setDisabled(!tmpFlag);
    btnListadoNuevoCgg_res_informe_pareja.setDisabled(!tmpFlag);
    btnListadoNuevoCgg_res_informe_testigo.setDisabled(!tmpFlag);
//btnDetalleCgg_gem_vacante.setDisabled(!sw_cgvcn);
//if (sw_cgvcn == false) btnEditarCgg_gem_vacante.setDisabled(true);
});

/**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_matrimonio.
     */
if(inDesktop){
    var winFrmListadoCgg_res_matrimonio = inDesktop.createWindow({
        id:'winFrmListadoCgg_res_matrimonio',
        title:tituloListadoCgg_res_matrimonio,
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_matrimonio,descListadoCgg_res_matrimonio),
        items:[grdCgg_res_matrimonio],
        width:700,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        bbar:[btnNuevoCgg_res_matrimonio,btnEditarCgg_res_matrimonio,'-',btnListadoNuevoCgg_res_informe_pareja,'-',btnListadoNuevoCgg_res_informe_testigo,'->',btnSalirCgg_res_matrimonio]
    });
    /**
         * Funcion que aplica los privilegios del usuario.
         */
    applyGrants(winFrmListadoCgg_res_matrimonio.getBottomToolbar());
}
/**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_matrimonio.
     * @returns ventana winFrmCgg_res_matrimonio.
     * @base FrmListadoCgg_res_matrimonio.prototype.show
     */
this.getWindow = function(){
    return winFrmListadoCgg_res_matrimonio;
}
/**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_matrimonio.
     * @base FrmListadoCgg_res_matrimonio.prototype.loadData
     */
this.loadData = function(){
    gsCgg_res_matrimonio.load();

}
/**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
this.getColumnModel = function(){
    return cmCgg_res_matrimonio;
}
/**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
this.getStore = function(){
    return gsCgg_res_matrimonio;
}
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_matrimonio.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_matrimonio.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_matrimonio desde una instancia.
 */
FrmListadoCgg_res_matrimonio.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_matrimonio desde una instancia.
 */
FrmListadoCgg_res_matrimonio.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_matrimonio,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_matrimonio.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_matrimonio desde una instancia.
 */
FrmListadoCgg_res_matrimonio.prototype.loadData = function(){
    this.loadData();
}
