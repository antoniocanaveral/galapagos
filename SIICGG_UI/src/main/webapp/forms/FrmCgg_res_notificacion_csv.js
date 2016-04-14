/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros 
 * @constructor
 * @base 
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_notificacion_csv(inDesktop) {
    var urlCgg_res_notificacion_csv= URL_WS + "Cgg_res_notificacion_csv";
    var tituloCgg_res_notificacion_csv= 'Cargar archivo CSV';
    var descCgg_res_notificacion_csv= 'El formulario permite cargar y almacenar archivos CSV al sistema';
    var isEdit = false;
    var reg  = null;
    
    var tmpUserSesion = new UserSession();
    var tmpCusu_nombre =  tmpUserSesion.getUserName().trim();
    var tmpCrper_codigo;

    IN_SENTENCIA_CGG_RES_NOTIFICACION_CSV="insert";
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO CSV
     */
    var txtCtadc_codigo = new Ext.form.TextField({
        id: 'txtCtadc_codigo',
        name: 'txtCtadc_codigo',
        fieldLabel: 'Codigo',
        anchor: '98%',
        value: "KEYGEN",
        hidden: true,
        hideLabel: true
    });
    /**
     * Ext.form.TextField NOMBRE DEL DOCUMENTO ADJUNTO
     */
    var txtCtadc_nombre_adjunto = new Ext.form.TextField({
        id: 'txtCtadc_nombre_adjunto',
        name: 'txtCtadc_nombre_adjunto',
        fieldLabel: 'Nombre',
        anchor: '98%',
        hidden:true
    });
    /**
     * Ext.form.TextField DESCRIPCION DEL DOCUMENTO ADJUNTO
     */
    var txtCtadc_descripcion_adjunto = new Ext.form.TextField({
        id: 'txtCtadc_descripcion_adjunto',
        name: 'txtCtadc_descripcion_adjunto',
        fieldLabel: 'Descripci\u00F3n',
        anchor: '98%'
    });
    /**
     * Ext.form.DateField FECHA DE REGISTRO DEL ARCHIVO DIGITAL
     */
    var dtCtadc_fecha_registro = new Ext.form.DateField({
        id: 'dtCtadc_fecha_registro',
        name: 'dtCtadc_fecha_registro',
        fieldLabel: 'Fecha registro',
        format: 'd/m/Y',
        value: new Date(),
        submitValue:false,
        hidden:true
    });
	
   function submitFormulario(){
        var v = filCrnot_adjunto.getValue();
        pnlCgg_res_notificacion_csv.getForm().submit({
            url: URL_WS + "Cgg_res_notificacion_csvSRV",
            waitMsg: 'Subiendo archivo...',
            params: {
                request: "VALIDAR_FILE",
            dtCtadc_fecha_registro:dtCtadc_fecha_registro.getValue().format('d-m-Y H:i:s')
            },
            success: function (fp, o) {
                if (v && v != '') {
                    var lenStr=v.length;
                    txtCtadc_nombre_adjunto.setValue(v.substring(0,lenStr-4));
                }
                storeLstNotificacionCSV.proxy  = new Ext.data.MemoryProxy(o.result.data);
                storeLstNotificacionCSV.reload();
                var selCSV = grdLstNotificacionCSV.getSelectionModel().getSelections();
            },
            failure: function (fp,o) {
                Ext.Msg.show({
                    title: tituloCgg_res_notificacion_csv,
                    msg: o.result.msg+" Favor verificar el archivo.",
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.ERROR
                });
                pnlCgg_res_notificacion_csv.getForm().reset();
                grdLstNotificacionCSV.getStore().removeAll();
                btnGuardarCgg_res_notificacion_csv.disable();
            }
        });
    }

    /**
     * DOCUMENTO DIGITAL ANEXO EN FORMATO CSV
     */
    var filCrnot_adjunto = new Ext.form.FileUploadField({
        id: 'filCrnot_adjunto',
        name: 'filCrnot_adjunto',
        fieldLabel: 'Archivo',
        anchor: '90%',
        emptyText: 'Seleccione un archivo CSV por favor...',
        disabled: false,
        buttonCfg: {
            text: '',
            iconCls: 'iconAdjunto'
        },
        listeners:{
            fileselected:function(){
                var v = filCrnot_adjunto.getValue();
                if (v && v != '') {
                    var strExtension = v.substring(v.length,v.length-3);
                    if (strExtension.toUpperCase()!="CSV")
                        Ext.MessageBox.confirm('Confirme', 'El archivo seleccionado parece no corresponder a uno CSV. Desea continuar de todos modos?', showResult);
                    else
                        submitFormulario();
                }else
                    return;
                function showResult(btn){
                    if (btn=="yes")
                        submitFormulario();
                    else{
                        pnlCgg_res_notificacion_csv.getForm().reset();
                        grdLstNotificacionCSV.getStore().removeAll();
                        btnGuardarCgg_res_notificacion_csv.disable();
                    }
                }
            }
        }
    });

    var xgrdLstNotificacionCSV = Ext.grid;
	 var sm = new xgrdLstNotificacionCSV.CheckboxSelectionModel({
        singleSelect:false
    });

    var cmLstNotificacionCSV = new xgrdLstNotificacionCSV.ColumnModel([
		sm,
        {dataIndex:'CRTNT_CODIGO',header:'Codigo tipo notificacion',width:120,sortable:true},
		{dataIndex:'CRPER_CODIGO',header:'Persona',width:100,sortable:true},
		{dataIndex:'CCTN_CODIGO',header:'Canton',width:100,sortable:true},
		{dataIndex:'CROSG_CODIGO',header:'Oficial',width:100,sortable:true},
		{dataIndex:'CRNOT_NUMERO_NOTIFICACION',header:'No. notificaci\u00f3n',width:100,sortable:true},
		{dataIndex:'CRNOT_FECHA_NOTIFICACION',header:'Fecha',width:100,sortable:true},
		{dataIndex:'CRNOT_ESTADO_NOTIFICACION',header:'Estado',width:100,sortable:true}
    ]);
  
    var storeLstNotificacionCSV = new Ext.data.Store({
        reader : new Ext.data.JsonReader({}, [
            
	     { name:"CRTNT_CODIGO"},
		 {name:"CRPER_CODIGO"},
		 {name:"CCTN_CODIGO"},
		 {name:"CROSG_CODIGO"},
		 {name:"CRNOT_NUMERO_NOTIFICACION"},
		 {name:"CRNOT_FECHA_NOTIFICACION"},
		 {name:"CRNOT_ESTADO_NOTIFICACION"}
        ]),
        proxy  : new Ext.data.MemoryProxy([]),
        listeners:{
            load:function( store, recs){
                /*var record;
                var arrRows= new Array();

                for (var i=0;i<store.getCount();i++)
                {
                    record = store.getAt(i);
                    if(record.get("validacion").resultadoValidacion != 'false')
                    {
                      arrRows.push(i);

                    }
                }
                sm.selectRows(arrRows);
                sm.lock();*/

                    btnGuardarCgg_res_notificacion_csv.enable();
			}
        }
    });


    var grdLstNotificacionCSV = new xgrdLstNotificacionCSV.GridPanel({
        store:storeLstNotificacionCSV,
        cm:cmLstNotificacionCSV,
		viewConfig:{forceFit:true},
        loadMask:{msg:"Cargando..."},
        region:"center",
		sm: sm
        
    });

    var btnGuardarCgg_res_notificacion_csv= new Ext.Button({
        id: 'btnGuardarCgg_tct_ingreso_salida_csv',
        text: 'Guardar',
        iconCls: 'iconGuardar',
        disabled :true,
        listeners: {
            click: function () {
                if (grdLstNotificacionCSV.getSelectionModel().getSelections().length==0){
                    Ext.Msg.show({
                        title:"Aviso",
                        msg: 'por favor seleccione por lo menos un registro',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.INFO
                    });
                    return;
                }                  

                        try{
                            function CallBackCgg_res_notificacion1(r){
							winFrmCgg_res_notificacion_csv.getEl().unmask();
								var tmpResponse = Ext.util.JSON.decode(r);
                                if(tmpResponse.success){
                                    Ext.Msg.show({
                                        title:"Exito",
                                        msg: 'La informaci\u00f3n de notificacion ha sido almacenada.<br>El n\u00famero de grupo es: <span class="numeroTramite">'+tmpResponse.msg+'</span>',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    winFrmCgg_res_notificacion_csv.close();
                                }else{
                                    Ext.Msg.show({
                                        title:"Aviso",
                                        msg: 'La informaci\u00f3n de notificacion no ha podido ser almacenada. '+(r.message?r.message:r),
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
                            }
                            
							var selCSV = grdLstNotificacionCSV.getSelectionModel().getSelections()[0];
                            winFrmCgg_res_notificacion_csv.getEl().mask('Guardando...', 'x-mask-loading');   
							var param = new SOAPClientParameters();
							param.add('inCrtnt_codigo',selCSV.get("CRTNT_CODIGO"));
							param.add('inCrper_codigo',selCSV.get("CRPER_CODIGO"));
							param.add('inCusu_codigo',null);
							param.add('inCgg_cusu_codigo',null);
							param.add('inCrres_codigo',null);
							param.add('inCrden_codigo',null);
							param.add('inCctn_codigo',selCSV.get("CCTN_CODIGO"));
							param.add('inCrosg_codigo',selCSV.get("CROSG_CODIGO"));
							param.add('inCgg_crosg_codigo',null);
							param.add('inCrnot_numero_notificacion',selCSV.get("CRNOT_NUMERO_NOTIFICACION"));
							param.add('inCrnot_fecha_notificacion',selCSV.get("CRNOT_FECHA_NOTIFICACION"));
							param.add('inCrnot_lugar_notificacion',selCSV.get("CRNOT_LUGAR_NOTIFICACION"));
							param.add('inCrnot_referencia',selCSV.get("CRNOT_REFERENCIA"));
							param.add('inCrnot_observacion',null);
							param.add('inCrnot_estado_notificacion',selCSV.get("CRNOT_ESTADO_NOTIFICACION"));
							param.add('inCrnot_regularizacion',0);
							param.add('inCrnot_fecha_audiencia',null);
							param.add('inCrnot_extracto_audiencia',null);
							param.add('inCrnot_observacion_audiencia',null);
							param.add('inCrnot_procede_notificacion',null);
							param.add('inCrnot_descripcion_adjunto_aud',null);
							param.add('inCrnot_nombre_adjunto_audiencia',null);
							param.add('inCrnot_adjunto_audiencia',null);
							param.add('inCrnot_fecha_salida_volunt',null);
							param.add('inCrnot_fecha_expulsion',null);
											
                            
                            SOAPClient.invoke(URL_WS+"Cgg_res_notificacion","insert",param, true, CallBackCgg_res_notificacion1);

                        }catch(inErr){
                            alert(inErr);
                        }
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_tct_ingreso_salida_csv.
     */
    var btnCerrarCgg_res_notificacion_csv= new Ext.Button({
        id: 'btnCerrarCgg_res_notificacion_csv',
        text: 'Cerrar',
        iconCls: 'iconCerrar',
        listeners: {
            click: function () {
                winFrmCgg_res_notificacion_csv.close();
            }
        }
    });

    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_tct_ingreso_salida_csv.
     */
    var pnlCgg_res_notificacion_csv= new Ext.form.FormPanel({
        frame: true,
        fileUpload: true,
        labelWidth: 100,
        height:150,
        region:"north",
        items: [txtCtadc_codigo,
            filCrnot_adjunto,
            txtCtadc_nombre_adjunto,
            txtCtadc_descripcion_adjunto
        ]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_tct_adjunto_csv.
     */
   
    if (inDesktop)
        var winCgg_res_notificacion_csv = inDesktop.createWindow({
            id: 'winFrmCgg_res_notificacion_csv',
            title: tituloCgg_res_notificacion_csv,
            width: 680,
            height:500,
            minWidth: 400,
            minHeight: 400,
            maximizable: true,
            minimizable: true,
            constrain: true,
            layout:"border",
            tbar: getPanelTitulo(tituloCgg_res_notificacion_csv, descCgg_res_notificacion_csv),
            items: [pnlCgg_res_notificacion_csv,grdLstNotificacionCSV],
            bbar: [btnGuardarCgg_res_notificacion_csv, '->', btnCerrarCgg_res_notificacion_csv],
            listeners:{
                show:function(){

                   
                }
            }
        });
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_tct_ingreso_salida_csv.
     * @returns ventana winFrmCgg_tct_ingreso_salida_csv.
     * @base FrmCgg_tct_ingreso_salida_csv.prototype.show
     */
    this.getWindow = function () {
        return winFrmCgg_res_notificacion_csv;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_tct_ingreso_salida_csv.
     * @base FrmCgg_tct_ingreso_salida_csv.prototype.loadData
     */
    this.loadData = function () {
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_tct_ingreso_salida_csv desde una instancia.
 */
FrmCgg_res_notificacion_csv.prototype.show = function () {
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_tct_ingreso_salida_csv desde una instancia.
 */
FrmCgg_res_notificacion_csv.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_tct_ingreso_salida_csv,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_notificacion_csv.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_tct_ingreso_salida_csv desde una instancia.
 */
FrmCgg_res_notificacion_csv.prototype.loadData = function () {
    this.loadData();
}