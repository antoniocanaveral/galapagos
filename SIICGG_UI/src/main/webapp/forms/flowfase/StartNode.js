draw2d.Start=function(INRECORD_PROCESO)
{
    var datoProceso=INRECORD_PROCESO;
    var auxNombre= (datoProceso.get('CRPRO_NOMBRE') == null)?"SIN MOTIVO":datoProceso.get('CRPRO_NOMBRE');
    /*var displayLabel = '<span style="font-size: xx-small; font-family: tahoma,arial,helvetica,sans-serif;">'+
     '<b>Reclamo: <font size=2 color="red">'+datoReclamo.get('DMRE_NUMERO')+'</font></b><br>';*/

    var displayLabel = '<span style="font-size: xx-small; font-family: tahoma,arial,helvetica,sans-serif;">'+
            '<b>Proceso: <font size=2 color="red">'+auxNombre+'</font></b><br>';
    // var tmpCadenaAsunto = '<b>Asunto:</b> '+auxMotivoReaclmo+'<br>';
    /* var tmpLongitud = Math.round(tmpCadenaAsunto.length-7);
     var tmpAsunto ="";
     var tmpIndexInicial =0;
     var tmpIndexFinal =30;
     if(tmpLongitud == 1){
     tmpAsunto = tmpCadenaAsunto+'<br>';
     }else if(tmpLongitud<tmpIndexFinal){
     tmpAsunto = tmpCadenaAsunto+'<br>';
     }else{
     tmpAsunto = tmpCadenaAsunto.substring(tmpIndexInicial,tmpIndexFinal+7)+'...<br>';
     }*/

    //displayLabel+=tmpAsunto+'<span>';

    /*var imagePath = "";
     if(datoReclamo.get('DMRE_PROGRAMADO') == 0){
     imagePath = "app/SISAR/workflow/Start_Comercial.png";
     }else if(datoReclamo.get('DMRE_PROGRAMADO') == 1){
     imagePath = "app/SISAR/workflow/Start_Tecnico.png";
     }else if(datoReclamo.get('DMRE_PROGRAMADO') == 2){
     imagePath = "app/SISAR/workflow/Start_Programado.png";
     }*/
    var  imagePath = "forms/flowfase/Start_Programado.png";
    draw2d.ImageFigure.call(this,imagePath);
    this.outputPort = null;
    this.setDimension(50,50);

    this.label = new draw2d.Label(displayLabel);
    this.label.setStyledText(displayLabel);
    this.label.setCanDrag(false);
    this.label.setSelectable(false);
    this.label.setBackgroundColor(new  draw2d.Color(255,255,255));
    this.label.setBorder(new draw2d.LineBorder());
    this.textLabel = displayLabel;
    this.data = datoProceso;
    this.setSelectable(true);
}

draw2d.Start.prototype = new draw2d.ImageFigure;
draw2d.Start.prototype.type="Start";

draw2d.Start.prototype.setWorkflow=function(/*:draw2d.Workflow*/ workflow)
{
    draw2d.ImageFigure.prototype.setWorkflow.call(this,workflow);
    if(workflow!=null && this.outputPort==null)
    {
        this.outputPort = new draw2d.OutputPort();
        this.outputPort.setMaxFanOut(5); // It is possible to add "5" Connector to this port
        this.outputPort.setWorkflow(workflow);
        this.outputPort.setBackgroundColor(new  draw2d.Color(245,115,115));
        this.outputPort.setSelectable(false);
        this.addPort(this.outputPort,this.width,this.height/2);
        workflow.addFigure(this.label,this.x-20,this.y-10);
    }
}

draw2d.Start.prototype.onDrag = function()
{
    draw2d.ImageFigure.prototype.onDrag.call(this);
    this.updateLabel();
}

draw2d.Start.prototype.setPosition=function(/*:int*/ xPos , /*:int*/yPos )
{
    draw2d.ImageFigure.prototype.setPosition.call(this,xPos,yPos);
    this.updateLabel();
}

