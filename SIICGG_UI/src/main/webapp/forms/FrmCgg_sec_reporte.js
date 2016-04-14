/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_sec_reporte.
* @param {String} IN_SENTENCIA_CGG_SEC_REPORTE Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_SEC_REPORTE Registro de datos de la tabla Cgg_sec_reporte.
* @constructor
* @base FrmListadoCgg_sec_reporte
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_sec_reporte(IN_SENTENCIA_CGG_SEC_REPORTE,IN_RECORD_CGG_SEC_REPORTE){
var optMenu = 'Sec reporte';
var inSentenciaCgg_sec_reporte = IN_SENTENCIA_CGG_SEC_REPORTE;
var inRecordCgg_sec_reporte=IN_RECORD_CGG_SEC_REPORTE;
var urlCgg_sec_reporte=URL_WS+"Cgg_sec_reporte";
var tituloCgg_sec_reporte='Sec reporte';
var descCgg_sec_reporte='El formulario permite administrar la informaci\u00f3n de la tabla Sec reporte';
var isEdit = false;
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO_ROL
*/
var txtCsrpt_codigo = new Ext.form.TextField({
id:'txtCsrpt_codigo',
name:'txtCsrpt_codigo',
fieldLabel :'Codigo',
anchor:'98%',
value:"KEYGEN",
hidden:true,
hideLabel:true,
allowBlank :false
});
/**
* Ext.form.TextField SI TIENE ACCESO DIRECTO EN EL ESCRITORIO
*/
var txtCsrpt_reporte = new Ext.form.TextField({
id:'txtCsrpt_reporte',
name:'txtCsrpt_reporte',
fieldLabel :'Reporte',
anchor:'98%',
allowBlank :false
});
/**
* Ext.form.TextArea SI TIENE ACCESO DIRECTO EN EL ESCRITORIO
*/
var txtCsrpt_descripcion = new Ext.form.TextArea({
id:'txtCsrpt_descripcion',
name:'txtCsrpt_descripcion',
fieldLabel :'Descripcion',
width:'90%',
allowBlank :false
});
/**
* Ext.form.Checkbox TEXTO DEL ACCESO DIRECTO. SOLO ES APLICABLE A LOS OBJETOS VISUALES.
*/
var chkCsrpt_activo = new Ext.form.Checkbox({
id:'chkCsrpt_activo',
name:'chkCsrpt_activo',
fieldLabel :'Activo',
allowBlank :false,
checked:true,
hidden:true
});
/**
* Boton que permite almacenar la informacion de la ventana winFrmCgg_sec_reporte
*/
var btnGuardarCgg_sec_reporte = new Ext.Button({
id:'btnGuardarCgg_sec_reporte',
text:'Guardar',
iconCls:'iconGuardar',
listeners:{
click:function(){
if (!pnlCgg_sec_reporte.getForm().isValid()){
return;
}
try{
function CallBackCgg_sec_reporte(r){
winFrmCgg_sec_reporte.getEl().unmask();
if(r=='true'){
Ext.Msg.show({
title:tituloCgg_sec_reporte,
msg: 'La informaci\u00f3n de Sec reporte ha sido almacenada.',
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.INFO
});winFrmCgg_sec_reporte.close()
}else{
Ext.Msg.show({
title:tituloCgg_sec_reporte,
msg: 'La informaci\u00f3n de Sec reporte no ha podido ser almacenada. '+(r.message?r.message:r),
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.ERROR
});
}
}
winFrmCgg_sec_reporte.getEl().mask('Guardando...', 'x-mask-loading');
var param = new SOAPClientParameters();
if(isEdit)
param.add('inCsrpt_codigo',txtCsrpt_codigo.getValue());
param.add('inCsrpt_reporte',txtCsrpt_reporte.getValue());
param.add('inCsrpt_descripcion',txtCsrpt_descripcion.getValue());
param.add('inCsrpt_activo',chkCsrpt_activo.getValue());
SOAPClient.invoke(urlCgg_sec_reporte,IN_SENTENCIA_CGG_SEC_REPORTE,param, true, CallBackCgg_sec_reporte);
}catch(inErr){
winFrmCgg_sec_reporte.getEl().unmask();
}
}}
});
/**
* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_sec_reporte.
*/
var btnCancelarCgg_sec_reporte = new Ext.Button({
id:'btnCancelarCgg_sec_reporte',
text:'Cancelar',
iconCls:'iconCancelar',
listeners:{
click:function(){
pnlCgg_sec_reporte.getForm().reset();
}}
});
/**
* Boton que permite cerrar la ventana winFrmCgg_sec_reporte.
*/
var btnCerrarCgg_sec_reporte = new Ext.Button({
id:'btnCerrarCgg_sec_reporte',
text:'Cerrar',
iconCls:'iconCerrar',
listeners:{
click:function(){
winFrmCgg_sec_reporte.close();
}}
});
/**
* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_sec_reporte.
*/
var pnlCgg_sec_reporte = new Ext.form.FormPanel({
frame:true,
labelWidth :100,
items:[txtCsrpt_codigo,txtCsrpt_reporte,txtCsrpt_descripcion,chkCsrpt_activo]
});
/**
* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_sec_reporte.
*/
var winFrmCgg_sec_reporte = new Ext.Window({
id:'winFrmCgg_sec_reporte',
title:tituloCgg_sec_reporte,
iconCls:'iconAplicacion',
width:400,
minWidth:400,
maximizable:true,
minimizable:true,
constrain:true,
modal:true, 
tbar:getPanelTitulo(tituloCgg_sec_reporte,descCgg_sec_reporte),
items:[pnlCgg_sec_reporte],
bbar:[btnGuardarCgg_sec_reporte,btnCancelarCgg_sec_reporte,'->',btnCerrarCgg_sec_reporte]
});
/**
* Funcion que aplica los privilegios del usuario.
*/
applyGrants(winFrmCgg_sec_reporte.getBottomToolbar());
/**
* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_sec_reporte.
* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
*/
function habilitarCgg_sec_reporteCtrls(inEstado){
estado=!inEstado;
txtCsrpt_codigo.setDisabled(estado);
txtCsrpt_reporte.setDisabled(estado);
txtCsrpt_descripcion.setDisabled(estado);
chkCsrpt_activo.setDisabled(estado);
}
/**
* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_sec_reporte.
*/
function cargarCgg_sec_reporteCtrls(){
if(inRecordCgg_sec_reporte){
txtCsrpt_codigo.setValue(inRecordCgg_sec_reporte.get('CSRPT_CODIGO'));
txtCsrpt_reporte.setValue(inRecordCgg_sec_reporte.get('CSRPT_REPORTE'));
txtCsrpt_descripcion.setValue(inRecordCgg_sec_reporte.get('CSRPT_DESCRIPCION'));
chkCsrpt_activo.setValue(inRecordCgg_sec_reporte.get('CSRPT_ACTIVO'));
isEdit = true;
habilitarCgg_sec_reporteCtrls(true);
}}
/**
* Funcion miembro que devuelve la ventana winFrmCgg_sec_reporte.
* @returns ventana winFrmCgg_sec_reporte.
* @base FrmCgg_sec_reporte.prototype.show
*/
this.getWindow = function(){
return winFrmCgg_sec_reporte;
}
/**
* Funcion miembro que carga los controles de la ventana winFrmCgg_sec_reporte.
* @base FrmCgg_sec_reporte.prototype.loadData
*/
this.loadData = function(){
cargarCgg_sec_reporteCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_sec_reporte desde una instancia.
*/
FrmCgg_sec_reporte.prototype.show = function(){
this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_sec_reporte desde una instancia.
*/
FrmCgg_sec_reporte.prototype.close = function(){
this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_sec_reporte,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_sec_reporte.prototype.closeHandler = function(inFunctionHandler){
this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_sec_reporte desde una instancia.
*/
FrmCgg_sec_reporte.prototype.loadData = function(){
this.loadData();
}
