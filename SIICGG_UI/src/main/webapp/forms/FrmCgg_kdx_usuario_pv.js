/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_kdx_usuario_pv.
* @param {String} IN_SENTENCIA_CGG_KDX_USUARIO_PV Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_KDX_USUARIO_PV Registro de datos de la tabla Cgg_kdx_usuario_pv.
* @constructor
* @base FrmListadoCgg_kdx_usuario_pv
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_kdx_usuario_pv(IN_SENTENCIA_CGG_KDX_USUARIO_PV,IN_RECORD_CGG_KDX_USUARIO_PV){
var inSentenciaCgg_kdx_usuario_pv = IN_SENTENCIA_CGG_KDX_USUARIO_PV;
var inRecordCgg_kdx_usuario_pv=IN_RECORD_CGG_KDX_USUARIO_PV;
var urlCgg_kdx_usuario_pv=URL_WS+"Cgg_kdx_usuario_pv";
var tituloCgg_kdx_usuario_pv='Kdx usuario pv';
var descCgg_kdx_usuario_pv='El formulario permite administrar la informaci\u00f3n de la tabla Kdx usuario pv';
var isEdit = false;
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
*/
var txtCkupv_codigo = new Ext.form.TextField({
id:'txtCkupv_codigo',
name:'txtCkupv_codigo',
fieldLabel :'Codigo',
anchor:'98%',
value:"KEYGEN",
hidden:true,
hideLabel:true,
allowBlank :false
});
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA 
*/
var txtCkpvt_codigo = new Ext.form.TextField({
id:'txtCkpvt_codigo',
name:'txtCkpvt_codigo',
fieldLabel :'Codigo',
anchor:'98%',
readOnly:'true',
allowBlank :false
});
/**
* IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA 
*/
var btnCkpvt_codigoCgg_kdx_usuario_pv = new Ext.Button({
id:'btnCkpvt_codigoCgg_kdx_usuario_pv',
text:'Ckpvt_codigo',
iconCls:'iconCkpvt_codigo',
listeners:{
click:function(){
var tmpFLCgg_kdx_punto_venta = new FrmListadoCgg_kdx_punto_venta();
var objBusqueda = new DlgBusqueda(tmpFLCgg_kdx_punto_venta.getStore(),tmpFLCgg_kdx_punto_venta.getColumnModel());
objBusqueda.closeHandler(function(){
var tmpRecord = objBusqueda.getSelectedRow();
if(tmpRecord)
txtCkpvt_codigo.setValue(tmpRecord.get('CKPVT_CODIGO'));
});
objBusqueda.show();
}}
});
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
*/
var txtCusu_codigo = new Ext.form.TextField({
id:'txtCusu_codigo',
name:'txtCusu_codigo',
fieldLabel :'Codigo',
anchor:'98%',
readOnly:'true',
allowBlank :false
});
/**
* IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
*/
var btnCusu_codigoCgg_kdx_usuario_pv = new Ext.Button({
id:'btnCusu_codigoCgg_kdx_usuario_pv',
text:'Cusu_codigo',
iconCls:'iconCusu_codigo',
listeners:{
click:function(){
var tmpFLCgg_usuario = new FrmListadoCgg_usuario();
var objBusqueda = new DlgBusqueda(tmpFLCgg_usuario.getStore(),tmpFLCgg_usuario.getColumnModel());
objBusqueda.closeHandler(function(){
var tmpRecord = objBusqueda.getSelectedRow();
if(tmpRecord)
txtCusu_codigo.setValue(tmpRecord.get('CUSU_CODIGO'));
});
objBusqueda.show();
}}
});
/**
* Ext.form.Checkbox ESTADO QUE DETERMINA SI EL USUARIO SE HALLA ACTIVO EN EL PUNTO DE VENTA
*/
var chkCkpvt_activo = new Ext.form.Checkbox({
id:'chkCkpvt_activo',
name:'chkCkpvt_activo',
fieldLabel :'Activo',
allowBlank :false,
checked:true
});
/**
* Boton que permite almacenar la informacion de la ventana winFrmCgg_kdx_usuario_pv
*/
var btnGuardarCgg_kdx_usuario_pv = new Ext.Button({
id:'btnGuardarCgg_kdx_usuario_pv',
text:'Guardar',
iconCls:'iconGuardar',
listeners:{
click:function(){
if (pnlCgg_kdx_usuario_pv.getForm().isValid()==false){
return;
}
try{
function CallBackCgg_kdx_usuario_pv(r){
winFrmCgg_kdx_usuario_pv.getEl().unmask();
if(r=='true'){
Ext.Msg.show({
title:tituloCgg_kdx_usuario_pv,
msg: 'La informaci\u00f3n de Kdx usuario pv ha sido almacenada.',
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.INFO
});winFrmCgg_kdx_usuario_pv.close()
}else{
Ext.Msg.show({
title:tituloCgg_kdx_usuario_pv,
msg: 'La informaci\u00f3n de Kdx usuario pv no ha podido ser almacenada. '+(r.message?r.message:r),
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.ERROR
});
}
}
winFrmCgg_kdx_usuario_pv.getEl().mask('Guardando...', 'x-mask-loading');
var param = new SOAPClientParameters();
if(isEdit)
param.add('inCkupv_codigo',txtCkupv_codigo.getValue());
param.add('inCkpvt_codigo',txtCkpvt_codigo.getValue());
param.add('inCusu_codigo',txtCusu_codigo.getValue());
param.add('inCkpvt_activo',chkCkpvt_activo.getValue());
SOAPClient.invoke(urlCgg_kdx_usuario_pv,IN_SENTENCIA_CGG_KDX_USUARIO_PV,param, true, CallBackCgg_kdx_usuario_pv);
}catch(inErr){
winFrmCgg_kdx_usuario_pv.getEl().unmask();
}
}}
});
/**
* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_kdx_usuario_pv.
*/
var btnCancelarCgg_kdx_usuario_pv = new Ext.Button({
id:'btnCancelarCgg_kdx_usuario_pv',
text:'Cancelar',
iconCls:'iconCancelar',
listeners:{
click:function(){
pnlCgg_kdx_usuario_pv.getForm().reset();
}}
});
/**
* Boton que permite cerrar la ventana winFrmCgg_kdx_usuario_pv.
*/
var btnCerrarCgg_kdx_usuario_pv = new Ext.Button({
id:'btnCerrarCgg_kdx_usuario_pv',
text:'Cerrar',
iconCls:'iconCerrar',
listeners:{
click:function(){
winFrmCgg_kdx_usuario_pv.close();
}}
});
/**
* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_kdx_usuario_pv.
*/
var pnlCgg_kdx_usuario_pv = new Ext.form.FormPanel({
frame:true,
labelWidth :100,
items:[txtCkupv_codigo,{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCkpvt_codigo]},{columnWidth:.4,layout:'form',items:[btnCkpvt_codigoCgg_kdx_usuario_pv]}]},{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCusu_codigo]},{columnWidth:.4,layout:'form',items:[btnCusu_codigoCgg_kdx_usuario_pv]}]},chkCkpvt_activo]
});
/**
* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_kdx_usuario_pv.
*/
var winFrmCgg_kdx_usuario_pv = new Ext.Window({
id:'winFrmCgg_kdx_usuario_pv',
title:tituloCgg_kdx_usuario_pv,
width:400,
minWidth:400,
maximizable:true,
minimizable:true,
constrain:true,
tbar:getPanelTitulo(tituloCgg_kdx_usuario_pv,descCgg_kdx_usuario_pv),
items:[pnlCgg_kdx_usuario_pv],
bbar:[btnGuardarCgg_kdx_usuario_pv,btnCancelarCgg_kdx_usuario_pv,'->',btnCerrarCgg_kdx_usuario_pv]
});
/**
* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_kdx_usuario_pv.
* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
*/
function habilitarCgg_kdx_usuario_pvCtrls(inEstado){
estado=!inEstado;
txtCkupv_codigo.setDisabled(estado);
txtCkpvt_codigo.setDisabled(estado);
txtCusu_codigo.setDisabled(estado);
chkCkpvt_activo.setDisabled(estado);
}
/**
* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_kdx_usuario_pv.
*/
function cargarCgg_kdx_usuario_pvCtrls(){
if(inRecordCgg_kdx_usuario_pv){
txtCkupv_codigo.setValue(inRecordCgg_kdx_usuario_pv.get('CKUPV_CODIGO'));
txtCkpvt_codigo.setValue(inRecordCgg_kdx_usuario_pv.get('CKPVT_CODIGO'));
txtCusu_codigo.setValue(inRecordCgg_kdx_usuario_pv.get('CUSU_CODIGO'));
chkCkpvt_activo.setValue(inRecordCgg_kdx_usuario_pv.get('CKPVT_ACTIVO'));
isEdit = true;
habilitarCgg_kdx_usuario_pvCtrls(true);
}}
/**
* Funcion miembro que devuelve la ventana winFrmCgg_kdx_usuario_pv.
* @returns ventana winFrmCgg_kdx_usuario_pv.
* @base FrmCgg_kdx_usuario_pv.prototype.show
*/
this.getWindow = function(){
return winFrmCgg_kdx_usuario_pv;
}
/**
* Funcion miembro que carga los controles de la ventana winFrmCgg_kdx_usuario_pv.
* @base FrmCgg_kdx_usuario_pv.prototype.loadData
*/
this.loadData = function(){
cargarCgg_kdx_usuario_pvCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_kdx_usuario_pv desde una instancia.
*/
FrmCgg_kdx_usuario_pv.prototype.show = function(){
this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_kdx_usuario_pv desde una instancia.
*/
FrmCgg_kdx_usuario_pv.prototype.close = function(){
this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_kdx_usuario_pv,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_kdx_usuario_pv.prototype.closeHandler = function(inFunctionHandler){
this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_kdx_usuario_pv desde una instancia.
*/
FrmCgg_kdx_usuario_pv.prototype.loadData = function(){
this.loadData();
}
