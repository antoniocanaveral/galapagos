/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_soporte_tecnico.
* @param {String} INSENTENCIA_CGG_SOPORTE_TECNICO Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} INRECORD_CGG_SOPORTE_TECNICO Registro de datos de la tabla Cgg_soporte_tecnico.
* @constructor
* @base FrmListadoCgg_soporte_tecnico
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_soporte_tecnico(INSENTENCIA_CGG_SOPORTE_TECNICO,INRECORD_CGG_SOPORTE_TECNICO){
var inSentenciaCgg_soporte_tecnico = INSENTENCIA_CGG_SOPORTE_TECNICO;
var inRecordCgg_soporte_tecnico=INRECORD_CGG_SOPORTE_TECNICO;
var urlCgg_soporte_tecnico=URL_WS+"Cgg_soporte_tecnico";
var tituloCgg_soporte_tecnico='Soporte tecnico';
var descCgg_soporte_tecnico='El formulario permite administrar informaci\u00f3n de la tabla Soporte tecnico';
var isEdit = false;
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE SOPORTE TECNICO
*/
var txtCsote_codigo = new Ext.form.TextField({
id:'txtCsote_codigo',
name:'txtCsote_codigo',
fieldLabel :'Codigo',
anchor:'98%',
allowBlank :false,
value:"KEYGEN",
hidden:true,
hideLabel:true,
maxLength :20
});
/**
* Ext.form.TextField NOMBRE DEL SOPORTE TECNICO
*/
var txtCsote_asunto = new Ext.form.TextField({
id:'txtCsote_asunto',
name:'txtCsote_asunto',
fieldLabel :'Asunto',
anchor:'98%',
allowBlank :false,
maxLength :20
});
/**
* Ext.form.TextField NUMERO DE SOPORTE TECNICO
*/
var txtCsote_numero = new Ext.form.TextField({
id:'txtCsote_numero',
name:'txtCsote_numero',
fieldLabel :'Numero',
anchor:'98%',
allowBlank :false,
maxLength :20
});
/**
* Ext.form.TextArea DESCRIPCION DEL SOPORTE TECNICO
*/
var txtCsote_descripcion = new Ext.form.TextArea({
id:'txtCsote_descripcion',
name:'txtCsote_descripcion',
fieldLabel :'Descripcion',
width:'90%',
allowBlank :false
});
/**
* Ext.form.TextField CAMPO QUE REGISTRA EL  EL CORREO ELECTRONICO O NUEMRO DE TELEFONO
*/
var txtCsote_contacto = new Ext.form.TextField({
id:'txtCsote_contacto',
name:'txtCsote_contacto',
fieldLabel :'Contacto',
anchor:'98%',
allowBlank :false,
maxLength :20
});
/**
* Ext.form.NumberField CAMPO QUE REGISTRA SE SE ATENDIO A UN SOPRTE TECNICO
0 - NO SOLUCIONADO
1 - SOLUCIONADO
2 - EN ESPERA
*/
var numCsote_atendido = new Ext.form.NumberField({
id:'numCsote_atendido',nname:'numCsote_atendido',fieldLabel :'Atendido',allowBlank :false,disabled :false});/**
* Boton que permite almacenar la informacion de la ventana winFrmCgg_soporte_tecnico
*/
var btnGuardarCgg_soporte_tecnico = new Ext.Button({
id:'btnGuardarCgg_soporte_tecnico',
text:'Guardar',
iconCls:'iconGuardar',
listeners:{
click:function(){
if (pnlCgg_soporte_tecnico.getForm().isValid()==false){
return;
}
try{
function CallBackCgg_soporte_tecnico(r){
winFrmCgg_soporte_tecnico.getEl().unmask();
if(r=='true'){
Ext.Msg.show({
title:tituloCgg_soporte_tecnico,
msg: 'La informaci\u00f3n de Soporte tecnico ha sido almacenada.',
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.INFO
});winFrmCgg_soporte_tecnico.close()
}else{
Ext.Msg.show({
title:tituloCgg_soporte_tecnico,
msg: 'La informaci\u00f3n de Soporte tecnico no ha podido ser almacenada.',
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.ERROR
});
}
}
winFrmCgg_soporte_tecnico.getEl().mask('Guardando...', 'x-mask-loading');
var param = new SOAPClientParameters();
if(isEdit)
param.add('inCsote_codigo',txtCsote_codigo.getValue());
param.add('inCsote_asunto',txtCsote_asunto.getValue());
param.add('inCsote_numero',txtCsote_numero.getValue());
param.add('inCsote_descripcion',txtCsote_descripcion.getValue());
param.add('inCsote_contacto',txtCsote_contacto.getValue());
param.add('inCsote_atendido',numCsote_atendido.getValue());
SOAPClient.invoke(urlCgg_soporte_tecnico,INSENTENCIA_CGG_SOPORTE_TECNICO,param, true, CallBackCgg_soporte_tecnico);
}catch(inErr){
winFrmCgg_soporte_tecnico.getEl().unmask();
}
}}
});
/**
* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_soporte_tecnico.
*/
var btnCancelarCgg_soporte_tecnico = new Ext.Button({
id:'btnCancelarCgg_soporte_tecnico',
text:'Cancelar',
iconCls:'iconCancelar',
listeners:{
click:function(){
pnlCgg_soporte_tecnico.getForm().reset();
}}
});
/**
* Boton que permite cerrar la ventana winFrmCgg_soporte_tecnico.
*/
var btnCerrarCgg_soporte_tecnico = new Ext.Button({
id:'btnCerrarCgg_soporte_tecnico',
text:'Cerrar',
iconCls:'iconCerrar',
listeners:{
click:function(){
winFrmCgg_soporte_tecnico.close();
}}
});
/**
* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_soporte_tecnico.
*/
var pnlCgg_soporte_tecnico = new Ext.form.FormPanel({
frame:true,
labelWidth :100,
items:[txtCsote_codigo,txtCsote_asunto,txtCsote_numero,txtCsote_descripcion,txtCsote_contacto,numCsote_atendido]
});
/**
* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_soporte_tecnico.
*/
var winFrmCgg_soporte_tecnico = new Ext.Window({
id:'winFrmCgg_soporte_tecnico',
title:tituloCgg_soporte_tecnico,
tbar:getPanelTitulo(tituloCgg_soporte_tecnico,descCgg_soporte_tecnico),
items:[pnlCgg_soporte_tecnico],
width:400,
minWidth:400,
maximizable:true,
minimizable:true,
constrain:true,
bbar:[btnGuardarCgg_soporte_tecnico,btnCancelarCgg_soporte_tecnico,'->',btnCerrarCgg_soporte_tecnico]
});
/**
* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_soporte_tecnico.
* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
*/
function habilitarCgg_soporte_tecnicoCtrls(inEstado){
estado=!inEstado;
txtCsote_codigo.setDisabled(estado);
txtCsote_asunto.setDisabled(estado);
txtCsote_numero.setDisabled(estado);
txtCsote_descripcion.setDisabled(estado);
txtCsote_contacto.setDisabled(estado);
numCsote_atendido.setDisabled(estado);
}
/**
* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_soporte_tecnico.
*/
function cargarCgg_soporte_tecnicoCtrls(){
if(inRecordCgg_soporte_tecnico){
txtCsote_codigo.setValue(inRecordCgg_soporte_tecnico.get('CSOTE_CODIGO'));
txtCsote_asunto.setValue(inRecordCgg_soporte_tecnico.get('CSOTE_ASUNTO'));
txtCsote_numero.setValue(inRecordCgg_soporte_tecnico.get('CSOTE_NUMERO'));
txtCsote_descripcion.setValue(inRecordCgg_soporte_tecnico.get('CSOTE_DESCRIPCION'));
txtCsote_contacto.setValue(inRecordCgg_soporte_tecnico.get('CSOTE_CONTACTO'));
numCsote_atendido.setValue(inRecordCgg_soporte_tecnico.get('CSOTE_ATENDIDO'));
isEdit = true;
habilitarCgg_soporte_tecnicoCtrls(true);
}}
/**
* Funcion miembro que devuelve la ventana winFrmCgg_soporte_tecnico.
* @returns ventana winFrmCgg_soporte_tecnico.
* @base FrmCgg_soporte_tecnico.prototype.show
*/
this.getWindow = function(){
return winFrmCgg_soporte_tecnico;
}
/**
* Funcion miembro que carga los controles de la ventana winFrmCgg_soporte_tecnico.
* @base FrmCgg_soporte_tecnico.prototype.loadData
*/
this.loadData = function(){
cargarCgg_soporte_tecnicoCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_soporte_tecnico desde una instancia.
*/
FrmCgg_soporte_tecnico.prototype.show = function(){
this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_soporte_tecnico desde una instancia.
*/
FrmCgg_soporte_tecnico.prototype.close = function(){
this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_soporte_tecnico,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_soporte_tecnico.prototype.closeHandler = function(inFunctionHandler){
this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_soporte_tecnico desde una instancia.
*/
FrmCgg_soporte_tecnico.prototype.loadData = function(){
this.loadData();
}
