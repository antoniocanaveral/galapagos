/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_jur_seguimiento_criterio.
* @param {String} IN_SENTENCIA_CGG_JUR_SEGUIMIENTO_CRITERIO Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_JUR_SEGUIMIENTO_CRITERIO Registro de datos de la tabla Cgg_jur_seguimiento_criterio.
* @constructor
* @base FrmListadoCgg_jur_seguimiento_criterio
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_jur_seguimiento_criterio(IN_SENTENCIA_CGG_JUR_SEGUIMIENTO_CRITERIO,IN_RECORD_CGG_JUR_SEGUIMIENTO_CRITERIO){
var inSentenciaCgg_jur_seguimiento_criterio = IN_SENTENCIA_CGG_JUR_SEGUIMIENTO_CRITERIO;
var inRecordCgg_jur_seguimiento_criterio=IN_RECORD_CGG_JUR_SEGUIMIENTO_CRITERIO;
var urlCgg_jur_seguimiento_criterio=URL_WS+"Cgg_jur_seguimiento_criterio";
var tituloCgg_jur_seguimiento_criterio='Jur seguimiento criterio';
var descCgg_jur_seguimiento_criterio='El formulario permite administrar la informaci\u00f3n de la tabla Jur seguimiento criterio';
var isEdit = false;
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO CRITERIO
*/
var txtCjsgc_codigo = new Ext.form.TextField({
id:'txtCjsgc_codigo',
name:'txtCjsgc_codigo',
fieldLabel :'Codigo',
anchor:'98%',
value:"KEYGEN",
hidden:true,
hideLabel:true,
allowBlank :false
});
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
*/
var txtCrseg_codigo = new Ext.form.TextField({
id:'txtCrseg_codigo',
name:'txtCrseg_codigo',
fieldLabel :'Codigo',
anchor:'98%',
readOnly:'true',
allowBlank :false
});
/**
* IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
*/
var btnCrseg_codigoCgg_jur_seguimiento_criterio = new Ext.Button({
id:'btnCrseg_codigoCgg_jur_seguimiento_criterio',
text:'Crseg_codigo',
iconCls:'iconCrseg_codigo',
listeners:{
click:function(){
var tmpFLCgg_res_seguimiento = new FrmListadoCgg_res_seguimiento();
var objBusqueda = new DlgBusqueda(tmpFLCgg_res_seguimiento.getStore(),tmpFLCgg_res_seguimiento.getColumnModel());
objBusqueda.closeHandler(function(){
var tmpRecord = objBusqueda.getSelectedRow();
if(tmpRecord)
txtCrseg_codigo.setValue(tmpRecord.get('CRSEG_CODIGO'));
});
objBusqueda.show();
}}
});
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CRITERIO JURIDICO
*/
var txtCjcri_codigo = new Ext.form.TextField({
id:'txtCjcri_codigo',
name:'txtCjcri_codigo',
fieldLabel :'Codigo',
anchor:'98%',
readOnly:'true',
allowBlank :false
});
/**
* IDENTIFICATIVO UNICO DE REGISTRO DE CRITERIO JURIDICO
*/
var btnCjcri_codigoCgg_jur_seguimiento_criterio = new Ext.Button({
id:'btnCjcri_codigoCgg_jur_seguimiento_criterio',
text:'Cjcri_codigo',
iconCls:'iconCjcri_codigo',
listeners:{
click:function(){
var tmpFLCgg_jur_criterio = new FrmListadoCgg_jur_criterio();
var objBusqueda = new DlgBusqueda(tmpFLCgg_jur_criterio.getStore(),tmpFLCgg_jur_criterio.getColumnModel());
objBusqueda.closeHandler(function(){
var tmpRecord = objBusqueda.getSelectedRow();
if(tmpRecord)
txtCjcri_codigo.setValue(tmpRecord.get('CJCRI_CODIGO'));
});
objBusqueda.show();
}}
});
/**
* Ext.form.Checkbox RESPUESTA DEL CRITERIO
SI / NO
*/
var chkCjsgc_respuesta = new Ext.form.Checkbox({
id:'chkCjsgc_respuesta',
name:'chkCjsgc_respuesta',
fieldLabel :'Respuesta',
allowBlank :false,
checked:true
});
/**
* Ext.form.TextArea RAZON QUE RESPALDA LA RESPUESTA
*/
var txtCjsgc_justificacion = new Ext.form.TextArea({
id:'txtCjsgc_justificacion',
name:'txtCjsgc_justificacion',
fieldLabel :'Justificacion',
width:'90%',
allowBlank :false
});
/**
* Ext.form.TextArea NO ESPECIFICADO
*/
var txtCjsgc_observacion = new Ext.form.TextArea({
id:'txtCjsgc_observacion',
name:'txtCjsgc_observacion',
fieldLabel :'Observacion',
width:'90%',
allowBlank :false
});
/**
* Ext.form.TextField NOMBRE DEL DOCUMENTO ADJUNTO
*/
var txtCjsgc_nombre_adjunto = new Ext.form.TextField({
id:'txtCjsgc_nombre_adjunto',
name:'txtCjsgc_nombre_adjunto',
fieldLabel :'Nombre adjunto',
anchor:'98%',
allowBlank :false
});
/**
* ARCHIVO DIGITAL ANEXO AL CRITERIO
*/
var filCjsgc_adjunto = new Ext.form.FileUploadField({
id:'filCjsgc_adjunto',
name:'filCjsgc_adjunto',
fieldLabel :'Adjunto',
anchor:'98%',
disabled :false,
buttonCfg: {
text: '',
iconCls: 'iconAdjunto'
}
});
/**
* Boton que permite almacenar la informacion de la ventana winFrmCgg_jur_seguimiento_criterio
*/
var btnGuardarCgg_jur_seguimiento_criterio = new Ext.Button({
id:'btnGuardarCgg_jur_seguimiento_criterio',
text:'Guardar',
iconCls:'iconGuardar',
listeners:{
click:function(){
if (pnlCgg_jur_seguimiento_criterio.getForm().isValid()==false){
return;
}

Ext.getCmp('pnlCgg_jur_seguimiento_criterio').getForm().submit({
	url: URL_WS+"Cgg_jur_seguimiento_criterioSRV",
	waitMsg: 'Enviando formulario...',
	success: function(fp, o){
		Ext.Msg.show({
		title:tituloCgg_jur_seguimiento_criterio,
		msg: 'La informaci\u00f3n de Jur seguimiento criterio ha sido almacenada.',
		buttons: Ext.Msg.OK,
		icon: Ext.MessageBox.INFO
		});
		winFrmCgg_jur_seguimiento_criterio.close();
	},
	failure:function(o){
		Ext.Msg.show({
		title:tituloCgg_jur_seguimiento_criterio,
		msg: 'La informaci\u00f3n de Jur seguimiento criterio no ha podido ser almacenada.',
		buttons: Ext.Msg.OK,
		icon: Ext.MessageBox.ERROR
		});
	}
});
 }}
});
/**
* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_jur_seguimiento_criterio.
*/
var btnCancelarCgg_jur_seguimiento_criterio = new Ext.Button({
id:'btnCancelarCgg_jur_seguimiento_criterio',
text:'Cancelar',
iconCls:'iconCancelar',
listeners:{
click:function(){
pnlCgg_jur_seguimiento_criterio.getForm().reset();
}}
});
/**
* Boton que permite cerrar la ventana winFrmCgg_jur_seguimiento_criterio.
*/
var btnCerrarCgg_jur_seguimiento_criterio = new Ext.Button({
id:'btnCerrarCgg_jur_seguimiento_criterio',
text:'Cerrar',
iconCls:'iconCerrar',
listeners:{
click:function(){
winFrmCgg_jur_seguimiento_criterio.close();
}}
});
/**
* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_jur_seguimiento_criterio.
*/
var pnlCgg_jur_seguimiento_criterio = new Ext.form.FormPanel({
frame:true,
labelWidth :100,
items:[txtCjsgc_codigo,{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCrseg_codigo]},{columnWidth:.4,layout:'form',items:[btnCrseg_codigoCgg_jur_seguimiento_criterio]}]},{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCjcri_codigo]},{columnWidth:.4,layout:'form',items:[btnCjcri_codigoCgg_jur_seguimiento_criterio]}]},chkCjsgc_respuesta,txtCjsgc_justificacion,txtCjsgc_observacion,txtCjsgc_nombre_adjunto,filCjsgc_adjunto]
});
/**
* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_jur_seguimiento_criterio.
*/
var winFrmCgg_jur_seguimiento_criterio = new Ext.Window({
id:'winFrmCgg_jur_seguimiento_criterio',
title:tituloCgg_jur_seguimiento_criterio,
width:400,
minWidth:400,
maximizable:true,
minimizable:true,
constrain:true,
tbar:getPanelTitulo(tituloCgg_jur_seguimiento_criterio,descCgg_jur_seguimiento_criterio),
items:[pnlCgg_jur_seguimiento_criterio],
bbar:[btnGuardarCgg_jur_seguimiento_criterio,btnCancelarCgg_jur_seguimiento_criterio,'->',btnCerrarCgg_jur_seguimiento_criterio]
});
/**
* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_jur_seguimiento_criterio.
* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
*/
function habilitarCgg_jur_seguimiento_criterioCtrls(inEstado){
estado=!inEstado;
txtCjsgc_codigo.setDisabled(estado);
txtCrseg_codigo.setDisabled(estado);
txtCjcri_codigo.setDisabled(estado);
chkCjsgc_respuesta.setDisabled(estado);
txtCjsgc_justificacion.setDisabled(estado);
txtCjsgc_observacion.setDisabled(estado);
txtCjsgc_nombre_adjunto.setDisabled(estado);
numCjsgc_adjunto.setDisabled(estado);
}
/**
* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_jur_seguimiento_criterio.
*/
function cargarCgg_jur_seguimiento_criterioCtrls(){
if(inRecordCgg_jur_seguimiento_criterio){
txtCjsgc_codigo.setValue(inRecordCgg_jur_seguimiento_criterio.get('CJSGC_CODIGO'));
txtCrseg_codigo.setValue(inRecordCgg_jur_seguimiento_criterio.get('CRSEG_CODIGO'));
txtCjcri_codigo.setValue(inRecordCgg_jur_seguimiento_criterio.get('CJCRI_CODIGO'));
chkCjsgc_respuesta.setValue(inRecordCgg_jur_seguimiento_criterio.get('CJSGC_RESPUESTA'));
txtCjsgc_justificacion.setValue(inRecordCgg_jur_seguimiento_criterio.get('CJSGC_JUSTIFICACION'));
txtCjsgc_observacion.setValue(inRecordCgg_jur_seguimiento_criterio.get('CJSGC_OBSERVACION'));
txtCjsgc_nombre_adjunto.setValue(inRecordCgg_jur_seguimiento_criterio.get('CJSGC_NOMBRE_ADJUNTO'));
numCjsgc_adjunto.setValue(inRecordCgg_jur_seguimiento_criterio.get('CJSGC_ADJUNTO'));
isEdit = true;
habilitarCgg_jur_seguimiento_criterioCtrls(true);
}}
/**
* Funcion miembro que devuelve la ventana winFrmCgg_jur_seguimiento_criterio.
* @returns ventana winFrmCgg_jur_seguimiento_criterio.
* @base FrmCgg_jur_seguimiento_criterio.prototype.show
*/
this.getWindow = function(){
return winFrmCgg_jur_seguimiento_criterio;
}
/**
* Funcion miembro que carga los controles de la ventana winFrmCgg_jur_seguimiento_criterio.
* @base FrmCgg_jur_seguimiento_criterio.prototype.loadData
*/
this.loadData = function(){
cargarCgg_jur_seguimiento_criterioCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_jur_seguimiento_criterio desde una instancia.
*/
FrmCgg_jur_seguimiento_criterio.prototype.show = function(){
this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_jur_seguimiento_criterio desde una instancia.
*/
FrmCgg_jur_seguimiento_criterio.prototype.close = function(){
this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_jur_seguimiento_criterio,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_jur_seguimiento_criterio.prototype.closeHandler = function(inFunctionHandler){
this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_jur_seguimiento_criterio desde una instancia.
*/
FrmCgg_jur_seguimiento_criterio.prototype.loadData = function(){
this.loadData();
}
