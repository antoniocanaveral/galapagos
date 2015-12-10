/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_seguimiento.
 * @param {Ext.data.Record} INRECORD_CGG_RES_SEGUIMIENTO Registro de datos de la tabla Cgg_res_seguimiento.
 * @param inDesktop Escritorio
 * @constructor
 * @base FrmListadoCgg_res_seguimiento
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_revision_tramite(INRECORD_CGG_RES_SEGUIMIENTO, inDesktop) {
    var inRecordCgg_res_seguimiento = INRECORD_CGG_RES_SEGUIMIENTO;
    var tituloCgg_res_seguimiento = 'Seguimiento';
    var tituloCgg_res_informe_seguimiento = 'Informe seguimiento';
    var descCgg_res_seguimiento = 'El formulario permite administrar informaci\u00f3n del seguimiento';
    var tmpFase = null;
    var tmpPersonaJuridica = null;
    var enableDelayRow = null;
    var numFase = 0;
    var crettCodigo = null;
    var generaResidencia = false;
    var crresData = null;
    var isVehiculo = false;
    var datosTramite = {
        CRTRA_ANIO:'2010',
        CRTRA_NUMERO:'',
        CRPER_BENEFICIARIO:'',
        CRPER_AUSPICIANTE:'',
        CRTRA_FECHA_RECEPCION:'',
        CRPJR_RAZON_SOCIAL:'',
        CISLA_NOMBRE:'',
        CRTRA_OBSERVACION:'',
        CRTRA_COMUNICADO_RADIAL:'',
        CRTRA_CODIGO:'',
        CRTRA_DIAS_PERMANENCIA:0,
        CRTRA_ACTIVIDAD_RESIDENCIA:'',
        CRTRA_FOLIO:0,
        CRPER_CODIGO:'',
        CRFAS_NOMBRE:''
    };

    var datosSeguimiento = {
        CRSEG_NUMERO:'0',
        CRSEG_OBSERVACION:'0',
        CRSEG_FECHA_RECEPCION:'0',
        CRFAS_NOMBRE:'0',
        CUSU_CODIGO:'0',
        CRSEG_TIPO_ACTIVIDAD:'0',
        CRSEG_FECHA_DESPACHO:'0',
        CRSEG_DESCRIPCION:'0',
        CUSUNOMBRES:'0',
        CUSU_NOMBRES:'0'

    };
    var tplTramite = new Ext.Template(
            '<table id="ver-zebra2" width="100%" border="0"> <colgroup> <col class="vzebra-odd-strong"/> <col class="vzebra-even-tight"/> <col class="vzebra-odd-strong"/> <col class="vzebra-even-tight"/> </colgroup>' +
                    ' <tr> <td width=80> N&uacute;mero:</td> <td width="33%"> {CRTRA_ANIO}-{CRTRA_NUMERO}</td> <td width=80> Tipo solicitud:</td> <td width="33%"> {CRTST_DESCRIPCION:ellipsis(25)}</td> </tr> ' +
                    '<tr> <td> <div id="idDivBeneficiario">{ETIQUETA}</div></td> <td> {CRPER_BENEFICIARIO:ellipsis(25)}</td> <td> Isla:</td> <td> {CISLA_NOMBRE}</td> </tr> ' +
                    '<tr> ' +
                    '<td> Auspiciante:</td> <td> {CRPER_AUSPICIANTE:ellipsis(25)}</td>'+
                    '<td> Recepci&oacute;n:</td> <td> {CRTRA_FECHA_RECEPCION}</td> </tr> ' +
                    '<tr>' +
                    ' <td> Pers. jur&iacute;dica:</td> <td> {CRPJR_RAZON_SOCIAL}</td>' +
                    ' <td> N. folios:</td> <td> {CRTRA_FOLIO}</td> </tr> ' +
                    '<tr> <td> Observaci&oacute;n:</td> <td> {CRTRA_OBSERVACION:ellipsis(30)}</td> <td> Comunicado(R):</td> <td> {CRTRA_COMUNICADO_RADIAL}</td> </tr> ' +
                    '<tr> <td>Actividad:</td> <td>{CRTRA_ACTIVIDAD_RESIDENCIA}</td> <td>Permanencia:</td> <td>{CRTRA_DIAS_PERMANENCIA}</td> </tr> ' +
                    '<tr> <td>Fase:</td> <td><span class="textoResultado">{CRFAS_NOMBRE:ellipsis(30)}</span></td> ' +
                    '<td></td> ' +
                    '<td></td> </tr> </table>'
);

    var rNovedadNotificacion = new Ext.data.Record.create([
        {
            name:'CRNOV_CODIGO'
        },

        {
            name:'CRSEG_CODIGO'
        },

        {
            name:'CRNOV_FECHA_REGISTRO'
        },

        {
            name:'CRNOV_DESCRIPCION'
        },

        {
            name:'CRNOV_TIPO'
        },

        {
            name:'CRNOV_USUARIO_INSERT'
        },

        {
            name:'CRNOV_USUARIO_UPDATE'
        },

        {
            name:'CRFAS_CODIGO'
        }
    ]);

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
     */
    var txtCrseg_codigo = new Ext.form.TextField({
        id:'txtCrseg_codigo',
        name:'txtCrseg_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO SEGUIMIENTO RECURSIVO
     */
    var txtCgg_crseg_codigo = new Ext.form.TextField({
        id:'txtCgg_crseg_codigo',
        name:'txtCgg_crseg_codigo',
        fieldLabel :'Crseg codigo',
        anchor:'98%',
        //allowBlank :false,
        readOnly:'true',
        maxLength :20
    });

    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_revision_tramite.
     */
    var btnCerrarCgg_res_seguimiento = new Ext.Button({
        id:'btnCerrarCgg_res_seguimiento',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:'Cerrar formulario',
        listeners:{
            click:function() {
                winFrmCgg_res_revision_tramite.close();
            }
        }
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_informe.
     */
    var cmCgg_res_informe_seguimiento = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
        {
            dataIndex:'CRISE_NUMERO_INFORME',
            header:'N\u00FAmero',
            width:80,
            sortable:true
        },

        {
            dataIndex:'CRISE_FECHA_INFORME',
            header:'Fecha',
            width:80,
            sortable:true,
            renderer:truncDate
        },

        {
            dataIndex:'CRISE_ASUNTO_INFORME',
            header:'Asunto',
            width:130,
            sortable:true
        },

        {
            dataIndex:'CRISE_EXTRACTO_INFORME',
            header:'Extracto informe',
            width:500,
            sortable:true
        },

        {
            dataIndex:'CRFAS_CODIGO',
            header:'Fase',
            width:100,
            renderer:function(inCRFAS_CODIGO){
                var descFase = null;
                var scpFase = new SOAPClientParameters();
                scpFase.add('inCrfas_codigo',inCRFAS_CODIGO);
                scpFase.add('format',TypeFormat.JSON);
                var tmpFase = SOAPClient.invoke(URL_WS+'Cgg_res_fase','select', scpFase, false, null);
                try{
                    tmpFase = Ext.util.JSON.decode(tmpFase);
                    tmpFase = tmpFase[0];
                    descFase = tmpFase.CRFAS_NOMBRE;
                }catch(inErr){
                    descFase = NO_DATA_MESSAGE;
                }
                return descFase;
            }
        },
        {
            dataIndex:'CRISE_USUARIO_INSERT',
            header:'Registrado por',
            width:100,
            sortable:true,
            hidden:true
        },

        {
            dataIndex:'CRISE_USUARIO_UPDATE',
            header:'Actualizado por',
            width:100,
            sortable:true,
            hidden:true
        }
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_informe por un campo especifico.
     */
    var gsCgg_res_informe_seguimiento = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS + "Cgg_res_informe_seguimiento",
            method:"selectCGG_RES_SEGUIMIENTO"
        }),
        reader:new Ext.data.JsonReader({
        }, [
            {
                name:'CRISE_CODIGO'
            },

            {
                name:'CRSEG_CODIGO'
            },

            {
                name:'CRSEC_CODIGO'
            },

            {
                name:'CRISE_NUMERO_INFORME'
            },

            {
                name:'CRISE_FECHA_INFORME'
            },

            {
                name:'CRISE_ASUNTO_INFORME'
            },

            {
                name:'CRISE_EXTRACTO_INFORME'
            },

            {
                name:'CRISE_DESCRIPCION_ADJUNTO'
            },

            {
                name:'CRFAS_CODIGO'
            },

            {
                name:'CRISE_USUARIO_INSERT'
            },

            {
                name:'CRISE_USUARIO_UPDATE'
            }
        ]),
        baseParams:{
            inCrseg_codigo:inRecordCgg_res_seguimiento.get('CRSEG_CODIGO'),
            format:TypeFormat.JSON
        },
        groupField:'CRFAS_CODIGO'
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_informe en un formato tabular de filas y columnas.
     */
    var grdCgg_res_informe_seguimiento = new Ext.grid.GridPanel({
        cm:cmCgg_res_informe_seguimiento,
        store:gsCgg_res_informe_seguimiento,
        region:'center',
        view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Informes" : "informe"]})'
        }),
        plugins:[new Ext.ux.grid.AutoSizeColumns()],
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        })
    });
    //gsCgg_res_informe_seguimiento.load();

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_novedad_notificacion.
     */
    var cmCgg_res_novedad_notificacion = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
        {dataIndex:'CRNOV_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:true},
        {dataIndex:'CRSEG_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:true},
        {dataIndex:'CRNOV_DESCRIPCION',header:'Mensaje',width:200,sortable:true},
        {dataIndex:'CRNOV_FECHA_REGISTRO',header:'Fecha',width:100,sortable:true,renderer:truncDate},
        {dataIndex:'CRNOV_TIPO',header:'Tipo',width:150,sortable:true,hidden:true,hideable:true},
        {dataIndex:'CRNOV_USUARIO_INSERT',header:'Registrado',width:100,hidden:true},
        {dataIndex:'CRNOV_USUARIO_UPDATE',header:'Actualizado',width:100,hidden:true},
        {dataIndex:'CRFAS_CODIGO',header:'Fase',width:100,
            renderer:function(inCRFAS_CODIGO){
                var descFase = null;
                var scpFase = new SOAPClientParameters();
                scpFase.add('inCrfas_codigo',inCRFAS_CODIGO);
                scpFase.add('format',TypeFormat.JSON);
                var tmpFase = SOAPClient.invoke(URL_WS+'Cgg_res_fase','select', scpFase, false, null);
                try{
                    tmpFase = Ext.util.JSON.decode(tmpFase);
                    tmpFase = tmpFase[0];
                    descFase = tmpFase.CRFAS_NOMBRE;
                }catch(inErr){
                    descFase = NO_DATA_MESSAGE;
                }
                return descFase;
            }
        }]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_novedad_notificacion por un campo especifico.
     */
    var gsCgg_res_novedad_notificacion = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS + "Cgg_res_novedad_notificacion",
            method:"selectCGG_RES_SEGUIMIENTO"
        }),
        reader:new Ext.data.JsonReader({}, rNovedadNotificacion),
        baseParams:{
            inCrseg_codigo:inRecordCgg_res_seguimiento.get('CRSEG_CODIGO'),
            format:"JSON"
        },
        groupField:'CRFAS_CODIGO'
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_novedad_notificacion en un formato tabular de filas y columnas.
     */
    var grdCgg_res_novedad_notificacion = new Ext.grid.GridPanel({
        cm:cmCgg_res_novedad_notificacion,
        store:gsCgg_res_novedad_notificacion,
        region:'center',
        //frame:true,
        //width:'40%',
        anchor:'100%',
        view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Comentarios/sumillas" : "Comentario/sumilla"]})',
            forceFit:true
        }),
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        loadMask:{
            msg:"Cargando..."
        }

    });
    //gsCgg_res_novedad_notificacion.load();

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_adjunto.
     */
    var cmCgg_res_adjunto = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
        {dataIndex:'CRADJ_CODIGO',width:40,hidden:true,hideable:false},
        {dataIndex:'CRADJ_NOMBRE_ADJUNTO',header:'Adjunto',width:200,sortable:true},
        {dataIndex:'CRSEG_CODIGO',header:'Seguimiento',width:150,sortable:true,hideable:false,hidden:true},
        {dataIndex:'CRADJ_OBSERVACION',header:'Observaci\u00F3n',width:150,sortable:true},
        {dataIndex:'CRADJ_FECHA_REGISTRO',header:'Fecha',width:100,sortable:true,renderer:truncDate},
        {dataIndex:'CRADJ_USUARIO_INSERT',header:'Registrado por',width:100,sortable:true,hidden:true},
        {dataIndex:'CRADJ_USUARIO_UPDATE',header:'Actualizado por',width:100,sortable:true,hidden:true}
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_adjunto por un campo especifico.
     */
    var gsCgg_res_adjunto = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS + "Cgg_res_adjunto",
            method:"selectCGG_RES_SEGUIMIENTO1"
        }),
        reader:new Ext.data.JsonReader({}, [
            {name:'CRADJ_CODIGO'},
            {name:'CRSEG_CODIGO'},
            {name:'CRADJ_NOMBRE_ADJUNTO'},
            {name:'CRADJ_OBSERVACION'},
            {name:'CRADJ_FECHA_REGISTRO'},
            {name:'CRADJ_USUARIO_INSERT'},
            {name:'CRADJ_USUARIO_UPDATE'}
        ]),
        baseParams:{
            inCrseg_codigo:inRecordCgg_res_seguimiento.get('CRSEG_CODIGO'),
            format:"JSON"
        }
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_adjunto en un formato tabular de filas y columnas.
     */
    var grdCgg_res_adjunto = new Ext.grid.GridPanel({
        cm:cmCgg_res_adjunto,
        store: gsCgg_res_adjunto,
        region:'center',
        sm: new Ext.grid.RowSelectionModel({
            singleSelect:true,
            moveEditorOnEnter:false
        }),
        viewConfig: {
            forceFit: true
        },
        loadMask:{
            msg:"Cargando..."
        },
        plugins:[new Ext.ux.grid.AutoSizeColumns()],
        trackMouseOver: true,
        tbar:[
            {
                id:'btnVerAdjunto',
                iconCls:'iconBuscar',
                handler:function() {
                    var rAdjunto = grdCgg_res_adjunto.getSelectionModel().getSelected();
                    if (rAdjunto !== null) {
                        window.open(URL_DOC_VIEWER + '?table=cgg_res_adjunto&keyc=cradj_codigo&keyv=' + rAdjunto.get('CRADJ_CODIGO') + '&column=cradj_archivo_adjunto&fn=' + rAdjunto.get('CRADJ_NOMBRE_ADJUNTO') + '&request=view');
                    }
                }
            },
            {
                id:'Descargar',
                iconCls:'iconGuardar',
                handler:function() {
                    var rAdjunto = grdCgg_res_adjunto.getSelectionModel().getSelected();
                    if (rAdjunto !== null) {
                        window.open(URL_DOC_VIEWER + '?table=cgg_res_adjunto&keyc=cradj_codigo&keyv=' + rAdjunto.get('CRADJ_CODIGO') + '&column=cradj_archivo_adjunto&fn=' + rAdjunto.get('CRADJ_NOMBRE_ADJUNTO') + '&request=download');
                    }
                }
            }
        ],
        listeners:{
            rowcontextmenu:function(inComponent, inRowIndex, inEventObject) {
                inComponent.getSelectionModel().selectRow(inRowIndex);
                var mAdjunto = new Ext.menu.Menu({
                    items:[
                        {
                            text: 'Descargar',
                            handler:function() {
                                var rAdjunto = inComponent.getSelectionModel().getSelected();
                                window.open(URL_DOC_VIEWER + '?table=cgg_res_adjunto&keyc=cradj_codigo&keyv=' + rAdjunto.get('CRADJ_CODIGO') + '&column=cradj_archivo_adjunto&fn=' + rAdjunto.get('CRADJ_NOMBRE_ADJUNTO') + '&request=download');
                            }
                        }
                    ]
                });
                inEventObject.stopEvent();
                mAdjunto.showAt(inEventObject.getXY());
            },
            rowdblclick:function(inGrid, rowIndex, e) {
                var rAdjunto = inGrid.getSelectionModel().getSelected();
                window.open(URL_DOC_VIEWER + '?table=cgg_res_adjunto&keyc=cradj_codigo&keyv=' + rAdjunto.get('CRADJ_CODIGO') + '&column=cradj_archivo_adjunto&fn=' + rAdjunto.get('CRADJ_NOMBRE_ADJUNTO') + '&request=view');
            }
        }
    });
    //gsCgg_res_adjunto.load();


    var ccCJCRI_REQUERIDO=new Ext.grid.CheckColumn({
        dataIndex:'CJCRI_REQUERIDO',
        header:'Requerido',
        width:70,
        sortable:true
    });

    var ccCJSGC_RESPUESTA=new Ext.grid.CheckColumn({
        dataIndex:'CJSGC_RESPUESTA',
        header:'Cumplido',
        width:60,
        sortable:true
    });

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_jur_seguimiento_criterio.
     */
    var cmCgg_jur_seguimiento_criterio = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
        {dataIndex:'CJSGC_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hiddeable:false},
        {dataIndex:'CRSEG_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hiddeable:false},
        {dataIndex:'CJCRI_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hiddeable:false},
        {dataIndex:'CJCRI_REQUERIMIENTO',header:'Requerimiento',width:100,sortable:true},
        ccCJCRI_REQUERIDO,ccCJSGC_RESPUESTA,
        {dataIndex:'CJSGC_JUSTIFICACION',header:'Justificaci\u00F3n',width:150,sortable:true,editor:{
                xtype:'textfield',
                emptyText:'Establezca una justificaci\u00F3n, por favor.'
            }
        },
        {dataIndex:'CJSGC_NOMBRE_ADJUNTO',header:'Adjunto',width:150,sortable:true},//hidden:true,hiddeable:true},
		{dataIndex:'CJSGC_OBSERVACION',header:'Observaci\u00f3n',width:150,sortable:true,hidden:true,hiddeable:true
        },{
            xtype: 'actioncolumn',
            width: 80,
            header:'Ver',
            id:'cjsgc_data',
            items:[
                {
                    iconCls: 'iconBuscar',                // Use a URL in the icon config
                    tooltip: 'Ver adjunto',
                    handler: function(grid, rowIndex, colIndex) {
                        grdCgg_jur_seguimiento_criterio.getSelectionModel().selectRow(rowIndex);
                        var rAdjuntoCriterio = grdCgg_jur_seguimiento_criterio.getSelectionModel().getSelected();
                        if (rAdjuntoCriterio.get('CJSGC_NOMBRE_ADJUNTO').length > 0) {
                            var url1 = URL_DOC_VIEWER + '?table=cgg_jur_seguimiento_criterio&keyc=cjsgc_codigo&keyv=' + rAdjuntoCriterio.get('CJSGC_CODIGO') + '&column=cjsgc_adjunto&fn=' + rAdjuntoCriterio.get('CJSGC_NOMBRE_ADJUNTO') + '&request=view';
                            window.open(url1);
                        }
                    }
                }/*,
                {
                    iconCls: 'iconGuardar',
                    tooltip: 'Guardar adjunto',
                    handler: function(grid, rowIndex, colIndex) {
                        grdCgg_jur_seguimiento_criterio.getSelectionModel().selectRow(rowIndex);
                        var rAdjuntoCriterio = grdCgg_jur_seguimiento_criterio.getSelectionModel().getSelected();
                        if (rAdjuntoCriterio !== null) {
                            var url2 = URL_DOC_VIEWER + '?table=cgg_jur_seguimiento_criterio&keyc=cjsgc_codigo&keyv=' + rAdjuntoCriterio.get('CJSGC_CODIGO') + '&column=cjsgc_adjunto&fn=' + rAdjuntoCriterio.get('CJSGC_NOMBRE_ADJUNTO') + '&request=download';
                            window.open(url2);
                        }
                    }
                }*/
            ]
        }
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_jur_seguimiento_criterio por un campo especifico.
     */
    var gsCgg_jur_seguimiento_criterio = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS + "Cgg_jur_seguimiento_criterio",
            method:"selectSEGUIMIENTO_CRITERIO"
        }),
        reader:new Ext.data.JsonReader({}, [
            {name:'CJSGC_CODIGO'},
            {name:'CRSEG_CODIGO'},
            {name:'CJCRI_CODIGO'},
            {name:'CJSGC_RESPUESTA'},
            {name:'CJSGC_JUSTIFICACION'},
            {name:'CJSGC_OBSERVACION'},
            {name:'CJSGC_NOMBRE_ADJUNTO'},
            {name:'CJCRI_REQUERIMIENTO'},
            {name:'CJCRI_REQUERIDO'}
        ]),
        baseParams:{
            inCrseg_codigo:inRecordCgg_res_seguimiento.get('CRSEG_CODIGO'),
            inCrfas_codigo:inRecordCgg_res_seguimiento.get('CRFAS_CODIGO'),
            format:TypeFormat.JSON
        },
        listeners:{
            load:function(){
                if(enableDelayRow !== null && enableDelayRow!==undefined){
                    grdCgg_jur_seguimiento_criterio.getSelectionModel().selectRow(enableDelayRow);
                    var rAdjuntoCriterio = grdCgg_jur_seguimiento_criterio.getSelectionModel().getSelected();
                    var objSubirAdjunto = new FrmSubirAdjuntoCriterio(rAdjuntoCriterio.get('CJSGC_CODIGO'));
                    objSubirAdjunto.closeHandler(function() {
                        enableDelayRow=null;
                        gsCgg_jur_seguimiento_criterio.load();
                    });
                    objSubirAdjunto.show();
                }
            }
        }
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_jur_seguimiento_criterio en un formato tabular de filas y columnas.
     */
    var grdCgg_jur_seguimiento_criterio = new Ext.grid.EditorGridPanel({
        cm:cmCgg_jur_seguimiento_criterio,
        store:gsCgg_jur_seguimiento_criterio,
        region:'center',
        cliksToEdit:'auto',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true,
            moveEditorOnEnter:false
        }),
        loadMask:{
            msg:"Cargando..."
        }
    });
    //gsCgg_jur_seguimiento_criterio.load();

    /**
     * Ext.Panel Panel que contiene los fielset con información del trámite y el seguimiento
     */
    var pnlSeguimientoP2 = new Ext.Panel({
        id:'pnlSeguimientoP2',
        labelWidth:100,
        region:'north',
        layout:'accordion',
        height:190,
        minHeight:190,
        bodyStyle:'background-color: #EBEBEB',
        items:[{
            title:'Datos tr\u00E1mite',
            html:'<div class="wfl" id="divTramite"/>',
            cls:'empty',
            autoScroll:true
        }
        ]
    });
    /*
     * Ext.form.FormPanel
     */
    var pnlAdjuntoSeguimiento = new Ext.form.FormPanel({
        id:'pnlAdjuntoSeguimiento',
        region:'center',
        layout:'border',
        fileUpload:true,
        items:[grdCgg_res_adjunto]
    });


    var cbcCRRQT_CUMPLE = new Ext.grid.CheckColumn({
        dataIndex: 'CRRQT_CUMPLE',
        header: 'Cumple',
        width: 80
    });

    var ccCRSRQ_REQUERIDO = new Ext.grid.CheckColumn({
        dataIndex: 'CRSRQ_REQUERIDO',
        header: 'Requerido',
        width: 90
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_seguimiento_requisito.
     */
    var cmCgg_res_seguimiento_requisito = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(), {
            dataIndex: 'CRSRQ_CODIGO',
            header: 'Codigo',
            width: 150,
            sortable: true,
            hidden: true,
            hideable: false
        }, {
            dataIndex: 'CRTSR_CODIGO',
            header: 'Codigo',
            width: 150,
            sortable: true,
            hidden: true,
            hideable: false
        }, {
            dataIndex: 'CRREQ_CODIGO',
            header: 'Requisito',
            width: 150,
            sortable: true,
            renderer: function(inCRREQ_CODIGO) {
                var i = 0;
                var result = 'no datos';
                for (i = 0; i < SCGG_RES_REQUISITO.getCount(); i++) {
                    var rRequisito = SCGG_RES_REQUISITO.getAt(i);
                    if (rRequisito.get('CRREQ_CODIGO') == inCRREQ_CODIGO) {
                        result = rRequisito.get('CRREQ_DESCRIPCION');
                        break;
                    }
                }
                return result;
            }
        }, {
            dataIndex: 'CRSRQ_DESCRIPCION',
            header: 'Descripci\u00F3n',
            width: 170,
            sortable: true
        }, {
            dataIndex: 'CRSRQ_PARTICIPANTE',
            header: 'Participante',
            width: 80,
            sortable: true,
            hidden: true,
            renderer: function(inCRSRQ_PARTICIPANTE) {
                var result = 'no datos';
                for (var i = 0; i < dsTipoParticipante.length; i++) {
                    if (dsTipoParticipante[i][0] == inCRSRQ_PARTICIPANTE) {
                        result = dsTipoParticipante[i][1];
                        break;
                    }
                }
                return result;
            }
        },ccCRSRQ_REQUERIDO, {
            dataIndex: 'CRRQT_CODIGO',
            header: 'Codigo',
            width: 100,
            sortable: true,
            hidden: true,
            hideable: false
        }, {
            dataIndex: 'CRTRA_CODIGO',
            header: 'Tramite',
            hidden: true,
            hideable: false
        }, cbcCRRQT_CUMPLE,
        {
            dataIndex: 'CRADJ_DATA',
            header: 'Archivo',
            width: 80,
            renderer:function(inCRADJ_DATA){
                var result = "";
                if(inCRADJ_DATA!==null && inCRADJ_DATA.CRADJ_NOMBRE_ADJUNTO!=null ){
                    result = inCRADJ_DATA.CRADJ_NOMBRE_ADJUNTO;
                }else{
                    result = '';
                }
                return result;
            }
        },
        {
            dataIndex: 'CRRQT_OBSERVACION',
            header: 'Observaci\u00F3n',
            width: 150,
            sortable: true
        }]);

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_seguimiento_requisito por un campo especifico.
     */
    var gsCgg_res_seguimiento_requisito = new Ext.data.GroupingStore({
        proxy: new Ext.ux.bsx.SoapProxy({
            url: URL_WS + "Cgg_res_requisito_tramite",
            method: "selectRequisitoAdjunto"
        }),
        reader: new Ext.data.JsonReader({}, [
            {name: 'CRSRQ_CODIGO'},
            {name: 'CRTSR_CODIGO'},
            {name: 'CRREQ_CODIGO'},
            {name: 'CRSRQ_DESCRIPCION'},
            {name: 'CRSRQ_REQUERIDO'},
            {name: 'CRSRQ_PARTICIPANTE'},
            {name: 'CRRQT_CODIGO'},
            {name: 'CRTRA_CODIGO'},
            {name: 'CRRQT_CUMPLE'},
            {name: 'CRRQT_OBSERVACION'},
            {name: 'CRADJ_DATA'}
        ]),
        groupField: 'CRSRQ_PARTICIPANTE',
        baseParams: {
            inCrtst_codigo: null,
            inCrtra_codigo: null,
            format: TypeFormat.JSON
        }
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_seguimiento_requisito en un formato tabular de filas y columnas.
     */
    var grdCgg_res_seguimiento_requisito = new Ext.grid.GridPanel({
        store: gsCgg_res_seguimiento_requisito,
        cm: cmCgg_res_seguimiento_requisito,
        region: 'center',
        view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Requisitos" : "Requisito"]})'
        }),
        sm: new Ext.grid.RowSelectionModel({
            singleSelect: true
        }),
        loadMask: {
            msg: "Cargando..."
        },
        tbar:[
            {
                iconCls: 'iconBuscar',                // Use a URL in the icon config
                tooltip: 'Ver adjunto',
                handler: function() {
                    //grdCgg_res_seguimiento_requisito.getSelectionModel().selectRow(rowIndex);
                    var rAdjuntoCriterio = grdCgg_res_seguimiento_requisito.getSelectionModel().getSelected();
                    if (rAdjuntoCriterio !== null) {
                        var cradj_data = rAdjuntoCriterio.get('CRADJ_DATA');
                        if (cradj_data !== null && cradj_data !== undefined) {
                            var url1 = URL_DOC_VIEWER + '?table=cgg_res_adjunto&keyc=cradj_codigo&keyv=' + cradj_data.CRADJ_CODIGO + '&column=cradj_archivo_adjunto&fn=' + cradj_data.CRADJ_NOMBRE_ADJUNTO + '&request=view';
                            window.open(url1);
                        }
                    }
                }
            },
            {
                iconCls: 'iconGuardar',
                tooltip: 'Guardar adjunto',
                handler: function() {
                    //grdCgg_res_seguimiento_requisito.getSelectionModel().selectRow(rowIndex);
                    var rAdjuntoCriterio = grdCgg_res_seguimiento_requisito.getSelectionModel().getSelected();
                    if (rAdjuntoCriterio !== null) {
                        var cradj_data = rAdjuntoCriterio.get('CRADJ_DATA');
                        if (cradj_data !== null && cradj_data !== undefined) {
                            var url1 = URL_DOC_VIEWER + '?table=cgg_res_adjunto&keyc=cradj_codigo&keyv=' + cradj_data.CRADJ_CODIGO + '&column=cradj_archivo_adjunto&fn=' + cradj_data.CRADJ_NOMBRE_ADJUNTO + '&request=download';
                            window.open(url1);
                        }
                    }
                }
            }
        ]
    });

    /**
     * Ext.TabPanel Contienen los tab de listado de informes que tiene el seguimiento y adjuntos
     * propios del seguimiento
     */
    var pnlTabSeguimientoP3 = new Ext.TabPanel({
        id:'pnlTabSeguimientoP3',
        activeTab:0,
        anchor:'100% 100%',
        region:'center',
        items:[
            {
                id:'tpRequisitoTramite',
                title:'Requisito de tr\u00E1mite',
                layout:'border',
                items: [grdCgg_res_seguimiento_requisito]
            },
            {
                id:'tpSeguimientoInforme',
                title:'Informes',
                layout:'border',
                items:[grdCgg_res_informe_seguimiento]
            },
            {
                id:'tpSeguimientoAdjunto',
                title:'Adjuntos',
                layout:'border',
                items:[pnlAdjuntoSeguimiento]
            },
            {
                id:'tpSeguimientoRequerimiento',
                title:'Requisitos a cumplir',
                layout:'border',
                items:[grdCgg_jur_seguimiento_criterio]
            },
            {
                id:'tpSumillas',
                title:'Sumillas/Comentarios',
                layout:'border',
                items:[grdCgg_res_novedad_notificacion]
            }
        ]
    });

    /**
     * Ext.Panel
     */
    var pnlFaseP4 = new Ext.Panel({
        id:'pnlFaseP4',
        region:'center',
        layout:'border',
        items:[pnlTabSeguimientoP3]
    });

    /**
     * Ext.Panel Contenedor principal
     */
    var pnlSeguimientoP1 = new Ext.Panel({
        id:'pnlSeguimientoP1',
        labelWidth :100,
        layout:'border',
        region:'center',
        fileUpload:true,
        items:[pnlSeguimientoP2,pnlFaseP4]
    });

    var fsBeneficiarios = new Ext.form.FieldSet({
        title:'Beneficiarios',
        items:[{
            layout:'column',
            items:[{
                columnWidth:0.5,
                layout:'form',
                items:[{
                    xtype:'textfield',
                    fieldLabel:'Beneficiario',
                    readOnly:true,
                    id:'txtCrperBeneficiario'
                },{
                    xtype:'textfield',
                    fieldLabel:'Auspiciante',
                    readOnly:true,
                    id:'txtCrperAuspiciante'
                }]
            },{
                columnWidth:0.5,
                layout:'form',
                items:[{
                    xtype:'textfield',
                    fieldLabel:'Tipo solicitud',
                    readOnly:true,
                    id:'txtCrtstDescripcion'
                }]
            }]
        }]
    });

    var fsResolucion= new Ext.form.FieldSet({
        title:'Resoluci\u00f3n',
        items:[{
            layout:'column',
            items:[{
                columnWidth:0.5,
                layout:'form',
                items:[{
                    xtype:'textfield',
                    fieldLabel:'Numero',
                    readOnly:true,
                    id:'txtCrresNumeroResolucion'
                },{
                    xtype:'textfield',
                    fieldLabel:'Lugar',
                    readOnly:true,
                    id:'txtCislaNombre'
                },{
                    xtype:'panel',
                    layout:'column',
                    items:[{
                        width:105,
                        items:[{
                            xtype:'label',
                            text:'Adjunto:'
                        }]
                    },{
                        columnWidth:0.5,
                        items:[{
                            xtype:'button',
                            iconCls:'iconBuscar',
                            handler:function(){
                                if(crresData.CRRES_NOMBRE_ADJUNTO_RESOL!== undefined && crresData.CRRES_NOMBRE_ADJUNTO_RESOL!==null ){
                                    var url1 = URL_DOC_VIEWER+'?table=cgg_res_resolucion&keyc=crres_codigo&keyv='+crresData.CRRES_CODIGO +'&column=crres_adjunto_resolucion&fn='+crresData.CRRES_NOMBRE_ADJUNTO_RESOL+'&request=view';
                                    window.open(url1);
                                }
                            }
                        }]
                    }]
                }]
            },{
                columnWidth:0.5,
                layout:'form',
                items:[{
                    xtype:'textfield',
                    fieldLabel:'Fecha',
                    readOnly:true,
                    id:'txtCrresFechaEjecucion'
                },{
                    xtype:'textarea',
                    fieldLabel:'Observaci\u00f3n',
                    readOnly:true,
                    id:'txtCrresObservaciones',
                    anchor:'100%'
                }]
            }]
        }]
    });

    var fsCarnet = new Ext.form.FieldSet({
        title:'Carnetizaci\u00f3n',
        items:[{
            layout:'column',
            items:[{
                columnWidth:0.5,
                layout:'form',
                items:[{
                    xtype:'textfield',
                    fieldLabel:'N. carnet',
                    readOnly:true,
                    id:'txtNumeroCarnet'
                },{
                    xtype:'textfield',
                    fieldLabel:'Fecha expedici\u00f3n',
                    readOnly:true,
                    id:'txtFechaExpedicion'
                }]
            },{
                columnWidth:0.5,
                layout:'form',
                items:[{
                    xtype:'textfield',
                    fieldLabel:'Fecha caducidad',
                    readOnly:true,
                    id:'txtFechaCaducidad'
                }]
            }]
        }]
    });

    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmTramite_aprobacion.
     */
    var pnlTramite_aprobacion = new Ext.Panel({
        frame:true,
        items:[fsBeneficiarios,fsResolucion,fsCarnet]
    });

    var tpSeguimiento = new Ext.TabPanel({
        id:'tpSeguimiento',
        region:'center',
        layoutOnTabChange:true,
        tabPosition:'bottom',
        items:[{
            title:'Seguimiento',
            xtype:'panel',
            layout:'border',
            id:'tpSeguimiento1',
            items:[pnlSeguimientoP1]
        }]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_seguimiento.
     */
    var winFrmCgg_res_revision_tramite = null;

    if (inDesktop !== null && inDesktop !== undefined) {
        winFrmCgg_res_revision_tramite = new inDesktop.createWindow({
            id:'winFrmCgg_res_revision_tramite',
            layout:'border',
            title:tituloCgg_res_seguimiento,
            tbar:getPanelTitulo(tituloCgg_res_seguimiento, descCgg_res_seguimiento),
            items:[tpSeguimiento],
            width:700,
            height:550,
            maximizable:true,
            minimizable:true,
            constrain:true,
            iconCls:'iconSeguimiento',
            bbar:['->',btnCerrarCgg_res_seguimiento],
            listeners:{
                show:function(){
                    tpSeguimiento.activate('tpSeguimiento1');
                    tpSeguimiento.activate('tpSeguimiento1');

                    tplTramite.compile();
                    tplTramite.overwrite('divTramite', datosTramite);

                    if(isVehiculo)
                        $("idDivBeneficiario").innerHTML = 'Vehiculo';
                }
            }
        });
    } else {
        winFrmCgg_res_revision_tramite = new Ext.Window({
            id:'winFrmCgg_res_revision_tramite',
            layout:'border',
            title:tituloCgg_res_seguimiento,
            tbar:getPanelTitulo(tituloCgg_res_seguimiento, descCgg_res_seguimiento),
            items:[pnlSeguimientoP1],
            width:650,
            height:500,
            maximizable:true,
            minimizable:true,
            constrain:true,
            iconCls:'iconSeguimiento',
            bbar:['->',btnCerrarCgg_res_seguimiento],
            listeners:{
                show:function() {
                    $('divTramite').innerHTML = tplTramite.apply(datosTramite);
                }
            }
        });
    }

    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_revision_tramite.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_res_seguimientoCtrls(inEstado) {
        var estado = !inEstado;
        txtCrseg_codigo.setDisabled(estado);
        txtCgg_crseg_codigo.setDisabled(estado);
    }

    function isla(inCISLA_CODIGO) {
        var tmp1 = SCGG_ISLA.findExact('CISLA_CODIGO', inCISLA_CODIGO);
        var resultado = null;
        if (tmp1 >= 0) {
            resultado = SCGG_ISLA.getAt(tmp1);
        } else {
            resultado = null;
        }
        return resultado;
    }

    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_revision_tramite.
     */
    function cargarCgg_res_seguimientoCtrls(inCrseg_codigo) {
        if (inRecordCgg_res_seguimiento) {
            var paramTramite = new SOAPClientParameters();
            paramTramite.add('inCrtra_codigo',inRecordCgg_res_seguimiento.get("CRTRA_CODIGO"));
            paramTramite.add('format',TypeFormat.JSON);
            var r= SOAPClient.invoke(URL_WS+'Cgg_res_tramite', 'selectTramiteByCode', paramTramite, false,false);
            var tmpTramite = eval(r);
            tmpTramite = tmpTramite[tmpTramite.length-1];
			
            datosTramite.CRTRA_ANIO = tmpTramite.CRTRA_ANIO;
            datosTramite.CRTRA_NUMERO = tmpTramite.CRTRA_NUMERO;
            datosTramite.CRPER_BENEFICIARIO = tmpTramite.CRPER_BENEFICIARIO?tmpTramite.CRPER_BENEFICIARIO:tmpTramite.VEHICULO;
            datosTramite.CRPER_AUSPICIANTE= tmpTramite.CRPER_AUSPICIANTE;
            datosTramite.CRTRA_FECHA_RECEPCION = tmpTramite.CRTRA_FECHA_RECEPCION;
            datosTramite.CRPJR_RAZON_SOCIAL = tmpTramite.CRPJR_RAZON_SOCIAL;
            datosTramite.CISLA_NOMBRE = tmpTramite.CISLA_NOMBRE;
            datosTramite.CRTRA_OBSERVACION = tmpTramite.CRTRA_OBSERVACION?tmpTramite.CRTRA_OBSERVACION:'';
            datosTramite.CRTRA_COMUNICADO_RADIAL = tmpTramite.CRTRA_COMUNICADO_RADIAL;
            datosTramite.CRTRA_CODIGO = tmpTramite.CRTRA_CODIGO;
            datosTramite.CRTRA_DIAS_PERMANENCIA = tmpTramite.CRTRA_DIAS_PERMANENCIA != 0?tmpTramite.CRTRA_DIAS_PERMANENCIA +' dias':tmpTramite.CRTRA_FECHA_SALIDA?truncDate(tmpTramite.CRTRA_FECHA_SALIDA):'INDEFINIDO';
            datosTramite.CRTRA_ACTIVIDAD_RESIDENCIA = tmpTramite.CRTRA_ACTIVIDAD_RESIDENCIA?tmpTramite.CRTRA_ACTIVIDAD_RESIDENCIA:'';
            datosTramite.CRTRA_FOLIO  = tmpTramite.CRTRA_FOLIO;
            datosTramite.CRPER_CODIGO = tmpTramite.CRPER_CODIGO;
            datosTramite.CRTST_DESCRIPCION = tmpTramite.CRTST_DESCRIPCION;
            datosTramite.CRFAS_NOMBRE = tmpTramite.CRFAS_NOMBRE;
            datosTramite.ETIQUETA = tmpTramite.VEHICULO?'Vehiculo:':'Beneficiario:';


            //tmpTramite.CRSEG_CODIGO
            isEdit = true;
            habilitarCgg_res_seguimientoCtrls(true);
            gsCgg_jur_seguimiento_criterio.reload({
                params:{
                    inCrseg_codigo:tmpTramite.CRSEG_CODIGO,
                    inCrfas_codigo:tmpTramite.CRFAS_CODIGO,
                    format:TypeFormat.JSON
                }
            });
            gsCgg_res_adjunto.reload({
                params:{
                    inCrseg_codigo:tmpTramite.CRSEG_CODIGO,
                    format:TypeFormat.JSON
                }
            });

            gsCgg_res_novedad_notificacion.reload({
                params:{
                    inCrseg_codigo:tmpTramite.CRSEG_CODIGO,
                    format:TypeFormat.JSON
                }
            });

            gsCgg_res_informe_seguimiento.reload({
                params:{
                    inCrseg_codigo:tmpTramite.CRSEG_CODIGO,
                    format:TypeFormat.JSON
                }
            });

            gsCgg_res_seguimiento_requisito.reload({
                params:{
                    inCrtst_codigo: tmpTramite.CRTST_CODIGO,
                    inCrtra_codigo: inRecordCgg_res_seguimiento.get('CRTRA_CODIGO'),
                    format: TypeFormat.JSON
                }
            });



        }
    }


    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_revision_tramite.
     * @returns ventana winFrmCgg_res_revision_tramite.
     * @base FrmCgg_res_revision_tramite.prototype.show
     */
    this.getWindow = function() {
        return winFrmCgg_res_revision_tramite;

    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_revision_tramite.
     * @base FrmCgg_res_revision_tramite.prototype.loadData
     */
    this.loadData = function(inFullLoad) {
        cargarCgg_res_seguimientoCtrls(inFullLoad);
    }

    this.setVehiculo = function(){
        isVehiculo = true;
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_revision_tramite desde una instancia.
 */
FrmCgg_res_revision_tramite.prototype.show = function() {
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_revision_tramite desde una instancia.
 */
FrmCgg_res_revision_tramite.prototype.close = function() {
    this.getWindow().close();
}

/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_revision_tramite,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_revision_tramite.prototype.closeHandler = function(inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_revision_tramite desde una instancia.
 */
FrmCgg_res_revision_tramite.prototype.loadData = function(inCrseg_codigo) {
    this.loadData(inCrseg_codigo);
}

/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_revision_tramite desde una instancia.
 */
FrmCgg_res_revision_tramite.prototype.setVehiculo = function() {
    this.setVehiculo();
}
