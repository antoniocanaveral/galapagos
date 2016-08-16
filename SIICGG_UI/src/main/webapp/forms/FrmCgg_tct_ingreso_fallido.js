/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_tct_ingreso_fallido.
* @param {String} IN_SENTENCIA_CGG_TCT_INGRESO_FALLIDO Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_TCT_INGRESO_FALLIDO Registro de datos de la tabla Cgg_tct_ingreso_fallido.
* @constructor
* @base FrmListadoCgg_tct_ingreso_fallido
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_tct_ingreso_fallido(IN_SENTENCIA_CGG_TCT_INGRESO_FALLIDO,IN_RECORD_CGG_TCT_INGRESO_FALLIDO){
var inSentenciaCgg_tct_ingreso_fallido = IN_SENTENCIA_CGG_TCT_INGRESO_FALLIDO;
var inRecordCgg_tct_ingreso_fallido=IN_RECORD_CGG_TCT_INGRESO_FALLIDO;
var urlCgg_tct_ingreso_fallido=URL_WS+"Cgg_tct_ingreso_fallido";
var tituloCgg_tct_ingreso_fallido='Tct ingreso fallido';
var descCgg_tct_ingreso_fallido='El formulario permite administrar la informaci\u00f3n de la tabla Tct ingreso fallido';
var isEdit = false;
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
*/
var txtCtigf_codigo = new Ext.form.TextField({
id:'txtCtigf_codigo',
name:'txtCtigf_codigo',
fieldLabel :'Codigo',
anchor:'98%',
value:"KEYGEN",
hidden:true,
hideLabel:true,
allowBlank :false
});
/**
* Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO
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
* CODIGO IDENTIFICATIVO DE REGISTRO
*/
var btnCrper_codigoCgg_tct_ingreso_fallido = new Ext.Button({
id:'btnCrper_codigoCgg_tct_ingreso_fallido',
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
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
*/
var txtCarpt_codigo = new Ext.form.TextField({
id:'txtCarpt_codigo',
name:'txtCarpt_codigo',
fieldLabel :'Codigo',
anchor:'98%',
readOnly:'true',
allowBlank :false
});
/**
* IDENTIFICATIVO UNICO DE REGISTRO
*/
var btnCarpt_codigoCgg_tct_ingreso_fallido = new Ext.Button({
id:'btnCarpt_codigoCgg_tct_ingreso_fallido',
text:'Carpt_codigo',
iconCls:'iconCarpt_codigo',
listeners:{
click:function(){
var tmpFLCgg_res_aeropuerto = new FrmListadoCgg_res_aeropuerto();
var objBusqueda = new DlgBusqueda(tmpFLCgg_res_aeropuerto.getStore(),tmpFLCgg_res_aeropuerto.getColumnModel());
objBusqueda.closeHandler(function(){
var tmpRecord = objBusqueda.getSelectedRow();
if(tmpRecord)
txtCarpt_codigo.setValue(tmpRecord.get('CARPT_CODIGO'));
});
objBusqueda.show();
}}
});
/**
* Ext.form.DateField FECHA DE INTENTO DE INGRESO
*/
var dtCtigf_fecha_intento = new Ext.form.DateField({
id:'dtCtigf_fecha_intento',
name:'dtCtigf_fecha_intento',
fieldLabel :'Fecha intento',
allowBlank :false,
format :'d/m/Y',
value:new Date()
});
/**
* Ext.form.NumberField TIPO DE INGRESO FALLIDO
0 - NOTIFICACION
1 - ESTADIA
2 - OTROS
*/
var numCtigf_tipo_ingreso_fallido = new Ext.form.NumberField({
id:'numCtigf_tipo_ingreso_fallido',
name:'numCtigf_tipo_ingreso_fallido',
fieldLabel :'Tipo ingreso fallido',
allowBlank :false,
disabled :false
});
/**
* Ext.form.TextField DESCRIPCION DEL INGRESO FALLIDO
*/
var txtCtigf_descripcion = new Ext.form.TextField({
id:'txtCtigf_descripcion',
name:'txtCtigf_descripcion',
fieldLabel :'Descripcion',
anchor:'98%',
allowBlank :false
});
/**
* Boton que permite almacenar la informacion de la ventana winFrmCgg_tct_ingreso_fallido
*/
var btnGuardarCgg_tct_ingreso_fallido = new Ext.Button({
id:'btnGuardarCgg_tct_ingreso_fallido',
text:'Guardar',
iconCls:'iconGuardar',
listeners:{
click:function(){
if (pnlCgg_tct_ingreso_fallido.getForm().isValid()==false){
return;
}
try{
function CallBackCgg_tct_ingreso_fallido(r){
winFrmCgg_tct_ingreso_fallido.getEl().unmask();
if(r=='true'){
Ext.Msg.show({
title:tituloCgg_tct_ingreso_fallido,
msg: 'La informaci\u00f3n de Tct ingreso fallido ha sido almacenada.',
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.INFO
});winFrmCgg_tct_ingreso_fallido.close()
}else{
Ext.Msg.show({
title:tituloCgg_tct_ingreso_fallido,
msg: 'La informaci\u00f3n de Tct ingreso fallido no ha podido ser almacenada. '+r,
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.ERROR
});
}
}
winFrmCgg_tct_ingreso_fallido.getEl().mask('Guardando...', 'x-mask-loading');
var param = new SOAPClientParameters();
if(isEdit)
param.add('inCtigf_codigo',txtCtigf_codigo.getValue());
param.add('inCrper_codigo',txtCrper_codigo.getValue());
param.add('inCarpt_codigo',txtCarpt_codigo.getValue());
param.add('inCtigf_fecha_intento',dtCtigf_fecha_intento.getValue().format('c'));
param.add('inCtigf_tipo_ingreso_fallido',numCtigf_tipo_ingreso_fallido.getValue());
param.add('inCtigf_descripcion',txtCtigf_descripcion.getValue());
SOAPClient.invoke(urlCgg_tct_ingreso_fallido,IN_SENTENCIA_CGG_TCT_INGRESO_FALLIDO,param, true, CallBackCgg_tct_ingreso_fallido);
}catch(inErr){
winFrmCgg_tct_ingreso_fallido.getEl().unmask();
}
}}
});
/**
* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_tct_ingreso_fallido.
*/
var btnCancelarCgg_tct_ingreso_fallido = new Ext.Button({
id:'btnCancelarCgg_tct_ingreso_fallido',
text:'Cancelar',
iconCls:'iconCancelar',
listeners:{
click:function(){
pnlCgg_tct_ingreso_fallido.getForm().reset();
}}
});
/**
* Boton que permite cerrar la ventana winFrmCgg_tct_ingreso_fallido.
*/
var btnCerrarCgg_tct_ingreso_fallido = new Ext.Button({
id:'btnCerrarCgg_tct_ingreso_fallido',
text:'Cerrar',
iconCls:'iconCerrar',
listeners:{
click:function(){
winFrmCgg_tct_ingreso_fallido.close();
}}
});
/**
* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_tct_ingreso_fallido.
*/
var pnlCgg_tct_ingreso_fallido = new Ext.form.FormPanel({
frame:true,
labelWidth :100,
items:[txtCtigf_codigo,{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCrper_codigo]},{columnWidth:.4,layout:'form',items:[btnCrper_codigoCgg_tct_ingreso_fallido]}]},{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCarpt_codigo]},{columnWidth:.4,layout:'form',items:[btnCarpt_codigoCgg_tct_ingreso_fallido]}]},dtCtigf_fecha_intento,numCtigf_tipo_ingreso_fallido,txtCtigf_descripcion]
});
/**
* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_tct_ingreso_fallido.
*/
var winFrmCgg_tct_ingreso_fallido = new Ext.Window({
id:'winFrmCgg_tct_ingreso_fallido',
title:tituloCgg_tct_ingreso_fallido,
width:400,
minWidth:400,
maximizable:true,
minimizable:true,
constrain:true,
tbar:getPanelTitulo(tituloCgg_tct_ingreso_fallido,descCgg_tct_ingreso_fallido),
items:[pnlCgg_tct_ingreso_fallido],
bbar:[btnGuardarCgg_tct_ingreso_fallido,btnCancelarCgg_tct_ingreso_fallido,'->',btnCerrarCgg_tct_ingreso_fallido]
});
/**
* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_tct_ingreso_fallido.
* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
*/
function habilitarCgg_tct_ingreso_fallidoCtrls(inEstado){
estado=!inEstado;
txtCtigf_codigo.setDisabled(estado);
txtCrper_codigo.setDisabled(estado);
txtCarpt_codigo.setDisabled(estado);
dtCtigf_fecha_intento.setDisabled(estado);
numCtigf_tipo_ingreso_fallido.setDisabled(estado);
txtCtigf_descripcion.setDisabled(estado);
}
/**
* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_tct_ingreso_fallido.
*/
function cargarCgg_tct_ingreso_fallidoCtrls(){
if(inRecordCgg_tct_ingreso_fallido){
txtCtigf_codigo.setValue(inRecordCgg_tct_ingreso_fallido.get('CTIGF_CODIGO'));
txtCrper_codigo.setValue(inRecordCgg_tct_ingreso_fallido.get('CRPER_CODIGO'));
txtCarpt_codigo.setValue(inRecordCgg_tct_ingreso_fallido.get('CARPT_CODIGO'));
dtCtigf_fecha_intento.setValue(inRecordCgg_tct_ingreso_fallido.get('CTIGF_FECHA_INTENTO'));
numCtigf_tipo_ingreso_fallido.setValue(inRecordCgg_tct_ingreso_fallido.get('CTIGF_TIPO_INGRESO_FALLIDO'));
txtCtigf_descripcion.setValue(inRecordCgg_tct_ingreso_fallido.get('CTIGF_DESCRIPCION'));
isEdit = true;
habilitarCgg_tct_ingreso_fallidoCtrls(true);
}}
/**
* Funcion miembro que devuelve la ventana winFrmCgg_tct_ingreso_fallido.
* @returns ventana winFrmCgg_tct_ingreso_fallido.
* @base FrmCgg_tct_ingreso_fallido.prototype.show
*/
this.getWindow = function(){
return winFrmCgg_tct_ingreso_fallido;
}
/**
* Funcion miembro que carga los controles de la ventana winFrmCgg_tct_ingreso_fallido.
* @base FrmCgg_tct_ingreso_fallido.prototype.loadData
*/
this.loadData = function(){
cargarCgg_tct_ingreso_fallidoCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_tct_ingreso_fallido desde una instancia.
*/
FrmCgg_tct_ingreso_fallido.prototype.show = function(){
this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_tct_ingreso_fallido desde una instancia.
*/
FrmCgg_tct_ingreso_fallido.prototype.close = function(){
this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_tct_ingreso_fallido,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_tct_ingreso_fallido.prototype.closeHandler = function(inFunctionHandler){
this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_tct_ingreso_fallido desde una instancia.
*/
FrmCgg_tct_ingreso_fallido.prototype.loadData = function(){
this.loadData();
}
