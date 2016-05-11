/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_persona.
 * @param {String} INSENTENCIA_CGG_RES_PERSONA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_PERSONA Registro de datos de la tabla Cgg_res_persona.
 * @constructor
 * @base FrmListadoCgg_res_persona
 * @author BMLaurus.
 */
function FrmCgg_res_notificacion_finan(INSENTENCIA_CGG_RES_PERSONA,INRECORD_CGG_RES_PERSONA){
    var inSentenciaCgg_res_persona = INSENTENCIA_CGG_RES_PERSONA;
    var inRecordCgg_res_persona=INRECORD_CGG_RES_PERSONA;
    var urlCgg_res_persona=URL_WS+"Cgg_res_persona";
    var tituloCgg_res_persona='Notificación Financiera';
    var descCgg_res_persona='El formulario permite administrar informaci\u00f3n que se enviará al Área Fianaciera';
    var isEdit = false;
    var tmpEstado = false; //Variable utilizada para determinar si ya se esta visualizando la ventana
    var tmpUserSession = new UserSession();
    var tmpPluginPersona; //Variable utilizada para referenciar informacion capturada desde el plugin
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
            // winFrmCgg_res_persona.getEl().mask('Cargando...', 'x-mask-loading');
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
                    winFrmCgg_res_persona.getEl().unmask();
                }
            }
        }
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
     * Boton que permite cerrar la ventana winFrmCgg_res_persona.
     */
    var btnCerrarCgg_res_persona = new Ext.Button({
        id:'btnCerrarCgg_res_persona',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:TypeTooltip.CERRAR,
        listeners:{
            click:function(){
                winFrmCgg_res_persona.close();
            }
        }
    });

    /**
     * FIN DE LA SECCION
     * */

    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_persona.
     */
    var pnlCgg_res_persona = new Ext.form.FormPanel({
        anchor:'100% 62%',
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
                txtCrper_nombres,cbxCrdid_codigo,
                {
                    xtype:'panel',
                    layout:'column',
                    items:[

                    {
                        columnWidth:.5,
                        layout:'form',
                        items:[txtCrper_numero_residencia,chkCrper_autorizado]
                    }]
                }
                ]
            }]
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
                items :[rdgCCrper_genero,cbxCgncn_codigo]
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
    var winFrmCgg_res_persona = new Ext.Window({
        id:'winFrmCgg_res_persona',
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
        bbar:['->',btnCerrarCgg_res_persona],
        listeners:{
            show:function()
            {
                tmpEstado = true;
            }
        }
    });
    /**
	* Funcion que aplica los privilegios del usuario.
	*/
    applyGrants(winFrmCgg_res_persona.getBottomToolbar());
    /**
     * Funcion que permite cargar los valores de los stores utilizados en el formulario .
     *
     */
    function loadStore()
    {
        gsCgg_res_documento_identificacio.load();
        gsCgg_nacionalidad.load();
        stCpais_nacimiento.loadData(Ext.util.JSON.decode(createJSONObject(SCGG_PAIS)),true);
        stCpais_residencia.loadData(Ext.util.JSON.decode(createJSONObject(SCGG_PAIS)),true);
        stCpais_residencia_anterior.loadData(Ext.util.JSON.decode(createJSONObject(SCGG_PAIS)),true);


    }
    loadStore();

/*    function consultarDivisonPolitica(INCCTN_CODIGO,INTYPE)
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
                }

            }
            var param = new SOAPClientParameters();
            param.add('inCctn_nombre',INCCTN_CODIGO);
            param.add('format',TypeFormat.JSON);
            SOAPClient.invoke(URL_WS+"Cgg_canton",'selectUp',param, true, CallBackCgg_res_canton);
        }catch(inErr){

        }
    }*/
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_persona.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_res_personaCtrls(inEstado){
        estado=!inEstado;
        txtCrper_codigo.setDisabled(estado);
        cbxCrdid_codigo.setDisabled(estado);
        cbxCgncn_codigo.setDisabled(estado);
        cbxCprr_codigo.setDisabled(estado);
        cbxCctn_nombre_residencia.setDisabled(estado);
        txtCrper_nombres.setDisabled(estado);
        txtCrper_apellido_paterno.setDisabled(estado);
        txtCrper_apellido_materno.setDisabled(estado);
        txtCrper_num_doc_identific.setDisabled(estado);
        numCrper_genero.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_persona.
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
            //numCrper_genero.setValue(inRecordCgg_res_persona.get('CRPER_GENERO'));
            rdgCCrper_genero.setValue('rdgCCrper_genero',inRecordCgg_res_persona.get('CRPER_GENERO'));
            isEdit = true;
            habilitarCgg_res_personaCtrls(true);


                cbxCpais_nombre_nacimiento.setValue(inRecordCgg_res_persona.get('CPAIS_CODIGO'));


                cbxCpais_nombre_residencia.setValue(inRecordCgg_res_persona.get('CGG_CPAIS_CODIGO'));


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
     * Funcion miembro que devuelve la ventana winFrmCgg_res_persona.
     * @returns ventana winFrmCgg_res_persona.
     * @base FrmCgg_res_notificacion_finan.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_persona;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_persona.
     * @base FrmCgg_res_notificacion_finan.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_personaCtrls();
    }

    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_persona.
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
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_persona desde una instancia.
 */
FrmCgg_res_notificacion_finan.prototype.show = function(){
    this.getWindow().show();
//this.getWindow().consultarImagen();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_persona desde una instancia.
 */
FrmCgg_res_notificacion_finan.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_persona,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_notificacion_finan.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_persona desde una instancia.
 */
FrmCgg_res_notificacion_finan.prototype.loadData = function(){
    this.loadData();
}

/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_persona desde una instancia.
 */
FrmCgg_res_notificacion_finan.prototype.loadData1 = function(){
    this.loadData1();
}