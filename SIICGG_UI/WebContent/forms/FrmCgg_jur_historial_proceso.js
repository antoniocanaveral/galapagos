/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_jur_historial_proceso.
 * @param {String} IN_SENTENCIA_CGG_JUR_HISTORIAL_PROCESO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_JUR_HISTORIAL_PROCESO Registro de datos de la tabla Cgg_jur_historial_proceso.
 * @constructor
 * @base FrmListadoCgg_jur_historial_proceso
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_jur_historial_proceso(IN_SENTENCIA_CGG_JUR_HISTORIAL_PROCESO,IN_RECORD_CGG_JUR_HISTORIAL_PROCESO){
    var inSentenciaCgg_jur_historial_proceso = IN_SENTENCIA_CGG_JUR_HISTORIAL_PROCESO;
    var inRecordCgg_jur_historial_proceso=IN_RECORD_CGG_JUR_HISTORIAL_PROCESO;
    var urlCgg_jur_historial_proceso=URL_WS+"Cgg_jur_historial_proceso";
    var tituloCgg_jur_historial_proceso='Historial Proceso Judicial';
    var descCgg_jur_historial_proceso='El formulario permite administrar la informaci\u00f3n de Historial Proceso Judicial';
    var isEdit = false;
    var tmpCjpju_codigo;
    var lisEliAdjuntosHp = new Array ();
    var tmpListadoEliminar1;
    var tmpValorEstado = 'false';
    /**
     * new Ext.Panel PANEL PARA LA VISUALIZACION LOS PROCESOS JURIDICOS
     */
    var pnlProcesoJuridico = new Ext.Panel({
        tbar:[{type:'button',id:'btnProcesoJuridico',text:'Proceso Juridico',iconCls:'iconBuscar',handler:function(){
            var tmpProcesoJuridico = new Cgg_jur_proceso_judicial();
            var objBusqueda = new DlgBusqueda(tmpProcesoJuridico.getStoreProcesoJudicial(), tmpProcesoJuridico.getColumnProcesoJudicial());
            objBusqueda.closeHandler(function () {
                tmpProcesoJuridico = objBusqueda.getSelectedRow();

                if (tmpProcesoJuridico) {
                    document.getElementById('divInfoProcesoJuridico').innerHTML =tmpInfoProcesoJuridico1.apply(tmpProcesoJuridico.json);
                    tmpCjpju_codigo=tmpProcesoJuridico.get('CJPJU_CODIGO');
                    cbxCjpju_estado_ejecucion_HP.setValue(tmpProcesoJuridico.get('CJPJU_ESTADO_EJECUCION'));
                }
            });
            objBusqueda.show();
        }}],
        //bodyStyle:'padding:0px 0px 0px 0px;',
        frame:true,
        height:160,
        html:'<div id="divInfoProcesoJuridico" style="padding:0px 0px 0px 0px;"></div>'
    });
    /**
     * new Ext.XTemplate XTEMPLATE PARA LA VISUALIZACION DE LA INFORMACION  DE LOS PROCESOS JURIDICOS EN EL PANEL pnlProcesoJuridico
     */
    var tmpInfoProcesoJuridico1 = new Ext.XTemplate(
            '<table width="100%" height="100%" cellpadding="0">' +
                    '<tr rowspan="0"><td>' +
                    '<div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Tipo Persona</font></div></td>' +
                // '<td><div class="itemTemplate"><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{CJPJU_TIPO_ADVERSARIO}</span></div></td></tr>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">' +
                    '<tpl if="CJPJU_TIPO_ADVERSARIO ==TypeAdversario.PERSONA_NATURAL">'+
                    '<span style="font-weight: bold;">Persona Natural</span>',
            '</tpl>',
            '<tpl if="CJPJU_TIPO_ADVERSARIO ==TypeAdversario.PERSONA_JURIDICA">',
            '<b>Persona Juridica</b>',
            '</tpl>',
            '</font></td></tr>' +
                    '<tr rowspan="0">' +
                    '<div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Persona Natural</font></div></td>' +
                    '<td><div class="itemTemplate"><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{PERSONA}</span></div></td>' +
                    '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Persona Jur\u00eddica</font></div></td>' +
                    '<td><div class="itemTemplate"><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{RAZON_SOCIAL}</span></div></td></tr>' +
                    '<tr rowspan="0">' +
                    '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">N\u00famero</font></div></td>' +
                    '<td><div class="itemTemplate"><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{CJPJU_NUMERO}</span></div></td>' +
                    '<div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Tipo</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">' +
                    '<tpl if="CJPJU_TIPO_PROCESO ==TypeTipoProceso.Demanda_Planteada">'+
                    '<span style="font-weight: bold;">Demanda Planteada</span>',
            '</tpl>',
            '<tpl if="CJPJU_TIPO_PROCESO ==TypeTipoProceso.Demanda_Recibida">',
            '<b>Demanda Recibida</b>',
            '</tpl>',
            '</font></td></tr>' +
                    '<tr rowspan="0">' +
                    '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Cant\u00f3n</font></div></td>' +
                    '<td><div class="itemTemplate"><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{CANTON}</span></div></td>' +
                    '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Estado</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif"><tpl if="CJPJU_ESTADO_EJECUCION ==TypeEstadoEjecucion.Planteado">'+
                    '<span style="font-weight: bold;">Planteado</span>',
            '</tpl>',
            '<tpl if="CJPJU_ESTADO_EJECUCION ==TypeEstadoEjecucion.En_Proceso">',
            '<b>En Proceso</b>',
            '</tpl>',
            '<tpl if="CJPJU_ESTADO_EJECUCION ==TypeEstadoEjecucion.Finalizado">',
            '<b>Finalizado</b>',
            '</tpl>',
            '<tpl if="CJPJU_ESTADO_EJECUCION ==TypeEstadoEjecucion.Suspendido">',
            '<b>Suspendido</b>',
            '</tpl>',

            '</font></td></tr>' +
                    '<tr rowspan="0">' +
                    '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif"> Fecha Inicio</font></div></td>' +
                    '<td><div class="itemTemplate"><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{[this.myFecha_Inicio(values.CJPJU_FECHA_INICIO)]}</span></div>' +
                    '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif"> Fecha Suscripci\u00f3n</font></div></td>' +
                    '<td><div class="itemTemplate"><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{[this.myFecha_Finalizacion(values.CJPJU_FECHA_FINALIZACION)]}</span></div></td></tr>' +

                    '</td></tr></table>',
    {
        // XTemplate configuration:
        disableFormats: true,
        // member functions:
        myFecha_Inicio: function(CJPJU_FECHA_INICIO){
            return truncDate(CJPJU_FECHA_INICIO);
        },
        myFecha_Finalizacion: function(CJPJU_FECHA_FINALIZACION){
            return truncDate(CJPJU_FECHA_FINALIZACION);
        }
    }
            );
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DEL HISTORIAL DEL PROCESO JUDICIAL
     */
    var txtCjhtp_codigo = new Ext.form.TextField({
        id:'txtCjhtp_codigo',
        name:'txtCjhtp_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
     */
    var txtCjpju_codigo = new Ext.form.TextField({
        id:'txtCjpju_codigo',
        name:'txtCjpju_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
     */
    var btnCjpju_codigoCgg_jur_historial_proceso = new Ext.Button({
        id:'btnCjpju_codigoCgg_jur_historial_proceso',
        text:'Cjpju_codigo',
        iconCls:'iconCjpju_codigo',
        listeners:{
            click:function(){
                var tmpFLCgg_jur_proceso_judicial = new FrmListadoCgg_jur_proceso_judicial();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_jur_proceso_judicial.getStore(),tmpFLCgg_jur_proceso_judicial.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                        txtCjpju_codigo.setValue(tmpRecord.get('CJPJU_CODIGO'));
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextArea DESCRIPCION DEL MOVIMIENTO DEL PROCESO JUDICIAL
     */
    var txtCjhtp_descripcion = new Ext.form.TextArea({
        id:'txtCjhtp_descripcion',
        name:'txtCjhtp_descripcion',
        fieldLabel :'Descripci\u00f3n',
        width:'98%',
        allowBlank :false
    });
    /**
     * Ext.form.NumberField TIPO DE MOVIMIENTO EN EL PROCESO JUDICIAL
     0 - ENTRADA
     1 - SALIDA
     */

    var cbxCjhtp_tipo = new Ext.form.ComboBox({
        id:'cbxCjhtp_tipo',
        name:'cbxCjhtp_tipo',
        store: dsTipoMovimientoProceso,
        fieldLabel :'Tipo Movimiento',
        anchor:'98%',
        mode:'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione un Tipo Movimiento'
    });
    /**
     * Ext.form.TextField NOMBRE DEL RESPONSABLE DE ESTE HISTORIAL DEL PROCESO JUDICIAL
     */
    var txtCjhtp_responsable = new Ext.form.TextField({
        id:'txtCjhtp_responsable',
        name:'txtCjhtp_responsable',
        fieldLabel :'Responsable',
        anchor:'98%',

        readOnly:true
    });
    /**
     * Ext.form.DateField FECHA DE REGISTRO DE OPERACION EN EL PROCESO JUDICIAL
     */
    var dtCjhtp_fecha = new Ext.form.DateField({
        id:'dtCjhtp_fecha',
        name:'dtCjhtp_fecha',
        fieldLabel :'Fecha',
        allowBlank :false,
        format :'d/m/Y',
        value:new Date()
    });
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Ext.form.TextField DESCRIP`CION DEL ARCHIVO ADJUNTO
     */
    var txtCjhtp_descripcion_adjunto = new Ext.form.TextField({
        id:'txtCjhtp_descripcion_adjunto',
        name:'txtCjada_descripci\u00f3n',
        anchor:'98%',
        allowBlank :false
    });
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * Ext.ux.grid.RowEditor Edito de filas personalizado para utilizaci?n en el grid de contacto
     */

    var cmAdj_historial_proceso = new Ext.grid.ColumnModel([
        {dataIndex:'CJADP_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:true},
        {dataIndex:'CJADP_NOMBRE_ADJUNTO',header:'Nombre adjunto',width:150,sortable:true},
        {dataIndex:'CJADP_DESCRIPCION',header:'Descripcion',width:150,sortable:true,editor: txtCjhtp_descripcion_adjunto},
        {dataIndex:'CRATE_DATA',header:'CRATE_DATA',width:150,sortable:true,hidden:true,hideable:true}
    ]);

    /*
     * Ext.ux.grid.RowEditor Edito de filas personalizado para utilizaci?n en el grid de Adjunto
     */
    var reAdjuntoHp = new Ext.ux.grid.RowEditor({
        saveText: 'Aceptar',
        cancelText:'Cancelar'
    });
    reAdjuntoHp.stopMonitoring();


    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_adjunto por un campo especifico.
     */
    var gsAdj_historial_proceso = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_jur_adjunto_proceso",
            method:"selectHistorialProcesoAdjunto",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
            id:'CRADJ_CODIGO',
            root:'dataSet'
        },[
            {name:'CJADP_CODIGO'},
            {name:'CJPJU_CODIGO'},
            {name:'CJADP_NOMBRE_ADJUNTO'},
            {name:'CJADP_DESCRIPCION'}

        ]),
        baseParams:{
            inCjhtp_codigo:'',
            format:"JSON"
        }
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_adjunto en un formato tabular de filas y columnas.
     */
    var grdCgg_jur_adjunto_historial_proceso = new Ext.grid.EditorGridPanel({
        id: 'grdCgg_jur_adjunto_proceso',
        region: 'south',
        split: true,
        collapsible: true,
        collapsed : true,
        title:'Adjunto',
        animCollapse : false,
        cm: cmAdj_historial_proceso,
        height:160,
        store:gsAdj_historial_proceso,
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

                var rAdjuntoTemporal;
                var objSubirAdjunto = new FrmCgg_res_adjunto_temporal();
                objSubirAdjunto.closeHandler(function(){
                    var dialogResult = objSubirAdjunto.dialogResult();
                    if(dialogResult  !== null){
                        var tmpRecordPersona = grdCgg_jur_adjunto_historial_proceso.getStore().recordType;
                        reAdjuntoHp.stopEditing();
                        grdCgg_jur_adjunto_historial_proceso.getStore().insert(0,
                                new tmpRecordPersona({
                                    'CJADP_CODIGO':'KEYGEN',
                                    'CJADP_NOMBRE_ADJUNTO':dialogResult.CRATE_NOMBRE,
                                    'CJADP_DESCRIPCION':'',
                                    'CRATE_DATA':dialogResult.CRATE_CODIGO
                                })
                                );
                        grdCgg_jur_adjunto_historial_proceso.getView().refresh();
                        grdCgg_jur_adjunto_historial_proceso.getSelectionModel().selectRow(0);
                        reAdjuntoHp.startEditing(0);
                    }
                });
                objSubirAdjunto.show();

            }

        }, {
            id: 'btnEliminarAdjuntoAcuerdo',
            iconCls: 'iconEliminar',
            handler: function(grid, rowIndex, colIndex) {
                grdCgg_jur_adjunto_historial_proceso.getSelectionModel().selectRow(rowIndex);
                var rAdjuntoRequisito = grdCgg_jur_adjunto_historial_proceso.getSelectionModel().getSelected();
                lisEliAdjuntosHp.push(rAdjuntoRequisito.get('CJADP_CODIGO'));
                tmpListadoEliminar1 = Ext.util.JSON.encode(lisEliAdjuntosHp);
                //alert("hola"+tmpListadoEliminar);
                grdCgg_jur_adjunto_historial_proceso.getStore().remove(rAdjuntoRequisito);
            }

        },{
            id:'btnVerAdjuntoAcuerdo',
            iconCls:'iconVer',
            listeners:{
                click:function(){
                    var r=grdCgg_jur_adjunto_historial_proceso.getSelectionModel().getSelected();
                    if(r){
					if(r.get('CRATE_DATA')){
							window.open(URL_DOC_VIEWER+'?table=cgg_res_adjunto_temporal&keyc=crate_codigo&keyv='+r.get('CRATE_DATA')+'&column=crate_archivo&fn='+r.get('CJADP_NOMBRE_ADJUNTO')+'&request=view');
						}else{
                      window.open(URL_DOC_VIEWER+'?table=cgg_jur_adjunto_proceso&keyc=cjadp_codigo&keyv='+r.get('CJADP_CODIGO')+'&column=cjadp_adjunto&fn='+r.get('CJADP_NOMBRE_ADJUNTO')+'&request=view');
						}
                }
            }

        }
		},{id:'btnDescargarAdjuntoAcuerdo',
            iconCls:'iconDescargar',
            listeners:{
                click:function(){
                    var r=grdCgg_jur_adjunto_historial_proceso.getSelectionModel().getSelected();
                    if(r)
                        window.open(URL_DOC_VIEWER+'?table=cgg_jur_adjunto_acuerdo&keyc=cjada_codigo&keyv='+r.get('CJADA_CODIGO')+'&column=cjada_adjunto&fn='+r.get('CJADA_NOMBRE_ADJUNTO')+'&request=download');
                }
            }
        }],
        plugins:[reAdjuntoHp]

    });
    /**
     * Ext.form.NumberField ESTADO DE LA EJECUCION DEL PROCESO
     0 - PLANTEADO
     1 - EN PROCESO
     2 - FINALIZADO
     3 - SUSPENDIDO
     */

    var cbxCjpju_estado_ejecucion_HP = new Ext.form.ComboBox({
        id:'cbxCjpju_estado_ejecucion_HP',
        name:'cbxCjpju_estado_ejecucion_HP',
        store: dsEstadoEjecucion,
        fieldLabel :'Estado',
        anchor:'95%',
        mode:'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione un Estado de Ejecucion',
        listeners:
        {
            select:function(combo,record)
            {
                tmpValorEstado= 'true';
            }
        }

    });
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_jur_historial_proceso
     */
    var btnGuardarCgg_jur_historial_proceso = new Ext.Button({
        id:'btnGuardarCgg_jur_historial_proceso',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (!pnlCgg_jur_historial_proceso.getForm().isValid()){
                    return;
                }
                try{
                    function CallBackCgg_jur_historial_proceso(r){
                        winFrmCgg_jur_historial_proceso.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_jur_historial_proceso,
                                msg: 'La informaci\u00f3n de Historial Proceso Judicial ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_jur_historial_proceso.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_jur_historial_proceso,
                                msg: 'La informaci\u00f3n de Historial Proceso Judicial no ha podido ser almacenada. '+(r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    if(lisEliAdjuntosHp.length<=0){
                        tmpListadoEliminar1= '[]';
                    }
                    winFrmCgg_jur_historial_proceso.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit){
                        param.add('inCjhtp_codigo',txtCjhtp_codigo.getValue());
                        param.add('inCjadjp_eliminar',tmpListadoEliminar1 );
                    }
                    param.add('inCjpju_codigo',tmpCjpju_codigo);
                    param.add('inCjhtp_descripcion',txtCjhtp_descripcion.getValue());
                    param.add('inCjhtp_tipo',cbxCjhtp_tipo.getValue());
                    param.add('inCjhtp_responsable',txtCjhtp_responsable.getValue());
                    param.add('inCjhtp_fecha',dtCjhtp_fecha.getValue().format('c'));
                    param.add('inCjadp_adjunto',grdCgg_jur_adjunto_historial_proceso.getStore().getJsonData());
                    param.add('inCjpju_estado_ejecucion_HP',cbxCjpju_estado_ejecucion_HP.getValue());
                    param.add('inTmpValorEstado',tmpValorEstado);
                    SOAPClient.invoke(urlCgg_jur_historial_proceso,IN_SENTENCIA_CGG_JUR_HISTORIAL_PROCESO,param, true, CallBackCgg_jur_historial_proceso);
                }catch(inErr){
                    winFrmCgg_jur_historial_proceso.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_jur_historial_proceso.
     */
    var btnCancelarCgg_jur_historial_proceso = new Ext.Button({
        id:'btnCancelarCgg_jur_historial_proceso',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_jur_historial_proceso.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_jur_historial_proceso.
     */
    var btnCerrarCgg_jur_historial_proceso = new Ext.Button({
        id:'btnCerrarCgg_jur_historial_proceso',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_jur_historial_proceso.close();
            }}
    });
    /**
     * Funcion que permite cargar el  codigo del documento generado
     */
    function responsableHistorialProceso(){
        function callBackResponsableHistorialProceso(r){
            txtCjhtp_responsable.setValue(r);
        }
        SOAPClient.invoke(URL_WS+"Cgg_jur_proceso_judicial",'responsableProcesoJudicial',false, false, callBackResponsableHistorialProceso);
    }
    responsableHistorialProceso();
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_jur_historial_proceso.
     */
    var pnlCgg_jur_historial_proceso = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCjhtp_codigo,txtCjhtp_descripcion,cbxCjhtp_tipo,txtCjhtp_responsable,
            {xtype:'panel',layout:'column',items:[
                {columnWidth:.50,layout:'form',items:[dtCjhtp_fecha]},
                {columnWidth:.50,layout:'form',items:[cbxCjpju_estado_ejecucion_HP]}]}
        ]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_jur_historial_proceso.
     */
    var winFrmCgg_jur_historial_proceso = new Ext.Window({
        id:'winFrmCgg_jur_historial_proceso',
        title:tituloCgg_jur_historial_proceso,
        iconCls:'iconAplicacion',
        width:600,
        minWidth:600,
        maximizable:false,
        minimizable:true,
        modal:true,
        resizable:false,
        constrain:true,
        tbar:getPanelTitulo(tituloCgg_jur_historial_proceso,descCgg_jur_historial_proceso),
        items:[pnlProcesoJuridico,pnlCgg_jur_historial_proceso,grdCgg_jur_adjunto_historial_proceso],
        bbar:[btnGuardarCgg_jur_historial_proceso,btnCancelarCgg_jur_historial_proceso,'->',btnCerrarCgg_jur_historial_proceso]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmCgg_jur_historial_proceso.getBottomToolbar());
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_jur_historial_proceso.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_jur_historial_procesoCtrls(inEstado){
        estado=!inEstado;
        txtCjhtp_codigo.setDisabled(estado);
        txtCjpju_codigo.setDisabled(estado);
        txtCjhtp_descripcion.setDisabled(estado);
        cbxCjhtp_tipo.setDisabled(estado);
        txtCjhtp_responsable.setDisabled(estado);
        dtCjhtp_fecha.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_jur_historial_proceso.
     */
    function cargarCgg_jur_historial_procesoCtrls(){
        if(inRecordCgg_jur_historial_proceso){
            txtCjhtp_codigo.setValue(inRecordCgg_jur_historial_proceso.get('CJHTP_CODIGO'));
            txtCjpju_codigo.setValue(inRecordCgg_jur_historial_proceso.get('CJPJU_CODIGO'));
            txtCjhtp_descripcion.setValue(inRecordCgg_jur_historial_proceso.get('CJHTP_DESCRIPCION'));
            cbxCjhtp_tipo.setValue(inRecordCgg_jur_historial_proceso.get('CJHTP_TIPO'));
            txtCjhtp_responsable.setValue(inRecordCgg_jur_historial_proceso.get('CJHTP_RESPONSABLE'));
            dtCjhtp_fecha.setValue(truncDate(inRecordCgg_jur_historial_proceso.get('CJHTP_FECHA')));
            cbxCjpju_estado_ejecucion_HP.setValue(inRecordCgg_jur_historial_proceso.get('CJPJU_ESTADO_EJECUCION'));
            gsAdj_historial_proceso.reload({
                params:{
                    inCjhtp_codigo:txtCjhtp_codigo.getValue(),
                    format:TypeFormat.JSON
                }
            });

            isEdit = true;
            habilitarCgg_jur_historial_procesoCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_jur_historial_proceso.
     * @returns ventana winFrmCgg_jur_historial_proceso.
     * @base FrmCgg_jur_historial_proceso.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_jur_historial_proceso;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_jur_historial_proceso.
     * @base FrmCgg_jur_historial_proceso.prototype.loadData
     */
    this.loadData = function(inHistorialProceso){
        cargarCgg_jur_historial_procesoCtrls();
        document.getElementById('divInfoProcesoJuridico').innerHTML =tmpInfoProcesoJuridico1.apply(inHistorialProceso.json);
        tmpCjpju_codigo=inHistorialProceso.get('CJPJU_CODIGO');
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_jur_historial_proceso desde una instancia.
 */
FrmCgg_jur_historial_proceso.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_jur_historial_proceso desde una instancia.
 */
FrmCgg_jur_historial_proceso.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_jur_historial_proceso,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_jur_historial_proceso.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_jur_historial_proceso desde una instancia.
 */
FrmCgg_jur_historial_proceso.prototype.loadData = function(){
    this.loadData();
}
