/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_movilidad.
 * @param {String} INSENTENCIA_CGG_RES_MOVILIDAD Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_MOVILIDAD Registro de datos de la tabla Cgg_res_movilidad.
 * @constructor
 * @base FrmListadoCgg_res_movilidad
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_movilidad_salida(INSENTENCIA_CGG_RES_MOVILIDAD,INRECORD_CGG_RES_MOVILIDAD) {
    var inSentenciaCgg_res_movilidad = INSENTENCIA_CGG_RES_MOVILIDAD;
    var inRecordCgg_res_movilidad = INRECORD_CGG_RES_MOVILIDAD;
    var urlCgg_res_movilidad = URL_WS + "Cgg_res_movilidad";
    var tituloCgg_res_movilidad = 'Registro de salida de personas de la provincia';
    var descCgg_res_movilidad = 'El formulario permite administrar la informaci\u00f3n del Registro de Salida de Personas de la Provincia';
    var isEdit = false;
    var tmpCtreg_codigo2;
    var tmpCrper_codigo2;
    var tmpCraln_codigosalida2;
    var tmpCarpt_codigo2;
    var tmpCggCarpt_codigo2;
    var tmCtfsl_codigo2;
    var tmpchbSalida =0;
    var tmpPluginTctSalida; //Variable utilizada para obtener una instancia del objeto plugin para toma de huellas dactilares
    var tmpFirText;//Variable utilizada para la toma y alamacenamiento de infromacion desde el dispositivo biometrico
    var tmpUserSession;
    var tmpSaveAndClose;
    var tmpLocal = false;
    var tmpCrrsd_codigo;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCrmov_codigo2 = new Ext.form.TextField({
        id:'txtCrmov_codigo2',
        name:'txtCrmov_codigo2',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength:20
    });

    /**
     * Ext.form.NumberField CODIGO DE BARRAS GENERADO PARA EL REGISTRO DE TCT
     */
    var txtCtreg_codigo_barras2 = new Ext.form.TextField({
        id:'txtCtreg_codigo_barras2',
        name:'txtCtreg_codigo_barras2',
        fieldLabel :'C\u00f3digo barras',
        anchor:'98%',
        style: {
            color:'#004A95',
            background:'#FFFFE6'
        },
        listeners:{
            specialkey :function(inField, e){
                if (e.getKey() == e.ENTER) {
                    gsCgg_res_buscar_persona_TCT.baseParams.inIdentificacion = txtCtreg_codigo_barras2.getValue();
                    gsCgg_res_buscar_persona_TCT.baseParams.start = 0;
                    gsCgg_res_buscar_persona_TCT.baseParams.limit = 30;
                    gsCgg_res_buscar_persona_TCT.reload();
                    tmpLocal = true;
                }
            }
        }
    });
    /**
     * Ext.form.NumberField CODIGO DE BARRAS GENERADO PARA EL REGISTRO DE TCT
     */
    var txtCrper_numero_identificativo2 = new Ext.form.TextField({
        id:'txtCrper_numero_identificativo2',
        name:'txtCrper_numero_identificativo2',
        fieldLabel :'Num. Identificaci\u00f3n',
        anchor:'98%',
        style: {
            color:'#004A95',
            background:'#F0FFF2'
        },
        listeners:{
            specialkey :function(inField, e){
                if (e.getKey() == e.ENTER) {
                    gsCgg_res_buscar_persona_TCT.baseParams.inIdentificacion = txtCrper_numero_identificativo2.getValue();
                    gsCgg_res_buscar_persona_TCT.baseParams.start = 0;
                    gsCgg_res_buscar_persona_TCT.baseParams.limit = 30;
                    gsCgg_res_buscar_persona_TCT.reload();
                    tmpLocal = true;
                }
            }
        }
    });

    /**
         * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_movilidad por un campo especifico.
         */
    var gsCgg_res_buscar_persona_TCT = new  Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_movilidad",
            method:"selectPagePersonasBuscarTCT",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRMOV_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CTREG_CODIGO'
        },

        {
            name:'CRPER_CODIGO'
        },

        {
            name:'CTREG_CODIGO_BARRAS'
        },

        {
            name:'CRALN_CODIGO'
        },

        {
            name:'AEROLINEA'
        },

        {
            name:'CARPT_CODIGO'
        },

        {
            name:'AEROPUER_ORIGEN'
        },

        {
            name:'CGG_CARPT_CODIGO'
        },

        {
            name:'AEROPUER_DESTINO'
        },

        {
            name:'CTREG_FECHA_INGRESO'
        },

        {
            name:'CTREG_FECHA_SALIDA'
        },

        {
            name:'CRDID_CODIGO'
        },

        {
            name:'DOCUMENTO'
        },

        {
            name:'CRPER_NUM_DOC_IDENTIFIC'
        },

        {
            name:'CRPER_NOMBRES'
        },

        {
            name:'CRPER_APELLIDO_PATERNO'
        },

        {
            name:'CRPER_GENERO'
        },

        {
            name:'CRPER_FECHA_NACIMIENTO'
        },

        {
            name:'CGNCN_CODIGO'
        },

        {
            name:'NACIONALIDAD'
        },

        {
            name:'CPAIS_CODIGO'
        },

        {
            name:'CRMOV_FECHA_VIAJE'
        },

        {
            name:'PAIS_RESIDENCIA'
        },

        {
            name:'CRTRA_CODIGO'
        },

        {
            name:'CRTRA_NUMERO'
        },

        {
            name:'CRTRA_CODIGO'
        },

        {
            name:'TIPO_RESIDENCIA'
        },

        {
            name:'CRRSD_CODIGO'
        },

        {
            name:'CTREG_ESTADO_REGISTRO'
        }
        ]),
        sortInfo:{
            field: 'CTREG_FECHA_INGRESO', 
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:'JSON',
            inIdentificacion:'',
            inMovimiento:0
        },
        listeners:{
            load:function(inSource, inRecords, inOptions){
                if(inRecords.length > 0 && tmpLocal){
                    tmpLocal = false;
                    inRecordCgg_res_movilidad = inRecords[0].data;
                    cargarCgg_res_movilidadCtrls();
                }
            }
        }
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_movilidad.
     */
    function BuscarPersonaTCT(){
        var cmCgg_res_buscar_persona_TCT = new Ext.grid.ColumnModel([
        {
            dataIndex:'CTREG_CODIGO_BARRAS',
            header:'Codigo Barras',
            width:150,
            sortable:true
        },

        {
            dataIndex:'AEROLINEA',
            header:'Aerolinea',
            width:70,
            sortable:true
        },

        {
            dataIndex:'AEROPUER_ORIGEN',
            header:'Aeropuerto Origen',
            width:150,
            sortable:true
        },

        {
            dataIndex:'AEROPUER_DESTINO',
            header:'Aeropuerto Destino',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CTREG_FECHA_INGRESO',
            header:'Fecha Ingreso',
            width:150,
            sortable:true,
            renderer:truncDate
        },

        {
            dataIndex:'CTREG_FECHA_SALIDA',
            header:'Fecha Salida',
            width:150,
            sortable:true,
            renderer:truncDate
        },

        {
            dataIndex:'CRDID_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden: true
        },

        {
            dataIndex:'DOCUMENTO',
            header:'Tipo Documnento',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CRPER_NUM_DOC_IDENTIFIC',
            header:'Numero Documento',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CRPER_NOMBRES',
            header:'Nombres',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CRPER_APELLIDO_PATERNO',
            header:'Apellido',
            width:150,
            sortable:true
        },

        {
            dataIndex:'NACIONALIDAD',
            header:'Nacionalidad',
            width:150,
            sortable:true
        },

        {
            dataIndex:'PAIS_RESIDENCIA', 
            header:'Pais Residencia', 
            width:150, 
            sortable:true
        },

        {
            dataIndex:'CRTRA_NUMERO',
            header:'Numero Certificado', 
            width:150, 
            sortable:true
        },

        {
            dataIndex:'TIPO_RESIDENCIA',
            header:'Tipo Residencia',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CTREG_ESTADO_REGISTRO',
            header:'Estado Registro',
            width:150,
            sortable:true, 
            renderer:function(inCreg_estado){
                return dsEstadoRegistroTct[inCreg_estado][1];
            }
        }
        ]);
        
    this.getCm = function() {
        return cmCgg_res_buscar_persona_TCT;
    };

}
BuscarPersonaTCT.prototype.getColumnModel = function() {
    return this.getCm();
};

