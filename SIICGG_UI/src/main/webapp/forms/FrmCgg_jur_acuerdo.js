/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_jur_acuerdo.
 * @param {String} IN_SENTENCIA_CGG_JUR_ACUERDO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_JUR_ACUERDO Registro de datos de la tabla Cgg_jur_acuerdo.
 * @constructor
 * @base FrmListadoCgg_jur_acuerdo
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_jur_acuerdo(IN_SENTENCIA_CGG_JUR_ACUERDO,IN_RECORD_CGG_JUR_ACUERDO){
    var inSentenciaCgg_jur_acuerdo = IN_SENTENCIA_CGG_JUR_ACUERDO;
    var inRecordCgg_jur_acuerdo=IN_RECORD_CGG_JUR_ACUERDO;
    var urlCgg_jur_acuerdo=URL_WS+"Cgg_jur_acuerdo";
    var tituloCgg_jur_acuerdo='Acuerdo: Contrato - Convenio';
    var descCgg_jur_acuerdo='El formulario permite administrar la informaci\u00f3n de Acuerdo: Contrato - Convenio';
    var isEdit = false;
    var tmpCrpjr_codigo;
    var tmpCrper_codigo;
    var tmpCjtpr_codigo;
    var tmpCsctp_codigo;
    var tmpCainf_codigo;
    var tmpCjacu_tipo;
    var lisEliAdjuntos1 = new Array ();
    var tmpListadoEliminar1;
    var tmpCgg_cusu_codigo;

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ACUERDO DE CONTRATO O CONVENIO
     */
    var txtCjacu_codigo = new Ext.form.TextField({
        id:'txtCjacu_codigo',
        name:'txtCjacu_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * new Ext.form.RadioGroup IDENTIFICATIVO  PARA LA PRESENTACION DE TIPOS DE PERSONAS
     */
    var rdgCjpjuTipo_persona = new Ext.form.RadioGroup({
        anchor:'98%',
        //columns: 2, //display the radiobuttons in two columns
        items: [
            {boxLabel: 'Natural', name: 'rdgCjpjuTipo_natural', id:'idPersonaNatural' ,  checked: true, inputValue: TypeAdversario.PERSONA_NATURAL},
            {boxLabel: 'Juridica', name: 'rdgCjpjuTipo_natural', id:'idPersonaJuridica' , inputValue: TypeAdversario.PERSONA_JURIDICA}
        ],
        listeners:{
            change: function(group,radio)
            {
                if (radio.getItemId()=='idPersonaNatural')
                {
                    pnlPersonaNatural.setVisible(true);
                    pnlPersonaJuridica1.setVisible(false);

                }else{
                    pnlPersonaJuridica1.setVisible(true);
                    pnlPersonaNatural.setVisible(false);
                }

            }
        }
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA CON QUIEN SE CELEBRA EL ACUERDO
     */
    var txtCrpjr_codigo = new Ext.form.TextField({
        id:'txtCrpjr_codigo',
        name:'txtCrpjr_codigo',
        fieldLabel :'Jur\u00eddica',
        width:250,
        readOnly:'true'

    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA CON QUIEN SE CELEBRA EL ACUERDO
     */
    var btnCrpjr_codigoCgg_jur_acuerdo = new Ext.Button({
        id:'btnCrpjr_codigoCgg_jur_acuerdo',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_res_persona_juridica = new FrmListadoCgg_res_persona_juridica();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona_juridica.getStore(),tmpFLCgg_res_persona_juridica.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpCrpjr_codigo=(tmpRecord.get('CRPJR_CODIGO'));
                        txtCrpjr_codigo.setValue(tmpRecord.get('CRPJR_RAZON_SOCIAL'))

                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA CON QUIEN SE CELEBRA EL ACUERDO
     */
    var txtCrper_codigo = new Ext.form.TextField({
        id:'txtCrper_codigo',
        name:'txtCrper_codigo',
        fieldLabel :'Natural',
        width:250,
        readOnly:'true'
    });
    /**
     * CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA CON QUIEN SE CELEBRA EL ACUERDO
     */
    var btnCrper_codigoCgg_jur_acuerdo = new Ext.Button({
        id:'btnCrper_codigoCgg_jur_acuerdo',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_res_persona = new Persona();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona.getStore(),tmpFLCgg_res_persona.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpCrper_codigo=(tmpRecord.get('CRPER_CODIGO'));
                        txtCrper_codigo.setValue(tmpRecord.get('CRPER_NOMBRES')+" "+tmpRecord.get('CRPER_APELLIDO_PATERNO'));
                    }
                });
                objBusqueda.show();
            }}
    });
    function UsuarioInterno(){
        /**
         * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_usuario.
         */
        var chkUsuarioInterno1 = new Ext.grid.CheckColumn(
        {
            dataIndex:'CUSU_USUARIO_INTERNO',
            header:'Usuario interno',
            width:150,
            sortable:true
        }
                );
        var chkCaducaClave1 = new Ext.grid.CheckColumn(
        {
            dataIndex:'CUSU_CADUCA_CLAVE',
            header:'Caduca clave',
            width:150,
            sortable:true
        }
                );
        var chkCusu_activo1 = new Ext.grid.CheckColumn(
        {
            dataIndex:'CUSU_ACTIVO',
            header:'Activo',
            width:150,
            sortable:true
        });
        var cmCgg_usuario_interno = new Ext.grid.ColumnModel([
            {dataIndex:'CRPER_NOMBRES',header:'Nombres',width:150,sortable:true},
            {dataIndex:'APELLIDOS',header:'Apellidos',width:150,sortable:true},
            {dataIndex:'CISLA_NOMBRE',header:'Isla',width:150,sortable:true},
            {dataIndex:'CRPJR_RAZON_SOCIAL',header:'Empresa',width:150,sortable:true},
            {dataIndex:'CUSU_NOMBRE_USUARIO',header:'Nombre usuario',width:150,sortable:true},
            {dataIndex:'CUSU_CLAVE_ACCESO',header:'Clave acceso',width:150,sortable:true,hideable:false,hidden:true},
            chkUsuarioInterno1,
            chkCaducaClave1,
            chkCusu_activo1
        ]);
        /**
         * Ext.data.Store Agrupacion de registros de la tabla Cgg_usuario por un campo especifico.
         */
        var gsCgg_usuario_interno = new Ext.data.Store({
            proxy:new Ext.ux.bsx.SoapProxy({
                url:URL_WS+"Cgg_jur_acuerdo",
                method:"selectPageUsuarioInterno",
                pagin:true
            }),
            remoteSort:true,
            reader:new Ext.data.JsonReader({
                id:'CUSU_CODIGO',
                root:'dataSet',
                totalProperty: 'totalCount'
            },[
                {name:'CUSU_CODIGO'},
                {name:'CRCRG_CODIGO'},
                {name:'CRCRG_NOMBRE'},
                {name:'CRPER_CODIGO'},
                {name:'CRPER_NOMBRES'},
                {name:'APELLIDOS'},
                {name:'CRPER_NUM_DOC_IDENTIFIC'},
                {name:'CRPJR_CODIGO'},
                {name:'CRPJR_RAZON_SOCIAL'},
                {name:'CTAGV_CODIGO'},
                {name:'CTAGV_NOMBRE'},
                {name:'CCTN_CODIGO'},
                {name:'CCTN_NOMBRE'},
                {name:'CUSU_NOMBRE_USUARIO'},
                {name:'CUSU_CLAVE_ACCESO'},
                {name:'CUSU_USUARIO_INTERNO'},
                {name:'CUSU_CADUCA_CLAVE'},
                {name:'CUSU_ACTIVO'},
                {name:'CUSU_CAMBIAR_CLAVE'},
                {name:'VIGENCIA'},
                {name:'TRANSCURRIDO'},
                {name:'CISLA_CODIGO'},
                {name:'CISLA_NOMBRE'}
            ]),
            sortInfo:{
                field: 'CUSU_NOMBRE_USUARIO',
                direction: 'ASC'
            },
            baseParams:{
                keyword:"",
                format:"JSON"
            }
        });
        this.getColumn = function() {
            return cmCgg_usuario_interno;
        };

        this.getStore = function() {
            return gsCgg_usuario_interno;
        }
    }
    UsuarioInterno.prototype.getColumnModel = function() {
        return this.getColumn();
    };

    UsuarioInterno.prototype.getStore = function() {
        return this.getStore();
    };
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO REPRESENTANTE LEGAL CGG
     */
    var txtCgg_cusu_codigo = new Ext.form.TextField({
        id:'txtCgg_cusu_codigo',
        name:'txtCgg_cusu_codigo',
        fieldLabel :'Responsable',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO REPRESENTANTE LEGAL CGG
     */
    var btnCgg_cusu_codigoCgg_jur_acuerdo = new Ext.Button({
        id:'btnCgg_cusu_codigoCgg_jur_acuerdo',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_usuario = new UsuarioInterno();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_usuario.getStore(),tmpFLCgg_usuario.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpCgg_cusu_codigo=tmpRecord.get('CUSU_CODIGO');
                        txtCgg_cusu_codigo.setValue(tmpRecord.get('CRPER_NOMBRES')+" "+tmpRecord.get('APELLIDOS'));
                    }
                });
                objBusqueda.show();
            }}
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
     */
    var gsCgg_sector_productivo = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_sector_productivo",
            method:"selectAll"
        }),
        reader:new Ext.data.JsonReader({},[
            {name:'CSCTP_CODIGO'},
            {name:'CGG_CSCTP_CODIGO'},
            {name:'CSCTP_NOMBRE'},
            {name:'CSCTP_DESCRIPCION'}
        ]),
        baseParams:{
            format:"JSON"
        }
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PROCESO DE CONTRATACION
     */
    var cbxCsctp_codigo = new Ext.form.ComboBox({
        id:'cbxCsctp_codigo',
        fieldLabel :'Sec. Productivo',
        displayField:'CSCTP_NOMBRE',
        store:gsCgg_sector_productivo,
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione el Tipo de Sector',
        selectOnFocus:true,
        valueField:'CSCTP_CODIGO',
        anchor:'98%'
    });
    gsCgg_sector_productivo.load();
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_jur_tipo_proceso por un campo especifico.
     */
    var gsCgg_jur_tipo_proceso = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_jur_tipo_proceso",
            method:"selectAll"
        }),
        reader:new Ext.data.JsonReader({},[
            {name:'CJTPR_CODIGO'},
            {name:'CJTPR_NOMBRE'},
            {name:'CJTPR_DESCRIPCION'},
            {name:'CJTPR_TIPO'}
        ]),
        baseParams:{
            format:"JSON"
        }
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PROCESO DE CONTRATACION
     */
    var cbxCjtpr_codigo = new Ext.form.ComboBox({
        id:'cbxCjtpr_codigo',
        fieldLabel :'Acuerdo',
        displayField:'CJTPR_NOMBRE',
        store:gsCgg_jur_tipo_proceso,
        typeAhead: true,
        mode: 'local',
        // forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione el Tipo de Acuerdo',
        selectOnFocus:true,
        valueField:'CJTPR_CODIGO',
        anchor:'98%',
        listeners:{
            select :function( inComboBox, inRecord, inNumber) {
                if (gsCgg_jur_tipo_proceso.getAt(inNumber).get('CJTPR_TIPO')==0){
                    tmpCjacu_tipo= gsCgg_jur_tipo_proceso.getAt(inNumber).get('CJTPR_TIPO');
                    numCjacu_tipo.setValue("CONTRATO");
                    generarNumeroConvenio();
                }else{
                    tmpCjacu_tipo= gsCgg_jur_tipo_proceso.getAt(inNumber).get('CJTPR_TIPO');
                    numCjacu_tipo.setValue("CONVENIO");
                    generarNumeroContrato();
                }


            }
        }
    });
    gsCgg_jur_tipo_proceso.load();
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE AREA DE INFLUENCIA
     */
    var gsCainf_area_influencia = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_area_influencia",
            method:"selectAll"
        }),
        reader:new Ext.data.JsonReader({},[
            {name:'CAINF_CODIGO'},
            {name:'CAINF_NOMBRE'},
            {name:'CAINF_DESCRIPCION'}
        ]),
        baseParams:{
            format:"JSON"
        }

    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PROCESO DE CONTRATACION
     */
    var cbxCainf_codigo= new Ext.form.ComboBox({
        id:'cbxCainf_codigo',
        fieldLabel :'\u00c1rea Influencia',
        displayField:'CAINF_NOMBRE',
        store:gsCainf_area_influencia,
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione el Area Influencia',
        selectOnFocus:true,
        valueField:'CAINF_CODIGO',
        anchor:'98%'

    });
    gsCainf_area_influencia.load();
    /**
     * Ext.form.NumberField ANIO EN EL QUE SE REALIZA EL ACUERDO
     */
    var numCjacu_anio = new Ext.form.NumberField({
        id:'numCjacu_anio',
        name:'numCjacu_anio',
        fieldLabel :'A\u00f1o',
        allowBlank :false,
        disabled :false

    });
    /**
     * Funcion que permite cargar el  codigo del documento generado
     */
    function generarAnio(){
        numCjacu_anio.setValue(parseInt(new Date().getFullYear()));
    }
    generarAnio();
    /**
     * Ext.form.TextField NUMERO SECUENCIAL UNICO DEL ACUERDO
     */
    var txtCjacu_numero = new Ext.form.TextField({
        id:'txtCjacu_numero',
        name:'txtCjacu_numero',
        fieldLabel :'N\u00famero',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Ext.form.TextArea OBJETO O MOTIVO DEL ACUERDO
     */
    var txtCjacu_objeto = new Ext.form.TextArea({
        id:'txtCjacu_objeto',
        name:'txtCjacu_objeto',
        fieldLabel :'Objeto',
        width:'98%',
        allowBlank :false,
        labelWidth :70
    });
    /**
     * Ext.form.TextArea DESCRIPCION DEL ACUERDO
     */
    var txtCjacu_descripcion = new Ext.form.TextArea({
        id:'txtCjacu_descripcion',
        name:'txtCjacu_descripcion',
        fieldLabel :'Descripci\u00f3n',
        width:'90%'
    });
    /**
     * Ext.form.TextField LUGAR DONDE SE EJECUTARA EL ACUERDO O AMBITO GEOGRAFICO DEL ACUERDO
     */
    var txtCjacu_jurisdiccion_ambito = new Ext.form.TextField({
        id:'txtCjacu_jurisdiccion_ambito',
        name:'txtCjacu_jurisdiccion_ambito',
        fieldLabel :'\u00c1mbito',
        anchor:'98%'

    });
    /**
     * Ext.form.DateField FECHA DE SUSCRIPCION O FIRMA DEL ACUERDO
     */
    var dtCjacu_fecha_suscripcion = new Ext.form.DateField({
        id:'dtCjacu_fecha_suscripcion',
        name:'dtCjacu_fecha_suscripcion',
        fieldLabel :'Suscripci\u00f3n',
        format :'d/m/Y',
      // minValue:new Date(),
        value:new Date()
    });
    /**
     * Ext.form.TextArea INSTITUCIONES QUE FIRMARON EN EL ACUERDO EN FORMATO JSON YA QUE SON UNA O VARIAS
     */
    var txtCjacu_institucion_firma = new Ext.form.TextArea({
        id:'txtCjacu_institucion_firma',
        name:'txtCjacu_institucion_firma',
        fieldLabel :'Instituci\u00f3n',
        width:'98%'

    });
    /**
     * Ext.form.DateField FECHA DE INICIO DEL ACUERDO
     */
    var dtCjacu_fecha_inicio = new Ext.form.DateField({
        id:'dtCjacu_fecha_inicio',
        name:'dtCjacu_fecha_inicio',
        fieldLabel :'Inicio',
        format :'d/m/Y',
       // minValue:new Date(),
        value:new Date()
    });
    /**
     * Ext.form.TextField PERSONA ENCARGADA DE LA SUPERVISION DEL ACUERDO
     */
    var txtCjacu_responsable = new Ext.form.TextField({
        id:'txtCjacu_responsable',
        name:'txtCjacu_responsable',
        fieldLabel :'Responsable',
        anchor:'98%',
        readOnly:true


    });
    /**
     * Ext.form.TextField NUMERO DE PARTIDA PRESUPUESTARIA QUE RESPALDA EL CONVENIO
     */
    var txtCjacu_partida_presupuestaria = new Ext.form.TextField({
        id:'txtCjacu_partida_presupuestaria',
        name:'txtCjacu_partida_presupuestaria',
        fieldLabel :'Partida presupuestaria',
        anchor:'98%'

    });
    /**
     * Ext.form.NumberField COSTO ASIGNADO PARA LA EJECUCION DEL ACUERDO
     */
    var numCjacu_costo =new Ext.ux.form.SpinnerField({
        id:'numCjacu_costo',
        name:'numCjacu_costo',
        fieldLabel :'Costo',
        disabled :false,
        allowBlank :false,
        value:0
    });
    /**
     * Ext.ux.form.SpinnerField TIEMPO DE DURACION DEL ACUERDO EN DIAS
     */
    var numCjacu_tiempo = new Ext.ux.form.SpinnerField({
        id:'numCjacu_tiempo',
        name:'numCjacu_tiempo',
        fieldLabel :'Tiempo (d\u00EDas)',
        disabled :false,
        allowBlank :false,
        value:0
    });
    /**
     * Ext.form.NumberField ESTADO DE LA EJECUCION DEL ACUERDO
     0 - FIRMADO
     1 - EN PROCESO
     2 - FINALIZADO
     3 - SUSPENDIDO
     */
    var cbxCjacu_estado_ejecucion = new Ext.form.ComboBox({
        id:'cbxCjacu_estado_ejecucion',
        name:'cbxCjacu_estado_ejecucion',
        store: dsEstadoAcuerdo,
        fieldLabel :'Estado',
        anchor:'98%',
        mode:'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione un Estado'
    });
    /**
     * Ext.form.DateField FECHA DE FINALIZACION DEL ACUERDO
     */
    var dtCjacu_fecha_finalizacion = new Ext.form.DateField({
        id:'dtCjacu_fecha_finalizacion',
        name:'dtCjacu_fecha_finalizacion',
        fieldLabel :'Finalizaci\u00f3n',
        format :'d/m/Y',
        value:new Date()/*,
        minValue:new Date()*/
    });
    /**
     * Ext.form.TextArea OBSERVACIONES DEL ACUERDO - HISTORIAL JSON
     */
    var txtCjacu_observacion = new Ext.form.TextArea({
        id:'txtCjacu_observacion',
        name:'txtCjacu_observacion',
        fieldLabel :'Observaci\u00f3n',
        width:'90%'

    });
    /**
     * Ext.form.NumberField TIPO DE ACUERDO
     0 - CONVENIO
     1 - CONTRATO
     */
    var numCjacu_tipo = new Ext.form.TextField({
        id:'numCjacu_tipo',
        name:'numCjacu_tipo',
        fieldLabel :'Tipo',
        disabled :false,
        anchor:'98%',
        readOnly:true
    });

    /**
     * Ext.form.Checkbox INDICA SI EL ACUERDO TIENE UN ADENDUM
     */
    var chkCjacu_adendum = new Ext.form.Checkbox({
        id:'chkCjacu_adendum',
        name:'chkCjacu_adendum',
        fieldLabel :'Adendum',
        checked:false,
        listeners:{
            check :function (inCheckbox,inchecked ){
                if (inchecked== true){
                    txtCjacu_objeto_adendum.enable();
                    dtCjacu_fecha_adendum.enable();
                } else{
                    txtCjacu_objeto_adendum.setDisabled(true);
                    dtCjacu_fecha_adendum.setDisabled(true);
                }
            }
        }
    });


    /**
     * Ext.form.DateField FECHA DEL ADENDUM
     */
    var dtCjacu_fecha_adendum = new Ext.form.DateField({
        id:'dtCjacu_fecha_adendum',
        name:'dtCjacu_fecha_adendum',
        fieldLabel :'Fecha',
        format :'d/m/Y',
        value:new Date(),
        //minValue:new Date(),
        disabled:true
    });
    /**
     * Ext.form.TextArea OBJETO DEL ADENDEUM
     */
    var txtCjacu_objeto_adendum = new Ext.form.TextArea({
        id:'txtCjacu_objeto_adendum',
        name:'txtCjacu_objeto_adendum',
        fieldLabel :'Objeto',
        width:'90%',
        labelWidth :70,
        disabled:true
    });
    /**
     * Ext.form.TextField DESCRIP`CION DEL ARCHIVO ADJUNTO
     */
    var txtCjada_descripcion = new Ext.form.TextField({
        id:'txtCjada_descripcion',
        name:'txtCjada_descripci\u00f3n',
        anchor:'98%',
        allowBlank :false
    });
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * Ext.ux.grid.RowEditor Edito de filas personalizado para utilizaci?n en el grid de contacto
     */

    var cmAdj_historial_acuerdo = new Ext.grid.ColumnModel([
        {dataIndex:'CJADA_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:true},
        {dataIndex:'CJACU_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:true},
        {dataIndex:'CJADA_NOMBRE_ADJUNTO',header:'Nombre adjunto',width:150,sortable:true},
        {dataIndex:'CJADA_DESCRIPCION',header:'Descripcion',width:150,sortable:true,editor:txtCjada_descripcion},
        {dataIndex:'CRATE_DATA',header:'CRATE_DATA',width:150,sortable:true,hidden:true,hideable:true}
    ]);

    /*
     * Ext.ux.grid.RowEditor Edito de filas personalizado para utilizaci?n en el grid de Adjunto
     */
    var reAdjunto = new Ext.ux.grid.RowEditor({
        saveText: 'Aceptar',
        cancelText:'Cancelar'
    });
    reAdjunto.stopMonitoring();


    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_adjunto por un campo especifico.
     */
    var gsAdj_historial_acuerdo = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_jur_adjunto_acuerdo",
            method:"selectAcuerdoAdjunto",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
            id:'CRADJ_CODIGO',
            root:'dataSet'
        },[
            {name:'CJADA_CODIGO'},
            {name:'CJACU_CODIGO'},
            {name:'CJADA_NOMBRE_ADJUNTO'},
            {name:'CJADA_DESCRIPCION'}

        ]),
        baseParams:{
            inCjacu_Codigo:'',
            format:"JSON"
        }
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_adjunto en un formato tabular de filas y columnas.
     */
    var grdCgg_jur_adjunto_acuerdo = new Ext.grid.EditorGridPanel({
        id: 'grdCgg_jur_adjunto_acuerdo',
        height:160,
        cm: cmAdj_historial_acuerdo,
        store:gsAdj_historial_acuerdo,
        sm: new Ext.grid.RowSelectionModel({
            singleSelect: true,
            moveEditorOnEnter: false
        }),
        viewConfig: {
            forceFit: true
        },
        loadMask: {
            msg: "Cargando..."
        },
        trackMouseOver: true,
        tbar: [{
            id: 'btnAgregarAdjuntoAcuerdo',
            iconCls: 'iconNuevo',
            handler: function(){
                var objSubirAdjunto = new FrmCgg_res_adjunto_temporal();
                var rAdjuntoTemporal = grdCgg_jur_adjunto_acuerdo.getSelectionModel().getSelected();;
                objSubirAdjunto.closeHandler(function(){
                    var dialogResult = objSubirAdjunto.dialogResult();
                    if(dialogResult  !== null){
                        var tmpRecordPersona = grdCgg_jur_adjunto_acuerdo.getStore().recordType;
                        reAdjunto.stopEditing();
                        grdCgg_jur_adjunto_acuerdo.getStore().insert(0,
                                new tmpRecordPersona({
                                    'CJADA_CODIGO':'KEYGEN',
                                    'CJADA_NOMBRE_ADJUNTO':dialogResult.CRATE_NOMBRE,
                                    'CJADA_DESCRIPCION':'',
                                    'CRATE_DATA':dialogResult.CRATE_CODIGO
                                })
                                );
                        grdCgg_jur_adjunto_acuerdo.getView().refresh();
                        grdCgg_jur_adjunto_acuerdo.getSelectionModel().selectRow(0);
                        reAdjunto.startEditing(0);
                    }
                });
                objSubirAdjunto.show();

            }

        }, {
            id: 'btnEliminarAdjuntoAcuerdo',
            iconCls: 'iconEliminar',
            handler: function(grid, rowIndex, colIndex) {
                grdCgg_jur_adjunto_acuerdo.getSelectionModel().selectRow(rowIndex);
                var rAdjuntoRequisito = grdCgg_jur_adjunto_acuerdo.getSelectionModel().getSelected();
                lisEliAdjuntos1.push(rAdjuntoRequisito.get('CJADA_CODIGO'));
                tmpListadoEliminar1 = Ext.util.JSON.encode(lisEliAdjuntos1);
                //alert("hola"+tmpListadoEliminar);
                grdCgg_jur_adjunto_acuerdo.getStore().remove(rAdjuntoRequisito);
            }

        },{
            id:'btnVerAdjuntoAcuerdo',
            iconCls:'iconVer',
            listeners:{
                click:function(){
                    var r=grdCgg_jur_adjunto_acuerdo.getSelectionModel().getSelected();
                    if(r){
					if(r.get('CRATE_DATA')){
							window.open(URL_DOC_VIEWER+'?table=cgg_res_adjunto_temporal&keyc=crate_codigo&keyv='+r.get('CRATE_DATA')+'&column=crate_archivo&fn='+r.get('CJADA_NOMBRE_ADJUNTO')+'&request=view');
						}else{
                        window.open(URL_DOC_VIEWER+'?table=cgg_jur_adjunto_acuerdo&keyc=cjada_codigo&keyv='+r.get('CJADA_CODIGO')+'&column=cjada_adjunto&fn='+r.get('CJADA_NOMBRE_ADJUNTO')+'&request=view');}
                }
			}
            }

        },{id:'btnDescargarAdjuntoAcuerdo',
            iconCls:'iconDescargar',
            listeners:{
                click:function(){
                    var r=grdCgg_jur_adjunto_acuerdo.getSelectionModel().getSelected();
                    if(r)
					
                        window.open(URL_DOC_VIEWER+'?table=cgg_jur_adjunto_acuerdo&keyc=cjada_codigo&keyv='+r.get('CJADA_CODIGO')+'&column=cjada_adjunto&fn='+r.get('CJADA_NOMBRE_ADJUNTO')+'&request=download');
                }
            }
        }],
        plugins:[reAdjunto]

    });
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_jur_acuerdo
     */
    var btnGuardarCgg_jur_acuerdo = new Ext.Button({
        id:'btnGuardarCgg_jur_acuerdo',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (!pnlCgg_jur_acuerdo.getForm().isValid()){
                    return;
                }
                try{
                    function CallBackCgg_jur_acuerdo(r){
                        winFrmCgg_jur_acuerdo.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_jur_acuerdo,
                                msg: 'La informaci\u00f3n de Acuerdo ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_jur_acuerdo.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_jur_acuerdo,
                                msg: 'La informaci\u00f3n de Acuerdo no ha podido ser almacenada. '+(r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_jur_acuerdo.getEl().mask('Guardando...', 'x-mask-loading');
                    if(lisEliAdjuntos1.length<=0){
                        tmpListadoEliminar1= '[]';
                    }
                    var param = new SOAPClientParameters();
                    if(isEdit){
                        cbxCainf_codigo.setValue(tmpCainf_codigo);
                        cbxCjtpr_codigo.setValue(tmpCjtpr_codigo);
                        cbxCsctp_codigo.setValue(tmpCsctp_codigo);
                        param.add('inCjacu_codigo',txtCjacu_codigo.getValue());
                        param.add('inCjadja_eliminar',tmpListadoEliminar1 );
                    }
                    param.add('inCrpjr_codigo',tmpCrpjr_codigo?tmpCrpjr_codigo:null);
                    param.add('inCrper_codigo',tmpCrper_codigo?tmpCrper_codigo:null);
                    param.add('inCsctp_codigo',cbxCsctp_codigo.getValue()?cbxCsctp_codigo.getValue():null);
                    param.add('inCjtpr_codigo',cbxCjtpr_codigo.getValue());
                    param.add('inCainf_codigo',cbxCainf_codigo.getValue()?cbxCainf_codigo.getValue():null);
                    param.add('inCgg_cusu_codigo',tmpCgg_cusu_codigo);
                    param.add('inCjacu_anio',numCjacu_anio.getValue());
                    param.add('inCjacu_numero',txtCjacu_numero.getValue());
                    param.add('inCjacu_objeto',txtCjacu_objeto.getValue());
                    param.add('inCjacu_descripcion',txtCjacu_descripcion.getValue());
                    param.add('inCjacu_jurisdiccion_ambito',txtCjacu_jurisdiccion_ambito.getValue());
                    param.add('inCjacu_fecha_suscripcion',dtCjacu_fecha_suscripcion.getValue().format('c'));
                    param.add('inCjacu_institucion_firma',txtCjacu_institucion_firma.getValue());
                    param.add('inCjacu_fecha_inicio',dtCjacu_fecha_inicio.getValue().format('c'));
                    param.add('inCjacu_responsable',txtCjacu_responsable.getValue());
                    param.add('inCjacu_partida_presupuestaria',txtCjacu_partida_presupuestaria.getValue());
                    param.add('inCjacu_costo',numCjacu_costo.getValue());
                    param.add('inCjacu_tiempo',numCjacu_tiempo.getValue());
                    param.add('inCjacu_estado_ejecucion',cbxCjacu_estado_ejecucion.getValue());
                    param.add('inCjacu_fecha_finalizacion',dtCjacu_fecha_finalizacion.getValue().format('c'));
                    param.add('inCjacu_observacion',txtCjacu_observacion.getValue());
                    param.add('inCjacu_tipo',tmpCjacu_tipo);
                    param.add('inCjacu_tipo_persona',rdgCjpjuTipo_persona.getValue().getRawValue());
                    param.add('inCjacu_adendum',chkCjacu_adendum.getValue());
                    param.add('inCjacu_fecha_adendum',dtCjacu_fecha_adendum.getValue().format('c'));
                    param.add('inCjacu_objeto_adendum',txtCjacu_objeto_adendum.getValue());
                    param.add('inCjadj_adjunto',grdCgg_jur_adjunto_acuerdo.getStore().getJsonData());
                    SOAPClient.invoke(urlCgg_jur_acuerdo,IN_SENTENCIA_CGG_JUR_ACUERDO,param, true, CallBackCgg_jur_acuerdo);
                }catch(inErr){
                    winFrmCgg_jur_acuerdo.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_jur_acuerdo.
     */
    var btnCancelarCgg_jur_acuerdo = new Ext.Button({
        id:'btnCancelarCgg_jur_acuerdo',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_jur_acuerdo.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_jur_acuerdo.
     */
    var btnCerrarCgg_jur_acuerdo = new Ext.Button({
        id:'btnCerrarCgg_jur_acuerdo',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_jur_acuerdo.close();
            }}
    });
    /**
     * new Ext.Panel Panel para la organizacion de la Persona Juridica
     */
    var pnlPersonaJuridica1 = new Ext.Panel({
        id:'pnlPersonaJuridica',
        hidden:true,
        items:[ {xtype:'panel',layout:'column',items:[
            {columnWidth:.58,layout:'form',items:[txtCrpjr_codigo]},
            {columnWidth:.42,layout:'form',items:[btnCrpjr_codigoCgg_jur_acuerdo]}]}
        ]
    });
    /**
     * new Ext.Panel Panel para la organizacion de la Persona Natural
     */
    var pnlPersonaNatural = new Ext.Panel({
        id:'pnlPersonaNatural',

        items:[ {xtype:'panel',layout:'column',items:[
            {columnWidth:.58,layout:'form',items:[txtCrper_codigo]},
            {columnWidth:.42,layout:'form',items:[btnCrper_codigoCgg_jur_acuerdo]}]}
        ]
    });
    /**
     *  new Ext.form.FieldSet para la organizacion de los paneles de pnlPersonaJuridica1 y pnlPersonaNatural
     */
    var pnlfsPersona = new Ext.form.FieldSet({
        id:'pnlfsPersona',
        title:'Persona',
        collapsible:true,
        region:'center',
        labelWidth :60,
        layout:'form',
        items:[ rdgCjpjuTipo_persona,
            pnlPersonaJuridica1,
            pnlPersonaNatural]
    });
    /**
     * new Ext.TabPanel TabPanel para la organizacion de los componentes en Tabs
     */
    var tblOrdenar = new Ext.TabPanel({
        activeTab:0,
        frame:true,
        labelWidth :100,
        region:'center',
        height:170,
        items:[
            {xtype:'panel',title:'Detalle',layout:'form', frame:true,labelWidth :70,
                items:[txtCjacu_descripcion,txtCjacu_observacion]},
            {xtype:'panel',title:'Datos Adicionales', frame:true,layout:'form',
                items:[{xtype:'panel',layout:'column',items:[
                    {columnWidth:.5,layout:'form',items:[cbxCsctp_codigo,cbxCainf_codigo,txtCjacu_jurisdiccion_ambito]},{
                        columnWidth:.5,layout:'form',labelWidth :70,items:[dtCjacu_fecha_suscripcion,dtCjacu_fecha_inicio,dtCjacu_fecha_finalizacion]}]
                },txtCjacu_institucion_firma]},
            {xtype:'panel',title:'Presupuesto', frame:true,layout:'form',
                items:[txtCjacu_partida_presupuestaria,numCjacu_costo,numCjacu_tiempo]},
            {xtype:'panel',title:'Adendum',layout:'form', frame:true,
                items:[chkCjacu_adendum,dtCjacu_fecha_adendum,txtCjacu_objeto_adendum]},
            {xtype:'panel',title:'Adjunto',layout:'form', frame:true,
                items:[grdCgg_jur_adjunto_acuerdo]}

        ]

    });

    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_jur_acuerdo.
     */
    var pnlCgg_jur_acuerdo = new Ext.form.FormPanel({
        frame:true,
        labelWidth :70,
        items:[txtCjacu_codigo,
            {xtype:'panel',layout:'column',labelWidth :70,items:[
                {columnWidth:.5,layout:'form',items:[cbxCjtpr_codigo,txtCjacu_numero]},{
                    columnWidth:.5,layout:'form',items:[numCjacu_tipo,numCjacu_anio]}]},
            pnlfsPersona,
            txtCjacu_objeto,
            {xtype:'panel',layout:'column',labelWidth :70,items:[
                {columnWidth:.6,layout:'form',items:[
                    {xtype:'panel',layout:'column',labelWidth :70,items:[
                        {columnWidth:.92,layout:'form',items:[txtCgg_cusu_codigo]},{
                            columnWidth:.08,layout:'form',items:btnCgg_cusu_codigoCgg_jur_acuerdo}]}

                ]},{ columnWidth:.4,layout:'form',items:[cbxCjacu_estado_ejecucion]}]},
            tblOrdenar]
    });
    /**
     * Funcion que permite cargar el  codigo del contrato generado
     */
    function generarNumeroContrato(){
        function callBackGenerarNumeroContrato(r){
            txtCjacu_numero.setValue(r);
        }
        SOAPClient.invoke(urlCgg_jur_acuerdo,'numeroContrato',false, false, callBackGenerarNumeroContrato);
    }
    /**
     * Funcion que permite cargar el  codigo del convenio generado
     */
    function generarNumeroConvenio(){
        function callBackGenerarNumeroConvenio(r){
            txtCjacu_numero.setValue(r);
        }
        SOAPClient.invoke(urlCgg_jur_acuerdo,'numeroConvenio',false, false, callBackGenerarNumeroConvenio);
    }
    /**
     * Funcion que permite cargar el  codigo del Responsable generado
     */
    function responsableAcuerdo(){
        function callBackResponsableAcuerdo(r){
            txtCjacu_responsable.setValue(r);
        }
        SOAPClient.invoke(URL_WS+"Cgg_jur_proceso_judicial",'responsableJudicial',false, false, callBackResponsableAcuerdo);
    }
    responsableAcuerdo();
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_jur_acuerdo.
     */

    var winFrmCgg_jur_acuerdo = new Ext.Window({
        id:'winFrmCgg_jur_acuerdo',
        title:tituloCgg_jur_acuerdo,
        iconCls:'iconAplicacion',
        width:630,
        minWidth:400,
        maximizable:false,
        modal:true,
        resizable:false,
        minimizable:false,
        constrainHeader:true,
        tbar:getPanelTitulo(tituloCgg_jur_acuerdo,descCgg_jur_acuerdo),
        items:[pnlCgg_jur_acuerdo],
        bbar:[btnGuardarCgg_jur_acuerdo,btnCancelarCgg_jur_acuerdo,'->',btnCerrarCgg_jur_acuerdo]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmCgg_jur_acuerdo.getBottomToolbar());
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_jur_acuerdo.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_jur_acuerdoCtrls(inEstado){
        estado=!inEstado;
        txtCjacu_codigo.setDisabled(estado);
        txtCrpjr_codigo.setDisabled(estado);
        txtCrper_codigo.setDisabled(estado);
        cbxCsctp_codigo.setDisabled(estado);
        cbxCjtpr_codigo.setDisabled(estado);
        cbxCainf_codigo.setDisabled(estado);
        numCjacu_anio.setDisabled(estado);
        txtCjacu_numero.setDisabled(estado);
        txtCjacu_objeto.setDisabled(estado);
        txtCjacu_descripcion.setDisabled(estado);
        txtCjacu_jurisdiccion_ambito.setDisabled(estado);
        dtCjacu_fecha_suscripcion.setDisabled(estado);
        txtCjacu_institucion_firma.setDisabled(estado);
        dtCjacu_fecha_inicio.setDisabled(estado);
        txtCjacu_responsable.setDisabled(estado);
        txtCjacu_partida_presupuestaria.setDisabled(estado);
        numCjacu_costo.setDisabled(estado);
        numCjacu_tiempo.setDisabled(estado);
        cbxCjacu_estado_ejecucion.setDisabled(estado);
        dtCjacu_fecha_finalizacion.setDisabled(estado);
        txtCjacu_observacion.setDisabled(estado);
        numCjacu_tipo.setDisabled(estado);
        chkCjacu_adendum.setDisabled(estado);
        dtCjacu_fecha_adendum.setDisabled(estado);
        txtCjacu_objeto_adendum.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_jur_acuerdo.
     */
    function cargarCgg_jur_acuerdoCtrls(){
        if(inRecordCgg_jur_acuerdo){
            txtCjacu_codigo.setValue(inRecordCgg_jur_acuerdo.get('CJACU_CODIGO'));
            tmpCrpjr_codigo=inRecordCgg_jur_acuerdo.get('CRPJR_CODIGO');
            txtCrpjr_codigo.setValue(inRecordCgg_jur_acuerdo.get('RAZON_SOCIAL'));
            tmpCrper_codigo=inRecordCgg_jur_acuerdo.get('CRPER_CODIGO');
            txtCrper_codigo.setValue(inRecordCgg_jur_acuerdo.get('PERSONA'));
            tmpCsctp_codigo=inRecordCgg_jur_acuerdo.get('CSCTP_CODIGO');
            cbxCsctp_codigo.setValue(inRecordCgg_jur_acuerdo.get('SECTOR_PRODUCTIVO'));
            tmpCjtpr_codigo=inRecordCgg_jur_acuerdo.get('CJTPR_CODIGO');
            cbxCjtpr_codigo.setValue(inRecordCgg_jur_acuerdo.get('NOMBRE_PROCESO'));
            tmpCainf_codigo=inRecordCgg_jur_acuerdo.get('CAINF_CODIGO');
            cbxCainf_codigo.setValue(inRecordCgg_jur_acuerdo.get('AREA'));
            numCjacu_anio.setValue(inRecordCgg_jur_acuerdo.get('CJACU_ANIO'));
            txtCjacu_numero.setValue(inRecordCgg_jur_acuerdo.get('CJACU_NUMERO'));
            txtCjacu_objeto.setValue(inRecordCgg_jur_acuerdo.get('CJACU_OBJETO'));
            txtCjacu_descripcion.setValue(inRecordCgg_jur_acuerdo.get('CJACU_DESCRIPCION'));
            txtCjacu_jurisdiccion_ambito.setValue(inRecordCgg_jur_acuerdo.get('CJACU_JURISDICCION_AMBITO'));
            dtCjacu_fecha_suscripcion.setMinValue(truncDate(inRecordCgg_jur_acuerdo.get('CJACU_FECHA_SUSCRIPCION')));
            dtCjacu_fecha_suscripcion.setValue(truncDate(inRecordCgg_jur_acuerdo.get('CJACU_FECHA_SUSCRIPCION')));
            txtCjacu_institucion_firma.setValue(inRecordCgg_jur_acuerdo.get('CJACU_INSTITUCION_FIRMA'));
            dtCjacu_fecha_inicio.setMinValue(truncDate(inRecordCgg_jur_acuerdo.get('CJACU_FECHA_INICIO')));
            dtCjacu_fecha_inicio.setValue(truncDate(inRecordCgg_jur_acuerdo.get('CJACU_FECHA_INICIO')));
            tmpCgg_cusu_codigo= inRecordCgg_jur_acuerdo.get('CGG_CUSU_CODIGO');
            txtCgg_cusu_codigo.setValue(inRecordCgg_jur_acuerdo.get('RESPONSABLE'));
            txtCjacu_partida_presupuestaria.setValue(inRecordCgg_jur_acuerdo.get('CJACU_PARTIDA_PRESUPUESTARIA'));
            numCjacu_costo.setValue(inRecordCgg_jur_acuerdo.get('CJACU_COSTO'));
            numCjacu_tiempo.setValue(inRecordCgg_jur_acuerdo.get('CJACU_TIEMPO'));
            cbxCjacu_estado_ejecucion.setValue(inRecordCgg_jur_acuerdo.get('CJACU_ESTADO_EJECUCION'));
            dtCjacu_fecha_finalizacion.setMinValue(truncDate(inRecordCgg_jur_acuerdo.get('CJACU_FECHA_FINALIZACION')));
            dtCjacu_fecha_finalizacion.setValue(truncDate(inRecordCgg_jur_acuerdo.get('CJACU_FECHA_FINALIZACION')));
            txtCjacu_observacion.setValue(inRecordCgg_jur_acuerdo.get('CJACU_OBSERVACION'));
            tmpCjacu_tipo=inRecordCgg_jur_acuerdo.get('CJACU_TIPO')
            if (tmpCjacu_tipo==0)
                numCjacu_tipo.setValue("CONTRATO");
            else
                numCjacu_tipo.setValue("CONVENIO");

            rdgCjpjuTipo_persona.setValue('rdgCjpjuTipo_natural',inRecordCgg_jur_acuerdo.get('CJACU_TIPO_PERSONA'));
            chkCjacu_adendum.setValue(inRecordCgg_jur_acuerdo.get('CJACU_ADENDUM'));
            if (chkCjacu_adendum.checked==true){
                txtCjacu_objeto_adendum.enable();
                dtCjacu_fecha_adendum.enable();
            } else{
                txtCjacu_objeto_adendum.setDisabled(true);
                dtCjacu_fecha_adendum.setDisabled(true);
            }
            dtCjacu_fecha_adendum.setMinValue(truncDate(inRecordCgg_jur_acuerdo.get('CJACU_FECHA_ADENDUM')));
            dtCjacu_fecha_adendum.setValue(truncDate(inRecordCgg_jur_acuerdo.get('CJACU_FECHA_ADENDUM')));
            txtCjacu_objeto_adendum.setValue(inRecordCgg_jur_acuerdo.get('CJACU_OBJETO_ADENDUM'));

            if (inRecordCgg_jur_acuerdo.get('CJACU_TIPO_PERSONA') ==0){
                pnlPersonaNatural.setVisible(true);
                pnlPersonaJuridica1.setVisible(false);

            }else{
                pnlPersonaJuridica1.setVisible(true);
                pnlPersonaNatural.setVisible(false);
            }
            gsAdj_historial_acuerdo.reload({
                params:{
                    inCjacu_Codigo:txtCjacu_codigo.getValue(),
                    format:TypeFormat.JSON
                }
            });
            isEdit = true;
            habilitarCgg_jur_acuerdoCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_jur_acuerdo.
     * @returns ventana winFrmCgg_jur_acuerdo.
     * @base FrmCgg_jur_acuerdo.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_jur_acuerdo;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_jur_acuerdo.
     * @base FrmCgg_jur_acuerdo.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_jur_acuerdoCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_jur_acuerdo desde una instancia.
 */
FrmCgg_jur_acuerdo.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_jur_acuerdo desde una instancia.
 */
FrmCgg_jur_acuerdo.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_jur_acuerdo,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_jur_acuerdo.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_jur_acuerdo desde una instancia.
 */
FrmCgg_jur_acuerdo.prototype.loadData = function(){
    this.loadData();
}
