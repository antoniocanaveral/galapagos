/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_regla_validacion.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_regla_validacion_resultado(inData){
    var urlListadoCgg_regla_validacion=URL_WS+"Cgg_regla_validacion";
    var tituloListadoCgg_regla_validacion='Aplicaci\u00f3n reglas de validaci\u00F3n';
    var descListadoCgg_regla_validacion='Las reglas aplicadas a esta operaci\u00f3n no han sido superadas.<br> A continuaci\u00f3n sirvase encontrar un detalle de las validaciones ejecutadas: ';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_regla_validacion_resultado.
     */
    var btnNuevoCgg_regla_validacion = new Ext.Button({
        id:'btnNuevoCgg_regla_validacion',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_regla_validacion = new FrmCgg_regla_validacion("insert");
                objCgg_regla_validacion.closeHandler(function(){
                    gsCgg_regla_validacion.reload();
                });
                objCgg_regla_validacion.show();
            }
        }
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_regla_validacion_resultado.
     */
    var btnSalirCgg_regla_validacion = new Ext.Button({
        id:'btnSalirCgg_regla_validacion',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_regla_validacion_resultado.close();
            }
        }
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_regla_validacion.
     */
    var cmCgg_regla_validacion = new Ext.grid.ColumnModel([
        {
            dataIndex:'CRVAL_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        },
        {
            dataIndex:'CRVAL_NOMBRE',
            header:'Nombre',
            width:150,
            sortable:true
        },
        {
            dataIndex:'CRVAL_DESCRIPCION',
            header:'Descripci\u00F3n',
            width:150,
            sortable:true
        },
        {
            dataIndex:'CRVAL_FUNCION_VALIDACION',
            header:'Funci\u00f3n validaci\u00F3n',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        },
        {
            dataIndex:'CRVAL_OPERADOR_COMPARADOR',
            header:'Comparador',
            width:80,
            hidden:true,
            hideable:false
        },
        {
            dataIndex:'CRVAL_APROBADO',
            header:'Resultado',
            width:50,
            sortable:true,
            renderer:function(value,metaData,record)
            {
                 switch (value) {
                    case 'TRUE':
                        metaData.css = 'iconAprobado';

                        break;
                    case 'FALSE':
                        metaData.css = 'iconNegado';
                        metaData.attr = 'ext:hide=false ext:qtitle=Fall\u00f3 ext:qtip="' + record.get('CRVAL_SUGERENCIA')+ '"';
                        break;
                }
                return '';

            }
        },
        {
            dataIndex:'CGCNF_CODIGO',
            header:'Parametro',
            width:100,
            sortable:true,
            hidden:true,
            hideable:false
        },
        {
            dataIndex:'CRVAL_VALOR_LIBRE',
            header:'Valor',
            width:80,
            hidden:true,
            hideable:false
        },
        {
            dataIndex:'CRVAL_RESULTADO_ACEPTACION',
            header:'Resultado aceptaci\u00F3n',
            width:100,
            sortable:true,
            hidden:true,
            hideable:false
        },
        {
            dataIndex:'CRVAL_SUGERENCIA',
            header:'Sugerencia',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        },
        {
            dataIndex:'CRVAL_TIPO',
            header:'Tipo',
            width:150,
            sortable:true,
            renderer:function(inCRVAL_TIPO){
                for(var i=0;i<dsModalidad.length;i++){
                    if(dsModalidad[i][0]==inCRVAL_TIPO){
                        return dsModalidad[i][1];
                    }
                }
                return NO_DATA_MESSAGE;
            },
            hidden:true,
            hideable:false
        },
        {
            dataIndex:'CRVAR_FECHA_INICIO',
            header:'Fecha inicio',
            width:80,
            sortable:true,
            renderer:truncDate,
            hidden:true,
            hideable:false
        },
        {
            dataIndex:'CRVAR_FECHA_FIN',
            header:'Fecha fin',
            width:150,
            sortable:true,
            renderer:truncDate,
            hidden:true,
            hideable:false
        },
        {
            dataIndex:'CRVAL_VALOR_1',
            header:'Valor 1',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        },
        {
            dataIndex:'CRVAL_VALOR_2',
            header:'Valor 2',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        }]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_regla_validacion por un campo especifico.
     */
    var gsCgg_regla_validacion = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_regla_validacion",
            method:"selectPage",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
            id:'CRVAL_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {
                name:'CRVAL_CODIGO'
            },

            {
                name:'CGCNF_CODIGO'
            },

            {
                name:'CRVAL_NOMBRE'
            },

            {
                name:'CRVAL_DESCRIPCION'
            },

            {
                name:'CRVAL_FUNCION_VALIDACION'
            },
            {
                name : 'CRVAL_APROBADO'
            },
            {
                name:'CRVAL_OPERADOR_COMPARADOR'
            },

            {
                name:'CRVAL_VALOR_LIBRE'
            },

            {
                name:'CRVAL_RESULTADO_ACEPTACION'
            },

            {
                name:'CRVAL_SUGERENCIA'
            },

            {
                name:'CRVAL_TIPO'
            },

            {
                name:'CRVAR_FECHA_INICIO'
            },

            {
                name:'CRVAR_FECHA_FIN'
            },

            {
                name:'CRVAL_VALOR_1'
            },

            {
                name:'CRVAL_VALOR_2'
            }
        ]),
        sortInfo:{
            field: 'CRVAL_APROBADO',
            direction: 'ASC'
        },
        baseParams:{
        }
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_regla_validacion en un formato tabular de filas y columnas.
     */
    var grdCgg_regla_validacion = new Ext.grid.GridPanel({
        cm:cmCgg_regla_validacion,
        store:gsCgg_regla_validacion,
        region:'center',
        viewConfig:{forceFit:true},
        autoExpandColumn:'CRVAL_NOMBRE',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        loadMask:{
            msg:"Cargando..."
        }
    });
    
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_regla_validacion.
     */        
    var winFrmListadoCgg_regla_validacion_resultado = new Ext.Window({
        id:'winFrmListadoCgg_regla_validacion_resultado',
        title:tituloListadoCgg_regla_validacion,
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:false,
        minimizable:false,
        modal:true,
        constrain:true,
        layout:'border',
        iconCls:'iconRegla',
        tbar:getPanelTitulo(tituloListadoCgg_regla_validacion,descListadoCgg_regla_validacion),
        items:[grdCgg_regla_validacion],
        bbar:['->',btnSalirCgg_regla_validacion]
    });
    // }

    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_regla_validacion_resultado.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_regla_validacion_resultado.
     * @returns ventana winFrmCgg_regla_validacion.
     * @base FrmListadoCgg_regla_validacion_resultado.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_regla_validacion_resultado;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_regla_validacion_resultado.
     * @base FrmListadoCgg_regla_validacion_resultado.prototype.loadData
     */
    this.loadData = function(){
        //gsCgg_regla_validacion.load();
        gsCgg_regla_validacion.loadData(inData,true);
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_regla_validacion;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_regla_validacion;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_regla_validacion_resultado.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_regla_validacion_resultado.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_regla_validacion_resultado desde una instancia.
 */
FrmListadoCgg_regla_validacion_resultado.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_regla_validacion_resultado desde una instancia.
 */
FrmListadoCgg_regla_validacion_resultado.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_regla_validacion_resultado,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_regla_validacion_resultado.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_regla_validacion_resultado desde una instancia.
 */
FrmListadoCgg_regla_validacion_resultado.prototype.loadData = function(){
    this.loadData();
}
