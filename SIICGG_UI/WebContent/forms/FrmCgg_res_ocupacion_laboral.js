/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_ocupacion_laboral.
 * @param {String} INSENTENCIA_CGG_RES_OCUPACION_LABORAL Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_OCUPACION_LABORAL Registro de datos de la tabla Cgg_res_ocupacion_laboral.
 * @constructor
 * @base FrmListadoCgg_res_ocupacion_laboral
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_ocupacion_laboral(INSENTENCIA_CGG_RES_OCUPACION_LABORAL,INRECORD_CGG_RES_OCUPACION_LABORAL){
    var inSentenciaCgg_res_ocupacion_laboral = INSENTENCIA_CGG_RES_OCUPACION_LABORAL;
    var inRecordCgg_res_ocupacion_laboral=INRECORD_CGG_RES_OCUPACION_LABORAL;
    var urlCgg_res_ocupacion_laboral=URL_WS+"Cgg_res_ocupacion_laboral";
    var tituloCgg_res_ocupacion_laboral='Ocupaci\u00f3n laboral';
    var descCgg_res_ocupacion_laboral='El formulario permite administrar informaci\u00f3n de Ocupaci\u00f3n laboral';
    var tmpDatosConfirmados = false; //Variable boolean utilizada para controlar la confirmacion del ingreso o actualización de información
    var isEdit = false;
    var objOcupacionPersona ={
        CROCL_CODIGO:'KEYGEN',
        CRPER_CODIGO:'',
        CGG_CRPER_CODIGO:'',
        CGG_CRPER_NOMBRES:'',
        CGCRG_CODIGO:'',
        CGCRG_NOMBRE:'',
        CSCTP_CODIGO:'',
        CSCTP_NOMBRE:'',
        CRPJR_CODIGO:'',
        CRPJR_RAZON_SOCIAL:'',
        CROCL_TIPO:''
    };


    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE OCUPACION LABORAL
     */
    var txtCrocl_codigo = new Ext.form.TextField({
        id:'txtCrocl_codigo',
        name:'txtCrocl_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA QUE TIENE UNA OCUPACION LABORAL
     */
    var txtCrper_codigo = new Ext.form.TextField({
        id:'txtCrper_codigo',
        name:'txtCrper_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });
    /**
     * CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA QUE TIENE UNA OCUPACION LABORAL
     */
    var btnCrper_codigoCgg_res_ocupacion_laboral = new Ext.Button({
        id:'btnCrper_codigoCgg_res_ocupacion_laboral',
        text:'Crper_codigo',
        iconCls:'iconCrper_codigo',
        listeners:{
            click:function(){
                var tmpFLCgg_res_persona = new FrmListadoCgg_res_persona();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona.getStore(),tmpFLCgg_res_persona.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                        txtCrper_codigo.setValue(tmpRecord.get('CRPER_CODIGO'));
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA QUE ACTUA COMO EMPLEADOR
     */
    var txtCgg_crper_codigo = new Ext.form.TextField({
        id:'txtCgg_crper_codigo',
        name:'txtCgg_crper_codigo',
        fieldLabel :'Crper codigo',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });

    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA QUE ACTUA COMO EMPLEADOR
     */
    var txtCgg_Empleador = new Ext.form.TextField({
        id:'txtCgg_Empleador',
        name:'txtCgg_Empleador',
        fieldLabel :'Empleador',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :200
    });
    /**
     * CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA QUE ACTUA COMO EMPLEADOR
     */
    var btnCgg_crper_codigoCgg_res_ocupacion_laboral = new Ext.Button({
        id:'btnCgg_crper_codigoCgg_res_ocupacion_laboral',
        iconCls:'iconBuscar',
        tooltip:'Buscar empleador',
        listeners:{

            click:function(){
                /*    var tmpFLCgg_res_persona = new FrmListadoCgg_res_persona();
                 var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona.getStore(),tmpFLCgg_res_persona.getColumnModel());
                 objBusqueda.closeHandler(function(){
                 var tmpRecord = objBusqueda.getSelectedRow();
                 if(tmpRecord)
                 txtCgg_crper_codigo.setValue(tmpRecord.get('CGG_CRPER_CODIGO'));
                 });
                 objBusqueda.show();*/


                var objBusqueda =null;
                if(rdgTipoPersona.getValue().getRawValue() == TypeAuspiciante.NATURAL){
                    var objPersona = new Persona();
                    objBusqueda =new DlgBusqueda(objPersona.getStore(), objPersona.getColumnModel());
                    objBusqueda.closeHandler(function(){
                        var tmpRecord = objBusqueda.getSelectedRow();
                        if(tmpRecord!=null && tmpRecord!=undefined)
                        {
                            txtCgg_Empleador.setValue(tmpRecord.get('CRPER_NOMBRES')+" "+tmpRecord.get('CRPER_APELLIDO_PATERNO') +" "+tmpRecord.get('CRPER_APELLIDO_MATERNO'));
                            txtCgg_crper_codigo.setValue(tmpRecord.get('CRPER_CODIGO'));
                            txtCrpjr_codigo.setValue('');
                        }
                    });
                    objBusqueda.show();
                }else{
                    var tmpFLCgg_res_persona_juridica = new FrmListadoCgg_res_persona_juridica();
                    objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona_juridica.getStore(),tmpFLCgg_res_persona_juridica.getColumnModel());
                    objBusqueda.closeHandler(function(){
                        var tmpRecord = objBusqueda.getSelectedRow();
                        if(tmpRecord!=null && tmpRecord!=undefined){
                            txtCgg_Empleador.setValue(tmpRecord.get('CRPJR_RAZON_SOCIAL'));
                            txtCgg_crper_codigo.setValue('');
                            txtCrpjr_codigo.setValue(tmpRecord.get('CRPJR_CODIGO'));

                            //

                        }
                    });
                    objBusqueda.show();
                }
            }}
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
     */
    var txtCgcrg_codigo = new Ext.form.TextField({
        id:'txtCgcrg_codigo',
        name:'txtCgcrg_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
     */
    var txtCgcrg_nombre = new Ext.form.TextField({
        id:'txtCgcrg_nombre',
        name:'txtCgcrg_nombre',
        fieldLabel :'Cargo',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true'
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
     */
    var btnCgcrg_codigoCgg_res_ocupacion_laboral = new Ext.Button({
        id:'btnCgcrg_codigoCgg_res_ocupacion_laboral',
        iconCls:'iconBuscar',
        tooltip:'Buscar cargo',
        listeners:{
            click:function(){
                var tmpFLCgg_gem_cargo = new FrmListadoCgg_gem_cargo();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_gem_cargo.getStore(),tmpFLCgg_gem_cargo.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                    {
                        txtCgcrg_codigo.setValue(tmpRecord.get('CGCRG_CODIGO'));
                        txtCgcrg_nombre.setValue(tmpRecord.get('CGCRG_NOMBRE'));
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
     */
    var txtCsctp_codigo = new Ext.form.TextField({
        id:'txtCsctp_codigo',
        name:'txtCsctp_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
     */
    var txtCsctp_nombre = new Ext.form.TextField({
        id:'txtCsctp_nombre',
        name:'txtCsctp_nombre',
        fieldLabel :'Sector prod.',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true'

    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
     */
    var btnCsctp_codigoCgg_res_ocupacion_laboral = new Ext.Button({
        id:'btnCsctp_codigoCgg_res_ocupacion_laboral',
        iconCls:'iconBuscar',
        tooltip:'Buscar sector productivo',
        listeners:{
            click:function(){
                var tmpFLCgg_sector_productivo = new FrmListadoCgg_sector_productivo();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_sector_productivo.getStore(),tmpFLCgg_sector_productivo.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                    {
                        txtCsctp_codigo.setValue(tmpRecord.get('CSCTP_CODIGO'));
                        txtCsctp_nombre.setValue(tmpRecord.get('CSCTP_NOMBRE'));
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
     */
    var txtCrpjr_codigo = new Ext.form.TextField({
        id:'txtCrpjr_codigo',
        name:'txtCrpjr_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
     */
    var btnCrpjr_codigoCgg_res_ocupacion_laboral = new Ext.Button({
        id:'btnCrpjr_codigoCgg_res_ocupacion_laboral',
        text:'Crpjr_codigo',
        iconCls:'iconCrpjr_codigo',
        listeners:{
            click:function(){
                var tmpFLCgg_res_persona_juridica = new FrmListadoCgg_res_persona_juridica();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona_juridica.getStore(),tmpFLCgg_res_persona_juridica.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                        txtCrpjr_codigo.setValue(tmpRecord.get('CRPJR_CODIGO'));
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.NumberField TIPO DE OCUPACION LABORAL
     0 -  PUBLICA
     1 - PRIVADA
     2 - PROPIA
     3 - OTROS
     */
    /*var numCrocl_tipo = new Ext.form.NumberField({
     id:'numCrocl_tipo',
     name:'numCrocl_tipo',
     fieldLabel :'Tipo',
     allowBlank :false,
     disabled :false
     });*/

    var cbxCrocl_tipo = new Ext.form.ComboBox({
        id:'cbxCrocl_tipo',
        name:'cbxCrocl_tipo',
        fieldLabel :'Tipo ocupacion',
        store: dsTipoOcupacionLaboral,
        anchor:'75%',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        editable: false,
        allowBlank :false,
        triggerAction:'all',
        emptyText : 'Seleccione el ocupacion',
        value:0
    });
    var rdgTipoPersona = new Ext.form.RadioGroup({
        id:'rdgTipoPersona',
        fieldLabel: 'Empleado por',
        itemCls: 'x-check-group-alt',
        items: [
            {
                boxLabel: 'Persona Natural',
                id:'rbPersonaNatural',
                name: 'rbAuspiciante',
                inputValue: TypeAuspiciante.NATURAL,
                checked: true
            },

            {
                boxLabel: 'Empresa',
                id: 'rbEmpresa',
                name: 'rbAuspiciante',
                inputValue: TypeAuspiciante.JURIDICA
            }
        ],
        listeners:{
            change: function(group,radio){
                //txtCrper_codigo.setValue('');
                // txtCrpjr_representante_legal.setValue('');
                if(radio.getRawValue() == TypeAuspiciante.NATURAL)
                {
                    txtCgg_crper_codigo.setValue('');
                    txtCrpjr_codigo.setValue('');
                    txtCgg_Empleador.setValue('');
                }
                else
                {
                    txtCgg_crper_codigo.setValue('');
                    txtCgg_Empleador.setValue('');
                    txtCrpjr_codigo.setValue('');

                }

            }
        }

    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_ocupacion_laboral
     */
    var btnGuardarCgg_res_ocupacion_laboral = new Ext.Button({
        id:'btnGuardarCgg_res_ocupacion_laboral',
        text:'Aceptar',
        iconCls:'iconAceptar',
        listeners:{
            click:function(){
                if (pnlCgg_res_ocupacion_laboral.getForm().isValid()==false){
                    return;
                }
                objOcupacionPersona.CROCL_CODIGO = txtCrocl_codigo.getValue();
                objOcupacionPersona.CRPER_CODIGO = txtCrper_codigo.getValue();
                objOcupacionPersona.CGG_CRPER_CODIGO = txtCgg_crper_codigo.getValue();
                objOcupacionPersona.CGG_CRPER_NOMBRES = txtCgg_crper_codigo.getValue()?txtCgg_Empleador.getValue():null;
                objOcupacionPersona.CGCRG_CODIGO = txtCgcrg_codigo.getValue();
                objOcupacionPersona.CGCRG_NOMBRE = txtCgcrg_nombre.getValue();
                objOcupacionPersona.CSCTP_CODIGO = txtCsctp_codigo.getValue();
                objOcupacionPersona.CSCTP_NOMBRE = txtCsctp_nombre.getValue();
                objOcupacionPersona.CRPJR_CODIGO = txtCrpjr_codigo.getValue();
                objOcupacionPersona.CRPJR_RAZON_SOCIAL =  txtCrpjr_codigo.getValue()?txtCgg_Empleador.getValue():null;
                objOcupacionPersona.CROCL_TIPO = cbxCrocl_tipo.getValue();
                tmpDatosConfirmados =  true;
                winFrmCgg_res_ocupacion_laboral.close();

            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_ocupacion_laboral.
     */
    var btnCancelarCgg_res_ocupacion_laboral = new Ext.Button({
        id:'btnCancelarCgg_res_ocupacion_laboral',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_res_ocupacion_laboral.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_ocupacion_laboral.
     */
    var btnCerrarCgg_res_ocupacion_laboral = new Ext.Button({
        id:'btnCerrarCgg_res_ocupacion_laboral',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_res_ocupacion_laboral.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_ocupacion_laboral.
     */
    var pnlCgg_res_ocupacion_laboral = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCrocl_codigo,
            rdgTipoPersona,
            // {xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCrper_codigo]},{columnWidth:.4,layout:'form',items:[btnCrper_codigoCgg_res_ocupacion_laboral]}]},
            {xtype:'panel',layout:'column',items:[{columnWidth:.9,layout:'form',items:[txtCgg_Empleador]},{columnWidth:.1,layout:'form',items:[btnCgg_crper_codigoCgg_res_ocupacion_laboral]}]},
            {xtype:'panel',layout:'column',items:[{columnWidth:.9,layout:'form',items:[txtCgcrg_nombre]},{columnWidth:.1,layout:'form',items:[btnCgcrg_codigoCgg_res_ocupacion_laboral]}]},
            {xtype:'panel',layout:'column',items:[{columnWidth:.9,layout:'form',items:[txtCsctp_nombre]},{columnWidth:.1,layout:'form',items:[btnCsctp_codigoCgg_res_ocupacion_laboral]}]},
            //  {xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCrpjr_codigo]},{columnWidth:.4,layout:'form',items:[btnCrpjr_codigoCgg_res_ocupacion_laboral]}]},
            cbxCrocl_tipo
        ]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_ocupacion_laboral.
     */
    var winFrmCgg_res_ocupacion_laboral = new Ext.Window({
        id:'winFrmCgg_res_ocupacion_laboral',
        title:tituloCgg_res_ocupacion_laboral,
        tbar:getPanelTitulo(tituloCgg_res_ocupacion_laboral,descCgg_res_ocupacion_laboral),
        items:[pnlCgg_res_ocupacion_laboral],
        width:400,
        minWidth:400,
        maximizable:false,
        minimizable:false,
        resizable:false,
        modal:true,
        constrain:true,
        bbar:[btnGuardarCgg_res_ocupacion_laboral,btnCancelarCgg_res_ocupacion_laboral,'->',btnCerrarCgg_res_ocupacion_laboral]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_ocupacion_laboral.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_res_ocupacion_laboralCtrls(inEstado){
        estado=!inEstado;
        txtCrocl_codigo.setDisabled(estado);
        txtCrper_codigo.setDisabled(estado);
        txtCgg_crper_codigo.setDisabled(estado);
        txtCgcrg_codigo.setDisabled(estado);
        txtCsctp_codigo.setDisabled(estado);
        txtCrpjr_codigo.setDisabled(estado);
        cbxCrocl_tipo.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_ocupacion_laboral.
     */
    function cargarCgg_res_ocupacion_laboralCtrls(){
        if(inRecordCgg_res_ocupacion_laboral){
            txtCrocl_codigo.setValue(inRecordCgg_res_ocupacion_laboral.get('CROCL_CODIGO'));
            txtCrper_codigo.setValue(inRecordCgg_res_ocupacion_laboral.get('CRPER_CODIGO'));
            txtCgg_Empleador.setValue(inRecordCgg_res_ocupacion_laboral.get('CGG_CRPER_CODIGO')?inRecordCgg_res_ocupacion_laboral.get('CGG_CRPER_NOMBRES'):inRecordCgg_res_ocupacion_laboral.get('CRPJR_RAZON_SOCIAL'));
            txtCgg_crper_codigo.setValue(inRecordCgg_res_ocupacion_laboral.get('CGG_CRPER_CODIGO'));
            txtCgcrg_codigo.setValue(inRecordCgg_res_ocupacion_laboral.get('CGCRG_CODIGO'));
            txtCgcrg_nombre.setValue(inRecordCgg_res_ocupacion_laboral.get('CGCRG_NOMBRE'));
            txtCsctp_codigo.setValue(inRecordCgg_res_ocupacion_laboral.get('CSCTP_CODIGO'));
            txtCsctp_nombre.setValue(inRecordCgg_res_ocupacion_laboral.get('CSCTP_NOMBRE'));
            txtCrpjr_codigo.setValue(inRecordCgg_res_ocupacion_laboral.get('CRPJR_CODIGO'));
            cbxCrocl_tipo.setValue(inRecordCgg_res_ocupacion_laboral.get('CROCL_TIPO'));
            inRecordCgg_res_ocupacion_laboral.get('CGG_CRPER_CODIGO')?rdgTipoPersona.setValue('rbPersonaNatural',true):rdgTipoPersona.setValue('rbEmpresa',true);
            isEdit = true;
            habilitarCgg_res_ocupacion_laboralCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_ocupacion_laboral.
     * @returns ventana winFrmCgg_res_ocupacion_laboral.
     * @base FrmCgg_res_ocupacion_laboral.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_ocupacion_laboral;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_ocupacion_laboral.
     * @base FrmCgg_res_ocupacion_laboral.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_ocupacion_laboralCtrls();
    }
    /**
     * Funcion miembro que devuelve los valores de los controles en un solo objeto.
     * @base FrmCgg_res_ocupacion_laboral.prototype.loadData
     */
    this.getData = function(){
        if (tmpDatosConfirmados)
            return objOcupacionPersona;
        else
            return null;
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_ocupacion_laboral desde una instancia.
 */
FrmCgg_res_ocupacion_laboral.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_ocupacion_laboral desde una instancia.
 */
FrmCgg_res_ocupacion_laboral.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_ocupacion_laboral,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_ocupacion_laboral.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_ocupacion_laboral desde una instancia.
 */
FrmCgg_res_ocupacion_laboral.prototype.loadData = function(){
    this.loadData();
}
