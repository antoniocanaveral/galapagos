/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_dhu_asistente_curso.
 * @param {String} INSENTENCIA_CGG_DHU_ASISTENTE_CURSO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_DHU_ASISTENTE_CURSO Registro de datos de la tabla Cgg_dhu_asistente_curso.
 * @constructor
 * @base FrmListadoCgg_dhu_asistente_curso
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_dhu_asistente_curso(INSENTENCIA_CGG_DHU_ASISTENTE_CURSO,INRECORD_CGG_DHU_ASISTENTE_CURSO){
    var inSentenciaCgg_dhu_asistente_curso = INSENTENCIA_CGG_DHU_ASISTENTE_CURSO;
    var inRecordCgg_dhu_asistente_curso=INRECORD_CGG_DHU_ASISTENTE_CURSO;
    var urlCgg_dhu_asistente_curso=URL_WS+"Cgg_dhu_asistente_curso";
    var tituloCgg_dhu_asistente_curso='Asistente curso';
    var descCgg_dhu_asistente_curso='El formulario permite administrar informaci\u00f3n de los asistentes al curso';
    var isEdit = false;
    var tmpInformacionAsistenteCurso;
    var tmpNumeroAsistente;
    var tmpEdad;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO ASISTENTES
     */
    var txtCdasc_codigo = new Ext.form.TextField({
        id:'txtCdasc_codigo',
        name:'txtCdasc_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });

    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
     */
    var txtCrper_codigo = new Ext.form.TextField({
        id:'txtCrper_codigo',
        name:'txtCrper_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
     */
    var txtCrper_codigo_residencia = new Ext.form.TextField({
        id:'txtCrper_codigo_residenciao',
        name:'txtCrper_codigo_residencia',
        fieldLabel :'Codigo residencia',
        anchor:'98%',
        readOnly:'true',
        maxLength :20
    });
    /**
     * Ext.form.TextField NUMERO DE DOCUMENTO DE PERSONA
     */
    var txtCrper_num_doc_identific = new Ext.form.TextField({
        id:'txtCrper_num_doc_identific',
        name:'txtCrper_num_doc_identific',
        fieldLabel :'No.Documento',
        allowBlank :false,
        anchor:'98%',
        listeners: {
            specialkey: function(field, e) {
                // e.HOME, e.END, e.PAGE_UP, e.PAGE_DOWN,
                // e.TAB, e.ESC, arrow keys: e.LEFT, e.RIGHT, e.UP, e.DOWN
                if (e.getKey() == e.ENTER) {
                    try {
                        function CallBackCgg_persona(r) {
                            tmpInformacionAsistenteCurso = Ext.util.JSON.decode(r)[0];
                            if (tmpInformacionAsistenteCurso) {
                                txtCrper_codigo.setValue(tmpInformacionAsistenteCurso.CRPER_CODIGO);
                                txtCrper_num_doc_identific.setValue(tmpInformacionAsistenteCurso.CRPER_NUM_DOC_IDENTIFIC);
                                tmpEdad=(calcularEdad( Date.parse(truncDate(tmpInformacionAsistenteCurso.CRPER_FECHA_NACIMIENTO)).format('Y-m-d')));
                                tmpInformacionAsistenteCurso.EDAD=tmpEdad;
                                txtCrper_codigo_residencia.setValue(tmpInformacionAsistenteCurso.CODIGO);
                                if(txtCrper_codigo_residencia.getValue()=='04'&& txtCdcur_tipo_residente.getValue()!=TypeCursoAsistente.PERMANENTE_TEMPORAL){

                                    Ext.Msg.show({
                                        title:tituloCgg_dhu_asistente_curso,
                                        msg: 'El asistente seleccionado es residente temporal no puede inscribirse.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    txtCdasc_actividad_realizada.disable();
                                    txtCsctp_nombre.disable();
                                    btnCsctp_codigoCgg_dhu_asistente_curso.disable();
                                }else{
                                    txtCdasc_actividad_realizada.enable();
                                    txtCsctp_nombre.enable();
                                    btnCsctp_codigoCgg_dhu_asistente_curso.enable();
                                }
                                tmpInfoAsistente.overwrite(Ext.getCmp('pnlAsistenteCurso').body,tmpInformacionAsistenteCurso);
                            }else {

                                Ext.Msg.show({
                                    title:tituloCgg_dhu_asistente_curso,
                                    msg: 'No existe el registro solicitado.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO});


                            }

                        }

                        var param = new SOAPClientParameters();
                        param.add('inCrper_num_doc_identific', txtCrper_num_doc_identific.getValue());
                        param.add('format', TypeFormat.JSON);
                        SOAPClient.invoke(URL_WS + "Cgg_dhu_asistente_curso", "selectAsistenteResidente", param, true, CallBackCgg_persona);
                    } catch(inErr) {
                        //winFrmCgg_institucion_educativa.getEl().unmask();
                    }

                }
            }
        }
    });
    /**
     * CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
     */
    var btnCrper_codigoCgg_dhu_asistente_curso = new Ext.Button({
        id:'btnCrper_codigoCgg_dhu_asistente_curso',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_res_persona = new PersonaAsistenteCurso();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona.getStore(),tmpFLCgg_res_persona.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        txtCrper_codigo.setValue(tmpRecord.get('CRPER_CODIGO'));
                        txtCrper_num_doc_identific.setValue(tmpRecord.get('CRPER_NUM_DOC_IDENTIFIC'));
                        txtCrper_codigo_residencia.setValue(tmpRecord.get('CODIGO'));
                        if(txtCrper_codigo_residencia.getValue()=='04'&& txtCdcur_tipo_residente.getValue()!=TypeCursoAsistente.PERMANENTE_TEMPORAL){

                            Ext.Msg.show({
                                title:tituloCgg_dhu_asistente_curso,
                                msg: 'El asistente seleccionado es residente temporal no puede inscribirse.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            txtCdasc_actividad_realizada.disable();
                            txtCsctp_nombre.disable();
                            btnCsctp_codigoCgg_dhu_asistente_curso.disable();
                        }else{
                            txtCdasc_actividad_realizada.enable();
                            txtCsctp_nombre.enable();
                            btnCsctp_codigoCgg_dhu_asistente_curso.enable();
                        }
                        tmpEdad=(calcularEdad( Date.parse(truncDate(tmpRecord.get('CRPER_FECHA_NACIMIENTO'))).format('Y-m-d')));
                        tmpRecord.EDAD=tmpEdad;
                        tmpInfoAsistente.overwrite(Ext.getCmp('pnlAsistenteCurso').body, tmpRecord.json);
                    }

                });
                objBusqueda.show();
            }}
    });
    var datosPersona = {
        CRPER_NUMERO_RESIDENCIA:'0',
        CRPER_NOMBRES:'0',
        CRPER_APELLIDO_PATERNO:'0',
        CRPER_NUM_DOC_IDENTIFIC:'0',
        CRPER_LUGAR_NACIMIENTO:'0',
        EDAD:'0',
        CGNCN_NOMBRE:'0'
    };
    /*template de la consulta de persona historial*/
    var tmpInfoAsistente;
    tmpInfoAsistente = new Ext.XTemplate(
            '<table width="100%" height="100%" cellpadding="0">' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Nombres:</font></div></td>' +
                    '<td><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{CRPER_NOMBRES}</span></td></td>' +
                    '<td><div class="tituloTemplate"<font  face="Arial, Helvetica, sans-serif">Apellidos:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CRPER_APELLIDO_PATERNO} {CRPER_APELLIDO_MATERNO}</font></td></td>' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><span style="font-family: Arial, Helvetica, sans-serif; ">Documento:</span></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CRDID_TIPO}</font></td></td>' +
                    '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">No.doc_identific:</font></div></td>' +
                    '<td><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{CRPER_NUM_DOC_IDENTIFIC}</span></td></td>' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Nacionalidad:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CGNCN_NOMBRE}</font></td></td>' +
                    '<td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Lugar nac:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CRPER_LUGAR_NACIMIENTO}</font></td></tr>' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">F.nacimiento:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{[this.myDate(values.CRPER_FECHA_NACIMIENTO)]}</font></td></td>' +
                    '<td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Edad:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{EDAD}</font></td></td>' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Tipo residencia:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{TIPO_RESIDENCIA}</font></td></td>' +
                    '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Auspiciante:</font></div></td>' +
                    '<td><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{CRPER_AUSPICIANTE}</span></td></td>' +
                    '</table>',
    {
        // XTemplate configuration:
        compiled: true,
        disableFormats: true,
        myDate: function(CRPER_FECHA_NACIMIENTO) {
            return truncDate(CRPER_FECHA_NACIMIENTO);
        }
    }

            );

    /*template de la consulta de persona historial*/
    var tmpInfoAsistenteEdit;
    tmpInfoAsistenteEdit = new Ext.XTemplate(
            '<table width="100%" height="100%" cellpadding="0">' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Nombres:</font></div></td>' +
                    '<td><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{CRPER_NOMBRES}</span></td></td>' +
                    '<td><div class="tituloTemplate"<font  face="Arial, Helvetica, sans-serif">Apellidos:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CRPER_APELLIDO_PATERNO} {CRPER_APELLIDO_MATERNO}</font></td></td>' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><span style="font-family: Arial, Helvetica, sans-serif; ">Documento:</span></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CRDID_TIPO}</font></td></td>' +
                    '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">No.doc_identific:</font></div></td>' +
                    '<td><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{CRPER_NUM_DOC_IDENTIFIC}</span></td></td>' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Lugar nac:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CRPER_LUGAR_NACIMIENTO}</font></td></td>' +
                    '<td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">F.nacimiento:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{[this.myDate(values.CRPER_FECHA_NACIMIENTO)]}</font></td></tr>' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Nacionalidad:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CGNCN_NOMBRE}</font></td></td>' +
                    '<td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Lugar origen:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CCNT_NOMBRE_ORIGEN}</font></td></td>' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Tipo residencia:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{TIPO_RESIDENCIA}</font></td></td>' +
                    '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Auspiciante:</font></div></td>' +
                    '<td><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{CRPER_AUSPICIANTE}</span></td></td>' +
                    '</table>',
    {
        // XTemplate configuration:
        compiled: true,
        disableFormats: true,
        myDate: function(CRPER_FECHA_NACIMIENTO) {
            return truncDate(CRPER_FECHA_NACIMIENTO);
        }
    }
            );

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CURSO
     */
    var txtCdcur_codigo = new Ext.form.TextField({
        id:'txtCdcur_codigo',
        name:'txtCdcur_codigo',
        fieldLabel :'Codigo',
        anchor:'98%'
    });
    /**
     * Ext.form.TextField DESCRIPCION DE REGISTRO DE CURSO
     */
    var txtCdcur_descripcion = new Ext.form.TextField({
        id:'txtCdcur_descripcion',
        name:'txtCdcur_descripcion',
        fieldLabel :'Curso',
        allowBlank :false,
        readOnly:'true',
        anchor:'98%'
    });
    /**
     * Ext.form.TextField DESCRIPCION DE REGISTRO DE CURSO para la consulta
     */
    var txtCdcur_descripcion_consu = new Ext.form.TextField({
        id:'txtCdcur_descripcion_consu',
        name:'txtCdcur_descripcion_consu',
        fieldLabel :'Curso',
        anchor:'98%'
    });
    /**
     * Ext.form.TextField NUMERO DE ASISTENTES
     */
    var txtCdcur_numero_asistente = new Ext.form.TextField({
        id:'txtCdcur_numero_asistente',
        name:'txtCdcur_numero_asistente',
        fieldLabel :'No. Asistente',
        anchor:'98%'
    });
    /**
     * Ext.form.TextField NUMERO DE ASISTENTES INSCRITOS
     */
    var txtCdcur_numero_inscrito= new Ext.form.TextField({
        id:'txtCdcur_numero_inscrito',
        name:'txtCdcur_numero_inscrito',
        fieldLabel :'No. Inscrito',
        anchor:'98%'
    });
    /**
     * Ext.form.TextField NUMERO DE ASISTENTES INSCRITOS
     */
    var txtCdcur_tipo_residente= new Ext.form.TextField({
        id:'txtCdcur_tipo_residente',
        name:'txtCdcur_tipo_residente',
        fieldLabel :'Tipo residente',
        anchor:'98%'
    });
    /**
     * Ext.form.TextField NUMERO DE ASISTENTES INSCRITOS
     */
    var txtCdcur_estado_curso= new Ext.form.TextField({
        id:'txtCdcur_estado_curso',
        name:'txtCdcur_estado_curso',
        fieldLabel :'Estado curso',
        anchor:'98%'
    });
	
    var cbxTipoCurso= new Ext.form.ComboBox({
        id:'cbxTipoCurso',
        name:'cbxTipoCurso',
        displayField: "CDTCR_NOMBRE",
        fieldLabel :'Tipo curso',
        valueField: 'CDTCR_CODIGO',
        mode:'local',
        typeAhead:true,
        autoSelect:true,
        hiddenId:'cbxTipoCursoH',
        hiddenName:'cbxTipoCursoH',
        hiddenValue:'id',
        forceSelection:true,
        editable: true,
        triggerAction:'all',
        submitValue:true,
        anchor:'98%',
        emptyText : 'Seleccione una opci\u00f3n..',
		allowBlank :false

    });
    function Curso(){

        /**
         * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_curso.
         */
        this.cmCurso = new Ext.grid.ColumnModel([

            {dataIndex:'CDCUR_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
            {dataIndex:'CDTCR_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
            {dataIndex:'CDTCR_NOMBRE',header:'Tipo curso',width:150,sortable:true,hidden:true},
            {dataIndex:'CCTN_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
            {dataIndex:'CDCUR_DESCRIPCION',header:'Curso',width:150,sortable:true},
            {dataIndex:'CCTN_NOMBRE',header:'Cant\u00f3n',width:150,sortable:true},
            {dataIndex:'CSCTP_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
            {dataIndex:'CSCTP_NOMBRE',header:'Sector productivo',width:150,sortable:true},
            {dataIndex:'CISLA_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
            {dataIndex:'CISLA_NOMBRE',header:'Isla',width:150,sortable:true,hidden:true},
            {dataIndex:'CDITR_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
            {dataIndex:'CDITR_NOMBRE',header:'Instituci\u00f3n',width:150,sortable:true},
            {dataIndex:'CRPER_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
            {dataIndex:'CRPER_INSTRUCTOR',header:'Cordinador',width:150,sortable:true},
            {dataIndex:'CDCUR_FECHA_PREVISTA_INICIO',header:'Fecha prevista inicio',width:150,sortable:true,renderer:truncDate,hidden:true},
            {dataIndex:'CDCUR_FECHA_INICIO',header:'Fecha inicio',width:150,sortable:true,renderer:truncDate,hidden:true},
            {dataIndex:'CDCUR_FECHA_CULMINACION',header:'Fecha culminaci\u00f3n',width:150,sortable:true,renderer:truncDate,hidden:true},
            {dataIndex:'CDCUR_FECHA_PREVISTA_CULMINACION',header:'Fecha prevista culminaci\u00f3n',width:150,sortable:true,renderer:truncDate,hidden:true}]);
        /**
         * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_curso por un campo especifico.
         */
        this.gsCurso = new Ext.data.Store({
            proxy:new Ext.ux.bsx.SoapProxy({
                url:URL_WS+"Cgg_dhu_curso",
                method:"selectCursoInscripcion",
                pagin:true
            }),
            remoteSort:true,
            reader:new Ext.data.JsonReader({
                id:'CDCUR_CODIGO',
                root:'dataSet',
                totalProperty: 'totalCount'
            },[
                {name:'CDCUR_CODIGO'},
                {name:'CDTCR_CODIGO'},
                {name:'CDTCR_NOMBRE'},
                {name:'CDTCR_TIPO_RESIDENTE'},
                {name:'CCTN_CODIGO'},
                {name:'CCTN_NOMBRE'},
                {name:'CSCTP_CODIGO'},
                {name:'CSCTP_NOMBRE'},
                {name:'CDITR_CODIGO'},
                {name:'CDITR_NOMBRE'},
                {name:'CRPER_CODIGO'},
                {name:'CRPER_INSTRUCTOR'},
                {name:'CDCUR_DESCRIPCION'},
                {name:'CDCUR_FECHA_PREVISTA_INICIO'},
                {name:'CDCUR_FECHA_INICIO'},
                {name:'CDCUR_FECHA_CULMINACION'},
                {name:'CDCUR_FECHA_PREVISTA_CULMINACION'},
                {name:'CDCUR_NUMERO_ASISTENTE'},
                {name:'CDCUR_ESTADO_CURSO'}
            ]),
            sortInfo:{field: 'CDTCR_NOMBRE', direction: 'ASC'},
            baseParams:{keyword:"",format:'JSON',inCdtcr_codigo: cbxTipoCurso.getValue()}
        });

    };

    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE CURSO
     */
    var btnCdcur_codigoCgg_dhu_asistente_curso = new Ext.Button({
        id:'btnCdcur_codigoCgg_dhu_asistente_curso',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
				if(cbxTipoCurso.getValue()){
					var tmpFLCgg_dhu_curso = new Curso();
					tmpFLCgg_dhu_curso.gsCurso.baseParams.inCdtcr_codigo=cbxTipoCurso.getValue();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_dhu_curso.gsCurso,tmpFLCgg_dhu_curso.cmCurso);
					objBusqueda.closeHandler(function(){
						var tmpRecord = objBusqueda.getSelectedRow();
						if(tmpRecord){
							txtCdcur_codigo.setValue(tmpRecord.get('CDCUR_CODIGO'));
							txtCdcur_descripcion.setValue(tmpRecord.get('CDCUR_DESCRIPCION'));
							txtCdcur_numero_asistente.setValue(tmpRecord.get('CDCUR_NUMERO_ASISTENTE'));
							txtCdcur_tipo_residente.setValue(tmpRecord.get('CDTCR_TIPO_RESIDENTE'));
							txtCdcur_estado_curso.setValue(tmpRecord.get('CDCUR_ESTADO_CURSO'));
							if(txtCdcur_estado_curso.getValue()==TypeEstadoCurso.REGISTRADO ){
								Ext.Msg.show({
									title:tituloCgg_dhu_asistente_curso,
									msg: 'El curso aun no esta en proceso de inscripci\u00f3n',
									buttons: Ext.Msg.OK,
									icon: Ext.MessageBox.INFO
								});
								btnGuardarCgg_dhu_asistente_curso.disable();
							}else {
								if(txtCdcur_estado_curso.getValue()==TypeEstadoCurso.PROCESO_INSCRIPCION ){
									NumeroAsistente();
									btnGuardarCgg_dhu_asistente_curso.enable();
								}
							}
						}

					});
					objBusqueda.show();
				}else{
					Ext.Msg.show({
						title:tituloCgg_dhu_asistente_curso,
						msg: 'Seleccione primero un tipo de curso',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.INFO
					});
				}
            }
		}
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO SECTOR PRODUCTIVO
     */
    var txtCsctp_codigo = new Ext.form.TextField({
        id:'txtCsctp_codigo',
        name:'txtCsctp_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO SECTOR PRODUCTIVO
     */
    var txtCsctp_nombre= new Ext.form.TextField({
        id:'txtCsctp_nombre',
        name:'txtCsctp_nombre',
        fieldLabel :'Sec.Productivo o social',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO SECTOR PRODUCTIVO
     */
    var btnCsctp_codigoCgg_dhu_asistente_curso = new Ext.Button({
        id:'btnCsctp_codigoCgg_dhu_asistente_curso',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_sector_productivo = new FrmListadoCgg_sector_productivo();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_sector_productivo.getStore(),tmpFLCgg_sector_productivo.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        txtCsctp_codigo.setValue(tmpRecord.get('CSCTP_CODIGO'));
						txtCsctp_nombre.setValue(tmpRecord.get('CSCTP_NOMBRE'));
					}
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCusu_codigo = new Ext.form.TextField({
        id:'txtCusu_codigo',
        name:'txtCusu_codigo',
        fieldLabel :'Codigo',
        anchor:'98%'
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO
     */
    var btnCusu_codigoCgg_dhu_asistente_curso = new Ext.Button({
        id:'btnCusu_codigoCgg_dhu_asistente_curso',
        text:'Cusu_codigo',
        iconCls:'iconCusu_codigo',
        listeners:{
            click:function(){
                var tmpFLCgg_usuario = new FrmListadoCgg_usuario();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_usuario.getStore(),tmpFLCgg_usuario.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                        txtCusu_codigo.setValue(tmpRecord.get('CUSU_CODIGO'));
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField ACTIVIDAD QUE SE HALLA REALIZANDO ACTUALMENTE
     */
    var txtCdasc_actividad_realizada = new Ext.form.TextField({
        id:'txtCdasc_actividad_realizada',
        name:'txtCdasc_actividad_realizada',
        fieldLabel :'Actividad realiza',
        anchor:'98%'
    });
    /**
     * Ext.form.NumberField NOTA FINAL DEL CURSO RECIBIDO
     */
    var numCdasc_nota_final = new Ext.form.SpinnerField({
        id:'numCdasc_nota_final',name:'numCdasc_nota_final',fieldLabel :'Nota final',allowBlank :false,disabled :false});
    /**
     * Ext.form.TextField NUMERO DE CERTIFICADO
     */
    var txtCdasc_numero_certificado = new Ext.form.TextField({
        id:'txtCdasc_numero_certificado',
        name:'txtCdasc_numero_certificado',
        fieldLabel :'No.certificado',
        anchor:'98%'
    });
    /**
     * Ext.form.DateField CAMPO QUE REGISTRA LA EMISION DEL CERTIFICADO DEL CURSO
     */
    var dtCdasc_fecha_emision_certificado = new Ext.form.DateField({
        id:'dtCdasc_fecha_emision_certificado',
        name:'dtCdasc_fecha_emision_certificado',
        fieldLabel :'F. emisi\u00f3n certificado',
        value:new Date()
    });
    /**
     * Ext.form.NumberField ESTADO QUE IDENTIFICA LA INSCRIPCION AL CURSO
     0 - PRE INSCRITO
     1 - INSCRITO


     */
    var cbxEstadoInscripcion = new Ext.form.ComboBox({
        id:'cbxEstadoInscripcion',
        name:'cbxEstadoInscripcion',
        store: dsEstadoInscrito,
        anchor:'98%',
        displayField: 'Estado_inscripcion',
        fieldLabel :'Estado insripci\u00f3n',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        editable: false,
        triggerAction:'all',
        emptyText : 'Seleccione',
        valueField:'id_estado_inscripcion'

    });
    //cbxEstadoInscripcion.setVisible(false);
    /**
     * Ext.form.NumberField ESTADO QUE DETERMINA SI LA PERSONA APROBO EL CURSO
     0 - REPROBADO
     1 - APROBADO
     2 - RETIRADO
     */
    var cbxTipoAprobadoCurso = new Ext.form.ComboBox({
        id:'cbxTipoAprobadoCurso',
        name:'cbxTipoAprobadoCurso',
        store:dsEstadoCursoAsistente ,
        anchor:'98%',
        displayField: 'Curso_Aprobado',
        fieldLabel :'Estado curso',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        editable: false,
        triggerAction:'all',
        emptyText : 'Seleccione',
        valueField:'id_aprobado_curso'

    });

    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_dhu_asistente_curso
     */
    var btnGuardarCgg_dhu_asistente_curso = new Ext.Button({
        id:'btnGuardarCgg_dhu_asistente_curso',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_dhu_asistente_curso.getForm().isValid()==false){
                    return;
                }
                var tmpNota_final=null;
                if (numCdasc_nota_final.getValue()!=null && numCdasc_nota_final.getValue()!=undefined) {
                    tmpNota_final=null;
                }else {
                    tmpNota_final = numCdasc_nota_final.getValue();

                }
                var tmpAprobado=null;
                if (cbxTipoAprobadoCurso.getValue()!=null && cbxTipoAprobadoCurso.getValue()!=undefined) {
                    tmpNota_final=null;
                }else {
                    tmpNota_final = cbxTipoAprobadoCurso.getValue();

                }
                try{
                    function CallBackCgg_dhu_asistente_curso(r){
                        winFrmCgg_dhu_asistente_curso.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_dhu_asistente_curso,
                                msg: 'La informaci\u00f3n de  asistente curso ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_dhu_asistente_curso.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_dhu_asistente_curso,
                                msg: 'La informaci\u00f3n de  asistente curso no ha podido ser almacenada.'+(r.result.msg?r.result.msg:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_dhu_asistente_curso.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCdasc_codigo',txtCdasc_codigo.getValue());
                    param.add('inCrper_codigo',txtCrper_codigo.getValue());
                    param.add('inCdcur_codigo',txtCdcur_codigo.getValue());
                    param.add('inCsctp_codigo',txtCsctp_codigo.getValue());
                    param.add('inCusu_codigo',null);
                    param.add('inCdasc_actividad_realizada',txtCdasc_actividad_realizada.getValue());
                    param.add('inCdasc_nota_final',tmpNota_final);
                    param.add('inCdasc_numero_certificado',null);
                    param.add('inCdasc_fecha_emision_certificado',null);
                    param.add('inCdasc_estado_inscripcion',1);
                    param.add('inCdasc_aprobado',3);
                    SOAPClient.invoke(urlCgg_dhu_asistente_curso,INSENTENCIA_CGG_DHU_ASISTENTE_CURSO,param, true, CallBackCgg_dhu_asistente_curso);
                }catch(inErr){
                    winFrmCgg_dhu_asistente_curso.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_dhu_asistente_curso.
     */
    var btnCancelarCgg_dhu_asistente_curso = new Ext.Button({
        id:'btnCancelarCgg_dhu_asistente_curso',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_dhu_asistente_curso.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_dhu_asistente_curso.
     */
    var btnCerrarCgg_dhu_asistente_curso = new Ext.Button({
        id:'btnCerrarCgg_dhu_asistente_curso',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_dhu_asistente_curso.close();
            }}
    });

    /**
     * Ext.form.FormPanel Panel principal que contiene los  datos persona.
     */
    var pnlPersonaAsistente = new Ext.form.FieldSet({
        id:'pnlPersonaAsistente',
        title:'Datos personales',
        collapsible:true,
        // height:137,
        layout:'form',
        //region:'north',
        items:[
            {xtype:'panel', id :'pnlAsistenteCurso',data:datosPersona,tpl:tmpInfoAsistente} ]
    });

    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_dhu_asistente_curso.
     */
    var pnlCgg_dhu_asistente= new Ext.Panel({
        frame:true,
        labelWidth :130,
        layout:'form',
        items:[{xtype:'panel',layout:'column',items:[
            {columnWidth:.50,layout:'form',items:[cbxTipoCurso]},
            {columnWidth:.45,layout:'form', labelWidth :60,items:[txtCdcur_descripcion]},
            {columnWidth:.05,layout:'form',items:[btnCdcur_codigoCgg_dhu_asistente_curso]}
        ]},{xtype:'panel',layout:'column',items:[
            {columnWidth:.95,layout:'form',items:[txtCrper_num_doc_identific]},
            {columnWidth:.05,layout:'form',items:[btnCrper_codigoCgg_dhu_asistente_curso]}
        ]}, pnlPersonaAsistente,
            {xtype:'panel',layout:'column',items:[{columnWidth:.95,layout:'form',items:[txtCsctp_nombre]},
                {columnWidth:.05,layout:'form',items:[btnCsctp_codigoCgg_dhu_asistente_curso]}]},
            txtCdasc_actividad_realizada

        ]

    });

    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_dhu_asistente_curso.
     */
    var pnlCgg_dhu_asistente_curso= new Ext.form.FormPanel({
        frame:true,
        labelWidth :120,
        items:[pnlCgg_dhu_asistente]

    });
    function NumeroAsistente(){
        function CallBackCgg_dhu_numero_asistente(r){

            txtCdcur_numero_inscrito.setValue(r);
            tmpNumeroAsistente=Math.round(((txtCdcur_numero_asistente.getValue())-(txtCdcur_numero_inscrito.getValue())));
            if(tmpNumeroAsistente>0){
                Ext.Msg.show({
                    title:tituloCgg_dhu_asistente_curso,
                    msg: 'El cupo disponible para inscribir es de'+ tmpNumeroAsistente,
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.INFO
                });
            }else{
                Ext.Msg.show({
                    title:tituloCgg_dhu_asistente_curso,
                    msg: 'Ya no exite cupo de inscripci\u00f3n disponible',
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.INFO
                });
            }
        }
        var param = new SOAPClientParameters();
        param.add('in_Cdcur_codigo',txtCdcur_codigo.getValue());
        SOAPClient.invoke(URL_WS+"Cgg_dhu_curso","numeroInscrito",param, true,CallBackCgg_dhu_numero_asistente);

    }

    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_dhu_asistente_curso.
     */
    var winFrmCgg_dhu_asistente_curso = new Ext.Window({
        id:'winFrmCgg_dhu_asistente_curso',
        title:tituloCgg_dhu_asistente_curso,
        tbar:getPanelTitulo(tituloCgg_dhu_asistente_curso,descCgg_dhu_asistente_curso),
        items:[pnlCgg_dhu_asistente_curso],
        width:600,
        minWidth:600,
        modal:true,
        constrain:true,
        bbar:[btnGuardarCgg_dhu_asistente_curso,btnCancelarCgg_dhu_asistente_curso,'->',btnCerrarCgg_dhu_asistente_curso],
        listeners:{
            show:function(){
                if(isEdit){
                    if(INRECORD_CGG_DHU_ASISTENTE_CURSO)
                    {
                        txtCrper_num_doc_identific.setVisible(false);
                        btnCrper_codigoCgg_dhu_asistente_curso.setVisible(false);
                        tmpInfoAsistenteEdit.overwrite( Ext.getCmp('pnlAsistenteCurso').body,inRecordCgg_dhu_asistente_curso.json)

                    }
                    else
                    {
                        alert('No se puede mostrar la informaci\u00f3n');
                    }
                }
            }
        }
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_dhu_asistente_curso.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_dhu_asistente_cursoCtrls(inEstado){
        estado=!inEstado;
        txtCdasc_codigo.setDisabled(estado);
        txtCrper_codigo.setDisabled(estado);
        txtCdcur_codigo.setDisabled(estado);
        txtCsctp_codigo.setDisabled(estado);
        txtCusu_codigo.setDisabled(estado);
        txtCdasc_actividad_realizada.setDisabled(estado);
        numCdasc_nota_final.setDisabled(estado);
        txtCdasc_numero_certificado.setDisabled(estado);
        dtCdasc_fecha_emision_certificado.setDisabled(estado);
        cbxEstadoInscripcion.setDisabled(estado);
        cbxTipoAprobadoCurso.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_dhu_asistente_curso.
     */
    function cargarCgg_dhu_asistente_cursoCtrls(){
        if(inRecordCgg_dhu_asistente_curso){
            txtCdasc_codigo.setValue(inRecordCgg_dhu_asistente_curso.get('CDASC_CODIGO'));
            txtCrper_codigo.setValue(inRecordCgg_dhu_asistente_curso.get('CRPER_CODIGO'));
            txtCdcur_codigo.setValue(inRecordCgg_dhu_asistente_curso.get('CDCUR_CODIGO'));
            txtCdcur_descripcion.setValue(inRecordCgg_dhu_asistente_curso.get('CDCUR_DESCRIPCION'));
            txtCsctp_codigo.setValue(inRecordCgg_dhu_asistente_curso.get('CSCTP_CODIGO'));
            txtCsctp_nombre.setValue(inRecordCgg_dhu_asistente_curso.get('CSCTP_NOMBRE'));
            txtCusu_codigo.setValue(inRecordCgg_dhu_asistente_curso.get('CUSU_CODIGO'));
            txtCdasc_actividad_realizada.setValue(inRecordCgg_dhu_asistente_curso.get('CDASC_ACTIVIDAD_REALIZADA'));
            numCdasc_nota_final.setValue(inRecordCgg_dhu_asistente_curso.get('CDASC_NOTA_FINAL'));
            txtCdasc_numero_certificado.setValue(inRecordCgg_dhu_asistente_curso.get('CDASC_NUMERO_CERTIFICADO'));
            dtCdasc_fecha_emision_certificado.setValue(truncDate(inRecordCgg_dhu_asistente_curso.get('CDASC_FECHA_EMISION_CERTIFICADO')));
            cbxEstadoInscripcion.setValue(inRecordCgg_dhu_asistente_curso.get('CDASC_ESTADO_INSCRIPCION'));
            cbxTipoAprobadoCurso.setValue(inRecordCgg_dhu_asistente_curso.get('CDASC_APROBADO'));
            // cbxEstadoInscripcion.setVisible(true);
            //cbxTipoAprobadoCurso.setVisible(true);
            isEdit = true;
			//alert(inRecordCgg_dhu_asistente_curso.get('CDTCR_CODIGO'));
			cbxTipoCurso.setValue(inRecordCgg_dhu_asistente_curso.get('CDTCR_CODIGO'));
            habilitarCgg_dhu_asistente_cursoCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_dhu_asistente_curso.
     * @returns ventana winFrmCgg_dhu_asistente_curso.
     * @base FrmCgg_dhu_asistente_curso.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_dhu_asistente_curso;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_dhu_asistente_curso.
     * @base FrmCgg_dhu_asistente_curso.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_dhu_asistente_cursoCtrls();
    }
	
	this.setStoreTipoCurso = function(inStoreTipoCurso){
		cbxTipoCurso.store = inStoreTipoCurso;
	}
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_dhu_asistente_curso desde una instancia.
 */
FrmCgg_dhu_asistente_curso.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_dhu_asistente_curso desde una instancia.
 */
FrmCgg_dhu_asistente_curso.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_dhu_asistente_curso,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_dhu_asistente_curso.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_dhu_asistente_curso desde una instancia.
 */
FrmCgg_dhu_asistente_curso.prototype.loadData = function(){
    this.loadData();
}

FrmCgg_dhu_asistente_curso.prototype.setStoreTipoCurso = function(inStoreTipoCurso){
    this.setStoreTipoCurso(inStoreTipoCurso);
}
