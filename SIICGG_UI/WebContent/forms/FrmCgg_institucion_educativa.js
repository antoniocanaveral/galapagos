/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_institucion_educativa.
 * @param {String} INSENTENCIA_CGG_INSTITUCION_EDUCATIVA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_INSTITUCION_EDUCATIVA Registro de datos de la tabla Cgg_institucion_educativa.
 * @constructor
 * @base FrmListadoCgg_institucion_educativa
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_institucion_educativa(INSENTENCIA_CGG_INSTITUCION_EDUCATIVA,INRECORD_CGG_INSTITUCION_EDUCATIVA){
    var inSentenciaCgg_institucion_educativa = INSENTENCIA_CGG_INSTITUCION_EDUCATIVA;
    var inRecordCgg_institucion_educativa=INRECORD_CGG_INSTITUCION_EDUCATIVA;
    var urlCgg_institucion_educativa=URL_WS+"Cgg_institucion_educativa";
    var tituloCgg_institucion_educativa='Instituci\u00f3n educativa';
    var descCgg_institucion_educativa='El formulario permite administrar la informaci\u00f3n de Instituci\u00f3n educativa';
    var isEdit = false;
	var tmpUserSession = new UserSession();
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION EDUCATIVA
     */
    var txtCgied_codigo = new Ext.form.TextField({
        id:'txtCgied_codigo',
        name:'txtCgied_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PAIS
     */
    var txtCpais_codigo = new Ext.form.TextField({
        id:'txtCpais_codigo',
        name:'txtCpais_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CANTON DE NACIMIENTO
     */
    var cbxCpais_nombre = new Ext.form.ComboBox({
        id:'cbxCpais_nombre',
        name:'cbxCpais_nombre',
        fieldLabel :'Pais',
        anchor:'98%',
        store: SCGG_PAIS,
        displayField:'CPAIS_NOMBRE',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione un Pa\u00eds',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CPAIS_NOMBRE}. {CPAIS_NOMBRE}" class="x-combo-list-item">{CPAIS_NOMBRE}</div></tpl>',
        valueField:'CPAIS_CODIGO'
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE PAIS
     */
    var btnCpais_codigoCgg_institucion_educativa = new Ext.Button({
        id:'btnCpais_codigoCgg_institucion_educativa',
        text:'Cpais_codigo',
        iconCls:'iconCpais_codigo',
        listeners:{
            click:function(){
                var tmpFLCgg_pais = new FrmListadoCgg_pais();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_pais.getStore(),tmpFLCgg_pais.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                        txtCpais_codigo.setValue(tmpRecord.get('CPAIS_CODIGO'));
                });
                objBusqueda.show();
            }}
    });    
	/**
	* Ext.form.TextField NO ESPECIFICADO
	*/
	var txtCgied_nombre = new Ext.form.TextField({
		id:'txtCgied_nombre',
		name:'txtCgied_nombre',
		fieldLabel :'Nombre',
		anchor:'98%',
		allowBlank :false
	});
	/**
	* Ext.form.TextArea DESCRIPCION DE LA INSTITUCION EDUCATIVA
	*/
	var txtCgied_descripcion = new Ext.form.TextArea({
		id:'txtCgied_descripcion',
		name:'txtCgied_descripcion',
		fieldLabel :'Descripcion',
		width:'90%',
		allowBlank :false
	});
    /**
     * Ext.form.TextField DIRECCION DE UBICACION DE LA INSTITUCION EDUCATIVA
     */
    var txtCgied_direccion = new Ext.form.TextField({
        id:'txtCgied_direccion',
        name:'txtCgied_direccion',
        fieldLabel :'Direcci\u00f3n principal',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_institucion_educativa
     */
    var btnGuardarCgg_institucion_educativa = new Ext.Button({
        id:'btnGuardarCgg_institucion_educativa',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:TypeTooltip.GUARDAR,
        listeners:{
            click:function(){
                if (pnlCgg_institucion_educativa.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_institucion_educativa(r){
                        winFrmCgg_institucion_educativa.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_institucion_educativa,
                                msg: 'La informaci\u00f3n de Institucion educativa ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_institucion_educativa.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_institucion_educativa,
                                msg: 'La informaci\u00f3n de Institucion educativa no ha podido ser almacenada. '+r,
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_institucion_educativa.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCgied_codigo',txtCgied_codigo.getValue());
                    param.add('inCpais_codigo',cbxCpais_nombre.getValue());					
                    param.add('inCgied_descripcion',txtCgied_descripcion.getValue());
                    param.add('inCgied_direccion',txtCgied_direccion.getValue());
                    param.add('inInstitucionContacto_JSON',grdCgg_res_institucion_contacto.getStore().getJsonData());
					param.add('inCgied_nombre',txtCgied_nombre.getValue());
					param.add('inInstitucionNivelEstudio_JSON',grdCgg_res_institucion_nivelEstudio.getStore().getJsonData());
                    SOAPClient.invoke(urlCgg_institucion_educativa,INSENTENCIA_CGG_INSTITUCION_EDUCATIVA,param, true, CallBackCgg_institucion_educativa);
                }catch(inErr){
                    winFrmCgg_institucion_educativa.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_institucion_educativa.
     */
    var btnCancelarCgg_institucion_educativa = new Ext.Button({
        id:'btnCancelarCgg_institucion_educativa',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:TypeTooltip.CANCELAR,
        listeners:{
            click:function(){
                pnlCgg_institucion_educativa.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_institucion_educativa.
     */
    var btnCerrarCgg_institucion_educativa = new Ext.Button({
        id:'btnCerrarCgg_institucion_educativa',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:TypeTooltip.CERRAR,
        listeners:{
            click:function(){
                winFrmCgg_institucion_educativa.close();
            }}
    });


    /**
     *Ext.form.ComboBox Combo para edicion de tipo de contacto.
     */
    var cbxCRTCO_CODIGOEditor = new Ext.form.ComboBox({
        id:'cbxCRTCO_CODIGOEditor',
        store: SCGG_RES_TIPO_CONTACTO,
        displayField:'CRTCO_NOMBRE',
        typeAhead: true,
        mode:'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione un tipo',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CRTCO_NOMBRE}" class="x-combo-list-item">{CRTCO_NOMBRE}</div></tpl>',
        valueField:'CRTCO_CODIGO'
    });

    var txtCINTC_CONTACTOEditor = new Ext.form.TextField({
        id:'txtCINTC_CONTACTOEditor',
        emptyText:'Establezca una descripci\u00F3n',
        allowBlank:false
    });
    /*
     * Ext.ux.grid.RowEditor Edito de filas personalizado para utilización en el grid de contacto
     */
    var reContacto= new Ext.ux.grid.RowEditor({
        saveText: 'Aceptar',
        cancelText:'Cancelar',
        listeners:{
            validateedit:function(inRowEditor,inObject,inRecord,inRowIndex){
                /*for(var i =0;i<grdCgg_res_garantia_solicitud.getStore().getCount();i++){
                 if(inObject.CRGRT_CODIGO==grdCgg_res_garantia_solicitud.getStore().getAt(i).get('CRGRT_CODIGO')){
                 Ext.Msg.show({
                 title:tituloCgg_res_tipo_solicitud_tramite,
                 msg: 'La garant\u00EDa seleccionada ya esta establecida.',
                 buttons: Ext.Msg.OK,
                 icon: Ext.MessageBox.WARNING
                 });
                 grdCgg_res_garantia_solicitud.getStore().remove(inRecord);
                 }
                 }*/
            },
            canceledit:function(inRowEditor,inFlag){
                var inRecord=grdCgg_res_institucion_contacto.getStore().getAt(0);
                if(inRecord.get('CINTC_CODIGO') == 'KEYGEN')
                {
                    grdCgg_res_institucion_contacto.getStore().remove(inRecord);
                }
            }
        }
    });


    /**
     * Ext.ColumnModel Agrupacion de registros de la tabla Cgg_res_persona_contacto por un campo especifico.
     */
    var cmCgg_res_institucion_contacto = new Ext.grid.ColumnModel([
        //new Ext.grid.RowNumberer(),
        {dataIndex:'CINTC_CODIGO',hidden:true,header:'Codigo',width:150,sortable:true},
        {dataIndex:'CGIED_CODIGO',hidden:true,header:'Codigo',width:150,sortable:true},
        {dataIndex:'CRTCO_CODIGO',header:'Contacto',width:40,sortable:true,
            editor:cbxCRTCO_CODIGOEditor,renderer:
                function(value, metaData, record){
                    var tmpHtml = null;
                    var tmpNombreImagen = null;
                    var rTipoContaco= record;
                    try{
                        rTipoContaco=SCGG_RES_TIPO_CONTACTO.getAt(SCGG_RES_TIPO_CONTACTO.findExact('CRTCO_CODIGO',value));
                        tmpNombreImagen = rTipoContaco.get('CRTCO_NOMBRE_IMAGEN');
                        new Ajax.Request(URL_DOC_VIEWER, {
                            onSuccess: function(response) {
                                tmpHtml = '<div><img src="/siiws/tmp/'+tmpUserSession.getUserName().trim()+'/'+ tmpNombreImagen +'" alt= "'+ rTipoContaco.get('CRTCO_NOMBRE')+'"/></div>';
                            },
                            onFailure:function(response){
                                //alert('Problemas aqui');
                            },
                            asynchronous:false,
                            parameters:{
                                table:'cgg_res_tipo_contacto',
                                keyc:'crtco_codigo',
                                keyv:rTipoContaco.get('CRTCO_CODIGO'),
                                column:'crtco_imagen',
                                fn:tmpNombreImagen,
                                request:'view'
                            }
                        });
                        return tmpHtml;
                    }
                    catch(inError)
                    {
                        return 'codigo';
                    }
                }},
        {dataIndex:'CINTC_DESCRIPCION',header:'Descripcion',width:50,sortable:true,hidden:true},
        {dataIndex:'CINTC_CONTACTO',header:'Descripci\u00f3n',width:150,sortable:true,editor:txtCINTC_CONTACTOEditor},
        {dataIndex:'CRTCO_NOMBRE',header:'Nombre',width:50,sortable:true,hidden:true},
        {dataIndex:'CRTCO_NOMBRE_IMAGEN',header:'Nombre',width:50,sortable:true,hidden:true}

    ]);

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_persona_contacto por un campo especifico.
     */
    var gsCgg_res_institucion_contacto = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_institucion_contacto",
            method:"selectInstitucionContacto",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
        },[
            {name:'CINTC_CODIGO'},
            {name:'CGIED_CODIGO'},
            {name:'CRTCO_CODIGO'},
            {name:'CINTC_DESCRIPCION'},
            {name:'CINTC_CONTACTO'},
            {name:'CRTCO_NOMBRE'},
            {name:'CRTCO_NOMBRE_IMAGEN'},


        ]),
        baseParams:{inCgied_codigo:'',format:TypeFormat.JSON}
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_persona_contacto en un formato tabular de filas y columnas.
     */
    var grdCgg_res_institucion_contacto = new Ext.grid.EditorGridPanel({
        cm:cmCgg_res_institucion_contacto,
        store:gsCgg_res_institucion_contacto,
        anchor:'100% 100%',
        viewConfig:{forceFit:true},
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        plugins:[reContacto]

    });
    var pnlCgg_institucion_contacto = new Ext.Panel({
        labelWidth:100,
        title:'Contactos',
        layout:'form',
        frame:false,
        height:200,
        tbar:[{
            iconCls:'iconNuevo',
            tooltip:'Agregar contacto',
            handler:function(){

                var tmpRecordCriterio = grdCgg_res_institucion_contacto.getStore().recordType;
                reContacto.stopEditing();
                grdCgg_res_institucion_contacto.getStore().insert(0,
                        new tmpRecordCriterio({
                            CINTC_CODIGO: 'KEYGEN',
                            CGIED_CODIGO: 'KEYGEN',
                            CRTCO_CODIGO: '',
                            CINTC_DESCRIPCION: '',
                            CINTC_CONTACTO: '',
                            CRTCO_NOMBRE: '',
                            CRTCO_NOMBRE_IMAGEN: ''
                        })
                        );
                grdCgg_res_institucion_contacto.getView().refresh();
                grdCgg_res_institucion_contacto.getSelectionModel().selectRow(0);
                reContacto.startEditing(0);
            }
        },{
            iconCls:'iconEliminar',
            tooltip:'Eliminar contacto',
            handler:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_institucion_contacto,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_institucion_contacto(btn){
                    if (btn=='yes')
                    {
                        try{
                            function CallBackCgg_institucion_contacto(r){
                                winFrmCgg_institucion_educativa.getEl().unmask();
                                if(r=='true'){
                                    Ext.Msg.show({
                                        title:tituloCgg_institucion_educativa,
                                        msg: 'La informaci\u00f3n de contacto ha sido eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    var seleccionado = grdCgg_res_institucion_contacto.getSelectionModel().getSelected();
                                    if(seleccionado != null ){
                                        grdCgg_res_institucion_contacto.getStore().remove(seleccionado);
                                    }
                                    //gsCgg_res_institucion_contacto.reload();
                                }else{
                                    Ext.Msg.show({
                                        title:tituloCgg_institucion_educativa,
                                        msg: 'La informaci\u00f3n de contacto no ha podido ser eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }}
                            winFrmCgg_institucion_educativa.getEl().mask('Eliminando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCintc_codigo',grdCgg_res_institucion_contacto.getSelectionModel().getSelected().get('CINTC_CODIGO'));
                            SOAPClient.invoke(URL_WS+"Cgg_institucion_contacto","delete",param, true, CallBackCgg_institucion_contacto);
                        }catch(inErr){
                            winFrmCgg_institucion_educativa.getEl().unmask();
                        }
                    }
                }
            }

        }],
        items:[grdCgg_res_institucion_contacto]
    });
	//////////////////////////////////////////////////////////////////////
	
    /**
     * Ext.ColumnModel Agrupacion de registros de la tabla Cgg_res_persona_contacto por un campo especifico.
     */
    var cmCgg_res_institucion_nivelEstudio = new Ext.grid.ColumnModel([
        //new Ext.grid.RowNumberer(),
        {dataIndex:'CGIEN_CODIGO',header:'Codigo IEN',width:70,sortable:true,hidden:true},
        {dataIndex:'CGNES_CODIGO',header:'Codigo NES',width:70,sortable:true,hidden:true},        
		{dataIndex:'CGIED_CODIGO',header:'Codigo Ins. Educativa',width:150,sortable:true,hidden:true},
        {dataIndex:'CGNES_DESCRIPCION',header:'Descripcion Nivel Estudio',width:150,sortable:true}        
    ]);

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_persona_contacto por un campo especifico.
     */
    var gsCgg_res_institucion_nivelEstudio = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_institucion_nivel",
            method:"selectInstitucionNivele",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
        },[
            {name:'CGIEN_CODIGO'},
            {name:'CGNES_CODIGO'},
            {name:'CGNES_DESCRIPCION'},
            {name:'CGIED_CODIGO'},
        ]),
        baseParams:{inCgied_codigo:'',format:TypeFormat.JSON}
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_persona_contacto en un formato tabular de filas y columnas.
     */
    var grdCgg_res_institucion_nivelEstudio = new Ext.grid.EditorGridPanel({
        cm:cmCgg_res_institucion_nivelEstudio,
        store:gsCgg_res_institucion_nivelEstudio,
        anchor:'100% 100%',
        viewConfig:{forceFit:true},
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."}
    });
	//////////////////////////////////////////////////////////////////////
	/**
    * new Ext.Panel Panel que contiene el template para visualizar la informacion sobre los Niveles de Educacion de la Institucion
    */
	var pnlNiveleEstudio = new Ext.Panel({
		labelWidth:100,
        title:'Niveles de Estudio',
        layout:'form',
        frame:false,
        height:200,
        tbar:[{
            iconCls:'iconNuevo',
            tooltip:'Agregar nivel de estudio',
            handler:function(){
				var tmpFLCgg_nivel_estudio = new FrmListadoCgg_nivel_estudio();
				var objBusqueda = new DlgBusqueda(tmpFLCgg_nivel_estudio.getStore(),tmpFLCgg_nivel_estudio.getColumnModel());
				objBusqueda.closeHandler(function(){
					var tmpRecord = objBusqueda.getSelectedRow();
					if(tmpRecord){
						var tmpRecordCriterio = grdCgg_res_institucion_nivelEstudio.getStore().recordType;
		                grdCgg_res_institucion_nivelEstudio.getStore().insert(0,
							new tmpRecordCriterio({
								CGIEN_CODIGO: 'KEYGEN',
								CGNES_CODIGO: tmpRecord.get('CGNES_CODIGO'),
								CGIED_CODIGO: txtCgied_codigo.getValue(),
								CGNES_DESCRIPCION: tmpRecord.get('CGNES_DESCRIPCION')																						
							})
                        );
						grdCgg_res_institucion_nivelEstudio.getView().refresh();
					}
				});
				objBusqueda.show();
            }
        },{
            iconCls:'iconEliminar',
            tooltip:'Eliminar nivel de estudio',
            handler:function(){
				Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_institucion_nivel,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_institucion_nivel(btn){
                    if (btn=='yes')
                    {
                        try{
                            function CallBackCgg_institucion_nivel(r){
                                winFrmCgg_institucion_educativa.getEl().unmask();
                                if(r=='true'){
                                    Ext.Msg.show({
                                        title:tituloCgg_institucion_educativa,
                                        msg: 'La informaci\u00f3n del nivel ha sido eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    var seleccionado = grdCgg_res_institucion_nivelEstudio.getSelectionModel().getSelected();
                                    if(seleccionado != null ){
                                        grdCgg_res_institucion_nivelEstudio.getStore().remove(seleccionado);
                                    }
                                    //gsCgg_res_institucion_contacto.reload();
                                }else{
                                    Ext.Msg.show({
                                        title:tituloCgg_institucion_educativa,
                                        msg: 'La informaci\u00f3n del nivel no ha podido ser eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
							}
                            winFrmCgg_institucion_educativa.getEl().mask('Eliminando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCgien_codigo',grdCgg_res_institucion_nivelEstudio.getSelectionModel().getSelected().get('CGIEN_CODIGO'));
                            SOAPClient.invoke(URL_WS+"Cgg_institucion_nivel","delete",param, true, CallBackCgg_institucion_nivel);
                        }catch(inErr){
                            winFrmCgg_institucion_educativa.getEl().unmask();
                        }
                    }
                }
            }

        }],
        items:[grdCgg_res_institucion_nivelEstudio]

	});
	/**
    * new Ext.TabPanel Panel que contiene el template para visualizar la informacion de contactos y Niveles de Educacion
    */
	var tpnlInformacionInstitucional = new Ext.TabPanel({
		id:"tpnlInformacionInstitucional",
		activeTab: 0,
        region:'center',
		items:[pnlCgg_institucion_contacto,pnlNiveleEstudio]
	});

    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_institucion_educativa.
     */
    var pnlCgg_institucion_educativa = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCgied_codigo,txtCgied_nombre,txtCgied_descripcion,cbxCpais_nombre,txtCgied_direccion]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_institucion_educativa.
     */
    var winFrmCgg_institucion_educativa = new Ext.Window({
        id:'winFrmCgg_institucion_educativa',
        title:tituloCgg_institucion_educativa,
        width:500,
        minWidth:500,
        maximizable:false,
        minimizable:false,
        modal:true,
        constrain:true,
        tbar:getPanelTitulo(tituloCgg_institucion_educativa,descCgg_institucion_educativa),
        items:[pnlCgg_institucion_educativa,/*pnlCgg_institucion_contacto*/tpnlInformacionInstitucional],
        bbar:[btnGuardarCgg_institucion_educativa,btnCancelarCgg_institucion_educativa,'->',btnCerrarCgg_institucion_educativa]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_institucion_educativa.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_institucion_educativaCtrls(inEstado){
        estado=!inEstado;
        txtCgied_codigo.setDisabled(estado);
        txtCpais_codigo.setDisabled(estado);
        txtCgied_descripcion.setDisabled(estado);
        txtCgied_direccion.setDisabled(estado);
		txtCgied_nombre.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_institucion_educativa.
     */
    function cargarCgg_institucion_educativaCtrls(){
        if(inRecordCgg_institucion_educativa){
            txtCgied_codigo.setValue(inRecordCgg_institucion_educativa.get('CGIED_CODIGO'));
            cbxCpais_nombre.setValue(inRecordCgg_institucion_educativa.get('CPAIS_CODIGO'));
			txtCgied_nombre.setValue(inRecordCgg_institucion_educativa.get('CGIED_NOMBRE'));
            txtCgied_descripcion.setValue(inRecordCgg_institucion_educativa.get('CGIED_DESCRIPCION'));
            txtCgied_direccion.setValue(inRecordCgg_institucion_educativa.get('CGIED_DIRECCION'));
            isEdit = true;
            gsCgg_res_institucion_contacto.reload({params:{
                inCgied_codigo:inRecordCgg_institucion_educativa.get('CGIED_CODIGO'),
                format:TypeFormat.JSON}
            });
			gsCgg_res_institucion_nivelEstudio.reload({
				params:{
					inCgied_codigo:inRecordCgg_institucion_educativa.get('CGIED_CODIGO'),
					format:TypeFormat.JSON
				}
			});
            habilitarCgg_institucion_educativaCtrls(true);

        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_institucion_educativa.
     * @returns ventana winFrmCgg_institucion_educativa.
     * @base FrmCgg_institucion_educativa.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_institucion_educativa;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_institucion_educativa.
     * @base FrmCgg_institucion_educativa.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_institucion_educativaCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_institucion_educativa desde una instancia.
 */
FrmCgg_institucion_educativa.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_institucion_educativa desde una instancia.
 */
FrmCgg_institucion_educativa.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_institucion_educativa,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_institucion_educativa.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_institucion_educativa desde una instancia.
 */
FrmCgg_institucion_educativa.prototype.loadData = function(){
    this.loadData();
}
