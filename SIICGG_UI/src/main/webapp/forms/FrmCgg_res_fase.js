/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_fase.
 * @param {String} INSENTENCIA_CGG_RES_FASE Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_FASE Registro de datos de la tabla Cgg_res_fase.
 * @constructor
 * @base FrmListadoCgg_res_fase
 * @author Besixplus Cia. Ltda.
 */
//function FrmCgg_res_fase(INSENTENCIA_CGG_RES_FASE,INRECORD_CGG_RES_FASE){
function FrmCgg_res_fase(INSENTENCIA_CGG_RES_FASE,INRECORD_PROCESO_FASE,INRECORD_CGG_RES_FASE){
    var inSentenciaCgg_res_fase = INSENTENCIA_CGG_RES_FASE;
    var inRecordProcesoFase=INRECORD_PROCESO_FASE;
    var inRecordCgg_res_fase=INRECORD_CGG_RES_FASE;
    var urlCgg_res_fase=URL_WS+"Cgg_res_fase";
    var tituloCgg_res_fase='Ingreso fase';
    var descCgg_res_fase='El formulario permite administrar informaci\u00f3n de la fase de un proceso';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE FASES
     */
    var txtCrfas_codigo = new Ext.form.TextField({
        id:'txtCrfas_codigo',
        name:'txtCrfas_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
     */
    var txtCrpro_codigo = new Ext.form.TextField({
        id:'txtCrpro_codigo',
        name:'txtCrpro_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20,
        visible: false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
     */
    var btnCrpro_codigoCgg_res_fase = new Ext.Button({
        id:'btnCrpro_codigoCgg_res_fase',
        text:'Crpro_codigo',
        iconCls:'iconCrpro_codigo',
        listeners:{
            click:function(){
                var tmpFLCgg_res_proceso = new FrmListadoCgg_res_proceso();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_proceso.getStore(),tmpFLCgg_res_proceso.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                        txtCrpro_codigo.setValue(tmpRecord.get('CRPRO_CODIGO'));
                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ESTADO DE TRAMITE RESPUESTA POSITIVA
     */
    var txtCrett_codigo = new Ext.form.TextField({
        id:'txtCrett_codigo',
        name:'txtCrett_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        maxLength :20
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ESTADO DE TRAMITE RESPUESTA POSITIVA
     */
    var txtCrett_nombre = new Ext.form.TextField({
        id:'txtCrett_nombre',
        name:'txtCrett_nombre',
        fieldLabel :'Res. positiva',
        anchor:'98%',
        readOnly:'true',
        maxLength :50
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE ESTADO DE TRAMITE RESPUESTA POSITIVA
     */
    var btnCrett_codigoCgg_res_fase = new Ext.Button({
        id:'btnCrett_codigoCgg_res_fase',
        iconCls:'iconBuscar',
        tooltip:'Buscar respuesta positiva estado de tr\u00E1mite',
        listeners:{
            click:function(){
                var tmpFLCgg_res_estado_tramite = new FrmListadoCgg_res_estado_tramite();
                var objBusquedaPositiva = new DlgBusqueda(tmpFLCgg_res_estado_tramite.getStore(),tmpFLCgg_res_estado_tramite.getColumnModel());
                objBusquedaPositiva.closeHandler(function(){
                    var tmpRecordPositiva = objBusquedaPositiva.getSelectedRow();
                    if(tmpRecordPositiva)
                    {
                        txtCrett_codigo.setValue(tmpRecordPositiva.get('CRETT_CODIGO'));
                        txtCrett_nombre.setValue(tmpRecordPositiva.get('CRETT_NOMBRE'));
                    }
                });
                objBusquedaPositiva.show();
            }
        }
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ESTADO DE TRAMITE RESPUESTA NEGATIVA
     */
    var txtCgg_crett_codigo = new Ext.form.TextField({
        id:'txtCgg_crett_codigo',
        name:'txtCgg_crett_codigo',
        fieldLabel :'Crett codigo',
        anchor:'98%',
        readOnly:'true',
        maxLength :20
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ESTADO DE TRAMITE RESPUESTA NEGATIVA
     */
    var txtCgg_crett_nombre = new Ext.form.TextField({
        id:'txtCgg_crett_nombre',
        name:'txtCgg_crett_nombre',
        fieldLabel :'Res. nega.',
        anchor:'98%',
        readOnly:'true',
        maxLength :50
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE ESTADO DE TRAMITE RESPUESTA NEGATIVA
     */
    var btnCgg_crett_codigoCgg_res_fase = new Ext.Button({
        id:'btnCgg_crett_codigoCgg_res_fase',
        iconCls:'iconBuscar',
        tooltip:'Buscar respuesta negativa estado de tr\u00E1mite',
        listeners:{
            click:function(){
                var tmpFLCgg_res_estado_tramite1 = new FrmListadoCgg_res_estado_tramite();
                var objBusquedaNegativa = new DlgBusqueda(tmpFLCgg_res_estado_tramite1.getStore(),tmpFLCgg_res_estado_tramite1.getColumnModel());
                objBusquedaNegativa.closeHandler(function(){
                    var tmpRecordNegativa = objBusquedaNegativa.getSelectedRow();
                    if(tmpRecordNegativa)
                    {
                        txtCgg_crett_codigo.setValue(tmpRecordNegativa.get('CRETT_CODIGO'));
                        txtCgg_crett_nombre.setValue(tmpRecordNegativa.get('CRETT_NOMBRE'));
                    }
                });
                objBusquedaNegativa.show();
            }
        }
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO SECCION
     */
    var txtCrsec_codigo = new Ext.form.TextField({
        id:'txtCrsec_codigo',
        name:'txtCrsec_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO SECCION
     */
    var txtCrsec_nombre = new Ext.form.TextField({
        id:'txtCrsec_nombre',
        name:'txtCrsec_nombre',
        fieldLabel :'Secci\u00F3n',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :50
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO SECCION
     */
    var btnCrsec_codigoCgg_res_fase = new Ext.Button({
        id:'btnCrsec_codigoCgg_res_fase',
        iconCls:'iconBuscar',
        tooltip:'Buscar secci\u00f3n encargada de supervisar fase',
        listeners:{
            click:function(){
                var tmpFLCgg_res_seccion = new FrmListadoCgg_res_seccion();
                var objBusquedaSeccion = new DlgBusqueda(tmpFLCgg_res_seccion.getStore(),tmpFLCgg_res_seccion.getColumnModel());
                objBusquedaSeccion.closeHandler(function(){
                    var tmpRecordSeccion = objBusquedaSeccion.getSelectedRow();
                    if(tmpRecordSeccion)
                    {
                        txtCrsec_codigo.setValue(tmpRecordSeccion.get('CRSEC_CODIGO'));
                        txtCrsec_nombre.setValue(tmpRecordSeccion.get('CRSEC_NOMBRE'));
                    }
                });
                objBusquedaSeccion.show();
            }
        }
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE FASES
     */
    var txtCgg_crfas_codigo = new Ext.form.TextField({
        id:'txtCgg_crfas_codigo',
        name:'txtCgg_crfas_codigo',
        fieldLabel :'Crfas codigo',
        anchor:'98%',
        readOnly:'true',
        maxLength :20
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE FASES
     */
    var btnCgg_crfas_codigoCgg_res_fase = new Ext.Button({
        id:'btnCgg_crfas_codigoCgg_res_fase',
        text:'Cgg_crfas_codigo',
        //iconCls:'',
        listeners:{
            click:function(){
                var tmpFLCgg_res_fase = new FrmListadoCgg_res_fase();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_fase.getStore(),tmpFLCgg_res_fase.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                        txtCgg_crfas_codigo.setValue(tmpRecord.get('CGG_CRFAS_CODIGO'));
                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO USUARIO
     */
    var txtCgg_cusu_codigo = new Ext.form.TextField({
        id:'txtCgg_cusu_codigo',
        name:'txtCgg_cusu_codigo',
        fieldLabel :'Cusu codigo',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20
//value:''
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO USUARIO
     */
    var btnCgg_cusu_codigoCgg_res_fase = new Ext.Button({
        id:'btnCgg_cusu_codigoCgg_res_fase',
        text:'Cgg_cusu_codigo',
        iconCls:'iconCgg_cusu_codigo',
        listeners:{
            click:function(){
                var tmpFLCgg_usuario = new FrmListadoCgg_usuario();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_usuario.getStore(),tmpFLCgg_usuario.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                        txtCgg_cusu_codigo.setValue(tmpRecord.get('CGG_CUSU_CODIGO'));
                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Ext.form.TextField INFORMACION DE IDENTIFICACION DE LA FASE
     */
    var txtCrfas_nombre = new Ext.form.TextField({
        id:'txtCrfas_nombre',
        name:'txtCrfas_nombre',
        fieldLabel :'Nombre',
        anchor:'98%',
        allowBlank :false,
        maxLength :100
    });
    /**
     * Ext.form.NumberField ORDEN DE EJECUCION DE LA FASE
     */
    var numCrfas_orden = new Ext.form.NumberField({
        id:'numCrfas_orden',
        nname:'numCrfas_orden',
        fieldLabel :'Orden',
        allowBlank :false,
        disabled :false
    });/**
     * Ext.form.TextField TAREA QUE SE REALIZA EN ESTA FASE DEL PROCESO
     */
    var txtCrfas_tarea_realiza = new Ext.form.TextField({
        id:'txtCrfas_tarea_realiza',
        name:'txtCrfas_tarea_realiza',
        fieldLabel :'Tarea a realizar',
        tooltip:'Descripci\u00f3n de la tarea que se realiza en esta fase',
        anchor:'98%',
        allowBlank :false,
        maxLength :200
    });

    function funcionEjecuta()
    {
        this.column = new Ext.grid.ColumnModel([
            {
                dataIndex:'PRONAME',
                header:'Funci\u00f3n',
                width:200,
                sortable:true
            },
            {
                dataIndex:'PRONARGS',
                header:'Prm.',
                width:50,
                sortable:true
            },
            {
                dataIndex:'PROARGNAMES',
                header:'Variables',
                width:200,
                sortable:true
            }
        ]);
        this.store = new Ext.data.Store({
            proxy: new Ext.ux.bsx.SoapProxy({
                url: URL_WS + "Cgg_regla_validacion",
                method: "selectFuncionPlSql",
                pagin:true
            }),
            remoteSort:true,
            reader: new Ext.data.JsonReader({
                root:'dataSet',
                totalProperty: 'totalCount'
            }, [
                {name: 'PRONAME'},
                {name: 'PRONARGS'},
                {name: 'PROARGNAMES'},
                {name: 'TYPNAME'}
            ]),
            sortInfo:{
                field: 'PRONAME',
                direction: 'ASC'
            },
            baseParams: {
                keyword:'',
                format: TypeFormat.JSON
            }
        });

    }

    /*stFuncionPlSql.reload({params:{
     start:0,
     limit:RECORD_PAGE
     }
     });*/


    /**
     * Ext.form.TextField NOMBRE DE LA FUNCION O PROCEDIMIENTO QUE SE EJECUTARIA EN LA FASE
     */
    var txtCrfas_funcion_ejecuta = new Ext.form.TextField({
        id:'txtCrfas_funcion_ejecuta',
        name:'txtCrfas_funcion_ejecuta',
        fieldLabel :'Funci\u00f3n a ejecutar',
        anchor:'98%',
        readOnly:true,
        allowBlank : true
    });

    var btnCgg_fase_fn_select = new Ext.Button({
        id:'btnCgg_fase_fn_select',
        iconCls:'iconBuscar',
        tooltip:'Buscar funcion a ejecutar',
        listeners:{
            click:function(){
                var objFuncionEjecuta = new funcionEjecuta();
                var objBusquedaFuncion = new DlgBusqueda(objFuncionEjecuta.store,objFuncionEjecuta.column);
                objBusquedaFuncion .closeHandler(function(){
                    var tmpRecordFuncion = objBusquedaFuncion.getSelectedRow();
                    if(tmpRecordFuncion){
                        txtCrfas_funcion_ejecuta.setValue(tmpRecordFuncion.get('PRONAME'));
                        chkCrfas_ejecuta_despacho.enable();
                        chkCrfas_ejecuta_despacho.setValue(true);
                    }
                });
                objBusquedaFuncion.show();
            }
        }
    });
    var btnCgg_fase_fn_delete = new Ext.Button({
        id:'btnCgg_fase_fn_delete',
        iconCls:'iconEliminar',
        tooltip:'Quitar funcion a ejecutar',
        listeners:{
            click:function(){
                txtCrfas_funcion_ejecuta.setValue(null);
                chkCrfas_ejecuta_despacho.disable();
                chkCrfas_ejecuta_despacho.setValue(false);
            }
        }
    });
    /**
     * Ext.form.Checkbox ESTADO QUE DETERMINA LA AUTORIZACION DE SUBIR ARCHIVOS ADJUNTOS
     */
    var chkCrfas_sube_adjunto = new Ext.form.Checkbox({
        id:'chkCrfas_sube_adjunto',
        name:'chkCrfas_sube_adjunto',
        fieldLabel :'Sube adjunto',
        tooltip:'Si se permite o no subir adjuntos en esta fase',
        allowBlank :false,
        checked:true
    });
    /**
     * Ext.form.Checkbox ESTADO QUE DETERMINA LA AUTORIZACION DE SUBIR ARCHIVOS ADJUNTOS DE REQUISITOS
     */
    var chkCrfas_sube_adjunto_requisito = new Ext.form.Checkbox({
        id:'chkCrfas_sube_adjunto_requisito',
        name:'chkCrfas_sube_adjunto_requisito',
        fieldLabel :'Sube adjuntos requisito',
        tooltip:'Si se permite o no subir adjuntos de requisitos en esta fase',
        allowBlank :false,
        checked:true
    });

    /**
     * Ext.form.Checkbox ESTADO QUE DETERMINA SI LA FUNCION SE EJECUTA AL REALIZAR DESPACHO O DISTRIBUCION
     */
    var chkCrfas_ejecuta_despacho = new Ext.form.Checkbox({
        id:'chkCrfas_ejecuta_despacho',
        name:'chkCrfas_ejecuta_despacho',
        fieldLabel :'Ejecuta despacho',
        allowBlank :false,
        checked:false,
        disabled :true
    });
    /**
     * Ext.form.Checkbox ESTADO QUE DETERMINA LA FASE SERA ATENDIDA EN FORMA NORMAL O A TRAVES DE OTRO PROCESO
     */
    var chkCrfas_atencion_normal = new Ext.form.Checkbox({
        id:'chkCrfas_atencion_normal',
        name:'chkCrfas_atencion_normal',
        fieldLabel :'Atencion normal',
        allowBlank :false,
        checked:true
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_fase
     */
    var btnGuardarCgg_res_fase = new Ext.Button({
        id:'btnGuardarCgg_res_fase',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:'Guardar fase',
        listeners:{
            click:function(){
                if (pnlCgg_res_fase.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_res_fase(r){
                        winFrmCgg_res_fase.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_res_fase,
                                msg: 'La informaci\u00f3n de fase ha sido almacenada correctamente.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            winFrmCgg_res_fase.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_res_fase,
                                msg: 'La informaci\u00f3n de fase NO ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_res_fase.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCrfas_codigo',txtCrfas_codigo.getValue());
                    param.add('inCrpro_codigo',txtCrpro_codigo.getValue());
                    param.add('inCrett_codigo',txtCrett_codigo.getValue()?txtCrett_codigo.getValue():null);
                    param.add('inCgg_crett_codigo',txtCgg_crett_codigo.getValue()?txtCgg_crett_codigo.getValue():null);
                    param.add('inCrsec_codigo',txtCrsec_codigo.getValue()?txtCrsec_codigo.getValue():null);
                    param.add('inCgg_crfas_codigo',txtCgg_crfas_codigo.getValue()?txtCgg_crfas_codigo.getValue():null);
                    param.add('inCgg_cusu_codigo',txtCgg_cusu_codigo.getValue()?txtCgg_cusu_codigo.getValue():null);
                    param.add('inCrfas_nombre',txtCrfas_nombre.getValue());
                    param.add('inCrfas_orden',numCrfas_orden.getValue()?numCrfas_orden.getValue():0);
                    param.add('inCrfas_tarea_realiza',txtCrfas_tarea_realiza.getValue());
                    param.add('inCrfas_funcion_ejecuta',txtCrfas_funcion_ejecuta.getValue());
                    param.add('inCrfas_sube_adjunto',chkCrfas_sube_adjunto.getValue());
                    param.add('inCrfas_sube_adjunto_requisito',chkCrfas_sube_adjunto_requisito.getValue());
                    param.add('inCrfas_ejecuta_despacho',chkCrfas_ejecuta_despacho.getValue());
                    param.add('inCrfas_atencion_normal',chkCrfas_atencion_normal.getValue());
                    param.add('inFaseUsuario_JSON',grdCgg_res_fase_usuario.getStore().getJsonData());
                    param.add('inFaseCriterio_JSON',grdCgg_jur_criterio.getStore().getJsonData());
                    param.add('inFaseNotificacion_JSON',grdCgg_res_fase_notificacion.getStore().getJsonData());
                    SOAPClient.invoke(urlCgg_res_fase,INSENTENCIA_CGG_RES_FASE + '1',param, true, CallBackCgg_res_fase);
                }catch(inErr){
                    winFrmCgg_res_fase.getEl().unmask();
                }
            }
        }
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_fase.
     */
    var btnCancelarCgg_res_fase = new Ext.Button({
        id:'btnCancelarCgg_res_fase',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:'Descarta la informaci\u00f3 ingresada',
        listeners:{
            click:function(){
                pnlCgg_res_fase.getForm().reset();
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_fase.
     */
    var btnCerrarCgg_res_fase = new Ext.Button({
        id:'btnCerrarCgg_res_fase',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:'Cerrar',
        listeners:{
            click:function(){
                winFrmCgg_res_fase.close();
            }
        }
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_fase_usuario.
     */
    var cmCgg_res_fase_usuario = new Ext.grid.ColumnModel([
        {
            dataIndex:'CRFSU_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true
        },
        {
            dataIndex:'CUSU_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true
        },
        {
            dataIndex:'CRFAS_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true
        },
        {
            dataIndex:'CRFSU_IDENTIFICACION',
            header:'Identificaci\u00f3n',
            width:150,
            sortable:true
        },
        {
            dataIndex:'CRFSU_NOMBRE',
            header:'Nombre',
            width:180,
            sortable:true
        },
        {
            dataIndex:'CISLA_NOMBRE',
            header:'Isla',
            width:150,
            sortable:true
        },
        {
            dataIndex:'CRFSU_ACTIVO',
            header:'Activo',
            width:80,
            sortable:true,
            xtype:'checkcolumn',
            editor:{
                xtype: 'checkbox'
            }
        }]);


    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_fase_usuario por un campo especifico.
     */
    var gsCgg_res_fase_usuario = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_fase_usuario",
            method:"selectUsuarioFase",
            pagin:false
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
        },[
            {
                name:'CRFSU_CODIGO'
            },

            {
                name:'CUSU_CODIGO'
            },

            {
                name:'CRFAS_CODIGO'
            },

            {
                name:'CRFSU_IDENTIFICACION'
            },

            {
                name:'CRFSU_NOMBRE'
            },

            {
                name:'CRFSU_ACTIVO'
            },

            {
                name:'CISLA_CODIGO'
            },

            {
                name:'CISLA_NOMBRE'
            }

        ]),
        baseParams:{
            inCrfas_codigo:'',
            format:"JSON"
        }
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_fase_usuario en un formato tabular de filas y columnas.
     */
    var grdCgg_res_fase_usuario = new Ext.grid.EditorGridPanel({
        cm:cmCgg_res_fase_usuario,
        store:gsCgg_res_fase_usuario,
        region:'center',
        anchor:'100% 100%',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        clicksToEdit:1,
        viewConfig:{
            forceFit:true
        },
        loadMask:{
            msg:"Cargando..."
        },
        tbar: [{
            xtype:'button',
            iconCls:'iconNuevo',
            tooltip:'Agregar usuario de fase',
            handler : function(){
                // if(grdCgg_res_fase_usuario.getStore().getCount() == 0)
                // {
                var tmpUsuarioFase = new Cgg_usuario();
                var objBusqueda = new DlgBusqueda(tmpUsuarioFase.getStore(),tmpUsuarioFase.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        if(gsCgg_res_fase_usuario.findExact('CUSU_CODIGO',tmpRecord.get('CUSU_CODIGO')) < 0)
                        {
                            var tmpRecordFaseUsuario = grdCgg_res_fase_usuario.getStore().recordType;
                            grdCgg_res_fase_usuario.getStore().insert(0,
                                    new tmpRecordFaseUsuario({
                                        CRFSU_CODIGO: 'KEYGEN',
                                        CUSU_CODIGO: tmpRecord.get('CUSU_CODIGO'),
                                        CRFAS_CODIGO: '',
                                        CRFSU_IDENTIFICACION: tmpRecord.get('CUSU_NOMBRE_USUARIO'),
                                        CRFSU_NOMBRE: tmpRecord.get('CRPER_NOMBRES') + ' '+ tmpRecord.get('CRPER_APELLIDO_PATERNO'),
                                        CRFSU_ACTIVO: 'true',
                                        CISLA_CODIGO:tmpRecord.get('CISLA_CODIGO'),
                                        CISLA_NOMBRE:tmpRecord.get('CISLA_NOMBRE')
                                    })
                                    );
                            grdCgg_res_fase_usuario.getView().refresh();
                        }
                        else
                        {
                            Ext.Msg.show({title:'Aviso', msg:'El usuario seleccionado ya esta asignado a la fase!!.', buttons: Ext.Msg.OK,icon: Ext.MessageBox.WARNING});
                        }
                    }
                });
                objBusqueda.show();
                /*}
                 else
                 {
                 Ext.Msg.show({title:'Aviso', msg:'S\u00f3lo puede asignarse un usuario por cada fase!!.', buttons: Ext.Msg.OK,icon: Ext.MessageBox.WARNING});
                 }*/
            }
        },
            {
                xtype:'button',
                iconCls:'iconEliminar',
                tooltip:'Eliminar usuario de fase',
                handler : function(){
                    if (grdCgg_res_fase_usuario.getSelectionModel().getSelected().get('CRFSU_CODIGO') != 'KEYGEN')
                    {
                        function SWRCgg_res_fase_usuario(btn){
                            if (btn=='yes'){
                                try{
                                    function CallBackCgg_res_fase_usuario(r){
                                        winFrmCgg_res_fase.getEl().unmask();
                                        if(r=='true'){
                                            grdCgg_res_fase_usuario.stopEditing();
                                            grdCgg_res_fase_usuario.getStore().remove(grdCgg_res_fase_usuario.getSelectionModel().getSelected());
                                            grdCgg_res_fase_usuario.getView().refresh();
                                            grdCgg_res_fase_usuario.getSelectionModel().selectRow(0);
                                            //gsCgg_res_fase_usuario.reload();
                                        }else{
                                            Ext.Msg.show({
                                                title:tituloCgg_res_fase,
                                                msg: 'La informaci\u00f3n de usuario no ha podido ser eliminada.',
                                                buttons: Ext.Msg.OK,
                                                icon: Ext.MessageBox.ERROR
                                            });
                                        }
                                    }
                                    winFrmCgg_res_fase.getEl().mask('Eliminando...', 'x-mask-loading');
                                    var param = new SOAPClientParameters();
                                    param.add('inCrfsu_codigo',grdCgg_res_fase_usuario.getSelectionModel().getSelected().get('CRFSU_CODIGO'));
                                    SOAPClient.invoke(URL_WS+"Cgg_res_fase_usuario","delete",param, true, CallBackCgg_res_fase_usuario);
                                }catch(inErr){
                                    winFrmCgg_res_fase.getEl().unmask();
                                }
                            }
                        }
                        Ext.Msg.show({
                            title:'Aviso',
                            msg:'Est\u00e1 seguro de eliminar?',
                            buttons: Ext.Msg.YESNO,
                            fn: SWRCgg_res_fase_usuario,
                            icon: Ext.MessageBox.QUESTION
                        });
                    }
                    else
                    {
                        grdCgg_res_fase_usuario.stopEditing();
                        grdCgg_res_fase_usuario.getStore().remove(grdCgg_res_fase_usuario.getSelectionModel().getSelected());
                        grdCgg_res_fase_usuario.getView().refresh();
                        grdCgg_res_fase_usuario.getSelectionModel().selectRow(0);
                    }
//grdCgg_res_fase_usuario.getStore().remove()


                }
            }]
    });

    /*
     * Ext.ux.grid.RowEditor Editor de filas personalizado para utilización en el grid de criterio
     */
    var reCriterio= new Ext.ux.grid.RowEditor({
        saveText: 'Aceptar',
        cancelText:'Cancelar',
        listeners:{
            validateedit:function(inRowEditor,inObject,inRecord,inRowIndex){
            },
            canceledit:function(inRowEditor,inFlag){
                var inRecord= grdCgg_jur_criterio.getStore().getAt(0);
                if(inRecord.get('CJCRI_CODIGO') == 'KEYGEN')
                {
                    if (inRecord.get('CJCRI_REQUERIMIENTO').length == 0)
                    {
                        grdCgg_jur_criterio.getStore().remove(inRecord);
                    }
                }
            }
        }
    });
//Deifine las columnas de la tabla cgg_pra_contacto.
    var cmCgg_jur_criterio = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
        {
            dataIndex:'CJCRI_CODIGO',
            hidden:true,
            header:'Codigo',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CRFAS_CODIGO',
            hidden:true,
            header:'Codigo',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CJCRI_REQUERIMIENTO',
            header:'Requerimiento',
            width:400,
            sortable:true,
            editor:new Ext.form.TextField({
                allowBlank:false
            })
        },

        {
            dataIndex:'CJCRI_REQUERIDO',
            header:'Requerido',
            width:400,
            sortable:true,
            xtype:'checkcolumn',
            editor: {
                xtype: 'checkbox'
            }
        }]);

//Agrupacion de registros de la tabla Cgg_pra_contacto por un campo especifico.*/
    var gsCgg_jur_criterio = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_jur_criterio",
            method:"selectCriterioFase",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
        },[
            {
                name:'CJCRI_CODIGO'
            },

            {
                name:'CRFAS_CODIGO'
            },

            {
                name:'CJCRI_REQUERIMIENTO'
            },

            {
                name:'CJCRI_REQUERIDO'
            }
        ]),
        sortInfo:{
            field: 'CRFAS_CODIGO',
            direction: 'ASC'
        },
        baseParams:{}
    });


//Reprentacion de datos de la tabla Cgg_pra_contacto en un formato tabular de filas y columnas.*/

    var grdCgg_jur_criterio = new Ext.grid.EditorGridPanel({
        //frame:true,
        cm:cmCgg_jur_criterio,
        store:gsCgg_jur_criterio,
        region:'center',
        anchor:'100% 100%',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        viewConfig:{
            forceFit:true
        },
        loadMask:{
            msg:"Cargando..."
        },
        plugins:[reCriterio],
        tbar: [{
            // xtype:'button',
            iconCls:'iconNuevo',
            tooltip:'Agregar requisito de fase',
            handler : function(){ // Agrego filas
                var tmpRecordCriterio = grdCgg_jur_criterio.getStore().recordType;
                reCriterio.stopEditing();
                grdCgg_jur_criterio.getStore().insert(0,
                        new tmpRecordCriterio({
                            CJCRI_CODIGO: 'KEYGEN',
                            CRFAS_CODIGO: 'KEYGEN',
                            CJCRI_REQUERIMIENTO: '',
                            CJCRI_REQUERIDO: 'true'
                        })
                        );
                grdCgg_jur_criterio.getView().refresh();
                reCriterio.startEditing(0,3);
            }
        },
            {
                xtype:'button',
                iconCls:'iconEliminar',
                tooltip:'Eliminar requisito de fase',
                handler : function(){ // Agrego filas
                    if (grdCgg_jur_criterio.getSelectionModel().getSelected().get('CJCRI_CODIGO') != 'KEYGEN')
                    {

                        function SWRCgg_jur_criterio(btn){
                            if (btn=='yes'){
                                try{
                                    function CallBackCgg_jur_criterio(r){
                                        winFrmCgg_res_fase.getEl().unmask();
                                        if(r=='true'){
                                            grdCgg_jur_criterio.stopEditing();
                                            gsCgg_jur_criterio.remove(grdCgg_jur_criterio.getSelectionModel().getSelected());
                                            grdCgg_jur_criterio.getView().refresh();
                                            grdCgg_jur_criterio.getSelectionModel().selectRow(0);
                                            //gsCgg_jur_criterio.reload();
                                        }else{
                                            Ext.Msg.show({
                                                title:tituloCgg_res_fase,
                                                msg: 'La informaci\u00f3n del criterio no ha podido ser eliminada.',
                                                buttons: Ext.Msg.OK,
                                                icon: Ext.MessageBox.ERROR
                                            });
                                        }
                                    }
                                    winFrmCgg_res_fase.getEl().mask('Eliminando...', 'x-mask-loading');
                                    var param = new SOAPClientParameters();
                                    param.add('inCjcri_codigo',grdCgg_jur_criterio.getSelectionModel().getSelected().get('CJCRI_CODIGO'));
                                    SOAPClient.invoke(URL_WS+"Cgg_jur_criterio","deleteTrusted",param, true, CallBackCgg_jur_criterio);
                                }catch(inErr){
                                    winFrmCgg_res_fase.getEl().unmask();
                                }
                            }
                        }
                        Ext.Msg.show({
                            title:'Aviso',
                            msg:'Est\u00e1 seguro de eliminar?',
                            buttons: Ext.Msg.YESNO,
                            fn: SWRCgg_jur_criterio,
                            icon: Ext.MessageBox.QUESTION
                        });
                    }
                    else
                    {
                        grdCgg_jur_criterio.stopEditing();
                        gsCgg_jur_criterio.remove(grdCgg_jur_criterio.getSelectionModel().getSelected());
                        grdCgg_jur_criterio.getView().refresh();
                        grdCgg_jur_criterio.getSelectionModel().selectRow(0);
                    }


                }
            }]
    });

    //AC==>

    /*
     * Ext.ux.grid.RowEditor Editor de filas personalizado para utilización en el grid de notificaciones
     */
    var reNotification= new Ext.ux.grid.RowEditor({
        saveText: 'Aceptar',
        cancelText:'Cancelar',
        listeners:{
            validateedit:function(inRowEditor,inObject,inRecord,inRowIndex){
            },
            canceledit:function(inRowEditor,inFlag){
                var inRecord= grdCgg_res_fase_notificacion.getStore().getAt(0);
                if(inRecord.get('CJCRI_CODIGO') == 'KEYGEN')
                {
                    if (inRecord.get('CJCRI_REQUERIMIENTO').length == 0)
                    {
                        grdCgg_res_fase_notificacion.getStore().remove(inRecord);
                    }
                }
            }
        }
    });

    var dsDestinatarios = [['AUSP','Auspiciante'],['BENF','Beneficiario'], ['USUA','Funcionario Fase'], ['GOB','Gobierno de Gal\u00F1pagos']];
    var dsMensajes = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_not_mail",
            method:"selectAll"
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({},[
            {
                name:'ntml_codigo'
            },

            {
                name:'ntml_name'
            },

            {
                name:'ntml_description'
            }
        ]),
        listeners:{
            load:function(){
                dsMensajes.sort('ntml_name','ASC');
            }
        }
    });
    dsMensajes.load();
    var cmbMensajes = new Ext.form.ComboBox({
        id:"cmbMensajes",
        store:dsMensajes,
        mode: 'local',
        forceSelection:true,
        displayField:'ntml_name',
        typeAhead: true,
        triggerAction:'all',
        emptyText:'Seleccione un Mensaje',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{ntml_description}" class="x-combo-list-item">{ntml_name}</div></tpl>',
        valueField:'ntml_codigo'
    });
    var cmbDestinatarios = new Ext.form.ComboBox({
        id:"cmbDestinatarios",
        store:dsDestinatarios,
        mode: 'local',
        forceSelection:true
    });
    
    //Deifine las columnas de la tabla cgg_pra_contacto.
    var cmCgg_not_fase_notification = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
        {
            dataIndex:'CRPRO_CODIGO',
            hidden:true,
            header:'Codigo',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CRFAS_CODIGO',
            hidden:true,
            header:'Codigo',
            width:150,
            sortable:true
        },

        {
            dataIndex:'NTML_CODIGO',
            header:'Mensaje',
            width:400,
            sortable:true,
            editor:cmbMensajes,
            renderer:function(inNtml_codigo){
                var i =0;
                var result = 'no datos';
                for(i=0;i<dsMensajes.getCount();i++){
                    var rRequisito = dsMensajes.getAt(i);
                    if(rRequisito.get('ntml_codigo') == inNtml_codigo){
                        result = rRequisito.get('ntml_name');
                        break;
                    }
                }
                return result;
            }
        },

        {
            dataIndex:'NTFN_DESTINATARIO',
            header:'Destinatario',
            width:400,
            sortable:true,
            editor: cmbDestinatarios
        }]);

    //Agrupacion de registros de la tabla Cgg_pra_contacto por un campo especifico.*/
    var gsCgg_not_fase_notification = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_not_fase_notification",
            method:"selectByFase",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
        },[
            {
                name:'CRPRO_CODIGO'
            },

            {
                name:'CRFAS_CODIGO'
            },

            {
                name:'NTML_CODIGO'
            },

            {
                name:'NTFN_DESTINATARIO'
            }
        ]),
        sortInfo:{
            field: 'NTML_CODIGO',
            direction: 'ASC'
        },
        baseParams:{}
    });


    var grdCgg_res_fase_notificacion = new Ext.grid.EditorGridPanel({
        cm:cmCgg_not_fase_notification,
        store:gsCgg_not_fase_notification,
        region:'center',
        anchor:'100% 100%',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        viewConfig:{
            forceFit:true
        },
        loadMask:{
            msg:"Cargando..."
        },
        plugins:[reNotification],
        tbar: [{
            // xtype:'button',
            iconCls:'iconNuevo',
            tooltip:'Agregar notificaci\u00F3n',
            handler : function(){ // Agrego filas
                var tmpRecordCriterio = grdCgg_res_fase_notificacion.getStore().recordType;
                reNotification.stopEditing();
                grdCgg_res_fase_notificacion.getStore().insert(0,
                    new tmpRecordCriterio({
                        CRPRO_CODIGO: 'KEYGEN',
                        CRFAS_CODIGO: 'KEYGEN',
                        NTML_CODIGO: '',
                        NTFN_DESTINATARIO: ''
                    })
                );
                grdCgg_res_fase_notificacion.getView().refresh();
                reNotification.startEditing(0,3);
            }
        },
            {
                xtype:'button',
                iconCls:'iconEliminar',
                tooltip:'Eliminar notificaci\u00F3n',
                handler : function(){ // Agrego filas
                    if (grdCgg_res_fase_notificacion.getSelectionModel().getSelected().get('CRFAS_CODIGO') != 'KEYGEN')
                    {

                        function SWRCgg_res_fase_notificacion(btn){
                            if (btn=='yes'){
                                try{
                                    function CallBackCgg_res_fase_notificacion(r){
                                        winFrmCgg_res_fase.getEl().unmask();
                                        if(r=='true'){
                                            grdCgg_res_fase_notificacion.stopEditing();
                                            gsCgg_not_fase_notification.remove(grdCgg_res_fase_notificacion.getSelectionModel().getSelected());
                                            grdCgg_res_fase_notificacion.getView().refresh();
                                            grdCgg_res_fase_notificacion.getSelectionModel().selectRow(0);
                                            //gsCgg_jur_criterio.reload();
                                        }else{
                                            Ext.Msg.show({
                                                title:tituloCgg_res_fase,
                                                msg: 'La informaci\u00f3n de la notificaci\u00F3n no ha podido ser eliminada.',
                                                buttons: Ext.Msg.OK,
                                                icon: Ext.MessageBox.ERROR
                                            });
                                        }
                                    }
                                    winFrmCgg_res_fase.getEl().mask('Eliminando...', 'x-mask-loading');
                                    var param = new SOAPClientParameters();
                                    param.add("inCrpro_codigo",grdCgg_res_fase_notificacion.getSelectionModel().getSelected().get('CRPRO_CODIGO'));
                                    param.add("inCrfas_codigo",grdCgg_res_fase_notificacion.getSelectionModel().getSelected().get('CRFAS_CODIGO'));
                                    param.add("inNtml_codigo",grdCgg_res_fase_notificacion.getSelectionModel().getSelected().get('NTML_CODIGO'));
                                    param.add("inNtfn_destinatario",grdCgg_res_fase_notificacion.getSelectionModel().getSelected().get('NTFN_DESTINATARIO'));
                                    SOAPClient.invoke(URL_WS+"Cgg_not_fase_notification","deleteTrusted",param, true, CallBackCgg_res_fase_notificacion);
                                }catch(inErr){
                                    winFrmCgg_res_fase.getEl().unmask();
                                }
                            }
                        }
                        Ext.Msg.show({
                            title:'Aviso',
                            msg:'Est\u00e1 seguro de eliminar?',
                            buttons: Ext.Msg.YESNO,
                            fn: SWRCgg_res_fase_notificacion,
                            icon: Ext.MessageBox.QUESTION
                        });
                    }
                    else
                    {
                        grdCgg_res_fase_notificacion.stopEditing();
                        gsCgg_not_fase_notification.remove(grdCgg_res_fase_notificacion.getSelectionModel().getSelected());
                        grdCgg_res_fase_notificacion.getView().refresh();
                        grdCgg_res_fase_notificacion.getSelectionModel().selectRow(0);
                    }


                }
            }]
    });


    var tabpnlOpciones = new Ext.TabPanel({
        activeTab: 0,
        frame:false,
        region:'south',
		//minHeight:250,
		height:225,
        items:[
            {
                xtype:'panel',
                layout:'border',
                title:'Usuario',
                //frame:false,
                items:[grdCgg_res_fase_usuario]
            },
            {
                xtype:'panel',
                layout:'border',
                //frame:false,
                title:'Requerimientos',
                items:[grdCgg_jur_criterio]
            },
            {
                xtype:'panel',
                layout:'border',
                //frame:false,
                title:'Notificaciones',
                items:[grdCgg_res_fase_notificacion]
            }
        ]
    });

    var fldControlRespuesta = new Ext.form.FieldSet({
        id:'fldControlRespuesta',
        checkboxName:'chkControlRespuesta',
        checkboxToggle:true,
        title: 'Altera respuesta de tr\u00e1mite',
        autoHeight:true,
        labelWidth:100,
        collapsed: false,
        items :[
            {
                xtype:'panel',
                layout:'column',
                items:[
                    {
                        columnWidth:.6,
                        layout:'form',
                        items:[txtCrett_nombre]
                    },
                    {
                        columnWidth:.4,
                        layout:'form',
                        items:[btnCrett_codigoCgg_res_fase]
                    }
                ]
            },
            {
                xtype:'panel',
                layout:'column',
                items:[
                    {
                        columnWidth:.6,
                        layout:'form',
                        items:[txtCgg_crett_nombre]
                    },
                    {
                        columnWidth:.4,
                        layout:'form',
                        items:[btnCgg_crett_codigoCgg_res_fase]
                    }
                ]
            }
        ],
        listeners:
        {
            collapse:function(){
				tabpnlOpciones.setHeight(tabpnlOpciones.getHeight()+50);
				winFrmCgg_res_fase.doLayout(true);
				txtCgg_crett_codigo.setValue(null);
                txtCrett_codigo.setValue(null);
                txtCgg_crett_nombre.setValue(null);
                txtCrett_nombre.setValue(null);
            },
            expand:function(){
				tabpnlOpciones.setHeight(tabpnlOpciones.getHeight()-50);
				winFrmCgg_res_fase.doLayout(true);
            }
        }

    });

    var pnlRespuesta = new Ext.Panel({
        labelWidth: 75,
        frame:false,
        items: [fldControlRespuesta]
    });

    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_fase.
     */
    var pnlCgg_res_fase = new Ext.form.FormPanel({
        frame:true,
        labelWidth :110,
        region:'center',
        items:[{
            layout:'column',
            bodyStyle:'padding:0px 0px 0px 0px;',
            items:[
                {
                    columnWidth: .2,
                    layout: 'form',
                    bodyStyle:'padding:10px 0px 0px 0px;',
                    items:[{
                        html: 	'<div>'+
                                '  	<div class="tituloGeneral">Proceso :</div>'+
                                '  	<div class="tituloGeneral">Fase principal:</div>'+
                                '</div>'
                    }]
                },
                {
                    columnWidth: .6,
                    layout: 'form',
                    bodyStyle:'padding:10px 0px 0px 0px;',
                    items:[{
                        html: 	'<SPAN style="color:blue">'+
                                '  	<div id="divProceso" class="itemGeneral">.</div>'+
                                '  	<div id="divFase" class="itemGeneral">.</div>'+
                                '</SPAN>'
                    }]
                }
            ]
        },
            txtCrfas_nombre,txtCrfas_tarea_realiza,
            {
                xtype:'panel',
                layout:'column',
                items:[
                    {
                        columnWidth:.6,
                        layout:'form',
                        items:[txtCrsec_nombre]
                    },
                    {
                        columnWidth:.4,
                        layout:'form',
                        items:[btnCrsec_codigoCgg_res_fase]
                    }
                ]
            },
            {
                xtype:'panel',
                layout:'column',
                items:[
                    {
                        columnWidth:.5,
                        layout:'form',
                        items:[chkCrfas_sube_adjunto]
                    },
                    {
                        columnWidth:.5,
                        layout:'form',
                        labelWidth:150,
                        items:[chkCrfas_sube_adjunto_requisito]
                    }
                ]
            },{
                xtype:'panel',
                layout:'column',
                items:[
                    {
                        columnWidth:.5,
                        layout:'form',
                        items:[chkCrfas_ejecuta_despacho]
                    },
                    {
                        columnWidth:.5,
                        layout:'form',
                        labelWidth:150,
                        items:[chkCrfas_atencion_normal]
                    }
                ]
            },{
                xtype:'panel',
                layout:'column',
                items:[
                    {
                        columnWidth:.8,
                        layout:'form',
                        items:[txtCrfas_funcion_ejecuta]
                    },
                    {
                        columnWidth:.2,
                        layout:'hbox',
                        items:[btnCgg_fase_fn_select,btnCgg_fase_fn_delete]
                    }
                ]
            }
            ,pnlRespuesta]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_fase.
     */
    var winFrmCgg_res_fase = new Ext.Window({
        id:'winFrmCgg_res_fase',
        title:tituloCgg_res_fase,
        tbar:getPanelTitulo(tituloCgg_res_fase,descCgg_res_fase),
        items:[pnlCgg_res_fase,tabpnlOpciones],
        layout:'border',
        width:600,
        minWidth:600,
        minHeight:630,
        height:630,
        maximizable:false,
        minimizable:false,
        modal:true,
        constrain:true,
        bbar:[btnGuardarCgg_res_fase,btnCancelarCgg_res_fase,'->',btnCerrarCgg_res_fase],
        listeners:{
            show:function(){
                if (inRecordProcesoFase)
                {
                    if (inSentenciaCgg_res_fase == 'insert')
                    {
                        txtCrpro_codigo.setValue(inRecordProcesoFase.CRPRO_CODIGO);
                        if ( inRecordProcesoFase.CGG_CRFAS_CODIGO.length > 0 )
                            txtCgg_crfas_codigo.setValue(inRecordProcesoFase.CGG_CRFAS_CODIGO);
                        else
                            txtCgg_crfas_codigo.setValue(null);
                    }
                    document.getElementById('divProceso').innerHTML=inRecordProcesoFase.CRPRO_NOMBRE.toUpperCase();
                    document.getElementById('divFase').innerHTML=inRecordProcesoFase.CGG_CRFAS_NOMBRE?inRecordProcesoFase.CGG_CRFAS_NOMBRE.toUpperCase():'PROCESO';

                }
                if(inRecordCgg_res_fase){
                    if (txtCgg_crett_codigo.getValue() || txtCrett_codigo.getValue() )
                    {
                        fldControlRespuesta.expand(false);
                    }
                    else
                    {
                        fldControlRespuesta.collapse(false);
                    }

                }
            }
        }
    });
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_fase.
     */
    function cargarCgg_res_faseCtrls(){
        if(inRecordCgg_res_fase){
            txtCrfas_codigo.setValue(inRecordCgg_res_fase['CRFAS_CODIGO']);
            txtCrpro_codigo.setValue(inRecordCgg_res_fase['CRPRO_CODIGO']);
            txtCrett_nombre.setValue(inRecordCgg_res_fase['CRETT_NOMBRE']);
            txtCrett_codigo.setValue(inRecordCgg_res_fase['CRETT_CODIGO']);
            txtCgg_crett_nombre.setValue(inRecordCgg_res_fase['CGG_CRETT_NOMBRE']);
            txtCgg_crett_codigo.setValue(inRecordCgg_res_fase['CGG_CRETT_CODIGO']);
            txtCrsec_codigo.setValue(inRecordCgg_res_fase['CRSEC_CODIGO']);
            txtCrsec_nombre.setValue(inRecordCgg_res_fase['CRSEC_NOMBRE']);
            txtCgg_crfas_codigo.setValue(inRecordCgg_res_fase['CGG_CRFAS_CODIGO']);
            txtCgg_cusu_codigo.setValue(inRecordCgg_res_fase['CGG_CUSU_CODIGO']);
            txtCrfas_nombre.setValue(inRecordCgg_res_fase['CRFAS_NOMBRE']);
            numCrfas_orden.setValue(inRecordCgg_res_fase['CRFAS_ORDEN']);
            txtCrfas_tarea_realiza.setValue(inRecordCgg_res_fase['CRFAS_TAREA_REALIZA']);
            txtCrfas_funcion_ejecuta.setValue(inRecordCgg_res_fase['CRFAS_FUNCION_EJECUTA']);
            chkCrfas_sube_adjunto.setValue(inRecordCgg_res_fase['CRFAS_SUBE_ADJUNTO']);
            chkCrfas_sube_adjunto_requisito.setValue(inRecordCgg_res_fase['CRFAS_SUBE_ADJUNTO_REQUISITO']);
            chkCrfas_ejecuta_despacho.setValue(inRecordCgg_res_fase['CRFAS_EJECUTA_DESPACHO']);
            chkCrfas_atencion_normal.setValue(inRecordCgg_res_fase['CRFAS_ATENCION_NORMAL']);
            if (inRecordCgg_res_fase['CRFAS_FUNCION_EJECUTA'])
            {
                chkCrfas_ejecuta_despacho.enable();
            }
            isEdit = true;
            gsCgg_res_fase_usuario.reload({
                params:{
                    inCrfas_codigo:inRecordCgg_res_fase['CRFAS_CODIGO'],
                    format:TypeFormat.JSON
                }
            });
            gsCgg_jur_criterio.reload({
                params:{
                    inCrfas_codigo:inRecordCgg_res_fase['CRFAS_CODIGO'],
                    format:TypeFormat.JSON
                }
            });
            gsCgg_not_fase_notification.reload({
                params:{
                    inCrfas_codigo:inRecordCgg_res_fase['CRFAS_CODIGO']
                }
            });
        }
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_fase.
     * @returns ventana winFrmCgg_res_fase.
     * @base FrmCgg_res_fase.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_fase;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_fase.
     * @base FrmCgg_res_fase.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_faseCtrls();
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_fase desde una instancia.
 */
FrmCgg_res_fase.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_fase desde una instancia.
 */
FrmCgg_res_fase.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_fase,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_fase.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_fase desde una instancia.
 */
FrmCgg_res_fase.prototype.loadData = function(){
    this.loadData();
}

