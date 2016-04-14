/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_representante_legal.
* @param {String} IN_SENTENCIA_CGG_RES_REPRESENTANTE_LEGAL Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_RES_REPRESENTANTE_LEGAL Registro de datos de la tabla Cgg_res_representante_legal.
* @constructor
* @base FrmListadoCgg_res_representante_legal
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_res_representante_legal(IN_SENTENCIA_CGG_RES_REPRESENTANTE_LEGAL,IN_RECORD_CGG_RES_REPRESENTANTE_LEGAL){
var inSentenciaCgg_res_representante_legal = IN_SENTENCIA_CGG_RES_REPRESENTANTE_LEGAL;
var inRecordCgg_res_representante_legal=IN_RECORD_CGG_RES_REPRESENTANTE_LEGAL;
var urlCgg_res_representante_legal=URL_WS+"Cgg_res_representante_legal";
var tituloCgg_res_representante_legal='Res representante legal';
var descCgg_res_representante_legal='El formulario permite administrar la informaci\u00f3n de la tabla Res representante legal';
var isEdit = false;
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE REPRESENTANTE LEGAL
*/
var txtCrrpt_codigo = new Ext.form.TextField({
id:'txtCrrpt_codigo',
name:'txtCrrpt_codigo',
fieldLabel :'Codigo',
anchor:'98%',
value:"KEYGEN",
hidden:true,
hideLabel:true,
allowBlank :false
});
/**
* Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
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
* CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
*/
var btnCrper_codigoCgg_res_representante_legal = new Ext.Button({
id:'btnCrper_codigoCgg_res_representante_legal',
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
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
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
* IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
*/
var btnCrpjr_codigoCgg_res_representante_legal = new Ext.Button({
id:'btnCrpjr_codigoCgg_res_representante_legal',
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
* Ext.form.DateField FECHA QUE SE INGRESO LA INFORMACION DEL REPRESNTANTE LEGAL
*/
var dtCrrpt_fecha_registro = new Ext.form.DateField({
id:'dtCrrpt_fecha_registro',
name:'dtCrrpt_fecha_registro',
fieldLabel :'Fecha registro',
allowBlank :false,
format :'d/m/Y',
value:new Date()
});
/**
* Ext.form.Checkbox ALMACENA INFORMACION DEL ESTADO DEL REPRESENTANTE LEGAL DENTRO D ELA EMPRESA
*/
var chkCrrpt_activo = new Ext.form.Checkbox({
id:'chkCrrpt_activo',
name:'chkCrrpt_activo',
fieldLabel :'Activo',
allowBlank :false,
checked:true
});
/**
* Ext.form.TextField NO ESPECIFICADO
*/
var txtColumn_11 = new Ext.form.TextField({
id:'txtColumn_11',
name:'txtColumn_11',
fieldLabel :'11',
anchor:'98%',
allowBlank :false
});
/**
* Boton que permite almacenar la informacion de la ventana winFrmCgg_res_representante_legal
*/
var btnGuardarCgg_res_representante_legal = new Ext.Button({
id:'btnGuardarCgg_res_representante_legal',
text:'Guardar',
iconCls:'iconGuardar',
listeners:{
click:function(){
if (pnlCgg_res_representante_legal.getForm().isValid()==false){
return;
}
try{
function CallBackCgg_res_representante_legal(r){
winFrmCgg_res_representante_legal.getEl().unmask();
if(r=='true'){
Ext.Msg.show({
title:tituloCgg_res_representante_legal,
msg: 'La informaci\u00f3n de Res representante legal ha sido almacenada.',
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.INFO
});winFrmCgg_res_representante_legal.close()
}else{
Ext.Msg.show({
title:tituloCgg_res_representante_legal,
msg: 'La informaci\u00f3n de Res representante legal no ha podido ser almacenada. '+r,
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.ERROR
});
}
}
winFrmCgg_res_representante_legal.getEl().mask('Guardando...', 'x-mask-loading');
var param = new SOAPClientParameters();
if(isEdit)
param.add('inCrrpt_codigo',txtCrrpt_codigo.getValue());
param.add('inCrper_codigo',txtCrper_codigo.getValue());
param.add('inCrpjr_codigo',txtCrpjr_codigo.getValue());
param.add('inCrrpt_fecha_registro',dtCrrpt_fecha_registro.getValue().format('c'));
param.add('inCrrpt_activo',chkCrrpt_activo.getValue());
param.add('inColumn_11',txtColumn_11.getValue());
SOAPClient.invoke(urlCgg_res_representante_legal,IN_SENTENCIA_CGG_RES_REPRESENTANTE_LEGAL,param, true, CallBackCgg_res_representante_legal);
}catch(inErr){
winFrmCgg_res_representante_legal.getEl().unmask();
}
}}
});
/**
* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_representante_legal.
*/
var btnCancelarCgg_res_representante_legal = new Ext.Button({
id:'btnCancelarCgg_res_representante_legal',
text:'Cancelar',
iconCls:'iconCancelar',
listeners:{
click:function(){
pnlCgg_res_representante_legal.getForm().reset();
}}
});
/**
* Boton que permite cerrar la ventana winFrmCgg_res_representante_legal.
*/
var btnCerrarCgg_res_representante_legal = new Ext.Button({
id:'btnCerrarCgg_res_representante_legal',
text:'Cerrar',
iconCls:'iconCerrar',
listeners:{
click:function(){
winFrmCgg_res_representante_legal.close();
}}
});
/**
* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_representante_legal.
*/
var pnlCgg_res_representante_legal = new Ext.form.FormPanel({
frame:true,
labelWidth :100,
items:[txtCrrpt_codigo,{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCrper_codigo]},{columnWidth:.4,layout:'form',items:[btnCrper_codigoCgg_res_representante_legal]}]},{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCrpjr_codigo]},{columnWidth:.4,layout:'form',items:[btnCrpjr_codigoCgg_res_representante_legal]}]},dtCrrpt_fecha_registro,chkCrrpt_activo,txtColumn_11]
});
/**
* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_representante_legal.
*/
var winFrmCgg_res_representante_legal = new Ext.Window({
id:'winFrmCgg_res_representante_legal',
title:tituloCgg_res_representante_legal,
width:400,
minWidth:400,
maximizable:true,
minimizable:true,
constrain:true,
tbar:getPanelTitulo(tituloCgg_res_representante_legal,descCgg_res_representante_legal),
items:[pnlCgg_res_representante_legal],
bbar:[btnGuardarCgg_res_representante_legal,btnCancelarCgg_res_representante_legal,'->',btnCerrarCgg_res_representante_legal]
});
/**
* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_representante_legal.
* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
*/
function habilitarCgg_res_representante_legalCtrls(inEstado){
estado=!inEstado;
txtCrrpt_codigo.setDisabled(estado);
txtCrper_codigo.setDisabled(estado);
txtCrpjr_codigo.setDisabled(estado);
dtCrrpt_fecha_registro.setDisabled(estado);
chkCrrpt_activo.setDisabled(estado);
txtColumn_11.setDisabled(estado);
}
/**
* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_representante_legal.
*/
function cargarCgg_res_representante_legalCtrls(){
if(inRecordCgg_res_representante_legal){
txtCrrpt_codigo.setValue(inRecordCgg_res_representante_legal.get('CRRPT_CODIGO'));
txtCrper_codigo.setValue(inRecordCgg_res_representante_legal.get('CRPER_CODIGO'));
txtCrpjr_codigo.setValue(inRecordCgg_res_representante_legal.get('CRPJR_CODIGO'));
dtCrrpt_fecha_registro.setValue(inRecordCgg_res_representante_legal.get('CRRPT_FECHA_REGISTRO'));
chkCrrpt_activo.setValue(inRecordCgg_res_representante_legal.get('CRRPT_ACTIVO'));
txtColumn_11.setValue(inRecordCgg_res_representante_legal.get('COLUMN_11'));
isEdit = true;
habilitarCgg_res_representante_legalCtrls(true);
}}
/**
* Funcion miembro que devuelve la ventana winFrmCgg_res_representante_legal.
* @returns ventana winFrmCgg_res_representante_legal.
* @base FrmCgg_res_representante_legal.prototype.show
*/
this.getWindow = function(){
return winFrmCgg_res_representante_legal;
}
/**
* Funcion miembro que carga los controles de la ventana winFrmCgg_res_representante_legal.
* @base FrmCgg_res_representante_legal.prototype.loadData
*/
this.loadData = function(){
cargarCgg_res_representante_legalCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_representante_legal desde una instancia.
*/
FrmCgg_res_representante_legal.prototype.show = function(){
this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_representante_legal desde una instancia.
*/
FrmCgg_res_representante_legal.prototype.close = function(){
this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_representante_legal,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_res_representante_legal.prototype.closeHandler = function(inFunctionHandler){
this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_representante_legal desde una instancia.
*/
FrmCgg_res_representante_legal.prototype.loadData = function(){
this.loadData();
}
