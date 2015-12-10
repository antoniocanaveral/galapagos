/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_jur_proceso_judicial.
 * @param {String} IN_SENTENCIA_CGG_JUR_PROCESO_JUDICIAL Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_JUR_PROCESO_JUDICIAL Registro de datos de la tabla Cgg_jur_proceso_judicial.
 * @constructor
 * @base FrmListadoCgg_jur_proceso_judicial
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_jur_proceso_judicial(IN_SENTENCIA_CGG_JUR_PROCESO_JUDICIAL,IN_RECORD_CGG_JUR_PROCESO_JUDICIAL){
    var inSentenciaCgg_jur_proceso_judicial = IN_SENTENCIA_CGG_JUR_PROCESO_JUDICIAL;
    var inRecordCgg_jur_proceso_judicial=IN_RECORD_CGG_JUR_PROCESO_JUDICIAL;
    var urlCgg_jur_proceso_judicial=URL_WS+"Cgg_jur_proceso_judicial";
    var tituloCgg_jur_proceso_judicial='Proceso Judicial';
    var descCgg_jur_proceso_judicial='El formulario permite administrar la informaci\u00f3n de Proceso Judicial';
    var isEdit = false;
    var tmpCctn_codigo;
    var tmpCrpjr_codigo;
    var tmpCrper_codigo;
    var lisEliAdjuntos2 = new Array ();
    var tmpListadoEliminar2;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
     */
    var txtCjpju_codigo = new Ext.form.TextField({
        id:'txtCjpju_codigo',
        name:'txtCjpju_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_canton por un campo especifico.
     */
	 function Canton(){
	 var cm=null;
	 var Store=null;
	 cm =new Ext.grid.ColumnModel([
        {dataIndex:'CCTN_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CCTN_NOMBRE',header:'Cant\u00f3n',width:300,sortable:true}
    ]);
	 
     Store=new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_canton",
            method:"selectPage",
			pagin:true
        }),
		remoteSort:true,
        reader:new Ext.data.JsonReader({
		id:'CCTN_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
		},[
            {name:'CCTN_CODIGO'},
			{name:'CGPRV_CODIGO'},
            {name:'CCTN_NOMBRE'},
			{name:'CCTN_DESCRPCION'},
			{name:'CCTN_ABREVIATURA'}
        ]),
		 sortInfo:{
        field: 'CCTN_NOMBRE',
        direction: 'ASC'
    },
		baseParams:{
			keyword:"",
            format:"JSON"
        }
    });
	this.getcm = function(){
        return cm;
    }

    this.getStore = function(){
        return Store;
    }


}

Canton.prototype.getColumnModel=function(){
    return this.getCm();
}

