/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_movilidad_interna.
 * @param {String} IN_SENTENCIA_CGG_RES_MOVILIDAD_INTERNA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_RES_MOVILIDAD_INTERNA Registro de datos de la tabla Cgg_res_movilidad_interna.
 * @constructor
 * @base FrmListadoCgg_res_movilidad_interna
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_movilidad_interna(IN_SENTENCIA_CGG_RES_MOVILIDAD_INTERNA,IN_RECORD_CGG_RES_MOVILIDAD_INTERNA){
    var inSentenciaCgg_res_movilidad_interna = IN_SENTENCIA_CGG_RES_MOVILIDAD_INTERNA;
    var inRecordCgg_res_movilidad_interna=IN_RECORD_CGG_RES_MOVILIDAD_INTERNA;
    var urlCgg_res_movilidad_interna=URL_WS+"Cgg_res_movilidad_interna";
    var tituloCgg_res_movilidad_interna='Registro desplazamiento interno';
    var descCgg_res_movilidad_interna='El formulario permite administrar la informaci\u00f3n del desplazamiento interno';
    var isEdit = false;
    var tmpcrmov_ext_codigo;
    var tmpCrper_mov_codigo;
    var tmpMovimientoInterno;
    var tmpCrmvi_tipo_operacion_movilidad;
    var tmpcrmov_ext_codigo_ingreso;
	var tmpLocal = false;
	var tmpUserSession;
	var tmpStoreEmbarcacion;
	var tmpStoreAerolinea;
	var tmpStoreHospedaje;
	var tmpStoreActividad;
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
				cbxMuelleOrigen.store = tmpStoreMuelle;
				cbxMuelleDestino.store = tmpStoreMuelle;
				if(tmpUserSession.getUserData().CRMLE_CODIGO)
					cbxMuelleOrigen.setValue(tmpUserSession.getUserData().CRMLE_CODIGO);
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
				cbxAeropuertoDestino.store = tmpGsAeropuerto;
				cbxAeropuertoOrigen.store = tmpGsAeropuerto;
				if(tmpUserSession.getUserData().CARPT_CODIGO)
					cbxAeropuertoOrigen.setValue(tmpUserSession.getUserData().CARPT_CODIGO);
			}
		}
	});
	tmpGsAeropuerto.load();
	
	function MovilidadPersona() {
        var cmMovilidadPersonaIngreso = null;
        /**
         * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_persona.
         *
         */
        cmMovilidadPersonaIngreso = new Ext.grid.ColumnModel([
            {dataIndex:'CRPER_TIPO_DOCUMENTO',header:'Documento',width:150,sortable:true},
            {dataIndex:'CRPER_NOMBRES',header:'Nombres',width:150,sortable:true},
            {dataIndex:'CRPER_APELLIDO_PATERNO',header:'Primer apellido',width:150,sortable:true},
            {dataIndex:'CRPER_APELLIDO_MATERNO',header:'Segundo apellido',width:150,sortable:true},
            {dataIndex:'CRPER_NUM_DOC_IDENTIFIC',header:'Num doc identific',width:150,sortable:true},
            {dataIndex:'CRPER_FECHA_NACIMIENTO',header:'Fecha nacimiento',width:150,sortable:true,renderer:truncDate},
            {dataIndex:'CRPER_GENERO',header:'Genero',width:150,sortable:true,renderer:function(inData){
				return dsGeneroPersona[inData][1];
			}},
			{dataIndex:'CRMOV_FECHA_VIAJE',header:'Fecha ingreso',width:150,sortable:true,renderer:truncDate},
			{dataIndex:'CRMVI_TIPO_OPERACION',header:'Tipo operacion',width:150,sortable:true}
        ]);
            
            this.getCm = function() {
            return cmMovilidadPersonaIngreso;
        };

    }

    MovilidadPersona.prototype.getColumnModel = function() {
        return this.getCm();
    };

	var gsMovilidadPersonaIngreso = new Ext.data.Store({
		proxy:new Ext.ux.bsx.SoapProxy({
			url:URL_WS + "Cgg_res_movilidad_interna",
			method:"selectMovilidadPersona",
			pagin:true
		}),
		remoteSort:true,
		reader:new Ext.data.JsonReader({
			id:'CRMOV_CODIGO',
			root:'dataSet',
			totalProperty: 'totalCount'
		}, [
			{name:'CRMIV_CODIGO'},
			{name:'CRMOV_CODIGO'},
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
			{name:'CRMOV_FECHA_VIAJE'},
			{name:'TIPO_RESIDENCIA'},
			{name:'CRMVI_TIPO_OPERACION'},
            {name:'CRRES_DIAS_TRANSCURRIDOS'}
		]),
		sortInfo:{
			field: 'CRPER_NOMBRES',
			direction: 'ASC'
		},
		baseParams:{
			keyword:'',
			format:'JSON',
			inCrper_numero_identificacion:''
		},
		listeners:{
			load:function(inSource, inRecords, inOptions){
				if(inRecords.length > 0 && tmpLocal){
					inRecordCgg_res_movilidad_interna = inRecords[0];
					cargarCgg_res_movilidad_internaCtrls();
					tmpLocal = false;
				}
			}
		}
	});
			
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD INTERNA
     */
    var txtCrmvi_codigo = new Ext.form.TextField({
        id:'txtCrmvi_codigo',
        name:'txtCrmvi_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });

    //Creamos una definici?n de los campos que vienen en el Json remoto

    var cbxMuelleOrigen = new Ext.form.ComboBox({
        store:tmpStoreMuelle,
        id:'cbxMuelleOrigen',
        name:'cbxMuelleOrigen',
        displayField: "CRMLE_NOMBRE",
        fieldLabel :'Origen',
        valueField: 'CRMLE_CODIGO',
        mode:'local',
        typeAhead:true,
        forceSelection:true,
        editable:false,
        triggerAction:'all',        
        anchor:'98%',
        emptyText : 'Seleccione una opci\u00f3n..'

    });
    //Creamos una definici?n de los campos que vienen en el Json remoto

    var cbxMuelleDestino = new Ext.form.ComboBox({
        store:tmpStoreMuelle,
        id:'cbxMuelleDestino',
        name:'cbxMuelleDestino',
        displayField: "CRMLE_NOMBRE",
        fieldLabel :'Destino',
        valueField: 'CRMLE_CODIGO',
        mode:'local',
        typeAhead:true,
        forceSelection:true,
        editable:false,
        triggerAction:'all',
        anchor:'98%',
        emptyText : 'Seleccione una opci\u00f3n..'
    });

    /**
     * Ext.form.TextField MUELLE ORIGEN
     */
    var txtCrmle_codigo = new Ext.form.TextField({
        id:'txtCrmle_codigo',
        name:'txtCrmle_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });


    /**
     * Ext.form.TextField MUELLE DESTINO
     */
    var txtCgg_crmle_codigo = new Ext.form.TextField({
        id:'txtCgg_crmle_codigo',
        name:'txtCgg_crmle_codigo',
        fieldLabel :'Crmle codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE EMBARCACION
     */
    var txtCremb_codigo = new Ext.form.TextField({
        id:'txtCremb_codigo',
        name:'txtCremb_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
  
//Creamos una definici?n de los campos que vienen en el Json remoto

    var cbxEmbarcacion = new Ext.form.ComboBox({
        id:'cbxEmbarcacion',
        name:'cbxEmbarcacion',
        displayField: "CREMB_NOMBRE",
        fieldLabel :'Embarcaci\u00f3n',
        valueField: 'CREMB_CODIGO',
        mode:'local',
        typeAhead:true,
        forceSelection:true,
        editable:false,
        triggerAction:'all',
        anchor:'98%',
        emptyText : 'Seleccione una opci\u00f3n..'

    });
    //Creamos una definici?n de los campos que vienen en el Json remoto

    var cbxAeropuertoOrigen = new Ext.form.ComboBox({
        id:'cbxAeropuertoOrigen',
        name:'cbxAeropuertoOrigen',
        displayField: "CARPT_NOMBRE",
        fieldLabel :'Origen',
        valueField: 'CARPT_CODIGO',
        mode:'local',
        typeAhead:true,
        forceSelection:true,
        editable: false,
        triggerAction:'all',
        anchor:'98%',
        emptyText : 'Seleccione una opci\u00f3n..'

    });
     //Creamos una definici?n de los campos que vienen en el Json remoto

    var cbxAeropuertoDestino = new Ext.form.ComboBox({
        id:'cbxAeropuertoDestino',
        name:'cbxAeropuertoDestino',
        displayField: "CARPT_NOMBRE",
        fieldLabel :'Destino',
        valueField: 'CARPT_CODIGO',
        mode:'local',
        typeAhead:true,
        forceSelection:true,
        editable: false,
        triggerAction:'all',
        anchor:'98%',
        emptyText:'Seleccione una opci\u00f3n..'

    });
    //Creamos una definici?n de los campos que vienen en el Json remoto

    var cbxAerolinea = new Ext.form.ComboBox({
        id:'cbxAerolinea',
        name:'cbxAerolinea',
        displayField: "CRALN_NOMBRE",
        fieldLabel :'Aerolinea',
        valueField: 'CRALN_CODIGO',
        mode:'local',
        typeAhead:true,
        forceSelection:true,
        editable: false,
        triggerAction:'all',
        anchor:'98%',
        emptyText : 'Seleccione una opci\u00f3n..'

    });


/**
     * Ext.form.NumberField CODIGO DE BARRAS GENERADO PARA EL REGISTRO DE TCT
     */
    var txtTipo_documento = new Ext.form.TextField({
        id:'txtTipo_documento',
        name:'txtTipo_documento',
        fieldLabel :'No.Documento',
        anchor:'98%',
        listeners:{
            specialkey :function(inField, e){
                if (e.getKey() == e.ENTER) {
					gsMovilidadPersonaIngreso.baseParams.start = 0;
					gsMovilidadPersonaIngreso.baseParams.limit = 30;
                    gsMovilidadPersonaIngreso.baseParams.inCrper_numero_identificacion = txtTipo_documento.getValue();
					gsMovilidadPersonaIngreso.reload();
					tmpLocal = true;
                }
            }
        }
    });
     /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD
     */
    var btnCrmov_codigoCgg_res_movilidad= new Ext.Button({
        id:'btnCrmov_codigoCgg_res_movilidad',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_res_movilidad = new MovilidadPersona();
                var objBusqueda = new DlgBusqueda(gsMovilidadPersonaIngreso,tmpFLCgg_res_movilidad.getCm());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
						inRecordCgg_res_movilidad_interna = tmpRecord;
						cargarCgg_res_movilidad_internaCtrls();
					}
				 });
                objBusqueda.show();
            }}
    });
     /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO  DE PERSONA
     */
    var txtCrper_codigo_mvi = new Ext.form.TextField({
        id:'txtCrper_codigo_mvi',
        name:'txtCrper_codigo_mvi',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
           * Ext.form.TextField TIPO DOCUMENTO
           */
          var txtCrdid_codigo_mvi = new Ext.form.TextField({
              id:'txtCrdid_codigo_mvi',
              name:'txtCrdid_codigo_mvi',
              fieldLabel :'Tipo Documento',
              anchor:'98%',
              readOnly:true
          });
          /**
           * Ext.form.TextField NOMBRES DE LA PERSONA
           */
          var txtCrper_nombres_mvi = new Ext.form.TextField({
              id:'txtCrper_nombres_mvi',
              name:'txtCrper_nombres_mvi',
              fieldLabel :'Nombres',
              anchor:'98%',
			  readOnly:true
          });
          /**
           * Ext.form.TextField APELLIDO PATERNO
           */
          var txtCrper_apellido_paterno_mvi = new Ext.form.TextField({
              id:'txtCrper_apellido_paterno_mvi',
              name:'txtCrper_apellido_paterno_mvi',
              fieldLabel :'Apellido ',
              anchor:'98%',
			  readOnly:true
          });

          /**
           * Ext.form.TextField NUMERO DE DOCUEMNTO DE IDENTIFICACION
           */
          var txtCrper_num_doc_identific_mvi = new Ext.form.TextField({
              id:'txtCrper_num_doc_identific_mvi',
              name:'txtCrper_num_doc_identific_mvi',
              fieldLabel :'No. identificaci\u00f3n',
              anchor:'98%',
              readOnly:true

          });
          /**
           * Ext.form.TextField APELLIDO PATERNO
           */
          var txtCrtra_codigo_mvi = new Ext.form.TextField({
              id:'txtCrtra_codigo_mvi',
              name:'txtCrtra_codigo_mvi',
              fieldLabel :'Tipo Registro',
              anchor:'98%',
              readOnly:true
          });
          /**
           * Ext.form.TextField GENERO DE LA PERSONA
           */
          var txtCrper_genero_mvi = new Ext.form.TextField({
              id:'txtCrper_genero_mvi',
              name:'txtCrper_genero_mvi',
              fieldLabel :'Genero',
              anchor:'98%',
			  readOnly:true
          });
          /**
           * Ext.form.TextField GENERO DE LA PERSONA
           */
          var txtCgncn_codigo_mvi = new Ext.form.TextField({
              id:'txtCgncn_codigo_mvi',
              name:'txtCgncn_codigo_mvi',
              fieldLabel :'Nacionalidad',
              anchor:'98%',
			  readOnly:true
          });
          /**
           * Ext.form.TextField REGISTRO DE LA PERSONA
           */
          var txtCtreg_tipo_registro_mvi = new Ext.form.TextField({
              id:'txtCtreg_tipo_registro_mvi',
              name:'txtCtreg_tipo_registro_mvi',
              fieldLabel :'Tipo Registro',
              anchor:'98%',
              readOnly:true
          });
          /**
           * Ext.form.DateField FECHA DE NACIMIENTO
           */
          var dtCrper_fecha_nacimiento_mvi = new Ext.form.DateField({
              id:'dtCrper_fecha_nacimiento_mvi',
              name:'dtCrper_fecha_nacimiento_mvi',
              fieldLabel :'Fecha nacimiento',
              format:'d/m/Y',
              readOnly:true
          });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD
     */
    var txtCrmov_codigo_mvi = new Ext.form.TextField({
        id:'txtCrmov_codigo_mvi',
        name:'txtCrmov_codigo_mvi',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
       /**
     * Ext.form.DateField FECHA DE VIAJE
     */
    var dtCrmvi_fecha_ingreso_provincia_mvi = new Ext.form.DateField({
        id:'dtCrmvi_fecha_ingreso_provincia_mvi',
        name:'dtCrmvi_fecha_ingreso_provincia_mvi',
        fieldLabel :'Fecha ingreso',
        format:'d/m/Y',
        readOnly:true
    });
     /**
     * Ext.form.TextField numero de dias que esta en la provincia
     */
    var txtCrmvi_dias_transcuriidos = new Ext.form.TextField({
        id:'txtCrmvi_dias_transcuriidos',
        name:'txtCrmvi_dias_transcuriidos',
        fieldLabel :'Estadia',
        anchor:'98%',
        readOnly:'true',
         style: {
            color:'#004A95',
            background:'#FFFFE6'
        }
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCarpt_codigo = new Ext.form.TextField({
        id:'txtCarpt_codigo',
        name:'txtCarpt_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCgg_carpt_codigo = new Ext.form.TextField({
        id:'txtCgg_carpt_codigo',
        name:'txtCgg_carpt_codigo',
        fieldLabel :'Carpt codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCraln_codigo = new Ext.form.TextField({
        id:'txtCraln_codigo',
        name:'txtCraln_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
  
    /**
     * Ext.form.TextField DESCRIPCION DEL VUELO
     */
    var txtCraln_descripcion_vuelo = new Ext.form.TextField({
        id:'txtCraln_descripcion_vuelo',
        name:'txtCraln_descripcion_vuelo',
        fieldLabel :'Vuelo',
        anchor:'98%',
		maskRe:/[\w\-]+/
    });
    /**
     * Ext.form.DateField FECHA DE VIAJE
     */
    var dtCrmvi_fecha_viaje = new Ext.form.DateField({
        id:'dtCrmvi_fecha_viaje',
        name:'dtCrmvi_fecha_viaje',
        fieldLabel :'Fecha viaje',
        allowBlank :false,
        format :'d/m/Y',
        value:new Date()
    });

    /**
     * Ext.form.TextField DESCRIPCION CORTA
     */
    var txtCrmvi_observacion = new Ext.form.TextArea({
        id:'txtCrmvi_observacion',
        name:'txtCrmvi_observacion',
        fieldLabel :'Observaci\u00f3n',
		autoScroll:true,
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
        {dataIndex:'CTACT_NOMBRE',header:'Actividad',width:130,sortable:true}]);


    /**
     * Ext.grid.GridPanel Representacion de los datos de la actividad interna en un formato tabular de filas y columnas.
     */
    var grdCgg_tct_actividad_interna = new Ext.grid.GridPanel({
        cm:cmCgg_tct_actividad,
        sm:smActividad,
        height:140,
        viewConfig:{forceFit:true},
        loadMask:{msg:"Cargando..."}
    });


     /**
     * Ext.form.TextField DESCRIPCION CORTA
     */
    var txtCrmvi_lugar_Hospedaje = new Ext.form.TextField({
        id:'txtCrmvi_lugar_Hospedaje',
        name:'txtCrmvi_lugar_Hospedaje',
        fieldLabel :'Lugar',
        anchor:'98%'

    });

    /*
     Seccion que permite seleccionar los tipos de actividades internas a realizar en el resgitro
     */
    var smTipo_Hospedaje_Interno = new Ext.grid.CheckboxSelectionModel();
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_tct_tipo_hospedaje_interno.
     */
    var cmCgg_tct_tipo_hospedaje_interno = new Ext.grid.ColumnModel([
        smTipo_Hospedaje_Interno,
        {dataIndex:'CTTHJ_NOMBRE',header:'Hospedaje',width:130,sortable:true}]);


    /**
     * Ext.grid.GridPanel Representacion de los datos de lahospedaje interno en un formato tabular de filas y columnas.
     */
    var grdCgg_tct_tipo_hospedaje_interno = new Ext.grid.GridPanel({
        cm:cmCgg_tct_tipo_hospedaje_interno,
        height:140,
        sm:smTipo_Hospedaje_Interno,
       loadMask:{msg:"Cargando..."},
        viewConfig:{forceFit:true}
    });


    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_movilidad_interna
     */
    var btnGuardarCgg_res_movilidad_interna = new Ext.Button({
        id:'btnGuardarCgg_res_movilidad_interna',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (!pnlCgg_res_movilidad_interna.getForm().isValid()){
                    return;
                }
				if(pnlfsMuelle.isVisible() && cbxMuelleOrigen.getValue() == cbxMuelleDestino.getValue()){
					Ext.Msg.alert(tituloCgg_res_movilidad_interna, 'El muelle de origen no puede ser igual al muelle de llegada.');
					return;
				}
				if(pnlfsAerolinea.isVisible() && cbxAeropuertoOrigen.getValue() == cbxAeropuertoDestino.getValue()){
					Ext.Msg.alert(tituloCgg_res_movilidad_interna, 'El aeropuerto de origen no puede ser igual al aeropuerto de arrivo.');
					return;
				}
               if((tmpCrmvi_tipo_operacion_movilidad==TypeMovimientoInterno.INGRESOPROVINCIA) || (tmpCrmvi_tipo_operacion_movilidad==TypeMovimientoInterno.INGRESOISLA) ){
                    tmpMovimientoInterno=TypeMovimientoInterno.SALIDAISLA;
                }

                try{
                    function CallBackCgg_res_movilidad_interna(r){

                        winFrmCgg_res_movilidad_interna.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_res_movilidad_interna,
                                msg: 'La informaci\u00f3n de Res movilidad interna ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_res_movilidad_interna.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_res_movilidad_interna,
                                msg: 'La informaci\u00f3n de Res movilidad interna no ha podido ser almacenada. '+r,
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_res_movilidad_interna.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
						param.add('inCrmvi_codigo',txtCrmvi_codigo.getValue());
                    param.add('inCrmle_codigo',pnlfsMuelle.isVisible()?cbxMuelleOrigen.getValue()?cbxMuelleOrigen.getValue():null:null);
                    param.add('inCgg_crmle_codigo',pnlfsMuelle.isVisible()?cbxMuelleDestino.getValue()?cbxMuelleDestino.getValue():null:null);
                    param.add('inCremb_codigo',cbxEmbarcacion.getValue()?cbxEmbarcacion.getValue():null);
                    param.add('inCrper_codigo',txtCrper_codigo_mvi.getValue());
                    param.add('inCrmov_codigo',tmpcrmov_ext_codigo_ingreso);
                    param.add('inCarpt_codigo',pnlfsAerolinea.isVisible()?cbxAeropuertoOrigen.getValue()?cbxAeropuertoOrigen.getValue():null:null);
                    param.add('inCgg_carpt_codigo',pnlfsAerolinea.isVisible()?cbxAeropuertoDestino.getValue()?cbxAeropuertoDestino.getValue():null:null);
                    param.add('inCraln_codigo',cbxAerolinea.getValue()?cbxAerolinea.getValue():null);
                    param.add('inCraln_descripcion_vuelo',txtCraln_descripcion_vuelo.getValue()?txtCraln_descripcion_vuelo.getValue():null);
                    param.add('inCrmvi_fecha_viaje',dtCrmvi_fecha_viaje.getValue().format('Y-m-d'));
                    param.add('inCrmvi_tipo_operacion',tmpMovimientoInterno);
                    param.add('inCrmvi_observacion',txtCrmvi_observacion.getValue());
                    param.add('inCtmhj_lugar_hospedaje',null);//txtCrmvi_lugar_Hospedaje.getValue());
					param.add('inHospedajeInterno_JSON', createJSONObject(grdCgg_tct_tipo_hospedaje_interno.getSelectionModel().getSelections()));
                    param.add('inActividadInterna_JSON', createJSONObject(grdCgg_tct_actividad_interna.getSelectionModel().getSelections()));
                    SOAPClient.invoke(urlCgg_res_movilidad_interna,IN_SENTENCIA_CGG_RES_MOVILIDAD_INTERNA,param, true, CallBackCgg_res_movilidad_interna);
                }catch(inErr){
                    winFrmCgg_res_movilidad_interna.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_movilidad_interna.
     */
    var btnCancelarCgg_res_movilidad_interna = new Ext.Button({
        id:'btnCancelarCgg_res_movilidad_interna',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
               pnlCgg_res_movilidad_interna.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_movilidad_interna.
     */
    var btnCerrarCgg_res_movilidad_interna = new Ext.Button({
        id:'btnCerrarCgg_res_movilidad_interna',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_res_movilidad_interna.close();
            }}
    });


       /**
     * Ext.Panel Panel que contiene los datos informativos de persona
     */
    var pnlCgg_res_persona_movilidad = new Ext.form.FieldSet({
        id:'pnlCgg_res_persona_movilidad',
        title:'Persona',
        collapsible:true,
		layout:'form',
        items:[
            txtCrdid_codigo_mvi,
			txtCrper_num_doc_identific_mvi,
            txtCrper_nombres_mvi,
			txtCrper_apellido_paterno_mvi,
            {xtype:'panel',layout:'column',items:[
				{columnWidth:.5,layout:'form',items:[txtCrper_genero_mvi]},
				{columnWidth:.5,layout:'form',items:[dtCrper_fecha_nacimiento_mvi]}
			]},
            txtCgncn_codigo_mvi,
			txtCtreg_tipo_registro_mvi
        ]
    });
    /**
     * Ext.Panel Panel que contiene los controles de la actividad y el  tipo hospedaje
     */
    var pnlCgg_tct_actividad_hospedaje_interno = new Ext.form.FieldSet({
        id:'pnlCgg_tct_actividad_hospedaje_interno',
        title:'Datos adicionales',
        collapsible:true,
		layout:'column',
        height:160,
        items:[
			{columnWidth:.50,layout:'form',items:[grdCgg_tct_actividad_interna]},
			{columnWidth:.50,layout:'form',items:[grdCgg_tct_tipo_hospedaje_interno]}
		]
    });

      /* ExtPanel Panel que contiene los controles del muelle y embarcacion
     */
    var pnlfsMuelle = new Ext.form.FieldSet({
        id:'pnlfsMuelle',
        title:'Puerto Maritimo',
        collapsible:true,
        split:true,
        animCollapse :true,
        labelWidth :100,
		layout:'form',
		style:{marginLeft:'6px'},
        items:[
			cbxMuelleOrigen,
			cbxMuelleDestino,
			cbxEmbarcacion
        ]
    });
     /* ExtPanel Panel que contiene los controles de la aerolinea y el numero de vuelo
     */
    var pnlfsAerolinea = new Ext.form.FieldSet({
        id:'pnlfsAerolinea',
        title:'Aerolinea',
        collapsible:true,
        split:true,
        animCollapse :true,
		style:{marginLeft:'6px'},
        labelWidth :100,
        items:[
			cbxAeropuertoOrigen,
			cbxAeropuertoDestino, 
			{xtype:'panel',layout:'column', //labelWidth :60,
                items:[
                    {
                        columnWidth:.60,layout:'form',items:[cbxAerolinea]},
                     {columnWidth:.40,layout:'form', labelWidth :40,
                        items:[txtCraln_descripcion_vuelo]}
                ]}
        ]
    });
 pnlfsAerolinea.setVisible(false);
           var rdgTipoTransporte = new Ext.form.RadioGroup({
        id:'rdgTipoTransporte',
        fieldLabel: 'Tipo',
        itemCls: 'x-check-group-alt',
        items: [
            {boxLabel: 'Muelle', name: 'cb-col',inputValue: TypeResult.TRUE,checked: true},
            {boxLabel: 'Aeropuerto', name: 'cb-col',inputValue: TypeResult.FALSE}
        ],
        listeners:{
            change: function(group,radio){
                if(radio && radio.getRawValue() == TypeResult.TRUE){
                    pnlfsMuelle.setVisible(true);
                    pnlfsAerolinea.setVisible(false);
                }else{   
					pnlfsAerolinea.setVisible(true);
                    pnlfsMuelle.setVisible(false);
                }
            }
        }

    });

    /* ExtPanel Panel que contiene los controles de la fecha del viaje interno
     */
    var pnlfsOtros = new Ext.form.FieldSet({
        id:'pnlfsOtros',
        title:'Datos principales',
        collapsible:true,
		layout:'form',
        labelWidth :100,
		height:95,
		style:{marginLeft:'5px'},
        items:[
			{xtype:'panel',id:'pnlMoviResFechas',layout:'form',items:[dtCrmvi_fecha_viaje]},
			rdgTipoTransporte
        ]
    });
	/**
     * Ext.form.FormPanel Panel para las Fechas
     */
    var pnlOrganizacionRegistrosImportantes = new Ext.Panel({
        id:'pnlOrganizacionRegistrosImportantes',
        collapsible:false,
        layout:'form',
        items:[
            pnlfsOtros,
			pnlfsMuelle,
			pnlfsAerolinea
        ]
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_movilidad_interna.
     */
    var pnlCgg_res_movilidad_interna = new Ext.form.FormPanel({
        frame:true,
		region:'center',
		layout:'form',
        items:[ {xtype:'panel',layout:'column', labelWidth :100,
                items:[
                    {columnWidth:.45,layout:'form',
                        items:[txtTipo_documento]},
                    {columnWidth:.05,layout:'form',items:[btnCrmov_codigoCgg_res_movilidad]},
                    {columnWidth:.25,layout:'form',labelWidth :80,
                        items:[dtCrmvi_fecha_ingreso_provincia_mvi]},
                     {columnWidth:.25,layout:'form',labelWidth :80,
                        items:[txtCrmvi_dias_transcuriidos]}
                ]},
				{xtype:'panel',layout:'column',
					items:[
					{columnWidth:.5,items:[pnlCgg_res_persona_movilidad]},
					{columnWidth:.5,items:[pnlOrganizacionRegistrosImportantes]}
				]},
				pnlCgg_tct_actividad_hospedaje_interno,
				txtCrmvi_observacion
		]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_movilidad_interna.
     */
    var winFrmCgg_res_movilidad_interna = new Ext.Window({
        id:'winFrmCgg_res_movilidad_interna',
        title:tituloCgg_res_movilidad_interna,
        width:900,
		height:600,
        minWidth:400,
        maximizable:true,
        minimizable:false,
        constrain:true,
        resizable:true,
        modal:true,
		layout:'border',
        tbar:getPanelTitulo(tituloCgg_res_movilidad_interna,descCgg_res_movilidad_interna),
        items:[pnlCgg_res_movilidad_interna],
        bbar:[btnGuardarCgg_res_movilidad_interna,btnCancelarCgg_res_movilidad_interna,'->',btnCerrarCgg_res_movilidad_interna],
		listeners:{
			show:function(){
				
			}
		}
    });
	
	/**
	 * Funcion que aplica los privilegios del usuario.
	 */
	applyGrants(winFrmCgg_res_movilidad_interna.getBottomToolbar());
	applyGrants(Ext.getCmp('pnlMoviResFechas'), true);
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_movilidad_interna.
     */
    function cargarCgg_res_movilidad_internaCtrls(){
        if(inRecordCgg_res_movilidad_interna){
			tmpcrmov_ext_codigo_ingreso=inRecordCgg_res_movilidad_interna.get('CRMVI_CODIGO');
			tmpcrmov_ext_codigo=inRecordCgg_res_movilidad_interna.get('CRMOV_CODIGO');
			txtTipo_documento.setValue(inRecordCgg_res_movilidad_interna.get('CRPER_NUM_DOC_IDENTIFIC'));
			txtCrdid_codigo_mvi.setValue(inRecordCgg_res_movilidad_interna.get('CRPER_TIPO_DOCUMENTO'));
			txtCrper_num_doc_identific_mvi.setValue(inRecordCgg_res_movilidad_interna.get('CRPER_NUM_DOC_IDENTIFIC'));
			txtCrper_nombres_mvi.setValue(inRecordCgg_res_movilidad_interna.get('CRPER_NOMBRES'));
			txtCrper_apellido_paterno_mvi.setValue(inRecordCgg_res_movilidad_interna.get('CRPER_APELLIDO_PATERNO'));
			txtCrper_genero_mvi.setValue(dsGeneroPersona[inRecordCgg_res_movilidad_interna.data.CRPER_GENERO][1]);
			dtCrper_fecha_nacimiento_mvi.setValue(truncDate(inRecordCgg_res_movilidad_interna.get('CRPER_FECHA_NACIMIENTO')));
			txtCgncn_codigo_mvi.setValue(inRecordCgg_res_movilidad_interna.get('CRPER_NACIONALIDAD'));
			dtCrmvi_fecha_ingreso_provincia_mvi.setValue(truncDate(inRecordCgg_res_movilidad_interna.get('CRMOV_FECHA_VIAJE')));
			txtCtreg_tipo_registro_mvi.setValue(inRecordCgg_res_movilidad_interna.get('TIPO_RESIDENCIA'));
			tmpCrmvi_tipo_operacion_movilidad=inRecordCgg_res_movilidad_interna.get('CRMVI_TIPO_OPERACION');
			if(tmpCrmvi_tipo_operacion_movilidad==TypeMovimientoInterno.SALIDAISLA) 
				Ext.MessageBox.alert('Salida Persona', 'No se encuentra registrado el ingreso a la isla');
					
            txtCrmvi_codigo.setValue(inRecordCgg_res_movilidad_interna.get('CRMVI_CODIGO'));
            txtCrmle_codigo.setValue(inRecordCgg_res_movilidad_interna.get('CRMLE_CODIGO'));
            txtCgg_crmle_codigo.setValue(inRecordCgg_res_movilidad_interna.get('CGG_CRMLE_CODIGO'));
            txtCremb_codigo.setValue(inRecordCgg_res_movilidad_interna.get('CREMB_CODIGO'));
            txtCrper_codigo_mvi.setValue(inRecordCgg_res_movilidad_interna.get('CRPER_CODIGO'));
            txtCrmov_codigo_mvi.setValue(inRecordCgg_res_movilidad_interna.get('CRMOV_CODIGO'));
            txtCarpt_codigo.setValue(inRecordCgg_res_movilidad_interna.get('CARPT_CODIGO'));
            txtCgg_carpt_codigo.setValue(inRecordCgg_res_movilidad_interna.get('CGG_CARPT_CODIGO'));
            txtCraln_codigo.setValue(inRecordCgg_res_movilidad_interna.get('CRALN_CODIGO'));
            txtCraln_descripcion_vuelo.setValue(inRecordCgg_res_movilidad_interna.get('CRALN_DESCRIPCION_VUELO'));
            txtCrmvi_observacion.setValue(inRecordCgg_res_movilidad_interna.get('CRMVI_OBSERVACION'));
            txtCrmvi_dias_transcuriidos.setValue(inRecordCgg_res_movilidad_interna.get('CRRES_DIAS_TRANSCURRIDOS')+' '+'dias');
            
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_movilidad_interna.
     * @returns ventana winFrmCgg_res_movilidad_interna.
     * @base FrmCgg_res_movilidad_interna.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_movilidad_interna;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_movilidad_interna.
     * @base FrmCgg_res_movilidad_interna.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_movilidad_internaCtrls();
    }
	
	this.setUserSession = function(inUserSession){
		tmpUserSession = inUserSession;
	}
	
	this.setStoreAerolinea = function(inStoreAerolinea){
		tmpStoreAerolinea = inStoreAerolinea;
		cbxAerolinea.store = tmpStoreAerolinea;
	}
	
	this.setStoreEmbarcacion = function(inStoreEmbarcacion){
		tmpStoreEmbarcacion = inStoreEmbarcacion;
		cbxEmbarcacion.store = tmpStoreEmbarcacion;
	}
	
	this.setStoreHospedaje = function(inStoreHospedaje){
		tmpStoreHospedaje = inStoreHospedaje;
		grdCgg_tct_tipo_hospedaje_interno.store = tmpStoreHospedaje;
	}
	
	this.setStoreActividad = function(inStoreActividad){
		tmpStoreActividad = inStoreActividad;
		grdCgg_tct_actividad_interna.store = tmpStoreActividad;
	}
}
FrmCgg_res_movilidad_interna.prototype.setUserSession = function(inUserSession){
    this.setUserSession(inUserSession);
}
FrmCgg_res_movilidad_interna.prototype.setStoreEmbarcacion = function(inStoreEmbarcacion){
    this.setStoreEmbarcacion(inUserSession);
}
FrmCgg_res_movilidad_interna.prototype.setStoreAerolinea = function(inStoreAerolinea){
    this.setStoreAerolinea(inStoreAerolinea);
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_movilidad_interna desde una instancia.
 */
FrmCgg_res_movilidad_interna.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_movilidad_interna desde una instancia.
 */
FrmCgg_res_movilidad_interna.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_movilidad_interna,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_movilidad_interna.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_movilidad_interna desde una instancia.
 */
FrmCgg_res_movilidad_interna.prototype.loadData = function(){
    this.loadData();
}

FrmCgg_res_movilidad_interna.prototype.setStoreHospedaje = function(inStoreHospedaje){
    this.setStoreHospedaje(inStoreHospedaje);
}

FrmCgg_res_movilidad_interna.prototype.setStoreActividad = function(inStoreActividad){
    this.setStoreActividad(inStoreActividad);
}