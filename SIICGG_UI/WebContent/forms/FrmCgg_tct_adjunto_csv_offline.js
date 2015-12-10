/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_tct_adjunto_CSVOFF_offline.
 * @constructor
 * @base FrmListadoCgg_tct_adjunto_CSVOFF_offline
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_tct_adjunto_CSVOFF_offline(inDesktop) {
    var urlCgg_tct_adjunto_CSVOFF_offline = URL_WS + "Cgg_tct_adjunto_CSVOFF_offline";
    var tituloCgg_tct_adjunto_CSVOFF_offline = 'Cargar archivo CSV del m\u00F3dulo fuera de l\u00EDnea';
    var descCgg_tct_adjunto_CSVOFF_offline = 'El formulario permite cargar y almacenar archivos CSV al sistema desde el m\u00F3dulo fuera de l\u00EDnea';
    var isEdit = false;
    var reg  = null;
    var tmpNumeroDocumento;
    var tmpCarpt_codigo_origen;
    var tmpUserSesion = new UserSession();
    var tmpCusu_nombre =  tmpUserSesion.getUserName().trim();
    var tmpCrper_codigo;

    IN_SENTENCIA_Cgg_tct_adjunto_CSVOFF_offline="insert";
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO CSVOFF
     */
    var txtCtadcoff_codigo = new Ext.form.TextField({
        id: 'txtCtadcoff_codigo',
        name: 'txtCtadcoff_codigo',
        fieldLabel: 'Codigo',
        anchor: '98%',
        value: "KEYGEN",
        hidden: true,
        hideLabel: true
    });
    /**
     * Ext.form.TextField NOMBRE DEL DOCUMENTO ADJUNTO
     */
    var txtCtadcoff_nombre_adjunto = new Ext.form.TextField({
        id: 'txtCtadcoff_nombre_adjunto',
        name: 'txtCtadcoff_nombre_adjunto',
        fieldLabel: 'Nombre',
        anchor: '98%',
        hidden:true
    });
    /**
     * Ext.form.TextField DESCRIPCION DEL DOCUMENTO ADJUNTO
     */
    var txtCtadcoff_descripcion_adjunto = new Ext.form.TextField({
        id: 'txtCtadcoff_descripcion_adjunto',
        name: 'txtCtadcoff_descripcion_adjunto',
        fieldLabel: 'Observaci\u00F3n',
        anchor: '98%'
    });
    /**
     * Ext.form.DateField FECHA DE REGISTRO DEL ARCHIVO DIGITAL
     */
    var dtCtadcoff_fecha_registro = new Ext.form.DateField({
        id: 'dtCtadcoff_fecha_registro',
        name: 'dtCtadcoff_fecha_registro',
        fieldLabel: 'Fecha registro',
        format: 'd/m/Y',
        value: new Date(),
        submitValue:false,
        hidden:true
    });
    function submitFormulario(){
        var v = filCtadcoff_adjunto.getValue();
        pnlCgg_tct_adjunto_CSVOFF_offline.getForm().submit({
            url: URL_WS + "Cgg_tct_adjunto_csv_offlineSRV",
            waitMsg: 'Subiendo archivo...',
            params: {
                request: "VALIDAR_FILE",
                dtCtadcoff_fecha_registro:dtCtadcoff_fecha_registro.getValue().format('d-m-Y H:i:s')
            },
            success: function (fp, o) {
                if (v && v != '') {
                    var lenStr=v.length;
                    txtCtadcoff_nombre_adjunto.setValue(v.substring(0,lenStr-4));
                }
                storeLstDatosCSVOFF.proxy  = new Ext.data.MemoryProxy(o.result.data);
                storeLstDatosCSVOFF.reload();
                var selCSVOFF = grdLstDatosCSVOFF.getSelectionModel().getSelections();
            },
            failure: function (fp,o) {
                Ext.Msg.show({
                    title: tituloCgg_tct_adjunto_CSVOFF_offline,
                    msg: o.result.msg+" Favor verificar el archivo.",
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.ERROR
                });
                pnlCgg_tct_adjunto_CSVOFF_offline.getForm().reset();
                grdLstDatosCSVOFF.getStore().removeAll();
                btnGuardarCgg_tct_adjunto_CSVOFF_offline.disable();
            }
        });
    }
    /**
     * DOCUMENTO DIGITAL ANEXO EN FORMATO CSVOFF
     */
    var filCtadcoff_adjunto = new Ext.form.FileUploadField({
        id: 'filCtadcoff_adjunto',
        name: 'filCtadcoff_adjunto',
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
                var v = filCtadcoff_adjunto.getValue();
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
                        pnlCgg_tct_adjunto_CSVOFF_offline.getForm().reset();
                        grdLstDatosCSVOFF.getStore().removeAll();
                        btnGuardarCgg_tct_adjunto_CSVOFF_offline.disable();
                    }
                }
            }
        }
    });

    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_tct_adjunto_CSVOFF_offline
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
    var xgrdLstDatosCSVOFF = Ext.grid;
    var sm = new xgrdLstDatosCSVOFF.CheckboxSelectionModel({
        singleSelect:false
    });

    var cmLstDatosCSVOFF = new xgrdLstDatosCSVOFF.ColumnModel([
        sm,
        {dataIndex:'CODIGO_USUARIO',header:'CODIGO_USUARIO',width:40,sortable:true},
        {dataIndex:'NOMBRES',header:'NOMBRES',width:100,sortable:true},
        {dataIndex:'APELLIDOS',header:'APELLIDOS',width:100,sortable:true},
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
        },
        {dataIndex:'NUMPASS',header:'NUMPASS',width:75,sortable:true,renderer:rndFNumPass},
        {dataIndex:'NACIONALIDAD',header:'NACIONALIDAD',width:35,sortable:true,hidden:true},
        {dataIndex:'PAIS',header:'PAIS',width:35,sortable:true},
        {dataIndex:'SEXO',header:'SEXO',width:40,sortable:true},
        {dataIndex:'FNACIMIENTO',header:'FNACIMIENTO',width:80,sortable:true,renderer:rndFNacimiento},
        {dataIndex:'FINGRESO',header:'FINGRESO',width:75,sortable:true,renderer:rndFIngreso},
        {dataIndex:'FSALIDA',header:'FSALIDA',width:75,sortable:true,renderer:rndFSalida},
        {dataIndex:'AEROLINEA',header:'AEROLINEA',width:80,sortable:true},
        {dataIndex:'AORIGEN',header:'AORIGEN',width:80,sortable:true},
        {dataIndex:'AEROARRIBO',header:'AEROARRIBO',width:80,sortable:true},
        {dataIndex:'HOSPEDAJE',header:'HOSPEDAJE',width:80,sortable:true},
        {dataIndex:'ACTIVIDAD',header:'ACTIVIDAD',width:80,sortable:true},
        {dataIndex:'TIPO_DOCUMENTO',header:'ACTIVIDAD',width:80,sortable:true},
        {dataIndex:'NUMERO_REGISTRO',header:'ACTIVIDAD',width:80,sortable:true},
        {dataIndex:'OBSERVACION',header:'ACTIVIDAD',width:80,sortable:true},
        {dataIndex:'CODIGO_TRAMITE',header:'ACTIVIDAD',width:80,sortable:true},
        {dataIndex:'FREGISTRO',header:'ACTIVIDAD',width:80,sortable:true},
        {dataIndex:'ESTADO',header:'ACTIVIDAD',width:80,sortable:true},
        {dataIndex:'FIMPRESION',header:'ACTIVIDAD',width:80,sortable:true}
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

    var storeLstDatosCSVOFF = new Ext.data.Store({
        reader : new Ext.data.JsonReader({}, [
            {name:"CODIGO_USUARIO"},
            {name:"NOMBRES"},
            {name:"APELLIDOS"},
            {name:"NUMPASS"},
            {name:"NACIONALIDAD"},
            {name:"PAIS"},
            {name:"SEXO"},
            {name:"FNACIMIENTO",type:"date",dateFormat:'Y-m-d'},
            {name:"FINGRESO",type:"date",dateFormat:'Y-m-d'},
            {name:"FSALIDA",type:"date",dateFormat:'Y-m-d'},
            {name:"AEROLINEA"},
            {name:"AORIGEN"},
            {name:"AEROARRIBO"},
            {name:"HOSPEDAJE"},
            {name:"ACTIVIDAD"},
            {name:"TIPO_DOCUMENTO"},
            {name:"NUMERO_REGISTRO"},
            {name:"OBSERVACION"},
            {name:"CODIGO_TRAMITE"},
            {name:"FREGISTRO",type:"date",dateFormat:'Y-m-d'},
            {name:"ESTADO"},
            {name:"FIMPRESION",type:"date",dateFormat:'Y-m-d'},
            {name:"validacion"}
        ]),
        proxy  : new Ext.data.MemoryProxy([]),
        listeners:{
            load:function( store, recs){
                var record;
                var arrRows= new Array();
                for (var i=0;i<store.getCount();i++){
                    record = store.getAt(i);
                    if(record.get("validacion").resultadoValidacion != 'false')
                      arrRows.push(i);
                }
				sm.unlock();
                sm.selectRows(arrRows);
                sm.lock();
                btnGuardarCgg_tct_adjunto_CSVOFF_offline.enable();
			}
        }
    });


    var grdLstDatosCSVOFF = new xgrdLstDatosCSVOFF.GridPanel({
        store:storeLstDatosCSVOFF,
        cm:cmLstDatosCSVOFF,
        loadMask:{msg:"Cargando..."},
        region:"center",
        sm: sm
    });

    var btnGuardarCgg_tct_adjunto_CSVOFF_offline = new Ext.Button({
        id: 'btnGuardarCgg_tct_adjunto_CSVOFF_offline',
        text: 'Guardar',
        iconCls: 'iconGuardar',
        disabled :true,
        listeners: {
            click: function () {
                if (grdLstDatosCSVOFF.getSelectionModel().getSelections().length==0){
                    Ext.Msg.show({
                        title:"Aviso",
                        msg: 'por favor seleccione por lo menos un registro',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.INFO
                    });
                    return;
                }
                
				try{
					function CallBackCgg_tct_registro1(r){
						var tmpResponse = Ext.util.JSON.decode(r);
						winFrmCgg_tct_adjunto_CSVOFF_offline.getEl().unmask();
						if(tmpResponse.success){
							Ext.Msg.show({
								title:"Exito",
								msg: 'La informaci\u00f3n de Tct registro ha sido almacenada.<br>El n\u00famero de grupo es: <span class="numeroTramite">'+tmpResponse.msg+'</span>',
								buttons: Ext.Msg.OK,
								icon: Ext.MessageBox.INFO
							});
							winFrmCgg_tct_adjunto_CSVOFF_offline.close();
						}else{
							Ext.Msg.show({
								title:"Exito",
								msg: 'La informaci\u00f3n de Tct registro no ha podido ser almacenada. '+(r.message?r.message:r),
								buttons: Ext.Msg.OK,
								icon: Ext.MessageBox.ERROR
							});
						}
					}
					var selCSVOFF = grdLstDatosCSVOFF.getSelectionModel().getSelections()[0];
					var arrActividad = selCSVOFF.get("ACTIVIDAD").split(",");
					var storeActividad = "[";
					for (k=0;k<arrActividad.length;k++){
						storeActividad+= (k==0)?"":",";
						storeActividad+="{\"CTACT_CODIGO\":\""+arrActividad[k]+"\",\"CTACT_NOMBRE\":\"\"}";
					}
					storeActividad += "]";
					var arrHospedaje = selCSVOFF.get("HOSPEDAJE").split(",");
					var storeHospedaje = "[";
					for (k=0;k<arrHospedaje.length;k++){
						storeHospedaje+= (k==0)?"":",";
						storeHospedaje+="{\"CTTHJ_CODIGO\":\""+arrHospedaje[k]+"\",\"CTTHJ_NOMBRE\":\"\"}";
					}
					storeHospedaje += "]";
					var storePersonas = "[";
					for (k=0;k<grdLstDatosCSVOFF.getSelectionModel().getSelections().length ;k++){
						var selCSVOFFTmp = grdLstDatosCSVOFF.getSelectionModel().getSelections()[k];
						storePersonas += k==0?"":",";
						storePersonas += "{\"CRPER_CODIGO\":\"\",\"CRDID_CODIGO\":\""+selCSVOFFTmp.get("TIPO_DOCUMENTO")+"\","+"\"CRPER_NUM_DOC_IDENTIFIC\":\""+selCSVOFFTmp.get("NUMPASS")+"\",\"CRPER_NOMBRES\":\""+selCSVOFFTmp.get("NOMBRES")+"\","+
								"\"CRPER_APELLIDO_PATERNO\":\""+selCSVOFFTmp.get("APELLIDOS")+"\",\"CRPER_GENERO\":"+((selCSVOFFTmp.get("SEXO")=="M")?0:1)+
								",\"CGNCN_CODIGO\":\""+selCSVOFFTmp.get("NACIONALIDAD")+"\",\"CGG_CPAIS_CODIGO\":\""+selCSVOFFTmp.get("PAIS")+"\",\"CRPER_FECHA_NACIMIENTO\":\""+Ext.util.Format.date(selCSVOFFTmp.get("FNACIMIENTO"),"Y-m-d H:i:s.u")+"\","+
								"\"CKESP_CODIGO\":\""+SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','CONF35')).get('CGCNF_VALOR_CADENA')+"\",\"CRTRA_CODIGO\":\""+selCSVOFFTmp.get("CODIGO_TRAMITE")+"\",\"CRTRA_NUMERO\":\"\","+
								"\"CTREG_NUMERO\":\""+selCSVOFFTmp.get("NUMERO_REGISTRO")+"\","+
								"\"CTREG_IMPRESION_ESPECIE\":\""+Ext.util.Format.date(selCSVOFFTmp.get("FIMPRESION"),"Y-m-d H:i:s.u")+"\","+
								"\"CTREG_FECHA_REGISTRO\":\""+Ext.util.Format.date(selCSVOFFTmp.get("FREGISTRO"),"Y-m-d H:i:s.u")+"\","+
								"\"CTREG_ESTADO_REGISTRO\":"+selCSVOFFTmp.get("ESTADO")+"}";
					}
					storePersonas += "]";

					winFrmCgg_tct_adjunto_CSVOFF_offline.getEl().mask('Guardando...', 'x-mask-loading');
					var param = new SOAPClientParameters();
					param.add('inCarpt_codigo', selCSVOFF.get("AORIGEN"));
					param.add('inCgg_carpt_codigo',selCSVOFF.get("AEROARRIBO"));
					param.add('inCraln_codigo',selCSVOFF.get("AEROLINEA"));
					param.add('inCtreg_numero',"");
					param.add('inCtreg_fecha_preregistro',new Date().format(TypeDateFormat.Custom));
					param.add('inCtreg_fecha_ingreso',Ext.util.Format.date(selCSVOFF.get("FINGRESO"),TypeDateFormat.Custom));
					param.add('inCtreg_codigo_barras','0');
					param.add('inCtreg_fecha_salida',Ext.util.Format.date(selCSVOFF.get("FSALIDA"),TypeDateFormat.Custom));
					param.add('inHospedaje_JSON',storeHospedaje);
					param.add('inActividad_JSON',storeActividad);
					param.add('inPersona_JSON',storePersonas);
					SOAPClient.invoke(URL_WS+"Cgg_tct_registro","insert",param, true, CallBackCgg_tct_registro1);

				}catch(inErr){
					alert(inErr);
				}
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_tct_adjunto_CSVOFF_offline.
     */
    var btnCerrarCgg_tct_adjunto_CSVOFF_offline = new Ext.Button({
        id: 'btnCerrarCgg_tct_adjunto_CSVOFF_offline',
        text: 'Cerrar',
        iconCls: 'iconCerrar',
        listeners: {
            click: function () {
                winFrmCgg_tct_adjunto_CSVOFF_offline.close();
            }
        }
    });

    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_tct_adjunto_CSVOFF_offline.
     */
    var pnlCgg_tct_adjunto_CSVOFF_offline = new Ext.form.FormPanel({
        frame: true,
        fileUpload: true,
        labelWidth: 75,
        height:70,
        region:"north",
        items: [txtCtadcoff_codigo,
            filCtadcoff_adjunto,
            txtCtadcoff_nombre_adjunto,
            txtCtadcoff_descripcion_adjunto,
            dtCtadcoff_fecha_registro
        ]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_tct_adjunto_CSVOFF_offline.
     */
    var tmpObjReglasValidacionCSVOFF;
    if (inDesktop)
        var winFrmCgg_tct_adjunto_CSVOFF_offline = inDesktop.createWindow({
            id: 'winFrmCgg_tct_adjunto_CSVOFF_offline',
            title: tituloCgg_tct_adjunto_CSVOFF_offline,
            width: 680,
            height:500,
            minWidth: 400,
            minHeight: 400,
            maximizable: true,
            minimizable: true,
            constrain: true,
            layout:"border",
            tbar: getPanelTitulo(tituloCgg_tct_adjunto_CSVOFF_offline, descCgg_tct_adjunto_CSVOFF_offline),
            items: [pnlCgg_tct_adjunto_CSVOFF_offline,grdLstDatosCSVOFF],
            bbar: [btnGuardarCgg_tct_adjunto_CSVOFF_offline, '->', btnCerrarCgg_tct_adjunto_CSVOFF_offline],
        });
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_tct_adjunto_CSVOFF_offline.
     * @returns ventana winFrmCgg_tct_adjunto_CSVOFF_offline.
     * @base FrmCgg_tct_adjunto_CSVOFF_offline.prototype.show
     */
    this.getWindow = function () {
        return winFrmCgg_tct_adjunto_CSVOFF_offline;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_tct_adjunto_CSVOFF_offline.
     * @base FrmCgg_tct_adjunto_CSVOFF_offline.prototype.loadData
     */
    this.loadData = function () {
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_tct_adjunto_CSVOFF_offline desde una instancia.
 */
FrmCgg_tct_adjunto_CSVOFF_offline.prototype.show = function () {
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_tct_adjunto_CSVOFF_offline desde una instancia.
 */
FrmCgg_tct_adjunto_CSVOFF_offline.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_tct_adjunto_CSVOFF_offline,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_tct_adjunto_CSVOFF_offline.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_tct_adjunto_CSVOFF_offline desde una instancia.
 */
FrmCgg_tct_adjunto_CSVOFF_offline.prototype.loadData = function () {
    this.loadData();
}