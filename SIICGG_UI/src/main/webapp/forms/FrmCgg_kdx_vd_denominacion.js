/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_kdx_vd_denominacion.
* @param {String} IN_SENTENCIA_CGG_KDX_VD_DENOMINACION Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_KDX_VD_DENOMINACION Registro de datos de la tabla Cgg_kdx_vd_denominacion.
* @constructor
* @base FrmListadoCgg_kdx_vd_denominacion
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_kdx_vd_denominacion(IN_SENTENCIA_CGG_KDX_VD_DENOMINACION,IN_RECORD_CGG_KDX_VD_DENOMINACION){
var inSentenciaCgg_kdx_vd_denominacion = IN_SENTENCIA_CGG_KDX_VD_DENOMINACION;
var inRecordCgg_kdx_vd_denominacion=IN_RECORD_CGG_KDX_VD_DENOMINACION;
var urlCgg_kdx_vd_denominacion=URL_WS+"Cgg_kdx_vd_denominacion";
var tituloCgg_kdx_vd_denominacion='Kdx vd denominacion';
var descCgg_kdx_vd_denominacion='El formulario permite administrar la informaci\u00f3n de la tabla Kdx vd denominacion';
var isEdit = false;
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE  VENTA DETALLE DENOMINACION
*/
var txtCkvdd_codigo = new Ext.form.TextField({
id:'txtCkvdd_codigo',
name:'txtCkvdd_codigo',
fieldLabel :'Codigo',
anchor:'98%',
value:"KEYGEN",
hidden:true,
hideLabel:true,
allowBlank :false
});
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE VENTA
*/
var txtCkvnt_codigo = new Ext.form.TextField({
id:'txtCkvnt_codigo',
name:'txtCkvnt_codigo',
fieldLabel :'Codigo',
anchor:'98%',
readOnly:'true',
allowBlank :false
});
/**
* IDENTIFICATIVO UNICO DE REGISTRO DE VENTA
*/
var btnCkvnt_codigoCgg_kdx_vd_denominacion = new Ext.Button({
id:'btnCkvnt_codigoCgg_kdx_vd_denominacion',
text:'Ckvnt_codigo',
iconCls:'iconCkvnt_codigo',
listeners:{
click:function(){
var tmpFLCgg_kdx_venta = new FrmListadoCgg_kdx_venta();
var objBusqueda = new DlgBusqueda(tmpFLCgg_kdx_venta.getStore(),tmpFLCgg_kdx_venta.getColumnModel());
objBusqueda.closeHandler(function(){
var tmpRecord = objBusqueda.getSelectedRow();
if(tmpRecord)
txtCkvnt_codigo.setValue(tmpRecord.get('CKVNT_CODIGO'));
});
objBusqueda.show();
}}
});
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE LA DENOMINACION
*/
var txtCkdnm_codigo = new Ext.form.TextField({
id:'txtCkdnm_codigo',
name:'txtCkdnm_codigo',
fieldLabel :'Codigo',
anchor:'98%',
readOnly:'true',
allowBlank :false
});
/**
* IDENTIFICATIVO UNICO DE REGISTRO DE LA DENOMINACION
*/
var btnCkdnm_codigoCgg_kdx_vd_denominacion = new Ext.Button({
id:'btnCkdnm_codigoCgg_kdx_vd_denominacion',
text:'Ckdnm_codigo',
iconCls:'iconCkdnm_codigo',
listeners:{
click:function(){
var tmpFLCgg_kdx_denominacion = new FrmListadoCgg_kdx_denominacion();
var objBusqueda = new DlgBusqueda(tmpFLCgg_kdx_denominacion.getStore(),tmpFLCgg_kdx_denominacion.getColumnModel());
objBusqueda.closeHandler(function(){
var tmpRecord = objBusqueda.getSelectedRow();
if(tmpRecord)
txtCkdnm_codigo.setValue(tmpRecord.get('CKDNM_CODIGO'));
});
objBusqueda.show();
}}
});
/**
* Ext.form.NumberField CANTIDAD
*/
var numCkvdd_cantidad = new Ext.form.NumberField({
id:'numCkvdd_cantidad',
name:'numCkvdd_cantidad',
fieldLabel :'Cantidad',
allowBlank :false,
disabled :false
});
/**
* Ext.form.NumberField VALOR MONETARIO DE LA DENOMINACION
*/
var numCkvdd_valor = new Ext.form.NumberField({
id:'numCkvdd_valor',
name:'numCkvdd_valor',
fieldLabel :'Valor',
allowBlank :false,
disabled :false
});
/**
* Ext.form.NumberField TOTAL CONTABLE
*/
var numCkvdd_total = new Ext.form.NumberField({
id:'numCkvdd_total',
name:'numCkvdd_total',
fieldLabel :'Total',
allowBlank :false,
disabled :false
});
/**
* Boton que permite almacenar la informacion de la ventana winFrmCgg_kdx_vd_denominacion
*/
var btnGuardarCgg_kdx_vd_denominacion = new Ext.Button({
id:'btnGuardarCgg_kdx_vd_denominacion',
text:'Guardar',
iconCls:'iconGuardar',
listeners:{
click:function(){
if (pnlCgg_kdx_vd_denominacion.getForm().isValid()==false){
return;
}
try{
function CallBackCgg_kdx_vd_denominacion(r){
winFrmCgg_kdx_vd_denominacion.getEl().unmask();
if(r=='true'){
Ext.Msg.show({
title:tituloCgg_kdx_vd_denominacion,
msg: 'La informaci\u00f3n de Kdx vd denominacion ha sido almacenada.',
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.INFO
});winFrmCgg_kdx_vd_denominacion.close()
}else{
Ext.Msg.show({
title:tituloCgg_kdx_vd_denominacion,
msg: 'La informaci\u00f3n de Kdx vd denominacion no ha podido ser almacenada. '+r,
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.ERROR
});
}
}
winFrmCgg_kdx_vd_denominacion.getEl().mask('Guardando...', 'x-mask-loading');
var param = new SOAPClientParameters();
if(isEdit)
param.add('inCkvdd_codigo',txtCkvdd_codigo.getValue());
param.add('inCkvnt_codigo',txtCkvnt_codigo.getValue());
param.add('inCkdnm_codigo',txtCkdnm_codigo.getValue());
param.add('inCkvdd_cantidad',numCkvdd_cantidad.getValue());
param.add('inCkvdd_valor',numCkvdd_valor.getValue());
param.add('inCkvdd_total',numCkvdd_total.getValue());
SOAPClient.invoke(urlCgg_kdx_vd_denominacion,IN_SENTENCIA_CGG_KDX_VD_DENOMINACION,param, true, CallBackCgg_kdx_vd_denominacion);
}catch(inErr){
winFrmCgg_kdx_vd_denominacion.getEl().unmask();
}
}}
});
/**
* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_kdx_vd_denominacion.
*/
var btnCancelarCgg_kdx_vd_denominacion = new Ext.Button({
id:'btnCancelarCgg_kdx_vd_denominacion',
text:'Cancelar',
iconCls:'iconCancelar',
listeners:{
click:function(){
pnlCgg_kdx_vd_denominacion.getForm().reset();
}}
});
/**
* Boton que permite cerrar la ventana winFrmCgg_kdx_vd_denominacion.
*/
var btnCerrarCgg_kdx_vd_denominacion = new Ext.Button({
id:'btnCerrarCgg_kdx_vd_denominacion',
text:'Cerrar',
iconCls:'iconCerrar',
listeners:{
click:function(){
winFrmCgg_kdx_vd_denominacion.close();
}}
});
/**
* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_kdx_vd_denominacion.
*/
var pnlCgg_kdx_vd_denominacion = new Ext.form.FormPanel({
frame:true,
labelWidth :100,
items:[txtCkvdd_codigo,{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCkvnt_codigo]},{columnWidth:.4,layout:'form',items:[btnCkvnt_codigoCgg_kdx_vd_denominacion]}]},{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCkdnm_codigo]},{columnWidth:.4,layout:'form',items:[btnCkdnm_codigoCgg_kdx_vd_denominacion]}]},numCkvdd_cantidad,numCkvdd_valor,numCkvdd_total]
});
/**
* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_kdx_vd_denominacion.
*/
var winFrmCgg_kdx_vd_denominacion = new Ext.Window({
id:'winFrmCgg_kdx_vd_denominacion',
title:tituloCgg_kdx_vd_denominacion,
width:400,
minWidth:400,
maximizable:true,
minimizable:true,
constrain:true,
tbar:getPanelTitulo(tituloCgg_kdx_vd_denominacion,descCgg_kdx_vd_denominacion),
items:[pnlCgg_kdx_vd_denominacion],
bbar:[btnGuardarCgg_kdx_vd_denominacion,btnCancelarCgg_kdx_vd_denominacion,'->',btnCerrarCgg_kdx_vd_denominacion]
});
/**
* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_kdx_vd_denominacion.
* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
*/
function habilitarCgg_kdx_vd_denominacionCtrls(inEstado){
estado=!inEstado;
txtCkvdd_codigo.setDisabled(estado);
txtCkvnt_codigo.setDisabled(estado);
txtCkdnm_codigo.setDisabled(estado);
numCkvdd_cantidad.setDisabled(estado);
numCkvdd_valor.setDisabled(estado);
numCkvdd_total.setDisabled(estado);
}
/**
* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_kdx_vd_denominacion.
*/
function cargarCgg_kdx_vd_denominacionCtrls(){
if(inRecordCgg_kdx_vd_denominacion){
txtCkvdd_codigo.setValue(inRecordCgg_kdx_vd_denominacion.get('CKVDD_CODIGO'));
txtCkvnt_codigo.setValue(inRecordCgg_kdx_vd_denominacion.get('CKVNT_CODIGO'));
txtCkdnm_codigo.setValue(inRecordCgg_kdx_vd_denominacion.get('CKDNM_CODIGO'));
numCkvdd_cantidad.setValue(inRecordCgg_kdx_vd_denominacion.get('CKVDD_CANTIDAD'));
numCkvdd_valor.setValue(inRecordCgg_kdx_vd_denominacion.get('CKVDD_VALOR'));
numCkvdd_total.setValue(inRecordCgg_kdx_vd_denominacion.get('CKVDD_TOTAL'));
isEdit = true;
habilitarCgg_kdx_vd_denominacionCtrls(true);
}}
/**
* Funcion miembro que devuelve la ventana winFrmCgg_kdx_vd_denominacion.
* @returns ventana winFrmCgg_kdx_vd_denominacion.
* @base FrmCgg_kdx_vd_denominacion.prototype.show
*/
this.getWindow = function(){
return winFrmCgg_kdx_vd_denominacion;
}
/**
* Funcion miembro que carga los controles de la ventana winFrmCgg_kdx_vd_denominacion.
* @base FrmCgg_kdx_vd_denominacion.prototype.loadData
*/
this.loadData = function(){
cargarCgg_kdx_vd_denominacionCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_kdx_vd_denominacion desde una instancia.
*/
FrmCgg_kdx_vd_denominacion.prototype.show = function(){
this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_kdx_vd_denominacion desde una instancia.
*/
FrmCgg_kdx_vd_denominacion.prototype.close = function(){
this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_kdx_vd_denominacion,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_kdx_vd_denominacion.prototype.closeHandler = function(inFunctionHandler){
this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_kdx_vd_denominacion desde una instancia.
*/
FrmCgg_kdx_vd_denominacion.prototype.loadData = function(){
this.loadData();
}