/**
     * Boton que permite buscar las pesonas que estan preregistradas para el ingreso a la provincia
     */
var btnBuscarCodigoBarras2 = new Ext.Button({
    id:'btnBuscarCodigoBarras',
    iconCls:'iconBuscar',
    listeners:{
        click:function(){
            var tmpFLCgg_res_personasTCT = new BuscarPersonaTCT();
            var objBusqueda = new DlgBusqueda(gsCgg_res_buscar_persona_TCT,tmpFLCgg_res_personasTCT.getColumnModel());
            objBusqueda.closeHandler(function(){
                var tmpRecord = objBusqueda.getSelectedRow();
                if(tmpRecord){
                    inRecordCgg_res_movilidad = tmpRecord.data;
                    cargarCgg_res_movilidadCtrls();
                }
            });
            objBusqueda.show();
        }
    }
});
	
/**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_aerolinea por un campo especifico.
     */
var gsCgg_res_aerolinea = new Ext.data.Store({
    proxy:new Ext.ux.bsx.SoapProxy({
        url:URL_WS+"Cgg_res_aerolinea",
        method:"selectAll"
    }),
    reader:new Ext.data.JsonReader({},[
    {
        name:'CRALN_CODIGO'
    },

    {
        name:'CRALN_NOMBRE'
    },

    {
        name:'CRALN_TIPO_AEROLINEA'
    }
    ]),
    baseParams:{
        format:"JSON"
    }
});

