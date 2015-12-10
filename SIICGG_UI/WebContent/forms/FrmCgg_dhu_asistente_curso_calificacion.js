
function FrmCgg_dhu_asistente_curso_calificacion(INSENTENCIA_CGG_DHU_ASISTENTE_CURSO_CALIFICACION,INRECORD_CGG_DHU_ASISTENTE_CURSO_CALIFICACION){
    var inSentenciaCgg_dhu_asistente_curso_calificacion = INSENTENCIA_CGG_DHU_ASISTENTE_CURSO_CALIFICACION;
    var inRecordCgg_dhu_asistente_curso_calificacion=INRECORD_CGG_DHU_ASISTENTE_CURSO_CALIFICACION;
    var urlCgg_dhu_asistente_curso_calificacion=URL_WS+"Cgg_dhu_asistente_curso";
    var tituloCgg_dhu_asistente_curso_calificacion='Asistente curso';
    var descCgg_dhu_asistente_curso_calificacion='El formulario permite administrar informaci\u00f3n del registro de inscripciones y calificaciones de los asistentes';
    var isEdit = false;
    var tmpInformacionAsistenteCurso;
    var tmpEstadoCurso;
    var tmpnumerominimo;
	var swEstadoInscripcion = false;
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

    var datosCurso = {
        CCTN_NOMBRE:'0',
        CDCUR_INSTITUCION:'0',
        CRPER_INSTRUCTOR:'0',
        CDCUR_FECHA_INICIO:'0',
        CDCUR_FECHA_PREVISTA_CULMINACION:'0',
        CDCUR_FECHA_CULMINACION:'0'
    };
    /*template de la consulta de los curso*/
    var tmpInfoCurso;
    tmpInfoCurso = new Ext.XTemplate(
            '<table width="100%" height="100%" cellpadding="0">' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Cant&oacute;n:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CCTN_NOMBRE}</font></td>' +
                    '<td><div class="tituloTemplate"<font  face="Arial, Helvetica, sans-serif">Sec.productivo o social:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CSCTP_NOMBRE}</font></td></td>' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><span style="font-family: Arial, Helvetica, sans-serif; ">Instituci&oacute;n:</span></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CDITR_NOMBRE}</font></td></td>' +
                    '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Cordinador:</font></div></td>' +
                    '<td><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{CRPER_INSTRUCTOR}</span></td></td>' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Cupo m&aacute;ximo:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CDCUR_NUMERO_ASISTENTE}</font></td></td>' +
                    '<td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Cupo disponible:</font></div></td>' +
                    '<td><font color="green" size="1" face="Arial, Helvetica, sans-serif">{NUMERO_DISPONIBLE}</font></td></tr>' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Fec.prevista inicio:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{[this.myDate(values.CDCUR_FECHA_PREVISTA_INICIO)]}</font></td></td>' +
                    '<td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Fec.prevista culminaci&oacute;n:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{[this.myDate(values.CDCUR_FECHA_PREVISTA_CULMINACION)]}</font></td></tr>' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Fecha inicio:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{[this.myDate(values.CDCUR_FECHA_INICIO)]}</font></td></td>' +
                    '<td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Fecha culminaci&oacute;n:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{[this.myDate(values.CDCUR_FECHA_CULMINACION)]}</font></td></tr>' +
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
     * Ext.form.TextField DESCRIPCION DE REGISTRO DE CURSO para la consulta
     */
    var txtCdcur_descripcion_consu = new Ext.form.TextField({
        id:'txtCdcur_descripcion_consu',
        name:'txtCdcur_descripcion_consu',
        fieldLabel :'Curso',
        anchor:'98%'
    });
    /**
     * Ext.form.TextField NUMERO MAXIMO DE ASISTENTES AL CURSO
     */
    var txtCdcur_numero_maximo= new Ext.form.TextField({
        id:'txtCdcur_numero_maximo',
        name:'txtCdcur_numero_maximo',
        fieldLabel :'No. m\u00e1ximo',
        anchor:'98%'
    });
    /**
     * Ext.form.TextField NUMERO MAXIMO DE ASISTENTES AL CURSO
     */
    var txtCdcur_estado_curso= new Ext.form.TextField({
        id:'txtCdcur_estado_curso',
        name:'txtCdcur_estado_curso',
        fieldLabel :'Estado',
        anchor:'98%'
    });
    /**
     * Ext.form.TextField NUMERO MAXIMO DE ASISTENTES AL CURSO
     */
    var txtCdcur_asistente_inscrito= new Ext.form.TextField({
        id:'txtCdcur_asistente_inscrito',
        name:'txtCdcur_asistente_inscrito',
        fieldLabel :'No. inscrito',
        anchor:'98%'
    });
     //Creamos una definici?n de los campos que vienen en el Json remoto

    var cbxTipoCurso_inscripcion= new Ext.form.ComboBox({
        id:'cbxTipoCurso_inscripcion',
        name:'cbxTipoCurso_inscripcion',
        displayField: "CDTCR_NOMBRE",
        fieldLabel :'Tipo curso',
        valueField: 'CDTCR_CODIGO',
        mode:'local',
        typeAhead:true,
        autoSelect:true,
        hiddenId:'cbxTipoCurso_inscripcionH',
        hiddenName:'cbxTipoCurso_inscripcionH',
        hiddenValue:'id',
        forceSelection:true,
        editable: true,
        triggerAction:'all',
        submitValue:true,
        anchor:'98%',
        emptyText : 'Seleccione una opci\u00f3n..'

    });
    function CursoAsistencia(){

        /**
         * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_curso.
         */
        this.cmCursoAsistencia = new Ext.grid.ColumnModel([

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
        this.gsCursoAsistencia = new Ext.data.Store({
            proxy:new Ext.ux.bsx.SoapProxy({
                url:URL_WS+"Cgg_dhu_curso",
                method:"selectCursoAsistente",
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
                {name:'NUMERO_INSCRITO'},
                {name:'NUMERO_DISPONIBLE'},
                {name:'CDCUR_ESTADO_CURSO'}
            ]),
            sortInfo:{field: 'CDTCR_NOMBRE', direction: 'ASC'},
            baseParams:{keyword:"",format:'JSON',inCdtcr_codigo: cbxTipoCurso_inscripcion.getValue()}
        });

    };

    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE CURSO
     */
    var btnCdcur_codigoCgg_dhu_asistente_curso_consu = new Ext.Button({
        id:'btnCdcur_codigoCgg_dhu_asistente_curso_consu',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
				if(cbxTipoCurso_inscripcion.getValue()){
					var tmpFLCgg_dhu_curso = new CursoAsistencia();
					tmpFLCgg_dhu_curso.gsCursoAsistencia.inCdtcr_codigo=cbxTipoCurso_inscripcion.getValue();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_dhu_curso.gsCursoAsistencia,tmpFLCgg_dhu_curso.cmCursoAsistencia);
					objBusqueda.closeHandler(function(){
						var tmpRecord = objBusqueda.getSelectedRow();
						if(tmpRecord){
							txtCdcur_codigo.setValue(tmpRecord.get('CDCUR_CODIGO'));
							txtCdcur_descripcion_consu.setValue(tmpRecord.get('CDCUR_DESCRIPCION'));
							tmpInfoCurso.overwrite(Ext.getCmp('pnlCurso').body, tmpRecord.json);
							txtCdcur_estado_curso.setValue(tmpRecord.get('CDCUR_ESTADO_CURSO'));
							NumeroAprobacion();
							gscgg_dhu_lista_asistente_inscrito.reload({
								params:{
									inCdcur_codigo:txtCdcur_codigo.getValue(),
									format:TypeFormat.JSON
								}});
							if(txtCdcur_estado_curso.getValue()==TypeEstadoCurso.REGISTRADO ){
								Ext.Msg.show({
									title:tituloCgg_dhu_asistente_curso_calificacion,
									msg: ('El curso aun no esta en proceso de inscripci\u00f3n'),
									buttons: Ext.Msg.OK,
									icon: Ext.MessageBox.INFO
								});
								swEstadoInscripcion = true;
							}
							if( txtCdcur_estado_curso.getValue()==TypeEstadoCurso.PROCESO_INSCRIPCION){
								tabCurso.setActiveTab(pnlCursoInscripcion);
								pnlCursoCalificacion.setDisabled(true);
								pnlCursoCertificado.setDisabled(true);
								pnlCursoInscripcion.setDisabled(false);
								gscgg_dhu_asistente_inscripcion.reload({
									params:{
										inCdcur_codigo:txtCdcur_codigo.getValue(),
										format:TypeFormat.JSON
									}});


							}if (gscgg_dhu_asistente_inscripcion.getCount()==0 && txtCdcur_estado_curso.getValue()==TypeEstadoCurso.PROCESO_INSCRIPCION ) {

							Ext.Msg.show({
								title:tituloCgg_dhu_asistente_curso_calificacion,
								msg: ('No tiene registros para inscribir','Si desea ingresar las calificaciones el curso aun no ha sido iniciado'),
								buttons: Ext.Msg.OK,
								icon: Ext.MessageBox.INFO
							});
							}
							if(txtCdcur_estado_curso.getValue()==TypeEstadoCurso.INICIADO){
								pnlCursoInscripcion.setDisabled(true);
								tabCurso.setActiveTab(pnlCursoCalificacion);
								pnlCursoCertificado.setDisabled(true);
								pnlCursoCalificacion.setDisabled(false);

								gscgg_dhu_asistente_curso.reload({
									params:{
										inCdcur_codigo:txtCdcur_codigo.getValue(),
										format:TypeFormat.JSON
									}});}
							if(txtCdcur_estado_curso.getValue()==TypeEstadoCurso.TERMINADO){
								pnlCursoInscripcion.setDisabled(true);
								tabCurso.setActiveTab(pnlCursoCertificado);
								pnlCursoCertificado.setDisabled(false);
								pnlCursoCalificacion.setDisabled(true);
								gscgg_dhu_asistente_certificado.reload({
									params:{
										inCdcur_codigo:txtCdcur_codigo.getValue(),
										format:TypeFormat.JSON
									}
								});
							}
						}

					});
					objBusqueda.show();
				}else{
					Ext.Msg.show({
						title:tituloCgg_dhu_asistente_curso_calificacion,
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
    var txtNumeroAprobacion = new Ext.form.NumberField({
        id:'txtNumeroAprobacion',
        name:'txtNumeroAprobacion',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });

    /**
     * Ext.form.NumberField NOTA FINAL DEL CURSO RECIBIDO
     */
    var numCdasc_nota_final = new Ext.form.NumberField({
        id:'numCdasc_nota_final',name:'numCdasc_nota_final',
        fieldLabel :'Nota final',
        allowBlank :false

    });/**
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

    var txtCdasc_aprobo_curso = new Ext.form.NumberField({
        id:'txtCdasc_aprobo_curso',
        name:'txtCdasc_aprobo_curso',
        fieldLabel :'Estado curso',
        anchor:'98%'
    });
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
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_asistente_curso de los asistentes inscritos
     */
    var cmcgg_dhu_lista_asistente_inscrito = new Ext.grid.ColumnModel([
        {dataIndex:'CDASC_CODIGO',header:'Codigo',width:100,sortable:true,hidden:true},
        {dataIndex:'CDCUR_CODIGO',header:'Codigo',width:100,sortable:true,hidden:true},
        {dataIndex:'CRPER_ASISTENTE',header:'Asistente',width:200,sortable:true},
        {dataIndex:'CRPER_NUM_DOC_IDENTIFIC',header:'No.doc. identific',width:120,sortable:true},
        {dataIndex:'CDASC_ESTADO_INSCRIPCION',header:'Estado inscripci\u00f3n',width:150,sortable:true,hidden:true}

    ]);

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_asistente_curso  por un campo especifico.
     */
    var gscgg_dhu_lista_asistente_inscrito = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_asistente_curso",
            method:"selectAsistenteInscrito",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
        },[ {name:'CDASC_CODIGO'},
            {name:'CDCUR_CODIGO'},
            {name:'CRPER_ASISTENTE'},
            {name:'CRPER_NUM_DOC_IDENTIFIC'},
            {name:'CDASC_ESTADO_INSCRIPCION'},
            {name:'CDCUR_NUMERO_ASISTENTE'},
            {name:'NUMERO_INSCRITO'},
            {name:'NUMERO_DISPONIBLE'}
        ]),
        baseParams:{inCdcur_codigo:'',format:'JSON'}
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_dhu_asistente_curso en un formato tabular de filas y columnas.
     */
    var grdcgg_dhu_lista_asistente_inscrito = new Ext.grid.EditorGridPanel({
        cm:cmcgg_dhu_lista_asistente_inscrito,
        store:gscgg_dhu_lista_asistente_inscrito,
        region:'center',        
		height:150,
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_asistente_curso
     */
    var cmcgg_dhu_asistente_curso = new Ext.grid.ColumnModel([
        {dataIndex:'CDASC_CODIGO',header:'Codigo',width:100,sortable:true,hidden:true},
        {dataIndex:'CDCUR_CODIGO',header:'Codigo',width:100,sortable:true,hidden:true},
        {dataIndex:'CRPER_ASISTENTE',header:'Asistente',width:200,sortable:true},
        {dataIndex:'CRPER_NUM_DOC_IDENTIFIC',header:'No.doc. identific',width:120,sortable:true},
        {dataIndex:'CDASC_NOTA_FINAL',header:'Nota final',width:100,sortable:true,editor:numCdasc_nota_final,renderer:
                function(value,metadata,record)
                {   
                    if(value >tmpnumerominimo)
                    {
                        record.set('CDASC_APROBADO','1');

                    }
                    if(value <tmpnumerominimo && value!=0)
                    {
                        record.set('CDASC_APROBADO','0');

                    }
                    if(value=='0')
                    {
                        record.set('CDASC_APROBADO','2');

                    }
                    return value;
                }

        },
        {dataIndex:'CDASC_APROBADO',header:'Estado curso',width:100,sortable:true,renderer:function(inCasc_Aprobado){
            if(inCasc_Aprobado==TypeEstadoAprobadoCurso.APROBADO){
                return('APROBADO');
            }
            if(inCasc_Aprobado==TypeEstadoAprobadoCurso.REPROBADO){
                return('REPROBADO');
            }
            if(inCasc_Aprobado==TypeEstadoAprobadoCurso.RETIRADO){
                return('RETIRADO');
            }
             if(inCasc_Aprobado==TypeEstadoAprobadoCurso.SIN_CALIFICACION){
                return('POR REGISTRAR');
            }
        }},
        {dataIndex:'CDASC_ESTADO_INSCRIPCION',header:'Estado inscripcion',width:150,sortable:true,hidden:true}

    ]);

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_asistente_curso  por un campo especifico.
     */
    var gscgg_dhu_asistente_curso = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_asistente_curso",
            method:"selectAsistenteCursoCalificacion",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
        },[ {name:'CDASC_CODIGO'},
            {name:'CDCUR_CODIGO'},
            {name:'CRPER_ASISTENTE'},
            {name:'CDASC_NOTA_FINAL'},
            {name:'CRPER_NUM_DOC_IDENTIFIC'},
            {name:'CDASC_ESTADO_INSCRIPCION'},
            {name:'CDASC_APROBADO'}
        ]),
        baseParams:{inCdcur_codigo:'',format:'JSON'}
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_dhu_asistente_curso en un formato tabular de filas y columnas.
     */
    var grdcgg_dhu_asistente_curso = new Ext.grid.EditorGridPanel({
        cm:cmcgg_dhu_asistente_curso,
        store:gscgg_dhu_asistente_curso,
        region:'center',        
		height:150,
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_asistente_curso
     */
    var smInscrito = new Ext.grid.CheckboxSelectionModel({
        checkOnly : true
    });
    var cmcgg_dhu_asistente_inscripcion = new Ext.grid.ColumnModel([
        smInscrito,
        {dataIndex:'CDASC_CODIGO',header:'Codigo',width:100,sortable:true,hidden:true},
        {dataIndex:'CDCUR_CODIGO',header:'Codigo',width:100,sortable:true,hidden:true},
        {dataIndex:'CRPER_ASISTENTE',header:'Asistente',width:200,sortable:true},
        {dataIndex:'CRPER_NUM_DOC_IDENTIFIC',header:'No.doc. identific',width:120,sortable:true},
        {dataIndex:'CDASC_ESTADO_INSCRIPCION',header:'Estado inscripci\u00f3n',width:150,sortable:true,editor:cbxEstadoInscripcion,
            renderer:function(inEstadoInscripcion){
                if(inEstadoInscripcion==TypeEstadoInscripcion.PRE_INSCRITO){
                    return('PRE-INSCRITO')
                }
                if(inEstadoInscripcion==TypeEstadoInscripcion.INSCRITO){
                    return('INSCRITO')
                }
                 if(inEstadoInscripcion==TypeEstadoInscripcion.ANULADO){
                    return('ANULADO')
                }
            }}
    ]);

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_asistente_curso  por un campo especifico.
     */
    var gscgg_dhu_asistente_inscripcion = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_asistente_curso",
            method:"selectAsistenteCursoInscrito",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
        },[ {name:'CDASC_CODIGO'},
            {name:'CDCUR_CODIGO'},
            {name:'CRPER_ASISTENTE'},
            {name:'CRPER_NUM_DOC_IDENTIFIC'},
            {name:'CDASC_ESTADO_INSCRIPCION'}
        ]),
        baseParams:{inCdcur_codigo:'',format:'JSON'}
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_dhu_asistente_curso en un formato tabular de filas y columnas.
     */
    var grdcgg_dhu_asistente_inscripcion = new Ext.grid.EditorGridPanel({
        cm:cmcgg_dhu_asistente_inscripcion,
        store:gscgg_dhu_asistente_inscripcion,
        region:'center',        
		height:150,
        clicksToEdit: 1,
        sm:smInscrito,
        loadMask:{msg:"Cargando..."}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_asistente_curso
     */
    var cmcgg_dhu_asistente_certificado = new Ext.grid.ColumnModel([
        {dataIndex:'CDASC_CODIGO',header:'Codigo',width:100,sortable:true,hidden:true},
        {dataIndex:'CDCUR_CODIGO',header:'Codigo',width:100,sortable:true,hidden:true},
        {dataIndex:'CRPER_ASISTENTE',header:'Asistente',width:200,sortable:true},
        {dataIndex:'CRPER_NUM_DOC_IDENTIFIC',header:'No.doc. identific',width:120,sortable:true},
        {dataIndex:'CDASC_NOTA_FINAL',header:'Nota final',width:100,sortable:true},
        {dataIndex:'CDASC_APROBADO',header:'Estado curso',width:100,sortable:true,renderer:function(inCasc_Aprobado){
            if(inCasc_Aprobado==TypeEstadoAprobadoCurso.APROBADO){
                return('APROBADO');
            }
            if(inCasc_Aprobado==TypeEstadoAprobadoCurso.REPROBADO){
                return('REPROBADO');
            }
            if(inCasc_Aprobado==TypeEstadoAprobadoCurso.RETIRADO){
                return('RETIRADO');
            }
        }},
        {dataIndex:'CDASC_NUMERO_CERTIFICADO',header:'No.certificado',width:100,sortable:true,editor:txtCdasc_numero_certificado},
        {dataIndex:'CDASC_FECHA_EMISION_CERTIFICADO',header:'Fecha emisi\u00f3n',width:100,sortable:true,editor:dtCdasc_fecha_emision_certificado}

    ]);

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_asistente_curso  por un campo especifico.
     */
    var gscgg_dhu_asistente_certificado = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_asistente_curso",
            method:"selectAsistenteCertificado",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
        },[ {name:'CDASC_CODIGO'},
            {name:'CDCUR_CODIGO'},
            {name:'CRPER_ASISTENTE'},
            {name:'CRPER_NUM_DOC_IDENTIFIC'},
            {name:'CDASC_NOTA_FINAL'},
            {name:'CDASC_APROBADO'}
        ]),
        baseParams:{inCdcur_codigo:'',format:'JSON'}
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_dhu_asistente_curso en un formato tabular de filas y columnas.
     */
    var grdcgg_dhu_asistente_certificado = new Ext.grid.EditorGridPanel({
        cm:cmcgg_dhu_asistente_certificado,
        store:gscgg_dhu_asistente_certificado,
        region:'center',
        height:150,
		//autoHeight : true,
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."}
    });
    // cbxEstadoInscripcion.setVisible(false);
    var btnInscribir = new Ext.Button({
        iconCls:'iconNuevo',
        text:'Inscribir',
        id:'btnInscribir',
        name:'btnInscribir',
        tooltip:'Inscribir asistente',
        listeners:{
            click:function(){
				if(swEstadoInscripcion == true){
					Ext.Msg.show({
						title:tituloCgg_dhu_asistente_curso_calificacion,
						msg: 'El curso no est\u00E1 en proceso de inscripciones',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.INFO
					});
					return;
				}
                var seleccionado = grdcgg_dhu_asistente_inscripcion.getSelectionModel().getSelections();
				if (seleccionado.length==0){
					Ext.Msg.show({
						title:tituloCgg_dhu_asistente_curso_calificacion,
						msg: 'No existen datos seleccionados',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.INFO
					});
					return;
				}
                for(i=0;i<seleccionado.length;i++){
                    seleccionado[i].set('CDASC_ESTADO_INSCRIPCION','1');
                }
                function CallBackCgg_dhu_registroInscribir(r) {
                    winFrmCgg_dhu_asistente_curso_calificacion.getEl().unmask();
                    if (r == 'true') {
                        Ext.Msg.show({
                            title:tituloCgg_dhu_asistente_curso_calificacion,
                            msg: 'Los asistentes seleccionados han sido inscritos.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.INFO
                        });
                        winFrmCgg_dhu_asistente_curso_calificacion.close()
                    } else
                        Ext.Msg.show({
                            title:tituloCgg_dhu_asistente_curso_calificacion,
                            msg: 'Los asistentes seleccionados no han podido ser inscritos',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.ERROR
                        });
                }

                winFrmCgg_dhu_asistente_curso_calificacion.getEl().mask('Guardando...', 'x-mask-loading');
                var param = new SOAPClientParameters();
                param.add('inAsistenteCurso_JSON', grdcgg_dhu_asistente_inscripcion.getStore().getJsonData());
                param.add('inCdcur_codigo',grdcgg_dhu_asistente_inscripcion.getSelectionModel().getSelected().get('CDCUR_CODIGO')) ;
                SOAPClient.invoke(urlCgg_dhu_asistente_curso_calificacion, "updateAsistenteInscripcion", param, true, CallBackCgg_dhu_registroInscribir);




            }
        }
    });
    var btnRegistroCalificacion = new Ext.Button({
        iconCls:'iconNuevo',
        text:'Registro calificaciones',
        id:'btnRegistroCalificacion',
        name:'btnRegistroCalificacion',
        tooltip:'Registro Calificaci\u00f3n',
        listeners:{
            click:function(){
				if(grdcgg_dhu_asistente_curso.getStore().getTotalCount()<=0){
					Ext.Msg.show({
						title:tituloCgg_dhu_asistente_curso_calificacion,
						msg: 'No existen datos',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.INFO
					});
					return;
				}

                function CallBackCgg_dhu_registroCalificacion(r) {
                    winFrmCgg_dhu_asistente_curso_calificacion.getEl().unmask();
                    if (r == 'true') {
                        Ext.Msg.show({
                            title:tituloCgg_dhu_asistente_curso_calificacion,
                            msg: 'Las calificaciones se han almacenado.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.INFO
                        });
                        winFrmCgg_dhu_asistente_curso_calificacion.close()
                    } else
                        Ext.Msg.show({
                            title:tituloCgg_dhu_asistente_curso_calificacion,
                            msg: 'Las calificaciones no han podido ser almacenado',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.ERROR
                        });
                }

                winFrmCgg_dhu_asistente_curso_calificacion.getEl().mask('Guardando...', 'x-mask-loading');
                var param = new SOAPClientParameters();
                param.add('inAsistenteCalificacion_JSON', grdcgg_dhu_asistente_curso.getStore().getJsonData());
                param.add('inCdcur_codigo',grdcgg_dhu_asistente_curso.getSelectionModel().getSelected().get('CDCUR_CODIGO')) ;
                SOAPClient.invoke(urlCgg_dhu_asistente_curso_calificacion, "updateAsistenteCalificacion", param, true, CallBackCgg_dhu_registroCalificacion);
            }
        }
    });
    var btnRegistroCertificado = new Ext.Button({
        iconCls:'iconNuevo',
        text:'Registro certificado',
        id:'btnRegistroCertificado',
        name:'btnRegistroCertificado',
        tooltip:'Registro Certificado',
        listeners:{
            click:function(){
				if (!grdcgg_dhu_asistente_certificado.getSelectionModel().getSelected()){
					Ext.Msg.show({
						title:tituloCgg_dhu_asistente_curso_calificacion,
						msg: 'No existen datos',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.INFO
					});
					return;
				}
                function CallBackCgg_dhu_registroCertificado(r) {
                    winFrmCgg_dhu_asistente_curso_calificacion.getEl().unmask();
                    if (r == 'true') {
                        Ext.Msg.show({
                            title:tituloCgg_dhu_asistente_curso_calificacion,
                            msg: 'La informcaci\u00f3n se han almacenado.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.INFO
                        });
                        winFrmCgg_dhu_asistente_curso_calificacion.close()
                    } else
                        Ext.Msg.show({
                            title:tituloCgg_dhu_asistente_curso_calificacion,
                            msg: 'La informcaci\u00f3n no han podido ser almacenado',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.ERROR
                        });
                }

                winFrmCgg_dhu_asistente_curso_calificacion.getEl().mask('Guardando...', 'x-mask-loading');
                var param = new SOAPClientParameters();
                param.add('inAsistenteCertificado_JSON', grdcgg_dhu_asistente_certificado.getStore().getJsonData());
                param.add('inCdcur_codigo',grdcgg_dhu_asistente_certificado.getSelectionModel().getSelected().get('CDCUR_CODIGO')) ;
                SOAPClient.invoke(urlCgg_dhu_asistente_curso_calificacion, "updateAsistenteCertificado", param, true, CallBackCgg_dhu_registroCertificado);
            }
        }
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_dhu_asistente_curso.
     */
    var btnCancelarCgg_dhu_asistente_curso_calificacion= new Ext.Button({
        id:'btnCancelarCgg_dhu_asistente_curso_calificacion',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                 pnlCgg_dhu_asistente_curso_calificacion.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_dhu_asistente_curso.
     */
    var btnCerrarCgg_dhu_asistente_curso_calificacion = new Ext.Button({
        id:'btnCerrarCgg_dhu_asistente_curso_calificacion',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_dhu_asistente_curso_calificacion.close();
            }}
    });


    /**
     * Ext.form.FormPanel Panel principal que contiene los  datos curso.
     */
    var pnlCursoNONONO = new Ext.form.FieldSet({
        id:'pnlCursoNONONON',
        title:'Datos curso',
        collapsible:false,
        layout:'form',
        items:[
            {xtype:'panel', id :'pnlDatosCurso',data:datosCurso,tpl:tmpInfoCurso} 
		]
    });
	var pnlCurso = new  Ext.form.FieldSet({
        id:'pnlCurso',
        region:'center',
		collapsible:true,
        title:'Estad\u00eda',
        data:datosCurso,
        tpl:tmpInfoCurso,
		height : 150,
		frame : true
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los  controles para inscribir  los asistentes al curso.
     */
    var pnlCursoInscripcion = new Ext.Panel({
        id:'pnlCursoInscripcion',
        title:'Asistente por inscribir',
        layout:'form',
        items:[grdcgg_dhu_asistente_inscripcion  ]
    });

    /**
     * Ext.form.FormPanel Panel principal que contiene los  controles para ingrasar las calificaciones.
     */
    var pnlCursoCalificacion = new Ext.Panel({
        id:'pnlCursoCalificacion',
        title:'Calificaci\u00f3n',
        layout:'form',		
        items:[grdcgg_dhu_asistente_curso]
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles para ingrasar los certificados.
     */
    var pnlCursoCertificado = new Ext.Panel({
        id:'pnlCursoCertificado',
        title:'Certificado',		
        layout:'form',
        items:[grdcgg_dhu_asistente_certificado ]
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles para visualizar el listado de los asistentes inscritos.
     */
    var pnlCursoAsistenteInscrito = new Ext.Panel({
        id:'pnlCursoAsistenteInscrito',
        title:'Asistentes inscritos',
        layout:'form',
        items:[grdcgg_dhu_lista_asistente_inscrito]
    });


    /**
     * Ext.form.TabPanel  que contiene los controles de la ventana winFrmCgg_dhu_asistente_curso.
     */
    var tabCurso = new Ext.TabPanel({
        region:'center',
		//autoHeight:true,
        activeTab:0,
        items:[pnlCursoAsistenteInscrito,pnlCursoInscripcion,pnlCursoCalificacion,pnlCursoCertificado],
        listeners:{
            tabchange :function(){
                if(tabCurso.getActiveTab().getId()=='pnlCursoInscripcion'){
                    btnRegistroCalificacion.disable();
                    btnRegistroCertificado.disable();
                    btnInscribir.enable();
                }if(tabCurso.getActiveTab().getId()=='pnlCursoCalificacion'){
                    btnInscribir.disable();
                    btnRegistroCalificacion.enable();
                    btnRegistroCertificado.disable();
                }if(tabCurso.getActiveTab().getId()=='pnlCursoCertificado'){
                    btnInscribir.disable();
                    btnRegistroCalificacion.disable();
                    btnRegistroCertificado.enable();
                }if(tabCurso.getActiveTab().getId()=='pnlCursoAsistenteInscrito'){
					btnInscribir.disable();
                    btnRegistroCalificacion.disable();
                    btnRegistroCertificado.disable();
				}

            }
        }
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_dhu_asistente_curso.
     */
    var pnlCgg_dhu_asistente_curso_calificacion= new Ext.form.FormPanel({
        frame:true,
        labelWidth :80,
		autoWidth:true,
		autoHeight:true,
		layout : 'form',
        items:[ 
			{	xtype:'panel',
				layout:'column',
				items:[{
					columnWidth:.40,
					layout:'form',
					items:[cbxTipoCurso_inscripcion]
				},{
					columnWidth:.55,
					layout:'form',
					items:[txtCdcur_descripcion_consu]
				},{
					columnWidth:.05,
					layout:'form',
					items:[btnCdcur_codigoCgg_dhu_asistente_curso_consu]
				}]
			},pnlCurso,tabCurso
		]
    });
    function NumeroAprobacion(){
        function CallBackCgg_dhu_ValorAprobado(r){
            tmpnumerominimo= r;
        }
        var param = new SOAPClientParameters();
        SOAPClient.invoke(URL_WS+"Cgg_dhu_asistente_curso","numeroAprobacion",param, true,CallBackCgg_dhu_ValorAprobado);


    }

    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_dhu_asistente_curso.
     */
    var winFrmCgg_dhu_asistente_curso_calificacion = new Ext.Window({
        id:'winFrmCgg_dhu_asistente_curso_calificacion',
        title:tituloCgg_dhu_asistente_curso_calificacion,
        tbar:getPanelTitulo(tituloCgg_dhu_asistente_curso_calificacion,descCgg_dhu_asistente_curso_calificacion),
        items:[pnlCgg_dhu_asistente_curso_calificacion],
        width:600,
        minWidth:600,
		autoHeight : true,
        constrain:true,
		layout: 'form',
		height : 450,
		modal:true,
		resizable:false,
		forceLayout : true,
        bbar:[btnInscribir,btnRegistroCalificacion,btnRegistroCertificado,btnCancelarCgg_dhu_asistente_curso_calificacion,'->',btnCerrarCgg_dhu_asistente_curso_calificacion]


    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_dhu_asistente_curso_calificacion.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_dhu_asistente_curso_calificacionCtrls(inEstado){
        estado=!inEstado;
        txtCdasc_codigo.setDisabled(estado);
        txtCrper_codigo.setDisabled(estado);
        txtCdcur_codigo.setDisabled(estado);
        txtCsctp_codigo.setDisabled(estado);
        numCdasc_nota_final.setDisabled(estado);
        txtCdasc_numero_certificado.setDisabled(estado);
        dtCdasc_fecha_emision_certificado.setDisabled(estado);
        cbxEstadoInscripcion.setDisabled(estado);
        cbxTipoAprobadoCurso.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_dhu_asistente_curso_calificacion.
     */
    function cargarCgg_dhu_asistente_curso_calificacionCtrls(){
        if(inRecordCgg_dhu_asistente_curso_calificacion){
            txtCdasc_codigo.setValue(inRecordCgg_dhu_asistente_curso_calificacion.get('CDASC_CODIGO'));
            txtCrper_codigo.setValue(inRecordCgg_dhu_asistente_curso_calificacion.get('CRPER_CODIGO'));
            txtCdcur_codigo.setValue(inRecordCgg_dhu_asistente_curso_calificacion.get('CDCUR_CODIGO'));
            //  txtCdcur_descripcion.setValue(inRecordCgg_dhu_asistente_curso_calificacion.get('CDCUR_DESCRIPCION'));
            txtCsctp_codigo.setValue(inRecordCgg_dhu_asistente_curso_calificacion.get('CSCTP_CODIGO'));
            //   txtCsctp_nombre.setValue(inRecordCgg_dhu_asistente_curso_calificacion.get('CSCTP_NOMBRE'));
            // txtCusu_codigo.setValue(inRecordCgg_dhu_asistente_curso_calificacion.get('CUSU_CODIGO'));
            //txtCdasc_actividad_realizada.setValue(inRecordCgg_dhu_asistente_curso_calificacion.get('CDASC_ACTIVIDAD_REALIZADA'));
            numCdasc_nota_final.setValue(inRecordCgg_dhu_asistente_curso_calificacion.get('CDASC_NOTA_FINAL'));
            txtCdasc_numero_certificado.setValue(inRecordCgg_dhu_asistente_curso_calificacion.get('CDASC_NUMERO_CERTIFICADO'));
            dtCdasc_fecha_emision_certificado.setValue(truncDate(inRecordCgg_dhu_asistente_curso_calificacion.get('CDASC_FECHA_EMISION_CERTIFICADO')));
            cbxEstadoInscripcion.setValue(inRecordCgg_dhu_asistente_curso_calificacion.get('CDASC_ESTADO_INSCRIPCION'));
            cbxTipoAprobadoCurso.setValue(inRecordCgg_dhu_asistente_curso_calificacion.get('CDASC_APROBADO'));
            // cbxEstadoInscripcion.setVisible(true);
            //cbxTipoAprobadoCurso.setVisible(true);
            isEdit = true;
            habilitarCgg_dhu_asistente_curso_calificacionCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_dhu_asistente_curso_calificacion.
     * @returns ventana winFrmCgg_dhu_asistente_curso_calificacion.
     * @base FrmCgg_dhu_asistente_curso_calificacion.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_dhu_asistente_curso_calificacion;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_dhu_asistente_curso_calificacion.
     * @base FrmCgg_dhu_asistente_curso_calificacion.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_dhu_asistente_curso_calificacionCtrls();
    }
	
	this.setStoreTipoCurso = function(inStoreTipoCurso){
		cbxTipoCurso_inscripcion.store = inStoreTipoCurso;
	}
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_dhu_asistente_curso_calificacion desde una instancia.
 */
FrmCgg_dhu_asistente_curso_calificacion.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_dhu_asistente_curso_calificacion desde una instancia.
 */
FrmCgg_dhu_asistente_curso_calificacion.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_dhu_asistente_curso_calificacion,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_dhu_asistente_curso_calificacion.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_dhu_asistente_curso_calificacion desde una instancia.
 */
FrmCgg_dhu_asistente_curso_calificacion.prototype.loadData = function(){
    this.loadData();
}

FrmCgg_dhu_asistente_curso_calificacion.prototype.setStoreTipoCurso = function(inStoreTipoCurso){
    this.setStoreTipoCurso(inStoreTipoCurso);
}