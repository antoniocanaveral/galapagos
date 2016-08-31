/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_movilidad.
 * @param {String} INSENTENCIA_CGG_RES_MOVILIDAD Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_MOVILIDAD Registro de datos de la tabla Cgg_res_movilidad.
 * @constructor
 * @base FrmListadoCgg_res_movilidad
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_movilidad(INSENTENCIA_CGG_RES_MOVILIDAD,INRECORD_CGG_RES_MOVILIDAD) {
    var inSentenciaCgg_res_movilidad = INSENTENCIA_CGG_RES_MOVILIDAD;
    var inRecordCgg_res_movilidad = INRECORD_CGG_RES_MOVILIDAD;
    var urlCgg_res_movilidad = URL_WS + "Cgg_res_movilidad";
    var tituloCgg_res_movilidad = 'Registro de ingreso de personas a la provincia';
    var descCgg_res_movilidad = 'El formulario permite administrar la informaci\u00f3n del registro de ingreso de personas a la provincia TCT.';
    var isEdit = false;
    var tmpCtreg_codigo;
    var tmpCrper_codigo;
    var tmpCraln_codigo;
    var tmpCarpt_codigo;
    var tmCtfsl_codigo;
    var tmpNumeroIdentifica;
    var tmpPluginTctIngreso; //Variable utilizada para obtener una instancia del objeto plugin para toma de huellas dactilares
    var tmpFirText;//Variable utilizada para la toma y alamacenamiento de infromacion desde el dispositivo biometrico
	var tmpSaveAndClose = false;
	var tmpUserSession;
	var tmpOrgAer;
	var tmpLocal = false;
	var tmpCrrsd_codigo;
	var tmpStoreHospedaje;
	var tmpStoreActividad;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCrmov_codigo = new Ext.form.TextField({
        id:'txtCrmov_codigo',
        name:'txtCrmov_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });

    /**
     * Ext.form.NumberField CODIGO DE BARRAS GENERADO PARA EL REGISTRO DE TCT
     */
    var txtCtreg_codigo_barras = new Ext.form.TextField({
        id:'txtCtreg_codigo_barras',
        name:'txtCtreg_codigo_barras',
        fieldLabel :'C\u00f3digo barras',
        anchor:'98%',
        style: {
            color:'#004A95',
            background:'#FFFFE6'
        },
        listeners:{
            specialkey :function(inField, e){
                if (e.getKey() == e.ENTER) {
					gsCgg_res_buscar_persona_TCT.baseParams.inIdentificacion = txtCtreg_codigo_barras.getValue();
					gsCgg_res_buscar_persona_TCT.baseParams.start = 0;
					gsCgg_res_buscar_persona_TCT.baseParams.limit = 100;
					gsCgg_res_buscar_persona_TCT.reload();
					tmpLocal = true;
                }
            }
        }
    });

    /**
     * Ext.form.NumberField CODIGO DE BARRAS GENERADO PARA EL REGISTRO DE TCT
     */
    var txtCrper_numero_identificativo = new Ext.form.TextField({
        id:'txtCrper_numero_identificativo',
        name:'txtCrper_numero_identificativo',
        fieldLabel :'N. identificaci\u00f3n',
        anchor:'98%',
        style: {
            color:'#004A95',
            background:'#F0FFF2'
        },
        listeners:{
            specialkey :function(inField, e){
                if (e.getKey() == e.ENTER) {
					gsCgg_res_buscar_persona_TCT.baseParams.inIdentificacion = txtCrper_numero_identificativo.getValue();
					gsCgg_res_buscar_persona_TCT.baseParams.start = 0;
					gsCgg_res_buscar_persona_TCT.baseParams.limit = 100;
					gsCgg_res_buscar_persona_TCT.reload();
					tmpLocal = true;
                }
            }
        }
    });

    /**
         * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_movilidad por un campo especifico.
         */
        var gsCgg_res_buscar_persona_TCT = new  Ext.data.Store({
            proxy:new Ext.ux.bsx.SoapProxy({
                url:URL_WS+"Cgg_res_movilidad",
                method:"selectPagePersonasBuscarTCT",
                pagin:true
            }),
            remoteSort:true,
            reader:new Ext.data.JsonReader({
                id:'CRMOV_CODIGO',
                root:'dataSet',
                totalProperty: 'totalCount'
            },[
                {name:'CTREG_CODIGO'},
                {name:'CRPER_CODIGO'},
                {name:'CTGTR_CODIGO'},
                {name:'CTREG_CODIGO_BARRAS'},
                {name:'CRALN_CODIGO'},
				{name:'CGG_CPAIS_CODIGO'},
                {name:'AEROLINEA'},
                {name:'CARPT_CODIGO'},
                {name:'AEROPUER_ORIGEN'},
                {name:'CGG_CARPT_CODIGO'},
                {name:'AEROPUER_DESTINO'},
                {name:'CTREG_FECHA_INGRESO'},
                {name:'CTREG_FECHA_SALIDA'},
                {name:'CRDID_CODIGO'},
                {name:'DOCUMENTO'},
                {name:'CRPER_NUM_DOC_IDENTIFIC'},
                {name:'CRPER_NOMBRES'},
                {name:'CRPER_APELLIDO_PATERNO'},
				{name:'CRPER_APELLIDO_MATERNO'},
                {name:'CRPER_GENERO'},
                {name:'CRPER_FECHA_NACIMIENTO'},
                {name: 'CRPER_SEGUIMIENTO'},
                {name:'CGNCN_CODIGO'},
                {name:'NACIONALIDAD'},
				{name:'CPAIS_CODIGO'},
                {name:'PAIS_RESIDENCIA'},
                {name:'CRTRA_CODIGO'},
                {name:'CRTRA_NUMERO'},
                {name:'TIPO_RESIDENCIA'},
				{name:'CRRSD_CODIGO'},
                {name:'CTREG_ESTADO_REGISTRO'},
				{name:'CRMOV_FILTRO_INTERNO'},
				{name:'CTREG_OBSERVACION'},
                {name:'CTREG_NUMERO_VUELO'}
            ]),
            sortInfo:{
                field: 'CRALN_CODIGO',
                direction: 'ASC'
            },
            baseParams:{
                keyword:'',
                format:'JSON',
				inIdentificacion:'',
				inMovimiento:-1
            },
			listeners:{
				load:function(inSource, inRecords, inOptions){
					if(inRecords.length > 0 && tmpLocal){
						inRecordCgg_res_movilidad = inRecords[0].data;
						cargarCgg_res_movilidadCtrls();
						tmpLocal = false;
					}
				}
			}
        });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_movilidad.
     */
    function BuscarPersonaTCT(){
        var cmCgg_res_buscar_persona_TCT = new Ext.grid.ColumnModel([
            {dataIndex:'CTREG_CODIGO',header:'Codigo',width:150,sortable:true,hidden: true},
            {dataIndex:'CRPER_CODIGO',header:'Codigo',width:150,sortable:true,hidden: true},
            {dataIndex:'CTGTR_CODIGO',header:'Codigo Barras',width:150,sortable:true,hidden:true},
            {dataIndex:'CTREG_CODIGO_BARRAS',header:'Codigo Barras',width:150,sortable:true},
            {dataIndex:'CRALN_CODIGO',header:'Codigo',width:150,sortable:true,hidden: true},
            {dataIndex:'AEROLINEA',header:'Aerolinea',width:150,sortable:true},
            {dataIndex:'CARPT_CODIGO',header:'Codigo',width:150,sortable:true,hidden: true},
            {dataIndex:'AEROPUER_ORIGEN',header:'Aeropuerto Origen',width:150,sortable:true},
            {dataIndex:'CGG_CARPT_CODIGO',header:'Carpt codigo',width:150,sortable:true,hidden: true},
            {dataIndex:'AEROPUER_DESTINO',header:'Aeropuerto Destino',width:150,sortable:true},
            {dataIndex:'CTREG_FECHA_INGRESO',header:'Fecha Ingreso',width:150,sortable:true,renderer:truncDate},
            {dataIndex:'CTREG_FECHA_SALIDA',header:'Fecha Salida',width:150,sortable:true,renderer:truncDate},
            {dataIndex:'DOCUMENTO',header:'Tipo Documnento',width:150,sortable:true},
            {dataIndex:'CRPER_NUM_DOC_IDENTIFIC',header:'Numero Documento',width:150,sortable:true},
            {dataIndex:'CRPER_NOMBRES',header:'Nombres',width:150,sortable:true},
            {dataIndex:'CRPER_APELLIDO_PATERNO',header:'Apellido',width:150,sortable:true},
            {dataIndex:'CRPER_GENERO',header:'Genero',width:150,sortable:true,renderer:function(inCrper_genero){
            		if(!inCrper_genero)
            			inCrper_genero = 0;
                    return dsGeneroPersona[inCrper_genero][1];
                }
            },
            {dataIndex:'CRPER_FECHA_NACIMIENTO',header:'Fecha Nacimiento',width:150,sortable:true,renderer:truncDate},
            {dataIndex:'CGNCN_CODIGO',header:'Codigo',width:150,sortable:true,hidden: true},
            {dataIndex:'CGNCN_CODIGO',header:'Codigo',width:150,sortable:true,hidden: true},
			{dataIndex:'NACIONALIDAD',header:'Nacionalidad',width:150,sortable:true},
			{dataIndex:'CPAIS_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
			{dataIndex:'PAIS_RESIDENCIA',header:'Pais Residencia',width:150,sortable:true},
			{dataIndex:'CRTRA_CODIGO',header:'Carpt codigo',width:150,sortable:true,hidden: true},
			{dataIndex:'CRTRA_NUMERO',header:'Numero Certificado',width:150,sortable:true},
            {dataIndex:'TIPO_RESIDENCIA',header:'Tipo Residencia',width:150,sortable:true},
            {dataIndex:'CTREG_ESTADO_REGISTRO',header:'Estado Registro',width:150,sortable:true,renderer:function(inCreg_estado){
					return dsEstadoRegistroTct[inCreg_estado][1];
                }
            }
        ]);
        
        this.getCm = function() {
            return cmCgg_res_buscar_persona_TCT;
        };
    }
    BuscarPersonaTCT.prototype.getColumnModel = function() {
        return this.getCm();
    };

    /**
     * Boton que permite buscar las pesonas que estan preregistradas para el ingreso a la provincia
     */
    var btnBuscarCodigoBarras = new Ext.Button({
        id:'btnBuscarCodigoBarras',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_res_personasTCT = new BuscarPersonaTCT();
                var objBusqueda = new DlgBusqueda(gsCgg_res_buscar_persona_TCT, tmpFLCgg_res_personasTCT.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        inRecordCgg_res_movilidad = tmpRecord.data;
						cargarCgg_res_movilidadCtrls();
                    }
                });
                objBusqueda.show();
            }
        }
    });
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_aerolinea por un campo especifico.
     */
    var gsCgg_res_aerolinea = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_aerolinea",
            method:"selectAll"
        }),
        reader:new Ext.data.JsonReader({},[
            {name:'CRALN_CODIGO'},
            {name:'CRALN_NOMBRE'},
            {name:'CRALN_TIPO_AEROLINEA'}
        ]),
        baseParams:{
            format:"JSON"
        }
    });

    /**
     * Ext.form.ComboBox Aereolinea de la tct.
     */
    var cbxCraln_codigo = new Ext.form.ComboBox({
        id:'cbxCraln_codigo',
        fieldLabel :'Aerol\u00ednea /Nav\u00edo',
        displayField:'CRALN_NOMBRE',
        store:gsCgg_res_aerolinea,
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
		editable:false,
        triggerAction:'all',
        emptyText:'Seleccione la aerol\u00ednea',
        selectOnFocus:true,
        valueField:'CRALN_CODIGO',
        anchor:'98%'
    });
    gsCgg_res_aerolinea.load();

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCtreg_estado_registro = new Ext.form.TextField({
        id:'txtCtreg_estado_registro',
        name:'txtCtreg_estado_registro',
        fieldLabel :'Estado',
        anchor:'100%',
        readOnly:'true'
    });
    /**
	* Ext.form.DateField FECHA DE VIAJE
	*/
	var dtCrmov_fecha_viaje = new Ext.form.DateField({
		id:'dtCrmov_fecha_viaje',
		name:'dtCrmov_fecha_viaje',
		fieldLabel :'Ingreso',
		allowBlank:false,
		value:CURRENT_DATE
	});
    /**
     * Ext.form.DateField FECHA DE SALIDA DE LA PROVINCIA
     */
    var dtCtreg_fecha_salida = new Ext.form.DateField({
        id:'dtCtreg_fecha_salida',
        name:'dtCtreg_fecha_salida',
        fieldLabel :'Salida',
        format :'d/m/Y',
        readOnly:true
    });
	/**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_aeropuerto por un campo especifico.
     */
    var gsAerOrigen = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_aeropuerto",
            method:"selectAll"
        }),
        reader:new Ext.data.JsonReader({},[
            {name:'CARPT_CODIGO'},
            {name:'CCTN_CODIGO'},
            {name:'CANTON'},
            {name:'CARPT_NOMBRE'},
            {name:'CARPT_TIPO_AEREOPUERTO'}
        ]),
        baseParams:{
            format:"JSON"
        },
		listeners:{
			load:function(inStore, inRecords, inOptions){
				for(i = 0; i < inRecords.length; i++)
					if(inRecords[i].data.CARPT_TIPO_AEREOPUERTO == 1)
						inStore.remove(inRecords[i]);
				cbxCarpt_codigo.store = gsAerOrigen;
				cbxCarpt_codigo.setValue(inStore.getAt(0).data.CARPT_CODIGO);
			}
		}
    });
	gsAerOrigen.reload();
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_aeropuerto por un campo especifico.
     */
    var gsCgg_res_aeropuerto = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_aeropuerto",
            method:"selectAll"
        }),
        reader:new Ext.data.JsonReader({},[
            {name:'CARPT_CODIGO'},
            {name:'CCTN_CODIGO'},
            {name:'CANTON'},
            {name:'CARPT_NOMBRE'},
            {name:'CARPT_TIPO_AEREOPUERTO'}
        ]),
        baseParams:{
            format:"JSON"
        },
		listeners:{
			load:function(){
				loadDefaultData();
			}
		}
    });

    /**
     * Ext.form.ComboBox IDENTIFICATIVO UNICO DE REGISTRO
     */
    var cbxCarpt_codigo= new Ext.form.ComboBox({
        fieldLabel :'Origen',
        displayField:'CARPT_NOMBRE',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
		editable:false,
        triggerAction:'all',
        emptyText:'Seleccione el origen',
        valueField:'CARPT_CODIGO',
        anchor:'98%'
    });

    /**
     * Ext.form.ComboBox IDENTIFICATIVO UNICO DE REGISTRO DE DESTINO
     */
    var cbxCgg_carpt_codigo= new Ext.form.ComboBox({
        id:'cbxCgg_carpt_codigo',
        fieldLabel :'Destino',
        displayField:'CARPT_NOMBRE',
        store:gsCgg_res_aeropuerto,
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        readOnly:true,
        triggerAction:'all',
        emptyText:'Seleccione el destino',
        selectOnFocus:true,
        valueField:'CARPT_CODIGO',
        anchor:'98%'
    });

    ////////////////////////////////////////////////////////////////
    /*
     Seccion que permite seleccionar los tipos de actividades a realizar en el resgitro
     */
    var smActividad = new Ext.grid.CheckboxSelectionModel();

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_tct_actividad.
     */
    var cmCgg_tct_actividad = new Ext.grid.ColumnModel([
        smActividad,
        {dataIndex:'CTACT_NOMBRE',header:'Actividad',width:150,sortable:true}
	]);


    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_tct_actividad en un formato tabular de filas y columnas.
     */
    var grdCgg_tct_actividad = new Ext.grid.GridPanel({
        cm:cmCgg_tct_actividad,
        sm:smActividad,
		height:160,
        loadMask:{
            msg:"Cargando..."
        }
    });

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_tct_agencia_contacto por un campo especifico.
     */
    var gsCgg_tct_actividad_reg = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS + "Cgg_tct_registro",
            method:"selectActividadTct",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
            id:'CTACT_CODIGO'
        }, [
            {name:'CTACT_CODIGO'},
            {name:'CTACT_NOMBRE'}
        ]),
        baseParams:{
            inCtgtr_codigo:"",
            format:"JSON"
        },
        listeners:{
            load:function(inStore, inRecords, inObject) {
                for (var i = 0; i < gsCgg_tct_actividad_reg.getTotalCount(); i++) {
                    for ( var j = 0; j < tmpStoreActividad.getTotalCount(); j++) {
                        if (gsCgg_tct_actividad_reg.getAt(i).get('CTACT_CODIGO')==tmpStoreActividad.getAt(j).get('CTACT_CODIGO'))
                            smActividad.selectRow(j,true);
                    }
                }
            }
        }
    });
    ////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////
    /*
     Seccion que permite seleccionar los tipos de actividades a realizar en el resgitro
     */
    var smTipo_Hospedaje = new Ext.grid.CheckboxSelectionModel();
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_tct_tipo_hospedaje.
     */
    var cmCgg_tct_tipo_hospedaje = new Ext.grid.ColumnModel([
        smTipo_Hospedaje,
        {dataIndex:'CTTHJ_NOMBRE',header:'Hospedaje',width:150,sortable:true}
	]);


    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_tct_tipo_hospedaje en un formato tabular de filas y columnas.
     */
    var grdCgg_tct_tipo_hospedaje = new Ext.grid.GridPanel({
        cm:cmCgg_tct_tipo_hospedaje,
        height:160,
        sm:smTipo_Hospedaje,
        loadMask:{
            msg:"Cargando..."
        }
    });

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_tct_agencia_contacto por un campo especifico.
     */
    var gsCgg_tct_tipo_hospedaje_reg = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS + "Cgg_tct_registro",
            method:"selectHospedajeTct",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
            id:'CTTHJ_CODIGO'
        }, [
            {name:'CTTHJ_CODIGO'},
            {name:'CTTHJ_NOMBRE'}
        ]),
        baseParams:{
            inCtgtr_codigo:"",
            format:"JSON"
        },
        listeners:{
            load:function(inStore, inRecords, inObject) {
                for (var i = 0; i < gsCgg_tct_tipo_hospedaje_reg.getTotalCount(); i++) {
                    for (var  j = 0; j < tmpStoreHospedaje.getTotalCount(); j++) {
                        if (gsCgg_tct_tipo_hospedaje_reg.getAt(i).get('CTTHJ_CODIGO')==tmpStoreHospedaje.getAt(j).get('CTTHJ_CODIGO') )
                            smTipo_Hospedaje.selectRow(j,true);
                    }
                }
            }
        }
    });
	
	var gsCgg_res_documento_identificacio = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_documento_identificacio",
            method:"selectAll",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
        },[
            {name:'CRDID_CODIGO'},
            {name:'CRDID_DESCRIPCION'
            }
        ]),
        baseParams:{
            format:TypeFormat.JSON
        }
    });
	gsCgg_res_documento_identificacio.load();
	
    ///////////////////////////////////////////////////////////////
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
     */
    var txtCrper_codigo = new Ext.form.TextField({
        id:'txtCrper_codigo',
        name:'txtCrper_codigo',
        fieldLabel :'Codigo',
        hidden:true,
        hideLabel:true
    });
    /**
     * Ext.form.ComboBox TIPO DOCUMENTO
     */
	var cbxCrdid_codigo = new Ext.form.ComboBox({
        id:'cbxCrdid_codigo',
        name:'cbxCrdid_codigo',
        fieldLabel :'Tipo de doc.',
        anchor:'98%',
        editable:false,
        displayField:'CRDID_DESCRIPCION',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
		readOnly:true,
        allowBlank :false,
        triggerAction:'all',
        emptyText:'Seleccione un tipo documento identidad',
        selectOnFocus:true,
		store:gsCgg_res_documento_identificacio,
        valueField:'CRDID_CODIGO'
    });
	
    /**
     * Ext.form.TextField NOMBRES DE LA PERSONA
     */
    var txtCrper_nombres = new Ext.form.TextField({
        id:'txtCrper_nombres',
        name:'txtCrper_nombres',
        fieldLabel :'Nombres',
        anchor:'98%',
        editable:false,
        readOnly:true
    });
    /**
     * Ext.form.TextField APELLIDO PATERNO
     */
    var txtCrper_apellido_paterno = new Ext.form.TextField({
        id:'txtCrper_apellido_paterno',
        name:'txtCrper_apellido_paterno',
        fieldLabel :'Apellidos',
        anchor:'98%',
        readOnly:true
    });

    /**
     * Ext.form.TextField NUMERO DE DOCUEMNTO DE IDENTIFICACION
     */
    var txtCrper_num_doc_identific = new Ext.form.TextField({
        id:'txtCrper_num_doc_identific',
        name:'txtCrper_num_doc_identific',
        fieldLabel :'N. identificaci\u00f3n',
        anchor:'98%',
        readOnly:true
    });
    /**
     * Ext.form.TextField APELLIDO PATERNO
     */
    var txtCrtra_codigo = new Ext.form.TextField({
        id:'txtCrtra_codigo',
        name:'txtCrtra_codigo',
        fieldLabel :'Tipo Registro',
        anchor:'98%',
        readOnly:'true'
    });
    /**
     * Ext.form.TextField APELLIDO PATERNO
     */
    var txtCtgtr_codigo = new Ext.form.TextField({
        id:'txtCtgtr_codigo',
        name:'txtCtgtr_codigo',
        fieldLabel :'Codigo_Grupo',
        width:280,
        readOnly:'true'
    });
    /**
     * Ext.form.TextField GENERO DE LA PERSONA
     */
    var cbxCrper_generoMov = new Ext.form.ComboBox({
        id:'cbxCrper_generoMov',
        name:'cbxCrper_generoMov',
        store: dsGeneroPersona,
		fieldLabel:'Genero',
        anchor:'98%',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        editable: false,
        disabled:true,
        allowBlank :false,
        triggerAction:'all',
        emptyText : 'Seleccione el G\u00e9nero'
    });
	
	var cbxCgg_cpais_codigoMov = new Ext.form.ComboBox({
        id:'cbxCgg_cpais_codigoMov',
        name:'cbxCgg_cpais_codigoMov',
        store:SCGG_PAIS,
        fieldLabel :'Pa\u00eds de residencia',
        anchor:'98%',
        displayField:'CPAIS_NOMBRE',		
        typeAhead: true,
        disabled: true,
        mode: 'local',
        forceSelection:true,
        allowBlank :false,
        triggerAction:'all',
        emptyText:'Seleccione la Residencia',
        selectOnFocus:true,
        valueField:'CPAIS_CODIGO'
    });
	
    var cbxCgncn_codigoMov = new Ext.form.ComboBox({
        id:'cbxCgncn_codigoMov',
        name:'cbxCgncn_codigoMov',
        fieldLabel :'Nacionalidad',
        anchor:'98%',
        displayField:'CGNCN_NACIONALIDAD',
        typeAhead: true,
        disabled: true,
        mode: 'local',
        forceSelection:true,
        allowBlank :false,
        triggerAction:'all',
        emptyText:'Seleccione la Nacionalidad',
        selectOnFocus:true,
        valueField:'CGNCN_CODIGO'
    });
    /**
     * Ext.form.TextField NUMERO DE CERTIFICADO DE LA PERSONA Q TIENE UN TRAMITE
     */
    var txtCrtra_numero = new Ext.form.TextField({
        id:'txtCrtra_numero',
        name:'txtCrtra_numero',
        fieldLabel :'N. Certificado',
        anchor:'98%',
        readOnly:true
    });

    /**
     * Ext.form.TextField GENERO DE LA PERSONA
     */
    var txtCtreg_tipo_registro = new Ext.form.TextField({
        id:'txtCtreg_tipo_registro',
        name:'txtCtreg_tipo_registro',
        fieldLabel :'Tipo Registro',
        width:280,
        readOnly:'true',
		disabled:true
    });
    /**
     * Ext.form.DateField FECHA DE NACIMIENTO
     */
    var dtCrper_fecha_nacimiento = new Ext.form.DateField({
        id:'dtCrper_fecha_nacimiento',
        name:'dtCrper_fecha_nacimiento',
        fieldLabel :'F. nacimiento',
        disabled: true,
        format:'d/m/Y',
		maxValue:CURRENT_DATE
    });
	
    /**
     * Ext.form.ComboBox Tipo Operacion
     */
    var cbxCtreg_tipo_operacion = new Ext.form.ComboBox({
        id:'cbxCtreg_tipo_operacion',
        name:'cbxCtreg_tipo_operacion',
        store: dsTipoOperacion,
        fieldLabel :'Tipo Operaci\u00f3n',
        width:200,
        displayField: 'tipo_operacion',
        valueField: 'id',
        mode:'local',
        editable: false,
        triggerAction:'all',
        allowBlank :false,
        emptyText : 'Seleccione una opci\u00f3n..'
    });
    /**
     * Ext.form.TextField NUMERO DE VUELO
     */
    var txtCrmov_numero_vuelo = new Ext.form.TextField({
        id:'txtCrmov_numero_vuelo',
        name:'txtCrmov_numero_vuelo',
        fieldLabel :'Vuelo /N.Nav\u00edo',
        anchor:'98%',
        allowBlank :false,
		maskRe:/[\w\-]+/
    });
    /**
     * Ext.form.TextField DESCRIPCION CORTA DE LA OPERACION
     */
    var txtCrmov_observacion = new Ext.form.TextArea({
        id:'txtCrmov_observacion',
        name:'txtCrmov_observacion',
        fieldLabel :'Observaci\u00f3n',
        anchor:'100%',
		height:36
    });
    /**
     * Ext.form.TextField NUMERO DE DOCUEMNTO DE IDENTIFICACION
     */
    var txtCrmov_tipo_salida = new Ext.form.NumberField({
        id:'txtCrmov_tipo_salida',
        name:'txtCrmov_tipo_salida',
        fieldLabel :'Tipo Salida',
        width:280,
        readOnly:'true'
    });
    /**
     * Ext.form.Checkbox IDENTIFICAR SI LA PERSONA PASO POR EL CONTROL DE NACIONAL O EXTRANJERO
     */
    var chkCrmov_filtro_interno = new Ext.form.Checkbox({
        id:'chkCrmov_filtro_interno',
        name:'chkCrmov_filtro_interno',
        fieldLabel :'Filtros Nacionales?',
        allowBlank:false,
        checked:false
    });

    /**
     * Ext.form.Checkbox IDENTIFICAR SI LA PERSONA SE ENCUENTRA EN SEGUIMIENTO O NO
     */
    var chkCrmov_seguimiento = new Ext.form.Checkbox({
        id:'chkCrmov_seguimiento',
        name:'chkCrmov_seguimiento',
        fieldLabel :'Seguimiento',
        allowBlank:false,
        checked:false
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_movilidad
     */
    var btnGuardarCgg_res_movilidad = new Ext.Toolbar.SplitButton({
        id:'btnGuardarCgg_res_movilidad',
        text:'Guardar',
        iconCls:'iconGuardar',
		menu:[{text:'Guardar y salir',handler:function(){
			tmpSaveAndClose = true;
			btnGuardarCgg_res_movilidad.fireEvent('click', btnGuardarCgg_res_movilidad);
		}}],
        listeners:{
            click:function() {
				/*if (smTipo_Hospedaje.length == 0){
					Ext.Msg.show({
						title:tituloCgg_res_movilidad,
						msg: 'Seleccione al menos un hospedaje.',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.WARNING
					});
					return;
				}
				if (smActividad.getSelections().length == 0){
					Ext.Msg.show({
						title:tituloCgg_res_movilidad,
						msg: 'Seleccione al menos una actividad.',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.WARNING
					});
					return;
				}*/
                if (pnlCgg_res_movilidad.getForm().isValid() == false) {
                    return;
                }
                try {
                    function CallBackCgg_res_movilidad(r) {
                        winFrmCgg_res_movilidad.getEl().unmask();
                        if (r == 'true') {
                            /*Ext.Msg.show({
                                title:tituloCgg_res_movilidad,
                                msg: 'La informaci\u00f3n de Movilidad ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });*/
							Ext.MsgPopup.msg(tituloCgg_res_movilidad, 'La informaci\u00f3n de Movilidad ha sido almacenada.');
							txtCtreg_codigo_barras.focus();
							if(tmpSaveAndClose)
								winFrmCgg_res_movilidad.close();
							else{
								pnlCgg_res_movilidad.getForm().reset();
								smActividad.clearSelections();
								smTipo_Hospedaje.clearSelections();
								txtCrmov_observacion.setValue('');
							}
							tmpSaveAndClose = false;
                        } else {
                            Ext.Msg.show({
                                title:tituloCgg_res_movilidad,
                                msg: 'La informaci\u00f3n de Movilidad no ha podido ser almacenada. '+ (r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
					if(new ManagerCookies().read('TCT_ING_VUELO'))
						new ManagerCookies().erase('TCT_ING_VUELO');
					new ManagerCookies().create('TCT_ING_VUELO', txtCrmov_numero_vuelo.getValue(), 168);
					
					tmpDatosPersonales = '{\"CRPER_CODIGO\":\"'+txtCrper_codigo.getValue()+'\",'+
						'\"CRPER_NOMBRES\":\"'+txtCrper_nombres.getValue()+'\",'+
						'\"CRPER_APELLIDOS\":\"'+txtCrper_apellido_paterno.getValue()+'\",'+
						'\"CRPER_GENERO\":\"'+cbxCrper_generoMov.getValue()+'\",'+
						'\"CRPER_FECHA_NACIMIENTO\":\"'+dtCrper_fecha_nacimiento.getValue().format(TypeDateFormat.ISO8601Long)+'\",'+
						'\"CRDID_CODIGO\":\"'+cbxCrdid_codigo.getValue()+'\",'+
						'\"CGG_CPAIS_CODIGO\":\"'+cbxCgg_cpais_codigoMov.getValue()+'\",'+
						'\"CGNCN_CODIGO\":\"'+cbxCgncn_codigoMov.getValue()+'\"'+
						'}';
					var tmpActividades = '[';
					var tmpArray = smActividad.getSelections();
					for(i = 0; i < tmpArray.length; i++){
						if(i>0)
							tmpActividades +=',';
						tmpActividades += Ext.util.JSON.encode(tmpArray[i].json);
					}
					tmpActividades +=']';
					
					var tmpHospedajes = '[';
					tmpArray = smTipo_Hospedaje.getSelections();
					for(i = 0; i < tmpArray.length; i++){
						if(i>0)
							tmpHospedajes +=',';
						tmpHospedajes += Ext.util.JSON.encode(tmpArray[i].json);
					}
					tmpHospedajes +=']';
					
                    winFrmCgg_res_movilidad.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if (isEdit){
                        param.add('inCrmov_codigo', txtCrmov_codigo.getValue());
                    }
                    param.add('inCraln_codigo', cbxCraln_codigo.getValue());
                    param.add('inCarpt_codigo', cbxCarpt_codigo.getValue());
                    param.add('inCgg_carpt_codigo', cbxCgg_carpt_codigo.getValue());
                    param.add('inCrper_codigo', tmpCrper_codigo);
                    param.add('inCtreg_codigo', tmpCtreg_codigo);
					param.add('inCrrsd_codigo', tmpCrrsd_codigo.length>0?tmpCrrsd_codigo:null);
                    param.add('inCrmov_fecha_viaje', dtCrmov_fecha_viaje.getValue().format('Y-m-d'));
                    param.add('inCrmov_tipo_operacion', '0');
                    param.add('inCrmov_numero_vuelo', txtCrmov_numero_vuelo.getValue());
                    param.add('inCrmov_observacion', txtCrmov_observacion.getValue());
                    param.add('inCrmov_tipo_salida', 0);
                    param.add('inCrmov_filtro_interno',chkCrmov_filtro_interno.getValue());
                    param.add('inCrmov_seguimiento',chkCrmov_seguimiento.getValue());
					param.add('inPersonaJSON',tmpDatosPersonales);
					param.add('inActividadesJSON',tmpActividades);
					param.add('inHospedajesJSON',tmpHospedajes);
                    SOAPClient.invoke(urlCgg_res_movilidad, INSENTENCIA_CGG_RES_MOVILIDAD, param, true, CallBackCgg_res_movilidad);
                } catch(inErr) {
                    winFrmCgg_res_movilidad.getEl().unmask();
                }
            }
        }
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_movilidad.
     */
    var btnCancelarCgg_res_movilidad = new Ext.Button({
        id:'btnCancelarCgg_res_movilidad',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function() {
                pnlCgg_res_movilidad.getForm().reset();
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_movilidad.
     */
    var btnCerrarCgg_res_movilidad = new Ext.Button({
        id:'btnCerrarCgg_res_movilidad',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function() {
                winFrmCgg_res_movilidad.close();
            }
        }
    });

    /**
     * ExtPanel Panel que contiene los controles de la aerolinea y el numero de vuelo
     */
    var pnlCgg_res_Aerolinea = new Ext.Panel({
        layout:'column',
        anchor:'100%',
        items:[
            {layout:'form',labelWidth:60,columnWidth:.60,items:[cbxCraln_codigo]},
            {layout:'form',labelWidth:40,columnWidth:.40,items:[txtCrmov_numero_vuelo]}
        ]
    });

    /**
     * ExtPanel Panel que contiene los controles de la aerolinea y el numero de vuelo
     */
    var pnlfsAeropuerto = new Ext.form.FieldSet({
        id:'pnlfsAeropuerto',
        title:'Datos de la entrada',
        //region:'center',
        //labelWidth :120,
        //height:250,
        anchor:'100%',
        items:[
            txtCtreg_estado_registro,
            pnlCgg_res_Aerolinea,
            cbxCarpt_codigo,
            cbxCgg_carpt_codigo,

            {	id:'pnlMovFechas',
                columnWidth:.50,
                layout:'form',
                anchor:'100%',
                labelWidth:110,
                items:[dtCrmov_fecha_viaje,dtCtreg_fecha_salida],

                columnWidth:.50,
                layout:'form',
                anchor:'100%',
                labelWidth:110,
                items:[chkCrmov_filtro_interno,chkCrmov_seguimiento]
            }
        ]
    });

    /**
     * Ext.Panel Panel que contiene los controles del tipo hospedaje
     */

    var pnlCgg_tct_codigo_barras = new Ext.Panel({
        layout: 'form',
        labelWidth :90,
        region:'north',
        items: [ {
            xtype:'panel',
            layout:'column',
            anchor:'100%',
            html:'<object id="bsxTctIngresoBiometric" type="' + SII_mimeType + '" width="0" height="0"></object>',
            items:[
                {
                    columnWidth:.40,
                    layout:'form',
                    anchor:'100%',
                    items:[txtCtreg_codigo_barras]
                },

                {
                    columnWidth:.50,
                    layout:'column',
                    anchor:'100%',
                    items:[
                        {
                            columnWidth:.93,
                            layout:'form',
                            items:[txtCrper_numero_identificativo]
                        },
                        {
                            columnWidth:.07,
                            layout:'form',
                            items:[btnBuscarCodigoBarras]
                        }
                    ]
                },
                {
                    columnWidth:.1,
                    layout:'form',
                    anchor:'100%',
                    items:[
                        {
                            xtype:'button',
                            iconCls:'iconHand',
                            arrowAlign :'bottom',
                            tooltip:'Verificar informaci\u00f3n dactilar',
                            listeners:
                            {
                                click:function()
                                {
                                    if ( txtCrper_num_doc_identific.getValue())
                                    {
                                        if(!tmpPluginTctIngreso)
                                            tmpPluginTctIngreso = document.getElementById("bsxTctIngresoBiometric");
                                        var tmpIdPersonaNotificacion;
                                        tmpIdPersonaNotificacion = txtCrper_num_doc_identific.getValue();
                                        var tmpHuella = tmpPluginTctIngreso.capture();
                                        if(tmpHuella == 0){
                                            tmpFirText = tmpPluginTctIngreso.firText;//dato procesado utilizado para verificacion
                                            Ext.Ajax.request({
                                                url: URL_WS+'Biometrico',
                                                success: function(inResponse){
                                                    var tmpJSON = Ext.util.JSON.decode(inResponse.responseText);
                                                    if(tmpJSON.success == false)
                                                    {
                                                        Ext.Msg.show({
                                                            title: tituloCgg_res_movilidad,
                                                            msg: tmpJSON.msg,
                                                            buttons: Ext.Msg.OK,
                                                            icon: Ext.MessageBox.ERROR
                                                        });
                                                    }
                                                    else
                                                    {
                                                        Ext.Msg.show({
                                                            title: tituloCgg_res_movilidad,
                                                            msg: "Informaci\u00f3n validada correctamente",
                                                            buttons: Ext.Msg.OK,
                                                            icon: Ext.MessageBox.INFO
                                                        });
                                                    }

                                                },
                                                failure: function(inResponse){
                                                    var tmpJSON = Ext.util.JSON.decode(inResponse.responseText)
                                                    Ext.Msg.show({
                                                        title: tituloCgg_res_movilidad,
                                                        msg: "Ha ocurrido un error en el proceso de verificacion",
                                                        buttons: Ext.Msg.OK,
                                                        icon: Ext.MessageBox.ERROR
                                                    });
                                                    //alert(inResponse.responseText);

                                                },
                                                params: {
                                                    op: 'verify',
                                                    data: tmpFirText,
                                                    id: tmpIdPersonaNotificacion
                                                }
                                            });
                                        }
                                        else
                                        {
                                            Ext.Msg.show({
                                                title: tituloCgg_res_movilidad,
                                                msg: tmpPluginTctIngreso.message,
                                                buttons: Ext.Msg.OK,
                                                icon: Ext.MessageBox.ERROR
                                            });
                                        }
                                    }
                                    else
                                    {
                                        Ext.Msg.show({
                                            title: tituloCgg_res_movilidad,
                                            msg: 'Es necesario seleccionar un registro de ingreso para verificar!!!',
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.ERROR
                                        });
                                    }

                                }
                            }

                        }
                    ]
                }

            ]
        }
        ]
    });
    /**
     * Ext.Panel Panel que contiene los controles de la actividad y el  tipo hospedaje
     */
    var pnlCgg_tct_actividad_hospedaje = new Ext.form.FieldSet({
        id:'pnlCgg_tct_actividad_hospedaje',
        title:'Actividad - Hospedaje',
        height:190,
        layout:'column',
        items:[
                    {
                        columnWidth:.5,
                        layout:'form',
                        items:[grdCgg_tct_actividad]
                    },{
                        columnWidth:.5,
                        layout:'form',
                        items:[grdCgg_tct_tipo_hospedaje]
                    }
            ]
    });
    /**
     * Ext.Panel Panel que contiene los controles de la actividad y el  tipo hospedaje
     */
    var pnlCgg_res_persona = new Ext.form.FieldSet({
        id:'pnlCgg_res_persona',
        title:'Datos de persona',
        collapsible:false,
        //disabled:true,
        items:[{
            xtype:'panel',
            layout:'column',
            anchor:'100%',

            items:[
                {
                    columnWidth:.50,
                    layout:'form',
                    anchor:'100%',
					labelWidth:110,
                    items:[cbxCrdid_codigo,txtCrper_nombres,cbxCrper_generoMov,cbxCgncn_codigoMov,txtCrtra_numero]
                },

                {
                    columnWidth:.50,
                    layout:'form',
                    anchor:'100%',
					labelWidth:110,
                    items:[txtCrper_num_doc_identific,txtCrper_apellido_paterno,dtCrper_fecha_nacimiento,cbxCgg_cpais_codigoMov,txtCrtra_codigo]
                }
            ]
        }],
        listeners:{
            collapse:function(inThis){
                pnlCgg_res_movilidad.setHeight(247);
                Ext.getCmp('pnlInfoPersona').setHeight(20);
                winFrmCgg_res_movilidad.doLayout(true,false);
            },
            expand:function(inThis){
                pnlCgg_res_movilidad.setHeight(380);
                Ext.getCmp('pnlInfoPersona').setHeight(143);
                winFrmCgg_res_movilidad.doLayout(true,false);
            }
        }
    });
    /**
     * Ext.form.FormPanel Panel para las Fechas
     */
   /* var pnlOrganizacion = new Ext.Panel({
        collapsible:false,
        labelWidth :60,
        layout:'form',
        items:[
            {
                xtype:'panel',
                layout:'column',
                items:[
                    {
                        columnWidth:.40,
                        layout:'form',
                        items:[pnlfsAeropuerto]
                    }/!*,{
                        columnWidth:.60,
                        layout:'form',
                        items:[pnlCgg_tct_actividad_hospedaje]
                    }*!/
                ]
            }
        ]
    });*/

    /**
     * Ext.form.FormPanel Panel que contiene todos los controles de winFrmCgg_res_movilidad
     */

    var pnlCgg_res_movilidad = new Ext.form.FormPanel({
        id:'pnlCgg_res_movilidad',
        frame:true,
        labelWidth :100,
        region:'center',
        layout:'form',
        items:[
            pnlCgg_tct_codigo_barras,
            //pnlOrganizacion,
            pnlfsAeropuerto,
            pnlCgg_res_persona,
			txtCrmov_observacion
        ]
    });

    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_movilidad.
     */
    var winFrmCgg_res_movilidad = new Ext.Window({
        id:'winFrmCgg_res_movilidad',
        title:tituloCgg_res_movilidad,
        tbar:getPanelTitulo(tituloCgg_res_movilidad, descCgg_res_movilidad),
        layout:'border',
        items:[pnlCgg_res_movilidad],
        width:780,
        height:560,
        minWidth:580,
        minimizable:false,
        maximizable:true,
        modal:true,
        constrain:true,
        bbar:[btnGuardarCgg_res_movilidad,btnCancelarCgg_res_movilidad,'->',btnCerrarCgg_res_movilidad],
		listeners:{
			show:function(){
				loadDefaultData();
                                Ext.getCmp('txtCtreg_codigo_barras').focus(false,400);
			}
		}
    });

		/**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmCgg_res_movilidad.getBottomToolbar());
		applyGrants(Ext.getCmp('pnlMovFechas'), true);
		
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_movilidad.
     */
    function cargarCgg_res_movilidadCtrls() {
        if (inRecordCgg_res_movilidad) {
			txtCrper_numero_identificativo.setValue(inRecordCgg_res_movilidad.CRPER_NUM_DOC_IDENTIFIC);
			txtCrper_codigo.setValue(inRecordCgg_res_movilidad.CRPER_CODIGO);
            txtCtreg_codigo_barras.setValue(inRecordCgg_res_movilidad.CTREG_CODIGO_BARRAS);
            txtCrmov_codigo.setValue(inRecordCgg_res_movilidad.CRMOV_CODIGO);
            tmpCtreg_codigo=inRecordCgg_res_movilidad.CTREG_CODIGO;
            tmpCrper_codigo= inRecordCgg_res_movilidad.CRPER_CODIGO;
            txtCtgtr_codigo.setValue(inRecordCgg_res_movilidad.CTGTR_CODIGO);
            txtCrmov_numero_vuelo.setValue(inRecordCgg_res_movilidad.CTREG_NUMERO_VUELO);
            tmpCraln_codigo= inRecordCgg_res_movilidad.CRALN_CODIGO;
            cbxCraln_codigo.setValue(inRecordCgg_res_movilidad.CRALN_CODIGO);
            tmpCarpt_codigo=inRecordCgg_res_movilidad.CARPT_CODIGO;
            cbxCarpt_codigo.setValue(inRecordCgg_res_movilidad.CARPT_CODIGO);
			txtCrtra_numero.setValue(inRecordCgg_res_movilidad.CRTRA_NUMERO);
            dtCtreg_fecha_salida.setValue(truncDate(inRecordCgg_res_movilidad.CTREG_FECHA_SALIDA));
            cbxCrdid_codigo.setValue(inRecordCgg_res_movilidad.CRDID_CODIGO);
            txtCrper_num_doc_identific.setValue(inRecordCgg_res_movilidad.CRPER_NUM_DOC_IDENTIFIC);
            txtCrper_nombres.setValue(inRecordCgg_res_movilidad.CRPER_NOMBRES);
            txtCrper_apellido_paterno.setValue(inRecordCgg_res_movilidad.CRPER_APELLIDO_PATERNO+' '+inRecordCgg_res_movilidad.CRPER_APELLIDO_MATERNO);
            chkCrmov_seguimiento.setValue(inRecordCgg_res_movilidad.CRPER_SEGUIMIENTO);
            txtCrmov_observacion.setValue(inRecordCgg_res_movilidad.CTREG_OBSERVACION);
			if(inRecordCgg_res_movilidad.CRPER_GENERO != null && inRecordCgg_res_movilidad.CRPER_GENERO != undefined)
			cbxCrper_generoMov.setValue(inRecordCgg_res_movilidad.CRPER_GENERO);
            
			dtCrper_fecha_nacimiento.setValue(truncDate(inRecordCgg_res_movilidad.CRPER_FECHA_NACIMIENTO));
            cbxCgncn_codigoMov.setValue(inRecordCgg_res_movilidad.CGNCN_CODIGO);
			cbxCgg_cpais_codigoMov.setValue(inRecordCgg_res_movilidad.CGG_CPAIS_CODIGO);
			
            if(inRecordCgg_res_movilidad.TIPO_RESIDENCIA.length > 0)
				txtCrtra_codigo.setValue(inRecordCgg_res_movilidad.TIPO_RESIDENCIA);
			else 
				txtCrtra_codigo.setValue('Turista');
			txtCtreg_estado_registro.setValue(dsEstadoRegistroTct[inRecordCgg_res_movilidad.CTREG_ESTADO_REGISTRO][1]);
			
			tmpCrrsd_codigo = inRecordCgg_res_movilidad.CRRSD_CODIGO;
            cbxCtreg_tipo_operacion.setValue(inRecordCgg_res_movilidad.CRMOV_TIPO_OPERACION);
            gsCgg_tct_actividad_reg.reload({
                params:{
                    inCtgtr_codigo:txtCtgtr_codigo.getValue(),
                    format:TypeFormat.JSON
                }
            });
            gsCgg_tct_tipo_hospedaje_reg.reload({
                params:{
                    inCtgtr_codigo:txtCtgtr_codigo.getValue(),
                    format:TypeFormat.JSON
                }
            });
			loadDefaultData();
			//isEdit = true;
        }
    }
	
	function loadDefaultData(){
		if(new ManagerCookies().read('TCT_ING_VUELO'))
			txtCrmov_numero_vuelo.setValue(new ManagerCookies().read('TCT_ING_VUELO'));
		cbxCgg_carpt_codigo.setValue(tmpUserSession.getUserData().CARPT_CODIGO);
	}

    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_movilidad.
     * @returns ventana winFrmCgg_res_movilidad.
     * @base FrmCgg_res_movilidad.prototype.show
     */
    this.getWindow = function() {
        return winFrmCgg_res_movilidad;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_movilidad.
     * @base FrmCgg_res_movilidad.prototype.loadData
     */
    this.loadData = function() {
        cargarCgg_res_movilidadCtrls();
    }
	
	this.setUserSession = function(inUserSession){
		tmpUserSession = inUserSession;
		gsCgg_res_aeropuerto.reload();
	}
	
	this.setNacionalidad = function(inStore) {
        cbxCgncn_codigoMov.store = inStore;
    }
	
	this.setStoreHospedaje = function(inStoreHospedaje){
		tmpStoreHospedaje = inStoreHospedaje;
		grdCgg_tct_tipo_hospedaje.store = tmpStoreHospedaje;
	}
	
	this.setStoreActividad = function(inStoreActividad){
		tmpStoreActividad = inStoreActividad;
		grdCgg_tct_actividad.store = tmpStoreActividad;
	}
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_movilidad desde una instancia.
 */
FrmCgg_res_movilidad.prototype.show = function(){
    this.getWindow().show();
}

FrmCgg_res_movilidad.prototype.setUserSession = function(inUserSession){
    this.setUserSession(inUserSession);
}

FrmCgg_res_movilidad.prototype.setNacionalidad = function(inStore){
	this.setNacionalidad(inStore);
}

/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_movilidad desde una instancia.
 */
FrmCgg_res_movilidad.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_movilidad,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_movilidad.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_movilidad desde una instancia.
 */
FrmCgg_res_movilidad.prototype.loadData = function(){
    this.loadData();
}

FrmCgg_res_movilidad.prototype.setStoreHospedaje = function(inStoreHospedaje){
    this.setStoreHospedaje(inStoreHospedaje);
}

FrmCgg_res_movilidad.prototype.setStoreActividad = function(inStoreActividad){
    this.setStoreActividad(inStoreActividad);
}