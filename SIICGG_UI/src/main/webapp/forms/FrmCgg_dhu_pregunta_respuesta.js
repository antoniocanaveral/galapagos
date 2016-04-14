/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_dhu_pregunta_respuesta.
 * @param {String} INSENTENCIA_CGG_DHU_PREGUNTA_RESPUESTA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_DHU_PREGUNTA_RESPUESTA Registro de datos de la tabla Cgg_dhu_pregunta_respuesta.
 * @constructor
 * @base FrmListadoCgg_dhu_pregunta_respuesta
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_dhu_pregunta_respuesta(INSENTENCIA_CGG_DHU_PREGUNTA_RESPUESTA,INRECORD_CGG_DHU_PREGUNTA_RESPUESTA){
    var inSentenciaCgg_dhu_pregunta_respuesta = INSENTENCIA_CGG_DHU_PREGUNTA_RESPUESTA;
    var inRecordCgg_dhu_pregunta_respuesta=INRECORD_CGG_DHU_PREGUNTA_RESPUESTA;
    var urlCgg_dhu_pregunta_respuesta=URL_WS+"Cgg_dhu_pregunta_respuesta";
    var tituloCgg_dhu_pregunta_respuesta='Pregunta - Respuesta';
    var descCgg_dhu_pregunta_respuesta='El formulario permite administrar informaci\u00f3n de la Pregunta - Respuesta';
    var isEdit = false;
    var tmpCdcat_codigo;
    var tmpCdprg_codigo;
    var tmpsmPreguntas;

    /**
     * Ext.form.NumberField VALOR ASIGNADO A UNA RESPUESTA SOBRE UNA PREGUNTA
     */
    var numCdprs_valoracion = new Ext.form.NumberField({
        id:'numCdprs_valoracion',
        name:'numCdprs_valoracion',
        fieldLabel :'Valoraci\u00f3n',
        value:0
    });/**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_dhu_pregunta_respuesta
     */
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_aerolinea por un campo especifico.
     */
    var gsCdcat_categoria = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_categoria",
            method:"selectAll"
        }),
        reader:new Ext.data.JsonReader({},[
            {name:'CDCAT_CODIGO'},
            {name:'CDCAT_NOMBRE'}
        ]),
        baseParams:{
            format:TypeFormat.JSON
        }
    });
    /**
     * Ext.form.ComboBox IDENTIFICATIVO UNICO DE REGISTRO DE LA CATEGORIA
     */

    var cbxCdcat_codigo = new Ext.form.ComboBox({	
        id:'cbxCdcat_codigo',
		name : 'cbxCdcat_codigo',
        fieldLabel :'Categor\u00eda',		
        displayField:'CDCAT_NOMBRE',
        store:gsCdcat_categoria,
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione una Categor\u00eda',
        selectOnFocus:true,
        valueField:'CDCAT_CODIGO',
        allowBlank :false,
        anchor:'98%',
        listeners:
        {
            select:function(combo,record)
            {
                tmpCdcat_codigo = record.get('CDCAT_CODIGO');
                gsCgg_dhu_pregunta1.reload({
                    params:{
                        inCdcat_codigo:tmpCdcat_codigo,
                        format:TypeFormat.JSON
                    }
				});
                gsCgg_dhu_respuesta.reload({
                    params:{                        
						inCdcat_codigo : record.get('CDCAT_CODIGO'),
						format:TypeFormat.JSON
					}
				});
            }
        }
    });
    gsCdcat_categoria.load();

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //PREGUNTAS
    tmpsmPreguntas = new Ext.grid.CheckboxSelectionModel({});


    var cmCgg_dhu_pregunta1 = new Ext.grid.ColumnModel([
        //tmpsmPreguntas,
        {dataIndex:'CDPRG_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'CDPRG_DESCRIPCION',header:'Descripci\u00f3n',width:150,sortable:true}
    ]);

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_pregunta por un campo especifico.
     */
    var gsCgg_dhu_pregunta1 = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS + "Cgg_dhu_pregunta",
            method:"selectCategoria",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
            id:'CDPRG_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CDPRG_CODIGO'},
            {name:'CDPRG_DESCRIPCION'}
        ]),

        baseParams:{
            inCdcat_codigo:"",
            format:"JSON"
        },
         listeners:{
			 load:function(){
				/*if (isEdit){
                    gsCgg_dhu_respuesta.removeAll();
                    tmpCdprg_codigo= grdCgg_dhu_pregunta.getSelectionModel().getSelected().get('CDPRG_CODIGO');
                    gsCgg_dhu_respuesta_preguntarespuesta.reload({
                        params:{
                            inCdprg_codigo:tmpCdprg_codigo,
                            format:TypeFormat.JSON
                        }});
                }*/
				/*if (isEdit){
                    gsCgg_dhu_respuesta.removeAll();
                    tmpCdprg_codigo= gsCgg_dhu_pregunta1.getAt(0).get('CDPRG_CODIGO');
                    gsCgg_dhu_respuesta_preguntarespuesta.reload({
                        params:{
                            inCdprg_codigo:tmpCdprg_codigo,
                            format:TypeFormat.JSON
                        }});
                }*/
			 }
         }

    });
	
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_pregunta_respuesta por un campo especifico.
     */
 

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_dhu_pregunta en un formato tabular de filas y columnas.
     */
    var grdCgg_dhu_pregunta = new Ext.grid.EditorGridPanel({
        cm:cmCgg_dhu_pregunta1,
        store:gsCgg_dhu_pregunta1,
        viewConfig:{forceFit:true},
        region:"center",
        sm:tmpsmPreguntas,
        loadMask:{msg:"Cargando..."},
        listeners:{
            rowclick:function(inGrid, inNumber, inObject){
            /*    if (isEdit){
                    gsCgg_dhu_respuesta.removeAll();
                    tmpCdprg_codigo= grdCgg_dhu_pregunta.getSelectionModel().getSelected().get('CDPRG_CODIGO');
                    gsCgg_dhu_respuesta_preguntarespuesta.reload({
                        params:{
                            inCdprg_codigo:tmpCdprg_codigo,
                            format:TypeFormat.JSON
                        }});
                }*/
            }}
    });
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //RESPUESTAS
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_respuesta.
     */
    var smRespuestas = new Ext.grid.CheckboxSelectionModel({
        checkOnly : true
    });
    var cmCgg_dhu_respuesta = new Ext.grid.ColumnModel([
        smRespuestas,
        {dataIndex:'CDRES_CODIGO',header:'Codigo',width:150,sortable:true, hidden:true, hiddeable:false},
        {dataIndex:'CDRES_DESCRIPCION',header:'Descripci\u00f3n',width:150,sortable:true},
        {dataIndex:'CDPRS_VALORACION',header:'Valoraci\u00f3n',width:150,sortable:true, editor:numCdprs_valoracion}
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_respuesta por un campo especifico.
     */
    var gsCgg_dhu_respuestaNOvalida = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_respuesta",
            method:"selectAll",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
            id:'CDRES_CODIGO'
        },[
            {name:'CDRES_CODIGO'},
            {name:'CDRES_DESCRIPCION'},
            {name:'CDPRS_VALORACION'}
        ]),
        baseParams:{format:"JSON"}
    });
	var gsCgg_dhu_respuesta = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_pregunta_respuesta",
            method:"selectPreguntaRespuestaGeneral",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
            id:'CDRES_CODIGO'/*,
             root:'dataSet',
             totalProperty: 'totalCount'*/
        },[
            {name:'CDRES_CODIGO'},
            {name:'CDRES_DESCRIPCION'},
            {name:'CDPRS_VALORACION'}
        ]),
        baseParams:{
			format:"JSON",
			inCdcat_codigo : ''},
		listeners:{
			load:function(){
				var a = gsCgg_dhu_respuesta;	
				for(i=0;i<gsCgg_dhu_respuesta.data.length;i++){					
					if(gsCgg_dhu_respuesta.getAt(i).get('CDPRS_VALORACION') || gsCgg_dhu_respuesta.getAt(i).get('CDPRS_VALORACION') == '0'){
						grdCgg_dhu_respuesta.selModel.selectRow(i,true);  
					}else{						
						grdCgg_dhu_respuesta.selModel.deselectRow(i,false);			
					}
				}
			}
		}
    });

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_respuesta por un campo especifico.
     */
    var gsCgg_dhu_respuesta_preguntarespuesta = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_pregunta_respuesta",
            method:"selectAllRespuesta_PreguntaRespuesta",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
            id:'CDRES_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CDRES_CODIGO'},
            {name:'CDRES_DESCRIPCION'},
            {name:'CDPRS_VALORACION'}
        ]),
        baseParams:{
            inCdprg_codigo:'',
            format:"JSON"},
        listeners:{
            load:function(){
                gsCgg_dhu_respuesta.add( gsCgg_dhu_respuesta_preguntarespuesta.getRange(0,gsCgg_dhu_respuesta_preguntarespuesta.getCount()-1));
            }
        }
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_dhu_respuesta en un formato tabular de filas y columnas.
     */
    var grdCgg_dhu_respuesta = new Ext.grid.EditorGridPanel({
        cm:cmCgg_dhu_respuesta,
        store:gsCgg_dhu_respuesta,
        region:'center',
        clicksToEdit: 1,
        sm:smRespuestas,
        viewConfig:{forceFit:true},
        loadMask:{msg:"Cargando..."}

    });
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    var btnGuardarCgg_dhu_pregunta_respuesta = new Ext.Button({
        id:'btnGuardarCgg_dhu_pregunta_respuesta',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_dhu_pregunta_respuesta.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_dhu_pregunta_respuesta(r){
                        winFrmCgg_dhu_pregunta_respuesta.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_dhu_pregunta_respuesta,
                                msg: 'La informaci\u00f3n de Pregunta - Respuesta ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_dhu_pregunta_respuesta.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_dhu_pregunta_respuesta,
                                msg: 'La informaci\u00f3n de Pregunta - Respuesta no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_dhu_pregunta_respuesta.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                                            
                    //param.add('inCdprg_pregunta', createJSONObject(grdCgg_dhu_pregunta.getSelectionModel().getSelections()));
					param.add('inCdprg_pregunta', grdCgg_dhu_pregunta.getStore().getJsonData());
                    param.add('inCdres_respuesta',createJSONObject(grdCgg_dhu_respuesta.getSelectionModel().getSelections()));
                    SOAPClient.invoke(urlCgg_dhu_pregunta_respuesta,INSENTENCIA_CGG_DHU_PREGUNTA_RESPUESTA,param, true, CallBackCgg_dhu_pregunta_respuesta);
                }catch(inErr){
                    winFrmCgg_dhu_pregunta_respuesta.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_dhu_pregunta_respuesta.
     */
    var btnCancelarCgg_dhu_pregunta_respuesta = new Ext.Button({
        id:'btnCancelarCgg_dhu_pregunta_respuesta',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_dhu_pregunta_respuesta.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_dhu_pregunta_respuesta.
     */
    var btnCerrarCgg_dhu_pregunta_respuesta = new Ext.Button({
        id:'btnCerrarCgg_dhu_pregunta_respuesta',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_dhu_pregunta_respuesta.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_dhu_pregunta_respuesta.
     */
    var pnlCgg_dhu_pregunta_respuesta = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        layout:'border',
        region:'center',
        items:[{
            xtype:'panel',
            region:'north',
            layout:'form',
            height:50,
            frame:true,
            items:[/*txtCdprs_codigo,*/cbxCdcat_codigo]
        },{
            xtype:'panel',
            region:'center',
            layout:'column',
           // bodyStyle:'border:1 dashed GRAY',
            border:true,
            items:[{
                columnWidth:.5,
                xtype:'panel',
                title: 'Preguntas',
                bodyStyle:"height:100%",
                layout:"border",
                items:[grdCgg_dhu_pregunta]
            },{
                columnWidth:.5,
                xtype:'panel',
                title: 'Respuestas',
                bodyStyle:"height:100%",
                layout:"border",
                items:[grdCgg_dhu_respuesta]
            }]
        }]
    });


    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_dhu_pregunta_respuesta.
     */
    var winFrmCgg_dhu_pregunta_respuesta = new Ext.Window({
        id:'winFrmCgg_dhu_pregunta_respuesta',
        title:tituloCgg_dhu_pregunta_respuesta,
        tbar:getPanelTitulo(tituloCgg_dhu_pregunta_respuesta,descCgg_dhu_pregunta_respuesta),
        items:[pnlCgg_dhu_pregunta_respuesta],
        width:600,
        layout:'border',
        minWidth:600,
        height:500,
        maximizable:false,
        minimizable:false,
        constrain:true,
		modal : true,
        bbar:[btnGuardarCgg_dhu_pregunta_respuesta,btnCancelarCgg_dhu_pregunta_respuesta,'->',btnCerrarCgg_dhu_pregunta_respuesta]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_dhu_pregunta_respuesta.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_dhu_pregunta_respuestaCtrls(inEstado){
        estado=!inEstado;
        
        numCdprs_valoracion.setDisabled(estado);
		cbxCdcat_codigo.setDisabled(!estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_dhu_pregunta_respuesta.
     */
    function cargarCgg_dhu_pregunta_respuestaCtrls(){
        if(inRecordCgg_dhu_pregunta_respuesta){
            
            cbxCdcat_codigo.setValue(inRecordCgg_dhu_pregunta_respuesta.get('CDCAT_NOMBRE'));
            tmpCdcat_codigo= inRecordCgg_dhu_pregunta_respuesta.get('CDCAT_CODIGO');
            /*gsCgg_dhu_pregunta_preguntarespuesta.reload({
                params:{
                    inCdcat_codigo:tmpCdcat_codigo,
                    format:TypeFormat.JSON
                }});*/
			gsCgg_dhu_pregunta1.reload({
				params:{
					inCdcat_codigo:tmpCdcat_codigo,
					format:TypeFormat.JSON
				}
			});
			gsCgg_dhu_respuesta.reload({
				params:{
					inCdcat_codigo:tmpCdcat_codigo,
					format:TypeFormat.JSON
				}
			});
            isEdit = true;
            habilitarCgg_dhu_pregunta_respuestaCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_dhu_pregunta_respuesta.
     * @returns ventana winFrmCgg_dhu_pregunta_respuesta.
     * @base FrmCgg_dhu_pregunta_respuesta.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_dhu_pregunta_respuesta;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_dhu_pregunta_respuesta.
     * @base FrmCgg_dhu_pregunta_respuesta.prototype.loadData
     */
    this.loadData = function(){
       // cmCgg_dhu_pregunta1.config.splice(0,1);
        grdCgg_dhu_pregunta.getSelectionModel().singleSelect = true;
        cargarCgg_dhu_pregunta_respuestaCtrls();

    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_dhu_pregunta_respuesta desde una instancia.
 */
FrmCgg_dhu_pregunta_respuesta.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_dhu_pregunta_respuesta desde una instancia.
 */
FrmCgg_dhu_pregunta_respuesta.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_dhu_pregunta_respuesta,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_dhu_pregunta_respuesta.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_dhu_pregunta_respuesta desde una instancia.
 */
FrmCgg_dhu_pregunta_respuesta.prototype.loadData = function(){

    this.loadData();
}