Canton.prototype.getStore=function(){
    return this.getStore();
}
    /**
     * Ext.form.ComboBox IDENTIFICATIVO UNICO DE REGISTRO de Cgg_canton
     */
  /*  var cbxCctn_codigo= new Ext.form.ComboBox({
        id:'cbxCctn_codigo',
        fieldLabel :'Canton',
        displayField:'CCTN_NOMBRE',
        store:gsCgg_canton,
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione el Canton',
        selectOnFocus:true,
        valueField:'CCTN_CODIGO',
        allowBlank :false,
        anchor:'98%',
        listeners:
        {
            select:function(combo,record)
            {
                tmpCctn_codigo = record.get('CCTN_CODIGO');
            }
        }
    });
    gsCgg_canton.load();*/
	    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGSITRO DE CANTON
     */
    var txtCctn_nombre = new Ext.form.TextField({
        id:'txtCctn_nombre',
        name:'txtCctn_nombre',
        fieldLabel :'Cant\u00f3n',
        anchor:'98%',
        readOnly:'true'
    });
	 /**
     * IDENTIFICATIVO UNICO DE REGSITRO DE PERSONA JURIDICA
     */
    var btnCctn_canton = new Ext.Button({
        id:'btnCctn_canton',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_canton = new Canton();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_canton.getStore(),tmpFLCgg_canton.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpCctn_codigo=tmpRecord.get('CCTN_CODIGO');
                        txtCctn_nombre.setValue(tmpRecord.get('CCTN_NOMBRE'));

                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGSITRO DE PERSONA JURIDICA
     */
    var txtCrpjr_codigo = new Ext.form.TextField({
        id:'txtCrpjr_codigo',
        name:'txtCrpjr_codigo',
        fieldLabel :'Raz\u00f3n Social',
        anchor:'98%',
        readOnly:'true'
    });
    /**
     * IDENTIFICATIVO UNICO DE REGSITRO DE PERSONA JURIDICA
     */
    var btnCrpjr_codigoCgg_jur_proceso_judicial = new Ext.Button({
        id:'btnCrpjr_codigoCgg_jur_proceso_judicial',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_res_persona_juridica = new FrmListadoCgg_res_persona_juridica();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona_juridica.getStore(),tmpFLCgg_res_persona_juridica.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpCrpjr_codigo=tmpRecord.get('CRPJR_CODIGO');
                        txtCrpjr_codigo.setValue(tmpRecord.get('CRPJR_RAZON_SOCIAL'));

                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
     */
    var txtCrper_codigo = new Ext.form.TextField({
        id:'txtCrper_codigo',
        name:'txtCrper_codigo',
        fieldLabel :'Persona',
        anchor:'98%',
        readOnly:'true'

    });
    /**
     * CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
     */
    var btnCrper_codigoCgg_jur_proceso_judicial = new Ext.Button({
        id:'btnCrper_codigoCgg_jur_proceso_judicial',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_res_persona = new Persona();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona.getStore(),tmpFLCgg_res_persona.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpCrper_codigo=(tmpRecord.get('CRPER_CODIGO'));
                        txtCrper_codigo.setValue(tmpRecord.get('CRPER_NOMBRES')+" "+tmpRecord.get('CRPER_APELLIDO_PATERNO'));
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField NUMERO SECUENCIAL UNICO DEL PROCESO JUDICIAL
     */
    var txtCjpju_numero = new Ext.form.TextField({
        id:'txtCjpju_numero',
        name:'txtCjpju_numero',
        fieldLabel :'N\u00famero',
        anchor:'98%',
        allowBlank :false,
        readOnly:true
    });
    /**
     * Ext.form.ComboBox TIPO DE PROCESO
     0 - DEMANDA PLANTEADA
     1 - DEMANDA RECIBIDA
     */
    var cbxCjpju_tipo_proceso = new Ext.form.ComboBox({
        id:'cbxCjpju_tipo_proceso',
        name:'cbxCjpju_tipo_proceso',
        store: dsTipoProceso,
        fieldLabel :'Tipo Proceso',
        anchor:'75%',
        mode:'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione un Tipo de Proceso'

    });
    /**
     * Ext.form.NumberField TIPO DE ADVERSARIO
     0 - PERSONA NATURAL
     1 - PERSONA JURIDICA
     */
    var rdgCjpjuTipo_adversario = new Ext.form.RadioGroup({
        anchor:'98%',
        //columns: 2, //display the radiobuttons in two columns
        items: [
            {boxLabel: 'Persona Natural', name: 'rdgCjpjuTipo_adversario', id:'idPersonaNatural', checked: true, inputValue: TypeAdversario.PERSONA_NATURAL},
            {boxLabel: 'Persona Juridica', name: 'rdgCjpjuTipo_adversario', id:'idPersonaJuridica' , inputValue: TypeAdversario.PERSONA_JURIDICA}
        ],
        listeners:{
            change: function(group,radio)
            {
                if (radio.getItemId()=='idPersonaNatural')
                {
                    pnlPersona.setVisible(true);
                    pnlPersonaJuridica.setVisible(false);

                }else{
                    pnlPersonaJuridica.setVisible(true);
                    pnlPersona.setVisible(false);
                }

            }
        }
    });
    /**
     * Ext.form.DateField FECHA DE INICIO DEL PROCESO
     */
    var dtCjpju_fecha_inicio = new Ext.form.DateField({
        id:'dtCjpju_fecha_inicio',
        name:'dtCjpju_fecha_inicio',
        fieldLabel :'Fecha inicio',
        allowBlank :false,
        format :'d/m/Y',
        value:new Date()
    });
    /**
     * Ext.form.DateField FECHA DE FINALIZACION DEL PROCESO
     */
    var dtCjpju_fecha_finalizacion = new Ext.form.DateField({
        id:'dtCjpju_fecha_finalizacion',
        name:'dtCjpju_fecha_finalizacion',
        fieldLabel :'Fecha finalizaci\u00f3n',
        allowBlank :false,
        format :'d/m/Y',
        value:new Date()
    });
    /**
     * Ext.form.NumberField ESTADO DE LA EJECUCION DEL PROCESO
     0 - PLANTEADO
     1 - EN PROCESO
     2 - FINALIZADO
     3 - SUSPENDIDO
     */

    var cbxCjpju_estado_ejecucion = new Ext.form.ComboBox({
        id:'cbxCjpju_estado_ejecucion',
        name:'cbxCjpju_estado_ejecucion',
        store: dsEstadoEjecucion,
        fieldLabel :'Estado Ejecuci\u00f3n',
        anchor:'75%',
        mode:'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione un Estado de Ejecucion'

    });
    /**
     * Ext.form.TextField PERSONA ENCARGADA DE LA SUPERVISION DEL ACUERDO
     */
    var txtCjpju_responsable = new Ext.form.TextField({
        id:'txtCjpju_responsable',
        name:'txtCjpju_responsable',
        fieldLabel :'Responsable',
        anchor:'98%',
        readOnly:false

    });
    /**
     * Ext.form.TextArea OBSERVACIONES DEL ACUERDO - HISTORIAL JSON
     */
    var txtCjpju_observacion = new Ext.form.TextArea({
        id:'txtCjpju_observacion',
        name:'txtCjpju_observacion',
        fieldLabel :'Observaci\u00f3n',
        width:'98%',
        allowBlank :false
    });
    /**
     * Ext.form.TextField DESCRIP`CION DEL ARCHIVO ADJUNTO
     */
    var txtCjadp_descripcion = new Ext.form.TextField({
        id:'txtCjadp_descripcion',
        name:'txtCjadp_descripcion',
        fieldLabel :'Descripci\u00f3n',
        anchor:'98%',
        allowBlank :false
    });
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * Ext.ux.grid.RowEditor Edito de filas personalizado para utilizaci?n en el grid de contacto
     */
    var reAdjunto1 = new Ext.ux.grid.RowEditor({
        saveText: 'Aceptar',
        cancelText:'Cancelar'
    });
    reAdjunto1.stopMonitoring();

    var cmAdj_proceso_judicial = new Ext.grid.ColumnModel([
        {dataIndex:'CJADP_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:true},
        {dataIndex:'CJHTP_FECHA_REGISTRO',header:'Fecha registro',width:150,sortable:true,hidden:true,hideable:true},
        {dataIndex:'CJADP_NOMBRE_ADJUNTO',header:'Nombre adjunto',width:150,sortable:true},
        {dataIndex:'CJADP_DESCRIPCION',header:'Descripcion',width:150,sortable:true,editor: txtCjadp_descripcion},
        {dataIndex:'CRATE_DATA',header:'CRATE_DATA',width:150,sortable:true,hidden:true,hideable:true}
    ]);


    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_adjunto por un campo especifico.
     */
    var gsAdj_proceso_judicial = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_jur_adjunto_proceso",
            method:"selectProcesoAdjunto",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
            id:'CRADJ_CODIGO',
            root:'dataSet'
        },[
            {name:'CJADP_CODIGO'},
            {name:'CJPJU_CODIGO'},
            {name:'CJHTP_FECHA_REGISTRO'},
            {name:'CJADP_NOMBRE_ADJUNTO'},
            {name:'CJADP_DESCRIPCION'}
        ]),
        baseParams:{
            inCjpju_codigo:'',
            format:"JSON"
        }
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_adjunto en un formato tabular de filas y columnas.
     */
    var grdCgg_jur_adjunto_proceso = new Ext.grid.EditorGridPanel({
        id: 'grdCgg_jur_adjunto_proceso',
        region: 'south',
        split: true,
        collapsible: true,
        collapsed : true,
        title:'Adjunto',
        animCollapse : false,
        cm: cmAdj_proceso_judicial,
        height:160,
        store:gsAdj_proceso_judicial,
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
            id: 'btnAgregarAdjuntoProceso',
            iconCls: 'iconNuevo',
            handler: function(){

                var rAdjuntoTemporal;
                var objSubirAdjunto = new FrmCgg_res_adjunto_temporal();
                objSubirAdjunto.closeHandler(function(){
                    var dialogResult = objSubirAdjunto.dialogResult();
                    if(dialogResult  !== null){
                        var tmpRecordPersona = grdCgg_jur_adjunto_proceso.getStore().recordType;
                        reAdjunto1.stopEditing();
                        grdCgg_jur_adjunto_proceso.getStore().insert(0,
                                new tmpRecordPersona({
                                    'CJADP_CODIGO':'KEYGEN',
                                    'CJADP_NOMBRE_ADJUNTO':dialogResult.CRATE_NOMBRE,
                                    'CJADP_DESCRIPCION':'',
                                    'CRATE_DATA':dialogResult.CRATE_CODIGO
                                })
                                );
                        grdCgg_jur_adjunto_proceso.getView().refresh();
                        grdCgg_jur_adjunto_proceso.getSelectionModel().selectRow(0);
                        reAdjunto1.startEditing(0);
                    }
                });
                objSubirAdjunto.show();
            }

        }, {
            id: 'btnEliminarAdjuntoProceso',
            iconCls: 'iconEliminar',
            handler: function(grid, rowIndex, colIndex) {
                grdCgg_jur_adjunto_proceso.getSelectionModel().selectRow(rowIndex);
                var rAdjuntoRequisito = grdCgg_jur_adjunto_proceso.getSelectionModel().getSelected();
                lisEliAdjuntos2.push(rAdjuntoRequisito.get('CJADP_CODIGO'));
                tmpListadoEliminar2 = Ext.util.JSON.encode(lisEliAdjuntos2);
                //alert("hola"+tmpListadoEliminar);
                grdCgg_jur_adjunto_proceso.getStore().remove(rAdjuntoRequisito);
            }

        },{
            id:'btnVerAdjuntoProceceso',
            iconCls:'iconVer',
            listeners:{
                click:function(){
                    var r=grdCgg_jur_adjunto_proceso.getSelectionModel().getSelected();
                    if(r){
					if(r.get('CRATE_DATA')){
							window.open(URL_DOC_VIEWER+'?table=cgg_res_adjunto_temporal&keyc=crate_codigo&keyv='+r.get('CRATE_DATA')+'&column=crate_archivo&fn='+r.get('CJADP_NOMBRE_ADJUNTO')+'&request=view');
						}else{
                        window.open(URL_DOC_VIEWER+'?table=cgg_jur_adjunto_proceso&keyc=cjadp_codigo&keyv='+r.get('CJADP_CODIGO')+'&column=cjadp_adjunto&fn='+r.get('CJADP_NOMBRE_ADJUNTO')+'&request=view');
						}
				}
                }
            }

        },{id:'btnDescargarAdjuntoProceso',
            iconCls:'iconDescargar',
            listeners:{
                click:function(){
                    var r=grdCgg_jur_adjunto_proceso.getSelectionModel().getSelected();
                    if(r){
                        window.open(URL_DOC_VIEWER+'?table=cgg_jur_adjunto_proceso&keyc=cjadp_codigo&keyv='+r.get('CJADP_CODIGO')+'&column=cjadp_adjunto&fn='+r.get('CJADP_NOMBRE_ADJUNTO')+'&request=download');
						}
                }
            }
        }],
        plugins:[reAdjunto1]

    });
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_jur_proceso_judicial
     */
    var btnGuardarCgg_jur_proceso_judicial = new Ext.Button({
        id:'btnGuardarCgg_jur_proceso_judicial',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (!pnlCgg_jur_proceso_judicial.getForm().isValid()){
                    return;
                }
                try{
                    function CallBackCgg_jur_proceso_judicial(r){
                        winFrmCgg_jur_proceso_judicial.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_jur_proceso_judicial,
                                msg: 'La informaci\u00f3n de Proceso Judicial ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_jur_proceso_judicial.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_jur_proceso_judicial,
                                msg: 'La informaci\u00f3n de Proceso Judicial no ha podido ser almacenada. '+(r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    if(lisEliAdjuntos2.length<=0){
                        tmpListadoEliminar2= '[]';
                    }
                    winFrmCgg_jur_proceso_judicial.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit){
                        
                        param.add('inCjpju_codigo',txtCjpju_codigo.getValue());
                        param.add('inCjadjp_eliminar',tmpListadoEliminar2 );
                    }
                    param.add('inCctn_codigo',tmpCctn_codigo?tmpCctn_codigo:null);
                    param.add('inCrpjr_codigo',tmpCrpjr_codigo?tmpCrpjr_codigo:null);
                    param.add('inCrper_codigo',tmpCrper_codigo?tmpCrper_codigo:null);
                    param.add('inCjpju_numero',txtCjpju_numero.getValue());
                    param.add('inCjpju_tipo_proceso',cbxCjpju_tipo_proceso.getValue());
                    param.add('inCjpju_tipo_adversario',rdgCjpjuTipo_adversario.getValue().getRawValue());
                    param.add('inCjpju_fecha_inicio',dtCjpju_fecha_inicio.getValue().format('c'));
                    param.add('inCjpju_fecha_finalizacion',dtCjpju_fecha_finalizacion.getValue().format('c'));
                    param.add('inCjpju_estado_ejecucion',cbxCjpju_estado_ejecucion.getValue());
                    param.add('inCjpju_responsable',txtCjpju_responsable.getValue());
                    param.add('inCjpju_observacion',txtCjpju_observacion.getValue());
                    param.add('inCjadp_adjunto',grdCgg_jur_adjunto_proceso.getStore().getJsonData());
                    SOAPClient.invoke(urlCgg_jur_proceso_judicial,IN_SENTENCIA_CGG_JUR_PROCESO_JUDICIAL,param, true, CallBackCgg_jur_proceso_judicial);
                }catch(inErr){
                    winFrmCgg_jur_proceso_judicial.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_jur_proceso_judicial.
     */
    var btnCancelarCgg_jur_proceso_judicial = new Ext.Button({
        id:'btnCancelarCgg_jur_proceso_judicial',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_jur_proceso_judicial.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_jur_proceso_judicial.
     */
    var btnCerrarCgg_jur_proceso_judicial = new Ext.Button({
        id:'btnCerrarCgg_jur_proceso_judicial',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_jur_proceso_judicial.close();
            }}
    });
    /**
     * Ext.Panel Panel para organizar la Persona Jurica
     */
    var pnlPersonaJuridica = new Ext.Panel({
        id:'pnlPersonaJuridica',
        hidden:true,
        items:[ {xtype:'panel',layout:'column',items:[
            {columnWidth:.92,layout:'form',items:[txtCrpjr_codigo]},
            {columnWidth:.08,layout:'form',items:[btnCrpjr_codigoCgg_jur_proceso_judicial]}]}
        ]
    });
    /**
     * Ext.Panel Panel para organizar la Persona
     */
    var pnlPersona = new Ext.Panel({
        id:'pnlPersona',
        //hidden:true,
        items:[ {xtype:'panel',layout:'column',items:[
            {columnWidth:.92,layout:'form',items:[txtCrper_codigo]},
            {columnWidth:.08,layout:'form',items:[btnCrper_codigoCgg_jur_proceso_judicial]}]}
        ]
    });
    /**
     * Ext.form.FieldSet FieldSet para la organizacion de los papeles : pnlPersonaJuridica y pnlPersona
     */
    var pnlfsAdversario = new Ext.form.FieldSet({
        id:'pnlfsAdversario',
        title:'Adversario',
        collapsible:true,
        // region:'center',
        labelWidth :60,
        layout:'form',
        items:[ rdgCjpjuTipo_adversario,
            pnlPersonaJuridica,
            pnlPersona]
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_jur_proceso_judicial.
     */
    var pnlCgg_jur_proceso_judicial = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        region:'center',
        items:[txtCjpju_codigo,
            txtCjpju_numero,
			{xtype:'panel',layout:'column',items:[
			{columnWidth:.92,layout:'form',items:[txtCctn_nombre]},
            {columnWidth:.08,layout:'form',items:[btnCctn_canton]}]},
            pnlfsAdversario,
            cbxCjpju_tipo_proceso,dtCjpju_fecha_inicio,dtCjpju_fecha_finalizacion,cbxCjpju_estado_ejecucion,txtCjpju_responsable,txtCjpju_observacion
        ]
    });
    /**
     * Funcion que permite cargar el  codigo del documento generado
     */
    function generarNumeroDocumento(){
        function callBackGenerarNumero(r){
            txtCjpju_numero.setValue(r);
        }
        SOAPClient.invoke(urlCgg_jur_proceso_judicial,'numeroProcesoJudicial',false, false, callBackGenerarNumero);
    }
    generarNumeroDocumento();
    /**
     * Funcion que permite cargar el  responseble del proceso
     */
    function responsableProceso(){
        function callBackResponsableProceso(r){
            txtCjpju_responsable.setValue(r);
        }
        SOAPClient.invoke(urlCgg_jur_proceso_judicial,'responsableJudicial',false, false, callBackResponsableProceso);
    }
    responsableProceso();
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_jur_proceso_judicial.
     */
    var winFrmCgg_jur_proceso_judicial = new Ext.Window({
        id:'winFrmCgg_jur_proceso_judicial',
        title:tituloCgg_jur_proceso_judicial,
        iconCls:'iconAplicacion',
        width:400,
        minWidth:400,
        height:500,
        maximizable:false,
        minimizable:true,
        modal:true,
        resizable:false,
        constrain:true,
        layout:'border',
        tbar:getPanelTitulo(tituloCgg_jur_proceso_judicial,descCgg_jur_proceso_judicial),
        items:[pnlCgg_jur_proceso_judicial,grdCgg_jur_adjunto_proceso],
        bbar:[btnGuardarCgg_jur_proceso_judicial,btnCancelarCgg_jur_proceso_judicial,'->',btnCerrarCgg_jur_proceso_judicial]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmCgg_jur_proceso_judicial.getBottomToolbar());
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_jur_proceso_judicial.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_jur_proceso_judicialCtrls(inEstado){
        estado=!inEstado;
        txtCjpju_codigo.setDisabled(estado);
        tmpCctn_codigo.setDisabled(estado);
        txtCrpjr_codigo.setDisabled(estado);
        txtCrper_codigo.setDisabled(estado);
        txtCjpju_numero.setDisabled(estado);
        cbxCjpju_tipo_proceso.setDisabled(estado);
        dtCjpju_fecha_inicio.setDisabled(estado);
        dtCjpju_fecha_finalizacion.setDisabled(estado);
        cbxCjpju_estado_ejecucion.setDisabled(estado);
        txtCjpju_responsable.setDisabled(estado);
        txtCjpju_observacion.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_jur_proceso_judicial.
     */
    function cargarCgg_jur_proceso_judicialCtrls(){
        if(inRecordCgg_jur_proceso_judicial){
            txtCjpju_codigo.setValue(inRecordCgg_jur_proceso_judicial.get('CJPJU_CODIGO'));
            tmpCctn_codigo=inRecordCgg_jur_proceso_judicial.get('CCTN_CODIGO');
            txtCctn_nombre.setValue(inRecordCgg_jur_proceso_judicial.get('CANTON'));
            tmpCrpjr_codigo=inRecordCgg_jur_proceso_judicial.get('CRPJR_CODIGO');
            txtCrpjr_codigo.setValue(inRecordCgg_jur_proceso_judicial.get('RAZON_SOCIAL'));
            tmpCrper_codigo=inRecordCgg_jur_proceso_judicial.get('CRPER_CODIGO');
            txtCrper_codigo.setValue(inRecordCgg_jur_proceso_judicial.get('PERSONA'));
            txtCjpju_numero.setValue(inRecordCgg_jur_proceso_judicial.get('CJPJU_NUMERO'));
            cbxCjpju_tipo_proceso.setValue(inRecordCgg_jur_proceso_judicial.get('CJPJU_TIPO_PROCESO'));
            cbxCjpju_estado_ejecucion.setValue(inRecordCgg_jur_proceso_judicial.get('CJPJU_ESTADO_EJECUCION'));
            dtCjpju_fecha_inicio.setValue(truncDate(inRecordCgg_jur_proceso_judicial.get('CJPJU_FECHA_INICIO')));
            dtCjpju_fecha_finalizacion.setValue(truncDate(inRecordCgg_jur_proceso_judicial.get('CJPJU_FECHA_FINALIZACION')));
            rdgCjpjuTipo_adversario.setValue('rdgCjpjuTipo_adversario',inRecordCgg_jur_proceso_judicial.get('CJPJU_TIPO_ADVERSARIO'));
            txtCjpju_responsable.setValue(inRecordCgg_jur_proceso_judicial.get('CJPJU_RESPONSABLE'));
            txtCjpju_observacion.setValue(inRecordCgg_jur_proceso_judicial.get('CJPJU_OBSERVACION'));
            if (inRecordCgg_jur_proceso_judicial.get('CJPJU_TIPO_ADVERSARIO') ==0){
                pnlPersona.setVisible(true);
                pnlPersonaJuridica.setVisible(false);

            }else{
                pnlPersonaJuridica.setVisible(true);
                pnlPersona.setVisible(false);
            }
            gsAdj_proceso_judicial.reload({
                params:{
                    inCjpju_codigo:txtCjpju_codigo.getValue(),
                    format:TypeFormat.JSON
                }
            });
            isEdit = true;
            habilitarCgg_jur_proceso_judicialCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_jur_proceso_judicial.
     * @returns ventana winFrmCgg_jur_proceso_judicial.
     * @base FrmCgg_jur_proceso_judicial.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_jur_proceso_judicial;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_jur_proceso_judicial.
     * @base FrmCgg_jur_proceso_judicial.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_jur_proceso_judicialCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_jur_proceso_judicial desde una instancia.
 */
FrmCgg_jur_proceso_judicial.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_jur_proceso_judicial desde una instancia.
 */
FrmCgg_jur_proceso_judicial.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_jur_proceso_judicial,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_jur_proceso_judicial.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_jur_proceso_judicial desde una instancia.
 */
FrmCgg_jur_proceso_judicial.prototype.loadData = function(){
    this.loadData();
}
