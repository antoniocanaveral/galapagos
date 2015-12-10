/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_dhu_seguimiento_profesional.
 * @param {String} INSENTENCIA_CGG_DHU_SEGUIMIENTO_PROFESIONAL Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_DHU_SEGUIMIENTO_PROFESIONAL Registro de datos de la tabla Cgg_dhu_seguimiento_profesional.
 * @constructor
 * @base FrmListadoCgg_dhu_seguimiento_profesional
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_dhu_seguimiento_profesional(INSENTENCIA_CGG_DHU_SEGUIMIENTO_PROFESIONAL,INRECORD_CGG_DHU_SEGUIMIENTO_PROFESIONAL){
    var inSentenciaCgg_dhu_seguimiento_profesional = INSENTENCIA_CGG_DHU_SEGUIMIENTO_PROFESIONAL;
    var inRecordCgg_dhu_seguimiento_profesional=INRECORD_CGG_DHU_SEGUIMIENTO_PROFESIONAL;
    var urlCgg_dhu_seguimiento_profesional=URL_WS+"Cgg_dhu_seguimiento_profesional";
    var tituloCgg_dhu_seguimiento_profesional='Seguimiento profesional';
    var descCgg_dhu_seguimiento_profesional='El formulario permite administrar informaci\u00f3n sobre el seguimiento profesional de una persona becada';
    var isEdit = false;
    var  tmpInformacionBeca;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DEL SEGUIMIENTO PROFESIONAL
     */
    var txtCdspr_codigo = new Ext.form.TextField({
        id:'txtCdspr_codigo',
        name:'txtCdspr_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE BECA
     */
    var txtCdbec_codigo = new Ext.form.TextField({
        id:'txtCdbec_codigo',
        name:'txtCdbec_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });
    /**
     * Ext.form.TextField numero de identidicacion de una persona
     */
    var txtCdsep_numero_doc= new Ext.form.TextField({
        id:'txtCdsep_numero_doc',
        name:'txtCdsep_numero_doc',
        fieldLabel :'No documento',
        anchor:'98%',
         listeners: {
            specialkey: function(field, e){
                if (e.getKey() == e.ENTER) {
                    try{
                        function CallBackCgg_persona(r){
                            tmpInformacionBeca = Ext.util.JSON.decode(r)[0];
                            if(tmpInformacionBeca!=null){
                                txtCdbec_codigo.setValue(tmpInformacionBeca.CDBEC_CODIGO);
                                tmpInfoPersonaBecaSeguimientoProfesional.overwrite(Ext.getCmp('pnlCgg_dhu_beca_seguimiento').body,tmpInformacionBeca);
                                txtCdsep_numero_doc.setValue(tmpInformacionBeca.CRPER_NUM_DOC_IDENTIFIC);
                                if(tmpInformacionBeca.CDBEC_TITULO_ENTREGADO==false){
                                     Ext.Msg.show({
                                    title:tituloCgg_dhu_seguimiento_profesional,
                                    msg: 'La persona aun no tiene registrado el titulo.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO});
                                    pnlCgg_dhu_beca_seguimiento_profesional.disable();
                                }else{
                                    pnlCgg_dhu_beca_seguimiento_profesional.enable();
                                }
                            }else{
                                Ext.Msg.show({
                                    title:tituloCgg_dhu_seguimiento_profesional,
                                    msg: 'No existe el registro solicitado.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO});
                            }

                        }
                        var param = new SOAPClientParameters();
                        param.add('in_crper_num_doc_identific',txtCdsep_numero_doc.getValue());
                        param.add('format',TypeFormat.JSON);
                        SOAPClient.invoke(URL_WS+"Cgg_dhu_seguimiento_profesional","selectBecaSeguimiento",param, true, CallBackCgg_persona);
                    }catch(inErr){
                        //winFrmCgg_institucion_educativa.getEl().unmask();
                    }

                }
            }
        }
    });
     /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_beca.
     */
    function Beca() {
    var cmBeca = null;
    var gsBeca = null;

    cmBeca = new Ext.grid.ColumnModel([
        {dataIndex:'CDBEC_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CDBEC_NUMERO',header:'No. Beca',width:150,sortable:true},
        {dataIndex:'CRPER_NOMBRES',header:'Nombre',width:150,sortable:true},
        {dataIndex:'CRPER_APELLIDOS_PERSONA',header:'Apellidos',width:150,sortable:true},
        {dataIndex:'CRPER_NUM_DOC_IDENTIFIC',header:'N.Identificativo',width:150,sortable:true},
        {dataIndex:'CDBEC_NUMERO_CONVENIO',header:'No. convenio',width:150,sortable:true},
        {dataIndex:'CDBEC_FUNCIONARIO',header:'Funcionario',width:150,sortable:true},
        {dataIndex:'CDBEC_TIPO_CICLO',header:'Tipo ciclo',width:150,sortable:true,renderer:function(inCdbecTipoCiclo){
            if(inCdbecTipoCiclo==TypeCiclo.ANUAL)
            {return('ANUAL');}
             if(inCdbecTipoCiclo==TypeCiclo.SEMESTRAL)
            {return('SEMESTRAL');}
             if(inCdbecTipoCiclo==TypeCiclo.QUIMESTRAL)
            {return('QUIMESTRAL');}
             if(inCdbecTipoCiclo==TypeCiclo.OTROS)
            {return('OTROS');}
        }},
        {dataIndex:'CDBEC_TITULO_ENTREGADO',header:'T\u00edtulo entregado',width:150,sortable:true,hidden:true},
        {dataIndex:'CDBEC_BECA_DEVENGADA',header:'Beca devengada',width:150,sortable:true},
        {dataIndex:'CDBEC_ESTADO_APROBACION',header:'Estado aprobaci\u00f3n',width:150,sortable:true,renderer:function(inCdbecEstadoBeca){
            if(inCdbecEstadoBeca==TypeBecaAprobacion.NO_CONCLUIDA)
            {return('NO CONCLUIDA');}
            if(inCdbecEstadoBeca==TypeBecaAprobacion.EN_SEGUIMIENTO)
            {return('EN SEGUIMIENTO');}
            if(inCdbecEstadoBeca==TypeBecaAprobacion.CONCLUIDA)
            {return('NO CONCLUIDA');}
            if(inCdbecEstadoBeca==TypeBecaAprobacion.REPROBADA)
            {return('REPROBADA');}
            if(inCdbecEstadoBeca==TypeBecaAprobacion.TERMINADA_CASO_FORTUITO)
            {return('TERMINADA CASO FORTUITO');}
        }}
       ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_beca por un campo especifico.
     */
    var gsBeca = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_seguimiento_profesional",
            method:"selectBecaProfesional",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CDBEC_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CDBEC_CODIGO'},
            {name:'CDBEC_NUMERO'},
            {name:'CRPER_NOMBRES'},
            {name:'CRPER_APELLIDOS_PERSONA'},
            {name:'CRPER_NUM_DOC_IDENTIFIC'},
            {name:'CRETF_NOMBRE'},
            {name:'CGESP_NOMBRE'},
            {name:'CGIED_NOMBRE'},
            {name:'CDTBC_NOMBRE'},
            {name:'CGTPR_NOMBRE'},
            {name:'CGNES_DESCRIPCION'},
            {name:'CDBEC_NUMERO'},
            {name:'CDBEC_FECHA_INGRESO'},
            {name:'CDBEC_FUNCIONARIO'},
            {name:'CDBEC_NUMERO_CONVENIO'},
            {name:'CDBEC_TIPO_CICLO'},
            {name:'CDBEC_TITULO_ENTREGADO'},
            {name:'CDBEC_BECA_DEVENGADA'},
            {name:'CDBEC_ESTADO_APROBACION'}
        ]),
        sortInfo:{field: 'CRPER_NOMBRES', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'}
    });
           this.getCm = function() {
            return cmBeca;
        };

        this.getStore = function() {
            return gsBeca;
        }
    }

    Beca.prototype.getColumnModel = function() {
        return this.getCm();
    };

    Beca.prototype.getStore = function() {
        return this.getStore();
    };
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE BECA
     */
    var btnCdbec_codigoCgg_dhu_seguimiento_profesional = new Ext.Button({
        id:'btnCdbec_codigoCgg_dhu_seguimiento_profesional',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_dhu_beca = new Beca();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_dhu_beca.getStore(),tmpFLCgg_dhu_beca.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                    txtCdbec_codigo.setValue(tmpRecord.get('CDBEC_CODIGO'));
                    tmpInfoPersonaBecaSeguimientoProfesional.overwrite(Ext.getCmp('pnlCgg_dhu_beca_seguimiento').body,tmpRecord.json);
                    txtCdsep_numero_doc.setValue(tmpRecord.get('CRPER_NUM_DOC_IDENTIFIC'));
                     if(tmpRecord.get('CDBEC_TITULO_ENTREGADO')==false){
                                     Ext.Msg.show({
                                    title:tituloCgg_dhu_seguimiento_profesional,
                                    msg: 'La persona aun no tiene registrado el titulo.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO});
                                    pnlCgg_dhu_beca_seguimiento_profesional.disable();
                                }
                    }
                });
                objBusqueda.show();
            }}
    });
    var datosBecaSeguimiento={
        CRPER_NOMBRES:'0',
        CRPER_APELLIDOS_PERSONA:'0',
        CRPER_NUM_DOC_IDENTIFIC:'0',
        CDTBC_NOMBRE:'0',
        CGESP_NOMBRE:'0',
        CDBEC_FUNCIONARIO:'0',
        CDBEC_NUMERO_CONVENIO:'0',
        CDBEC_BECA_DEVENGADA:'0'
    }
    /*template de la consulta de PERSONA Y DATOS DE LA BECA*/
    var tmpInfoPersonaBecaSeguimientoProfesional = new Ext.XTemplate(
            '<table width="100%" height="100%" cellpadding="0">' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Nombres:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CRPER_NOMBRES}</font></td></td>' +
                    '<td><div class="tituloTemplate"<font  face="Arial, Helvetica, sans-serif">Apellidos:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CRPER_APELLIDOS_PERSONA}</font></td></td>' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">No.documento:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CRPER_NUM_DOC_IDENTIFIC}</font></td></td>' +
                    '<td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Tipo beca:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CDTBC_NOMBRE}</font></td></td>' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Especialidad:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CGESP_NOMBRE}</font></td></td>' +
                    '<td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Funcionario:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CDBEC_FUNCIONARIO}</font></td></td>' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Convenio:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CDBEC_NUMERO_CONVENIO}</font></td></td>' +
                    '<td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Beca devengada:</font></div></td>' +
                //'<td><font size="1" face="Arial, Helvetica, sans-serif">{CDBEC_BECA_DEVENGADA}</font></td></td>' +
                    ' <td><font size="1" face="Arial, Helvetica, sans-serif">',
            '<tpl if="CDBEC_BECA_DEVENGADA ==true">',
            '<span style="font-weight: bold;">SI</span>',
            '</tpl>',
            '<tpl if="CDBEC_BECA_DEVENGADA ==false">',
            '<b>NO</b>',
            '</tpl>',
            '</font></td>' +
                    '</table>'

            );
    /*template de la consulta de PERSONA Y DATOS DE LA BECA para editar */
    var tmpInfoPersonaBecaSeguimientoProfesionalEdit = new Ext.XTemplate(
            '<table width="100%" height="100%" cellpadding="0">' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Nombres:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CRPER_NOMBRES}</font></td></td>' +
                    '<td><div class="tituloTemplate"<font  face="Arial, Helvetica, sans-serif">Apellidos:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CRPER_APELLIDO_PATERNO} {CRPER_APELLIDO_MATERNO}</font></td></td>' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">No.documento:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CRPER_NUM_DOC_IDENTIFIC}</font></td></td>' +
                    '<td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Tipo beca:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CDTBC_NOMBRE}</font></td></td>' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Especialidad:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CGESP_NOMBRE}</font></td></td>' +
                    '<td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Funcionario:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CDBEC_FUNCIONARIO}</font></td></td>' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Convenio:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CDBEC_NUMERO_CONVENIO}</font></td></td>' +
                    '<td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Beca devengada:</font></div></td>' +
                //'<td><font size="1" face="Arial, Helvetica, sans-serif">{CDBEC_BECA_DEVENGADA}</font></td></td>' +
                    ' <td><font size="1" face="Arial, Helvetica, sans-serif">',
            '<tpl if="CDBEC_BECA_DEVENGADA ==true">',
            '<span style="font-weight: bold;">SI</span>',
            '</tpl>',
            '<tpl if="CDBEC_BECA_DEVENGADA ==false">',
            '<b>NO</b>',
            '</tpl>',
            '</font></td>' +
                    '</table>'

            );
    /**
     * Ext.form.NumberField NUMERO DEL ANIO DEL CUAL SE ESTA REGISTRANDO EL SEGUIMIENTO
     */
    var numCdspr_anio = new Ext.form.NumberField({
        id:'numCdspr_anio',nname:'numCdspr_anio',fieldLabel :'Anio',allowBlank :false,disabled :false});/**
     * Ext.form.DateField FECHA DE INGRESO A LA INSTITUCION
     */
    var dtCdspr_fecha_ingreso = new Ext.form.DateField({
        id:'dtCdspr_fecha_ingreso',
        name:'dtCdspr_fecha_ingreso',
        fieldLabel :'Fecha ingreso',
        allowBlank :false,
        value:new Date()
    });
    /**
     * Ext.form.TextField INSTITUCION DONDE EL BECARIO ESTA PRESTANDO SUS SERVICIOS
     */
    var txtCdspr_institucion = new Ext.form.TextField({
        id:'txtCdspr_institucion',
        name:'txtCdspr_institucion',
        fieldLabel :'Instituci\u00f3n',
        anchor:'98%'
    });
    /**
     * Ext.form.TextField CARGO QUE SE HALLA DESEMPENIANDO EL BECARIO
     */
    var txtCdspr_cargo = new Ext.form.TextField({
        id:'txtCdspr_cargo',
        name:'txtCdspr_cargo',
        fieldLabel :'Cargo',
        anchor:'98%'
    });
    /**
     * Ext.form.DateField FECHA DE SALIDA DE LA INSTITUCION
     */
    var dtCdspr_fecha_salida = new Ext.form.DateField({
        id:'dtCdspr_fecha_salida',
        name:'dtCdspr_fecha_salida',
        fieldLabel :'Fecha salida',
        value:new Date()
    });
    /**
     * Ext.form.TextArea OBSERVACIONES AL SEGUIMIENTO
     */
    var txtCdspr_observaciones = new Ext.form.TextArea({
        id:'txtCdspr_observaciones',
        name:'txtCdspr_observaciones',
        fieldLabel :'Observaciones',
        width:'90%'
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_dhu_seguimiento_profesional
     */
    var btnGuardarCgg_dhu_seguimiento_profesional = new Ext.Button({
        id:'btnGuardarCgg_dhu_seguimiento_profesional',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:TypeTooltip.GUARDAR,
        listeners:{
            click:function(){
                if (pnlCgg_dhu_seguimiento_profesional.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_dhu_seguimiento_profesional(r){
                        winFrmCgg_dhu_seguimiento_profesional.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_dhu_seguimiento_profesional,
                                msg: 'La informaci\u00f3n del seguimiento profesional ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_dhu_seguimiento_profesional.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_dhu_seguimiento_profesional,
                                msg: 'La informaci\u00f3n del seguimiento profesional no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_dhu_seguimiento_profesional.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCdspr_codigo',txtCdspr_codigo.getValue());
                    param.add('inCdbec_codigo',txtCdbec_codigo.getValue());
                    param.add('inCdspr_anio',numCdspr_anio.getValue());
                    param.add('inCdspr_fecha_ingreso',dtCdspr_fecha_ingreso.getValue().format('c'));
                    param.add('inCdspr_institucion',txtCdspr_institucion.getValue());
                    param.add('inCdspr_cargo',txtCdspr_cargo.getValue());
                    param.add('inCdspr_fecha_salida',dtCdspr_fecha_salida.getValue().format('c'));
                    param.add('inCdspr_observaciones',txtCdspr_observaciones.getValue());
                    SOAPClient.invoke(urlCgg_dhu_seguimiento_profesional,INSENTENCIA_CGG_DHU_SEGUIMIENTO_PROFESIONAL,param, true, CallBackCgg_dhu_seguimiento_profesional);
                }catch(inErr){
                    winFrmCgg_dhu_seguimiento_profesional.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_dhu_seguimiento_profesional.
     */
    var btnCancelarCgg_dhu_seguimiento_profesional = new Ext.Button({
        id:'btnCancelarCgg_dhu_seguimiento_profesional',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:TypeTooltip.CANCELAR,
        listeners:{
            click:function(){
                pnlCgg_dhu_seguimiento_profesional.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_dhu_seguimiento_profesional.
     */
    var btnCerrarCgg_dhu_seguimiento_profesional = new Ext.Button({
        id:'btnCerrarCgg_dhu_seguimiento_profesional',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:TypeTooltip.CERRAR,
        listeners:{
            click:function(){
                winFrmCgg_dhu_seguimiento_profesional.close();
            }}
    });
    /**
     * Ext.Panel Panel que contiene los datos informativos de persona y beca
     */
    var pnlCgg_dhu_beca_seguimiento = new Ext.form.FieldSet({
        id:'pnlCgg_dhu_beca_seguimiento',
        title:'Informaci\u00f3n beca',
        collapsible:true,
        // height:137,
        layout:'form',
        //region:'north',
        items:[
            {xtype:'panel', id :'pnlCgg_dhu_beca_seguimiento',data:datosBecaSeguimiento,tlp:tmpInfoPersonaBecaSeguimientoProfesional}
        ]
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles del registro del seguimiento academico
     */
    var pnlCgg_dhu_beca_seguimiento_profesional = new Ext.Panel({
        id:'pnlCgg_dhu_beca_seguimiento_profesional',
        layout:'form',
        frame:true,
        items:[numCdspr_anio,txtCdspr_institucion,txtCdspr_cargo,
            {xtype:'panel',layout:'column',
                items:[
                    {columnWidth:.50,layout:'form',labelWidth :100,
                        items:[dtCdspr_fecha_ingreso]},
                    {columnWidth:.50,layout:'form',
                        items:[dtCdspr_fecha_salida]}
                ]},
            txtCdspr_observaciones
        ]


    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_dhu_seguimiento_profesional.
     */
    var pnlCgg_dhu_seguimiento_profesional = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[
            {xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCdsep_numero_doc]},
                {columnWidth:.4,layout:'form',items:[btnCdbec_codigoCgg_dhu_seguimiento_profesional]}]},
            pnlCgg_dhu_beca_seguimiento,pnlCgg_dhu_beca_seguimiento_profesional]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_dhu_seguimiento_profesional.
     */
    var winFrmCgg_dhu_seguimiento_profesional = new Ext.Window({
        id:'winFrmCgg_dhu_seguimiento_profesional',
        title:tituloCgg_dhu_seguimiento_profesional,
        tbar:getPanelTitulo(tituloCgg_dhu_seguimiento_profesional,descCgg_dhu_seguimiento_profesional),
        items:[pnlCgg_dhu_seguimiento_profesional],
        width:600,
        minWidth:600,
        maximizable:true,
        minimizable:true,
        constrain:true,
        modal:true,
		resizable : false,
        bbar:[btnGuardarCgg_dhu_seguimiento_profesional,btnCancelarCgg_dhu_seguimiento_profesional,'->',btnCerrarCgg_dhu_seguimiento_profesional],
        listeners:{
            show:function(){
                if(isEdit){
                    if(INRECORD_CGG_DHU_SEGUIMIENTO_PROFESIONAL)
                    {
                        txtCdsep_numero_doc.setVisible(false);
                        btnCdbec_codigoCgg_dhu_seguimiento_profesional.setVisible(false);
                        tmpInfoPersonaBecaSeguimientoProfesionalEdit.overwrite( Ext.getCmp('pnlCgg_dhu_beca_seguimiento').body,inRecordCgg_dhu_seguimiento_profesional.json)
                        //txtCrper_codigo.setValue(inRecordCgg_res_prestamo_expediente.get('CRPER_CODIGO'));




                    }
                    else
                    {
                        alert('No se cargaron los datos');
                    }
                }
            }
        }
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_dhu_seguimiento_profesional.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_dhu_seguimiento_profesionalCtrls(inEstado){
        estado=!inEstado;
        txtCdspr_codigo.setDisabled(estado);
        txtCdbec_codigo.setDisabled(estado);
        numCdspr_anio.setDisabled(estado);
        dtCdspr_fecha_ingreso.setDisabled(estado);
        txtCdspr_institucion.setDisabled(estado);
        txtCdspr_cargo.setDisabled(estado);
        dtCdspr_fecha_salida.setDisabled(estado);
        txtCdspr_observaciones.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_dhu_seguimiento_profesional.
     */
    function cargarCgg_dhu_seguimiento_profesionalCtrls(){
        if(inRecordCgg_dhu_seguimiento_profesional){
            txtCdspr_codigo.setValue(inRecordCgg_dhu_seguimiento_profesional.get('CDSPR_CODIGO'));
            txtCdbec_codigo.setValue(inRecordCgg_dhu_seguimiento_profesional.get('CDBEC_CODIGO'));
            numCdspr_anio.setValue(inRecordCgg_dhu_seguimiento_profesional.get('CDSPR_ANIO'));
            dtCdspr_fecha_ingreso.setValue(truncDate(inRecordCgg_dhu_seguimiento_profesional.get('CDSPR_FECHA_INGRESO')));
            txtCdspr_institucion.setValue(inRecordCgg_dhu_seguimiento_profesional.get('CDSPR_INSTITUCION'));
            txtCdspr_cargo.setValue(inRecordCgg_dhu_seguimiento_profesional.get('CDSPR_CARGO'));
            dtCdspr_fecha_salida.setValue(truncDate(inRecordCgg_dhu_seguimiento_profesional.get('CDSPR_FECHA_SALIDA')));
            txtCdspr_observaciones.setValue(inRecordCgg_dhu_seguimiento_profesional.get('CDSPR_OBSERVACIONES'));
            isEdit = true;
            habilitarCgg_dhu_seguimiento_profesionalCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_dhu_seguimiento_profesional.
     * @returns ventana winFrmCgg_dhu_seguimiento_profesional.
     * @base FrmCgg_dhu_seguimiento_profesional.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_dhu_seguimiento_profesional;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_dhu_seguimiento_profesional.
     * @base FrmCgg_dhu_seguimiento_profesional.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_dhu_seguimiento_profesionalCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_dhu_seguimiento_profesional desde una instancia.
 */
FrmCgg_dhu_seguimiento_profesional.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_dhu_seguimiento_profesional desde una instancia.
 */
FrmCgg_dhu_seguimiento_profesional.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_dhu_seguimiento_profesional,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_dhu_seguimiento_profesional.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_dhu_seguimiento_profesional desde una instancia.
 */
FrmCgg_dhu_seguimiento_profesional.prototype.loadData = function(){
    this.loadData();
}
