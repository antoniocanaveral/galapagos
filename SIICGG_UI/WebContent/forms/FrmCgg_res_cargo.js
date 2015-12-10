/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_cargo.
* @param {String} IN_SENTENCIA_CGG_RES_CARGO Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_RES_CARGO Registro de datos de la tabla Cgg_res_cargo.
* @constructor
* @base FrmListadoCgg_res_cargo
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_res_cargo(IN_SENTENCIA_CGG_RES_CARGO,IN_RECORD_CGG_RES_CARGO){
var optMenu = 'Res cargo';
var inSentenciaCgg_res_cargo = IN_SENTENCIA_CGG_RES_CARGO;
var inRecordCgg_res_cargo=IN_RECORD_CGG_RES_CARGO;
var urlCgg_res_cargo=URL_WS+"Cgg_res_cargo";
var tituloCgg_res_cargo='Res cargo';
var descCgg_res_cargo='El formulario permite administrar la informaci\u00f3n de la tabla Res cargo';
var isEdit = false;
var txtCrsec_codigo_cod ="";
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
*/
var txtCrcrg_codigo = new Ext.form.TextField({
id:'txtCrcrg_codigo',
name:'txtCrcrg_codigo',
fieldLabel :'Codigo',
anchor:'98%',
value:"KEYGEN",
hidden:true,
hideLabel:true,
allowBlank :false
});
/**
* Ext.form.TextField NOMBRE DEL CARGO
*/
var txtCrcrg_nombre = new Ext.form.TextField({
id:'txtCrcrg_nombre',
name:'txtCrcrg_nombre',
fieldLabel :'Nombre',
anchor:'98%',
allowBlank :false
});
/**
* Ext.form.TextField NO ESPECIFICADO
*/
var txtCrsec_codigo = new Ext.form.TextField({
id:'txtCrsec_codigo',
name:'txtCrsec_codigo',
fieldLabel :'Secci\u00f3n',
anchor:'98%',
readOnly:'true',
allowBlank :false
});
/**
* NO ESPECIFICADO
*/
var btnCrsec_codigoCgg_res_cargo = new Ext.Button({
id:'btnCrsec_codigoCgg_res_cargo',
text:'',
iconCls:'iconBuscar',
listeners:{
click:function(){
var tmpFLCgg_res_seccion = new FrmListadoCgg_res_seccion();
var objBusqueda = new DlgBusqueda(tmpFLCgg_res_seccion.getStore(),tmpFLCgg_res_seccion.getColumnModel());
objBusqueda.closeHandler(function(){
var tmpRecord = objBusqueda.getSelectedRow();
if(tmpRecord){
txtCrsec_codigo_cod=tmpRecord.get('CRSEC_CODIGO');
txtCrsec_codigo.setValue(tmpRecord.get('CRSEC_NOMBRE'));
}
});
objBusqueda.show();
}}
});
/**
* Boton que permite almacenar la informacion de la ventana winFrmCgg_res_cargo
*/
var btnGuardarCgg_res_cargo = new Ext.Button({
id:'btnGuardarCgg_res_cargo',
text:'Guardar',
iconCls:'iconGuardar',
listeners:{
click:function(){
if (!pnlCgg_res_cargo.getForm().isValid()){
return;
}
try{
function CallBackCgg_res_cargo(r){
winFrmCgg_res_cargo.getEl().unmask();
if(r=='true'){
Ext.Msg.show({
title:tituloCgg_res_cargo,
msg: 'La informaci\u00f3n de cargo ha sido almacenada.',
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.INFO
});winFrmCgg_res_cargo.close()
}else{
Ext.Msg.show({
title:tituloCgg_res_cargo,
msg: 'La informaci\u00f3n de cargo no ha podido ser almacenada. '+(r.message?r.message:r),
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.ERROR
});
}
}
winFrmCgg_res_cargo.getEl().mask('Guardando...', 'x-mask-loading');
var param = new SOAPClientParameters();
if(isEdit)
param.add('inCrcrg_codigo',txtCrcrg_codigo.getValue());
param.add('inCrcrg_nombre',txtCrcrg_nombre.getValue());
param.add('inCrsec_codigo',txtCrsec_codigo_cod);
SOAPClient.invoke(urlCgg_res_cargo,IN_SENTENCIA_CGG_RES_CARGO,param, true, CallBackCgg_res_cargo);
}catch(inErr){
winFrmCgg_res_cargo.getEl().unmask();
}
}}
});
/**
* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_cargo.
*/
var btnCancelarCgg_res_cargo = new Ext.Button({
id:'btnCancelarCgg_res_cargo',
text:'Cancelar',
iconCls:'iconCancelar',
listeners:{
click:function(){
pnlCgg_res_cargo.getForm().reset();
}}
});
/**
* Boton que permite cerrar la ventana winFrmCgg_res_cargo.
*/
var btnCerrarCgg_res_cargo = new Ext.Button({
id:'btnCerrarCgg_res_cargo',
text:'Cerrar',
iconCls:'iconCerrar',
listeners:{
click:function(){
winFrmCgg_res_cargo.close();
}}
});
/**
* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_cargo.
*/
var pnlCgg_res_cargo = new Ext.form.FormPanel({
frame:true,
labelWidth :100,
items:[txtCrcrg_codigo,txtCrcrg_nombre,{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCrsec_codigo]},{columnWidth:.4,layout:'form',items:[btnCrsec_codigoCgg_res_cargo]}]}]
});
/**
* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_cargo.
*/
var winFrmCgg_res_cargo = new Ext.Window({
id:'winFrmCgg_res_cargo',
title:tituloCgg_res_cargo,
iconCls:'iconAplicacion',
width:400,
minWidth:400,
maximizable:true,
minimizable:true,
constrain:true,
tbar:getPanelTitulo(tituloCgg_res_cargo,descCgg_res_cargo),
items:[pnlCgg_res_cargo],
bbar:[btnGuardarCgg_res_cargo,btnCancelarCgg_res_cargo,'->',btnCerrarCgg_res_cargo]
});
/**
* Funcion que aplica los privilegios del usuario.
*/
applyGrants(winFrmCgg_res_cargo.getBottomToolbar());
/**
* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_cargo.
* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
*/
function habilitarCgg_res_cargoCtrls(inEstado){
estado=!inEstado;
txtCrcrg_codigo.setDisabled(estado);
txtCrcrg_nombre.setDisabled(estado);
txtCrsec_codigo.setDisabled(estado);
}
/**
* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_cargo.
*/
function cargarCgg_res_cargoCtrls(){
if(inRecordCgg_res_cargo){
txtCrcrg_codigo.setValue(inRecordCgg_res_cargo.get('CRCRG_CODIGO'));
txtCrcrg_nombre.setValue(inRecordCgg_res_cargo.get('CRCRG_NOMBRE'));
txtCrsec_codigo_cod=inRecordCgg_res_cargo.get('CRSEC_CODIGO');
txtCrsec_codigo.setValue(inRecordCgg_res_cargo.get('CRSEC_NOMBRE'));
isEdit = true;
habilitarCgg_res_cargoCtrls(true);
}}
/**
* Funcion miembro que devuelve la ventana winFrmCgg_res_cargo.
* @returns ventana winFrmCgg_res_cargo.
* @base FrmCgg_res_cargo.prototype.show
*/
this.getWindow = function(){
return winFrmCgg_res_cargo;
}
/**
* Funcion miembro que carga los controles de la ventana winFrmCgg_res_cargo.
* @base FrmCgg_res_cargo.prototype.loadData
*/
this.loadData = function(){
cargarCgg_res_cargoCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_cargo desde una instancia.
*/
FrmCgg_res_cargo.prototype.show = function(){
this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_cargo desde una instancia.
*/
FrmCgg_res_cargo.prototype.close = function(){
this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_cargo,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_res_cargo.prototype.closeHandler = function(inFunctionHandler){
this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_cargo desde una instancia.
*/
FrmCgg_res_cargo.prototype.loadData = function(){
this.loadData();
}
