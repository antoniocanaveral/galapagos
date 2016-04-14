/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_dhu_cuestionario.
 * @param {String} IN_SENTENCIA_CGG_DHU_CUESTIONARIO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_DHU_CUESTIONARIO Registro de datos de la tabla Cgg_dhu_cuestionario.
 * @constructor
 * @base FrmListadoCgg_dhu_cuestionario
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_dhu_cuestionario(IN_SENTENCIA_CGG_DHU_CUESTIONARIO,IN_RECORD_CGG_DHU_CUESTIONARIO){
    var inSentenciaCgg_dhu_cuestionario = IN_SENTENCIA_CGG_DHU_CUESTIONARIO;
    var inRecordCgg_dhu_cuestionario=IN_RECORD_CGG_DHU_CUESTIONARIO;
    var urlCgg_dhu_cuestionario=URL_WS+"Cgg_dhu_cuestionario";
    var tituloCgg_dhu_cuestionario='Cuestionario';
    var descCgg_dhu_cuestionario='El formulario permite administrar la informaci\u00f3n de Cuestionario';
    var isEdit = false;
    var tmpCdenc_codigo;
    var tmpgrd_preguntas_respuestas;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO CUESTIONARIO
     */
    var txtCdcst_codigo = new Ext.form.TextField({
        id:'txtCdcst_codigo',
        name:'txtCdcst_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Ext.ColumnModel Agrupacion de registros de la tabla Cgg_dhu_preguntas
     *  por un campo especifico.
     */
    function SeleccionarPreguntaRepuesta(){
        var cmCgg_dhu_preguntas = new Ext.grid.ColumnModel([
            {dataIndex:'CDPRG_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true, hiddeable:false},
            {dataIndex:'CDCAT_CODIGO',header:'Codigo',width:150,sortable:true,hiddeable:false, hidden:true},
            {dataIndex:'CDCAT_NOMBRE',header:'Codigo',width:150,sortable:true,hiddeable:false, hidden:true},
            {dataIndex:'CDPRG_DESCRIPCION',header:'Pregunta',width:300,sortable:true},
            {dataIndex:'CDPRG_CUANTIFICABLE',header:'Cuantificable',width:100,sortable:true,renderer:function(v){
				if(v==true){
					return 'Si';
				}else{
					return 'No';
				}
			}}
            /*{dataIndex:'CDRES_DESCRIPCION',header:'Respuesta',width:100,sortable:true},
            {dataIndex:'CDPRS_VALORACION',header:'Valoracion',width:100,sortable:true},*/
			//{dataIndex:'JSON_INFO',header:'JSON',width:100,sortable:true}
        ]);
        /**
         * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_pregunta por un campo especifico.
         */
        var gsCgg_dhu_preguntas = new Ext.data.Store({
            proxy:new Ext.ux.bsx.SoapProxy({
                url:URL_WS + "Cgg_dhu_cuestionario",
                method:"selectPagePreguntasRespuestas",
                pagin:true
            }),
            remoteSort:true,
            reader:new Ext.data.JsonReader({
                root:'dataSet',
                totalProperty: 'totalCount'
            }, [
                {name:'CDPRG_CODIGO'},
                {name:'CDCAT_CODIGO'},
                {name:'CDCAT_NOMBRE'},
                {name:'CDPRG_DESCRIPCION'},
                {name:'CDPRG_CUANTIFICABLE'},
                /*{name:'CDRES_DESCRIPCION'},
                {name:'CDPRS_VALORACION'},*/
				{name:'JSON_INFO'}
            ]),
            sortInfo:{field: 'CDPRG_DESCRIPCION', direction: 'ASC'},
            baseParams:{keyword:"",format:"JSON"}
        });
        this.getCm = function() {
            return cmCgg_dhu_preguntas;
        };

        this.getStore = function() {
            return gsCgg_dhu_preguntas;
        }
    }
    SeleccionarPreguntaRepuesta.prototype.getColumnModel = function() {
        return this.getCm();
    };

    SeleccionarPreguntaRepuesta.prototype.getStore = function() {
        return this.getStore();
    };

    /**
     * Ext.ColumnModel Agrupacion de registros de la tabla Cgg_dhu_preguntas_respuestas
     *  por un campo especifico.
     */
	 var rowExpander = new Ext.ux.grid.RowExpander({
        tpl : new Ext.XTemplate(
               '<SPAN style="color:blue"><b>Opciones de Respuestas:</b><br></SPAN>'+
                    '<table id="box-table-a" cborder="0" align="left">' +
                        '<tbody>' +
                        '<tr>' +
                        '<th style="width: 2%;">Opcion</th>' +
                        '<th style="width: 10%;">Valoracion</th>' +                        
                        '</tr>'+
						'{JSON_INFO}'+                        
                        '</tbody>' +
                    '</table>'
                 )
    });
	
    var cmCgg_dhu_preguntas_respuestas = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
		rowExpander,
        {dataIndex:'CDENC_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true, hiddeable:false},
        {dataIndex:'CDENC_NOMBRE',header:'Codigo',width:150,sortable:true,hidden:true, hiddeable:false},
        {dataIndex:'CDPRG_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true, hiddeable:false},
        {dataIndex:'CDPRG_DESCRIPCION',header:'Pregunta',width:300,sortable:true},        
        //{dataIndex:'CDRES_DESCRIPCION',header:'Opciones de Respuesta',width:100,sortable:true},
		{dataIndex:'CDPRG_CUANTIFICABLE',header:'Cuantificable',width:100,sortable:true,renderer:function(v){
				if(v==true){
					return 'Si';
				}else{
					return 'No';
				}
			}}/*,
        {dataIndex:'CDPRS_VALORACION',header:'Valoracion',width:100,sortable:true}*/
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_pregunta por un campo especifico.
     */
	 
    var gsCgg_dhu_preguntas_respuestas = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS + "Cgg_dhu_cuestionario",
            method:"selectPagePreguntasRespuestasEncuesta",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({

            root:'dataSet',
            totalProperty: 'totalCount'
        }, [
            {name:'CDENC_CODIGO'},
            {name:'CDENC_NOMBRE'},
            {name:'CDPRG_CODIGO'},
            {name:'CDPRG_DESCRIPCION'},
            {name:'CDPRG_CUANTIFICABLE'},
            //{name:'CDRES_DESCRIPCION'},
            //{name:'CDPRS_VALORACION'}
			{name:'JSON_INFO'}
						
			
        ]),
        //sortInfo:{field: 'CDCAT_NOMBRE', direction: 'ASC'},
        baseParams:{inCdenc_codigo:'',format:"JSON"},
        //groupField:'CDPRG_DESCRIPCION',
        listeners:{
            load: function(inStore, inRecords, inObject){

                tmpgrd_preguntas_respuestas = gsCgg_dhu_preguntas_respuestas.getJsonData();
                if (tmpgrd_preguntas_respuestas.length!=2){
                    isEdit = true;
                    IN_SENTENCIA_CGG_DHU_CUESTIONARIO = 'update';
                }
            }

        }
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE EVALUACION
     */
    var btnSeleccionarPreguntas = new Ext.Button({
        id:'btnSeleccionarPreguntas',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
				if(txtCdenc_codigo.getValue()){
					var tmpFLCgg_seleccionar = new SeleccionarPreguntaRepuesta();
					var objCgg_res_seleccionPregunta = new DlgBusqueda(tmpFLCgg_seleccionar.getStore(), tmpFLCgg_seleccionar.getColumnModel(), true);
					objCgg_res_seleccionPregunta.closeHandler(function(){
						var tmpRows = objCgg_res_seleccionPregunta.getSelectedRows();
						if(tmpRows){                        
							/*for(i = 0 ;i<tmpRows.length;i++){								
								tmpDatos  = eval('['+tmpRows[i].data.JSON_INFO+']');
								var sw = true;
								for(l=0;l<tmpDatos.length;l++){
									for(k=0;k<gsCgg_dhu_preguntas_respuestas.data.length;k++){
										if (tmpDatos[l].CDPRG_CODIGO == gsCgg_dhu_preguntas_respuestas.getAt(k).get('CDPRG_CODIGO')){
											sw = false;
											break;
										}
										if(sw==false){
											break;
										}
									}
								}
							
								for(j=0;j<tmpDatos.length;j++){
									
									if (sw == true){
										var tmpRecordFaseUsuario = gsCgg_dhu_preguntas_respuestas.recordType;
										gsCgg_dhu_preguntas_respuestas.insert(0,
											new tmpRecordFaseUsuario(tmpDatos[j])
										);	
									}
								}
							}	*/	
							
							for(j=0;j<tmpRows.length;j++){
									var sw = true;									
									for(k=0;k<gsCgg_dhu_preguntas_respuestas.data.length;k++){
										if (tmpRows[j].data.CDPRG_CODIGO == gsCgg_dhu_preguntas_respuestas.getAt(k).get('CDPRG_CODIGO')){
											sw = false;
											break;
										}
										if(sw==false){
											break;
										}
									}									
									if(sw == true){
										var tmpRecordFaseUsuario = gsCgg_dhu_preguntas_respuestas.recordType;
										gsCgg_dhu_preguntas_respuestas.insert(gsCgg_dhu_preguntas_respuestas.data.length,											
											new tmpRecordFaseUsuario({
												CDENC_CODIGO:null,
												CDENC_NOMBRE:null,
												CDPRG_CODIGO:tmpRows[j].data.CDPRG_CODIGO,
												CDPRG_DESCRIPCION:tmpRows[j].data.CDPRG_DESCRIPCION,
												CDPRG_CUANTIFICABLE: tmpRows[j].data.CDPRG_CUANTIFICABLE,
												JSON_INFO:tmpRows[j].data.JSON_INFO
											})
										);	
									}
							}	
							
							//gsCgg_dhu_preguntas_respuestas.add(tmpRows);
						}
					});
					objCgg_res_seleccionPregunta.show();
				}else{
					Ext.Msg.show({
						title:'Alerta',
						msg: 'Seleccione primero una encuesta',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.INFO,
						fn: fnOk
					});
						

					function fnOk(btn){
						if(btn =='ok')
							txtCdenc_codigo.focus = true;
					}
				}
			}
		}

    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE EVALUACION
     */
    var btnEliminarPreguntas = new Ext.Button({
        id:'btnEliminarPreguntas',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                var seleccionado = grdCgg_res_preguntas.getSelectionModel().getSelected();
                if (seleccionado != null) {
                    grdCgg_res_preguntas.getStore().remove(seleccionado);
                } else if (grdCgg_res_preguntas.getStore().getCount() >= 1) {
                    grdCgg_res_preguntas.getSelectionModel().selectLastRow();
                    grdCgg_res_preguntas.getStore().remove(grdCgg_res_preguntas.getSelectionModel().getSelected());
                }
            }}

    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_persona_contacto en un formato tabular de filas y columnas.
     */
    var grdCgg_res_preguntas = new Ext.grid.GridPanel({		
        cm:cmCgg_dhu_preguntas_respuestas,
        store:gsCgg_dhu_preguntas_respuestas,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
		plugins: rowExpander, 
        /*view: new Ext.grid.GroupingView({
            forceFit:true,
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
        }),
*/
        loadMask:{
            msg:"Cargando..."
        },
        tbar:['Preguntas',btnSeleccionarPreguntas, btnEliminarPreguntas
        ]
    });
	/*grdCgg_res_preguntas.getSelectionModel().on("selectionchange",function(sm){		
		grdCgg_res_preguntas.selModel.selectRow(1,true);  		
	});*/
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE EVALUACION
     */
    var txtCdenc_codigo = new Ext.form.TextField({
        id:'txtCdenc_codigo',
        name:'txtCdenc_codigo',
        fieldLabel :'Encuesta',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE EVALUACION
     */
    var btnCdenc_codigoCgg_dhu_cuestionario = new Ext.Button({
        id:'btnCdenc_codigoCgg_dhu_cuestionario',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_dhu_encuesta = new FrmListadoCgg_dhu_encuesta();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_dhu_encuesta.getStore(),tmpFLCgg_dhu_encuesta.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpCdenc_codigo=tmpRecord.get('CDENC_CODIGO');
                        txtCdenc_codigo.setValue(tmpRecord.get('CDENC_NOMBRE'));
                        gsCgg_dhu_preguntas_respuestas.reload({
                            params:{
                                inCdenc_codigo:tmpCdenc_codigo,
                                format:TypeFormat.JSON
                            }


                        });
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_dhu_cuestionario
     */
    var btnGuardarCgg_dhu_cuestionario = new Ext.Button({
        id:'btnGuardarCgg_dhu_cuestionario',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){				
                  if (!pnlCgg_dhu_cuestionario.getForm().isValid()){
                 return;
                 }
				 if (gsCgg_dhu_preguntas_respuestas.getCount()==0){
					Ext.Msg.show({
						title:tituloCgg_dhu_cuestionario,
						msg: 'Debe ingresar por lo menos una pregunta para el cuestionario',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.ERROR
					});
					return;
				 }
                try{
                    function CallBackCgg_dhu_cuestionario(r){
                        winFrmCgg_dhu_cuestionario.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_dhu_cuestionario,
                                msg: 'La informaci\u00f3n de Cuestionario ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_dhu_cuestionario.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_dhu_cuestionario,
                                msg: 'La informaci\u00f3n de Cuestionario no ha podido ser almacenada. '+(r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_dhu_cuestionario.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inEliCdprg_codigo',tmpgrd_preguntas_respuestas);
                    param.add('inCdprg_codigo',grdCgg_res_preguntas.getStore().getJsonData());
                    param.add('inCdenc_codigo',tmpCdenc_codigo);
                    SOAPClient.invoke(urlCgg_dhu_cuestionario,IN_SENTENCIA_CGG_DHU_CUESTIONARIO,param, true, CallBackCgg_dhu_cuestionario);
                }catch(inErr){
                    winFrmCgg_dhu_cuestionario.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_dhu_cuestionario.
     */
    var btnCancelarCgg_dhu_cuestionario = new Ext.Button({
        id:'btnCancelarCgg_dhu_cuestionario',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_dhu_cuestionario.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_dhu_cuestionario.
     */
    var btnCerrarCgg_dhu_cuestionario = new Ext.Button({
        id:'btnCerrarCgg_dhu_cuestionario',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_dhu_cuestionario.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_dhu_cuestionario.
     */
    var pnlCgg_dhu_cuestionario = new Ext.form.FormPanel({

        region:'center',
        layout:'border',
        labelWidth :100,
        items:[
            {xtype:'panel',frame:true,layout:'column',region:'north',height:50,items:[
                {columnWidth:.92,layout:'form',items:[txtCdcst_codigo,txtCdenc_codigo]},
                {columnWidth:.08,layout:'form',items:[btnCdenc_codigoCgg_dhu_cuestionario]}]},
            grdCgg_res_preguntas]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_dhu_cuestionario.
     */
    var winFrmCgg_dhu_cuestionario = new Ext.Window({
        id:'winFrmCgg_dhu_cuestionario',
        title:tituloCgg_dhu_cuestionario,
        iconCls:'iconAplicacion',
        width:650,
        minWidth:650,
        height:500,
        minHeight:500,
        maximizable:false,
        minimizable:false,
		modal:true,
        layout:'border',
        constrain:true,
        tbar:getPanelTitulo(tituloCgg_dhu_cuestionario,descCgg_dhu_cuestionario),
        items:[pnlCgg_dhu_cuestionario],
        bbar:[btnGuardarCgg_dhu_cuestionario,btnCancelarCgg_dhu_cuestionario,'->',btnCerrarCgg_dhu_cuestionario]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmCgg_dhu_cuestionario.getBottomToolbar());
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_dhu_cuestionario.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_dhu_cuestionarioCtrls(inEstado){
        estado=!inEstado;
        txtCdcst_codigo.setDisabled(estado);
        txtCdenc_codigo.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_dhu_cuestionario.
     */
    function cargarCgg_dhu_cuestionarioCtrls(){
        if(inRecordCgg_dhu_cuestionario){
            txtCdcst_codigo.setValue(inRecordCgg_dhu_cuestionario.get('CDCST_CODIGO'));
            tmpCdenc_codigo=inRecordCgg_dhu_cuestionario.get('CDENC_CODIGO');
            txtCdenc_codigo.setValue(inRecordCgg_dhu_cuestionario.get('CDENC_NOMBRE'));
            gsCgg_dhu_preguntas_respuestas.reload({
                params:{
                    inCdenc_codigo:tmpCdenc_codigo,
                    format:TypeFormat.JSON
                }

            });


            isEdit = true;
            habilitarCgg_dhu_cuestionarioCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_dhu_cuestionario.
     * @returns ventana winFrmCgg_dhu_cuestionario.
     * @base FrmCgg_dhu_cuestionario.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_dhu_cuestionario;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_dhu_cuestionario.
     * @base FrmCgg_dhu_cuestionario.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_dhu_cuestionarioCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_dhu_cuestionario desde una instancia.
 */
FrmCgg_dhu_cuestionario.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_dhu_cuestionario desde una instancia.
 */
FrmCgg_dhu_cuestionario.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_dhu_cuestionario,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_dhu_cuestionario.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_dhu_cuestionario desde una instancia.
 */
FrmCgg_dhu_cuestionario.prototype.loadData = function(){
    this.loadData();
}
