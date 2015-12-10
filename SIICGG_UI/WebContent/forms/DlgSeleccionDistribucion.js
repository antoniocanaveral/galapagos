/**
 *FUNCION. CREA EL OBJETO FRMSELECCIONSEGUIMIENTO PARA SELECCION DE SEGUIMIENTO DE FASES A LAS QUE SE DESPACHA UN SEGUIMIENTO DE UN TRAMITE.
 *@param inCrpro_codigo CODIGO DE PROCESO PRECARGADO.
 *@param inCrfas_codigo CODIGO DE FASE PREDETERMINADA.
 */
function DlgSeleccionDistribucion(inCrpro_codigo,inCrfas_codigo){

    var tituloDlgSeleccionDistribucion = 'Selecci\u00F3n de seguimiento';
    var descDlgSeleccionDistribucion = 'Este formulario le permite seleccionar el o los seguimientos a los que desea distribuir el seguimiento de su tr\u00E1mite.';
    var crproCodigo = null;
    var crfasCodigo = null;
    var outResult = null;
    
    var btnNuevoDlgSeleccionDistribucion = new Ext.Button({
        id:'btnNuevoDlgSeleccionDistribucion',
        text:'Aceptar',
        iconCls:'iconAceptar',
        handler:function (){
            var rFaseDistribucion  = cbsmFaseDistribuicion.getSelections();
            if(rFaseDistribucion !== null && rFaseDistribucion !== undefined && rFaseDistribucion.length>=1){
                outResult = createJSONObject(rFaseDistribucion);
                winDlgSeleccionDistribucion.close();
            }
        }
    });

    var btnCerrarDlgSeleccionDistribucion = new Ext.Button({
        id:'btnCerrarDlgSeleccionDistribucion',
        text:'Cerrar',
        iconCls:'iconCerrar',
        handler:function (){
            outResult = null;
            winDlgSeleccionDistribucion.close();
        }
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
     */
    var txtCrpro_codigoDss = new Ext.form.TextField({
        id: 'txtCrpro_codigoDss',
        name: 'txtCrpro_codigoDss',
        fieldLabel: 'Proceso',
        anchor: '98%',
        allowBlank: false,
        readOnly: 'true'        
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
     */
    var btnCrpro_codigoDss = new Ext.Button({
        id: 'btnCrpro_codigoDss',
        iconCls: 'iconBuscar',
        disabled:true,
        listeners: {
            click: function(){
                var tmpFLCgg_res_proceso = new FrmListadoCgg_res_proceso();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_proceso.getStore(), tmpFLCgg_res_proceso.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord) {
                        txtCrpro_codigoDss.setValue(tmpRecord.get('CRPRO_NOMBRE'));
                        crproCodigo= tmpRecord.get('CRPRO_CODIGO');
                        
                        sCgg_res_faseDss.reload({
                            params: {
                                inCrpro_codigo: tmpRecord.get('CRPRO_CODIGO'),
                                inCisla_codigo:new UserSession().getUserData().CISLA_CODIGO,
                                format: TypeFormat.JSON
                            }
                        });
                    }
                });
                objBusqueda.show();
            }
        }
    });

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_fase por un campo especifico.
     */
    var sCgg_res_faseDss =new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_fase",
            method:"selectCGG_RES_PROCESO"
        }),
        reader:new Ext.data.JsonReader({
            },[
            {
                name: 'CRFAS_CODIGO'
            }, {
                name: 'CRPRO_CODIGO'
            }, {
                name: 'CRETT_CODIGO'
            }, {
                name: 'CGG_CRETT_CODIGO'
            }, {
                name: 'CRSEC_CODIGO'
            }, {
                name: 'CGG_CRFAS_CODIGO'
            }, {
                name: 'CGG_CUSU_CODIGO'
            }, {
                name: 'CRFAS_NOMBRE'
            }, {
                name: 'CRFAS_ORDEN'
            }, {
                name: 'CRFAS_TAREA_REALIZA'
            }, {
                name: 'CRFAS_SUBE_ADJUNTO'
            }, {
                name: 'CRFAS_SUMILLA'
            }, {
                name: 'CUSU_CODIGO'
            }]),
        baseParams:{
            inCrpro_codigo:null,
            format:TypeFormat.JSON
        },
        listeners:{
            load:function(inThis,inRecords,inOptions){                
                var rFase = null;
                for(var i =0;i<inRecords.length;i++){
                    if(inRecords[i].get('CRFAS_CODIGO')==inCrfas_codigo){
                        rFase = inRecords[i];
                        break;
                    }
                }
                if(rFase!==null){
                    cbxCgg_res_faseDss.setValue(inCrfas_codigo);
                    cbxCgg_res_faseDss.fireEvent('select',cbxCgg_res_faseDss,rFase);
                }else{
                    sCgg_res_fase_hijoDss.reload({
                        params:{
                            inCgg_crfas_codigo:inCrfas_codigo,
                            inCisla_codigo:new UserSession().getUserData().CISLA_CODIGO,
                            format:TypeFormat.JSON
                        }
                    });                              
                }                
            }
        }
    });
    
    var sCgg_res_fase_hijoDss =new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_fase",
            method:"selectCGG_RES_FASE1"
        }),
        reader:new Ext.data.JsonReader({
            },[
            {
                name:'CRFAS_CODIGO'
            },

            {
                name:'CRPRO_CODIGO'
            },

            {
                name:'CRETT_CODIGO'
            },

            {
                name:'CGG_CRETT_CODIGO'
            },

            {
                name:'CRSEC_CODIGO'
            },

            {
                name:'CGG_CRFAS_CODIGO'
            },

            {
                name:'CGG_CUSU_CODIGO'
            },

            {
                name:'CRFAS_NOMBRE'
            },

            {
                name:'CRFAS_ORDEN'
            },{
                name:'CRFAS_TAREA_REALIZA'
            },{
                name:'CRFAS_SUBE_ADJUNTO'
            },{
                name:'CRFAS_SUMILLA'
            },{
                name:'CUSU_CODIGO'
            }]),
        baseParams:{
            inCgg_crfas_codigo:null,
            inCisla_codigo:new UserSession().getUserData().CISLA_CODIGO,
            format:TypeFormat.JSON
        },
        listeners:{
            load:function(inThis,inRecords,inOptions){
                if(inRecords.length == 0 ){
                    btnCrpro_codigoDss.disable();
                    cbxCgg_res_faseDss.disable();
                    btnNuevoDlgSeleccionDistribucion.disable();
                    Ext.MsgPopup.msg(tituloDlgSeleccionDistribucion,'La fase actual no presenta sub fases para distribuci\u00f3n', MsgPopup.WARNING);
					return;
                }
				try{
					
					var tmp_inCrfas_codigo = inRecords[0].get('CRFAS_CODIGO');					
					sCgg_res_fase_usuario.reload({
						params:{
							inCrfas_codigo: tmp_inCrfas_codigo,
							inCisla_codigo:new UserSession().getUserData().CISLA_CODIGO,
							format:TypeFormat.JSON
						}
					});

				}catch(inErr){
					crfasSiguiente = null;
				}
            }
        }
    });

    var cbsmFaseDistribuicion = new Ext.grid.CheckboxSelectionModel({        
        moveEditorOnEnter:false
    });
