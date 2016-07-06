/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_tct_adjunto_csv.
 * @constructor
 * @base FrmListadoCgg_tct_adjunto_csv
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_tct_adjunto_csv(inDesktop) {
    var urlCgg_tct_adjunto_csv = URL_WS + "Cgg_tct_adjunto_csv";
    var tituloCgg_tct_adjunto_csv = 'Cargar archivo CSV';
    var descCgg_tct_adjunto_csv = 'El formulario permite cargar y almacenar archivos CSV al sistema';
    var isEdit = false;
    var reg  = null;
    var tmpNumeroDocumento;
    var tmpCarpt_codigo_origen;
    var tmpUserSesion = new UserSession();
    var tmpCusu_nombre =  tmpUserSesion.getUserName().trim();
    var tmpCrper_codigo;

    IN_SENTENCIA_CGG_TCT_ADJUNTO_CSV="insert";
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
        var v = filCtadc_adjunto.getValue();
        pnlCgg_tct_adjunto_csv.getForm().submit({
            url: URL_WS + "Cgg_tct_adjunto_csvSRV",
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
                storeLstDatosCSV.proxy  = new Ext.data.MemoryProxy(o.result.data);
                storeLstDatosCSV.reload();
                var selCSV = grdLstDatosCSV.getSelectionModel().getSelections();
            },
            failure: function (fp,o) {
                Ext.Msg.show({
                    title: tituloCgg_tct_adjunto_csv,
                    msg: o.result.msg+" Favor verificar el archivo.",
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.ERROR
                });
                pnlCgg_tct_adjunto_csv.getForm().reset();
                grdLstDatosCSV.getStore().removeAll();
                btnGuardarCgg_tct_adjunto_csv.disable();
            }
        });
    }
    /**
     * DOCUMENTO DIGITAL ANEXO EN FORMATO CSV
     */
    var filCtadc_adjunto = new Ext.form.FileUploadField({
        id: 'filCtadc_adjunto',
        name: 'filCtadc_adjunto',
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
                var v = filCtadc_adjunto.getValue();
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
                        pnlCgg_tct_adjunto_csv.getForm().reset();
                        grdLstDatosCSV.getStore().removeAll();
                        btnGuardarCgg_tct_adjunto_csv.disable();
                    }
                }
            }
        }
    });

    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_tct_adjunto_csv
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
    var sm = new xgrdLstDatosCSV.CheckboxSelectionModel({
        singleSelect:false
    });

    var cmLstDatosCSV = new xgrdLstDatosCSV.ColumnModel([
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
        {dataIndex:'ACTIVIDAD',header:'ACTIVIDAD',width:80,sortable:true}
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
            {name:"validacion"}
        ]),
        proxy  : new Ext.data.MemoryProxy([]),
        listeners:{
            load:function( store, recs){
                var record;
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
                sm.lock();

                    btnGuardarCgg_tct_adjunto_csv.enable();
    

                /*
                 grdLstDatosCSV.getEl().mask("Validando datos de personas...",'x-mask-loading');
                 btnGuardarCgg_tct_adjunto_csv.disable();
                 var k=0;
                 var TmpMsg ="";
                 var arrRows= new Array();
                 sm.unlock();
                 function validarReglas(r){
                 if (r) {
                 var h = eval("("+r+")");
                 if (h.resultadoValidacion == "true")	arrRows.push(k-1);
                 recs[k-1].set("MSG",h);
                 recs[k-1].commit();
                 }else if (k>0){
                 recs[k-1].set("MSG",{resultadoValidacion:"true"});
                 recs[k-1].commit();
                 arrRows.push(k-1);
                 }
                 if (recs.length<=k){
                 sm.selectRows(arrRows);
                 sm.lock();
                 btnGuardarCgg_tct_adjunto_csv.enable();
                 grdLstDatosCSV.getEl().unmask();
                 return Ext.util.JSON.decode(r);
                 }
                 var tmpRec = recs[k];

                 tmpCarpt_codigo_origen = tmpRec.get("AORIGEN");
                 tmpNumeroDocumento = tmpRec.get("NUMPASS");
                 k++;
                 //Obtiene el copdigo de la persona
                 function CallBackCgg_tct_csv_persona(r){
                 var tmpSelect = Ext.util.JSON.decode(r);
                 if (tmpSelect.length > 0){
                 tmpCrper_codigo = tmpSelect[0].CRPER_CODIGO;
                 if (tmpCrper_codigo){
                 try{
                 var objReglasValidacion  = Ext.decode(tmpObjReglasValidacionCsv );
                 for(var i=0;i<objReglasValidacion.length;i++){
                 var objTmp = Ext.decode(objReglasValidacion[i].CRTSE_CAMPO_EVALUACION)[0];
                 for (var key in objTmp)	objTmp[key] = eval(objTmp[key]);
                 objReglasValidacion[i].CRTSE_CAMPO_EVALUACION ='['+Ext.encode(objTmp)+']';
                 }
                 objReglasValidacion=Ext.encode(objReglasValidacion);
                 var param = new SOAPClientParameters();
                 param.add('inJSON_reglas_validacion',objReglasValidacion);
                 param.add('jsonData',null);
                 SOAPClient.invoke(URL_WS+'Cgg_regla_validacion' ,'ejecutarReglaTipoSolicitud',param, true, validarReglas);
                 }catch(inErr){
                 Ext.MsgPopup.msg("Error", "No se ha podido validar la informaci\u00f3n a almacenar.\nError:"+inErr);
                 pnlOrganizacion.getEl().unmask();
                 return false;
                 }
                 }else
                 validarReglas();
                 }else
                 validarReglas();
                 }
                 var param = new SOAPClientParameters();
                 param.add('inCrper_num_doc_identific',tmpNumeroDocumento);
                 param.add('format',TypeFormat.JSON);
                 SOAPClient.invoke(URL_WS+"Cgg_res_persona",'selectNumDoc',param, true, CallBackCgg_tct_csv_persona);
                 }
                 validarReglas();
                 */}
        }
    });


    var grdLstDatosCSV = new xgrdLstDatosCSV.GridPanel({
        store:storeLstDatosCSV,
        cm:cmLstDatosCSV,
        loadMask:{msg:"Cargando..."},
        region:"center",
        sm: sm
    });

    var btnGuardarCgg_tct_adjunto_csv = new Ext.Button({
        id: 'btnGuardarCgg_tct_adjunto_csv',
        text: 'Guardar',
        iconCls: 'iconGuardar',
        disabled :true,
        listeners: {
            click: function () {
                if (grdLstDatosCSV.getSelectionModel().getSelections().length==0){
                    Ext.Msg.show({
                        title:"Aviso",
                        msg: 'por favor seleccione por lo menos un registro',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.INFO
                    });
                    return;
                }
                pnlCgg_tct_adjunto_csv.getForm().submit({
                    url: URL_WS + "Cgg_tct_adjunto_csvSRV",
                    waitMsg: 'Guardardando informaci\u00f3n...',
                    params: {
                        request: IN_SENTENCIA_CGG_TCT_ADJUNTO_CSV,
                        dtCtadc_fecha_registro:dtCtadc_fecha_registro.getValue().format('d-m-Y H:i:s')
                    },
                    success: function (fp, o) {
                        try{
                            function CallBackCgg_tct_registro1(r){
								var tmpResponse = Ext.util.JSON.decode(r);
                                winFrmCgg_tct_adjunto_csv.getEl().unmask();
                                if(tmpResponse.success){
                                    Ext.Msg.show({
                                        title:"Exito",
                                        msg: 'La informaci\u00f3n de Tct registro ha sido almacenada.<br>El n\u00famero de grupo es: <span class="numeroTramite">'+tmpResponse.msg+'</span>',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    winFrmCgg_tct_adjunto_csv.close();
                                }else{
                                    Ext.Msg.show({
                                        title:"Exito",
                                        msg: 'La informaci\u00f3n de Tct registro no ha podido ser almacenada. '+(r.message?r.message:r),
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
                            }
                            var selCSV = grdLstDatosCSV.getSelectionModel().getSelections()[0];
                            var arrActividad = selCSV.get("ACTIVIDAD").split(",");
                            var storeActividad = "[";
                            for (k=0;k<arrActividad.length;k++){
                                storeActividad+= (k==0)?"":",";
                                storeActividad+="{\"CTACT_CODIGO\":\""+arrActividad[k]+"\",\"CTACT_NOMBRE\":\"\"}";
                            }
                            storeActividad += "]";
                            var arrHospedaje = selCSV.get("HOSPEDAJE").split(",");
                            var storeHospedaje = "[";
                            for (k=0;k<arrHospedaje.length;k++){
                                storeHospedaje+= (k==0)?"":",";
                                storeHospedaje+="{\"CTTHJ_CODIGO\":\""+arrHospedaje[k]+"\",\"CTTHJ_NOMBRE\":\"\"}";
                            }
                            storeHospedaje += "]";
                            var storePersonas = "[";
                            for (k=0;k<grdLstDatosCSV.getSelectionModel().getSelections().length ;k++){
                                var selCSVTmp = grdLstDatosCSV.getSelectionModel().getSelections()[k];
                                storePersonas += k==0?"":",";
                                storePersonas += "{\"CRPER_CODIGO\":\"\",\"CRDID_CODIGO\":\"2\","+"\"CRPER_NUM_DOC_IDENTIFIC\":\""+selCSVTmp.get("NUMPASS")+"\",\"CRPER_NOMBRES\":\""+selCSVTmp.get("NOMBRES")+"\","+
                                        "\"CRPER_APELLIDO_PATERNO\":\""+selCSVTmp.get("APELLIDOS")+"\",\"CRPER_GENERO\":"+((selCSVTmp.get("SEXO")=="M")?0:1)+
                                        ",\"CGNCN_CODIGO\":\""+selCSVTmp.get("NACIONALIDAD")+"\",\"CGG_CPAIS_CODIGO\":\""+selCSVTmp.get("PAIS")+"\",\"CRPER_FECHA_NACIMIENTO\":\""+Ext.util.Format.date(selCSVTmp.get("FNACIMIENTO"),"Y-m-d H:i:s.u")+"\","+
                                        "\"CKESP_CODIGO\":\""+SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','CONF35')).get('CGCNF_VALOR_CADENA')+"\",\"CRTRA_CODIGO\":\"\",\"CRTRA_NUMERO\":\"\","+
                                        "\"CTREG_OBSERVACION\":\"\","+
                                        "\"CTREG_ESTADO_REGISTRO\":0}";
                            }
                            storePersonas += "]";

                            winFrmCgg_tct_adjunto_csv.getEl().mask('Guardando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCarpt_codigo', selCSV.get("AORIGEN"));
                            param.add('inCgg_carpt_codigo',selCSV.get("AEROARRIBO"));
                            param.add('inCraln_codigo',selCSV.get("AEROLINEA"));
                            param.add('inCtreg_numero',"");
                            param.add('inCtreg_fecha_preregistro',new Date().format(TypeDateFormat.Custom));
                            param.add('inCtreg_fecha_ingreso',Ext.util.Format.date(selCSV.get("FINGRESO"),TypeDateFormat.Custom));
                            param.add('inCtreg_codigo_barras','0');
                            param.add('inCtreg_fecha_salida',Ext.util.Format.date(selCSV.get("FSALIDA"),TypeDateFormat.Custom));
                            param.add('inHospedaje_JSON',storeHospedaje);
                            param.add('inActividad_JSON',storeActividad);
                            param.add('inPersona_JSON',storePersonas);
                            SOAPClient.invoke(URL_WS+"Cgg_tct_registro","insert",param, true, CallBackCgg_tct_registro1);

                        }catch(inErr){
                            alert(inErr);
                        }
                    },
                    failure: function (o,e) {
                        Ext.Msg.show({
                            title: tituloCgg_tct_adjunto_csv,
                            msg: 'La informaci\u00f3n de Tct adjunto csv no ha podido ser almacenada.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.ERROR
                        });
                    }
                });
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_tct_adjunto_csv.
     */
    var btnCerrarCgg_tct_adjunto_csv = new Ext.Button({
        id: 'btnCerrarCgg_tct_adjunto_csv',
        text: 'Cerrar',
        iconCls: 'iconCerrar',
        listeners: {
            click: function () {
                winFrmCgg_tct_adjunto_csv.close();
            }
        }
    });

    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_tct_adjunto_csv.
     */
    var pnlCgg_tct_adjunto_csv = new Ext.form.FormPanel({
        frame: true,
        fileUpload: true,
        labelWidth: 75,
        height:70,
        region:"north",
        items: [txtCtadc_codigo,
            filCtadc_adjunto,
            txtCtadc_nombre_adjunto,
            txtCtadc_descripcion_adjunto,
            dtCtadc_fecha_registro
        ]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_tct_adjunto_csv.
     */
    var tmpObjReglasValidacionCsv;
    if (inDesktop)
        var winFrmCgg_tct_adjunto_csv = inDesktop.createWindow({
            id: 'winFrmCgg_tct_adjunto_csv',
            title: tituloCgg_tct_adjunto_csv,
            width: 680,
            height:500,
            minWidth: 400,
            minHeight: 400,
            maximizable: true,
            minimizable: true,
            constrain: true,
            layout:"border",
            tbar: getPanelTitulo(tituloCgg_tct_adjunto_csv, descCgg_tct_adjunto_csv),
            items: [pnlCgg_tct_adjunto_csv,grdLstDatosCSV],
            bbar: [btnGuardarCgg_tct_adjunto_csv, '->', btnCerrarCgg_tct_adjunto_csv],
            listeners:{
                show:function(){

                    /*function listarReglasValidacion(inCopvl_formulario){
                     function CallBackReglasTipoSolicitud(r){
                     try{

                     tmpObjReglasValidacionCsv  = r;

                     }catch(inErr){
                     tmpObjReglasValidacionCsv =[];
                     }
                     }
                     var param = new SOAPClientParameters();
                     param.add('inCopvl_formulario',inCopvl_formulario);
                     param.add('format',TypeFormat.JSON);
                     SOAPClient.invoke(URL_WS+'Cgg_regla_validacion' ,'selectOperacionValidacionByForm',param, true,CallBackReglasTipoSolicitud);
                     }
                     listarReglasValidacion("FrmCgg_tct_registro");*/
                }
            }
        });
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_tct_adjunto_csv.
     * @returns ventana winFrmCgg_tct_adjunto_csv.
     * @base FrmCgg_tct_adjunto_csv.prototype.show
     */
    this.getWindow = function () {
        return winFrmCgg_tct_adjunto_csv;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_tct_adjunto_csv.
     * @base FrmCgg_tct_adjunto_csv.prototype.loadData
     */
    this.loadData = function () {
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_tct_adjunto_csv desde una instancia.
 */
FrmCgg_tct_adjunto_csv.prototype.show = function () {
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_tct_adjunto_csv desde una instancia.
 */
FrmCgg_tct_adjunto_csv.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_tct_adjunto_csv,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_tct_adjunto_csv.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_tct_adjunto_csv desde una instancia.
 */
FrmCgg_tct_adjunto_csv.prototype.loadData = function () {
    this.loadData();
}