draw2d.Start.prototype.updateLabel=function()
{
    this.label.setStyledText(this.textLabel);
    var xpos = this.getX()+(this.getWidth()/2)-(this.label.getWidth()/2);
    this.label.setPosition(xpos,this.y-this.label.getHeight()-3);
}

draw2d.Start.prototype.onDoubleClick=function()
{
    annotationWindow.setStyledText('Diagrama de procesos');

    //alert(this.getWorkflow().getCurrentSelection());

    /*var param = new SOAPClientParameters();
     param.add('inDRPR_CODIGO',this.data.get('DRPR_CODIGO'));
     param.add('inTypeFormat',TYPE_FORMAT.JSON);
     var resultProcedencia = '';
     try{
     var result = eval(SOAPClient.invoke(URL_APPLICATION_SISARD+"/WSDc_rec_procedenciaSoapHttpPort","SelectDc_rec_procedenciaElement",param, false,null));
     resultProcedencia = result[0].DRPR_DESCRIPCION;
     }catch(inErr){
     resultProcedencia = '';
     }

     var param1 = new SOAPClientParameters();
     param1.add('inDRTI_CODIGO',this.data.get('DRTI_CODIGO'));
     param1.add('inTypeFormat',TYPE_FORMAT.JSON);
     var resultTipoReclamo = '';
     try{
     var result1 = eval(SOAPClient.invoke(URL_APPLICATION_SISARD+"/WSDc_rec_tipoSoapHttpPort","SelectDc_rec_tipoElement",param1, false,null));
     resultTipoReclamo = result1[0].DRTI_DESCRIPCION;
     }catch(inErr){
     resultTipoReclamo = '';
     }

     var recibidoNombre='';
     try{
     var rEmpleado=GSPARTICIPANTE.getAt(GSPARTICIPANTE.findExact('ETPA_ID',this.data.get('DMRE_ETPA_ID')));
     recibidoNombre=rEmpleado.get('ETPA_NOMBRE')+' '+rEmpleado.get('ETPA_APELLIDO');
     }catch(inError){
     recibidoNombre='';
     }

     var parroquia_canton=new Array(2);
     try{
     var rParroquia_Canton=GSPARROQUIA.getAt(GSPARROQUIA.findExact('COD_PARROQUIA',this.data.get('COD_PARROQUIA')));
     parroquia_canton[0]=rParroquia_Canton.get('NOM_PARROQUIA');
     parroquia_canton[1]=rParroquia_Canton.get('NOM_CANTON');
     }catch(inError){
     parroquia_canton='';
     }

     var inSector ='';
     for(var i in eval(DS_TIPO_LOCACION_SUBETAPA)){
     if(DS_TIPO_LOCACION_SUBETAPA[i].INDICE == this.data.get('DMRE_PERIMETRO')){
     inSector = DS_TIPO_LOCACION_SUBETAPA[i].DESCRIPCION;
     }
     }

     var inMotivoReaclamo ='';
     if(this.data.get('DMRE_MOTIVO') !=null){
     inMotivoReaclamo = this.data.get('DMRE_MOTIVO');
     }

     annotationWindow.setStyledText('<b>Reclamo No.: </b>'+this.data.get('DMRE_NUMERO')+'<br>'+
     '<b>Motivo Reclamo: </b>'+inMotivoReaclamo+'<br>'+
     '<b>Recibido por : </b>'+recibidoNombre+'<br>'+
     '<b>Fecha recepci&oacute;n: </b>'+truncDate(this.data.get('DMRE_FECHA_RECEPCION'))+'<br>'+
     '<b>Hora recepci&oacute;n:</b> '+truncTime(this.data.get('DMRE_HORA_RECEPCION'))+'<br>'+
     '<b>Medio recepci&oacute;n: </b>'+resultProcedencia+'<br>'+
     '<b>Cuenta No: </b>'+this.data.get('MAAC_CODIGO')+'<br>'+
     '<b>Informante: </b>'+this.data.get('DMRE_NOMBRE_INFORMANTE')+' '+this.data.get('DMRE_APELLIDO_INFORMANTE')+'<br>'+
     '<b>Cant&oacute;n: </b>'+parroquia_canton[1]+'<br>'+
     '<b>Parroquia: </b>'+parroquia_canton[0]+'<br>'+
     '<b>Sector: </b>'+inSector+'<br>'+
     '<b>Direcci&oacute;n: </b>'+this.data.get('DMRE_DIRECCION')+'<br>'+
     '<b>Referencia: </b>'+this.data.get('DMRE_DIRECCION_NOTIF')+'<br>'+
     '<b>Tel&eacute;fono: </b>'+this.data.get('DMRE_TELEFONO')+'<br>'+
     '<b>Tipo Reclamo: </b>'+resultTipoReclamo+'<br>'+
     '<a href="#" id="lnkImprimirReclamo" name="'+this.data.get('DMRE_NUMERO')+'|'+this.data.get('DMRE_PROGRAMADO')+'"><span>Imprimir reclamo...</span></a></span>');
     */

    /*Ext.fly('lnkImprimirReclamo').on('click',function(item){
     var recordReclamoClave = $('lnkImprimirReclamo').name.split('|');
     var urlReportReclamo = URL_REPORTS_SERVER_SISAR+'&output='+OUTPUT_REPORT+'&reportUnit=/reports/SISAR/rptReclamo&P_DMRE_CODIGO='+recordReclamoClave[0];
     window.open(urlReportReclamo);

     if (recordReclamoClave[1] == 0){
     urlReportReclamo = URL_REPORTS_SERVER_SISAR+'&output='+OUTPUT_REPORT+'&reportUnit=/reports/SISAR/rptReclamoComercial&P_DMRE_CODIGO='+recordReclamoClave[0]
     window.open(urlReportReclamo);
     }else{
     urlReportReclamo = URL_REPORTS_SERVER_SISAR+'&output='+OUTPUT_REPORT+'&reportUnit=/reports/SISAR/rptReclamoDOM&P_DMRE_CODIGO='+recordReclamoClave[0];
     window.open(urlReportReclamo);
     urlReportReclamo = URL_REPORTS_SERVER_SISAR+'&output='+OUTPUT_REPORT+'&reportUnit=/reports/SISAR/rptPlantillaMaterialesUtilizados';
     window.open(urlReportReclamo);
     }
     });		*/
}



