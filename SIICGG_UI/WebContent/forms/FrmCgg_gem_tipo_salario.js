/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_gem_tipo_salario.
* @param {String} IN_SENTENCIA_CGG_GEM_TIPO_SALARIO Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_GEM_TIPO_SALARIO Registro de datos de la tabla Cgg_gem_tipo_salario.
* @constructor
* @base FrmListadoCgg_gem_tipo_salario
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_gem_tipo_salario(IN_SENTENCIA_CGG_GEM_TIPO_SALARIO,IN_RECORD_CGG_GEM_TIPO_SALARIO){
var inSentenciaCgg_gem_tipo_salario = IN_SENTENCIA_CGG_GEM_TIPO_SALARIO;
var inRecordCgg_gem_tipo_salario=IN_RECORD_CGG_GEM_TIPO_SALARIO;
var urlCgg_gem_tipo_salario=URL_WS+"Cgg_gem_tipo_salario";
var tituloCgg_gem_tipo_salario='Tipos de salarios';
var descCgg_gem_tipo_salario='El formulario permite administrar la informaci\u00f3n de los tipos de salarios';
var isEdit = false;
/**
* Ext.form.TextField IDENTIFICADOR UNICO DEL TIPO DE SALARIO
*/
var txtCgtsa_codigo = new Ext.form.TextField({
id:'txtCgtsa_codigo',
name:'txtCgtsa_codigo',
fieldLabel :'Codigo',
anchor:'98%',
value:"KEYGEN",
hidden:true,
hideLabel:true,
allowBlank :false
});
/**
* Ext.form.TextField NOMBRE DEL TIPO DE SALARIO QUE SE VA APLICAR
*/
var txtCgtsa_nombre = new Ext.form.TextField({
id:'txtCgtsa_nombre',
name:'txtCgtsa_nombre',
fieldLabel :'Nombre',
anchor:'98%',
allowBlank :false
});
/**
* Ext.form.TextField BREVE DESCRIPCION DEL TIPO DE SALARIO
*/
var txtCgtsa_descripcion = new Ext.form.TextArea({
id:'txtCgtsa_descripcion',
name:'txtCgtsa_descripcion',
fieldLabel :'Descripci\u00f3n',
anchor:'98%',
allowBlank :false
});
/**
* Boton que permite almacenar la informacion de la ventana winFrmCgg_gem_tipo_salario
*/
var btnGuardarCgg_gem_tipo_salario = new Ext.Button({
id:'btnGuardarCgg_gem_tipo_salario',
text:'Guardar',
iconCls:'iconGuardar',
listeners:{
click:function(){
if (!pnlCgg_gem_tipo_salario.getForm().isValid()){
return;
}
try{
function CallBackCgg_gem_tipo_salario(r){
winFrmCgg_gem_tipo_salario.getEl().unmask();
if(r=='true'){
Ext.Msg.show({
title:tituloCgg_gem_tipo_salario,
msg: 'La informaci\u00f3n del tipo de salario ha sido almacenada.',
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.INFO
});winFrmCgg_gem_tipo_salario.close()
}else{
Ext.Msg.show({
title:tituloCgg_gem_tipo_salario,
msg: 'La informaci\u00f3n de Gem tipo salario no ha podido ser almacenada. '+(r.message?r.message:r),
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.ERROR
});
}
}
winFrmCgg_gem_tipo_salario.getEl().mask('Guardando...', 'x-mask-loading');
var param = new SOAPClientParameters();
if(isEdit)
param.add('inCgtsa_codigo',txtCgtsa_codigo.getValue());
param.add('inCgtsa_nombre',txtCgtsa_nombre.getValue());
param.add('inCgtsa_descripcion',txtCgtsa_descripcion.getValue());
SOAPClient.invoke(urlCgg_gem_tipo_salario,IN_SENTENCIA_CGG_GEM_TIPO_SALARIO,param, true, CallBackCgg_gem_tipo_salario);
}catch(inErr){
winFrmCgg_gem_tipo_salario.getEl().unmask();
}
}}
});
/**
* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_gem_tipo_salario.
*/
var btnCancelarCgg_gem_tipo_salario = new Ext.Button({
id:'btnCancelarCgg_gem_tipo_salario',
text:'Cancelar',
iconCls:'iconCancelar',
listeners:{
click:function(){
pnlCgg_gem_tipo_salario.getForm().reset();
}}
});
/**
* Boton que permite cerrar la ventana winFrmCgg_gem_tipo_salario.
*/
var btnCerrarCgg_gem_tipo_salario = new Ext.Button({
id:'btnCerrarCgg_gem_tipo_salario',
text:'Cerrar',
iconCls:'iconCerrar',
listeners:{
click:function(){
winFrmCgg_gem_tipo_salario.close();
}}
});
/**
* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_gem_tipo_salario.
*/
var pnlCgg_gem_tipo_salario = new Ext.form.FormPanel({
frame:true,
labelWidth :100,
items:[txtCgtsa_codigo,txtCgtsa_nombre,txtCgtsa_descripcion]
});
/**
* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_gem_tipo_salario.
*/
var winFrmCgg_gem_tipo_salario = new Ext.Window({
id:'winFrmCgg_gem_tipo_salario',
title:tituloCgg_gem_tipo_salario,
iconCls:'iconAplicacion',
width:400,
minWidth:400,
maximizable:false,
minimizable:false,
resizable:false,
modal:true,
constrain:true,
tbar:getPanelTitulo(tituloCgg_gem_tipo_salario,descCgg_gem_tipo_salario),
items:[pnlCgg_gem_tipo_salario],
bbar:[btnGuardarCgg_gem_tipo_salario,btnCancelarCgg_gem_tipo_salario,'->',btnCerrarCgg_gem_tipo_salario]
});
/**
* Funcion que aplica los privilegios del usuario.
*/
applyGrants(winFrmCgg_gem_tipo_salario.getBottomToolbar());
/**
* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_gem_tipo_salario.
*/
function cargarCgg_gem_tipo_salarioCtrls(){
if(inRecordCgg_gem_tipo_salario){
txtCgtsa_codigo.setValue(inRecordCgg_gem_tipo_salario.get('CGTSA_CODIGO'));
txtCgtsa_nombre.setValue(inRecordCgg_gem_tipo_salario.get('CGTSA_NOMBRE'));
txtCgtsa_descripcion.setValue(inRecordCgg_gem_tipo_salario.get('CGTSA_DESCRIPCION'));
isEdit = true;
}}
/**
* Funcion miembro que devuelve la ventana winFrmCgg_gem_tipo_salario.
* @returns ventana winFrmCgg_gem_tipo_salario.
* @base FrmCgg_gem_tipo_salario.prototype.show
*/
this.getWindow = function(){
return winFrmCgg_gem_tipo_salario;
}
/**
* Funcion miembro que carga los controles de la ventana winFrmCgg_gem_tipo_salario.
* @base FrmCgg_gem_tipo_salario.prototype.loadData
*/
this.loadData = function(){
cargarCgg_gem_tipo_salarioCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_gem_tipo_salario desde una instancia.
*/
FrmCgg_gem_tipo_salario.prototype.show = function(){
this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_gem_tipo_salario desde una instancia.
*/
FrmCgg_gem_tipo_salario.prototype.close = function(){
this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_gem_tipo_salario,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_gem_tipo_salario.prototype.closeHandler = function(inFunctionHandler){
this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_gem_tipo_salario desde una instancia.
*/
FrmCgg_gem_tipo_salario.prototype.loadData = function(){
this.loadData();
}
