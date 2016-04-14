/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_observado.
 * @param {String} IN_SENTENCIA_CGG_RES_OBSERVADO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_RES_OBSERVADO Registro de datos de la tabla Cgg_res_observado.
 * @constructor
 * @base FrmListadoCgg_res_observado
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_observado(IN_SENTENCIA_CGG_RES_OBSERVADO,IN_RECORD_CGG_RES_OBSERVADO){
    var inSentenciaCgg_res_observado = IN_SENTENCIA_CGG_RES_OBSERVADO;
    var inRecordCgg_res_observado=IN_RECORD_CGG_RES_OBSERVADO;
    var urlCgg_res_observado=URL_WS+"Cgg_res_observado";
    var tituloCgg_res_observado='Persona observada';
    var descCgg_res_observado='El formulario permite administrar la informaci\u00f3n de persona observada';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCrobs_codigo = new Ext.form.TextField({
        id:'txtCrobs_codigo',
        name:'txtCrobs_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO
     */
    var txtCrper_codigo = new Ext.form.TextField({
        id:'txtCrper_codigo',
        name:'txtCrper_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false,
        labelStyle:'font-weight:bold;',
        labelWidth:60
    });
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO
     */
    var txtCrper_num_doc_identific = new Ext.form.TextField({
        id:'txtCrper_num_doc_identific',
        name:'txtCrper_num_doc_identific',
        fieldLabel :'No.doc.ident.',
        anchor:'100%',
        // readOnly:'true',
        allowBlank :false,
        labelStyle:'font-weight:bold;',
        enableKeyEvents:true,
        listeners: {
            specialkey: function(field, e){
                // e.HOME, e.END, e.PAGE_UP, e.PAGE_DOWN,
                // e.TAB, e.ESC, arrow keys: e.LEFT, e.RIGHT, e.UP, e.DOWN
                if (e.getKey() == e.ENTER) {
                    try{
                        function CallBackCgg_persona(r){
                            tplInfoPersona.overwrite(Ext.getCmp('pnlDetailPersona').body,Ext.util.JSON.decode(r)[0])
                        }
                        var param = new SOAPClientParameters();
                        param.add('inCrper_num_doc_identific',txtCrper_num_doc_identific.getValue());
                        param.add('format',TypeFormat.JSON);
                        SOAPClient.invoke(URL_WS+"Cgg_res_persona","selectNumDoc",param, true, CallBackCgg_persona);
                    }catch(inErr){
                        //winFrmCgg_institucion_educativa.getEl().unmask();
                    }

                }
            }
        }

    });

    /**
     * CODIGO IDENTIFICATIVO DE REGISTRO
     */
    var btnCrper_codigoCgg_res_observado = new Ext.Button({
        id:'btnCrper_codigoCgg_res_observado',
        iconCls:'iconBuscar',
        tooltip:TypeTooltip.BUSCAR + ' residente',
        listeners:{
            click:function(){
                var tmpPersonaObservado = new Persona();
                var objBusqueda = new DlgBusqueda(tmpPersonaObservado.getStore(), tmpPersonaObservado.getCm());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                    {
                        txtCrper_codigo.setValue(tmpRecord.get('CRPER_CODIGO'));
                        txtCrper_num_doc_identific.setValue(tmpRecord.get('CRPER_NUM_DOC_IDENTIFIC'));
                        tplInfoPersona.overwrite(Ext.getCmp('pnlDetailPersona').body,tmpRecord.json);
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.DateField FECHA DE REGISTRO DE LA 0BSERVACION
     */
    var dtCrobs_fecha_observacion = new Ext.form.DateField({
        //id:'dtCrobs_fecha_observacion',
        // name:'dtCrobs_fecha_observacion',
        //fieldLabel :'Fecha observacion',
        allowBlank :false,
        format :'d/m/Y',
        value:new Date()
    });
    /**
     * Ext.form.TextField DESCRIPCION DEL INCONVENIENTE QUE GENERO LA OBSERVACION
     */
    var txtCrobs_descripcion = new Ext.form.TextField({
        id:'txtCrobs_descripcion',
        name:'txtCrobs_descripcion',
        fieldLabel :'Descripcion',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Ext.form.Checkbox ESTADO QUE DETERMINA SI YA SE RESOLVIO LA OBSERVACION
     */
    var chkCrobs_resueltoEditor = new Ext.form.Checkbox({
        id:'chkCrobs_resueltoEditor',
        name:'chkCrobs_resueltoEditor',
        //fieldLabel :'Resuelto',
        //allowBlank :false,
        checked:false
    });
    /**
     * Ext.form.DateField FECHA DE RESOLUCION DE LA OBSERVACION
     */
    var dtCrobs_fecha_resuelto = new Ext.form.DateField({
        id:'dtCrobs_fecha_resuelto',
        name:'dtCrobs_fecha_resuelto',
        fieldLabel :'Fecha resuelto',
        allowBlank :false,
        format :'d/m/Y',
        value:new Date()
    });

    var objPersona ={
        CRPER_NUMERO_RESIDENCIA:'',
        MODALIDAD:'',
        CRPER_NOMBRES:'',
        CRPER_APELLIDO_PATERNO:'',
        CRPER_APELLIDO_MATERNO:'',
        TIPO_DOC_IDEN:'',
        CRPER_NUM_DOC_IDENTIFIC:''
    }
    var tplInfoPersona = new Ext.Template(
            '<table width="100%" height="100%" cellpadding="0">' +
                    '<tr rowspan="0">' +
                    '<td width="17%" ><div class="tituloTemplate">No.</div></td>' +
                    '<td width="33%"  ><div class="itemTemplate">{CRPER_NUMERO_RESIDENCIA}</div></td>' +
                    '<td width="33%" ><div class="itemTemplate">{MODALIDAD}</div></td>' +
                    '</tr>' +
                    '<tr rowspan="0" alingth="LEFT">' +
                    '<td width="17%" ><div class="tituloTemplate">Nombres:</div></td>' +
                    '<td width="33%" ><div class="itemTemplate">{CRPER_NOMBRES}</div></td>' +
                    '<td width="17%" ><div class="tituloTemplate"> Apellidos:</div></td>' +
                    '<td width="33%" ><div class="itemTemplate" >{CRPER_APELLIDO_PATERNO} {CRPER_APELLIDO_MATERNO}</div></td>' +
                    '</tr>' +
					 '<tr rowspan="0">' +
					 '<td colspan="2"><div class="tituloTemplate"><FONT COLOR="4169E1">Para mayor informaci&oacuten revisar el historial de la persona.</font></div></td>' +
					 '</tr>' +
                    '</table>'
            );

    var pnlInfoPersona = new Ext.Panel({
        id:'pnlInfoPersona',
        //region:'north',
        layout:'form',
        anchor:'100%',
        //labelWidth:50,
        //title:'Datos personales',
        //tpl:tplInfoPersona,

        frame:true,
        items:[{
            xtype:'fieldset',
            layout:'form',
            title:'Datos personales',
            //tpl:tplInfoPersona,
            items:[
                {xtype:'panel',layout:'column',items:[
                    {columnWidth:.9,layout:'form',labelWidth:90,items:[txtCrper_num_doc_identific]}
                    ,{columnWidth:.1,layout:'form',items:[btnCrper_codigoCgg_res_observado]}
                ]},
                {xtype:'panel', id :'pnlDetailPersona',data:objPersona,tpl:tplInfoPersona}

            ]
        }]
    });
    /*
     * Ext.ux.grid.RowEditor Edito de filas personalizado para utilización en el grid de contacto
     */
    var reObservacion= new Ext.ux.grid.RowEditor({
        saveText: 'Aceptar',
        cancelText:'Cancelar',
        listeners:{
            validateedit:function(inRowEditor,inObject,inRecord,inRowIndex){
            },
            canceledit:function(inRowEditor,inFlag){
                /* var inRecord=grdCgg_res_institucion_contacto.getStore().getAt(0);
                 grdCgg_res_institucion_contacto.getStore().remove(inRecord);*/
            }
        }
    });

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_observado.
     */
    var chkCrobs_resuelto = new Ext.grid.CheckColumn(
    {dataIndex:'CROBS_RESUELTO',header:'Resuelto',width:50,sortable:true,editor:chkCrobs_resueltoEditor});

    var cmCgg_res_observado = new Ext.grid.ColumnModel([
        {dataIndex:'CROBS_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CRPER_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CROBS_DESCRIPCION',header:'Descripcion',width:250,sortable:true,editor:txtCrobs_descripcion},
        {dataIndex:'CROBS_FECHA_OBSERVACION',
            renderer:truncDate,
            header:'Fecha observacion',width:150,sortable:true,hidden:true},
        chkCrobs_resuelto,
        {dataIndex:'CROBS_FECHA_RESUELTO',header:'Fecha resuelto',width:150,sortable:true,hidden:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_observado por un campo especifico.
     */
    var gsCgg_res_observado = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_observado",
            method:"selectObservadoPersona",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
        },[
            {name:'CROBS_CODIGO'},
            {name:'CRPER_CODIGO'},
            {name:'CROBS_FECHA_OBSERVACION'},
            {name:'CROBS_DESCRIPCION'},
            {name:'CROBS_RESUELTO'},
            {name:'CROBS_FECHA_RESUELTO'}
        ]),
        baseParams:{inCrper_codigo:'',format:'JSON'}
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_observado en un formato tabular de filas y columnas.
     */
    var grdCgg_res_observado = new Ext.grid.EditorGridPanel({
        cm:cmCgg_res_observado,
        store:gsCgg_res_observado,
        region:'center',
        anchor:'100% 100%',
        autoExpandColumn: 'CROBS_DESCRIPCION',
        viewConfig:{forceFit:true},
        clicksToEdit :2,
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        plugins:[reObservacion]
    });

    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_observado
     */
    var btnGuardarCgg_res_observado = new Ext.Button({
        id:'btnGuardarCgg_res_observado',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:TypeTooltip.GUARDAR,
        listeners:{
            click:function(){
                if (pnlCgg_res_observado.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_res_observado(r){
                        winFrmCgg_res_observado.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_res_observado,
                                msg: 'La informaci\u00f3n de observaci\u00f3n ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_res_observado.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_res_observado,
                                msg: 'La informaci\u00f3n de observaci\u00f3n no ha podido ser almacenada. '+r,
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_res_observado.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(!isEdit)
                        param.add('inCrper_codigo',txtCrper_codigo.getValue());
                    param.add('inObservaciones_JSON',grdCgg_res_observado.getStore().getJsonData());
                    SOAPClient.invoke(urlCgg_res_observado,IN_SENTENCIA_CGG_RES_OBSERVADO+'Group',param, true, CallBackCgg_res_observado);
                }catch(inErr){
                    winFrmCgg_res_observado.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_observado.
     */
    var btnCancelarCgg_res_observado = new Ext.Button({
        id:'btnCancelarCgg_res_observado',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:TypeTooltip.CANCELAR,
        listeners:{
            click:function(){
                pnlCgg_res_observado.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_observado.
     */
    var btnCerrarCgg_res_observado = new Ext.Button({
        id:'btnCerrarCgg_res_observado',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:TypeTooltip.CERRAR,
        listeners:{
            click:function(){
                winFrmCgg_res_observado.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_observado.
     */
    var pnlCgg_res_observado = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        region:'center',
        layout:'form',
        height:200,
        title:'Registro novedades/observaciones',
        items:[grdCgg_res_observado],
        tbar:[{
            iconCls:'iconNuevo',
            tooltip:'Agregar observaci\u00f3n',
            handler:function(){
                if(txtCrper_codigo.getValue())
                {
                    var tmpRecordCriterio = grdCgg_res_observado.getStore().recordType;
                    reObservacion.stopEditing();
                    grdCgg_res_observado.getStore().insert(0,
                            new tmpRecordCriterio({
                                CROBS_CODIGO: 'KEYGEN',
                                CRPER_CODIGO: txtCrper_codigo.getValue(),
                                CROBS_FECHA_OBSERVACION: '',
                                CROBS_DESCRIPCION: '',
                                CROBS_RESUELTO: '',
                                CROBS_FECHA_RESUELTO: ''
                            })
                            );
                    grdCgg_res_observado.getView().refresh();
                    grdCgg_res_observado.getSelectionModel().selectRow(0);
                    reObservacion.startEditing(0);
                }
                else
                {
                    Ext.Msg.show({
                        title:tituloCgg_res_observado,
                        msg: 'Por favor seleccione una persona residente para continuar.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.INFO
                    });
                }
            }


        },{
            iconCls:'iconEliminar',
            tooltip:'Eliminar observaci\u00f3n',
            handler:function(){
                Ext.Msg.show({title:'Aviso', msg:'Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_observado,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_res_observado(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_res_observado(r){
                            winFrmCgg_res_observado.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_observado,
                                    msg: 'La informaci\u00f3n de observaci\u00f3n ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_res_observado.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_observado,
                                    msg: 'La informaci\u00f3n de observaci\u00f3n no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmCgg_res_observado.getEl().mask('Eliminando...', 'x-mask-loading');
                        if(grdCgg_res_observado.getSelectionModel().getSelected().get('CROBS_CODIGO') != 'KEYGEN')
                        {
                            var param = new SOAPClientParameters();
                            param.add('inCrobs_codigo',grdCgg_res_observado.getSelectionModel().getSelected().get('CROBS_CODIGO'));
                            SOAPClient.invoke(urlListadoCgg_res_observado,"delete",param, true, CallBackCgg_res_observado);
                        }
                        else
                        {
                            grdCgg_res_observado.getStore().remove(grdCgg_res_observado.getSelectionModel().getSelected());
                            winFrmCgg_res_observado.getEl().unmask();
                        }
                    }catch(inErr){
                        winFrmCgg_res_observado.getEl().unmask();
                    }}}
            }

        }
        ]//[txtCrobs_codigo,
        //{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCrper_codigo]},{columnWidth:.4,layout:'form',items:[btnCrper_codigoCgg_res_observado]}]},
        //dtCrobs_fecha_observacion,txtCrobs_descripcion,chkCrobs_resuelto,dtCrobs_fecha_resuelto]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_observado.
     */
    var winFrmCgg_res_observado = new Ext.Window({
        id:'winFrmCgg_res_observado',
        title:tituloCgg_res_observado,
        width:500,
        minWidth:500,
        maximizable:false,
        minimizable:false,
        resizable:false,
        modal:true,
        constrain:true,
        layout:'form',
        tbar:getPanelTitulo(tituloCgg_res_observado,descCgg_res_observado),
        items:[pnlInfoPersona,pnlCgg_res_observado],
        bbar:[btnGuardarCgg_res_observado,btnCancelarCgg_res_observado,'->',btnCerrarCgg_res_observado],
        listeners:{
            show:function(){
                if(isEdit)
                {
                    gsCgg_res_observado.reload({params:{
                        inCrper_codigo:inRecordCgg_res_observado.get('CRPER_CODIGO'),
                        format:TypeFormat.JSON
                    }
                    });

                    tplInfoPersona.overwrite(Ext.getCmp('pnlDetailPersona').body,inRecordCgg_res_observado.json);
                }
            }
        }
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_observado.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_res_observadoCtrls(inEstado){
        estado=!inEstado;
        txtCrper_num_doc_identific.setDisabled(estado);
        btnCrper_codigoCgg_res_observado.disable();
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_observado.
     */
    function cargarCgg_res_observadoCtrls(){
        if(inRecordCgg_res_observado){
            txtCrper_codigo.setValue(inRecordCgg_res_observado.get('CRPER_CODIGO'));
            txtCrper_num_doc_identific.setValue(inRecordCgg_res_observado.get('CRPER_NUM_DOC_IDENTIFIC'));//Pendiente de cambio.
            isEdit = true;
            habilitarCgg_res_observadoCtrls(false);


        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_observado.
     * @returns ventana winFrmCgg_res_observado.
     * @base FrmCgg_res_observado.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_observado;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_observado.
     * @base FrmCgg_res_observado.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_observadoCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_observado desde una instancia.
 */
FrmCgg_res_observado.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_observado desde una instancia.
 */
FrmCgg_res_observado.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_observado,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_observado.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_observado desde una instancia.
 */
FrmCgg_res_observado.prototype.loadData = function(){
    this.loadData();
}
