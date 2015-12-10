/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_operacion_validacion.
 * @param {String} IN_SENTENCIA_CGG_OPERACION_VALIDACION Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_OPERACION_VALIDACION Registro de datos de la tabla Cgg_operacion_validacion.
 * @constructor
 * @base FrmListadoCgg_operacion_validacion
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_operacion_validacion(IN_SENTENCIA_CGG_OPERACION_VALIDACION,IN_RECORD_CGG_OPERACION_VALIDACION){
    var inSentenciaCgg_operacion_validacion = IN_SENTENCIA_CGG_OPERACION_VALIDACION;
    var inRecordCgg_operacion_validacion=IN_RECORD_CGG_OPERACION_VALIDACION;
    var urlCgg_operacion_validacion=URL_WS+"Cgg_operacion_validacion";
    var tituloCgg_operacion_validacion='Operacion validacion';
    var descCgg_operacion_validacion='El formulario permite administrar la informaci\u00f3n de la tabla Operacion validacion';
    var isEdit = false;
    var objReglasValidacion = null;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE OPERACION
     */
    var txtCopvl_codigo = new Ext.form.TextField({
        id:'txtCopvl_codigo',
        name:'txtCopvl_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.form.TextField DESCRIPCION DE LA OPERACION
     */
    var txtCopvl_descripcion = new Ext.form.TextField({
        id:'txtCopvl_descripcion',
        name:'txtCopvl_descripcion',
        fieldLabel :'Descripcion',
        anchor:'98%',
        allowBlank :false
    });
    var rTipoSolicitudRegla = Ext.data.Record.create([{
        name:'CORV_CODIGO'
    },

        {
            name:'COPVL_CODIGO'
        },

        {
            name:'CRVAL_CODIGO'
        },
        {
            name:'CRVAL_NOMBRE'
        },

        {
            name:'CORV_CAMPO_EVALUACION'
        },

        {
            name:'CORV_VALOR_1'
        }
    ]);


    /**
     * Ext.data.Store Seleccion de registros de la tabla Cgg_sec_objeto
     */
    var gsCgg_sec_objeto = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_sec_objeto",
            method:"selectObjectsByType",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
        },[
            {name:'CSOBJ_TIPO'},
            {name:'CSOBJ_RUTA'}
        ]),
        sortInfo:{field: 'CSOBJ_RUTA', direction: 'ASC'},
        baseParams:{
            inTypeObject:TypeObjeto.INTERFACE,
            format:TypeFormat.JSON}
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DEL ESTADO CIVIL
     */
    var cbxCopvl_formulario = new Ext.form.ComboBox({
        store: gsCgg_sec_objeto,
        fieldLabel :'Formulario',
        displayField:'CSOBJ_RUTA',
        typeAhead: true,
        lazyRender:true,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione un formulario',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CSOBJ_RUTA}" class="x-combo-list-item">{CSOBJ_RUTA}</div></tpl>',
        valueField:'CSOBJ_RUTA'
    });
    gsCgg_sec_objeto.load();

    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_operacion_validacion
     */
    var btnGuardarCgg_operacion_validacion = new Ext.Button({
        id:'btnGuardarCgg_operacion_validacion',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:TypeTooltip.GUARDAR,
        listeners:{
            click:function(){
                if (pnlCgg_operacion_validacion.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_operacion_validacion(r){
                        winFrmCgg_operacion_validacion.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_operacion_validacion,
                                msg: 'La informaci\u00f3n de Operacion validacion ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_operacion_validacion.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_operacion_validacion,
                                msg: 'La informaci\u00f3n de Operacion validacion no ha podido ser almacenada. '+r,
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_operacion_validacion.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCopvl_codigo',txtCopvl_codigo.getValue());
                    param.add('inCopvl_descripcion',txtCopvl_descripcion.getValue());
                    param.add('inCopvl_formulario',cbxCopvl_formulario.getRawValue());
                    param.add('inCorv_JSON',obtenerReglasJson());
                    SOAPClient.invoke(urlCgg_operacion_validacion,IN_SENTENCIA_CGG_OPERACION_VALIDACION+'1',param, true, CallBackCgg_operacion_validacion);
                }catch(inErr){
                    winFrmCgg_operacion_validacion.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_operacion_validacion.
     */
    var btnCancelarCgg_operacion_validacion = new Ext.Button({
        id:'btnCancelarCgg_operacion_validacion',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:TypeTooltip.CANCELAR,
        listeners:{
            click:function(){
                pnlCgg_operacion_validacion.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_operacion_validacion.
     */
    var btnCerrarCgg_operacion_validacion = new Ext.Button({
        id:'btnCerrarCgg_operacion_validacion',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:TypeTooltip.CERRAR,
        listeners:{
            click:function(){
                winFrmCgg_operacion_validacion.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_operacion_validacion.
     */
    var pnlCgg_operacion_validacion = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        region:'north',
        height:70,
        layout:'form',
        items:[txtCopvl_codigo,txtCopvl_descripcion,cbxCopvl_formulario]
    });

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_tipo_solicitud_regla.
     */
    var cmCgg_res_tipo_solicitud_regla = new Ext.grid.ColumnModel([
        {
            dataIndex:'CORV_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        },

        {
            dataIndex:'COPVL_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        },

        {
            dataIndex:'CRVAL_CODIGO',
            header:'Regla validaci\u00f3n',
            width:150,
            sortable:true,
            hidden:true

            //renderer: Ext.util.Format.comboRenderer(cbxCgg_regla_validacionEditor)
            //editor:cbxCgg_regla_validacionEditor
            /*renderer:function(inCRVAL_CODIGO){
             var scpReglaValidacion = new SOAPClientParameters();
             var resultRegla = null;
             scpReglaValidacion.add('inCRVAL_CODIGO',inCRVAL_CODIGO);
             scpReglaValidacion.add('format',TypeFormat.JSON);
             var tmpRegla = SOAPClient.invoke(URL_WS+'Cgg_regla_validacion','select', scpReglaValidacion, false,null);
             try{
             tmpRegla = Ext.util.JSON.decode(tmpRegla);
             tmpRegla = tmpRegla[0];
             resultRegla = tmpRegla.CRVAL_NOMBRE;
             }catch(inErr){
             resultRegla = NO_DATA_MESSAGE;
             }
             return resultRegla;
             }*/
        },
        {
            dataIndex:'CRVAL_NOMBRE',
            header:'Regla validaci\u00f3n',
            width:150,
            sortable:true,
            hidden:true
        },
        {
            dataIndex:'CORV_VALOR_1',
            header:'Parametro',
            width:150,
            sortable:true,
            hidden:false,
            hideable:false
        },
        {
            dataIndex:'CORV_CAMPO_EVALUACION',
            header:'Campo evaluaci\u00f3n',
            width:150,
            sortable:true,
            editor:{
                xtype:'textfield'
            }
        }
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_tipo_solicitud_regla por un campo especifico.
     */
    var     gsCgg_res_tipo_solicitud_regla = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_operacion_regla_validacion",
            method:"selectCGG_OPERACION_VALIDACION1"
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({},rTipoSolicitudRegla),
        baseParams:{
            inCopvl_codigo:'',
            format:'JSON'
        },
        groupField: 'CRVAL_NOMBRE'
    });

    var reTipoSolicitudRegla = new Ext.ux.grid.RowEditor({
        saveText: 'Aceptar',
        listeners:{
            canceledit:function(inRowEditor,inFlag){
                /* var inRecord=grdCgg_res_tipo_solicitud_regla.getStore().getAt(0);
                 grdCgg_res_tipo_solicitud_regla.getStore().remove(inRecord);*/
            },
            afteredit:function(inRowEditor,inObject,inRecord,inRowIndex){
                /*  if(inRecord.get('CRVAL_CODIGO').trim().length==0){
                 grdCgg_res_tipo_solicitud_regla.getStore().remove(inRecord);
                 }else{
                 for(var i=0;i<grdCgg_res_tipo_solicitud_regla.getStore().getCount();i++){
                 if(i > 0){
                 if(inRecord.get('CRVAL_CODIGO')==grdCgg_res_tipo_solicitud_regla.getStore().getAt(i).get('CRVAL_CODIGO')){
                 Ext.Msg.show({
                 title:tituloCgg_res_tipo_solicitud_tramite,
                 msg: 'La regla seleccionada ya esta establecida.',
                 buttons: Ext.Msg.OK,
                 icon: Ext.MessageBox.WARNING
                 });
                 grdCgg_res_tipo_solicitud_regla.getStore().removeAt(0);
                 }
                 }
                 }
                 }*/
            }
        }
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_tipo_solicitud_regla en un formato tabular de filas y columnas.
     */
    var grdCgg_res_tipo_solicitud_regla = new Ext.grid.GridPanel({
        cm:cmCgg_res_tipo_solicitud_regla,
        store:gsCgg_res_tipo_solicitud_regla,
        region:'center',
        anchor:'100% 100%',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        loadMask:{
            msg:"Cargando..."
        },
        //viewConfig: {forceFit: true },
        plugins:[reTipoSolicitudRegla],
        view: new Ext.grid.GroupingView({
            forceFit: true,
            // custom grouping text template to display the number of items per group
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
        })

    });

    /*gsCgg_res_tipo_solicitud_regla.reload({
     params:{
     inCopvl_codigo:null,
     format:'JSON'
     }
     });*/

    var pnlOperacionRegla = new Ext.Panel({
        id:'pnlOperacionRegla',
        title: 'Reglas de validaci\u00F3n',
        region:'center',
        layout:'border',
        items:[grdCgg_res_tipo_solicitud_regla],
        tbar:[{
            iconCls:'iconNuevo',
            tooltip:'Agregar regla',
            handler:function(){
                var rFilaRegla = null;
                var objReglaValidacion =  new Cgg_res_regla_validacion_lite();
                var objDlgBusquedas = new DlgBusqueda(objReglaValidacion.getStore(),objReglaValidacion.getColumnModel(),false);
                objDlgBusquedas.closeHandler(function(){
                            var tmpRecordRegla = objDlgBusquedas.getSelectedRow();
                            if(tmpRecordRegla){
                                var tmpRuleExist =gsCgg_res_tipo_solicitud_regla.getAt(gsCgg_res_tipo_solicitud_regla.findExact('CRVAL_NOMBRE',tmpRecordRegla.get('CRVAL_NOMBRE')));
                                if (!tmpRuleExist){
                                    var tmpParams = tmpRecordRegla.get('CRVAL_FUNCION_PLSQL_PARAMETROS');
                                    if(tmpParams.length>0){
                                        tmpParams = tmpParams.split(',');
                                        for(var i=0;i<(tmpParams.length-2);i++){
                                            var rFilaRegla = new rTipoSolicitudRegla({
                                                CORV_CODIGO:'KEYGEN',
                                                COPVL_CODIGO:'',
                                                CRVAL_CODIGO:tmpRecordRegla.get('CRVAL_CODIGO'),
                                                CRVAL_NOMBRE:tmpRecordRegla.get('CRVAL_NOMBRE'),
                                                CORV_VALOR_1:tmpParams[i].toUpperCase(),
                                                CORV_CAMPO_EVALUACION:''
                                            });
                                            reTipoSolicitudRegla.stopEditing();
                                            gsCgg_res_tipo_solicitud_regla.insert(0,rFilaRegla);
                                            grdCgg_res_tipo_solicitud_regla.getView().refresh();
                                        }
                                        grdCgg_res_tipo_solicitud_regla.getSelectionModel().selectRow(0);
                                    }
                                    //  reTipoSolicitudRegla.startEditing(0);
                                }
                            }
                        }
				)
                objDlgBusquedas.show();
            }
        },{
            iconCls:'iconEliminar',
            tooltip:'Eliminar regla',
            handler:function(){
                Ext.Msg.show({title:'Aviso', msg:'Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_operacion_regla_validacion,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_operacion_regla_validacion(btn){if (btn=='yes'){
                    try{
                        if (grdCgg_res_tipo_solicitud_regla.getSelectionModel().getSelected().get('CORV_CODIGO') !='KEYGEN')
                        {
                            function CallBackCgg_operacion_regla_validacion(r){
                                winFrmCgg_operacion_validacion.getEl().unmask();
                                if(r=='true'){
                                    Ext.Msg.show({
                                        title:tituloCgg_operacion_validacion,
                                        msg: 'La informaci\u00f3n de Operacion regla validacion ha sido eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    gsCgg_res_tipo_solicitud_regla.reload();
                                }else{
                                    Ext.Msg.show({
                                        title:tituloCgg_operacion_validacion,
                                        msg: 'La informaci\u00f3n de Operacion regla validacion no ha podido ser eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }}
                            winFrmCgg_operacion_validacion.getEl().mask('Eliminando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCorv_codigo',grdCgg_res_tipo_solicitud_regla.getSelectionModel().getSelected().get('CORV_CODIGO'));
                            SOAPClient.invoke(URL_WS+"Cgg_operacion_regla_validacion","delete",param, true, CallBackCgg_operacion_regla_validacion);
                        }
                        else
                        {
                            var seleccionado = grdCgg_res_tipo_solicitud_regla.getSelectionModel().getSelected();
                            if(seleccionado != null ){
                                grdCgg_res_tipo_solicitud_regla.getStore().remove(seleccionado);
                            }else if(grdCgg_res_tipo_solicitud_regla.getStore().getCount()>=1){
                                grdCgg_res_tipo_solicitud_regla.getSelectionModel().selectLastRow();
                                grdCgg_res_tipo_solicitud_regla.getStore().remove(grdCgg_res_tipo_solicitud_regla.getSelectionModel().getSelected());
                            }
                        }

                    }catch(inErr){
                        winFrmCgg_operacion_validacion.getEl().unmask();
                    }
                }
                }
            }
        }]
    });



    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_operacion_validacion.
     */
    var winFrmCgg_operacion_validacion = new Ext.Window({
        id:'winFrmCgg_operacion_validacion',
        title:tituloCgg_operacion_validacion,
        width:450,
        minWidth:450,
        height:500,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        tbar:getPanelTitulo(tituloCgg_operacion_validacion,descCgg_operacion_validacion),
        items:[pnlCgg_operacion_validacion,pnlOperacionRegla],
        bbar:[btnGuardarCgg_operacion_validacion,btnCancelarCgg_operacion_validacion,'->',btnCerrarCgg_operacion_validacion]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_operacion_validacion.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_operacion_validacionCtrls(inEstado){
        estado=!inEstado;
        txtCopvl_codigo.setDisabled(estado);
        txtCopvl_descripcion.setDisabled(estado);
        cbxCopvl_formulario.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_operacion_validacion.
     */
    function cargarCgg_operacion_validacionCtrls(){
        if(inRecordCgg_operacion_validacion){
            txtCopvl_codigo.setValue(inRecordCgg_operacion_validacion.get('COPVL_CODIGO'));
            txtCopvl_descripcion.setValue(inRecordCgg_operacion_validacion.get('COPVL_DESCRIPCION'));
            cbxCopvl_formulario.setValue(inRecordCgg_operacion_validacion.get('COPVL_FORMULARIO'));
            isEdit = true;
            habilitarCgg_operacion_validacionCtrls(true);
            gsCgg_res_tipo_solicitud_regla.reload({
                params:{
                    inCopvl_codigo:inRecordCgg_operacion_validacion.get('COPVL_CODIGO'),
                    format:TypeFormat.JSON
                }
            })
        }}

    function obtenerReglasJson(){

        var tmpReglaGuardar ={};
        var tmpParams = {};
        var rRegla = null;
        var reglaJSON = [];
        var tmpNombreRegla =  null;
        var tmpExistenVarios = 0;
        for(var i=0;i<gsCgg_res_tipo_solicitud_regla.getCount();i++)
        {
            var rRegla = gsCgg_res_tipo_solicitud_regla.getAt(i);
            if((tmpNombreRegla == null)||(tmpNombreRegla !=rRegla.get('CRVAL_NOMBRE')))
            {
                if(tmpNombreRegla != null)
                {
                    tmpReglaGuardar.CORV_CAMPO_EVALUACION = '['+Ext.util.JSON.encode(tmpParams)+']';//Ext.util.JSON.encode(tmpParams);
                    reglaJSON.push(tmpReglaGuardar);
                }
                tmpReglaGuardar ={};
                tmpParams = {};
                tmpReglaGuardar.CORV_CODIGO = rRegla.get('CORV_CODIGO');
                tmpReglaGuardar.COPVL_CODIGO = rRegla.get('COPVL_CODIGO');
                tmpReglaGuardar.CRVAL_CODIGO = rRegla.get('CRVAL_CODIGO');
                tmpReglaGuardar.CRVAL_NOMBRE = rRegla.get('CRVAL_NOMBRE');
                tmpReglaGuardar.CORV_VALOR_1  = '';
                tmpReglaGuardar.CORV_CAMPO_EVALUACION = '';
                tmpNombreRegla = rRegla.get('CRVAL_NOMBRE');
                tmpParams[rRegla.get('CORV_VALOR_1')] = rRegla.get('CORV_CAMPO_EVALUACION');
                tmpExistenVarios = gsCgg_res_tipo_solicitud_regla.findExact('CRVAL_CODIGO',rRegla.get('CRVAL_CODIGO'),i+1);
                if(tmpExistenVarios<0)
                {
                    tmpReglaGuardar.CORV_CAMPO_EVALUACION = '['+Ext.util.JSON.encode(tmpParams)+']';//Ext.util.JSON.encode(tmpParams);
                    reglaJSON.push(tmpReglaGuardar);
                    tmpNombreRegla = null;
                }


            }
            else
            {
                tmpParams[rRegla.get('CORV_VALOR_1')] = rRegla.get('CORV_CAMPO_EVALUACION');
                if((i+1) == gsCgg_res_tipo_solicitud_regla.getCount())
                {
                    tmpReglaGuardar.CORV_CAMPO_EVALUACION = '['+Ext.util.JSON.encode(tmpParams)+']';//Ext.util.JSON.encode(tmpParams);
                    reglaJSON.push(tmpReglaGuardar);

                }


            }


        }
        return Ext.util.JSON.encode(reglaJSON);
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_operacion_validacion.
     * @returns ventana winFrmCgg_operacion_validacion.
     * @base FrmCgg_operacion_validacion.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_operacion_validacion;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_operacion_validacion.
     * @base FrmCgg_operacion_validacion.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_operacion_validacionCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_operacion_validacion desde una instancia.
 */
FrmCgg_operacion_validacion.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_operacion_validacion desde una instancia.
 */
FrmCgg_operacion_validacion.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_operacion_validacion,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_operacion_validacion.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_operacion_validacion desde una instancia.
 */
FrmCgg_operacion_validacion.prototype.loadData = function(){
    this.loadData();
}
