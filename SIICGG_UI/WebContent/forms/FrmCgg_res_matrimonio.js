/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_matrimonio.
 * @param {String} INSENTENCIA_CGG_RES_MATRIMONIO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_MATRIMONIO Registro de datos de la tabla Cgg_res_matrimonio.
 * @constructor
 * @base FrmListadoCgg_res_matrimonio
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_matrimonio(INSENTENCIA_CGG_RES_MATRIMONIO,INRECORD_CGG_RES_MATRIMONIO){
    var inSentenciaCgg_res_matrimonio = INSENTENCIA_CGG_RES_MATRIMONIO;
    var inRecordCgg_res_matrimonio=INRECORD_CGG_RES_MATRIMONIO;
    var urlCgg_res_matrimonio=URL_WS+"Cgg_res_matrimonio";
    var tituloCgg_res_matrimonio='Matrimonio';
    var descCgg_res_matrimonio='El formulario permite administrar informaci\u00f3n de Matrimonio';
    var isEdit = false;
    var Crper_codigo;
    var Crper_codigoConyuge;

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCrmtr_codigo = new Ext.form.TextField({
        id:'txtCrmtr_codigo',
        name:'txtCrmtr_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true
    });
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DEL RESIDENTE PERMANENTE
     */
    var txtCrper_codigo = new Ext.form.TextField({
        id:'txtCrper_codigo',
        name:'txtCrper_codigo',
        fieldLabel :'Residente',
        anchor:'100%',
        allowBlank :false,
        readOnly:'true'
    });

     /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DEL RESIDENTE PERMANENTE
     */
    var txtCrtra_numero = new Ext.form.TextField({
        id:'txtCrtra_numero',
        fieldLabel :'No. tramite',
        anchor:'50%',
        allowBlank :false
    });
    /**
     * CODIGO IDENTIFICATIVO DEL RESIDENTE PERMANENTE
     */
    var btnCrper_codigoCgg_res_matrimonio = new Ext.Button({
        id:'btnCrper_codigoCgg_res_matrimonio',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_res_persona = new Persona();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona.getStore(),tmpFLCgg_res_persona.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        Crper_codigo= (tmpRecord.get('CRPER_CODIGO'));
                        txtCrper_codigo.setValue(tmpRecord.get('CRPER_NOMBRES')+" "+tmpRecord.get('CRPER_APELLIDO_PATERNO'));
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DEL CONYUGE O BENEFICIARIO
     */
    var txtCgg_crper_codigo = new Ext.form.TextField({
        id:'txtCgg_crper_codigo',
        name:'txtCgg_crper_codigo',
        fieldLabel :'C\u00f3nyuge',
        anchor:'100%',
        allowBlank :false,
        readOnly:'true'
    });
    /**
     * CODIGO IDENTIFICATIVO DEL CONYUGE O BENEFICIARIO
     */
    var btnCgg_crper_codigoCgg_res_matrimonio = new Ext.Button({
        id:'btnCgg_crper_codigoCgg_res_matrimonio',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                  var tmpFLCgg_res_persona = new Persona();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona.getStore(),tmpFLCgg_res_persona.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        Crper_codigoConyuge= (tmpRecord.get('CRPER_CODIGO'));
                        txtCgg_crper_codigo.setValue(tmpRecord.get('CRPER_NOMBRES')+" "+tmpRecord.get('CRPER_APELLIDO_PATERNO'));
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.DateField FECHA DE REALIZACION DE MATRIMONIO O UNION DE HECHO
     */
    var dtCrmtr_fecha_matrimonio = new Ext.form.DateField({
        id:'dtCrmtr_fecha_matrimonio',
        name:'dtCrmtr_fecha_matrimonio',
        fieldLabel :'Fecha Matrimonio',
        allowBlank :false,
        //value:new Date(),
        format:'d/m/Y'
    });
    /**
     * Ext.form.NumberField TIPO DE RELACION FORMALIZADA Y LEGALIZADA
     MATRIMONIO
     UNION DE HECHO
     */
    var dttipo_estado_civil =[
        [1,'MATRIMONIO'],[2,'UNI\u00D3N DE HECHO']
    ];
    var sttipo_estado_civil = new Ext.data.ArrayStore({
        fields:['id','tipo_estado_civil'],
        data:dttipo_estado_civil
    });
    var cbxCrmtr_tipo = new Ext.form.ComboBox({
        id:'cbxCrmtr_tipo',
        name:'cbxCrmtr_tipo',
        store: sttipo_estado_civil,
        fieldLabel :'Estado Civil',
        anchor:'75%',
        displayField: 'tipo_estado_civil',
        valueField: 'id',
        mode:'local',
        editable: false,
        triggerAction:'all',
        emptyText : 'Seleccione una opci\u00f3n..'
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO FrmCgg_res_oficial_seguimiento
     */
    var txtCrosg_codigo = new Ext.form.TextField({
        id:'txtCrosg_codigo',
        name:'txtCrosg_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO FrmCgg_res_oficial_seguimiento
     */
    var btnCusu_codigoCgg_res_oficial_seguimiento = new Ext.Button({
        id:'btnCusu_codigoCgg_res_oficial_seguimiento',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var tmpFLCgg_res_oficial_seguimiento_usuario= new FrmListadoCgg_res_oficial_seguimiento_usuario();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_oficial_seguimiento_usuario.getStore(),tmpFLCgg_res_oficial_seguimiento_usuario.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        var Llenar = tmpFLCgg_res_oficial_seguimiento_usuario.getStore().recordType;
                        var nuevo = new Llenar({
                            CUSU_CODIGO: tmpRecord.get('CUSU_CODIGO'),
                            CRPER_NOMBRES: tmpRecord.get('CUSU_NOMBRES'),
                            CRPER_APELLIDO_PATERNO: tmpRecord.get('CUSU_APELLIDOS')
                        });
                        dtgOficial_Seguimiento.stopEditing();
                        dtgOficial_Seguimiento.getStore().insert(0,nuevo);
                        dtgOficial_Seguimiento.startEditing(0, 0);
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO FrmCgg_res_oficial_seguimiento
     */
    var btnCusu_codigoCgg_res_oficial_seguimientoelimin = new Ext.Button({
        id:'btnCusu_codigoCgg_res_oficial_seguimientoelimin',
        iconCls:'iconEliminar',
        handler:function(){
            var seleccionado = dtgOficial_Seguimiento.getSelectionModel().getSelected();
            if(seleccionado !=null){
                dtgOficial_Seguimiento.getStore().remove(seleccionado);
            }else if(dtgOficial_Seguimiento.getStore().getCount()>=1){
                dtgOficial_Seguimiento.getSelectionModel().selectLastRow();
                dtgOficial_Seguimiento.getStore().remove(dtgOficial_Seguimiento.getSelectionModel().getSelected());
            }
        }
    });

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_matrimonio.
     */
    var cmOficialMatrimonio = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
        {dataIndex:'CUSU_CODIGO',header:'Codigo',width:150,sortable:true, hidden:true},
        {dataIndex:'CRPER_NOMBRES',header:'Nombres',width:150,sortable:true},
        {dataIndex:'CRPER_APELLIDO_PATERNO',header:'Apellidos',width:150,sortable:true}
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_matrimonio por un campo especifico.
     */
    var gsOficialMatrimonio = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_oficial_matrimonio",
            method:"selectUsuario_Matrimonio",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
            id:'CROSG_CODIGO',
            root:'dataSet'
        },[
            {name:'CUSU_CODIGO'},
            {name:'CRPER_NOMBRES'},
            {name:'CRPER_APELLIDO_PATERNO'}
        ])
        //sortInfo:{field: 'CRPER_CODIGO', direction: 'ASC'},
        // baseParams:{format:"JSON"}
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_matrimonio en un formato tabular de filas y columnas.
     */
    var dtgOficial_Seguimiento = new Ext.grid.EditorGridPanel({
        cm:cmOficialMatrimonio,
        store:gsOficialMatrimonio,
        viewConfig:{forceFit:true},
        tbar:[btnCusu_codigoCgg_res_oficial_seguimiento,btnCusu_codigoCgg_res_oficial_seguimientoelimin],
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."}
    });

    ///////////////////////////////////////////////////
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCusu_codigo = new Ext.form.TextField({
        id:'txtCusu_codigo',
        name:'txtCusu_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });

    var pnlCgg_res_oficial_seguimiento = new Ext.form.FormPanel({
        title :'Oficial de Matrimonio',
        anchor:'100% 50%',
        height :150,
        layout:'border',
        items:[dtgOficial_Seguimiento]
    });

    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_matrimonio
     */
    var btnGuardarCgg_res_matrimonio = new Ext.Button({
        id:'btnGuardarCgg_res_matrimonio',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){

                if (pnlCgg_res_matrimonio.getForm().isValid()==false){
                    return;
                }
                if (pnlCgg_res_oficial_seguimiento.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_res_matrimonio(r){
                        winFrmCgg_res_matrimonio.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_res_matrimonio,
                                msg: 'La informaci\u00f3n del Matrimonio ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_res_matrimonio.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_res_matrimonio,
                                msg: 'La informaci\u00f3n del Matrimonio no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_res_matrimonio.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    /////////////////////////////////////////////////////////////////////////
                    var tmpStoreOf = dtgOficial_Seguimiento.getStore().getJsonData();
                    if(isEdit)
                        param.add('inCrmtr_codigo',txtCrmtr_codigo.getValue());
                    param.add('inCrtra_codigo',INRECORD_CGG_RES_MATRIMONIO.get('CRTRA_CODIGO'));
                    param.add('inCrmtr_fecha_matrimonio',dtCrmtr_fecha_matrimonio.getValue().format('c'));
                    param.add('inCrmtr_tipo',cbxCrmtr_tipo.getValue());
                    param.add('inCrmtr_estado_seguimiento',0);
                    param.add('inpryu_JSON',tmpStoreOf);
                    SOAPClient.invoke(urlCgg_res_matrimonio,INSENTENCIA_CGG_RES_MATRIMONIO+'1',param, true, CallBackCgg_res_matrimonio);
                }catch(inErr){
                    winFrmCgg_res_matrimonio.getEl().unmask();
                }
            }
        }
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_matrimonio.
     */
    var btnCancelarCgg_res_matrimonio = new Ext.Button({
        id:'btnCancelarCgg_res_matrimonio',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_res_matrimonio.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_matrimonio.
     */
    var btnCerrarCgg_res_matrimonio = new Ext.Button({
        id:'btnCerrarCgg_res_matrimonio',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_res_matrimonio.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_matrimonio.
     */
    var pnlCgg_res_matrimonio = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        anchor:'100% 50%',
        items:[txtCrmtr_codigo,txtCrtra_numero,txtCrper_codigo,txtCgg_crper_codigo,dtCrmtr_fecha_matrimonio,cbxCrmtr_tipo]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_matrimonio.
     */
    var winFrmCgg_res_matrimonio = new Ext.Window({
        id:'winFrmCgg_res_matrimonio',
        title:tituloCgg_res_matrimonio,
        tbar:getPanelTitulo(tituloCgg_res_matrimonio,descCgg_res_matrimonio),
        items:[pnlCgg_res_matrimonio, pnlCgg_res_oficial_seguimiento],
        layout:'form',
        width:420,
        height:400,
        resizable : false,
        modal:true,
        minWidth:400,
        maximizable:false,
        minimizable:false,
        constrain:true,
        bbar:[btnGuardarCgg_res_matrimonio,btnCancelarCgg_res_matrimonio,'->',btnCerrarCgg_res_matrimonio]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_matrimonio.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_res_matrimonioCtrls(inEstado){
        estado=!inEstado;
        txtCrmtr_codigo.setDisabled(estado);
        txtCrper_codigo.setDisabled(estado);
        txtCgg_crper_codigo.setDisabled(estado);
        dtCrmtr_fecha_matrimonio.setDisabled(estado);
        cbxCrmtr_tipo.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_matrimonio.
     */
    function cargarCgg_res_matrimonioCtrls(){
        if(inRecordCgg_res_matrimonio){
            txtCrmtr_codigo.setValue(inRecordCgg_res_matrimonio.get('CRMTR_CODIGO'));
           // Crper_codigo=inRecordCgg_res_matrimonio.get('CRPER_CODIGO');
            txtCrper_codigo.setValue(inRecordCgg_res_matrimonio.get('RESIDENTE'));
          //  Crper_codigoConyuge = inRecordCgg_res_matrimonio.get('CGG_CRPER_CODIGO');
            txtCgg_crper_codigo.setValue(inRecordCgg_res_matrimonio.get('CONYUGE'));
            inRecordCgg_res_matrimonio.get('CRMTR_FECHA_MATRIMONIO')?dtCrmtr_fecha_matrimonio.setValue(truncDate(inRecordCgg_res_matrimonio.get('CRMTR_FECHA_MATRIMONIO'))):0;
            inRecordCgg_res_matrimonio.get('CRMTR_TIPO')>0?cbxCrmtr_tipo.setValue(inRecordCgg_res_matrimonio.get('CRMTR_TIPO')):0;
            txtCrtra_numero.setValue(inRecordCgg_res_matrimonio.get('CRTRA_NUMERO'));
            isEdit = true;
            habilitarCgg_res_matrimonioCtrls(true);
            gsOficialMatrimonio.reload();
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_matrimonio.
     * @returns ventana winFrmCgg_res_matrimonio.
     * @base FrmCgg_res_matrimonio.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_matrimonio;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_matrimonio.
     * @base FrmCgg_res_matrimonio.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_matrimonioCtrls();
    }
    /**
     * Funcion que permite cargar la codigo de los controles de la ventana winFrmListadoCgg_res_matrimonio.
     */
    function cargarCgg_res_matrimonio(inCodigo){
        gsOficialMatrimonio.reload({params:{
            format:"JSON",
            inCrmtr_codigo:inCodigo
        }
        });
    }
    /**
     * Funcion que permite cargar la codgi de los controles de la ventana winFrmListadoCgg_res_matrimonio.
     */
    this.loadMatrimonio = function(inCodigo){
        cargarCgg_res_matrimonio(inCodigo);
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_matrimonio desde una instancia.
 */
FrmCgg_res_matrimonio.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_matrimonio desde una instancia.
 */
FrmCgg_res_matrimonio.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_matrimonio,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_matrimonio.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_matrimonio desde una instancia.
 */
FrmCgg_res_matrimonio.prototype.loadData = function(){
    this.loadData();
}
FrmCgg_res_matrimonio.prototype.loadMatrimonio = function(inCodigo){
    this.loadMatrimonio(inCodigo);
}
