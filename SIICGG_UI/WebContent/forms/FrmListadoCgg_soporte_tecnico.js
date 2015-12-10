/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_soporte_tecnico.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_soporte_tecnico(){
var optMenu = 'Soporte tecnico';
var urlListadoCgg_soporte_tecnico=URL_WS+"Cgg_soporte_tecnico";
var tituloListadoCgg_soporte_tecnico='Listado Soporte tecnico';
var descListadoCgg_soporte_tecnico='El formulario permite administrar informaci\u00f3n de la tabla Soporte tecnico';
/**
* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_soporte_tecnico.
*/
var btnNuevoCgg_soporte_tecnico = new Ext.Button({
id:'btnNuevoCgg_soporte_tecnico',
text:'Nuevo',
iconCls:'iconNuevo',
listeners:{
click:function(){
var objCgg_soporte_tecnico = new FrmCgg_soporte_tecnico("insert");
objCgg_soporte_tecnico.closeHandler(function(){
gsCgg_soporte_tecnico.reload();
});
objCgg_soporte_tecnico.show();
}}
});
/**
* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_soporte_tecnico.
*/
var btnEditarCgg_soporte_tecnico = new Ext.Button({
id:'btnEditarCgg_soporte_tecnico',
text:'Editar',
iconCls:'iconEditar',
listeners:{
click:function(){
var r=grdCgg_soporte_tecnico.getSelectionModel().getSelected();
if(r){
var objCgg_soporte_tecnico = new FrmCgg_soporte_tecnico("update",r);
objCgg_soporte_tecnico.closeHandler(function(){
gsCgg_soporte_tecnico.reload();
});
objCgg_soporte_tecnico.loadData();
objCgg_soporte_tecnico.show();
}
}}
});
/**
* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_soporte_tecnico.
*/
var btnEliminarCgg_soporte_tecnico = new Ext.Button({
id:'btnEliminarCgg_soporte_tecnico',
text:'Eliminar',
iconCls:'iconEliminar',
listeners:{
click:function(){
Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_soporte_tecnico,icon: Ext.MessageBox.QUESTION});
function SWRCgg_soporte_tecnico(btn){if (btn=='yes'){
try{
function CallBackCgg_soporte_tecnico(r){
winFrmListadoCgg_soporte_tecnico.getEl().unmask();
if(r=='true'){
Ext.Msg.show({
title:tituloListadoCgg_soporte_tecnico,
msg: 'La informaci\u00f3n de Soporte tecnico ha sido eliminada.',
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.INFO
});
gsCgg_soporte_tecnico.reload();
}else{
Ext.Msg.show({
title:tituloListadoCgg_soporte_tecnico,
msg: 'La informaci\u00f3n de Cgg_soporte_tecnico no ha podido ser eliminada.',
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.ERROR
});
}}
winFrmListadoCgg_soporte_tecnico.getEl().mask('Eliminando...', 'x-mask-loading');
var param = new SOAPClientParameters();
param.add('inCsote_codigo',grdCgg_soporte_tecnico.getSelectionModel().getSelected().get('CSOTE_CODIGO'));
SOAPClient.invoke(urlListadoCgg_soporte_tecnico,"delete",param, true, CallBackCgg_soporte_tecnico);
}catch(inErr){
winFrmListadoCgg_soporte_tecnico.getEl().unmask();
}}}
}}
});
/**
* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_soporte_tecnico.
*/
var btnSalirCgg_soporte_tecnico = new Ext.Button({
id:'btnSalirCgg_soporte_tecnico',
text:'Salir',
iconCls:'iconSalir',
listeners:{
click:function(){
winFrmListadoCgg_soporte_tecnico.close();
}}
});
/**
* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_soporte_tecnico.
*/
var cmCgg_soporte_tecnico = new Ext.grid.ColumnModel([
{dataIndex:'CSOTE_CODIGO',header:'Codigo',width:150,sortable:true},
{dataIndex:'CSOTE_ASUNTO',header:'Asunto',width:150,sortable:true},
{dataIndex:'CSOTE_NUMERO',header:'Numero',width:150,sortable:true},
{dataIndex:'CSOTE_DESCRIPCION',header:'Descripcion',width:150,sortable:true},
{dataIndex:'CSOTE_CONTACTO',header:'Contacto',width:150,sortable:true},
{dataIndex:'CSOTE_ATENDIDO',header:'Atendido',width:150,sortable:true}]);
/**
* Ext.data.Store Agrupacion de registros de la tabla Cgg_soporte_tecnico por un campo especifico.
*/
var gsCgg_soporte_tecnico = new Ext.data.Store({
proxy:new Ext.ux.bsx.SoapProxy({
url:URL_WS+"Cgg_soporte_tecnico",
method:"selectPage",
pagin:true
}),
remoteSort:true,
reader:new Ext.data.JsonReader({
id:'CSOTE_CODIGO',
root:'dataSet',
totalProperty: 'totalCount'
},[
{name:'CSOTE_CODIGO'},
{name:'CSOTE_ASUNTO'},
{name:'CSOTE_NUMERO'},
{name:'CSOTE_DESCRIPCION'},
{name:'CSOTE_CONTACTO'},
{name:'CSOTE_ATENDIDO'}
]),
sortInfo:{field: 'CSOTE_ASUNTO', direction: 'ASC'},
baseParams:{keyword:"",format:"JSON"}
});
/**
* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_soporte_tecnico.
*/
var pgBarCgg_soporte_tecnico= new Ext.PagingToolbar({
store: gsCgg_soporte_tecnico,
displayInfo: true,
pageSize:RECORD_PAGE,
displayMsg: 'Mostrando {0} - {1} de {2}',
temptyMsg: 'No hay informaci\u00f3n para mostrar'
});
/**
* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_soporte_tecnico en un formato tabular de filas y columnas.
*/
var grdCgg_soporte_tecnico = new Ext.grid.GridPanel({
cm:cmCgg_soporte_tecnico,
store:gsCgg_soporte_tecnico,
region:'center',
sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
loadMask:{msg:"Cargando..."},
tbar: [
'Buscar: ', ' ',
new Ext.ux.bsx.SearchField({
store:gsCgg_soporte_tecnico,
width:200
})
],
bbar:pgBarCgg_soporte_tecnico,
listeners:{
rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
if(!btnEditarCgg_soporte_tecnico.hidden){
btnEditarCgg_soporte_tecnico.fireEvent('click', btnEditarCgg_soporte_tecnico);
}
}}});
gsCgg_soporte_tecnico.reload({params:{
start:0,
limit:RECORD_PAGE,
format:"JSON"
}
});
/**
* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_soporte_tecnico.
*/
var winFrmListadoCgg_soporte_tecnico = new Ext.Window({
id:'winFrmListadoCgg_soporte_tecnico',
title:tituloListadoCgg_soporte_tecnico,
tbar:getPanelTitulo('Listado '+tituloListadoCgg_soporte_tecnico,descListadoCgg_soporte_tecnico),
items:[grdCgg_soporte_tecnico],
width:600,
minWidth:600,
height:400,
minHeight:400,
maximizable:true,
minimizable:true,
constrain:true,
layout:'border',
bbar:[btnNuevoCgg_soporte_tecnico,btnEditarCgg_soporte_tecnico,btnEliminarCgg_soporte_tecnico,'->',btnSalirCgg_soporte_tecnico]
});
/**
* Funcion que aplica los privilegios del usuario.
*/
applyGrants(winFrmListadoCgg_soporte_tecnico.getBottomToolbar());
/**
* Funcion miembro que devuelve la ventana winFrmListadoCgg_soporte_tecnico.
* @returns ventana winFrmCgg_soporte_tecnico.
* @base FrmListadoCgg_soporte_tecnico.prototype.show
*/
this.getWindow = function(){
return winFrmListadoCgg_soporte_tecnico;
}
/**
* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_soporte_tecnico.
* @base FrmListadoCgg_soporte_tecnico.prototype.loadData
*/
this.loadData = function(){
gsCgg_soporte_tecnico.load();
}
/**
* Funcion miembro que develve el ColumnModel utilizado en el listado.
*/
this.getColumnModel = function(){
return cmCgg_soporte_tecnico;
}
/**
* Funcion miembro que develve el Store utilizado en el listado.
*/
this.getStore = function(){
return gsCgg_soporte_tecnico;
}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_soporte_tecnico.prototype.getColumnModel = function(){
this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_soporte_tecnico.prototype.getStore = function(){
this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_soporte_tecnico desde una instancia.
*/
FrmListadoCgg_soporte_tecnico.prototype.show = function(){
this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_soporte_tecnico desde una instancia.
*/
FrmListadoCgg_soporte_tecnico.prototype.close = function(){
this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_soporte_tecnico,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_soporte_tecnico.prototype.closeHandler = function(inFunctionHandler){
this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_soporte_tecnico desde una instancia.
*/
FrmListadoCgg_soporte_tecnico.prototype.loadData = function(){
this.loadData();
}