/**
     * Ext.form.ComboBox Aereolinea de la tct.
     */
var cbxCraln_codigo_salida2 = new Ext.form.ComboBox({
    id:'cbxCraln_codigo_salida2',
    fieldLabel :'Aerol\u00ednea',
    displayField:'CRALN_NOMBRE',
    store:gsCgg_res_aerolinea,
    typeAhead: true,
    mode: 'local',
    forceSelection:true,
    editable:false,
    triggerAction:'all',
    emptyText:'Seleccione la aerol\u00ednea',
    selectOnFocus:true,
    valueField:'CRALN_CODIGO',
    anchor:'98%'
});
gsCgg_res_aerolinea.load();


/**
     * Ext.form.DateField FECHA DE INGRESO  A LA PROVINCIA
     */
var dtCtreg_fecha_ingreso2 = new Ext.form.DateField({
    id:'dtCtreg_fecha_ingreso2',
    name:'dtCtreg_fecha_ingreso2',
    fieldLabel :'Ingreso',
    format :'d/m/Y',
    readOnly:true
});

/**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
var txtCarpt_codigo2 = new Ext.form.TextField({
    id:'txtCarpt_codigo2',
    name:'txtCarpt_codigo2',
    fieldLabel :'Origen',
    anchor:'98%',
    readOnly:'true'
});
/**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
var txtCgg_carpt_codigo2 = new Ext.form.TextField({
    id:'txtCgg_carpt_codigo2',
    name:'txtCgg_carpt_codigo2',
    fieldLabel :'Arribo',
    anchor:'98%',
    readOnly:'true'
});

/**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_aeropuerto por un campo especifico.
     */
var gsCgg_res_aeropuerto2 = new Ext.data.Store({
    proxy:new Ext.ux.bsx.SoapProxy({
        url:URL_WS+"Cgg_res_aeropuerto",
        method:"selectAll"
    }),
    reader:new Ext.data.JsonReader({},[
    {
        name:'CARPT_CODIGO'
    },

    {
        name:'CCTN_CODIGO'
    },

    {
        name:'CANTON'
    },

    {
        name:'CARPT_NOMBRE'
    },

    {
        name:'CARPT_TIPO_AEREOPUERTO'
    }
    ]),
    baseParams:{
        format:"JSON"
    }
});

/**
     * Ext.form.ComboBox IDENTIFICATIVO UNICO DE REGISTRO
     */
var cbxCarpt_codigo_salida2= new Ext.form.ComboBox({
    id:'cbxCarpt_codigo_salida2',
    fieldLabel :'Salida',
    displayField:'CARPT_NOMBRE',
    store:gsCgg_res_aeropuerto2,
    typeAhead: true,
    mode: 'local',
    readOnly:true,
    triggerAction:'all',
    emptyText:'Seleccione el origen',
    selectOnFocus:true,
    allowBlank :false,
    valueField:'CARPT_CODIGO',
    anchor:'98%'
});
gsCgg_res_aeropuerto2.reload();

///////////////////////////////////////////////////////////////
/**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
     */
