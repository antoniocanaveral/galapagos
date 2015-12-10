/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_kdx_venta_cierre.
* @param {String} IN_SENTENCIA_CGG_KDX_VENTA_CIERRE Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_KDX_VENTA_CIERRE Registro de datos de la tabla Cgg_kdx_venta_cierre.
* @constructor
* @base FrmListadoCgg_kdx_venta_cierre
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_kdx_venta_cierre(IN_SENTENCIA_CGG_KDX_VENTA_CIERRE,IN_RECORD_CGG_KDX_VENTA_CIERRE){
var inSentenciaCgg_kdx_venta_cierre = IN_SENTENCIA_CGG_KDX_VENTA_CIERRE;
var inRecordCgg_kdx_venta_cierre=IN_RECORD_CGG_KDX_VENTA_CIERRE;
var urlCgg_kdx_venta_cierre=URL_WS+"Cgg_kdx_venta_cierre";
var tituloCgg_kdx_venta_cierre='Kdx venta cierre';
var descCgg_kdx_venta_cierre='El formulario permite administrar la informaci\u00f3n de la tabla Kdx venta cierre';
var isEdit = false;
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE VENTA CIERRE
*/
var txtCkvtc_codigo = new Ext.form.TextField({
id:'txtCkvtc_codigo',
name:'txtCkvtc_codigo',
fieldLabel :'Codigo',
anchor:'98%',
value:"KEYGEN",
hidden:true,
hideLabel:true,
allowBlank :false
});
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE  VENTA
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
* IDENTIFICATIVO UNICO DE REGISTRO DE  VENTA
*/
var btnCkvnt_codigoCgg_kdx_venta_cierre = new Ext.Button({
id:'btnCkvnt_codigoCgg_kdx_venta_cierre',
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
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CIERRE DE CAJA
*/
var txtCkcrr_codigo = new Ext.form.TextField({
id:'txtCkcrr_codigo',
name:'txtCkcrr_codigo',
fieldLabel :'Codigo',
anchor:'98%',
readOnly:'true',
allowBlank :false
});
/**
* IDENTIFICATIVO UNICO DE REGISTRO DE CIERRE DE CAJA
*/
var btnCkcrr_codigoCgg_kdx_venta_cierre = new Ext.Button({
id:'btnCkcrr_codigoCgg_kdx_venta_cierre',
text:'Ckcrr_codigo',
iconCls:'iconCkcrr_codigo',
listeners:{
click:function(){
var tmpFLCgg_kdx_cierre = new FrmListadoCgg_kdx_cierre();
var objBusqueda = new DlgBusqueda(tmpFLCgg_kdx_cierre.getStore(),tmpFLCgg_kdx_cierre.getColumnModel());
objBusqueda.closeHandler(function(){
var tmpRecord = objBusqueda.getSelectedRow();
if(tmpRecord)
txtCkcrr_codigo.setValue(tmpRecord.get('CKCRR_CODIGO'));
});
objBusqueda.show();
}}
});
/**
* Boton que permite almacenar la informacion de la ventana winFrmCgg_kdx_venta_cierre
*/
var btnGuardarCgg_kdx_venta_cierre = new Ext.Button({
id:'btnGuardarCgg_kdx_venta_cierre',
text:'Guardar',
iconCls:'iconGuardar',
listeners:{
click:function(){
if (!pnlCgg_kdx_venta_cierre.getForm().isValid()){
return;
}
try{
function CallBackCgg_kdx_venta_cierre(r){
winFrmCgg_kdx_venta_cierre.getEl().unmask();
if(r=='true'){
Ext.Msg.show({
title:tituloCgg_kdx_venta_cierre,
msg: 'La informaci\u00f3n de Kdx venta cierre ha sido almacenada.',
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.INFO
});winFrmCgg_kdx_venta_cierre.close()
}else{
Ext.Msg.show({
title:tituloCgg_kdx_venta_cierre,
msg: 'La informaci\u00f3n de Kdx venta cierre no ha podido ser almacenada. '+(r.message?r.message:r),
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.ERROR
});
}
}
winFrmCgg_kdx_venta_cierre.getEl().mask('Guardando...', 'x-mask-loading');
var param = new SOAPClientParameters();
if(isEdit)
param.add('inCkvtc_codigo',txtCkvtc_codigo.getValue());
param.add('inCkvnt_codigo',txtCkvnt_codigo.getValue());
param.add('inCkcrr_codigo',txtCkcrr_codigo.getValue());
SOAPClient.invoke(urlCgg_kdx_venta_cierre,IN_SENTENCIA_CGG_KDX_VENTA_CIERRE,param, true, CallBackCgg_kdx_venta_cierre);
}catch(inErr){
winFrmCgg_kdx_venta_cierre.getEl().unmask();
}
}}
});
/**
* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_kdx_venta_cierre.
*/
var btnCancelarCgg_kdx_venta_cierre = new Ext.Button({
id:'btnCancelarCgg_kdx_venta_cierre',
text:'Cancelar',
iconCls:'iconCancelar',
listeners:{
click:function(){
pnlCgg_kdx_venta_cierre.getForm().reset();
}}
});
/**
* Boton que permite cerrar la ventana winFrmCgg_kdx_venta_cierre.
*/
var btnCerrarCgg_kdx_venta_cierre = new Ext.Button({
id:'btnCerrarCgg_kdx_venta_cierre',
text:'Cerrar',
iconCls:'iconCerrar',
listeners:{
click:function(){
winFrmCgg_kdx_venta_cierre.close();
}}
});
/**
* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_kdx_venta_cierre.
*/
var pnlCgg_kdx_venta_cierre = new Ext.form.FormPanel({
frame:true,
labelWidth :100,
items:[txtCkvtc_codigo,{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCkvnt_codigo]},{columnWidth:.4,layout:'form',items:[btnCkvnt_codigoCgg_kdx_venta_cierre]}]},{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCkcrr_codigo]},{columnWidth:.4,layout:'form',items:[btnCkcrr_codigoCgg_kdx_venta_cierre]}]}]
});
/**
* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_kdx_venta_cierre.
*/
var winFrmCgg_kdx_venta_cierre = new Ext.Window({
id:'winFrmCgg_kdx_venta_cierre',
title:tituloCgg_kdx_venta_cierre,
iconCls:'iconAplicacion',
width:400,
minWidth:400,
maximizable:true,
minimizable:true,
constrain:true,
tbar:getPanelTitulo(tituloCgg_kdx_venta_cierre,descCgg_kdx_venta_cierre),
items:[pnlCgg_kdx_venta_cierre],
bbar:[btnGuardarCgg_kdx_venta_cierre,btnCancelarCgg_kdx_venta_cierre,'->',btnCerrarCgg_kdx_venta_cierre]
});
/**
* Funcion que aplica los privilegios del usuario.
*/
applyGrants(winFrmCgg_kdx_venta_cierre.getBottomToolbar());
/**
* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_kdx_venta_cierre.
* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
*/
function habilitarCgg_kdx_venta_cierreCtrls(inEstado){
estado=!inEstado;
txtCkvtc_codigo.setDisabled(estado);
txtCkvnt_codigo.setDisabled(estado);
txtCkcrr_codigo.setDisabled(estado);
}
/**
* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_kdx_venta_cierre.
*/
function cargarCgg_kdx_venta_cierreCtrls(){
if(inRecordCgg_kdx_venta_cierre){
txtCkvtc_codigo.setValue(inRecordCgg_kdx_venta_cierre.get('CKVTC_CODIGO'));
txtCkvnt_codigo.setValue(inRecordCgg_kdx_venta_cierre.get('CKVNT_CODIGO'));
txtCkcrr_codigo.setValue(inRecordCgg_kdx_venta_cierre.get('CKCRR_CODIGO'));
isEdit = true;
habilitarCgg_kdx_venta_cierreCtrls(true);
}}
/**
* Funcion miembro que devuelve la ventana winFrmCgg_kdx_venta_cierre.
* @returns ventana winFrmCgg_kdx_venta_cierre.
* @base FrmCgg_kdx_venta_cierre.prototype.show
*/
this.getWindow = function(){
return winFrmCgg_kdx_venta_cierre;
}
/**
* Funcion miembro que carga los controles de la ventana winFrmCgg_kdx_venta_cierre.
* @base FrmCgg_kdx_venta_cierre.prototype.loadData
*/
this.loadData = function(){
cargarCgg_kdx_venta_cierreCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_kdx_venta_cierre desde una instancia.
*/
FrmCgg_kdx_venta_cierre.prototype.show = function(){
this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_kdx_venta_cierre desde una instancia.
*/
FrmCgg_kdx_venta_cierre.prototype.close = function(){
this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_kdx_venta_cierre,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_kdx_venta_cierre.prototype.closeHandler = function(inFunctionHandler){
this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_kdx_venta_cierre desde una instancia.
*/
FrmCgg_kdx_venta_cierre.prototype.loadData = function(){
this.loadData();
}
