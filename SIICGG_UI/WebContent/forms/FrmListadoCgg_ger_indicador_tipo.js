/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_ger_indicador_tipo.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_ger_indicador_tipo(){
var urlListadoCgg_ger_indicador_tipo=URL_WS+"Cgg_ger_indicador_tipo";
var tituloListadoCgg_ger_indicador_tipo='Ger indicador tipo';
var descListadoCgg_ger_indicador_tipo='El formulario permite administrar informaci\u00f3n de la tabla Ger indicador tipo';
/**
* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_ger_indicador_tipo.
*/
var btnNuevoCgg_ger_indicador_tipo = new Ext.Button({
id:'btnNuevoCgg_ger_indicador_tipo',
text:'Nuevo',
iconCls:'iconNuevo',
listeners:{
click:function(){
var objCgg_ger_indicador_tipo = new FrmCgg_ger_indicador_tipo("insert");
objCgg_ger_indicador_tipo.closeHandler(function(){
gsCgg_ger_indicador_tipo.reload();
});
objCgg_ger_indicador_tipo.show();
}}
});
/**
* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_ger_indicador_tipo.
*/
var btnEditarCgg_ger_indicador_tipo = new Ext.Button({
id:'btnEditarCgg_ger_indicador_tipo',
text:'Editar',
iconCls:'iconEditar',
listeners:{
click:function(){
var r=grdCgg_ger_indicador_tipo.getSelectionModel().getSelected();
if(r){
var objCgg_ger_indicador_tipo = new FrmCgg_ger_indicador_tipo("update",r);
objCgg_ger_indicador_tipo.closeHandler(function(){
gsCgg_ger_indicador_tipo.reload();
});
objCgg_ger_indicador_tipo.loadData();
objCgg_ger_indicador_tipo.show();
}
}}
});
/**
* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_ger_indicador_tipo.
*/
var btnEliminarCgg_ger_indicador_tipo = new Ext.Button({
id:'btnEliminarCgg_ger_indicador_tipo',
text:'Eliminar',
iconCls:'iconEliminar',
listeners:{
click:function(){
Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_ger_indicador_tipo,icon: Ext.MessageBox.QUESTION});
function SWRCgg_ger_indicador_tipo(btn){if (btn=='yes'){
try{
function CallBackCgg_ger_indicador_tipo(r){
winFrmListadoCgg_ger_indicador_tipo.getEl().unmask();
if(r=='true'){
Ext.Msg.show({
title:tituloListadoCgg_ger_indicador_tipo,
msg: 'La informaci\u00f3n de Ger indicador tipo ha sido eliminada.',
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.INFO
});
gsCgg_ger_indicador_tipo.reload();
}else{
Ext.Msg.show({
title:tituloListadoCgg_ger_indicador_tipo,
msg: 'La informaci\u00f3n de Ger indicador tipo no ha podido ser eliminada.'+(r.message?r.message:r),
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.ERROR
});
}}
winFrmListadoCgg_ger_indicador_tipo.getEl().mask('Eliminando...', 'x-mask-loading');
var param = new SOAPClientParameters();
param.add('inCggit_codigo',grdCgg_ger_indicador_tipo.getSelectionModel().getSelected().get('CGGIT_CODIGO'));
SOAPClient.invoke(urlListadoCgg_ger_indicador_tipo,"delete",param, true, CallBackCgg_ger_indicador_tipo);
}catch(inErr){
winFrmListadoCgg_ger_indicador_tipo.getEl().unmask();
}}}
}}
});
/**
* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_ger_indicador_tipo.
*/
var btnSalirCgg_ger_indicador_tipo = new Ext.Button({
id:'btnSalirCgg_ger_indicador_tipo',
text:'Salir',
iconCls:'iconSalir',
listeners:{
click:function(){
winFrmListadoCgg_ger_indicador_tipo.close();
}}
});
/**
* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_ger_indicador_tipo.
*/
var cmCgg_ger_indicador_tipo = new Ext.grid.ColumnModel([
{dataIndex:'CGGIT_CODIGO',header:'Codigo',width:150,sortable:true},
{dataIndex:'CGGIT_DESCRIPCION',header:'Descripcion',width:150,sortable:true}]);
/**
* Ext.data.Store Agrupacion de registros de la tabla Cgg_ger_indicador_tipo por un campo especifico.
*/
var gsCgg_ger_indicador_tipo = new Ext.data.Store({
proxy:new Ext.ux.bsx.SoapProxy({
url:URL_WS+"Cgg_ger_indicador_tipo",
method:"selectPage",
pagin:true
}),
remoteSort:true,
reader:new Ext.data.JsonReader({
id:'CGGIT_CODIGO',
root:'dataSet',
totalProperty: 'totalCount'
},[
{name:'CGGIT_CODIGO'},
{name:'CGGIT_DESCRIPCION'}
]),
sortInfo:{field: 'CGGIT_DESCRIPCION', direction: 'ASC'},
baseParams:{keyword:"",format:'JSON'}
});
/**
* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_ger_indicador_tipo.
*/
var pgBarCgg_ger_indicador_tipo= new Ext.PagingToolbar({
store: gsCgg_ger_indicador_tipo,
displayInfo: true,
pageSize:RECORD_PAGE,
displayMsg: 'Mostrando {0} - {1} de {2}',
temptyMsg: 'No hay informaci\u00f3n para mostrar'
});
/**
* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_ger_indicador_tipo en un formato tabular de filas y columnas.
*/
var grdCgg_ger_indicador_tipo = new Ext.grid.GridPanel({
cm:cmCgg_ger_indicador_tipo,
store:gsCgg_ger_indicador_tipo,
region:'center',
sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
loadMask:{msg:"Cargando..."},
tbar: [
'Buscar: ',
new Ext.ux.bsx.SearchField({
store:gsCgg_ger_indicador_tipo,
width:200
})
],
bbar:pgBarCgg_ger_indicador_tipo,
listeners:{
rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
if(!btnEditarCgg_ger_indicador_tipo.hidden){
btnEditarCgg_ger_indicador_tipo.fireEvent('click', btnEditarCgg_ger_indicador_tipo);
}
}}});
gsCgg_ger_indicador_tipo.reload({params:{
start:0,
limit:RECORD_PAGE,
format:'JSON'
}
});
/**
* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_ger_indicador_tipo.
*/
var winFrmListadoCgg_ger_indicador_tipo = new Ext.Window({
id:'winFrmListadoCgg_ger_indicador_tipo',
title:tituloListadoCgg_ger_indicador_tipo,
iconCls:'iconAplicacion',
width:600,
minWidth:600,
height:400,
minHeight:400,
maximizable:true,
minimizable:true,
constrain:true,
layout:'border',
tbar:getPanelTitulo('Listado '+tituloListadoCgg_ger_indicador_tipo,descListadoCgg_ger_indicador_tipo),
items:[grdCgg_ger_indicador_tipo],
bbar:[btnNuevoCgg_ger_indicador_tipo,btnEditarCgg_ger_indicador_tipo,btnEliminarCgg_ger_indicador_tipo,'->',btnSalirCgg_ger_indicador_tipo]
});
/**
* Funcion que aplica los privilegios del usuario.
*/
applyGrants(winFrmListadoCgg_ger_indicador_tipo.getBottomToolbar());
/**
* Funcion miembro que devuelve la ventana winFrmListadoCgg_ger_indicador_tipo.
* @returns ventana winFrmCgg_ger_indicador_tipo.
* @base FrmListadoCgg_ger_indicador_tipo.prototype.show
*/
this.getWindow = function(){
return winFrmListadoCgg_ger_indicador_tipo;
}
/**
* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_ger_indicador_tipo.
* @base FrmListadoCgg_ger_indicador_tipo.prototype.loadData
*/
this.loadData = function(){
gsCgg_ger_indicador_tipo.load();
}
/**
* Funcion miembro que develve el ColumnModel utilizado en el listado.
*/
this.getColumnModel = function(){
return cmCgg_ger_indicador_tipo;
}
/**
* Funcion miembro que develve el Store utilizado en el listado.
*/
this.getStore = function(){
return gsCgg_ger_indicador_tipo;
}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_ger_indicador_tipo.prototype.getColumnModel = function(){
this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_ger_indicador_tipo.prototype.getStore = function(){
this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_ger_indicador_tipo desde una instancia.
*/
FrmListadoCgg_ger_indicador_tipo.prototype.show = function(){
this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_ger_indicador_tipo desde una instancia.
*/
FrmListadoCgg_ger_indicador_tipo.prototype.close = function(){
this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_ger_indicador_tipo,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_ger_indicador_tipo.prototype.closeHandler = function(inFunctionHandler){
this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_ger_indicador_tipo desde una instancia.
*/
FrmListadoCgg_ger_indicador_tipo.prototype.loadData = function(){
this.loadData();
}