var txtCrper_codigo2 = new Ext.form.TextField({
    id:'txtCrper_codigo2',
    name:'txtCrper_codigo2',
    fieldLabel :'Codigo',
    anchor:'98%',
    hidden:true,
    hideLabel:true

});
/**
     * Ext.form.TextField TIPO DOCUMENTO
     */
var txtCrdid_codigo2 = new Ext.form.TextField({
    id:'txtCrdid_codigo2',
    name:'txtCrdid_codigo2',
    fieldLabel :'Tipo Documento',
    anchor:'98%',
    readOnly:'true'
});
/**
     * Ext.form.TextField NOMBRES DE LA PERSONA
     */
var txtCrper_nombres2 = new Ext.form.TextField({
    id:'txtCrper_nombres2',
    name:'txtCrper_nombres2',
    fieldLabel :'Nombres',
    anchor:'98%',
    readOnly:'true'
});
/**
     * Ext.form.TextField APELLIDO PATERNO
     */
var txtCrper_apellido_paterno2 = new Ext.form.TextField({
    id:'txtCrper_apellido_paterno2',
    name:'txtCrper_apellido_paterno2',
    fieldLabel :'Apellido ',
    anchor:'98%',
    readOnly:'true'
});

/**
     * Ext.form.TextField NUMERO DE DOCUEMNTO DE IDENTIFICACION
     */
var txtCrper_num_doc_identific2 = new Ext.form.TextField({
    id:'txtCrper_num_doc_identific2',
    name:'txtCrper_num_doc_identific2',
    fieldLabel :'No. identificaci\u00f3n',
    anchor:'98%',
    readOnly:'true'

});
/**
     * Ext.form.TextField APELLIDO PATERNO
     */
var txtCrtra_codigo2 = new Ext.form.TextField({
    id:'txtCrtra_codigo2',
    name:'txtCrtra_codigo2',
    fieldLabel :'Tipo Registro',
    anchor:'98%',
    readOnly:'true'
});
/**
     * Ext.form.TextField APELLIDO PATERNO
     */
var txtCtgtr_codigo2 = new Ext.form.TextField({
    id:'txtCtgtr_codigo2',
    name:'txtCtgtr_codigo2',
    fieldLabel :'Codigo_Grupo',
    anchor:'98%',
    readOnly:'true'
});
/**
     * Ext.form.TextField GENERO DE LA PERSONA
     */
var txtCrper_genero2 = new Ext.form.TextField({
    id:'txtCrper_genero2',
    name:'txtCrper_genero2',
    fieldLabel :'Genero',
    anchor:'98%',
    readOnly:'true'
});
/**
     * Ext.form.TextField GENERO DE LA PERSONA
     */
var txtCgncn_codigo2 = new Ext.form.TextField({
    id:'txtCgncn_codigo2',
    name:'txtCgncn_codigo2',
    fieldLabel :'Nacionalidad',
    anchor:'98%',
    readOnly:'true'
});
/**
     * Ext.form.TextField PAIS DE RESIDENCIA
     */
var txtCpais_codigo2 = new Ext.form.TextField({
    id:'txtCpais_codigo2',
    name:'txtCpais_codigo2',
    fieldLabel :'Pais de residencia',
    anchor:'98%',
    readOnly:'true'
});/**
     * Ext.form.TextField NUMERO DE CERTIFICADO DE LA PERSONA Q TIENE UN TRAMITE
     */
var txtCrtra_numero2 = new Ext.form.TextField({
    id:'txtCrtra_numero2',
    name:'txtCrtra_numero2',
    fieldLabel :'N. Certificado',
    anchor:'98%',
    readOnly:'true'
});

/**
     * Ext.form.TextField GENERO DE LA PERSONA
     */
var txtCtreg_tipo_registro2 = new Ext.form.TextField({
    id:'txtCtreg_tipo_registro2',
    name:'txtCtreg_tipo_registro2',
    fieldLabel :'Tipo Registro',
    anchor:'98%',
    readOnly:'true'
});
//////////////////////////////////////////////
var chbSalida = {
    id:'chbSalida',
    name:'chbSalida',
    fieldLabel :'Salida especial',
    checked:false,
    xtype:"checkbox",
    listeners:{
        check :function(inField,check){
            tmpchbSalida=check?1:0;
        }
    }
};
/**
     * Ext.form.DateField FECHA DE VIAJE
     */
