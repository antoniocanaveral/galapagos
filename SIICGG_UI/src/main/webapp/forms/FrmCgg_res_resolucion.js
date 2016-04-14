/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_resolucion.
 * @param {String} INSENTENCIA_CGG_RES_RESOLUCION Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_RESOLUCION Registro de datos de la tabla Cgg_res_resolucion.
 * @constructor
 * @base FrmListadoCgg_res_resolucion
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_resolucion(INSENTENCIA_CGG_RES_RESOLUCION,INRECORD_CGG_RES_RESOLUCION){
    var inSentenciaCgg_res_resolucion = INSENTENCIA_CGG_RES_RESOLUCION;
    var inRecordCgg_res_resolucion=INRECORD_CGG_RES_RESOLUCION;
    var urlCgg_res_resolucion=URL_WS+"Cgg_res_resolucion";
    var tituloCgg_res_resolucion='Resoluci\u00f3n';
    var descCgg_res_resolucion='El formulario permite administrar informaci\u00f3n de la Resoluci\u00f3n';
    var isEdit = false;
    var tmpFecha;
    var tmpCrtra_codigo;
    var tmpCrssc_codigo;
    var lisEliAdjuntos = new Array ();
    var tmpListadoEliminar;
	var tmpUserSession = new UserSession();
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
     */
    var txtCrres_codigo = new Ext.form.TextField({
        id:'txtCrres_codigo',
        name:'txtCrres_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
     */
    var txtCrtra_codigo = new Ext.form.TextField({
        id:'txtCrtra_codigo',
        name:'txtCrtra_codigo',
        fieldLabel :'Tr\u00e1mite',
        width:'98',
        readOnly:'true',
        submitValue:false
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGIsTRO DE SESION
     */
    var txtCrssc_codigo = new Ext.form.TextField({
        id:'txtCrssc_codigo',
        name:'txtCrssc_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        hidden:true,
        hideLabel:true,
        submitValue:false
    });
    /**
     * Ext.form.TextField NUMERO IDENTIFICATIVO DE LA RESOLUCION
     */
    var txtCrres_numero_resolucion = new Ext.form.TextField({
        id:'txtCrres_numero_resolucion',
        name:'txtCrres_numero_resolucion',
        fieldLabel :'N\u00famero',
        width:'200',
        readOnly:true
    });
    /**
     * Ext.form.NumberField TIPO DE RESOLUCION
     0 - NORMATIVA
     1 - APROBACION
     */
    var cbxCrres_tipo_resolucion = new Ext.form.ComboBox({
        id:'cbxCrres_tipo_resolucion',
        name:'cbxCrres_tipo_resolucion',
        store: dsTipoResolucion,
        fieldLabel :'Tipo',
        labelWidth:'70',
        width:'150',
        disabled: false,
        typeAhead:true,
        forceSelection:true,
        mode:'local',
        editable: false,
        triggerAction:'all',
        submitValue:false,
        emptyText:'Seleccione una opci\u00f3n..',
        enableKeyEvents:true,
        listeners:{
            select:function(cbxCrres_tipo_resolucion , sttipo_resolucion, inCrmtr_Tipo) {
                if (inCrmtr_Tipo==1){
                    //Ext.getCmp("pnlTramites").setVisible(true);
                }else{
                    //Ext.getCmp("pnlTramites").setVisible(false);
                }
            }
        }

    });
    cbxCrres_tipo_resolucion.setValue(0);
    /**
     * Ext.form.TextArea OBSERVACIONES CONSIDERADAS PARA LA RESOLUCION
     */
    var txtCrres_observaciones = new Ext.form.TextArea({
    	title:'Observaciones',
        id:'txtCrres_observaciones',
        name:'txtCrres_observaciones',
        fieldLabel :'Observaciones',
        width:'98%'
    });
    /**
     * Ext.form.TextArea RESUMEN DEL CONTENIDO DE LA RESOLUCION
     */
    var txtCrres_extracto_resolucion = new Ext.form.TextArea({
        id:'txtCrres_extracto_resolucion',
        name:'txtCrres_extracto_resolucion',
        fieldLabel :'Extracto',
        width:'98%'
    });
    /**
     * Ext.form.NumberField NUMERO DE VOTOS A FAVOR DE LA RESOLUCION
     */
    var numCrres_votos_aprobacion = new Ext.form.NumberField({
        id:'numCrres_votos_aprobacion',
        name:'numCrres_votos_aprobacion',
        fieldLabel :'Aprobados',
        anchor:'98%',
        disabled :false,
        readOnly:true
    });
    /**
     * Ext.form.NumberField NUMERO DE VOTOS EN CONTRA DE LA RESOLUCION
     */
    var numCrres_votos_negacion = new Ext.form.NumberField({
        id:'numCrres_votos_negacion',
        name:'numCrres_votos_negacion',
        fieldLabel :'Negados',
        anchor:'98%',
        disabled :false,
        readOnly:true,
        value:0
    });
    /**
     * Ext.form.NumberField NUMERO DE VOTOS DE ABSTENCION
     */
    var numCrres_votos_abstencion = new Ext.form.NumberField({
        id:'numCrres_votos_abstencion',
        name:'numCrres_votos_abstencion',
        fieldLabel :'Abstenciones',
        anchor:'98%',
        allowBlank :false,
        readOnly:true,
        value:0
    });
    /**
     /**
     * Ext.form.DateField FECHA DE EMISION DE RESULTADO DE LA RESOLUCION
     */
    var dtCrres_fecha_emision = new Ext.form.DateField({
        id:'dtCrres_fecha_emision',
        name:'dtCrres_fecha_emision',
        fieldLabel :'Emisi\u00f3n',
        value:CURRENT_DATE,
        readOnly:true,
        listeners:{
        	change:function(obj,newValue,oldValue){
                	dtCrres_fecha_ejecucion.setMinValue(newValue);
                	dtCrres_fecha_ejecucion.setValue(newValue);
                	dtCrres_fecha_anulacion.setMinValue(newValue);
                	dtCrres_fecha_anulacion.setValue(newValue);
            	},
            	select:function(obj,value){
                	dtCrres_fecha_ejecucion.setMinValue(value);
                	dtCrres_fecha_ejecucion.setValue(value);
                	dtCrres_fecha_anulacion.setMinValue(value);
                	dtCrres_fecha_anulacion.setValue(value);
            	}
        }
    });
    /**
     * Ext.form.DateField FECHA DE EJECUCION O LLEVADA A LA PRACTICA
     */
    var dtCrres_fecha_ejecucion = new Ext.form.DateField({
        id:'dtCrres_fecha_ejecucion',
        name:'dtCrres_fecha_ejecucion',
        fieldLabel :'Ejecuci\u00f3n',
        value:CURRENT_DATE,
        readOnly:true,
        listeners:{
        	change:function(obj,newValue,oldValue){
                	dtCrres_fecha_anulacion.setMinValue(newValue);
                	dtCrres_fecha_anulacion.setValue(newValue);
            	},
            	select:function(obj,value){
                	dtCrres_fecha_anulacion.setMinValue(value);
                	dtCrres_fecha_anulacion.setValue(value);
            	}
        }
    });
    /**
     * Ext.form.DateField FECHA DE ANULACION O PERDIDA DE LA VIGENCIA
     */
    var dtCrres_fecha_anulacion = new Ext.form.DateField({
        id:'dtCrres_fecha_anulacion',
        name:'dtCrres_fecha_anulacion',
        fieldLabel :'Anulaci\u00f3n',
        value:CURRENT_DATE,
        readOnly:true
    });
    /**
     * Ext.form.TextField RESOLUCION POR LA QUE PUDO SER REEMPLAZA LA ACTUAL
     */
    var txtCrres_resolucion_reemplaza = new Ext.form.TextField({
        id:'txtCrres_resolucion_reemplaza',
        name:'txtCrres_resolucion_reemplaza',
        fieldLabel :'Reemplazo',
        width:'150',
        readOnly:true
    });
    /**
     * BUSQUEDA DE LA RESOLUCION A REEMPLAZAR
     */
    var btnCrres_codigoCgg_res_resolucion = new Ext.Button({
        id:'btnCrres_codigoCgg_res_resolucion',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFListadoCgg_res_resolucion = new FrmListadoCgg_res_resolucion();
                var objBusqueda = new DlgBusqueda(tmpFListadoCgg_res_resolucion.getStore(),tmpFListadoCgg_res_resolucion.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                        txtCrres_resolucion_reemplaza.setValue(tmpRecord.get('CRRES_NUMERO_RESOLUCION'));
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField NOMBRE DEL DOCUMENTO ADJUNTO
     */
    var txtCrres_nombre_adjunto_resol = new Ext.form.TextField({
        id:'txtCrres_nombre_adjunto_resol',
        name:'txtCrres_nombre_adjunto_resol',
        fieldLabel :'Nombre',
        anchor:'98%',
        readOnly:true
    });
    /**
     * ARCHIVO DIGITAL ANEXO
     */
    var filCrres_adjunto_resolucion = new Ext.form.FileUploadField({
        id:'filCrres_adjunto_resolucion',
        name:'filCrres_adjunto_resolucion',
        fieldLabel :'Archivo',
        disabled :false,
        anchor:'100%',
        buttonCfg: {
            text: '',
            iconCls: 'iconAdjunto'
        }
    });
    /**
     * Ext.form.TextField DESCRIPCION DE LOS DOCUMENTOS ADJUNTOS
     */
    var txtCrres_descripcion_adjunto = new Ext.form.TextField({
        id:'txtCrres_descripcion_adjunto',
        name:'txtCrres_descripcion_adjunto',
        fieldLabel :'Descripci\u00f3n',
        anchor:'98%'
    });
    /**
     * Ext.form.DateField FECHA DE APELACION A LA RESOLUCION
     */
    var dtCrres_fecha_apelacion = new Ext.form.DateField({
        id:'dtCrres_fecha_apelacion',
        name:'dtCrres_fecha_apelacion',
        fieldLabel :'Fecha',
        value:CURRENT_DATE,
        format:'d/m/Y'
    });

    /**
     * Ext.form.TextArea EXTRACTO DE LA APELACION
     */
    var txtCrres_extracto_apelacion = new Ext.form.TextArea({
        id:'txtCrres_extracto_apelacion',
        name:'txtCrres_extracto_apelacion',
        fieldLabel :'Extracto',
        anchor:'98%'
    });
    /**
     * Ext.form.TextField NUMERO DE DOCUMENTO DE APELACION
     */
    var txtCrres_numero_apelacion = new Ext.form.TextField({
        id:'txtCrres_numero_apelacion',
        name:'txtCrres_numero_apelacion',
        fieldLabel :'N\u00famero',
        anchor:'98%'
    });
    /**
     * Ext.form.TextField NOMBRE DEL DOCUMENTO ADJUNTO
     */
    var txtCrres_nombre_adjunto_apelac = new Ext.form.TextField({
        id:'txtCrres_nombre_adjunto_apelac',
        name:'txtCrres_nombre_adjunto_apelac',
        fieldLabel :'Nombre adjunto',
        anchor:'98%',
        readOnly:true
    });
    /**
     * ARCHIVO DIGITAL ANEXO
     */
    var filCrres_adjunto_apelacion = new Ext.form.FileUploadField({
        id:'filCrres_adjunto_apelacion',
        name:'filCrres_adjunto_apelacion',
        fieldLabel :'Archivo adjunto',
        disabled :false,
        anchor:'100%',
        buttonCfg: {
            text: '',
            iconCls: 'iconAdjunto'
        }
    });
    /**
     * Ext.form.NumberField ESTADO DE LA RESOLUCION:
     0 - ESPERANDO VOTACION
     1 - APROBADA
     2 - NEGADA
     3 - EJECUTADA
     4 - ANULADA
     */
    var cbxCrres_estado_resolucion = new Ext.form.ComboBox({
        id:'cbxCrres_estado_resolucion',
        name:'cbxCrres_estado_resolucion',
        store: dsEstadoResolucion,
        fieldLabel :'Estado',
        width:'150',
        disabled: true,
        mode:'local',
        editable: false,
        submitValue:false,
        triggerAction:'all',
        emptyText : 'Seleccione una opcion '

    });
    cbxCrres_estado_resolucion.setValue(0);
    //////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////
    var cmAdjunto = new Ext.grid.ColumnModel([
        {
            dataIndex:'CRADJ_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hideable:false,
            hidden:true
        },{
            dataIndex:'CRADJ_NOMBRE_ADJUNTO',
            header:'Nombre adjunto',
            width:150,
            sortable:true
        }
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_adjunto por un campo especifico.
     */
    var gsCgg_res_resolucion_adjunto = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_resolucion",
            method:"selectResolucionAdjunto",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
            id:'CRADJ_CODIGO',
            root:'dataSet'
        },[  {
            name:'CRADJ_CODIGO'
        },{
            name:'CRADJ_NOMBRE_ADJUNTO'
        }
        ]),
        baseParams:{
            inCrres_codigo:'',
            format:"JSON"
        }
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_adjunto en un formato tabular de filas y columnas.
     */
    var grdCgg_res_adjuntos = new Ext.grid.GridPanel({
        id: 'grdCgg_res_adjuntos',
        cm: cmAdjunto,
        height:250,
        store:gsCgg_res_resolucion_adjunto,
        //store: new Ext.data.JsonStore({}),
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
            id: 'btnAgregarAdjuntoTranseunte',
            iconCls: 'iconNuevo',
            handler: function(){
                var coleccion = {};
                //  tmpListadoEliminar= '[]';
                var datos = "<div width='100%'><INPUT TYPE='file' id='ful" + grdCgg_res_adjuntos.getStore().getCount() + "' size='25' name='inResolucionAdjuntos'/></div> ";

                //coleccion['CRADJ_CODIGO'] =  grdCgg_res_adjuntos.getStore().getCount();
                coleccion['CRADJ_CODIGO'] =  "KEYGEN";
                coleccion['CRADJ_NOMBRE_ADJUNTO'] = datos;

                var recordAdjunto = new Ext.data.Record(coleccion, grdCgg_res_adjuntos.getStore().getCount());
                grdCgg_res_adjuntos.getStore().add(recordAdjunto);
            }
        }, {
            id: 'btnEliminarAdjuntoTranseunte',
            iconCls: 'iconEliminar',
            handler: function(){
                var seleccionado = grdCgg_res_adjuntos.getSelectionModel().getSelected();
                if(seleccionado !=null){
                    if(seleccionado.get('CRADJ_CODIGO')== "KEYGEN")
                    {
                        grdCgg_res_adjuntos.getStore().remove(seleccionado);

                    }else
                    {
                        function SWRCgg_res_adj(btn){
                            if (btn=='yes')
                            {
                                lisEliAdjuntos.push(seleccionado.get('CRADJ_CODIGO'));
                                tmpListadoEliminar = Ext.util.JSON.encode(lisEliAdjuntos);
                               // alert("hola"+tmpListadoEliminar);
                                grdCgg_res_adjuntos.getStore().remove(seleccionado);
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

        },'-',{
                    xtype:'button',
                    iconCls:'iconVer',
                    tooltip:'Ver documento',
                    listeners:{
                        click:function(){
                        	var tmpRecord = grdCgg_res_adjuntos.getSelectionModel().getSelected();
                            if (tmpRecord && tmpRecord.data.CRADJ_CODIGO != 'KEYGEN'){
                                var url1 = URL_DOC_VIEWER+'?table=cgg_res_adjunto&keyc=cradj_codigo&keyv='+tmpRecord.data.CRADJ_CODIGO+'&column=cradj_archivo_adjunto&fn='+tmpRecord.data.CRADJ_NOMBRE_ADJUNTO+'&request=view';
                                window.open(url1);
                            }
                        }
                    }
                },{
                    xtype:'button',
                    iconCls:'iconDescargar',
                    tooltip:'Descargar documento',
                    listeners:{
                        click:function(){
                            var tmpRecord = grdCgg_res_adjuntos.getSelectionModel().getSelected();
                            if (tmpRecord && tmpRecord.data.CRADJ_CODIGO != 'KEYGEN'){
                                var url2 = URL_DOC_VIEWER+'?table=cgg_res_adjunto&keyc=cradj_codigo&keyv='+tmpRecord.data.CRADJ_CODIGO+'&column=cradj_archivo_adjunto&fn='+tmpRecord.data.CRADJ_NOMBRE_ADJUNTO+'&request=download';
                                window.open(url2);
                            }
                        }
                    }

                }]

    });
    //////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_resolucion
     */
    var btnGuardarCgg_res_resolucion = new Ext.Button({
        id:'btnGuardarCgg_res_resolucion',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_res_resolucion.getForm().isValid()==false){
                    return;
                }
                if (filCrres_adjunto_resolucion.getValue() && filCrres_adjunto_resolucion.getValue().length>0)
                    txtCrres_nombre_adjunto_resol.setValue(filCrres_adjunto_resolucion.getValue());
                if (filCrres_adjunto_apelacion.getValue())
                    txtCrres_nombre_adjunto_apelac.setValue(filCrres_adjunto_apelacion.getValue());
                if(isEdit && dtCrres_fecha_apelacion.getValue()){
                    tmpFecha=dtCrres_fecha_apelacion.getValue().format('d/m/Y');
                }
                else{
                    tmpFecha= new Date().format('d/m/Y');
                }
               // alert(lisEliAdjuntos.length);
                if(lisEliAdjuntos.length<=0){
                    tmpListadoEliminar= '[]';
                }
                pnlCgg_res_resolucion.getEl().mask('Espere un momento por favor.<br>El tiempo de respuesta depender\u00E1 del tama\u00F1o de sus archivos adjuntos.', 'x-mask-loading');
                Ext.getCmp('pnlCgg_res_resolucion').getForm().submit({
                    url:URL_WS+"Cgg_res_resolucionSRV",
                    success:function(fp,o){
                        Ext.Msg.show({
                            title:tituloCgg_res_resolucion,
                            msg: 'La informaci\u00f3n de la Resoluci\u00f3n ha sido almacenada.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.INFO
                        });winFrmCgg_res_resolucion.close();
                    },
                    failure:function(o){
                        Ext.Msg.show({
                            title:tituloCgg_res_resolucion,
                            msg: 'La informaci\u00f3n de la Resoluci\u00f3n no ha podido ser almacenada.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.ERROR
                        });
                    },
                    params:{
                        request:INSENTENCIA_CGG_RES_RESOLUCION,
                        dtCrres_fecha_apelacion: tmpFecha,
						crres_tipo_resolucion:cbxCrres_tipo_resolucion.getValue(),
						crres_estado_resolucion:cbxCrres_estado_resolucion.getValue(),
                        txtCrtra_codigo:tmpCrtra_codigo,
                        txtCrssc_codigo:tmpCrssc_codigo,
                        inEliCradj_codigo:tmpListadoEliminar
                    }
                });
            }
        }
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_resolucion.
     */
    var btnCancelarCgg_res_resolucion = new Ext.Button({
        id:'btnCancelarCgg_res_resolucion',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_res_resolucion.getForm().reset();
                pnlCgg_res_adjuntos_obser.getForm().reset();
                pnlCgg_res_apelacion.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_resolucion.
     */
    var btnCerrarCgg_res_resolucion = new Ext.Button({
        id:'btnCerrarCgg_res_resolucion',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_res_resolucion.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel para el tipo de resolucion de winFrmCgg_res_resolucion.
     */
    var pnlCgg_res_tipo_resolucion = new Ext.Panel({
        layout:'column',
        items:[{columnWidth:.6,layout:'form',items:[cbxCrres_tipo_resolucion]},
            {columnWidth:.4,layout:'form',items:[{xtype:'panel',labelWidth:45,layout:'column', id:'pnlTramites',hidden:true,
                items:[{columnWidth:.9,layout:'form',items:[txtCrtra_codigo]}]}]}
        ]
    });
    /**
     * Ext.form.FormPanel Panel para los tipos de votos de winFrmCgg_res_resolucion.
     */

    var pnlfsCgg_res_voto = new Ext.form.FieldSet({
        id:'pnlfsCgg_res_voto',
        title:'Votos',
        collapsible:false,
        region:'center',
        labelWidth :90,
        height:60,
        width:640,
        layout:'column',
        items:[{columnWidth:.32,labelWidth :70,layout:'form',width:50,items:[numCrres_votos_aprobacion]},
            {columnWidth:.32,labelWidth :65,layout:'form',width:50,items:[numCrres_votos_negacion]},
            {columnWidth:.36,labelWidth :80,layout:'form',width:50,items:[numCrres_votos_abstencion]}
        ]
    });
    /**
     * Ext.form.FormPanel Panel para el reemplazo de las resoluciones de winFrmCgg_res_resolucion.
     */
    var pnlCgg_res_reemplazo = new Ext.Panel({
        hidden:true,
        layout:'column',
        items:[{columnWidth:.37,layout:'form',items:[txtCrres_resolucion_reemplaza]},
            {columnWidth:.63,layout:'form',items:[btnCrres_codigoCgg_res_resolucion]}
        ]
    });
    /**
     * Ext.form.FormPanel Panel para los tab con las fechas de la resolucion de winFrmCgg_res_resolucion.
     */
    var pnlfsCgg_res_fecha = new Ext.form.FieldSet({
        id:'pnlfsCgg_res_fecha',
        title:'Fecha',
        collapsible:true,
        //region:'center',
        height:60,
        labelWidth :100,
        layout:'form',
        items:[{xtype:'panel',layout:'column',
            items:[
                {columnWidth:.5,layout:'form',labelWidth :50,items:[dtCrres_fecha_emision]},
                {columnWidth:.5,layout:'form',labelWidth :60,items:[dtCrres_fecha_ejecucion]}
                ]}
        ]

    });
    var pnlfsAdjunto = new Ext.form.FieldSet({
        id:'pnlfsAdjunto',
        title:'Adjunto de resoluci\u00f3n propuesta',
        collapsible:true,
        region:'center',
        height:100,
        labelWidth:80,
        layout:'form',
        fileUpload:true,
        items:[{
                xtype:'panel',layout:'column',items:[
                {columnWidth:.8,layout:'form',items:[filCrres_adjunto_resolucion]},
                {columnWidth:.2,layout:'hbox',items:[{
                    xtype:'button',
                    iconCls:'iconVer',
                    tooltip:'Ver documento',
                    listeners:{
                        click:function()
                        {
                            if (txtCrres_nombre_adjunto_resol.getValue() && isEdit)
                            {
                                var url1 = URL_DOC_VIEWER+'?table=cgg_res_resolucion&keyc=crres_codigo&keyv='+txtCrres_codigo.getValue() +'&column=crres_adjunto_resolucion&fn='+txtCrres_nombre_adjunto_resol.getValue()+'&request=view';
                                window.open(url1);
                            }
                        }
                    }

                },{
                    xtype:'button',
                    iconCls:'iconDescargar',
                    tooltip:'Descargar documento',
                    listeners:{
                        click:function()
                        {
                            if (txtCrres_nombre_adjunto_resol.getValue() && isEdit)
                            {
                                var url2 = URL_DOC_VIEWER+'?table=cgg_res_resolucion&keyc=crres_codigo&keyv='+txtCrres_codigo.getValue() +'&column=crres_adjunto_resolucion&fn='+txtCrres_nombre_adjunto_resol.getValue()+'&request=download';
                                window.open(url2);
                            }
                        }
                    }

                }]}
            ]
            },txtCrres_descripcion_adjunto]
    });
    /**
     * Ext.form.FormPanel Panel para los el tab de winFrmCgg_res_resolucion.
     */
    var pnlCgg_res_adjuntos_obser = new Ext.Panel({
        frame:true,
        labelWidth :100,
        title:'Otros',
        layout:'form',
        fileUpload:true,
        items:[pnlfsCgg_res_fecha,pnlfsAdjunto]
    });

    /**
     * Ext.form.FormPanel Panel para los el tab de winFrmCgg_res_resolucion.
     */
    var pnlCgg_res_adjuntos = new Ext.Panel({
        frame:true,
        labelWidth :100,
        title:'Adjuntos',
        layout:'form',
        fileUpload:true,
        items:[grdCgg_res_adjuntos]
    });
    /**
     * Ext.form.FormPanel Panel para los el tab de winFrmCgg_res_resolucion.
     */
    var pnlCgg_res_apelacion = new Ext.Panel({
        frame:true,
        labelWidth :100,
        title:'Apelaci\u00f3n',
        layout:'form',
        height:150,
        disabled : true,
        items:[txtCrres_numero_apelacion,dtCrres_fecha_apelacion,txtCrres_extracto_apelacion,{
                xtype:'panel',layout:'column',items:[
                {columnWidth:.8,layout:'form',items:[filCrres_adjunto_apelacion]},
                {columnWidth:.2,layout:'hbox',items:[{
                    xtype:'button',
                    iconCls:'iconVer',
                    tooltip:'Ver documento',
                    listeners:{
                        click:function(){
                            if (txtCrres_nombre_adjunto_apelac.getValue() && isEdit){
                                var url1 = URL_DOC_VIEWER+'?table=cgg_res_resolucion&keyc=crres_codigo&keyv='+txtCrres_codigo.getValue() +'&column=crres_adjunto_apelacion&fn='+txtCrres_nombre_adjunto_apelac.getValue()+'&request=view';
                                window.open(url1);
                            }
                        }
                    }

                },{
                    xtype:'button',
                    iconCls:'iconDescargar',
                    tooltip:'Descargar documento',
                    listeners:{
                        click:function(){
                            if (txtCrres_nombre_adjunto_apelac.getValue() && isEdit){
                                var url2 = URL_DOC_VIEWER+'?table=cgg_res_resolucion&keyc=crres_codigo&keyv='+txtCrres_codigo.getValue() +'&column=crres_adjunto_apelacion&fn='+txtCrres_nombre_adjunto_apelac.getValue()+'&request=download';
                                window.open(url2);
                            }
                        }
                    }

                }]}
            ]
            }],
        listeners:{
            beforeshow :function(pnlCgg_res_apelacion) {
                /**
                 * Funcion que permite mostrar el numero de Apelacion
                 */
                if (txtCrres_numero_apelacion.getValue.length==0){
                    //  generarNumeroApelacion();



                }
            }}
    });
    /**
     * Funcion que permite mostrar el numero de Apelacion
     */
    function generarNumeroApelacion(){
        function callBackGenerarApelacion(a){
            txtCrres_numero_apelacion.setValue(a);
        }
        SOAPClient.invoke(urlCgg_res_resolucion,'numeroApelacion',false, false, callBackGenerarApelacion);
    }

    /**
     * Ext.form.FormPanel TabPanel para los demas controles de winFrmCgg_res_resolucion.
     */
    var tblOrdenar = new Ext.TabPanel({
        activeTab:0,
        frame:true,
        region:'center',
        height:253,
        items:[pnlCgg_res_adjuntos_obser, pnlCgg_res_adjuntos, pnlCgg_res_apelacion,txtCrres_observaciones]
    });
	
	var pnlResolucion = new Ext.Panel({
		frame:true,
		height:216,
		region:'north',
		layout:'form',
		items:[txtCrres_codigo,txtCrssc_codigo,txtCrres_numero_resolucion,pnlCgg_res_tipo_resolucion,txtCrres_extracto_resolucion,cbxCrres_estado_resolucion,pnlfsCgg_res_voto,pnlCgg_res_reemplazo]
	});
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_resolucion.
     */
    var pnlCgg_res_resolucion = new Ext.form.FormPanel({
        labelWidth :80,
        region:'center',
        layout:'border',
        id:'pnlCgg_res_resolucion',
        fileUpload:true,
        items:[pnlResolucion,tblOrdenar]

    });
    /**
     * Funcion que permite mostrar el numero de Resolucion
     */
    /*function generarNumeroResolucion(){
        function callBackGenerarResolucion(r){
            txtCrres_numero_resolucion.setValue(r);
        }
		var param = new SOAPClientParameters();
		param.add('inCisla_codigo', tmpUserSession.getUserData().CISLA_CODIGO);
        SOAPClient.invoke(urlCgg_res_resolucion,'numeroResolucion', param, false, callBackGenerarResolucion);
    }
    generarNumeroResolucion()

    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_resolucion.
     */
    var winFrmCgg_res_resolucion = new Ext.Window({
        id:'winFrmCgg_res_resolucion',
        title:tituloCgg_res_resolucion,
        tbar:getPanelTitulo(tituloCgg_res_resolucion,descCgg_res_resolucion),
        items:[pnlCgg_res_resolucion],
        layout:'border',
        modal:true,
        resizable:true,
        width:680,
        minWidth:400,
        height:550,
        maximizable:false,
        minimizable:false,
        constrain:true,
        bbar:[btnGuardarCgg_res_resolucion,btnCancelarCgg_res_resolucion,'->',btnCerrarCgg_res_resolucion]
    });

    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_resolucion.
     */
    function cargarCgg_res_resolucionCtrls(){
        if(inRecordCgg_res_resolucion){
            txtCrres_codigo.setValue(inRecordCgg_res_resolucion.get('CRRES_CODIGO'));
            txtCrtra_codigo.setValue(inRecordCgg_res_resolucion.get('NUMERO'));
            tmpCrtra_codigo =inRecordCgg_res_resolucion.get('CRTRA_CODIGO');
            txtCrssc_codigo.setValue(inRecordCgg_res_resolucion.get('NUMERO_SESION'));
            tmpCrssc_codigo =inRecordCgg_res_resolucion.get('CRSSC_CODIGO');
            txtCrres_numero_resolucion.setValue(inRecordCgg_res_resolucion.get('CRRES_NUMERO_RESOLUCION'))
            cbxCrres_tipo_resolucion.setValue(inRecordCgg_res_resolucion.get('CRRES_TIPO'));
            txtCrres_observaciones.setValue(inRecordCgg_res_resolucion.get('CRRES_OBSERVACIONES'));
            txtCrres_extracto_resolucion.setValue(inRecordCgg_res_resolucion.get('CRRES_EXTRACTO_RESOLUCION'));
            numCrres_votos_aprobacion.setValue(inRecordCgg_res_resolucion.get('CRRES_VOTOS_APROBACION'));
            numCrres_votos_negacion.setValue(inRecordCgg_res_resolucion.get('CRRES_VOTOS_NEGACION'));
            numCrres_votos_abstencion.setValue(inRecordCgg_res_resolucion.get('CRRES_VOTOS_ABSTENCION'));
            dtCrres_fecha_emision.setValue(truncDate(inRecordCgg_res_resolucion.get('CRRES_FECHA_EMISION')));
            dtCrres_fecha_ejecucion.setValue(truncDate(inRecordCgg_res_resolucion.get('CRRES_FECHA_EJECUCION')));
            dtCrres_fecha_anulacion.setValue(truncDate(inRecordCgg_res_resolucion.get('CRRES_FECHA_ANULACION')));
            txtCrres_resolucion_reemplaza.setValue(inRecordCgg_res_resolucion.get('CRRES_RESOLUCION_REEMPLAZA'));
            txtCrres_nombre_adjunto_resol.setValue(inRecordCgg_res_resolucion.get('CRRES_NOMBRE_ADJUNTO_RESOL'));
            txtCrres_descripcion_adjunto.setValue(inRecordCgg_res_resolucion.get('CRRES_DESCRIPCION_ADJUNTO'));
            if(inRecordCgg_res_resolucion.data.CRRES_FECHA_APELACION.length > 0)
            	dtCrres_fecha_apelacion.setValue(Date.parse(inRecordCgg_res_resolucion.get('CRRES_FECHA_APELACION').substr(0,inRecordCgg_res_resolucion.get('CRRES_FECHA_APELACION').lastIndexOf('.'))));
            txtCrres_extracto_apelacion.setValue(inRecordCgg_res_resolucion.get('CRRES_EXTRACTO_APELACION'));
            txtCrres_numero_apelacion.setValue(inRecordCgg_res_resolucion.get('CRRES_NUMERO_APELACION'));
            txtCrres_nombre_adjunto_apelac.setValue(inRecordCgg_res_resolucion.get('CRRES_NOMBRE_ADJUNTO_APELAC'));
            filCrres_adjunto_apelacion.setValue(inRecordCgg_res_resolucion.get('CRRES_NOMBRE_ADJUNTO_APELAC'));
            cbxCrres_estado_resolucion.setValue(inRecordCgg_res_resolucion.get('CRRES_ESTADO_RESOLUCION'));
            isEdit = true;
            pnlCgg_res_reemplazo.setVisible(true);
            pnlCgg_res_apelacion.enable();
            if(txtCrres_nombre_adjunto_resol.getValue().length > 0)
		filCrres_adjunto_resolucion.setValue(txtCrres_nombre_adjunto_resol.getValue());
            txtCrres_numero_resolucion.setValue(inRecordCgg_res_resolucion.get('CRRES_NUMERO_RESOLUCION'));
			
            if(txtCrres_numero_resolucion.getValue(inRecordCgg_res_resolucion.get('CRRES_NUMERO_RESOLUCION'))==null){
                generarNumeroResolucion();
            }
            // HABILITAR EL CONTROL EL  cbxCrres_estado_resolucion
            cbxCrres_estado_resolucion.setDisabled(isEdit);
			cbxCrres_tipo_resolucion.setDisabled(isEdit);
            if(cbxCrres_tipo_resolucion.getValue()==1){
                Ext.getCmp("pnlTramites").setVisible(true);
            }
            gsCgg_res_resolucion_adjunto.reload({
                params:{
                    inCrres_codigo:txtCrres_codigo.getValue(),
                    format:TypeFormat.JSON
                }
            });
            if ( inRecordCgg_res_resolucion.get('CRRES_NUMERO_APELACION')== null){
                generarNumeroApelacion();
            }else{
                txtCrres_numero_apelacion.setValue(inRecordCgg_res_resolucion.get('CRRES_NUMERO_APELACION'));
            }
        }
    }


    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_resolucion.
     * @returns ventana winFrmCgg_res_resolucion.
     * @base FrmCgg_res_resolucion.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_resolucion;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_resolucion.
     * @base FrmCgg_res_resolucion.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_resolucionCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_resolucion desde una instancia.
 */
FrmCgg_res_resolucion.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_resolucion desde una instancia.
 */
FrmCgg_res_resolucion.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_resolucion,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_resolucion.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_resolucion desde una instancia.
 */
FrmCgg_res_resolucion.prototype.loadData = function(){
    this.loadData();
}
