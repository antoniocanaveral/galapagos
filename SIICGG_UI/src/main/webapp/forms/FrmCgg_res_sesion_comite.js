/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_sesion_comite.
 * @param {String} INSENTENCIA_CGG_RES_SESION_COMITE Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_SESION_COMITE Registro de datos de la tabla Cgg_res_sesion_comite.
 * @constructor
 * @base FrmListadoCgg_res_sesion_comite
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_sesion_comite(INSENTENCIA_CGG_RES_SESION_COMITE,INRECORD_CGG_RES_SESION_COMITE){
    var inSentenciaCgg_res_sesion_comite = INSENTENCIA_CGG_RES_SESION_COMITE;
    var inRecordCgg_res_sesion_comite=INRECORD_CGG_RES_SESION_COMITE;
    var urlCgg_res_sesion_comite=URL_WS+"Cgg_res_sesion_comite";
    var tituloCgg_res_sesion_comite='Sesi\u00f3n de comit\u00e9';
    var descCgg_res_sesion_comite='El formulario permite administrar informaci\u00f3n de la Sesi\u00f3n Comit\u00e9';
    var isEdit = false;
    var tmpCisla_isla;
    var tmpCicom_comite;
    var tmpFecha;
    var tmpFechaFin;
    var lisEliAdjuntos = new Array();
    var tmpListadoEliminar;
    var tmpEliTramites = new Array();
	var tmpUserSession = new UserSession();
	var tmpEliResoluciones = new Array();
	var tmpLoadAll = false;
	tmpCisla_isla=tmpUserSession.getUserData().CISLA_CODIGO;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGIsTRO DE SESION
     */
    var txtCrssc_codigo = new Ext.form.TextField({
        id:'txtCrssc_codigo',
        name:'txtCrssc_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ISLA
     */
    var txtCisla_codigo = new Ext.form.TextField({
        id:'txtCisla_codigo',
        name:'txtCisla_codigo',
        fieldLabel :'Isla',
        anchor:'98%',
        readOnly:'true',
        submitValue:false,
        allowBlank :false,
		value:tmpUserSession.getIsla()
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE ISLA
     */
    var btnCisla_codigoCgg_res_sesion_comite = new Ext.Button({
        id:'btnCisla_codigoCgg_res_sesion_comite',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_isla = new FrmListadoCgg_isla();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_isla.getStore(),tmpFLCgg_isla.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpCisla_isla=tmpRecord.get('CISLA_CODIGO');
                        txtCisla_codigo.setValue(tmpRecord.get('CISLA_NOMBRE'));}
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCrcom_codigo = new Ext.form.TextField({
        id:'txtCrcom_codigo',
        name:'txtCrcom_codigo',
        fieldLabel :'Comit\u00e9',
        anchor:'98%',
        readOnly:'true',
        submitValue:false,
        allowBlank :false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO
     */
    var btnCrcom_codigoCgg_res_sesion_comite = new Ext.Button({
        id:'btnCrcom_codigoCgg_res_sesion_comite',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_res_comite = new FrmListadoCgg_res_comite();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_comite.getStore(),tmpFLCgg_res_comite.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpCicom_comite =(tmpRecord.get('CRCOM_CODIGO'));
                        txtCrcom_codigo.setValue(tmpRecord.get('CRCOM_NOMBRE'));
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.DateField FECHA DE REALIZACION DE LA SESION
     */
    var dtCrssc_fecha_reunion = new Ext.form.DateField({
        id:'dtCrssc_fecha_reunion',
        name:'dtCrssc_fecha_reunion',
        fieldLabel :'Fecha',
        format :'d/m/Y',
        submitValue:false,
        value:CURRENT_DATE,
        listeners:{
		change:function(obj,newValue,oldValue){
                	dtCrssc_fecha_finalizacion.setMinValue(newValue);
                	dtCrssc_fecha_finalizacion.setValue(newValue);
            	},
            	select:function(obj,value){
                	dtCrssc_fecha_finalizacion.setMinValue(value);
                	dtCrssc_fecha_finalizacion.setValue(value);
            	}
        }
    });
    /**
     * Ext.form.DateField FECHA DE FINALIZACION DE SESION
     */
    var dtCrssc_fecha_finalizacion = new Ext.form.DateField({
        id:'dtCrssc_fecha_finalizacion',
        name:'dtCrssc_fecha_finalizacion',
        fieldLabel :'Fecha finalizaci\u00f3n',
        allowBlank :false,
        format :'d/m/Y',
        submitValue:false,
        value:CURRENT_DATE
    });
    /**
     * Ext.form.TextField NUMERO IDENTIFICATIVO DE LA SESION
     */
    var txtCrssc_numero_sesion = new Ext.form.TextField({
        id:'txtCrssc_numero_sesion',
        name:'txtCrssc_numero_sesion',
        fieldLabel :'N\u00famero',
        anchor:'98%',
        readOnly:true
    });
    /**
     * Ext.form.TextArea RESUMEN DEL CONTENIDO DE LA SESION
     */
    var txtCrssc_extracto = new Ext.form.TextArea({
        id:'txtCrssc_extracto',
        name:'txtCrssc_extracto',
        fieldLabel :'Extracto',
        anchor:'98%'

    });
    /**
     * Ext.form.TextArea OBSERVACIONES DE LA SESION
     */
    var txtCrssc_observacion = new Ext.form.TextArea({
        id:'txtCrssc_observacion',
        name:'txtCrssc_observacion',
        fieldLabel :'Observaci\u00f3n',
        anchor:'98%'
    });
    /**
     * Ext.form.DateField FECHA DE REALIZACION DE LA CONVOCATORIA PARA LA SESION
     */
    var dtCrssc_fecha_convocatoria = new Ext.form.DateField({
        id:'dtCrssc_fecha_convocatoria',
        name:'dtCrssc_fecha_convocatoria',
        fieldLabel :'Fecha',
        allowBlank :false,
        format :'d/m/Y',
        submitValue:false,
        value:new Date()
    });
    /**
     * Ext.form.TextArea RESUMEN DE LOS TEMAS A TRATARSE EN LA SESION
     */
    var txtCrssc_motivo_convocatoria = new Ext.form.TextArea({
        id:'txtCrssc_motivo_convocatoria',
        name:'txtCrssc_motivo_convocatoria',
        fieldLabel :'Motivo',
        anchor:'98%'

    });
    /**
     * Ext.form.TextField DESCRIPCION DE LOS DOCUMENTOS ADJUNTOS A LA SESION
     */
    var txtCrssc_descripcion_adjunto = new Ext.form.TextArea({
        id:'txtCrssc_descripcion_adjunto',
        name:'txtCrssc_descripcion_adjunto',
        fieldLabel :'Descripci\u00f3n',
        anchor:'98%',
		maxLength:200
    });

    /**
     * ARCHIVO DIGITAL ANEXO A LA SESION
     */
    var filCrssc_adjunto = new Ext.form.FileUploadField({
        id:'filCrssc_adjunto',
        name:'filCrssc_adjunto',
        fieldLabel :'Archivo',
        anchor:'98%',
        disabled :false,
        buttonCfg: {
            text: '',
            iconCls: 'iconAdjunto'
        }
    });
    /**
     * Ext.form.NumberField ESTADO DE LA CONVOCATORIA
     0 - REGISTRADA
     1 - APROBADA
     2 - ANULADA
     3 - EN PROCESO
     4 - SUSPENDIDA
     5 - CONCLUIDA
     */
    var cbxCrssc_estado_convocatoria = new Ext.form.ComboBox({
        id:'cbxCrssc_estado_convocatoria',
        name:'cbxCrssc_estado_convocatoria',
        store: dsEstadoConvocatoria,
        fieldLabel :'Estado',
        width:'150',
        displayField: 'estado_convocatoria',
        valueField: 'id',
        disabled: true,
        mode:'local',
        editable: false,
        submitValue:true,
        hiddenId:'cbxCrssc_estado_convocatoriaH',
        hiddenName:'cbxCrssc_estado_convocatoriaH',
        hiddenValue:'id',
        triggerAction:'all',
        emptyText : 'Seleccione una opcion ',
        listeners:{
            select:function(cbxCrssc_estado_convocatoria , stestado_convocatoria, inEstadoConvocatoria) {
                validarControles();
            }}
    });
    cbxCrssc_estado_convocatoria.setValue(0);
    var numCrssc_estado_convocatoria = new Ext.form.NumberField({
        id:'numCrssc_estado_convocatoria',
        name:'numCrssc_estado_convocatoria',
        fieldLabel :'Estado convocatoria',
        readonly:true
    });

    ////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Boton que permite cargar todos los tramites que estan listos para entrar a comite
     */
    var btnTodosTramite = new Ext.Button({
        id:'btnTodosTramites',
        text:'Todos',
        iconCls:'iconTodo',
        listeners:{
            click:function(){
				tmpLoadAll = true;
				gsTramites.baseParams.start = 0;
				gsTramites.baseParams.limit = 10000;
				gsTramites.baseParams.inCrssc_codigo = txtCrssc_codigo.getValue();
				gsTramites.reload();
            }}
    });
    /**
     * Ext.data.Store Agrupacion de registros de los tramites Comite por un campo especifico.
     */
    var gsTramites = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_sesion_comite",
            method:"tramiteSelect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRTRA_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRTRA_CODIGO'},
			{name:'CRRST_CODIGO'},
			{name:'CANTON'},
            {name:'CRTRA_NUMERO'},
            {name:'CRTST_CODIGO'},
            {name:'CRTST_DESCRIPCION'},
            {name:'CRETT_CODIGO'},
            {name:'CRETT_NOMBRE'}
        ]),
        sortInfo:{field: 'CRTRA_CODIGO', direction: 'ASC'},
        baseParams:{keyword:'',format:'JSON',inCrssc_codigo:''},
		listeners:{
			load:function(){
				if(tmpLoadAll){
					for(i=0; i < gsTramites.getTotalCount(); i++){
								if(!gsCgg_res_tramite.getAt(gsCgg_res_tramite.findExact('CRTRA_CODIGO',gsTramites.getAt(i).data.CRTRA_CODIGO)))
									gsCgg_res_tramite.add(gsTramites.getAt(i));
					}
					tmpLoadAll = false;
				}
			}
		}
    });
    var btnCSCSeleccionTramite = new Ext.Button({
        id:'btnCSCSeleccionTramite',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
				var cmTramites = new Ext.grid.ColumnModel([
					{dataIndex:'CANTON',header:'Cant\u00f3n',width:150,sortable:true},
					{dataIndex:'CRTRA_NUMERO',header:'N\u00famero',width:150,sortable:true},
					{dataIndex:'CRTST_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
					{dataIndex:'CRTST_DESCRIPCION',header:'Descripci\u00f3n',width:200,sortable:true},
					{dataIndex:'CRETT_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
					{dataIndex:'CRETT_NOMBRE',header:'Estado',width:150,sortable:true}
				]);
				gsTramites.baseParams.inCrssc_codigo = txtCrssc_codigo.getValue();
                var objCgg_res_seleccionTramite = new DlgBusqueda(gsTramites, cmTramites, true);
				objCgg_res_seleccionTramite.closeHandler(function(){
                    var tmpRows = objCgg_res_seleccionTramite.getSelectedRows();
					if(tmpRows){
						for(i=0; i < tmpRows.length; i++){
							if(!gsCgg_res_tramite.getAt(gsCgg_res_tramite.findExact('CRTRA_CODIGO',tmpRows[i].data.CRTRA_CODIGO)))
								gsCgg_res_tramite.add(tmpRows[i]);
						}
					}
                });
                objCgg_res_seleccionTramite.show();
            }}

    });

     var btnEliminarSeleccionTramite = new Ext.Button({
        id:'btnEliminarSeleccionTramite',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                var seleccionado = grdCgg_res_tramite_comite.getSelectionModel().getSelected();
                if(seleccionado !=null){
					tmpEliTramites.push(seleccionado.data.CRRST_CODIGO);
                    grdCgg_res_tramite_comite.getStore().remove(seleccionado);
                }else{
                    Ext.Msg.show({title:'Aviso', msg:'Seleccione el tipo de solicitud a eliminar.', buttons: Ext.Msg.OK,icon: Ext.MessageBox.QUESTION});
                }
            }
        }
    });

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el tramite Comite
     */
    var cmCgg_res_tramite_comite = new Ext.grid.ColumnModel([
        {dataIndex:'CRTRA_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CANTON',header:'Cant\u00f3n',width:150,sortable:true},
        {dataIndex:'CRTRA_NUMERO',header:'N\u00famero',width:80,sortable:true},
        {dataIndex:'CRTST_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CRTST_DESCRIPCION',header:'Descripci\u00f3n',width:150,sortable:true},
        {dataIndex:'CRETT_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CRETT_NOMBRE',header:'Estado',width:150,sortable:true}
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de los tramites Comite por un campo especifico.
     */
	 ///////////////////STORE DE INICIO, CONTIENE LAS LOS TRAMITES ASIGNADOS A LA SESION///////////////////////
    /**
     * Ext.data.Store Agrupacion de registros de los tramites Comite por un campo especifico.
     */
    var gsCgg_res_tramite = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_sesion_comite",
            method:"selectTramite",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
            id:'CRTRA_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRTRA_CODIGO'},
			{name:'CRRST_CODIGO'},
            {name:'CANTON'},
            {name:'CRTRA_NUMERO'},
            {name:'CRTST_CODIGO'},
            {name:'CRTST_DESCRIPCION'},
            {name:'CRETT_CODIGO'},
            {name:'CRETT_NOMBRE'}
        ]),
        sortInfo:{field: 'CRTRA_CODIGO' },
        baseParams:{
            inCrssc_codigo:"",
            format:"JSON"}
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos tramite Comite en un formato tabular de filas y columnas.
     */
    var grdCgg_res_tramite_comite = new Ext.grid.GridPanel({
		title:'Tr\u00e1mites',
        cm:cmCgg_res_tramite_comite,
        store:gsCgg_res_tramite,
        region:'center',
		disabled:true,
        height:250,
        tbar:[btnTodosTramite,'-',btnCSCSeleccionTramite,btnEliminarSeleccionTramite],
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."}

    });

    ///////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////
    var cmAdjunto = new Ext.grid.ColumnModel([
        {dataIndex:'CRADJ_CODIGO',header:'Codigo',width:150,sortable:true,hideable:false,hidden:true},
        {dataIndex:'CRADJ_NOMBRE_ADJUNTO',header:'Nombre adjunto',width:150,sortable:true}
    ]);

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_adjunto por un campo especifico.
     */
    var gsCgg_res_sesion_adjunto = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_sesion_comite",
            method:"selectSesionAdjunto",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
            id:'CRADJ_CODIGO',
            root:'dataSet'
        },[  
			{name:'CRADJ_CODIGO'},
			{name:'CRADJ_NOMBRE_ADJUNTO'}
        ]),
        baseParams:{
            inCrssc_codigo:'',
            format:"JSON"
        }
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_adjunto en un formato tabular de filas y columnas.
     */
    var grdCgg_res_adjuntos_sesion_comite = new Ext.grid.EditorGridPanel({
        id: 'grdCgg_res_adjuntos_sesion_comite',
		title:'Adjuntos',
        cm: cmAdjunto,
        height:250,
        store:gsCgg_res_sesion_adjunto,
        disabled:true,
        region: 'center',
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
            id: 'btnAgregarAdjuntoSesion',
            iconCls: 'iconNuevo',
            handler: function(){
                var coleccion = {};
                //  tmpListadoEliminar= '[]';
                var datos = "<div width='100%'><INPUT TYPE='file' id='ful" + grdCgg_res_adjuntos_sesion_comite.getStore().getCount() + "' size='25' name='inSesionAdjuntos'/></div> ";

                //coleccion['CRADJ_CODIGO'] =  grdCgg_res_adjuntos_sesion_comite.getStore().getCount();
                coleccion['CRADJ_CODIGO'] =  "KEYGEN";
                coleccion['CRADJ_NOMBRE_ADJUNTO'] = datos;


                var recordAdjunto = new Ext.data.Record(coleccion, grdCgg_res_adjuntos_sesion_comite.getStore().getCount());
                grdCgg_res_adjuntos_sesion_comite.getStore().add(recordAdjunto);
            }
        }, {
            id: 'btnEliminarAdjuntoSesion',
            iconCls: 'iconEliminar',
            handler: function(){
                var seleccionado = grdCgg_res_adjuntos_sesion_comite.getSelectionModel().getSelected();
                // alert(seleccionado.get('CRADJ_CODIGO'));
                if(seleccionado !=null){
                    if(seleccionado.get('CRADJ_CODIGO')== "KEYGEN")
                    {
                        grdCgg_res_adjuntos_sesion_comite.getStore().remove(seleccionado);

                    }else
                    {
                        function SWRCgg_res_adj(btn){
                            if (btn=='yes')
                            {
                                lisEliAdjuntos.push(seleccionado.get('CRADJ_CODIGO'));
                                tmpListadoEliminar = Ext.util.JSON.encode(lisEliAdjuntos);
                                //alert("hola"+tmpListadoEliminar);
                                grdCgg_res_adjuntos_sesion_comite.getStore().remove(seleccionado);
                            }
                        }
                        Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_adj,icon: Ext.MessageBox.QUESTION});
                    }
                }
                else
                {
                    Ext.MessageBox.alert('Sesi\u00f3n Comit\u00e9', 'Seleccione el registro a eliminar');
                }
            }

        },{
            id:'btnVerCgg_res_sesion_comite',
            iconCls:'iconVer',
            listeners:{
                click:function(){
                    var r=grdCgg_res_adjuntos_sesion_comite.getSelectionModel().getSelected();
                    if(r)
                        window.open(URL_DOC_VIEWER+'?table=cgg_res_adjunto&keyc=cradj_codigo&keyv='+r.get('CRADJ_CODIGO')+'&column=cradj_archivo_adjunto&fn='+r.get('CRADJ_NOMBRE_ADJUNTO')+'&request=view');
                }
            }

        },{id:'btnDescargarCgg_res_sesion_comite',
            iconCls:'iconDescargar',
            listeners:{
                click:function(){
                    var r=grdCgg_res_adjuntos_sesion_comite.getSelectionModel().getSelected();
                    if(r)
                        window.open(URL_DOC_VIEWER+'?table=cgg_res_adjunto&keyc=cradj_codigo&keyv='+r.get('CRADJ_CODIGO')+'&column=cradj_archivo_adjunto&fn='+r.get('CRADJ_NOMBRE_ADJUNTO')+'&request=download');
                }
            }
        }]

    });
	///////////////////////////////////////RESOLUCIONES//////////////////////////////////////////
	/**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_resolucion.
     */
    var cmCgg_res_resolucionSC = new Ext.grid.ColumnModel([
        {dataIndex:'CRRES_NUMERO_RESOLUCION',header:'N\u00famero',width:150,sortable:true},
        {dataIndex:'CRRES_TIPO',header:'Tipo',width:150,sortable:true, renderer:function(inCrres_Tipo){
            return dsTipoResolucion[inCrres_Tipo][1];
        }},
        {dataIndex:'CRRES_OBSERVACIONES',header:'Observaciones',width:150,sortable:true,hidden:true},
        {dataIndex:'CRRES_EXTRACTO_RESOLUCION',header:'Extracto',width:150,sortable:true},
        {dataIndex:'CRRES_NOMBRE_ADJUNTO_RESOL',header:'Nombre adjunto',width:150,sortable:true},
        {dataIndex:'CRRES_DESCRIPCION_ADJUNTO',header:'Descripcion adjunto',width:150,sortable:true,hidden:true},
        {dataIndex:'CRRES_EXTRACTO_APELACION',header:'Extracto apelacion',width:150,sortable:true,hidden:true},
        {dataIndex:'CRRES_NOMBRE_ADJUNTO_APELAC',header:'Nombre adjunto apelac',width:150,sortable:true,hidden:true},
        {dataIndex:'CRRES_ESTADO_RESOLUCION',header:'Estado resolucion',width:150,sortable:true, renderer:function(inCrres_estado){
            return dsEstadoResolucion[inCrres_estado][1];
        }
        }]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_resolucion por un campo especifico.
     */
    var gsCgg_res_resolucionSC = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_resolucion",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRRES_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRRES_CODIGO'},            
            {name:'NUMERO'},
            {name:'CRSSC_CODIGO'},
            {name:'CRSSC_NUMERO_SESION'},
            {name:'CRRES_NUMERO_RESOLUCION'},
            {name:'CRRES_TIPO'},
            {name:'CRRES_OBSERVACIONES'},
            {name:'CRRES_EXTRACTO_RESOLUCION'},
            {name:'CRRES_VOTOS_APROBACION'},
            {name:'CRRES_VOTOS_NEGACION'},
            {name:'CRRES_VOTOS_ABSTENCION'},
            {name:'CRRES_FECHA_EMISION'},
            {name:'CRRES_FECHA_EJECUCION'},
            {name:'CRRES_FECHA_ANULACION'},
            {name:'CRRES_RESOLUCION_REEMPLAZA'},
            {name:'CRRES_NOMBRE_ADJUNTO_RESOL'},
            {name:'CRRES_DESCRIPCION_ADJUNTO'},
            {name:'CRRES_FECHA_APELACION'},
            {name:'CRRES_EXTRACTO_APELACION'},
            {name:'CRRES_NUMERO_APELACION'},
            {name:'CRRES_NOMBRE_ADJUNTO_APELAC'},                           
            {name:'CRRES_ESTADO_RESOLUCION'}
        ]),        
        sortInfo:{field: 'CRSSC_NUMERO_SESION', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON',
			inCrres_estado_resolucion:0,
			inCrssc_codigo:''}
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_resolucion en un formato tabular de filas y columnas.
     */
    var grdCgg_res_resolucionSC = new Ext.grid.GridPanel({
		title:'Resoluciones',
        cm:cmCgg_res_resolucionSC,
        store:gsCgg_res_resolucionSC,
        region:'center',
		disabled:true,
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [{iconCls:'iconNuevo',handler:function(){
			var tmpResol = new FrmListadoCgg_res_resolucion();
			var tmpStore = tmpResol.getStore();
			var tmpCM = tmpResol.getColumnModel();
			tmpStore.baseParams.inCrres_estado_resolucion = 0;
			tmpCM.setHidden(1,true);
			tmpCM.setHidden(3,true);
			var dlgSelecResol = new DlgBusqueda(tmpStore,tmpCM,true);
			dlgSelecResol.closeHandler(function(){
				var tmpRows = dlgSelecResol.getSelectedRows();
				if(tmpRows){
					for(i=0; i < tmpRows.length; i++){
						if(!gsCgg_res_resolucionSC.getAt(gsCgg_res_resolucionSC.findExact('CRRES_CODIGO',tmpRows[i].data.CRRES_CODIGO)))
							gsCgg_res_resolucionSC.add(tmpRows[i]);
					}
				}
			});
			dlgSelecResol.show();
		}},{iconCls:'iconEliminar',handler:function(){
			if(grdCgg_res_resolucionSC.getSelectionModel().getSelected()){
				tmpEliResoluciones.push(grdCgg_res_resolucionSC.getSelectionModel().getSelected().data.CRRES_CODIGO);
				gsCgg_res_resolucionSC.remove(grdCgg_res_resolucionSC.getSelectionModel().getSelected());
			}
		}}
		],
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_resolucion.disabled){
                    btnEditarCgg_res_resolucion.fireEvent('click', btnEditarCgg_res_resolucion);
                }
            }}});
	////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_sesion_comite
     */
    var btnGuardarCgg_res_sesion_comite = new Ext.Button({
        id:'btnGuardarCgg_res_sesion_comite',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_res_sesion_comite.getForm().isValid()==false){
                    return;
                }
                tmpFecha = dtCrssc_fecha_reunion.getValue().format(TypeDateFormat.ISO8601Long);
                tmpFechaFin= dtCrssc_fecha_finalizacion.getValue().format(TypeDateFormat.ISO8601Long);
                if(lisEliAdjuntos.length<=0){
                    tmpListadoEliminar='[]';
                }
                ///////////////////
                var tmpStoreOf = grdCgg_res_tramite_comite.getStore().getJsonData();
                pnlCgg_res_sesion_comite.getEl().mask('Espere un momento por favor.<br>El tiempo de respuesta depender\u00E1 del tama\u00F1o de sus archivos adjuntos.', 'x-mask-loading');
                pnlCgg_res_sesion_comite.getForm().submit({
                    url: URL_WS+"Cgg_res_sesion_comiteSRV",
                    success: function(inThis, inResponse){
						Ext.Msg.show({
							title:tituloCgg_res_sesion_comite,
							msg: 'La informaci\u00f3n de la Sesi\u00f3n Comit\u00e9 ha sido almacenada.'+(!isEdit?'<br>El numero de sesi\u00f3n es <b>'+inResponse.result.msg+'</b>.':''),
							buttons: Ext.Msg.OK,
							icon: Ext.MessageBox.INFO
						});
						winFrmCgg_res_sesion_comite.close();
                    },
                    failure:function(inThis, inResponse){
                        Ext.Msg.show({
                            title:tituloCgg_res_sesion_comite,
                            msg: 'La informaci\u00f3n de la Sesi\u00f3n Comit\u00e9 no ha podido ser almacenada. '+inResponse.result.msg,
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.ERROR
                        });
                        pnlCgg_res_sesion_comite.getEl().unmask();
                    },

                    params:{
                        request:INSENTENCIA_CGG_RES_SESION_COMITE,
                        txtCisla_codigo: tmpCisla_isla,
                        txtCrcom_codigo:tmpCicom_comite,
                        dtCrssc_fecha_reunion: tmpFecha,
                        dtCrssc_fecha_finalizacion: tmpFechaFin,
                        dtCrssc_fecha_convocatoria:tmpFecha,
                        inpryu_JSON:tmpStoreOf,
                        inEliTramites:tmpEliTramites.toJSON(),
                        inEliCradj_codigo:tmpListadoEliminar,
						inResoluciones:gsCgg_res_resolucionSC.getJsonData(),
						inEliResoluciones:tmpEliResoluciones.toJSON()
                    }
                });
            }
        }
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_sesion_comite.
     */
    var btnCancelarCgg_res_sesion_comite = new Ext.Button({
        id:'btnCancelarCgg_res_sesion_comite',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_res_sesion_comite.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_sesion_comite.
     */
    var btnCerrarCgg_res_sesion_comite = new Ext.Button({
        id:'btnCerrarCgg_res_sesion_comite',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_res_sesion_comite.close();
            }}
    });

    var btnDescargarAdjuntoSesionComite = new Ext.Button({
        id:'btnDescargarAdjuntoSesionComite',
        iconCls:'iconVer',
        listeners:{
            click:function(){
                if(isEdit){
                    if(INRECORD_CGG_RES_SESION_COMITE)
                    {
                        window.open(URL_DOC_VIEWER+'?table=cgg_res_sesion_comite&keyc=crssc_codigo&keyv='+inRecordCgg_res_sesion_comite.get('CRSSC_CODIGO')+'&column=crssc_adjunto&fn='+inRecordCgg_res_sesion_comite.get('CRSSC_NOMBRE_ADJUNTO')+'&request=view');
                    }
                }}
        }

    });
    /**
     * Ext.form.FormPanel Panel para las Fechas
     */
    var pnlfsAdjunto = new Ext.form.FieldSet({
        id:'pnlfsAdjunto',
        title:'Adjunto',
        collapsible:true,
        region:'center',
        height:150,
        labelWidth :70,

        layout:'form',
        items:[ {xtype:'panel', layout:'column',
                        fileUpload:true,
            items:[  {columnWidth:.65,
                    layout:'form',
                    items:[filCrssc_adjunto]},
                    {columnWidth:.35,
                        layout:'form',
                        items:[btnDescargarAdjuntoSesionComite]}

                        ]},txtCrssc_descripcion_adjunto]
    });

    var pnlGeneral = new Ext.Panel({
        frame:true,
        labelWidth :100,
        region:'north',
        height:100,
        layout:'form',
        items:[txtCrssc_codigo,
            {xtype:'panel',layout:'column',items:
                    [{columnWidth:.92,layout:'form',items:[txtCisla_codigo]},
                        {columnWidth:.08,layout:'form',items:[btnCisla_codigoCgg_res_sesion_comite]}]},
            {xtype:'panel',layout:'column',items:
                    [{columnWidth:.92,layout:'form',items:[txtCrcom_codigo]},
                        {columnWidth:.08,layout:'form',items:[btnCrcom_codigoCgg_res_sesion_comite]}]},
            cbxCrssc_estado_convocatoria]


    });
    var pnlSesion= new Ext.Panel({
        frame:true,
        labelWidth:70,
        layout:'form',
        title:'Sesi\u00f3n',
        fileUpload:true,
        items:[txtCrssc_numero_sesion,{xtype:'panel',layout:'column',items:[{columnWidth:.5,layout:'form',items:[dtCrssc_fecha_reunion]},{columnWidth:.5,layout:'form',labelWidth:110,items:[dtCrssc_fecha_finalizacion]}]},txtCrssc_extracto,txtCrssc_observacion,pnlfsAdjunto]

    });

    var pnlConvocatoria = new Ext.Panel({
        frame:true,
        labelWidth :100,
        layout:'form',
        title:'Convocatoria',
        fileUpload:true,
        items:[dtCrssc_fecha_convocatoria, txtCrssc_motivo_convocatoria]

    });
    var tblOrdenar = new Ext.TabPanel({
        activeTab:0,
        frame:true,
        region:'center',
        height:280,
        items:[pnlSesion,grdCgg_res_adjuntos_sesion_comite,grdCgg_res_tramite_comite,grdCgg_res_resolucionSC]
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_sesion_comite.
     */
    var pnlCgg_res_sesion_comite = new Ext.form.FormPanel({
        labelWidth :100,
        items:[pnlGeneral,tblOrdenar],
        region:'center',
        layout:'border',
        bodyBorder :false,
        id:'pnlCgg_res_sesion_comite',
        fileUpload:true
    });

    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_sesion_comite.
     */
    var winFrmCgg_res_sesion_comite = new Ext.Window({
        title:tituloCgg_res_sesion_comite,
        tbar:getPanelTitulo(tituloCgg_res_sesion_comite,descCgg_res_sesion_comite),
        layout:'border',
        items:[pnlCgg_res_sesion_comite],
        width:560,
        minWidth:450,
        height:600,
        modal:true,
        resizable:true,
        maximizable:false,
        minimizable:false,
        constrain:true,
        bbar:[btnGuardarCgg_res_sesion_comite,btnCancelarCgg_res_sesion_comite,'->',btnCerrarCgg_res_sesion_comite],
		listeners:{
			show:function(){
				if(!isEdit){
					dtCrssc_fecha_reunion.minValue = CURRENT_DATE;
					dtCrssc_fecha_finalizacion.minValue = CURRENT_DATE;
				}
			}
		}
    });
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_sesion_comite.
     */
    function cargarCgg_res_sesion_comiteCtrls(){
        if(inRecordCgg_res_sesion_comite){
            txtCrssc_codigo.setValue(inRecordCgg_res_sesion_comite.get('CRSSC_CODIGO'));
            tmpCisla_isla=inRecordCgg_res_sesion_comite.get('CISLA_CODIGO');
            txtCisla_codigo.setValue(inRecordCgg_res_sesion_comite.get('CISLA_NOMBRE'));
            tmpCicom_comite=inRecordCgg_res_sesion_comite.get('CRCOM_CODIGO');
            txtCrcom_codigo.setValue(inRecordCgg_res_sesion_comite.get('COMITE'));
            dtCrssc_fecha_reunion.setValue(truncDate(inRecordCgg_res_sesion_comite.get('CRSSC_FECHA_REUNION')));
            dtCrssc_fecha_finalizacion.setValue(truncDate(inRecordCgg_res_sesion_comite.get('CRSSC_FECHA_FINALIZACION')));
            txtCrssc_numero_sesion.setValue(inRecordCgg_res_sesion_comite.get('CRSSC_NUMERO_SESION'));
            txtCrssc_extracto.setValue(inRecordCgg_res_sesion_comite.get('CRSSC_EXTRACTO'));
            txtCrssc_observacion.setValue(inRecordCgg_res_sesion_comite.get('CRSSC_OBSERVACION'));
            dtCrssc_fecha_convocatoria.setValue(truncDate(inRecordCgg_res_sesion_comite.get('CRSSC_FECHA_CONVOCATORIA')));
            txtCrssc_motivo_convocatoria.setValue(inRecordCgg_res_sesion_comite.get('CRSSC_MOTIVO_CONVOCATORIA'));
            txtCrssc_descripcion_adjunto.setValue(inRecordCgg_res_sesion_comite.get('CRSSC_DESCRIPCION_ADJUNTO'));
            filCrssc_adjunto.setValue(inRecordCgg_res_sesion_comite.get('CRSSC_NOMBRE_ADJUNTO'));
            // filCrssc_adjunto.setValue(inRecordCgg_res_sesion_comite.get('CRSSC_ADJUNTO'));
            cbxCrssc_estado_convocatoria.setValue(inRecordCgg_res_sesion_comite.get('CRSSC_ESTADO_CONVOCATORIA'));
            isEdit = true;
            
            cbxCrssc_estado_convocatoria.hiddenValue = inRecordCgg_res_sesion_comite.get('CRSSC_ESTADO_CONVOCATORIA');
            cbxCrssc_estado_convocatoria.enable();
            grdCgg_res_tramite_comite.enable();
            pnlSesion.enable();
            
			validarControles();
			btnGuardarCgg_res_sesion_comite.setDisabled(inRecordCgg_res_sesion_comite.get('CRSSC_ESTADO_CONVOCATORIA') == TypeEstadoConvocatoria.CONCLUIDA ||
				inRecordCgg_res_sesion_comite.get('CRSSC_ESTADO_CONVOCATORIA') == TypeEstadoConvocatoria.ANULADA);
            gsCgg_res_sesion_adjunto.reload({
                params:{
                    inCrssc_codigo:txtCrssc_codigo.getValue(),
                    format:TypeFormat.JSON
                }
            });
			gsCgg_res_resolucionSC.baseParams.inCrssc_codigo = inRecordCgg_res_sesion_comite.get('CRSSC_CODIGO');
			gsCgg_res_resolucionSC.baseParams.start = 0;
			gsCgg_res_resolucionSC.baseParams.limit = 1000;
			gsCgg_res_resolucionSC.reload();
			gsCgg_res_tramite.baseParams.inCrssc_codigo = inRecordCgg_res_sesion_comite.get('CRSSC_CODIGO');
			gsCgg_res_tramite.reload();
        }
    }
	
	function validarControles(){
		grdCgg_res_resolucionSC.setDisabled(
			cbxCrssc_estado_convocatoria.getValue()!=1 && cbxCrssc_estado_convocatoria.getValue()!=3
		);
		grdCgg_res_tramite_comite.setDisabled(
			cbxCrssc_estado_convocatoria.getValue()!=1 && cbxCrssc_estado_convocatoria.getValue()!=3
		);
		grdCgg_res_adjuntos_sesion_comite.setDisabled(
			cbxCrssc_estado_convocatoria.getValue()!=1 && cbxCrssc_estado_convocatoria.getValue()!=3
		);
		pnlSesion.setDisabled(cbxCrssc_estado_convocatoria.getValue() > 0);
	}
	
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_sesion_comite.
     * @returns ventana winFrmCgg_res_sesion_comite.
     * @base FrmCgg_res_sesion_comite.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_sesion_comite;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_sesion_comite.
     * @base FrmCgg_res_sesion_comite.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_sesion_comiteCtrls();
    }
}

/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_sesion_comite desde una instancia.
 */
FrmCgg_res_sesion_comite.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_sesion_comite desde una instancia.
 */
FrmCgg_res_sesion_comite.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_sesion_comite,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_sesion_comite.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_sesion_comite desde una instancia.
 */
FrmCgg_res_sesion_comite.prototype.loadData = function(){
    this.loadData();
}
