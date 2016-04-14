/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_operacion_regla_validacion.
* @param {String} IN_SENTENCIA_CGG_OPERACION_REGLA_VALIDACION Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_OPERACION_REGLA_VALIDACION Registro de datos de la tabla Cgg_operacion_regla_validacion.
* @constructor
* @base FrmListadoCgg_operacion_regla_validacion
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_operacion_regla_validacion(IN_SENTENCIA_CGG_OPERACION_REGLA_VALIDACION,IN_RECORD_CGG_OPERACION_REGLA_VALIDACION){
var inSentenciaCgg_operacion_regla_validacion = IN_SENTENCIA_CGG_OPERACION_REGLA_VALIDACION;
var inRecordCgg_operacion_regla_validacion=IN_RECORD_CGG_OPERACION_REGLA_VALIDACION;
var urlCgg_operacion_regla_validacion=URL_WS+"Cgg_operacion_regla_validacion";
var tituloCgg_operacion_regla_validacion='Operacion regla validacion';
var descCgg_operacion_regla_validacion='El formulario permite administrar la informaci\u00f3n de la tabla Operacion regla validacion';
var isEdit = false;
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO OPERACION REGLA DE VALIDACION
*/
var txtCorv_codigo = new Ext.form.TextField({
id:'txtCorv_codigo',
name:'txtCorv_codigo',
fieldLabel :'Codigo',
anchor:'98%',
value:"KEYGEN",
hidden:true,
hideLabel:true,
allowBlank :false
});
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
*/
var txtCrval_codigo = new Ext.form.TextField({
id:'txtCrval_codigo',
name:'txtCrval_codigo',
fieldLabel :'Codigo',
anchor:'98%',
readOnly:'true',
allowBlank :false
});
/**
* IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
*/
var btnCrval_codigoCgg_operacion_regla_validacion = new Ext.Button({
id:'btnCrval_codigoCgg_operacion_regla_validacion',
text:'Crval_codigo',
iconCls:'iconCrval_codigo',
listeners:{
click:function(){
var tmpFLCgg_regla_validacion = new FrmListadoCgg_regla_validacion();
var objBusqueda = new DlgBusqueda(tmpFLCgg_regla_validacion.getStore(),tmpFLCgg_regla_validacion.getColumnModel());
objBusqueda.closeHandler(function(){
var tmpRecord = objBusqueda.getSelectedRow();
if(tmpRecord)
txtCrval_codigo.setValue(tmpRecord.get('CRVAL_CODIGO'));
});
objBusqueda.show();
}}
});
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE OPERACION DE VALIDACION
*/
var txtCopvl_codigo = new Ext.form.TextField({
id:'txtCopvl_codigo',
name:'txtCopvl_codigo',
fieldLabel :'Codigo',
anchor:'98%',
readOnly:'true',
allowBlank :false
});
/**
* IDENTIFICATIVO UNICO DE REGISTRO DE OPERACION DE VALIDACION
*/
var btnCopvl_codigoCgg_operacion_regla_validacion = new Ext.Button({
id:'btnCopvl_codigoCgg_operacion_regla_validacion',
text:'Copvl_codigo',
iconCls:'iconCopvl_codigo',
listeners:{
click:function(){
var tmpFLCgg_operacion_validacion = new FrmListadoCgg_operacion_validacion();
var objBusqueda = new DlgBusqueda(tmpFLCgg_operacion_validacion.getStore(),tmpFLCgg_operacion_validacion.getColumnModel());
objBusqueda.closeHandler(function(){
var tmpRecord = objBusqueda.getSelectedRow();
if(tmpRecord)
txtCopvl_codigo.setValue(tmpRecord.get('COPVL_CODIGO'));
});
objBusqueda.show();
}}
});
/**
* Ext.form.TextArea CADENA DE TEXTO DE CAMPO QUE SE VA A EVALUAR CON LA REGLA DE VALIDACION
*/
var txtCorv_campo_evaluacion = new Ext.form.TextArea({
id:'txtCorv_campo_evaluacion',
name:'txtCorv_campo_evaluacion',
fieldLabel :'Campo evaluacion',
width:'90%',
allowBlank :false
});
/**
* Ext.form.NumberField CADENA DE TEXTO DE VALOR NUMERICO AUXILIAR PARA VALORES ADICIONALES DE LA TABLA
*/
var numCorv_valor_1 = new Ext.form.NumberField({
id:'numCorv_valor_1',
name:'numCorv_valor_1',
fieldLabel :'Valor 1',
allowBlank :false,
disabled :false
});
/**
* Boton que permite almacenar la informacion de la ventana winFrmCgg_operacion_regla_validacion
*/
var btnGuardarCgg_operacion_regla_validacion = new Ext.Button({
id:'btnGuardarCgg_operacion_regla_validacion',
text:'Guardar',
iconCls:'iconGuardar',
listeners:{
click:function(){
if (pnlCgg_operacion_regla_validacion.getForm().isValid()==false){
return;
}
try{
function CallBackCgg_operacion_regla_validacion(r){
winFrmCgg_operacion_regla_validacion.getEl().unmask();
if(r=='true'){
Ext.Msg.show({
title:tituloCgg_operacion_regla_validacion,
msg: 'La informaci\u00f3n de Operacion regla validacion ha sido almacenada.',
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.INFO
});winFrmCgg_operacion_regla_validacion.close()
}else{
Ext.Msg.show({
title:tituloCgg_operacion_regla_validacion,
msg: 'La informaci\u00f3n de Operacion regla validacion no ha podido ser almacenada. '+r,
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.ERROR
});
}
}
winFrmCgg_operacion_regla_validacion.getEl().mask('Guardando...', 'x-mask-loading');
var param = new SOAPClientParameters();
if(isEdit)
param.add('inCorv_codigo',txtCorv_codigo.getValue());
param.add('inCrval_codigo',txtCrval_codigo.getValue());
param.add('inCopvl_codigo',txtCopvl_codigo.getValue());
param.add('inCorv_campo_evaluacion',txtCorv_campo_evaluacion.getValue());
param.add('inCorv_valor_1',numCorv_valor_1.getValue());
SOAPClient.invoke(urlCgg_operacion_regla_validacion,IN_SENTENCIA_CGG_OPERACION_REGLA_VALIDACION,param, true, CallBackCgg_operacion_regla_validacion);
}catch(inErr){
winFrmCgg_operacion_regla_validacion.getEl().unmask();
}
}}
});
/**
* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_operacion_regla_validacion.
*/
var btnCancelarCgg_operacion_regla_validacion = new Ext.Button({
id:'btnCancelarCgg_operacion_regla_validacion',
text:'Cancelar',
iconCls:'iconCancelar',
listeners:{
click:function(){
pnlCgg_operacion_regla_validacion.getForm().reset();
}}
});
/**
* Boton que permite cerrar la ventana winFrmCgg_operacion_regla_validacion.
*/
var btnCerrarCgg_operacion_regla_validacion = new Ext.Button({
id:'btnCerrarCgg_operacion_regla_validacion',
text:'Cerrar',
iconCls:'iconCerrar',
listeners:{
click:function(){
winFrmCgg_operacion_regla_validacion.close();
}}
});
/**
* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_operacion_regla_validacion.
*/
var pnlCgg_operacion_regla_validacion = new Ext.form.FormPanel({
frame:true,
labelWidth :100,
items:[txtCorv_codigo,{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCrval_codigo]},{columnWidth:.4,layout:'form',items:[btnCrval_codigoCgg_operacion_regla_validacion]}]},{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCopvl_codigo]},{columnWidth:.4,layout:'form',items:[btnCopvl_codigoCgg_operacion_regla_validacion]}]},txtCorv_campo_evaluacion,numCorv_valor_1]
});
/**
* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_operacion_regla_validacion.
*/
var winFrmCgg_operacion_regla_validacion = new Ext.Window({
id:'winFrmCgg_operacion_regla_validacion',
title:tituloCgg_operacion_regla_validacion,
width:400,
minWidth:400,
maximizable:true,
minimizable:true,
constrain:true,
tbar:getPanelTitulo(tituloCgg_operacion_regla_validacion,descCgg_operacion_regla_validacion),
items:[pnlCgg_operacion_regla_validacion],
bbar:[btnGuardarCgg_operacion_regla_validacion,btnCancelarCgg_operacion_regla_validacion,'->',btnCerrarCgg_operacion_regla_validacion]
});
/**
* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_operacion_regla_validacion.
* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
*/
function habilitarCgg_operacion_regla_validacionCtrls(inEstado){
estado=!inEstado;
txtCorv_codigo.setDisabled(estado);
txtCrval_codigo.setDisabled(estado);
txtCopvl_codigo.setDisabled(estado);
txtCorv_campo_evaluacion.setDisabled(estado);
numCorv_valor_1.setDisabled(estado);
}
/**
* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_operacion_regla_validacion.
*/
function cargarCgg_operacion_regla_validacionCtrls(){
if(inRecordCgg_operacion_regla_validacion){
txtCorv_codigo.setValue(inRecordCgg_operacion_regla_validacion.get('CORV_CODIGO'));
txtCrval_codigo.setValue(inRecordCgg_operacion_regla_validacion.get('CRVAL_CODIGO'));
txtCopvl_codigo.setValue(inRecordCgg_operacion_regla_validacion.get('COPVL_CODIGO'));
txtCorv_campo_evaluacion.setValue(inRecordCgg_operacion_regla_validacion.get('CORV_CAMPO_EVALUACION'));
numCorv_valor_1.setValue(inRecordCgg_operacion_regla_validacion.get('CORV_VALOR_1'));
isEdit = true;
habilitarCgg_operacion_regla_validacionCtrls(true);
}}
/**
* Funcion miembro que devuelve la ventana winFrmCgg_operacion_regla_validacion.
* @returns ventana winFrmCgg_operacion_regla_validacion.
* @base FrmCgg_operacion_regla_validacion.prototype.show
*/
this.getWindow = function(){
return winFrmCgg_operacion_regla_validacion;
}
/**
* Funcion miembro que carga los controles de la ventana winFrmCgg_operacion_regla_validacion.
* @base FrmCgg_operacion_regla_validacion.prototype.loadData
*/
this.loadData = function(){
cargarCgg_operacion_regla_validacionCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_operacion_regla_validacion desde una instancia.
*/
FrmCgg_operacion_regla_validacion.prototype.show = function(){
this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_operacion_regla_validacion desde una instancia.
*/
FrmCgg_operacion_regla_validacion.prototype.close = function(){
this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_operacion_regla_validacion,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_operacion_regla_validacion.prototype.closeHandler = function(inFunctionHandler){
this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_operacion_regla_validacion desde una instancia.
*/
FrmCgg_operacion_regla_validacion.prototype.loadData = function(){
this.loadData();
}
