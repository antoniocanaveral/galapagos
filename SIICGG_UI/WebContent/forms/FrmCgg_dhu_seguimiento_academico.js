/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_dhu_seguimiento_academico.
 * @param {String} INSENTENCIA_CGG_DHU_SEGUIMIENTO_ACADEMICO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_DHU_SEGUIMIENTO_ACADEMICO Registro de datos de la tabla Cgg_dhu_seguimiento_academico.
 * @constructor
 * @base FrmListadoCgg_dhu_seguimiento_academico
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_dhu_seguimiento_academico(INSENTENCIA_CGG_DHU_SEGUIMIENTO_ACADEMICO,INRECORD_CGG_DHU_SEGUIMIENTO_ACADEMICO){
    var inSentenciaCgg_dhu_seguimiento_academico = INSENTENCIA_CGG_DHU_SEGUIMIENTO_ACADEMICO;
    var inRecordCgg_dhu_seguimiento_academico=INRECORD_CGG_DHU_SEGUIMIENTO_ACADEMICO;
    var urlCgg_dhu_seguimiento_academico=URL_WS+"Cgg_dhu_seguimiento_academico";
    var tituloCgg_dhu_seguimiento_academico='Seguimiento acad\u00E9mico';
    var descCgg_dhu_seguimiento_academico='El formulario permite administrar informaci\u00f3n del seguimiento acad\u00E9mico';
    var isEdit = false;
    var tmpInformacionPersonaBecaSeguimiento;
    var EliSadjunto=new Array ();
    var tmpListadoEliminarAdjunto;
	var valor = true;
   // var tmpFase = null;
    var tmpnumerociclo;
     var tmpSigNumero;
    var tmpFechaIngreso;
    function PersonaBeca() {
        var cmPersonaBeca = null;
        var gsPersonaBeca = null;
        /**
         * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_persona.
         *
         */
        cmPersonaBeca = new Ext.grid.ColumnModel([
            {dataIndex:'CDBEC_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
            {dataIndex:'CDBEC_NUMERO',header:'No.Beca',width:150,sortable:true},
            {dataIndex:'CDBEC_NUMERO_CONVENIO',header:'Contrato',width:150,sortable:true},
            {dataIndex:'CRPER_NOMBRES',header:'Nombres',width:150,sortable:true},
            {dataIndex:'CRPER_APELLIDOS_PERSONA',header:'Apellidos',width:150,sortable:true},
            {dataIndex:'CRPER_NUM_DOC_IDENTIFIC',header:'Num.documento',width:150,sortable:true},
            {dataIndex:'CDBEC_FUNCIONARIO',header:'Funcionario',width:150,sortable:true},
            {dataIndex:'CGESP_NOMBRE',header:'Especialidad',width:150,sortable:true},
            {dataIndex:'CDBEC_TIPO_CICLO',header:'Tipo ciclo',width:150,sortable:true,renderer:function(inCdbsegTipoCiclo){
            if(inCdbsegTipoCiclo==TypeCiclo.ANUAL)
            {return('ANUAL');}
             if(inCdbsegTipoCiclo==TypeCiclo.SEMESTRAL)
            {return('SEMESTRAL');}
             if(inCdbsegTipoCiclo==TypeCiclo.QUIMESTRAL)
            {return('QUIMESTRAL');}
             if(inCdbsegTipoCiclo==TypeCiclo.OTROS)
            {return('OTROS');}}}]);
        /**
         * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_persona por un campo especifico.
         */
        gsPersonaBeca = new Ext.data.Store({
            proxy:new Ext.ux.bsx.SoapProxy({
                url:URL_WS + "Cgg_dhu_seguimiento_academico",
                method:"selectBecaSeguimiento",
                pagin:true
            }),
            remoteSort:true,
            reader:new Ext.data.JsonReader({
                id:'CDBEC_CODIGO',
                root:'dataSet',
                totalProperty: 'totalCount'
            }, [{name:'CDBEC_CODIGO'},
                {name:'CDBEC_NUMERO'},
                {name:'CRPER_NOMBRES'},
                {name:'CRPER_APELLIDOS_PERSONA'},
                {name:'CRPER_NUM_DOC_IDENTIFIC'},
                {name:'CDTBC_CODIGO'},
                {name:'CDTBC_NOMBRE'},
                {name:'CGESP_NOMBRE'},
                {name:'CDBEC_FUNCIONARIO'},
                {name:'CDBEC_NUMERO_CONVENIO'},
                {name:'CDBEC_TIPO_CICLO'},
                {name:'CDBEC_TOTAL_CICLOS'}



            ]),
            sortInfo:{
                field: 'CDBEC_NUMERO',
                direction: 'DESC'
            },
            baseParams:{
                keyword:"",
                format:"JSON"
            }
        });
        this.getCm = function() {
            return cmPersonaBeca;
        };

        this.getStore = function() {
            return gsPersonaBeca;
        }
    }

    PersonaBeca.prototype.getColumnModel = function() {
        return this.getCm();
    };

    PersonaBeca.prototype.getStore = function() {
        return this.getStore();
    };
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE BECA
     */
    var txtCdbec_codigo = new Ext.form.TextField({
        id:'txtCdbec_codigo',
        name:'txtCdbec_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        maxLength :20
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE TIPO DE BECA
     */
    var txtCdtbc_codigo = new Ext.form.TextField({
        id:'txtCdtbc_codigo',
        name:'txtCdtbc_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        maxLength :20
    });
       /**
     * Ext.form.TextField TOTAL DE CICLOS DE BECA
     */
    var txtCdbec_total_ciclo = new Ext.form.TextField({
        id:'txtCdbec_total_ciclo',
        name:'txtCdbec_total_ciclo',
        fieldLabel :'Total ciclo',
        anchor:'98%',
        readOnly:'true'
    });
    /**
     * Ext.form.TextField numero de identificacion
     */
    var txtCdbec_seguimiento = new Ext.form.TextField({
        id:'txtCdbec_seguimiento',
        name:'txtCdbec_seguimiento',
        fieldLabel :'No.documento',
        anchor:'98%',
        enableKeyEvents:true,
		allowBlank:false,
        listeners: {
            specialkey: function(field, e){
                if (e.getKey() == e.ENTER) {
                    try{
                        function CallBackCgg_persona(r){
                            tmpInformacionPersonaBecaSeguimiento = Ext.util.JSON.decode(r)[0];
                            if(tmpInformacionPersonaBecaSeguimiento!=null){
                                txtCdbec_codigo.setValue(tmpInformacionPersonaBecaSeguimiento.CDBEC_CODIGO);
                                tmpInfoPersonaBecaSeguimiento.overwrite(Ext.getCmp('pnlCgg_res_beca_persona1').body,tmpInformacionPersonaBecaSeguimiento);
                                txtCdtbc_codigo.setValue(tmpInformacionPersonaBecaSeguimiento.CDTBC_CODIGO);
                                txtCdbec_total_ciclo.setValue(tmpInformacionPersonaBecaSeguimiento.CDBEC_TOTAL_CICLOS);
                               if (NumeroCiclo()==true){
									gsCgg_dhu_certificado_beca.load({
										params:{
											in_Cdbec_codigo:txtCdbec_codigo.getValue(),
											in_Cdacd_codigo:"",
											format:TypeFormat.JSON
										}
									});
									if(numCdbec_ciclo.getValue()>txtCdbec_total_ciclo.getValue()){
										Ext.Msg.show({
											title:tituloCgg_dhu_seguimiento_academico,
											msg: 'El ciclo acad\u00E9mico a registrar. excede del total de ciclos de la carrera ',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.ERROR
										});
									}
								}else{
									Ext.Msg.show({
										title:tituloCgg_dhu_seguimiento_academico,
										msg: 'La informaci\u00f3n seleccionada ya esta en proceso de seguimiento. <br/> Por favor seleccione otro',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
									});
									valor = true;
									txtCdbec_seguimiento.setValue('');
								}
                            }else{
                                Ext.Msg.show({
                                    title:tituloCgg_dhu_seguimiento_academico,
                                    msg: 'No existe el registro solicitado.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO});
                            }

                        }
                        var param = new SOAPClientParameters();
                        param.add('inCrper_num_doc_identific',txtCdbec_seguimiento.getValue());
                        param.add('format',TypeFormat.JSON);
                        SOAPClient.invoke(URL_WS+"Cgg_dhu_seguimiento_academico","selectSeguimientoAcademicoBeca",param, true, CallBackCgg_persona);
                    }catch(inErr){
                        //winFrmCgg_institucion_educativa.getEl().unmask();
                    }

                }
            }
        }
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE BECA
     */txtCdbec_seguimiento
    var btnCdbec_codigoCgg_dhu_seguimiento_academico = new Ext.Button({
        id:'btnCdbec_codigoCgg_dhu_seguimiento_academico',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){

                var tmpFLCgg_dhu_beca_seguimiento = new PersonaBeca();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_dhu_beca_seguimiento.getStore(),tmpFLCgg_dhu_beca_seguimiento.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord!=null){
                        txtCdbec_codigo.setValue(tmpRecord.get('CDBEC_CODIGO'));
                        
						
                        txtCdbec_seguimiento.setValue(tmpRecord.get('CRPER_NUM_DOC_IDENTIFIC'));
                        txtCdtbc_codigo.setValue(tmpRecord.get('CDTBC_CODIGO'));
                        txtCdbec_total_ciclo.setValue(tmpRecord.get('CDBEC_TOTAL_CICLOS'));
						if (NumeroCiclo()==true){
							tmpInfoPersonaBecaSeguimiento.overwrite(Ext.getCmp('pnlCgg_res_beca_persona1').body,tmpRecord.json);
							gsCgg_dhu_certificado_beca.load({
								params:{
									in_Cdbec_codigo:txtCdbec_codigo.getValue(),
									in_Cdacd_codigo:"",
									format:TypeFormat.JSON
								}});
							if(numCdbec_ciclo.getValue()>txtCdbec_total_ciclo.getValue()){
								Ext.Msg.show({
									title:tituloCgg_dhu_seguimiento_academico,
									msg: 'El ciclo academico a registrar. excede del total de ciclos de la carrera ',
									buttons: Ext.Msg.OK,
									icon: Ext.MessageBox.ERROR
								});
							}
						}else{
							Ext.Msg.show({
								title:tituloCgg_dhu_seguimiento_academico,
								msg: 'La informaci\u00f3n seleccionada ya esta en proceso de seguimiento. <br/> Por favor seleccione otro',
								buttons: Ext.Msg.OK,
								icon: Ext.MessageBox.INFO
							});
							valor = true;
							txtCdbec_seguimiento.setValue('');
						}
                    }/*else
                    {
                        Ext.Msg.show({
                            title:tituloCgg_dhu_seguimiento_academico,
                            msg: 'El registro solicitado no esta en proceso',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.ERROR
                        });
                    }*/
                });
                objBusqueda.show();
            }}
    });
    var datosPersonaBecaSeguimiento= {

        CRPER_NOMBRE_PERSONA:'0',
        CRPER_APELLIDOS_PERSONA:'0',
        CRPER_NUM_IDENTIFIC:'0',
        CDBEC_TIPO_BECA:'0',
        CGESP_NOMBRE:'0',
        CDBEC_FUNCIONARIO:'0',
        CDBEC_NUMERO_CONVENIO:'0',
        CDBEC_TIPO_CICLO:'0'
    }


	/***************************
	*****************************/
	var tmpInfoPersonaBecaSeguimiento = new Ext.XTemplate(
		'<table width="100%" height="100px" class="cggTemplate"><tr>'+
			'<td width="60%" valign="top"><table cellspacing=5>'+
                '<tr><th>Noombres:</th><td><span>{CRPER_NOMBRES}</span></td></tr>'+
                '<tr><th>No.documento:</th><td><span>{CRPER_NUM_DOC_IDENTIFIC}</span></td></tr>'+
                '<tr><th>Especialidad:</th><td><span>{CGESP_NOMBRE}</span></td></tr>'+
                '<tr><th>Contrato:</th><td><span>{CDBEC_NUMERO_CONVENIO}</span></td></tr>'+
				        
			'</table></td>'+
            '<td width="40%" valign="top">  <table cellspacing=5>'+
				'<tr><th>Apellidos:</th><td><span>{CRPER_APELLIDOS_PERSONA}</span></td></tr>'+
				'<tr><th>Tipo beca:</th><td><span>{CDTBC_NOMBRE}</span></td></tr>'+
				'<tr><th>Funcionario:</th><td><span>{CDBEC_FUNCIONARIO}</span></td></tr>'+
				'<tr><th>Tipo Ciclo:</th><td>',
					'<tpl if="CDBEC_TIPO_CICLO ==TypeCiclo.ANUAL">',
						'<span>Anual</span>',
						'</tpl>',
					'<tpl if="CDBEC_TIPO_CICLO ==TypeCiclo.SEMESTRAL">',
						'<span>Semestral</span>',
					'</tpl>',
					'<tpl if="CDBEC_TIPO_CICLO ==TypeCiclo.QUIMESTRAL">',
						'<span>Quimestral</span>',
					'</tpl>',
					'<tpl if="CDBEC_TIPO_CICLO ==TypeCiclo.OTROS">',
						'<span>Otros</span>',
					'</tpl>',
				'</td></tr>'+
			'</table> </td>'+
		'</tr></table>',
		{
			/*fnValor: function(CDBEC_TIPO_CICLO){
				return CDBEC_TIPO_CICLO;
			}*/
		}
	);
	
	//******************************
	
	
    /*template de la consulta de PERSONA Y DATOS DE LA BECA*/
    var tmpInfoPersonaSeguimientoEdit = new Ext.XTemplate(
            '<table width="100%" height="100%" cellpadding="0">' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Nombres:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CRPER_NOMBRES}</font></td></td>' +
                    '<td><div class="tituloTemplate"<font  face="Arial, Helvetica, sans-serif">Apellidos:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CRPER_APELLIDOS_PERSONA}</font></td></td>' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">No.documento:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CRPER_NUM_DOC_IDENTIFIC}</font></td></td>' +
                    '<td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Tipo Beca:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CDTBC_NOMBRE}</font></td></td>' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Especialidad:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CGESP_NOMBRE}</font></td></td>' +
                    '<td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Funcionario:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CDBEC_FUNCIONARIO}</font></td></td>' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Convenio:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CDBEC_NUMERO_CONVENIO}</font></td></td>' +
                    '<td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Tipo ciclo:</font></div></td>' +
                // '<td><font size="1" face="Arial, Helvetica, sans-serif">{CDBEC_TIPO_CICLO}</font></td></td>' +
                    ' <td><font size="1" face="Arial, Helvetica, sans-serif">',
            '<tpl if="CDBEC_TIPO_CICLO ==TypeCiclo.ANUAL">',
            '<span style="font-weight: bold;">Anual</span>',

            '</tpl>',
            '<tpl if="CDBEC_TIPO_CICLO ==TypeCiclo.SEMESTRAL">',
            '<b>Semestral</b>',
            '</tpl>',
            '<tpl if="CDBEC_TIPO_CICLO ==TypeCiclo.QUIMESTRAL">',
            '<b>Quimestral</b>',
            '</tpl>',
            '<tpl if="CDBEC_TIPO_CICLO ==TypeCiclo.OTROS">',
            '<b>Otros</b>',
            '</tpl>',
            '</font></td>' +
                    '</table>'


            );

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO ACADEMICO
     */
    var txtCdacd_codigo = new Ext.form.TextField({
        id:'txtCdacd_codigo',
        name:'txtCdacd_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.NumberField NUMERO DE CICLO ACADEMICO
     */
    var numCdbec_ciclo = new Ext.ux.form.SpinnerField({
        id:'numCdbec_ciclo',
        name:'numCdbec_ciclo',
        fieldLabel :'Ciclo acad\u00E9mico',
        minValue: 0,
        maxValue: 20,
        value: 0,
		allowBlank:false,
        anchor:'70%'
    });
    /**
     * Ext.form.NumberField NUMERO DE CICLO ACADEMICO
     */
    var numCdbec_ciclo1 = new Ext.ux.form.SpinnerField({
        id:'numCdbec_ciclo1',
        name:'numCdbec_ciclo1',
        fieldLabel :'Ciclo acad\u00E9mico',
        minValue: 0,
        maxValue: 20,
        value: 0,
        anchor:'70%'
    });
    /*var numCdacd_numero_ciclo = new Ext.form.NumberField({
     id:'numCdacd_numero_ciclo',nname:'numCdacd_numero_ciclo',fieldLabel :'Numero ciclo',allowBlank :false,disabled :false});/**
     * Ext.form.DateField FECHA DE INICIO DEL CICLO
     */
    var dtCdacd_fecha_inicio = new Ext.form.DateField({
        id:'dtCdacd_fecha_inicio',
        name:'dtCdacd_fecha_inicio',
        fieldLabel :'Fecha inicio',
		value : new Date(),
		allowBlank:false,
		listeners:{
			change:function(obj,newValue,oldValue){
				dtCdacd_fecha_fin.setMinValue(newValue);
				//dtCdacd_fecha_fin.setValue(newValue);				
			},
			select:function(obj,value){
				dtCdacd_fecha_fin.setMinValue(value);
				//dtCdacd_fecha_fin.setValue(value);				
			}
		}
        //maxValue:new Date()
    });
    /**
     * Ext.form.DateField FECHA DE CULMINACION DEL CICLO
     */
    var dtCdacd_fecha_fin = new Ext.form.DateField({
        id:'dtCdacd_fecha_fin',
        name:'dtCdacd_fecha_fin',
        fieldLabel :'Fecha fin',
		allowBlank:false,
		value : new Date()
        //minValue:new Date()	
		//minValue:dtCdacd_fecha_inicio.getValue()
    });
    /**
     * Ext.form.TextField INFORMACION ADICIONAL
     */
    var txtCdacd_observacion = new Ext.form.TextArea({
        id:'txtCdacd_observacion',
        name:'txtCdacd_observacion',
        fieldLabel :'Observaci\u00f3n',
        anchor:'98%'
    });
    /**
     * Ext.form.NumberField CAMPO QUE INDICA SI EL SEGUIMIENTO ACADEMICO FUE APROBADO VALORES:
     0 - NO APROBADO
     1 - APROBADO
     2 - OTROS
     */
    /*var numCdacd_estado_aprobacion = new Ext.form.NumberField({
     id:'numCdacd_estado_aprobacion',
     nname:'numCdacd_estado_aprobacion',
     fieldLabel :'Estado aprobacion',allowBlank :false,disabled :false});*/
    //Creamos una definici?n de los campos que vienen en el Json remoto DEL ESTADO DE APROBACION DEl CICLO ACADEMICO
    var cbxTipoAprobacionCiclo = new Ext.form.ComboBox({
        id:'cbxTipoAprobacionCiclo',
        name:'cbxTipoAprobacionCiclo',
        store: dsTipoAprobacionCiclo,
        anchor:'75%',
        displayField: 'Ciclo_Aprobado',
        fieldLabel :'Estado ciclo',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        editable: false,
        triggerAction:'all',
        emptyText : 'Seleccione',
        valueField:'id_tipo_aprobacion_ciclo'

    });
    cbxTipoAprobacionCiclo.setVisible(false);
    ////controles para el grid de los adjuntos///////

    /**
     * Ext.form.DateField FECHA DE CULMINACION DEL CICLO
     */
    var dtCdsad_fecha_ingreso = new Ext.form.DateField({
        id:'dtCdsad_fecha_ingreso',
        name:'dtCdsad_fecha_ingreso',
        fieldLabel :'Fecha ingreso',
        value:new Date()
    });
    /**
     * Ext.form.TextArea CAMPO DE TEXTO DE OBSERVACION DEL DOCUMENTO
     */
    var txtCdsad_observacion = new Ext.form.TextField({
        id:'txtCdsad_observacion',
        name:'txtCdsad_observacion',
        fieldLabel :'Observaci\u00f3n',
        width:'90%'
    });
    /**
     * Ext.form.DateField FECHA DE ingreso del certificado
     */
    var dtCdsad_fecha_ingreso_certificado = new Ext.form.DateField({
        id:'dtCdsad_fecha_ingreso_certificado',
        name:'dtCdsad_fecha_ingreso_certificado',
        fieldLabel :'Fecha ingreso',
        value:new Date()
    });
    /**
     * Ext.form.TextArea CAMPO DE TEXTO DE OBSERVACION DEL DOCUMENTO ADJUNTO DE CERTIFICADO
     */
    var txtCdsad_observacion_certificado = new Ext.form.TextField({
        id:'txtCdsad_observacion_certificado',
        name:'txtCdsad_observacion_certificado',
        fieldLabel :'Observaci\u00f3n',
        width:'90%'
    });
    //////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_adjunto.
     */
    var cmCgg_dhu_sadjunto = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
        {
            dataIndex:'CDSAD_CODIGO',
            width:40,
            hidden:true,
            hideable:false
        },
        {
            dataIndex:'CDACD_CODIGO',
            header:'Seguimiento',
            width:40,
            sortable:true,
            hidden:true
        },{
            dataIndex:'CDSAD_FECHA_REGISTRO',
            header:'Fecha ingreso',
            width:150,
            sortable:true,editor:dtCdsad_fecha_ingreso,renderer:truncDate

        },{
            dataIndex:'CDSAD_NOMBRE_ADJUNTO',
            header:'Nombre Adjunto',
            width:150,
            sortable:true

        },
        {
            dataIndex:'CDSAD_OBSERVACION',
            header:'Observaci\u00f3n',
            width:300,
            sortable:true,editor:txtCdsad_observacion
        }, {dataIndex:'CRATE_DATA',header:'CRATE_DATA',width:150,sortable:true,hidden:true,hideable:true}
    ]);

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_adjunto por un campo especifico.
     */
    var gsCgg_dhu_sadjunto = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS + "Cgg_dhu_sadjunto",
            method:"selectSeguimientoAdjunto"
        }),
        reader:new Ext.data.JsonReader({}, [
            {name:'CDSAD_CODIGO'},
            {name:'CDACD_CODIGO'},
            {name:'CDSAD_FECHA_REGISTRO'},
            {name:'CDSAD_NOMBRE_ADJUNTO'},
            //{name:'CDSAD_ADJUNTO'},
			{name:'CDSAD_OBSERVACION'}
        ]),
        baseParams:{
            inCdacd_codigo:'',
            format:"JSON"
        }
    });


    /*
     * Ext.ux.grid.RowEditor Edito de filas personalizado para utilizaci?n en el grid de adjunto beca
     */
    var reAdjuntoSeguiAcademico = new Ext.ux.grid.RowEditor({
        saveText: 'Aceptar',
        cancelText:'Cancelar'
    });
    reAdjuntoSeguiAcademico.stopMonitoring();
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_gem_perfil_prof en un formato tabular de filas y columnas.
     */
    var grdCgg_dhu_sadjunto = new Ext.grid.GridPanel({
        cm:cmCgg_dhu_sadjunto,
        store: gsCgg_dhu_sadjunto,
        region:'center',
        anchor:'100% 100%',
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
                var objSAdjunto = new FrmCgg_res_adjunto_temporal();
                var rAdjuntoTemporal = grdCgg_dhu_sadjunto.getSelectionModel().getSelected();
                objSAdjunto.closeHandler(function(){
                    var dialogResult = objSAdjunto.dialogResult();
                    if(dialogResult  !== null){						
                        var tmpRecordAjunto = grdCgg_dhu_sadjunto.getStore().recordType;
                        reAdjuntoSeguiAcademico.stopEditing();
                        grdCgg_dhu_sadjunto.getStore().insert(0,
                                new tmpRecordAjunto({
                                    'CDSAD_CODIGO':'KEYGEN',
                                    'CDACD_CODIGO':'',
                                    'CDSAD_FECHA_REGISTRO':'',
                                    'CDSAD_NOMBRE_ADJUNTO':dialogResult.CRATE_NOMBRE,
                                    'CDSAD_ADJUNTO':'',
                                    'CDSAD_OBSERVACION':'',
                                    'CRATE_DATA':dialogResult.CRATE_CODIGO
                                })
						);
                        grdCgg_dhu_sadjunto.getView().refresh();
                        grdCgg_dhu_sadjunto.getSelectionModel().selectRow(0);
                        reAdjuntoSeguiAcademico.startEditing(0);
						dtCdsad_fecha_ingreso.setValue(new Date());
						txtCdsad_observacion.focus(true);
                    }
                });
                objSAdjunto.show();
            }
        }, {
            id: 'btnEliminarAdjunto',
            iconCls: 'iconEliminar',
            handler: function(grid, rowIndex, colIndex) {
                grdCgg_dhu_sadjunto.getSelectionModel().selectRow(rowIndex);
                var rSadjunto= grdCgg_dhu_sadjunto.getSelectionModel().getSelected();
                EliSadjunto.push(rSadjunto.get('CDAD_CODIGO'));
                tmpListadoEliminarAdjunto = Ext.util.JSON.encode(EliSadjunto);
                grdCgg_dhu_sadjunto.getStore().remove(rSadjunto);
            }

        },{
            id:'btnVerAdjuntoSeguimiento',
            iconCls:'iconVer',
            listeners:{
                click:function(){
                    var r=grdCgg_dhu_sadjunto.getSelectionModel().getSelected();
                    if(r){                        
						if(r.get('CRATE_DATA')){
							window.open(URL_DOC_VIEWER+'?table=cgg_res_adjunto_temporal&keyc=crate_codigo&keyv='+r.get('CRATE_DATA')+'&column=crate_archivo&fn='+r.get('CDSAD_NOMBRE_ADJUNTO')+'&request=view');
						}else{
							window.open(URL_DOC_VIEWER+'?table=cgg_dhu_sadjunto&keyc=cdsad_codigo&keyv='+r.get('CDSAD_CODIGO')+'&column=cdsad_adjunto&fn='+r.get('CDSAD_NOMBRE_ADJUNTO')+'&request=view');
						}
					}
                }
            }

        },{id:'btnDescargarAdjuntoAcuerdo',
            iconCls:'iconDescargar',
            listeners:{
                click:function(){
                    var r=grdCgg_dhu_sadjunto.getSelectionModel().getSelected();
                    if(r){                        
						if(r.get('CRATE_DATA')){
							window.open(URL_DOC_VIEWER+'?table=cgg_res_adjunto_temporal&keyc=crate_codigo&keyv='+r.get('CRATE_DATA')+'&column=crate_archivo&fn='+r.get('CDSAD_NOMBRE_ADJUNTO')+'&request=download');
						}else{
							window.open(URL_DOC_VIEWER+'?table=cgg_dhu_sadjunto&keyc=cdsad_codigo&keyv='+r.get('CDSAD_CODIGO')+'&column=cdsad_adjunto&fn='+r.get('CDSAD_NOMBRE_ADJUNTO')+'&request=download');
						}
					}
					
                }
            }
        }] ,plugins:[reAdjuntoSeguiAcademico]
    });



    var ccCDBCR_OBLIGATORIO = new Ext.grid.CheckColumn({
        dataIndex: 'CDBCR_OBLIGATORIO',
        header: 'Obligatorio',
        width: 90
    });
    /*
     Seccion que permite seleccionar los tipos de actividades a realizar en el resgitro
     */
    var smCertificado = new Ext.grid.CheckboxSelectionModel();

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_beca_certificado.
     */
    var cmCgg_dhu_certificado_beca = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
        smCertificado,
		{dataIndex: 'CDTBC_CODIGO',header: 'Codigo',width: 150,sortable: true,hidden: true,hideable: false}, 
		{dataIndex:'CDSAD_CODIGO',width:40,hidden:true,hideable:false}, 
		{dataIndex: 'CDBCR_CODIGO',header: 'Codigo',width: 150,sortable: true,hidden: true,hideable: false}, 
		{
            dataIndex: 'CDTCA_NOMBRE',
            header: 'Certificado',
            width: 120,
            sortable: true

        }, ccCDBCR_OBLIGATORIO
        ,{
            dataIndex:'CDSAD_FECHA_REGISTRO',
            header:'Fecha ingreso',
            width:150,
            sortable:true,editor:dtCdsad_fecha_ingreso_certificado,renderer:truncDate

        },{
            dataIndex:'CDSAD_NOMBRE_ADJUNTO',
            header:'Nombre Adjunto',
            width:150,
            sortable:true
        },
        /*{
            dataIndex:'CDSAD_OBSERVACION',
            header:'Observaci\u00f3n',
            width:300,
            sortable:true,editor:txtCdsad_observacion_certificado
        }, */
		{dataIndex:'CRATE_DATA',header:'CRATE_DATA',width:150,sortable:true,hidden:true,hideable:true},
        {
            xtype: 'actioncolumn',
            width: 80,
            header:'Adjunto',
            id:'cdsad_data',
            items:[{
                iconCls: 'iconAdjunto',                // Use a URL in the icon config
                tooltip: 'Subir adjunto',
                handler:function(grid, rowIndex) {					
					grdCgg_dhu_certificado_beca.getSelectionModel().selectRow(rowIndex);
					var objSAdjunto = new FrmCgg_res_adjunto_temporal();
					var rAdjuntoTemporal = grdCgg_dhu_certificado_beca.getSelectionModel().getSelected();
					objSAdjunto.closeHandler(function(){
						var dialogResult = objSAdjunto.dialogResult();
						if(dialogResult  !== null){													
							
							rAdjuntoTemporal.set('CRATE_DATA',dialogResult.CRATE_CODIGO);
                            rAdjuntoTemporal.set('CDSAD_NOMBRE_ADJUNTO',dialogResult.CRATE_NOMBRE);
                            rAdjuntoTemporal.set( 'CDSAD_CODIGO','KEYGEN');
							rAdjuntoTemporal.set('CDSAD_FECHA_REGISTRO',new Date());
                            rAdjuntoTemporal.commit();                            
                            grdCgg_dhu_certificado_beca.getSelectionModel().selectRow(rowIndex);
							grdCgg_dhu_certificado_beca.getView().refresh();														
						}
					});
					objSAdjunto.show();
                }
            },
                /*{
                    iconCls: 'iconEliminar',                // Use a URL in the icon config
                    tooltip: 'Eliminar adjunto',
                    handler: function(grid, rowIndex, colIndex) {
                        
                        var rSadjunto= grdCgg_dhu_certificado_beca.getSelectionModel().getSelected();
                        EliSadjunto.push(rSadjunto.get('CDSAD_CODIGO'));
                        tmpListadoEliminarAdjunto = Ext.util.JSON.encode(EliSadjunto);
                        
                        grdCgg_dhu_certificado_beca.getStore().remove(rSadjunto);
                    }
                },*/
                {
                    iconCls: 'iconBuscar',                // Use a URL in the icon config
                    tooltip: 'Ver adjunto',					
                    handler: function(grid, rowIndex, colIndex) {						
						grdCgg_dhu_certificado_beca.getSelectionModel().selectRow(rowIndex);
						var r = grdCgg_dhu_certificado_beca.getSelectionModel().getSelected();
						if(r){                        
							if(r.get('CRATE_DATA')){
								window.open(URL_DOC_VIEWER+'?table=cgg_res_adjunto_temporal&keyc=crate_codigo&keyv='+r.get('CRATE_DATA')+'&column=crate_archivo&fn='+r.get('CDSAD_NOMBRE_ADJUNTO')+'&request=view');
							}else{
								window.open(URL_DOC_VIEWER+'?table=cgg_dhu_sadjunto&keyc=cdsad_codigo&keyv='+r.get('CDSAD_CODIGO')+'&column=cdsad_adjunto&fn='+r.get('CDSAD_NOMBRE_ADJUNTO')+'&request=view');
							}
						}
						
                    }
                }
            ]
        }]);

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_beca_certificado por un campo especifico.
     */
    var gsCgg_dhu_certificado_beca = new Ext.data.Store({
        proxy: new Ext.ux.bsx.SoapProxy({
            url: URL_WS + "Cgg_dhu_seguimiento_academico",
            method: "selectCertificadoAdjunto"
        }),
        reader: new Ext.data.JsonReader({}, [
            { name: 'CDTBC_CODIGO'},
            { name: 'CDBCR_CODIGO'},
            { name: 'CDTCA_CODIGO' },
            { name: 'CDTCA_NOMBRE'},
            {name: 'CDBCR_OBLIGATORIO'},
            {name: 'CDSAD_CODIGO'},
            {name:'CDSAD_FECHA_REGISTRO'},
            {name:'CDSAD_NOMBRE_ADJUNTO'},
            {name:'CDSAD_ADJUNTO'},
            {name:'CDSAD_OBSERVACION'}

        ]),       
        baseParams: {
            in_Cdbec_codigo:"",
            in_Cdacd_codigo:"",
            format:"JSON"
        }
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_seguimiento_requisito en un formato tabular de filas y columnas.
     */
    var grdCgg_dhu_certificado_beca = new Ext.grid.EditorGridPanel({
        store: gsCgg_dhu_certificado_beca,
        cm: cmCgg_dhu_certificado_beca,
        region: 'center',
			
        sm:smCertificado,

        loadMask: {
            msg: "Cargando..."
        }

    });

    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_dhu_seguimiento_academico
     */
    var btnGuardarCgg_dhu_seguimiento_academico = new Ext.Button({
        id:'btnGuardarCgg_dhu_seguimiento_academico',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:TypeTooltip.GUARDAR,
        listeners:{
            click:function(){
                if (pnlCgg_dhu_seguimiento_academico.getForm().isValid()==false){
                    return;
                }
                var tmp1;
                if (cbxTipoAprobacionCiclo.getValue()) {
                    tmp1=cbxTipoAprobacionCiclo.getValue();
                }else {
                    tmp1 = 1;

                }
                try{
                    function CallBackCgg_dhu_seguimiento_academico(r){
                        winFrmCgg_dhu_seguimiento_academico.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_dhu_seguimiento_academico,
                                msg: 'La informaci\u00f3n de seguimiento acad\u00E9mico ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_dhu_seguimiento_academico.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_dhu_seguimiento_academico,
                                msg: 'La informaci\u00f3n de seguimiento acad\u00E9mico no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }  if (r=='true' && numCdbec_ciclo.getValue()==1) {
                                Ext.Msg.show({
                                title:tituloCgg_dhu_seguimiento_academico,
                                msg: 'La beca empieza un proceso de seguimiento hasta que culmine la carrera.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                }
                    }
                    winFrmCgg_dhu_seguimiento_academico.getEl().mask('Guardando...', 'x-mask-loading');
                    if(EliSadjunto.length<=0){
                        tmpListadoEliminarAdjunto= '[]';
                    }
                    var param = new SOAPClientParameters();


                    if(isEdit){
                        param.add('inEliminarAjunto',tmpListadoEliminarAdjunto);
                        param.add('inCdacd_codigo',txtCdacd_codigo.getValue());

                    }
                    param.add('inCdbec_codigo',txtCdbec_codigo.getValue());
                    param.add('inCdacd_numero_ciclo',numCdbec_ciclo.getValue());
                    param.add('inCdacd_fecha_inicio',dtCdacd_fecha_inicio.getValue().format('c'));
                    param.add('inCdacd_fecha_fin',dtCdacd_fecha_fin.getValue().format('c'));
                    param.add('inCdacd_observacion',txtCdacd_observacion.getValue());
                    param.add('inCdacd_estado_aprobacion',tmp1);
                    param.add('inAdjuntoSeguimiento_JSON',grdCgg_dhu_sadjunto.getStore().getJsonData());
                    param.add('inAdjuntoCertificado_JSON',grdCgg_dhu_certificado_beca.getStore().getJsonData());//createJSONObject(smCertificado.getSelections()));
                    SOAPClient.invoke(urlCgg_dhu_seguimiento_academico,INSENTENCIA_CGG_DHU_SEGUIMIENTO_ACADEMICO,param, true, CallBackCgg_dhu_seguimiento_academico);
                }catch(inErr){
                    winFrmCgg_dhu_seguimiento_academico.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_dhu_seguimiento_academico.
     */
    var btnCancelarCgg_dhu_seguimiento_academico = new Ext.Button({
        id:'btnCancelarCgg_dhu_seguimiento_academico',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:TypeTooltip.CANCELAR,
        listeners:{
            click:function(){
                pnlCgg_dhu_seguimiento_academico.getForm().reset();

            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_dhu_seguimiento_academico.
     */
    var btnCerrarCgg_dhu_seguimiento_academico = new Ext.Button({
        id:'btnCerrarCgg_dhu_seguimiento_academico',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:TypeTooltip.CERRAR,
        listeners:{
            click:function(){
                winFrmCgg_dhu_seguimiento_academico.close();
            }}
    });

    /**
     * Ext.Panel Panel que contiene los datos informativos de persona y beca
     */
    var pnlCgg_res_beca_persona = new Ext.form.FieldSet({
        id:'pnlCgg_res_beca_persona',
        title:'Convenio',
        collapsible:true,
        // height:137,
        layout:'form',
        //region:'north',
        items:[{
			xtype:'panel',
			id :'pnlCgg_res_beca_persona1',
			data:datosPersonaBecaSeguimiento,
			tlp:tmpInfoPersonaBecaSeguimiento
		}]
	});
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles del registro del seguimiento academico
     */
    var pnlCgg_res_beca_seguimiento_academico = new Ext.Panel({
        id:'pnlCgg_res_beca_seguimiento_academico',
        title:'Registro seguimiento acad\u00E9mico',
        layout:'form',		
        frame:true,		
        items:[
            {xtype:'panel',layout:'column',
                items:[
                    {columnWidth:.50,layout:'form',labelWidth :100,
                        items:[numCdbec_ciclo]},
                    {columnWidth:.50,layout:'form',
                        items:[cbxTipoAprobacionCiclo]}
                ]}, {xtype:'panel',layout:'column',
                items:[
                    {columnWidth:.50,layout:'form',labelWidth :100,
                        items:[dtCdacd_fecha_inicio]},
                    {columnWidth:.50,layout:'form',
                        items:[dtCdacd_fecha_fin]}
                ]},
            txtCdacd_observacion
        ]


    });
    /**
     * Ext.form.Panel  que contiene los controles de los addjuntos de un seguimiento academico
     */
    var pnlCgg_dhu_adjunto_seguimiento_beca = new Ext.Panel({
        id:'pnlCgg_dhu_adjunto_seguimiento_beca',
        title:'Adjunto Documento',
        layout:'border',
        // height:160,
        items:[grdCgg_dhu_sadjunto]
    });
    /**
     * Ext.form.Panel  que contiene los controles de los addjuntos de un seguimiento academico
     */
    var pnlCgg_dhu_certificado_adjunto = new Ext.Panel({
        id:'pnlCgg_dhu_certificado_adjunto',
        title:'Certificados',
        layout:'border',
        // height:160,
        items:[grdCgg_dhu_certificado_beca]
    });
    /**
     * Ext.form.TabPanel  que contiene los controles de la ventana winFrmCgg_dhu_beca.
     */
    var tabBecaSeguimientoAcademico = new Ext.TabPanel({        
        activeTab:0,
        frame:true,
		region : 'center',		
		anchor:"100%",
        height:180,
        items:[pnlCgg_res_beca_seguimiento_academico,pnlCgg_dhu_certificado_adjunto,pnlCgg_dhu_adjunto_seguimiento_beca]
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_dhu_seguimiento_academico.
     */
    var pnlCgg_dhu_seguimiento_academico = new Ext.form.FormPanel({
        id:'pnlCgg_dhu_seguimiento_academico',
        frame : true,
		region : 'center',
        labelWidth :100,
		autoHeight : true,
        items:[
			{
				xtype:'panel',layout:'column',
				items:[{columnWidth:.6,layout:'form',
						items:[txtCdbec_seguimiento]
						},
						{columnWidth:.4,layout:'form',
							items:[btnCdbec_codigoCgg_dhu_seguimiento_academico]
						}
				]
			},pnlCgg_res_beca_persona,
			tabBecaSeguimientoAcademico			
		]
    });
    function NumeroCiclo(){
        function CallBackCgg_dhu_numero_ciclo(r){
			tmpnumerociclo = Ext.util.JSON.decode(r)[0];
			if(tmpnumerociclo!=null){
				
				if(tmpnumerociclo.NUM_SEGUIMIENTOS>0){					
					valor = false;
					//return;
				}
				if (tmpnumerociclo.CDACD_NUMERO_CICLO){						
					numCdbec_ciclo1.setValue(tmpnumerociclo.CDACD_NUMERO_CICLO);
					tmpSigNumero=Math.round(((numCdbec_ciclo1.getValue())+1))
				}else{
					tmpSigNumero=1;
				}
				

			}
			if (valor==true){/*else{
				   tmpSigNumero=1;
				}*/
			   numCdbec_ciclo.setValue(tmpSigNumero)
			   numCdbec_ciclo.disable();					
			}
			
		}
		
		var param = new SOAPClientParameters();
		param.add('in_cdbec_codigo',txtCdbec_codigo.getValue());
		param.add('format',TypeFormat.JSON);
		var r = SOAPClient.invoke(URL_WS+"Cgg_dhu_seguimiento_academico","selectNumeroCiclo",param, false,null);
		tmpnumerociclo = Ext.util.JSON.decode(r)[0];
		if(tmpnumerociclo!=null){
			
			if(tmpnumerociclo.NUM_SEGUIMIENTOS>0){					
				valor = false;
				//return;
			}
			if (tmpnumerociclo.CDACD_NUMERO_CICLO){						
				numCdbec_ciclo1.setValue(tmpnumerociclo.CDACD_NUMERO_CICLO);
				tmpSigNumero=Math.round(((numCdbec_ciclo1.getValue())+1))
			}else{
				tmpSigNumero=1;
			}
			

		}
		if (valor==true){/*else{
			   tmpSigNumero=1;
			}*/
		   numCdbec_ciclo.setValue(tmpSigNumero)
		   numCdbec_ciclo.disable();					
		}
		return valor;
    }

    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_dhu_seguimiento_academico.
     */

        var winFrmCgg_dhu_seguimiento_academico = new Ext.Window ({
        id:'winFrmCgg_dhu_seguimiento_academico',
        title:tituloCgg_dhu_seguimiento_academico,
        tbar:getPanelTitulo(tituloCgg_dhu_seguimiento_academico,descCgg_dhu_seguimiento_academico),
        items:[pnlCgg_dhu_seguimiento_academico],
        width:600,
        minWidth:600,
        maximizable:false,
        minimizable:false,		
		height : 500,
		//layout : 'border',		
		modal:true,	
		autoHeight: true,
		resizable:false,
        constrain:true,
        bbar:[btnGuardarCgg_dhu_seguimiento_academico,btnCancelarCgg_dhu_seguimiento_academico,'->',btnCerrarCgg_dhu_seguimiento_academico],
        listeners:{
            show:function(){
                if(isEdit){
                    if(INRECORD_CGG_DHU_SEGUIMIENTO_ACADEMICO)
                    {
                        txtCdbec_seguimiento.setVisible(false);
                        btnCdbec_codigoCgg_dhu_seguimiento_academico.setVisible(false);
                        /*tmpInfoPersonaSeguimientoEdit*/tmpInfoPersonaBecaSeguimiento.overwrite( Ext.getCmp('pnlCgg_res_beca_persona1').body,inRecordCgg_dhu_seguimiento_academico.json);

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
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_dhu_seguimiento_academico.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_dhu_seguimiento_academicoCtrls(inEstado){
        estado=!inEstado;
        txtCdbec_codigo.setDisabled(estado);
        txtCdacd_codigo.setDisabled(estado);
        numCdbec_ciclo.setDisabled(estado);
        dtCdacd_fecha_inicio.setDisabled(estado);
        dtCdacd_fecha_fin.setDisabled(estado);
        txtCdacd_observacion.setDisabled(estado);
        cbxTipoAprobacionCiclo.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_dhu_seguimiento_academico.
     */
    function cargarCgg_dhu_seguimiento_academicoCtrls(){
        if(inRecordCgg_dhu_seguimiento_academico){
			txtCdbec_seguimiento.allowBlank=true,
            txtCdbec_codigo.setValue(inRecordCgg_dhu_seguimiento_academico.get('CDBEC_CODIGO'));
            txtCdacd_codigo.setValue(inRecordCgg_dhu_seguimiento_academico.get('CDACD_CODIGO'));
            txtCdtbc_codigo.setValue(inRecordCgg_dhu_seguimiento_academico.get('CDTBC_CODIGO'));
            numCdbec_ciclo.setValue(inRecordCgg_dhu_seguimiento_academico.get('CDACD_NUMERO_CICLO'));
            dtCdacd_fecha_inicio.setValue(truncDate(inRecordCgg_dhu_seguimiento_academico.get('CDACD_FECHA_INICIO')));
            dtCdacd_fecha_fin.setValue(truncDate(inRecordCgg_dhu_seguimiento_academico.get('CDACD_FECHA_FIN')));
            txtCdacd_observacion.setValue(inRecordCgg_dhu_seguimiento_academico.get('CDACD_OBSERVACION'));
            cbxTipoAprobacionCiclo.setValue(inRecordCgg_dhu_seguimiento_academico.get('CDACD_ESTADO_APROBACION'));
            gsCgg_dhu_sadjunto.reload({
                params:{
                    inCdacd_codigo:txtCdacd_codigo.getValue(),
                    format:TypeFormat.JSON
                }
            });
            gsCgg_dhu_certificado_beca.reload({
                params:{
                    in_Cdbec_codigo:txtCdbec_codigo.getValue(),
                    in_Cdacd_codigo:txtCdacd_codigo.getValue(),
                    format:TypeFormat.JSON
                }
            });
            isEdit = true;
            habilitarCgg_dhu_seguimiento_academicoCtrls(true);
            cbxTipoAprobacionCiclo.setVisible(true);
        }
	}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_dhu_seguimiento_academico.
     * @returns ventana winFrmCgg_dhu_seguimiento_academico.
     * @base FrmCgg_dhu_seguimiento_academico.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_dhu_seguimiento_academico;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_dhu_seguimiento_academico.
     * @base FrmCgg_dhu_seguimiento_academico.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_dhu_seguimiento_academicoCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_dhu_seguimiento_academico desde una instancia.
 */
FrmCgg_dhu_seguimiento_academico.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_dhu_seguimiento_academico desde una instancia.
 */
FrmCgg_dhu_seguimiento_academico.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_dhu_seguimiento_academico,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_dhu_seguimiento_academico.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_dhu_seguimiento_academico desde una instancia.
 */
FrmCgg_dhu_seguimiento_academico.prototype.loadData = function(){
    this.loadData();
}