var dtCrmov_fecha_viaje2 = new Ext.form.DateField({
    id:'dtCrmov_fecha_viaje2',
    name:'dtCrmov_fecha_viaje2',
    maxValue: CURRENT_DATE,
    fieldLabel :'Viaje',
    value:CURRENT_DATE
});

/**
     * Ext.form.TextField NUMERO DE VUELO
     */
var txtCrmov_numero_vuelo2 = new Ext.form.TextField({
    id:'txtCrmov_numero_vuelo2',
    name:'txtCrmov_numero_vuelo2',
    fieldLabel :'Numero vuelo',
    width:80,
    labelWidth:90,
    allowBlank :false
});
/**
     * Ext.form.TextField DESCRIPCION CORTA DE LA OPERACION
     */
var txtCrmov_observacion2 = new Ext.form.TextArea({
    id:'txtCrmov_observacion2',
    name:'txtCrmov_observacion2',
    fieldLabel :'Observaci\u00f3n',
    anchor:'98%'
});
/**
     * Ext.form.Checkbox IDENTIFICAR SI LA PERSONA PASO POR EL CONTROL DE NACIONAL O EXTRANJERO
     */
var chkCrmov_filtro_interno2 = new Ext.form.Checkbox({
    id:'chkCrmov_filtro_interno2',
    name:'chkCrmov_filtro_interno2',
    fieldLabel :'Filtros Nacionales?',
    checked:false
});
/**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_movilidad_salida
     */
var btnGuardarCgg_res_movilidad2 = new Ext.Toolbar.SplitButton({
    id:'btnGuardarCgg_res_movilidad2',
    text:'Guardar',
    iconCls:'iconGuardar',
    menu:[{
        text:'Guardar y salir',
        handler:function(){
            tmpSaveAndClose = true;
            btnGuardarCgg_res_movilidad2.fireEvent('click', btnGuardarCgg_res_movilidad2);
        }
    }],
listeners:{
    click:function() {
        if (!pnlCgg_res_movilidad2.getForm().isValid()) {
            return;
        }
        try {
            function CallBackCgg_res_movilidad(r) {
                winFrmCgg_res_movilidad_salida.getEl().unmask();
                if (r == 'true') {
                    /* Ext.Msg.show({
                                title:tituloCgg_res_movilidad,
                                msg: 'La informaci\u00f3n de la Salida de la Persona ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });*/
                    Ext.MsgPopup.msg(tituloCgg_res_movilidad, 'La informaci\u00f3n de la Salida de la Persona ha sido almacenada.');
                    txtCtreg_codigo_barras2.focus();
                    if(tmpSaveAndClose){
                        winFrmCgg_res_movilidad_salida.close()
                    }else{
                        pnlCgg_res_movilidad2.getForm().reset();
                    }
                    tmpSaveAndClose = false;
                } else {
                    Ext.Msg.show({
                        title:tituloCgg_res_movilidad,
                        msg: 'La informaci\u00f3n de la Salida de la Persona no ha podido ser almacenada. '+ (r.message?r.message:r),
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.ERROR
                    });
                }
            }
            if(new ManagerCookies().read('TCT_SALIDA_VUELO'))
                new ManagerCookies().erase('TCT_SALIDA_VUELO');
            new ManagerCookies().create('TCT_SALIDA_VUELO', txtCrmov_numero_vuelo2.getValue(), 168);
					
            if(new ManagerCookies().read('TCT_SALIDA_AEROLINEA'))
                new ManagerCookies().erase('TCT_SALIDA_AEROLINEA');
            new ManagerCookies().create('TCT_SALIDA_AEROLINEA', cbxCraln_codigo_salida2.getValue(), 168);
					
            winFrmCgg_res_movilidad_salida.getEl().mask('Guardando...', 'x-mask-loading');
            var param = new SOAPClientParameters();
            if (isEdit){
                param.add('inCrmov_codigo', txtCrmov_codigo2.getValue());
            }
            param.add('inCraln_codigo', cbxCraln_codigo_salida2.getValue());
            param.add('inCarpt_codigo', cbxCarpt_codigo_salida2.getValue());
            param.add('inCgg_carpt_codigo', null);
            param.add('inCrper_codigo', tmpCrper_codigo2);
            param.add('inCtreg_codigo', tmpCtreg_codigo2);
            param.add('inCrrsd_codigo', tmpCrrsd_codigo.length>0?tmpCrrsd_codigo:null);
            param.add('inCrmov_fecha_viaje', dtCrmov_fecha_viaje2.getValue().format('Y-m-d'));
            param.add('inCrmov_tipo_operacion', '1');
            param.add('inCrmov_numero_vuelo', txtCrmov_numero_vuelo2.getValue());
            param.add('inCrmov_observacion', txtCrmov_observacion2.getValue());
            param.add('inCrmov_tipo_salida', tmpchbSalida);
            param.add('inCrmov_filtro_interno',chkCrmov_filtro_interno2.getValue());
            param.add('inPersonaJSON',null);
            param.add('inActividadesJSON',null);
            param.add('inHospedajesJSON',null);
            SOAPClient.invoke(urlCgg_res_movilidad, INSENTENCIA_CGG_RES_MOVILIDAD, param, true, CallBackCgg_res_movilidad);
        } catch(inErr) {
            winFrmCgg_res_movilidad_salida.getEl().unmask();
        }
    }
}
});
/**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_movilidad_salida.
     */
