/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_kdx_venta_detalle.
* @param {String} IN_SENTENCIA_CGG_KDX_VENTA_DETALLE Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_KDX_VENTA_DETALLE Registro de datos de la tabla Cgg_kdx_venta_detalle.
* @constructor
* @base FrmListadoCgg_kdx_venta_detalle
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_kdx_venta_detalle(IN_SENTENCIA_CGG_KDX_VENTA_DETALLE,IN_RECORD_CGG_KDX_VENTA_DETALLE){
var inSentenciaCgg_kdx_venta_detalle = IN_SENTENCIA_CGG_KDX_VENTA_DETALLE;
var inRecordCgg_kdx_venta_detalle=IN_RECORD_CGG_KDX_VENTA_DETALLE;
var urlCgg_kdx_venta_detalle=URL_WS+"Cgg_kdx_venta_detalle";
var tituloCgg_kdx_venta_detalle='Kdx venta detalle';
var descCgg_kdx_venta_detalle='El formulario permite administrar la informaci\u00f3n de la tabla Kdx venta detalle';
var isEdit = false;
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE LA VENTA DETALLE
*/
var txtCkvdt_codigo = new Ext.form.TextField({
id:'txtCkvdt_codigo',
name:'txtCkvdt_codigo',
fieldLabel :'Codigo',
anchor:'98%',
value:"KEYGEN",
hidden:true,
hideLabel:true,
allowBlank :false
});
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE LA VENTA
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
* IDENTIFICATIVO UNICO DE REGISTRO DE LA VENTA
*/
var btnCkvnt_codigoCgg_kdx_venta_detalle = new Ext.Button({
id:'btnCkvnt_codigoCgg_kdx_venta_detalle',
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
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES
*/
var txtCkesp_codigo = new Ext.form.TextField({
id:'txtCkesp_codigo',
name:'txtCkesp_codigo',
fieldLabel :'Codigo',
anchor:'98%',
readOnly:'true',
allowBlank :false
});
/**
* IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES
*/
var btnCkesp_codigoCgg_kdx_venta_detalle = new Ext.Button({
id:'btnCkesp_codigoCgg_kdx_venta_detalle',
text:'Ckesp_codigo',
iconCls:'iconCkesp_codigo',
listeners:{
click:function(){
var tmpFLCgg_kdx_especie = new FrmListadoCgg_kdx_especie();
var objBusqueda = new DlgBusqueda(tmpFLCgg_kdx_especie.getStore(),tmpFLCgg_kdx_especie.getColumnModel());
objBusqueda.closeHandler(function(){
var tmpRecord = objBusqueda.getSelectedRow();
if(tmpRecord)
txtCkesp_codigo.setValue(tmpRecord.get('CKESP_CODIGO'));
});
objBusqueda.show();
}}
});
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TCT
*/
var txtCtreg_codigo = new Ext.form.TextField({
id:'txtCtreg_codigo',
name:'txtCtreg_codigo',
fieldLabel :'Codigo',
anchor:'98%',
readOnly:'true',
allowBlank :false
});
/**
* IDENTIFICATIVO UNICO DE REGISTRO DE TCT
*/
var btnCtreg_codigoCgg_kdx_venta_detalle = new Ext.Button({
id:'btnCtreg_codigoCgg_kdx_venta_detalle',
text:'Ctreg_codigo',
iconCls:'iconCtreg_codigo',
listeners:{
click:function(){
var tmpFLCgg_tct_registro = new FrmListadoCgg_tct_registro();
var objBusqueda = new DlgBusqueda(tmpFLCgg_tct_registro.getStore(),tmpFLCgg_tct_registro.getColumnModel());
objBusqueda.closeHandler(function(){
var tmpRecord = objBusqueda.getSelectedRow();
if(tmpRecord)
txtCtreg_codigo.setValue(tmpRecord.get('CTREG_CODIGO'));
});
objBusqueda.show();
}}
});
/**
* Ext.form.NumberField CANTIDAD DE ESPECIES
*/
var numCkvdt_cantidad = new Ext.form.NumberField({
id:'numCkvdt_cantidad',
name:'numCkvdt_cantidad',
fieldLabel :'Cantidad',
allowBlank :false,
disabled :false
});
/**
* Ext.form.NumberField SERIE DE INICIO DE LAS ESPECIES
*/
var numCkvdt_serie = new Ext.form.NumberField({
id:'numCkvdt_serie',
name:'numCkvdt_serie',
fieldLabel :'Serie',
allowBlank :false,
disabled :false
});
/**
* Ext.form.NumberField PRECIO UNITARIO DE LA ESPECIE
*/
var numCkvdt_precio_unitario = new Ext.form.NumberField({
id:'numCkvdt_precio_unitario',
name:'numCkvdt_precio_unitario',
fieldLabel :'Precio unitario',
allowBlank :false,
disabled :false
});
/**
* Ext.form.NumberField TOTAL DE LA COMPRA
*/
var numCkvdt_total = new Ext.form.NumberField({
id:'numCkvdt_total',
name:'numCkvdt_total',
fieldLabel :'Total',
allowBlank :false,
disabled :false
});
/**
* Boton que permite almacenar la informacion de la ventana winFrmCgg_kdx_venta_detalle
*/
var btnGuardarCgg_kdx_venta_detalle = new Ext.Button({
id:'btnGuardarCgg_kdx_venta_detalle',
text:'Guardar',
iconCls:'iconGuardar',
listeners:{
click:function(){
if (pnlCgg_kdx_venta_detalle.getForm().isValid()==false){
return;
}
try{
function CallBackCgg_kdx_venta_detalle(r){
winFrmCgg_kdx_venta_detalle.getEl().unmask();
if(r=='true'){
Ext.Msg.show({
title:tituloCgg_kdx_venta_detalle,
msg: 'La informaci\u00f3n de Kdx venta detalle ha sido almacenada.',
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.INFO
});winFrmCgg_kdx_venta_detalle.close()
}else{
Ext.Msg.show({
title:tituloCgg_kdx_venta_detalle,
msg: 'La informaci\u00f3n de Kdx venta detalle no ha podido ser almacenada. '+(r.message?r.message:r),
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.ERROR
});
}
}
winFrmCgg_kdx_venta_detalle.getEl().mask('Guardando...', 'x-mask-loading');
var param = new SOAPClientParameters();
if(isEdit)
param.add('inCkvdt_codigo',txtCkvdt_codigo.getValue());
param.add('inCkvnt_codigo',txtCkvnt_codigo.getValue());
param.add('inCkesp_codigo',txtCkesp_codigo.getValue());
param.add('inCtreg_codigo',txtCtreg_codigo.getValue());
param.add('inCkvdt_cantidad',numCkvdt_cantidad.getValue());
param.add('inCkvdt_serie',numCkvdt_serie.getValue());
param.add('inCkvdt_precio_unitario',numCkvdt_precio_unitario.getValue());
param.add('inCkvdt_total',numCkvdt_total.getValue());
SOAPClient.invoke(urlCgg_kdx_venta_detalle,IN_SENTENCIA_CGG_KDX_VENTA_DETALLE,param, true, CallBackCgg_kdx_venta_detalle);
}catch(inErr){
winFrmCgg_kdx_venta_detalle.getEl().unmask();
}
}}
});
/**
* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_kdx_venta_detalle.
*/
var btnCancelarCgg_kdx_venta_detalle = new Ext.Button({
id:'btnCancelarCgg_kdx_venta_detalle',
text:'Cancelar',
iconCls:'iconCancelar',
listeners:{
click:function(){
pnlCgg_kdx_venta_detalle.getForm().reset();
}}
});
/**
* Boton que permite cerrar la ventana winFrmCgg_kdx_venta_detalle.
*/
var btnCerrarCgg_kdx_venta_detalle = new Ext.Button({
id:'btnCerrarCgg_kdx_venta_detalle',
text:'Cerrar',
iconCls:'iconCerrar',
listeners:{
click:function(){
winFrmCgg_kdx_venta_detalle.close();
}}
});
/**
* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_kdx_venta_detalle.
*/
var pnlCgg_kdx_venta_detalle = new Ext.form.FormPanel({
frame:true,
labelWidth :100,
items:[txtCkvdt_codigo,{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCkvnt_codigo]},{columnWidth:.4,layout:'form',items:[btnCkvnt_codigoCgg_kdx_venta_detalle]}]},{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCkesp_codigo]},{columnWidth:.4,layout:'form',items:[btnCkesp_codigoCgg_kdx_venta_detalle]}]},{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCtreg_codigo]},{columnWidth:.4,layout:'form',items:[btnCtreg_codigoCgg_kdx_venta_detalle]}]},numCkvdt_cantidad,numCkvdt_serie,numCkvdt_precio_unitario,numCkvdt_total]
});
/**
* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_kdx_venta_detalle.
*/
var winFrmCgg_kdx_venta_detalle = new Ext.Window({
id:'winFrmCgg_kdx_venta_detalle',
title:tituloCgg_kdx_venta_detalle,
width:400,
minWidth:400,
maximizable:true,
minimizable:true,
constrain:true,
tbar:getPanelTitulo(tituloCgg_kdx_venta_detalle,descCgg_kdx_venta_detalle),
items:[pnlCgg_kdx_venta_detalle],
bbar:[btnGuardarCgg_kdx_venta_detalle,btnCancelarCgg_kdx_venta_detalle,'->',btnCerrarCgg_kdx_venta_detalle]
});
/**
* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_kdx_venta_detalle.
* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
*/
function habilitarCgg_kdx_venta_detalleCtrls(inEstado){
estado=!inEstado;
txtCkvdt_codigo.setDisabled(estado);
txtCkvnt_codigo.setDisabled(estado);
txtCkesp_codigo.setDisabled(estado);
txtCtreg_codigo.setDisabled(estado);
numCkvdt_cantidad.setDisabled(estado);
numCkvdt_serie.setDisabled(estado);
numCkvdt_precio_unitario.setDisabled(estado);
numCkvdt_total.setDisabled(estado);
}
/**
* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_kdx_venta_detalle.
*/
function cargarCgg_kdx_venta_detalleCtrls(){
if(inRecordCgg_kdx_venta_detalle){
txtCkvdt_codigo.setValue(inRecordCgg_kdx_venta_detalle.get('CKVDT_CODIGO'));
txtCkvnt_codigo.setValue(inRecordCgg_kdx_venta_detalle.get('CKVNT_CODIGO'));
txtCkesp_codigo.setValue(inRecordCgg_kdx_venta_detalle.get('CKESP_CODIGO'));
txtCtreg_codigo.setValue(inRecordCgg_kdx_venta_detalle.get('CTREG_CODIGO'));
numCkvdt_cantidad.setValue(inRecordCgg_kdx_venta_detalle.get('CKVDT_CANTIDAD'));
numCkvdt_serie.setValue(inRecordCgg_kdx_venta_detalle.get('CKVDT_SERIE'));
numCkvdt_precio_unitario.setValue(inRecordCgg_kdx_venta_detalle.get('CKVDT_PRECIO_UNITARIO'));
numCkvdt_total.setValue(inRecordCgg_kdx_venta_detalle.get('CKVDT_TOTAL'));
isEdit = true;
habilitarCgg_kdx_venta_detalleCtrls(true);
}}
/**
* Funcion miembro que devuelve la ventana winFrmCgg_kdx_venta_detalle.
* @returns ventana winFrmCgg_kdx_venta_detalle.
* @base FrmCgg_kdx_venta_detalle.prototype.show
*/
this.getWindow = function(){
return winFrmCgg_kdx_venta_detalle;
}
/**
* Funcion miembro que carga los controles de la ventana winFrmCgg_kdx_venta_detalle.
* @base FrmCgg_kdx_venta_detalle.prototype.loadData
*/
this.loadData = function(){
cargarCgg_kdx_venta_detalleCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_kdx_venta_detalle desde una instancia.
*/
FrmCgg_kdx_venta_detalle.prototype.show = function(){
this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_kdx_venta_detalle desde una instancia.
*/
FrmCgg_kdx_venta_detalle.prototype.close = function(){
this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_kdx_venta_detalle,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_kdx_venta_detalle.prototype.closeHandler = function(inFunctionHandler){
this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_kdx_venta_detalle desde una instancia.
*/
FrmCgg_kdx_venta_detalle.prototype.loadData = function(){
this.loadData();
}