/**
     * Ext.data.Store. Almacenamiento de los usuarios de una fase por su isla.
     */
    var sCgg_res_fase_usuario = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_fase_usuario",
            method:"selectUsuariosFase"
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({},[
			{name:'CUSU_CODIGO'	},
			{name:'CRPER_NOMBRES'},
			{name:'CUSU_NOMBRE_USUARIO'}
        ]),
        baseParams:{
            inCrfas_codigo:'',
            inCisla_codigo:'',
            format:TypeFormat.JSON
        }
    });

    var cbxCUSU_CODIGOEditor = new Ext.form.ComboBox({
        id:'cbxCUSU_CODIGOEditor',
        store: sCgg_res_fase_usuario,
        displayField:'CRPER_NOMBRES',
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CRPER_NOMBRES}" class="x-combo-list-item">{CRPER_NOMBRES}</div></tpl>',
        valueField:'CUSU_CODIGO'
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_fase.
     */
    var cmCgg_res_faseDss = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
        cbsmFaseDistribuicion,
        {
            dataIndex:'CRFAS_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true,
            hideable:true
        },
        {
            dataIndex:'CRPRO_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true,
            hideable:true
        },
        {
            dataIndex:'CRETT_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true,
            hideable:true
        },
        {
            dataIndex:'CGG_CRETT_CODIGO',
            header:'Crett codigo',
            width:150,
            sortable:true,
            hidden:true,
            hideable:true
        },
        {
            dataIndex:'CRSEC_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true,
            hideable:true
        },
        {
            dataIndex:'CGG_CRFAS_CODIGO',
            header:'Crfas codigo',
            width:150,
            sortable:true,
            hidden:true,
            hideable:true
        },
        {
            dataIndex:'CGG_CUSU_CODIGO',
            header:'Cusu codigo',
            width:150,
            sortable:true,
            hidden:true,
            hideable:true
        },
        {
            dataIndex:'CRFAS_NOMBRE',
            header:'Nombre',
            width:150,
            sortable:true
        },
        {
            dataIndex:'CRFAS_ORDEN',
            header:'Orden',
            width:150,
            sortable:true,
            hidden:true,
            hideable:true
        },
        {
            dataIndex:'CRFAS_SUBE_ADJUNTO',
            header:'Sube adjunto',
            width:150,
            sortable:true,
            hidden:true,
            hideable:true
        },{
            dataIndex:'CUSU_CODIGO',
            header:'Usuario',
            width:150,
            sortable:true,
			editor:cbxCUSU_CODIGOEditor,
            renderer:function(inCUSU_CODIGO){
                var scpUsuario = new SOAPClientParameters();
                scpUsuario.add('inCusu_codigo',Ext.util.Format.undef(inCUSU_CODIGO));
                scpUsuario.add('format',TypeFormat.JSON);
                var tmpCusuUsuario = SOAPClient.invoke(URL_WS+"Cgg_usuario", 'selectUsuarioPersona', scpUsuario, false, null);
                try{
                    tmpCusuUsuario = Ext.util.JSON.decode(tmpCusuUsuario);
                    tmpCusuUsuario= tmpCusuUsuario[0];
                    return tmpCusuUsuario.CRPER_NOMBRES+' '+tmpCusuUsuario.CRPER_APELLIDO_PATERNO+' '+tmpCusuUsuario.CRPER_APELLIDO_MATERNO;
                }catch(inErr){
                    return NO_DATA_MESSAGE;
                }
            }
        },{
            dataIndex:'CRFAS_SUMILLA',
            header:'Comentario/Sumilla',
            width:150,
            sortable:true,
            editor:{
                xtype:'textfield'
            }
        },{
            dataIndex:'CRFAS_TAREA_REALIZA',
            header:'Actividad',
            width:150,
            sortable:true
        }]);


    /**
     *Ext.form.ComboBox Combo para edicion de requisitos.
     */
    var cbxCgg_res_faseDss = new Ext.form.ComboBox({
        id:'cbxCgg_res_faseDss',
        store:sCgg_res_faseDss,
        displayField:'CRFAS_NOMBRE',        
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        selectOnFocus:true,
        valueField:'CRFAS_CODIGO',
        disabled:true,
        listeners:{
            select:function(inThis,inRecord,inIndex){
                sCgg_res_fase_hijoDss.reload({
                    params:{
                        inCgg_crfas_codigo:inRecord.get('CRFAS_CODIGO'),
                        inCisla_codigo:new UserSession().getUserData().CISLA_CODIGO,
                        format:TypeFormat.JSON
                    }
                });
            }
        }
    });    	
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_fase en un formato tabular de filas y columnas.
     */
    var grdCgg_res_faseDss = new Ext.grid.EditorGridPanel({
        cm:cmCgg_res_faseDss,
        store:sCgg_res_fase_hijoDss,
        region:'center',
        frame:true,
        sm:cbsmFaseDistribuicion,
        tbar:['Destinatario/s'],
        loadMask:{
            msg:"Cargando..."
        },
        plugins:[new Ext.ux.grid.AutoSizeColumns()],
        clicksToEdit:1,
        listeners:{            
            afteredit:function(inObject){
                if(inObject.value.trim().length ==0){
                    inObject.record.set('CRFAS_SUMILLA','Atender, por favor.');
                }
            }
        }
    });

    var pnlNorteDss = new Ext.Panel({
        id:'pnlNorteDss',
        layout:'column',
        region:'north',
        height:35,
        minHeight:35,
        frame:true,
        anchor:'100%',
        items:[{
            columnWidth:.45,
            layout: 'form',
            labelWidth:90,
            items: [txtCrpro_codigoDss]
        }, {
            columnWidth:.05,
            layout: 'form',
            style:{
                marginleft:'5px'
            },
            items: [btnCrpro_codigoDss]
        },{
            columnWidth:.5,
            anchor:'100%',
            items:[cbxCgg_res_faseDss]
        }]
    });
    
    var winDlgSeleccionDistribucion = new Ext.Window({
        id:'winDlgSeleccionDistribucion',
        title:tituloDlgSeleccionDistribucion,
        tbar:getPanelTitulo(tituloDlgSeleccionDistribucion,descDlgSeleccionDistribucion),
        items:[pnlNorteDss,grdCgg_res_faseDss],
        width:600,
        minWidth:600,
        height:300,
        minHeight:400,
        maximizable:true,
        constrain:true,
        modal:true,
        layout:'border',        
        bbar:[btnNuevoDlgSeleccionDistribucion,'->',btnCerrarDlgSeleccionDistribucion]
    });
    /**
     *FUNCION QUE PERMITE CARGAR DATOS
     */
    function cargarDatos(){
        if(inCrpro_codigo !== null && inCrpro_codigo !== undefined){
            
            var scpProceso = new SOAPClientParameters();
            scpProceso.add('inCrpro_codigo', inCrpro_codigo);            
            scpProceso.add('format', TypeFormat.JSON);
            var tmpCrproRegistro = SOAPClient.invoke(URL_WS + "Cgg_res_proceso", 'select', scpProceso, false, null);
            try {
                tmpCrproRegistro = Ext.util.JSON.decode(tmpCrproRegistro);

                txtCrpro_codigoDss.setValue(tmpCrproRegistro[0].CRPRO_NOMBRE);
                crproCodigo= tmpCrproRegistro[0].CRPRO_CODIGO;

                sCgg_res_faseDss.reload({
                    params: {
                        inCrpro_codigo:crproCodigo,
                        inCisla_codigo:new UserSession().getUserData().CISLA_CODIGO,
                        format: TypeFormat.JSON
                    }
                });
            }catch (inErr) {
                txtCrpro_codigoDss.setValue('');
                crproCodigo= null;
            }
			
		
        }
    }

    /**
     * FUNCION MIEMBRO QUE DEVUELVE LA VENTANA WINDLGSELECCIONDISTRIBUCION.
     * @returns VENTANA winDlgSeleccionDistribucion.
     */
    this.getWindow = function(){
        return winDlgSeleccionDistribucion;
    }
    /**
     * FUNCION MIEMBRO QUE DEVUELVE EL CODIGO DE PROCESO
     * @returns crproCodigo CODIGO DE PROCESO
     */
    this.getCrproCodigo = function(){
        return crproCodigo;
    }
    /**
     * FUNCION MIEMBRO QUE DEVUELVE EL CODIGO DE FASE
     * @returns crfasCodigo CODIGO DE FASE
     */
    this.getCrfasCodigo = function(){
        return crfasCodigo;
    }
    /**
     * FUNCION QUE DEVUELVE LA FASE DE SEGUIMIENTO
     * @returns outResult
     */
    this.getCrfasSeguimiento = function(){
        return outResult;
    }

    this.loadData = cargarDatos;

}