var btnCancelarCgg_res_movilidad2 = new Ext.Button({
    id:'btnCancelarCgg_res_movilidad2',
    text:'Cancelar',
    iconCls:'iconCancelar',
    listeners:{
        click:function() {
            pnlCgg_res_movilidad2.getForm().reset();
        }
    }
});
/**
     * Boton que permite cerrar la ventana winFrmCgg_res_movilidad_salida.
     */
var btnCerrarCgg_res_movilidad2 = new Ext.Button({
    id:'btnCerrarCgg_res_movilidad2',
    text:'Cerrar',
    iconCls:'iconCerrar',
    listeners:{
        click:function() {
            winFrmCgg_res_movilidad_salida.close();
        }
    }
});

/**
     * Ext.form.FormPanel Panel para las Fechas
     */
var pnlfsDatosAdic2 = new Ext.form.FieldSet({
    id:'pnlfsDatosAdic2',
    title:'Datos de la Salida',
    collapsible:false,
    anchor:'100%',
    region:'center',
    labelWidth :80,
    layout:'form',
    items:[cbxCraln_codigo_salida2,
    txtCrmov_numero_vuelo2,
    txtCarpt_codigo2,
    txtCgg_carpt_codigo2,
    cbxCarpt_codigo_salida2,{
        xtype:'panel',
        id:'pnlMovSalFechas',
        layout:'form',
        items:[
        dtCtreg_fecha_ingreso2,dtCrmov_fecha_viaje2]
        }
    ]
    });


/**
     * Ext.form.FormPanel Panel para organizar las actividades y los tipos de hospedaje
     */
