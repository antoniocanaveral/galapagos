/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_seguimiento.
 * @constructor
 * @param inDesktop Escritorio web de la aplicacion.
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_jur_seguimiento_criterio_juridico(inDesktop){
    var urlListadoCgg_jur_seguimiento=URL_WS+"Cgg_jur_seguimiento_criterio";
    var tituloListadoCgg_jur_seguimiento='Revisi\u00F3n del seguimiento criterio';
    var descListadoCgg_jur_seguimiento='El formulario permite revisar informaci\u00f3n del seguimiento criterio';

    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_seguimiento.
     */
    var btnSalirCgg_jur_seguimiento_criterio_juridico = new Ext.Button({
        id:'btnSalirCgg_jur_seguimiento_criterio_juridico',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:'Salir del formulario',
        listeners:{
            click:function(){
                winFrmListadoCgg_jur_seguimiento_criterio_juridico.close();
            }
        }
    });
    /**
     *  Ext.ux.grid.RowExpander Expandir fila
     **/
    var reSeguimiento_juridico = new Ext.ux.grid.RowExpander({
        tpl : new Ext.Template(
                '<br> <table style="width:100%;" border="0">' +
                        ' <tr> <td style="width:50%;"> <div style="vertical-align:middle;"> '+ '<table id="ver-zebra" style="width:100%;" border="0"> <colgroup> '+ '<col class="vzebra-odd"/> <col class="vzebra-even"/> ' + '</colgroup>' +
                        ' <tr><td width="100">Datos de Tr&aacute;mite</td> <td></td> </tr>' +
                        ' <tr><td width="100">N&uacute;mero</td><td>{CRTRA_NUMERO}</td></tr>' +
                        ' <tr><td width="100">A\u00f1o</td><td>{CRTRA_ANIO}</td></tr>' +
                        ' <tr><td width="100">Beneficiario</td><td>{BENEFICIARIO}<br/></td></tr>' +
                        ' <tr><td width="100">Auspiciante</td><td>{AUSPICIANTE}</td></tr> ' +
                        ' <tr><td width="100">Recepci&oacute;n</td><td>{CRTRA_FECHA_RECEPCION}</td></tr>' +
                        ' <tr><td width="100">Tipo solicitud</td><td>{TIPO_SOLICITUD}</td></tr>' +
                        ' </table> </div> </td> <td style="width:50%;">' +
                        ' <table id="ver-zebra" style="width:100%;" border="0"> <colgroup> <col class="vzebra-odd"/><col class="vzebra-even"/></colgroup>' +
                        ' <tr><td width="100">Datos de fase</td> <td></td> </tr>' +
                        ' <tr><td width="100">Justificaci&oacute;n</td><td>{CJSGC_JUSTIFICACION}</td></tr> ' +
                        ' <tr><td width="100">Actual</td><td class="textoResultado">{CRFAS_NOMBRE}</td></tr> ' +
                        ' <tr><td width="100">Recepci&oacute;n</td><td>{CRSEG_FECHA_RECEPCION}</td></tr> ' +
                        ' <tr><td width="100">Revisi&oacute;n</td><td>{CRSEG_FECHA_REVISION}</td></tr>' +
                        ' <tr><td width="100">Despacho</td><td>{CRSEG_FECHA_DESPACHO}</td></tr> ' +
                        ' </table> </td> </tr> <tr>' +
                        ' <td colspan="2"><p/>{SEGUIMIENTO_HTML}</td> </tr> </table>'
                )
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_seguimiento.
     */
    var cmCgg_jur_seguimiento_criterio_juridico = new Ext.grid.ColumnModel([
        reSeguimiento_juridico,
        {
            dataIndex:'CRSEG_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        },
        {
            dataIndex:'CRSEG_NUMERO',
            header:'N\u00famero Seg.',
            width:60,
            sortable:true
        },
        {
            dataIndex:'CRSEG_DESCRIPCION',
            header:'Descripci\u00F3n',
            width:100,
            sortable:true,
            hidden:true
        },
        {
            dataIndex:'CRTRA_CODIGO',
            header:'Tr\u00E1mite',
            width:60,
            sortable:true,
            hidden:true,
            hideable:false
        },
        {
            dataIndex:'CRTRA_ANIO',
            header:'A\u00F1o',
            width:50,
            sortable:true
        },{
            dataIndex:'CRTRA_CODIGO',
            header:'crtra_codigo',
            width:50,
            sortable:true,
            hidden:true,
            hideable:false
        },{
            dataIndex:'CRTRA_NUMERO',
            header:'Tr\u00E1mite',
            width:80,
            sortable:true
        },{
            dataIndex:'CRTST_CODIGO',
            header:'crtst_codigo',
            width:50,
            sortable:true,
            hidden:true,
            hideable:false
        },{
            dataIndex:'CRTST_DESCRIPCION',
            header:'Tipo solicitud',
            width:100,
            sortable:true
        },
            {
            dataIndex:'CRPER_CODIGO',
            header:'CRPER_CODIGO',
            width:70,
            sortable:true,
            hidden:true,
            hideable:false
        },
        {
            dataIndex:'AUSPICIANTE',
            header:'Auspiciante',
            width:150,
            sortable:true
        },
        {
            dataIndex:'BENEFICIARIO',
            header:'Beneficiario',
            width:150,
            sortable:true
        },
        {
            dataIndex:'CGG_CRPER_CODIGO',
            header:'CGG_CRPER_CODIGO',
            width:70,
            sortable:true,
            hidden:true,
            hideable:false
        },
        {
            dataIndex:'CGG_CRSEG_CODIGO',
            header:'Seguimiento recursivo',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        },
        {
            dataIndex:'CRFAS_NOMBRE',
            header:'Fase',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        },

        {
            dataIndex:'CRSEG_ESTADO_ATENCION',
            header:'Estado',
            width:100,
            sortable:true,
            renderer:function(inCRSEG_ESTADO_ATENCION){
                for(var x=0;x<dsEstadoAtencionSeguimiento.length;x++){
                    if(dsEstadoAtencionSeguimiento[x][0]==inCRSEG_ESTADO_ATENCION){
                        return dsEstadoAtencionSeguimiento[x][1];
                    }
                }
                return NO_DATA_MESSAGE;
            }
        },

        {
            dataIndex:'CRSEG_TIPO_RESPUESTA',
            header:'Respuesta',
            width:100,
            sortable:true,
            renderer:function(inCRSEG_TIPO_RESPUESTA){
                for(TipoRespuesta in TypeRespuestaSeguimiento){
                    if(eval('TypeRespuestaSeguimiento.'+TipoRespuesta)==inCRSEG_TIPO_RESPUESTA){
                        return TipoRespuesta;
                    }
                }
                return NO_DATA_MESSAGE;
            }
        },

        {
            dataIndex:'CRSEG_FECHA_RECEPCION',
            header:'Fecha recepci\u00F3n',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        },
        {
            dataIndex:'CRTRA_FECHA_RECEPCION',
            header:'Fecha recepci\u00F3n',
            width:80,
            sortable:true,
            renderer:truncDate
        },
        {
            dataIndex:'CRSEG_FECHA_REVISION',
            header:'Fecha revisi\u00F3n',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        },{
            dataIndex:'CJSGC_JUSTIFICACION',
            header:'Justificaci\u00F3n',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        },
        {
            dataIndex:'CRSEG_FECHA_DESPACHO',
            header:'Fecha despacho',
            width:150,
            sortable:true,
            hidden:true,
            renderer:truncDate
        },
        {
            dataIndex:'CRSEG_ESTADO_HIJO',
            header:'Seguimiento',
            width:100,
            sortable:true,
            renderer:function(inCRSEG_ESTADO_HIJO){
                for(TipoHijo in TypeEstadoHijo){
                    if(eval('TypeEstadoHijo.'+TipoHijo) == inCRSEG_ESTADO_HIJO){
                        return TipoHijo;
                    }
                }
                return NO_DATA_MESSAGE;
            }
        }

    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_seguimiento por un campo especifico.
     */
    var gsCgg_jur_seguimiento_criterio_juridico = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_jur_seguimiento_criterio",
            method:"selectPageDirectJuridico",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRSEG_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {
                name:'CRSEG_CODIGO'
            },
            {
                name:'CRSEG_NUMERO'
            },
            {
                name:'CRSEG_DESCRIPCION'
            },
            {
                name:'CRTRA_CODIGO'
            },
            {
                name:'CRTRA_ANIO'
            },
            {
                name:'CRTRA_NUMERO'
            },
            {
                name:'CRTST_CODIGO'
            },
            {
                name:'CRTST_DESCRIPCION'
            },
            {
                name:'AUSPICIANTE'
            },
            {
                name:'BENEFICIARIO'
            },
            {
                name:'CGG_CRPER_CODIGO'
            },
            {
                name:'CGG_CRSEG_CODIGO'
            },
            {
                name:'CRFAS_NOMBRE'
            },
            {
              name:'CRSEG_ESTADO_ATENCION'
            },
            {
               name:'CRSEG_TIPO_RESPUESTA'
            },{
               name:'CJSGC_JUSTIFICACION'
            },
            {
                name:'CRSEG_FECHA_RECEPCION'
            },
            {
                name:'CRTRA_FECHA_RECEPCION'
            },
            {
                name:'CRSEG_FECHA_REVISION'
            },
            {
                name:'CRSEG_FECHA_DESPACHO'
            },
            {
                name:'CRSEG_ESTADO_HIJO'
            }
        ]),
        groupField:'CRTRA_FECHA_RECEPCION',
        sortInfo:{
            field: 'CRSEG_FECHA_RECEPCION',
            direction: 'DESC'
        },
        baseParams:{
            keyword:"",
            format:"JSON"
        }
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_seguimiento.
     */
    var pgBarCgg_jur_seguimiento_criterio_juridico= new Ext.PagingToolbar({
        store: gsCgg_jur_seguimiento_criterio_juridico,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });

    var gvCgg_jur_seguimiento_criterio_juridico = new Ext.grid.GroupingView({
        enableRowBody:true,
        groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Tr\u00E1mites" : "Tr\u00E1mite"]})',
        getRowClass: function(inRecord, inRowIndex, inRowParams, inStore){
            var resCss='';
            switch (inRecord.get('CRSEG_ESTADO_HIJO')) {
                case TypeEstadoHijo.SINHIJOS:
                    resCss = '';
                    break;
                case TypeEstadoHijo.SINRESPUESTAS:
                    resCss = 'row-orange';
                    break;
                case TypeEstadoHijo.RESPUESTAPARCIAL:
                    resCss = 'row-yellow';
                    break;
                case TypeEstadoHijo.RESPUESTATOTAL:
                    resCss = 'row-green';
                    break;
                default:
                    resCss='';
                    break;
            }
            return resCss;
        }
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_seguimiento en un formato tabular de filas y columnas.
     */
    var grdCgg_jur_seguimiento_criterio_juridico = new Ext.grid.GridPanel({
        cm:cmCgg_jur_seguimiento_criterio_juridico,
        store:gsCgg_jur_seguimiento_criterio_juridico,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        loadMask:{
            msg:"Cargando..."
        },
        viewConfig:gvCgg_jur_seguimiento_criterio_juridico,
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                id:'sfCgg_res_seguimiento',
                store:gsCgg_jur_seguimiento_criterio_juridico,
                width:300
            })
        ],
        plugins:[reSeguimiento_juridico,new Ext.ux.grid.AutoSizeColumns()],
        /*bbar:pgBarCgg_res_seguimiento_criterio,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_seguimiento_criterio.disabled){
                    btnEditarCgg_res_seguimiento_criterio.fireEvent('click', btnEditarCgg_res_seguimiento);
                }
            }
        },*/
        animCollapse: false
    });
    gsCgg_jur_seguimiento_criterio_juridico.reload({
        params:{
            start:0,
            limit:RECORD_PAGE,
            format:"JSON"
        }
    });


    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_seguimiento.
     */
    var winFrmListadoCgg_jur_seguimiento_criterio_juridico = null;
    if(inDesktop ==null && inDesktop == undefined){
        winFrmListadoCgg_jur_seguimiento_criterio_juridico = new Ext.Window({
            id:'winFrmListadoCgg_jur_seguimiento_criterio_juridico',
            title:tituloListadoCgg_jur_seguimiento,
            tbar:getPanelTitulo(tituloListadoCgg_jur_seguimiento,descListadoCgg_jur_seguimiento),
            items:[grdCgg_jur_seguimiento_criterio_juridico],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            iconCls:'iconSeguimiento',
            bbar:['->',btnSalirCgg_jur_seguimiento_criterio_juridico]
        });
    }else{
        winFrmListadoCgg_jur_seguimiento_criterio_juridico = new inDesktop.createWindow({
            id:'winFrmListadoCgg_jur_seguimiento_criterio_juridico',
            title:tituloListadoCgg_jur_seguimiento,
            tbar:getPanelTitulo(tituloListadoCgg_jur_seguimiento,descListadoCgg_jur_seguimiento),
            items:[grdCgg_jur_seguimiento_criterio_juridico],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            iconCls:'iconSeguimiento',
            bbar:['->',btnSalirCgg_jur_seguimiento_criterio_juridico],
            listeners:{
                show:function(){
                    Ext.getCmp('sfCgg_res_seguimiento').focus(true,400);
                }
            }
        });
    }

    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_jur_seguimiento_criterio_juridico.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_seguimiento.
     * @returns ventana winFrmCgg_res_seguimiento.
     * @base FrmListadoCgg_res_seguimiento.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_jur_seguimiento_criterio_juridico;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_seguimiento.
     * @base FrmListadoCgg_res_seguimiento.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_jur_seguimiento_criterio_juridico.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_jur_seguimiento_criterio_juridico;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_jur_seguimiento_criterio_juridico;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_jur_seguimiento_criterio_juridico.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_jur_seguimiento_criterio_juridico.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_seguimiento desde una instancia.
 */
FrmListadoCgg_jur_seguimiento_criterio_juridico.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_seguimiento desde una instancia.
 */
FrmListadoCgg_jur_seguimiento_criterio_juridico.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_seguimiento,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_jur_seguimiento_criterio_juridico.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_seguimiento desde una instancia.
 */
FrmListadoCgg_jur_seguimiento_criterio_juridico.prototype.loadData = function(){
    this.loadData();
}

