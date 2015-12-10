/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_dhu_sadjunto.
* @param {String} INSENTENCIA_CGG_DHU_SADJUNTO Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} INRECORD_CGG_DHU_SADJUNTO Registro de datos de la tabla Cgg_dhu_sadjunto.
* @constructor
* @base FrmListadoCgg_dhu_sadjunto
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_dhu_sadjunto(INSENTENCIA_CGG_DHU_SADJUNTO,INRECORD_CGG_DHU_SADJUNTO){
var inSentenciaCgg_dhu_sadjunto = INSENTENCIA_CGG_DHU_SADJUNTO;
var inRecordCgg_dhu_sadjunto=INRECORD_CGG_DHU_SADJUNTO;
var urlCgg_dhu_sadjunto=URL_WS+"Cgg_dhu_sadjunto";
var tituloCgg_dhu_sadjunto='Dhu sadjunto';
var descCgg_dhu_sadjunto='El formulario permite administrar informaci\u00f3n de la tabla Dhu sadjunto';
var isEdit = false;
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DEL ADJUNTO DE SEGUIMIENTO
*/
var txtCdsad_codigo = new Ext.form.TextField({
id:'txtCdsad_codigo',
name:'txtCdsad_codigo',
fieldLabel :'Codigo',
anchor:'98%',
allowBlank :false,
value:"KEYGEN",
hidden:true,
hideLabel:true,
maxLength :20
});
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO ACADEMICO
*/
var txtCdacd_codigo = new Ext.form.TextField({
id:'txtCdacd_codigo',
name:'txtCdacd_codigo',
fieldLabel :'Codigo',
anchor:'98%',
allowBlank :false,
readOnly:'true',
maxLength :20
});
/**
* IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO ACADEMICO
*/
var btnCdacd_codigoCgg_dhu_sadjunto = new Ext.Button({
id:'btnCdacd_codigoCgg_dhu_sadjunto',
text:'Cdacd_codigo',
iconCls:'iconCdacd_codigo',
listeners:{
click:function(){
var tmpFLCgg_dhu_seguimiento_academico = new FrmListadoCgg_dhu_seguimiento_academico();
var objBusqueda = new DlgBusqueda(tmpFLCgg_dhu_seguimiento_academico.getStore(),tmpFLCgg_dhu_seguimiento_academico.getColumnModel());
objBusqueda.closeHandler(function(){
var tmpRecord = objBusqueda.getSelectedRow();
if(tmpRecord)
txtCdacd_codigo.setValue(tmpRecord.get('CDACD_CODIGO'));
});
objBusqueda.show();
}}
});
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
*/
var txtCdbcr_codigo = new Ext.form.TextField({
id:'txtCdbcr_codigo',
name:'txtCdbcr_codigo',
fieldLabel :'Codigo',
anchor:'98%',
allowBlank :false,
readOnly:'true',
maxLength :20
});
/**
* IDENTIFICATIVO UNICO DE REGISTRO
*/
var btnCdbcr_codigoCgg_dhu_sadjunto = new Ext.Button({
id:'btnCdbcr_codigoCgg_dhu_sadjunto',
text:'Cdbcr_codigo',
iconCls:'iconCdbcr_codigo',
listeners:{
click:function(){
var tmpFLCgg_dhu_beca_certificado = new FrmListadoCgg_dhu_beca_certificado();
var objBusqueda = new DlgBusqueda(tmpFLCgg_dhu_beca_certificado.getStore(),tmpFLCgg_dhu_beca_certificado.getColumnModel());
objBusqueda.closeHandler(function(){
var tmpRecord = objBusqueda.getSelectedRow();
if(tmpRecord)
txtCdbcr_codigo.setValue(tmpRecord.get('CDBCR_CODIGO'));
});
objBusqueda.show();
}}
});
/**
* Ext.form.DateField FECHA DE REGISTRO DEL ADJUNTO
*/
var dtCdsad_fecha_registro = new Ext.form.DateField({
id:'dtCdsad_fecha_registro',
name:'dtCdsad_fecha_registro',
fieldLabel :'Fecha registro',
allowBlank :false,
value:new Date()
});
/**
* Ext.form.TextField NOMBRE DEL DOCUMENTO ADJUNTO
*/
var txtCdsad_nombre_adjunto = new Ext.form.TextField({
id:'txtCdsad_nombre_adjunto',
name:'txtCdsad_nombre_adjunto',
fieldLabel :'Nombre adjunto',
anchor:'98%',
allowBlank :false,
maxLength :20
});
/**
* Ext.form.TextField INFORMACION ADICIONAL
*/
var txtCdsad_observacion = new Ext.form.TextField({
id:'txtCdsad_observacion',
name:'txtCdsad_observacion',
fieldLabel :'Observacion',
anchor:'98%',
allowBlank :false,
maxLength :20
});
/**
* Boton que permite almacenar la informacion de la ventana winFrmCgg_dhu_sadjunto
*/
var btnGuardarCgg_dhu_sadjunto = new Ext.Button({
id:'btnGuardarCgg_dhu_sadjunto',
text:'Guardar',
iconCls:'iconGuardar',
listeners:{
click:function(){
if (pnlCgg_dhu_sadjunto.getForm().isValid()==false){
return;
}
try{
function CallBackCgg_dhu_sadjunto(r){
winFrmCgg_dhu_sadjunto.getEl().unmask();
if(r=='true'){
Ext.Msg.show({
title:tituloCgg_dhu_sadjunto,
msg: 'La informaci\u00f3n de Dhu sadjunto ha sido almacenada.',
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.INFO
});winFrmCgg_dhu_sadjunto.close()
}else{
Ext.Msg.show({
title:tituloCgg_dhu_sadjunto,
msg: 'La informaci\u00f3n de Dhu sadjunto no ha podido ser almacenada.',
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.ERROR
});
}
}
winFrmCgg_dhu_sadjunto.getEl().mask('Guardando...', 'x-mask-loading');
var param = new SOAPClientParameters();
if(isEdit)
param.add('inCdsad_codigo',txtCdsad_codigo.getValue());
param.add('inCdacd_codigo',txtCdacd_codigo.getValue());
param.add('inCdbcr_codigo',txtCdbcr_codigo.getValue());
param.add('inCdsad_fecha_registro',dtCdsad_fecha_registro.getValue().format('c'));
param.add('inCdsad_nombre_adjunto',txtCdsad_nombre_adjunto.getValue());
param.add('inCdsad_nombre_adjunto',txtCdsad_nombre_adjunto.getValue());
param.add('inCdsad_observacion',txtCdsad_observacion.getValue());
SOAPClient.invoke(urlCgg_dhu_sadjunto,INSENTENCIA_CGG_DHU_SADJUNTO,param, true, CallBackCgg_dhu_sadjunto);
}catch(inErr){
winFrmCgg_dhu_sadjunto.getEl().unmask();
}
}}
});
/**
* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_dhu_sadjunto.
*/
var btnCancelarCgg_dhu_sadjunto = new Ext.Button({
id:'btnCancelarCgg_dhu_sadjunto',
text:'Cancelar',
iconCls:'iconCancelar',
listeners:{
click:function(){
pnlCgg_dhu_sadjunto.getForm().reset();
}}
});
/**
* Boton que permite cerrar la ventana winFrmCgg_dhu_sadjunto.
*/
var btnCerrarCgg_dhu_sadjunto = new Ext.Button({
id:'btnCerrarCgg_dhu_sadjunto',
text:'Cerrar',
iconCls:'iconCerrar',
listeners:{
click:function(){
winFrmCgg_dhu_sadjunto.close();
}}
});
/**
* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_dhu_sadjunto.
*/
var pnlCgg_dhu_sadjunto = new Ext.form.FormPanel({
frame:true,
labelWidth :100,
items:[txtCdsad_codigo,{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCdacd_codigo]},{columnWidth:.4,layout:'form',items:[btnCdacd_codigoCgg_dhu_sadjunto]}]},{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCdbcr_codigo]},{columnWidth:.4,layout:'form',items:[btnCdbcr_codigoCgg_dhu_sadjunto]}]},dtCdsad_fecha_registro,txtCdsad_nombre_adjunto,,txtCdsad_observacion]
});
/**
* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_dhu_sadjunto.
*/
var winFrmCgg_dhu_sadjunto = new Ext.Window({
id:'winFrmCgg_dhu_sadjunto',
title:tituloCgg_dhu_sadjunto,
tbar:getPanelTitulo(tituloCgg_dhu_sadjunto,descCgg_dhu_sadjunto),
items:[pnlCgg_dhu_sadjunto],
width:400,
minWidth:400,
maximizable:true,
minimizable:true,
constrain:true,
bbar:[btnGuardarCgg_dhu_sadjunto,btnCancelarCgg_dhu_sadjunto,'->',btnCerrarCgg_dhu_sadjunto]
});
/**
* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_dhu_sadjunto.
* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
*/
function habilitarCgg_dhu_sadjuntoCtrls(inEstado){
estado=!inEstado;
txtCdsad_codigo.setDisabled(estado);
txtCdacd_codigo.setDisabled(estado);
txtCdbcr_codigo.setDisabled(estado);
dtCdsad_fecha_registro.setDisabled(estado);
txtCdsad_nombre_adjunto.setDisabled(estado);
txtCdsad_observacion.setDisabled(estado);
}
/**
* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_dhu_sadjunto.
*/
function cargarCgg_dhu_sadjuntoCtrls(){
if(inRecordCgg_dhu_sadjunto){
txtCdsad_codigo.setValue(inRecordCgg_dhu_sadjunto.get('CDSAD_CODIGO'));
txtCdacd_codigo.setValue(inRecordCgg_dhu_sadjunto.get('CDACD_CODIGO'));
txtCdbcr_codigo.setValue(inRecordCgg_dhu_sadjunto.get('CDBCR_CODIGO'));
dtCdsad_fecha_registro.setValue(inRecordCgg_dhu_sadjunto.get('CDSAD_FECHA_REGISTRO'));
txtCdsad_nombre_adjunto.setValue(inRecordCgg_dhu_sadjunto.get('CDSAD_NOMBRE_ADJUNTO'));
txtCdsad_observacion.setValue(inRecordCgg_dhu_sadjunto.get('CDSAD_OBSERVACION'));
isEdit = true;
habilitarCgg_dhu_sadjuntoCtrls(true);
}}
/**
* Funcion miembro que devuelve la ventana winFrmCgg_dhu_sadjunto.
* @returns ventana winFrmCgg_dhu_sadjunto.
* @base FrmCgg_dhu_sadjunto.prototype.show
*/
this.getWindow = function(){
return winFrmCgg_dhu_sadjunto;
}
/**
* Funcion miembro que carga los controles de la ventana winFrmCgg_dhu_sadjunto.
* @base FrmCgg_dhu_sadjunto.prototype.loadData
*/
this.loadData = function(){
cargarCgg_dhu_sadjuntoCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_dhu_sadjunto desde una instancia.
*/
FrmCgg_dhu_sadjunto.prototype.show = function(){
this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_dhu_sadjunto desde una instancia.
*/
FrmCgg_dhu_sadjunto.prototype.close = function(){
this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_dhu_sadjunto,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_dhu_sadjunto.prototype.closeHandler = function(inFunctionHandler){
this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_dhu_sadjunto desde una instancia.
*/
FrmCgg_dhu_sadjunto.prototype.loadData = function(){
this.loadData();
}
