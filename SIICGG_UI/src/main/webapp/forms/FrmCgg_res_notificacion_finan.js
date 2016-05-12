/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_persona.
 * @param {String} INSENTENCIA_CGG_RES_PERSONA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_PERSONA Registro de datos de la tabla Cgg_res_persona.
 * @constructor
 * @base FrmListadoCgg_res_persona
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_notificacion_finan(INSENTENCIA_CGG_RES_PERSONA,INRECORD_CGG_RES_PERSONA){
    var inSentenciaCgg_res_persona = INSENTENCIA_CGG_RES_PERSONA;
    var inRecordCgg_res_persona=INRECORD_CGG_RES_PERSONA;
    var urlCgg_res_persona=URL_WS+"Cgg_res_persona";
    var tituloCgg_res_persona='Persona';
    var descCgg_res_persona='El formulario permite administrar informaci\u00f3n de Persona';
    var isEdit = false;
    var flagImage = false; //Variable utilizada para determinar si la persona tiene ingresada su fotografia en el sistema
    var tmpEstado = false; //Variable utilizada para determinar si ya se esta visualizando la ventana
    var tmpUserSession = new UserSession();
    var tmpCrper_adjunto_acta = null; //Variable utilizada para almacenar el codigo del archivo adjunto de acta defuncion
    var tmpPluginPersona; //Variable utilizada para referenciar informacion capturada desde el plugin
    var tmpFirAuditText; //Variable de control biometrico
    var tmpFirText; //Variable de control biometrico
    var tmpFirma; //Variable temporal de firma
    var tmpHuellaImagen;
    var stCctn_nacimiento = new Cgg_canton().getStore();
    var stCctn_residencia =  new Cgg_canton().getStore();
    var stCctn_residencia_anterior = new Cgg_canton().getStore();
    var stCrprv_nacimiento =  new Cgg_provincia().getStore();
    var stCrprv_residencia =  new Cgg_provincia().getStore();
    var stCrprv_residencia_anterior =  new Cgg_provincia().getStore();
    var stCpais_nacimiento =  new Cgg_pais().getStore();
    var stCpais_residencia =  new Cgg_pais().getStore();
    var stCpais_residencia_anterior =  new Cgg_pais().getStore();

    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
     */
    var txtCrper_codigo = new Ext.form.TextField({
        id:'txtCrper_codigo',
        name:'txtCrper_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true

    });

    /**
     * Ext.data.Store Seleccion de registros de la tabla Cgg_res_estado_civil
     */
    var gsCgg_res_estado_civil = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_estado_civil",
            method:"selectAll",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
        },[
            {
                name:'CRECV_CODIGO'
            },

            {
                name:'CRECV_DESCRPCION'
            }
        ]),
        baseParams:{
            format:TypeFormat.JSON
        },
        listeners:{
            load:function(){
                if(INRECORD_CGG_RES_PERSONA){
                    try{
                        //if(inRecordCgg_res_persona.get('CRECV_CODIGO') != undefined)
                        cbxCrecv_codigo.setValue(inRecordCgg_res_persona.get('CRECV_CODIGO'));
                    }
                    catch(inErr){
                    }
                }
                gsCgg_res_estado_civil.sort('CRECV_DESCRPCION','ASC');
            }
        }
    });


    /**
     * Ext.data.Store Seleccion de registros de la tabla Cgg_res_estado_civil
     */
    var gsCgg_res_persona = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_persona",
            method:"select",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
        },[
            {
                name:'CRPER_CODIGO'
            },

            {
                name:'CRECV_CODIGO'
            },

            {
                name:'CRDID_CODIGO'
            },

            {
                name:'CRTSG_CODIGO'
            },

            {
                name:'CGNCN_CODIGO'
            },

            {
                name:'CPRR_CODIGO'
            },

            {
                name:'CCTN_CODIGO'
            },

            {
                name:'CGG_CCTN_CODIGO'
            },

            {
                name:'CPAIS_CODIGO'
            },

            {
                name:'CGG_CPAIS_CODIGO'
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
                name:'CRPER_OBSERVACIONES'
            },

            {
                name:'CRPER_NUMERO_RESIDENCIA'
            },

            {
                name:'CRPER_FOTO'
            },

            {
                name:'CRPER_FOTO_CURRICULUM'
            },

            {
                name:'CRPER_HUELLA_DACTILAR'
            },

            {
                name:'CRPER_FIRMA'
            },

            {
                name:'CRPER_AUTORIZADO'
            },

            {
                name:'CRPER_NUMERO_EXPEDIENTE'
            },

            {
                name:'CRPER_FECHA_ARCHIVO'
            },

            {
                name:'CRPER_EMPLEADO'
            },

            {
                name:'CRPER_FECHA_ULTIMO_EMPLEO'
            },

            {
                name:'CRPER_ASPIRACION_SALARIAL'
            },

            {
                name:'CRPER_CUPO_VEHICULAR'
            },

            {
                name:'CRPER_TIPO_PERSONA'
            },

            {
                name:'CRPER_ESTADO_INTERFECTO'
            },

            {
                name:'CRPER_FECHA_DEFUNCION'
            },

            {
                name:'CRPER_NUMERO_ACTA'
            },

            {
                name:'CRPER_TIPO'
            },

            {
                name:'CRPER_ATENCION_CLIENTE'
            }
        ]),
        baseParams:{
            inCrper_codigo:'',
            format:TypeFormat.JSON
        },
        listeners:{
            // winFrmCgg_res_notificacion_finan.getEl().mask('Cargando...', 'x-mask-loading');
            load:function(record)
            {
                if(record.getCount()>0)
                {
                    inRecordCgg_res_persona = record.getAt(0);
                    cargarCgg_res_personaCtrls();
                    cbxCrecv_codigo.setValue(inRecordCgg_res_persona.get('CRECV_CODIGO'));
                    cbxCrdid_codigo.setValue(inRecordCgg_res_persona.get('CRDID_CODIGO'));
                    cbxCrtsg_codigo.setValue(inRecordCgg_res_persona.get('CRTSG_CODIGO'));
                    cbxCgncn_codigo.setValue(inRecordCgg_res_persona.get('CGNCN_CODIGO'));
                    winFrmCgg_res_notificacion_finan.getEl().unmask();
                }
            }
        }
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DEL ESTADO CIVIL
     */
    var cbxCrecv_codigo = new Ext.form.ComboBox({
        id:'cbxCrecv_codigo',
        name:'cbxCrecv_codigo',
        fieldLabel :'Estado civil',
        anchor:'98%',
        store: gsCgg_res_estado_civil,
        displayField:'CRECV_DESCRPCION',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        editable:false,
        triggerAction:'all',
        emptyText:'Seleccione un estado civil',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CRECV_DESCRPCION}. {CRECV_DESCRPCION}" class="x-combo-list-item">{CRECV_DESCRPCION}</div></tpl>',
        valueField:'CRECV_CODIGO'
    });

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_documento_identificacio por un campo especifico.
     */
    var gsCgg_res_documento_identificacio = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_documento_identificacio",
            method:"selectAll",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
        },[
            {
                name:'CRDID_CODIGO'
            },

            {
                name:'CRDID_DESCRIPCION'
            }
        ]),
        baseParams:{
            format:TypeFormat.JSON
        },
        listeners:{
            load:function(){
                if(INRECORD_CGG_RES_PERSONA){
                    try
                    {
                        //if(inRecordCgg_res_persona.get('CRDID_CODIGO') != undefined)
                        cbxCrdid_codigo.setValue(inRecordCgg_res_persona.get('CRDID_CODIGO'));
                    }
                    catch(inErr)
                    {

                    }
                }
            }
        }
    });

    var cbxCrdid_codigo = new Ext.form.ComboBox({
        id:'cbxCrdid_codigo',
        name:'cbxCrdid_codigo',
        fieldLabel :'Tipo documento',
        anchor:'50%',
        store: gsCgg_res_documento_identificacio,
        displayField:'CRDID_DESCRIPCION',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione un tipo documento identidad',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CRDID_DESCRIPCION}. {CRDID_DESCRIPCION}" class="x-combo-list-item">{CRDID_DESCRIPCION}</div></tpl>',
        valueField:'CRDID_CODIGO'
    });

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_tipo_sanguineo por un campo especifico.
     */
    var gsCgg_res_tipo_sanguineo = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_tipo_sanguineo",
            method:"selectAll",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
        },[
            {
                name:'CRTSG_CODIGO'
            },

            {
                name:'CRTSG_DESCRPCION'
            }
        ]),
        baseParams:{
            format:TypeFormat.JSON
        },
        listeners:{
            load:function(){
                if(INRECORD_CGG_RES_PERSONA){
                    try{
                        cbxCrtsg_codigo.setValue(inRecordCgg_res_persona.get('CRTSG_CODIGO'));
                    }catch(inErr){
                    }
                }
                gsCgg_res_tipo_sanguineo.sort('CRTSG_DESCRPCION','ASC');
            }
        }
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TIPO SANQUINEO
     */
    var cbxCrtsg_codigo = new Ext.form.ComboBox({
        id:'cbxCrtsg_codigo',
        name:'cbxCrtsg_codigo',
        fieldLabel :'Tipo sanguineo',
        anchor:'98%',
        store: gsCgg_res_tipo_sanguineo,
        displayField:'CRTSG_DESCRPCION',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        editable:false,
        triggerAction:'all',
        emptyText:'Seleccione un tipo sanguineo',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CRTSG_DESCRPCION}. {CRTSG_DESCRPCION}" class="x-combo-list-item">{CRTSG_DESCRPCION}</div></tpl>',
        valueField:'CRTSG_CODIGO'
    });

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_nacionalidad por un campo especifico.
     */
    var gsCgg_nacionalidad = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_nacionalidad",
            method:"selectAll",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
        },[
            {
                name:'CGNCN_CODIGO'
            },

            {
                name:'CGNCN_NACIONALIDAD'
            }
        ]),
        baseParams:{
            format:TypeFormat.JSON
        },
        listeners:{
            load:function(){
                if(INRECORD_CGG_RES_PERSONA){
                    try{
                        cbxCgncn_codigo.setValue(inRecordCgg_res_persona.get('CGNCN_CODIGO'));
                    }catch(inErr){
                    }
                }
                gsCgg_nacionalidad.sort('CGNCN_NACIONALIDAD', 'ASC');
            }
        }
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE NACIONALIDAD
     */
    var cbxCgncn_codigo = new Ext.form.ComboBox({
        id:'cbxCgncn_codigo',
        name:'cbxCgncn_codigo',
        fieldLabel :'Nacionalidad',
        anchor:'98%',
        store: gsCgg_nacionalidad,
        displayField:'CGNCN_NACIONALIDAD',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione una Nacionalidad',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CGNCN_NACIONALIDAD}" class="x-combo-list-item">{CGNCN_NACIONALIDAD}</div></tpl>',
        valueField:'CGNCN_CODIGO'
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PARROQUIA
     */
    var cbxCprr_codigo = new Ext.form.ComboBox({
        id:'cbxCprr_codigo',
        name:'cbxCprr_codigo',
        fieldLabel :'Parroquia',
        anchor:'98%',
        store: SCGG_RES_PARROQUIA,
        displayField:'CPRR_NOMBRE',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione una Parroquia',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CPRR_NOMBRE}. {CPRR_NOMBRE}" class="x-combo-list-item">{CPRR_NOMBRE}</div></tpl>',
        valueField:'CPRR_CODIGO',
        lastQuery: ''
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CIUDAD/CANTON DE NACIMIENTO
     */
    var cbxCctn_nombre_nacimiento = new Ext.form.ComboBox({
        id:'cbxCctn_nombre_nacimiento',
        name:'cbxCctn_nombre_nacimiento',
        fieldLabel :'Ciudad',
        anchor:'98%',
        store: stCctn_nacimiento,
        displayField:'CCTN_NOMBRE',
        typeAhead: false,
        lastQuery:'',
        clearFilterOnReset:false,
        mode: 'local',
        forceSelection:false,
        triggerAction:'all',
        emptyText:'Seleccione una Ciudad',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CCTN_NOMBRE}. {CCTN_NOMBRE}" class="x-combo-list-item">{CCTN_NOMBRE}</div></tpl>',
        valueField:'CCTN_CODIGO',
        lastQuery: ''
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PROVINCIA DE NACIMIENTO
     */
    var cbxCgprv_nombre_nacimiento = new Ext.form.ComboBox({
        id:'cbxCgprv_nombre_nacimiento',
        name:'cbxCgprv_nombre_nacimiento',
        fieldLabel :'Provincia',
        anchor:'98%',
        store: stCrprv_nacimiento,
        displayField:'CGPRV_NOMBRE',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione una Provincia',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CGPRV_NOMBRE}. {CGPRV_NOMBRE}" class="x-combo-list-item">{CGPRV_NOMBRE}</div></tpl>',
        valueField:'CGPRV_CODIGO',
        lastQuery: '',
        listeners:{
            select:function(combo, value) {
                var rCanton=stCrprv_nacimiento.getAt(stCrprv_nacimiento.findExact('CGPRV_CODIGO',combo.getValue())).json;
                cbxCctn_nombre_nacimiento.clearValue();
                stCctn_nacimiento.removeAll();
                stCctn_nacimiento.loadData(rCanton.CANTONES,true);

            }
        }
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CANTON DE NACIMIENTO
     */
    var cbxCpais_nombre_nacimiento = new Ext.form.ComboBox({
        id:'cbxCpais_nombre_nacimiento',
        name:'cbxCpais_nombre_nacimiento',
        fieldLabel :'Pais',
        anchor:'98%',
        store: stCpais_nacimiento,
        displayField:'CPAIS_NOMBRE',
        typeAhead: true,
        mode:'local',
        autoSelect:true,
        editable:true,
        selectOnFocus:true,
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione un Pa\u00efs',
        valueField:'CPAIS_CODIGO',
        lastQuery: '',
        listeners:{
            select:function(combo, value) {
                var rProvincia=SCGG_PAIS.getAt(SCGG_PAIS.findExact('CPAIS_CODIGO',combo.getValue())).json;
                cbxCgprv_nombre_nacimiento.clearValue();
                cbxCctn_nombre_nacimiento.clearValue();
                stCrprv_nacimiento.removeAll();
                stCctn_nacimiento.removeAll();
                stCrprv_nacimiento.loadData(rProvincia.PROVINCIAS,true);
            }
        }

    });

    ////
    ///
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CIUDAD/CANTON DE RESIDENCIA EN LA PROVINCIA DE GALAPAGOS
     */
    var cbxCctn_nombre_residencia = new Ext.form.ComboBox({
        id:'cbxCctn_nombre_residencia',
        name:'cbxCctn_nombre_residencia',
        fieldLabel :'Ciudad',
        anchor:'98%',
        store: stCctn_residencia,
        displayField:'CCTN_NOMBRE',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione una Ciudad',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CCTN_NOMBRE}. {CCTN_NOMBRE}" class="x-combo-list-item">{CCTN_NOMBRE}</div></tpl>',
        valueField:'CCTN_CODIGO',
        lastQuery: '',
        listeners:{
            select:function(combo, value) {
                cbxCprr_codigo.clearValue();
                cbxCprr_codigo.getStore().filter('CCTN_CODIGO', combo.getValue());
            }
        }
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PROVINCIA DE RESIDENCIA
     */
    var cbxCgprv_nombre_residencia = new Ext.form.ComboBox({
        id:'cbxCgprv_nombre_residencia',
        name:'cbxCgprv_nombre_residencia',
        fieldLabel :'Provincia',
        anchor:'98%',
        store: stCrprv_residencia,
        displayField:'CGPRV_NOMBRE',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione una Provincia',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CGPRV_NOMBRE}. {CGPRV_NOMBRE}" class="x-combo-list-item">{CGPRV_NOMBRE}</div></tpl>',
        valueField:'CGPRV_CODIGO',
        lastQuery: '',
        listeners:{
            select:function(combo, value) {
                var rCantonResidencia=stCrprv_residencia.getAt(stCrprv_residencia.findExact('CGPRV_CODIGO',combo.getValue())).json;
                cbxCctn_nombre_residencia.clearValue();
                stCctn_residencia.removeAll();
                stCctn_residencia.loadData(rCantonResidencia.CANTONES,true);


            }
        }
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PAIS DE RESIDENCIA
     */
    var cbxCpais_nombre_residencia = new Ext.form.ComboBox({
        id:'cbxCpais_nombre_residencia',
        name:'cbxCpais_nombre_residencia',
        fieldLabel :'Pais',
        anchor:'98%',
        store: stCpais_residencia,
        displayField:'CPAIS_NOMBRE',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione un Pa\u00efs',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CPAIS_NOMBRE}. {CPAIS_NOMBRE}" class="x-combo-list-item">{CPAIS_NOMBRE}</div></tpl>',
        valueField:'CPAIS_CODIGO',
        lastQuery: '',
        listeners:{
            select:function(combo, value) {
                var rProvinciaResidencia=SCGG_PAIS.getAt(SCGG_PAIS.findExact('CPAIS_CODIGO',combo.getValue())).json;
                cbxCgprv_nombre_residencia.clearValue();
                cbxCctn_nombre_residencia.clearValue();
                stCrprv_residencia.removeAll();
                stCctn_residencia.removeAll();
                stCrprv_residencia.loadData(rProvinciaResidencia.PROVINCIAS,true);

            }
        }
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CIUDAD/CANTON DE DOMICILIO ANTERIOR
     */
    var cbxCctn_nombre_res_anterior = new Ext.form.ComboBox({
        id:'cbxCctn_nombre_res_anterior',
        name:'cbxCctn_nombre_res_anterior',
        fieldLabel :'Ciudad',
        anchor:'98%',
        store: stCctn_residencia_anterior,
        displayField:'CCTN_NOMBRE',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione una Ciudad',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CCTN_NOMBRE}. {CCTN_NOMBRE}" class="x-combo-list-item">{CCTN_NOMBRE}</div></tpl>',
        valueField:'CCTN_CODIGO',
        lastQuery: ''
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CIUDAD/CANTON DE DOMICILIO ANTERIOR
     */
    var cbxCgprv_nombre_res_anterior = new Ext.form.ComboBox({
        id:'cbxCgprv_nombre_res_anterior',
        name:'cbxCgprv_nombre_res_anterior',
        fieldLabel :'Provincia',
        anchor:'98%',
        store: stCrprv_residencia_anterior,
        displayField:'CGPRV_NOMBRE',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione una Provincia',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CGPRV_NOMBRE}. {CGPRV_NOMBRE}" class="x-combo-list-item">{CGPRV_NOMBRE}</div></tpl>',
        valueField:'CGPRV_CODIGO',
        lastQuery: '',
        listeners:{
            select:function(combo, value) {
                var rCantonAnterior=stCrprv_residencia_anterior.getAt(stCrprv_residencia_anterior.findExact('CGPRV_CODIGO',combo.getValue())).json;
                cbxCctn_nombre_res_anterior.clearValue();
                stCctn_residencia_anterior.removeAll();
                stCctn_residencia_anterior.loadData(rCantonAnterior.CANTONES,true);
            }
        }
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PAIS DE RESIDENCIA
     */
    var cbxCpais_nombre_res_anterior = new Ext.form.ComboBox({
        id:'cbxCpais_nombre_res_anterior',
        name:'cbxCpais_nombre_res_anterior',
        fieldLabel :'Pais',
        anchor:'98%',
        store: stCpais_residencia_anterior,
        displayField:'CPAIS_NOMBRE',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione un Pa\u00efs',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CPAIS_NOMBRE}. {CPAIS_NOMBRE}" class="x-combo-list-item">{CPAIS_NOMBRE}</div></tpl>',
        valueField:'CPAIS_CODIGO',
        lastQuery: '',
        listeners:{
            select:function(combo, value) {
                var rProvinciaAnterior=SCGG_PAIS.getAt(SCGG_PAIS.findExact('CPAIS_CODIGO',combo.getValue())).json;
                cbxCgprv_nombre_res_anterior.clearValue();
                cbxCctn_nombre_res_anterior.clearValue();
                stCrprv_residencia_anterior.removeAll();
                stCctn_residencia_anterior.removeAll();
                stCrprv_residencia_anterior.loadData(rProvinciaAnterior.PROVINCIAS,true);

            }
        }
    });


    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
     */
    var txtCctn_codigo = new Ext.form.TextField({
        id:'txtCctn_codigo',
        name:'txtCctn_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true'

    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
     */
    var btnCctn_codigoCgg_res_persona = new Ext.Button({
        id:'btnCctn_codigoCgg_res_persona',
        text:'Cctn_codigo',
        iconCls:'iconCctn_codigo',
        listeners:{
            click:function(){
                var tmpFLCgg_canton = new FrmListadoCgg_canton();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_canton.getStore(),tmpFLCgg_canton.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                        txtCctn_codigo.setValue(tmpRecord.get('CCTN_CODIGO'));
                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Ext.form.TextField CIUDAD DE ORIGEN EN EL ECUADOR CONTINENTAL DE UN RESIDENTE
     */
    var txtCgg_cctn_codigo = new Ext.form.TextField({
        id:'txtCgg_cctn_codigo',
        name:'txtCgg_cctn_codigo',
        fieldLabel :'Cctn codigo',
        anchor:'98%',
        readOnly:'true'
    });
    /**
     * CIUDAD DE ORIGEN EN EL ECUADOR CONTINENTAL DE UN RESIDENTE
     */
    var btnCgg_cctn_codigoCgg_res_persona = new Ext.Button({
        id:'btnCgg_cctn_codigoCgg_res_persona',
        text:'Cgg_cctn_codigo',
        iconCls:'iconCgg_cctn_codigo',
        listeners:{
            click:function(){
                var tmpFLCgg_canton = new FrmListadoCgg_canton();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_canton.getStore(),tmpFLCgg_canton.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                        txtCgg_cctn_codigo.setValue(tmpRecord.get('CCTN_CODIGO'));
                });
                objBusqueda.show();
            }
        }
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
        fieldLabel :'Apellido paterno',
        anchor:'98%',
        allowBlank :false,
        invalidText : 'Es necesario ingresar el apellido  de la persona '
    });
    /**
     * Ext.form.TextField APELLIDO MATERNO
     */
    var txtCrper_apellido_materno = new Ext.form.TextField({
        id:'txtCrper_apellido_materno',
        name:'txtCrper_apellido_materno',
        fieldLabel :'Apellido materno',
        anchor:'98%',
        allowBlank : true
    });
    /**
     * Ext.form.TextField NUMERO DE DOCUEMNTO DE IDENTIFICACION
     */
    var txtCrper_num_doc_identific = new Ext.form.TextField({
        id:'txtCrper_num_doc_identific',
        name:'txtCrper_num_doc_identific',
        fieldLabel :'No. identific.',
        anchor:'98%',
        allowBlank :false,
        invalidText : 'Es necesario definir un numero de identificaci\u00f3n '
    });
    /**
     * Ext.form.DateField FECHA DE NACIMIENTO
     */
    var dtCrper_fecha_nacimiento = new Ext.form.DateField({
        id:'dtCrper_fecha_nacimiento',
        name:'dtCrper_fecha_nacimiento',
        fieldLabel :'Fecha nacimiento',
        format :'d/m/Y',
        value:new Date(),
        allowBlank :false,
        maxValue:new Date()
    });
    /**
     * Ext.form.TextField LUGAR DE NACIMIENTO
     */
    var txtCrper_lugar_nacimiento = new Ext.form.TextField({
        id:'txtCrper_lugar_nacimiento',
        name:'txtCrper_lugar_nacimiento',
        fieldLabel :'Lugar nacimiento',
        anchor:'98%'
        //allowBlank :false
    });
    /**
     * Ext.form.NumberField GENERO DE LA PERSONA
     0 - MASCULINO
     1 - FEMENINO
     */
    var rdgCCrper_genero = new Ext.form.RadioGroup({
        fieldLabel: 'Genero',
        anchor:'98%',
        //columns: 2, //display the radiobuttons in two columns
        items: [
            {
                boxLabel: 'Masculino',
                name: 'rdgCCrper_genero',
                inputValue: TypeGenero.MASCULINO,
                checked: true
            },

            {
                boxLabel: 'Femenino',
                name: 'rdgCCrper_genero',
                inputValue: TypeGenero.FEMENINO
            }
        ],
        listeners:{
            change: function(group,radio)
            {
                if(!flagImage)
                {
                    if(radio.getRawValue() == TypeGenero.FEMENINO)
                    {
                        objImageDefault.AVATAR = 'resources/images/female_avatar.jpg';
                    }
                    else
                    {
                        objImageDefault.AVATAR = 'resources/images/male_avatar.jpeg';

                    }
                    if (tmpEstado)
                        tplImagePersona.overwrite(pnlImage.body,objImageDefault);
                }
            }
        }
    });
    var numCrper_genero = new Ext.form.NumberField({
        id:'numCrper_genero',
        name:'numCrper_genero',
        fieldLabel :'Genero',
        allowBlank :false,
        disabled :false
    });


    /**
     * Ext.form.TextField OBSERVACIONES O COMENTARIOS PARA CON LA PERSONA

     */
    var txtCrper_observaciones = new Ext.form.TextArea({
        id:'txtCrper_observaciones',
        name:'txtCrper_observaciones',
        hideLabel:true,
        height:80,
        anchor:'98% 100%',
        allowBlank :true
    });
    /**
     * Ext.form.TextField NUMERO UNICO DE IDENTIFICACION DE RESIDENCIA
     */
    var txtCrper_numero_residencia = new Ext.form.TextField({
        id:'txtCrper_numero_residencia',
        name:'txtCrper_numero_residencia',
        fieldLabel :'No. residencia',
        anchor:'98%',
        allowBlank : true,
        readOnly:true
    });
    /**
     * Ext.form.Checkbox ESTADO DEL REGISTRO QUE DEFINE SI UNA PERSONA TIENE AUTORIZADO SU INGRESO A LA PROVINCIA
     */

    var chkCrper_autorizado = new Ext.form.Checkbox({
        id:'chkCrper_autorizado',
        name:'chkCrper_autorizado',
        fieldLabel :'Autorizado',
        allowBlank :false,
        checked:false,
        disabled : true,
        listeners:{
            check: function (obj,value)
            {
                if(value)
                {
                    objImageDefault.AUTORIZADO ='resources/images/32x32/success.png';

                }
                else
                {
                    objImageDefault.AUTORIZADO ='resources/images/32x32/fail.png';

                }
                if (tmpEstado)
                    tplImagePersona.overwrite(pnlImage.body,objImageDefault);

            }
        }
    });
    /**
     * Ext.form.TextField NUMERO DE EXPEDIENTE UNICO
     */
    var txtCrper_numero_expediente = new Ext.form.TextField({
        id:'txtCrper_numero_expediente',
        name:'txtCrper_numero_expediente',
        fieldLabel :'No. expediente',
        anchor:'98%',
        allowBlank :true
    });
    /**
     * Ext.form.DateField FECHA DE ARCHIVO DE LA DOCUMENTACION DE LA PERSONA
     */
    var dtCrper_fecha_archivo = new Ext.form.DateField({
        id:'dtCrper_fecha_archivo',
        name:'dtCrper_fecha_archivo',
        fieldLabel : 'Fecha archivo',
        allowBlank : true,
        format :'d/m/Y',
        value : new Date()
    });
    /**
     * Ext.form.Checkbox ESTADO LABORAL DE LA PERSONA
     */
    var chkCrper_empleado = new Ext.form.Checkbox({
        id:'chkCrper_empleado',
        name:'chkCrper_empleado',
        fieldLabel :'Empleado',
        allowBlank : true
        //checked:true
    });
    /**
     * Ext.form.DateField FECHA DE INICIO DEL ULTIMO EMPLEO
     */
    var dtCrper_fecha_ultimo_empleo = new Ext.form.DateField({
        id:'dtCrper_fecha_ultimo_empleo',
        name:'dtCrper_fecha_ultimo_empleo',
        fieldLabel :'Fecha \u00falt. empleo',
        allowBlank : true,
        format :'d/m/Y',
        value:new Date(),
        maxValue: new Date()
    });
    /**
     * Ext.form.NumberField SALARIO ESPERADO POR CUMPLIR CON UN DETERMINADO TRABAJO
     */
    var numCrper_aspiracion_salarial = new Ext.form.NumberField({
        id:'numCrper_aspiracion_salarial',
        name:'numCrper_aspiracion_salarial',
        fieldLabel :'Aspiracion salarial',
        allowBlank : true,
        disabled :false
    });/**
     * Ext.form.Checkbox SI TIENE DISPONIBLE UN CUPO VEHICULAR
     */
    var chkCrper_cupo_vehicular = new Ext.form.Checkbox({
            id:'chkCrper_cupo_vehicular',
            name:'chkCrper_cupo_vehicular',
            fieldLabel : 'Cupo vehicular',
            allowBlank : true,
            disabled : true
            //checked:true
        });
    /**
     * Ext.form.Checkbox CAMPO QUE VERIFICA EL ESTADO INTERFECTO DE LA PERSONA

     */
    var chkTipoPersona = new Ext.form.Checkbox({
        id:'chkTipoPersona',
        name:'chkTipoPersona',
        fieldLabel :'Discapacidad',
        allowBlank : true,
        checked:false,
        listeners:{
            check:function(obj,value)
            {
                if(value)
                {
                    numCrper_tipo_persona.enable();
                }
                else
                {
                    numCrper_tipo_persona.disable();
                }

            }
        }
    });
    /**
     * Ext.form.NumberField CAMPO QUE IDENTIPFICA EL TIPO DE PERSONA
     0 - CAPACIDADES ESPECIALES
     1 - DISCAPACIDAD FISICA
     2 - NORMAL
     */
    var numCrper_tipo_persona = new Ext.form.NumberField({
        id:'numCrper_tipo_persona',
        name:'numCrper_tipo_persona',
        fieldLabel :'Tipo persona',
        allowBlank : true,
        disabled : true
    });
    /**
     *Ext.form.ComboBox Combo para edicion de tipo de contacto.
     */
    var cbxCrper_tipo_persona = new Ext.form.ComboBox({
        id:'cbxCrper_tipo_persona',
        store: dsTipoPersonaDiscapacidad,
        fieldLabel :'Discapacidad',
        typeAhead: true,
        mode:'local',
        forceSelection:true,
        triggerAction:'all',
        value:TypePersonaDiscapacidad.NINGUNA,
        //emptyText:'Seleccione un tipo',
        selectOnFocus:true
        //tpl: '<tpl for="."><div ext:qtip="{Descripcion}" class="x-combo-list-item">{Descripcion}</div></tpl>',
        //valueField:'id'
    });

    /**
     * Ext.form.Checkbox CAMPO QUE VERIFICA EL ESTADO INTERFECTO DE LA PERSONA

     */
    var chkCrper_estado_interfecto = new Ext.form.Checkbox({
        id:'chkCrper_estado_interfecto',
        name:'chkCrper_estado_interfecto',
        fieldLabel :'Estado interfecto',
        allowBlank : true,
        checked:false
    });
    /**
     * Ext.form.DateField FECHA DE DEFUNCION
     */
    var dtCrper_fecha_defuncion = new Ext.form.DateField({
        id:'dtCrper_fecha_defuncion',
        name:'dtCrper_fecha_defuncion',
        fieldLabel :'Fecha defuncion',
        allowBlank : true,
        format :'d/m/Y',
        value:new Date()
    });
    /**
     * Ext.form.TextField NUMERO DE ACTA DE DEFUNCION
     */
    var txtCrper_numero_acta = new Ext.form.TextField({
        id:'txtCrper_numero_acta',
        name:'txtCrper_numero_acta',
        fieldLabel :'Numero acta',
        anchor:'98%',
        allowBlank : true
    });
    /**
     * Ext.form.TextField NOMBRE ARCHIVO DIGITAL ADJUNTO DE ACTA DE DEFUNCION
     */
    var txtCrper_nombre_adjunto_acta = new Ext.form.TextField({
        id:'txtCrper_nombre_adjunto_acta',
        name:'txtCrper_nombre_adjunto_acta',
        fieldLabel :'Adjunto acta',
        anchor:'98%',
        allowBlank : true
    });
    /**
     * Ext.form.NumberField ALMACENA INFORMACION QUE PERMITE DEFINIR SI LA PERSONA ESTA REGISTRADA COMO PARTE DE LA ADMINSITRACION DE RESIDENCIA
     0 - REGULAR
     1 - IRREGULAR
     */
    var numCrper_tipo = new Ext.form.NumberField({
        id:'numCrper_tipo',
        name:'numCrper_tipo',
        fieldLabel :'Tipo',
        allowBlank : true,
        disabled :false
    });/**
     * Ext.form.Checkbox SI LA INFORMACION FUE REGISTRADA DESDE ATENCION AL CLIENTE
     */
    var chkCrper_atencion_cliente = new Ext.form.Checkbox({
            id:'chkCrper_atencion_cliente',
            name:'chkCrper_atencion_cliente',
            fieldLabel :'Atencion cliente',
            allowBlank :false,
            checked : true
        });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_notificacion_finan
     */
    var btnGuardarCgg_res_persona = new Ext.Button({
        id:'btnGuardarCgg_res_persona',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:TypeTooltip.GUARDAR,
        listeners:{
            click:function(){
                if ( valCedula()==false || pnlCgg_res_persona.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_res_persona(r){
                        winFrmCgg_res_notificacion_finan.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_res_persona,
                                msg: 'La informaci\u00f3n de Persona ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            winFrmCgg_res_notificacion_finan.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_res_persona,
                                msg: 'La informaci\u00f3n de Persona no ha podido ser almacenada. '+(r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_res_notificacion_finan.getEl().mask('Guardando...', 'x-mask-loading');
                    var tmpMetodo = null;
                    var fDefuncion = null;
                    var eDefuncion = false;

                    var param = new SOAPClientParameters();
                    if(isEdit)
                    {
                        param.add('inCrper_codigo',txtCrper_codigo.getValue());
                    }
                    else
                    {
                        param.add('inCrper_huella_dactilar', tmpFirText?tmpFirText:null);
                        param.add('inCrper_huella_imagen',tmpHuellaImagen?tmpHuellaImagen:null);
                        param.add('inCrper_huella_cadena',tmpFirAuditText?tmpFirAuditText:null);
                        param.add('inCrper_firma',tmpFirma?tmpFirma:null);
                        param.add('inCrper_adjunto_acta',tmpCrper_adjunto_acta?tmpCrper_adjunto_acta:null);
                        param.add('inCrper_nombre_adjunto_acta',txtCrper_nombre_adjunto_acta.getValue()?txtCrper_nombre_adjunto_acta.getValue():null);
                    }
                    tmpMetodo = inSentenciaCgg_res_persona+'All';


                    if(Ext.getCmp('pnlOpcional') && Ext.getCmp('pnlOpcional').isVisible()){
                        fDefuncion = dtCrper_fecha_defuncion.getValue()?dtCrper_fecha_defuncion.getValue().format('c'):null;
                        eDefuncion = chkCrper_estado_interfecto.getValue()?chkCrper_estado_interfecto.getValue():false
                    }

                    param.add('inCrecv_codigo',cbxCrecv_codigo.getValue()?cbxCrecv_codigo.getValue():null);
                    param.add('inCrdid_codigo',cbxCrdid_codigo.getValue()?cbxCrdid_codigo.getValue():null);
                    param.add('inCrtsg_codigo',cbxCrtsg_codigo.getValue()?cbxCrtsg_codigo.getValue():null);
                    param.add('inCgncn_codigo',cbxCgncn_codigo.getValue()?cbxCgncn_codigo.getValue():null);
                    param.add('inCprr_codigo',cbxCprr_codigo.getValue()?cbxCprr_codigo.getValue():null);
                    param.add('inCctn_codigo',cbxCctn_nombre_residencia.getValue()?cbxCctn_nombre_residencia.getValue():null);
                    param.add('inCgg_cctn_codigo',cbxCctn_nombre_res_anterior.getValue()?cbxCctn_nombre_res_anterior.getValue():null);//Ciudad de origen en el ecuador continental
                    param.add('inCpais_codigo',cbxCpais_nombre_nacimiento.getValue()?cbxCpais_nombre_nacimiento.getValue():null);//Pais de nacimiento
                    param.add('inCgg_cpais_codigo',cbxCpais_nombre_residencia.getValue()?cbxCpais_nombre_residencia.getValue():null);//Pais de residencia
                    param.add('inCrper_nombres',txtCrper_nombres.getValue());
                    param.add('inCrper_apellido_paterno',txtCrper_apellido_paterno.getValue()?txtCrper_apellido_paterno.getValue():null);
                    param.add('inCrper_apellido_materno',txtCrper_apellido_materno.getValue()?txtCrper_apellido_materno.getValue():null);
                    param.add('inCrper_num_doc_identific',txtCrper_num_doc_identific.getValue()?txtCrper_num_doc_identific.getValue():null);
                    param.add('inCrper_fecha_nacimiento',dtCrper_fecha_nacimiento.getValue().format(TypeDateFormat.Custom)?dtCrper_fecha_nacimiento.getValue().format(TypeDateFormat.Custom):null);
                    param.add('inCrper_lugar_nacimiento',cbxCctn_nombre_nacimiento.getValue()?cbxCctn_nombre_nacimiento.getValue():null);
                    param.add('inCrper_genero',rdgCCrper_genero.getValue().getRawValue());
                    param.add('inCrper_observaciones',txtCrper_observaciones.getValue()?txtCrper_observaciones.getValue():'');
                    param.add('inCrper_numero_residencia',txtCrper_numero_residencia.getValue()?txtCrper_numero_residencia.getValue():null);

                    param.add('inCrper_autorizado',chkCrper_autorizado.getValue());
                    param.add('inCrper_numero_expediente',txtCrper_numero_expediente.getValue()?txtCrper_numero_expediente.getValue():null);
                    param.add('inCrper_fecha_archivo',dtCrper_fecha_archivo.getValue()?dtCrper_fecha_archivo.getValue().format('c'):null);
                    param.add('inCrper_empleado',chkCrper_empleado.getValue()?chkCrper_empleado.getValue():false);
                    param.add('inCrper_fecha_ultimo_empleo',dtCrper_fecha_ultimo_empleo.getValue()?dtCrper_fecha_ultimo_empleo.getValue().format('c'):null);
                    param.add('inCrper_aspiracion_salarial',numCrper_aspiracion_salarial.getValue()?numCrper_aspiracion_salarial.getValue():'0');
                    param.add('inCrper_cupo_vehicular',chkCrper_cupo_vehicular.getValue());
                    param.add('inCrper_tipo_persona',cbxCrper_tipo_persona.getValue()?cbxCrper_tipo_persona.getValue():TypePersonaDiscapacidad.NINGUNA);
                    param.add('inCrper_estado_interfecto',eDefuncion);
                    param.add('inCrper_fecha_defuncion',fDefuncion);
                    param.add('inCrper_numero_acta',txtCrper_numero_acta.getValue()?txtCrper_numero_acta.getValue():null);

                    param.add('inCrper_tipo',TypeInPerson.RESIDENCIA);
                    param.add('inCrper_atencion_cliente',chkCrper_atencion_cliente.getValue());
                    param.add('inPersonaContacto_JSON',dtgCgg_res_persona_contacto.getStore().getJsonData());
                    param.add('inPersonaPerfil_JSON',grdCgg_gem_perfil_prof.getStore().getJsonData());
                    param.add('inPersonaOcupacion_JSON',grdCgg_res_ocupacion_laboral.getStore().getJsonData());
                    SOAPClient.invoke(urlCgg_res_persona,tmpMetodo,param, true, CallBackCgg_res_persona);
                }catch(inErr){
                    Ext.Msg.show({
                        title:tituloCgg_res_persona,
                        msg: 'La informaci\u00f3n de Persona ha sido almacenada.<br> Error: '+ inErr ,
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.ERROR
                    });
                    winFrmCgg_res_notificacion_finan.getEl().unmask();
                }
            }
        }
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_notificacion_finan.
     */
    var btnCancelarCgg_res_persona = new Ext.Button({
        id:'btnCancelarCgg_res_persona',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:TypeTooltip.CANCELAR,
        listeners:{
            click:function(){
                pnlCgg_res_persona.getForm().reset();
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_notificacion_finan.
     */
    var btnCerrarCgg_res_persona = new Ext.Button({
        id:'btnCerrarCgg_res_persona',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:TypeTooltip.CERRAR,
        listeners:{
            click:function(){
                winFrmCgg_res_notificacion_finan.close();
            }
        }
    });
    /**
     * Ext.Button Boton para registrar acciones adicionales
     */
    var btnMasAcciones = new Ext.Button({
        id: 'btnMasAcciones',
        name: 'btnMasAcciones',
        text: 'M\u00e1s acciones',
        // iconCls: 'iconImprimir',
        menu: [
            {
                id:'mnRegistroDefuncion',
                text: 'Registrar defunci\u00f3n',
                listeners:{
                    click: function () {
                        /**
                         * Ext.form.Checkbox CAMPO QUE VERIFICA EL ESTADO INTERFECTO DE LA PERSONA

                         */
                        if (!Ext.getCmp('pnlOpcional'))
                        {
                            chkCrper_estado_interfecto = new Ext.form.Checkbox({
                                id:'chkCrper_estado_interfecto',
                                name:'chkCrper_estado_interfecto',
                                fieldLabel :'Defunci\u00f3n confirmada',
                                allowBlank : true,
                                checked:false
                            });
                            /**
                             * Ext.form.DateField FECHA DE DEFUNCION
                             */
                            dtCrper_fecha_defuncion = new Ext.form.DateField({
                                id:'dtCrper_fecha_defuncion',
                                name:'dtCrper_fecha_defuncion',
                                fieldLabel :'Fecha',
                                allowBlank : true,
                                format :'d/m/Y',
                                maxValue: new Date()
                            });
                            /**
                             * Ext.form.TextField NUMERO DE ACTA DE DEFUNCION
                             */
                            txtCrper_numero_acta = new Ext.form.TextField({
                                id:'txtCrper_numero_acta',
                                name:'txtCrper_numero_acta',
                                fieldLabel :'N\u00famero acta',
                                anchor:'50%',
                                allowBlank : true
                            });
                            /**
                             * Ext.form.TextField NOMBRE ARCHIVO DIGITAL ADJUNTO DE ACTA DE DEFUNCION
                             */
                            txtCrper_nombre_adjunto_acta = new Ext.form.TextField({
                                id:'txtCrper_nombre_adjunto_acta',
                                name:'txtCrper_nombre_adjunto_acta',
                                fieldLabel :'Adjunto acta',
                                anchor:'98%',
                                allowBlank : true
                            });

                           /* tabpnlInformacionAdicional.add({
                                id:'pnlOpcional',
                                layout:'form',
                                frame : true,
                                title:'Datos defunci\u00f3n',
                                closable : true,
                                items:[chkCrper_estado_interfecto,dtCrper_fecha_defuncion,txtCrper_numero_acta,{
                                    xtype:'panel',
                                    layout:'column',
                                    items:[

                                        {
                                            columnWidth:.5,
                                            layout:'form',
                                            items:[txtCrper_nombre_adjunto_acta]
                                        },

                                        {
                                            columnWidth:.035,
                                            layout:'form',
                                            items:[{
                                                xtype:'button',
                                                iconCls:'iconNuevo',
                                                tooltip:'Agregar documento',
                                                listeners:{
                                                    click:function()
                                                    {
                                                        var objSubirAdjunto = new FrmCgg_res_adjunto_temporal();
                                                        objSubirAdjunto.closeHandler(function(){
                                                            var dialogResult = objSubirAdjunto.dialogResult();
                                                            if(dialogResult  !== null){
                                                                txtCrper_nombre_adjunto_acta.setValue(dialogResult.CRATE_NOMBRE);
                                                                tmpCrper_adjunto_acta = dialogResult.CRATE_CODIGO;

                                                            }
                                                        });
                                                        objSubirAdjunto.show();

                                                    }
                                                }

                                            }]
                                        },
                                        {
                                            columnWidth:.035,
                                            layout:'form',
                                            items:[{
                                                xtype:'button',
                                                iconCls:'iconVer',
                                                tooltip:'Ver documento',
                                                listeners:{
                                                    click:function()
                                                    {

                                                        var url1 = URL_DOC_VIEWER+'?table=cgg_res_persona&keyc=crper_codigo&keyv='+inRecordCgg_res_persona.get('CRPER_CODIGO') +'&column=Crper_adjunto_acta&fn='+txtCrper_nombre_adjunto_acta.getValue()+'&request=view';
                                                        window.open(url1);
                                                        /!* window.open( new Ajax.Request(URL_DOC_VIEWER, {
                                                         onSuccess: function(response) {
                                                         //alert(response);
                                                         },
                                                         onFailure:function(response){
                                                         //alert("Fallo;")
                                                         },
                                                         asynchronous:true,
                                                         parameters:{
                                                         table:'cgg_res_persona',
                                                         keyc:'crper_codigo',
                                                         keyv:inRecordCgg_res_persona.get('CRPER_CODIGO'),
                                                         column:'Crper_adjunto_acta',
                                                         fn:txtCrper_nombre_adjunto_acta.getValue(),
                                                         request:'view'
                                                         }
                                                         }));*!/

                                                    }
                                                }

                                            }]
                                        },

                                        {
                                            columnWidth:.035,
                                            layout:'form',
                                            items:[{
                                                xtype:'button',
                                                iconCls:'iconDescargar',
                                                tooltip:'Descargar documento',
                                                listeners:{
                                                    click:function()
                                                    {
                                                        var url2 = URL_DOC_VIEWER+'?table=cgg_res_persona&keyc=crper_codigo&keyv='+inRecordCgg_res_persona.get('CRPER_CODIGO') +'&column=Crper_adjunto_acta&fn='+txtCrper_nombre_adjunto_acta.getValue()+'&request=download';
                                                        window.open(url2);
                                                    }
                                                }

                                            }]
                                        }
                                    ]
                                }]
                            });*/
                            Ext.getCmp('pnlOpcional').show();
                            if(inRecordCgg_res_persona)
                            {
                                chkCrper_estado_interfecto.setValue(inRecordCgg_res_persona.get('CRPER_ESTADO_INTERFECTO'));
                                dtCrper_fecha_defuncion.setValue(inRecordCgg_res_persona.get('CRPER_FECHA_DEFUNCION')?formatShortDate(inRecordCgg_res_persona.get('CRPER_FECHA_DEFUNCION')):null);
                                txtCrper_numero_acta.setValue(inRecordCgg_res_persona.get('CRPER_NUMERO_ACTA'));
                                txtCrper_nombre_adjunto_acta.setValue(inRecordCgg_res_persona.get('CRPER_NOMBRE_ADJUNTO_ACTA'));
                            }
                        }
                    }
                }
            }
        ]
    });
    /**
     *Ext.form.ComboBox Combo para edicion de tipo de contacto.
     */
    var cbxCRTCO_CODIGOEditor = new Ext.form.ComboBox({
        id:'cbxCRTCO_CODIGOEditor',
        store: SCGG_RES_TIPO_CONTACTO,
        displayField:'CRTCO_NOMBRE',
        typeAhead: true,
        mode:'local',
        forceSelection:true,
        allowBlank:false,
        triggerAction:'all',
        emptyText:'Seleccione un tipo',
        selectOnFocus:true,
        valueField:'CRTCO_CODIGO'
    });

    var txtCINTC_CONTACTOEditor = new Ext.form.TextField({
        id:'txtCINTC_CONTACTOEditor',
        emptyText:'Establezca una descripci\u00F3n',
        allowBlank:false
    });
    /*
     * Ext.ux.grid.RowEditor Edito de filas personalizado para utilización en el grid de contacto
     */
    var reContacto= new Ext.ux.grid.RowEditor({
        saveText: 'Aceptar',
        cancelText:'Cancelar',
        errorSummary: false,
        listeners:{
            validateedit:function(inRowEditor,inObject,inRecord,inRowIndex){
                /*for(var i =0;i<grdCgg_res_garantia_solicitud.getStore().getCount();i++){
                 if(inObject.CRGRT_CODIGO==grdCgg_res_garantia_solicitud.getStore().getAt(i).get('CRGRT_CODIGO')){
                 Ext.Msg.show({
                 title:tituloCgg_res_tipo_solicitud_tramite,
                 msg: 'La garant\u00EDa seleccionada ya esta establecida.',
                 buttons: Ext.Msg.OK,
                 icon: Ext.MessageBox.WARNING
                 });
                 grdCgg_res_garantia_solicitud.getStore().remove(inRecord);
                 }
                 }*/
            },
            canceledit:function(inRowEditor,inFlag,inRecord){
                var inRecord=dtgCgg_res_persona_contacto.getStore().getAt(0);
                if (inRecord.get('CRPRC_CODIGO') == 'KEYGEN')
                {
                    dtgCgg_res_persona_contacto.getStore().remove(inRecord);
                }

            }
        }
    });

    /**
     * Ext.ColumnModel Agrupacion de registros de la tabla Cgg_res_persona_contacto por un campo especifico.
     */
    var cmCgg_res_persona_contacto = new Ext.grid.ColumnModel([
        {
            dataIndex:'CRPRC_CODIGO',
            hidden:true,
            header:'Codigo',
            width:150,
            sortable:true
        },
        {
            dataIndex:'CRPER_CODIGO',
            hidden:true,
            header:'Codigo',
            width:150,
            sortable:true
        },
        {
            dataIndex:'CRTCO_CODIGO',
            header:'Contacto',
            width:40,
            sortable:true,
            editor:cbxCRTCO_CODIGOEditor,
            renderer:
                function(value, metaData, record){
                    if (value){
                        var tmpHtml = null;
                        var tmpNombreImagen = null;
                        var rTipoContaco= record;
                        try{
                            if (rTipoContaco.get('CRTCO_NOMBRE_IMAGEN').length == 0)
                            {
                                rTipoContaco=SCGG_RES_TIPO_CONTACTO.getAt(SCGG_RES_TIPO_CONTACTO.findExact('CRTCO_CODIGO',value));
                            }
                            tmpNombreImagen = rTipoContaco.get('CRTCO_NOMBRE_IMAGEN');
                            new Ajax.Request(URL_DOC_VIEWER, {
                                onSuccess: function(response) {
                                    tmpHtml = '<div><img src="/siiws/tmp/'+tmpUserSession.getUserName().trim()+'/'+ tmpNombreImagen +'"/></div>';
                                },
                                onFailure:function(response){

                                },
                                asynchronous:false,
                                parameters:{
                                    table:'cgg_res_tipo_contacto',
                                    keyc:'crtco_codigo',
                                    keyv:rTipoContaco.get('CRTCO_CODIGO'),
                                    column:'crtco_imagen',
                                    fn:tmpNombreImagen,
                                    request:'view'
                                }
                            });
                            return tmpHtml;
                        }
                        catch(inError)
                        {
                            return 'codigo';
                        }
                    }
                }
        },
        {
            dataIndex:'CRPRC_DESCRIPCION',
            header:'Descripcion',
            width:50,
            sortable:true,
            hidden:true
        },
        {
            dataIndex:'CRPRC_CONTACTO',
            header:'Descripci\u00f3n',
            width:150,
            sortable:true,
            editor:txtCINTC_CONTACTOEditor
        },
        {
            dataIndex:'CRTCO_NOMBRE',
            header:'Nombre',
            width:50,
            sortable:true,
            hidden:true
        },
        {
            dataIndex:'CRTCO_NOMBRE_IMAGEN',
            header:'Nombre',
            width:50,
            sortable:true,
            hidden:true
        }

    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_persona_contacto por un campo especifico.
     */
    var gsCgg_res_persona_contacto = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_persona_contacto",
            method:"selectPersonaContacto",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
        },[
            {
                name:'CRPRC_CODIGO'
            },

            {
                name:'CRPER_CODIGO'
            },

            {
                name:'CRTCO_CODIGO',
                allowBlank:false
            },

            {
                name:'CRPRC_DESCRIPCION'
            },

            {
                name:'CRPRC_CONTACTO',
                allowBlank:false
            },

            {
                name:'CRTCO_NOMBRE'
            },

            {
                name:'CRTCO_NOMBRE_IMAGEN'
            }


        ]),
        baseParams:{
            inCrper_codigo:'',
            format:TypeFormat.JSON
        }
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_persona_contacto en un formato tabular de filas y columnas.
     */
    var dtgCgg_res_persona_contacto = new Ext.grid.EditorGridPanel({
        cm:cmCgg_res_persona_contacto,
        store:gsCgg_res_persona_contacto,
        region:'center',
        anchor:'100% 100%',
        viewConfig:{
            forceFit:true
        },
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        loadMask:{
            msg:"Cargando..."
        },
        tbar: [{
            text:'Datos contacto'
        },'->',{
            xtype:'button',
            iconCls:'iconNuevo',
            tooltip:'Agregar contacto',
            handler:function(){
                var tmpRecordCriterio = dtgCgg_res_persona_contacto.getStore().recordType;
                reContacto.stopEditing();
                dtgCgg_res_persona_contacto.getStore().insert(0,
                    new tmpRecordCriterio({
                        CRPRC_CODIGO: 'KEYGEN',
                        CRPER_CODIGO: 'KEYGEN',
                        CRTCO_CODIGO: '',
                        CRPRC_DESCRIPCION: '',
                        CRPRC_CONTACTO: '',
                        CRTCO_NOMBRE: '',
                        CRTCO_NOMBRE_IMAGEN: ''
                    })
                );
                dtgCgg_res_persona_contacto.getView().refresh();
                dtgCgg_res_persona_contacto.getSelectionModel().selectRow(0);
                reContacto.startEditing(0);
            }
        },
            {
                iconCls:'iconEliminar',
                tooltip:'Eliminar contacto',
                handler:function(){
                    Ext.Msg.show({
                        title:'Aviso',
                        msg:'Est\u00e1 seguro de eliminar el registro seleccionado?',
                        buttons: Ext.Msg.YESNO,
                        fn: SWRCgg_perfil_prof,
                        icon: Ext.MessageBox.QUESTION
                    });
                    function SWRCgg_perfil_prof(btn){
                        if (btn=='yes')
                        {
                            try{
                                var seleccionado = dtgCgg_res_persona_contacto.getSelectionModel().getSelected();
                                if(seleccionado)
                                {
                                    function CallBackCgg_res_persona_contacto(r){
                                        winFrmCgg_res_notificacion_finan.getEl().unmask();
                                        if(r=='true'){
                                            Ext.Msg.show({
                                                title:tituloCgg_res_persona,
                                                msg: 'La informaci\u00f3n de contacto ha sido eliminada.',
                                                buttons: Ext.Msg.OK,
                                                icon: Ext.MessageBox.INFO
                                            });
                                            dtgCgg_res_persona_contacto.getStore().remove(seleccionado);
                                        }else{
                                            Ext.Msg.show({
                                                title:tituloCgg_res_persona,
                                                msg: 'La informaci\u00f3n de contacto no ha podido ser eliminada.',
                                                buttons: Ext.Msg.OK,
                                                icon: Ext.MessageBox.ERROR
                                            });
                                        }
                                    }
                                    winFrmCgg_res_notificacion_finan.getEl().mask('Eliminando...', 'x-mask-loading');

                                    if(seleccionado.get('CRPRC_CODIGO') == 'KEYGEN')
                                    {
                                        dtgCgg_res_persona_contacto.getStore().remove(seleccionado);
                                        winFrmCgg_res_notificacion_finan.getEl().unmask();
                                    }
                                    else
                                    {
                                        var param = new SOAPClientParameters();
                                        param.add('inCrprc_codigo',dtgCgg_res_persona_contacto.getSelectionModel().getSelected().get('CRPRC_CODIGO'));
                                        SOAPClient.invoke(URL_WS + 'Cgg_res_persona_contacto',"delete",param, true, CallBackCgg_res_persona_contacto);
                                    }

                                }
                            }catch(inErr){
                                winFrmCgg_res_notificacion_finan.getEl().unmask();
                            }
                        }
                    }
                }

            }
        ],
        plugins:[reContacto]
    });



    var chkPredeterminado = new Ext.grid.CheckColumn({
        header:'Inicial',
        dataIndex: 'CGPPR_PREDETERMINADO',
        width:50,
        sortable:true
    });

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_gem_perfil_prof.
     */
    var cmCgg_gem_perfil_prof = new Ext.grid.ColumnModel([
        {
            dataIndex:'CGPPR_CODIGO',
            header:'Codigo',
            width:100,
            sortable:true,
            hidden:true
        },
        {
            dataIndex:'CGNES_DESCRIPCION',
            header:'Nivel estudio',
            width:100,
            sortable:true
        },
        {
            dataIndex:'CGIED_NOMBRE',
            header:'Institucion educativa',
            width:120,
            sortable:true
        },
        {
            dataIndex:'CGTPR_DESCRIPCION',
            header:'Titulo profesional',
            width:120,
            sortable:true
        },
        {
            dataIndex:'CGESP_NOMBRE',
            header:'Especialidad',
            width:120,
            sortable:true
        },
        {
            dataIndex:'CGMDC_DESCRIPCION',
            header:'Modalidad curso',
            width:100,
            sortable:true
        },
        {
            dataIndex:'CRPER_CODIGO',
            header:'Persona',
            width:150,
            sortable:true,
            hidden:true
        },
        {
            dataIndex:'CGPPR_NIVEL_APROBADO',
            header:'Nivel aprobado',
            width:100,
            sortable:true
        },
        {
            dataIndex:'CGPPR_FECHA_INICIO',
            header:'Fecha Inicio',
            width:100,
            sortable:true
        },
        {
            dataIndex:'CGPPR_FECHA_FIN',
            header:'Fecha Fin',
            width:100,
            sortable:true
        },
        {
            dataIndex:'CGPPR_CONFIRMADO',
            header:'Confirmado',
            width:50,
            sortable:true,
            hidden:true
        },
        {
            dataIndex:'CGIEN_CODIGO',
            header:'Instituci\u00F3n',
            width:50,
            sortable:true,
            hidden:true
        },
        {
            dataIndex:'CGESP_CODIGO',
            header:'Codigo Especialidad',
            width:50,
            sortable:true,
            hidden:true
        },
        {
            dataIndex:'CGPPR_FECHA_CONFIRMACION',
            header:'Fecha confirmacion',
            width:100,
            sortable:true,
            hidden:true
        },
        //{dataIndex:'CGPPR_PREDETERMINADO',header:'Inicial',width:50,sortable:true,xtype:'checkcolumn'}
        chkPredeterminado
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_perfil_prof por un campo especifico.
     */
    var gsCgg_gem_perfil_prof = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_gem_perfil_prof",
            method:"selectPerfilPersona",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
        },[
            {
                name:'CGPPR_CODIGO'
            },

            {
                name:'CGESP_CODIGO'
            },

            {
                name:'CGESP_NOMBRE'
            },

            {
                name:'CGTPR_CODIGO'
            },

            {
                name:'CGTPR_DESCRIPCION'
            },

            {
                name:'CGIEN_CODIGO'
            },

            {
                name:'CGIED_NOMBRE'
            },

            {
                name:'CGMDC_CODIGO'
            },

            {
                name:'CGMDC_DESCRIPCION'
            },

            {
                name:'CGNES_CODIGO'
            },

            {
                name:'CGNES_DESCRIPCION'
            },

            {
                name:'CRPER_CODIGO'
            },

            {
                name:'CGPPR_NIVEL_APROBADO'
            },

            {
                name:'CGPPR_CONFIRMADO'
            },

            {
                name:'CGPPR_FECHA_INICIO'
            },

            {
                name:'CGPPR_FECHA_FIN'
            },

            {
                name:'CGPPR_FECHA_CONFIRMACION'
            },

            {
                name:'CGPPR_PREDETERMINADO'
            }
        ]),
        baseParams:{
            inCrper_codigo:'',
            format:TypeFormat.JSON
        }
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_gem_perfil_prof en un formato tabular de filas y columnas.
     */
    var grdCgg_gem_perfil_prof = new Ext.grid.GridPanel({
        cm:cmCgg_gem_perfil_prof,
        store:gsCgg_gem_perfil_prof,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        loadMask:{
            msg:"Cargando..."
        },
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                Ext.getCmp('btnEditarCgg_gem_perfil_prof').fireEvent('click',Ext.getCmp('btnEditarCgg_gem_perfil_prof'));
            }
        }
    });


    /**
     * DEFINICION DE INFORMCION DE OCUPACION LABORAL
     * **/
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_ocupacion_laboral.
     */
    var cmCgg_res_ocupacion_laboral = new Ext.grid.ColumnModel([
        {
            dataIndex:'CROCL_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true
        },
        {
            dataIndex:'CRPER_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true
        },
        {
            dataIndex:'CGG_CRPER_CODIGO',
            header:'Crper codigo',
            width:150,
            sortable:true,
            hidden:true
        },
        {
            dataIndex:'CGG_CRPER_NOMBRES',
            header:'Empleador',
            width:200,
            sortable:true,
            renderer:function(value,metadata,record)
            {
                if(value != null &&  value != undefined && value.length>0)
                {
                    return value;
                }
                else
                {
                    return record.data.CRPJR_RAZON_SOCIAL;
                }
            }
        },
        {
            dataIndex:'CGCRG_NOMBRE',
            header:'Cargo',
            width:150,
            sortable:true
        },
        {
            dataIndex:'CSCTP_NOMBRE',
            header:'Sector Productivo',
            width:150,
            sortable:true
        },
        {
            dataIndex:'CRPJR_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true
        },
        {
            dataIndex:'CROCL_TIPO',
            header:'Tipo',
            width:150,
            sortable:true,
            renderer:function(value)
            {
                if(value == TypeOcupacionLaboral.PUBLICA)
                {
                    return 'Publica';
                }
                if(value == TypeOcupacionLaboral.PRIVADA)
                {
                    return 'Privada';
                }
                if(value == TypeOcupacionLaboral.PROPIA)
                {
                    return 'Propia';
                }
                if(value == TypeOcupacionLaboral.OTROS)
                {
                    return 'Otros';
                }

            }
        }]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_ocupacion_laboral por un campo especifico.
     */
    var gsCgg_res_ocupacion_laboral = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_ocupacion_laboral",
            method:"selectOcupacionPersona",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({

        },[
            {
                name:'CROCL_CODIGO'
            },

            {
                name:'CRPER_CODIGO'
            },

            {
                name:'CGG_CRPER_CODIGO'
            },

            {
                name:'CGG_CRPER_NOMBRES'
            },

            {
                name:'CGCRG_CODIGO'
            },

            {
                name:'CGCRG_NOMBRE'
            },

            {
                name:'CSCTP_CODIGO'
            },

            {
                name:'CSCTP_NOMBRE'
            },

            {
                name:'CRPJR_CODIGO'
            },

            {
                name:'CRPJR_RAZON_SOCIAL'
            },

            {
                name:'CROCL_TIPO'
            }
        ]),
        baseParams:{
            inCrper_codigo:"",
            format:"JSON"
        }
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_ocupacion_laboral en un formato tabular de filas y columnas.
     */
    var grdCgg_res_ocupacion_laboral = new Ext.grid.GridPanel({
        cm:cmCgg_res_ocupacion_laboral,
        store:gsCgg_res_ocupacion_laboral,
        region:'center',
        viewConfig:{
            forceFit:true
        },
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        loadMask:{
            msg:"Cargando..."
        },
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                /*if(!btn.disabled){
                 btnEditarCgg_res_ocupacion_laboral.fireEvent('click', btnEditarCgg_res_ocupacion_laboral);
                 }*/
            }
        }
    });


    /**
     * FIN DE LA SECCION
     * */
    var objImageDefault={
        AVATAR:'resources/images/male_avatar.jpeg',
        AUTORIZADO:'resources/images/32x32/fail.png',
        HUELLA:'resources/images/fingerprint.jpg',
        FIRMA:'resources/images/signature.png'
    };

    var tplImagePersona = new Ext.Template('<div style="position:absolute; top:0px; left:0px;height: 100% ; width: 100% ; padding:5px 0px 0px 5px"' +
    '><img id="imgFotoPrs" src={AVATAR} width = "95%"  height = "95%" /></div>' +
    '<div style="position:absolute; top:90px; left:110px;height: 32px ; width: 32px ; padding:5px 0px 0px 5px"' +
    '><img src={AUTORIZADO} width = "95%"  height = "95%" /></div>');

    var tplHuella = new Ext.Template('<div style="height: 100% ; width:100% ; padding:5px 0px 0px 5px;text-align: center;"' +
    '><img id="imgHuellaPrs" src={HUELLA}  width = "55%"  height = "90%" /></div>');

    var tplFirma = new Ext.Template('<div style="height: 100% ; width: 100% ; padding:5px 0px 0px 5px;text-align: center;"' +
    '><img id="imgFirmaPrs" src={FIRMA} width = "65%"  height = "60%"/></div>');

    var pnlImage = new Ext.Panel({
        id:'pnlImage',
        anchor: '100%',
        frame:true,
        height: 150,
        data:objImageDefault,
        tpl:tplImagePersona
    });


   /* var tabpnlInformacionAdicional= new Ext.TabPanel({
        activeTab: 0,
        frame:false,
        anchor:'100% 38%',
        autoDestroy: true,
        labelWidth :100,
        plugins: new Ext.ux.TabCloseMenu(),
        items:[
            {
                layout:'column',
                title:'Residencia',
                frame:true,
                bodyStyle: 'padding:0px 0px 0px 0px',
                items:[
                    {
                        columnWidth:.5,
                        layout:'form',
                        frame:false,
                        height:143,
                        items:[dtgCgg_res_persona_contacto]
                    },

                    {
                        columnWidth:.5,
                        bodyStyle: 'padding:0px 0px 0px 0px',
                        items:[

                            {
                                xtype:'tabpanel',
                                activeTab: 0,
                                frame:true,
                                height:143,
                                anchor:'100% 100%',
                                items:[
                                    {
                                        title: 'Actual',
                                        layout:'form',
                                        anchor:'100% 100%',
                                        frame:true,
                                        /!* style:{
                                         marginLeft: '5px'
                                         },
                                         bodyStyle: 'padding:0px 0px 0px 0px',*!/
                                        items :[cbxCpais_nombre_residencia,cbxCgprv_nombre_residencia,cbxCctn_nombre_residencia,cbxCprr_codigo]

                                    },
                                    {
                                        // xtype:'fieldset',
                                        title: 'Anterior',
                                        layout:'form',
                                        anchor:'100% 100%',
                                        frame:true,
                                        /!* style:{
                                         marginLeft: '5px'
                                         },
                                         bodyStyle: 'padding:0px 0px 0px 0px',*!/
                                        items :[cbxCpais_nombre_res_anterior,cbxCgprv_nombre_res_anterior,cbxCctn_nombre_res_anterior]

                                    }
                                ]
                            }

                        ]
                    }]

            },
            {
                //xtype:'panel',
                layout:'border',
                frame : false,
                title:'Datos Academicos',
                anchor:'100% 100%',
                tbar:[{
                    xtype:'button',
                    iconCls:'iconNuevo',
                    tooltip:'Agregar perfil profesional',
                    listeners:{
                        click:function(){
                            var objCgg_gem_perfil_prof = new FrmCgg_gem_perfil_prof("insert",null,"persona");
                            objCgg_gem_perfil_prof.closeHandler(function(){

                                var tmpRecordPerfilPersona = objCgg_gem_perfil_prof.getData();
                                if(tmpRecordPerfilPersona)
                                {
                                    var recId = grdCgg_gem_perfil_prof.getStore().getCount() + 1;
                                    grdCgg_gem_perfil_prof.stopEditing();
                                    grdCgg_gem_perfil_prof.getStore().insert(0, new gsCgg_gem_perfil_prof.recordType(tmpRecordPerfilPersona, recId));
                                    grdCgg_gem_perfil_prof.getView().refresh();

                                    grdCgg_gem_perfil_prof.getSelectionModel().selectRow(0);
                                    if (grdCgg_gem_perfil_prof.getSelectionModel().getSelected().get('CGPPR_PREDETERMINADO') == true)
                                    {
                                        Ext.getCmp('btnPredeterminadoCgg_gem_perfil_prof').fireEvent('click',Ext.getCmp('btnPredeterminadoCgg_gem_perfil_prof'));
                                    }
                                }

                            });
                            objCgg_gem_perfil_prof.show();
                        }
                    }
                },
                    {
                        xtype:'button',
                        id:'btnEditarCgg_gem_perfil_prof',
                        iconCls:'iconEditar',
                        tooltip:'Editar perfil profesional',
                        listeners:{
                            click:function(){
                                var r = grdCgg_gem_perfil_prof.getSelectionModel().getSelected();
                                var index = 0;
                                if (r) {
                                    var objCgg_gem_perfil_prof = new FrmCgg_gem_perfil_prof("Update",r,"persona");
                                    objCgg_gem_perfil_prof.closeHandler(function(){

                                        var tmpRecordPerfilPersona = objCgg_gem_perfil_prof.getData();
                                        if(tmpRecordPerfilPersona)
                                        {
                                            index = grdCgg_gem_perfil_prof.getStore().indexOf(r);
                                            var recId = grdCgg_gem_perfil_prof.getStore().getCount() + 1 + index; // provide unique id
                                            grdCgg_gem_perfil_prof.stopEditing();

                                            grdCgg_gem_perfil_prof.getStore().remove(grdCgg_gem_perfil_prof.getSelectionModel().getSelected());
                                            //grdCgg_gem_perfil_prof.getView().refresh();
                                            grdCgg_gem_perfil_prof.getStore().insert(index, new gsCgg_gem_perfil_prof.recordType(tmpRecordPerfilPersona, recId));
                                            grdCgg_gem_perfil_prof.getView().refresh();
                                            grdCgg_gem_perfil_prof.getSelectionModel().selectRow(index);
                                        }

                                    });
                                    objCgg_gem_perfil_prof.loadData();
                                    objCgg_gem_perfil_prof.show();
                                }
                            }
                        }
                    },
                    {
                        iconCls:'iconEliminar',
                        tooltip:'Eliminar perfil profesional',
                        handler:function(){
                            Ext.Msg.show({
                                title:'Aviso',
                                msg:'Est\u00e1 seguro de eliminar el registro seleccionado?',
                                buttons: Ext.Msg.YESNO,
                                fn: SWRCgg_perfil_prof,
                                icon: Ext.MessageBox.QUESTION
                            });
                            function SWRCgg_perfil_prof(btn){
                                if (btn=='yes')
                                {
                                    try{
                                        var seleccionado = grdCgg_gem_perfil_prof.getSelectionModel().getSelected();
                                        if(seleccionado)
                                        {
                                            function CallBackCgg_gem_perfil_prof(r){
                                                winFrmCgg_res_notificacion_finan.getEl().unmask();
                                                if(r=='true'){
                                                    Ext.Msg.show({
                                                        title:tituloCgg_res_persona,
                                                        msg: 'La informaci\u00f3n de perfil profesional ha sido eliminada.',
                                                        buttons: Ext.Msg.OK,
                                                        icon: Ext.MessageBox.INFO
                                                    });
                                                    grdCgg_gem_perfil_prof.getStore().remove(seleccionado);
                                                }else{
                                                    Ext.Msg.show({
                                                        title:tituloCgg_res_persona,
                                                        msg: 'La informaci\u00f3n de perfil profesional no ha podido ser eliminada.',
                                                        buttons: Ext.Msg.OK,
                                                        icon: Ext.MessageBox.ERROR
                                                    });
                                                }
                                            }
                                            winFrmCgg_res_notificacion_finan.getEl().mask('Eliminando...', 'x-mask-loading');

                                            if(seleccionado.get('CGPPR_CODIGO') == 'KEYGEN')
                                            {
                                                grdCgg_gem_perfil_prof.getStore().remove(seleccionado);
                                                winFrmCgg_res_notificacion_finan.getEl().unmask();
                                            }
                                            else
                                            {
                                                var param = new SOAPClientParameters();
                                                param.add('inCgppr_codigo',grdCgg_gem_perfil_prof.getSelectionModel().getSelected().get('CGPPR_CODIGO'));
                                                SOAPClient.invoke(URL_WS + 'Cgg_gem_perfil_prof',"delete",param, true, CallBackCgg_gem_perfil_prof);
                                            }

                                        }
                                    }catch(inErr){
                                        winFrmCgg_res_notificacion_finan.getEl().unmask();
                                    }
                                }
                            }
                        }

                    },
                    '->',
                    {
                        id:'btnPredeterminadoCgg_gem_perfil_prof',
                        iconCls:'iconPredeterminado',
                        tooltip:'Marcar predeterminado',
                        listeners:{
                            click:function(){
                                if (grdCgg_gem_perfil_prof.getSelectionModel().getSelected())
                                {
                                    grdCgg_gem_perfil_prof.getSelectionModel().getSelected().set('CGPPR_PREDETERMINADO',true);
                                    //Aqui el codigo para recorrer el grid y poner los registros diferentes al seleccionado en false
                                    var tmpCGPPR_CODIGO = grdCgg_gem_perfil_prof.getSelectionModel().getSelected().get('CGPPR_CODIGO');
                                    for(var i =0;i<grdCgg_gem_perfil_prof.getStore().getCount();i++){
                                        if(!grdCgg_gem_perfil_prof.getSelectionModel().isSelected(i))
                                        {
                                            grdCgg_gem_perfil_prof.getStore().getAt(i).set('CGPPR_PREDETERMINADO',false);
                                        }
                                    }
                                }

                            }
                        }

                    }

                ],
                items:[grdCgg_gem_perfil_prof]
            },
            {
                //xtype:'panel',
                layout:'border',
                frame : false,
                title:'Datos Ocupacionales',
                anchor:'100% 100%',
                tbar:[{
                    xtype:'button',
                    iconCls:'iconNuevo',
                    tooltip:'Agregar ocupacion laboral',
                    listeners:{
                        click:function(){
                            var objCgg_res_ocupacion_laboral = new FrmCgg_res_ocupacion_laboral("insert");
                            objCgg_res_ocupacion_laboral.closeHandler(function(){
                                var tmpRecordOcupacionPersona = objCgg_res_ocupacion_laboral.getData();
                                if(tmpRecordOcupacionPersona)
                                {
                                    var recId = grdCgg_res_ocupacion_laboral.getStore().getCount() + 1;
                                    grdCgg_res_ocupacion_laboral.stopEditing();
                                    grdCgg_res_ocupacion_laboral.getStore().insert(0, new gsCgg_res_ocupacion_laboral.recordType(tmpRecordOcupacionPersona, recId));
                                    grdCgg_res_ocupacion_laboral.getView().refresh();
                                    grdCgg_res_ocupacion_laboral.getSelectionModel().selectRow(0);
                                }
                            });
                            objCgg_res_ocupacion_laboral.show();
                        }
                    }
                },
                    {
                        xtype:'button',
                        id:'btnEditarCgg_gem_perfil_prof',
                        iconCls:'iconEditar',
                        tooltip:'Editar ocupacion laboral',
                        listeners:{
                            click:function(){
                                var r = grdCgg_res_ocupacion_laboral.getSelectionModel().getSelected();
                                var index = 0;
                                if (r) {
                                    // var objCgg_gem_perfil_prof = new FrmCgg_gem_perfil_prof("Update",r,"persona");
                                    var objCgg_res_ocupacion_laboral = new FrmCgg_res_ocupacion_laboral("update",r);
                                    objCgg_res_ocupacion_laboral.closeHandler(function(){

                                        var tmpRecordOcupacionPersona = objCgg_res_ocupacion_laboral.getData();
                                        if(tmpRecordOcupacionPersona)
                                        {
                                            index = grdCgg_res_ocupacion_laboral.getStore().indexOf(r);
                                            var recId = grdCgg_res_ocupacion_laboral.getStore().getCount() + 1 + index; // provide unique id
                                            grdCgg_res_ocupacion_laboral.stopEditing();

                                            grdCgg_res_ocupacion_laboral.getStore().remove(grdCgg_res_ocupacion_laboral.getSelectionModel().getSelected());
                                            //grdCgg_gem_perfil_prof.getView().refresh();
                                            grdCgg_res_ocupacion_laboral.getStore().insert(index, new gsCgg_res_ocupacion_laboral.recordType(tmpRecordOcupacionPersona, recId));
                                            grdCgg_res_ocupacion_laboral.getView().refresh();
                                            grdCgg_res_ocupacion_laboral.getSelectionModel().selectRow(index);
                                        }

                                    });
                                    objCgg_res_ocupacion_laboral.loadData();
                                    objCgg_res_ocupacion_laboral.show();
                                }
                            }
                        }
                    },
                    {
                        iconCls:'iconEliminar',
                        tooltip:'Eliminar ocupacion laboral',
                        handler:function(){
                            Ext.Msg.show({
                                title:'Aviso',
                                msg:'Est\u00e1 seguro de eliminar el registro seleccionado?',
                                buttons: Ext.Msg.YESNO,
                                fn: SWRCgg_perfil_prof,
                                icon: Ext.MessageBox.QUESTION
                            });
                            function SWRCgg_perfil_prof(btn){
                                if (btn=='yes')
                                {
                                    try{
                                        var seleccionado = grdCgg_res_ocupacion_laboral.getSelectionModel().getSelected();
                                        if(seleccionado)
                                        {
                                            function CallBackCgg_gem_perfil_prof(r){
                                                winFrmCgg_res_notificacion_finan.getEl().unmask();
                                                if(r=='true'){
                                                    Ext.Msg.show({
                                                        title:tituloCgg_res_persona,
                                                        msg: 'La informaci\u00f3n de ocupaci\u00f3n laboral ha sido eliminada.',
                                                        buttons: Ext.Msg.OK,
                                                        icon: Ext.MessageBox.INFO
                                                    });
                                                    grdCgg_res_ocupacion_laboral.getStore().remove(seleccionado);
                                                }else{
                                                    Ext.Msg.show({
                                                        title:tituloCgg_res_persona,
                                                        msg: 'La informaci\u00f3n de ocupaci\u00f3n laboral no ha podido ser eliminada.',
                                                        buttons: Ext.Msg.OK,
                                                        icon: Ext.MessageBox.ERROR
                                                    });
                                                }
                                            }
                                            winFrmCgg_res_notificacion_finan.getEl().mask('Eliminando...', 'x-mask-loading');

                                            if(seleccionado.get('CROCL_CODIGO') == 'KEYGEN')
                                            {
                                                grdCgg_res_ocupacion_laboral.getStore().remove(seleccionado);
                                                winFrmCgg_res_notificacion_finan.getEl().unmask();
                                            }
                                            else
                                            {
                                                var param = new SOAPClientParameters();
                                                param.add('inCrocl_codigo',grdCgg_res_ocupacion_laboral.getSelectionModel().getSelected().get('CROCL_CODIGO'));
                                                SOAPClient.invoke(URL_WS + 'Cgg_res_ocupacion_laboral',"delete",param, true, CallBackCgg_gem_perfil_prof);
                                            }

                                        }
                                    }catch(inErr){
                                        winFrmCgg_res_notificacion_finan.getEl().unmask();
                                    }
                                }
                            }
                        }

                    }

                ],
                items:[grdCgg_res_ocupacion_laboral]
            },
            {
                frame : true,
                title:'Identificaci\u00f3n',
                html:'<object id="bsxCrperRegisterBiometric" type="' + SII_mimeType + '" width="0" height="0"></object>',
                layout:'column',
                items:[
                    {
                        xtype:'fieldset',
                        columnWidth: 0.5,
                        title: 'Huella Dactilar',
                        anchor:'100%',
                        border:true,
                        items :[
                            {
                                xtype:'panel',
                                layout:'column',
                                items:
                                    [
                                        {
                                            columnWidth:.9,
                                            layout:'form',
                                            items:[

                                                {
                                                    xtype:'panel',
                                                    id:'pnlHuella',
                                                    height:130,
                                                    data:objImageDefault,
                                                    tpl:tplHuella
                                                }
                                            ]
                                        }
                                        ,
                                        {
                                            columnWidth:.1,
                                            layout:'form',
                                            items:
                                                [
                                                    {
                                                        xtype:'button',
                                                        iconCls:'iconHand',
                                                        arrowAlign :'bottom',
                                                        tooltip:'Capturar huella',
                                                        listeners:{
                                                            click:function()
                                                            {
                                                                if ( txtCrper_num_doc_identific.getValue())
                                                                {
                                                                    if(!tmpPluginPersona)
                                                                        tmpPluginPersona = document.getElementById("bsxCrperRegisterBiometric");
                                                                    var tmpIdPersona;
                                                                    tmpIdPersona = txtCrper_num_doc_identific.getValue();
                                                                    var tmpHuella = tmpPluginPersona.enroll(tmpIdPersona);
                                                                    if(tmpHuella){
                                                                        tmpFirAuditText = tmpPluginPersona.firAuditText;
                                                                        tmpFirText = tmpPluginPersona.firText;
                                                                        if(!isEdit)
                                                                        {
                                                                            Ext.Ajax.request({
                                                                                url: URL_WS+'Biometrico',
                                                                                success: function(inResponse){
                                                                                    var tmpJSON = Ext.util.JSON.decode(inResponse.responseText)
                                                                                    tmpHuellaImagen = tmpJSON.msg;
                                                                                    var tmpImgHuella = document.getElementById("imgHuellaPrs");
                                                                                    tmpImgHuella.src = 'data:image/jpg;base64,'+ tmpHuellaImagen;
                                                                                },
                                                                                failure: function(inResponse){
                                                                                },
                                                                                params: {
                                                                                    op: 'photo',
                                                                                    data: tmpFirAuditText
                                                                                }
                                                                            });
                                                                        }
                                                                        else
                                                                        {
                                                                            Ext.Ajax.request({
                                                                                url: URL_WS+'Biometrico',
                                                                                success: function(inResponse){
                                                                                    var tmpJSON = Ext.util.JSON.decode(inResponse.responseText)
                                                                                    tmpHuellaImagen = tmpJSON.msg;
                                                                                    var tmpImgHuella = document.getElementById("imgHuellaPrs");
                                                                                    tmpImgHuella.src = 'data:image/jpg;base64,'+ tmpHuellaImagen;
                                                                                },
                                                                                failure: function(inResponse){
                                                                                },
                                                                                params: {
                                                                                    op: 'update',
                                                                                    data: tmpFirAuditText,
                                                                                    dataAudit: tmpFirText,
                                                                                    id: txtCrper_codigo.getValue()
                                                                                }
                                                                            });
                                                                        }
                                                                    }else{
                                                                        Ext.Msg.show({
                                                                            title: tituloCgg_res_persona,
                                                                            msg: tmpPluginPersona.message,
                                                                            buttons: Ext.Msg.OK,
                                                                            icon: Ext.MessageBox.ERROR
                                                                        });
                                                                    }
                                                                }
                                                                else
                                                                {
                                                                    Ext.Msg.show({
                                                                        title: tituloCgg_res_persona,
                                                                        msg: 'Es necesario ingresar el numero de indentificaci\u00f3n de la persona!!!',
                                                                        buttons: Ext.Msg.OK,
                                                                        icon: Ext.MessageBox.ERROR
                                                                    });
                                                                }

                                                            }
                                                        }
                                                    },
                                                    {
                                                        xtype:'button',
                                                        iconCls:'iconEliminar',
                                                        arrowAlign :'bottom'
                                                    }
                                                ]
                                        }
                                    ]
                            }
                        ]

                    },{
                        xtype:'fieldset',
                        title: 'Firma digital',
                        columnWidth: 0.5,
                        anchor:'100%',
                        style:{
                            marginLeft: '5px'
                        },
                        border: true,
                        items :[
                            {
                                xtype:'panel',
                                layout:'column',
                                items:
                                    [
                                        {
                                            columnWidth:.9,
                                            layout:'form',
                                            items:[

                                                {
                                                    xtype:'panel',
                                                    id:'pnlFirma',
                                                    height:130,
                                                    data:objImageDefault,
                                                    tpl:tplFirma
                                                    //    frame:true
                                                }
                                            ]
                                        }
                                        ,
                                        {
                                            columnWidth:.1,
                                            layout:'form',
                                            items:
                                                [
                                                    {
                                                        xtype:'button',
                                                        iconCls:'iconFirma',
                                                        arrowAlign :'bottom',
                                                        tooltip: 'Capturar firma',
                                                        listeners :{
                                                            click:function()
                                                            {
                                                                if(!tmpPluginPersona)
                                                                    tmpPluginPersona = document.getElementById("bsxCrperRegisterBiometric");
                                                                tmpFirma = tmpPluginPersona.getSignature()
                                                                if(tmpFirma && tmpFirma.length > 0){
                                                                    var tmpImgFirma = document.getElementById("imgFirmaPrs");
                                                                    tmpImgFirma.src = 'data:image/jpg;base64,'+tmpFirma;
                                                                    if(isEdit)
                                                                    {
                                                                        function CallBackCgg_res_persona_firma(r){
                                                                            Ext.Msg.show({
                                                                                title: tituloCgg_res_persona,
                                                                                msg: 'Firma actualizada satisfactoriamente !!',
                                                                                buttons: Ext.Msg.OK,
                                                                                icon: Ext.MessageBox.INFO
                                                                            });

                                                                        }
                                                                        var param = new SOAPClientParameters();
                                                                        param.add('inCrper_codigo',txtCrper_codigo.getValue());
                                                                        param.add('inCrper_firma',tmpFirma);
                                                                        SOAPClient.invoke(URL_WS+"Cgg_res_persona",'updateFirma',param, true, CallBackCgg_res_persona_firma);
                                                                    }
                                                                }else{
                                                                    Ext.Msg.show({
                                                                        title: tituloCgg_res_persona,
                                                                        msg: tmpPluginPersona.message,
                                                                        buttons: Ext.Msg.OK,
                                                                        icon: Ext.MessageBox.ERROR
                                                                    });
                                                                }
                                                            }
                                                        }
                                                    },
                                                    {
                                                        xtype:'button',
                                                        iconCls:'iconEliminar',
                                                        arrowAlign :'bottom'
                                                    }
                                                ]
                                        }
                                    ]
                            }

                        ]
                    }
                ]

            }
            ,
            {
                layout:'column',
                frame : true,
                title:'Datos Complementarios',
                items:[
                    {
                        xtype:'fieldset',
                        columnWidth: 0.5,
                        labelWidth:'150',
                        title: 'Adicionales',
                        anchor:'100%',
                        bodyStyle: 'padding:0px 0px 0px 10px',
                        border:true,
                        //layout:'anchor',
                        items :[
                            chkCrper_empleado,chkCrper_cupo_vehicular,cbxCrper_tipo_persona
                        ]

                    },{
                        xtype:'fieldset',
                        title: 'Observaciones',
                        columnWidth: 0.5,
                        anchor:'100%',
                        style:{
                            marginLeft: '5px'
                        },
                        bodyStyle: 'padding:5px 0px 0px 10px',
                        //border: true,
                        items :[
                            txtCrper_observaciones
                        ]
                    }]
            }
        ]
    });*/

    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_notificacion_finan.
     */
    var pnlCgg_res_persona = new Ext.form.FormPanel({
        anchor:'100% 100%',
        items:[
            {
                xtype:'panel',
                layout:'column',
                defaults: {
                    bodyStyle: 'padding:4px'
                },
                items:[
                    {
                        xtype:'fieldset',
                        columnWidth: 0.75,
                        title: 'Personales',
                        layout: 'form',
                        items :[
                            {
                                xtype:'panel',
                                layout:'column',
                                items:[

                                    {
                                        columnWidth:.5,
                                        layout:'form',
                                        items:[txtCrper_apellido_paterno]
                                    },

                                    {
                                        columnWidth:.5,
                                        layout:'form',
                                        items:[txtCrper_apellido_materno]
                                    }]
                            },
                            txtCrper_nombres,
                            {
                                xtype:'panel',
                                layout:'column',
                                items:[

                                    {
                                        columnWidth:.5,
                                        layout:'form',
                                        items:[txtCrper_num_doc_identific,txtCrper_numero_expediente]
                                    },

                                    {
                                        columnWidth:.5,
                                        layout:'form',
                                        items:[txtCrper_numero_residencia,chkCrper_autorizado]
                                    }]
                            }
                        ]
                    }/*,{
                        xtype:'fieldset',
                        header: '',
                        autoHeight:true,
                        columnWidth: 0.25,
                        layout:'anchor',
                        border: false,
                        items :[pnlImage]
                    }*/]
            },
            {
                xtype:'panel',
                layout:'column',
                defaults: {
                    layout: 'form',
                    bodyStyle: 'padding:4px'
                },
                items:[
                    {
                        xtype:'fieldset',
                        columnWidth: 0.5,
                        title: 'General',
                        border:true,
                        items :[rdgCCrper_genero,cbxCrecv_codigo,cbxCrtsg_codigo,cbxCgncn_codigo]
                    },{
                        xtype:'fieldset',
                        title: 'Nacimiento',
                        columnWidth: 0.5,
                        style:{
                            marginLeft: '5px'
                        },
                        border: true,
                        items :[dtCrper_fecha_nacimiento,cbxCpais_nombre_nacimiento,cbxCgprv_nombre_nacimiento,cbxCctn_nombre_nacimiento]
                    }]
            }],
        frame:true,
        labelWidth :100
    });

    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_persona.
     */
    var winFrmCgg_res_notificacion_finan = new Ext.Window({
        id:'winFrmCgg_res_notificacion_finan',
        title:tituloCgg_res_persona,
        tbar:getPanelTitulo(tituloCgg_res_persona,descCgg_res_persona),
        items:[pnlCgg_res_persona],
        width:710,
        minWidth:700,
        height:600,
        minHeight:600,
        maximizable:false,
        resizable:false,
        minimizable:false,
        layout:'anchor',
        modal:true,
        constrain:true,
        bbar:[btnGuardarCgg_res_persona,btnMasAcciones,btnCancelarCgg_res_persona,'->',btnCerrarCgg_res_persona],
        listeners:{
            show:function()
            {
                tmpEstado = true;
                if(rdgCCrper_genero.getValue().getRawValue() == TypeGenero.FEMENINO)
                {
                    objImageDefault.AVATAR = 'resources/images/female_avatar.jpg';
                }
                else
                {
                    objImageDefault.AVATAR = 'resources/images/male_avatar.jpeg';

                }
                if (tmpEstado)
                    tplImagePersona.overwrite(pnlImage.body,objImageDefault);

                if(isEdit)
                {
                   /* tabpnlInformacionAdicional.setActiveTab(3);
                    tabpnlInformacionAdicional.setActiveTab(0);*/
                    consultarImagen();
                }

            }
        }
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmCgg_res_notificacion_finan.getBottomToolbar());
    /**
     * Funcion que permite cargar los valores de los stores utilizados en el formulario .
     *
     */
    function loadStore()
    {
        gsCgg_res_documento_identificacio.load();
        gsCgg_res_estado_civil.load();
        gsCgg_res_tipo_sanguineo.load();
        gsCgg_nacionalidad.load();
        stCpais_nacimiento.loadData(Ext.util.JSON.decode(createJSONObject(SCGG_PAIS)),true);
        stCpais_residencia.loadData(Ext.util.JSON.decode(createJSONObject(SCGG_PAIS)),true);
        stCpais_residencia_anterior.loadData(Ext.util.JSON.decode(createJSONObject(SCGG_PAIS)),true);


    }
    loadStore();

    function consultarDivisonPolitica(INCCTN_CODIGO,INTYPE)
    {
        try{
            function CallBackCgg_res_canton(r){
                var tmpResult = Ext.util.JSON.decode(r);
                if (tmpResult.length > 0 )
                {
                    if(INTYPE == TypeCiudadPersona.NACIMIENTO)
                    {
                        cbxCpais_nombre_nacimiento.setValue(tmpResult[0].CPAIS_CODIGO);


                        var rProvincia=SCGG_PAIS.getAt(SCGG_PAIS.findExact('CPAIS_CODIGO',tmpResult[0].CPAIS_CODIGO)).json;
                        stCrprv_nacimiento.loadData(rProvincia.PROVINCIAS,true);
                        cbxCgprv_nombre_nacimiento.setValue(tmpResult[0].CGPRV_CODIGO);


                        var rCanton=stCrprv_nacimiento.getAt(stCrprv_nacimiento.findExact('CGPRV_CODIGO',tmpResult[0].CGPRV_CODIGO)).json;
                        stCctn_nacimiento.loadData(rCanton.CANTONES,true);

                        cbxCctn_nombre_nacimiento.setValue(tmpResult[0].CCTN_CODIGO);
                    }
                    else if(INTYPE == TypeCiudadPersona.RESIDENCIA)
                    {
                        cbxCpais_nombre_residencia.setValue(tmpResult[0].CPAIS_CODIGO);
                        var rProvinciaResidencia=SCGG_PAIS.getAt(SCGG_PAIS.findExact('CPAIS_CODIGO',tmpResult[0].CPAIS_CODIGO)).json;
                        stCrprv_residencia.loadData(rProvinciaResidencia.PROVINCIAS,true);

                        cbxCgprv_nombre_residencia.setValue(tmpResult[0].CGPRV_CODIGO);
                        var rCantonResidencia=stCrprv_residencia.getAt(stCrprv_residencia.findExact('CGPRV_CODIGO',tmpResult[0].CGPRV_CODIGO)).json;
                        stCctn_residencia.loadData(rCantonResidencia.CANTONES,true);

                        cbxCctn_nombre_residencia.setValue(tmpResult[0].CCTN_CODIGO);
                    }
                    else
                    {
                        cbxCpais_nombre_res_anterior.setValue(tmpResult[0].CPAIS_CODIGO);
                        var rProvinciaAnterior=SCGG_PAIS.getAt(SCGG_PAIS.findExact('CPAIS_CODIGO',tmpResult[0].CPAIS_CODIGO)).json;
                        stCrprv_residencia_anterior.loadData(rProvinciaAnterior.PROVINCIAS,true);

                        cbxCgprv_nombre_res_anterior.setValue(tmpResult[0].CGPRV_CODIGO);
                        var rCantonAnterior=stCrprv_residencia_anterior.getAt(stCrprv_residencia_anterior.findExact('CGPRV_CODIGO',tmpResult[0].CGPRV_CODIGO)).json;
                        stCctn_residencia_anterior.loadData(rCantonAnterior.CANTONES,true);

                        cbxCctn_nombre_res_anterior.setValue(tmpResult[0].CCTN_CODIGO);

                    }
                }

            }
            var param = new SOAPClientParameters();
            param.add('inCctn_nombre',INCCTN_CODIGO);
            param.add('format',TypeFormat.JSON);
            SOAPClient.invoke(URL_WS+"Cgg_canton",'selectUp',param, true, CallBackCgg_res_canton);
        }catch(inErr){

        }
    }
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_notificacion_finan.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_res_personaCtrls(inEstado){
        estado=!inEstado;
        txtCrper_codigo.setDisabled(estado);
        cbxCrecv_codigo.setDisabled(estado);
        cbxCrdid_codigo.setDisabled(estado);
        cbxCrtsg_codigo.setDisabled(estado);
        cbxCgncn_codigo.setDisabled(estado);
        cbxCprr_codigo.setDisabled(estado);
        cbxCctn_nombre_residencia.setDisabled(estado);
        cbxCctn_nombre_res_anterior.setDisabled(estado);
        txtCrper_nombres.setDisabled(estado);
        txtCrper_apellido_paterno.setDisabled(estado);
        txtCrper_apellido_materno.setDisabled(estado);
        txtCrper_num_doc_identific.setDisabled(estado);
        dtCrper_fecha_nacimiento.setDisabled(estado);
        txtCrper_lugar_nacimiento.setDisabled(estado);
        numCrper_genero.setDisabled(estado);
        txtCrper_observaciones.setDisabled(estado);
        txtCrper_numero_residencia.setDisabled(estado);
        //chkCrper_autorizado.setDisabled(estado);
        txtCrper_numero_expediente.setDisabled(estado);
        dtCrper_fecha_archivo.setDisabled(estado);
        chkCrper_empleado.setDisabled(estado);
        dtCrper_fecha_ultimo_empleo.setDisabled(estado);
        numCrper_aspiracion_salarial.setDisabled(estado);
        //chkCrper_cupo_vehicular.setDisabled(estado);
        //cbxCrper_tipo_persona.setDisabled(estado);
        chkCrper_estado_interfecto.setDisabled(estado);
        dtCrper_fecha_defuncion.setDisabled(estado);
        txtCrper_numero_acta.setDisabled(estado);
        numCrper_tipo.setDisabled(estado);
        chkCrper_atencion_cliente.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_notificacion_finan.
     */
    function cargarCgg_res_personaCtrls(){
        if(inRecordCgg_res_persona){
            txtCrper_codigo.setValue(inRecordCgg_res_persona.get('CRPER_CODIGO'));
            //  cbxCrecv_codigo.setValue(inRecordCgg_res_persona.get('CRECV_CODIGO'));
            //  cbxCrdid_codigo.setValue(inRecordCgg_res_persona.get('CRDID_CODIGO'));
            // cbxCrtsg_codigo.setValue(inRecordCgg_res_persona.get('CRTSG_CODIGO'));
            //cbxCgncn_codigo.setValue(inRecordCgg_res_persona.get('CGNCN_CODIGO'));
            cbxCprr_codigo.setValue(inRecordCgg_res_persona.get('CPRR_CODIGO'));
            // cbxCctn_nombre_residencia.setValue(inRecordCgg_res_persona.get('CCTN_CODIGO'));
            //cbxCctn_nombre_res_anterior.setValue(inRecordCgg_res_persona.get('CGG_CCTN_CODIGO'));
            txtCrper_nombres.setValue(inRecordCgg_res_persona.get('CRPER_NOMBRES'));
            txtCrper_apellido_paterno.setValue(inRecordCgg_res_persona.get('CRPER_APELLIDO_PATERNO'));
            txtCrper_apellido_materno.setValue(inRecordCgg_res_persona.get('CRPER_APELLIDO_MATERNO'));
            txtCrper_num_doc_identific.setValue(inRecordCgg_res_persona.get('CRPER_NUM_DOC_IDENTIFIC'));
            //dtCrper_fecha_nacimiento.format='Y/m/d';
            dtCrper_fecha_nacimiento.setValue(inRecordCgg_res_persona.get('CRPER_FECHA_NACIMIENTO')?formatShortDate(inRecordCgg_res_persona.get('CRPER_FECHA_NACIMIENTO')):null);
            txtCrper_lugar_nacimiento.setValue(inRecordCgg_res_persona.get('CRPER_LUGAR_NACIMIENTO'));
            //numCrper_genero.setValue(inRecordCgg_res_persona.get('CRPER_GENERO'));
            rdgCCrper_genero.setValue('rdgCCrper_genero',inRecordCgg_res_persona.get('CRPER_GENERO'));
            txtCrper_observaciones.setValue(inRecordCgg_res_persona.get('CRPER_OBSERVACIONES'));
            txtCrper_numero_residencia.setValue(inRecordCgg_res_persona.get('CRPER_NUMERO_RESIDENCIA'));
            chkCrper_autorizado.setValue(inRecordCgg_res_persona.get('CRPER_AUTORIZADO'));
            txtCrper_numero_expediente.setValue(inRecordCgg_res_persona.get('CRPER_NUMERO_EXPEDIENTE'));
            dtCrper_fecha_archivo.setValue(inRecordCgg_res_persona.get('CRPER_FECHA_ARCHIVO')?formatShortDate(inRecordCgg_res_persona.get('CRPER_FECHA_ARCHIVO')):null);
            chkCrper_empleado.setValue(inRecordCgg_res_persona.get('CRPER_EMPLEADO'));
            dtCrper_fecha_ultimo_empleo.setValue(inRecordCgg_res_persona.get('CRPER_FECHA_ULTIMO_EMPLEO')?formatShortDate(inRecordCgg_res_persona.get('CRPER_FECHA_ULTIMO_EMPLEO')):null);
            numCrper_aspiracion_salarial.setValue(inRecordCgg_res_persona.get('CRPER_ASPIRACION_SALARIAL'));
            chkCrper_cupo_vehicular.setValue(inRecordCgg_res_persona.get('CRPER_CUPO_VEHICULAR'));
            cbxCrper_tipo_persona.setValue(inRecordCgg_res_persona.get('CRPER_TIPO_PERSONA'));
            /*chkCrper_estado_interfecto.setValue(inRecordCgg_res_persona.get('CRPER_ESTADO_INTERFECTO'));
             dtCrper_fecha_defuncion.setValue(inRecordCgg_res_persona.get('CRPER_FECHA_DEFUNCION')?formatShortDate(inRecordCgg_res_persona.get('CRPER_FECHA_DEFUNCION')):null);
             txtCrper_numero_acta.setValue(inRecordCgg_res_persona.get('CRPER_NUMERO_ACTA'));*/
            numCrper_tipo.setValue(inRecordCgg_res_persona.get('CRPER_TIPO'));
            chkCrper_atencion_cliente.setValue(inRecordCgg_res_persona.get('CRPER_ATENCION_CLIENTE'));
            isEdit = true;
            habilitarCgg_res_personaCtrls(true);
            gsCgg_gem_perfil_prof.reload({
                params:{
                    inCrper_codigo:inRecordCgg_res_persona.get('CRPER_CODIGO'),
                    format:TypeFormat.JSON
                }
            });
            gsCgg_res_persona_contacto.reload({
                params:{
                    inCrper_codigo:inRecordCgg_res_persona.get('CRPER_CODIGO'),
                    format:TypeFormat.JSON
                }
            });
            gsCgg_res_ocupacion_laboral.reload({
                params:{
                    inCrper_codigo:inRecordCgg_res_persona.get('CRPER_CODIGO'),
                    format:TypeFormat.JSON
                }
            });

            if(inRecordCgg_res_persona.get('CRPER_LUGAR_NACIMIENTO'))
            {
                consultarDivisonPolitica(inRecordCgg_res_persona.get('CRPER_LUGAR_NACIMIENTO'),TypeCiudadPersona.NACIMIENTO);
            }
            else
            {
                cbxCpais_nombre_nacimiento.setValue(inRecordCgg_res_persona.get('CPAIS_CODIGO'));
            }
            if(inRecordCgg_res_persona.get('CCTN_CODIGO'))
            {
                consultarDivisonPolitica(inRecordCgg_res_persona.get('CCTN_CODIGO'),TypeCiudadPersona.RESIDENCIA);
            }
            else
            {
                cbxCpais_nombre_residencia.setValue(inRecordCgg_res_persona.get('CGG_CPAIS_CODIGO'));
            }
            if(inRecordCgg_res_persona.get('CGG_CCTN_CODIGO'))
            {
                consultarDivisonPolitica(inRecordCgg_res_persona.get('CGG_CCTN_CODIGO'),TypeCiudadPersona.RESIDENCIA_ANTERIOR);
            }
            if(inRecordCgg_res_persona.get('CRPER_ESTADO_INTERFECTO') == true)
            {
                Ext.getCmp('mnRegistroDefuncion').fireEvent('click', Ext.getCmp('mnRegistroDefuncion'));

            }

        }
    }
    /**
     * Funcion que permite consultar informacion de archivos generales correspondientes a la persona
     * */
    function consultarImagen()
    {
        /*var tmpNombreFoto = 'avatar.png';
         var tmpNombreFirma = 'signature.png';
         var tmpNombreHuella = 'fingerprinter.png';*/
        try{
            function CallBackCgg_res_adjuntos(r){
                var tmpArchivosResult =  Ext.util.JSON.decode(r);
                if (tmpArchivosResult[0].CRPER_HUELLA_IMAGEN != undefined && tmpArchivosResult[0].CRPER_HUELLA_IMAGEN && tmpArchivosResult[0].CRPER_HUELLA_IMAGEN.length > 0){
                    var tmpImgCtrlHuella = document.getElementById("imgHuellaPrs");
                    tmpImgCtrlHuella.src = 'data:image/jpg;base64,'+ tmpArchivosResult[0].CRPER_HUELLA_IMAGEN;
                    /*objImageDefault.HUELLA = 'data:image/jpg;base64,'+ tmpResult[0].CRPER_HUELLA_IMAGEN;
                     tplHuella.overwrite(Ext.getCmp('pnlHuella').body,objImageDefault);*/
                }
                if(tmpArchivosResult[0].CRPER_FIRMA != undefined){
                    var tmpFirmaImagen = document.getElementById("imgFirmaPrs");
                    tmpFirmaImagen.src = 'data:image/jpg;base64,'+ tmpArchivosResult[0].CRPER_FIRMA;
                }
                if (tmpArchivosResult[0].CRPER_FOTO != undefined){
                    var tmpFoto = document.getElementById("imgFotoPrs");
                    tmpFoto.src = 'data:image/jpg;base64,'+ tmpArchivosResult[0].CRPER_FOTO;
                }

            }
            var param = new SOAPClientParameters();
            param.add('inCrper_codigo',txtCrper_codigo.getValue());
            param.add('format',TypeFormat.JSON);
            SOAPClient.invoke(urlCgg_res_persona,'selectAdjuntosIdentificacionById',param, true, CallBackCgg_res_adjuntos);
        }catch(inErr){
            Ext.Msg.show({
                title:tituloCgg_res_persona,
                msg: 'La informaci\u00f3n de documentos adjuntos no ha podido ser consultada.',
                buttons: Ext.Msg.OK,
                icon: Ext.MessageBox.ERROR
            });
        }
    }

    /**
     *Valida el numero de cedula.
     */
    function valCedula(){
        var f1 = true;
        if(cbxCrdid_codigo.getValue()=='1'){
            f1 = validarCedula(txtCrper_num_doc_identific.getValue());
            if(f1){
                txtCrper_num_doc_identific.clearInvalid();
            }else{
                txtCrper_num_doc_identific.markInvalid('Establezca un numero de documento correcto, por favor.');
            }
        }
        return f1;
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_notificacion_finan.
     * @returns ventana winFrmCgg_res_notificacion_finan.
     * @base FrmCgg_res_notificacion_finan.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_notificacion_finan;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_notificacion_finan.
     * @base FrmCgg_res_notificacion_finan.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_personaCtrls();
    }

    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_notificacion_finan.
     * @base FrmCgg_res_notificacion_finan.prototype.loadData
     */
    this.loadData1 = function(){
        gsCgg_res_persona.reload({
            params:{
                inCrper_codigo:inRecordCgg_res_persona,
                format:TypeFormat.JSON
            }

        })
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_notificacion_finan desde una instancia.
 */
FrmCgg_res_notificacion_finan.prototype.show = function(){
    this.getWindow().show();
//this.getWindow().consultarImagen();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_notificacion_finan desde una instancia.
 */
FrmCgg_res_notificacion_finan.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_notificacion_finan,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_notificacion_finan.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_notificacion_finan desde una instancia.
 */
FrmCgg_res_notificacion_finan.prototype.loadData = function(){
    this.loadData();
}

/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_notificacion_finan desde una instancia.
 */
FrmCgg_res_notificacion_finan.prototype.loadData1 = function(){
    this.loadData1();
}