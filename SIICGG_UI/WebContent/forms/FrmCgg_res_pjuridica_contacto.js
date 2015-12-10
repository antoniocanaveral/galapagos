/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_pjuridica_contacto.
* @param {String} IN_SENTENCIA_CGG_RES_PJURIDICA_CONTACTO Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_RES_PJURIDICA_CONTACTO Registro de datos de la tabla Cgg_res_pjuridica_contacto.
* @constructor
* @base FrmListadoCgg_res_pjuridica_contacto
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_res_pjuridica_contacto(IN_SENTENCIA_CGG_RES_PJURIDICA_CONTACTO,IN_RECORD_CGG_RES_PJURIDICA_CONTACTO){
var inSentenciaCgg_res_pjuridica_contacto = IN_SENTENCIA_CGG_RES_PJURIDICA_CONTACTO;
var inRecordCgg_res_pjuridica_contacto=IN_RECORD_CGG_RES_PJURIDICA_CONTACTO;
var urlCgg_res_pjuridica_contacto=URL_WS+"Cgg_res_pjuridica_contacto";
var tituloCgg_res_pjuridica_contacto='Res pjuridica contacto';
var descCgg_res_pjuridica_contacto='El formulario permite administrar la informaci\u00f3n de la tabla Res pjuridica contacto';
var isEdit = false;
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO AL CONTACTO DE LA PERSONA JURIDICA
*/
var txtCrpjc_codigo = new Ext.form.TextField({
id:'txtCrpjc_codigo',
name:'txtCrpjc_codigo',
fieldLabel :'Codigo',
anchor:'98%',
value:"KEYGEN",
hidden:true,
hideLabel:true,
allowBlank :false
});
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGSITRO
*/
var txtCrpjr_codigo = new Ext.form.TextField({
id:'txtCrpjr_codigo',
name:'txtCrpjr_codigo',
fieldLabel :'Codigo',
anchor:'98%',
readOnly:'true',
allowBlank :false
});
/**
* IDENTIFICATIVO UNICO DE REGSITRO
*/
var btnCrpjr_codigoCgg_res_pjuridica_contacto = new Ext.Button({
id:'btnCrpjr_codigoCgg_res_pjuridica_contacto',
text:'Crpjr_codigo',
iconCls:'iconCrpjr_codigo',
listeners:{
click:function(){
var tmpFLCgg_res_persona_juridica = new FrmListadoCgg_res_persona_juridica();
var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona_juridica.getStore(),tmpFLCgg_res_persona_juridica.getColumnModel());
objBusqueda.closeHandler(function(){
var tmpRecord = objBusqueda.getSelectedRow();
if(tmpRecord)
txtCrpjr_codigo.setValue(tmpRecord.get('CRPJR_CODIGO'));
});
objBusqueda.show();
}}
});
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
*/
var txtCrtco_codigo = new Ext.form.TextField({
id:'txtCrtco_codigo',
name:'txtCrtco_codigo',
fieldLabel :'Codigo',
anchor:'98%',
readOnly:'true',
allowBlank :false
});
/**
* IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
*/
var btnCrtco_codigoCgg_res_pjuridica_contacto = new Ext.Button({
id:'btnCrtco_codigoCgg_res_pjuridica_contacto',
text:'Crtco_codigo',
iconCls:'iconCrtco_codigo',
listeners:{
click:function(){
var tmpFLCgg_res_tipo_contacto = new FrmListadoCgg_res_tipo_contacto();
var objBusqueda = new DlgBusqueda(tmpFLCgg_res_tipo_contacto.getStore(),tmpFLCgg_res_tipo_contacto.getColumnModel());
objBusqueda.closeHandler(function(){
var tmpRecord = objBusqueda.getSelectedRow();
if(tmpRecord)
txtCrtco_codigo.setValue(tmpRecord.get('CRTCO_CODIGO'));
});
objBusqueda.show();
}}
});
/**
* Ext.form.TextField VALOR ASIGNADO AL CONTACTO
*/
var txtCrpjc_descripcion = new Ext.form.TextField({
id:'txtCrpjc_descripcion',
name:'txtCrpjc_descripcion',
fieldLabel :'Descripcion',
anchor:'98%',
allowBlank :false
});
/**
* Ext.form.TextField NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
*/
var txtCrpjc_contacto = new Ext.form.TextField({
id:'txtCrpjc_contacto',
name:'txtCrpjc_contacto',
fieldLabel :'Contacto',
anchor:'98%',
allowBlank :false
});
/**
* Ext.form.Checkbox CAMPO QUE INDICA SI EL CONTACTO ES PRINCIPAL O NO DE UN REGISTRO
*/
var chkCrpjc_principal = new Ext.form.Checkbox({
id:'chkCrpjc_principal',
name:'chkCrpjc_principal',
fieldLabel :'Principal',
allowBlank :false,
checked:true
});
/**
* Boton que permite almacenar la informacion de la ventana winFrmCgg_res_pjuridica_contacto
*/
var btnGuardarCgg_res_pjuridica_contacto = new Ext.Button({
id:'btnGuardarCgg_res_pjuridica_contacto',
text:'Guardar',
iconCls:'iconGuardar',
listeners:{
click:function(){
if (pnlCgg_res_pjuridica_contacto.getForm().isValid()==false){
return;
}
try{
function CallBackCgg_res_pjuridica_contacto(r){
winFrmCgg_res_pjuridica_contacto.getEl().unmask();
if(r=='true'){
Ext.Msg.show({
title:tituloCgg_res_pjuridica_contacto,
msg: 'La informaci\u00f3n de Res pjuridica contacto ha sido almacenada.',
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.INFO
});winFrmCgg_res_pjuridica_contacto.close()
}else{
Ext.Msg.show({
title:tituloCgg_res_pjuridica_contacto,
msg: 'La informaci\u00f3n de Res pjuridica contacto no ha podido ser almacenada. '+r,
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.ERROR
});
}
}
winFrmCgg_res_pjuridica_contacto.getEl().mask('Guardando...', 'x-mask-loading');
var param = new SOAPClientParameters();
if(isEdit)
param.add('inCrpjc_codigo',txtCrpjc_codigo.getValue());
param.add('inCrpjr_codigo',txtCrpjr_codigo.getValue());
param.add('inCrtco_codigo',txtCrtco_codigo.getValue());
param.add('inCrpjc_descripcion',txtCrpjc_descripcion.getValue());
param.add('inCrpjc_contacto',txtCrpjc_contacto.getValue());
param.add('inCrpjc_principal',chkCrpjc_principal.getValue());
SOAPClient.invoke(urlCgg_res_pjuridica_contacto,IN_SENTENCIA_CGG_RES_PJURIDICA_CONTACTO,param, true, CallBackCgg_res_pjuridica_contacto);
}catch(inErr){
winFrmCgg_res_pjuridica_contacto.getEl().unmask();
}
}}
});
/**
* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_pjuridica_contacto.
*/
var btnCancelarCgg_res_pjuridica_contacto = new Ext.Button({
id:'btnCancelarCgg_res_pjuridica_contacto',
text:'Cancelar',
iconCls:'iconCancelar',
listeners:{
click:function(){
pnlCgg_res_pjuridica_contacto.getForm().reset();
}}
});
/**
* Boton que permite cerrar la ventana winFrmCgg_res_pjuridica_contacto.
*/
var btnCerrarCgg_res_pjuridica_contacto = new Ext.Button({
id:'btnCerrarCgg_res_pjuridica_contacto',
text:'Cerrar',
iconCls:'iconCerrar',
listeners:{
click:function(){
winFrmCgg_res_pjuridica_contacto.close();
}}
});
/**
* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_pjuridica_contacto.
*/
var pnlCgg_res_pjuridica_contacto = new Ext.form.FormPanel({
frame:true,
labelWidth :100,
items:[txtCrpjc_codigo,{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCrpjr_codigo]},{columnWidth:.4,layout:'form',items:[btnCrpjr_codigoCgg_res_pjuridica_contacto]}]},{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCrtco_codigo]},{columnWidth:.4,layout:'form',items:[btnCrtco_codigoCgg_res_pjuridica_contacto]}]},txtCrpjc_descripcion,txtCrpjc_contacto,chkCrpjc_principal]
});
/**
* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_pjuridica_contacto.
*/
var winFrmCgg_res_pjuridica_contacto = new Ext.Window({
id:'winFrmCgg_res_pjuridica_contacto',
title:tituloCgg_res_pjuridica_contacto,
width:400,
minWidth:400,
maximizable:true,
minimizable:true,
constrain:true,
tbar:getPanelTitulo(tituloCgg_res_pjuridica_contacto,descCgg_res_pjuridica_contacto),
items:[pnlCgg_res_pjuridica_contacto],
bbar:[btnGuardarCgg_res_pjuridica_contacto,btnCancelarCgg_res_pjuridica_contacto,'->',btnCerrarCgg_res_pjuridica_contacto]
});
/**
* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_pjuridica_contacto.
* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
*/
function habilitarCgg_res_pjuridica_contactoCtrls(inEstado){
estado=!inEstado;
txtCrpjc_codigo.setDisabled(estado);
txtCrpjr_codigo.setDisabled(estado);
txtCrtco_codigo.setDisabled(estado);
txtCrpjc_descripcion.setDisabled(estado);
txtCrpjc_contacto.setDisabled(estado);
chkCrpjc_principal.setDisabled(estado);
}
/**
* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_pjuridica_contacto.
*/
function cargarCgg_res_pjuridica_contactoCtrls(){
if(inRecordCgg_res_pjuridica_contacto){
txtCrpjc_codigo.setValue(inRecordCgg_res_pjuridica_contacto.get('CRPJC_CODIGO'));
txtCrpjr_codigo.setValue(inRecordCgg_res_pjuridica_contacto.get('CRPJR_CODIGO'));
txtCrtco_codigo.setValue(inRecordCgg_res_pjuridica_contacto.get('CRTCO_CODIGO'));
txtCrpjc_descripcion.setValue(inRecordCgg_res_pjuridica_contacto.get('CRPJC_DESCRIPCION'));
txtCrpjc_contacto.setValue(inRecordCgg_res_pjuridica_contacto.get('CRPJC_CONTACTO'));
chkCrpjc_principal.setValue(inRecordCgg_res_pjuridica_contacto.get('CRPJC_PRINCIPAL'));
isEdit = true;
habilitarCgg_res_pjuridica_contactoCtrls(true);
}}
/**
* Funcion miembro que devuelve la ventana winFrmCgg_res_pjuridica_contacto.
* @returns ventana winFrmCgg_res_pjuridica_contacto.
* @base FrmCgg_res_pjuridica_contacto.prototype.show
*/
this.getWindow = function(){
return winFrmCgg_res_pjuridica_contacto;
}
/**
* Funcion miembro que carga los controles de la ventana winFrmCgg_res_pjuridica_contacto.
* @base FrmCgg_res_pjuridica_contacto.prototype.loadData
*/
this.loadData = function(){
cargarCgg_res_pjuridica_contactoCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_pjuridica_contacto desde una instancia.
*/
FrmCgg_res_pjuridica_contacto.prototype.show = function(){
this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_pjuridica_contacto desde una instancia.
*/
FrmCgg_res_pjuridica_contacto.prototype.close = function(){
this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_pjuridica_contacto,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_res_pjuridica_contacto.prototype.closeHandler = function(inFunctionHandler){
this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_pjuridica_contacto desde una instancia.
*/
FrmCgg_res_pjuridica_contacto.prototype.loadData = function(){
this.loadData();
}
