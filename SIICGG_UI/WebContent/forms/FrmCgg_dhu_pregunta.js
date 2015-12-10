/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_dhu_pregunta.
 * @param {String} INSENTENCIA_CGG_DHU_PREGUNTA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_DHU_PREGUNTA Registro de datos de la tabla Cgg_dhu_pregunta.
 * @constructor
 * @base FrmListadoCgg_dhu_pregunta
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_dhu_pregunta(INSENTENCIA_CGG_DHU_PREGUNTA,INRECORD_CGG_DHU_PREGUNTA){
    var inSentenciaCgg_dhu_pregunta = INSENTENCIA_CGG_DHU_PREGUNTA;
    var inRecordCgg_dhu_pregunta=INRECORD_CGG_DHU_PREGUNTA;
    var urlCgg_dhu_pregunta=URL_WS+"Cgg_dhu_pregunta";
    var tituloCgg_dhu_pregunta='Pregunta';
    var descCgg_dhu_pregunta='El formulario permite administrar informaci\u00f3n de la Pregunta';
    var isEdit = false;
    var tmpCdcat_codigo;
    var tmpCdres_respuesta;
    var valorRespuesta = null;
    var eliCdprg_preguntas;
	var tipoPregunta;

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE LA PREGUNTA
     */
    var txtCdprg_codigo = new Ext.form.TextField({
        id:'txtCdprg_codigo',
        name:'txtCdprg_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_aerolinea por un campo especifico.
     */
    var gsCdcat_codigo = new Ext.data.Store({
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
        fieldLabel :'Categor\u00eda',
        displayField:'CDCAT_NOMBRE',
        store:gsCdcat_codigo,
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione una categor\u00eda',
        selectOnFocus:true,
        valueField:'CDCAT_CODIGO',
        allowBlank :false,
        anchor:'98%',
        listeners:
        {
            select:function(combo,record)
            {
                tmpCdcat_codigo = record.get('CDCAT_CODIGO');
				gsCgg_dhu_pregunta.reload({
					params:{
						inCdcat_codigo:tmpCdcat_codigo,
						format:TypeFormat.JSON
					}

				});
				
            }
        }
    });
    gsCdcat_codigo.load();
    /**
     * Ext.form.TextField DESCRIPCION DE LA PREGUNTA
     */
    var txtCdprg_descripcion = new Ext.form.TextField({
        id:'txtCdprg_descripcion',
        name:'txtCdprg_descripcion',
        fieldLabel :'Descripci\u00f3n',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Ext.form.Checkbox ESTADO QUE DETERMINA SI LA PREGUNTA SE PUEDE CUANTIFICAR
     */
    var chkCdprg_cuantificable = new Ext.form.Checkbox({
        id:'chkCdprg_cuantificable',
        name:'chkCdprg_cuantificable',
        fieldLabel :'Cuantificable',
        allowBlank :false,
        checked:false
    });
    /**
     * Ext.form.Checkbox ESTADO QUE DETERMINA SI LA PREGUNTA SE PUEDE CUANTIFICAR
     */
    var chkCdprg_multiple = new Ext.form.Checkbox({
        id:'chkCdprg_multiple',
        name:'chkCdprg_multiple',
        fieldLabel :'Selecci\u00f3n M\u00faltiple',
        allowBlank :false,
        checked:false
    });

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Ext.ColumnModel Agrupacion de registros de la tabla Cgg_dhu_pregunta
     *  por un campo especifico.
     */
   /* var chkCdprg_cuantificable1 = new Ext.grid.CheckColumn(
    {dataIndex:'CDPRG_CUANTIFICABLE',header:'Cuantificable',width:150,sortable:true,editor: chkCdprg_cuantificable});
    var chkCdprg_multiple1 = new Ext.grid.CheckColumn(
    {dataIndex:'CDPRG_MULTIPLE',header:'Seleccion Multiple',width:150,sortable:true, editor: chkCdprg_multiple});*/
    var cmCgg_dhu_pregunta = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
        {dataIndex:'CDPRG_CODIGO',header:'Codigo',width:150,sortable:true,editor:txtCdprg_codigo, hidden:true, hiddeable:false},
        {dataIndex:'CDCAT_CODIGO',header:'Codigo',width:150,sortable:true,hiddeable:false, hidden:true},
        {dataIndex:'CDPRG_DESCRIPCION',header:'Descripci\u00f3n',width:300,sortable:true, editor: txtCdprg_descripcion}/*,
        chkCdprg_cuantificable1,
        chkCdprg_multiple1*/
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_pregunta por un campo especifico.
     */
    var gsCgg_dhu_pregunta = new Ext.data.Store({
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
        }, [
            {name:'CDPRG_CODIGO'},
            {name:'CDCAT_CODIGO'},
            {name:'CDPRG_DESCRIPCION'},
            {name:'CDPRG_CUANTIFICABLE'},
            {name:'CDPRG_MULTIPLE'}
        ]),
        baseParams:{
            inCdcat_codigo:"",
            format:"JSON"
        },
        listeners:{
            load: function(inStore, inRecords, inObject){
                eliCdprg_preguntas = gsCgg_dhu_pregunta.getJsonData();
				//alert(gsCgg_dhu_pregunta.getAt(0).get('CDPRG_CUANTIFICABLE'));
				if (gsCgg_dhu_pregunta.getCount()>0){
					if(gsCgg_dhu_pregunta.getAt(0).get('CDPRG_CUANTIFICABLE') == true){
						if(gsCgg_dhu_pregunta.getAt(0).get('CDPRG_MULTIPLE') != true){
							gbTipo.setValue('cuatificables',true);
						}else{
							gbTipo.setValue('multiple',true);
						}
					}else{
						if(gsCgg_dhu_pregunta.getAt(0).get('CDPRG_MULTIPLE')==false){
							gbTipo.setValue('abierta',true);
						}else{
							gbTipo.setValue('cuatificables',true);
						}
					}
				}else{
					gbTipo.setValue('cuatificables',true);
				}
            }

        }
    });
    /*
     * Ext.ux.grid.RowEditor Edito de filas personalizado para utilizaci?n en el grid de contacto
     */
    var rePregunta = new Ext.ux.grid.RowEditor({
        saveText: 'Aceptar',
        cancelText:'Cancelar',
		errorSummary: false,
		listeners:{
		 	/*beforeedit:function(inSource, inRowIndex){
		 		var tmpRecord = gsCgg_dhu_pregunta.getAt(inRowIndex);
		 		if(tmpRecord && typeof(tmpRecord.data.CRPER_FECHA_NACIMIENTO) == 'string'){
		 			tmpRecord.data.CRPER_FECHA_NACIMIENTO = Date.parse(tmpRecord.data.CRPER_FECHA_NACIMIENTO.substr(0,tmpRecord.data.CRPER_FECHA_NACIMIENTO.lastIndexOf('.')));
		 		} 
		 	},*/
			canceledit:function(inSource, inIsCancel){
				var tmpRecord = grdCgg_res_pregunta.getSelectionModel().getSelected();
				if(tmpRecord){
					if(tmpRecord.data.CDPRG_CODIGO == 'KEYGEN' || tmpRecord.data.CDPRG_CODIGO.length == 0)
						gsCgg_dhu_pregunta.removeAt(0);
				}
			}
		 }
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_persona_contacto en un formato tabular de filas y columnas.
     */
    var grdCgg_res_pregunta = new Ext.grid.EditorGridPanel({
        cm:cmCgg_dhu_pregunta,
        store:gsCgg_dhu_pregunta,
        region:'south',
        anchor:'100% 110%',
        viewConfig:{forceFit:true},
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true,
            moveOnEnter:true
        }),
        loadMask:{
            msg:"Cargando..."
        },
        frame:true,
        tbar:['Pregunta',{
            iconCls:'iconNuevo',
            tooltip:'Agregar Pregunta',
            handler:function() {
				if(cbxCdcat_codigo.getValue()){
					var tmpRecordPersona = grdCgg_res_pregunta.getStore().recordType;
					rePregunta.stopEditing();
					grdCgg_res_pregunta.getStore().insert(0,
							new tmpRecordPersona({
								CDPRG_CODIGO:'KEYGEN',
								CDCAT_CODIGO:'',
								CDPRG_DESCRIPCION:'',
								CDPRG_CUANTIFICABLE:'',
								CDPRG_MULTIPLE:''

							})
							);
					grdCgg_res_pregunta.getView().refresh();
					grdCgg_res_pregunta.getSelectionModel().selectRow(0);
					rePregunta.startEditing(0);
				}else{
					Ext.Msg.show({
							title:'Aviso',
							msg: 'Selecione primero una categoria.',
							buttons: Ext.Msg.OK,
							icon: Ext.MessageBox.INFO
					});
				}
            }
        },{
            iconCls:'iconEliminar',
            tooltip:'Eliminar Pregunta',
            handler:function() {
				if (grdCgg_res_pregunta.getSelectionModel().getSelected()){
					Ext.Msg.show({
						title:'Aviso',
						msg:'Seguro de eliminar el registro seleccionado?',
						buttons: Ext.Msg.YESNO,
						fn: SWRCgg_res_pregunta,
						icon: Ext.MessageBox.QUESTION
					});
					function SWRCgg_res_pregunta(btn) {
						if (btn == 'yes'){
							if(!isEdit){
								var seleccionado = grdCgg_res_pregunta.getSelectionModel().getSelected();
								if (seleccionado != null) {
									grdCgg_res_pregunta.getStore().remove(seleccionado);
								} else if (grdCgg_res_pregunta.getStore().getCount() >= 1) {
									grdCgg_res_pregunta.getSelectionModel().selectLastRow();
									grdCgg_res_pregunta.getStore().remove(grdCgg_res_pregunta.getSelectionModel().getSelected());
								}
							}else{
								function CallBackCgg_dhu_delete(r){									
									if(r=='true'){
										Ext.Msg.show({
												title:'Aviso',
												msg: 'La informaci\u00f3n sobre la pregunta ha sido eliminada.',
												buttons: Ext.Msg.OK,
												icon: Ext.MessageBox.INFO
										});
										grdCgg_res_pregunta.getStore().remove(grdCgg_res_pregunta.getSelectionModel().getSelected());
										grdCgg_res_pregunta.getStore().reload();
									}else{
										Ext.Msg.show({
												title:'Aviso',
												msg: 'La informaci\u00f3n sobre la pregunta no ha podido ser eliminada.',
												buttons: Ext.Msg.OK,
												icon: Ext.MessageBox.ERROR
										});
								}}
								var param = new SOAPClientParameters();
								param.add('inCdprg_codigo',grdCgg_res_pregunta.getSelectionModel().getSelected().get('CDPRG_CODIGO'));
								SOAPClient.invoke(URL_WS+'Cgg_dhu_pregunta', 'delete', param, true, CallBackCgg_dhu_delete);
								
								
							}
						}
					}
				}else{
					Ext.Msg.show({
						title:'Aviso',
						msg:'Seleccione una pregunta',
						buttons: Ext.Msg.OK,
						//fn: SWRCgg_res_pregunta,
						icon: Ext.MessageBox.ERROR
					});
				}
            }
        }
        ],
        plugins:[rePregunta]
    });
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_dhu_pregunta
     */
    var btnGuardarCgg_dhu_pregunta = new Ext.Button({
        id:'btnGuardarCgg_dhu_pregunta',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_dhu_pregunta.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_dhu_pregunta(r){
                        winFrmCgg_dhu_pregunta.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_dhu_pregunta,
                                msg: 'La informaci\u00f3n de Pregunta ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_dhu_pregunta.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_dhu_pregunta,
                                msg: 'La informaci\u00f3n de Pregunta no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_dhu_pregunta.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit){
                        param.add('inCdprg_codigo',txtCdprg_codigo.getValue());
                        param.add('inEliCdprg_preguntas',eliCdprg_preguntas);
					}
                    param.add('inCdcat_codigo',tmpCdcat_codigo);
                    param.add('inCdprg_preguntas', grdCgg_res_pregunta.getStore().getJsonData());
					param.add('inCdprg_tipo', tipoPregunta?tipoPregunta:0);
                    SOAPClient.invoke(urlCgg_dhu_pregunta,INSENTENCIA_CGG_DHU_PREGUNTA,param, true, CallBackCgg_dhu_pregunta);
                }catch(inErr){
                    winFrmCgg_dhu_pregunta.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_dhu_pregunta.
     */
    var btnCancelarCgg_dhu_pregunta = new Ext.Button({
        id:'btnCancelarCgg_dhu_pregunta',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
				//grdCgg_res_pregunta.getStore().remove(grdCgg_res_pregunta.getSelectionModel().getSelected());
				//gsCgg_res_persona.removeAt(grdCgg_res_pregunta.getSelectionModel().getSelected());
                pnlCgg_dhu_pregunta.getForm().reset();
				gsCgg_dhu_pregunta.reload({
					params:{
						inCdcat_codigo:tmpCdcat_codigo,
						format:TypeFormat.JSON
					}

				});
				
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_dhu_pregunta.
     */
    var btnCerrarCgg_dhu_pregunta = new Ext.Button({
        id:'btnCerrarCgg_dhu_pregunta',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_dhu_pregunta.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_dhu_pregunta.
     */
	 var gbTipo = new Ext.form.RadioGroup({ 
			fieldLabel: 'Tipo de preguntas', 
			vertical: false, 
			id:"gbTipo", 
			items: [ 
				{boxLabel: 'Cuantificable', name: 'rgTipo', id:'cuatificables',inputValue: 0,checked:true},
				{boxLabel: 'Selecci\u00f3n m\u00faltiple', name: 'rgTipo',id:'multiple', inputValue: 1 },			
				{boxLabel: 'Pregunta abierta', name: 'rgTipo',id:'abierta', inputValue: 2 }
			],
			listeners:{
				change:function(group,radio){
					//alert(radio.getRawValue());
					if(radio.getRawValue() == 0)
					{						
						tipoPregunta = 0;
					}
					else
					{
						if(radio.getRawValue()== 1){
							tipoPregunta = 1;
						}else{
							tipoPregunta = 2;
						}						
					}
				}
			}
	});
    var pnlCgg_dhu_pregunta = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[
			txtCdprg_codigo,
			cbxCdcat_codigo,
			gbTipo,
			grdCgg_res_pregunta
		]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_dhu_pregunta.
     */
    var winFrmCgg_dhu_pregunta = new Ext.Window({
        id:'winFrmCgg_dhu_pregunta',
        title:tituloCgg_dhu_pregunta,
        tbar:getPanelTitulo(tituloCgg_dhu_pregunta,descCgg_dhu_pregunta),
        items:[pnlCgg_dhu_pregunta],
        width:600,
        minWidth:600,
        height:500,
        minheigth:500,
        maximizable:true,
        minimizable:false,
		modal : true,
        constrain:true,
        bbar:[btnGuardarCgg_dhu_pregunta,btnCancelarCgg_dhu_pregunta,'->',btnCerrarCgg_dhu_pregunta]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_dhu_pregunta.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_dhu_preguntaCtrls(inEstado){
        estado=!inEstado;
        txtCdprg_codigo.setDisabled(estado);
        txtCdprg_descripcion.setDisabled(estado);
        chkCdprg_cuantificable.setDisabled(estado);
		cbxCdcat_codigo.setDisabled(!estado);
		//gbTipo.setDisabled(!estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_dhu_pregunta.
     */
    function cargarCgg_dhu_preguntaCtrls(){
        if(inRecordCgg_dhu_pregunta){
            tmpCdcat_codigo =inRecordCgg_dhu_pregunta.get('CDCAT_CODIGO');
            cbxCdcat_codigo.setValue(inRecordCgg_dhu_pregunta.get('CDCAT_NOMBRE'));
            gsCgg_dhu_pregunta.reload({
                params:{
                    inCdcat_codigo:tmpCdcat_codigo,
                    format:TypeFormat.JSON
                }

            });
            isEdit = true;
            habilitarCgg_dhu_preguntaCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_dhu_pregunta.
     * @returns ventana winFrmCgg_dhu_pregunta.
     * @base FrmCgg_dhu_pregunta.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_dhu_pregunta;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_dhu_pregunta.
     * @base FrmCgg_dhu_pregunta.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_dhu_preguntaCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_dhu_pregunta desde una instancia.
 */
FrmCgg_dhu_pregunta.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_dhu_pregunta desde una instancia.
 */
FrmCgg_dhu_pregunta.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_dhu_pregunta,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_dhu_pregunta.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_dhu_pregunta desde una instancia.
 */
FrmCgg_dhu_pregunta.prototype.loadData = function(){
    this.loadData();
}
