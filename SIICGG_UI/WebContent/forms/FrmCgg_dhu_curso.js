/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_dhu_curso.
 * @param {String} IN_SENTENCIA_CGG_DHU_CURSO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_DHU_CURSO Registro de datos de la tabla Cgg_dhu_curso.
 * @constructor
 * @base FrmListadoCgg_dhu_curso
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_dhu_curso(IN_SENTENCIA_CGG_DHU_CURSO,IN_RECORD_CGG_DHU_CURSO){
    var inSentenciaCgg_dhu_curso = IN_SENTENCIA_CGG_DHU_CURSO;
    var inRecordCgg_dhu_curso=IN_RECORD_CGG_DHU_CURSO;
    var urlCgg_dhu_curso=URL_WS+"Cgg_dhu_curso";
    var tituloCgg_dhu_curso='Curso';
    var descCgg_dhu_curso='El formulario permite administrar la informaci\u00f3n del registro de los cursos';
    var isEdit = false;
    var tmpValorFinanciado;
    var tmpFechaInicio;
    var tmpFechaFin;
    var tmpValorAsistente;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CURSO
     */
    var txtCdcur_codigo = new Ext.form.TextField({
        id:'txtCdcur_codigo',
        name:'txtCdcur_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
	
	
	var SCGG_DHU_TIPO_CURSO1 = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_tipo_curso",
            method:"selectAll",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
        },[
            {name:'CDTCR_CODIGO'},
            {name:'CDTCR_NOMBRE'}
        ]),
        baseParams:{format:TypeFormat.JSON},
        listeners:{
            load:function()
            {
                if(IN_RECORD_CGG_DHU_CURSO)
                {
                    cbxTipo_curso1.setValue(inRecordCgg_dhu_curso.get('CDTCR_CODIGO'));

                }
            }
        }
    });
	
	SCGG_DHU_TIPO_CURSO1.load();
	
    var cbxTipo_curso11111 = new Ext.form.ComboBox({
        store:SCGG_DHU_TIPO_CURSO1,
        id:'cbxTipo_curso11111',
        name:'cbxTipo_curso11111',
        displayField: "CDTCR_NOMBRE",
        fieldLabel :'Tipo curso',
        valueField: 'CDTCR_CODIGO',
        mode:'local',
        typeAhead:true,
        autoSelect:true,
        hiddenId:'cbxTipo_curso1H',
        hiddenName:'cbxTipo_curso1H',
        hiddenValue:'id',
        forceSelection:true,
        editable: true,
        triggerAction:'all',
        submitValue:true,
        anchor:'98%',
        emptyText : 'Seleccione una opci\u00f3n..'

    });
	var cbxTipo_curso1 = new Ext.form.ComboBox({
        id:'cbxTipo_curso1',
        name:'cbxTipo_curso1',
        fieldLabel :'Tipo Curso',
        anchor:'90%',
        store: SCGG_DHU_TIPO_CURSO1,
        displayField:'CDTCR_NOMBRE',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        allowBlank:false,
        emptyText:'Seleccione un tipo...',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CDTCR_NOMBRE}" class="x-combo-list-item">{CDTCR_NOMBRE}</div></tpl>',
        valueField:'CDTCR_CODIGO'
    });
    //Creamos una definici?n de los campos que vienen en el Json remoto

    var cbxCanton_curso = new Ext.form.ComboBox({
        store:SCGG_CANTON,
        id:'cbxCanton_curso',
        name:'cbxCanton_curso',
        displayField: "CCTN_NOMBRE",
        fieldLabel :'Cant\u00f3n',
        valueField: 'CCTN_CODIGO',
        mode:'local',
        typeAhead:true,
        autoSelect:true,
        hiddenId:'cbxCanton_cursoH',
        hiddenName:'cbxCanton_cursoH',
        hiddenValue:'id',
        forceSelection:true,
        editable: true,
        triggerAction:'all',
        submitValue:true,
        anchor:'98%',
        emptyText : 'Seleccione una opci\u00f3n..',
		allowBlank :false
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO SECTOR PRODUCTIVO
     */
    var txtCsctp_codigo = new Ext.form.TextField({
        id:'txtCsctp_codigo',
        name:'txtCsctp_codigo',
        fieldLabel :'Codigo',
        anchor:'98%'
    });
    /**
     * Ext.form.TextField NOMBRE DE REGISTRO SECTOR PRODUCTIVO
     */
    var txtCsctp_descripcion = new Ext.form.TextField({
        id:'txtCsctp_descripcion',
        name:'txtCsctp_descripcion',
        fieldLabel :'Sec. productivo o social',
        allowBlank :false,
        anchor:'98%'
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO SECTOR PRODUCTIVO
     */
    var btnCsctp_codigoCgg_dhu_curso = new Ext.Button({
        id:'btnCsctp_codigoCgg_dhu_curso',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_sector_productivo = new FrmListadoCgg_sector_productivo();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_sector_productivo.getStore(),tmpFLCgg_sector_productivo.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        txtCsctp_codigo.setValue(tmpRecord.get('CSCTP_CODIGO'));
                        txtCsctp_descripcion.setValue(tmpRecord.get('CSCTP_NOMBRE'));
                    }
                });
                objBusqueda.show();
            }}
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION RESPONSABLE
     */
    var txtCditr_codigo = new Ext.form.TextField({
        id:'txtCditr_codigo',
        name:'txtCditr_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * Ext.form.TextField NOMBRE UNICO DE REGISTRO DE INSTITUCION RESPONSABLE
     */
    var txtCditr_nombre = new Ext.form.TextField({
        id:'txtCditr_nombre',
        name:'txtCditr_nombre',
        fieldLabel :'Ins.Responsable',
        anchor:'98%',
		allowBlank :false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION RESPONSABLE
     */
    var btnCditr_codigoCgg_dhu_curso = new Ext.Button({
        id:'btnCditr_codigoCgg_dhu_curso',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_dhu_institucion_responsable = new FrmListadoCgg_dhu_institucion_responsable();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_dhu_institucion_responsable.getStore(),tmpFLCgg_dhu_institucion_responsable.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        txtCditr_codigo.setValue(tmpRecord.get('CDITR_CODIGO'));
                        txtCditr_nombre.setValue(tmpRecord.get('CDITR_NOMBRE'));
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA INSTRUCTOR DEL CURSO
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
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA INSTRUCTOR DEL CURSO
     */
    var txtCrper_instructor = new Ext.form.TextField({
        id:'txtCrper_instructor',
        name:'txtCrper_instructor',
        fieldLabel :'Coordinador',
        anchor:'98%',
		allowBlank :false
    });
    /**
     * CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA INSTRUCTOR DEL CURSO
     */
    var btnCrper_codigoCgg_dhu_curso = new Ext.Button({
        id:'btnCrper_codigoCgg_dhu_curso',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_res_persona = new PersonaResidentePermanente();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona.getStore(),tmpFLCgg_res_persona.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        txtCrper_codigo.setValue(tmpRecord.get('CRPER_CODIGO'));
                        txtCrper_instructor.setValue(tmpRecord.get('CRPER_NOMBRES')+' '+tmpRecord.get('CRPER_APELLIDO_PATERNO')+' '+tmpRecord.get('CRPER_APELLIDO_MATERNO'));
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField DESCRIPCION DEL CURSO
     */
    var txtCdcur_descripcion = new Ext.form.TextField({
        id:'txtCdcur_descripcion',
        name:'txtCdcur_descripcion',
        fieldLabel :'Curso',
        allowBlank :false,
        anchor:'98%'
    });
    /**
     * Ext.form.DateField FECHA DE INICIO DEL CURSO
     */
    var dtCdcur_fecha_prevista_inicio = new Ext.form.DateField({
        id:'dtCdcur_fecha_prevista_inicio',
        name:'dtCdcur_fecha_prevista_inicio',
        fieldLabel :'F.prevista inicio',
        format :'d/m/Y',
        value:new Date(),
		listeners:{
            change:function(obj,newValue,oldValue){
                dtCdcur_fecha_prevista_culminacio.setMinValue(newValue);
                //dtCdcur_fecha_prevista_culminacio.setValue(newValue);
				dtCdcur_fecha_inicio.setMinValue(newValue);
				dtCdcur_fecha_culminacion.setMinValue(newValue);
            },
            select:function(obj,value){
                dtCdcur_fecha_prevista_culminacio.setMinValue(value);
                //dtCdcur_fecha_prevista_culminacio.setValue(value);				
				dtCdcur_fecha_inicio.setMinValue(value);
				dtCdcur_fecha_culminacion.setMinValue(value);
            }
        }
    });
    /**
     * Ext.form.DateField FECHA DE INICIO DEL CURSO
     */
    var dtCdcur_fecha_inicio = new Ext.form.DateField({
        id:'dtCdcur_fecha_inicio',
        name:'dtCdcur_fecha_inicio',
        fieldLabel :'Fecha inicio',
        format :'d/m/Y',
        value:new Date(),
        submitValue:false,
		listeners:{
            change:function(obj,newValue,oldValue){
                dtCdcur_fecha_culminacion.setMinValue(newValue);
                //dtCdcur_fecha_culminacion.setValue(newValue);				
            },
            select:function(obj,value){
                dtCdcur_fecha_culminacion.setMinValue(value);
                //dtCdcur_fecha_culminacion.setValue(value);				
            }
        }
    });
    dtCdcur_fecha_inicio.disable();
    /**
     * Ext.form.DateField FECHA DE FINALIZACION DEL CURSO
     */
    var dtCdcur_fecha_culminacion = new Ext.form.DateField({
        id:'dtCdcur_fecha_culminacion',
        name:'dtCdcur_fecha_culminacion',
        fieldLabel :'Fec.culminaci\u00f3n',
        format :'d/m/Y',
        value:new Date(),
        submitValue:false
    });
    dtCdcur_fecha_culminacion.disable();
    /**
     * Ext.form.DateField FECHA DE FINALIZACION DEL CURSO
     */
    var dtCdcur_fecha_prevista_culminacio = new Ext.form.DateField({
        id:'dtCdcur_fecha_prevista_culminacio',
        name:'dtCdcur_fecha_prevista_culminacio',
        fieldLabel :'F.prevista culmin',
        format :'d/m/Y',
        value:new Date()
    });

    /**
     * Ext.form.TextField HORARIO DEL CURSO
     */
    var txtCdcur_horario= new Ext.form.TimeField({
        id:'txtCdcur_horario',
        name:'txtCdcur_horario',
        fieldLabel :'Horario',
        anchor:'98%',
        minValue: '8:00 AM',
        maxValue: '11:00 PM',
        increment: 15
    });
    var txtCdcur_horario1 =new Ext.form.TimeField({
        id:'txtCdcur_horario1',
        name:'txtCdcur_horario1',
        fieldLabel :'a',
        minValue: '8:00 AM',
        maxValue: '11:00 PM',
        increment: 15,
        anchor:'47%'
    });
    /**
     * Ext.form.NumberField NUMERO DE HORAS PEDAGOGICAS DE DURACION DEL CURSO
     */
    var numCdcur_numero_horas_pedagogicas = new Ext.ux.form.SpinnerField({
        id:'numCdcur_numero_horas_pedagogicas',
        name:'numCdcur_numero_horas_pedagogicas',
        fieldLabel :'H.pedagogicas',
        minValue: 0,
        maxValue: 1000,
        value: 0,
        anchor:'70%'
    });
    /**
     * Ext.form.NumberField NUMERO DE HORAS RELOJ DE DURACION
     */
    var numCdcur_numero_horas = new Ext.ux.form.SpinnerField({
        id:'numCdcur_numero_horas',
        name:'numCdcur_numero_horas',
        fieldLabel :'No. horas',
        minValue: 0,
        maxValue: 1000,
        value: 0,
        anchor:'70%',
		allowBlank :false
    });
    /**
     * Ext.form.NumberField MODULOS DEL CURSO
     */

    var numCdcur_numero_modulos = new Ext.ux.form.SpinnerField({
        id:'numCdcur_numero_modulos',
        name:'numCdcur_numero_modulos',
        fieldLabel :'No. m\u00f3dulo',
        anchor:'70%',
       
        value: 0,
		allowBlank :false,
		incrementValue: 1,
		
		minValue: 0,
		maxValue: 1000        
    });

    /**
     * Ext.form.TextArea CONTENIDO DEL CURSO
     */
    var txtCdcur_contenido = new Ext.form.TextArea({
        id:'txtCdcur_contenido',
        name:'txtCdcur_contenido',
        fieldLabel :'Contenido',
        width:'98%',
		allowBlank :false
    });
    /**
     * Ext.form.TextField NOMBRE DE LA INSTITUCION RESPONSABLE DEL CURSO
     */
    var txtCdcur_institucion = new Ext.form.TextField({
        id:'txtCdcur_institucion',
        name:'txtCdcur_institucion',
        fieldLabel :'Instituci\u00f3n',
        anchor:'98%',
		allowBlank :false
    });
    /**
     * Ext.form.TextField LUGAR DONDE SE REALIZA EL CURSO
     */
    var txtCdcur_establecimiento = new Ext.form.TextField({
        id:'txtCdcur_establecimiento',
        name:'txtCdcur_establecimiento',
        fieldLabel :'Local',
        anchor:'98%',
		allowBlank :false
    });

    /**
     * Ext.form.NumberField COSTO DEL CURSO
     */
    var numCdcur_costo = new Ext.form.NumberField({
        id:'numCdcur_costo',
        name:'numCdcur_costo',
        fieldLabel :'Costo',
		allowBlank :false,
		minValue : 1
    });
    /**
     * Ext.form.NumberField PORCENTAJE APORTADO POR EL CGG PARA EL CURSO
     */
    var numCdcur_porcentaje_financiado = new Ext.form.NumberField({
        id:'numCdcur_porcentaje_financiado',
        name:'numCdcur_porcentaje_financiado',
        fieldLabel :'Valor financiado',
		readOnly:true,
        listeners:{
            blur :function (inField){
                valorFinanciado();
            }
        }

    });

    /**
     * Ext.form.NumberField PORCENTAJE APORTADO POR EL CGG PARA EL CURSO
     */
    var numCdcur_porcentaje = new Ext.form.NumberField({
        id:'numCdcur_porcentaje',
        name:'numCdcur_porcentaje',
        fieldLabel :'Porcentaje',
        value:0,
		minValue:0,
		maxValue:100,
        listeners: {
            specialkey: function(field, e) {               
                if (e.getKey() == e.ENTER) {
                    valorFinanciado();
                    valorAsistente();
                }
            }
        },
		allowBlank :false

    });
    /**
     * Ext.form.TextField OBSERVACION DEL CURSO
     */
    var txtCdcur_observacion = new Ext.form.TextArea({
        id:'txtCdcur_observacion',
        name:'txtCdcur_observacion',
        fieldLabel :'Observaci\u00f3n',
        anchor:'98%'
    });
    /**
     * Ext.form.NumberField PORCENTAJE DE ACEPTACION DE LOS ASISTENTES RESPECTO AL CURSO
     */
    var numCdcur_valoracion = new Ext.form.NumberField({
        id:'numCdcur_valoracion',
        name:'numCdcur_valoracion',
		readOnly:true,
        fieldLabel :'Valor contraparte',
        listeners:{
            blur :function (inField){
                valorAsistente();
            }
        }
    });
    /**
     * Ext.form.NumberField NUMERO DE LOS ASISTENTES RESPECTO AL CURSO
     */
    var numCdcur_numero_asistente = new Ext.form.NumberField({
        id:'numCdcur_numero_asistente',
        name:'numCdcur_numero_asistente',
        fieldLabel :'No. asistente',
		allowBlank :false
    });
    /**
     * Ext.form.NumberField ESTADO PROPIOS DEL CURSO
     0 - REGISTRADO
     1 - PROCESO MATRICULA
     2 - INICIADO
     3 - FINALIZADO
     4 - SUSPENDIDO
     5 - CANCELADO
     */
    //Creamos una definici?n de los campos que vienen en el Json remoto

    var cbxEstado_curso = new Ext.form.ComboBox({
        id:'cbxEstado_curso',
        name:'cbxEstado_curso',
        store: dsEstadoCurso,
        fieldLabel :'Estado',
        displayField: 'estado_curso',
        valueField: 'id',
        mode:'local',
        typeAhead:true,
        autoSelect:true,
        hiddenId:'cbxEstado_cursoH',
        hiddenName:'cbxEstado_cursoH',
        hiddenValue:'id',
        forceSelection:true,
        editable: true,
        triggerAction:'all',
        submitValue:true,
        anchor:'98%',
        triggerAction:'all',
        emptyText : 'Seleccione una opci\u00f3n..',
         listeners:{
            select:function(){
                if(cbxEstado_curso.getValue()==TypeEstadoCurso.INICIADO){
                      Ext.Msg.show({
                            title:tituloCgg_dhu_curso,
                            msg: 'Registre la fecha de inicio del curso.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.INFO
                        });
                }
            }

        }


    });
    cbxEstado_curso.disable();
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_dhu_curso
     */
    var btnGuardarCgg_dhu_curso = new Ext.Button({
        id:'btnGuardarCgg_dhu_curso',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
				/*alert(txtCdcur_horario.getRawValue());
				return;*/
                if (pnlCgg_dhu_curso.getForm().isValid()==false){
					Ext.Msg.show({
						title:tituloCgg_dhu_curso,
						msg: 'Verifique que todos los datos hayan sido ingresado correctamente',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.INFO
					});
                    return;
                }
                tmpFechaInicio = isEdit && dtCdcur_fecha_inicio.getValue() ? dtCdcur_fecha_inicio.getValue().format('c') : null;
                tmpFechaFin = isEdit && dtCdcur_fecha_culminacion.getValue() ? dtCdcur_fecha_culminacion.getValue().format('c') : null;
                var tmpEstadoCurso;
                if (cbxEstado_curso.getValue()) {
                    tmpEstadoCurso=cbxEstado_curso.getValue();
                }else {
                    tmpEstadoCurso =TypeEstadoCurso.REGISTRADO;
                }
                if (cbxEstado_curso.getValue()=='REGISTRADO' ) {
                    tmpEstadoCurso=TypeEstadoCurso.REGISTRADO;
                }
              if (cbxEstado_curso.getValue()=='TERMINADO' ) {
                    tmpEstadoCurso=TypeEstadoCurso.TERMINADO;

                }if (cbxEstado_curso.getValue()=='FINALIZADO' ) {
                    tmpEstadoCurso=TypeEstadoCurso.FINALIZADO;
                }
				/**
				*	VERIFICAR DATOS
				**/
				
				//if (txtCdcur_horario.getRawValue()>txtCdcur_horario1.getRawValue()){
				if (txtCdcur_horario.selectedIndex>=txtCdcur_horario1.selectedIndex){
					Ext.Msg.show({
						title:tituloCgg_dhu_curso,
						msg: 'Verifique los datos de horario. </br>La hora de salida debe ser mayor a la de entrada',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.ERROR
					});
					return;
				}
				if (!numCdcur_porcentaje_financiado.getValue()){
					valorFinanciado();
					valorAsistente();
				}
				//*********************************************************
                try{
                    function CallBackCgg_dhu_curso(r){
                        winFrmCgg_dhu_curso.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_dhu_curso,
                                msg: 'La informaci\u00f3n del curso ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_dhu_curso.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_dhu_curso,
                                msg: 'La informaci\u00f3n del curso no ha podido ser almacenada. '+r,
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_dhu_curso.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCdcur_codigo',txtCdcur_codigo.getValue());
                    param.add('inCdtcr_codigo',cbxTipo_curso1.getValue());
                    param.add('inCctn_codigo',cbxCanton_curso.getValue());
                    param.add('inCsctp_codigo',txtCsctp_codigo.getValue());
                    param.add('inCditr_codigo',txtCditr_codigo.getValue());
                    param.add('inCrper_codigo',txtCrper_codigo.getValue());
                    param.add('inCdcur_descripcion',txtCdcur_descripcion.getValue());
                    param.add('inCdcur_fecha_prevista_inicio',dtCdcur_fecha_prevista_inicio.getValue().format('c'));
                    param.add('inCdcur_fecha_inicio',tmpFechaInicio);
                    param.add('inCdcur_fecha_culminacion',tmpFechaFin);
                    param.add('inCdcur_fecha_prevista_culminacion',dtCdcur_fecha_prevista_culminacio.getValue().format('c'));
                    param.add('inCdcur_horario',txtCdcur_horario.getValue());
                    param.add('inCdcur_horario1',txtCdcur_horario1.getValue());
                    param.add('inCdcur_numero_horas_pedagogicas',numCdcur_numero_horas_pedagogicas.getValue());
                    param.add('inCdcur_numero_horas',numCdcur_numero_horas.getValue());
                    param.add('inCdcur_numero_modulos',numCdcur_numero_modulos.getValue());
                    param.add('inCdcur_contenido',txtCdcur_contenido.getValue());
                    param.add('inCdcur_institucion',txtCdcur_institucion.getValue());
                    param.add('inCdcur_establecimiento',txtCdcur_establecimiento.getValue());
                    param.add('inCdcur_costo',numCdcur_costo.getValue());
                    param.add('inCdcur_porcentaje_financiado',numCdcur_porcentaje_financiado.getValue());
                    param.add('inCdcur_observacion',txtCdcur_observacion.getValue());
                    param.add('inCdcur_valoracion',numCdcur_valoracion.getValue());
                    param.add('inCdcur_numero_asistente',numCdcur_numero_asistente.getValue());
                    param.add('inCdcur_estado_curso',tmpEstadoCurso);
                    SOAPClient.invoke(urlCgg_dhu_curso,IN_SENTENCIA_CGG_DHU_CURSO,param, true, CallBackCgg_dhu_curso);
                }catch(inErr){
                    winFrmCgg_dhu_curso.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_dhu_curso.
     */
    var btnCancelarCgg_dhu_curso = new Ext.Button({
        id:'btnCancelarCgg_dhu_curso',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_dhu_curso.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_dhu_curso.
     */
    var btnCerrarCgg_dhu_curso = new Ext.Button({
        id:'btnCerrarCgg_dhu_curso',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_dhu_curso.close();
            }}
    });
    /**
     * Ext.Panel Panel que contiene los datos informativos de persona
     */
    var pnlCgg_dhu_curso_registro = new Ext.Panel({
        id:'pnlCgg_dhu_curso_registro',
        layout:'form',
        frame:true,
        items:[
            {xtype:'panel',layout:'column',
                items:[
                    {columnWidth:.50,layout:'form',labelWidth :100,
                        items:[cbxCanton_curso]},
                    {columnWidth:.50,layout:'form',
                        items:[cbxTipo_curso1]}
                ]}, {xtype:'panel',layout:'column',
                items:[
                    {columnWidth:.95,layout:'form',
                        items:[txtCsctp_descripcion]},
                    {columnWidth:.05,layout:'form',
                        items:[btnCsctp_codigoCgg_dhu_curso]}
                ]}, {xtype:'panel',layout:'column',
                items:[
                    {columnWidth:.95,layout:'form',
                        items:[txtCrper_instructor]},
                    {columnWidth:.05,layout:'form',
                        items:[btnCrper_codigoCgg_dhu_curso]}
                ]},{xtype:'panel',layout:'column',
                items:[
                    {columnWidth:.95,layout:'form',
                        items:[txtCditr_nombre]},
                    {columnWidth:.05,layout:'form',
                        items:[btnCditr_codigoCgg_dhu_curso]}
                ]},txtCdcur_descripcion

        ]


    });
    /**
     * Ext.Panel Panel que contiene los datos informativos de persona
     */
    var pnlCgg_dhu_curso_datos_adicionales = new Ext.Panel({
        id:'pnlCgg_dhu_curso_datos_adicionales',
        layout:'form',
        title:'Fecha-Horario',
        frame:true,
        items:[

            {xtype:'panel',layout:'column', items:[
                {columnWidth:.50,layout:'form',
                    items:[dtCdcur_fecha_prevista_inicio]},
                {columnWidth:.50,layout:'form',items:[dtCdcur_fecha_prevista_culminacio]}
            ] },
            {xtype:'panel',layout:'column', labelWidth :100,
                items:[
                    {columnWidth:.50,layout:'form',
                        items:[dtCdcur_fecha_inicio]},
                    {columnWidth:.50,layout:'form',
                        items:[dtCdcur_fecha_culminacion]}
                ] },
            {xtype:'panel',layout:'column', labelWidth :100,
                items:[
                    {columnWidth:.35,layout:'form',labelWidth :100,
                        items:[txtCdcur_horario]},
                    {columnWidth:.35,layout:'form',labelWidth :10,items:[txtCdcur_horario1]}
                ]},
            {xtype:'panel',layout:'column', labelWidth :100,
                items:[
                    {columnWidth:.50,layout:'form',
                        items:[numCdcur_numero_horas]},
                    {columnWidth:.50,layout:'form',items:[numCdcur_numero_horas_pedagogicas]}
                ]},numCdcur_numero_asistente,txtCdcur_observacion

        ]


    });
    /**
     * Ext.Panel Panel que contiene los datos informativos de persona
     */
    var pnlCgg_dhu_curso_datos_modulo = new Ext.Panel({
        id:'pnlCgg_dhu_curso_datos_modulo',
        layout:'form',
        title:'Datos Principales',
        frame:true,
        items:[

            {xtype:'panel',layout:'column', labelWidth :100,
                items:[
                    {columnWidth:.50,layout:'form',
                        items:[numCdcur_numero_modulos]},
                    {columnWidth:.50,layout:'form',labelWidth :80,items:[cbxEstado_curso]}
                ]},txtCdcur_contenido,
            txtCdcur_institucion,
            txtCdcur_establecimiento,
            {xtype:'panel',layout:'column', labelWidth :100,
                items:[
                    {columnWidth:.50,layout:'form',
                        items:[numCdcur_costo]},
                    {columnWidth:.50,layout:'form',
                        items:[numCdcur_porcentaje]},
                    {columnWidth:.50,layout:'form',labelWidth :100,items:[numCdcur_porcentaje_financiado]},
                    {columnWidth:.50,layout:'form',labelWidth :100,items:[numCdcur_valoracion]}
                ]}

        ]


    });
      /**
     * Funcion que calcula el porcentaje financiado por el CGG.
     */
    function valorFinanciado(){
        tmpValorFinanciado= Math.round(((numCdcur_costo.getValue()*numCdcur_porcentaje.getValue())/100));
        numCdcur_porcentaje_financiado.setValue(tmpValorFinanciado);


    }
     /**
     * Funcion que calcula el valor que debe cancelar el auspiciante.
     */
    function valorAsistente(){
        tmpValorAsistente=Math.round((numCdcur_costo.getValue()-numCdcur_porcentaje_financiado.getValue()));
        numCdcur_valoracion.setValue(tmpValorAsistente);

    }

    /**
     * Ext.form.TabPanel  que contiene los controles de la ventana winFrmCgg_dhu_curso.
     */
    var tabCurso = new Ext.TabPanel({
        region:'south',
        activeTab:0,
        frame:true,
        height:260,
        items:[pnlCgg_dhu_curso_datos_modulo,pnlCgg_dhu_curso_datos_adicionales]
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_dhu_curso.
     */
    var pnlCgg_dhu_curso = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[pnlCgg_dhu_curso_registro,tabCurso]
    });

    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_dhu_curso.
     */
    var winFrmCgg_dhu_curso = new Ext.Window({
        id:'winFrmCgg_dhu_curso',
        title:tituloCgg_dhu_curso,
        width:600,
        minWidth:600,
        maximizable:false,
        minimizable:false,
		modal : true,
        constrain:true,
        tbar:getPanelTitulo(tituloCgg_dhu_curso,descCgg_dhu_curso),
        items:[pnlCgg_dhu_curso],
        bbar:[btnGuardarCgg_dhu_curso,btnCancelarCgg_dhu_curso,'->',btnCerrarCgg_dhu_curso]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_dhu_curso.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_dhu_cursoCtrls(inEstado){
        estado=!inEstado;
        txtCdcur_codigo.setDisabled(estado);
        cbxTipo_curso1.setDisabled(estado);
        cbxCanton_curso.setDisabled(estado);
        txtCsctp_codigo.setDisabled(estado);
        txtCditr_codigo.setDisabled(estado);
        txtCrper_codigo.setDisabled(estado);
        txtCdcur_descripcion.setDisabled(estado);
        dtCdcur_fecha_inicio.setDisabled(estado);
        dtCdcur_fecha_prevista_inicio.setDisabled(estado);
        dtCdcur_fecha_culminacion.setDisabled(estado);
        dtCdcur_fecha_prevista_culminacio.setDisabled(estado);
        txtCdcur_horario.setDisabled(estado);
        numCdcur_numero_horas_pedagogicas.setDisabled(estado);
        numCdcur_numero_horas.setDisabled(estado);
        numCdcur_numero_modulos.setDisabled(estado);
        txtCdcur_contenido.setDisabled(estado);
        txtCdcur_institucion.setDisabled(estado);
        txtCdcur_establecimiento.setDisabled(estado);
        numCdcur_costo.setDisabled(estado);
        numCdcur_porcentaje_financiado.setDisabled(estado);
        txtCdcur_observacion.setDisabled(estado);
        numCdcur_valoracion.setDisabled(estado);
        cbxEstado_curso.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_dhu_curso.
     */
    function cargarCgg_dhu_cursoCtrls(){
        if(inRecordCgg_dhu_curso){
            txtCdcur_codigo.setValue(inRecordCgg_dhu_curso.get('CDCUR_CODIGO'));
            cbxTipo_curso1.setValue(inRecordCgg_dhu_curso.get('CDTCR_CODIGO'));
            cbxCanton_curso.setValue(inRecordCgg_dhu_curso.get('CCTN_CODIGO'));
            txtCsctp_codigo.setValue(inRecordCgg_dhu_curso.get('CSCTP_CODIGO'));
            txtCditr_codigo.setValue(inRecordCgg_dhu_curso.get('CDITR_CODIGO'));
            txtCrper_codigo.setValue(inRecordCgg_dhu_curso.get('CRPER_CODIGO'));
            txtCdcur_descripcion.setValue(inRecordCgg_dhu_curso.get('CDCUR_DESCRIPCION'));
            txtCsctp_descripcion.setValue(inRecordCgg_dhu_curso.get('CSCTP_NOMBRE'));
            txtCrper_instructor.setValue(inRecordCgg_dhu_curso.get('CRPER_INSTRUCTOR'));
            txtCditr_nombre.setValue(inRecordCgg_dhu_curso.get('CDITR_NOMBRE'));
            dtCdcur_fecha_inicio.setValue(truncDate(inRecordCgg_dhu_curso.get('CDCUR_FECHA_INICIO')));
            dtCdcur_fecha_prevista_inicio.setValue(truncDate(inRecordCgg_dhu_curso.get('CDCUR_FECHA_PREVISTA_INICIO')));
            dtCdcur_fecha_prevista_culminacio.setValue(truncDate(inRecordCgg_dhu_curso.get('CDCUR_FECHA_PREVISTA_CULMINACION')));
            dtCdcur_fecha_culminacion.setValue(truncDate(inRecordCgg_dhu_curso.get('CDCUR_FECHA_CULMINACION')));
            txtCdcur_horario.setValue(inRecordCgg_dhu_curso.get('CDCUR_HORARIO'));
            txtCdcur_horario1.setValue(inRecordCgg_dhu_curso.get('CDCUR_HORARIO1'));
            numCdcur_numero_horas_pedagogicas.setValue(inRecordCgg_dhu_curso.get('CDCUR_NUMERO_HORAS_PEDAGOGICAS'));
            numCdcur_numero_horas.setValue(inRecordCgg_dhu_curso.get('CDCUR_NUMERO_HORAS'));
            numCdcur_numero_modulos.setValue(inRecordCgg_dhu_curso.get('CDCUR_NUMERO_MODULOS'));
            txtCdcur_contenido.setValue(inRecordCgg_dhu_curso.get('CDCUR_CONTENIDO'));
            txtCdcur_institucion.setValue(inRecordCgg_dhu_curso.get('CDCUR_INSTITUCION'));
            txtCdcur_establecimiento.setValue(inRecordCgg_dhu_curso.get('CDCUR_ESTABLECIMIENTO'));
            numCdcur_costo.setValue(inRecordCgg_dhu_curso.get('CDCUR_COSTO'));
            numCdcur_porcentaje_financiado.setValue(inRecordCgg_dhu_curso.get('CDCUR_PORCENTAJE_FINANCIADO'));
            txtCdcur_observacion.setValue(inRecordCgg_dhu_curso.get('CDCUR_OBSERVACION'));
            numCdcur_valoracion.setValue(inRecordCgg_dhu_curso.get('CDCUR_VALORACION'));
            cbxEstado_curso.setValue(inRecordCgg_dhu_curso.get('CDCUR_ESTADO_CURSO'));
            if(cbxEstado_curso.getValue()==TypeEstadoCurso.REGISTRADO){
                cbxEstado_curso.setValue('REGISTRADO');
            }
            if(cbxEstado_curso.getValue()==TypeEstadoCurso.TERMINADO){
                cbxEstado_curso.setValue('TERMINADO');
                cbxEstado_curso.disable();
            }
            if(cbxEstado_curso.getValue()==TypeEstadoCurso.FINALIZADO){
                cbxEstado_curso.setValue('FINALIZADO');
                cbxEstado_curso.disable();
            }
            numCdcur_numero_asistente.setValue(inRecordCgg_dhu_curso.get('CDCUR_NUMERO_ASISTENTE'));
            isEdit = true;
            dtCdcur_fecha_inicio.enable();
            dtCdcur_fecha_culminacion.enable();
            cbxEstado_curso.enable();
            numCdcur_porcentaje.setVisible(false);
            habilitarCgg_dhu_cursoCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_dhu_curso.
     * @returns ventana winFrmCgg_dhu_curso.
     * @base FrmCgg_dhu_curso.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_dhu_curso;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_dhu_curso.
     * @base FrmCgg_dhu_curso.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_dhu_cursoCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_dhu_curso desde una instancia.
 */
FrmCgg_dhu_curso.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_dhu_curso desde una instancia.
 */
FrmCgg_dhu_curso.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_dhu_curso,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_dhu_curso.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_dhu_curso desde una instancia.
 */
FrmCgg_dhu_curso.prototype.loadData = function(){
    this.loadData();
}
