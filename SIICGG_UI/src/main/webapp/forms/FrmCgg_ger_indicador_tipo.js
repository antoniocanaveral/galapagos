/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_ger_indicador_tipo.
* @param {String} IN_SENTENCIA_CGG_GER_INDICADOR_TIPO Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_GER_INDICADOR_TIPO Registro de datos de la tabla Cgg_ger_indicador_tipo.
* @constructor
* @base FrmListadoCgg_ger_indicador_tipo
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_ger_indicador_tipo(IN_SENTENCIA_CGG_GER_INDICADOR_TIPO,IN_RECORD_CGG_GER_INDICADOR_TIPO){
var inSentenciaCgg_ger_indicador_tipo = IN_SENTENCIA_CGG_GER_INDICADOR_TIPO;
var inRecordCgg_ger_indicador_tipo=IN_RECORD_CGG_GER_INDICADOR_TIPO;
var urlCgg_ger_indicador_tipo=URL_WS+"Cgg_ger_indicador_tipo";
var tituloCgg_ger_indicador_tipo='Ger indicador tipo';
var descCgg_ger_indicador_tipo='El formulario permite administrar la informaci\u00f3n de la tabla Ger indicador tipo';
var isEdit = false;
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
*/
var txtCggit_codigo = new Ext.form.TextField({
id:'txtCggit_codigo',
name:'txtCggit_codigo',
fieldLabel :'Codigo',
anchor:'98%',
value:"KEYGEN",
hidden:true,
hideLabel:true,
allowBlank :false
});
/**
* Ext.form.TextArea DESCRIPCION DEL TIPO DE INDICADOR
*/
var txtCggit_descripcion = new Ext.form.TextArea({
id:'txtCggit_descripcion',
name:'txtCggit_descripcion',
fieldLabel :'Descripcion',
width:'90%',
allowBlank :false
});
/**
* Boton que permite almacenar la informacion de la ventana winFrmCgg_ger_indicador_tipo
*/
var btnGuardarCgg_ger_indicador_tipo = new Ext.Button({
id:'btnGuardarCgg_ger_indicador_tipo',
text:'Guardar',
iconCls:'iconGuardar',
listeners:{
click:function(){
if (!pnlCgg_ger_indicador_tipo.getForm().isValid()){
return;
}
try{
function CallBackCgg_ger_indicador_tipo(r){
winFrmCgg_ger_indicador_tipo.getEl().unmask();
if(r=='true'){
Ext.Msg.show({
title:tituloCgg_ger_indicador_tipo,
msg: 'La informaci\u00f3n de Ger indicador tipo ha sido almacenada.',
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.INFO
});winFrmCgg_ger_indicador_tipo.close()
}else{
Ext.Msg.show({
title:tituloCgg_ger_indicador_tipo,
msg: 'La informaci\u00f3n de Ger indicador tipo no ha podido ser almacenada. '+(r.message?r.message:r),
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.ERROR
});
}
}
winFrmCgg_ger_indicador_tipo.getEl().mask('Guardando...', 'x-mask-loading');
var param = new SOAPClientParameters();
if(isEdit)
param.add('inCggit_codigo',txtCggit_codigo.getValue());
param.add('inCggit_descripcion',txtCggit_descripcion.getValue());
SOAPClient.invoke(urlCgg_ger_indicador_tipo,IN_SENTENCIA_CGG_GER_INDICADOR_TIPO,param, true, CallBackCgg_ger_indicador_tipo);
}catch(inErr){
winFrmCgg_ger_indicador_tipo.getEl().unmask();
}
}}
});
/**
* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_ger_indicador_tipo.
*/
var btnCancelarCgg_ger_indicador_tipo = new Ext.Button({
id:'btnCancelarCgg_ger_indicador_tipo',
text:'Cancelar',
iconCls:'iconCancelar',
listeners:{
click:function(){
pnlCgg_ger_indicador_tipo.getForm().reset();
}}
});
/**
* Boton que permite cerrar la ventana winFrmCgg_ger_indicador_tipo.
*/
var btnCerrarCgg_ger_indicador_tipo = new Ext.Button({
id:'btnCerrarCgg_ger_indicador_tipo',
text:'Cerrar',
iconCls:'iconCerrar',
listeners:{
click:function(){
winFrmCgg_ger_indicador_tipo.close();
}}
});
/**
* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_ger_indicador_tipo.
*/
var pnlCgg_ger_indicador_tipo = new Ext.form.FormPanel({
frame:true,
labelWidth :100,
items:[txtCggit_codigo,txtCggit_descripcion]
});
/**
* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_ger_indicador_tipo.
*/
var winFrmCgg_ger_indicador_tipo = new Ext.Window({
id:'winFrmCgg_ger_indicador_tipo',
title:tituloCgg_ger_indicador_tipo,
iconCls:'iconAplicacion',
width:400,
minWidth:400,
maximizable:true,
minimizable:true,
constrain:true,
tbar:getPanelTitulo(tituloCgg_ger_indicador_tipo,descCgg_ger_indicador_tipo),
items:[pnlCgg_ger_indicador_tipo],
bbar:[btnGuardarCgg_ger_indicador_tipo,btnCancelarCgg_ger_indicador_tipo,'->',btnCerrarCgg_ger_indicador_tipo]
});
/**
* Funcion que aplica los privilegios del usuario.
*/
applyGrants(winFrmCgg_ger_indicador_tipo.getBottomToolbar());
/**
* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_ger_indicador_tipo.
* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
*/
function habilitarCgg_ger_indicador_tipoCtrls(inEstado){
estado=!inEstado;
txtCggit_codigo.setDisabled(estado);
txtCggit_descripcion.setDisabled(estado);
}
/**
* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_ger_indicador_tipo.
*/
function cargarCgg_ger_indicador_tipoCtrls(){
if(inRecordCgg_ger_indicador_tipo){
txtCggit_codigo.setValue(inRecordCgg_ger_indicador_tipo.get('CGGIT_CODIGO'));
txtCggit_descripcion.setValue(inRecordCgg_ger_indicador_tipo.get('CGGIT_DESCRIPCION'));
isEdit = true;
habilitarCgg_ger_indicador_tipoCtrls(true);
}}
/**
* Funcion miembro que devuelve la ventana winFrmCgg_ger_indicador_tipo.
* @returns ventana winFrmCgg_ger_indicador_tipo.
* @base FrmCgg_ger_indicador_tipo.prototype.show
*/
this.getWindow = function(){
return winFrmCgg_ger_indicador_tipo;
}
/**
* Funcion miembro que carga los controles de la ventana winFrmCgg_ger_indicador_tipo.
* @base FrmCgg_ger_indicador_tipo.prototype.loadData
*/
this.loadData = function(){
cargarCgg_ger_indicador_tipoCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_ger_indicador_tipo desde una instancia.
*/
FrmCgg_ger_indicador_tipo.prototype.show = function(){
this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_ger_indicador_tipo desde una instancia.
*/
FrmCgg_ger_indicador_tipo.prototype.close = function(){
this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_ger_indicador_tipo,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_ger_indicador_tipo.prototype.closeHandler = function(inFunctionHandler){
this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_ger_indicador_tipo desde una instancia.
*/
FrmCgg_ger_indicador_tipo.prototype.loadData = function(){
this.loadData();
}
