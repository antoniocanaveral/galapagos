/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_gem_informacion_laboral.
* @param {String} IN_SENTENCIA_CGG_GEM_INFORMACION_LABORAL Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_GEM_INFORMACION_LABORAL Registro de datos de la tabla Cgg_gem_informacion_laboral.
* @constructor
* @base FrmListadoCgg_gem_informacion_laboral
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_gem_informacion_laboral(IN_SENTENCIA_CGG_GEM_INFORMACION_LABORAL,IN_RECORD_CGG_GEM_INFORMACION_LABORAL,IN_CRPER_CODIGO,IN_ADMINISTRACION,IN_BUSQUEDA_PERFIL){	
	var inSentenciaCgg_gem_informacion_laboral = IN_SENTENCIA_CGG_GEM_INFORMACION_LABORAL;
	var inRecordCgg_gem_informacion_laboral=IN_RECORD_CGG_GEM_INFORMACION_LABORAL;
	var urlCgg_gem_informacion_laboral=URL_WS+"Cgg_gem_informacion_laboral";
	var tituloCgg_gem_informacion_laboral='Informaci\u00F3n laboral';
	var descCgg_gem_informacion_laboral='El formulario permite administrar la informaci\u00f3n laboral de la persona para la hoja de vida';
	var codigoPersona=IN_CRPER_CODIGO;
	var isEdit = false;
	/**
	* Ext.form.TextField NO ESPECIFICADO
	*/
	var txtCginf_codigo = new Ext.form.TextField({
			id:'txtCginf_codigo',
			name:'txtCginf_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			value:"KEYGEN",
			hidden:true,
			hideLabel:true,
			allowBlank :false
	});
	/**
	* Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE LA TABLA PERSONA
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
	* CODIGO IDENTIFICATIVO DE REGISTRO DE LA TABLA PERSONA
	*/
	var btnCrper_codigoCgg_gem_informacion_laboral = new Ext.Button({
			id:'btnCrper_codigoCgg_gem_informacion_laboral',
			text:'Crper_codigo',
			iconCls:'iconCrper_codigo',
			listeners:{
				click:function(){
					var tmpFLCgg_res_persona = new FrmListadoCgg_res_persona();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona.getStore(),tmpFLCgg_res_persona.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord)
								txtCrper_codigo.setValue(tmpRecord.get('CRPER_CODIGO'));
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.ComboBox SI ESTA O NO DISPUESTO A TRABAJAR EN OTRA CIUDAD
	*/
	var cmbCginf_trab_otra_ciudad = new Ext.form.ComboBox({
        id:'cmbCginf_trab_otra_ciudad',
        name:'cmbCginf_trab_otra_ciudad',
        fieldLabel:'Dispuesto a trabajar en otra ciudad',
        store: [
                        ['0', 'NO'],
                        ['1', 'SI'],
                        ['2', 'OTRO']
                   ],
        typeAhead: true,
        forceSelection: true,
        triggerAction: 'all',
        emptyText:'Seleccione',
        selectOnFocus:true,
        editable:false,
        submitValue:false
    });	

				
	/**
	* Ext.form.Checkbox SI LA TRABAJARIA O NO FUERA DE LA CIUDAD
	SI
	NO
	*/
	var chkCginf_trab_otra_ciudad = new Ext.form.Checkbox({
			id:'chkCginf_trab_otra_ciudad',
			name:'chkCginf_trab_otra_ciudad',
			fieldLabel :'Trabajar\u00EDa en otra ciudad',
			allowBlank :false,
			checked:false
	});
				
	//////////////////////////////////////////
	/**
	* Ext.form.TextField ASPIRACION SALARIAL
	*/
	var txtCrper_aspiracion_salarial = new Ext.form.NumberField({
			id:'txtCrper_aspiracion_salarial',
			name:'txtCrper_aspiracion_salarial',
			fieldLabel :'Aspiraci\u00F3n Salarial $',
			anchor:'98%',
			xtype: 'numberfield',
			allowNegative: false, 
			value:0
	});
	/**
	* Ext.form.TextField EN QUE TIEMPO ESTA DISPONIBLE PARA APLICAR A OTRO TRABAJO
	*/
	var txtCginf_disponibilidad = new Ext.form.TextField({
			id:'txtCginf_disponibilidad',
			name:'txtCginf_disponibilidad',
			fieldLabel :'Disponibilidad',
			anchor:'98%',			
			emptyText: '¿Tiempo para trabajar en un nuevo puesto?'
	});	
	/**
     * Ext.form.NumberField NUMERO DE HIJOS
     */
    var numCginf_hijos = new Ext.ux.form.SpinnerField({
        id:'numCginf_hijos',
        name:'numCginf_hijos',
        fieldLabel :'N\u00FAmero de hijos',
        
        //disabled :true,
        minValue: 0,
        maxValue: 20,
		value: 0,
        anchor:'50%'
    });

	/**
	* Ext.form.ComboBox CAMPO QUE REPRESENTA SI UN RESIDENTE TIENE VEHICULO
	0 - NO
	1 - SI
	2 - PRONTO
	*/
	var cmbCginf_vehiculo = new Ext.form.ComboBox({
        id:'cmbCginf_vehiculo',
        name:'cmbCginf_vehiculo',
        fieldLabel:'Transporte propio',
        store: [
                        ['0', 'NO'],
                        ['1', 'SI'],
                        ['2', 'OTRO']
                   ],
        typeAhead: true,
        forceSelection: true,
        triggerAction: 'all',
        emptyText:'Seleccione',
        selectOnFocus:true,
        editable:false,
        submitValue:false
    });
	/**
	* Ext.form.TextField Calificacion del empleado
	*/
	var cbxCginf_Calificacion = new Ext.form.ComboBox({
		id:'cbxCginf_Calificacion',
		name:'cbxCginf_Calificacion',
		fieldLabel :'Calificaci\u00F3n',
		 store: [
					['1', '1'],
					['2', '2'],
					['3', '3'],
					['4', '4'],
					['5', '5']
			   ],
		typeAhead: true,
        forceSelection: true,
        triggerAction: 'all',
        emptyText:'Seleccione',
        selectOnFocus:true,
        editable:false,
        submitValue:false
	});
	
	/**
	* Ext.form.Checkbox SI DISPONE O NO LICENCIA DE CONDUCIR
	SI
	NO
	*/
	var chkCginf_licencia_conducir = new Ext.form.Checkbox({
			id:'chkCginf_licencia_conducir',
			name:'chkCginf_licencia_conducir',
			fieldLabel :'Licencia de conducir',
			allowBlank :false,
			checked:false
	});
	
	/**
	* Ext.form.ComboBox ESTADO LABORAL Q PUEDE TENER UNA PERSONA
	*/
	var cmbCginf_estado_laboral = new Ext.form.ComboBox({
        id:'cmbCginf_estado_laboral',
        name:'cmbCginf_estado_laboral',
        fieldLabel:'Estado laboral',
        store: [
                        ['0', 'Actualmente trabajando'],
                        ['1', 'Ama de casa'],
                        ['2', 'No trabaja'],
						['3', 'Estudiante'],
						['4', 'Negocio propio']
                   ],
        typeAhead: true,
        forceSelection: true,
        triggerAction: 'all',
        emptyText:'Seleccione',
        selectOnFocus:true,
        editable:false,
        submitValue:false
    });
	/**
	* Ext.form.TextArea INFORMACION ADICIONAL
	*/
	var txtCginf_observaciones = new Ext.form.TextArea({
			id:'txtCginf_observaciones',
			name:'txtCginf_observaciones',
			fieldLabel :'Detalle',
			width:'90%'
	});
	/**
	* Boton que permite almacenar la informacion de la ventana winFrmCgg_gem_informacion_laboral
	*/
	var btnGuardarCgg_gem_informacion_laboral = new Ext.Button({
			id:'btnGuardarCgg_gem_informacion_laboral',
			text:'Guardar',
			iconCls:'iconGuardar',			
			listeners:{
				click:function(){
					if (!pnlCgg_gem_informacion_laboral.getForm().isValid()){
						return;
					}
					try{
						function CallBackCgg_gem_informacion_laboral(r){
							pnlCgg_gem_informacion_laboral.getEl().unmask();
							if(r=='true'){
								Ext.Msg.show({
										title:tituloCgg_gem_informacion_laboral,
										msg: 'La informaci\u00f3n laboral para la hoja de vida ha sido almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
								});winFrmCgg_gem_informacion_laboral.close()
							}else{
								Ext.Msg.show({
										title:tituloCgg_gem_informacion_laboral,
										msg: 'La informaci\u00f3n laboral para la hoja de vida no ha podido ser almacenada. '+(r.message?r.message:r),
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
								});
							}
						}
						pnlCgg_gem_informacion_laboral.getEl().mask('Guardando...', 'x-mask-loading');
						var param = new SOAPClientParameters();
						if(isEdit)
							param.add('inCginf_codigo',txtCginf_codigo.getValue());
						param.add('inCrper_codigo',codigoPersona);
						if (chkCginf_trab_otra_ciudad.getValue()){
							param.add('inCginf_trab_otra_ciudad','1')
						}else{
							param.add('inCginf_trab_otra_ciudad','0')
						}
						
						if(chkCginf_licencia_conducir.getValue())
							param.add('inCginf_licencia_conducir','1');
						else
							param.add('inCginf_licencia_conducir','0');
						
						param.add('inCginf_disponibilidad',txtCginf_disponibilidad.getValue());
						param.add('inCginf_calificacion',cbxCginf_Calificacion.getValue());
						param.add('inCginf_estado_laboral',cmbCginf_estado_laboral.getValue());
						param.add('inCginf_hijos',numCginf_hijos.getValue());
						param.add('inCginf_observaciones',txtCginf_observaciones.getValue());
						param.add('inCrper_aspiracion_salarial',txtCrper_aspiracion_salarial.getValue());
						SOAPClient.invoke(urlCgg_gem_informacion_laboral,inSentenciaCgg_gem_informacion_laboral,param, true, CallBackCgg_gem_informacion_laboral);
					}catch(inErr){
						pnlCgg_gem_informacion_laboral.getEl().unmask();
					}
			}}
	});
	/**
	* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_gem_informacion_laboral.
	*/
	var btnCancelarCgg_gem_informacion_laboral = new Ext.Button({
			id:'btnCancelarCgg_gem_informacion_laboral',
			text:'Cancelar',
			iconCls:'iconCancelar',
			listeners:{
				click:function(){
					pnlCgg_gem_informacion_laboral.getForm().reset();
			}}
	});
	/**
	* Boton que permite cerrar la ventana winFrmCgg_gem_informacion_laboral.
	*/
	var btnCerrarCgg_gem_informacion_laboral = new Ext.Button({
			id:'btnCerrarCgg_gem_informacion_laboral',
			text:IN_ADMINISTRACION?'Salir':'Cerrar',
			iconCls:IN_ADMINISTRACION?'iconSalir':'iconCerrar',			
			listeners:{
				click:function(){
					if(IN_ADMINISTRACION)
						Ext.getCmp('btnSalirCgg_gem_administracion_hoja_vida').fireEvent('click');
					else
						winFrmCgg_gem_informacion_laboral.close();
			}}
	});
	/**
	  * Ext.data.Store registros de la tabla Cgg_gem_informacion_laboral por un campo especifico.
	  */
    var gscInformacionLaboral = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_gem_informacion_laboral",
            method:"selectInformacionLaboralById"
        }),
        reader:new Ext.data.JsonReader({},[
            {
            name:'CGINF_CODIGO'
            },
            {
            name:'CRPER_CODIGO'
            },
            {
            name:'CGINF_TRAB_OTRA_CIUDAD'
            },
            {
            name:'CRPER_ASPIRACION_SALARIAL'
            },
            {
            name:'CGINF_DISPONIBILIDAD'
            },
            {
            name:'CGINF_VEHICULO'
            },
            {
            name:'CGINF_CALIFICACION'
            },
            {
            name:'CGINF_ESTADO_LABORAL'
            },
            {
            name:'CGINF_HIJOS'
            },
            {
            name:'CGINF_OBSERVACIONES'
            }
        ]),
        baseParams:{
            inCrper_codigo:codigoPersona,
            format:"JSON"
        },
		listeners:{
			'load':function(obj,rec){
				if(rec[0].get('CRPER_CODIGO')){
					//alert('Existe');
					cargarDatos();
					inSentenciaCgg_gem_informacion_laboral='update';
					isEdit=true;
				}else{
					//alert('No Existe');
					inSentenciaCgg_gem_informacion_laboral='insert';
				}
				
			}
		}
    });
	
	/**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_gem_informacion_laboral.
	*/
	var pnlCgg_gem_informacion_laboral = new Ext.form.FormPanel({
		frame:true,
		region:'center',
		labelWidth :120,
		items:[txtCginf_codigo,
			chkCginf_trab_otra_ciudad,
			txtCrper_aspiracion_salarial,
			txtCginf_disponibilidad,
			numCginf_hijos,
			chkCginf_licencia_conducir,
			cmbCginf_estado_laboral,
			{	
				xtype:'fieldset',
				title: 'Calificaci\u00F3n de empleado', 
				autoHeight:true,        
				items :[cbxCginf_Calificacion,{
					fieldLabel :' ',
					hidden:true,
					html:'<div id="divCginf_Calificacion"></div>'
					},txtCginf_observaciones
				]
			
			}
		],
		bbar:[btnGuardarCgg_gem_informacion_laboral,btnCancelarCgg_gem_informacion_laboral,'->',btnCerrarCgg_gem_informacion_laboral]
	});
	function setCalificacion(v){
		cbxCginf_Calificacion.setValue(v);
		var divCginf_Calificacion = document.getElementById("divCginf_Calificacion");
		if (divCginf_Calificacion){
			divCginf_Calificacion.innerHTML="";
			var strCalif ="";
			for (var i = 1;i<=10 ; i++){
				var strUrlImg = (i<= v)?"staron.jpg":"staroff.jpg";
				strCalif+="<img title='"+i+"' src='resources/images/"+strUrlImg+"'  id ='imgCal"+i+"'/>";			
			}
			divCginf_Calificacion.innerHTML = strCalif;
			/*for (var i = 1;i<=10 ; i++){
				document.getElementById("imgCal"+i).onclick = function(){
					setCalificacion(this.title);
				}
			}*/
		}
	}
	function cargarDatos(){
			txtCginf_codigo.setValue(gscInformacionLaboral.getAt(0).get('CGINF_CODIGO'));
			codigoPersona=gscInformacionLaboral.getAt(0).get('CRPER_CODIGO');
			//cmbCginf_trab_otra_ciudad.setValue(gscInformacionLaboral.getAt(0).get('CGINF_TRAB_OTRA_CIUDAD'));
			chkCginf_trab_otra_ciudad.setValue(gscInformacionLaboral.getAt(0).get('CGINF_TRAB_OTRA_CIUDAD'));
			txtCrper_aspiracion_salarial.setValue(gscInformacionLaboral.getAt(0).get('CRPER_ASPIRACION_SALARIAL'));
			txtCginf_disponibilidad.setValue(gscInformacionLaboral.getAt(0).get('CGINF_DISPONIBILIDAD'));
			var tmpCalif = gscInformacionLaboral.getAt(0).get('CGINF_CALIFICACION');			
			setCalificacion(tmpCalif);
			chkCginf_licencia_conducir.setValue(gscInformacionLaboral.getAt(0).get('CGINF_LICENCIA_CONDUCIR'));
			cmbCginf_estado_laboral.setValue(gscInformacionLaboral.getAt(0).get('CGINF_ESTADO_LABORAL'));
			txtCginf_observaciones.setValue(gscInformacionLaboral.getAt(0).get('CGINF_OBSERVACIONES'));	
			numCginf_hijos.setValue(gscInformacionLaboral.getAt(0).get('CGINF_HIJOS'))
	}
	
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_gem_informacion_laboral.
	*/
	var winFrmCgg_gem_informacion_laboral = new Ext.Window({
			id:'winFrmCgg_gem_informacion_laboral',
			title:tituloCgg_gem_informacion_laboral,
			iconCls:'iconAplicacion',
			width:400,
			minWidth:400,				
			minHeight: 400,
			height: 400,
			maximizable:false,
			minimizable:false,			
			modal:true,
			layout:'border',
			constrainHeader:true,
			tbar:getPanelTitulo(tituloCgg_gem_informacion_laboral,descCgg_gem_informacion_laboral),
			items:[pnlCgg_gem_informacion_laboral],
			listeners:{
				show:function(){
					setCalificacion(cbxCginf_Calificacion.getValue());
				}
			}
	});
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
//	applyGrants(pnlCgg_gem_informacion_laboral.getBottomToolbar());
	
	/**
	* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_gem_informacion_laboral.
	*/
	function cargarCgg_gem_informacion_laboralCtrls(){
		if(inRecordCgg_gem_informacion_laboral){
			txtCginf_codigo.setValue(inRecordCgg_gem_informacion_laboral.get('CGINF_CODIGO'));
			txtCrper_codigo.setValue(inRecordCgg_gem_informacion_laboral.get('CRPER_CODIGO'));
			txtCginf_disponibilidad.setValue(inRecordCgg_gem_informacion_laboral.get('CGINF_DISPONIBILIDAD'));
			cbxCginf_Calificacion.setValue(inRecordCgg_gem_informacion_laboral.get('CGINF_VEHICULO'))||0;
			setCalificacion(cbxCginf_Calificacion.getValue());
			txtCginf_licencia_conducir.setValue(inRecordCgg_gem_informacion_laboral.get('CGINF_LICENCIA_CONDUCIR'));
			chkCginf_discapacidad.setValue(inRecordCgg_gem_informacion_laboral.get('CGINF_DISCAPACIDAD'));
			txtCginf_estado_laboral.setValue(inRecordCgg_gem_informacion_laboral.get('CGINF_ESTADO_LABORAL'));
			txtCginf_observaciones.setValue(inRecordCgg_gem_informacion_laboral.get('CGINF_OBSERVACIONES'));
			isEdit = true;		
	}}
	gscInformacionLaboral.reload();
	/**
	* Funcion miembro que devuelve la ventana winFrmCgg_gem_informacion_laboral.
	* @returns ventana winFrmCgg_gem_informacion_laboral.
	* @base FrmCgg_gem_informacion_laboral.prototype.show
	*/
	this.getWindow = function(){
		return winFrmCgg_gem_informacion_laboral;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmCgg_gem_informacion_laboral.
	* @base FrmCgg_gem_informacion_laboral.prototype.loadData
	*/
	this.loadData = function(){		
		cargarCgg_gem_informacion_laboralCtrls();
	}
	/**
	* Funcion miembro que devuelve el panel de los controles de informacion laboral
	*/
	this.getPanel = function(){
		return pnlCgg_gem_informacion_laboral;
	}
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_gem_informacion_laboral desde una instancia.
*/
FrmCgg_gem_informacion_laboral.prototype.show = function(){
	this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_gem_informacion_laboral desde una instancia.
*/
FrmCgg_gem_informacion_laboral.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_gem_informacion_laboral,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_gem_informacion_laboral.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_gem_informacion_laboral desde una instancia.
*/
FrmCgg_gem_informacion_laboral.prototype.loadData = function(){
	this.loadData();
}
/**
* Funcion prototipo. Permite obtener el panel sobre los controles de informacion laboral
*/
FrmCgg_gem_informacion_laboral.prototype.getPanel = function(){
	this.getPanel();
}
