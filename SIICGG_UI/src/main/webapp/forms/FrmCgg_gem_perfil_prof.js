/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_gem_perfil_prof.
* @param {String} IN_SENTENCIA_CGG_GEM_PERFIL_PROF Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_GEM_PERFIL_PROF Registro de datos de la tabla Cgg_gem_perfil_prof.
* @constructor
* @base FrmListadoCgg_gem_perfil_prof
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_gem_perfil_prof(IN_SENTENCIA_CGG_GEM_PERFIL_PROF,IN_RECORD_CGG_GEM_PERFIL_PROF,IN_PERSONA,IN_CRPER_CODIGO){
	var inSentenciaCgg_gem_perfil_prof = IN_SENTENCIA_CGG_GEM_PERFIL_PROF;
	var inRecordCgg_gem_perfil_prof=IN_RECORD_CGG_GEM_PERFIL_PROF;
	var urlCgg_gem_perfil_prof=URL_WS+"Cgg_gem_perfil_prof";
	var tituloCgg_gem_perfil_prof='Perfil profesional';
	var descCgg_gem_perfil_prof='El formulario permite administrar la informaci\u00f3n del perfil profesional de la persona.';
	var isEdit = false;
	var tmpDatosConfirmados = false; //Variable boolean utilizada para controlar la confirmacion del ingreso o actualización de información
	var codigoInstitucion = "";
	var codigoTitulo= "";
	var codigoEspecialidad="";
	var codigoPersona="";
	if(IN_CRPER_CODIGO){
		codigoPersona=IN_CRPER_CODIGO;
	}
	var objPerfilPersona ={
        CGPPR_CODIGO:'KEYGEN',
        CGESP_CODIGO:'',
        CGESP_NOMBRE:'',
        CGTPR_CODIGO:'',
        CGTPR_DESCRIPCION:'',
        CGIEN_CODIGO:'',
        CGIED_NOMBRE:'',
        CGMDC_CODIGO:'',
        CGMDC_DESCRIPCION:'',
        CGNES_CODIGO:'',
        CGNES_DESCRIPCION:'',
        CRPER_CODIGO:'',
        CGPPR_NIVEL_APROBADO:'',
		CGPPR_FECHA_INICIO:'',
		CGPPR_FECHA_FIN:'',
        CGPPR_CONFIRMADO:true,
        CGPPR_FECHA_CONFIRMACION:new Date(),
        CGPPR_PREDETERMINADO:true
    };
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PERFIL PROFESIONAL
	*/
	var txtCgppr_codigo = new Ext.form.TextField({
			id:'txtCgppr_codigo',
			name:'txtCgppr_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			value:"KEYGEN",
			hidden:true,
			hideLabel:true,
			allowBlank :false
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
		{dataIndex:'CGESP_DESCRIPCION',header:'Descripcion',width:350,sortable:true}]);
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
	////////////////////////////////////////////////////////////
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIALIDAD
	*/
	var txtCgesp_codigo = new Ext.form.TextField({
			id:'txtCgesp_codigo',
			name:'txtCgesp_codigo',
			fieldLabel :'Especialidad',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIALIDAD
	*/
	var btnCgesp_codigoCgg_gem_perfil_prof = new Ext.Button({
			id:'btnCgesp_codigoCgg_gem_perfil_prof',
			//text:'Cgesp_codigo',
			iconCls:'iconBuscar',
			listeners:{
				click:function(){
					var StoreEspecialidad = new CargarStoreEspecialidad();
					StoreEspecialidad.gsCgg_especialidad.baseParams.inCgnes_codigo=cbxCgnes_codigo.getValue();
					var objBusqueda = new DlgBusqueda(StoreEspecialidad.gsCgg_especialidad,StoreEspecialidad.cmCgg_especialidad);
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord){
								codigoEspecialidad = tmpRecord.get('CGESP_CODIGO');
								txtCgesp_codigo.setValue(tmpRecord.get('CGESP_NOMBRE'));
							}
					});
					objBusqueda.show();
			}}
	});
	/**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_nivel_estudio por un campo especifico.
     */
    var gsCgg_nivel_estudio = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_nivel_estudio",
            method:"selectAll",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
        },[
            {name:'CGNES_CODIGO'},
            {name:'CGNES_DESCRIPCION'},
            {name:'CGNES_GRADO'}
        ]),
        baseParams:{format:TypeFormat.JSON},
        listeners:{
            load:function()
            {
                if(IN_RECORD_CGG_GEM_PERFIL_PROF)
                {
                    cbxCgnes_codigo.setValue(inRecordCgg_gem_perfil_prof.get('CGNES_CODIGO'));

                }
            }
        }
    });
    /**
     * Ext.form.ComboBox IDENTIFICATIVO UNICO DE REGISTRO DE NIVEL DE ESTUDIO
     */
    var cbxCgnes_codigo = new Ext.form.ComboBox({
        id:'cbxCgnes_codigo',
        name:'cbxCgnes_codigo',
        fieldLabel :'Nivel estudio',
        anchor:'90%',
        store: gsCgg_nivel_estudio,
        displayField:'CGNES_DESCRIPCION',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        allowBlank:false,
        triggerAction:'all',
        emptyText:'Seleccione un nivel de estudio',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CGNES_DESCRIPCION}.- {CGNES_GRADO}" class="x-combo-list-item">{CGNES_DESCRIPCION}</div></tpl>',
        valueField:'CGNES_CODIGO',
		listeners:{
			'select':function(){
				//alert('cambio');
				/*txtCgien_codigo.reset();
				txtCgtpr_codigo.reset();
				txtCgesp_codigo.reset();*/
				txtCgien_codigo.setValue('');
				txtCgtpr_codigo.setValue('');
				txtCgesp_codigo.setValue('');
			}
		}
    });
	
	///////////////////////////////////////////////////
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
				baseParams:{keyword:"",format:'JSON',inCgnes_codigo:cbxCgnes_codigo.getValue()}
		});	
	}
	///////////////////////////////////////////////////
	
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TITULO PROFESIONAL
	*/
	var txtCgtpr_codigo = new Ext.form.TextField({
			id:'txtCgtpr_codigo',
			name:'txtCgtpr_codigo',
			fieldLabel :'T\u00EDtulo Profesional',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TITULO PROFESIONAL
	*/
	var btnCgtpr_codigoCgg_gem_perfil_prof = new Ext.Button({
			id:'btnCgtpr_codigoCgg_gem_perfil_prof',
			//text:'Cgtpr_codigo',
			iconCls:'iconBuscar',
			listeners:{
				click:function(){		
					var StoreTituloProfesional = new CargarStoreTituloProfesional();
					StoreTituloProfesional.gsCgg_titulo_profesional.baseParams.inCgnes_codigo=cbxCgnes_codigo.getValue();
					var objBusqueda = new DlgBusqueda(StoreTituloProfesional.gsCgg_titulo_profesional,StoreTituloProfesional.cmCgg_titulo_profesional);
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord)
							{
								codigoTitulo = tmpRecord.get('CGTPR_CODIGO')
								txtCgtpr_codigo.setValue(tmpRecord.get('CGTPR_DESCRIPCION'));
							}
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE MODALIDAD DE CURSO
	*/
/*	var txtCgmdc_codigo = new Ext.form.TextField({
			id:'txtCgmdc_codigo',
			name:'txtCgmdc_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE MODALIDAD DE CURSO
	*/
/*	var btnCgmdc_codigoCgg_gem_perfil_prof = new Ext.Button({
			id:'btnCgmdc_codigoCgg_gem_perfil_prof',
			text:'Cgmdc_codigo',
			iconCls:'iconCgmdc_codigo',
			listeners:{
				click:function(){
					var tmpFLCgg_modalidad_curso = new FrmListadoCgg_modalidad_curso();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_modalidad_curso.getStore(),tmpFLCgg_modalidad_curso.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord)
								txtCgmdc_codigo.setValue(tmpRecord.get('CGMDC_CODIGO'));
					});
					objBusqueda.show();
			}}
	});
*/

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_modalidad_curso por un campo especifico.
     */
    var gsCgg_modalidad_curso = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_modalidad_curso",
            method:"selectAll",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
        },[
            {name:'CGMDC_CODIGO'},
            {name:'CGMDC_DESCRIPCION'}
        ]),
        baseParams:{format:TypeFormat.JSON},
        listeners:{
            load:function()
            {
                if(IN_RECORD_CGG_GEM_PERFIL_PROF)
                {
                    cbxCgmdc_codigo.setValue(inRecordCgg_gem_perfil_prof.get('CGMDC_CODIGO'));

                }
            }
        }
    });
    /**
     * Ext.form.ComboBox IDENTIFICATIVO UNICO DE REGISTRO DE NIVEL DE ESTUDIO
     */
    var cbxCgmdc_codigo = new Ext.form.ComboBox({
        id:'cbxCgmdc_codigo',
        name:'cbxCgmdc_codigo',
        fieldLabel :'Modalidad estudio',
        anchor:'90%',
        store: gsCgg_modalidad_curso,
        displayField:'CGMDC_DESCRIPCION',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        allowBlank:false,
        emptyText:'Seleccione una modalidad...',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CGMDC_DESCRIPCION}" class="x-combo-list-item">{CGMDC_DESCRIPCION}</div></tpl>',
        valueField:'CGMDC_CODIGO'
    });

	/**
	* Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	var txtCrper_codigo = new Ext.form.TextField({
			id:'txtCrper_codigo',
			name:'txtCrper_codigo',
			fieldLabel :'Persona',
			anchor:'98%',
			readOnly:'true',
			allowBlank :(IN_PERSONA)?true:false
	});
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	var btnCrper_codigoCgg_gem_perfil_prof = new Ext.Button({
			id:'btnCrper_codigoCgg_gem_perfil_prof',
			//text:'Crper_codigo',
			iconCls:'iconBuscar',
			listeners:{
				click:function(){
					var tmpFLCgg_res_persona = new FrmListadoCgg_res_persona();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona.getStore(),tmpFLCgg_res_persona.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord){
								codigoPersona = tmpRecord.get('CRPER_CODIGO');
								txtCrper_codigo.setValue(tmpRecord.get('CRPER_NOMBRES')+" "+tmpRecord.get('CRPER_APELLIDO_PATERNO')+" "+tmpRecord.get('CRPER_APELLIDO_MATERNO') );
							}
					});
					objBusqueda.show();
			}}
	});
	
				
	/**
	* Ext.form.TextField NO ESPECIFICADO
	*/
	var txtCgien_codigo = new Ext.form.TextField({
			id:'txtCgien_codigo',
			name:'txtCgien_codigo',
			fieldLabel :'Ins. Educativa',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* NO ESPECIFICADO
	*/
	var btnCgien_codigoCgg_gem_perfil_prof = new Ext.Button({
			id:'btnCgien_codigoCgg_gem_perfil_prof',
			//text:'Cgien_codigo',
			iconCls:'iconBuscar',
			listeners:{
				click:function(){
					var tmpFLCgg_institucion_nivel = new FrmListadoCgg_institucion_nivel(cbxCgnes_codigo.getValue());
					var objBusqueda = new DlgBusqueda(tmpFLCgg_institucion_nivel.getStore(),tmpFLCgg_institucion_nivel.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord){
								codigoInstitucion = tmpRecord.get('CGIEN_CODIGO')
								txtCgien_codigo.setValue(tmpRecord.get('CGIED_NOMBRE'));
							}
					});
					objBusqueda.show();
			}}
	});
	/* Ext.form.Checkbox SI LA INFORMACIÓN YA FUE REVISADA POR ADMINISTRACION DE RESIDENCIA
     SI
     NO
     */
    var chkFormacionParcial = new Ext.form.Checkbox({
        id:'chkFormacionParcial',
        name:'chkFormacionParcial',
        fieldLabel :'Formaci\u00f3n Parcial',
        allowBlank :false,
        checked:false,
        listeners:{
            'check': function (obj,value)
            {
                if(value)
                {
                    numCgppr_nivel_aprobado.enable();                  			
                }
                else
                {
                    numCgppr_nivel_aprobado.disable();
                    numCgppr_nivel_aprobado.setValue(0);

                }
            }
        }
    });
	/**
	* Ext.form.NumberField ULTIMO NIVEL QUE APROBO.
	0 - APROBADO TODOS LOS NIVELES
	
	*/
	/*var numCgppr_nivel_aprobado = new Ext.form.NumberField({
			id:'numCgppr_nivel_aprobado',
			name:'numCgppr_nivel_aprobado',
			fieldLabel :'Nivel aprobado',
			allowBlank :false,
			disabled :false
	});*/
	
	/**
     * Ext.form.NumberField ULTIMO NIVEL QUE APROBO.
     0 - APROBADO TODOS LOS NIVELES

     */
    var numCgppr_nivel_aprobado = new Ext.ux.form.SpinnerField({
        id:'numCgppr_nivel_aprobado',
        name:'numCgppr_nivel_aprobado',
        fieldLabel :'Nivel aprobado',
        allowBlank :false,
        disabled :true,
        minValue: 0,
        maxValue: 20,
		value: 0,
        anchor:'90%'
    });

	/**
	* Ext.form.DateField NO ESPECIFICADO
	*/
	var dtCgppr_fecha_inicio = new Ext.form.DateField({
			id:'dtCgppr_fecha_inicio',
			name:'dtCgppr_fecha_inicio',
			fieldLabel :'Fecha inicio',			
			format :'d/m/Y',			
			maxValue:new Date()
	});
	/**
	* Ext.form.DateField NO ESPECIFICADO
	*/
	var dtCgppr_fecha_fin = new Ext.form.DateField({
			id:'dtCgppr_fecha_fin',
			name:'dtCgppr_fecha_fin',
			fieldLabel :'Fecha fin',			
			format :'d/m/Y',			
			maxValue:new Date()
	});
	/**
	* Ext.form.Checkbox SI LA INFORMACIÓN YA FUE REVISADA POR ADMINISTRACION DE RESIDENCIA
	SI
	NO
	*/
	var chkCgppr_confirmado = new Ext.form.Checkbox({
			id:'chkCgppr_confirmado',
			name:'chkCgppr_confirmado',
			fieldLabel :'Confirmado',
			allowBlank :false,
			checked:true
	});
	
	/**
	* Ext.form.DateField FECHA EN LA QUE SE COMPROBO LA VERACIDAD DE LA INFORMACION
	*/
	var dtCgppr_fecha_confirmacion = new Ext.form.DateField({
			id:'dtCgppr_fecha_confirmacion',
			name:'dtCgppr_fecha_confirmacion',
			fieldLabel :'Fecha confirmacion',
			allowBlank :false,
			format :'d/m/Y',
			value:new Date()
	});
	/**
	* Ext.form.Checkbox DETERMINA SI EL REGISTRO ES EL ULTIMO ALCANZADO
	*/
	var chkCgppr_predeterminado = new Ext.form.Checkbox({
			id:'chkCgppr_predeterminado',
			name:'chkCgppr_predeterminado',
			fieldLabel :'Predeterminado',
			allowBlank :false,
			checked:true
	});
	/**
	* Oculta controles cuando se llama desde el formulario persona
	*/
	if(IN_PERSONA){
		txtCrper_codigo.hidden = true;
		btnCrper_codigoCgg_gem_perfil_prof.hidden=true;		
		//codigoPersona = IN_CRPER_CODIGO;		
		chkCgppr_predeterminado.hidden=true;
		dtCgppr_fecha_confirmacion.hidden = true;
	}else{
		txtCrper_codigo.hidden = false;
		btnCrper_codigoCgg_gem_perfil_prof.hidden= false;
		chkCgppr_predeterminado.hidden=false;
		dtCgppr_fecha_confirmacion.hidden = false;
	}
	/**
	* Boton que permite almacenar la informacion de la ventana winFrmCgg_gem_perfil_prof
	*/
	var btnGuardarCgg_gem_perfil_prof = new Ext.Button({
			id:'btnGuardarCgg_gem_perfil_prof',
			text:(IN_PERSONA)?'Aceptar':'Guardar',
			iconCls:(IN_PERSONA)?'iconAceptar':'iconGuardar',
			listeners:{
				click:function(){
					if (!pnlCgg_gem_perfil_prof.getForm().isValid()){
						return;
					}
					try{
						if(IN_PERSONA){						
							objPerfilPersona.CGPPR_CODIGO = txtCgppr_codigo.getValue();
							//objPerfilPersona.CGESP_CODIGO = cbxCgesp_codigo.getValue();
							objPerfilPersona.CGESP_CODIGO = codigoEspecialidad;
							//objPerfilPersona.CGESP_DESCRIPCION = cbxCgesp_codigo.getRawValue();
							objPerfilPersona.CGESP_NOMBRE = txtCgesp_codigo.getValue();
							//objPerfilPersona.CGTPR_CODIGO = cbxCgtpr_codigo.getValue();
							objPerfilPersona.CGTPR_CODIGO = codigoTitulo;
							objPerfilPersona.CGTPR_DESCRIPCION = txtCgtpr_codigo.getValue();
							//objPerfilPersona.CGIED_CODIGO = cbxCgied_codigo.getValue();
							objPerfilPersona.CGIEN_CODIGO = codigoInstitucion;
							//objPerfilPersona.CGIED_DESCRIPCION = cbxCgied_codigo.getRawValue();
							objPerfilPersona.CGIED_NOMBRE = txtCgien_codigo.getValue();
							objPerfilPersona.CGMDC_CODIGO = cbxCgmdc_codigo.getValue();							
							objPerfilPersona.CGMDC_DESCRIPCION = cbxCgmdc_codigo.getRawValue();
							objPerfilPersona.CGNES_CODIGO = cbxCgnes_codigo.getValue();
							objPerfilPersona.CGNES_DESCRIPCION = cbxCgnes_codigo.getRawValue();
							objPerfilPersona.CGPPR_NIVEL_APROBADO = numCgppr_nivel_aprobado.getValue()?numCgppr_nivel_aprobado.getValue():0;
							objPerfilPersona.CGPPR_FECHA_INICIO = dtCgppr_fecha_inicio.getValue()?dtCgppr_fecha_inicio.getValue().format('Y-m-d'):'';
							objPerfilPersona.CGPPR_FECHA_FIN = dtCgppr_fecha_fin.getValue()?dtCgppr_fecha_fin.getValue().format('Y-m-d'):'';
							objPerfilPersona.CGPPR_PREDETERMINADO = chkCgppr_predeterminado.getValue();
							tmpDatosConfirmados =  true;
							winFrmCgg_gem_perfil_prof.close();
						}else{							
							function CallBackCgg_gem_perfil_prof(r){
								winFrmCgg_gem_perfil_prof.getEl().unmask();
								if(r=='true'){
									Ext.Msg.show({
											title:tituloCgg_gem_perfil_prof,
											msg: 'La informaci\u00f3n sobre el perfil profesional ha sido almacenada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.INFO
									});winFrmCgg_gem_perfil_prof.close()
								}else{
									Ext.Msg.show({
											title:tituloCgg_gem_perfil_prof,
											msg: 'La informaci\u00f3n sobre el perfil profesional no ha podido ser almacenada. '+(r.message?r.message:r),
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.ERROR
									});
								}
							}
							winFrmCgg_gem_perfil_prof.getEl().mask('Guardando...', 'x-mask-loading');
							var param = new SOAPClientParameters();
							if(isEdit)
								param.add('inCgppr_codigo',txtCgppr_codigo.getValue());							
							param.add('inCgesp_codigo',codigoEspecialidad);							
							param.add('inCgtpr_codigo',codigoTitulo);
							param.add('inCgmdc_codigo',cbxCgmdc_codigo.getValue());							
							param.add('inCrper_codigo',codigoPersona);							
							param.add('inCgien_codigo',codigoInstitucion);
							param.add('inCgppr_nivel_aprobado',numCgppr_nivel_aprobado.getValue());
							param.add('inCgppr_fecha_inicio',(dtCgppr_fecha_inicio.getValue().length==0)?null:dtCgppr_fecha_inicio.getValue().format('c'));
							param.add('inCgppr_fecha_fin',(dtCgppr_fecha_fin.getValue().length==0)?null:dtCgppr_fecha_fin.getValue().format('c'));
							param.add('inCgppr_confirmado',chkCgppr_confirmado.getValue());
							param.add('inCgppr_fecha_confirmacion',dtCgppr_fecha_confirmacion.getValue()?dtCgppr_fecha_confirmacion.getValue().format('c'):new Date().format('c'));
							param.add('inCgppr_predeterminado',chkCgppr_predeterminado.getValue());
							SOAPClient.invoke(urlCgg_gem_perfil_prof,IN_SENTENCIA_CGG_GEM_PERFIL_PROF,param, true, CallBackCgg_gem_perfil_prof);
						}
					}catch(inErr){
						winFrmCgg_gem_perfil_prof.getEl().unmask();
					}
			}}
	});
	/**
	* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_gem_perfil_prof.
	*/
	var btnCancelarCgg_gem_perfil_prof = new Ext.Button({
			id:'btnCancelarCgg_gem_perfil_prof',
			text:'Cancelar',
			iconCls:'iconCancelar',
			listeners:{
				click:function(){
					pnlCgg_gem_perfil_prof.getForm().reset();
			}}
	});
	/**
	* Boton que permite cerrar la ventana winFrmCgg_gem_perfil_prof.
	*/
	var btnCerrarCgg_gem_perfil_prof = new Ext.Button({
			id:'btnCerrarCgg_gem_perfil_prof',
			text:'Cerrar',
			iconCls:'iconCerrar',
			listeners:{
				click:function(){
					winFrmCgg_gem_perfil_prof.close();
			}}
	});
	/**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_gem_perfil_prof.
	*/
	var pnlCgg_gem_perfil_prof = new Ext.form.FormPanel({
			frame:true,
			labelWidth :100,
			items:[txtCgppr_codigo,cbxCgnes_codigo,
				{xtype:'panel',layout:'column',items:[{columnWidth:.85,layout:'form',items:[txtCgien_codigo]},{columnWidth:.15,layout:'form',items:[btnCgien_codigoCgg_gem_perfil_prof]}]},
				{xtype:'panel',layout:'column',items:[{columnWidth:.85,layout:'form',items:[txtCgtpr_codigo]},{columnWidth:.15,layout:'form',items:[btnCgtpr_codigoCgg_gem_perfil_prof]}]},
				{xtype:'panel',layout:'column',items:[{columnWidth:.85,layout:'form',items:[txtCgesp_codigo]},{columnWidth:.15,layout:'form',items:[btnCgesp_codigoCgg_gem_perfil_prof]}]},/*{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCgmdc_codigo]},{columnWidth:.4,layout:'form',items:[btnCgmdc_codigoCgg_gem_perfil_prof]}]}*/
				cbxCgmdc_codigo,
				//{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCrper_codigo]},{columnWidth:.4,layout:'form',items:[btnCrper_codigoCgg_gem_perfil_prof]}]},
				{xtype:'panel',layout:'column',items:[{columnWidth:.5,layout:'form',items:[chkFormacionParcial]},{columnWidth:.5,layout:'form',items:[numCgppr_nivel_aprobado]}]}/*numCgppr_nivel_aprobado*/,
				dtCgppr_fecha_inicio,
				dtCgppr_fecha_fin,			
				chkCgppr_confirmado,
				//dtCgppr_fecha_confirmacion,
				chkCgppr_predeterminado]			
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_gem_perfil_prof.
	*/
	var winFrmCgg_gem_perfil_prof = new Ext.Window({
			id:'winFrmCgg_gem_perfil_prof',
			title:tituloCgg_gem_perfil_prof,
			iconCls:'iconAplicacion',
			width:400,
			minWidth:400,			
			maximizable:false,
			minimizable:false,			
			modal:true,
			constrainHeader:true,
			tbar:getPanelTitulo(tituloCgg_gem_perfil_prof,descCgg_gem_perfil_prof),
			items:[pnlCgg_gem_perfil_prof],
			bbar:[btnGuardarCgg_gem_perfil_prof,btnCancelarCgg_gem_perfil_prof,'->',btnCerrarCgg_gem_perfil_prof]
	});
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmCgg_gem_perfil_prof.getBottomToolbar());
	
	function loadStore()
    {
        gsCgg_nivel_estudio.load();
		gsCgg_modalidad_curso.load();
    }
    loadStore();	
	/**
	* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_gem_perfil_prof.
	*/
	function cargarCgg_gem_perfil_profCtrls(){
		if(inRecordCgg_gem_perfil_prof){
			cbxCgnes_codigo.setValue(inRecordCgg_gem_perfil_prof.get('CGNES_CODIGO'));
			txtCgppr_codigo.setValue(inRecordCgg_gem_perfil_prof.get('CGPPR_CODIGO'));			
			codigoEspecialidad = inRecordCgg_gem_perfil_prof.get('CGESP_CODIGO');
			txtCgesp_codigo.setValue(inRecordCgg_gem_perfil_prof.get('CGESP_NOMBRE'));
			codigoTitulo = inRecordCgg_gem_perfil_prof.get('CGTPR_CODIGO');
			txtCgtpr_codigo.setValue(inRecordCgg_gem_perfil_prof.get('CGTPR_DESCRIPCION'));			
			cbxCgmdc_codigo.setValue(inRecordCgg_gem_perfil_prof.get('CGMDC_CODIGO'));
			codigoPersona = inRecordCgg_gem_perfil_prof.get('CRPER_CODIGO')
			txtCrper_codigo.setValue(inRecordCgg_gem_perfil_prof.get('CRPER_NOMBRES')+" "+inRecordCgg_gem_perfil_prof.get('CRPER_APELLIDO_PATERNO')+" "+inRecordCgg_gem_perfil_prof.get('CRPER_APELLIDO_MATERNO'));			
			codigoInstitucion = inRecordCgg_gem_perfil_prof.get('CGIEN_CODIGO');
			txtCgien_codigo.setValue(inRecordCgg_gem_perfil_prof.get('CGIED_NOMBRE'));			
			numCgppr_nivel_aprobado.setValue(inRecordCgg_gem_perfil_prof.get('CGPPR_NIVEL_APROBADO'));
			dtCgppr_fecha_inicio.setValue((inRecordCgg_gem_perfil_prof.get('CGPPR_FECHA_INICIO'))||'');
			dtCgppr_fecha_fin.setValue((inRecordCgg_gem_perfil_prof.get('CGPPR_FECHA_FIN'))||'');
			chkCgppr_confirmado.setValue(inRecordCgg_gem_perfil_prof.get('CGPPR_CONFIRMADO'));
			dtCgppr_fecha_confirmacion.setValue(inRecordCgg_gem_perfil_prof.get('CGPPR_FECHA_CONFIRMACION')||new Date());
			chkCgppr_predeterminado.setValue(inRecordCgg_gem_perfil_prof.get('CGPPR_PREDETERMINADO'));
			isEdit = true;
			
			if (IN_PERSONA){
				txtCrper_codigo.hidden = true;
				btnCrper_codigoCgg_gem_perfil_prof.hidden=true;
			}else{
				txtCrper_codigo.hidden = false;
				btnCrper_codigoCgg_gem_perfil_prof.hidden=false;
			}
			if (inRecordCgg_gem_perfil_prof.get('CGPPR_NIVEL_APROBADO') > 0)
            {
                chkFormacionParcial.setValue(true);
                numCgppr_nivel_aprobado.enable();
                //numCgppr_nivel_aprobado.enable();
            }
            else
            {
                chkFormacionParcial.setValue(false);
                numCgppr_nivel_aprobado.disable();
            }			
	}}
	/**
	* Funcion miembro que devuelve la ventana winFrmCgg_gem_perfil_prof.
	* @returns ventana winFrmCgg_gem_perfil_prof.
	* @base FrmCgg_gem_perfil_prof.prototype.show
	*/
	this.getWindow = function(){
		return winFrmCgg_gem_perfil_prof;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmCgg_gem_perfil_prof.
	* @base FrmCgg_gem_perfil_prof.prototype.loadData
	*/
	this.loadData = function(){
		cargarCgg_gem_perfil_profCtrls();
	}
	/**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_persona_contacto.
     * @base FrmCgg_res_persona_contacto.prototype.loadData
     */
    this.getData = function(){
        if (tmpDatosConfirmados)
            return objPerfilPersona;
        else
            return null;
    }
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_gem_perfil_prof desde una instancia.
*/
FrmCgg_gem_perfil_prof.prototype.show = function(){
	this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_gem_perfil_prof desde una instancia.
*/
FrmCgg_gem_perfil_prof.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_gem_perfil_prof,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_gem_perfil_prof.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_gem_perfil_prof desde una instancia.
*/
FrmCgg_gem_perfil_prof.prototype.loadData = function(){
	this.loadData();
}
/**
 * Funcion prototipo. Permite obtener los datos del perfil registrado desde una instancia.
 */
FrmCgg_gem_perfil_prof.prototype.getData = function(){
    this.getData();
}
