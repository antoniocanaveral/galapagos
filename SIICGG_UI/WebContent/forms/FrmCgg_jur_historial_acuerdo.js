/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_jur_historial_acuerdo.
 * @param {String} IN_SENTENCIA_CGG_JUR_HISTORIAL_ACUERDO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_JUR_HISTORIAL_ACUERDO Registro de datos de la tabla Cgg_jur_historial_acuerdo.
 * @constructor
 * @base FrmListadoCgg_jur_historial_acuerdo
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_jur_historial_acuerdo(IN_SENTENCIA_CGG_JUR_HISTORIAL_ACUERDO,IN_RECORD_CGG_JUR_HISTORIAL_ACUERDO){
    var inSentenciaCgg_jur_historial_acuerdo = IN_SENTENCIA_CGG_JUR_HISTORIAL_ACUERDO;
    var inRecordCgg_jur_historial_acuerdo=IN_RECORD_CGG_JUR_HISTORIAL_ACUERDO;
    var urlCgg_jur_historial_acuerdo=URL_WS+"Cgg_jur_historial_acuerdo";
    var tituloCgg_jur_historial_acuerdo='Historial Acuerdo';
    var descCgg_jur_historial_acuerdo='El formulario permite administrar la informaci\u00f3n de Historial Acuerdo';
    var isEdit = false;
    var tmpCjacu_codigo1;
    var lisEliAdjuntos2 = new Array ();
    var tmpListadoEliminar2;
    var tmpCjacu_estado_ejecucion_HA;
    var tmpValorEstado = 'false';
    /**
     * new Ext.Panel PANEL PARA LA VISUALIZACION LOS ACUERDOS1
     */
    var pnlAcuerdo1 = new Ext.Panel({
		autoScroll : true,
        tbar:[{type:'button',id:'btnAcuerdo1',text:'Contrato - Convenio ',iconCls:'iconBuscar',handler:function(){
            var tmpAcuerdo1 = new Cgg_jur_acuerdo();
            var objBusqueda = new DlgBusqueda(tmpAcuerdo1.getStoreAcuerdo(), tmpAcuerdo1.getColumnAcuerdo());
            objBusqueda.closeHandler(function () {
                tmpAcuerdo1 = objBusqueda.getSelectedRow();

                if (tmpAcuerdo1) {
                    document.getElementById('divInfoAcuerdo1').innerHTML =tmpInfoAcuerdo1.apply(tmpAcuerdo1.json);
                    tmpCjacu_codigo1=tmpAcuerdo1.get('CJACU_CODIGO');
                    cbxCjacu_estado_ejecucion_HA.setValue(tmpAcuerdo1.get('CJACU_ESTADO_EJECUCION'));
                }
            });
            objBusqueda.show();
        }}],
        //bodyStyle:'padding:0px 0px 0px 0px;',
        frame:true,
        height:160,
        html:'<div id="divInfoAcuerdo1" style="padding:0px 0px 0px 0px;" style ="overflow:auto"></div>'
    });
    /**
     * new Ext.XTemplate XTEMPLATE PARA LA VISUALIZACION DE LA INFORMACION  DE LOS ACUERDOS1 EN EL PANEL pnlAcuerdo1
     */
    var tmpInfoAcuerdo1 = new Ext.XTemplate(
            '<table width="100%" height="100%" cellpadding="0">' +
                    '<tr rowspan="0"><td>' +
                    '<div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Tipo Persona</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif"><tpl if="CJACU_TIPO_PERSONA ==TypeAdversario.PERSONA_NATURAL">'+
                    '<span style="font-weight: bold;">Persona Natural</span>',
            '</tpl>',
            '<tpl if="CJACU_TIPO_PERSONA ==TypeAdversario.PERSONA_JURIDICA">',
            '<b>Persona Juridica</b>',
            '</tpl>',
            '</font></td></tr>' +
                    '<tr rowspan="0">' +
                    '<div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Persona Natural</font></div></td>' +
                    '<td><div class="itemTemplate"><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{PERSONA}</span></div></td>' +
                    '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Persona Jur\u00eddica</font></div></td>' +
                    '<td><div class="itemTemplate"><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{RAZON_SOCIAL}</span></div></td></tr>' +
                    '<tr rowspan="0">' +
                    '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Acuerdo</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">' +
                    '<tpl if="CJACU_TIPO ==TypeTipoAcuerdo.Contrato">'+
                    '<span style="font-weight: bold;">Contrato</span>',
            '</tpl>',
            '<tpl if="CJACU_TIPO ==TypeTipoAcuerdo.Convenio">',
            '<b>Convenio</b>',
            '</tpl>',
            '</font></td>' +
                    '<div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Tipo</font></div></td>' +
                    '<td><div class="itemTemplate"><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{NOMBRE_PROCESO}</span></div></td></tr>' +
                    '<tr rowspan="0">' +
                    '<div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">N\u00f9mero</font></div></td>' +
                    '<td><div class="itemTemplate"><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{CJACU_NUMERO}</span></div></td>' +
                    '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">A\u00f1o</font></div></td>' +
                    '<td><div class="itemTemplate"><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{CJACU_ANIO}</span></div></td></tr>' +
                    '<tr rowspan="0">' +
                    '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif"> Fecha Inicio</font></div></td>' +
                    '<td><div class="itemTemplate"><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{[this.myFecha_Inicio(values.CJACU_FECHA_INICIO)]}</span></div></td>' +
                    '<td><div class="tituloTemplate"> <font face="Arial, Helvetica, sans-serif">Fecha Suscripci\u00f3n</font></div></td>' +
                    '<td><div class="itemTemplate"><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{[this.myFecha_Suscripcion(values.CJACU_FECHA_SUSCRIPCION)]}</span></div></td></tr>' +
                    '</td></tr></table>',
    {
        // XTemplate configuration:
        disableFormats: true,
        // member functions:
        myFecha_Inicio: function(CJACU_FECHA_INICIO){
            return truncDate(CJACU_FECHA_INICIO);
        },
        myFecha_Suscripcion: function(CJACU_FECHA_SUSCRIPCION){
            return truncDate(CJACU_FECHA_SUSCRIPCION);
        }
    }
            );

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DEL HISTORIAL DE ACUERDO
     */
    var txtCjhac_codigo = new Ext.form.TextField({
        id:'txtCjhac_codigo',
        name:'txtCjhac_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });

    /**
     * Ext.form.TextArea DESCRIPCION DEL MOVIMIENTO DEL ACUERDO
     */
    var txtCjhac_descripcion = new Ext.form.TextArea({
        id:'txtCjhac_descripcion',
        name:'txtCjhac_descripcion',
        fieldLabel :'Descripci\u00f3n',
        width:'98%',
        allowBlank :false
    });
    /**
     * Ext.form.TextField NOMBRE DEL RESPONSABLE DE ESTE HISTORIAL DEL ACUERDO
     */
    var txtCjhac_responsable = new Ext.form.TextField({
        id:'txtCjhac_responsable',
        name:'txtCjhac_responsable',
        fieldLabel :'Responsable',
        anchor:'98%'//,
        /*revisar*/
		//readOnly:true
    });
    /**
     * Ext.form.DateField FECHA DE REGISTRO DE OPERACION DEL ACUERDO
     */
    var dtCjhac_fecha = new Ext.form.DateField({
        id:'dtCjhac_fecha',
        name:'dtCjhac_fecha',
        fieldLabel :'Fecha',
        allowBlank :false,
        format :'d/m/Y',
        value:new Date()
    });
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Ext.form.TextField DESCRIP`CION DEL ARCHIVO ADJUNTO
     */
    var txtCjada_descripcionHa = new Ext.form.TextField({
        id:'txtCjada_descripcionHa',
        name:'txtCjada_descripci\u00f3n',
        anchor:'98%',
        allowBlank :false
    });
    /*
     * Ext.ux.grid.RowEditor Edito de filas personalizado para utilizaci?n en el grid de contacto
     */

    var cmAdj_historial_acuerdo1 = new Ext.grid.ColumnModel([
        {dataIndex:'CJADA_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:true},
        {dataIndex:'CJACU_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:true},
        {dataIndex:'CJADA_NOMBRE_ADJUNTO',header:'Nombre adjunto',width:150,sortable:true},
        {dataIndex:'CJADA_DESCRIPCION',header:'Descripcion',width:150,sortable:true,editor:txtCjada_descripcionHa},
        {dataIndex:'CRATE_DATA',header:'CRATE_DATA',width:150,sortable:true,hidden:true,hideable:true}
    ]);

    /*
     * Ext.ux.grid.RowEditor Edito de filas personalizado para utilizaci?n en el grid de Adjunto
     */
    var reAdjuntoHa = new Ext.ux.grid.RowEditor({
        saveText: 'Aceptar',
        cancelText:'Cancelar'
    });
    reAdjuntoHa.stopMonitoring();


    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_adjunto por un campo especifico.
     */
    var gsAdj_historial_acuerdo1 = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_jur_adjunto_acuerdo",
            method:"selectHistorialAcuerdoAdjunto",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
            id:'CRADJ_CODIGO',
            root:'dataSet'
        },[
            {name:'CJADA_CODIGO'},
            {name:'CJACU_CODIGO'},
            {name:'CJADA_NOMBRE_ADJUNTO'},
            {name:'CJADA_DESCRIPCION'}

        ]),
        baseParams:{
            inCjhac_codigo:'',
            format:"JSON"
        }
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_adjunto en un formato tabular de filas y columnas.
     */
    var grdCgg_jur_adjunto_acuerdo1 = new Ext.grid.EditorGridPanel({
        id: 'grdCgg_jur_adjunto_proceso1',
        region: 'south',
        split: true,
        collapsible: true,
        collapsed : true,
        title:'Adjunto',
        animCollapse : false,
        cm: cmAdj_historial_acuerdo1,
        height:160,
        store:gsAdj_historial_acuerdo1,
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
            id: 'btnAgregarAdjuntoAcuerdo',
            iconCls: 'iconNuevo',
            handler: function(){

                var rAdjuntoTemporal;
                var objSubirAdjunto = new FrmCgg_res_adjunto_temporal();
                objSubirAdjunto.closeHandler(function(){
                    var dialogResult = objSubirAdjunto.dialogResult();
                    if(dialogResult  !== null){
                        var tmpRecordPersona = grdCgg_jur_adjunto_acuerdo1.getStore().recordType;
                        reAdjuntoHa.stopEditing();
                        grdCgg_jur_adjunto_acuerdo1.getStore().insert(0,
                                new tmpRecordPersona({
                                    'CJADA_CODIGO':'KEYGEN',
                                    'CJADA_NOMBRE_ADJUNTO':dialogResult.CRATE_NOMBRE,
                                    'CJADA_DESCRIPCION':'',
                                    'CRATE_DATA':dialogResult.CRATE_CODIGO
                                })
                                );
                        grdCgg_jur_adjunto_acuerdo1.getView().refresh();
                        grdCgg_jur_adjunto_acuerdo1.getSelectionModel().selectRow(0);
                        reAdjuntoHa.startEditing(0);
                    }
                });
                objSubirAdjunto.show();

            }

        }, {
            id: 'btnEliminarAdjuntoAcuerdo',
            iconCls: 'iconEliminar',
            handler: function(grid, rowIndex, colIndex) {
                grdCgg_jur_adjunto_acuerdo1.getSelectionModel().selectRow(rowIndex);
                var rAdjuntoRequisito = grdCgg_jur_adjunto_acuerdo1.getSelectionModel().getSelected();
                lisEliAdjuntos2.push(rAdjuntoRequisito.get('CJADA_CODIGO'));
                tmpListadoEliminar2 = Ext.util.JSON.encode(lisEliAdjuntos2);
                //alert("hola"+tmpListadoEliminar);
                grdCgg_jur_adjunto_acuerdo1.getStore().remove(rAdjuntoRequisito);
            }

        },{
            id:'btnVerAdjuntoAcuerdo',
            iconCls:'iconVer',
            listeners:{
                click:function(){
                    var r=grdCgg_jur_adjunto_acuerdo1.getSelectionModel().getSelected();
                    if(r){
					if(r.get('CRATE_DATA')){
							window.open(URL_DOC_VIEWER+'?table=cgg_res_adjunto_temporal&keyc=crate_codigo&keyv='+r.get('CRATE_DATA')+'&column=crate_archivo&fn='+r.get('CJADA_NOMBRE_ADJUNTO')+'&request=view');
						}else{
                        window.open(URL_DOC_VIEWER+'?table=cgg_jur_adjunto_acuerdo&keyc=cjada_codigo&keyv='+r.get('CJADA_CODIGO')+'&column=cjada_adjunto&fn='+r.get('CJADA_NOMBRE_ADJUNTO')+'&request=view');
                }
            }

        }
		}
		},{id:'btnDescargarAdjuntoAcuerdo',
            iconCls:'iconDescargar',
            listeners:{
                click:function(){
                    var r=grdCgg_jur_adjunto_acuerdo1.getSelectionModel().getSelected();
                    if(r)
                        window.open(URL_DOC_VIEWER+'?table=cgg_jur_adjunto_acuerdo&keyc=cjada_codigo&keyv='+r.get('CJADA_CODIGO')+'&column=cjada_adjunto&fn='+r.get('CJADA_NOMBRE_ADJUNTO')+'&request=download');
                }
            }
        }],
        plugins:[reAdjuntoHa]


    });
    var cbxCjacu_estado_ejecucion_HA = new Ext.form.ComboBox({
        id:'cbxCjacu_estado_ejecucion_HA',
        name:'cbxCjacu_estado_ejecucion_HA',
        store: dsEstadoAcuerdo,
        fieldLabel :'Estado',
        anchor:'95%',
        mode:'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione un Estado',
        listeners:
        {
            select:function(combo,record)
            {
                tmpValorEstado= 'true';
            }
        }

    });
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_jur_historial_acuerdo
     */
    var btnGuardarCgg_jur_historial_acuerdo = new Ext.Button({
        id:'btnGuardarCgg_jur_historial_acuerdo',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (!pnlCgg_jur_historial_acuerdo.getForm().isValid()){
                    return;
                }
                try{
                    function CallBackCgg_jur_historial_acuerdo(r){
                        winFrmCgg_jur_historial_acuerdo.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_jur_historial_acuerdo,
                                msg: 'La informaci\u00f3n de Historial Acuerdo ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_jur_historial_acuerdo.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_jur_historial_acuerdo,
                                msg: 'La informaci\u00f3n de Historial Acuerdo no ha podido ser almacenada. '+(r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_jur_historial_acuerdo.getEl().mask('Guardando...', 'x-mask-loading');
                    if(lisEliAdjuntos2.length<=0){
                        tmpListadoEliminar2= '[]';
                    }
                    var param = new SOAPClientParameters();
                    if(isEdit){
                        param.add('inCjhac_codigo',txtCjhac_codigo.getValue());
                        param.add('inCjadja_eliminar',tmpListadoEliminar2 );
                    }
                    param.add('inCjacu_codigo',tmpCjacu_codigo1);
                    param.add('inCjhac_descripcion',txtCjhac_descripcion.getValue());
                    param.add('inCjhac_responsable',txtCjhac_responsable.getValue());
                    param.add('inCjhac_fecha',dtCjhac_fecha.getValue().format('c'));
                    param.add('inCjadj_adjunto',grdCgg_jur_adjunto_acuerdo1.getStore().getJsonData());
                    param.add('inCjacu_estado_ejecucion',cbxCjacu_estado_ejecucion_HA.getValue());
                    param.add('inTmpValorEstado',tmpValorEstado);
                    SOAPClient.invoke(urlCgg_jur_historial_acuerdo,IN_SENTENCIA_CGG_JUR_HISTORIAL_ACUERDO,param, true, CallBackCgg_jur_historial_acuerdo);
                }catch(inErr){
                    winFrmCgg_jur_historial_acuerdo.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_jur_historial_acuerdo.
     */
    var btnCancelarCgg_jur_historial_acuerdo = new Ext.Button({
        id:'btnCancelarCgg_jur_historial_acuerdo',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_jur_historial_acuerdo.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_jur_historial_acuerdo.
     */
    var btnCerrarCgg_jur_historial_acuerdo = new Ext.Button({
        id:'btnCerrarCgg_jur_historial_acuerdo',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_jur_historial_acuerdo.close();
            }}
    });

    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_jur_historial_acuerdo.
     */
    var pnlCgg_jur_historial_acuerdo = new Ext.form.FormPanel({
        labelWidth :100,
        frame:true,
        items:[txtCjhac_codigo,txtCjhac_descripcion,txtCjhac_responsable,
            {xtype:'panel',layout:'column',items:[
                {columnWidth:.50,layout:'form',items:[dtCjhac_fecha]},
                {columnWidth:.50,layout:'form',items:[cbxCjacu_estado_ejecucion_HA]}]}
        ]
    });
    /**
     * Funcion que permite cargar el  codigo del documento generado
     */
    function responsableAcuerdo1(){
        function callBackResponsableAcuerdo1(r){
            txtCjhac_responsable.setValue(r);
        }
        SOAPClient.invoke(URL_WS+"Cgg_jur_proceso_judicial",'responsableProcesoJudicial',false, false, callBackResponsableAcuerdo1);
    }
    responsableAcuerdo1();
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_jur_historial_acuerdo.
     */
    var winFrmCgg_jur_historial_acuerdo = new Ext.Window({
        id:'winFrmCgg_jur_historial_acuerdo',
        title:tituloCgg_jur_historial_acuerdo,
        iconCls:'iconAplicacion',
        width:600,
        minWidth:600,
        maximizable:true,
        minimizable:true,
        modal:true,        
        constrain:true,
        tbar:getPanelTitulo(tituloCgg_jur_historial_acuerdo,descCgg_jur_historial_acuerdo),
        items:[pnlAcuerdo1,pnlCgg_jur_historial_acuerdo,grdCgg_jur_adjunto_acuerdo1],
        bbar:[btnGuardarCgg_jur_historial_acuerdo,btnCancelarCgg_jur_historial_acuerdo,'->',btnCerrarCgg_jur_historial_acuerdo]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmCgg_jur_historial_acuerdo.getBottomToolbar());
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_jur_historial_acuerdo.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_jur_historial_acuerdoCtrls(inEstado){
        estado=!inEstado;
        txtCjhac_codigo.setDisabled(estado);
        txtCjhac_descripcion.setDisabled(estado);
        txtCjhac_responsable.setDisabled(estado);
        dtCjhac_fecha.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_jur_historial_acuerdo.
     */
    function cargarCgg_jur_historial_acuerdoCtrls(){
        if(inRecordCgg_jur_historial_acuerdo){
            txtCjhac_codigo.setValue(inRecordCgg_jur_historial_acuerdo.get('CJHAC_CODIGO'));
            txtCjhac_descripcion.setValue(inRecordCgg_jur_historial_acuerdo.get('CJHAC_DESCRIPCION'));
            txtCjhac_responsable.setValue(inRecordCgg_jur_historial_acuerdo.get('CJHAC_RESPONSABLE'));
            dtCjhac_fecha.setValue(truncDate(inRecordCgg_jur_historial_acuerdo.get('CJHAC_FECHA')));
            cbxCjacu_estado_ejecucion_HA.setValue(inRecordCgg_jur_historial_acuerdo.get('CJACU_ESTADO_EJECUCION'));
            gsAdj_historial_acuerdo1.reload({
                params:{
                    inCjhac_codigo:txtCjhac_codigo.getValue(),
                    format:TypeFormat.JSON
                }
            });
            isEdit = true;
            habilitarCgg_jur_historial_acuerdoCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_jur_historial_acuerdo.
     * @returns ventana winFrmCgg_jur_historial_acuerdo.
     * @base FrmCgg_jur_historial_acuerdo.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_jur_historial_acuerdo;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_jur_historial_acuerdo.
     * @base FrmCgg_jur_historial_acuerdo.prototype.loadData
     */
    this.loadData = function(inAcuerdo1){
        cargarCgg_jur_historial_acuerdoCtrls();
        document.getElementById('divInfoAcuerdo1').innerHTML =tmpInfoAcuerdo1.apply(inAcuerdo1.json);
        tmpCjacu_codigo1=inAcuerdo1.get('CJACU_CODIGO');
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_jur_historial_acuerdo desde una instancia.
 */
FrmCgg_jur_historial_acuerdo.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_jur_historial_acuerdo desde una instancia.
 */
FrmCgg_jur_historial_acuerdo.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_jur_historial_acuerdo,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_jur_historial_acuerdo.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_jur_historial_acuerdo desde una instancia.
 */
FrmCgg_jur_historial_acuerdo.prototype.loadData = function(){
    this.loadData();
}
