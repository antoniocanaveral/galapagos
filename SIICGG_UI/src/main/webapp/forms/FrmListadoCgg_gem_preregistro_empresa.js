/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_gem_preregistro_empresa.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_gem_preregistro_empresa(){
var urlListadoCgg_gem_preregistro_empresa=URL_WS+"Cgg_gem_preregistro_empresa";
var tituloListadoCgg_gem_preregistro_empresa='Gem preregistro empresa';
var descListadoCgg_gem_preregistro_empresa='El formulario permite administrar informaci\u00f3n de la tabla Gem preregistro empresa';
/**
* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_gem_preregistro_empresa.
*/
var btnNuevoCgg_gem_preregistro_empresa = new Ext.Button({
id:'btnNuevoCgg_gem_preregistro_empresa',
text:'Nuevo',
iconCls:'iconNuevo',
listeners:{
click:function(){
var objCgg_gem_preregistro_empresa = new FrmCgg_gem_preregistro_empresa("insert");
objCgg_gem_preregistro_empresa.closeHandler(function(){
gsCgg_gem_preregistro_empresa.reload();
});
objCgg_gem_preregistro_empresa.show();
}}
});
/**
* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_gem_preregistro_empresa.
*/
var btnEditarCgg_gem_preregistro_empresa = new Ext.Button({
id:'btnEditarCgg_gem_preregistro_empresa',
text:'Editar',
iconCls:'iconEditar',
listeners:{
click:function(){
var r=grdCgg_gem_preregistro_empresa.getSelectionModel().getSelected();
if(r){
var objCgg_gem_preregistro_empresa = new FrmCgg_gem_preregistro_empresa("update",r);
objCgg_gem_preregistro_empresa.closeHandler(function(){
gsCgg_gem_preregistro_empresa.reload();
});
objCgg_gem_preregistro_empresa.loadData();
objCgg_gem_preregistro_empresa.show();
}
}}
});
/**
* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_gem_preregistro_empresa.
*/
var btnEliminarCgg_gem_preregistro_empresa = new Ext.Button({
id:'btnEliminarCgg_gem_preregistro_empresa',
text:'Eliminar',
iconCls:'iconEliminar',
listeners:{
click:function(){
Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_gem_preregistro_empresa,icon: Ext.MessageBox.QUESTION});
function SWRCgg_gem_preregistro_empresa(btn){if (btn=='yes'){
try{
function CallBackCgg_gem_preregistro_empresa(r){
winFrmListadoCgg_gem_preregistro_empresa.getEl().unmask();
if(r=='true'){
Ext.Msg.show({
title:tituloListadoCgg_gem_preregistro_empresa,
msg: 'La informaci\u00f3n de Gem preregistro empresa ha sido eliminada.',
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.INFO
});
gsCgg_gem_preregistro_empresa.reload();
}else{
Ext.Msg.show({
title:tituloListadoCgg_gem_preregistro_empresa,
msg: 'La informaci\u00f3n de Gem preregistro empresa no ha podido ser eliminada.'+(r.message?r.message:r),
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.ERROR
});
}}
winFrmListadoCgg_gem_preregistro_empresa.getEl().mask('Eliminando...', 'x-mask-loading');
var param = new SOAPClientParameters();
param.add('inCgpre_codigo',grdCgg_gem_preregistro_empresa.getSelectionModel().getSelected().get('CGPRE_CODIGO'));
SOAPClient.invoke(urlListadoCgg_gem_preregistro_empresa,"delete",param, true, CallBackCgg_gem_preregistro_empresa);
}catch(inErr){
winFrmListadoCgg_gem_preregistro_empresa.getEl().unmask();
}}}
}}
});
/**
* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_gem_preregistro_empresa.
*/
var btnSalirCgg_gem_preregistro_empresa = new Ext.Button({
id:'btnSalirCgg_gem_preregistro_empresa',
text:'Salir',
iconCls:'iconSalir',
listeners:{
click:function(){
winFrmListadoCgg_gem_preregistro_empresa.close();
}}
});
/**
* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_gem_preregistro_empresa.
*/
var cmCgg_gem_preregistro_empresa = new Ext.grid.ColumnModel([
{dataIndex:'CGPRE_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
{dataIndex:'CGPRE_RAZON_SOCIAL',header:'Raz\u00F3n social',width:100,sortable:true},
{dataIndex:'CGPRE_RUC',header:'Ruc',width:100,sortable:true},
{dataIndex:'CGPRE_REPRESENTANTE',header:'Representante',width:150,sortable:true,hidden:true},
{dataIndex:'CGPRE_FECHA_CREACION',header:'Fecha creacion',width:150,sortable:true,hidden:true},
{dataIndex:'CGPRE_ACTIVIDAD',header:'Actividad',width:120,sortable:true},
{dataIndex:'CGPRE_DIRECCION',header:'Direccion',width:120,sortable:true},
{dataIndex:'CGPRE_SECTOR',header:'Sector',width:150,sortable:true,hidden:true},
{dataIndex:'CGPRE_TIPO',header:'Tipo',width:150,sortable:true,hidden:true},
{dataIndex:'CGPRE_NUMERO_EMPLEADO',header:'Numero empleado',width:150,sortable:true,hidden:true},
{dataIndex:'CGPRE_TELEFONO',header:'Telefono',width:70,sortable:true},
{dataIndex:'CGPRE_EMAIL',header:'Email',width:90,sortable:true},
{dataIndex:'CGPRE_CEDULA',header:'Cedula',width:150,sortable:true,hidden:true},
{dataIndex:'CGPRE_ADJUNTO',header:'Adjunto',width:150,sortable:true,hidden:true},
{dataIndex:'CGPRE_TIPO_ADJUNTO',header:'Tipo adjunto',width:150,sortable:true,hidden:true},
{dataIndex:'CGPRE_NOMBRE_ADJUNTO',header:'Nombre adjunto',width:150,sortable:true,hidden:true}]);
/**
* Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_preregistro_empresa por un campo especifico.
*/
var gsCgg_gem_preregistro_empresa = new Ext.data.Store({
proxy:new Ext.ux.bsx.SoapProxy({
url:URL_WS+"/PublicWS/Cgg_gem_preregistro_empresa",
method:"selectPage",
pagin:true
}),
remoteSort:true,
reader:new Ext.data.JsonReader({
id:'CGPRE_CODIGO',
root:'dataSet',
totalProperty: 'totalCount'
},[
{name:'CGPRE_CODIGO'},
{name:'CGPRE_RAZON_SOCIAL'},
{name:'CGPRE_RUC'},
{name:'CGPRE_REPRESENTANTE'},
{name:'CGPRE_FECHA_CREACION'},
{name:'CGPRE_ACTIVIDAD'},
{name:'CGPRE_DIRECCION'},
{name:'CGPRE_SECTOR'},
{name:'CGPRE_TIPO'},
{name:'CGPRE_NUMERO_EMPLEADO'},
{name:'CGPRE_TELEFONO'},
{name:'CGPRE_EMAIL'},
{name:'CGPRE_CEDULA'},
{name:'CGPRE_ADJUNTO'},
{name:'CGPRE_TIPO_ADJUNTO'},
{name:'CGPRE_NOMBRE_ADJUNTO'},
{name:'CGPRE_CCTN_CODIGO'},
{name:'CGPRE_CISLA_CODIGO'}
]),
sortInfo:{field: 'CGPRE_RAZON_SOCIAL', direction: 'ASC'},
baseParams:{keyword:"",format:'JSON'}
});
/**
* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_gem_preregistro_empresa.
*/
var pgBarCgg_gem_preregistro_empresa= new Ext.PagingToolbar({
store: gsCgg_gem_preregistro_empresa,
displayInfo: true,
pageSize:RECORD_PAGE,
displayMsg: 'Mostrando {0} - {1} de {2}',
temptyMsg: 'No hay informaci\u00f3n para mostrar'
});
/**
* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_gem_preregistro_empresa en un formato tabular de filas y columnas.
*/
var grdCgg_gem_preregistro_empresa = new Ext.grid.GridPanel({
cm:cmCgg_gem_preregistro_empresa,
store:gsCgg_gem_preregistro_empresa,
region:'center',
sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
loadMask:{msg:"Cargando..."},
tbar: [
'Buscar: ',
new Ext.ux.bsx.SearchField({
store:gsCgg_gem_preregistro_empresa,
width:200
})
],
bbar:pgBarCgg_gem_preregistro_empresa,
listeners:{
rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
if(!btnEditarCgg_gem_preregistro_empresa.hidden){
btnEditarCgg_gem_preregistro_empresa.fireEvent('click', btnEditarCgg_gem_preregistro_empresa);
}
}}});
gsCgg_gem_preregistro_empresa.reload({params:{
start:0,
limit:RECORD_PAGE,
format:'JSON'
}
});
/**
* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_gem_preregistro_empresa.
*/
var winFrmListadoCgg_gem_preregistro_empresa = new Ext.Window({
id:'winFrmListadoCgg_gem_preregistro_empresa',
title:tituloListadoCgg_gem_preregistro_empresa,
iconCls:'iconAplicacion',
width:600,
minWidth:600,
height:400,
minHeight:400,
maximizable:true,
minimizable:true,
constrainHeader:true,
layout:'border',
tbar:getPanelTitulo('Listado '+tituloListadoCgg_gem_preregistro_empresa,descListadoCgg_gem_preregistro_empresa),
items:[grdCgg_gem_preregistro_empresa],
bbar:[btnNuevoCgg_gem_preregistro_empresa,btnEditarCgg_gem_preregistro_empresa,btnEliminarCgg_gem_preregistro_empresa,'-',btnReporteCgg_gem_preregistro_empresa,'->',btnSalirCgg_gem_preregistro_empresa]
});
/**
* Funcion que aplica los privilegios del usuario.
*/
applyGrants(winFrmListadoCgg_gem_preregistro_empresa.getBottomToolbar());
/**
* Funcion miembro que devuelve la ventana winFrmListadoCgg_gem_preregistro_empresa.
* @returns ventana winFrmCgg_gem_preregistro_empresa.
* @base FrmListadoCgg_gem_preregistro_empresa.prototype.show
*/
this.getWindow = function(){
return winFrmListadoCgg_gem_preregistro_empresa;
}
/**
* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_gem_preregistro_empresa.
* @base FrmListadoCgg_gem_preregistro_empresa.prototype.loadData
*/
this.loadData = function(){
gsCgg_gem_preregistro_empresa.load();
}
/**
* Funcion miembro que develve el ColumnModel utilizado en el listado.
*/
this.getColumnModel = function(){
return cmCgg_gem_preregistro_empresa;
}
/**
* Funcion miembro que develve el Store utilizado en el listado.
*/
this.getStore = function(){
return gsCgg_gem_preregistro_empresa;
}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_gem_preregistro_empresa.prototype.getColumnModel = function(){
this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_gem_preregistro_empresa.prototype.getStore = function(){
this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_gem_preregistro_empresa desde una instancia.
*/
FrmListadoCgg_gem_preregistro_empresa.prototype.show = function(){
this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_gem_preregistro_empresa desde una instancia.
*/
FrmListadoCgg_gem_preregistro_empresa.prototype.close = function(){
this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_gem_preregistro_empresa,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_gem_preregistro_empresa.prototype.closeHandler = function(inFunctionHandler){
this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_gem_preregistro_empresa desde una instancia.
*/
FrmListadoCgg_gem_preregistro_empresa.prototype.loadData = function(){
this.loadData();
}
