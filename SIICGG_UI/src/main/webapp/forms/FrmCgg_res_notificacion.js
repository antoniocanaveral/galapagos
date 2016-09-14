/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_notificacion.
 * @param {String} INSENTENCIA_CGG_RES_NOTIFICACION Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_NOTIFICACION Registro de datos de la tabla Cgg_res_notificacion.
 * @constructor
 * @base FrmListadoCgg_res_notificacion
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_notificacion(INSENTENCIA_CGG_RES_NOTIFICACION,INRECORD_CGG_RES_NOTIFICACION) {
    var inSentenciaCgg_res_notificacion = INSENTENCIA_CGG_RES_NOTIFICACION;
    var inRecordCgg_res_notificacion = INRECORD_CGG_RES_NOTIFICACION;
    var urlCgg_res_notificacion = URL_WS + "Cgg_res_notificacion";
    var tituloCgg_res_notificacion = 'Ingreso  notificaciones';
    var descCgg_res_notificacion = 'Formulario para administrar informaci\u00f3n de notificaciones realizadas a personas irregulares';
    var isEdit = false;
    var tmpDependencias = new Array(9);
    var tmp_estado = TypeEstadoNotificacion.REGISTRADA;
    var tmpFecha;
    var tmpFecha_expul;
    var tmpFecha_audiencia;
    var tmpInformacionPersonaNotificacion;
    var rFilaNuevaPersona = Ext.data.Record.create(['CRPER_CODIGO', 'CRDID_CODIGO', 'CRPER_NUM_DOC_IDENTIFIC', 'CRPER_NOMBRES', 'CRPER_APELLIDO_PATERNO', 'CRPER_APELLIDO_MATERNO', 'CRPER_GENERO', 'CRECV_CODIGO', 'CRPER_FECHA_NACIMIENTO']);
    var tmpListadoIngreso;
    var tmpPluginNotificacion; //Variable utilizada para referenciar informacion capturada desde el plugin
    var tmpFirAuditText; //Variable de control biometrico
    var tmpFirText; //Variable de control biometrico
    var tmpHuellaImagenNotif;


    var rNotificado = new rFilaNuevaPersona({
        CRPER_CODIGO: '',
        CRDID_CODIGO: '',
        CRPER_NUM_DOC_IDENTIFIC: '',
        CRPER_NOMBRES: '',
        CRPER_APELLIDO_PATERNO: '',
        CRPER_APELLIDO_MATERNO: '',
        CRPER_GENERO: 0,
        CRECV_CODIGO: '',
        CRPER_FECHA_NACIMIENTO: ''
    });

    function PersonaNotificacion() {
        var cmPersonaNotificacion = null;
        var gsPersonaNotificacion = null;
        /**
         * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_persona.
         *
         */
        cmPersonaNotificacion = new Ext.grid.ColumnModel([
        {
            dataIndex:'CRPER_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
			hidden:true
        },
        {
            dataIndex:'CRPER_NOMBRES',
            header:'Nombres',
            width:150,
            sortable:true
        },
        {
            dataIndex:'CRPER_APELLIDO_PATERNO',
            header:'Primer apellido',
            width:150,
            sortable:true
        },
        {
            dataIndex:'CRPER_APELLIDO_MATERNO',
            header:'Segundo apellido',
            width:150,
            sortable:true
        },
        {
            dataIndex:'CRPER_NUM_DOC_IDENTIFIC',
            header:'Num doc identific',
            width:150,
            sortable:true
        },
        {
            dataIndex:'CRPER_NUMERO_RESIDENCIA',
            header:'Numero residencia',
            width:150,
            sortable:true
        }
        ]);
        /**
         * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_persona por un campo especifico.
         */
        gsPersonaNotificacion = new Ext.data.Store({
            proxy:new Ext.ux.bsx.SoapProxy({
                url:URL_WS + "Cgg_res_notificacion",
                method:"selectNotificacionConsultaNoResidente",
                pagin:true
            }),
            remoteSort:true,
            reader:new Ext.data.JsonReader({
                id:'CRPER_CODIGO',
                root:'dataSet',
                totalProperty: 'totalCount'
            }, [
           {
                name:'CRPER_CODIGO'
            },

            {
                name:'CRPER_NOMBRES'
            },

            {
                name:'CRPER_APELLIDO_PATERNO'
            },

            {
                name:'CRPER_APELLIDO_MATERNO'
            },
            {
                name:'CRPER_NUM_DOC_IDENTIFIC'
            },
            {
                name:'CRPER_NUMERO_RESIDENCIA'
            },
			{
                name:'CODIGO'
            }



            ]),
            sortInfo:{
                field: 'CRPER_CODIGO',
                direction: 'ASC'
            },
            baseParams:{
                keyword:"",
                format:"JSON"
            }
        });
        this.getCm = function() {
            return cmPersonaNotificacion;
        };

        this.getStore = function() {
            return gsPersonaNotificacion;
        }
    }

    PersonaNotificacion.prototype.getColumnModel = function() {
        return this.getCm();
    };

    PersonaNotificacion.prototype.getStore = function() {
        return this.getStore();
    };
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE NOTIFICACION
     */
    var txtCrnot_codigo = new Ext.form.TextField({
        id:'txtCrnot_codigo',
        name:'txtCrnot_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE NOTIFICACION
     */
    var txtCrtnt_codigo = new Ext.form.TextField({
        id:'txtCrtnt_codigo',
        name:'txtCrtnt_codigo',
        fieldLabel :'Codigo',
        hidden: true,
        anchor:'72%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });
    var txtCrtnt_tipo_notificacion = new Ext.form.TextField({
        id:'txtCrtnt_tipo_notificacion ',
        name:'txtCrtnt_tipo_notificacion ',
        fieldLabel :'Motivo',
        anchor:'98%',
        allowBlank :false,
        readOnly:true
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE NOTIFICACION
     */
    var btnCrtnt_codigoCgg_res_notificacion = new Ext.Button({
        id:'btnCrtnt_codigoCgg_res_notificacion',
        //text:'Crtnt_codigo',
        iconCls:'iconBuscar',
        tooltip:'Formulario Motivo Notificacion',
        listeners:{
            click:function() {
                var tmpFLCgg_res_tipo_notificacion = new FrmListadoCgg_res_tipo_notificacion();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_tipo_notificacion.getStore(), tmpFLCgg_res_tipo_notificacion.getColumnModel());
                objBusqueda.closeHandler(function() {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord){
                        tmpDependencias['TIPO_NOTIFICACION'] = tmpRecord.get('CRTNT_CODIGO');
                        txtCrtnt_tipo_notificacion.setValue(tmpRecord.get('CRTNT_SUSTENTO_LEGAL'));
                    }
                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
     */
    var txtCrper_codigo = new Ext.form.TextField({
        id:'txtCrper_codigo',
        name:'txtCrper_codigo',
        fieldLabel :'Codigo',
        hidden:true,
        anchor:'98%',
        allowBlank :false,
        readOnly:true,
        maxLength :50
    });
    var txtCrper_nombre = new Ext.form.TextField({
        id:'txtCrper_nombre',
        name:'txtCrper_nombre',
        fieldLabel :'Persona notificada',
        anchor:'98%',
        allowBlank :true,
        readOnly:'true',
        maxLength :200
    });

    var txtCrper_num_doc_identific_notificacion = new Ext.form.TextField({
        id:'txtCrper_num_doc_identific_notificacion',
        name:'txtCrper_num_doc_identific_notificacion',
        fieldLabel :'No. documento',
        labelWidth:60,
        enableKeyEvents:true,
        anchor:'98%',
        allowBlank : false,
        listeners: {
            specialkey: function(field, e){
                if (e.getKey() == e.ENTER) {
                    try{
                        function CallBackCgg_persona(r){
                            tmpInformacionPersonaNotificacion = Ext.util.JSON.decode(r)[0];
                            if(tmpInformacionPersonaNotificacion!=null){
                                tmpDependencias['PERSONA_NOT'] = tmpInformacionPersonaNotificacion.CRPER_CODIGO;
                                tmpInfoPersonaNotificacion.overwrite(Ext.getCmp('pnlPersonaConsultaNotificacion1').body,tmpInformacionPersonaNotificacion);
                                //MODIFICACION
                                if (tmpInformacionPersonaNotificacion.CODIGO == true ) {

                                    Ext.Msg.show({
                                        title:tituloCgg_res_notificacion,
                                        msg: 'La persona notificada es Residente permanente.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                    pnlNotificacion.disable();
                                    btnGuardarCgg_res_notificacion.disable();
                                    pnlHuellaNotificacion.disable();
                                }else{
                                    pnlNotificacion.enable();
                                    btnGuardarCgg_res_notificacion.enable();
                                    pnlHuellaNotificacion.enable();
                                }


                            }else{
                                Ext.Msg.show({
                                    title:tituloCgg_res_notificacion,
                                    msg: 'No existe el registro solicitado.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                                txtCrper_num_doc_identific_notificacion.reset();
                            }

                        }
                        var param = new SOAPClientParameters();
                        param.add('inCrper_num_doc_identific',txtCrper_num_doc_identific_notificacion.getValue());
                        param.add('format',TypeFormat.JSON);
                        SOAPClient.invoke(URL_WS+"Cgg_res_notificacion","selectPersonaNoResidente",param, true, CallBackCgg_persona);
                    }catch(inErr){
                    //winFrmCgg_institucion_educativa.getEl().unmask();
                    }

                }
            }
        }
    });

    var datosPersonaNotificacion= {

        CRPER_NOMBRES:'',
        CRPER_APELLIDO_PATERNO:'',
        CRPER_APELLIDO_MATERNO:'',
        CRPER_NUMERO_RESIDENCIA:'',
        CGNCN_NOMBRE:''
     }
    /*template de la consulta de persona historial*/
    var tmpInfoPersonaNotificacion = new Ext.XTemplate(
        '<table width="100%" height="100%" cellpadding="0">' +
        '<tr rowspan="0"><td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Nombres:</font></div></td>' +
        '<td><font size="1" face="Arial, Helvetica, sans-serif">{CRPER_NOMBRES}</font></td></td>' +
        '<td><div class="tituloTemplate"<font  face="Arial, Helvetica, sans-serif">Apellidos:</font></div></td>' +
        '<td><font size="1" face="Arial, Helvetica, sans-serif">{CRPER_APELLIDO_PATERNO} {CRPER_APELLIDO_MATERNO}</font></td></td>' +
        '<tr rowspan="0"><td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">No.residencia:</font></div></td>' +
        '<td><font size="1" face="Arial, Helvetica, sans-serif">{CRPER_NUMERO_RESIDENCIA}</font></td></td>' +
        '<td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Nacionalidad:</font></div></td>' +
        '<td><font size="1" face="Arial, Helvetica, sans-serif">{CGNCN_NOMBRE}</font></td></td>' +
        '<tr rowspan="0"><td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Residencia:</font></div></td>' +
        '<td><font size="1" face="Arial, Helvetica, sans-serif">{TIPO_RESIDENCIA}</font></td></td>' +
        '<td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif"></font></div></td>' +
        '<td><font size="1" face="Arial, Helvetica, sans-serif"></font></td></td>' +
        '</table>'

        );
    /*template de la consulta de persona notificacion*/
    var tmpInfoNotificacionEdit = new Ext.XTemplate(
        '<table width="100%" height="100%" cellpadding="0">' +
        '<tr rowspan="0"><td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Nombres:</font></div></td>' +
        '<td><font size="1" face="Arial, Helvetica, sans-serif">{CRPER_NOMBRES}{CRPER_APELLIDO_PATERNO}{APELLIDO_MATERNO} </font></td></td>' +
        '<td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Doc.identific:</font></div></td>' +
        '<td><font size="1" face="Arial, Helvetica, sans-serif">{CRPER_NUM_DOC_IDENTIFIC}</font></td></td>' +
        '<tr rowspan="0"><td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">No.residencia:</font></div></td>' +
        '<td><font size="1" face="Arial, Helvetica, sans-serif">{CRPER_NUMERO_RESIDENCIA}</font></td></td>' +
        '<td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Nacionalidad:</font></div></td>' +
        '<td><font size="1" face="Arial, Helvetica, sans-serif">{CRPER_NACIONALIDAD}</font></td></td>' +
        '</table>'
        );

    /**
     * CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
     */
    var btnCrper_codigoCgg_res_notificacion = new Ext.Button({
        id:'btnCrper_codigoCgg_res_notificacion',
        iconCls:'iconBuscar',
        tooltip:'Formulario persona',
        listeners:{
            click:function() {
                var tmpPersonaNotificacion= new PersonaNotificacion();
                var objBusqueda = new DlgBusqueda(tmpPersonaNotificacion.getStore(),tmpPersonaNotificacion.getCm());
                objBusqueda.closeHandler(function() {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord){

                        tmpDependencias['PERSONA_NOT'] = tmpRecord.get('CRPER_CODIGO');
                        tmpInfoPersonaNotificacion.overwrite(Ext.getCmp('pnlPersonaConsultaNotificacion1').body,tmpRecord.json);
                        txtCrper_num_doc_identific_notificacion.setValue(tmpRecord.get('CRPER_NUM_DOC_IDENTIFIC'));
                        if (tmpRecord.get('CODIGO') == true ) {

                            Ext.Msg.show({
                                title:tituloCgg_res_notificacion,
                                msg: 'La persona notificada es Residente permanente.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            pnlNotificacion.disable();
                            btnGuardarCgg_res_notificacion.disable();
                            pnlHuellaNotificacion.disable();
                        }else{
                            pnlNotificacion.enable();
                            btnGuardarCgg_res_notificacion.enable();
                            pnlHuellaNotificacion.enable();
                        }
                    }
                });
                objBusqueda.show();
            }
        }
    });

    var btnRegistrarPersonaNotificada = new Ext.Button({
        id: 'btnRegistrarPersonaNotificada',
        iconCls: 'iconNuevo',
        tooltip: 'Registro de persona no existente',
        listeners: {
            click: function(){
                var objBeneficiario = new FrmCgg_res_beneficiario(rNotificado);
                objBeneficiario.closeHandler(function(){
                    //alert(rNotificado.get('CRPER_CODIGO'));

                    rNotificado = objBeneficiario.getData();
                    if(rNotificado.get('CRPER_CODIGO').trim().length > 0 )
                    {
                        txtCrper_codigo.setValue(rNotificado.get('CRPER_CODIGO'));
                        tmpDependencias['PERSONA_NOT'] =txtCrper_codigo.getValue();
                        tmpInfoPersonaNotificacion.overwrite(Ext.getCmp('pnlPersonaConsultaNotificacion1').body,rNotificado.data);
                        txtCrper_num_doc_identific_notificacion.setValue(rNotificado.get('CRPER_NUM_DOC_IDENTIFIC'));
                    }

                });
                objBeneficiario.show();
                objBeneficiario.loadData();
            }
        }
    });
    /**
     * Ext.form.TextField ESTADO NOTIFICACIOCN
     */
    var txtCres_notificacion = new Ext.form.TextField({
        id:'txtCres_notificacion',
        name:'txtCres_notificacion',
        fieldLabel :'Estado',
        anchor:'98%',
        allowBlank :true,
        readOnly:'false',
        maxLength :20
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO DE USUARIO QUE REGISTRO LA NOTIFICACION
     */
    var txtCusu_codigo = new Ext.form.TextField({
        id:'txtCusu_codigo',
        name:'txtCusu_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :true,
        readOnly:'false',
        maxLength :20
    });
    var txtCrosg_nombre_usuario = new Ext.form.TextField({
        id:'txtCrosg_nombre_usuario',
        name:'txtCrosg_nombre_usuario',
        fieldLabel :'Oficial',
        anchor:'98%',
        allowBlank :false,
        readOnly:true,
        maxLength :50
    });
    /**
     * IDENTIFICATIVO DE USUARIO QUE REGISTRO LA NOTIFICACION
     */
    var btnCusu_codigoCgg_res_notificacion = new Ext.Button({
        id:'btnCusu_codigoCgg_res_notificacion',
        text:'Cusu_codigo',
        iconCls:'iconBuscar',
        tooltip:'Formulario usuario registro',
        listeners:{
            click:function() {
                var tmpFLCgg_usuario = new FrmListadoCgg_usuario();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_usuario.getStore(), tmpFLCgg_usuario.getColumnModel());
                objBusqueda.closeHandler(function() {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord){
                        tmpDependencias['USUARIO'] = tmpRecord.get('CUSU_CODIGO');
                    }

                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO DE USUARIO QUE REGISTRA LA AUDIENCIA
     */
    var txtCgg_cusu_codigo = new Ext.form.TextField({
        id:'txtCgg_cusu_codigo',
        name:'txtCgg_cusu_codigo',
        fieldLabel :'Cusu codigo',
        anchor:'98%',
        allowBlank :true,
        readOnly:'false',
        maxLength :50
    });

    /**
     * IDENTIFICATIVO DE USUARIO QUE REGISTRA LA AUDIENCIA
     */
    var btnCgg_cusu_codigoCgg_res_notificacion = new Ext.Button({
        id:'btnCgg_cusu_codigoCgg_res_notificacion',
        iconCls:'iconBuscar',
        tooltip:'Formulario usuario audiencia',
        listeners:{
            click:function() {
                var tmpFLCgg_usuario = new FrmListadoCgg_usuario();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_usuario.getStore(), tmpFLCgg_usuario.getColumnModel());
                objBusqueda.closeHandler(function() {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord){
                        tmpDependencias['USUARIO_AUD'] = tmpRecord.get('CGG_CUSU_CODIGO');
                    }
                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE SEGUIMIENTO QUE REALIZO LA AUDIENCIA
     */
    var txtCgg_crosg_codigo_audiencia = new Ext.form.TextField({
        id:' txtCgg_crosg_codigo_audiencia',
        name:' txtCgg_crosg_codigo_audiencia',
        fieldLabel :'Crosg codigo',
        anchor:'98%',
        readOnly:true,
        allowBlank :true
    });
    var txtCgg_nombre_usu_audiencia = new Ext.form.TextField({
        id:'txtCgg_nombre_usu_audiencia',
        name:'txtCgg_nombre_usu_audiencia',
        fieldLabel :'Oficial Audiencia',
        anchor:'98%',
        allowBlank :true,
        readOnly: true,
        maxLength :200
    });
    function OficialSeguimiento() {
        var cmOficialSeguimiento = null;
        var gsOficialSeguimiento = null;
        /**
         * Ext.grid.ColumnModel Define el modelo de columnas para el objeto Cgg_res_oficial_seguimiento_usuario.
         */
        var cmOficialSeguimiento = new Ext.grid.ColumnModel([
        {
            dataIndex:'CROSG_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true
        },

        {
            dataIndex:'CUSU_CODIGO',
            header:'Usuario',
            width:150,
            sortable:true,
            hidden:true
        },

        {
            dataIndex:'CRPER_NOMBRES',
            header:'Nombres',
            width:150,
            sortable:true
        },

        {
            dataIndex:'APELLIDOS',
            header:'Apellidos',
            width:150,
            sortable:true
        }
        ]);
        /**
         * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_oficial_seguimiento_usuario por un campo especifico.
         */
        var gsOficialSeguimiento = new Ext.data.Store({
            proxy:new Ext.ux.bsx.SoapProxy({
                url:URL_WS+"Cgg_res_notificacion",
                method:"selectOficialJefe",
                pagin:true
            }),
            remoteSort:true,
            reader:new Ext.data.JsonReader({
                id:'CROSG_CODIGO',
                root:'dataSet',
                totalProperty: 'totalCount'
            },[
            {
                name:'CROSG_CODIGO'
            },

            {
                name:'CUSU_CODIGO'
            },

            {
                name:'CRPER_NOMBRES'
            },

            {
                name:'APELLIDOS'
            }
            ]),
            sortInfo:{
                field: 'CUSU_CODIGO',
                direction: 'ASC'
            },
            baseParams:{
                keyword:"",
                format:"JSON"
            }
        });
        this.getCm = function() {
            return cmOficialSeguimiento;
        };

        this.getStore = function() {
            return gsOficialSeguimiento;
        }
    }

    OficialSeguimiento.prototype.getColumnModel = function() {
        return this.getCm();
    };

    OficialSeguimiento.prototype.getStore = function() {
        return this.getStore();
    };

    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE SEGUIMIENTO QUE REALIZO LA AUDIENCIA
     */
    var btnCgg_crosg_codigoCgg_res_notificacion = new Ext.Button({
        id:'btnCgg_crosg_codigoCgg_res_notificacion',
        iconCls:'iconBuscar',
        tooltip:'Listado oficial seguimiento audiencia',
        listeners:{
            click:function() {
                var tmpFLCgg_res_oficial_seguimiento_audiencia = new OficialSeguimiento();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_oficial_seguimiento_audiencia.getStore(), tmpFLCgg_res_oficial_seguimiento_audiencia.getColumnModel());
                objBusqueda.closeHandler(function() {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord) {
                        tmpDependencias['AUDIENCIA'] = tmpRecord.get('CROSG_CODIGO');
                        txtCgg_nombre_usu_audiencia.setValue(tmpRecord.get('CRPER_NOMBRES')+''+tmpRecord.get('APELLIDOS'));
                    }
                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
     */
    var txtCrres_codigo = new Ext.form.TextField({
        id:'txtCrres_codigo',
        name:'txtCrres_codigo',
        fieldLabel :'Codigo',
        hidden:true,
        anchor:'98%',
        allowBlank :true,
        readOnly:'true',
        maxLength :20
    });
    var txtCrres_resolucion = new Ext.form.TextField({
        id:'txtCrres_resolucion',
        name:'txtCrres_resolucion',
        fieldLabel :'Resoluci\u00f3n',
        anchor:'98%',
        allowBlank :true,
        readOnly:'false'
    });

    function ResolucionNotificacion() {
        var cmResolucionNotificacion = null;
        var gsResolucionNotificacion = null;
        /**
         * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_resolucion.
         */
        cmResolucionNotificacion = new Ext.grid.ColumnModel([
        {
            dataIndex:'CRRES_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true
        },

        {
            dataIndex:'CRSSC_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true
        },

        {
            dataIndex:'NUMERO_SESION',
            header:'Sesi\u00f3n',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CRRES_NUMERO_RESOLUCION',
            header:'N\u00famero',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CRRES_EXTRACTO_RESOLUCION',
            header:'Extracto',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CRRES_RESOLUCION_REEMPLAZA',
            header:'Resolucion reemplaza',
            width:150,
            sortable:true,
            hidden:true
        },

        {
            dataIndex:'CRRES_ESTADO_RESOLUCION',
            header:'Estado resolucion',
            width:150,
            sortable:true,
            hidden:true

        }]);
        /**
         * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_resolucion por un campo especifico.
         */
        var gsResolucionNotificacion = new Ext.data.Store({
            proxy:new Ext.ux.bsx.SoapProxy({
                url:URL_WS+"Cgg_res_notificacion",
                method:"selectResolucionNotificacion",
                pagin:true
            }),
            remoteSort:true,
            reader:new Ext.data.JsonReader({
                id:'CRRES_CODIGO',
                root:'dataSet',
                totalProperty: 'totalCount'
            },[
            {
                name:'CRRES_CODIGO'
            },

            {
                name:'CRSSC_CODIGO'
            },

            {
                name:'NUMERO_SESION'
            },

            {
                name:'CRRES_NUMERO_RESOLUCION'
            },

            {
                name:'CRRES_TIPO'
            },

            {
                name:'CRRES_EXTRACTO_RESOLUCION'
            },

            {
                name:'CRRES_RESOLUCION_REEMPLAZA'
            },

            {
                name:'CRRES_ESTADO_RESOLUCION'
            }
            ]),
            sortInfo:{
                field: 'NUMERO_SESION',
                direction: 'ASC'
            },
            baseParams:{
                keyword:"",
                format:'JSON'
            }
        });
        this.getCm = function() {
            return cmResolucionNotificacion;
        };

        this.getStore = function() {
            return gsResolucionNotificacion;
        }
    }

    ResolucionNotificacion.prototype.getColumnModel = function() {
        return this.getCm();
    };

    ResolucionNotificacion.prototype.getStore = function() {
        return this.getStore();
    };
    txtCrres_resolucion.setVisible(false);

    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
     */
    var btnCrres_codigoCgg_res_notificacion = new Ext.Button({
        id:'btnCrres_codigoCgg_res_notificacion',
        iconCls:'iconBuscar',
        tooltip:'Resoluci\u00f3n',
        listeners:{
            click:function() {
                var tmpFLCgg_res_resolucion = new ResolucionNotificacion();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_resolucion.getStore(), tmpFLCgg_res_resolucion.getColumnModel());
                objBusqueda.closeHandler(function() {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord){
                        tmpDependencias['RESOLUCION_NOT'] = tmpRecord.get('CRRES_CODIGO');
                        txtCrres_resolucion.setValue(tmpRecord.get('CRRES_EXTRACTO_RESOLUCION'));
                    }
                });
                objBusqueda.show();
            }
        }
    });
    btnCrres_codigoCgg_res_notificacion.setVisible(false);
    var btnDescargarAdjuntoNotificacion = new Ext.Button({
        id:'btnDescargarAdjuntoNotificacion',
        iconCls:'iconVer',
        listeners:{
            click:function(){
                if(isEdit){
                    if(INRECORD_CGG_RES_NOTIFICACION)
                    {
                        window.open(URL_DOC_VIEWER+'?table=cgg_res_notificacion&keyc=crnot_codigo&keyv='+inRecordCgg_res_notificacion.get('CRNOT_CODIGO')+'&column=crnot_adjunto_audiencia&fn='+inRecordCgg_res_notificacion.get('CRNOT_NOMBRE_ADJUNTO_AUDIENCIA')+'&request=view');
                    }
                }
            }
        }

    });
    function fnDenuncia(){
        /**
         * Ext.ColumnModel Agrupacion de registros de la tabla Cgg_res_persona por un campo especifico.
         */
        this.cmCgg_res_denuncia = new Ext.grid.ColumnModel([

        {
                dataIndex:'CRDEN_CODIGO',
                hidden:true,
                header:'Codigo',
                width:150,
                sortable:true
            },

            {
                dataIndex:'CRDEN_NUMERO',
                header:'Numero denuncia',
                width:200,
                sortable:true
            },

            {
                dataIndex:'CRDEN_DESCRIPCION',
                header:'Descripcion',
                width:400,
                sortable:true
            },

            {
                dataIndex:'CRDEN_ESTADO_DENUNCIA',
                hidden:true,
                header:'Estado denuncia',
                width:150,
                sortable:true
            }
            ]);

        /**
         * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_persona por un campo especifico.
         */
        this.gsCgg_res_denuncia = new Ext.data.Store({
            proxy:new Ext.ux.bsx.SoapProxy({
                url:URL_WS + "Cgg_res_denuncia",
                method:"selectPagePersonaDenuncia",
                pagin:true
            }),
            remoteSort:false,
            reader:new Ext.data.JsonReader({
                id:'CRPER_CODIGO',
                root:'dataSet',
                totalProperty: 'totalCount'
            }, [
            {
                name:'CRDEN_CODIGO'
            },

            {
                name:'CRDEN_NUMERO'
            },

            {
                name:'CRDEN_DESCRIPCION'
            },

            {
                name:'CRDEN_ESTADO_DENUNCIA'
            }

            ]),
            sortInfo:{
                field: 'CRDEN_CODIGO',
                direction: 'ASC'
            },
            baseParams:{
                keyword:"",
                format:"JSON",
                sort:"CRDEN_CODIGO",
                dir:"ASC"
            }
        });
    /**
         * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_notificacion.
         */
    /*this.pgBarCgg_res_denuncia = new Ext.PagingToolbar({
         store: gsCgg_res_denuncia,
         displayInfo: true,
         pageSize:RECORD_PAGE,
         displayMsg: 'Mostrando {0} - {1} de {2}',
         temptyMsg: 'No hay informaci\u00f3n para mostrar'
         });*/
    }
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE DENUNCIA
     */
    var txtCrden_codigo = new Ext.form.TextField({
        id:'txtCrden_codigo',
        name:'txtCrden_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :true,
        readOnly:'false',
        maxLength :20
    });

    var txtCrden_numero = new Ext.form.TextField({
        id:'txtCrden_numero',
        name:'txtCrden_numero',
        fieldLabel :'No.denuncia',
        anchor:'98%',
        allowBlank :true,
        readOnly:'true',
        maxLength :50
    });
    var txtCrden_descripcion = new Ext.form.TextArea({
        id:'txtCrden_descripcion',
        name:'txtCrden_descripcion',
        fieldLabel :'Descripcion',
        anchor:'98%',
        allowBlank :true,
        readOnly:'false',
        height:22

    });

    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE DENUNCIA
     */
    var btnCrden_codigoCgg_res_notificacion = new Ext.Button({
        id:'btnCrden_codigoCgg_res_notificacion',
        iconCls:'iconBuscar',
        tooltip:'Denuncia',
        listeners:{
            click:function() {
                //var tmpFLCgg_res_denuncia = new FrmListadoCgg_res_denuncia(null,0);
                var objBusqueda = new DlgBusqueda(new fnDenuncia().gsCgg_res_denuncia, new fnDenuncia().cmCgg_res_denuncia);
                objBusqueda.closeHandler(function() {
                    var tmpRecord = objBusqueda.getSelectedRow();

                    if (tmpRecord)
                    {
                        tmpDependencias['DENUNCIA'] = tmpRecord.get('CRDEN_CODIGO');
                        txtCrden_numero.setValue(tmpRecord.get('CRDEN_NUMERO'));
                        txtCrden_descripcion.setValue(tmpRecord.get('CRDEN_DESCRIPCION'));
                    }

                });
                objBusqueda.show();


            }
        }
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
     */
    var txtCctn_codigo = new Ext.form.TextField({
        id:'txtCctn_codigo',
        name:'txtCctn_codigo',
        fieldLabel :'Codigo',
        hidden: true,
        anchor:'98%',
        allowBlank :true,
        readOnly:'true',
        maxLength :20
    });

    /**
     * Ext.data.Store Almacenamiento de informacion de canton.
     */
    var scCantonNotificacion = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_canton",
            method:"selectAll"
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({},[
        {
            name:'CCTN_CODIGO'
        },

        {
            name:'CGPRV_CODIGO'
        },

        {
            name:'CCTN_NOMBRE'
        },

        {
            name:'CCTN_DESCRIPCION'
        }
        ]),
        baseParams:{
            format:TypeFormat.JSON
        },
        listeners:{
            load:function()
            {
                if (isEdit)
                {
                    cbxCanton.setValue(inRecordCgg_res_notificacion.get('CCTN_CODIGO'));
                    cbxCanton.hiddenValue = inRecordCgg_res_notificacion.get('CCTN_CODIGO');
                }
            }
        }

    });
    scCantonNotificacion.load();


    //Creamos una definici�n de los campos que vienen en el Json remoto

    var cbxCanton = new Ext.form.ComboBox({
        store:scCantonNotificacion,
        id:'cbxCanton',
        name:'cbxCanton',
        displayField: "CCTN_NOMBRE",
        fieldLabel :'Cant\u00f3n',
        valueField: 'CCTN_CODIGO',
        mode:'local',
        typeAhead:true,
        autoSelect:true,
        hiddenId:'cbxCantonH',
        hiddenName:'cbxCantonH',
        hiddenValue:'id',
        forceSelection:true,
        editable: true,
        triggerAction:'all',
        submitValue:true,
        anchor:'75%',
        emptyText : 'Seleccione una opci\u00f3n..',
        allowBlank:false

    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE SEGUIMIENTO
     */
    var txtCrosg_codigo_notificacion = new Ext.form.TextField({
        id:'txtCrosg_codigo_notificacion',
        name:'txtCrosg_codigo_notificacion',
        fieldLabel :'Codigo',
        hidden:true,
        anchor:'98%',
        readOnly:'true',
        allowBlank :true
    });

    var txtCrosg_nombre_oficial_notificacion = new Ext.form.TextField({
        id:' txtCrosg_nombre_oficial',
        name:' txtCrosg_nombre_oficial',
        fieldLabel :'Nombre oficial',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false,
        maxLenght:200
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE SEGUIMIENTO
     */
    var btnCrosg_codigoCgg_res_notificacion_oficial = new Ext.Button({
        id:'btnCrosg_codigoCgg_res_notificacion_oficial',
        iconCls:'iconBuscar',
        tooltip:'Formulario oficial seguimiento',
        listeners:{
            click:function() {
                var tmpFLCgg_res_oficial_seguimiento = new FrmListadoCgg_res_oficial_seguimiento_usuario();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_oficial_seguimiento.getStore(), tmpFLCgg_res_oficial_seguimiento.getColumnModel());
                objBusqueda.closeHandler(function() {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord)
                    {
                        tmpDependencias['NOTIFICACION_PER'] = (tmpRecord.get('CROSG_CODIGO'));
                        txtCrosg_nombre_oficial_notificacion.setValue(tmpRecord.get('CUSU_NOMBRES')+''+tmpRecord.get('CUSU_APELLIDOS'));
                    }


                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Ext.form.TextField NUMERO SECUENCIAL UNICO DE IDENTIFICACION
     */
    var txtCrnot_numero_notificacion = new Ext.form.TextField({
        id:'txtCrnot_numero_notificacion',
        name:'txtCrnot_numero_notificacion',
        fieldLabel :'No.notificaci\u00f3n',
        anchor:'75%',
        allowBlank :false,
        maxLength :50

    });
    /**
     * Ext.form.DateField FECHA EN QUE SE REALIZO LA NOTIFICACION
     */
    var dtCrnot_fecha_notificacion = new Ext.form.DateField({
        id:'dtCrnot_fecha_notificacion',
        name:'dtCrnot_fecha_notificacion',
        fieldLabel :'Fecha',
        allowBlank :true,
        value:new Date(),
        format:'d/m/Y',
        anchor:'98%',
        maxValue:new Date()


    });
    /**
     * Ext.form.TextField LUGAR/LOCAL DE LA NOTIFICACION
     */
    var txtCrnot_lugar_notificacion = new Ext.form.TextField({
        id:'txtCrnot_lugar_notificacion',
        name:'txtCrnot_lugar_notificacion',
        fieldLabel :'Lugar notificaci\u00f3n',
        anchor:'98%',
        allowBlank :true,
        maxLength :200
    });
    /**
     * Ext.form.TextField REFERENCIA DONDE SE ENTREGO LA NOTIFICACION
     */
    var txtCrnot_referencia = new Ext.form.TextField({
        id:'txtCrnot_referencia',
        name:'txtCrnot_referencia',
        fieldLabel :'Referencia',
        anchor:'98%',
        allowBlank :true,
        maxLength :200
    });
    /**
     * Ext.form.TextField OBSERVACION DE LA NOTIFICACION
     */
    var txtCrnot_observacion = new Ext.form.TextArea({
        id:'txtCrnot_observacion',
        name:'txtCrnot_observacion',
        fieldLabel :'Observaci\u00f3n',
        allowBlank :false,
        anchor:'98%',
        width:'50%'


    });
    /**
     * Ext.form.TextField OBSERVACION DE LA NOTIFICACION
     */
    var txtCrnot_estatus = new Ext.form.TextArea({
        id:'txtCrnot_estatus',
        name:'txtCrnot_estatus',
        fieldLabel :'Estatus',
        allowBlank :false,
        anchor:'98%',
        width:'50%'



    });
    /**
     * Ext.form.NumberField ESTADO DE LA NOTIFICACION
     0 - REGISTRADA
     1 - PROCESADA
     2 - ANULADA
     */
    var chkCrnot_estado = new Ext.form.Checkbox({
        id:'chkCrnot_estado',
        name:'chkCrnot_estado',
        fieldLabel:'Anular',
        checked:false,
        submitValue:false,
        hideLabel:true,
        listeners:{
            check:function( control,  checked ){
                if(checked == true){
                    Ext.Msg.show({
                        title:tituloCgg_res_notificacion,
                        msg:'Est\u00e1 seguro de anular la notificaci\u00f3n?',
                        buttons: Ext.Msg.YESNO,
                        fn: function(btn){
                            if (btn=='yes'){
                                pnlAudiencia.setDisabled(true);
                                tmp_estado = TypeEstadoNotificacion.ANULADA;
                                btnGuardarCgg_res_notificacion.fireEvent('click', btnGuardarCgg_res_notificacion);
                            }else{
                                chkCrnot_estado.setValue(false);
                            }
                        },
                        icon: Ext.MessageBox.QUESTION
                    });
                }
            }
        }

    });
    chkCrnot_estado.setVisible(false);

    /**
     * Ext.form.NumberField ESTATUS MIGRATORIO
     */
    var cbxCrnot_estatus = new Ext.form.ComboBox({
        id:'cbxCrnot_estatus',
        name:'cbxCrnot_estatus',
        store: dttipo_estatus_migratorio,
        fieldLabel :'Regularizaci\u00f3n',
        displayField: 'estatus_migratorio',
        valueField: 'id',
        mode:'local',
        typeAhead:true,
        autoSelect:true,
        hiddenId:'cbxCrnot_estatusH',
        hiddenName:'cbxCrnot_estatusH',
		//hiddenValue:'id',
        forceSelection:true,
        editable: true,
        triggerAction:'all',
        submitValue:true,
        anchor:'98%',
        emptyText : 'Seleccione una opci\u00f3n..',
        allowBlank : false,
        listeners:{
            select:function(){
                if(cbxCrnot_estatus.getValue()==Typeestatus_migratorio.PERMITIDO){
                    //if(isEdit && txtCres_notificacion.getValue()==TypeEstadoNotificacion.EJECUTADA){

                    function SWRCgg_res_notificacion(btn){
                        if (btn=='yes'){
                            //btnGuardarCgg_res_notificacion.fireEvent('click', btnGuardarCgg_res_notificacion);
                            txtCrres_resolucion.setVisible(true);
                            btnCrres_codigoCgg_res_notificacion.setVisible(true);
                        }
                        else
                        {
                            cbxCrnot_estatus.setValue(Typeestatus_migratorio.NO_PERMITIDO)
                        }
                    }
                    Ext.Msg.show({
                        title:'Aviso',
                        msg:'Est\u00e1 seguro de cambiar el estatus migratorio?',
                        buttons: Ext.Msg.YESNO,
                        fn: SWRCgg_res_notificacion,
                        icon: Ext.MessageBox.QUESTION
                    });

                /* }else{

                        Ext.Msg.show({
                            title:tituloCgg_res_notificacion,
                            msg: 'La Notificacion no ha sido ejecutada.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.INFO
                        });
                        cbxCrnot_estatus.setValue()==Typeestatus_migratorio.NO_PERMITIDO;
                    }*/
                }
                else{

                    txtCrres_resolucion.setVisible(false);
                    btnCrres_codigoCgg_res_notificacion.setVisible(false);
                    txtCrres_resolucion.reset();
                    txtCrres_codigo.reset();

                }
            }

        },
        value:0
    });
    /**
     * Ext.form.DateField FECHA DE  AUDIENCIA PARA ANALISIS O JUSTIFICACION DE LA NOTIFICACION
     */
    var dtCrnot_fecha_audiencia = new Ext.form.DateField({
        id:'dtCrnot_fecha_audiencia',
        name:'dtCrnot_fecha_audiencia',
        fieldLabel :'Fecha',
        allowBlank :true,
        value:new Date(),
        format:'d/m/Y',
        submitValue:false,
        anchor:'98%',
        maxValue:new Date()
    });
    /**
     * Ext.form.TextArea RESUMEN DEL CONTENIDO DE LA AUDIENCIA
     */
    var txtCrnot_extracto_audiencia = new Ext.form.TextArea({
        id:'txtCrnot_extracto_audiencia',
        name:'txtCrnot_extracto_audiencia',
        fieldLabel :'Extracto',
        width:'60%',
        allowBlank:true,
        anchor:'98%'
    });
    /**
     * Ext.form.TextField OBSERVACION REGISTRADA EN AL AUDIENCIA
     */
    var txtCrnot_observacion_audiencia = new Ext.form.TextArea({
        id:'txtCrnot_observacion_audiencia',
        name:'txtCrnot_observacion_audiencia',
        fieldLabel :'Observaci\u00f3n',
        anchor:'98%',
        width:'60%',
        allowBlank :true
    });
    /**
     * Ext.form.Checkbox ESTADO QUE DETERMINA SI SE  APLICA LA NOTIFICACION
     SI
     NO
     */
    var chkCrnot_procede_notificacion = new Ext.form.Checkbox({
        id:'chkCrnot_procede_notificacion',
        name:'chkCrnot_procede_notificacion',
        fieldLabel:'Procede notificaci\u00f3n',
        allowBlank :true,
        anchor:'90%',
        checked:true,
        hideLabel:true
    });
    chkCrnot_procede_notificacion.setVisible(false);
    /**
     * Ext.form.TextField DESCRIPCION DEL DOCUMENTO ADJUNTO
     */
    var txtCrnot_descripcion_adjunto_aud = new Ext.form.TextArea({
        id:'txtCrnot_descripcion_adjunto_aud',
        name:'txtCrnot_descripcion_adjunto_aud',
        fieldLabel :'Descripci\u00f3n',
        anchor:'98%',
        allowBlank :true,
        maxLength :100,
        autoScroll:true
    });
    /**
     * Ext.form.TextField NOMBRE DEL DOCUMENTO ADJUNTO DE LA AUDIENCIA
     */
    var txtCrnot_nombre_adjunto_audiencia = new Ext.form.TextField({
        id:'txtCrnot_nombre_adjunto_audiencia',
        name:'txtCrnot_nombre_adjunto_audiencia',
        fieldLabel :'Nombre adjunto',
        anchor:'98%',
        allowBlank :true,
        maxLength :50,
        hideLabel:true
    });
    txtCrnot_nombre_adjunto_audiencia.setVisible(false);
    /**
     * ARCHIVO DIGITAL ANEXO
     */
    var filCrnot_adjunto_audiencia = new Ext.form.FileUploadField({
        id:'filCrnot_adjunto_audiencia',
        name:'filCrnot_adjunto_audiencia',
        fieldLabel :'Archivo adjunto',
        disabled :false,
        anchor:'98%',
        buttonCfg: {
            text: '',
            iconCls: 'iconAdjunto'
        }
    });
    /**
     * Ext.form.DateField FECHA DE SALIDA VOLUNTARIA COMO CONSECUENCIA DE LA APLICACION DE LA RESOLUCION
     */
    var dtCrnot_fecha_salida_volunt = new Ext.form.DateField({
        id:'dtCrnot_fecha_salida_volunt',
        name:'dtCrnot_fecha_salida_volunt',
        fieldLabel :'Fecha salida',
        format:'d/m/Y',
        submitValue:false,
        anchor:'70%',
        minValue: new Date()
    });

    /**
     * Ext.form.DateField FECHA DE EXPULSION COMO CONSECUENCIA DE LA APLICACION DE LA RESOLUCION
     */
    var dtCrnot_fecha_expulsion = new Ext.form.DateField({
        id:'dtCrnot_fecha_expulsion',
        name:'dtCrnot_fecha_expulsion',
        fieldLabel :'Fecha expulsi\u00f3n',
        allowBlank :true,
        format:'d/m/Y',
        submitValue:false,
        minValue: new Date()

    });
    dtCrnot_fecha_expulsion.setVisible(false);

    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_notificacion
     */
    var btnGuardarCgg_res_notificacion = new Ext.Button({
        id:'btnGuardarCgg_res_notificacion',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltips:TypeTooltip.GUARDAR,
        listeners:{
            click:function() {
                if (pnlCgg_res_Notificacion.getForm().isValid() == false) {
                    return;
                }
                /*if (!pnlAudiencia.disabled)
                {
                    if (txtCgg_nombre_usu_audiencia.getValue().length == 0)
                    {
                        txtCgg_nombre_usu_audiencia.markInvalid("Es necesario definir un Oficial de audiencia");
                        return;
                    }
                    else
                    {
                        txtCgg_nombre_usu_audiencia.clearInvalid();
                    }
                }*/

                if (filCrnot_adjunto_audiencia.getValue() && filCrnot_adjunto_audiencia.getValue().length > 0){
                    txtCrnot_nombre_adjunto_audiencia.setValue(filCrnot_adjunto_audiencia.getValue());
                }

                tmpDependencias['USUARIO_AUD'] = tmpDependencias['USUARIO_AUD'] ? tmpDependencias['USUARIO_AUD'] : null;
                tmpDependencias['DENUNCIA'] = tmpDependencias['DENUNCIA'] ? tmpDependencias['DENUNCIA'] : null;
                tmpDependencias['AUDIENCIA'] = tmpDependencias['AUDIENCIA'] ? tmpDependencias['AUDIENCIA'] : null;
                tmpDependencias['RESOLUCION_NOT'] = tmpDependencias['RESOLUCION_NOT'] ? tmpDependencias['RESOLUCION_NOT'] : null;
                tmpFecha = isEdit && dtCrnot_fecha_salida_volunt.getValue() ? dtCrnot_fecha_salida_volunt.getValue().format('d/m/Y') : null;
                tmpFecha_expul = isEdit && dtCrnot_fecha_expulsion.getValue() ? dtCrnot_fecha_expulsion.getValue().format('d/m/Y') : null;
                tmpFecha_audiencia = isEdit && dtCrnot_fecha_audiencia.getValue() ? dtCrnot_fecha_audiencia.getValue().format('d/m/Y') : null;
                /*if (chkCrnot_estado.getValue()==true) {
                    tmp_estado=TypeEstadoNotificacion.ANULADA;
                }else{
                    tmp_estado=TypeEstadoNotificacion.REGISTRADA;
                }*/
                if(isEdit==true && chkCrnot_estado.getValue()==false&&tmpFecha_audiencia && tmp_estado != TypeEstadoNotificacion.EJECUTADA){
                    tmp_estado=TypeEstadoNotificacion.PROCESADA;
                }
                if(cbxCrnot_estatus.getValue()==Typeestatus_migratorio.PERMITIDO ){
                    //tmp_estado=TypeEstadoNotificacion.PERMITIDO_INGRESO;
                    if (txtCrres_resolucion.getValue().length == 0)
                    {
                        txtCrres_resolucion.markInvalid("Es necesario seleccionar una resoluci\u00f3n de respaldo");
                        return;
                    }
                }

                Ext.getCmp('pnlCgg_res_Notificacion').getForm().submit({
                    url: URL_WS + "Cgg_res_notificacionSRV",
                    success: function(fp, o) {
                        if(isEdit==true && pnlAudiencia.disabled){
                            Ext.Msg.show({
                                title:tituloCgg_res_notificacion,
                                msg: 'La Notificacion sera procesada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_res_notificacion,
                                msg: 'La informaci\u00f3n  ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                        }

                        winFrmCgg_res_notificacion.close();
                    },
                    failure:function(fp,o) {
                        Ext.Msg.show({
                            title:tituloCgg_res_notificacion,
                            msg: 'La informaci\u00f3n  no ha podido ser almacenada.'+ o,//(o.result.msg?o.result.msg:o),
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.ERROR
                        });
                    },
                    params:{
                        request:INSENTENCIA_CGG_RES_NOTIFICACION,
                        crnot_codigo:tmpDependencias['CODIGO_NOTIFICACION'],
                        crtnt_codigo:tmpDependencias['TIPO_NOTIFICACION'],
                        crper_codigo:tmpDependencias['PERSONA_NOT'],
                        cusu_codigo:tmpDependencias['USUARIO'],
                        cgg_cusu_codigo:tmpDependencias['USUARIO_AUD'],
                        cgg_crosg_codigo:tmpDependencias['AUDIENCIA'],
                        crres_codigo:tmpDependencias['RESOLUCION_NOT'],
                        crden_codigo:tmpDependencias['DENUNCIA'],
                        crosg_codigo:tmpDependencias['NOTIFICACION_PER'],
                        crden_denuncia:tmpDependencias['ESTADO'],
                        dtCrnot_fecha_salida_volunt:tmpFecha,
                        dtCrnot_fecha_expulsion:tmpFecha_expul,
                        dtCrnot_fecha_audiencia:tmpFecha_audiencia,
                        chkCrnot_estado:tmp_estado,
                        inNuevoBeneficiario: rNotificado.get('CRPER_CODIGO').trim().length == 0 ? null : Ext.util.JSON.encode(rNotificado.data),//+']'
                        crper_huella_dactilar:tmpFirText?tmpFirText:null,
                        crper_huella_imagen:tmpHuellaImagenNotif?tmpHuellaImagenNotif:null,
                        crper_huella_cadena:tmpFirAuditText?tmpFirAuditText:null
                    }
                });
            }
        }
    });
    var tmpInfoPersonaImpedidaIngreso;
    tmpInfoPersonaImpedidaIngreso = new Ext.XTemplate(
        '<table width="100%" height="100%" cellpadding="5">' +
        '<tbody>' +

        '<tpl for="."'+
        '<tr>'+

        '<div class="tituloTemplate"<font  face="Arial, Helvetica, sans-serif">{msg}</font></div></td>' +
        '<td >',
        '</tr>' +
        '</tpl>'+
        '</tbody>' +
        '</table>'


        );


    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_notificacion.
     */
    var btnCerrarCgg_res_notificacion = new Ext.Button({
        id:'btnCerrarCgg_res_notificacion',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltips:TypeTooltip.CERRAR,
        listeners:{
            click:function() {
                winFrmCgg_res_notificacion.close();

            }
        }
    });



    /**
     * Ext.form.FormPanel Panel principal que contiene los  datos persona.
     */
    var pnlCgg_res_notificacion_persona = new Ext.Panel({
        //id:'pnlPersonaConsul',
        //anchor:'100% 100%',
        items:[
        {
            xtype:'panel',//layout:'column',
            defaults: {      // defaults applied to items
                // layout: 'form',
                // border: false,
                bodyStyle: 'padding:4px'
            },
            items:[
            {
                xtype:'fieldset',
                // columnWidth: 0.75,
                layout:'form',

                title:'Datos personales',
                //tpl:tplInfoPersona,
                items:[
                {
                    xtype:'panel',
                    layout:'column',
                    items:[

                    {
                        columnWidth:.45,
                        layout:'form',
                        labelWidth:105,
                        items:[txtCrper_num_doc_identific_notificacion]
                    }
                    ,{
                        columnWidth:.05,
                        layout:'form',
                        items:[btnCrper_codigoCgg_res_notificacion]
                    },

                    {
                        columnWidth:.05,
                        layout:'form',
                        items:[btnRegistrarPersonaNotificada]
                    }
                    ]
                },

                {
                    xtype:'panel',
                    id :'pnlPersonaConsultaNotificacion1',
                    data:datosPersonaNotificacion,
                    tlp:tmpInfoPersonaNotificacion
                }]
            } ]
        }],

        frame:true
    });



    var pnlNotificacion = new Ext.Panel({
        frame:true,
        labelWidth :110,
        layout:'form',
        title: 'Notificaci\u00f3n',
        items:[
        {
            xtype:'panel',
            labelWidth :110,
            layout:'column',
            items:[
            {
                columnWidth:.6,
                layout:'form',
                items:[txtCrnot_numero_notificacion]
            },


            {
                columnWidth:.4,
                labelWidth :80,
                layout:'form',
                items:[  dtCrnot_fecha_notificacion]
            }
            ]
        },


        {
            xtype:'panel',

            layout:'column',
            items:[
            {
                columnWidth:.6,
                labelWidth :110,
                layout:'form',
                items:[cbxCanton]
            },

            {
                columnWidth:.4,
                labelWidth :80,
                layout:'form',
                items:[]
            }

            ]
        },

        {
            xtype:'panel',
            labelWidth :110,
            layout:'column',
            items:[
            {
                columnWidth:.95,
                layout:'form',
                items:[txtCrosg_nombre_oficial_notificacion]
            },

            {
                columnWidth:.05,
                layout:'form',
                items:[btnCrosg_codigoCgg_res_notificacion_oficial]
            }

            ]
        },

        {
            xtype:'panel',
            layout:'column',
            items:[
            {
                columnWidth:.95,
                //labelWidth :100,
                layout:'form',
                items:[txtCrtnt_tipo_notificacion]
            },

            {
                columnWidth:.05,
                layout:'form',
                items:[btnCrtnt_codigoCgg_res_notificacion]

            }
            ]
        },
        txtCrnot_lugar_notificacion,
        txtCrnot_referencia,
        txtCrnot_observacion,
        {
            xtype:'panel',
            layout:'column',
            items:[

            {
                columnWidth:.50,
                labelWidth :110,
                layout:'form',
                items:[cbxCrnot_estatus]
            },//dtCrnot_fecha_expulsion]},

            {
                columnWidth:.50,
                layout:'form',
                items:[chkCrnot_estado]
            }

            ]
        }, {
            xtype:'panel',
            layout:'column',
            items:[
            {
                columnWidth:.95,
                layout:'form',
                labelWidth :110,
                items:[txtCrres_resolucion]
            },

            {
                columnWidth:.05,
                layout:'form',
                items:[btnCrres_codigoCgg_res_notificacion]
            }
            ]
        },

        {
            xtype:'fieldset',
            // frame:true,
            checkboxToggle:true,
            labelWidth :100,
            title: 'Denuncia',
            //autoHeight:true,
            collapsed: true,
            listeners:{
                collapse:function(){
                    winFrmCgg_res_notificacion.doLayout();

                }
            },
            items:[
            {
                xtype:'panel',
                layout:'column',
                labelWidth :100,
                items:[
                {
                    columnWidth:.5,
                    layout:'form',
                    items:[txtCrden_numero]
                },

                {
                    columnWidth:.05,
                    layout:'form',
                    items:[btnCrden_codigoCgg_res_notificacion]
                }
                ]
            },
            txtCrden_descripcion


            ]
        }
        ]
    });
    var pnlAudiencia = new Ext.Panel({
        id:'pnlAudiencia',
        frame:true,
        layout:'form',
        title: 'Audiencia',
        // disabled:true,
        labelWidth :110,
        fileUpload:true,
        items:[
        {
            xtype:'panel',
            layout:'column',
            items:[
            {
                columnWidth:.55,
                layout:'form',
                items:[txtCgg_nombre_usu_audiencia]
            },

            {
                columnWidth:.05,
                layout:'form',
                items:[btnCgg_crosg_codigoCgg_res_notificacion]
            },

            {
                columnWidth:.4,
                labelWidth :80,
                layout:'form',
                items:[dtCrnot_fecha_audiencia]
            }
            ]
        },
        txtCrnot_extracto_audiencia,
        txtCrnot_observacion_audiencia,
        {
            xtype:'panel',
            layout:'column',
            items:[
            {
                columnWidth:.6,
                labelWidth:110,
                layout:'form',
                items:[dtCrnot_fecha_salida_volunt]
            }
            ]
        },

        {
            xtype:'fieldset',
            checkboxToggle:true,
            title: 'Adjunto Audiencia',
            autoHeight:true,
            collapsed: true,

            items :[
            {
                xtype:'panel',
                layout:'column',
                fileUpload:true,
                items:[
                {
                    columnWidth:.65,
                    layout:'form',
                    items:[filCrnot_adjunto_audiencia]
                },

                {
                    columnWidth:.35,
                    layout:'form',
                    items:[btnDescargarAdjuntoNotificacion]
                }

                ]
            },txtCrnot_descripcion_adjunto_aud
            ]
        }

        ]

    });

    var objImageDefaultNotif={
        HUELLA:'resources/images/fingerprint.jpg'
    };
    var tplHuellaNotificacion = new Ext.Template('<div style="height: 100% ; width:100% ; padding:5px 0px 0px 5px;text-align: center;"' +
        '><img id="imgHuellaNotificacion" src={HUELLA}  width = "55%"  height = "90%" /></div>');

    var pnlHuellaNotificacion = new  Ext.Panel({
        id : 'pnlHuellaNotificacion ',
        title: 'Huella Dactilar',
        html:'<object id="bsxCrperNotifBiometric" type="' + SII_mimeType + '" width="0" height="0"></object>',
        frame :true,
        anchor:'100% 100%',
        items :[
        {
            xtype:'panel',
            layout:'column',
            items:
            [
            {
                columnWidth:.9,
                layout:'form',
                items:[

                {
                    xtype:'panel',
                    // region:'center',
                    id:'pnlHuella',
                    height:180,
                    anchor:'100% 100%',
                    data:objImageDefaultNotif,
                    tpl:tplHuellaNotificacion
                }
                ]
            }
            ,
            {
                columnWidth:.1,
                layout:'form',
                items:
                [
                {
                    xtype:'button',
                    iconCls:'iconHand',
                    arrowAlign :'bottom',
                    tooltip:'Capturar huella',
                    listeners:{
                        click:function()
                        {
                            if ( txtCrper_num_doc_identific_notificacion.getValue()){
                                if(!tmpPluginNotificacion){
                                    tmpPluginNotificacion = document.getElementById("bsxCrperNotifBiometric");
                                }
                                var tmpIdPersonaNotificacion;
                                tmpIdPersonaNotificacion = txtCrper_num_doc_identific_notificacion.getValue();
                                var tmpHuella = tmpPluginNotificacion.enroll(tmpIdPersonaNotificacion);
                                if(tmpHuella == 0){
                                    tmpFirAuditText = tmpPluginNotificacion.firAuditText;//dato completo
                                    tmpFirText = tmpPluginNotificacion.firText;//dato tratado
                                    if(!isEdit)
                                    {
                                        Ext.Ajax.request({
                                            url: URL_WS+'Biometrico',
                                            success: function(inResponse){
                                                var tmpJSON = Ext.util.JSON.decode(inResponse.responseText)
                                                tmpHuellaImagenNotif = tmpJSON.msg;
                                                var tmpImgHuella = document.getElementById("imgHuellaNotificacion");
                                                tmpImgHuella.src = 'data:image/jpg;base64,'+ tmpHuellaImagenNotif;
                                            },
                                            failure: function(inResponse){
                                            },
                                            params: {
                                                op: 'photo',
                                                data: tmpFirAuditText
                                            }
                                        });
                                    }
                                    else
                                    {
                                        Ext.Ajax.request({
                                            url: URL_WS+'Biometrico',
                                            success: function(inResponse){
                                                var tmpJSON = Ext.util.JSON.decode(inResponse.responseText)
                                                tmpHuellaImagenNotif = tmpJSON.msg;
                                                var tmpImgHuella = document.getElementById("imgHuellaNotificacion");
                                                tmpImgHuella.src = 'data:image/jpg;base64,'+ tmpHuellaImagenNotif;
                                            },
                                            failure: function(inResponse){
                                            },
                                            params: {
                                                op: 'update',
                                                data: tmpFirAuditText,
                                                dataAudit: tmpFirText,
                                                id: tmpDependencias['PERSONA_NOT']
                                            }
                                        });
                                    }
                                }else{
                                    Ext.Msg.show({
                                        title: tituloCgg_res_notificacion,
                                        msg: tmpPluginNotificacion.message,
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
                            }else{
                                Ext.Msg.show({
                                    title: tituloCgg_res_notificacion,
                                    msg: 'Es necesario seleccionar informaci\u00f3n de una persona!!!',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }


                        }
                    }
                },
                {
                    xtype:'button',
                    iconCls:'iconBuscar',
                    arrowAlign :'bottom',
                    tooltip:'Verificar informaci\u00f3n dactilar',
                    listeners:
                    {
                        click:function()
                        {
                            if(!tmpPluginNotificacion){
                                tmpPluginNotificacion = document.getElementById("bsxCrperNotifBiometric");
                            }
                            var tmpIdPersonaNotificacion;
                            tmpIdPersonaNotificacion = txtCrper_num_doc_identific_notificacion.getValue();
                            var tmpHuella = tmpPluginNotificacion.capture();
                            if(tmpHuella == 0){
                                tmpFirText = tmpPluginNotificacion.firText;//dato procesado utilizado para verificacion
                                Ext.Ajax.request({
                                    url: URL_WS+'Biometrico',
                                    success: function(inResponse){
                                        var tmpJSON = Ext.util.JSON.decode(inResponse.responseText);
                                        if(tmpJSON.success == false)
                                        {
                                            Ext.Msg.show({
                                                title: tituloCgg_res_notificacion,
                                                msg: tmpJSON.msg,
                                                buttons: Ext.Msg.OK,
                                                icon: Ext.MessageBox.ERROR
                                            });
                                        }
                                        else
                                        {
                                            Ext.Msg.show({
                                                title: tituloCgg_res_notificacion,
                                                msg: "Informaci\u00f3n validada correctamente",
                                                buttons: Ext.Msg.OK,
                                                icon: Ext.MessageBox.INFO
                                            });
                                        }

                                    },
                                    failure: function(inResponse){
                                        var tmpJSON = Ext.util.JSON.decode(inResponse.responseText)
                                        Ext.Msg.show({
                                            title: tituloCgg_res_notificacion,
                                            msg: "Ha ocurrido un error en el proceso de verificacion",
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.ERROR
                                        });
                                    //alert(inResponse.responseText);

                                    },
                                    params: {
                                        op: 'verify',
                                        data: tmpFirText,
                                        id: tmpIdPersonaNotificacion
                                    }
                                });
                            }
                            else
                            {
                                Ext.Msg.show({
                                    title: tituloCgg_res_notificacion,
                                    msg: tmpPluginNotificacion.message,
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
        }

        ]
    });


    var tabNotificacion = new Ext.TabPanel({
        region:'center',
        activeTab:0,
        frame:true,
        defaults:{
            autoHeight: true
        },
        items:[pnlNotificacion,pnlAudiencia,pnlHuellaNotificacion]
    });



    var pnlCgg_res_Notificacion = new Ext.form.FormPanel({
        id:'pnlCgg_res_Notificacion',
        name:'pnlCgg_res_Notificacion',
        frame:false,
        layout:'form',
        fileUpload:true,
        items:[pnlCgg_res_notificacion_persona,tabNotificacion]
    });


    /**
     * Funcion que permite controlar los dias maximos para realizar la audiencia
     */
    function tiempoMaximo() {
        function callBackTiempoMaximo(r) {
            if(r=='false')
            {
            // pnlAudiencia.disabled;
            }
            else
            {
                pnlAudiencia.enable();
            }
        }
        var param = new SOAPClientParameters();
        param.add('inCrnot_codigo',txtCrnot_codigo.getValue());
        SOAPClient.invoke(urlCgg_res_notificacion,'tiempoAudiencia',param,true,callBackTiempoMaximo);
    }

    //tiempoMaximo();

    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_notificacion.
     */
    var winFrmCgg_res_notificacion = new Ext.Window({
        id:'winFrmCgg_res_notificacion',
        title:tituloCgg_res_notificacion,
        tbar:getPanelTitulo(tituloCgg_res_notificacion, descCgg_res_notificacion),
        items:[pnlCgg_res_Notificacion],
        width:600,
        modal:true,
        minWidth:600,
        height:500,
        minHeight:500,
        //maximizable:true,
        //minimizable:true,
        autoHeight:true,
        layout:'anchor',
        resizable:false,
        shadow:false,
        // collapsed:true,
        constrain:true,
        bbar:[btnGuardarCgg_res_notificacion,'->',btnCerrarCgg_res_notificacion],
        listeners:{
            show:function(){
                if(isEdit){
                    if(INRECORD_CGG_RES_NOTIFICACION)
                    {
                        txtCrper_num_doc_identific_notificacion.setVisible(false);
                        btnCrper_codigoCgg_res_notificacion.setVisible(false);
                        btnRegistrarPersonaNotificada.setVisible(false);
                        tmpInfoNotificacionEdit.overwrite( Ext.getCmp('pnlPersonaConsultaNotificacion1').body,inRecordCgg_res_notificacion.json);

                    }
                    /*    else
                     {
                     alert('NOOOOO');
                     }*/


                    tabNotificacion.setActiveTab(2);
                    tabNotificacion.setActiveTab(0);
                    consultarImagen();

                }
            }
        }


    });

    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_notificacion.
     */
    function cargarCgg_res_notificacionCtrls() {
        if (inRecordCgg_res_notificacion) {
            tmpDependencias['CODIGO_NOTIFICACION'] = inRecordCgg_res_notificacion.get('CRNOT_CODIGO');
            tmpDependencias['TIPO_NOTIFICACION'] = inRecordCgg_res_notificacion.get('CRTNT_CODIGO');
            tmpDependencias['PERSONA_NOT'] = inRecordCgg_res_notificacion.get('CRPER_CODIGO');
            tmpDependencias['USUARIO'] = inRecordCgg_res_notificacion.get('CUSU_CODIGO');
            tmpDependencias['USUARIO_AUD'] = inRecordCgg_res_notificacion.get('CGG_CUSU_CODIGO');
            tmpDependencias['AUDIENCIA'] = inRecordCgg_res_notificacion.get('CGG_CROSG_CODIGO');
            tmpDependencias['RESOLUCION_NOT'] = inRecordCgg_res_notificacion.get('CRRES_CODIGO');
            tmpDependencias['DENUNCIA'] = inRecordCgg_res_notificacion.get('CRDEN_CODIGO');
            tmpDependencias['NOTIFICACION_PER'] = inRecordCgg_res_notificacion.get('CROSG_CODIGO');
            txtCrnot_codigo.setValue(inRecordCgg_res_notificacion.get('CRNOT_CODIGO'));
            txtCrtnt_codigo.setValue(inRecordCgg_res_notificacion.get('TIPO_NOTIFICACION'));
            txtCrtnt_tipo_notificacion.setValue(inRecordCgg_res_notificacion.get('CRTNT_SUSTENTO_LEGAL'));
            txtCrper_codigo.setValue(inRecordCgg_res_notificacion.get('PERSONA_NOT'));
            txtCrper_nombre.setValue(inRecordCgg_res_notificacion.get('CRPER_NOMBRE_PERSONA'));
            txtCrper_num_doc_identific_notificacion.setValue(inRecordCgg_res_notificacion.data.CRPER_NUM_DOC_IDENTIFIC);
            txtCusu_codigo.setValue(inRecordCgg_res_notificacion.get('USUARIO'));
            txtCgg_cusu_codigo.setValue(inRecordCgg_res_notificacion.get('USUARIO_AUD'));
            txtCrres_codigo.setValue(inRecordCgg_res_notificacion.get('RESOLUCION_NOT'));
            txtCrres_resolucion.setValue(inRecordCgg_res_notificacion.get('CRRES_RESOLUCION'));
            txtCrden_codigo.setValue(inRecordCgg_res_notificacion.get('DENUNCIA'));
            txtCrden_numero.setValue(inRecordCgg_res_notificacion.get('CRDEN_NUMERO'));
            txtCrden_descripcion.setValue(inRecordCgg_res_notificacion.get('CRDEN_DESCRIPCION'));
            //            cbxCanton.setValue(inRecordCgg_res_notificacion.get('CCTN_CODIGO'));
            //           cbxCanton.setValue(inRecordCgg_res_notificacion.get('CCNT_NOMBRE'));
            txtCrosg_codigo_notificacion.setValue(inRecordCgg_res_notificacion.get('NOTIFICACION_PER'));
            txtCrosg_nombre_oficial_notificacion.setValue(inRecordCgg_res_notificacion.get('NOMBRE_OFICIAL'));
            txtCgg_crosg_codigo_audiencia.setValue(inRecordCgg_res_notificacion.get('AUDIENCIA'));
            txtCgg_nombre_usu_audiencia.setValue(inRecordCgg_res_notificacion.get('NOMBRE_AUDIENCIA'));
            txtCrnot_numero_notificacion.setValue(inRecordCgg_res_notificacion.get('CRNOT_NUMERO_NOTIFICACION'));
            dtCrnot_fecha_notificacion.setValue(truncDate(inRecordCgg_res_notificacion.get('CRNOT_FECHA_NOTIFICACION')));
            txtCrnot_lugar_notificacion.setValue(inRecordCgg_res_notificacion.get('CRNOT_LUGAR_NOTIFICACION'));
            txtCrnot_referencia.setValue(inRecordCgg_res_notificacion.get('CRNOT_REFERENCIA'));
            txtCrnot_observacion.setValue(inRecordCgg_res_notificacion.get('CRNOT_OBSERVACION'));
            txtCres_notificacion.setValue(inRecordCgg_res_notificacion.get('CRNOT_ESTADO_NOTIFICACION'));
            tmp_estado = inRecordCgg_res_notificacion.get('CRNOT_ESTADO_NOTIFICACION');
            if(txtCres_notificacion.getValue()==TypeEstadoNotificacion.ANULADA){
                chkCrnot_estado.checked=true;
                btnGuardarCgg_res_notificacion.disable();

            }
            cbxCrnot_estatus.setValue(inRecordCgg_res_notificacion.get('CRNOT_REGULARIZACION'));
            if(inRecordCgg_res_notificacion.get('CRNOT_REGULARIZACION')==Typeestatus_migratorio.PERMITIDO){
                txtCrres_resolucion.setVisible(true);
                btnCrres_codigoCgg_res_notificacion.setVisible(true);
            }
            dtCrnot_fecha_audiencia.setValue(truncDate(inRecordCgg_res_notificacion.get('CRNOT_FECHA_AUDIENCIA')));
            txtCrnot_extracto_audiencia.setValue(inRecordCgg_res_notificacion.get('CRNOT_EXTRACTO_AUDIENCIA'));
            txtCrnot_observacion_audiencia.setValue(inRecordCgg_res_notificacion.get('CRNOT_OBSERVACION_AUDIENCIA'));
            chkCrnot_procede_notificacion.setValue(inRecordCgg_res_notificacion.get('CRNOT_PROCEDE_NOTIFICACION'));
            txtCrnot_descripcion_adjunto_aud.setValue(inRecordCgg_res_notificacion.get('CRNOT_DESCRIPCION_ADJUNTO_AUD'));
            filCrnot_adjunto_audiencia.setValue(inRecordCgg_res_notificacion.get('CRNOT_NOMBRE_ADJUNTO_AUDIENCIA'));
            dtCrnot_fecha_salida_volunt.setValue(truncDate(inRecordCgg_res_notificacion.get('CRNOT_FECHA_SALIDA_VOLUNT')));

            dtCrnot_fecha_salida_volunt.setMinValue(inRecordCgg_res_notificacion.get('CRNOT_FECHA_SALIDA_VOLUNT')?truncDate(inRecordCgg_res_notificacion.get('CRNOT_FECHA_SALIDA_VOLUNT')):new Date());
            dtCrnot_fecha_expulsion.setValue(truncDate(inRecordCgg_res_notificacion.get('CRNOT_FECHA_EXPULSION')));
            isEdit = true;
            //  cbxCanton.hiddenValue = inRecordCgg_res_notificacion.get('CCTN_CODIGO');
            cbxCrnot_estatus.hiddenValue = inRecordCgg_res_notificacion.get('CRNOT_REGULARIZACION');
            chkCrnot_estado.hideLabel=false;
            chkCrnot_estado.setVisible(true);
            dtCrnot_fecha_expulsion.setVisible(false);

            tiempoMaximo();
        /* if(txtCres_notificacion.getValue()==TypeEstadoNotificacion.REGISTRADA || txtCres_notificacion.getValue()==TypeEstadoNotificacion.PROCESADA ){*/
        //chkCrnot_estado.setVisible(true);
        //}else{chkCrnot_estado.setVisible(false);}
        }
    }

    /**
     * Funcion que permite consultar informacion de archivos generales correspondientes a la persona
     * */
    function consultarImagen()
    {
        try{
            function CallBackCgg_res_adjuntos(r){
                var tmpArchivosResult =  Ext.util.JSON.decode(r);
                if (tmpArchivosResult[0].CRPER_HUELLA_IMAGEN != undefined)
                {
                    var tmpImgCtrlHuella = document.getElementById("imgHuellaNotificacion");
                    tmpImgCtrlHuella.src = 'data:image/jpg;base64,'+ tmpArchivosResult[0].CRPER_HUELLA_IMAGEN;

                }
            }
            var param = new SOAPClientParameters();
            param.add('inCrper_codigo',inRecordCgg_res_notificacion.get('CRPER_CODIGO'));
            param.add('format',TypeFormat.JSON);
            SOAPClient.invoke(URL_WS + 'Cgg_res_persona','selectAdjuntosIdentificacionById',param, true, CallBackCgg_res_adjuntos);
        }catch(inErr){
            Ext.Msg.show({
                title:tituloCgg_res_notificacion,
                msg: 'La informaci\u00f3n de documentos adjuntos no ha podido ser consultada.',
                buttons: Ext.Msg.OK,
                icon: Ext.MessageBox.ERROR
            });
        }
    }

    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_notificacion.
     * @returns ventana winFrmCgg_res_notificacion.
     * @base FrmCgg_res_notificacion.prototype.show
     */
    this.getWindow = function() {
        return winFrmCgg_res_notificacion;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_notificacion.
     * @base FrmCgg_res_notificacion.prototype.loadData
     */
    this.loadData = function() {
        cargarCgg_res_notificacionCtrls();
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_notificacion desde una instancia.
 */
FrmCgg_res_notificacion.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_notificacion desde una instancia.
 */
FrmCgg_res_notificacion.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_notificacion,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_notificacion.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_notificacion desde una instancia.
 */
FrmCgg_res_notificacion.prototype.loadData = function(){
    this.loadData();
}
