/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_tct_adjunto_csv.
 * @constructor
 * @base FrmListadoCgg_tct_adjunto_csv
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_tct_ingreso_salida_csv(inDesktop) {
    var urlCgg_tct_ingreso_salida_csv= URL_WS + "Cgg_tct_ingreso_salida_csv";
    var tituloCgg_tct_ingreso_salida_csv= 'Cargar archivo CSV';
    var descCgg_tct_ingreso_salida_csv= 'El formulario permite cargar y almacenar archivos CSV al sistema';
    var isEdit = false;
    var reg  = null;
    var tmpNumeroDocumento;
    var tmpCarpt_codigo_origen;	
    var tmpUserSesion = new UserSession();
	var tmpOperacion = 'INGRESO';
    var tmpCusu_nombre =  tmpUserSesion.getUserName().trim();
    var tmpCrper_codigo;

    IN_SENTENCIA_CGG_TCT_INGRESO_SALIDA_CSV="insert";
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
	
	  /**
     * Ext.form.DateField FECHA DE INGRESO  A LA PROVINCIA
     */
    var dtCrmov_fecha_viaje = new Ext.form.DateField({
        id:'dtCrmov_fecha_viaje',
        name:'dtCrmov_fecha_viaje',
        fieldLabel :'Fecha viaje',
        format :'d/m/Y',
     //   minValue:new Date(),
        value:new Date(),
		maxValue: new Date(),
        listeners:{
            change:function(obj,newValue,oldValue){
                
            }
        }
    });
	
	   /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_aeropuerto por un campo especifico.
     */
    var gsCgg_res_aeropuerto_csv = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_aeropuerto",
            method:"selectAll"
        }),
        reader:new Ext.data.JsonReader({},[
            {name:'CARPT_CODIGO'},
            {name:'CCTN_CODIGO'},
            {name:'CANTON'},
            {name:'CARPT_NOMBRE'},
            {name:'CARPT_TIPO_AEREOPUERTO'}
        ]),
        baseParams:{
            format:"JSON"
        },
		listeners:{
			load:function(){
				loadDefaultData();
			}
		}
    });
	
	function loadDefaultData(){
		cbxCarpt_codigo_csv.setValue(tmpUserSesion.getUserData().CARPT_CODIGO);
	}
	  /**
     * Ext.form.ComboBox IDENTIFICATIVO UNICO DE REGISTRO
     */
   	
	var cbxCarpt_codigo_csv = new Ext.form.ComboBox({
        id:'cbxCarpt_codigo_csv',
        name:'cbxCarpt_codigo_csv',
        store:gsCgg_res_aeropuerto_csv,
        fieldLabel :'Aeropuerto',
        anchor:'50%',
        displayField:'CARPT_NOMBRE',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        editable:true,
        allowBlank :false,
        triggerAction:'all',
        emptyText:'Seleccione una Residencia',
        selectOnFocus:true,
        valueField:'CARPT_CODIGO'
    });
    gsCgg_res_aeropuerto_csv.reload();
	
    function submitFormulario(){
        var v = filCrmov_adjunto.getValue();
        pnlCgg_tct_ingreso_salida_csv.getForm().submit({
            url: URL_WS + "Cgg_tct_ingreso_salida_csvSRV",
            waitMsg: 'Subiendo archivo...',
            params: {
                request: tmpOperacion
            },
            success: function (fp, o) {
                if (v && v != '') {
                    var lenStr=v.length;
                    txtCtadc_nombre_adjunto.setValue(v.substring(0,lenStr-4));
                }
                storeLstDatosCSV.proxy  = new Ext.data.MemoryProxy(o.result.data);
                storeLstDatosCSV.reload();
                var selCSV = grdLstDatosCSV.getSelectionModel().getSelections();
            },
            failure: function (fp,o) {
                Ext.Msg.show({
                    title: tituloCgg_tct_ingreso_salida_csv,
                    msg: o.result.msg+" Favor verificar el archivo.",
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.ERROR
                });
                pnlCgg_tct_ingreso_salida_csv.getForm().reset();
                grdLstDatosCSV.getStore().removeAll();
                btnGuardarCgg_tct_ingreso_salida_csv.disable();
            }
        });
    }
	var rdgTipoOperacion = new Ext.form.RadioGroup({
        id:'rdgTipoOperacion',
        fieldLabel: 'Tipo Operaci\u00f3n',
        itemCls: 'x-check-group-alt',
        items: [
            {
                boxLabel: 'Entrada',
                id:'rbEntrada',
                name: 'rdgTipoOperacion',
                inputValue: TypeOperacionMovilidad.ENTRADA,
                checked: true
            },
            {
                boxLabel: 'Salida',
                id: 'rbSalida',
                name: 'rdgTipoOperacion',
                inputValue: TypeOperacionMovilidad.SALIDA
            }
        ],
        listeners:{
            change: function(group,radio)
            {
                if (radio.getRawValue() == TypeOperacionMovilidad.ENTRADA)
                {
                   grdLstDatosCSV.getColumnModel().setHidden(3, false);
				   grdLstDatosCSV.getColumnModel().setHidden(5, false);
				   tmpOperacion = 'INGRESO';
				    
                }
                else
                {
                   grdLstDatosCSV.getColumnModel().setHidden(3, true);
                   grdLstDatosCSV.getColumnModel().setHidden(5, true);
				   tmpOperacion = 'SALIDA';
                }
				filCrmov_adjunto.reset();
				grdLstDatosCSV.getStore().removeAll();
                btnGuardarCgg_tct_ingreso_salida_csv.disable();
            }
        }

    });
    /**
     * DOCUMENTO DIGITAL ANEXO EN FORMATO CSV
     */
    var filCrmov_adjunto = new Ext.form.FileUploadField({
        id: 'filCrmov_adjunto',
        name: 'filCrmov_adjunto',
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
                var v = filCrmov_adjunto.getValue();
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
                        pnlCgg_tct_ingreso_salida_csv.getForm().reset();
						loadDefaultData();
                        grdLstDatosCSV.getStore().removeAll();
                        btnGuardarCgg_tct_ingreso_salida_csv.disable();
                    }
                }
            }
        }
    });

    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_tct_ingreso_salida_csv
     */
    function rndFNacimiento(v){
        return "<span style='color:black'>"+Ext.util.Format.date(v,"Y-m-d")+"</span>";
    }
    function rndFIngreso(v){
        return "<span style='color:green'>"+Ext.util.Format.date(v,"Y-m-d")+"</span>";
    }
    function rndFSalida(v){
        return "<span style='color:red'>"+Ext.util.Format.date(v,"Y-m-d")+"</span>";
    }
    function rndFNumPass(v){
        return "<span style='font-weight: bold '>"+v+"</span>";
    }
    var xgrdLstDatosCSV = Ext.grid;

    var cmLstDatosCSV = new xgrdLstDatosCSV.ColumnModel([
		new Ext.grid.RowNumberer(),
        {dataIndex:'CODIGO_BARRAS',header:'Codigo Barras',width:120,sortable:true},
		{dataIndex:'AEROLINEA',header:'Aerolinea',width:100,sortable:true},
		{dataIndex:'AEROPUERTO_ORIGEN',header:'Aeropuerto Origen',width:100,sortable:true},       
        {dataIndex:'VUELO',header:'Vuelo',width:50,sortable:true},
		{dataIndex:'FILTRO_NACIONAL',header:'Filtro Nacional',width:100,sortable:true, renderer:function(a,b,rec){
				if (rec.get("FILTRO_NACIONAL")=='true')
				{
					return 'Si';
				}
				else
				{
					return 'No';
				} 
        }},
        {dataIndex:'validacion',header:'MSG',width:30,sortable:true,renderer:function(a,b,rec){
            if (rec.get("validacion")){
                var recTmp = rec.get("validacion").resultadoValidacion;
                var iconTmp =(recTmp == "true")?"iconCell iconOk":"iconCell iconCancelar";
                return "<div class='"+iconTmp+"'></div>";
            }else
                return "<div class='iconCell iconCargando'></div>";
        }},
        {xtype: 'actioncolumn',
            width: 30,
            dataIndex:'',
            header:'\u00a0',
            items: [{
                iconCls: 'iconBuscar',
                tooltip: 'Ver detalle del proceso',
                handler: function(grid, rowIndex, colIndex) {
                    var tmpRecord = grid.getStore().getAt(rowIndex).get("validacion");
                    if (tmpRecord.resultadoValidacion == 'false'){
                        Ext.Msg.show({
                            title:'Error validaci\u00f3n',
                            minWidth:400,
                            msg:'No se puede realizar el registro de la persona.!!<br>'+
                                    'A continuaci\u00f3n el detalle de sus novedades:<br>'+
                                    tplNotificacion.apply(tmpRecord.dataSet),
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.ERROR
                        });
                    }
                }
            }]
        }
    ]);
    var tplNotificacion = new Ext.XTemplate(
            '<table class="CggTemplate" width=300>',
            '<tpl for=".">',
            '<tpl if="CRVAL_APROBADO == &quot;FALSE&quot;">',
            '<tr>' +
                    '<th>{#}.</th>' +
                    '<td><span>{CRVAL_SUGERENCIA}.</span></td>'+
                    '</tr>' +
                    '</tpl>',
            '</tpl></td>'+
                    '</table>'
            );

    var storeLstDatosCSV = new Ext.data.Store({
        reader : new Ext.data.JsonReader({}, [
            {name:"CODIGO_BARRAS"},
			 {name:"AEROPUERTO_ORIGEN"},
            {name:"AEROLINEA"},
            {name:"VUELO"},
            {name:"FILTRO_NACIONAL"},            
            {name:"validacion"}
        ]),
        proxy  : new Ext.data.MemoryProxy([]),
        listeners:{
            load:function( store, recs){
                     btnGuardarCgg_tct_ingreso_salida_csv.enable();
			}
        }
    });


    var grdLstDatosCSV = new xgrdLstDatosCSV.GridPanel({
        store:storeLstDatosCSV,
        cm:cmLstDatosCSV,
		viewConfig:{forceFit:true},
        loadMask:{msg:"Cargando..."},
        region:"center"
        
    });

    var btnGuardarCgg_tct_ingreso_salida_csv= new Ext.Button({
        id: 'btnGuardarCgg_tct_ingreso_salida_csv',
        text: 'Guardar',
        iconCls: 'iconGuardar',
        disabled :true,
        listeners: {
            click: function () {
             	try
				{
						function CallBackCgg_res_movilidad(r) {
						 winFrmCgg_tct_ingreso_salida_csv.getEl().unmask();
                        var tmpResponse = Ext.util.JSON.decode(r);
                        if(tmpResponse.success){
                            Ext.Msg.show({
                                title:tituloCgg_tct_ingreso_salida_csv,
                                msg: 'La informaci\u00f3n de Movilidad ha sido almacenada. <br>Se ha procesado : <span class="numeroTramite">'+tmpResponse.msg+'</span> registro(s)',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            winFrmCgg_tct_ingreso_salida_csv.close();
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_tct_ingreso_salida_csv,
                                msg: 'La informaci\u00f3n de Movilidad no ha podido ser almacenada. ' + (tmpResponse.msg),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                        btnGuardarCgg_tct_ingreso_salida_csv.enable();
						}
                       		btnGuardarCgg_tct_ingreso_salida_csv.disable();
							var personasJSON = grdLstDatosCSV.getStore().getJsonData();
                            winFrmCgg_tct_ingreso_salida_csv.getEl().mask('Guardando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCarpt_codigo',cbxCarpt_codigo_csv.getValue());
                            param.add('inCrmov_tipo_operacion',rdgTipoOperacion.getValue().getRawValue() );
                            param.add('inCrmov_fecha_viaje',dtCrmov_fecha_viaje.getValue().format(TypeDateFormat.Custom));
                            param.add('inPersonaJSON',personasJSON);
                            SOAPClient.invoke(URL_WS+"Cgg_res_movilidad","insertCsv",param, true, CallBackCgg_res_movilidad);

                        }catch(inErr){
                            alert(inErr);
							btnGuardarCgg_tct_ingreso_salida_csv.enable();
                        }
                    }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_tct_ingreso_salida_csv.
     */
    var btnCerrarCgg_tct_ingreso_salida_csv= new Ext.Button({
        id: 'btnCerrarCgg_tct_ingreso_salida_csv',
        text: 'Cerrar',
        iconCls: 'iconCerrar',
        listeners: {
            click: function () {
                winFrmCgg_tct_ingreso_salida_csv.close();
            }
        }
    });

    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_tct_ingreso_salida_csv.
     */
    var pnlCgg_tct_ingreso_salida_csv= new Ext.form.FormPanel({
        frame: true,
        fileUpload: true,
        labelWidth: 100,
        height:150,
        region:"north",
        items: [txtCtadc_codigo,
            filCrmov_adjunto,
            txtCtadc_nombre_adjunto,
            txtCtadc_descripcion_adjunto,
			rdgTipoOperacion,
			dtCrmov_fecha_viaje,
			cbxCarpt_codigo_csv,
            dtCtadc_fecha_registro
        ]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_tct_adjunto_csv.
     */
    var tmpObjReglasValidacionCsv;
    if (inDesktop)
        var winFrmCgg_tct_ingreso_salida_csv = inDesktop.createWindow({
            id: 'winFrmCgg_tct_ingreso_salida_csv',
            title: tituloCgg_tct_ingreso_salida_csv,
            width: 680,
            height:500,
            minWidth: 400,
            minHeight: 400,
            maximizable: true,
            minimizable: true,
            constrain: true,
            layout:"border",
            tbar: getPanelTitulo(tituloCgg_tct_ingreso_salida_csv, descCgg_tct_ingreso_salida_csv),
            items: [pnlCgg_tct_ingreso_salida_csv,grdLstDatosCSV],
            bbar: [btnGuardarCgg_tct_ingreso_salida_csv, '->', btnCerrarCgg_tct_ingreso_salida_csv],
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
        return winFrmCgg_tct_ingreso_salida_csv;
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
FrmCgg_tct_ingreso_salida_csv.prototype.show = function () {
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_tct_ingreso_salida_csv desde una instancia.
 */
FrmCgg_tct_ingreso_salida_csv.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_tct_ingreso_salida_csv,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_tct_ingreso_salida_csv.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_tct_ingreso_salida_csv desde una instancia.
 */
FrmCgg_tct_ingreso_salida_csv.prototype.loadData = function () {
    this.loadData();
}