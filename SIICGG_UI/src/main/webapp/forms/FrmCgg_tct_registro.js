/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_tct_registro.
 * @param {String} IN_SENTENCIA_CGG_TCT_REGISTRO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_TCT_REGISTRO Registro de datos de la tabla Cgg_tct_registro.
 * @constructor
 * @base FrmListadoCgg_tct_registro
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_tct_registro(IN_SENTENCIA_CGG_TCT_REGISTRO,IN_RECORD_CGG_TCT_REGISTRO, inPrintMode,inStoreActividad,inStoreHospedaje,inDesktop) {
    var inSentenciaCgg_tct_registro = IN_SENTENCIA_CGG_TCT_REGISTRO;
    var inRecordCgg_tct_registro = IN_RECORD_CGG_TCT_REGISTRO;
    var urlCgg_tct_registro = URL_WS + "Cgg_tct_registro";
    var tituloCgg_tct_registro = 'Pre registro de personas';
    var descCgg_tct_registro = 'El formulario permite administrar la informaci\u00f3n del Pre-Registro de Personas';
    var isEdit = false;
    var tmpCraln_codigo;
    var regTipoDocumento;
    var regNacionalidad;
    var regResidencia;
    var regEspecie_Kardex;
    var tmpIsLock = false;
    var tmpFailCheck = false;
    var tmpStoreHospedaje = inStoreHospedaje;
    var tmpStoreActividad = inStoreActividad;
    var tmpNumeroDocumento = null; //Variable utilizada para almacenar el numero de documento a ser evaluado desde las reglas de validacion
    var objReglasValidacion = null; //Varibale utilizada para almacenar las regla aplicar en este control
    var tmpObjReglasValidacion = null;//Variable utilizada para almacenar las reglas de validacion a aplicar, como cadena original
    //Variables de reglas de validacion
    var tmpCrper_codigo;
    var tmpFechaIngreso = CURRENT_DATE.format(TypeDateFormat.ISO8601Long);
    var tmpCarpt_codigo_origen;
    var tmpCarpt_codigo_destino;
    var tmpUserSesion = new UserSession();
    var tmpCusu_nombre =  tmpUserSesion.getUserName().trim();
    ///////////////////////////
    var tmpPrintMode = false;
    var tmpSelectionModel;
    var myJasperServer = new JasperServer();
    var deskApp = inDesktop;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TCT
     */
    var txtCtreg_codigo = new Ext.form.TextField({
        id:'txtCtreg_codigo',
        name:'txtCtreg_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.form.TextField NUMERO DE TRAMITE
     */
    var txtCrtra_numero = new Ext.form.TextField({
        id:'txtCrtra_numero',
        name:'txtCrtra_numero',
        fieldLabel :'Numero',
        anchor:'98%',
        readOnly:true
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TCT
     */
    var txtCtgtr_codigo = new Ext.form.TextField({
        id:'txtCtgtr_codigo',
        name:'txtCtgtr_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        hidden:true,
        hideLabel:true,
        allowBlank :false
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
                if(!tmpUserSesion.getUserData().CUSU_USUARIO_INTERNO){
                    for(i = 0; i < inRecords.length; i++)
                        if(inRecords[i].data.CARPT_TIPO_AEREOPUERTO == 1)
                            inStore.remove(inRecords[i]);
                }
                if(new ManagerCookies().read('CARPT_CODIGO') != null) {
                    tmpCarpt_codigo_origen = new ManagerCookies().read('CARPT_CODIGO');
                    cbxCarpt_codigo.setValue(new ManagerCookies().read('CARPT_CODIGO'));
                }
            }
        }
    });
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_aeropuerto por un campo especifico.
     */
    var gsAerDestino = new Ext.data.Store({
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
                if(!tmpUserSesion.getUserData().CUSU_USUARIO_INTERNO){
                    for(i = 0; i < inRecords.length; i++)
                        if(inRecords[i].data.CARPT_TIPO_AEREOPUERTO == 0)
                            inStore.remove(inRecords[i]);

                }
                if(new ManagerCookies().read('CGG_CARPT_CODIGO') != null) {
                    cbxCgg_carpt_codigo.setValue(new ManagerCookies().read('CGG_CARPT_CODIGO'));
                }
            }
        }
    });

    /**
     * Ext.form.ComboBox IDENTIFICATIVO UNICO DE REGISTRO
     */
    var cbxCarpt_codigo= new Ext.form.ComboBox({
        id:'cbxCarpt_codigo',
        fieldLabel :'Origen',
        displayField:'CARPT_NOMBRE',
        store:gsAerOrigen,
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        editable:true,
        triggerAction:'all',
        emptyText:'Seleccione el origen',
        selectOnFocus:true,
        valueField:'CARPT_CODIGO',
        allowBlank :false,
        anchor:'98%',
        listeners:{
            select:function(combo,record){
                tmpCarpt_codigo_origen = record.get('CARPT_CODIGO');
                validarAeropuerto(tmpCarpt_codigo_origen, tmpCarpt_codigo_destino);
                new ManagerCookies().erase('CARPT_CODIGO');
                new ManagerCookies().create('CARPT_CODIGO', record.get('CARPT_CODIGO'), 168);
            }
        }
    });

    /**
     * Ext.form.ComboBox IDENTIFICATIVO UNICO DE REGISTRO DE DESTINO
     */
    var cbxCgg_carpt_codigo= new Ext.form.ComboBox({
        id:'cbxCgg_carpt_codigo',
        fieldLabel :'Destino',
        displayField:'CARPT_NOMBRE',
        store:gsAerDestino,
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        editable:true,
        triggerAction:'all',
        emptyText:'Seleccione el destino',
        selectOnFocus:true,
        valueField:'CARPT_CODIGO',
        allowBlank :false,
        anchor:'98%',
        listeners:{
            select:function(combo,record){
                tmpCarpt_codigo_destino = record.get('CARPT_CODIGO');
                validarAeropuerto(tmpCarpt_codigo_origen, tmpCarpt_codigo_destino);
                new ManagerCookies().erase('CGG_CARPT_CODIGO');
                new ManagerCookies().create('CGG_CARPT_CODIGO', record.get('CARPT_CODIGO'), 168);
            }
        }
    });
    gsAerOrigen.load();
    gsAerDestino.load();

    function validarAeropuerto(){
        if(tmpCarpt_codigo_origen == tmpCarpt_codigo_destino){
            Ext.MessageBox.alert('Aviso', 'El aeropuerto de origen no puede ser igual al de destino');
            cbxCgg_carpt_codigo.clearValue();
            cbxCarpt_codigo.clearValue();
            tmpCarpt_codigo_origen = undefined;
            tmpCarpt_codigo_destino = undefined;
        }
    }
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
            format:TypeFormat.JSON
        },
        listeners:{
            load:function(){
                if(new ManagerCookies().read('CRALN_CODIGO') != null) {
                    cbxCraln_codigo.setValue(new ManagerCookies().read('CRALN_CODIGO'));
                }
            }
        }
    });



    /**
     * Ext.form.ComboBox Aereolinea de la tct.
     */
    var cbxCraln_codigo = new Ext.form.ComboBox({
        id:'cbxCraln_codigo',
        fieldLabel :'Aerol\u00ednea',
        displayField:'CRALN_NOMBRE',
        store:gsCgg_res_aerolinea,
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        editable:true,
        triggerAction:'all',
        emptyText:'Seleccione la aerol\u00ednea',
        selectOnFocus:true,
        valueField:'CRALN_CODIGO',
        allowBlank :false,
        anchor:'98%',
        listeners:
        {
            select:function(combo,record)
            {
                tmpCraln_codigo = record.get('CRALN_CODIGO');

                new ManagerCookies().erase('CRALN_CODIGO');
                new ManagerCookies().create('CRALN_CODIGO', record.get('CRALN_CODIGO'), 168);
            }
        }
    });
    gsCgg_res_aerolinea.load();

    /**
     * Ext.form.NumberField NUMERO SECUENCIAL UNICO DEL REGISTRO DE TCT
     */
    var numCtreg_numero = new Ext.form.NumberField({
        id:'numCtreg_numero',
        name:'numCtreg_numero',
        fieldLabel :'N\u00famero',
        width:240,
        value:0
    });

    var numCtreg_numero_vuelo = new Ext.form.TextField({
        id:'numCtreg_numero_vuelo',
        name:'numCtreg_numero_vuelo',
        fieldLabel :'Vuelo',
        editable:true,
        allowBlank :false,
        anchor:'98%'
    });
    /**
     * Ext.form.DateField FECHA DE RESERVA DEL TCT
     */
    var dtCtreg_fecha_preregistro = new Ext.form.DateField({
        id:'dtCtreg_fecha_preregistro',
        name:'dtCtreg_fecha_preregistro',
        fieldLabel :'Preregistro',
        allowBlank :false,
        format :'d/m/Y',
        value:CURRENT_DATE
    });
    /**
     * Ext.form.DateField FECHA DE INGRESO  A LA PROVINCIA
     */
    var dtCtreg_fecha_ingreso = new Ext.form.DateField({
        id:'dtCtreg_fecha_ingreso',
        name:'dtCtreg_fecha_ingreso',
        fieldLabel :'Ingreso',
        format :'d/m/Y',
        minValue:CURRENT_DATE,
        value:CURRENT_DATE,
        listeners:{
            change:function(obj,newValue,oldValue){
                dtCtreg_fecha_salida.setMinValue(newValue);
                dtCtreg_fecha_salida.setValue(newValue);
                tmpFechaIngreso = newValue.format(TypeDateFormat.ISO8601Long);
            },
            select:function(obj,value){
                dtCtreg_fecha_salida.setMinValue(value);
                dtCtreg_fecha_salida.setValue(value);
                tmpFechaIngreso = value.format(TypeDateFormat.ISO8601Long);
            }
        }
    });
    /**
     * Ext.form.NumberField CODIGO DE BARRAS GENERADO PARA EL REGISTRO DE TCT
     */
    var numCtreg_codigo_barras = new Ext.form.TextField({
        id:'numCtreg_codigo_barras',
        name:'numCtreg_codigo_barras',
        fieldLabel :'Numero de grupo',
        anchor:'98%',
        value:0,
        listeners:{
            specialkey :function(inField, e) {
                if (e.getKey() == e.ENTER) {
                    gsCtreg_codigo_barras.reload({
                        params:{
                            inCtgtr_numero:numCtreg_codigo_barras.getValue(),
                            format:TypeFormat.JSON
                        }
                    });
                }
            }
        }
    });
    /**
     * Ext.form.DateField FECHA DE SALIDA DE LA PROVINCIA
     */
    var dtCtreg_fecha_salida = new Ext.form.DateField({
        id:'dtCtreg_fecha_salida',
        name:'dtCtreg_fecha_salida',
        fieldLabel :'Salida',
        format :'d/m/Y',
        minValue:dtCtreg_fecha_ingreso.getValue(),
        value:CURRENT_DATE
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
        smActividad,{
            dataIndex:'CTACT_NOMBRE',
            header:'Actividad',
            width:150,
            sortable:true
        }]);


    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_tct_actividad en un formato tabular de filas y columnas.
     */
    var grdCgg_tct_actividad = new Ext.grid.GridPanel({
        cm:cmCgg_tct_actividad,
        store:tmpStoreActividad,
        sm:smActividad,
        region:'west',
        width:'50%',
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
                for ( var j = 0; j < tmpStoreActividad.getTotalCount(); j++) {
                    for (var i = 0; i < gsCgg_tct_actividad_reg.getTotalCount(); i++) {
                        if (gsCgg_tct_actividad_reg.getAt(i).get('CTACT_CODIGO')==tmpStoreActividad.getAt(j).get('CTACT_CODIGO')){
                            smActividad.selectRow(j,true);
                            break;
                        }
                    }
                }
                if(tmpIsLock)
                    smActividad.lock();
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
        {
            dataIndex:'CTTHJ_NOMBRE',
            header:'Hospedaje',
            width:150,
            sortable:true
        }]);


    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_tct_tipo_hospedaje en un formato tabular de filas y columnas.
     */
    var grdCgg_tct_tipo_hospedaje = new Ext.grid.GridPanel({
        cm:cmCgg_tct_tipo_hospedaje,
        store:tmpStoreHospedaje,
        region:'center',
        anchor:'50%',
        split:true,
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
            method:"selectMultipleHospedajeTct",
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
                if(tmpIsLock)
                    smTipo_Hospedaje.lock();
            }
        }
    });
    ///////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_documento_identificacio por un campo especifico.
     */
    var inRecordCgg_res_persona;

    var cbxCrdid_codigo = new Ext.form.ComboBox({
        id:'cbxCrdid_codigo',
        name:'cbxCrdid_codigo',
        fieldLabel :'Tipo de documento',
        anchor:'50%',
        displayField:'CRDID_DESCRIPCION',
        typeAhead: true,
        editable:false,
        mode: 'local',
        forceSelection:true,
        allowBlank :false,
        triggerAction:'all',
        emptyText:'Seleccione un tipo documento identidad',
        selectOnFocus:true,
        valueField:'CRDID_CODIGO',
        listeners:{
            change:function(inSource, inNewValue, inOldValue){
                cbxCrdid_codigo.setReadOnly(true);
            }
        }
    });

    var cbxCkesp_codigo = new Ext.form.ComboBox({
        id:'cbxCkesp_codigo',
        name:'cbxCkesp_codigo',
        fieldLabel :'Tipo especie',
        anchor:'50%',
        displayField:'CKESP_NOMBRE',
        typeAhead: true,
        mode: 'local',
        editable:false,
        forceSelection:true,
        triggerAction:'all',
        allowBlank :false,
        emptyText:'Seleccione un tipo especie',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CKESP_NOMBRE}. {CKESP_NOMBRE}" class="x-combo-list-item">{CKESP_NOMBRE}</div></tpl>',
        valueField:'CKESP_CODIGO'
    });


    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE NACIONALIDAD
     */
    var cbxCgncn_codigo = new Ext.form.ComboBox({
        id:'cbxCgncn_codigo',
        name:'cbxCgncn_codigo',
        fieldLabel :'Nacionalidad',
        anchor:'98%',
        displayField:'CGNCN_NACIONALIDAD',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        editable:true,
        allowBlank :false,
        triggerAction:'all',
        emptyText:'Seleccione una Nacionalidad',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CGNCN_NACIONALIDAD}" class="x-combo-list-item">{CGNCN_NACIONALIDAD}</div></tpl>',
        valueField:'CGNCN_CODIGO',
		listeners:{
			select:function ( combo, record, index )
			{
				/*alert(record.data.CGNCN_CODIGO);
				cbxCgg_cpais_codigo.setValue(record.data.CGNCN_CODIGO);*/
			}
		}
		
    });

    var cbxCrper_genero = new Ext.form.ComboBox({
        id:'cbxCrper_genero',
        name:'cbxCrper_genero',
        store: dsGeneroPersona,
        anchor:'75%',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        editable: true,
        allowBlank :false,
        triggerAction:'all',
        emptyText : 'Seleccione el G\u00e9nero',
        value:0
    });

