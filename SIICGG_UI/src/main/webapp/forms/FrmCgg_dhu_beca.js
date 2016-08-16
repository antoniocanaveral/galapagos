/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_dhu_beca.
 * @param {String} IN_SENTENCIA_CGG_DHU_BECA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_DHU_BECA Registro de datos de la tabla Cgg_dhu_beca.
 * @constructor
 * @base FrmListadoCgg_dhu_beca
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_dhu_beca(IN_SENTENCIA_CGG_DHU_BECA,IN_RECORD_CGG_DHU_BECA){
    var inSentenciaCgg_dhu_beca = IN_SENTENCIA_CGG_DHU_BECA;
    var inRecordCgg_dhu_beca=IN_RECORD_CGG_DHU_BECA;
    var urlCgg_dhu_beca=URL_WS+"Cgg_dhu_beca";
    var tituloCgg_dhu_beca='Registro beca';
    var descCgg_dhu_beca='El formulario permite administrar la informaci\u00f3n de beca';
    var isEdit = false;
    var tmpNumeroDocumento = null;
    var regTipoDocumentoRepresentante;
    var EliAdjunto= new Array ();
    var tmpListadoEliminar1;
    var tmpInformacionPersonaPermanente;
    var tmpTipoAprobacion;
    var tmpValorSalida=0;
    var tmpValorRetorno=0;
	var swTemp = false;
	/**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE BECA
     */
    var txtCdbec_codigo = new Ext.form.TextField({
        id:'txtCdbec_codigo',
        name:'txtCdbec_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true
    });

    /**
     * Ext.form.TextField TIPO DOCUMENTO
     */
    var txtCdhu_codigo = new Ext.form.TextField({
        id:'txtCdhu_codigo',
        name:'txtCdhu_codigo',
        fieldLabel :'Tipo Documento',
        anchor:'98%',
        readOnly:true
    });
    /**
     * Ext.form.TextField NOMBRES DE LA PERSONA
     */
    var txtCdhu_nombres = new Ext.form.TextField({
        id:'txtCdhu_nombres',
        name:'txtCdhu_nombres',
        fieldLabel :'Nombres',
        anchor:'98%',
		readOnly:true
    });
    /**
     * Ext.form.TextField APELLIDO PATERNO
     */
    var txtCdhu_apellido_paterno = new Ext.form.TextField({
        id:'txtCdhu_apellido_paterno',
        name:'txtCdhu_apellido_paterno',
        fieldLabel :'Apellido ',
        anchor:'98%',
		readOnly:true
    });

    /**
     * Ext.form.TextField NUMERO DE DOCUEMNTO DE IDENTIFICACION
     */
    var txtCdhu_num_doc_identific = new Ext.form.TextField({
        id:'txtCdhu_num_doc_identific',
        name:'txtCdhu_num_doc_identific',
        fieldLabel :'No. identificaci\u00f3n',
        anchor:'98%',
		readOnly:true
	});
    /**
     * Ext.form.TextField Residencia
     */
    var txtCdhu_residencia = new Ext.form.TextField({
        id:'txtCdhu_residencia',
        name:'txtCdhu_residencia',
        fieldLabel :'No.Residencia',
        anchor:'98%',
        readOnly:true
    });
    /**
     * Ext.form.TextField Lugar nacimiento
     */
    var txtCdhu_lugar_nacimiento = new Ext.form.TextField({
        id:'txtCdhu_lugar_nacimiento',
        name:'txtCdhu_lugar_nacimiento',
        fieldLabel :'Lugar nacimiento',
        anchor:'98%',
		readOnly:true
    });
    /**
     * Ext.form.TextField Edad DE LA PERSONA
     */
    var txtCdhu_edad = new Ext.form.TextField({
        id:'txtCdhu_edad',
        name:'txtCdhu_edad',
        fieldLabel :'Edad',
        anchor:'98%',readOnly:'true'
    });

    /**
     * Ext.form.DateField FECHA DE NACIMIENTO
     */
    var dtCdhu_fecha_nacimiento = new Ext.form.DateField({
        id:'dtCdhu_fecha_nacimiento',
        name:'dtCdhu_fecha_nacimiento',
        fieldLabel :'Fecha nacimiento',
        format:'d/m/Y',
        disabled:true
    });
    /**
     * Ext.form.TextField Codigo del perfil
     */
    var txtCdhu_perfil_codigo = new Ext.form.TextField({
        id:'txtCdhu_perfil_codigo',
        name:'txtCdhu_perfil_codigo',
        fieldLabel :'Codigo perfil',
        anchor:'98%',readOnly:'true'
    });
    /**
     * Ext.form.TextField Nivel estudio DE LA PERSONA
     */
    var txtCdhu_nivel_estudio = new Ext.form.TextField({
        id:'txtCdhu_nivel_estudio',
        name:'txtCdhu_nivel_estudio',
        fieldLabel :'Nivel estudio',
        anchor:'98%',readOnly:'true'
    });
    /**
     * Ext.form.TextField Institucion DE LA PERSONA
     */
    var txtCdhu_institucion_edu = new Ext.form.TextField({
        id:'txtCdhu_institucion_edu',
        name:'txtCdhu_institucion_edu',
        fieldLabel :'Instituci\u00f3n Educativa',
        anchor:'98%',readOnly:'true'
    });
    /**
     * Ext.form.TextField Titulo DE LA PERSONA
     */
    var txtCdhu_titulo_prof = new Ext.form.TextField({
        id:'txtCdhu_titulo_prof',
        name:'txtCdhu_titulo_prof',
        fieldLabel :'T\u00edtulo',
        anchor:'98%',readOnly:'true'
    });

    /**
     * Ext.form.TextField Especialidad DE LA PERSONA
     */
    var txtCdhu_especialidad= new Ext.form.TextField({
        id:'txtCdhu_especialidad',
        name:'txtCdhu_especialidad',
        fieldLabel :'Especialidad',
        anchor:'98%',readOnly:'true'
    });
    /**
     * Ext.form.TextField Modalidad DE LA PERSONA
     */
    var txtCdhu_modalidad_curso = new Ext.form.TextField({
        id:'txtCdhu_modalidad_curso',
        name:'txtCdhu_modalidad_curso',
        fieldLabel :'Modalidad',
        anchor:'98%',readOnly:'true'
    });
    /**
     * Ext.form.TextField Nivel Aprobado DE LA PERSONA
     */
    var txtCdhu_nivel_aprobado = new Ext.form.TextField({
        id:'txtCdhu_nivel_aprobado',
        name:'txtCdhu_nivel_aprobado',
        fieldLabel :'Nivel aprobado',
        anchor:'98%',readOnly:'true'
    });
    /**
     * Ext.form.TextField nivel confirmado
     */
    var txtCdhu_confirmado = new Ext.form.TextField({
        id:'txtCdhu_confirmado',
        name:'txtCdhu_confirmado',
        fieldLabel :'Confirmado',
        anchor:'98%',readOnly:'true'
    });
    /**
     * Ext.form.DateField FECHA INICIO
     */
    var dtCdhu_fecha_confirmado = new Ext.form.DateField({
        id:'dtCdhu_fecha_confirmado',
        name:'dtCdhu_fecha_confirmado',
        fieldLabel :'Fecha confirmado',
        format:'d/m/Y',
        disabled:true
    });
    /**
     * Ext.form.DateField FECHA DE INICIO
     */
    var dtCdhu_fecha_inicio = new Ext.form.DateField({
        id:'dtCdhu_fecha_inicio',
        name:'dtCdhu_fecha_inicio',
        fieldLabel :'Fecha inicio',
        format:'d/m/Y',
        disabled:true
    });
    /**
     * Ext.form.DateField FECHA FIN
     */
    var dtCdhu_fecha_fin = new Ext.form.DateField({
        id:'dtCdhu_fecha_fin',
        name:'dtCdhu_fecha_fin',
        fieldLabel :'Fecha fin',
        format:'d/m/Y',
        disabled:true
    });

  

    /**
     * CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
     */
    var btnCrper_codigoCgg_dhu_beca = new Ext.Button({
        id:'btnCrper_codigoCgg_dhu_beca',        
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var objPersona = new PersonaResidentePermanente();
                var objBusqueda = new DlgBusqueda(objPersona.getStore(),objPersona.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
						if(tmpRecord.get('NUM_REGISTROS')==0){
							txtCrper_codigo.setValue(tmpRecord.get('CRPER_CODIGO'));
							txtCdhu_codigo.setValue(tmpRecord.get('CRDID_TIPO'));
							txtCrper_numero_documento.setValue(tmpRecord.get('CRPER_NUM_DOC_IDENTIFIC'));
							txtCdhu_num_doc_identific.setValue(tmpRecord.get('CRPER_NUM_DOC_IDENTIFIC'));
							txtCdhu_nombres.setValue(tmpRecord.get('CRPER_NOMBRES'));
							txtCdhu_apellido_paterno.setValue(tmpRecord.get('CRPER_APELLIDO_PATERNO')+' '+tmpRecord.get('CRPER_APELLIDO_MATERNO'));
							txtCdhu_residencia.setValue(tmpRecord.get('CRPER_NUMERO_RESIDENCIA'));
							txtCdhu_lugar_nacimiento.setValue(tmpRecord.get('CRPER_LUGAR_NACIMIENTO'));
							dtCdhu_fecha_nacimiento.setValue(truncDate(tmpRecord.get('CRPER_FECHA_NACIMIENTO')));
							txtCdhu_edad.setValue(calcularEdad( Date.parse(truncDate(tmpRecord.get('CRPER_FECHA_NACIMIENTO'))).format('Y-m-d')));
							txtCrper_codigo_residente.setValue(tmpRecord.get('CODIGO'));
							if(txtCrper_codigo_residente.getValue()!='03'){
								Ext.Msg.show({
									title:tituloCgg_dhu_beca,
									msg:'La persona seleccionada no es residente',
									buttons:Ext.Msg.OK,
									icon:Ext.MessageBox.INFO
								});
								tabBeca.disable();
							}else{
								tabBeca.enable();
							}
							gsCgg_gem_perfil_prof_beca.load({
								params:{
									inCrper_codigo:txtCrper_codigo.getValue(),
									format:TypeFormat.JSON
								}});
						}else{
							Ext.Msg.show({
								title:tituloCgg_dhu_beca,
								msg:'La persona seleccionada ya tiene una beca en proceso',
								buttons:Ext.Msg.OK,
								icon:Ext.MessageBox.INFO
							});
							txtCrper_numero_documento.setValue('');
							txtCdhu_codigo.setValue('');
							txtCdhu_nombres.setValue('');
							txtCdhu_residencia.setValue('');
							txtCdhu_num_doc_identific.setValue('');
							txtCdhu_apellido_paterno.setValue('');
							txtCdhu_lugar_nacimiento.setValue('');
							txtCdhu_edad.setValue('');
						}						
                    }
                });
                objBusqueda.show();
            }}
    });

    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
     */
    var txtCdirp_codigo = new Ext.form.TextField({
        id:'txtCdirp_codigo',
        name:'txtCdirp_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        hidden:true,
        hideLabel:true

    });
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
     */
    var txtCrper_codigo_representante = new Ext.form.TextField({
        id:'txtCrper_codigo_reprsentante',
        name:'txtCrper_codigo_reprsentante',
        fieldLabel :'Codigo',
        anchor:'98%',
        hidden:true,
        hideLabel:true

    });
    /**
     * Ext.form.TextField NOMBRES DE LA PERSONA
     */
    var txtCrper_nombres_representante = new Ext.form.TextField({
        id:'txtCrper_nombres_representante',
        name:'txtCrper_nombres_representante',
        fieldLabel :'Nombres',
        anchor:'98%',
		readOnly : true
    });
    /**
     * Ext.form.TextField APELLIDO PATERNO
     */
    var txtCrper_apellido_paterno_representante = new Ext.form.TextField({
        id:'txtCrper_apellido_paterno_representante',
        name:'txtCrper_apellido_paterno_representante',
        fieldLabel :'Primer apellido',
        anchor:'98%',
		readOnly : true
    });
    /**
     * Ext.form.TextField APELLIDO MATERNO
     */
    var txtCrper_apellido_materno_representante = new Ext.form.TextField({
        id:'txtCrper_apellido_materno_representante',
        name:'txtCrper_apellido_materno_representante',
        fieldLabel :'Segundo apellido',
        anchor:'98%',
		readOnly : true
    });

    /**
     * Ext.form.TextField NUMERO DE DOCUEMNTO DE IDENTIFICACION
     */
    var txtCrper_num_doc_identific_representante = new Ext.form.TextField({
        id:'txtCrper_num_doc_identific_representante',
        name:'txtCrper_num_doc_identific_representante',
        fieldLabel :'No. identific.',
        anchor:'98%',
        allowBlank :true,
        invalidText : 'Es necesario definir un numero de identificaci\u00f3n ',
        listeners:{
            change : function(fld, valn, valo) {
                var tmp = validarCedula(valn);
                if (tmp== true){
                    tmpNumeroDocumento = valn;
                    gsPersonabecaRepresentanteBuscar.reload({
                        params:{
                            inCrper_num_doc_identific:tmpNumeroDocumento,
                            format:TypeFormat.JSON
                        }
                    });
                }
                else
                {
                    Ext.MessageBox.alert('Registro de Ingreso de Personas a la Provincia', 'Numero de identificacion no valido');
                }
            }
        }
    });
    /**
     * Ext.form.TextField N. RESIDENCIA
     */
    var txtCrper_residencia_representante = new Ext.form.TextField({
        id:'txtCrper_residencia_representante',
        name:'txtCrper_residencia_representante',
        fieldLabel :'No.Residencia',
        anchor:'98%',
		readOnly : true
    });
    /**
     * Ext.form.TextField Descripcion Representante
     */
    var txtCrper_descripcion_representante = new Ext.form.TextField({
        id:'txtCrper_descripcion_representante',
        name:'txtCrper_descripcion_representante',
        fieldLabel :'Descripci\u00f3n',
        anchor:'98%'
		//readOnly : true
    });
    /**
     * Ext.form.TextField Codigo
     */
    var txtCrper_codigo_residente = new Ext.form.TextField({
        id:'txtCrper_codigo_residente',
        name:'txtCrper_codigo_residente',
        fieldLabel :'codido',
        anchor:'98%'
    });
    //Creamos una definici?n de los campos que vienen en el Json remoto DEL TIPO DE BECA

    var cbxTipoRepresentante = new Ext.form.ComboBox({
        id:'cbxTipoRepresentante',
        name:'cbxTipoRepresentante',
        store: dsTipoRepresentante,
        anchor:'75%',
        //displayField: 'Representante',
        typeAhead: true,
        mode: 'local',
        editable: false,
        triggerAction:'all',
        emptyText : 'Seleccione',
        //valueField:'id_tipo_representante',
		allowBlank:false,
		selectedIndex : 0

    });

    /*
     * Ext.ux.grid.RowEditor Edito de filas personalizado para utilizaci?n en el grid de contacto
     */
    var rePersonaBeca = new Ext.ux.grid.RowEditor({
        saveText: 'Aceptar',
        cancelText:'Cancelar',
        listeners:{
            /*canceledit:function(inRowEditor, inFlag, inRecord) {
                var rFila = grdCgg_res_persona.getStore().getAt(0);
                if (rFila.get('CRPER_CODIGO') == '') {
                    grdCgg_res_persona.getStore().remove(rFila);
                }
            }*/
			canceledit:function(inSource, inIsCancel){
				var tmpRecord = grdCgg_res_persona.getSelectionModel().getSelected();
				if(tmpRecord){
					if(tmpRecord.data.CRPER_CODIGO == 'KEYGEN' || tmpRecord.data.CRPER_CODIGO.length == 0){
						grdCgg_res_persona.getStore().removeAt(0);
					}else{
						if(swTemp == true){
							grdCgg_res_persona.getStore().removeAt(0);
						}
					}
				}
			}
        }
    });
    rePersonaBeca.stopMonitoring();
    /**
     * Ext.ColumnModel Agrupacion de registros de la tabla Cgg_res_persona_contacto por un campo especifico.
     */
    var cmPersonaBecaRepresentante = new Ext.grid.ColumnModel([{
            dataIndex:'CDINR_TIPO_REPRESENTANTE',
            header:'Representante',
            width:150,
            sortable:true,
            editor:cbxTipoRepresentante,
            renderer:function(inCinr_tipo_representate) {
                var result = "";
				//cbxTipoRepresentante.setValue(inCinr_tipo_representate);
				if(!cbxTipoRepresentante.getValue()){
					cbxTipoRepresentante.setValue(cbxTipoRepresentante.store.data.items[0].data.field1)
				}
                switch (cbxTipoRepresentante.getValue()) {
                    case 0:
                        result = 'PADRE';
                        break;
                    case 1:
                        result = 'MADRE';
                        break;
                    case 2:
                        result = 'REPRESENTANTE LEGAL';
                        break;
                    case 3:
                        result = 'APODERADO';
                        break;
                    case 4:
                        result = 'GARANTE';
                        break;
                    /*default:
                        result =NO_DATA_MESSAGE;
                        break;*/
                }
                return result;
            }
        },{
            dataIndex:'CRPER_NUM_DOC_IDENTIFIC',
            header:'No. Documento',
            width:150,
            sortable:true,
            editor: txtCrper_num_doc_identific_representante
        },
        {
            dataIndex:'CRPER_NOMBRES',
            header:'Nombres',
            width:150,
            sortable:true,
            editor:txtCrper_nombres_representante
        },
        {
            dataIndex:'CRPER_APELLIDO_PATERNO',
            header:'Primer apellido',
            width:150,
            sortable:true,
            editor:txtCrper_apellido_paterno_representante
        },{
            dataIndex:'CRPER_APELLIDO_MATERNO',
            header:'Segundo apellido',
            width:150,
            sortable:true,
            editor:txtCrper_apellido_materno_representante
        },

        {
            dataIndex:'CRPER_NUMERO_RESIDENCIA',
            header:'Num.Residencia',
            width:150,
            sortable:true,
            editor:txtCrper_residencia_representante
        },{
            dataIndex:'CDINR_DESCRIPCION',
            header:'Descripci\u00f3n',
            width:150,
            sortable:true,
            editor:txtCrper_descripcion_representante
        }
    ]);


    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_persona por un campo especifico.
     */
    var gsPersonabecaRepresentanteBuscar = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS + "Cgg_dhu_beca",
            method:"selectPersonaRepresetante",
            pagin:false
        }),

        reader:new Ext.data.JsonReader({
            id:'CRPER_CODIGO'

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

        baseParams:{
            inCrper_num_doc_identific:"",
            format:"JSON"
        }, listeners:{
            load:function() {
                if (gsPersonabecaRepresentanteBuscar.getTotalCount() > 0) {
                    var tmpselect = gsPersonabecaRepresentanteBuscar.getAt(0);
                    grdCgg_res_persona.getSelectionModel().getSelected().set('CRPER_CODIGO', tmpselect.get('CRPER_CODIGO'));
                    txtCrper_codigo_representante.setValue(tmpselect.get('CRPER_CODIGO'));
                    txtCrper_codigo_residente.setValue(tmpselect.get('CODIGO'));
                    if(txtCrper_codigo_residente.getValue()!='03'){
                        Ext.Msg.show({
                            title:tituloCgg_dhu_beca,
                            msg: 'La persona seleccionada no es Residente.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.INFO});
                    }
                    txtCrper_nombres_representante.setValue(tmpselect.get('CRPER_NOMBRES'));
                    txtCrper_apellido_paterno_representante.setValue(tmpselect.get('CRPER_APELLIDO_PATERNO'));
                    txtCrper_apellido_materno_representante.setValue(tmpselect.get('CRPER_APELLIDO_MATERNO'));
                    txtCrper_num_doc_identific_representante.setValue(tmpselect.get('CRPER_NUM_DOC_IDENTIFIC'));
                    txtCrper_residencia_representante.setValue(tmpselect.get('CRPER_NUMERO_RESIDENCIA'));
                    //txtCrper_descripcion_representante.setValue(tmpselect.get('CDINR_DESCRIPCION'));
                    // cbxTipoRepresentante.setValue(tmpselect.get('CDINR_TIPO_REPRESENTANTE'));


                } else {

                    Ext.MessageBox.alert('Registro de Ingreso de Personas a la Provincia', 'Datos no asociados a ninguna persona, por favor ingrese los datos');
                }
            }
        }

    });
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_persona por un campo especifico.
     */
    var gsPersonabecaRepresentante = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS + "Cgg_dhu_beca",
            method:"selectRepresetanteBeca",
            pagin:false
        }),

        reader:new Ext.data.JsonReader({
            id:'CRPER_CODIGO'

        }, [
            {
                name:'CRPER_CODIGO'
            },{
                name:'CDINR_CODIGO'
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
            },
            {
                name:'CDINR_DESCRIPCION'
            },{
                name:'CDINR_TIPO_REPRESENTANTE'
            }
        ]),

        baseParams:{
            inCdbec_codigo:"",
            format:"JSON"
        }
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_persona_contacto en un formato tabular de filas y columnas.
     */
    var grdCgg_res_persona = new Ext.grid.EditorGridPanel({
        cm:cmPersonaBecaRepresentante,
        store:gsPersonabecaRepresentante,
        region:'center',
        height:230,
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        loadMask:{
            msg:"Cargando..."
        },
        frame:true,
        tbar:['Representantes',{
            iconCls:'iconNuevo',
            tooltip:'Agregar Persona',
            handler:function() {
				swTemp = true;
                var tmpRecordPersona = grdCgg_res_persona.getStore().recordType;
                rePersonaBeca.stopEditing();
                grdCgg_res_persona.getStore().insert(0,
                        new tmpRecordPersona({
                            CRPER_CODIGO:'',
                            CDINR_CODIGO:'KEYGEN',
                            CRPER_NUM_DOC_IDENTIFIC: '',
                            CRPER_NOMBRES: '',
                            CRPER_APELLIDO_PATERNO: '',
                            CRPER_APELLIDO_MATERNO: '',
                            CRPER_NUMERO_RESIDENCIA: '',
                            CDINR_TIPO_REPRESENTANTE: '',
                            CDINR_DESCRIPCION:''
                        })
                        );
                grdCgg_res_persona.getView().refresh();
                grdCgg_res_persona.getSelectionModel().selectRow(0);
                rePersonaBeca.startEditing(0);
            }
        },{
            iconCls:'iconEliminar',
            tooltip:'Eliminar Persona',
            handler:function() {
                Ext.Msg.show({
                    title:'Aviso',
                    msg:'Seguro de eliminar el registro seleccionado?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_res_persona,
                    icon: Ext.MessageBox.QUESTION
                });
                function SWRCgg_res_persona(btn) {
                    if (btn == 'yes'){
                        var seleccionado = grdCgg_res_persona.getSelectionModel().getSelected();
                        if (seleccionado != null) {
                            grdCgg_res_persona.getStore().remove(seleccionado);
                        } else if (grdCgg_res_persona.getStore().getCount() >= 1) {
                            grdCgg_res_persona.getSelectionModel().selectLastRow();
                            grdCgg_res_persona.getStore().remove(grdCgg_res_persona.getSelectionModel().getSelected());
                        }
                    }
                }
            }
        }],
        plugins:[rePersonaBeca]
    });

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_gem_perfil_prof.
     */
    var cmCgg_gem_perfil_prof_beca = new Ext.grid.ColumnModel([
        {dataIndex:'CGPPR_CODIGO',header:'Codigo',width:100,sortable:true,hidden:true,editor:txtCdhu_perfil_codigo},
        {dataIndex:'CGNES_DESCRIPCION',header:'Nivel estudio',width:100,sortable:true,editor:txtCdhu_nivel_estudio},
        {dataIndex:'CGIED_NOMBRE',header:'Instituci\u00f3n educativa',width:120,sortable:true,editor:txtCdhu_institucion_edu},
        {dataIndex:'CGTPR_DESCRIPCION',header:'T\u00edtulo profesional',width:120,sortable:true,editor:txtCdhu_titulo_prof},
        {dataIndex:'CGESP_NOMBRE',header:'Especialidad',width:120,sortable:true,editor:txtCdhu_especialidad},
        {dataIndex:'CGMDC_DESCRIPCION',header:'Modalidad curso',width:100,sortable:true,editor:txtCdhu_modalidad_curso},
        {dataIndex:'CRPER_CODIGO',header:'Persona',width:150,sortable:true,hidden:true,editor:txtCrper_codigo},
        {dataIndex:'CGPPR_NIVEL_APROBADO',header:'Nivel aprobado',width:100,sortable:true,editor:txtCdhu_modalidad_curso},
        {dataIndex:'CGPPR_FECHA_INICIO',header:'Fecha inicio',width:100,sortable:true,hidden:true,renderer:truncDate},
        {dataIndex:'CGPPR_FECHA_FIN',header:'Fecha fin',width:100,sortable:true,hidden:true,renderer:truncDate},
        {dataIndex:'CGPPR_CONFIRMADO',header:'Confirmado',width:50,sortable:true,hidden:true,editor:txtCdhu_confirmado},
        {dataIndex:'CGPPR_FECHA_CONFIRMACION',header:'Fecha confirmaci\u00f3n',width:100,sortable:true,hidden:true,renderer:truncDate},
        {dataIndex:'CGPPR_PREDETERMINADO',header:'Inicial',width:50,sortable:true,xtype:'checkcolumn'}]);

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_perfil_prof por un campo especifico.
     */
    var gsCgg_gem_perfil_prof_beca = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_gem_perfil_prof",
            method:"selectPerfilPersona",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
        },[
            {name:'CGPPR_CODIGO'},
            {name:'CGESP_CODIGO'},
            {name:'CGESP_NOMBRE'},
            {name:'CGTPR_CODIGO'},
            {name:'CGTPR_DESCRIPCION'},
            {name:'CGIEN_CODIGO'},
            {name:'CGIED_NOMBRE'},
            {name:'CGTPR_DESCRIPCION'},
            {name:'CGIED_CODIGO'},
            {name:'CGIED_DESCRIPCION'},
            {name:'CGMDC_CODIGO'},
            {name:'CGMDC_DESCRIPCION'},
            {name:'CGNES_CODIGO'},
            {name:'CGNES_DESCRIPCION'},
            {name:'CRPER_CODIGO'},
            {name:'CGPPR_NIVEL_APROBADO'},
            {name:'CGPPR_FECHA_INICIO'},
            {name:'CGPPR_FECHA_FIN'},
            {name:'CGPPR_CONFIRMADO'},
            {name:'CGPPR_FECHA_CONFIRMACION'},
            {name:'CGPPR_PREDETERMINADO'}
        ]),

        baseParams:{inCrper_codigo:'',format:'JSON'}
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_gem_perfil_prof en un formato tabular de filas y columnas.
     */
    var grdCgg_gem_perfil_prof_beca = new Ext.grid.GridPanel({
        cm:cmCgg_gem_perfil_prof_beca,
        store:gsCgg_gem_perfil_prof_beca,
        region:'center',
        height:185,
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."}
        /*  listeners:{
         rowdblclick:function(inGridComponent, inRowIndex, inEventObject){

         Ext.getCmp('btnEditarCgg_gem_perfil_prof').fireEvent('click',Ext.getCmp('btnEditarCgg_gem_perfil_prof'));
         // }
         }
         }*/});
	/**
	 * Ext.data.Store Almacenamiento de informacion del tipo de beca.
	 */
	var strDhuTipoBeca = new Ext.data.Store({
		proxy:new Ext.ux.bsx.SoapProxy({
			url:URL_WS+"Cgg_dhu_tipo_beca",
			method:"selectAll"
		}),
		reader:new Ext.data.JsonReader({},[
			{name:'CDTBC_CODIGO'},
			{name:'CDTBC_NOMBRE'},
			{name:'CDTBC_ABREVIATURA'},
			{name:'CDTBC_ESTADO_BECA'}
		]),
		baseParams:{
			format:TypeFormat.JSON
		},
		listeners:{
			load:function(){
				cbxTipoBeca.store = strDhuTipoBeca;
				if(isEdit)
				cbxTipoBeca.setValue(inRecordCgg_dhu_beca.get('CDTBC_CODIGO'));
			}
		}
	});
	strDhuTipoBeca.load();

    //Creamos una definici?n de los campos que vienen en el Json remoto DEL TIPO DE BECA

    var cbxTipoBeca = new Ext.form.ComboBox({
        id:'cbxTipoBeca',
        name:'cbxTipoBeca',
        displayField: "CDTBC_NOMBRE",
        fieldLabel :'Tipo beca',
        valueField: 'CDTBC_CODIGO',
        mode:'local',
        typeAhead:true,
        autoSelect:true,
        hiddenId:'cbxTipoBecaH',
        hiddenName:'cbxTipoBecaH',
        hiddenValue:'id',
        forceSelection:true,
        editable: true,
        triggerAction:'all',
        submitValue:true,
        anchor:'98%',
        emptyText : 'Seleccione una opci\u00f3n..',
		allowBlank:false

    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGSITRO  ENTIDAD FINANCIERA
     */
    var txtCrpjr_codigo = new Ext.form.TextField({
        id:'txtCrpjr_codigo',
        name:'txtCrpjr_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * Ext.form.TextField  REGSITRO  ENTIDAD FINANCIERA NOMBRE
     */
    var txtCrpjr_nombre = new Ext.form.TextField({
        id:'txtCrpjr_nombre',
        name:'txtCrpjr_nombre',
        fieldLabel :'Banco',
        anchor:'98%',
        readOnly:'true',
		allowBlank:false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGSITRO  ENTIDAD FINANCIERA
     */
    var btnCrpjr_codigoCgg_dhu_beca = new Ext.Button({
        id:'btnCrpjr_codigoCgg_dhu_beca',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_res_persona_juridica = new FrmListadoCgg_res_persona_juridica();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona_juridica.getStore(),tmpFLCgg_res_persona_juridica.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        txtCrpjr_codigo.setValue(tmpRecord.get('CRPJR_CODIGO'));
                        txtCrpjr_nombre.setValue(tmpRecord.get('CRPJR_RAZON_SOCIAL'));
                    }
                });
                objBusqueda.show();
            }}
    });
    ////////////////////////////////////////////////////////////
    function CargarStoreEspecialidad(){
        /**
         * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_especialidad.
         */
        this.cmCgg_especialidad = new Ext.grid.ColumnModel([
            {dataIndex:'CGESP_CODIGO',header:'Codigo',width:90,sortable:true,hidden:true},
            {dataIndex:'CGNES_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
            {dataIndex:'CGNES_DESCRIPCION',header:'Nivel de Educaci\u00F3n',width:130,sortable:true,hidden:true},
            {dataIndex:'CGESP_NOMBRE',header:'Nombre',width:200,sortable:true},
            {dataIndex:'CGESP_DESCRIPCION',header:'Descripci\u00f3n',width:350,sortable:true}]);
        /**
         * Ext.data.Store Agrupacion de registros de la tabla Cgg_especialidad por un campo especifico.
         */
        this.gsCgg_especialidad = new Ext.data.Store({
            proxy:new Ext.ux.bsx.SoapProxy({
                url:URL_WS+"Cgg_especialidad",
                method:"selectPageEspecialidadByIdNivelEstudio",
                pagin:true
            }),
            remoteSort:true,
            reader:new Ext.data.JsonReader({
                id:'CGESP_CODIGO',
                root:'dataSet',
                totalProperty: 'totalCount'
            },[
                {name:'CGESP_CODIGO'},
                {name:'CGNES_CODIGO'},
                {name:'CGESP_NOMBRE'},
                {name:'CGESP_DESCRIPCION'},
                {name:'CGNES_DESCRIPCION'}
            ]),
            sortInfo:{field: 'CGNES_CODIGO', direction: 'ASC'},
            baseParams:{keyword:"",format:'JSON',inCgnes_codigo:''/*cbxCgnes_codigo.getValue()*/}
        });
    }

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIALIDAD
     */
    var txtCgesp_codigo = new Ext.form.TextField({
        id:'txtCgesp_codigo',
        name:'txtCgesp_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * Ext.form.TextField NOMBRE DE ESPECIALIDAD
     */
    var txtCgesp_nombre= new Ext.form.TextField({
        id:'txtCgesp_nombre',
        name:'txtCgesp_nombre',
        fieldLabel :'Especialidad',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIALIDAD
     */
    var btnCgesp_codigoCgg_dhu_beca = new Ext.Button({
        id:'btnCgesp_codigoCgg_dhu_beca',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_especialidad = new CargarStoreEspecialidad();
                tmpFLCgg_especialidad.gsCgg_especialidad.baseParams.inCgnes_codigo=cbxNivelEstudio.getValue();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_especialidad.gsCgg_especialidad,tmpFLCgg_especialidad.cmCgg_especialidad);
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        txtCgesp_codigo.setValue(tmpRecord.get('CGESP_CODIGO'));
                        txtCgesp_nombre.setValue(tmpRecord.get('CGESP_NOMBRE'));
                    }
                });
                objBusqueda.show();
            }}
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION EDUCATIVA
     */
    var txtCgied_codigo = new Ext.form.TextField({
        id:'txtCgied_codigo',
        name:'txtCgied_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * Ext.form.TextField NOMBRE DE INSTITUCION EDUCATIVA
     */
    var txtCgied_institucion_educativa = new Ext.form.TextField({
        id:'txtCgied_institucion_educativa',
        name:'txtCgied_institucion_educativa',
        fieldLabel :'Instituci\u00f3n',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION EDUCATIVA
     */
    var btnCgied_codigoCgg_dhu_beca = new Ext.Button({
        id:'btnCgied_codigoCgg_dhu_beca',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
				if(cbxNivelEstudio.getValue()){
					var tmpFLCgg_institucion_educativa = new FrmListadoCgg_institucion_nivel(cbxNivelEstudio.getValue());
					var objBusqueda = new DlgBusqueda(tmpFLCgg_institucion_educativa.getStore(),tmpFLCgg_institucion_educativa.getColumnModel());
					objBusqueda.closeHandler(function(){
						var tmpRecord = objBusqueda.getSelectedRow();
						if(tmpRecord){
							txtCgied_codigo.setValue(tmpRecord.get('CGIED_CODIGO'));
							txtCgied_institucion_educativa.setValue(tmpRecord.get('CGIED_NOMBRE'));
						}
					});
					objBusqueda.show();
				}else{
					Ext.Msg.show({
						title:tituloCgg_dhu_beca,
						msg: 'Seleccione primero un nivel.',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.INFO
					});
				}
            }
		}
    });

    //Creamos una definici?n de los campos que vienen en el Json remoto

    var cbxPais = new Ext.form.ComboBox({
        store:SCGG_PAIS,
        id:'cbxPais',
        name:'cbxPais',
        displayField: "CPAIS_NOMBRE",
        fieldLabel :'Pa\u00eds',
        valueField: 'CPAIS_CODIGO',
        mode:'local',
        typeAhead:true,
        autoSelect:true,
        hiddenId:'cbxPaisH',
        hiddenName:'cbxPaisH',
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
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TITULO PROFESONAL
     */
    var txtCgtpr_codigo = new Ext.form.TextField({
        id:'txtCgtpr_codigo',
        name:'txtCgtpr_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TITULO PROFESONAL
     */
    var txtCgtpr_nombre_titulo = new Ext.form.TextField({
        id:'txtCgtpr_nombre_titulo',
        name:'txtCgtpr_nombre_titulo',
        fieldLabel :'T\u00edtulo',
        anchor:'98%',
        readOnly:'true'
    });
    function CargarStoreTituloProfesional(){
        /**
         * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_titulo_profesional.
         */
        this.cmCgg_titulo_profesional = new Ext.grid.ColumnModel([
            {dataIndex:'CGTPR_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
            {dataIndex:'CGNES_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
            {dataIndex:'CGNES_DESCRIPCION',header:'Nivel de Estudio',width:120,sortable:true,hidden:true},
            {dataIndex:'CGTPR_DESCRIPCION',header:'Descripci\u00F3n',width:380,sortable:true}]);
        /**
         * Ext.data.Store Agrupacion de registros de la tabla Cgg_titulo_profesional filtrado por el codigo de Nivel se estudio
         */
        this.gsCgg_titulo_profesional = new Ext.data.Store({
            proxy:new Ext.ux.bsx.SoapProxy({
                url:URL_WS+"Cgg_titulo_profesional",
                method:"selectPageTituloByIdNivelEstudio",
                pagin:true
            }),
            remoteSort:true,
            reader:new Ext.data.JsonReader({
                id:'CGTPR_CODIGO',
                root:'dataSet',
                totalProperty: 'totalCount'
            },[
                {name:'CGTPR_CODIGO'},
                {name:'CGNES_CODIGO'},
                {name:'CGNES_DESCRIPCION'},
                {name:'CGTPR_DESCRIPCION'}
            ]),
            sortInfo:{field: 'CGNES_CODIGO', direction: 'ASC'},
            baseParams:{keyword:"",format:'JSON',inCgnes_codigo:cbxNivelEstudio.getValue()}
        });
    }
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE TITULO PROFESONAL
     */
    var btnCgtpr_codigoCgg_dhu_beca = new Ext.Button({
        id:'btnCgtpr_codigoCgg_dhu_beca',
        // text:'Cgtpr_codigo',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var StoreTituloProfesional = new CargarStoreTituloProfesional();
                StoreTituloProfesional.gsCgg_titulo_profesional.baseParams.inCgnes_codigo=cbxNivelEstudio.getValue();
                var objBusqueda = new DlgBusqueda(StoreTituloProfesional.gsCgg_titulo_profesional,StoreTituloProfesional.cmCgg_titulo_profesional);
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                    {
                        txtCgtpr_codigo.setValue(tmpRecord.get('CGTPR_CODIGO'));
                        txtCgtpr_nombre_titulo.setValue(tmpRecord.get('CGTPR_DESCRIPCION'));
                    }
                });
                objBusqueda.show();
            }}
    });

    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
     */
    var txtCrper_codigo = new Ext.form.TextField({
        id:'txtCrper_codigo',
        name:'txtCrper_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false

    });
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
     */
    var txtCrper_codigo_residente = new Ext.form.TextField({
        id:'txtCrper_codigo_residente',
        name:'txtCrper_codigo_residente',
        fieldLabel :'Residente',
        anchor:'98%',
        readOnly:'true'

    });
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
     */
    var txtCrper_numero_documento = new Ext.form.NumberField({
        id:'txtCrper_numero_documento',
        name:'txtCrper_numero_documento',
        fieldLabel :'No documento',
        anchor:'98%',
        listeners: {
            specialkey: function(field, e) {
                // e.HOME, e.END, e.PAGE_UP, e.PAGE_DOWN,
                // e.TAB, e.ESC, arrow keys: e.LEFT, e.RIGHT, e.UP, e.DOWN
                if (e.getKey() == e.ENTER) {
                    try {
                        function CallBackCgg_persona(r) {
                            tmpInformacionPersonaPermanente = Ext.util.JSON.decode(r)[0];
                            if (tmpInformacionPersonaPermanente) {
								if(tmpInformacionPersonaPermanente.NUM_REGISTROS==0){
									txtCrper_codigo.setValue(tmpInformacionPersonaPermanente.CRPER_CODIGO);
									txtCdhu_codigo.setValue(tmpInformacionPersonaPermanente.CRDID_TIPO);
									txtCrper_numero_documento.setValue(tmpInformacionPersonaPermanente.CRPER_NUM_DOC_IDENTIFIC);
									txtCdhu_num_doc_identific.setValue(tmpInformacionPersonaPermanente.CRPER_NUM_DOC_IDENTIFIC);
									txtCdhu_nombres.setValue(tmpInformacionPersonaPermanente.CRPER_NOMBRES);
									txtCdhu_apellido_paterno.setValue((tmpInformacionPersonaPermanente.CRPER_APELLIDO_PATERNO)+' '+(tmpInformacionPersonaPermanente.CRPER_APELLIDO_MATERNO));
									txtCdhu_residencia.setValue(tmpInformacionPersonaPermanente.CRPER_NUMERO_RESIDENCIA);
									txtCdhu_lugar_nacimiento.setValue(tmpInformacionPersonaPermanente.CRPER_LUGAR_NACIMIENTO);
									dtCdhu_fecha_nacimiento.setValue(truncDate(tmpInformacionPersonaPermanente.CRPER_FECHA_NACIMIENTO));
									txtCdhu_edad.setValue(calcularEdad( Date.parse(truncDate(tmpInformacionPersonaPermanente.CRPER_FECHA_NACIMIENTO)).format('Y-m-d')));
									txtCrper_codigo_residente.setValue(tmpInformacionPersonaPermanente.CODIGO);
									if(txtCrper_codigo_residente.getValue()!='03'){
										Ext.Msg.show({
											title:tituloCgg_dhu_beca,
											msg:'La persona seleccionada no es residente',
											buttons:Ext.Msg.OK,
											icon:Ext.MessageBox.INFO
										});
										tabBeca.disable();
									}else{
										tabBeca.enable();
									}
									gsCgg_gem_perfil_prof_beca.load({
										params:{
											inCrper_codigo:txtCrper_codigo.getValue(),
											format:TypeFormat.JSON
										}});

								}else{
									Ext.Msg.show({
										title:tituloCgg_dhu_beca,
										msg:'La persona seleccionada ya tiene una beca en proceso',
										buttons:Ext.Msg.OK,
										icon:Ext.MessageBox.INFO
									});
									txtCrper_numero_documento.setValue('');
									txtCdhu_codigo.setValue('');
									txtCdhu_nombres.setValue('');
									txtCdhu_residencia.setValue('');
									txtCdhu_num_doc_identific.setValue('');
									txtCdhu_apellido_paterno.setValue('');
									txtCdhu_lugar_nacimiento.setValue('');
									txtCdhu_edad.setValue('');
								}
                            }else {

                                Ext.Msg.show({
                                    title:tituloCgg_dhu_beca,
                                    msg: 'No existe el registro solicitado.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO});


                            }

                        }

                        var param = new SOAPClientParameters();
                        param.add('inCrper_num_doc_identific', txtCrper_numero_documento.getValue());
                        param.add('format', TypeFormat.JSON);
                        SOAPClient.invoke(URL_WS + "Cgg_dhu_beca", "selectResidentePermaneteBeca", param, true, CallBackCgg_persona);
                    } catch(inErr) {
                        //winFrmCgg_institucion_educativa.getEl().unmask();
                    }

                }
            }
        }
    });

    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA FUNCIONARIO CGG
     */
    var txtCgg_crper_codigo = new Ext.form.TextField({
        id:'txtCgg_crper_codigo',
        name:'txtCgg_crper_codigo',
        fieldLabel :'Crper codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * Ext.form.TextField  REGISTRO DE PERSONA FUNCIONARIO CGG
     */
    var txtCgg_crper_funcionario = new Ext.form.TextField({
        id:'txtCgg_crper_funcionario',
        name:'txtCgg_crper_funcionario',
        fieldLabel :'Funcionario',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    function PersonaFuncionario() {
        var cmPersonaFuncionario = null;
        var gsPersonaFuncionario = null;
        /**
         * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_persona.
         *
         */
        cmPersonaFuncionario = new Ext.grid.ColumnModel([
            {dataIndex:'CRPER_CODIGO',header:'Codigo',width:150,sortable:true},
            {dataIndex:'CRPER_NOMBRES',header:'Nombres',width:150,sortable:true},
            {dataIndex:'CRPER_APELLIDO_PATERNO',header:'Primer apellido',width:150,sortable:true},
            {dataIndex:'CRPER_APELLIDO_MATERNO',header:'Segundo apellido',width:150,sortable:true},
            {dataIndex:'CRPER_NUM_DOC_IDENTIFIC',header:'Num doc identific',width:150,sortable:true},
            {dataIndex:'CUSU_USUARIO_INTERNO',header:'Usuario',width:150,sortable:true}]);
        /**
         * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_persona por un campo especifico.
         */
        gsPersonaFuncionario = new Ext.data.Store({
            proxy:new Ext.ux.bsx.SoapProxy({
                url:URL_WS + "Cgg_dhu_beca",
                method:"selectFuncionarioBeca",
                pagin:true
            }),
            remoteSort:true,
            reader:new Ext.data.JsonReader({
                id:'CRPER_CODIGO',
                root:'dataSet',
                totalProperty: 'totalCount'
            }, [{name:'CRPER_CODIGO'},
                {name:'CRPER_NOMBRES'},
                {name:'CRPER_APELLIDO_PATERNO'},
                {name:'CRPER_APELLIDO_MATERNO'},
                {name:'CRPER_NUM_DOC_IDENTIFIC'},
                {name:'CUSU_USUARIO_INTERNO'}


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
            return cmPersonaFuncionario;
        };

        this.getStore = function() {
            return gsPersonaFuncionario;
        }
    }

    PersonaFuncionario.prototype.getColumnModel = function() {
        return this.getCm();
    };

    PersonaFuncionario.prototype.getStore = function() {
        return this.getStore();
    };
    /**
     * Ext.form.TextField NOMBRE DEL FUNCIONARIO QUE APROBO LA BECA O CARRERA
     */
    var txtCdbec_funcionario = new Ext.form.TextField({
        id:'txtCdbec_funcionario',
        name:'txtCdbec_funcionario',
        fieldLabel :'Funcionario',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA FUNCIONARIO CGG
     */
    var btnCgg_crper_codigoCgg_dhu_beca = new Ext.Button({
        id:'btnCgg_crper_codigoCgg_dhu_beca',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_res_persona_funcionario = new PersonaFuncionario();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona_funcionario.getStore(),tmpFLCgg_res_persona_funcionario.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        txtCgg_crper_codigo .setValue(tmpRecord.get('CRPER_CODIGO'));
                        txtCgg_crper_funcionario.setValue(tmpRecord.get('CRPER_NOMBRES')+' '+tmpRecord.get('CRPER_APELLIDO_PATERNO')+' '+tmpRecord.get('CRPER_APELLIDO_MATERNO'));
                    }

                });
                objBusqueda.show();
            }}
    });

    /**
     * Ext.form.TextField NUMERO DE LA BECA FORMADO POR LA ABREVIATURA DEL TIPO DE BECA MAS SECUENCIAL
     */
    var txtCdbec_numero = new Ext.form.TextField({
        id:'txtCdbec_numero',
        name:'txtCdbec_numero',
        fieldLabel :'No. Beca',
        anchor:'98%',
		style: {
            color:'#004A95',
            background:'#FFFFE6'
        },
		readOnly:true		
    });


    /**
     * Ext.form.DateField FECHA DE INGRESO A LA BECA O CARRERA
     */
    var dtCdbec_fecha_ingreso = new Ext.form.DateField({
        id:'dtCdbec_fecha_ingreso',
        name:'dtCdbec_fecha_ingreso',
        fieldLabel :'Fecha ingreso',
        allowBlank :false,
        format :'d/m/Y',
        value:new Date()
    });
    dtCdbec_fecha_ingreso.setVisible(false);
    /**
     * Ext.form.TextField NUMERO DEL DOCUMENTO DE APROBACION DE LA BECA
     */
    var txtCdbec_numero_aprobacion = new Ext.form.TextField({
        id:'txtCdbec_numero_aprobacion',
        name:'txtCdbec_numero_aprobacion',
        fieldLabel :'No. aprobaci\u00f3n',
        anchor:'98%',
        allowBlank :false
    });

    /**
     * Ext.form.DateField FECHA DE INICIO DE LA BECA
     */
    var dtCdbec_fecha_inicio = new Ext.form.DateField({
        id:'dtCdbec_fecha_inicio',
        name:'dtCdbec_fecha_inicio',
        fieldLabel :'Fecha inicio',
        allowBlank :false,
        format :'d/m/Y',
        value:new Date(),
		listeners:{
            change:function(obj,newValue,oldValue){
                dtCdbec_fecha_fin.setMinValue(newValue);                
            },
            select:function(obj,value){
                dtCdbec_fecha_fin.setMinValue(value);                
            }
        }
    });
    /**
     * Ext.form.DateField FECHA DE FINALIZACION DE LA BECA
     */
    var dtCdbec_fecha_fin = new Ext.form.DateField({
        id:'dtCdbec_fecha_fin',
        name:'dtCdbec_fecha_fin',
        fieldLabel :'Fecha fin',
        allowBlank :false,
        format :'d/m/Y',
        value:new Date()
    });
    /**
     * Ext.form.TextField NUMERO IDENTIFICADOR DE la aprobacion modificatorio de la beca
     */
    var txtCdbec_numero_aprobacion_modificatorio = new Ext.form.TextField({
        id:'txtCdbec_numero_aprobacion_modificatorio',
        name:'txtCdbec_numero_aprobacion_modificatorio',
        fieldLabel :'No. aprobaci\u00f3n',
        anchor:'98%'
    });
    /**
     * Ext.form.TextField NUMERO IDENTIFICADOR DEL CONTRATO MODIFICATORIO DE LA BECA
     */
    var txtCdbec_numero_contrato_modificatorio = new Ext.form.TextField({
        id:'txtCdbec_numero_contrato_modificatorio',
        name:'txtCdbec_numero_contrato_modificatorio',
        fieldLabel :'No. contrato mod',
        anchor:'98%'
    });
    /**
     * Ext.form.TextField INFORMACION ADICIONAL DEL CONTRATO MODIFICATORIO DE LA BECA
     */
    var txtCdbec_observacion_contrato_modificatorio = new Ext.form.TextArea({
        id:'txtCdbec_observacion_contrato_modificatorio',
        name:'txtCdbec_observacion_contrato_modificatorio',
        fieldLabel :'Observaci\u00f3n',
        anchor:'98%'
    });
    /**
     * Ext.form.TextField NUMERO IDENTIFICADOR DEL CONTRATO O CONVENIO
     */
    var txtCdbec_numero_convenio = new Ext.form.TextField({
        id:'txtCdbec_numero_convenio',
        name:'txtCdbec_numero_convenio',
        fieldLabel :'No. contrato',
        anchor:'98%',
        allowBlank :false
    });

    /**
     * Ext.form.TextField ORIGEN DEL VUELO DE SALIDA
     */
    var txtCdbec_vsalida_origen = new Ext.form.TextField({
        id:'txtCdbec_vsalida_origen',
        name:'txtCdbec_vsalida_origen',
        fieldLabel :'Salida origen',
        anchor:'98%'
    });
    /**
     * Ext.form.TextField DESTINO DEL VUELO DE SALIDA
     */
    var txtCdbec_vsalida_destino = new Ext.form.TextField({
        id:'txtCdbec_vsalida_destino',
        name:'txtCdbec_vsalida_destino',
        fieldLabel :'Salido destino',
        anchor:'98%'
    });
    /**
     * Ext.form.NumberField VALOR DEL PASAJE DE SALIDA
     */
    var numCdbec_vsalida_valor = new Ext.form.NumberField({
        id:'numCdbec_vsalida_valor',
        name:'numCdbec_vsalida_valor',
        fieldLabel :'Salida valor'
    });
    /**
     * Ext.form.TextField ORIGEN DEL VUELO DE RETORNO
     */
    var txtCdbec_vretorno_origen = new Ext.form.TextField({
        id:'txtCdbec_vretorno_origen',
        name:'txtCdbec_vretorno_origen',
        fieldLabel :'Retorno origen',
        anchor:'98%'
    });
    /**
     * Ext.form.TextField DESTINO DEL VUELO DE RETORNO
     */
    var txtCdbec_vretorno_destino = new Ext.form.TextField({
        id:'txtCdbec_vretorno_destino',
        name:'txtCdbec_vretorno_destino',
        fieldLabel :'Retorno destino',
        anchor:'98%'
    });
    /**
     * Ext.form.NumberField VALOR DEL PASAJE DE RETORNO
     */
    var numCdbec_vretorno_valor = new Ext.form.NumberField({
        id:'numCdbec_vretorno_valor',
        name:'numCdbec_vretorno_valor',
        fieldLabel :'Retorno valor'
    });
    /**
     * Ext.form.TextField NOMBRE DE LA CARRERA A SEGUIR
     */
    var txtCdbec_carrera = new Ext.form.TextField({
        id:'txtCdbec_carrera',
        name:'txtCdbec_carrera',
        fieldLabel :'Carrera',
        anchor:'98%'
    });
	/**
	 * Ext.data.Store Almacenamiento de informacion de Nivel Estudio.
	 */
	var strNivelEstudio = new Ext.data.Store({
		proxy:new Ext.ux.bsx.SoapProxy({
			url:URL_WS+"Cgg_nivel_estudio",
			method:"selectAll"
		}),
		reader:new Ext.data.JsonReader({},[
			{name:'CGNES_CODIGO'},
			{name:'CGNES_DESCRIPCION'},
			{name:'CGNES_GRADO'}
		]),
		baseParams:{
			format:TypeFormat.JSON
		},
		listeners:{
			load:function(){
				cbxNivelEstudio.store = strNivelEstudio;
				if(isEdit)
				cbxNivelEstudio.setValue(inRecordCgg_dhu_beca.get('CGNES_DESCRIPCION'));
			}
		}
	});
	strNivelEstudio.load();
    //Creamos una definici?n de los campos que vienen en el Json remoto

    var cbxNivelEstudio= new Ext.form.ComboBox({
        id:'cbxNivelEstudio',
        name:'cbxNivelEstudio',
        displayField: "CGNES_DESCRIPCION",
        fieldLabel :'Nivel',
        valueField: 'CGNES_CODIGO',
        mode:'local',
        typeAhead:true,
        autoSelect:true,
        hiddenId:'cbxNivelEstudioH',
        hiddenName:'cbxNivelEstudioH',
        hiddenValue:'id',
        forceSelection:true,
        editable: true,
        triggerAction:'all',
        submitValue:true,
        anchor:'75%',
        emptyText : 'Seleccione una opci\u00f3n..'

    });
    /**
     * Ext.form.NumberField TIPOS DE CICLIO DE LAS CARRERAS PROFESIONALES
     0 - ANUAL
     1 - SEMESTRAL
     2 - QUIMESTRAL
     3 - OTROS
     */
    var numCdbec_tipo_ciclo = new Ext.form.NumberField({
        id:'numCdbec_tipo_ciclo',
        name:'numCdbec_tipo_ciclo',
        fieldLabel :'Tipo ciclo'
        // disabled :false
    });
    /**
     * Ext.form.NumberField tipo de ciclo

     */

    var cbxCdhu_tipo_ciclo = new Ext.form.ComboBox({
        id:'cbxCdhu_tipo_ciclo',
        name:'cbxCdhu_tipo_ciclo',
        store: dsTipoCiclo,
        fieldLabel :'Tipo ciclo',
        displayField: 'tipo_ciclo',
        valueField: 'id',
        mode:'local',
        typeAhead:true,
        autoSelect:true,
        hiddenId:'cbxCdhu_tipo_cicloH',
        hiddenName:'cbxCdhu_tipo_cicloH',
        hiddenValue:'id',
        forceSelection:true,
        editable: true,
        triggerAction:'all',
        submitValue:true,
        anchor:'98%',
        triggerAction:'all',
        emptyText : 'Seleccione una opci\u00f3n..',
		allowBlank:false
    });
    /**
     * Ext.form.NumberField TOTAL DE CICLIO QUE DEBE CUMPLIR PARA APROBAR LA CARRERA.
     */

    var numCdbec_total_ciclos = new Ext.ux.form.SpinnerField({
        id:'numCdbec_total_ciclos',
        name:'numCdbec_total_ciclos',
        fieldLabel :'Total ciclos',
        minValue: 0,
        maxValue: 20,
        value: 0,
        anchor:'70%'
    });
    /**
     * Ext.form.TextField NUEMRO DE CUENTA PARA EL DEPOSITO DEL DINERO DE LA BECA
     */
    var txtCdbec_numero_cuento = new Ext.form.TextField({
        id:'txtCdbec_numero_cuento',
        name:'txtCdbec_numero_cuento',
        fieldLabel :'No. Cuenta',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Ext.form.TextField INFORMACION ADICIONAL
     */
    var txtCdbec_observacion = new Ext.form.TextArea({
        id:'txtCdbec_observacion',
        name:'txtCdbec_observacion',
        fieldLabel :'Observaci\u00f3n',
        anchor:'98%'
    });
    /**
     * Ext.form.Checkbox ESTADO QUE DETERMINA SI LA PERSONA ENTREGO UNA COPIA DE SU TITULO PROFESIONAL
     */
    var chkCdbec_titulo_entregado = new Ext.form.Checkbox({
        id:'chkCdbec_titulo_entregado',
        name:'chkCdbec_titulo_entregado',
        fieldLabel :'T\u00edtulo entregado'
    });
    chkCdbec_titulo_entregado.setVisible(false);
    //////////////////////////////adjunto///////////////////////////////
    /**
     * Ext.form.NumberField tipo de adjunto

     */

    /*var cbxCdhu_tipo_adjunto = new Ext.form.ComboBox({
        id:'cbxCdhu_tipo_adjunto',
        name:'cbxCdhu_tipo_adjunto',
        store: dtCdad_tipo,
        fieldLabel :'Tipo documento',
        //displayField: 'tipo_adjunto',
        //valueField: 'id',
        mode:'local',
        typeAhead:true,
        //hiddenId:'cbxCdhu_tipo_adjuntoH',
        //hiddenName:'cbxCdhu_tipo_adjuntoH',
        //hiddenValue:'id',
        forceSelection:true,
        editable: true,
        triggerAction:'all',
        submitValue:true,
        anchor:'98%',
        triggerAction:'all',
        emptyText : 'Seleccione una opci\u00f3n..',
		selectedIndex : 0
    });*/
	
	var cbxCdhu_tipo_adjunto = new Ext.form.ComboBox({
        id:'cbxCdhu_tipo_adjunto',
        name:'cbxCdhu_tipo_adjunto',
        store: dtCdad_tipo,
        anchor:'75%',
        //displayField: 'Representante',
        typeAhead: true,
        mode: 'local',
        editable: false,
        triggerAction:'all',
        emptyText : 'Seleccione',
        //valueField:'id_tipo_representante',
		allowBlank:false,
		selectedIndex : 0

    });
	
    /**
     * Ext.form.TextArea CAMPO DE TEXTO DESCRIPCION CONTENIDO
     */
    var txtCdad_descripcion_contenido = new Ext.form.TextField({
        id:'txtCdad_descripcion_contenido',
        name:'txtCdad_descripcion_contenido',
        fieldLabel :'Descripci\u00f3n contenido',
        width:'90%'
    });
    /**
     * Ext.form.TextArea CAMPO DE TEXTO DE UNA DESCRIPCION DE DOCUMENTO
     */
    var txtCdad_descripcion = new Ext.form.TextField({
        id:'txtCdad_descripcion',
        name:'txtCdad_descripcion',
        fieldLabel :'Descripci\u00f3n',
        width:'90%'
    });
    /**
     * Ext.form.TextArea CAMPO DE TEXTO DE OBSERVACION DEL DOCUMENTO
     */
    var txtCdad_observacion = new Ext.form.TextField({
        id:'txtCdad_observacion',
        name:'txtCdad_observacion',
        fieldLabel :'Observaci\u00f3n',
        width:'90%'
    });

    //////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_adjunto.
     */
    var cmCgg_dhu_adjunto = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
        {
            dataIndex:'CDAD_CODIGO',
            width:40,
            hidden:true,
            hideable:false
        },
        {
            dataIndex:'CDBEC_CODIGO',
            header:'Beca',
            width:200,
            sortable:true,
            hidden:true
        },{
            dataIndex:'CDAD_NOMBRE_ADJUNTO',
            header:'Nombre Adjunto',
            width:100,
            sortable:true

        },{
            dataIndex:'CDAD_DESCRIPCION',
            header:'Descripci\u00f3n',
            width:100,
            sortable:true,editor:txtCdad_descripcion

        },

        {
            dataIndex:'CDAD_OBSERVACION',
            header:'Observaci\u00F3n',
            width:150,
            sortable:true,editor:txtCdad_observacion
        },

        {
            dataIndex:'CDAD_TIPO',
            header:'Tipo',
            width:150,
			/*if(inCdhuTipoAdjunto==TypeAdjuntoBeca.CONTRATO_BECA){
					return('CONTRATO DE BECA')
				}if(inCdhuTipoAdjunto==TypeAdjuntoBeca.INFORME){
					return('INFORME')
				}if(inCdhuTipoAdjunto==TypeAdjuntoBeca.MEMORANDUM_APROBACIONES){
					return('MEMORANDUM DE APROBACIONES')
				}if(inCdhuTipoAdjunto==TypeAdjuntoBeca.OTROS){
					return('OTROS')
				}*/
            sortable:true,editor:cbxCdhu_tipo_adjunto,renderer:function(inCdhuTipoAdjunto){			
				
				var result = "";				
				if(!cbxCdhu_tipo_adjunto.getValue()){
					cbxCdhu_tipo_adjunto.setValue(cbxCdhu_tipo_adjunto.store.data.items[0].data.field1)
				}
                switch (cbxCdhu_tipo_adjunto.getValue()) {
                    case 0:
                        result = 'CONTRATO DE BECA';
                        break;
                    case 1:
                        result = 'INFORME';
                        break;
                    case 2:
                        result = 'MEMORANDUM DE APROBACIONES';
                        break;
                    case 3:
                        result = 'OTROS';
                        break;                                       
                }
                return cbxCdhu_tipo_adjunto.getValue();
			}
        },{
            dataIndex:'CDAD_DESCRIPCION_CONTENIDO',
            header:'Descripci\u00f3n contenido ',
            width:100,
            sortable:true,editor:txtCdad_descripcion_contenido
        }, {dataIndex:'CRATE_DATA',header:'CRATE_DATA',width:150,sortable:true,hidden:true,hideable:true}
    ]);

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_adjunto por un campo especifico.
     */
    var gsCgg_dhu_adjunto = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS + "Cgg_dhu_adjunto",
            method:"selectAdjuntoBecas"
        }),
        reader:new Ext.data.JsonReader({}, [
            {name:'CDAD_CODIGO'},
            {name:'CDBEC_CODIGO'},
            {name:'CDAD_DESCRIPCION'},
            {name:'CDAD_OBSERVACION'},
			{name:'CDAD_NOMBRE_ADJUNTO'},  
			//{name:'CDAD_ADJUNTO'},
			{name:'CDAD_TIPO'},
			{name:'CDAD_DESCRIPCION_CONTENIDO'}
        ]),
        baseParams:{
            inCdbec_codigo:'',
            format:"JSON"
        }
    });


    /*
     * Ext.ux.grid.RowEditor Edito de filas personalizado para utilizaci?n en el grid de adjunto beca
     */
    var reAdjuntoBeca = new Ext.ux.grid.RowEditor({
        saveText: 'Aceptar',
        cancelText:'Cancelar'
    });
    reAdjuntoBeca.stopMonitoring();
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_gem_perfil_prof en un formato tabular de filas y columnas.
     */
    var grdCgg_dhu_adjunto = new Ext.grid.GridPanel({
        cm:cmCgg_dhu_adjunto,
        store: gsCgg_dhu_adjunto,
        region:'center',
        height:155,
		x:12,
        sm: new Ext.grid.RowSelectionModel({
            singleSelect: true,
            moveEditorOnEnter: false
        }),
        loadMask: {
            msg: "Cargando..."
        },
        trackMouseOver: true,
        tbar: [{
            xtype:'button',
            iconCls:'iconNuevo',
            handler:function() {
                var objSubirAdjunto = new FrmCgg_res_adjunto_temporal();
                var rAdjuntoTemporal = grdCgg_dhu_adjunto.getSelectionModel().getSelected();
                objSubirAdjunto.closeHandler(function(){
                    /*var dialogResult = objSubirAdjunto.dialogResult();
                    if(dialogResult  !== null){
                        var tmpRecordAjunto = grdCgg_dhu_adjunto.getStore().recordType;
                        reAdjuntoBeca.stopEditing();
                        grdCgg_dhu_adjunto.getStore().insert(0,
                                new tmpRecordAjunto({
                                    'CDAD_CODIGO':'KEYGEN',
                                    'CDBEC_CODIGO':'',
                                    'CDAD_DESCRIPCION':'',
                                    'CDAD_OBSERVACION':'',
                                    'CDAD_NOMBRE_ADJUNTO':dialogResult.CRATE_NOMBRE,
                                    'CDAD_ADJUNTO':'',
                                    'CDAD_TIPO':'',
                                    'CDAD_DESCRIPCION_CONTENIDO':'',
                                    'CRATE_DATA':dialogResult.CRATE_CODIGO
                                })
                                );
                        grdCgg_dhu_adjunto.getView().refresh();
                        grdCgg_dhu_adjunto.getSelectionModel().selectRow(0);
                        reAdjuntoBeca.startEditing(0);
					}	*/
						var dialogResult = objSubirAdjunto.dialogResult();
						if(dialogResult  !== null){						
							var tmpRecordAjunto = grdCgg_dhu_adjunto.getStore().recordType;
							reAdjuntoBeca.stopEditing();
							grdCgg_dhu_adjunto.getStore().insert(0,
									new tmpRecordAjunto({
										'CDAD_CODIGO':'KEYGEN',
										'CDBEC_CODIGO':'',
										'CDAD_DESCRIPCION':'',
										'CDAD_OBSERVACION':'',
										'CDAD_NOMBRE_ADJUNTO':dialogResult.CRATE_NOMBRE,
										'CDAD_ADJUNTO':'',
										'CDAD_TIPO':'',
										'CDAD_DESCRIPCION_CONTENIDO':'',										
										'CRATE_DATA':dialogResult.CRATE_CODIGO
									})
							);
							grdCgg_dhu_adjunto.getView().refresh();
							grdCgg_dhu_adjunto.getSelectionModel().selectRow(0);
							reAdjuntoBeca.startEditing(0);
							//dtCdsad_fecha_ingreso.setValue(new Date());
							//txtCdsad_observacion.focus(true);
						}
                    
                });
                objSubirAdjunto.show();
            }
        }, {
            id: 'btnEliminarAdjuntoAcuerdo',
            iconCls: 'iconEliminar',
            handler: function(grid, rowIndex, colIndex) {
                grdCgg_dhu_adjunto.getSelectionModel().selectRow(rowIndex);
                var rAdjuntoBeca= grdCgg_dhu_adjunto.getSelectionModel().getSelected();
                EliAdjunto.push(rAdjuntoBeca.get('CDAD_CODIGO'));
                tmpListadoEliminar1 = Ext.util.JSON.encode(EliAdjunto);
                //alert("hola"+tmpListadoEliminar);
                grdCgg_dhu_adjunto.getStore().remove(rAdjuntoBeca);
            }

        },{
            id:'btnVerAdjuntoAcuerdo',
            iconCls:'iconVer',
            listeners:{
                click:function(){
                    /*var r=grdCgg_dhu_adjunto.getSelectionModel().getSelected();
                    if(r)
                        window.open(URL_DOC_VIEWER+'?table=cgg_dhu_adjunto&keyc=cdad_codigo&keyv='+r.get('CDAD_CODIGO')+'&column=cdad_adjunto&fn='+r.get('CDAD_NOMBRE_ADJUNTO')+'&request=view');*/
					var r=grdCgg_dhu_adjunto.getSelectionModel().getSelected();
                    if(r){                        
						if(r.get('CRATE_DATA')){
							window.open(URL_DOC_VIEWER+'?table=cgg_res_adjunto_temporal&keyc=crate_codigo&keyv='+r.get('CRATE_DATA')+'&column=crate_archivo&fn='+r.get('CDAD_NOMBRE_ADJUNTO')+'&request=view');
						}else{
							window.open(URL_DOC_VIEWER+'?table=cgg_dhu_adjunto&keyc=cdad_codigo&keyv='+r.get('CDAD_CODIGO')+'&column=cdad_adjunto&fn='+r.get('CDAD_NOMBRE_ADJUNTO')+'&request=view');
						}
					}
                }
              
            }

        },{id:'btnDescargarAdjuntoAcuerdo',
            iconCls:'iconDescargar',
            listeners:{
                click:function(){
                    /*var r=grdCgg_dhu_adjunto.getSelectionModel().getSelected();
                    if(r)
                        window.open(URL_DOC_VIEWER+'?table=cgg_dhu_adjunto&keyc=cdad_codigo&keyv='+r.get('CDAD_CODIGO')+'&column=cdad_adjunto&fn='+r.get('CDAD_NOMBRE_ADJUNTO')+'&request=view');*/
					var r=grdCgg_dhu_adjunto.getSelectionModel().getSelected();
                    if(r){                        
						if(r.get('CRATE_DATA')){
							window.open(URL_DOC_VIEWER+'?table=cgg_res_adjunto_temporal&keyc=crate_codigo&keyv='+r.get('CRATE_DATA')+'&column=crate_archivo&fn='+r.get('CDAD_NOMBRE_ADJUNTO')+'&request=download');
						}else{
							window.open(URL_DOC_VIEWER+'?table=cgg_dhu_adjunto&keyc=cdad_codigo&keyv='+r.get('CDAD_CODIGO')+'&column=cdad_adjunto&fn='+r.get('CDAD_NOMBRE_ADJUNTO')+'&request=download');
						}
					}
                }
            }
        }] ,plugins:[reAdjuntoBeca]
    });

    /**
     * Ext.form.Checkbox DETERMINA SI UNA BECA YA FUE RECOMPENSADA CON TRABAJO EN LA PROVINCIA
     */
    var chkCdbec_beca_devengada = new Ext.form.Checkbox({
        id:'chkCdbec_beca_devengada',
        name:'chkCdbec_beca_devengada',
        fieldLabel :'Beca devengada',
        checked:false,
        listeners: {
            check: function(){
                if(chkCdbec_beca_devengada.getValue()==true){
                    Ext.Msg.show({
                        title:tituloCgg_dhu_beca,
                        msg: 'La beca se dara por concluida.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.INFO});
                    cbxTipoAprobacionBeca.disable();


                }
            }
        }
    });
    chkCdbec_beca_devengada.setVisible(false);

    //Creamos una definici?n de los campos que vienen en el Json remoto DEL ESTADO DE APROBACION DE LA BECA
    var cbxTipoAprobacionBeca = new Ext.form.ComboBox({
        id:'cbxTipoAprobacionBeca',
        name:'cbxTipoAprobacionBeca',
        store: dsTipoAprobacionBeca,
        displayField: 'Beca_Aprobada',
        fieldLabel :'Estado beca',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        editable: false,
        triggerAction:'all',
        valueField:'id_tipo_aprobacion',
        anchor:'98%',
        emptyText : 'Seleccione una opci\u00f3n..',
        typeAhead:true,
        autoSelect:true,
        hiddenValue:'id_tipo_aprobacion',
        submitValue:true
        /* listeners:{
         change:function(){
         if(cbxTipoAprobacionBeca.getValue()==TypeBecaAprobacion.REGISTRADA){
         cbxTipoAprobacionBeca.setValue('REGISTRADA');
         }}}*/
    });


    //cbxTipoAprobacionBeca.store.filter('id',cbxTipoAprobacionBeca.getValue(),false);
    cbxTipoAprobacionBeca.setVisible(false);
    /**
     * Ext.form.NumberField CAMPO QUE SE REGISTRA EL VALOR DE REMBOLSO POR NO CULMINAR LA BECA
     */
    var numCdbec_valor_reembolso = new Ext.form.NumberField({
        id:'numCdbec_valor_reembolso',
        name:'numCdbec_valor_reembolso',
        fieldLabel :'Valor reembolso'
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_dhu_beca
     */
    var btnGuardarCgg_dhu_beca = new Ext.Button({
        id:'btnGuardarCgg_dhu_beca',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_dhu_beca.getForm().isValid()==false){
					Ext.Msg.show({
						title:tituloCgg_dhu_beca,
						msg: 'Verifique que todos los datos hayan sido ingresado correctamente',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.INFO
					});
                    return;
                }
				if(!txtCdhu_num_doc_identific.getValue()){
					Ext.Msg.show({
						title:tituloCgg_dhu_beca,
						msg: 'Por favor ingrese un n\u00FAmero de documento de identificaci\u00F3n v\u00E1lido',
						buttons: Ext.Msg.OK,
						fn:function(btn){
							if(btn == 'ok'){
								txtCrper_numero_documento.focus(true);
							}
						},
						icon: Ext.MessageBox.INFO
					});
					return;
				}
				if(gsPersonabecaRepresentante.getCount()==0){
					Ext.Msg.show({
						title:tituloCgg_dhu_beca,
						msg: 'Por favor ingrese por lo menos un representante',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.INFO
					});
                    return;
				}
				
				if(isEdit){
					if (chkCdbec_beca_devengada.getValue()==true  ){
						tmpTipoAprobacion = TypeBecaAprobacion.CONCLUIDA;
					}else{
						if (cbxTipoAprobacionBeca.getValue()=='REGISTRADA' ) {
							tmpTipoAprobacion=TypeBecaAprobacion.REGISTRADA;
						}else{
							if (cbxTipoAprobacionBeca.getValue()=='EN SEGUIMIENTO' ) {
								tmpTipoAprobacion=TypeBecaAprobacion.EN_SEGUIMIENTO;
							}else{
								if (cbxTipoAprobacionBeca.getValue()=='CONCLUIDA' ) {
									tmpTipoAprobacion=TypeBecaAprobacion.CONCLUIDA;
								}else{
									tmpTipoAprobacion = cbxTipoAprobacionBeca.getValue();
								}
							}
						}
					}				
				}else{
					tmpTipoAprobacion =TypeBecaAprobacion.REGISTRADA;
				}
				if (numCdbec_vsalida_valor.getValue()) {
						tmpValorSalida=numCdbec_vsalida_valor.getValue();
					}else {
						tmpValorSalida=0;
					}
					if (numCdbec_vretorno_valor.getValue()){
						tmpValorRetorno=numCdbec_vretorno_valor.getValue();
					}else {tmpValorRetorno=0;}
                try{
                    function CallBackCgg_dhu_beca(r){
                        winFrmCgg_dhu_beca.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_dhu_beca,
                                msg: 'La informaci\u00f3n  ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_dhu_beca.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_dhu_beca,
                                msg: 'La informaci\u00f3n  no ha podido ser almacenada. '+r.message.split(': ')[1],
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }if(r.length==0){
                            Ext.Msg.show({
                                title:tituloCgg_dhu_beca,
                                msg: 'Verifque si todos los campos obligatorios tienen informaci\u00f3n',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }


                    winFrmCgg_dhu_beca.getEl().mask('Guardando...', 'x-mask-loading');
                    if(EliAdjunto.length<=0){
                        tmpListadoEliminar1= '[]';
                    }
                    var param = new SOAPClientParameters();
                    if(isEdit){
                        param.add('inAdjuntoEliminar',tmpListadoEliminar1 );
                        param.add('inCdbec_codigo',txtCdbec_codigo.getValue());
						param.add('inCdbec_numero',txtCdbec_numero.getValue());
                    }else
					    param.add('inCdbec_numero','0'); //EL NUMERO SE GENERA EN LA BASE DE DATOS
                    param.add('inCdtbc_codigo',cbxTipoBeca.getValue());
                    param.add('inCgesp_codigo',txtCgesp_codigo.getValue());
                    param.add('inCgied_codigo',txtCgied_codigo.getValue());
                    param.add('inCpais_codigo',cbxPais.getValue());
                    param.add('inCgtpr_codigo',txtCgtpr_codigo.getValue());
                    param.add('inCrper_codigo',txtCrper_codigo.getValue());
                    param.add('inCgg_crper_codigo',txtCgg_crper_codigo.getValue());
                    param.add('inCrpjr_codigo',txtCrpjr_codigo.getValue());
                    param.add('inCdbec_fecha_ingreso',dtCdbec_fecha_ingreso.getValue().format('c'));
                    param.add('inCdbec_funcionario',txtCgg_crper_funcionario.getValue());
                    param.add('inCdbec_numero_aprobacion',txtCdbec_numero_aprobacion.getValue());
                    param.add('inCdbec_fecha_inicio',dtCdbec_fecha_inicio.getValue().format('c'));
                    param.add('inCdbec_fecha_fin',dtCdbec_fecha_fin.getValue().format('c'));
                    param.add('inCdbec_numero_convenio',txtCdbec_numero_convenio.getValue());
                    param.add('inCdbec_vsalida_origen',txtCdbec_vsalida_origen.getValue());
                    param.add('inCdbec_vsalida_destino',txtCdbec_vsalida_destino.getValue());
                    param.add('inCdbec_vsalida_valor',tmpValorSalida);
                    param.add('inCdbec_vretorno_origen',txtCdbec_vretorno_origen.getValue());
                    param.add('inCdbec_vretorno_destino',txtCdbec_vretorno_destino.getValue());
                    param.add('inCdbec_vretorno_valor',tmpValorRetorno);
                    param.add('inCdbec_carrera',txtCdbec_carrera.getValue());
                    param.add('inCdbec_tipo_ciclo',cbxCdhu_tipo_ciclo.getValue());
                    param.add('inCdbec_total_ciclos',numCdbec_total_ciclos.getValue());
                    param.add('inCdbec_numero_cuento',txtCdbec_numero_cuento.getValue());
                    param.add('inCdbec_numero_aprobacion_modificatorio',txtCdbec_numero_aprobacion_modificatorio.getValue());
                    param.add('inCdbec_numero_contrato_modificatorio',txtCdbec_numero_contrato_modificatorio.getValue());
                    param.add('inCdbec_observacion_contrato_modificatorio',txtCdbec_observacion_contrato_modificatorio.getValue());
                    param.add('inCdbec_observacion',txtCdbec_observacion.getValue());
                    param.add('inCdbec_titulo_entregado',chkCdbec_titulo_entregado.getValue());
                    param.add('inCdbec_beca_devengada',chkCdbec_beca_devengada.getValue());
                    param.add('inCdbec_estado_aprobacion',tmpTipoAprobacion);
                    param.add('inCdbec_valor_reembolso',(numCdbec_valor_reembolso.getValue())?numCdbec_valor_reembolso.getValue():0);
                    param.add('inCdinr_descripcion',txtCrper_descripcion_representante.getValue());
                    param.add('inCdinr_tipo_representante',cbxTipoRepresentante.getValue());
                    param.add('inPersonaRepresentante_JSON', grdCgg_res_persona.getStore().getJsonData());
                    param.add('inAdjunto_JSON',grdCgg_dhu_adjunto.getStore().getJsonData());
                    param.add('inPerfilProfesional_JSON',grdCgg_gem_perfil_prof_beca.getStore().getJsonData());
                    SOAPClient.invoke(urlCgg_dhu_beca,IN_SENTENCIA_CGG_DHU_BECA,param, true, CallBackCgg_dhu_beca);
                }catch(inErr){
                    winFrmCgg_dhu_beca.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_dhu_beca.
     */
    var btnCancelarCgg_dhu_beca = new Ext.Button({
        id:'btnCancelarCgg_dhu_beca',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_dhu_beca.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_dhu_beca.
     */
    var btnCerrarCgg_dhu_beca = new Ext.Button({
        id:'btnCerrarCgg_dhu_beca',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_dhu_beca.close();
            }}
    });
    var pnlCgg_dhu_adjunto = new Ext.form.FieldSet({
        id:'pnlCgg_dhu_adjunto',
        title:'Adjunto Documento',
        height:200,
        region:'west',
        split:true,        
        items:[grdCgg_dhu_adjunto]
    });
    var pnlCgg_dhu_perfil_prof = new Ext.Panel({
        frame : true,
        title:'Datos Acad\u00e9micos',
        anchor:'100% 100%',
        tbar:[{
            xtype:'button',
            iconCls:'iconNuevo',
            listeners:{
                click:function(){
                    var objCgg_gem_perfil_prof = new FrmCgg_gem_perfil_prof("insert",null,"persona");
                    objCgg_gem_perfil_prof.closeHandler(function(){

                        var tmpRecordPerfilPersona = objCgg_gem_perfil_prof.getData();
                        if(tmpRecordPerfilPersona)
                        {
                            var recId = grdCgg_gem_perfil_prof_beca.getStore().getCount() + 1;
                            grdCgg_gem_perfil_prof_beca.stopEditing();
                            grdCgg_gem_perfil_prof_beca.getStore().insert(0, new gsCgg_gem_perfil_prof_beca.recordType(tmpRecordPerfilPersona, recId));
                            grdCgg_gem_perfil_prof_beca.getView().refresh();

                            grdCgg_gem_perfil_prof_beca.getSelectionModel().selectRow(0);
                            /*  if (grdCgg_gem_perfil_prof_beca.getSelectionModel().getSelected().get('CGPPR_PREDETERMINADO') == true)
                             {
                             Ext.getCmp('btnPredeterminadoCgg_gem_perfil_prof').fireEvent('click',Ext.getCmp('btnPredeterminadoCgg_gem_perfil_prof'));
                             }*/
                        }

                    });
                    objCgg_gem_perfil_prof.show();
                }}
        },
            {
                xtype:'button',
                id:'btnEditarCgg_gem_perfil_prof',
                iconCls:'iconEditar',
                listeners:{
                    click:function(){
                        var r = grdCgg_gem_perfil_prof_beca.getSelectionModel().getSelected();
                        var index = 0;
                        if (r) {
                            var objCgg_gem_perfil_prof = new FrmCgg_gem_perfil_prof("Update",r,"persona");
                            objCgg_gem_perfil_prof.closeHandler(function(){

                                var tmpRecordPerfilPersona = objCgg_gem_perfil_prof.getData();
                                if(tmpRecordPerfilPersona)
                                {
                                    index = grdCgg_gem_perfil_prof_beca.getStore().indexOf(r);
                                    var recId = grdCgg_gem_perfil_prof_beca.getStore().getCount() + 1 + index; // provide unique id
                                    grdCgg_gem_perfil_prof_beca.stopEditing();

                                    grdCgg_gem_perfil_prof_beca.getStore().remove(grdCgg_gem_perfil_prof_beca.getSelectionModel().getSelected());
                                    //grdCgg_gem_perfil_prof.getView().refresh();
                                    grdCgg_gem_perfil_prof_beca.getStore().insert(index, new gsCgg_gem_perfil_prof_beca.recordType(tmpRecordPerfilPersona, recId));
                                    grdCgg_gem_perfil_prof_beca.getView().refresh();
                                    grdCgg_gem_perfil_prof_beca.getSelectionModel().selectRow(index);
                                }

                            });
                            objCgg_gem_perfil_prof.loadData();
                            objCgg_gem_perfil_prof.show();
                        }}
                }
            },
            {
                iconCls:'iconEliminar',
                tooltip:'Eliminar perfil profesional',
                handler:function(){
                    Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_perfil_prof,icon: Ext.MessageBox.QUESTION});
                    function SWRCgg_perfil_prof(btn){
                        if (btn=='yes')
                        {
                            try{
                                var seleccionado = grdCgg_gem_perfil_prof_beca.getSelectionModel().getSelected();
                                if(seleccionado)
                                {
                                    function CallBackCgg_gem_perfil_prof(r){
                                        winFrmCgg_dhu_beca.getEl().unmask();
                                        if(r=='true'){
                                            Ext.Msg.show({
                                                title:tituloCgg_dhu_beca,
                                                msg: 'La informaci\u00f3n de perfil profesional ha sido eliminada.',
                                                buttons: Ext.Msg.OK,
                                                icon: Ext.MessageBox.INFO
                                            });
                                            grdCgg_gem_perfil_prof_beca.getStore().remove(seleccionado);
                                        }else{
                                            Ext.Msg.show({
                                                title:tituloCgg_dhu_beca,
                                                msg: 'La informaci\u00f3n de perfil profesional no ha podido ser eliminada.',
                                                buttons: Ext.Msg.OK,
                                                icon: Ext.MessageBox.ERROR
                                            });
                                        }}
                                    winFrmCgg_dhu_beca.getEl().mask('Eliminando...', 'x-mask-loading');

                                    if(seleccionado.get('CGPPR_CODIGO') == 'KEYGEN')
                                    {
                                        grdCgg_gem_perfil_prof_beca.getStore().remove(seleccionado);
                                        winFrmCgg_dhu_beca.getEl().unmask();
                                    }
                                    else
                                    {
                                        var param = new SOAPClientParameters();
                                        param.add('inCgppr_codigo',grdCgg_gem_perfil_prof_beca.getSelectionModel().getSelected().get('CGPPR_CODIGO'));
                                        SOAPClient.invoke(URL_WS + 'Cgg_gem_perfil_prof',"delete",param, true, CallBackCgg_gem_perfil_prof);
                                    }

                                }
                            }catch(inErr){
                                winFrmCgg_dhu_beca.getEl().unmask();
                            }
                        }
                    }
                }

            },
            '->',
            {
                id:'btnPredeterminadoCgg_gem_perfil_prof',
                iconCls:'iconPredeterminado',
                tooltip:'Marcar predeterminado',
                listeners:{
                    click:function(){
                        if (grdCgg_gem_perfil_prof_beca.getSelectionModel().getSelected())
                        {
                            grdCgg_gem_perfil_prof_beca.getSelectionModel().getSelected().set('CGPPR_PREDETERMINADO',true);
                            //Aqui el codigo para recorrer el grid y poner los registros diferentes al seleccionado en false
                            var tmpCGPPR_CODIGO = grdCgg_gem_perfil_prof_beca.getSelectionModel().getSelected().get('CGPPR_CODIGO');
                            for(var i =0;i<grdCgg_gem_perfil_prof_beca.getStore().getCount();i++){
                                if(!grdCgg_gem_perfil_prof_beca.getSelectionModel().isSelected(i))
                                {
                                    grdCgg_gem_perfil_prof_beca.getStore().getAt(i).set('CGPPR_PREDETERMINADO',false);
                                }
                            }
                        }

                    }
                }

            }

        ],
        items:[grdCgg_gem_perfil_prof_beca]
    });
    /**
     * Ext.Panel Panel que contiene los datos informativos de persona
     */
    var pnlCgg_res_persona_beca = new Ext.form.FieldSet({
        id:'pnlCgg_res_persona_beca',
        title:'Persona',
        collapsible:true,
        height:137,
        layout:'form',
        region:'north',
        items:[
            {xtype:'panel',layout:'column',
                items:[
                    {columnWidth:.50,layout:'form',
                        items:[txtCdhu_codigo]},
                    {columnWidth:.50,layout:'form',
                        items:[txtCdhu_num_doc_identific]}
                ]},
            {xtype:'panel',layout:'column',
                items:[
                    {columnWidth:.50,layout:'form',
                        items:[txtCdhu_nombres]},
                    {columnWidth:.50,layout:'form',
                        items:[txtCdhu_apellido_paterno]}
                ]},
            {xtype:'panel',layout:'column',
                items:[
                    {columnWidth:.50,layout:'form',
                        items:[txtCdhu_residencia]},
                    {columnWidth:.50,layout:'form',
                        items:[txtCdhu_lugar_nacimiento]}
                ]},
            {xtype:'panel',layout:'column',
                items:[
                    {columnWidth:.50,layout:'form',
                        items:[dtCdhu_fecha_nacimiento]},
                    {columnWidth:.50,layout:'form',
                        items:[txtCdhu_edad]}
                ]}
        ]


    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de los registros de beca.
     */
    var pnlCgg_dhu_registro_beca = new Ext.Panel({

        labelWidth :100,

        items:[
            {xtype:'panel',layout:'column', labelWidth :100,
                items:[
                    {columnWidth:.50,layout:'form',
                        items:[txtCdbec_numero]},
                    {columnWidth:.50,layout:'form',items:[cbxTipoBeca]}

                ]}, {xtype:'panel',layout:'column',
                items:[
                    {columnWidth:.95,layout:'form',
                        items:[txtCgg_crper_funcionario]},
                    {columnWidth:.05,layout:'form',
                        items:[btnCgg_crper_codigoCgg_dhu_beca]}
                ]}


        ]   });
    /**
     * Ext.Panel Panel que contiene los datos informativos de persona
     */
    var pnlCgg_res_beca_convenio = new Ext.form.FieldSet({
        id:'pnlCgg_res_beca_convenio',
        title:'Convenio',
        collapsible:true,
        // height:137,
        layout:'form',
        //region:'north',
        items:[
            {xtype:'panel',layout:'column',
                items:[
                    {columnWidth:.50,layout:'form',labelWidth :100,
                        items:[txtCdbec_numero_aprobacion]},
                    {columnWidth:.50,layout:'form',
                        items:[txtCdbec_numero_convenio]}
                ]},
            {xtype:'panel',layout:'column', labelWidth :100,
                items:[
                    {columnWidth:.50,layout:'form',
                        items:[dtCdbec_fecha_inicio]},
                    {columnWidth:.50,layout:'form',items:[dtCdbec_fecha_fin]}
                ]}, {xtype:'panel',layout:'column',
                items:[
                    {columnWidth:.95,layout:'form',
                        items:[txtCrpjr_nombre]},
                    {columnWidth:.05,layout:'form',
                        items:[btnCrpjr_codigoCgg_dhu_beca]}
                ]},{xtype:'panel',layout:'column',
                items:[
                    {columnWidth:.50,layout:'form',
                        items:[txtCdbec_numero_cuento]},
                    {columnWidth:.50,layout:'form',
                        items:[numCdbec_valor_reembolso]}
                ]}
        ]


    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de los registros de beca.
     */
    var pnlCgg_dhu_registro_beca_general = new Ext.Panel({
        frame:true,
        labelWidth :100,
        title: 'Beca',
        // heigth:300,
        //fileUpload:true,

        items:[pnlCgg_dhu_registro_beca,pnlCgg_res_beca_convenio,
            {xtype:'panel',layout:'column',
                items:[
                    {columnWidth:.40,layout:'form',
                        items:[cbxTipoAprobacionBeca]},
                    {columnWidth:.30,layout:'form',
                        items:[chkCdbec_titulo_entregado ]},
                    {columnWidth:.30,layout:'form',
                        items:[chkCdbec_beca_devengada]}
                ]}


        ]   });

    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de los registros de beca.
     */
    var pnlCgg_dhu_registro_carrera = new Ext.Panel({
        frame:true,
        //labelWidth :100,
        title: 'Carrera',
        layout:'form',
        fileUpload:true,
        items:[ {xtype:'panel',layout:'column',
            items:[{columnWidth:.50,layout:'form',labelWidth :100,
                items:[cbxPais]},
                {columnWidth:.50,layout:'form',labelWidth :70,
                    items:[cbxNivelEstudio]},
                {columnWidth:.45,layout:'form',
                    items:[txtCgied_institucion_educativa]},
                {columnWidth:.05,layout:'form',
                    items:[btnCgied_codigoCgg_dhu_beca]},
                {columnWidth:.50,layout:'form',labelWidth :70,
                    items:[txtCdbec_carrera]}
            ]},
            {xtype:'panel',layout:'column', labelWidth :100,
                items:[
                    {columnWidth:.95,layout:'form',
                        items:[txtCgesp_nombre]},
                    {columnWidth:.05,layout:'form',items:[btnCgesp_codigoCgg_dhu_beca]}

                ]},
            {xtype:'panel',layout:'column', labelWidth :100,
                items:[
                    {columnWidth:.95,layout:'form',
                        items:[txtCgtpr_nombre_titulo]},
                    {columnWidth:.05,layout:'form',items:[btnCgtpr_codigoCgg_dhu_beca]}

                ]},
            {xtype:'panel',layout:'column',
                items:[
                    {columnWidth:.50,layout:'form',
                        items:[cbxCdhu_tipo_ciclo]},
                    {columnWidth:.50,layout:'form',
                        items:[numCdbec_total_ciclos]}
                ]},txtCdbec_observacion]  });

    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de los registros de beca.
     */
    var pnlCgg_dhu_registro_vuelo = new Ext.form.FieldSet({
        //frame:true,
        labelWidth :100,
        title: 'Registro viaje',
        // layout:'form',
        width:325,
        height:200,
        collapsible:true,
        items:[
            txtCdbec_vsalida_origen,
            txtCdbec_vsalida_destino,
            numCdbec_vsalida_valor,
            txtCdbec_vretorno_origen,
            txtCdbec_vretorno_destino,
            numCdbec_vretorno_valor

        ]  });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_dhu_beca.
     */
    var pnlCgg_dhu_persona_representante = new Ext.Panel({
        layout:'form',
        title: 'Representante',
        items:[{
			xtype:'panel',layout:'column',
            items:[grdCgg_res_persona]
		}]
	});
    /**
     * Ext.Panel Panel que contiene los controles de LOS REGISTRO DE VUELO Y DESEMBOLSO
     */
    var pnlDatos_Adicionales = new Ext.Panel({
        title:'Datos Adicionales',
        region:'center',        
        frame:true,        
        items:[
            {xtype:'panel',layout:'column',
                items:[
                    {columnWidth:.50,layout:'form',
                        items:[pnlCgg_dhu_registro_vuelo]},
                    {columnWidth:.50,layout:'form',
                        items:[grdCgg_dhu_adjunto]}
                ]}]
    });
    /**
     * Ext.Panel Panel que contiene los controles del CONTRATO MODIFICATORIO
     */
    var pnlDatos_Contrato = new Ext.Panel({
        title:'Contrato Modificatorio',
        region:'center',
        frame:true,
        layout:'form',
        // width:920,
        items:[
            {xtype:'panel',layout:'column',
                items:[
                    {columnWidth:.50,layout:'form',
                        items:[txtCdbec_numero_aprobacion_modificatorio]},
                    {columnWidth:.50,layout:'form',
                        items:[txtCdbec_numero_contrato_modificatorio]}

                ]},txtCdbec_observacion_contrato_modificatorio]
    });

    /**
     * Ext.form.TabPanel  que contiene los controles de la ventana winFrmCgg_dhu_beca.
     */
    var tabBeca = new Ext.TabPanel({
        region:'south',
        activeTab:0,
        frame:true,
        height:260,
        items:[pnlCgg_dhu_perfil_prof,pnlCgg_dhu_registro_beca_general,pnlCgg_dhu_registro_carrera,pnlCgg_dhu_persona_representante,pnlDatos_Adicionales,pnlDatos_Contrato]
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_dhu_beca.
     */
    var pnlCgg_dhu_beca = new Ext.form.FormPanel({
        id:'pnlCgg_dhu_beca',
        frame:true,
        labelWidth :100,
        layout:'anchor',
        items:[
            {xtype:'panel',layout:'column', labelWidth :100,
                items:[
                    {columnWidth:.45,layout:'form',
                        items:[txtCrper_numero_documento]},
                    {columnWidth:.05,layout:'form',items:[btnCrper_codigoCgg_dhu_beca]},
                    {columnWidth:.50,layout:'form',items:[dtCdbec_fecha_ingreso]}

                ]},pnlCgg_res_persona_beca,tabBeca]  });
    /**
     * Funcion que permite cargar el  codigo del documento generado
     */
    /*function generarNumeroBeca() {
        function callBackGenerarNumeroBeca(r) {
            txtCdbec_numero.setValue(r);
        }

        SOAPClient.invoke(urlCgg_dhu_beca, 'numeroBeca', false, false,callBackGenerarNumeroBeca);
    }

    generarNumeroBeca();*/
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_dhu_beca.
     */
    var winFrmCgg_dhu_beca = new Ext.Window({
        id:'winFrmCgg_dhu_beca',
        title:tituloCgg_dhu_beca,
        width:700,
        minWidth:700,
        maximizable:false,
        minimizable:false,
		resizable:false,
		modal:true,
        layout:'anchor',
        constrain:true,
        tbar:getPanelTitulo(tituloCgg_dhu_beca,descCgg_dhu_beca),
        items:[pnlCgg_dhu_beca],
        bbar:[btnGuardarCgg_dhu_beca,btnCancelarCgg_dhu_beca,'->',btnCerrarCgg_dhu_beca],
		listeners:{
			show:function(){
				for (i = 0; i < tabBeca.items.length; i++) {
					tabBeca.setActiveTab(i);
				}
				tabBeca.setActiveTab(0);					
			}
		}
    });

    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_dhu_beca.
     */
    function cargarCgg_dhu_becaCtrls(){
        if(inRecordCgg_dhu_beca){
            txtCdbec_codigo.setValue(inRecordCgg_dhu_beca.get('CDBEC_CODIGO'));            
            txtCdhu_codigo.setValue(inRecordCgg_dhu_beca.get('CRDID_TIPO'));            
            txtCgesp_codigo.setValue(inRecordCgg_dhu_beca.get('CGESP_CODIGO'));
            txtCgied_codigo.setValue(inRecordCgg_dhu_beca.get('CGIED_CODIGO'));
            cbxPais.setValue(inRecordCgg_dhu_beca.get('CPAIS_CODIGO'));
            txtCgtpr_codigo.setValue(inRecordCgg_dhu_beca.get('CGTPR_CODIGO'));
            txtCrper_codigo.setValue(inRecordCgg_dhu_beca.get('CRPER_CODIGO'));
            txtCgg_crper_codigo.setValue(inRecordCgg_dhu_beca.get('CGG_CRPER_CODIGO'));
            txtCrpjr_codigo.setValue(inRecordCgg_dhu_beca.get('CRPJR_CODIGO'));
            txtCdbec_numero.setValue(inRecordCgg_dhu_beca.get('CDBEC_NUMERO'));
            dtCdbec_fecha_ingreso.setValue(truncDate(inRecordCgg_dhu_beca.get('CDBEC_FECHA_INGRESO')));
            txtCgg_crper_funcionario.setValue(inRecordCgg_dhu_beca.get('CDBEC_FUNCIONARIO'));
            txtCdbec_numero_aprobacion.setValue(inRecordCgg_dhu_beca.get('CDBEC_NUMERO_APROBACION'));
            dtCdbec_fecha_inicio.setValue(truncDate(inRecordCgg_dhu_beca.get('CDBEC_FECHA_INICIO')));
            dtCdbec_fecha_fin.setValue(truncDate(inRecordCgg_dhu_beca.get('CDBEC_FECHA_FIN')));
            txtCdbec_numero_convenio.setValue(inRecordCgg_dhu_beca.get('CDBEC_NUMERO_CONVENIO'));
            txtCdbec_vsalida_origen.setValue(inRecordCgg_dhu_beca.get('CDBEC_VSALIDA_ORIGEN'));
            txtCdbec_vsalida_destino.setValue(inRecordCgg_dhu_beca.get('CDBEC_VSALIDA_DESTINO'));
            numCdbec_vsalida_valor.setValue(inRecordCgg_dhu_beca.get('CDBEC_VSALIDA_VALOR'));
            txtCdbec_vretorno_origen.setValue(inRecordCgg_dhu_beca.get('CDBEC_VRETORNO_ORIGEN'));
            txtCdbec_vretorno_destino.setValue(inRecordCgg_dhu_beca.get('CDBEC_VRETORNO_DESTINO'));
            numCdbec_vretorno_valor.setValue(inRecordCgg_dhu_beca.get('CDBEC_VRETORNO_VALOR'));
            txtCdbec_carrera.setValue(inRecordCgg_dhu_beca.get('CDBEC_CARRERA'));
            cbxCdhu_tipo_ciclo.setValue(inRecordCgg_dhu_beca.get('CDBEC_TIPO_CICLO'));
            numCdbec_total_ciclos.setValue(inRecordCgg_dhu_beca.get('CDBEC_TOTAL_CICLOS'));
            txtCdbec_numero_cuento.setValue(inRecordCgg_dhu_beca.get('CDBEC_NUMERO_CUENTO'));
            txtCdbec_observacion.setValue(inRecordCgg_dhu_beca.get('CDBEC_OBSERVACION'));
            chkCdbec_titulo_entregado.setValue(inRecordCgg_dhu_beca.get('CDBEC_TITULO_ENTREGADO'));
            chkCdbec_beca_devengada.setValue(inRecordCgg_dhu_beca.get('CDBEC_BECA_DEVENGADA'));
            numCdbec_valor_reembolso.setValue(inRecordCgg_dhu_beca.get('CDBEC_VALOR_REEMBOLSO'));
            txtCdhu_num_doc_identific.setValue(inRecordCgg_dhu_beca.get('CRPER_NUM_DOC_IDENTIFIC'));
            txtCdhu_nombres.setValue(inRecordCgg_dhu_beca.get('CRPER_NOMBRES'));
            txtCdhu_apellido_paterno.setValue(inRecordCgg_dhu_beca.get('CRPER_APELLIDO_PATERNO')+' '+inRecordCgg_dhu_beca.get('CRPER_APELLIDO_MATERNO'));
            txtCdhu_residencia.setValue(inRecordCgg_dhu_beca.get('CRPER_NUMERO_RESIDENCIA'));
            txtCdhu_lugar_nacimiento.setValue(inRecordCgg_dhu_beca.get('CRPER_LUGAR_NACIMIENTO'));
            dtCdhu_fecha_nacimiento.setValue(truncDate(inRecordCgg_dhu_beca.get('CRPER_FECHA_NACIMIENTO')));
            cbxTipoAprobacionBeca.setValue(inRecordCgg_dhu_beca.get('CDBEC_ESTADO_APROBACION'));
            if(cbxTipoAprobacionBeca.getValue()==TypeBecaAprobacion.REGISTRADA){
                cbxTipoAprobacionBeca.setValue('REGISTRADA');
            }
            if(cbxTipoAprobacionBeca.getValue()==TypeBecaAprobacion.EN_SEGUIMIENTO){
                cbxTipoAprobacionBeca.setValue('EN SEGUIMIENTO');
            }
            if(cbxTipoAprobacionBeca.getValue()==TypeBecaAprobacion.CONCLUIDA){
                cbxTipoAprobacionBeca.setValue('CONCLUIDA');
            }
            
            txtCdhu_edad.setValue(calcularEdad( Date.parse(truncDate(inRecordCgg_dhu_beca.get('CRPER_FECHA_NACIMIENTO'))).format('Y-m-d')));
            
            txtCrpjr_codigo.setValue(inRecordCgg_dhu_beca.get('CRPJR_CODIGO'));
            txtCrpjr_nombre.setValue(inRecordCgg_dhu_beca.get('CRPJR_NOMBRE'));
            txtCgesp_nombre.setValue(inRecordCgg_dhu_beca.get('CGESP_NOMBRE'));
            txtCgied_institucion_educativa.setValue(inRecordCgg_dhu_beca.get('CGIED_NOMBRE'));
            txtCgtpr_nombre_titulo.setValue(inRecordCgg_dhu_beca.get('CGTPR_NOMBRE'));
            txtCdbec_numero_aprobacion_modificatorio.setValue(inRecordCgg_dhu_beca.get('CDBEC_NUMERO_APROBACION_MODIFICATORIO'));
            txtCdbec_numero_contrato_modificatorio.setValue(inRecordCgg_dhu_beca.get('CDBEC_NUMERO_CONTRATO_MODIFICATORIO'));
            txtCdbec_observacion_contrato_modificatorio.setValue(inRecordCgg_dhu_beca.get('CDBEC_OBSRERVACION_CONTRATO_MODIFICATORIO'));
            gsPersonabecaRepresentante.reload({
                params:{
                    inCdbec_codigo:txtCdbec_codigo.getValue(),
                    format:TypeFormat.JSON
                }});
            gsCgg_gem_perfil_prof_beca.reload({
                params:{
                    inCrper_codigo:txtCrper_codigo.getValue(),
                    format:TypeFormat.JSON
                }
            });
            gsCgg_dhu_adjunto.reload({
                params:{
                    inCdbec_codigo:txtCdbec_codigo.getValue(),
                    format:TypeFormat.JSON
                }
            });

            isEdit = true;            
            txtCrper_numero_documento.setVisible(false);
            btnCrper_codigoCgg_dhu_beca.setVisible(false);
            cbxTipoAprobacionBeca.setVisible(true);
            chkCdbec_beca_devengada.setVisible(true);
            chkCdbec_titulo_entregado.setVisible(true);
            cbxTipoAprobacionBeca.hiddenValue = inRecordCgg_dhu_beca.get('CDBEC_ESTADO_APROBACION');            
        }}

    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_dhu_beca.
     * @returns ventana winFrmCgg_dhu_beca.
     * @base FrmCgg_dhu_beca.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_dhu_beca;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_dhu_beca.
     * @base FrmCgg_dhu_beca.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_dhu_becaCtrls();
    }
    /**
     * Funcion miembro que develve el tipo de documento.
     */
}

/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_dhu_beca desde una instancia.
 */
FrmCgg_dhu_beca.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_dhu_beca desde una instancia.
 */
FrmCgg_dhu_beca.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_dhu_beca,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_dhu_beca.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_dhu_beca desde una instancia.
 */
FrmCgg_dhu_beca.prototype.loadData = function(){
    this.loadData();
}