draw2d.Start.prototype.onContextMenu= function()
{
    var myCrpro_codigo = this.data.get('CRPRO_CODIGO');
    var myCrpro_nombre = this.data.get('CRPRO_NOMBRE');
    var ctxMenu = new Ext.menu.Menu({
        floating:true,
        items : [{
            text : 'Nuevo fase',
            iconCls:'iconNuevo',
            listeners:{
                click:function ()
                {
                    var recordPrincipal = {
                        'CRPRO_CODIGO' : myCrpro_codigo,
                        'CRPRO_NOMBRE' : myCrpro_nombre,
                        'CGG_CRFAS_CODIGO' : '',
                        'CGG_CRFAS_NOMBRE' : ''
                    }

                    var objCgg_res_fase = new FrmCgg_res_fase("insert",recordPrincipal);
                    objCgg_res_fase.closeHandler(function(){
                        // gsCgg_res_fase.reload();
                    });
                    //objCgg_res_fase.loadData();
                    objCgg_res_fase.show();
                }
            }
        },
            {
                text : 'Establecer orden ',
                iconCls:'iconArriba',
                listeners:{
                    click:function ()
                    {
                        var objCgg_res_fase_orden = new FrmCgg_res_fase_orden("update",myCrpro_codigo);
                        //objCgg_res_fase.loadData();
                        objCgg_res_fase_orden.closeHandler(function(){
                            // gsCgg_res_fase.reload();
                        });
                        objCgg_res_fase_orden.show();
                    }
                }
            }
        ]
    });

    var el = ctxMenu.getEl();
    var elTempDivMenu=Ext.get("divMenu");
    elTempDivMenu.applyStyles("position:absolute;left:"+(this.getX()+50)+"px;top:"+(this.getY()+50)+"px;");
    ctxMenu.show(Ext.get('divMenu'),'br');
}




