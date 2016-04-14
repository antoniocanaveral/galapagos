/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_beneficiario.
 * @param {Ext.data.Record} inRecordCgg_res_beneficiario Record con informacion del beneficiario a registrarse.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_carnet_tramite(inInfoPersona){

    var tituloCgg_res_beneficiario='Residente - actualizar auspiciante ';
    var descCgg_res_beneficiario='Actualizaci\u00f3n de informaci\u00f3n del Auspiciante';
    var isEdit = false;
    var tmpAuspiciante = null;
    var tmpAuspiciantePJ =  null;


    var tmpInfoPersona = new Ext.XTemplate(
            '<table width="100%" height="100%" cellpadding="0">'+
                    '<tr rowspan="0">'+
                    '<td><div class="tituloTemplate">Residencia</div></td>'+
                    '<td><div class="itemTemplate">{CRPER_NUMERO_RESIDENCIA}</div></td>'+
                    '<td><div class="tituloTemplate"> Tipo:</div></td>'+
                    '<td><div class="itemTemplate">{CRPER_TIPO_RESIDENCIA}</div></td>'+
                    '</tr>'+
                    '<tr rowspan="0">'+
                    '<td><div class="tituloTemplate">Nombres:</div></td>'+
                    '<td><div class="itemTemplate">{CRPER_NOMBRES}</div></td>'+
                    '<td><div class="tituloTemplate"> Apellidos:</div></td>'+
                    '<td><div class="itemTemplate">{CRPER_APELLIDO_PATERNO}</div></td></tr>'+
                    '<tr rowspan="0">'+
                    '</table>'

            );

    var pnlInfoPersona = new Ext.Panel({
        id:'pnlImage',
        anchor: '100%',
        frame:true,
        height: 80,
        data:inInfoPersona,
        tpl:tmpInfoPersona
    });
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE AUSPICIANTE
     */
    var txtCrper_codigo = new Ext.form.TextField({
        id:'txtCrper_codigo',
        name:'txtCrper_codigo',
        fieldLabel :'Auspiciante',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true'
        //hidden:true
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE AUSPICIANTE PERSONA JURIDICA
     */
    var txtCrpjr_representante_legal= new Ext.form.TextField({
        id:'txtCrpjr_representante_legal',
        name:'txtCrpjr_representante_legal',
        fieldLabel :'Representante',
        anchor:'97%',
        readOnly:'true',
        disabled:true

    });

    var rdgTipoAuspiciante = new Ext.form.RadioGroup({
        id:'rdgTipoAuspiciante',
        fieldLabel: 'Tipo',
        itemCls: 'x-check-group-alt',
        items: [
            {
                boxLabel: 'Persona Natural',
                id:'rbPersonaNatural',
                name: 'rdgTipoAuspiciante',
                inputValue: TypeAuspiciante.NATURAL,
                checked: true
            },

            {
                boxLabel: 'Empresa',
                id: 'rbEmpresa',
                name: 'rdgTipoAuspiciante',
                inputValue: TypeAuspiciante.JURIDICA
            }
        ],
        listeners:{
            change: function(group,radio)
            {
                txtCrper_codigo.setValue('');
                txtCrpjr_representante_legal.setValue('');
                /*if (radio.getRawValue() == TypeAuspiciante.NATURAL)
                {
                    txtCrper_codigo.reset();
                    txtCrpjr_representante_legal.reset();
                }
                else
                {
                    txtCrper_codigo.reset();
                    txtCrpjr_representante_legal.reset();
                }*/
            }
        }

    });

    var strPersona = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_persona",
            method:"selectPageLite",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRPER_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRPER_CODIGO'},
            {name:'CRDID_CODIGO'},
            {name:'CRPER_NOMBRES'},
            {name:'CRPER_APELLIDO_PATERNO'},
            {name:'CRPER_APELLIDO_MATERNO'},
            {name:'CRPER_NUM_DOC_IDENTIFIC'},
            {name:'CRPER_FECHA_NACIMIENTO'},
            {name:'CRPER_LUGAR_NACIMIENTO'},
            {name:'CRPER_GENERO'},
            {name:'CRPER_OBSERVACIONES'},
            {name:'CRPER_NUMERO_RESIDENCIA'},
            {name:'CRPER_AUTORIZADO'},
            {name:'CRPER_NUMERO_EXPEDIENTE'}
        ]),
        sortInfo:{
            field: 'CRPER_APELLIDO_PATERNO',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON",
            inCrtst_codigo:TypeResidencia.NINGUNA,
            inCarnet:false,
            inIdentificacion:''
        }
        /* listeners:{
         load:function(inSource, inRecords, inOptions){
         if(inRecords.length > 0 && tmpLocal){
         tmpPersona = inRecords[0];
         loadPersona(tmpPersona);
         tmpLocal = false;

         }
         else
         {
         if(tmpFlag)
         {
         Ext.Msg.show({
         title: 'Aviso',
         msg: 'La persona solicitada no posee informaci\u00f3n asociada.',
         buttons: Ext.Msg.OK,
         icon: Ext.MessageBox.INFO

         });
         tmpFlag =  false;
         }
         }
         winFrmListadoCgg_res_carnet.getEl().unmask();
         }
         }*/
    });


    /**
     * CODIGO IDENTIFICATIVO DE REGISTRO DE AUSPICIANTE
     */
    var btnCrper_codigoCgg_res_tramite = new Ext.Button({
        id:'btnCrper_codigoCgg_res_tramite',
        iconCls:'iconBuscar',
        tooltip:'Buscar auspiciante',
        listeners:{
            click:function(){
                var objBusqueda =null;
                if(rdgTipoAuspiciante.getValue().getRawValue() == TypeAuspiciante.NATURAL){
                    var tmpTimeout = Ext.Ajax.timeout;
                    Ext.Ajax.timeout = 90000;
                    var tmpObjPersona = new Persona();
                    strPersona.baseParams.inCarnet = true;
                    strPersona.baseParams.inIdentificacion = '';
                    var objBusqueda = new DlgBusqueda(strPersona, tmpObjPersona.getColumnModel());
                    objBusqueda.closeHandler(function () {
                        tmpCarnet = false;
                        Ext.Ajax.timeout = tmpTimeout;
                        var tmpRecord = objBusqueda.getSelectedRow();
                        if(tmpRecord!=null && tmpRecord!=undefined)
                        {
                            txtCrper_codigo.setValue(tmpRecord.get('CRPER_NOMBRES')+" "+tmpRecord.get('CRPER_APELLIDO_PATERNO')+" "+tmpRecord.get('CRPER_APELLIDO_MATERNO'));
                            tmpAuspiciante = tmpRecord.get('CRPER_CODIGO');
                            tmpAuspiciantePJ = null;
                            txtCrpjr_representante_legal.setValue('');
                        }
                    });
                    objBusqueda.show();
                }else{
                    var tmpFLCgg_res_persona_juridica = new FrmListadoCgg_res_persona_juridica();
                    objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona_juridica.getStore(),tmpFLCgg_res_persona_juridica.getColumnModel());
                    objBusqueda.closeHandler(function(){
                        var tmpRecord = objBusqueda.getSelectedRow();
                        if(tmpRecord!=null && tmpRecord!=undefined){
                            txtCrper_codigo.setValue(tmpRecord.get('CRPJR_RAZON_SOCIAL'));
                            tmpAuspiciante = null;
                            tmpAuspiciantePJ=tmpRecord.get('CRPJR_CODIGO');
                            // Consulta de representante Legal
                            var scpRepresentantePersona = new SOAPClientParameters();
                            scpRepresentantePersona.add('inCrpjr_codigo',tmpRecord.get('CRPJR_CODIGO'));
                            scpRepresentantePersona.add('format',TypeFormat.JSON);
                            var tmpRepresentantePersonaRegistro = SOAPClient.invoke(URL_WS+"Cgg_res_representante_legal", 'selectRepresentantePersona', scpRepresentantePersona, false, null);
                            try{
                                tmpRepresentantePersonaRegistro = Ext.util.JSON.decode(tmpRepresentantePersonaRegistro);
                                txtCrpjr_representante_legal.setValue(tmpRepresentantePersonaRegistro[0].CRPER_NOMBRES);
                                tmpAuspiciante = tmpRepresentantePersonaRegistro[0].CRPER_CODIGO;
                            }
                            catch(inErr){}
                            //

                        }
                    });
                    objBusqueda.show();
                }
            }
        }
    });



    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_carnet_tramite
     */
    var btnAceptarCgg_res_beneficiario = new Ext.Button({
        id:'btnAceptarCgg_res_beneficiario',
        text:'Aceptar',
        iconCls:'iconGuardar',
        tooltip:'Guardar beneficiario',
        listeners:{
            click:function(){
                if (pnlCgg_res_beneficiario.getForm().isValid()==false){
                    return;
                }else{
                    var scpRepresentantePersona = new SOAPClientParameters();
                    scpRepresentantePersona.add('inCrtra_codigo',inInfoPersona.CRTRA_CODIGO);
                    scpRepresentantePersona.add('inCrper_codigo',tmpAuspiciante?tmpAuspiciante:null);
                    scpRepresentantePersona.add('inCrpjr_codigo',tmpAuspiciantePJ?tmpAuspiciantePJ:null);
                    var tmpResult = SOAPClient.invoke(URL_WS+"Cgg_res_tramite", 'updateAuspiciante', scpRepresentantePersona, false, null);
                    if ( tmpResult =="true")
                    {
                        Ext.Msg.show({
                            title: tituloCgg_res_beneficiario,
                            msg: 'La informaci\u00f3n de Auspiciante ha sido actualizada exitosamente.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.INFO
                        });
                        winFrmCgg_res_carnet_tramite.close();
                    }
                    else
                    {
                        Ext.Msg.show({
                            title: tituloCgg_res_beneficiario,
                            msg: 'La informaci\u00f3n de Auspiciante no ha podido ser almacenada.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.WARNING
                        });
                    }


                }
            }
        }
    });

    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_carnet_tramite.
     */
    var btnCerrarCgg_res_beneficiario = new Ext.Button({
        id:'btnCerrarCgg_res_beneficiario',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:'Cerrar formulario',
        listeners:{
            click:function(){
                winFrmCgg_res_carnet_tramite.close();
            }
        }
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_carnet_tramite.
     */
    var pnlCgg_res_beneficiario = new Ext.form.FormPanel({
        frame:true,
        anchor:'100%',
        items:[
            pnlInfoPersona,
            rdgTipoAuspiciante,
            {
                layout:'column',
                anchor:'100%',
                items:[{
                    columnWidth:.95,
                    layout:'form',
                    items:[txtCrper_codigo]
                },{
                    columnWidth:.05,
                    items:[btnCrper_codigoCgg_res_tramite]
                }]
            },
            txtCrpjr_representante_legal
        ]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_beneficiario.
     */
    var winFrmCgg_res_carnet_tramite = new Ext.Window({
        title:tituloCgg_res_beneficiario,
        tbar:getPanelTitulo(tituloCgg_res_beneficiario,descCgg_res_beneficiario),
        items:[pnlCgg_res_beneficiario],
        width:450,
        resizable:false,
        constrain:true,
        modal:true,
        bbar:[btnAceptarCgg_res_beneficiario,'->',btnCerrarCgg_res_beneficiario]
    });

    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_carnet_tramite.
     */
    function cargarCgg_res_beneficiarioCtrls(){
        if(inInfoPersona.CRPER_CODIGO_AUSPICIANTE != undefined && inInfoPersona.CRPER_CODIGO_AUSPICIANTE.length>0){
            if(inInfoPersona.CRPJR_CODIGO.length>0)
            {
                txtCrper_codigo.setValue(inInfoPersona.CRPJR_RAZON_SOCIAL);
                tmpAuspiciantePJ = inInfoPersona.CRPJR_CODIGO;
                txtCrpjr_representante_legal.setValue(inInfoPersona.CRPER_NOMBRE_AUSPICIANTE);
                tmpAuspiciante= inInfoPersona.CRPER_CODIGO_AUSPICIANTE;
                rdgTipoAuspiciante.setValue('rdgTipoAuspiciante',TypeAuspiciante.JURIDICA);
            }
            else
            {
                txtCrper_codigo.setValue(inInfoPersona.CRPER_NOMBRE_AUSPICIANTE);
                tmpAuspiciante= inInfoPersona.CRPER_CODIGO_AUSPICIANTE;
                rdgTipoAuspiciante.setValue('rdgTipoAuspiciante',TypeAuspiciante.NATURAL);
            }
        }
    }

    function consultarDatosPersona(inValue){

    }

    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_carnet_tramite.
     * @returns ventana winFrmCgg_res_carnet_tramite.
     * @base FrmCgg_res_carnet_tramite.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_carnet_tramite;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_carnet_tramite.
     * @base FrmCgg_res_carnet_tramite.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_beneficiarioCtrls();
    }

    this.data = function(){
        return inRecordCgg_res_beneficiario;
    }

    this.setTitle=function(inTitle){
        winFrmCgg_res_carnet_tramite.setTitle(inTitle);
        winFrmCgg_res_carnet_tramite.tbar = getPanelTitulo(tituloCgg_res_beneficiario,descCgg_res_beneficiario);
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_carnet_tramite desde una instancia.
 */
FrmCgg_res_carnet_tramite.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_carnet_tramite desde una instancia.
 */
FrmCgg_res_carnet_tramite.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_carnet_tramite,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_carnet_tramite.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_carnet_tramite desde una instancia.
 */
FrmCgg_res_carnet_tramite.prototype.loadData = function(){
    this.loadData();
}

FrmCgg_res_carnet_tramite.prototype.getData = function(){
    return this.data();
}

FrmCgg_res_carnet_tramite.prototype.setTitle = function(inTitle){
    return this.setTitle(inTitle);
}