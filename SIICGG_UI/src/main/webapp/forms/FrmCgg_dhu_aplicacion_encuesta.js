/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_dhu_aplicacion_encuesta.
 * @param {String} INSENTENCIA_CGG_DHU_APLICACION_ENCUESTA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_DHU_APLICACION_ENCUESTA Registro de datos de la tabla Cgg_dhu_aplicacion_encuesta.
 * @constructor
 * @base FrmListadoCgg_dhu_aplicacion_encuesta
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_dhu_aplicacion_encuesta(INSENTENCIA_CGG_DHU_APLICACION_ENCUESTA,INRECORD_CGG_DHU_APLICACION_ENCUESTA){
    var inSentenciaCgg_dhu_aplicacion_encuesta = INSENTENCIA_CGG_DHU_APLICACION_ENCUESTA;
    var inRecordCgg_dhu_aplicacion_encuesta=INRECORD_CGG_DHU_APLICACION_ENCUESTA;
    var urlCgg_dhu_aplicacion_encuesta=URL_WS+"Cgg_dhu_aplicacion_encuesta";
    var tituloCgg_dhu_aplicacion_encuesta='Aplicaci\u00f3n Encuesta';
    var descCgg_dhu_aplicacion_encuesta='El formulario permite administrar informaci\u00f3n de Aplicaci\u00f3n Encuesta';
    var isEdit = false;
    var tmpCdcre_codigo;
    var tmpgrd_preguntas_respuestas;
    var tmpCdenc_codigo;
    var tmpCdcategoria;
    var inRecordsRespuesta = new Array();
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE APLICACION DE LA ENCUESTA
     */
    var txtCdape_codigo = new Ext.form.TextField({
        id:'txtCdape_codigo',
        name:'txtCdape_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCdcre_codigo = new Ext.form.TextField({
        id:'txtCdcre_codigo',
        name:'txtCdcre_codigo',
        fieldLabel :'Encuesta',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true'
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO
     */
    var btnCdcre_codigoCgg_dhu_aplicacion_encuesta = new Ext.Button({
        id:'btnCdcre_codigoCgg_dhu_aplicacion_encuesta',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_dhu_cronograma_encuesta = new FrmListadoCgg_dhu_cronograma_encuesta();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_dhu_cronograma_encuesta.getStore(),tmpFLCgg_dhu_cronograma_encuesta.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){{
                        tmpCdcre_codigo=tmpRecord.get('CDCRE_CODIGO');
                        tmpCdenc_codigo=tmpRecord.get('CDENC_CODIGO');
                        txtCdcre_codigo.setValue(tmpRecord.get('CDENC_NOMBRE'));
                        gsCgg_dhu_aplicacion_categoria_preguntas_respuestas.reload({
                            params:{
                                inCdenc_codigo:tmpCdenc_codigo,
                                format:TypeFormat.JSON
                            }
                        });

                    }
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.DateField FECHA DE APLICACION DE LA ENCUESTA
     */
    var dtCdape_fecha = new Ext.form.DateField({
        id:'dtCdape_fecha',
        name:'dtCdape_fecha',
        fieldLabel :'Fecha Aplicaci\u00f3n',
        allowBlank :false,
        value:new Date()
    });
    /**
     * Ext.form.TextArea OBSERVACION DE LA ENCUESTA
     */
    var txtCdape_observacion = new Ext.form.TextArea({
        id:'txtCdape_observacion',
        name:'txtCdape_observacion',
        fieldLabel :'Observaci\u00f3n',
        width:'98%'
    });
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ENCUESTAS
     */
    var txtCdrge_codigo = new Ext.form.TextField({
        id:'txtCdrge_codigo',
        name:'txtCdrge_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextArea REDACCION DEL TEXTO DE RESPUESTA A PREGUNTAS ABIERTAS
     */
    var txtCdrge_respuesta_abierta = new Ext.form.TextArea({
        id:'txtCdrge_respuesta_abierta',
        name:'txtCdrge_respuesta_abierta',
        fieldLabel :'Respuesta abierta',
        width:'90%'
    });
    /**
     * Ext.form.DateField FECHA DE REGISTRO DE LA  ENCUESTA
     */
    var dtCdrge_fecha_registro = new Ext.form.DateField({
        id:'dtCdrge_fecha_registro',
        name:'dtCdrge_fecha_registro',
        fieldLabel :'Fecha Registro',
        allowBlank :false,
        value:new Date(),
        readOnly:true
    });
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Ext.form.Checkbox ESTADO QUE DETERMINA SI LA PREGUNTA SE PUEDE CUANTIFICAR
     */
    var chkCdres_valor = new Ext.form.Checkbox({
        id:'chkCdres_valor',
        name:'chkCdres_valor',
        fieldLabel :'Valor',
        allowBlank :false,
        checked:false
    });
    var tmpColumns = new Array();
    tmpColumns.push({dataIndex:'CDPRG_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true, hiddeable:false});
    tmpColumns.push({dataIndex:'CDPRG_DESCRIPCION',header:'Pregunta',width:300,sortable:true});
    /**
     * Ext.ColumnModel Agrupacion de registros de la tabla Cgg_dhu_preguntas_respuestas
     *  por un campo especifico.
     */
    var cmCgg_dhu_aplicacion_preguntas_respuestas = new Ext.grid.ColumnModel(tmpColumns);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_pregunta por un campo especifico.
     */
    var gsCgg_dhu_aplicacion_preguntas_respuestas1 = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS + "Cgg_dhu_registro_encuesta",
            method:"selectPageRegistroEncuestaByEnc",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({

            root:'dataSet',
            totalProperty: 'totalCount'
        }, [
            {name:'CDPRG_CODIGO'},
            {name:'CDPRG_DESCRIPCION'},
            {name:'CDPRG_CUANTIFICABLE'},
            {name:'CDPRG_MULTIPLE'},
            {name:'CDRES_CODIGO'},
            {name:'CDRES_DESCRIPCION'},
            {name:'CDRGE_RESPUESTA_ABIERTA'}
        ]),
        baseParams:{inCdcat_codigo:'',format:"JSON",inCdenc_codigo: ''}
    });
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_pregunta por un campo especifico.
     */
    var gsCgg_dhu_aplicacion_categoria_preguntas_respuestas = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS + "Cgg_dhu_registro_encuesta",
            method:"selectPageCategoriaRegistroEncuesta",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({

            root:'dataSet',
            totalProperty: 'totalCount'
        }, [
            {name:'CDCAT_CODIGO'},
            {name:'CDCAT_DESCRIPCION'}
        ]),
        baseParams:{inCdenc_codigo:'',format:"JSON"},
        listeners:{
            load:function(inStore, inRecords, inObject) {
                tmpCdcategoria= gsCgg_dhu_aplicacion_categoria_preguntas_respuestas.getAt(0).get('CDCAT_CODIGO');
                gsCgg_dhu_aplicacion_preguntas_respuestas1.reload({
                    params:{
                        inCdcat_codigo:tmpCdcategoria,
                        format:TypeFormat.JSON,
						inCdenc_codigo: tmpCdenc_codigo
                    }
                });
                var tmpColumns = new Array();
                tmpColumns.push({dataIndex:'CDPRG_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true, hiddeable:false});
                tmpColumns.push({dataIndex:'CDPRG_DESCRIPCION',header:'Pregunta',width:300,sortable:true});
               

                consultarValorRespuesta(tmpCdcategoria,cmCgg_dhu_aplicacion_preguntas_respuestas);
                for (var ix=1;ix<gsCgg_dhu_aplicacion_categoria_preguntas_respuestas.getCount();ix++){
                    tmpCdcategoria= gsCgg_dhu_aplicacion_categoria_preguntas_respuestas.getAt(ix).get('CDCAT_CODIGO');
                    cmCgg_dhu_aplicacion_preguntas_respuestas = new Ext.grid.ColumnModel(tmpColumns);
                    consultarValorRespuesta(tmpCdcategoria,cmCgg_dhu_aplicacion_preguntas_respuestas);
                    /**
                     * Ext.form.Checkbox ESTADO QUE DETERMINA SI LA PREGUNTA SE PUEDE CUANTIFICAR
                     */
                    var chkCdres_valor = new Ext.form.Checkbox({
                        id:'chkCdres_valor',
                        name:'chkCdres_valor',
                        fieldLabel :'Valor',
                        allowBlank :false,
                        checked:false
                    });


                    /**
                     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_pregunta por un campo especifico.
                     */
                    var gsCgg_dhu_aplicacion_preguntas_respuestas = new Ext.data.Store({
                        proxy:new Ext.ux.bsx.SoapProxy({
                            url:URL_WS + "Cgg_dhu_registro_encuesta",
                            method:"selectPageRegistroEncuestaByEnc",
                            pagin:false
                        }),
                        remoteSort:false,
                        reader:new Ext.data.JsonReader({

                            root:'dataSet',
                            totalProperty: 'totalCount'
                        }, [
                            {name:'CDPRG_CODIGO'},
                            {name:'CDPRG_DESCRIPCION'},
                            {name:'CDPRG_CUANTIFICABLE'},
                            {name:'CDPRG_MULTIPLE'},
                            {name:'CDRES_CODIGO'},
                            {name:'CDRES_DESCRIPCION'},
                            {name:'CDRGE_RESPUESTA_ABIERTA'}
                        ]),
                        baseParams:{
							inCdcat_codigo:tmpCdcategoria,
							format:"JSON",
							inCdenc_codigo: tmpCdenc_codigo
						}
                    });
                    gsCgg_dhu_aplicacion_preguntas_respuestas.load();

                    /**
                     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_dhu_preguntas en un formato tabular de filas y columnas.
                     */
                    var grdCgg_res_preguntas = new Ext.grid.EditorGridPanel({
                        cm:cmCgg_dhu_aplicacion_preguntas_respuestas,
                        store:gsCgg_dhu_aplicacion_preguntas_respuestas,
                        anchor:'100% 100%',
                        sm:new Ext.grid.RowSelectionModel({
                            singleSelect:true
                        }),

                        loadMask:{
                            msg:"Cargando..."
                        }

                    });

                    tblCategoria.add(grdCgg_res_preguntas);
                }
               
            }
        }
    });
    function consultarValorRespuesta(tmpCdcategoria,cmTmp)
    {
        try{
            function CallBackCgg_dhu_valor_respuesta(r){

                var tmp = eval("("+r+")");
                var inRecords = tmp.dataSet;
                inRecordsRespuesta.push({categoria:tmpCdcategoria,record:inRecords});
                tmpColumns = new Array();
                tmpColumns.push({dataIndex:'CDPRG_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true, hiddeable:false});
                tmpColumns.push({dataIndex:'CDPRG_DESCRIPCION',header:'Pregunta',width:300,sortable:true});
                for (i=0; i<inRecords.length;i++){
                    var inRecord = inRecords[i];
                    if (inRecord.CDPRG_CUANTIFICABLE== true){
                        if (inRecord.CDPRG_MULTIPLE!= true){
                            tmpColumns.push({id: inRecord.CDRES_CODIGO, dataIndex:'CDPRG_CODIGO1',header:inRecord.CDRES_DESCRIPCION,width:50,sortable:true,renderer:
                                    function(v,e,rec){

                                        return "<input type= 'radio' name='"+rec.get("CDPRG_CODIGO")+"' id ='"+rec.get("CDPRG_CODIGO")+e.id+"'/>";
                                    }
                            });
                        }else{
                            tmpColumns.push({id: inRecord.CDRES_CODIGO,dataIndex:'CDPRG_CODIGO1',header:inRecord.CDRES_DESCRIPCION,width:50,sortable:true,renderer:
                                    function(v,e,rec){
                                        return "<input type= 'checkbox' name='"+rec.get("CDPRG_CODIGO")+"' id ='"+rec.get("CDPRG_CODIGO")+e.id+"'/>";
                                    }
                            });
                        }
                    }else{
                        tmpColumns.push({id: inRecord.CDRES_CODIGO,dataIndex:'CDPRG_CODIGO1',header:inRecord.CDRES_DESCRIPCION,width:250,sortable:true,editor:txtCdrge_respuesta_abierta
                        });
                    }
                }
                cmTmp.setConfig(tmpColumns);

            }
            var param = new SOAPClientParameters();
            param.add('inCdcat_codigo',tmpCdcategoria);
            param.add('format',TypeFormat.JSON);
            SOAPClient.invoke(URL_WS+"Cgg_dhu_registro_encuesta",'selectPageRegistroRespuesta_Pregunta',param, false, CallBackCgg_dhu_valor_respuesta);
        }catch(inErr){

        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_persona_contacto en un formato tabular de filas y columnas.
     */
    var grdCgg_res_preguntas = new Ext.grid.EditorGridPanel({
        cm:cmCgg_dhu_aplicacion_preguntas_respuestas,
        store:gsCgg_dhu_aplicacion_preguntas_respuestas1,
        anchor:'100% 100%',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),

        loadMask:{
            msg:"Cargando..."
        }

    });
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_dhu_aplicacion_encuesta
     */
    var btnGuardarCgg_dhu_aplicacion_encuesta = new Ext.Button({
        id:'btnGuardarCgg_dhu_aplicacion_encuesta',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_dhu_aplicacion_encuesta.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_dhu_aplicacion_encuesta(r){
                        winFrmCgg_dhu_aplicacion_encuesta.getEl().unmask();
                        if(r!='false'){
                            var tmpIsAll = false;
                            var resultado = true;
                            var tmpSentencia = INSENTENCIA_CGG_DHU_APLICACION_ENCUESTA;
                            function CallBackCgg_dhu_registro_encuesta(r){
                                resultado = resultado && r;
                                if(tmpIsAll){
                                    if (resultado){
                                        Ext.Msg.show({
                                            title:tituloCgg_dhu_aplicacion_encuesta,
                                            msg: 'La informaci\u00f3n de Aplicacion Encuesta ha sido almacenada.',
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.INFO
                                        });winFrmCgg_dhu_aplicacion_encuesta.close()
                                    }else{
                                        Ext.Msg.show({
                                            title:tituloCgg_dhu_aplicacion_encuesta,
                                            msg: 'La informaci\u00f3n de Aplicacion Encuesta no ha podido ser almacenada.',
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.ERROR
                                        });
                                    }
                                }
                            }
                            var tmpRespuestas1 = new Array();
                            for(var k = 0; k < tblCategoria.items.length; k++) {
                                var param1 = new SOAPClientParameters();
                                var tmpObj = tblCategoria.items.get(k);                                
                                tmpIsAll = (k == tblCategoria.items.length - 1);
                                var tmpStore = tmpObj.getStore();
                                var codigoCategoria = (tmpStore.lastOptions.params)?tmpStore.lastOptions.params.inCdcat_codigo:tmpStore.baseParams.inCdcat_codigo;
                                var posCategoria = 0;
                                for (var i=0;i<inRecordsRespuesta.length;i++) {
                                    if (inRecordsRespuesta[i].categoria == codigoCategoria)
                                        posCategoria = i;
                                }
                                for (var i=0;i< tmpObj.getStore().getCount();i++) {
                                    var tmpRecord = tmpObj.getStore().getAt(i);
                                    var tmpRecRespuesta = inRecordsRespuesta[posCategoria].record;
                                    for (var j=0;j<tmpRecRespuesta.length;j++) {

                                        if (tmpRecord.get("CDPRG_CUANTIFICABLE")){
                                            if (tmpRecord.get("CDPRG_MULTIPLE")!=true){
                                                var tmpId = tmpRecord.get('CDPRG_CODIGO')+ tmpRecRespuesta[j].CDRES_CODIGO;

                                                var tmpComponente = document.getElementById(tmpId);
                                                if (tmpComponente){                                                    
                                                    if (tmpComponente.checked){
                                                        tmpRespuestas1.push({CDPRG_CODIGO:tmpRecord.get('CDPRG_CODIGO'),CDRES_CODIGO:tmpRecRespuesta[j].CDRES_CODIGO,CDRGE_RESPUESTA_ABIERTA:'null'});
                                                        break;
                                                    }
                                                }
                                            }else{

                                                var tmpId = tmpRecord.get('CDPRG_CODIGO')+ tmpRecRespuesta[j].CDRES_CODIGO;
                                                var tmpComponente = document.getElementById(tmpId);
                                                if (tmpComponente){
                                                    if (tmpComponente.checked){
                                                        tmpRespuestas1.push({CDPRG_CODIGO:tmpRecord.get('CDPRG_CODIGO'),CDRES_CODIGO:tmpRecRespuesta[j].CDRES_CODIGO,CDRGE_RESPUESTA_ABIERTA:'null'});
                                                    }
                                                }

                                            }

                                        }else{
                                            tmpRespuestas1.push({CDPRG_CODIGO:tmpRecord.get('CDPRG_CODIGO'),CDRES_CODIGO:tmpRecRespuesta[j].CDRES_CODIGO,CDRGE_RESPUESTA_ABIERTA:tmpRecord.get('CDPRG_CODIGO1')});
                                        }
                                        
                                   }
                                }
                            }
                            param1.add('inPreguntas_Respuestas',Ext.encode(tmpRespuestas1));
                            param1.add('inCdape_codigo',r);
                            param1.add('inCdrge_fecha_registro',dtCdrge_fecha_registro.getValue().format('c'));
                            SOAPClient.invoke(URL_WS+"Cgg_dhu_registro_encuesta",tmpSentencia,param1, true, CallBackCgg_dhu_registro_encuesta);
                        }
                    }
                    winFrmCgg_dhu_aplicacion_encuesta.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                    param.add('inCdape_codigo',txtCdape_codigo.getValue());
                    param.add('inCdcre_codigo',tmpCdcre_codigo);
                    param.add('inCdape_fecha',dtCdape_fecha.getValue().format('c'));
                    param.add('inCdape_observacion',txtCdape_observacion.getValue());


                    SOAPClient.invoke(urlCgg_dhu_aplicacion_encuesta,INSENTENCIA_CGG_DHU_APLICACION_ENCUESTA,param, true, CallBackCgg_dhu_aplicacion_encuesta);
                }catch(inErr){
                    winFrmCgg_dhu_aplicacion_encuesta.getEl().unmask();
                }

            }
        }
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_dhu_aplicacion_encuesta.
     */
    var btnCancelarCgg_dhu_aplicacion_encuesta = new Ext.Button({
        id:'btnCancelarCgg_dhu_aplicacion_encuesta',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_dhu_aplicacion_encuesta.getForm().reset();

            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_dhu_aplicacion_encuesta.
     */
    var btnCerrarCgg_dhu_aplicacion_encuesta = new Ext.Button({
        id:'btnCerrarCgg_dhu_aplicacion_encuesta',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_dhu_aplicacion_encuesta.close();
            }}
    });
    /**
     * ExtPanel Panel que contiene los controles de la aplicaion de la Encuesta
     */
    var pnlfsAplicacionEncuesta = new Ext.form.FieldSet({
        id:'pnlfsAplicacionEncuesta',
        name:'pnlfsAplicacionEncuesta',
        title:'Encuesta',
        height:150,
        collapsible: true,
        autoHeight:true,
        items:[{xtype:'panel',layout:'column',
            items:[
                {columnWidth:.92,layout:'form',items:[txtCdcre_codigo]},
                {columnWidth:.08,layout:'form',items:[btnCdcre_codigoCgg_dhu_aplicacion_encuesta]}]},
            {xtype:'panel',layout:'column',
                items:[
                    {columnWidth:.50,layout:'form',items:[dtCdape_fecha]},
                    {columnWidth:.50,layout:'form',items:[dtCdrge_fecha_registro]}]},
            txtCdape_observacion],
        listeners:{
            collapse:function(inPanel) {
                grdCgg_res_preguntas.setHeight(550);
                winFrmCgg_dhu_aplicacion_encuesta.doLayout(true);

            },
            expand:function(inPanel) {
                grdCgg_res_preguntas.setHeight(201);
                winFrmCgg_dhu_aplicacion_encuesta.doLayout(true);

            }
        }
    });

    /**
     * Ext.form.TabPanel TabPanel para ordenar las catgorias de las preguntas
     */
    var tblCategoria = new Ext.TabPanel({
        id:'tblCategoria',
        name:'tblCategoria',
        region:'south',
        title:'Categor\u00eda',
        height:220,
        activeTab:0,
        frame: true,
        
        items:[grdCgg_res_preguntas]
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_dhu_aplicacion_encuesta.
     */
    var pnlCgg_dhu_aplicacion_encuesta = new Ext.form.FormPanel({
        id:'pnlCgg_dhu_aplicacion_encuesta',
        name:'pnlCgg_dhu_aplicacion_encuesta',
        frame:true,

        layout:'form',
        labelWidth :100,
        items:[txtCdape_codigo,
            pnlfsAplicacionEncuesta
        ]
    });

    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_dhu_aplicacion_encuesta.
     */
    var winFrmCgg_dhu_aplicacion_encuesta = new Ext.Window({
        id:'winFrmCgg_dhu_aplicacion_encuesta',
        title:tituloCgg_dhu_aplicacion_encuesta,
        tbar:getPanelTitulo(tituloCgg_dhu_aplicacion_encuesta,descCgg_dhu_aplicacion_encuesta),
        items:[pnlCgg_dhu_aplicacion_encuesta,tblCategoria],
        width:600,
        minWidth:600,
        height:500,
        // layout:'border',
        minHeight:500,
        maximizable:true,
        minimizable:true,
        constrain:true,
        bbar:[btnGuardarCgg_dhu_aplicacion_encuesta,btnCancelarCgg_dhu_aplicacion_encuesta,'->',btnCerrarCgg_dhu_aplicacion_encuesta]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_dhu_aplicacion_encuesta.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_dhu_aplicacion_encuestaCtrls(inEstado){
        estado=!inEstado;
        txtCdape_codigo.setDisabled(estado);
        txtCdcre_codigo.setDisabled(estado);
        dtCdape_fecha.setDisabled(estado);
        txtCdape_observacion.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_dhu_aplicacion_encuesta.
     */
    function cargarCgg_dhu_aplicacion_encuestaCtrls(){
        if(inRecordCgg_dhu_aplicacion_encuesta){
            txtCdape_codigo.setValue(inRecordCgg_dhu_aplicacion_encuesta.get('CDAPE_CODIGO'));
            txtCdcre_codigo.setValue(inRecordCgg_dhu_aplicacion_encuesta.get('CDCRE_CODIGO'));
            dtCdape_fecha.setValue(inRecordCgg_dhu_aplicacion_encuesta.get('CDAPE_FECHA'));
            txtCdape_observacion.setValue(inRecordCgg_dhu_aplicacion_encuesta.get('CDAPE_OBSERVACION'));
            isEdit = true;
            habilitarCgg_dhu_aplicacion_encuestaCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_dhu_aplicacion_encuesta.
     * @returns ventana winFrmCgg_dhu_aplicacion_encuesta.
     * @base FrmCgg_dhu_aplicacion_encuesta.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_dhu_aplicacion_encuesta;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_dhu_aplicacion_encuesta.
     * @base FrmCgg_dhu_aplicacion_encuesta.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_dhu_aplicacion_encuestaCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_dhu_aplicacion_encuesta desde una instancia.
 */
FrmCgg_dhu_aplicacion_encuesta.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_dhu_aplicacion_encuesta desde una instancia.
 */
FrmCgg_dhu_aplicacion_encuesta.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_dhu_aplicacion_encuesta,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_dhu_aplicacion_encuesta.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_dhu_aplicacion_encuesta desde una instancia.
 */
FrmCgg_dhu_aplicacion_encuesta.prototype.loadData = function(){
    this.loadData();
}
