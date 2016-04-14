/**
 * Created by IntelliJ IDEA.
 * User: BSX06
 * Date: 09/12/2010
 * Time: 05:50:22 PM
 * To change this template use File | Settings | File Templates.
 */
/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_movilidad_interna.
 * @param {String} IN_SENTENCIA_CGG_RES_MOVILIDAD_INTERNA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_RES_MOVILIDAD_INTERNA Registro de datos de la tabla Cgg_res_movilidad_interna.
 * @constructor
 * @base FrmListadoCgg_res_movilidad_interna
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_movilidad_interna_ingreso(IN_SENTENCIA_CGG_RES_MOVILIDAD_INTERNA,IN_RECORD_CGG_RES_MOVILIDAD_INTERNA){
    var inSentenciaCgg_res_movilidad_interna_ingreso = IN_SENTENCIA_CGG_RES_MOVILIDAD_INTERNA;
    var inRecordCgg_res_movilidad_interna_ingreso=IN_RECORD_CGG_RES_MOVILIDAD_INTERNA;
    var urlCgg_res_movilidad_interna_ingreso=URL_WS+"Cgg_res_movilidad_interna";
    var tituloCgg_res_movilidad_interna_ingreso='Registro desplazamiento interno';
    var descCgg_res_movilidad_interna_ingreso='El formulario permite administrar la informaci\u00f3n del desplazamiento interno';
    var isEdit = false;
    var tmpcrmov_ext_codigo_ingreso;
    var tmpCrper_mov_codigo;
    var tmpMovimientoInterno_ingreso;
    var tmpCrres_tipo_operacion_ingreso;
    var tmpInformacionPersonaIngreso;
    var tmpInformacionPersonaIngreso1;
    var tmpStoreEmbarcacion;
    var tmpStoreAerolinea;
	var tmpStoreHospedaje;
	var tmpStoreActividad;
    var tmpUserSession;
    /**
     * Ext.data.Store Almacenamiento de informacion de muelle.
     */
    var tmpStoreMuelle = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_muelle",
            method:"selectAll"
        }),
        reader:new Ext.data.JsonReader({},[
            {name:'CRMLE_CODIGO'},
            {name:'CCTN_CODIGO'},
            {name:'CRMLE_NOMBRE'}
        ]),
        baseParams:{
            format:TypeFormat.JSON
        },
        listeners:{
            load:function(){
                cbxMuelleOrigenIngreso.store = tmpStoreMuelle;
                cbxMuelleDestinoIngreso.store = tmpStoreMuelle;
                cbxMuelleDestinoIngreso.setValue(tmpUserSession.getUserData().CRMLE_CODIGO);
            }
        }
    });
    tmpStoreMuelle.load();

    /**
     * Ext.data.Store Almacenamiento de informacion de AEROPUERTO.
     */
    var tmpGsAeropuerto = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_aeropuerto",
            method:"selectAll"
        }),
        reader:new Ext.data.JsonReader({},[
            {name:'CARPT_CODIGO'},
            {name:'CCTN_CODIGO'},
            {name:'CARPT_NOMBRE'},
            {name:'CARPT_TIPO_AEREOPUERTO'}
        ]),
        baseParams:{
            format:TypeFormat.JSON
        },
        listeners:{
            load:function(inStore, inRecords, inOptions){
                for(i = 0; i < inRecords.length; i++)
                    if(inRecords[i].data.CARPT_TIPO_AEREOPUERTO == 0)
                        inStore.remove(inRecords[i]);
                inStore.sort('CARPT_NOMBRE', 'ASC');
                cbxAeropuertoDestinoIngreso.store = tmpGsAeropuerto;
                cbxAeropuertoOrigenIngreso.store = tmpGsAeropuerto;
                cbxAeropuertoDestinoIngreso.setValue(tmpUserSession.getUserData().CARPT_CODIGO);
            }
        }
    });
    tmpGsAeropuerto.load();

    /**
     * Ext.data.Store Agrupacion de registros de varias tablas por un campo especifico.
     */
    gsMovilidadInternaIngreso = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS + "Cgg_res_movilidad_interna",
            method:"selectMovilidadInternaPersona",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRMIV_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        }, [{name:'CRMVI_CODIGO'},
            {name:'CRPER_CODIGO'},
            {name:'CRDID_CODIGO'},
            {name:'CRPER_TIPO_DOCUMENTO'},
            {name:'CRPER_NUM_DOC_IDENTIFIC'},
            {name:'CRPER_NUMERO_RESIDENCIA'},
            {name:'CRPER_NOMBRES'},
            {name:'CRPER_APELLIDO_PATERNO'},
            {name:'CRPER_APELLIDO_MATERNO'},
            {name:'CRPER_GENERO'},
            {name:'CRPER_FECHA_NACIMIENTO'},
            {name:'CGNCN_CODIGO'},
            {name:'CRPER_NACIONALIDAD'},
            {name:'TIPO_RESIDENCIA'},
            {name:'CRMVI_TIPO_OPERACION'},
            {name:'CRMLE_CODIGO'},
            {name:'CRMLE_NOMBRE'},
            {name:'CGG_CRMLE_CODIGO'},
            {name:'CGG_CRMLE_NOMBRE'},
            {name:'CREMB_CODIGO'},
            {name:'CREMB_NOMBRE'},
            {name:'CARPT_CODIGO'},
            {name:'CARPT_NOMBRE'},
            {name:'CGG_CARPT_CODIGO'},
            {name:'CARPT_NOMBRE_DESTINO'},
            {name:'CRALN_CODIGO'},
            {name:'CRALN_NOMBRE'},
            {name:'CRALN_DESCRIPCION_VUELO'}

        ]), sortInfo:{
            field: 'CRMVI_CODIGO',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON"
        }
    });

    function MovilidadInternaIngreso() {
        var cmMovilidadInternaIngreso = null;
        var gsMovilidadInternaIngreso = null;
        /**
         * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_persona.
         *
         */
        cmMovilidadInternaIngreso = new Ext.grid.ColumnModel([
            {dataIndex:'CRPER_TIPO_DOCUMENTO',header:'Documento',width:150,sortable:true},
            {dataIndex:'CRPER_NUM_DOC_IDENTIFIC',header:'No.documento',width:150,sortable:true},
            {dataIndex:'CRPER_NOMBRES',header:'Nombres',width:150,sortable:true},
            {dataIndex:'CRPER_APELLIDO_PATERNO',header:'Apellido paterno',width:150,sortable:true},
            {dataIndex:'CRPER_APELLIDO_MATERNO',header:'Apellido materno',width:150,sortable:true},
            {dataIndex:'CRPER_NUM_DOC_IDENTIFIC',header:'Num doc identific',width:150,sortable:true},
            {dataIndex:'CRPER_FECHA_NACIMIENTO',header:'Fecha nacimiento',width:150,sortable:true,renderer:truncDate},
            {dataIndex:'CRPER_GENERO',header:'Genero',width:150,sortable:true},
            {dataIndex:'CRPER_NUMERO_RESIDENCIA',header:'Numero residencia',width:150,sortable:true},
            {dataIndex:'CRMVI_TIPO_OPERACION',header:'Tipo operacion',width:150,sortable:true},
            {dataIndex:'CREMB_NOMBRE',header:'Embarcaci\u00f3n',width:150,sortable:true}
        ]);
        this.getCm = function() {
            return cmMovilidadInternaIngreso;
        };
    }

    MovilidadInternaIngreso.prototype.getColumnModel = function() {
        return this.getCm();
    };

    var datosPersonaIngreso = {
        TIPO_RESIDENCIA:'0',
        CRPER_NOMBRES:'0',
        CRPER_APELLIDO_PATERNO:'0',
        CRDID_TIPO:'0',
        CRPER_NUM_DOC_IDENTIFIC:'0',
        CRPER_LUGAR_NACIMIENTO:'0',
        CRPER_GENERO:' ',
        CRPER_NACIONALIDAD:'0'
    };
    /*template de la consulta de persona historial*/
    var tmpInfoPersonaIngresoInterno;
    tmpInfoPersonaIngresoInterno = new Ext.XTemplate(
            '<table width="45%" height="120%"  class="CggTemplate" cellspacing=5>' +
                '<tr><th>Nombre:</th><td><span>{CRPER_NOMBRES}</span></td></tr>',
                '<tr><th>Apellido:</th><td><span>{CRPER_APELLIDO_PATERNO} {CRPER_APELLIDO_MATERNO}</span></td></tr>',
                '<tr><th>Documento Iden.:</th><td><span>{CRPER_NUM_DOC_IDENTIFIC}</span></td></tr>',
                '</font></td></span></td></tr>',
                '<tr><th>Fecha Nacimiento:</th><td><span>{[this.myDate(values.CRPER_FECHA_NACIMIENTO)]}</span></td></tr>',
                '<tr><th>Nacionalidad:</th><td><span>{CRPER_NACIONALIDAD}</span></td></tr>',
				'<tr><th>Tipo residencia:</th><td><span>{TIPO_RESIDENCIA}</span></td></tr>',
                '<tr><th>G\u00E9nero:</th><td><span<tpl if="CRPER_GENERO ==TypeGenero.MASCULINO">',
                '<span style="font-weight: bold;">Masculino</span>',

                '</tpl>',
                '<tpl if="CRPER_GENERO ==TypeGenero.FEMENINO">',
                '<b>Femenino</b>',
                '</tpl>',
                '</font></td></span></td></tr>',
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
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD
     */
    var btnCrmov_codigoCgg_res_movilidad_interna_ingreso= new Ext.Button({
        id:'btnCrmov_codigoCgg_res_movilidad',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_res_movilidad_interna = new MovilidadInternaIngreso();
                var objBusqueda = new DlgBusqueda(gsMovilidadInternaIngreso, tmpFLCgg_res_movilidad_interna.getCm());
                objBusqueda.closeHandler(function(){
                    // var tmpRecordIngreso = objBusqueda.getSelectedRow();
                    var tmpRecordIngreso1 = objBusqueda.getSelectedRow();
                    if(tmpRecordIngreso1){
                        tmpcrmov_ext_codigo_ingreso=tmpRecordIngreso1.get('CRMOV_CODIGO');
                        txtCrper_codigo_mvi_ingreso.setValue(tmpRecordIngreso1.get('CRPER_CODIGO'));
                        txtTipo_documento_ingreso.setValue(tmpRecordIngreso1.get('CRPER_NUM_DOC_IDENTIFIC'));
                        tmpInfoPersonaIngresoInterno.overwrite(Ext.getCmp('pnlPersonaConsultaIngreso').body, tmpRecordIngreso1.json);
                        txtCrmvi_codigo_salida.setValue(tmpRecordIngreso1.get('CRMVI_CODIGO'));
                        cbxMuelleOrigenIngreso.setValue(tmpRecordIngreso1.get('CRMLE_CODIGO'));
                        cbxEmbarcacionIngreso.setValue(tmpRecordIngreso1.get('CREMB_CODIGO'));
                        cbxAeropuertoOrigenIngreso.setValue(tmpRecordIngreso1.get('CARPT_NOMBRE'));
                        cbxAeropuertoDestinoIngreso.setValue(tmpRecordIngreso1.get('CARPT_NOMBRE_DESTINO'));
                        txtCraln_descripcion_vuelo_ingreso.setValue(tmpRecordIngreso1.get('CRALN_NOMBRE'));
                        cbxAerolineaIngreso.setValue(tmpRecordIngreso1.get('CRALN_DESCRIPCION_VUELO'));
                        gsCgg_tct_actividad_reg_interno.reload({
                            params:{
                                inCrmvi_codigo:txtCrmvi_codigo_salida.getValue(),
                                format:TypeFormat.JSON
                            }
                        });
                        gsCgg_tct_tipo_hospedaje_reg_ingreso.reload({
                            params:{
                                inCrmvi_codigo:txtCrmvi_codigo_salida.getValue(),
                                format:TypeFormat.JSON
                            }
                        });
                    }});
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD INTERNA
     */
    var txtCrmvi_codigo_salida= new Ext.form.TextField({
        id:'txtCrmvi_codigo_salida',
        name:'txtCrmvi_codigo_salida',
        fieldLabel :'Codigo',
        anchor:'98%'
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD
     */
    var txtCrmov_codigo_mvi = new Ext.form.TextField({
        id:'txtCrmov_codigo_mvi',
        name:'txtCrmov_codigo_mvi',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true'

    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD INTERNA
     */
    var txtCrmvi_codigo_ingreso = new Ext.form.TextField({
        id:'txtCrmvi_codigo_ingreso',
        name:'txtCrmvi_codigo_ingreso',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true
    });

    //Creamos una definici?n de los campos que vienen en el Json remoto

    var cbxMuelleOrigenIngreso = new Ext.form.ComboBox({
        id:'cbxMuelleOrigenIngreso',
        name:'cbxMuelleOrigenIngreso',
        displayField: "CRMLE_NOMBRE",
        fieldLabel :'Origen',
        valueField: 'CRMLE_CODIGO',
        mode:'local',
        typeAhead:true,
        autoSelect:true,
        forceSelection:true,
        editable:false,
        submitValue:true,
        anchor:'75%',
        triggerAction:'all'

    });
    //Creamos una definici?n de los campos que vienen en el Json remoto

    var cbxMuelleDestinoIngreso = new Ext.form.ComboBox({
        id:'cbxMuelleDestinoIngreso',
        name:'cbxMuelleDestinoIngreso',
        displayField: "CRMLE_NOMBRE",
        fieldLabel :'Destino',
        valueField: 'CRMLE_CODIGO',
        mode:'local',
        typeAhead:true,
        autoSelect:true,
        forceSelection:true,
        editable:false,
        submitValue:true,
        anchor:'75%',
        triggerAction:'all'

    });
    var chkCrmvi_estado = new Ext.form.Checkbox({
        id:'chkCrmvi_estado',
        name:'chkCrmvi_estado',
        fieldLabel:'Verificar ingreso',
        allowBlank :false,
        checked:false,
        submitValue:false
    });


    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE EMBARCACION
     */
    var txtCremb_codigo_ingreso = new Ext.form.TextField({
        id:'txtCremb_codigo_ingreso',
        name:'txtCremb_codigo_ingreso',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });

    //Creamos una definici?n de los campos que vienen en el Json remoto

    var cbxEmbarcacionIngreso = new Ext.form.ComboBox({
        id:'cbxEmbarcacionIngreso',
        name:'cbxEmbarcacionIngreso',
        displayField: "CREMB_NOMBRE",
        fieldLabel :'Embarcacion',
        valueField: 'CREMB_CODIGO',
        mode:'local',
        typeAhead:true,
        autoSelect:true,
        forceSelection:true,
        triggerAction:'all',
        editable:false,
        submitValue:true,
        anchor:'75%',
        emptyText : 'Seleccione una opci\u00f3n..'

    });
    //Creamos una definici?n de los campos que vienen en el Json remoto

    var cbxAeropuertoOrigenIngreso = new Ext.form.ComboBox({
        id:'cbxAeropuertoOrigenIngreso',
        name:'cbxAeropuertoOrigenIngreso',
        displayField: "CARPT_NOMBRE",
        fieldLabel :'Origen',
        valueField: 'CARPT_CODIGO',
        mode:'local',
        typeAhead:true,
        autoSelect:true,
        forceSelection:true,
        triggerAction:'all',
        editable: true,
        submitValue:true,
        anchor:'75%',
        emptyText : 'Seleccione una opci\u00f3n..'

    });
    //Creamos una definici?n de los campos que vienen en el Json remoto

    var cbxAeropuertoDestinoIngreso = new Ext.form.ComboBox({
        id:'cbxAeropuertoDestinoIngreso',
        name:'cbxAeropuertoDestinoIngreso',
        displayField: "CARPT_NOMBRE",
        fieldLabel :'Destino',
        valueField: 'CARPT_CODIGO',
        mode:'local',
        typeAhead:true,
        autoSelect:true,
        forceSelection:true,
        editable: true,
        triggerAction:'all',
        submitValue:true,
        anchor:'75%',
        emptyText : 'Seleccione una opci\u00f3n..'

    });
    //Creamos una definici?n de los campos que vienen en el Json remoto

    var cbxAerolineaIngreso = new Ext.form.ComboBox({
        id:'cbxAerolineaIngreso',
        name:'cbxAerolineaIngreso',
        displayField: "CRALN_NOMBRE",
        fieldLabel :'Aerolinea',
        valueField: 'CRALN_CODIGO',
        mode:'local',
        typeAhead:true,
        autoSelect:true,
        hiddenValue:'id',
        forceSelection:true,
        editable: true,
        triggerAction:'all',
        submitValue:true,
        anchor:'98%',
        emptyText : 'Seleccione una opci\u00f3n..'

    });

    /**
     * Ext.form.NumberField CODIGO DE BARRAS GENERADO PARA EL REGISTRO DE TCT
     */
    var txtTipo_documento_ingreso = new Ext.form.TextField({
        id:'txtTipo_documento_ingreso',
        name:'txtTipo_documento_ingreso',
        fieldLabel :'No.Documento',
        anchor:'98%',
        listeners:{
            specialkey :function(inField, e){
                if (e.getKey() == e.ENTER) {

                    try {
                        function CallBackCgg_persona(r) {
                            tmpInformacionPersonaIngreso = Ext.util.JSON.decode(r)[0];
                            if (tmpInformacionPersonaIngreso) {
                                txtCrper_codigo_mvi_ingreso.setValue(tmpInformacionPersonaIngreso.CRPER_CODIGO);
                                tmpInfoPersonaIngresoInterno.overwrite(Ext.getCmp('pnlPersonaConsultaIngreso').body,tmpInformacionPersonaIngreso);
                                txtCrmvi_codigo_salida.setValue(tmpInformacionPersonaIngreso.CRMVI_CODIGO);
                                tmpcrmov_ext_codigo_ingreso=tmpInformacionPersonaIngreso.CRMOV_CODIGO;
                                cbxMuelleOrigenIngreso.setValue(tmpInformacionPersonaIngreso.CRMLE_CODIGO);
                                cbxMuelleDestinoIngreso.setValue(tmpInformacionPersonaIngreso.CGG_CRMLE_CODIGO);
                                cbxEmbarcacionIngreso.setValue(tmpInformacionPersonaIngreso.CREMB_CODIGO);
                                cbxAeropuertoOrigenIngreso.setValue(tmpInformacionPersonaIngreso.CARPT_NOMBRE);
                                cbxAeropuertoDestinoIngreso.setValue(tmpInformacionPersonaIngreso.CARPT_NOMBRE_DESTINO);
                                txtCraln_descripcion_vuelo_ingreso.setValue(tmpInformacionPersonaIngreso.CRALN_NOMBRE);
                                cbxAerolineaIngreso.setValue(tmpInformacionPersonaIngreso.CRALN_DESCRIPCION_VUELO);
                                gsCgg_tct_actividad_reg_interno.reload({
                                    params:{
                                        inCrmvi_codigo:txtCrmvi_codigo_salida.getValue(),
                                        format:TypeFormat.JSON
                                    }
                                });
                                gsCgg_tct_tipo_hospedaje_reg_ingreso.reload({
                                    params:{
                                        inCrmvi_codigo:txtCrmvi_codigo_salida.getValue(),
                                        format:TypeFormat.JSON
                                    }
                                });


                            }
                            if(tmpInformacionPersonaIngreso.CRMLE_CODIGO!=null){
                                pnlfsAerolinea_ingreso.setVisible(false);
                            }else{
                                pnlfsAerolinea_ingreso.setVisible(true);
                                pnlfsMuelle_ingreso.setVisible(false);
                            }
                        }

                        var param = new SOAPClientParameters();
                        param.add('in_crper_numero_identificacion',txtTipo_documento_ingreso.getValue());
                        param.add('format', TypeFormat.JSON);
                        SOAPClient.invoke(URL_WS + "Cgg_res_movilidad_interna", "selectMovilidadInternaBuscarSalida", param, true, CallBackCgg_persona);
                    } catch(inErr) {
                        //winFrmCgg_institucion_educativa.getEl().unmask();
                    }
                }
            }
        }
    });

    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO  DE PERSONA
     */
    var txtCrper_codigo_mvi_ingreso = new Ext.form.TextField({
        id:'txtCrper_codigo_mvi_ingreso',
        name:'txtCrper_codigo_mvi_ingreso',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });


    /**
     * Ext.form.DateField FECHA DE NACIMIENTO
     */
    var dtCrper_fecha_nacimiento_mvi_ingreso = new Ext.form.DateField({
        id:'dtCrper_fecha_nacimiento_mvi_ingreso',
        name:'dtCrper_fecha_nacimiento_mvi_ingreso',
        fieldLabel :'Fecha nacimiento',
        //allowBlank :false,
        format:'d/m/Y',
        disabled:true
    });


    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD
     */
    var txtCrmov_codigo_mvi_ingreso = new Ext.form.TextField({
        id:'txtCrmov_codigo_mvi_ingreso',
        name:'txtCrmov_codigo_mvi_ingreso',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * Ext.form.DateField FECHA DE VIAJE
     */
    var dtCrmvi_fecha_ingreso_provincia_mvi_ingreso = new Ext.form.DateField({
        id:'dtCrmvi_fecha_ingreso_provincia_mvi_ingreso',
        name:'dtCrmvi_fecha_ingreso_provincia_mvi_ingreso',
        fieldLabel :'Fecha ingreso',
        // allowBlank :false,
        format :'d/m/Y',
        disabled:true
        //value:new Date()
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCarpt_codigo_ingreso = new Ext.form.TextField({
        id:'txtCarpt_codigo_ingreso',
        name:'txtCarpt_codigo_ingreso',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCgg_carpt_codigo_ingreso = new Ext.form.TextField({
        id:'txtCgg_carpt_codigo_ingreso',
        name:'txtCgg_carpt_codigo_ingreso',
        fieldLabel :'Carpt codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCraln_codigo_ingreso = new Ext.form.TextField({
        id:'txtCraln_codigo_ingreso',
        name:'txtCraln_codigo_ingreso',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });

    /**
     * Ext.form.TextField DESCRIPCION DEL VUELO
     */
    var txtCraln_descripcion_vuelo_ingreso = new Ext.form.TextField({
        id:'txtCraln_descripcion_vuelo_ingreso',
        name:'txtCraln_descripcion_vuelo_ingreso',
        fieldLabel :'Vuelo',
        anchor:'98%'
        //allowBlank :false
    });
    /**
     * Ext.form.DateField FECHA DE VIAJE
     */
    var dtCrmvi_fecha_viaje_ingreso = new Ext.form.DateField({
        id:'dtCrmvi_fecha_viaje_ingreso',
        name:'dtCrmvi_fecha_viaje_ingreso',
        fieldLabel :'Fecha viaje',
        allowBlank :false,
        format :'d/m/Y',
        value:CURRENT_DATE
    });
    /**
     * Ext.form.NumberField TIPO DE OPERACION DE LA PERSONA SOBRE LAS ISLAS
     */
    var numCrmvi_tipo_operacion_ingreso = new Ext.form.NumberField({
        id:'numCrmvi_tipo_operacion_ingreso',
        name:'numCrmvi_tipo_operacion_ingreso',
        fieldLabel :'Tipo operacion',
        disabled :false
    });
    /**
     * Ext.form.TextField DESCRIPCION CORTA
     */
    var txtCrmvi_observacion_ingreso = new Ext.form.TextArea({
        id:'txtCrmvi_observacion_ingreso',
        name:'txtCrmvi_observacion_ingreso',
        fieldLabel :'Observaci\u00f3n',
        anchor:'98%'
    });

    ////////////////////////////////////////////////////////////////
    /*
     Seccion que permite seleccionar los tipos de actividades a realizar en el resgitro
     */
    var smActividadIngreso = new Ext.grid.CheckboxSelectionModel();

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_tct_actividad.
     */
    var cmCgg_tct_actividad_ingreso = new Ext.grid.ColumnModel([
        smActividadIngreso,
        {dataIndex:'CTACT_NOMBRE',header:'Actividad',width:150,sortable:true}]);


    /**
     * Ext.grid.GridPanel Representacion de los datos de la actividad interna en un formato tabular de filas y columnas.
     */
    var grdCgg_tct_actividad_interna_ingreso = new Ext.grid.GridPanel({
        cm:cmCgg_tct_actividad_ingreso,
        region:'center',
        sm:smActividadIngreso,
        height:160,
        viewConfig:{forceFit:true},
        loadMask:{msg:"Cargando..."}
    });

    /**
     * Ext.data.Store Agrupacion de registros de la actividad interna.
     */
    var gsCgg_tct_actividad_reg_interno = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS + "Cgg_res_movilidad_interna",
            method:"selectActividadInterna",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
            id:'CTACT_CODIGO'
        }, [
            {name:'CTACT_CODIGO'},
            {name:'CTACT_NOMBRE'}
        ]),
        baseParams:{inCrmvi_codigo:"", format:"JSON"},
        listeners:{
            load:function(inStore, inRecords, inObject) {
                for (i = 0; i < tmpStoreActividad.getTotalCount(); i++) {
                    for (j = 0; j < gsCgg_tct_actividad_reg_interno.getTotalCount(); j++) {
                        if (tmpStoreActividad.getAt(i).get('CTMAC_CODIGO') == gsCgg_tct_actividad_reg_interno.getAt(j).get('CTMAC_CODIGO'))
                            smActividadIngreso.selectRow(j);
                    }
                }
            }
        }
    });
    /**
     * Ext.form.TextField DESCRIPCION CORTA
     */
    var txtCrmvi_lugar_Hospedaje_ingreso = new Ext.form.TextField({
        id:'txtCrmvi_lugar_Hospedaje_ingreso',
        name:'txtCrmvi_lugar_Hospedaje_ingreso',
        fieldLabel :'Lugar',
        anchor:'98%'
        // allowBlank :false
    });

    /*
     Seccion que permite seleccionar los tipos de actividades internas a realizar en el resgitro
     */
    var smTipo_Hospedaje_Interno_ingreso = new Ext.grid.CheckboxSelectionModel();
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_tct_tipo_hospedaje_interno.
     */
    var cmCgg_tct_tipo_hospedaje_interno_ingreso = new Ext.grid.ColumnModel([
        smTipo_Hospedaje_Interno_ingreso,
        {dataIndex:'CTTHJ_NOMBRE',header:'Hospedaje',width:150,sortable:true}]);


    /**
     * Ext.grid.GridPanel Representacion de los datos de lahospedaje interno en un formato tabular de filas y columnas.
     */
    var grdCgg_tct_tipo_hospedaje_interno_ingreso = new Ext.grid.GridPanel({
        cm:cmCgg_tct_tipo_hospedaje_interno_ingreso,
        region:'center',
        height:160,
        sm:smTipo_Hospedaje_Interno_ingreso,
        loadMask:{msg:"Cargando..."},
        viewConfig:{forceFit:true}
    });

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_tct_agencia_contacto por un campo especifico.
     */
    var gsCgg_tct_tipo_hospedaje_reg_ingreso = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS + "Cgg_res_movilidad_interna",
            method:"selectHospedajeInterno",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
            id:'CTTHJ_CODIGO'
        }, [
            {name:'CTTHJ_CODIGO'},
            {name:'CTTHJ_NOMBRE'}
        ]),
        baseParams:{inCrmvi_codigo:"",format:"JSON"},
        listeners:{
            load:function(inStore, inRecords, inObject) {
                for (i = 0; i < tmpStoreHospedaje.getTotalCount(); i++) {
                    for (j = 0; j < gsCgg_tct_tipo_hospedaje_reg_ingreso.getTotalCount(); j++) {
                        if (tmpStoreHospedaje.getAt(i).get('CTMHJ_CODIGO') == gsCgg_tct_tipo_hospedaje_reg_ingreso.getAt(j).get('CTMHJ_CODIGO'))
                            smTipo_Hospedaje_Interno_ingreso.selectRow(j);
                    }
                }
            }
        }
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_movilidad_interna
     */
    var btnGuardarCgg_res_movilidad_interna_ingreso = new Ext.Button({
        id:'btnGuardarCgg_res_movilidad_interna_ingreso',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (!pnlCgg_res_movilidad_interna_ingreso.getForm().isValid())
                    return;
                if(chkCrmvi_estado.getValue()==true){
                    tmpMovimientoInterno_ingreso=TypeMovimientoInterno.INGRESOISLA;


                    try{
                        function CallBackCgg_res_movilidad_interna(r){

                            winFrmCgg_res_movilidad_interna_ingreso.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloCgg_res_movilidad_interna_ingreso,
                                    msg: 'La informaci\u00f3n de Res movilidad interna ha sido almacenada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });winFrmCgg_res_movilidad_interna_ingreso.close()
                            }else{
                                Ext.Msg.show({
                                    title:tituloCgg_res_movilidad_interna_ingreso,
                                    msg: 'La informaci\u00f3n de Res movilidad interna no ha podido ser almacenada. '+r,
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }
                        }
                        winFrmCgg_res_movilidad_interna_ingreso.getEl().mask('Guardando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        if(isEdit)
                            param.add('inCrmvi_codigo',txtCrmvi_codigo_ingreso.getValue());
                        param.add('inCrmle_codigo',cbxMuelleOrigenIngreso.getValue()?cbxMuelleOrigenIngreso.getValue():null);
                        param.add('inCgg_crmle_codigo',cbxMuelleDestinoIngreso.getValue()?cbxMuelleDestinoIngreso.getValue():null);
                        param.add('inCremb_codigo',cbxEmbarcacionIngreso.getValue()?cbxEmbarcacionIngreso.getValue():null);
                        param.add('inCrper_codigo',txtCrper_codigo_mvi_ingreso.getValue());
                        param.add('inCrmov_codigo',tmpcrmov_ext_codigo_ingreso);
                        param.add('inCarpt_codigo',cbxAeropuertoOrigenIngreso.getValue()?cbxAeropuertoOrigenIngreso.getValue():null);
                        param.add('inCgg_carpt_codigo',cbxAeropuertoDestinoIngreso.getValue()?cbxAeropuertoDestinoIngreso.getValue():null);
                        param.add('inCraln_codigo',cbxAerolineaIngreso.getValue()?cbxAerolineaIngreso.getValue():null);
                        param.add('inCraln_descripcion_vuelo',txtCraln_descripcion_vuelo_ingreso.getValue()?txtCraln_descripcion_vuelo_ingreso.getValue():null);
                        param.add('inCrmvi_fecha_viaje',dtCrmvi_fecha_viaje_ingreso.getValue().format('c'));
                        param.add('inCrmvi_tipo_operacion',tmpMovimientoInterno_ingreso);
                        param.add('inCrmvi_observacion',txtCrmvi_observacion_ingreso.getValue());
                        param.add('inCtmhj_lugar_hospedaje',null);
                        param.add('inHospedajeInterno_JSON', createJSONObject(grdCgg_tct_tipo_hospedaje_interno_ingreso.getSelectionModel().getSelections()));
                        param.add('inActividadInterna_JSON', createJSONObject(grdCgg_tct_actividad_interna_ingreso.getSelectionModel().getSelections()));
                        SOAPClient.invoke(urlCgg_res_movilidad_interna_ingreso,IN_SENTENCIA_CGG_RES_MOVILIDAD_INTERNA,param, true, CallBackCgg_res_movilidad_interna);
                    }catch(inErr){
                        winFrmCgg_res_movilidad_interna_ingreso.getEl().unmask();
                    }}else
                {
                    Ext.Msg.show({
                        title:tituloCgg_res_movilidad_interna_ingreso,
                        msg: 'Por favor verifique el ingreso de la persona.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.ERROR
                    });
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_movilidad_interna.
     */
    var btnCancelarCgg_res_movilidad_interna_ingreso = new Ext.Button({
        id:'btnCancelarCgg_res_movilidad_interna_ingreso',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_res_movilidad_interna_ingreso.getForm().reset();
                //alert(txtCrmvi_codigo_ingreso.getValue());
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_movilidad_interna.
     */
    var btnCerrarCgg_res_movilidad_interna_ingreso = new Ext.Button({
        id:'btnCerrarCgg_res_movilidad_interna_ingreso',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_res_movilidad_interna_ingreso.close();
            }}
    });
    /**
     * Ext.Panel Panel que contiene los datos informativos de persona
     */
    var pnlCgg_res_persona_movilidad_ingreso = new Ext.form.FieldSet({
        id:'pnlCgg_res_persona_movilidad_ingreso',
        title:'Persona',
        collapsible:true,
		height:218,
        region:'center',
        items:[{xtype:'panel', id :'pnlPersonaConsultaIngreso',data:datosPersonaIngreso,tpl:tmpInfoPersonaIngresoInterno, width:885} ]


    });
    /**
     * Ext.Panel Panel que contiene los controles de la actividad y el  tipo hospedaje
     */
    var pnlCgg_tct_actividad_hospedaje_interno_ingreso = new Ext.form.FieldSet({
        id:'pnlCgg_tct_actividad_hospedaje_interno_ingreso',
        title:'Datos adicionales',
        collapsible:true,
        region:'center',
        layout:'column',
        height:160,
        items:[
            {columnWidth:.50,layout:'form',items:[grdCgg_tct_actividad_interna_ingreso]},
            {columnWidth:.50,layout:'form',items:[grdCgg_tct_tipo_hospedaje_interno_ingreso]}
        ]
    });
    /* ExtPanel Panel que contiene los controles del muelle y embarcacion
     */
    var pnlfsMuelle_ingreso = new Ext.form.FieldSet({
        id:'pnlfsMuelle_ingreso',
        title:'Puerto Maritimo',
        collapsible:true,
        split:true,
        animCollapse :true,
        labelWidth :100,
        style:{marginLeft:'5px'},
        layout:'form',
        items:[cbxMuelleOrigenIngreso,cbxMuelleDestinoIngreso,cbxEmbarcacionIngreso]
    });
    /* ExtPanel Panel que contiene los controles de la aerolinea y el numero de vuelo
     */
    var pnlfsAerolinea_ingreso = new Ext.form.FieldSet({
        id:'pnlfsAerolinea_ingreso',
        title:'Aerolinea',
        collapsible:true,
        split:true,
        animCollapse :true,
        style:{marginLeft:'5px'},
        labelWidth :100,
        items:[cbxAeropuertoOrigenIngreso,cbxAeropuertoDestinoIngreso,
            {xtype:'panel',layout:'column', //labelWidth :60,
                items:[
                    {
                        columnWidth:.60,layout:'form',items:[cbxAerolineaIngreso]},
                    {columnWidth:.40,layout:'form', labelWidth :40,
                        items:[txtCraln_descripcion_vuelo_ingreso]}
                ]}
        ]
    });
    pnlfsAerolinea_ingreso.setVisible(false);




    /* ExtPanel Panel que contiene los controles de la aerolinea y el numero de vuelo
     */
    var pnlfsOtros_ingreso = new Ext.form.FieldSet({
        id:'pnlfsOtros_ingreso',
        title:'Datos principales',
        collapsible:true,
        layout:'form',
        labelWidth :100,
        height:95,
        style:{marginLeft:'5px'},
        items:[dtCrmvi_fecha_viaje_ingreso,chkCrmvi_estado]
    });


    /**
     * Ext.form.FormPanel Panel para las Fechas
     */
    var pnlOrganizacion_ingreso = new Ext.Panel({
        id:'pnlOrganizacion_ingreso',
        collapsible:false,
        region:'center',
        layout:'form',
        items:[
            {xtype:'panel',layout:'column',
                items:[
                    {columnWidth:.50,layout:'form',
                        items:[pnlCgg_res_persona_movilidad_ingreso]},
                    {columnWidth:.50,layout:'form',
                        items:[pnlfsOtros_ingreso,pnlfsMuelle_ingreso,pnlfsAerolinea_ingreso]}
                ]}
        ]
    });



    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_movilidad_interna.
     */
    var pnlCgg_res_movilidad_interna_ingreso = new Ext.form.FormPanel({
        frame:true,
        region:'center',
        layout:'form',
        labelWidth :100,
        height:500,
        items:[ {xtype:'panel',layout:'column',
            items:[
                {columnWidth:.45,layout:'form',
                    items:[txtTipo_documento_ingreso]},
                {columnWidth:.05,layout:'form',items:[btnCrmov_codigoCgg_res_movilidad_interna_ingreso]}

            ]},pnlOrganizacion_ingreso,pnlCgg_tct_actividad_hospedaje_interno_ingreso,txtCrmvi_observacion_ingreso]

    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_movilidad_interna.
     */
    var winFrmCgg_res_movilidad_interna_ingreso = new Ext.Window({
        id:'winFrmCgg_res_movilidad_interna_ingreso',
        title:tituloCgg_res_movilidad_interna_ingreso,
        width:900,
        minWidth:400,
        maximizable:true,
        minimizable:false,
        constrain:true,
        resizable:true,
        modal:true,
        tbar:getPanelTitulo(tituloCgg_res_movilidad_interna_ingreso,descCgg_res_movilidad_interna_ingreso),
        items:[pnlCgg_res_movilidad_interna_ingreso],
        bbar:[btnGuardarCgg_res_movilidad_interna_ingreso,btnCancelarCgg_res_movilidad_interna_ingreso,'->',btnCerrarCgg_res_movilidad_interna_ingreso]
    });
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_movilidad_interna_ingreso.
     */
    function cargarCgg_res_movilidad_interna_ingresoCtrls(){
        if(inRecordCgg_res_movilidad_interna_ingreso){
            txtCrmvi_codigo_ingreso.setValue(inRecordCgg_res_movilidad_interna_ingreso.get('CRMVI_CODIGO'));
            txtCremb_codigo_ingreso.setValue(inRecordCgg_res_movilidad_interna_ingreso.get('CREMB_CODIGO'));
            txtCrper_codigo_mvi_ingreso.setValue(inRecordCgg_res_movilidad_interna_ingreso.get('CRPER_CODIGO'));
            tmpcrmov_ext_codigo_ingreso=inRecordCgg_res_movilidad_interna_ingreso.get('CRMOV_CODIGO');
            txtCarpt_codigo_ingreso.setValue(inRecordCgg_res_movilidad_interna_ingreso.get('CARPT_CODIGO'));
            txtCgg_carpt_codigo_ingreso.setValue(inRecordCgg_res_movilidad_interna_ingreso.get('CGG_CARPT_CODIGO'));
            txtCraln_codigo_ingreso.setValue(inRecordCgg_res_movilidad_interna_ingreso.get('CRALN_CODIGO'));
            txtCraln_descripcion_vuelo_ingreso.setValue(inRecordCgg_res_movilidad_interna_ingreso.get('CRALN_DESCRIPCION_VUELO'));
            dtCrmvi_fecha_viaje_ingreso.setValue(inRecordCgg_res_movilidad_interna_ingreso.get('CRMVI_FECHA_VIAJE'));
            numCrmvi_tipo_operacion_ingreso.setValue(inRecordCgg_res_movilidad_interna_ingreso.get('CRMVI_TIPO_OPERACION'));
            txtCrmvi_observacion_ingreso.setValue(inRecordCgg_res_movilidad_interna_ingreso.get('CRMVI_OBSERVACION'));
            cbxMuelleOrigenIngreso.setValue(tmpInformacionPersonaIngreso.CRMLE_CODIGO);
            cbxMuelleDestinoIngreso.setValue(tmpInformacionPersonaIngreso.CGG_CRMLE_CODIGO);
            cbxEmbarcacionIngreso.setValue(tmpInformacionPersonaIngreso.CREMB_CODIGO);
            cbxAeropuertoOrigenIngreso.setValue(tmpInformacionPersonaIngreso.CARPT_NOMBRE);
            cbxAeropuertoDestinoIngreso.setValue(tmpInformacionPersonaIngreso.CARPT_NOMBRE_DESTINO);
            cbxAerolineaIngreso.setValue(tmpInformacionPersonaIngreso.CRALN_DESCRIPCION_VUELO);
            gsCgg_tct_actividad_reg_interno.reload({
                params:{
                    inCrmvi_codigo:txtCrmvi_codigo_salida.getValue(),
                    format:TypeFormat.JSON
                }
            });
            gsCgg_tct_tipo_hospedaje_reg_ingreso.reload({
                params:{
                    inCrmvi_codigo:txtCrmvi_codigo_salida.getValue(),
                    format:TypeFormat.JSON
                }
            });
            /*  gsCgg_res_persona.reload({
             params:{
             inCtgtr_codigo:txtCtgtr_codigo.getValue(),
             format:TypeFormat.JSON
             }
             });*/
            isEdit = true;
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_movilidad_interna_ingreso.
     * @returns ventana winFrmCgg_res_movilidad_interna_ingreso.
     * @base FrmCgg_res_movilidad_interna_ingreso.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_movilidad_interna_ingreso;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_movilidad_interna_ingreso.
     * @base FrmCgg_res_movilidad_interna.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_movilidad_interna_ingresoCtrls();
    }

    this.setUserSession = function(inUserSession){
        tmpUserSession = inUserSession;
    }

    this.setStoreAerolinea = function(inStoreAerolinea){
        tmpStoreAerolinea = inStoreAerolinea;
        cbxAerolineaIngreso.store = tmpStoreAerolinea;
    }

    this.setStoreEmbarcacion = function(inStoreEmbarcacion){
        tmpStoreEmbarcacion = inStoreEmbarcacion;
        cbxEmbarcacionIngreso.store = tmpStoreEmbarcacion;
    }
	
	this.setStoreHospedaje = function(inStoreHospedaje){
		tmpStoreHospedaje = inStoreHospedaje;
		grdCgg_tct_tipo_hospedaje_interno_ingreso.store = tmpStoreHospedaje;
	}
	
	this.setStoreActividad = function(inStoreActividad){
		tmpStoreActividad = inStoreActividad;
		grdCgg_tct_actividad_interna_ingreso.store = tmpStoreActividad;
	}
}
FrmCgg_res_movilidad_interna_ingreso.prototype.setUserSession = function(inUserSession){
    this.setUserSession(inUserSession);
}
FrmCgg_res_movilidad_interna_ingreso.prototype.setStoreEmbarcacion = function(inStoreEmbarcacion){
    this.setStoreEmbarcacion(inUserSession);
}
FrmCgg_res_movilidad_interna_ingreso.prototype.setStoreAerolinea = function(inStoreAerolinea){
    this.setStoreAerolinea(inStoreAerolinea);
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_movilidad_interna desde una instancia.
 */
FrmCgg_res_movilidad_interna_ingreso.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_movilidad_interna desde una instancia.
 */
FrmCgg_res_movilidad_interna_ingreso.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_movilidad_interna,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_movilidad_interna_ingreso.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_movilidad_interna desde una instancia.
 */
FrmCgg_res_movilidad_interna_ingreso.prototype.loadData = function(){
    this.loadData();
}

FrmCgg_res_movilidad_interna_ingreso.prototype.setStoreHospedaje = function(inStoreHospedaje){
    this.setStoreHospedaje(inStoreHospedaje);
}

FrmCgg_res_movilidad_interna_ingreso.prototype.setStoreActividad = function(inStoreActividad){
    this.setStoreActividad(inStoreActividad);
}