var pnlCgg_tct_varios2 = new Ext.Panel({
    layout: 'form',
    height:30,
    labelWidth :90,
    items:[
    {
        xtype:'panel',
        layout:'column',
        html:'<object id="bsxTctSalidaBiometric" type="' + SII_mimeType + '" width="0" height="0"></object>',
        items:[
        {
            columnWidth:.45,
            layout:'form',
            items:[txtCtreg_codigo_barras2]
        },
        {
            columnWidth:.45,
            layout:'form',
            items:[{
                xtype:'panel',
                layout:'column',
                items:[
                {
                    columnWidth:.92,
                    layout:'form',
                    labelWidth :110,
                    items:[txtCrper_numero_identificativo2]
                    },

                    {
                    columnWidth:.08,
                    layout:'form',
                    labelWidth :110,
                    items:[btnBuscarCodigoBarras2]
                    }
                ]
                }
            ]
        },
        {
            columnWidth:.1,
            layout:'form',
            anchor:'100%',
            items:[
            {
                xtype:'button',
                iconCls:'iconHand',
                arrowAlign :'bottom',
                tooltip:'Verificar informaci\u00f3n dactilar',
                listeners:
                {
                    click:function()
                    {
                        if ( txtCrper_num_doc_identific2.getValue())
                        {
                            if(!tmpPluginTctSalida)
                                tmpPluginTctSalida = document.getElementById("bsxTctSalidaBiometric");
                            var tmpHuella = tmpPluginTctSalida.capture();
                            if(tmpHuella == 0){
                                tmpFirText = tmpPluginTctSalida.firText;//dato procesado utilizado para verificacion
                                Ext.Ajax.request({
                                    url: URL_WS+'Biometrico',
                                    success: function(inResponse){
                                        var tmpJSON = Ext.util.JSON.decode(inResponse.responseText);
                                        if(tmpJSON.success == false)
                                        {
                                            Ext.Msg.show({
                                                title: tituloCgg_res_movilidad,
                                                msg: tmpJSON.msg,
                                                buttons: Ext.Msg.OK,
                                                icon: Ext.MessageBox.ERROR
                                            });
                                        }
                                        else
                                        {
                                            Ext.Msg.show({
                                                title: tituloCgg_res_movilidad,
                                                msg: "Informaci\u00f3n validada correctamente",
                                                buttons: Ext.Msg.OK,
                                                icon: Ext.MessageBox.INFO
                                            });

                                        }

                                    },
                                    failure: function(inResponse){
                                        var tmpJSON = Ext.util.JSON.decode(inResponse.responseText)
                                        Ext.Msg.show({
                                            title: tituloCgg_res_movilidad,
                                            msg: "Ha ocurrido un error en el proceso de verificacion",
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.ERROR
                                        });
                                    //alert(inResponse.responseText);

                                    },
                                    params: {
                                        op: 'verify',
                                        data: tmpFirText,
                                        id: txtCrper_num_doc_identific2.getValue()
                                    }
                                });
                            }
                            else
                            {
                                Ext.Msg.show({
                                    title: tituloCgg_res_movilidad,
                                    msg: tmpPluginTctSalida.message,
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }
                        }
                        else
                        {
                            Ext.Msg.show({
                                title: tituloCgg_res_movilidad,
                                msg: 'Es necesario seleccionar un registro para su verificaci\u00f3!!!',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }

                    }
                }

            }
            ]
        }
        ]
        }]
});


/**
     * Ext.Panel Panel que contiene los controles de la actividad y el  tipo hospedaje
     */
var pnlCgg_res_persona2 = new Ext.form.FieldSet({
    title:'Persona',
    anchor:'100%',
    region:'center',
    labelWidth:110,
    style:{
        marginLeft:'6px'
    },
    items:[
    txtCrdid_codigo2,txtCrper_num_doc_identific2,txtCrper_nombres2,txtCrper_apellido_paterno2,
    txtCrper_genero2,txtCgncn_codigo2,txtCpais_codigo2,txtCrtra_codigo2,txtCrtra_numero2
    ]
});


/**
     * Ext.Panel Panel que contiene los controles de la actividad y el  tipo hospedaje
     */
var pnlCgg_res_organizar2 = new  Ext.Panel({
    items:[
    {
        xtype:'panel',
        layout:'column',
        items:[
        {
            columnWidth:.50,
            layout:'form',
            items:[pnlfsDatosAdic2,chbSalida]
            },

            {
            columnWidth:.50,
            layout:'form', 
            items:[pnlCgg_res_persona2]
            }
        ]
        }
    ]
});
/**
     * Ext.form.FormPanel Panel que contiene todos los controles de winFrmCgg_res_movilidad_salida
     */

var pnlCgg_res_movilidad2 = new Ext.form.FormPanel({
    frame:true,
    items:[pnlCgg_tct_varios2,
    pnlCgg_res_organizar2,
    txtCrmov_observacion2
    ]
});

/**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_movilidad.
     */
var winFrmCgg_res_movilidad_salida = new Ext.Window({
    id:'winFrmCgg_res_movilidad_salida',
    title:tituloCgg_res_movilidad,
    tbar:getPanelTitulo(tituloCgg_res_movilidad, descCgg_res_movilidad),
    items:[pnlCgg_res_movilidad2],
    width:715,
    minWidth:400,
    maximizable:true,
    resizable:true,
    modal:true,
    minimizable:false,
    constrain:true,
    bbar:[btnGuardarCgg_res_movilidad2,btnCancelarCgg_res_movilidad2,'->',btnCerrarCgg_res_movilidad2]
});

applyGrants(winFrmCgg_res_movilidad_salida.getBottomToolbar());
applyGrants(Ext.getCmp('pnlMovSalFechas'), true);
	
/**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_movilidad_salida.
     */
function cargarCgg_res_movilidadCtrls() {
    if (inRecordCgg_res_movilidad) {
        txtCrper_numero_identificativo2.setValue(inRecordCgg_res_movilidad.CRPER_NUM_DOC_IDENTIFIC);
        txtCtreg_codigo_barras2.setValue(inRecordCgg_res_movilidad.CTREG_CODIGO_BARRAS);
        //txtCrmov_codigo2.setValue(inRecordCgg_res_movilidad.CRMOV_CODIGO);
        tmpCtreg_codigo2=inRecordCgg_res_movilidad.CTREG_CODIGO;
        tmpCrper_codigo2= inRecordCgg_res_movilidad.CRPER_CODIGO;
        txtCtgtr_codigo2.setValue(inRecordCgg_res_movilidad.CTGTR_CODIGO);
        cbxCraln_codigo_salida2.setValue(inRecordCgg_res_movilidad.CRALN_CODIGO);
        tmpCarpt_codigo2=inRecordCgg_res_movilidad.CARPT_CODIGO;
        txtCarpt_codigo2.setValue(inRecordCgg_res_movilidad.AEROPUER_ORIGEN);
        tmpCggCarpt_codigo2=inRecordCgg_res_movilidad.CGG_CARPT_CODIGO;
        txtCgg_carpt_codigo2.setValue(inRecordCgg_res_movilidad.AEROPUER_DESTINO);
        dtCtreg_fecha_ingreso2.setValue(truncDate(inRecordCgg_res_movilidad.CRMOV_FECHA_VIAJE));
        txtCrdid_codigo2.setValue(inRecordCgg_res_movilidad.DOCUMENTO);
        txtCrper_num_doc_identific2.setValue(inRecordCgg_res_movilidad.CRPER_NUM_DOC_IDENTIFIC);
        txtCrper_nombres2.setValue(inRecordCgg_res_movilidad.CRPER_NOMBRES);
        txtCrper_apellido_paterno2.setValue(inRecordCgg_res_movilidad.CRPER_APELLIDO_PATERNO);
        txtCrper_genero2.setValue(dsGeneroPersona[inRecordCgg_res_movilidad.CRPER_GENERO][1]);
        txtCgncn_codigo2.setValue(inRecordCgg_res_movilidad.NACIONALIDAD);
        txtCpais_codigo2.setValue(inRecordCgg_res_movilidad.PAIS_RESIDENCIA);
        txtCrtra_codigo2.setValue(inRecordCgg_res_movilidad.TIPO_RESIDENCIA);
        txtCrmov_numero_vuelo2.setValue(inRecordCgg_res_movilidad.CRMOV_NUMERO_VUELO);
        txtCrtra_numero2.setValue(inRecordCgg_res_movilidad.CRTRA_NUMERO);
        tmpCrrsd_codigo = inRecordCgg_res_movilidad.CRRSD_CODIGO;
        if(new ManagerCookies().read('TCT_SALIDA_VUELO'))
            txtCrmov_numero_vuelo2.setValue(new ManagerCookies().read('TCT_SALIDA_VUELO'));
        if(new ManagerCookies().read('TCT_SALIDA_AEROLINEA'))
            cbxCraln_codigo_salida2.setValue(new ManagerCookies().read('TCT_SALIDA_AEROLINEA'));
        cbxCarpt_codigo_salida2.setValue(tmpUserSession.getUserData().CARPT_CODIGO);
    //isEdit = true;
    }
}
/**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_movilidad_salida.
     * @returns ventana winFrmCgg_res_movilidad_salida.
     * @base FrmCgg_res_movilidad_salida.prototype.show
     */
this.getWindow = function() {
    return winFrmCgg_res_movilidad_salida;
}
/**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_movilidad_salida.
     * @base FrmCgg_res_movilidad_salida.prototype.loadData
     */
this.loadData = function() {
    cargarCgg_res_movilidadCtrls();
}
	
this.setUserSession = function(inUserSession){
    tmpUserSession = inUserSession;
}
}

FrmCgg_res_movilidad_salida.prototype.setUserSession = function(inUserSession){
    this.setUserSession(inUserSession);
}

/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_movilidad_salida desde una instancia.
 */
FrmCgg_res_movilidad_salida.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_movilidad_salida desde una instancia.
 */
FrmCgg_res_movilidad_salida.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_movilidad_salida,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_movilidad_salida.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_movilidad_salida desde una instancia.
 */
FrmCgg_res_movilidad_salida.prototype.loadData = function(){
    this.loadData();
}