/* Ext.form.Checkbox Seguimiento
    */
    var chk_seguimiento_persona = new Ext.form.Checkbox({
        id: 'chk_seguimiento_persona',
        name: 'chk_seguimiento_persona',
        fieldLabel: 'Seguimiento',
        checked: false
    });

    /**
     * Ext.form.TextField NOMBRES DE LA PERSONA
     */
    var txtCrper_nombres = new Ext.form.TextField({
        id:'txtCrper_nombres',
        name:'txtCrper_nombres',
        fieldLabel :'Nombres',
        anchor:'98%',
        allowBlank :false,
        invalidText : 'Es necesario ingresar el nombre  de la persona '
    });
    /**
     * Ext.form.TextField APELLIDO PATERNO
     */
    var txtCrper_apellido_paterno = new Ext.form.TextField({
        id:'txtCrper_apellido_paterno',
        name:'txtCrper_apellido_paterno',
        fieldLabel :'Primer apellido',
        anchor:'98%',
        allowBlank :false,
        invalidText : 'Es necesario ingresar el apellido  de la persona '
    });

    var existChange = false;
    /**
     * Ext.form.TextField NUMERO DE DOCUEMNTO DE IDENTIFICACION
     */
    var txtCrper_num_doc_identific = new Ext.form.TextField({
        id:'txtCrper_num_doc_identific',
        name:'txtCrper_num_doc_identific',
        fieldLabel :'No. identific.',
        anchor:'98%',
        style:{textTransform: "uppercase"},
        allowBlank :false,
        maskRe:/[0-9a-zA-Z]+/,
        invalidText : 'Es necesario definir un numero de identificaci\u00f3n ',
        listeners:{
            change: function(field, newValue, oldValue){
                if (newValue != oldValue)
                {
                   existChange = true;
                }
                field.setValue(newValue.toUpperCase());
                if(txtCrper_num_doc_identific.getValue().length > 0)
                    cbxCrdid_codigo.setReadOnly(true);
            },
            blur:function(inSource){
                if(txtCrper_num_doc_identific.getValue().length > 0)
                {
                    if(existChange)
                    {
                        consultarDatos();
                        existChange = false;
                        //txtCtreg_flag.setValue('');
                    }

                }
               /*else
                {
                    Ext.Msg.show({
                        title:tituloCgg_tct_registro,
                        msg: 'N\u00famero de identificaci\u00f3n no valido',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.WARNING
                    });
                    reTctRegistro.stopEditing();
                }*/

            }
        }
    });

    function consultarDatos (){
        if(cbxCrdid_codigo.getValue() == SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','CONF33')).get('CGCNF_VALOR_CADENA')){
            var tmp = validarCedula(txtCrper_num_doc_identific.getValue());
            if (tmp== true){
                consultarPersona();
            }else{
                Ext.Msg.show({
                    title:tituloCgg_tct_registro,
                    msg: 'N\u00famero de identificaci\u00f3n no valido',
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.WARNING
                });
                reTctRegistro.stopEditing(false);
            }
        }else
            consultarPersona();
    }
    SCGG_PAIS.sort('CPAIS_NOMBRE','ASC');
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PAIS DE RESIDENCIA
     */
    var cbxCgg_cpais_codigo = new Ext.form.ComboBox({
        id:'cbxCgg_cpais_codigo',
        name:'cbxCgg_cpais_codigo',
        store:SCGG_PAIS,
        fieldLabel :'Pa\u00eds Residencia',
        anchor:'98%',
        displayField:'CPAIS_NOMBRE',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        editable:true,
        allowBlank :false,
        triggerAction:'all',
        emptyText:'Seleccione una Residencia',
        selectOnFocus:true,
        valueField:'CPAIS_CODIGO',
        listeners:{
            select:function(inThis,inRecord,inIndex){
                cbxCgncn_codigo.setValue(inRecord.data.CPAIS_CODIGO);
            },
			change:function(inThis,inNewValue,inOldValue){
                cbxCgncn_codigo.setValue(inNewValue);
            }
			
        }
    });

    /**
     * Ext.form.TextField APELLIDO PATERNO
     */
    var txtCrtipo_persona = new Ext.form.TextField({
        id:'txtCrtipo_persona',
        name:'txtCrtipo_persona',
        fieldLabel :'Tipo',
        anchor:'98%',
        readOnly:'true'
    });


    /**
     * Ext.form.TextField APELLIDO PATERNO
     */
    var txtCrtra_codigo = new Ext.form.TextField({
        id:'txtCrtra_codigo',
        name:'txtCrtra_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        hidden:true,
        hideLabel:true,
        readOnly:'true'
    });
    /**
     * Ext.form.DateField FECHA DE NACIMIENTO
     */
    var dtCrper_fecha_nacimiento = new Ext.form.DateField({
        id:'dtCrper_fecha_nacimiento',
        name:'dtCrper_fecha_nacimiento',
        fieldLabel :'Fecha n.',
        format:'d/m/Y',
        value:CURRENT_DATE,
        maxValue:CURRENT_DATE
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TCT
     */
    var txtCtregPer_codigo = new Ext.form.TextField({
        id:'txtCtregPer_codigo',
        name:'txtCtregPer_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        hidden:true,
        hideLabel:true
    });

    /**
     * Ext.ColumnModel Agrupacion de registros de la tabla Cgg_res_persona_contacto por un campo especifico.
     */
    var cmCgg_res_persona = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
        {dataIndex:'CRDID_CODIGO',header:'Documento',width:100,sortable:true,editor:cbxCrdid_codigo,editable:!inPrintMode,renderer:function(inCrdid_codigo) {
            var i =0;
            for (i = 0; i < regTipoDocumento.getTotalCount(); i++) {
                if (inCrdid_codigo == regTipoDocumento.getAt(i).get('CRDID_CODIGO')) {
                    inCrdid_codigo = regTipoDocumento.getAt(i).get('CRDID_DESCRIPCION');
                }
            }
            return inCrdid_codigo;
        }
        },
        {dataIndex:'CRPER_NUM_DOC_IDENTIFIC',header:'Num. de doc.',width:100,sortable:true,editor:txtCrper_num_doc_identific,editable:!inPrintMode},
        {dataIndex:'CRPER_NOMBRES',header:'Nombres',width:100,sortable:true,editor:txtCrper_nombres,editable:!inPrintMode},
        {dataIndex:'CRPER_APELLIDO_PATERNO',header:'Apellidos',width:100,sortable:true,editor:txtCrper_apellido_paterno,editable:!inPrintMode},
        {dataIndex:'CRPER_GENERO',header:'G\u00e9nero',width:50,sortable:true,editor: cbxCrper_genero,editable:!inPrintMode,renderer:function(inCrper_genero){
            if(inCrper_genero != null && inCrper_genero >= 0)
                return dsGeneroPersona[inCrper_genero][1];
        }
        },
        {dataIndex:'CRPER_FECHA_NACIMIENTO',header:'Fecha n.',width:80,sortable:true,editor:dtCrper_fecha_nacimiento,editable:!inPrintMode,renderer:truncDate},
        {dataIndex:'CGG_CPAIS_CODIGO',header:'Pa\u00eds Residencia',width:100,sortable:true,editor:cbxCgg_cpais_codigo,editable:!inPrintMode,renderer:function(inCpais_codigo) {
            var tmpRecord = SCGG_PAIS.getAt(SCGG_PAIS.findExact('CPAIS_CODIGO', inCpais_codigo));
            if(tmpRecord)
                return tmpRecord.data.CPAIS_NOMBRE;
            return inCpais_codigo;
        }
        },
        {dataIndex:'CGNCN_CODIGO',header:'Nacionalidad',width:100,sortable:true,editor:cbxCgncn_codigo,editable:!inPrintMode,renderer:function(inCgncn_codigo) {
            var tmpRecord = regNacionalidad.getAt(regNacionalidad.findExact('CGNCN_CODIGO', inCgncn_codigo));
            if(tmpRecord)
			{
                cbxCgg_cpais_codigo.setValue(inCgncn_codigo);
				return tmpRecord.data.CGNCN_NACIONALIDAD;
				// cbxCgncn_codigo.setValue(tmpSelect[0].CGNCN_CODIGO);
                
			}
            return inCgncn_codigo;
        }
        },
        {dataIndex:'CKESP_CODIGO',header:'Especie',width:80,sortable:true,editable:!inPrintMode,hiddeable:(tmpUserSesion.getUserData().CUSU_USUARIO_INTERNO),hidden:(!tmpUserSesion.getUserData().CUSU_USUARIO_INTERNO),editor:cbxCkesp_codigo,renderer:function(inCkesp_codigo) {
            for (i = 0; i < regEspecie_Kardex.getCount(); i++) {
                if (inCkesp_codigo == regEspecie_Kardex.getAt(i).get('CKESP_CODIGO')) {
                    return regEspecie_Kardex.getAt(i).get('CKESP_NOMBRE');
                }
            }
            return inCkesp_codigo;

        }
        },
        {dataIndex:'TIPO_RESIDENCIA',header:'Tipo',width:100,sortable:true,align:'center',editable:!inPrintMode,editor:txtCrtipo_persona},
        {dataIndex:'CRTRA_CODIGO',header:'codigo',width:10,sortable:true,editor:txtCrtra_codigo,hidden:true,hiddeable:true,editable:!inPrintMode},
        {dataIndex:'CRTRA_NUMERO',header:'No. aut.',width:50,sortable:true,editor:txtCrtra_numero,editable:true},
        {dataIndex:'CTREG_OBSERVACION',header:'Observaci\u00f3n',width:80,sortable:true,editable:true,editor:new Ext.form.TextField({})},
        {dataIndex:'CRPER_SEGUIMIENTO',header:'Seguimiento',width:80,sortable:true,align:'center',editor:chk_seguimiento_persona},
    ]);

    function consultarPersona(){
        function CallBackCgg_tct_persona(r){
            tmpNumeroDocumento = txtCrper_num_doc_identific.getValue();
            var tmpSelect = Ext.util.JSON.decode(r);
            if (tmpSelect.length == 0){
                Ext.MsgPopup.msg(tituloCgg_tct_registro, 'Datos no asociados a ninguna persona, ingrese los datos por favor.', MsgPopup.WARNING);
                var tmpRecord = gsCgg_res_persona.getAt(0);
               /* new tmpRecordPersona({
                            CTREG_CODIGO:'',
                            CRPER_CODIGO:'',
                            CRDID_CODIGO:SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','CONF33')).get('CGCNF_VALOR_CADENA'),
                            CRPER_NUM_DOC_IDENTIFIC: '',
                            CRPER_NOMBRES: '',
                            CRPER_APELLIDO_PATERNO: '',
                            CRPER_GENERO: 0,
                            CRPER_FECHA_NACIMIENTO:CURRENT_DATE,
                            CGG_CPAIS_CODIGO:SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','CONF38')).get('CGCNF_VALOR_CADENA'),
                            CGNCN_CODIGO:SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','CONF36')).get('CGCNF_VALOR_CADENA'),
                            CKESP_CODIGO:SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','CONF35')).get('CGCNF_VALOR_CADENA'),
                            CRTRA_CODIGO:'',
                            CRTRA_NUMERO:'',
                            CTREG_OBSERVACION:''
                        })*/
                tmpCrper_codigo = '';
                tmpRecord.data.CRPER_CODIGO = '';
                txtCrper_nombres.setValue('');
                txtCrper_apellido_paterno.setValue('');
                cbxCrper_genero.setValue(0);
                cbxCgncn_codigo.setValue(SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','CONF36')).get('CGCNF_VALOR_CADENA'));
                cbxCgg_cpais_codigo.setValue(SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','CONF38')).get('CGCNF_VALOR_CADENA'));
                cbxCkesp_codigo.setValue(SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','CONF35')).get('CGCNF_VALOR_CADENA'));
                dtCrper_fecha_nacimiento.setValue(new Date());
                tmpRecord.data.CRTRA_CODIGO = '';
                txtCrtra_numero.setValue('');
                txtCrtipo_persona.setValue('TURISTA');
                chk_seguimiento_persona.setValue(false);


            }else{
                var tmpRecord = gsCgg_res_persona.getAt(0);
                tmpRecord.beginEdit();
                //Variable referenciada en las reglas de validacion
                tmpCrper_codigo = tmpSelect[0].CRPER_CODIGO;
                tmpRecord.data.CRPER_CODIGO = tmpSelect[0].CRPER_CODIGO;
                txtCrper_nombres.setValue(tmpSelect[0].CRPER_NOMBRES);
                txtCrper_apellido_paterno.setValue(tmpSelect[0].CRPER_APELLIDO_PATERNO);
                var tmps= (tmpSelect[0].CRPER_GENERO+" ").trim();
                if (tmps.length>0)
                    cbxCrper_genero.setValue(tmpSelect[0].CRPER_GENERO);
                cbxCgncn_codigo.setValue(tmpSelect[0].CGNCN_CODIGO);
                cbxCgg_cpais_codigo.setValue(tmpSelect[0].CGG_CPAIS_CODIGO);
                if(tmpSelect[0].CKESP_CODIGO)
                    cbxCkesp_codigo.setValue(tmpSelect[0].CKESP_CODIGO);
                else
					if (tmpSelect[0].CRTRA_NUMERO != undefined)
						cbxCkesp_codigo.setValue(SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','CONF51')).get('CGCNF_VALOR_CADENA'));
					else
						cbxCkesp_codigo.setValue(SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','CONF35')).get('CGCNF_VALOR_CADENA'));
                dtCrper_fecha_nacimiento.setValue(Date.parse(truncDate(tmpSelect[0].CRPER_FECHA_NACIMIENTO)));
                if(tmpSelect[0].CRTRA_CODIGO)
                    tmpRecord.data.CRTRA_CODIGO = tmpSelect[0].CRTRA_CODIGO;
                else
                    tmpRecord.data.CRTRA_CODIGO = '';
                txtCrtra_numero.setValue(tmpSelect[0].CRTRA_NUMERO);
                if(tmpSelect[0].CRTRA_NUMERO != undefined)
                    txtCrtipo_persona.setValue('TRANSEUNTE');
                else
                    txtCrtipo_persona.setValue('TURISTA');
                tmpRecord.endEdit();
                validarReglas();
            }
        }
        var param = new SOAPClientParameters();
        param.add('inCrdid_codigo',cbxCrdid_codigo.getValue());
        param.add('inCrper_num_doc_identific',txtCrper_num_doc_identific.getValue());
        param.add('inCtreg_fecha_ingreso',dtCtreg_fecha_ingreso.getValue().format(TypeDateFormat.Custom));
        param.add('format',TypeFormat.JSON);
        SOAPClient.invoke(urlCgg_tct_registro,'selectPersonaTct',param, true, CallBackCgg_tct_persona);
    }
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_tct_agencia_contacto por un campo especifico.
     */
    var gsCgg_res_persona = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS + "Cgg_tct_registro",
            method:"selectTctPersonaTct",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
            id:'CTREG_CODIGO'
        }, [
            {name:'CTREG_CODIGO'},
            {name:'CRPER_CODIGO'},
            {name:'CTGTR_CODIGO'},
            {name:'CRDID_CODIGO'},
            {name:'CRPER_NUM_DOC_IDENTIFIC'},
            {name:'CRPER_NOMBRES'},
            {name:'CRPER_APELLIDO_PATERNO'},
            {name:'CRPER_GENERO'},
            {name:'CGNCN_CODIGO'},
            {name:'CRPER_FECHA_NACIMIENTO'},
            {name:'CKESP_CODIGO'},
            {name:'CGG_CPAIS_CODIGO'},
            {name:'CRTRA_CODIGO'},
            {name:'CRTRA_NUMERO'},
            {name:'TIPO_RESIDENCIA'},
            {name:'CKESP_CODIGO'},
            {name:'CKESP_REPORTE'},
            {name:'CTREG_OBSERVACION'},
            {name:'CRPER_SEGUIMIENTO'}

        ]),
        baseParams:{
            inCtgtr_codigo:"",
            format:"JSON",
            inCtreg_estado_registro:'0'
        }
    });

    var btnAnular = new Ext.Button({
        iconCls:'iconAnular',
        id:'btnAnular',
        name:'btnAnular',
        tooltip:'Anular registro',
        listeners:{
            click:function(){
                var seleccionado = grdCgg_res_persona.getSelectionModel().getSelected();
                if(seleccionado && seleccionado.data.CTREG_CODIGO.length > 0){
                    function CallBackCgg_tct_registroAnular(r) {
                        winFrmCgg_tct_registro.getEl().unmask();
                        if (r == 'true') {
                            Ext.Msg.show({
                                title:tituloCgg_tct_registro,
                                msg: 'La informaci\u00f3n ha sido anulada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            winFrmCgg_tct_registro.close();
                        } else
                            Ext.Msg.show({
                                title:tituloCgg_tct_registro,
                                msg: 'La informaci\u00f3n no ha podido ser anulada. ' + (r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                    }
                    winFrmCgg_tct_registro.getEl().mask('Anulando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    param.add('inCtreg_codigo', grdCgg_res_persona.getSelectionModel().getSelected().get('CTREG_CODIGO'));
                    param.add('inCtreg_estado_registro',3);
                    SOAPClient.invoke(urlCgg_tct_registro, "updateEstadoAnulada", param, true, CallBackCgg_tct_registroAnular);
                }else{
                    if( seleccionado.data.CTREG_CODIGO.length == 0)
                        gsCgg_res_persona.remove(grdCgg_res_persona.getSelectionModel().getSelected());
                    else
                        Ext.Msg.show({
                            title:'Aviso',
                            msg:'Seleccione el Pre Registro para ser anulado',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.QUESTION
                        });
                }
            }
        }
    });
    if(inPrintMode){
        tmpSelectionModel = new Ext.grid.CheckboxSelectionModel();
        cmCgg_res_persona.config.splice(0,0,tmpSelectionModel);
    }else{
        tmpSelectionModel = new Ext.grid.RowSelectionModel({
            singleSelect:true,
            moveOnEnter:true
        });
    }
    var tmpIsEdit =  false;
    var reTctRegistro = new Ext.ux.grid.RowEditor({
        saveText: 'Aceptar',
        cancelText:'Cancelar',
        errorSummary: false,
        listeners:{
            beforeedit:function(inSource, inRowIndex){
                //Ext.getCmp('btnAgregaTct').disable();
                var tmpRecord = gsCgg_res_persona.getAt(inRowIndex);
                if(tmpRecord && typeof(tmpRecord.data.CRPER_FECHA_NACIMIENTO) == 'string'){
                    tmpRecord.data.CRPER_FECHA_NACIMIENTO = Date.parse(tmpRecord.data.CRPER_FECHA_NACIMIENTO.substr(0,tmpRecord.data.CRPER_FECHA_NACIMIENTO.lastIndexOf('.')));
                }
            },
            afteredit:function(inSource,inObject,inRecord,inRowIndex){
                var tmpRecord = gsCgg_res_persona.getAt(gsCgg_res_persona.findExact('CRPER_NUM_DOC_IDENTIFIC',inRecord.data.CRPER_NUM_DOC_IDENTIFIC,1));                
                if(tmpRecord && tmpRecord != inRecord && (tmpRecord.data.CRDID_CODIGO == inRecord.data.CRDID_CODIGO &&
                        (isEdit && tmpRecord.data.CTREG_CODIGO != inRecord.data.CTREG_CODIGO) || (!isEdit && inRecord.data.CTREG_CODIGO.length == 0)) ){
                    Ext.MsgPopup.msg(tituloCgg_tct_registro, 'Persona repetida!',MsgPopup.WARNING);
                    tmpFailCheck = true;
                    gsCgg_res_persona.removeAt(0);
                    grdCgg_res_persona.getView().refresh();
                }
                //Ext.getCmp('btnAgregaTct').enable();
            },
            canceledit:function(inRowEditor,inForced){
                //Ext.getCmp('btnAgregaTct').enable();
                if(grdCgg_res_persona.getSelectionModel().getSelected().get('CRPER_NUM_DOC_IDENTIFIC').length == 0 && inForced == true){
                    gsCgg_res_persona.removeAt(0);
                    grdCgg_res_persona.getView().refresh();
                }

                if (tmpIsEdit)
                {
                     var tmpRecord = grdCgg_res_persona.getSelectionModel().getSelected();
                    if(tmpRecord){
                        if((tmpRecord.data.CTREG_CODIGO == 'KEYGEN' || tmpRecord.data.CTREG_CODIGO.length == 0) && !tmpFailCheck){
                            gsCgg_res_persona.remove(tmpRecord);
                            grdCgg_res_persona.getView().refresh();
                        }
                        tmpFailCheck = false;
                    }
                    tmpIsEdit = false;                    
                }                
            },
            validateedit:function(inRowEditor,inObject,inRecord,inRowIndex){
                 // Ext.getCmp('btnAgregaTct').enable();
                  tmpIsEdit = false;
                // reTctRegistro.stopEditing();
                 //reTctRegistro.startEditing(0);
                 // alert(inRecord.data.CRPER_NUM_DOC_IDENTIFIC);
            }
        }
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_persona_contacto en un formato tabular de filas y columnas.
     */
    //Estilos
    var css =[];
    css.push(".seguimiento-row .x-grid-cell { background-color: #ffe2e2; color: #900; } ");
    css.push(".regular-row .x-grid-cell { background-color: #fff; color: #000; } ");
    for(var k=0;k<css.length;k++){
        var head = document.head || document.getElementsByTagName('head')[0];
        var style = document.createElement('style');
        style.type = 'text/css';
        if (style.styleSheet){
            style.styleSheet.cssText = css[k];
        } else {
            style.appendChild(document.createTextNode(css[k]));
        }
        head.appendChild(style);
    }

    var grdCgg_res_persona = new Ext.grid.EditorGridPanel({
        cm:cmCgg_res_persona,
        store:gsCgg_res_persona,
        region:'center',
        sm:tmpSelectionModel,
        viewConfig:{
            stripeRows:false,
            getRowClass:function (record) {
                return record.get('CRPER_SEGUIMIENTO')?'regular-row':'seguimiento-row';
            }
        },
        loadMask:{
            msg:"Cargando..."
        },
        tbar:['Persona',{
            iconCls:'iconNuevo',
            id:'btnAgregaTct',
            tooltip:'Agregar persona',
            handler:function() {
                if(!cbxCarpt_codigo.getValue()){
                    Ext.Msg.show({
                        title:'Aviso',
                        msg:'Es necesario seleccionar el aeropuerto de origen para continuar.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.ERROR
                    });
                    return;
                }

                tmpIsEdit = true;
                cbxCrdid_codigo.setReadOnly(false);
                SCGG_PAIS.clearFilter();
                regNacionalidad.clearFilter();
                var tmpRecordPersona = grdCgg_res_persona.getStore().recordType;                
                
                grdCgg_res_persona.getStore().insert(0,
                        new tmpRecordPersona({
                            CTREG_CODIGO:'',
                            CRPER_CODIGO:'',
                            CRDID_CODIGO:SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','CONF33')).get('CGCNF_VALOR_CADENA'),
                            CRPER_NUM_DOC_IDENTIFIC: '',
                            CRPER_NOMBRES: '',
                            CRPER_APELLIDO_PATERNO: '',
                            CRPER_GENERO: 0,
                            CRPER_FECHA_NACIMIENTO:CURRENT_DATE,
                            CGG_CPAIS_CODIGO:SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','CONF38')).get('CGCNF_VALOR_CADENA'),
                            CGNCN_CODIGO:SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','CONF36')).get('CGCNF_VALOR_CADENA'),
                            CKESP_CODIGO:SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','CONF35')).get('CGCNF_VALOR_CADENA'),
                            CRTRA_CODIGO:'',
                            CRTRA_NUMERO:'',
                            CTREG_OBSERVACION:'',
                            CRPER_SEGUIMIENTO:'FALSE'
                        })
                        );
                grdCgg_res_persona.getView().refresh();
                grdCgg_res_persona.getSelectionModel().selectRow(0);
                reTctRegistro.startEditing(0);
                btnImprimirCgg_tct_registro.setDisabled(true);
                
            }
        },btnAnular
        ],
        plugins:reTctRegistro,
        listeners:{
            beforeedit:function(inObject){
                if(inObject.column == 6){
                    gsCgg_res_persona.getAt(inObject.row).data.CRPER_FECHA_NACIMIENTO = truncDate(inObject.value);
                }
            }
        }
    });

    ///////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////
    var gsCtreg_codigo_barras = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS + "Cgg_tct_registro",
            method:"selectRegistroCodigoBarras",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
            id:'CTREG_CODIGO'
        }, [
            {name:'CTREG_CODIGO'},
            {name:'CARPT_CODIGO'},
            {name:'AEROPUER_ORIGEN'},
            {name:'CGG_CARPT_CODIGO'},
            {name:'AEROPUER_DESTINO'},
            {name:'CRALN_CODIGO'},
            {name:'AEROLINEA'},
            {name:'CTGTR_CODIGO'},
            {name:'CTGTR_NUMERO'},
            {name:'CRTRA_CODIGO'},
            {name:'NUMERO'},
            {name:'CTREG_FECHA_INGRESO'},
            {name:'CTREG_FECHA_SALIDA'},
            {name:'CTREG_ESTADO_REGISTRO'},
            {name:'CTACT_CODIGO'},
            {name:'CTTHJ_CODIGO'},
            {name:'CRPER_CODIGO'},
            {name:'CRDID_CODIGO'},
            {name:'CRPER_NUM_DOC_IDENTIFIC'},
            {name:'CRPER_NOMBRES'},
            {name:'CRPER_APELLIDO_PATERNO'},
            {name:'CRPER_GENERO'},
            {name:'CGNCN_CODIGO'},
            {name:'CRPER_FECHA_NACIMIENTO'},
            {name:'CKESP_CODIGO'},
            {name:'CGG_CPAIS_CODIGO'},
            {name:'CRTRA_CODIGO'},
            {name:'CRTRA_NUMERO'},
            {name:'CRTRA_NUMERO_VUELO'}
        ]),
        baseParams:{
            inCtgtr_numero:"",
            format:"JSON"
        },
        listeners:{
            load:function(inStore, inRecords, inObject) {
                if (gsCtreg_codigo_barras.getTotalCount() != 0) {
                    inRecordCgg_tct_registro = gsCtreg_codigo_barras.getAt(0);
                    cargarCgg_tct_registroCtrls();
                } else {
                    Ext.MessageBox.alert('Registro de Ingreso de Personas a la Provincia', 'Datos no registrados');
                    txtCrper_nombres.reset();
                }
            }
        }
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO
     */
    var btnBuscarCodigoBarras = new Ext.Button({
        id:'btnBuscarCodigoBarras',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_BuscarCodigoBarras = new FrmListadoCgg_tct_registro();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_BuscarCodigoBarras.getStore(),tmpFLCgg_BuscarCodigoBarras.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        inRecordCgg_tct_registro = tmpRecord;
                        cargarCgg_tct_registroCtrls();
                    }
                });
                objBusqueda.show();
            }
        }
    });
    ///////
    /*template de la consulta de persona historial*/
    var tmpInfoPersonaImpedidaIngreso;
    tmpInfoPersonaImpedidaIngreso = new Ext.XTemplate(
            '<table width="100%" height="100%" cellpadding="5">' +
                    '<tbody>' +

                    '<tpl for="."'+
                    '<tr>'+
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">',
            '<tpl if="ESTADO==TypeImpos.IMPOSIBILITADO">',

            '</tpl>',
            '</font></td>' +
                    '<div class="tituloTemplate"<font  face="Arial, Helvetica, sans-serif">{DESCRIPCION}</font></div></td>' +
                    '</tr>' +
                    '</tpl>'+
                    '</tbody>' +
                    '</table>'
            );

    ///////////////////////////////////////////////////////////////

    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_tct_registro
     */
    var btnGuardarCgg_tct_registro = new Ext.Button({
        id:'btnGuardarCgg_tct_registro',
        text:'Guardar',
        iconCls:'iconGuardar',
        hidden:inPrintMode,
        listeners:{
            click:function() {
                reTctRegistro.stopEditing();
                if (pnlCgg_tct_registro.getForm().isValid() == false)
                    return;
                try {
                    if(gsCgg_res_persona.data.length == 0){
                        Ext.Msg.show({
                            title:tituloCgg_tct_registro,
                            msg: 'Por favor registre al menos una persona.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.WARNING
                        });
                        return;
                    }
                    if (smTipo_Hospedaje.getSelections().length == 0){
                        Ext.Msg.show({
                            title:tituloCgg_tct_registro,
                            msg: 'Seleccione al menos un hospedaje.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.WARNING
                        });
                        return;
                    }
                    if (smActividad.getSelections().length == 0){
                        Ext.Msg.show({
                            title:tituloCgg_tct_registro,
                            msg: 'Seleccione al menos una actividad.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.WARNING
                        });
                        return;
                    }
                    function CallBackCgg_tct_registro(r) {
                        winFrmCgg_tct_registro.getEl().unmask();
                        var tmpResponse = Ext.util.JSON.decode(r);
                        if(tmpResponse.success){
                            Ext.Msg.show({
                                title:tituloCgg_tct_registro,
                                msg: 'La informaci\u00f3n de pre-registro ha sido almacenada. '+(isEdit?'':'<br>El n\u00famero de grupo es: <span class="numeroTramite">'+tmpResponse.msg+'</span>'),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            winFrmCgg_tct_registro.close();
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_tct_registro,
                                msg: 'La informaci\u00f3n de pre-registro no ha podido ser almacenada. ' + (tmpResponse.msg),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                        btnGuardarCgg_tct_registro.enable();
                    }
                    winFrmCgg_tct_registro.getEl().mask('Guardando...', 'x-mask-loading');

                    btnGuardarCgg_tct_registro.disable();

                    //ANTES DE MANDAR A GUARDAR
                    //CONSULTAMOS SI LAS PERSONAS ESTAN ENTRE LOS MAS BUSCADOS
                    var hayBuscados = false;
                    for(var j=0;j<grdCgg_res_persona.getStore().data.length;j++){
                        param = new SOAPClientParameters();
                        param.add('inIdentificacion', grdCgg_res_persona.getStore().data.items[j].data.CRPER_NUM_DOC_IDENTIFIC);
                        var masBuscado = SOAPClient.invoke(URL_WS+'MasBuscados', 'consultarMB', param, false, null);
                        if(masBuscado=="{true}"){
                            grdCgg_res_persona.getStore().data.items[j].data.CRPER_SEGUIMIENTO=true;
                            grdCgg_res_persona.getStore().data.items[j].data.CTREG_OBSERVACION="EN LISTA DE MAS BUSCADOS; "+grdCgg_res_persona.getStore().data.items[j].data.CTREG_OBSERVACION;
                            hayBuscados = true;
                            console.log(grdCgg_res_persona.getStore().getJsonData());//.backgroundColor('#336699');
                        }
                    }

                    var breakSave = false;
                    if(hayBuscados){
                        Ext.Msg.show({
                            title:'Atenci\u00f3n!!',
                            msg: 'Las personas marcadas tienen problemas juridicos. \nSe pondra una marca de seguimiento, por favor comunique a las autoridades. Desea Continuar?',
                            buttons: Ext.Msg.YESNO,
                            icon: Ext.MessageBox.ERROR,
                            fn: function(btn, text){
                                if (btn == 'ok')
                                    breakSave=false;
                                else
                                    breakSave=true;
                            }
                        });
                    }

                    if(!breakSave){
                        var param = new SOAPClientParameters();
                        if (isEdit){
                            param.add('inCtgtr_codigo', txtCtgtr_codigo.getValue());
                            cbxCarpt_codigo.setValue(tmpCarpt_codigo_origen);
                            cbxCgg_carpt_codigo.setValue(tmpCarpt_codigo_destino);
                            cbxCraln_codigo.setValue(tmpCraln_codigo);
                        }
                        param.add('inCarpt_codigo', cbxCarpt_codigo.getValue());
                        param.add('inCgg_carpt_codigo', cbxCgg_carpt_codigo.getValue());
                        param.add('inCraln_codigo', cbxCraln_codigo.getValue());
                        param.add('inCtreg_numero', numCtreg_numero.getValue());
                        param.add('inCtreg_numero_vuelo', numCtreg_numero_vuelo.getValue());
                        param.add('inCtreg_fecha_preregistro', dtCtreg_fecha_preregistro.getValue().format(TypeDateFormat.Custom));
                        param.add('inCtreg_fecha_ingreso', dtCtreg_fecha_ingreso.getValue().format(TypeDateFormat.Custom));
                        param.add('inCtreg_codigo_barras', numCtreg_codigo_barras.getValue());
                        param.add('inCtreg_fecha_salida', dtCtreg_fecha_salida.getValue().format(TypeDateFormat.Custom));
                        param.add('inHospedaje_JSON', createJSONObject(smTipo_Hospedaje.getSelections()));
                        param.add('inActividad_JSON', createJSONObject(smActividad.getSelections()));
                        param.add('inPersona_JSON', grdCgg_res_persona.getStore().getJsonData());
                        SOAPClient.invoke(urlCgg_tct_registro, IN_SENTENCIA_CGG_TCT_REGISTRO, param, true, CallBackCgg_tct_registro);
                    }
                } catch(inErr) {
                    alert(inErr.message);
                    winFrmCgg_tct_registro.getEl().unmask();
                    btnGuardarCgg_tct_registro.enable();
                }
            }
        }
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_tct_registro
     */
    var btnImprimirCgg_tct_registro  = new Ext.Toolbar.SplitButton({
        id:'btnImprimirCgg_tct_registro',
        text:'Imprimir',
        disabled:true,
        hidden:!inPrintMode,
        iconCls:'iconImprimir',
        menu:[{text:'Imprimir todo',handler:function(){
            if(gsCgg_res_persona.getRange())
                printEspecies(gsCgg_res_persona.getRange());
        }}],
        listeners:{
            click:function() {
                var tmpRecords = tmpSelectionModel.getSelections();
                if(tmpRecords.length > 0){
                    printEspecies(tmpRecords);
                }else{
                    Ext.Msg.show({
                        title:tituloCgg_tct_registro,
                        msg: 'Seleccione los registros que desea imprimir antes continuar.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.INFO
                    });
                }
            }
        }
    });

    function printEspecies(inRecords){
        var tmpArrayReports = new Array();
        var tmpImpRegistros = '';
        function CallBackCgg_tct_registro(r) {
            if (r == 'true') {
                Ext.Msg.show({
                    title:tituloCgg_tct_registro,
                    msg: 'Las especies de Tct han sido impresas.',
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.INFO
                });
                for(var tmpRN in tmpArrayReports){
                    if(typeof(tmpArrayReports[tmpRN]) == 'string'){
                        myJasperServer.addParam('P_PREVIEW',0);
                        myJasperServer.addParam('P_CTGTR_CODIGO',inRecords[0].data.CTGTR_CODIGO);
                        myJasperServer.addParam('P_CKESP_CODIGO',tmpArrayReports[tmpRN]);
                        myJasperServer.addParam('P_CTREG_CODIGO',tmpImpRegistros);
                        myJasperServer.setReportName(tmpRN);
                        myJasperServer.setTitle(tmpRN);
                        myJasperServer.setReportFolder('/Reports/sii/tct');
                        myJasperServer.run();
                    }
                }
                winFrmCgg_tct_registro.close();
            } else
                Ext.Msg.show({
                    title:tituloCgg_tct_registro,
                    msg: 'Las especies de TCT no ha podido ser impresas. ' + (r.message?r.message:r),
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.ERROR
                });
        }
        var tmpData = '[';
        for(i = 0; i < inRecords.length; i++){
            if(i>0){
                tmpData += ',';
                tmpImpRegistros += ',';
            }
            tmpImpRegistros += inRecords[i].data.CTREG_CODIGO;
            tmpArrayReports[inRecords[i].data.CKESP_REPORTE] = inRecords[i].data.CKESP_CODIGO;
            tmpData += '{\"CTREG_CODIGO\":\"'+inRecords[i].data.CTREG_CODIGO+'\",\"CKESP_CODIGO\":\"'+inRecords[i].data.CKESP_CODIGO+'\"}';
        }
        tmpData +=']';
        var param = new SOAPClientParameters();
        param.add('inPersona_JSON', tmpData);
        param.add('inCtreg_estado_registro',1);
        SOAPClient.invoke(urlCgg_tct_registro, 'updateEstadoImpresa', param, true, CallBackCgg_tct_registro);
    }

    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_tct_registro.
     */
    var btnCancelarCgg_tct_registro = new Ext.Button({
        id:'btnCancelarCgg_tct_registro',
        text:'Cancelar',
        iconCls:'iconCancelar',
        hidden:inPrintMode,
        listeners:{
            click:function() {
                pnlCgg_tct_registro.getForm().reset();
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_tct_registro.
     */
    var btnCerrarCgg_tct_registro = new Ext.Button({
        id:'btnCerrarCgg_tct_registro',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function() {
                winFrmCgg_tct_registro.close();
            }
        }
    });
    /*panel que contiene los datos de persona del historial de estadia*/

    var pnlIngresoImpedido = new Ext.Panel({
        id:'pnlIngresoImpedido',
        frame:true,
        anchor:'100% 100%',
        //tbar:['prueba']
        items:[
            {
                xtype:'panel',//layout:'column',
                defaults: {      // defaults applied to items
                    // layout: 'form',
                    // border: false,
                    bodyStyle: 'padding:4px'
                },
                items:[
                    {
                        xtype:'panel',
                        id :'pnlPersonaConsultaImpedidoIngreso',
                        tpl:tmpInfoPersonaImpedidaIngreso
                    }
                ]
            }
        ]


    });

    /**
     * Ext.form.FormPanel Panel para los Aeropuertos
     */
    var pnlfsAeropuerto = new Ext.form.FieldSet({
        id:'pnlfsAeropuerto',
        title:'Datos de la entrada',
        collapsible:true,
        region:'center',
        labelWidth :60,
        layout:'form',
        height:180,
        items:[
            cbxCraln_codigo,
            numCtreg_numero_vuelo,
            cbxCarpt_codigo,
            cbxCgg_carpt_codigo,
            {
                xtype:'panel',
                layout:'hbox',
                //bodyStyle:'padding-right:5',
                items:[{xtype:'label',text:'Estadia: ',  width:65, cls:'x-form-item'}, 
                    dtCtreg_fecha_ingreso,{xtype:'label', style:{width: '60px',textAlign: 'center'}, text:' - ', cls:'x-form-item'},dtCtreg_fecha_salida]
            }
        ],
        listeners:{
            collapse:function(inPanel) {
                pnlCgg_tct_actividad_hospedaje.collapse(false);
                winFrmCgg_tct_registro.doLayout(true);

            },
            expand:function(inPanel) {
                pnlCgg_tct_actividad_hospedaje.expand(false);
                winFrmCgg_tct_registro.doLayout(true);
            }
        }
    });

    var pnlCgg_tct_actividad_hospedaje = new Ext.form.FieldSet({
        id:'pnlCgg_tct_actividad_hospedaje',
        title:'Actividad - hospedaje',
        height:180,
        layout:'border',
        collapsible:true,
        items:[grdCgg_tct_actividad,grdCgg_tct_tipo_hospedaje],
        listeners:{
            collapse:function(inPanel) {
                pnlfsAeropuerto.collapse(false);
                pnlCgg_tct_registro.setHeight(80);
                winFrmCgg_tct_registro.doLayout(true);

            },
            expand:function(inPanel) {
                pnlfsAeropuerto.expand(false);
                pnlCgg_tct_registro.setHeight(220);
                winFrmCgg_tct_registro.doLayout(true);

            }
        }
    });

    /**
     * Ext.form.FormPanel Panel para las Fechas
     */
    var pnlOrganizacion = new Ext.Panel({
        id:'pnlOrganizacion',
        region:'center',
        labelWidth :60,
        layout:'column',
        items:[{
            columnWidth:.60,
            layout:'form',
            anchor:'100%',
            bodyStyle:'padding-right:5',
            items:[pnlfsAeropuerto]
        },{
            columnWidth:.40,
            items:[pnlCgg_tct_actividad_hospedaje]
        }]
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_tct_registro.
     */
    var pnlCgg_tct_registro = new Ext.form.FormPanel({
        frame:true,
        labelWidth :70,
        region:'north',
        layout:'border',
        height:220,
        anchor:'100%',
        items:[{
            xtype:'panel',
            layout:'column',
            region:'north',
            height:25,
            minHeight:25,
            labelWidth:110,
            items:[
                {
                    columnWidth:.80,
                    layout:'form',
                    items:[numCtreg_codigo_barras]
                },
                {
                    columnWidth:.20,
                    layout:'form',
                    items:[btnBuscarCodigoBarras]
                }
            ]
        },
            pnlOrganizacion
        ]
    });

    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_tct_registro.
     */
    var winFrmCgg_tct_registro = null;

    if (deskApp !== null && deskApp !== undefined) {

        winFrmCgg_tct_registro = deskApp.createWindow({
            id:'winFrmCgg_tct_registro',
            title:tituloCgg_tct_registro,
            width:800,
            height:550,
            minWidth:500,
            minimizable:true,
            maximizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo(tituloCgg_tct_registro, descCgg_tct_registro),
            items:[pnlCgg_tct_registro,grdCgg_res_persona],
            bbar:[btnGuardarCgg_tct_registro,btnCancelarCgg_tct_registro,'-',btnImprimirCgg_tct_registro,'->',btnCerrarCgg_tct_registro],
            listeners:{
                show:function(){
                    listarReglasValidacion('FrmCgg_tct_registro');
                }
            }
        });

    }else{

        winFrmCgg_tct_registro = new Ext.Window({
            id:'winFrmCgg_tct_registro',
            title:tituloCgg_tct_registro,
            width:1155,
            height:550,
            minWidth:850,
            minimizable:true,
            maximizable:true,
            constrain:true,
            collapsible:true,
            layout:'border',
            tbar:getPanelTitulo(tituloCgg_tct_registro, descCgg_tct_registro),
            items:[pnlCgg_tct_registro,grdCgg_res_persona],
            bbar:[btnGuardarCgg_tct_registro,btnCancelarCgg_tct_registro,'-',btnImprimirCgg_tct_registro,'->',btnCerrarCgg_tct_registro],
            listeners:{
                show:function(){
                    listarReglasValidacion('FrmCgg_tct_registro');
                }
            }
        });
    }

    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_tct_registro.
     */
    function cargarCgg_tct_registroCtrls() {
        if (inRecordCgg_tct_registro) {
            txtCtreg_codigo.setValue(inRecordCgg_tct_registro.get('CTREG_CODIGO'));
            tmpCarpt_codigo_origen = inRecordCgg_tct_registro.get('CARPT_CODIGO');
            cbxCarpt_codigo.setValue(inRecordCgg_tct_registro.get('AEROPUER_ORIGEN'));
            tmpCarpt_codigo_destino = inRecordCgg_tct_registro.get('CGG_CARPT_CODIGO');
            cbxCgg_carpt_codigo.setValue(inRecordCgg_tct_registro.get('AEROPUER_DESTINO'));
            tmpCraln_codigo = inRecordCgg_tct_registro.get('CRALN_CODIGO');
            cbxCraln_codigo.setValue(inRecordCgg_tct_registro.get('AEROLINEA'));
            txtCtgtr_codigo.setValue(inRecordCgg_tct_registro.get('CTGTR_CODIGO'));
            numCtreg_numero.setValue(inRecordCgg_tct_registro.get('CTREG_NUMERO'));
            numCtreg_numero_vuelo.setValue(inRecordCgg_tct_registro.get('CTREG_NUMERO_VUELO'));
            dtCtreg_fecha_preregistro.setValue(truncDate(inRecordCgg_tct_registro.get('CTREG_FECHA_PREREGISTRO')));
            dtCtreg_fecha_ingreso.setValue(truncDate(inRecordCgg_tct_registro.get('CTREG_FECHA_INGRESO')));
            numCtreg_codigo_barras.setValue(inRecordCgg_tct_registro.get('CTGTR_NUMERO'));
            dtCtreg_fecha_salida.setValue(truncDate(inRecordCgg_tct_registro.get('CTREG_FECHA_SALIDA')));

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

            gsCgg_res_persona.baseParams.inCtgtr_codigo = txtCtgtr_codigo.getValue();
            gsCgg_res_persona.reload();

            btnImprimirCgg_tct_registro.enable();
            isEdit = true;

            function CallBackInfoGrupo(inServerResponse){
                var tmpInfo = Ext.util.JSON.decode(inServerResponse);
                if(tmpInfo[0].TOTAL_TRANS > 0){
                    alert(tituloCgg_tct_registro, 'Se ha deshabilitado la fecha de ingreso por que existe un transe\u00fante en el grupo.');
                    dtCtreg_fecha_ingreso.setReadOnly(true);
                }
                pnlfsAeropuerto.setDisabled(tmpInfo[0].IMPRESAS > 0 || inPrintMode);
                if(tmpInfo[0].IMPRESAS > 0 || inPrintMode){
                    tmpIsLock = true;
                }
            }
            var param = new SOAPClientParameters();
            param.add('inCtgtr_codigo', inRecordCgg_tct_registro.data.CTGTR_CODIGO);
            param.add('format','JSON');
            SOAPClient.invoke(URL_WS+'Cgg_tct_grupo_turista', 'selectInformation', param, true, CallBackInfoGrupo);
        }
    }

    /*
     *Funcion encargada de listar las regals de validacion asociadas con un formulario
     *
     * */

    function listarReglasValidacion(inCopvl_formulario){
        function CallBackReglasTipoSolicitud(r){
            try{
                tmpObjReglasValidacion  = r;
            }catch(inErr){
                tmpObjReglasValidacion =[];
            }

        }
        var param = new SOAPClientParameters();
        param.add('inCopvl_formulario',inCopvl_formulario);
        param.add('format',TypeFormat.JSON);
        SOAPClient.invoke(URL_WS+'Cgg_regla_validacion' ,'selectOperacionValidacionByForm',param, true,CallBackReglasTipoSolicitud);
    }

    /*
     * Funcion encargada de obtener los valores definidos en cada una de las reglas de validacion
     * */

    function evaluarReglasValidacion(objReglasValidacion1){
        for(var i=0;i<objReglasValidacion1.length;i++){
            var objTmp = Ext.decode(objReglasValidacion1[i].CRTSE_CAMPO_EVALUACION)[0]; //[0].INPARAMETRO1);
            for (var key in objTmp) {
                objTmp[key] = eval(objTmp[key]);
            }
            objReglasValidacion1[i].CRTSE_CAMPO_EVALUACION ='['+Ext.encode(objTmp)+']';
        }
        return(Ext.encode(objReglasValidacion1));
    }

    /*
     * Funcion definida para invocar el proceso de validacion
     *
     * */
    function validarReglas()
    {
        try{
            function CallBackCgg_regla_validacion(r){
                try{
                    var validacion = Ext.util.JSON.decode(r);
                    grdCgg_res_persona.getEl().unmask();
                    if(validacion.resultadoValidacion != undefined){
                        if(validacion.resultadoValidacion == 'false'){
                            function eliminarRegistro(tmp){
                                tmpFailCheck = true;
                                reTctRegistro.stopEditing();
                                gsCgg_res_persona.removeAt(0);
                                grdCgg_res_persona.getView().refresh();
                                tmpFailCheck = false;
                            }
                            var tmpMsg='';
                            for(i = 0 ; i < validacion.dataSet.length; i++){
                                if(validacion.dataSet[i].CRVAL_APROBADO != 'TRUE' && validacion.dataSet[i].CRVAL_APROBADO != 'true')
                                    tmpMsg +='<b>'+(i+1)+'</b>. '+validacion.dataSet[i].CRVAL_SUGERENCIA+'<br>';
                            }
                            Ext.Msg.show({
                                title:'Error validaci\u00f3n',
                                msg:'No se puede realizar el registro de la persona.!!<br><br>A continuaci\u00f3n el detalle de sus novedades:<br>'+tmpMsg,
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR,
                                fn: eliminarRegistro
                            });
                        }else{
                            if(!tmpUserSesion.getUserData().CUSU_USUARIO_INTERNO)
                                gsCgg_res_persona.getAt(0).data.CKESP_CODIGO = SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','CONF35')).get('CGCNF_VALOR_CADENA');
                        }
                    }
                }
                catch (inErr) {
                    grdCgg_res_persona.getEl().unmask();
                    Ext.Msg.show({
                        title: tituloCgg_tct_registro,
                        msg: 'No se podido validar la informaci\u00f3n a almacenar.<br>Error:' + inErr + '.<br>' + ERR_MESSAGE,
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.ERROR

                    });
                    return false;
                }

            }
            grdCgg_res_persona.getEl().mask('Validando...', 'x-mask-loading');
            objReglasValidacion  = Ext.decode(tmpObjReglasValidacion);
            var param = new SOAPClientParameters();
            param.add('inJSON_reglas_validacion',evaluarReglasValidacion(objReglasValidacion));
            param.add('jsonData',null);
            SOAPClient.invoke(URL_WS+'Cgg_regla_validacion' ,'ejecutarReglaTipoSolicitud',param, true, CallBackCgg_regla_validacion);
        }catch(inErr){
            Ext.MsgPopup.msg(tituloCgg_tct_registro, "No se ha podido validar la informaci\u00f3n a almacenar.\nError:"+inErr);
            grdCgg_res_persona.getEl().unmask();
            return false;
        }

    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_tct_registro.
     * @returns ventana winFrmCgg_tct_registro.
     * @base FrmCgg_tct_registro.prototype.show
     */
    this.getWindow = function() {
        return winFrmCgg_tct_registro;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_tct_registro.
     * @base FrmCgg_tct_registro.prototype.loadData
     */
    this.loadData = function() {
        cargarCgg_tct_registroCtrls();
    }
    /**
     * Funcion miembro que develve el tipo de documento.
     */
    this.setTipoDocumento = function(inTipoDocumento) {
        regTipoDocumento = inTipoDocumento;
        cbxCrdid_codigo.store = regTipoDocumento;
    }
    /**
     * Funcion miembro que develve el tipo de documento.
     */
    this.setNacionalidad = function(inNacionalidad) {
        regNacionalidad = inNacionalidad;
        regNacionalidad.sort('CGNCN_NACIONALIDAD', 'ASC');
        cbxCgncn_codigo.store = regNacionalidad;
    }
    /**
     * Funcion miembro que develve el tipo de documento.
     */
    /* this.setResidencia = function(inResidencia) {
     regResidencia = inResidencia;
     cbxCgg_cpais_codigo.store = regResidencia;
     }*/
    /**
     * Funcion miembro que develve el tipo de documento.
     */
    this.setEspecie_Kardex = function(inEspecie_Kardex) {
        regEspecie_Kardex = inEspecie_Kardex;
        cbxCkesp_codigo.store = regEspecie_Kardex;
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
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_tct_registro desde una instancia.
 */
FrmCgg_tct_registro.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_tct_registro desde una instancia.
 */
FrmCgg_tct_registro.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_tct_registro,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_tct_registro.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_tct_registro desde una instancia.
 */
FrmCgg_tct_registro.prototype.loadData = function(){
    this.loadData();
}
/**
 * Funcion prototipo. Permite cargar el store de TipoDocumento
 */
FrmCgg_tct_registro.prototype.setTipoDocumento = function(inTipoDocumento){
    this.setTipoDocumento(inTipoDocumento);
}
/**
 * Funcion prototipo. Permite cargar el store de Nacionaliad
 */
FrmCgg_tct_registro.prototype.setNacionalidad = function(inNacionalidad){
    this.setNacionalidad(inNacionalidad);
}
/**
 * Funcion prototipo. Permite cargar el store de Nacionaliad
 */
FrmCgg_tct_registro.prototype.setEspecie_Kardex = function(inEspecie_Kardex){
    this.setEspecie_Kardex(inEspecie_Kardex);
}

FrmCgg_tct_registro.prototype.setStoreHospedaje = function(inStoreHospedaje){
    this.setStoreHospedaje(inStoreHospedaje);
}

FrmCgg_tct_registro.prototype.setStoreActividad = function(inStoreActividad){
    this.setStoreActividad(inStoreActividad);
}
