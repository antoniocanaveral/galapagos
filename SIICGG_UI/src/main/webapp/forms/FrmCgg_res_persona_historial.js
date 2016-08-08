/**
 * Funcion publica. Formulario que permite consultar el historial de las personas
 * @param {String} INSENTENCIA_CGG_RES_PERSONA_HISTORIAL Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_PERSONA_HISTORIAL Registro de datos de la tabla Cgg_res_movilidad.
 * @constructor
 * @base FrmListadoCgg_res_movilidad
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_persona_historial(inDesktop,INRECORDHISTORIALPERSONA) {
    var optMenu = 'Control de Residencia/Historial de persona';
    var inRecordHistorialPersona = INRECORDHISTORIALPERSONA;
    var tituloCgg_res_persona_historial = 'Historial persona';
    var urlCgg_res_persona=URL_WS+"Cgg_res_persona";
    var descCgg_res_persona_historial = 'El formulario permite consultar el historial de una persona';    
    var tmpInformacionPersona;
    var tmpInformacionPersonaEstadia;
    var tmpUserSession = new UserSession();


    function PersonaHistorial() {
        var cmPersonaHistorial = null;
        var gsPersonaHistorial = null;
        /**
         * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_persona.
         *
         */
        cmPersonaHistorial = new Ext.grid.ColumnModel([
        {
            dataIndex:'CRPER_NOMBRES',
            header:'Nombres',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CRPER_APELLIDO_PATERNO',
            header:'Primer apellido',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CRPER_APELLIDO_MATERNO',
            header:'Segundo apellido',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CRPER_NUM_DOC_IDENTIFIC',
            header:'Num doc identific',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CRPER_FECHA_NACIMIENTO',
            header:'Fecha nacimiento',
            width:150,
            sortable:true,
            renderer:truncDate
        },

        {
            dataIndex:'CRPER_LUGAR_NACIMIENTO',
            header:'Lugar nacimiento',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CRPER_GENERO',
            header:'Genero',
            width:150,
            sortable:true,
            renderer:function(inData){
                if(!inData)
                    return dsGeneroPersona[0][1];
                return dsGeneroPersona[inData][1];
            }
        },

        {
            dataIndex:'CRPER_NUMERO_RESIDENCIA',
            header:'Numero residencia',
            width:150,
            sortable:true
        }
        ]);
        /**
         * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_persona por un campo especifico.
         */
        gsPersonaHistorial = new Ext.data.Store({
            proxy:new Ext.ux.bsx.SoapProxy({
                url:URL_WS + "Cgg_res_persona",
                method:"selectConsultaPersonaGeneral",
                pagin:true
            }),
            remoteSort:true,
            reader:new Ext.data.JsonReader({
                id:'CRPER_CODIGO',
                root:'dataSet',
                totalProperty: 'totalCount'
            }, [
            {
                name:'CRPER_CODIGO'
            },

            {
                name:'CRPER_NOMBRES'
            },

            {
                name:'CRPER_APELLIDO_PATERNO'
            },

            {
                name:'CRPER_APELLIDO_MATERNO'
            },

            {
                name:'CRDID_TIPO'
            },

            {
                name:'CRPER_NUM_DOC_IDENTIFIC'
            },

            {
                name:'CRPER_FECHA_NACIMIENTO'
            },

            {
                name:'CRPER_LUGAR_NACIMIENTO'
            },

            {
                name:'CRPER_GENERO'
            },

            {
                name:'CCNT_NOMBRE'
            },

            {
                name:'CRPER_CUPO_VEHICULAR'
            },

            {
                name:'CCNT_NOMBRE_ORIGEN'
            },

            {
                name:'CRPER_TIPO_PERSONA'
            },

            {
                name:'CRPER_NUMERO_RESIDENCIA'
            },

            {
                name:'CRPER_AUTORIZADO'
            },

            {
                name:'CGNCN_NOMBRE'
            },

            {
                name:'CRECV_ESTADO_CIVIL'
            },

            {
                name:'CRPER_TIPO'
            }
            ]),
            sortInfo:{
                field: 'CRPER_NOMBRES',
                direction: 'ASC'
            },
            baseParams:{
                keyword:'',
                format:"JSON",
                inIdentificacion:''
            }
        });
        this.getCm = function() {
            return cmPersonaHistorial;
        };

        this.getStore = function() {
            return gsPersonaHistorial;
        }
    }

    PersonaHistorial.prototype.getColumnModel = function() {
        return this.getCm();
    };

    PersonaHistorial.prototype.getStore = function() {
        return this.getStore();
    };
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto del historial del observado.
     */
    var cmCgg_res_observado = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
        {
            dataIndex:'CROBS_FECHA_OBSERVACION',
            header:'Fecha observacion',
            width:150,
            sortable:true,
            renderer:truncDate
        },

        {
            dataIndex:'CROBS_DESCRIPCION',
            header:'Descripcion',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CROBS_RESUELTO',
            header:'Resuelto',
            width:150,
            sortable:true,
            xtype: 'booleancolumn',
            trueText: 'Si',
            falseText: 'No'
        },

        {
            dataIndex:'CROBS_FECHA_RESUELTO',
            header:'Fecha resuelto',
            width:150,
            sortable:true,
            renderer:truncDate
        }
        ]);

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_oficial_matrimonio_usuario por un campo especifico.
     */
    var gsCgg_res_observacion = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS + "Cgg_res_persona",
            method:"selectHistorialObservado"

        }),
        reader:new Ext.data.JsonReader({}, [
        {
            name:'CROBS_CODIGO'
        },

        {
            name:'CROBS_FECHA_OBSERVACION'
        },

        {
            name:'CROBS_DESCRIPCION'
        },

        {
            name:'CROBS_RESUELTO'
        },

        {
            name:'CROBS_FECHA_RESUELTO'
        }
        ]),
        sortInfo:{
            field: 'CROBS_FECHA_OBSERVACION',
            direction: 'DESC'
        },
        baseParams:{
            format:"JSON"
        }
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_oficial_matrimonio_usuario en un formato tabular de filas y columnas.
     */
    var grdCgg_res_observacion = new Ext.grid.GridPanel({
        cm:cmCgg_res_observado,
        store:gsCgg_res_observacion,
        region:'center',
        frame:true,
        sm: new Ext.grid.RowSelectionModel({
            singleSelect: true,
            moveEditorOnEnter: false
        }),
        tbar:['Listado de observaciones'],
        loadMask: {
            msg: "Cargando..."
        }
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto del historial de notificado.
     */
    var cmCgg_res_notificacion_historial = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
        {
            dataIndex:'CRNOT_NUMERO_NOTIFICACION',
            header:'No.',
            width:50,
            sortable:true
        },

        {
            dataIndex:'CRNOT_FECHA_NOTIFICACION',
            header:'Fecha',
            width:100,
            sortable:true,
            renderer:truncDate
        },

        {
            dataIndex:'CROSG_NOMBRE_NOTIFICACION',
            header:'Oficial',
            width:200,
            sortable:true
        },

        {
            dataIndex:'CRNOT_ESTADO_NOTIFICACION',
            header:'Estado',
            width:100,
            sortable:true,
            renderer:function(inCrnotestadoNtificacionHistorial) {
                return dsEstadoNotificacion[inCrnotestadoNtificacionHistorial][1];
            }
        },
		{
            dataIndex:'CRNOT_REGULARIZACION',
            header:'Regularizacion',
            width:100,
            sortable:true,
            renderer:function(v){
				return (v=='0')?'No permitido':'Permitido';
			}
        },
        {
            dataIndex:'CRNOT_FECHA_SALIDA_VOLUNT',
            header:'Fecha salida',
            width:100,
            sortable:true,
            renderer:truncDate
        },

        {
            dataIndex:'CRNOT_FECHA_EXPULSION',
            header:'Fecha expulsion',
            width:100,
            sortable:true,
            renderer:truncDate
        }
        ]);

    /**
     * Ext.data.Store Agrupacion de registros  por un campo especifico.
     */
    var gsCgg_res_notificacion_historial = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS + "Cgg_res_persona",
            method:"selectHistorialNotificacion"

        }),
        reader:new Ext.data.JsonReader({}, [
        {
            name:'CRNOT_CODIGO'
        },

        {
            name:'CRNOT_NUMERO_NOTIFICACION'
        },

        {
            name:'CRNOT_FECHA_NOTIFICACION'
        },

        {
            name:'CROSG_NOMBRE_NOTIFICACION'
        },

        {
            name:'CRNOT_ESTADO_NOTIFICACION'
        },
		{
            name:'CRNOT_REGULARIZACION'
        },
        {
            name:'CRNOT_FECHA_SALIDA_VOLUNT'
        },

        {
            name:'CRNOT_FECHA_EXPULSION'
        }
        ]),
        sortInfo:{
            field: 'CRNOT_FECHA_NOTIFICACION',
            direction: 'DESC'
        },
        baseParams:{
            format:"JSON"
        }
    });


    /**
     * Ext.grid.GridPanel Representacion de  en un formato tabular de filas y columnas.
     */
    var grdCgg_res_notificacion = new Ext.grid.GridPanel({
        frame:true,
        cm:cmCgg_res_notificacion_historial,
        store:gsCgg_res_notificacion_historial,
        region:'center',
        sm: new Ext.grid.RowSelectionModel({
            singleSelect: true,
            moveEditorOnEnter: false
        }),
        loadMask: {
            msg: "Cargando..."
        },
        tbar:['Listado de notificaciones']
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto del historial de RECORD MIGRATORIO.
     */
    var cmCgg_res_recordmigratorio_historial = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
        {
            dataIndex:'FECHA_VIAJE_INGRESO',
            header:'Fecha ingreso',
            width:150,
            sortable:true,
            renderer:truncDateTime
        },

        {
            dataIndex:'TIPO_RESIDENCIA',
            header:'Residencia IN',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CRALN_NOMBRE_INGRESO',
            header:'Aereolinea IN',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CRMOV_NUMERO_VUELO',
            header:'No.vuelo IN',
            width:100,
            sortable:true
        },

        {
            dataIndex:'CARPT_NOMBRE_INGRESO',
            header:'Aeropuerto partida ',
            width:170,
            sortable:true
        },

        {
            dataIndex:'CGG_CARPT_NOMBRE_INGRESO',
            header:'Aeropuerto arribo',
            width:170,
            sortable:true
        },

        {
            dataIndex:'CRMOV_FECHA_VIAJE_SALIDA',
            header:'Fecha salida',
            width:150,
            sortable:true,
            renderer:truncDateTime
        },

        {
            dataIndex:'TIPO_RESIDENCIA_SALIDA',
            header:'Residencia OUT',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CRALN_NOMBRE_SALIDA',
            header:'Aereolinea OUT',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CRMOV_NUMERO_VUELO_SALIDA',
            header:'No.vuelo OUT',
            width:100,
            sortable:true
        },

        {
            dataIndex:'CARPT_NOMBRE_SALIDA',
            header:'Aeropuerto partida',
            width:170,
            sortable:true
        }
        ]);


    /**
     * Ext.data.Store Agrupacion de registros  por un campo especifico.
     */
    var gsCgg_res_recordmigratorio_historial = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS + "Cgg_res_persona",
            method:"selectHistorialMovilidad",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRMOV_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        }, [
        {
            name:'CRMOV_CODIGO'
        },

        {
            name:'FECHA_VIAJE_INGRESO'
        },

        {
            name:'CRMOV_TIPO_OPERACION'
        },

        {
            name:'TIPO_RESIDENCIA'
        },

        {
            name:'CRALN_NOMBRE_INGRESO'
        },

        {
            name:'CARPT_NOMBRE_INGRESO'
        },

        {
            name:'CGG_CARPT_NOMBRE_INGRESO'
        },

        {
            name:'CRMOV_NUMERO_VUELO'
        },

        {
            name:'CRMOV_FECHA_VIAJE_SALIDA'
        },

        {
            name:'TIPO_RESIDENCIA_SALIDA'
        },

        {
            name:'CRMOV_TIPO_OPERACION_SALIDA'
        },

        {
            name:'CRALN_NOMBRE_SALIDA'
        },

        {
            name:'CARPT_NOMBRE_SALIDA'
        },

        {
            name:'CGG_CARPT_NOMBRE_SALIDA'
        },

        {
            name:'CRMOV_NUMERO_VUELO_SALIDA'
        }
        ]),
        sortInfo:{
            field: 'FECHA_VIAJE_INGRESO',
            direction: 'DESC'
        },
        baseParams:{
            keyword:"",
            format:'JSON',
            inCrper_codigo:''
        }
    });

    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_movilidad.
     */
    var pgBarCgg_res_recordmigratorio_historial= new Ext.PagingToolbar({
        store: gsCgg_res_recordmigratorio_historial,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion  en un formato tabular de filas y columnas.
     */
    var grdCgg_res_recordmigratorio_historial = new Ext.grid.GridPanel({
        frame:true,
        cm:cmCgg_res_recordmigratorio_historial,
        store:gsCgg_res_recordmigratorio_historial,
        region:'center',
        sm: new Ext.grid.RowSelectionModel({
            singleSelect: true,
            moveEditorOnEnter: false
        }),
        tbar:['Listado de salida e ingreso de la provincia'],
        loadMask: {
            msg: "Cargando..."
        },
        bbar:pgBarCgg_res_recordmigratorio_historial
    });

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto del historial de MOVILIDAD INTERNA
     */
    var cmCgg_res_movilidadinterna_historial = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
        {
            dataIndex:'CRMIV_FECHA_VIAJE_SALIDA',
            header:'Fecha salida',
            width:100,
            sortable:true,
            renderer:truncDate
        },

        {
            dataIndex:'CREMB_NOMBRE_SALIDA',
            header:'Embarque',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CRMLE_NOMBRE_SALIDA',
            header:'Muelle partida',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CGG_CRMLE_NOMBRE_SALIDA',
            header:'Muelle arribo',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CRMVI_FECHA_VIAJE',
            header:'Fecha ingreso',
            width:100,
            sortable:true,
            renderer:truncDate
        },

        {
            dataIndex:'CREMB_NOMBRE_INGRESO',
            header:'Embarque',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CRMLE_NOMBRE_INGRESO',
            header:'Muelle partida',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CGG_CRMLE_NOMBRE_INGRESO',
            header:'Muelle arribo',
            width:150,
            sortable:true
        }
        ]);

    /**
     * Ext.data.Store Agrupacion de registros  por un campo especifico.
     */
    var gsCgg_res_movilidadinterna_historial = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS + "Cgg_res_persona",
            method:"selectHistorialMovilidadInterna",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRMIV_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        }, [
        {
            name:'CRMIV_CODIGO'
        },

        {
            name:'CRMVI_TIPO_OPERACION'
        },

        {
            name:'CRMIV_FECHA_VIAJE_SALIDA'
        },

        {
            name:'CREMB_NOMBRE_SALIDA'
        },

        {
            name:'CRMLE_NOMBRE_SALIDA'
        },

        {
            name:'CGG_CRMLE_NOMBRE_SALIDA'
        },

        {
            name:'CRMVI_FECHA_VIAJE'
        },

        {
            name:'CREMB_NOMBRE_INGRESO'
        },

        {
            name:'CRMLE_NOMBRE_INGRESO'
        },

        {
            name:'CGG_CRMLE_NOMBRE_INGRESO'
        }

        ]),
        sortInfo:{
            field: 'CRMIV_FECHA_VIAJE_SALIDA',
            direction: 'DESC'
        },

        baseParams:{
            keyword:"",
            format:'JSON',
            inCrper_codigo:''
        }
    });
    /*
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_movilidad_interna.
     */
    var pgBarCgg_res_movilidadinterna_historial= new Ext.PagingToolbar({
        store: gsCgg_res_movilidadinterna_historial,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos  en un formato tabular de filas y columnas.
     */
    var grdCgg_res_movilidadinterna_historial = new Ext.grid.GridPanel({
        cm:cmCgg_res_movilidadinterna_historial,
        store:gsCgg_res_movilidadinterna_historial,
        frame:true,
        region:'center',
        sm: new Ext.grid.RowSelectionModel({
            singleSelect: true,
            moveEditorOnEnter: false
        }),
        tbar:['Listado de desplazamiento interno por muelle'],
        loadMask: {
            msg: "Cargando..."
        },
        bbar:pgBarCgg_res_movilidadinterna_historial

    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto del historial de EXPULSION
     */
    var cmCgg_res_expulsion_historial = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
        {
            dataIndex:'CRPEX_FECHA_EXPULSION',
            header:'Fecha expulsion',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CRNOT_NUMERO_NOTIFICACION',
            header:'No. notificacion',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CREXP_NOMBRE_EXPULSION',
            header:'Oficial expulsion',
            width:150,
            sortable:true
        }
        ]);

    /**
     * Ext.data.Store Agrupacion de registros  por un campo especifico.
     */
    var gsCgg_res_expulsion_historial = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS + "Cgg_res_persona",
            method:"selectHistorialExpulsion"

        }),
        reader:new Ext.data.JsonReader({}, [
        {
            name:'CRPEX_CODIGO'
        },

        {
            name:'CRPEX_FECHA_EXPULSION'
        },

        {
            name:'CRNOT_NUMERO_NOTIFICACION'
        },

        {
            name:'CREXP_NOMBRE_EXPULSION'
        }
        ]),
        sortInfo:{
            field: 'CRPEX_FECHA_EXPULSION',
            direction: 'ASC'
        },
        baseParams:{
            format:"JSON"
        }
    });


    /**
     * Ext.grid.GridPanel Representacion de los datos  tabular de filas y columnas.
     */
    var grdCgg_res_expulsion_historial = new Ext.grid.GridPanel({
        cm:cmCgg_res_expulsion_historial,
        store:gsCgg_res_expulsion_historial,
        region:'center',
        frame:true,
        sm: new Ext.grid.RowSelectionModel({
            singleSelect: true,
            moveEditorOnEnter: false
        }),
        tbar:['Listado de expulsiones'],
        loadMask: {
            msg: "Cargando..."
        }
    });
    /* *
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto del historial de RESIDENCIA DE NA PERSONA
     */
    var cmCgg_res_residencia_historial = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
        {
            dataIndex:'NUMERO_RESIDENCIA',
            header:'No.',
            width:70,
            sortable:true
        },

        {
            dataIndex:'TIPO_RESIDENCIA',
            header:'Tipo residencia',
            width:300,
            sortable:true
        },

        {
            dataIndex:'CRRES_NUMERO_RESOLUCION',
            header:'Resoluci\u00f3n',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CRRES_FECHA_EMISION',
            header:'Fecha Res.',
            width:120,
            sortable:true,
            renderer:truncDateTime
        },

        {
            dataIndex:'CRRSD_FECHA_INICIO',
            header:'Fecha inicio',
            width:120,
            sortable:true,
            renderer:truncDateTime
        },

        {
            dataIndex:'CRRSD_FECHA_CADUCIDAD',
            header:'Fecha Caducidad',
            width:120,
            sortable:true,
            renderer:truncDateTime
        },

        {
            dataIndex:'CRRSD_VIGENTE',
            header:'Estado',
            width:80,
            sortable:true,
            xtype: 'booleancolumn',
            trueText: 'Vigente',
            falseText: 'No vigente'
        }
        ]);

    /**
     * Ext.data.Store Agrupacion de registros  por un campo especifico.
     */
    var gsCgg_res_residencia_historial = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS + "Cgg_res_persona",
            method:"selectHistorialResidencia"
        }),
        reader:new Ext.data.JsonReader({}, [
        {
            name:'NUMERO_RESIDENCIA'
        },

        {
            name:'TIPO_RESIDENCIA'
        },

        {
            name:'CRRES_NUMERO_RESOLUCION'
        },

        {
            name:'CRRES_FECHA_EMISION'
        },

        {
            name:'CRRSD_FECHA_INICIO'
        },

        {
            name:'CRRSD_FECHA_CADUCIDAD'
        },

        {
            name:'CRRSD_VIGENTE'
        }
        ]),
        sortInfo:{
            field: 'CRRSD_FECHA_INICIO',
            direction: 'ASC'
        },
        baseParams:{
            format:"JSON"
        },
        listeners:{
            load:function(inStore, inRecords, inOptions){
                for (var i = 0; i < inRecords.length; i++){
                    var tmpCaduca = inRecords[i].get('CRRSD_VIGENTE');
                    if(tmpCaduca==true){
                        grdCgg_res_residencia_historial.getView().getRow(i).style.backgroundColor = '#FFFFE0';
                    }
                }
                if(gsCgg_res_residencia_historial.data.length>0)
                    btnCarnetCgg_res_carnet.setDisabled(false);
            }
        }
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos  tabular de filas y columnas.
     */
    var grdCgg_res_residencia_historial = new Ext.grid.GridPanel({
        cm:cmCgg_res_residencia_historial,
        store:gsCgg_res_residencia_historial,
        region:'center',
        frame:true,
        sm: new Ext.grid.RowSelectionModel({
            singleSelect: true,
            moveEditorOnEnter: false
        }),
        tbar:['Listado de residencias'],
        loadMask: {
            msg: "Cargando..."
        }
    });

    var btnCarnetCgg_res_carnet = new Ext.Button({
        id: 'btnCarnetCgg_res_carnet',
        name: 'btnCarnetCgg_res_carnet',
        text: 'Ver Carnet',
        iconCls: 'iconPreview',
        disabled:true,
        listeners:{
            click:function(){
                var carnetWin = new FrmListadoCgg_res_carnet(inDesktop,txtCrper_num_doc_identific_historial.getValue());
                carnetWin.show();
                carnetWin.loadHistorico();
            }
        }
    });


    /**
     /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO
     */
    var txtCrper_codigo = new Ext.form.TextField({
        id:'txtCrper_codigo',
        name:'txtCrper_codigo',
        fieldLabel :'Codigo',
        anchor:'80%',
        readOnly:'true',
        allowBlank :false

    });
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO
     */
    var Crper_num_doc_identific="";
    var txtCrper_num_doc_identific_historial = new Ext.form.TextField({
        id:'txtCrper_num_doc_identific_historial',
        name:'txtCrper_num_doc_identific_historial',
        fieldLabel :'Numero de documento',
        anchor:'98%',
        allowBlank :false,
        labelWidth:60,
        enableKeyEvents:true,
        listeners: {
            specialkey: function(field, e) {
                if (e.getKey() == e.ENTER) {
                    consultarPersona(txtCrper_num_doc_identific_historial.getValue());
                }
            }
        }
    });

    /**
     * CODIGO IDENTIFICATIVO DE REGISTRO
     */
    var btnCrper_codigoCgg_res_historial_persona = new Ext.Button({
        id:'btnCrper_codigoCgg_res_historial_persona',
        iconCls:'iconBuscar',
        tooltip:TypeTooltip.BUSCAR + ' residente',
        listeners:{
            click:function() {                
                var tmpTimeout = Ext.Ajax.timeout;
                Ext.Ajax.timeout = 90000;
                var tmpPersonaHistorial = new PersonaHistorial();
                var objBusqueda = new DlgBusqueda(tmpPersonaHistorial.getStore(), tmpPersonaHistorial.getCm());
                objBusqueda.closeHandler(function() {
                    Ext.Ajax.timeout = tmpTimeout;
                    if (objBusqueda.getSelectedRow()) {
                        Ext.getCmp('pnlPersonaConsulta').getEl().mask('Cargando...', 'x-mask-loading');
                        tmpInformacionPersona = objBusqueda.getSelectedRow().json;
                        txtCrper_codigo.setValue(tmpInformacionPersona.CRPER_CODIGO);
                        txtCrper_num_doc_identific_historial.setValue(tmpInformacionPersona.CRPER_NUM_DOC_IDENTIFIC);
                        Crper_num_doc_identific= tmpInformacionPersona.CRPER_NUM_DOC_IDENTIFIC;
                        tmpInfoPersona.overwrite(Ext.getCmp('pnlPersonaConsulta').body, tmpInformacionPersona);
                        Ext.getCmp('pnlPersonaConsulta').getEl().unmask();
                        if (tmpInformacionPersona.CRPER_CODIGO != null) {                        
                            if (tmpInformacionPersona.CRPER_GENERO == TypeGenero.FEMENINO) {
                                objImageDefault.AVATAR = 'resources/images/female_avatar.jpg';
                                tplImagePersona.overwrite(pnlImage.body, objImageDefault);
                            }else {
                                objImageDefault.AVATAR = 'resources/images/male_avatar.jpeg';
                                tplImagePersona.overwrite(pnlImage.body, objImageDefault);
                            }                        
                            consultarImagenPersona();
                            pnlPersonaConsultaEstadia.setVisible(true);
                            try {
                                
                                function CallBackCgg_persona(r) {
                                    if (r.length > 2) {
                                        tmpInformacionPersonaEstadia = Ext.util.JSON.decode(r)[0];
                                        tmpInfoPersonaEstadia.overwrite(Ext.getCmp('pnlPersonaConsultaEstadia').body, tmpInformacionPersonaEstadia);
                                    }
                                    else {
                                        pnlPersonaConsultaEstadia.setVisible(false);
                                    }
                                    Ext.getCmp('pnlPersonaConsultaEstadia').getEl().unmask();
                                }
                                Ext.getCmp('pnlPersonaConsultaEstadia').getEl().mask('Cargando...', 'x-mask-loading');
                                var param = new SOAPClientParameters();
                                param.add('inCrper_codigo', txtCrper_codigo.getValue());
                                param.add('format', TypeFormat.JSON);
                                SOAPClient.invoke(URL_WS + "Cgg_res_persona", "selectPersonaTiempoEstadia", param, true, CallBackCgg_persona);
                            } catch(inErr) {


                            }
                        }

                    }

                });
                objBusqueda.show();
            }
        }
    });
	
    function consultarPersona(inCrper_num_doc_identific){        
        Ext.getCmp('pnlPersonaConsulta').getEl().mask('Cargando...', 'x-mask-loading');
        try {          
            tmpInfoPersona.overwrite(Ext.getCmp('pnlPersonaConsulta').body, datosPersona);
            pnlPersonaConsultaEstadia.setVisible(false);
            function CallBackCgg_persona(r) {
                var tmpResponse = Ext.util.JSON.decode(r);
                tmpInformacionPersona = tmpResponse.dataSet[0];
                Ext.getCmp('pnlPersonaConsulta').getEl().unmask();
                if (tmpInformacionPersona) {                    
                    Crper_num_doc_identific = tmpInformacionPersona.CRPER_NUM_DOC_IDENTIFIC;
                    txtCrper_codigo.setValue(tmpInformacionPersona.CRPER_CODIGO);
                    tmpInfoPersona.overwrite(Ext.getCmp('pnlPersonaConsulta').body, tmpInformacionPersona);
                    if (tmpInformacionPersona.CRPER_CODIGO != null) {
                        if (tmpInformacionPersona.CRPER_GENERO && tmpInformacionPersona.CRPER_GENERO == TypeGenero.FEMENINO) {
                            objImageDefault.AVATAR = 'resources/images/female_avatar.jpg';
                            tplImagePersona.overwrite(pnlImage.body, objImageDefault);
                        }
                        else {
                            objImageDefault.AVATAR = 'resources/images/male_avatar.jpeg';
                            tplImagePersona.overwrite(pnlImage.body, objImageDefault);
                        }                    
                        consultarImagenPersona();
                        pnlPersonaConsultaEstadia.setVisible(true);
                        
                        function CallBackCgg_personaEstadia(r) {
                            if (r.length > 2){
                                tmpInformacionPersonaEstadia = Ext.util.JSON.decode(r)[0];
                                tmpInfoPersonaEstadia.overwrite(Ext.getCmp('pnlPersonaConsultaEstadia').body,tmpInformacionPersonaEstadia)
                            }else{
                                pnlPersonaConsultaEstadia.setVisible(false);
                            }
                            Ext.getCmp('pnlPersonaConsultaEstadia').getEl().unmask();
                        }

                        Ext.getCmp('pnlPersonaConsultaEstadia').getEl().mask('Cargando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCrper_codigo', txtCrper_codigo.getValue());
                        param.add('format', TypeFormat.JSON);
                        SOAPClient.invoke(URL_WS + "Cgg_res_persona", "selectPersonaTiempoEstadia", param, true, CallBackCgg_personaEstadia);
                    } else {

                        Ext.Msg.show({
                            title:tituloCgg_res_persona_historial,
                            msg: 'No existe el registro solicitado.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.INFO
                        });
                        pnlPersonaConsultaEstadia.setVisible(false);

                    }
                }else{
                    Ext.MsgPopup.msg(tituloCgg_res_persona_historial, 'La persona requerida no existe.');
                }
            }
            var param = new SOAPClientParameters();
            param.add('start', 0);
            param.add('limit', 30);
            param.add('sort', 'CRPER_NOMBRES');
            param.add('dir', 'ASC');
            param.add('keyword', '');
            param.add('inIdentificacion', inCrper_num_doc_identific);
            param.add('format', TypeFormat.JSON);
            SOAPClient.invoke(URL_WS + "Cgg_res_persona", "selectConsultaPersonaGeneral", param, true, CallBackCgg_persona);
        } catch(inErr) {
            Ext.MsgPopup.msg(tituloCgg_res_persona_historial, "Se produjo una problema al consultar la persona.<br>Error:"+inErr+'.<br>'+ERR_MESSAGE, MsgPopup.WARNING);
            Ext.getCmp('pnlPersonaConsulta').getEl().unmask();
        }
    }

    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_persona_historial.
     */

    var btnCerrarCgg_res_persona_historial = new Ext.Button({
        id:'btnCerrarCgg_res_persona_historial',
        text:'Salir',
        iconCls:'iconCerrar',
        tooltip:TypeTooltip.CERRAR,
        listeners:{
            click:function() {
                pnlPersonaHistorial.items =[];
                winFrmCgg_res_persona_historial.close();
            }
        }
    });


    var datosPersona = {
        CRPER_NUMERO_RESIDENCIA:'',
        CRPER_TIPO_PERSONA:'',
        CRPER_NOMBRES:'',
        CRPER_APELLIDO_PATERNO:'',
        CRPER_APELLIDO_MATERNO:'',
        CRDID_TIPO:'',
        CRPER_NUM_DOC_IDENTIFIC:'',
        CRPER_LUGAR_NACIMIENTO:'',
        CRPER_GENERO:'',
        CRECV_ESTADO_CIVIL:'',
        CGNCN_NOMBRE:'',
        CCNT_NOMBRE_ORIGEN:'',
        CCNT_NOMBRE:'',
        CRPER_CUPO_VEHICULAR:''
    };
    
    /*template de la consulta de persona historial*/
    var tmpInfoPersona;
    tmpInfoPersona = new Ext.XTemplate(
        '<table width="100%" style ="font-size: 12px;font-family:Arial, Helvetica, sans-serif" cellpadding="0">' +
        '<tr rowspan="0">'+
        '<td><b>Documento:</b></td>' +
        '<td>{CRDID_TIPO}</td></td>' +
        '<td><b>No.:</b></td>' +
        '<td>{CRPER_NUM_DOC_IDENTIFIC}</font></td></td>' +
        '<tr rowspan="0">'+
        '<td><b>Nombres:</b></td>' +
        '<td>{CRPER_NOMBRES}</td></td>' +
        '<td><b>Apellidos:</b></td>' +
        '<td>{CRPER_APELLIDO_PATERNO} {CRPER_APELLIDO_MATERNO}</td></td>' +
        '<tr rowspan="0">'+
        '<td><b>No.residencia:</b></td>' +
        '<td>{CRPER_NUMERO_RESIDENCIA}</td></td>' +
        '<td><b>Nacionalidad:</b></td>' +
        '<td>{CGNCN_NOMBRE}</td></td>' +
        '<tr rowspan="0">'+
        '<td><b>Prov de nac.:</b></td>' +
        '<td>{CRPER_LUGAR_NACIMIENTO}</td></td>' +
        '<td><b>Fecha de nac.:</b></td>' +
        '<td>{[this.myDate(values.CRPER_FECHA_NACIMIENTO)]}</td></tr>' +
        '<td><b>G&eacute;nero:</b></td>' +
        '<td>',
        '<tpl if="CRPER_GENERO ==TypeGenero.MASCULINO">',
        '<b>Masculino</b>',
        '</tpl>',
        '<tpl if="CRPER_GENERO ==TypeGenero.FEMENINO">',
        '<b>Femenino</b>',
        '</tpl>',
        '</td>' +
        '<td><b>Estado civil:</b></td>' +
        '<td>{CRECV_ESTADO_CIVIL}</td></td>' +
        '<tr rowspan="0"><td><b>Prov. de res.:</b></td>' +
        '<td>{CCNT_NOMBRE}</td></td>' +
        '<td><b>Tiene veh\u00edculo:</b></td>' +
        '<td>',
        '<tpl if="CRPER_CUPO_VEHICULAR ==true">',
        '<b>Si dispone</b>',

        '</tpl>',
        '<tpl if="CRPER_CUPO_VEHICULAR ==false">',
        '<b>No dispone</b>',
        '</tpl>',
        '</td>' +
        '</table>',
        {
            // XTemplate configuration:
            compiled: true,
            disableFormats: true,
            // member functions:
            myDate: function(CRPER_FECHA_NACIMIENTO) {
                return truncDate(CRPER_FECHA_NACIMIENTO);
            }
        }

        );

    var objImageDefault = {
        AVATAR:'resources/images/male_avatar.jpeg',
        ID:''
    };

    var tplImagePersona = new Ext.Template('<div style="position:absolute; top:0px; left:0px;height: 100% ; width: 100% ; padding:5px 0px 0px 5px"' +
        '><img id="imgFotoPrs{ID}" name="imgFotoPrs" src={AVATAR} width = "95%"  height = "95%" /></div>');

    var pnlImage = new Ext.Panel({
        id:'pnlImage',
        frame:true,
        region:'east',
        width: 150,
        height:150,
        data:objImageDefault,
        tpl:tplImagePersona
    });


    var datosPersonaResidencia = {
        CRRES_RESIDENCIA:'0',
        CRRSD_NUMERO_DIAS:'0',
        CRRSD_FECHA_INICIO:'',
        CRRSD_FECHA_CADUCIDAD:'',
        CRRES_DIAS_TRANSCURRIDOS:'0',
        CRRES_DIAS_RESTANTES:'0',
        CRRSD_VIGENTE:'0',
        TIPO_OPERACION:'',
        CADUCIDAD:'0',
        DIAS_VIGENTE:'0'


    };
    /*template de la consulta de persona historial*/
    var tmpInfoPersonaEstadia = new Ext.XTemplate(
        '<table width="100%" cellpadding="5" style ="font-size: 12px;font-family:Arial, Helvetica, sans-serif" cellspacing=5>' +
        '<tr>'+
        '<td width="90px"><b>Residencia:<b></td>		<td width="200px">{TIPO_RESIDENCIA}</td>' +
        '<td><b>Fecha inicio:</b></td>	<td>{[this.myDate(values.FECHA_INICIO)]}</td>' +
        '<td><b>F. caducidad:</b></td>	<td>{[this.myDate(values.FECHA_CADUCIDAD)]}</td>' +
        '</tr><tr>' +
        //'<td><b>Estadia m&aacute;xima:</b></td><td>{DIAS_AUTORIZADOS}  d&iacute;a</td>' +
        //'<td><b>Estadia actual<b></td>	<td>{ESTADIA_ACTUAL} d&iacute;as </td>' +
        '<td><b>D&iacute;as vigente:</td><td><b>',
        '<tpl if="0<=DIAS_VIGENTE">','{DIAS_VIGENTE}','</tpl>',
        '<tpl if="DIAS_VIGENTE<=0 && TIPO_OPERACION ==0">','Exedido','</tpl>',
        '</b></td>' +
        '</tr><tr>' +
        '<td><b>Est.residencia:</b></td><td><b>',
        '<tpl if="CRRSD_VIGENTE ==true">','Vigente','</tpl>',
        '<tpl if="CRRSD_VIGENTE ==false">','No vigente','</tpl>',
        '</b></td>' +
        '<td><b>Est. migratorio:</b></td><td colspan=2><b>',
        '<tpl if="TIPO_OPERACION==0 && CADUCIDAD==false">',
        '<span style="color:red;font-size:11px">Se encuentra en la provincia <br/>y residencia a caducado</span>',
        '</tpl>',
        '<tpl if="TIPO_OPERACION==1 && CADUCIDAD==true">',
        'No se encuentra en la provincia, residencia vigente',
        '</tpl>',
        '<tpl if="TIPO_OPERACION==1 && CADUCIDAD==false">',
        'No se encuentra en la provincia',
        '</tpl>',
        '<tpl if="TIPO_OPERACION==0 && CADUCIDAD==true">',
        'Se encuentra en la provincia',
        '</tpl>',
        '</b></td>' +
        '</tr>'+
        '</table>',
        {
            compiled: false,
            disableFormats: true,
            myDate: function(CRRSD_RESIDENCIA) {
                return truncDate(CRRSD_RESIDENCIA);
            }
        }
        );

    /**
     * Ext.form.FormPanel Panel principal que contiene los  datos persona.
     */
    var pnlPersonaConsul = new Ext.Panel({
        region:'north',
        height:210,
        layout:'border',
        items:[
        {
            xtype:'fieldset',
            columnWidth: 0.75,
            layout:'form',
            title:'Datos personales',
            region:'center',
            items:[
            {
                xtype:'panel',
                layout:'column',
                items:[

                {
                    columnWidth:.6,
                    layout:'form',
                    labelWidth:140,
                    items:[txtCrper_num_doc_identific_historial]
                },

                {
                    columnWidth:.05,
                    layout:'form',
                    items:[btnCrper_codigoCgg_res_historial_persona]
                }
                ]
            },
            {
                xtype:'panel',
                id :'pnlPersonaConsulta',
                data:datosPersona,
                tpl:tmpInfoPersona,
                height:130
            }
            ]
        } ,
        pnlImage
        ]
    });


    /*panel que contiene los datos de persona del historial de estadia*/

    var pnlPersonaConsultaEstadia = new  Ext.form.FieldSet({
        id:'pnlPersonaConsultaEstadia',
        region:'center',
        title:'Estadia',
        data:datosPersonaResidencia,
        tpl:tmpInfoPersonaEstadia,
        frame:false
    });
    
    pnlPersonaConsultaEstadia.setVisible(false);
    /**panel que visualiza los registros del template persona para observado*/
    var pnlConsuPersona1 = new Ext.Panel({
        height:170,
        layout:'border',
        region:'north',
        items:[
        {
            xtype:'fieldset',
            layout:'form',
            title:'Datos personales',
            region:'center',
            items:[{
                xtype:'panel',
                id :'pnlConsultapersonaObservado',
                data:datosPersona
            }]
        },{
            xtype:'panel',
            id :'pnlImageObservado',
            frame:true,
            height:160,
            width:160,
            region:'east',
            data:objImageDefault,
            tpl:tplImagePersona
        }
        ]
    });
    /**panel que visualiza los registros del template persona para notificado*/
    var pnlConsuPersona = new Ext.Panel({
        id:'pnlConsuPersona',
        layout:'border',
        region:'north',
        height:170,
        items:[
        {
            xtype:'fieldset',
            layout:'form',
            region:'center',
            title:'Datos personales',
            autoScroll:true,
            items:[
            {
                xtype:'panel',
                id :'pnlConsultapersonaNotificado',
                data:datosPersona
            }
            ]
        },{
            xtype:'panel',
            id :'pnlImageNotificado',
            frame:true,
            region:'east',
            height:160,
            width:160,
            data:objImageDefault,
            tpl:tplImagePersona
        }
        ]
    });
    /**panel que visualiza los registros del template persona*/
    var pnlConsuPersonaRecordMigratorio = new Ext.Panel({
        id:'pnlConsuPersonaRecordMigratorio',
        region:'north',
        layout:'border',
        height:170,
        items:[
        {
            xtype:'fieldset',
            title:'Datos personales',
            region:'center',
            autoScroll:true,
            items:[
            {
                xtype:'panel',
                id :'pnlConsultapersonaRecordigratorio',
                data:datosPersona
            }
            ]
        },{
            xtype:'panel',
            id :'pnlImageRecord',
            region:'east',
            frame:true,
            height:160,
            width:160,
            data:objImageDefault,
            tpl:tplImagePersona
        }
        ]

    });

    /**panel que visualiza los registros del template persona*/
    var pnlConsuPersonaMovilidadInterna = new Ext.Panel({
        id:'pnlConsuPersonaMovilidadInterna',
        height:170,
        region:'north',
        layout:'border',
        items:[
        {
            xtype:'fieldset',
            region:'center',
            title:'Datos personales',
            autoScroll:true,
            items:[{
                xtype:'panel',
                id :'pnlConsultapersonaMovilidadInterna',
                data:datosPersona
            }
            ]
        },{
            xtype:'panel',
            id :'pnlImageMovilidadInterna',
            frame:true,
            region:'east',
            height:160,
            width:160,
            data:objImageDefault,
            tpl:tplImagePersona
        }
        ]
    });
    /**panel que visualiza los registros del template persona*/
    var pnlConsultaPersonaExpulsion = new Ext.Panel({
        height:170,
        region:'north',
        layout:'border',
        items:[
        {
            xtype:'fieldset',
            layout:'form',
            region:'center',
            title:'Datos personales',
            items:[
            {
                xtype:'panel',
                id :'pnlConsultapersonaExpulsion',
                data:datosPersona
            }
            ]
        },{
            xtype:'panel',
            id :'pnlImageExpulsion',
            frame:true,
            height:160,
            region:'east',
            width:160,
            data:objImageDefault,
            tpl:tplImagePersona
        }
        ]
    });
    /**panel que visualiza los registros del template persona*/
    var pnlConsultaResidenciaHistorial = new Ext.Panel({
        height:170,
        region:'north',
        layout:'border',
        items:[
        {
            xtype:'fieldset',
            layout:'form',
            region:'center',
            title:'Datos personales',
            items:[
            {
                xtype:'panel',
                id :'pnlConsultaresidenciaHistorial',
                data:datosPersona
            }
            ]
        },{
            xtype:'panel',
            id :'pnlImageResidencia',
            frame:true,
            height:160,
            region:'east',
            width:160,
            data:objImageDefault,
            tpl:tplImagePersona
        }
        ]
    });
	
	var btnEmitirCertificadoResidente = new Ext.Button({		
		text:'Emitir certificado',
		id:'btnEmitirCertificadoResidente',
		iconCls:'iconImprimir',
		handler:function(){
			var param = new SOAPClientParameters();
			param.add('inCgcsn_codigo','CERT_RES');
			var res = SOAPClient.invoke(URL_WS + "Cgg_configuracion", "generaNumero", param, false, false);
			var reporte = new Reporte("rptCertificadoResidenciaporNumIdentificacion", '/Reports/sii/residencia', {
				P_NUMERO_CERTIFICADO:res,
				P_CUSU_CODIGO:new UserSession().getUserID(),
				P_CRPER_NUM_DOC_IDENTIFIC:Crper_num_doc_identific
			});
			reporte.show();
		}
	});
	var btnEmitirCertificadoNotificado= new Ext.Button({
		text:'Emitir certificado',
		id:'btnEmitirCertificadoNotificado',
		iconCls:'iconImprimir',
		handler:function(){
			var tmp=grdCgg_res_notificacion.getSelectionModel().getSelected();
			var reporte = new Reporte("rptCertificadoNotificacionPersona", '/Reports/sii/residencia', {
				P_NUMERO_CERTIFICADO:prompt('Numero de certificado?'),
				P_CUSU_CODIGO:new UserSession().getUserID(),
				P_CRPER_NUM_DOC_IDENTIFIC:Crper_num_doc_identific
			});
			reporte.show();
		}
	});
	var btnEmitirCertificadoObservado = new Ext.Button({
		text:'Emitir certificado',
		id:'btnEmitirCertificadoObservado',
		iconCls:'iconImprimir',
		handler:function(){
			var reporte = new Reporte("rptCertificadoObservacionporEstado", '/Reports/sii/residencia', {
				P_NUMERO_CERTIFICADO:prompt('Numero de certificado?'),
				P_CUSU_CODIGO:new UserSession().getUserID(),
				P_CRPER_NUM_DOC_IDENTIFIC:Crper_num_doc_identific
			});
			reporte.show();
		}
	});
    var groupPanel = {
        xtype: 'grouptabpanel',
        tabWidth: 175,
        activeGroup: 0,
        id:'grouptabpanelHistorial',
        items: [{
            mainItem: 1,
            items: [
            {
                title: 'Record migratorio',
                iconCls: 'iconhistorial',
                id:'Record migratorio',
                listeners:{
                    activate :function(t) {
                        objImageDefault.ID=t.id;
                            
                        tmpInfoPersona.overwrite(Ext.getCmp('pnlConsultapersonaRecordigratorio').body,tmpInformacionPersona);
                        tplImagePersona.overwrite(Ext.getCmp('pnlImageRecord').body,objImageDefault);

                        if (tmpArchivosResult[0].CRPER_FOTO != undefined)
                        {
                            var tmpFoto = document.getElementById("imgFotoPrs"+t.id);
                            tmpFoto.src = 'data:image/jpg;base64,'+ tmpArchivosResult[0].CRPER_FOTO;
                        }
                        gsCgg_res_recordmigratorio_historial.baseParams.start = 0;
                        gsCgg_res_recordmigratorio_historial.baseParams.limit = RECORD_PAGE;
                        gsCgg_res_recordmigratorio_historial.baseParams.inCrper_codigo = txtCrper_codigo.getValue();
                        gsCgg_res_recordmigratorio_historial.reload();
                    }

                },
                frame:true,
                layout:'border',
                items:[ pnlConsuPersonaRecordMigratorio,grdCgg_res_recordmigratorio_historial]
            },
            {
                xtype: 'panel',
				id:'pnlHistorialPersona',
                title: 'Historial persona',
                tabTip: 'Historial persona',
                layout:'border',
                frame:true,
                items: [pnlPersonaConsul,pnlPersonaConsultaEstadia],
                bbar:[btnEmitirCertificadoResidente]
            },
            {
                title: 'Desplazamiento interno',
                iconCls: 'iconTodo',
                layout:'border',
                id:'Desplazamiento interno',
                listeners:{
                    activate :function(t) {
                        objImageDefault.ID=t.id;
                            
                        tmpInfoPersona.overwrite(Ext.getCmp('pnlConsultapersonaMovilidadInterna').body,tmpInformacionPersona);
                        tplImagePersona.overwrite(Ext.getCmp('pnlImageMovilidadInterna').body,objImageDefault);
                            
                        if (tmpArchivosResult[0].CRPER_FOTO != undefined)
                        {
                            var tmpFoto = document.getElementById("imgFotoPrs"+t.id);
                            tmpFoto.src = 'data:image/jpg;base64,'+ tmpArchivosResult[0].CRPER_FOTO;
                        }
                        gsCgg_res_movilidadinterna_historial.baseParams.start = 0;
                        gsCgg_res_movilidadinterna_historial.baseParams.limit = RECORD_PAGE;
                        gsCgg_res_movilidadinterna_historial.baseParams.inCrper_codigo = txtCrper_codigo.getValue();
                        gsCgg_res_movilidadinterna_historial.reload();
                    }
                },
                frame:true,
                items:[ pnlConsuPersonaMovilidadInterna,grdCgg_res_movilidadinterna_historial]
            },{
                title: 'Notificaci\u00f3n',
                iconCls: 'iconListado',
                tabTip: 'Consulta notificaciones',
                id:'Notificacion',
                layout:'border',
                listeners:{
                    activate :function(t) {
                        objImageDefault.ID=t.id;
                            
                        tmpInfoPersona.overwrite(Ext.getCmp('pnlConsultapersonaNotificado').body,tmpInformacionPersona);
                        tplImagePersona.overwrite(Ext.getCmp('pnlImageNotificado').body,objImageDefault);
                            
                        if (tmpArchivosResult[0].CRPER_FOTO != undefined)
                        {
                            var tmpFoto = document.getElementById("imgFotoPrs"+t.id);
                            tmpFoto.src = 'data:image/jpg;base64,'+ tmpArchivosResult[0].CRPER_FOTO;
                        }
                        gsCgg_res_notificacion_historial.baseParams.inCrper_codigo = txtCrper_codigo.getValue();
                        gsCgg_res_notificacion_historial.reload();
                    }
                },
                frame:true,
                items:[pnlConsuPersona,grdCgg_res_notificacion],
                bbar:[btnEmitirCertificadoNotificado]
            },{
                title: 'Expulsi\u00f3n',
                iconCls: 'iconListado',
                tabTip: 'Consulta expulsiones',
                id:'Expulsion',
                listeners:{
                    activate :function(t) {
                        objImageDefault.ID=t.id;
                            
                        tmpInfoPersona.overwrite(Ext.getCmp('pnlConsultapersonaExpulsion').body,tmpInformacionPersona);
                        tplImagePersona.overwrite(Ext.getCmp('pnlImageExpulsion').body,objImageDefault);
                            
                        if (tmpArchivosResult[0].CRPER_FOTO != undefined)
                        {
                            var tmpFoto = document.getElementById("imgFotoPrs"+t.id);
                            tmpFoto.src = 'data:image/jpg;base64,'+ tmpArchivosResult[0].CRPER_FOTO;
                        }
                        //gsCgg_res_observacion.baseParams.inCrper_codigo = txtCrper_codigo.getValue();
                        //gsCgg_res_observacion.reload();
                    }
                },
                frame:true,
                layout:'border',
                items:[pnlConsultaPersonaExpulsion,grdCgg_res_expulsion_historial]
            }/*,{
                title: 'Observaciones',
                tabTip: 'Consulta observaciones persona',
                iconCls:'iconTodo',
                frame:true,
                id:'Observacion',
                layout:'border',
                listeners:{
                    activate :function(t) {
                        objImageDefault.ID=t.id;
                            
                        tmpInfoPersona.overwrite(Ext.getCmp('pnlConsultapersonaObservado').body,tmpInformacionPersona);
                        tplImagePersona.overwrite(Ext.getCmp('pnlImageObservado').body,objImageDefault);

                        if (tmpArchivosResult[0].CRPER_FOTO != undefined)
                        {
                            var tmpFoto = document.getElementById("imgFotoPrs"+t.id);
                            tmpFoto.src = 'data:image/jpg;base64,'+ tmpArchivosResult[0].CRPER_FOTO;
                        }
                        gsCgg_res_observacion.baseParams.inCrper_codigo = txtCrper_codigo.getValue();
                        gsCgg_res_observacion.reload();
                    }
                },
                items:[pnlConsuPersona1, grdCgg_res_observacion],
                bbar:[btnEmitirCertificadoObservado]
            }*/,
            {
                title: 'Residencia',
                tabTip: 'Historial de residencia',
                iconCls:'iconTodo',
                frame:true,
                id:'Residencia',
                layout:'border',
                listeners:{
                    activate :function(t) {
                        objImageDefault.ID=t.id;
                            
                        tmpInfoPersona.overwrite(Ext.getCmp('pnlConsultaresidenciaHistorial').body,tmpInformacionPersona);
                        tplImagePersona.overwrite(Ext.getCmp('pnlImageResidencia').body,objImageDefault);

                        if (tmpArchivosResult[0].CRPER_FOTO != undefined)
                        {
                            var tmpFoto = document.getElementById("imgFotoPrs"+t.id);
                            tmpFoto.src = 'data:image/jpg;base64,'+ tmpArchivosResult[0].CRPER_FOTO;
                        }
                        gsCgg_res_residencia_historial.baseParams.inCrper_codigo = txtCrper_codigo.getValue();
                        gsCgg_res_residencia_historial.reload();
                    }
                },
                items:[pnlConsultaResidenciaHistorial,grdCgg_res_residencia_historial]
            }
            ]
        }
        ]
    };

    //AC==>
    var btnAdjuntos = new Ext.ux.form.AlfrescoFM({
        id:'compAdjunto',   //(opcional)
        name:'compAdjunto', //(opcional)
        text: 'Adjuntos',    //(opcional -> Texto del botón)
        tableName: 'Cgg_res_persona',
        validateRecordID:true,
        recordID : null,
        filter : null
    });

    btnAdjuntos.addListener("updateData",function(t){
        t.recordID = null;
        t.recordID = tmpInformacionPersona!=undefined?tmpInformacionPersona.CRPER_CODIGO:null;
        t.filter = null;
        rTramite=null;
    });

    //<== AC


    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar consulta de persona.
     */
    var pnlPersonaHistorial = new Ext.form.FormPanel({
        height:450,
        minheight:450,
        layout:'fit',
        region:'center',
        items:[
        groupPanel
        ]
    });

    if (!inDesktop!== null && inDesktop!==undefined) {
        var  winFrmCgg_res_persona_historial = inDesktop.createWindow({
            id:'winFrmCgg_res_persona_historial',
            title:tituloCgg_res_persona_historial,
            tbar:getPanelTitulo(tituloCgg_res_persona_historial, descCgg_res_persona_historial),
            layout:'border',
            items:[pnlPersonaHistorial],
            width:950,
            minWidth:950,
            height:600,
            minheight:500,
            maximizable:true,
            minimizable:true,
            constrain:true,
            resizable:true,
            iconCls:'iconHistorialPersona',
            bbar:[btnAdjuntos,btnCarnetCgg_res_carnet,'->',btnCerrarCgg_res_persona_historial]
        });
        winFrmCgg_res_persona_historial.on("beforeclose",function(){
            pnlPersonaHistorial.items =[];
        });
		
    }
	applyGrants(Ext.getCmp("pnlHistorialPersona").getBottomToolbar());
	applyGrants(Ext.getCmp("Observacion").getBottomToolbar());
	applyGrants(Ext.getCmp("Notificacion").getBottomToolbar());

    /**
     * Funcion que permite consultar informacion de archivos generales correspondientes a la persona
     * */
    var tmpArchivosResult;
    function consultarImagenPersona(){
        try{
            function CallBackCgg_res_adjuntos(r){
                tmpArchivosResult=  Ext.util.JSON.decode(r);
                if (tmpArchivosResult[0].CRPER_FOTO != undefined){
                    try{
                        var tmpFoto = document.getElementsByName("imgFotoPrs")[0];
                        tmpFoto.src = 'data:image/jpg;base64,'+ tmpArchivosResult[0].CRPER_FOTO;
                    }catch(inErr){
                        alert(inErr);
                    }
                }
                pnlImage.getEl().unmask();
            }

            pnlImage.getEl().mask('Cargando...', 'x-mask-loading');
            var param = new SOAPClientParameters();
            param.add('inCrper_codigo',txtCrper_codigo.getValue());
            param.add('format',TypeFormat.JSON);
            SOAPClient.invoke(urlCgg_res_persona,'selectAdjuntosIdentificacionById',param, true, CallBackCgg_res_adjuntos);
        }catch(inErr){
            Ext.Msg.show({
                title:tituloCgg_res_persona_historial,
                msg: 'La informaci\u00f3n de documentos adjuntos no ha podido ser consultada.',
                buttons: Ext.Msg.OK,
                icon: Ext.MessageBox.ERROR
            });
        }
    }

    function habilitarCgg_res_persona_historialCtrls(inEstado) {
        estado = !inEstado;
        txtCrper_num_doc_identific_historial.setDisabled(estado);
        btnCrper_codigoCgg_res_historial_persona.setDisabled(estado);
        pnlPersonaHistorial.setDisabled(estado);
        btnCerrarCgg_res_persona_historial.setDisabled(estado);
    }

    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_persona_historial.
     * @returns ventana winFrmCgg_res_persona_historial.
     * @base FrmCgg_res__persona_historial.prototype.show
     */
    this.getWindow = function() {
        return winFrmCgg_res_persona_historial;
    }

    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_persona_historial.
     * @base Cgg_res_persona_historial.prototype.loadData
     */
    this.loadData = function() {
        cargarCgg_res_personaHistorialCtrls();
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_persona_historial desde una instancia.
 */
FrmCgg_res_persona_historial.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_persona_historial desde una instancia.
 */
FrmCgg_res_persona_historial.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_persona_historial,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_persona_historial.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_persona_historial desde una instancia.
 */
FrmCgg_res_persona_historial.prototype.loadData = function(){
    this.loadData();
}