/**
 * FUNCION PROTOTIPO. PERMITE MOSTRAR LA VENTANA WINFRMLISTADOCGG_RES_VOTO DESDE UNA INSTANCIA.
 */
DlgSeleccionDistribucion.prototype.show = function(){
    this.getWindow().show();
}
/**
 * FUNCION PROTOTIPO. PERMITE CERRAR LA VENTANA WINFRMLISTADOCGG_RES_VOTO DESDE UNA INSTANCIA.
 */
DlgSeleccionDistribucion.prototype.close = function(){
    this.getWindow().close();
}
/**
 * FUNCION PROTOTIPO. PERMITE SABER SI SE HA CERRADO LA VENTANA WINFRMLISTADOCGG_RES_VOTO,
 * CON EL FIN DE REALIZAR OTRAS ACCIONES DESDE UNA INSTANCIA.
 * @param inFunctionHandler FUNCION
 */
DlgSeleccionDistribucion.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}

/**
 * FUNCION PROTOTIPO. SELECIONA EL CODIGO DE PROCESO SELECCIONADO.
 */
DlgSeleccionDistribucion.prototype.getCrproCodigo = function(){
    this.getCrproCodigo();
}

/**
 * FUNCION PROTOTIPO. SELECIONA EL CODIGO DE PROCESO SELECCIONADO.
 */
DlgSeleccionDistribucion.prototype.getCrfasCodigo = function(){
    this.getCrfasCodigo();
}

/**
 * FUNCION PROTOTIPO. SELECIONA EL CODIGO DE PROCESO SELECCIONADO.
 */
DlgSeleccionDistribucion.prototype.getCrfasSeguimiento = function(){
    this.getCrfasSeguimiento();
}

/**
 * FUNCION PROTOTIPO. EJECUTA LA FUNCION INTERNA PARA CARGA DE DATOS.
 */
DlgSeleccionDistribucion.prototype.loadData = function(){
    return this.loadData;
}