var myEstado;
draw2d.End=function(INSEGUIMIENTO_RECORD,INRECORD_PROCESO1){
    var SeguimientoData = INSEGUIMIENTO_RECORD;
    var infaseNombre = SeguimientoData['CRFAS_NOMBRE'];
    var datoProceso1=INRECORD_PROCESO1;
    var displayLabel = '<span style="font-size: xx-small; font-family: tahoma,arial,helvetica,sans-serif;">'+
    'Fase: '+infaseNombre+	'<span>';

    draw2d.ImageFigure.call(this,'forms/flowfase/EndNoAbierto.png');

    this.inputPort = null;
    this.setDimension(50,50);
    this.label = new draw2d.Label(displayLabel);
    this.label.setStyledText(displayLabel);
    this.label.setCanDrag(false);
    this.label.setSelectable(false);
    this.label.setBackgroundColor(new  draw2d.Color(255,255,255));
    this.label.setBorder(new draw2d.LineBorder());
    this.textLabel = displayLabel;
    this.data = SeguimientoData;
    this.data1 = datoProceso1;
    this.setSelectable(false);
}

draw2d.End.prototype = new draw2d.ImageFigure;
draw2d.End.prototype.type="End";

draw2d.End.prototype.setWorkflow=function(/*:draw2d.Workflow*/ workflow){
    draw2d.ImageFigure.prototype.setWorkflow.call(this,workflow);

    if(workflow!=null && this.inputPort==null){
        this.inputPort = new draw2d.MyInputPort();
        this.inputPort.setWorkflow(workflow);
        this.inputPort.setBackgroundColor(new  draw2d.Color(115,115,245));
        this.inputPort.setColor(null);
        this.addPort(this.inputPort,0,this.height/2);

        this.outputPort = new draw2d.OutputPort();
        this.outputPort.setMaxFanOut(5); // It is possible to add "5" Connector to this port
        this.outputPort.setWorkflow(workflow);
        this.outputPort.setBackgroundColor(new  draw2d.Color(245,115,115));
        this.addPort(this.outputPort,this.width,this.height/2);

        workflow.addFigure(this.label,this.x-20,this.y-10);
    }
}

draw2d.End.prototype.onDrag = function(){
    draw2d.ImageFigure.prototype.onDrag.call(this);
    this.updateLabel();
}

draw2d.End.prototype.setPosition=function(/*:int*/ xPos , /*:int*/yPos ){
    draw2d.ImageFigure.prototype.setPosition.call(this,xPos,yPos);
    this.updateLabel();
}

draw2d.End.prototype.updateLabel=function(){
    this.label.setStyledText(this.textLabel);
    var xpos = this.getX()+(this.getWidth()/2)-(this.label.getWidth()/2);
    this.label.setPosition(xpos,this.y-this.label.getHeight()-3);
}

draw2d.End.prototype.onDoubleClick=function(){
    var msgInfoSeguimiento = '<span>'+
    '<b>  Fase: </b>'+this.data['CRFAS_NOMBRE']+'<br>'+
    '<b>  Tarea: </b>'+this.data['CRFAS_TAREA_REALIZA']+'<br>'+
    '<b>  Secci\u00f3n: </b>'+this.data['CRSEC_NOMBRE']+'<br>'+
    '</span>';
    var faseTooltip =  new Ext.ToolTip({
        title: 'Datos de fase',
        anchor: 'top',
        anchorOffset: 85,
        html: msgInfoSeguimiento,
        trackMouse:true,
        dismissDelay: 5000,
        draggable:true
    });


    var tmpElement = Ext.get('divDiagrama');
    faseTooltip .showAt([tmpElement.getX()+this.getX()+50,tmpElement.getY()+this.y]);
}

draw2d.End.prototype.onContextMenu=function(){
    var myCrpro_codigo1 = this.data1.get('CRPRO_CODIGO');
    var myCrpro_nombre1 = this.data1.get('CRPRO_NOMBRE');
    var myCrfas_codigo = this.data['CRFAS_CODIGO'];
    var myCrfas_nombre = this.data['CRFAS_NOMBRE'];
    var myCgg_crfas_codigo = this.data['CGG_CRFAS_CODIGO'];
    var myCgg_crfas_nombre = this.data['CGG_CRFAS_NOMBRE'];
    var myRecordFase = this.data;
    var urlCgg_res_fase_general_end=URL_WS+"Cgg_res_fase";
    var ctxMenuEnd = new Ext.menu.Menu({
        floating:true,
        items : [{
            text : 'Nuevo fase',
            iconCls:'iconNuevo',
            listeners:{
                click:function ()
                {
                    var recordPrincipal = {
                        'CRPRO_CODIGO' : myCrpro_codigo1,
                        'CRPRO_NOMBRE' : myCrpro_nombre1,
                        'CGG_CRFAS_CODIGO' : myCrfas_codigo,
                        'CGG_CRFAS_NOMBRE' : myCrfas_nombre
                    }

                    var objCgg_res_fase = new FrmCgg_res_fase("insert",recordPrincipal);
                    objCgg_res_fase.closeHandler(function(){
                        });
                    objCgg_res_fase.show();
                }
            }
        },{
            text : 'Editar fase',
            iconCls: 'iconEditar',
            listeners:{
                click:function(){
                    try{

                        var recordPrincipal = {
                            'CRPRO_CODIGO' : myCrpro_codigo1,
                            'CRPRO_NOMBRE' : myCrpro_nombre1,
                            'CGG_CRFAS_CODIGO' : myCgg_crfas_codigo,
                            'CGG_CRFAS_NOMBRE' : myCgg_crfas_nombre
                        }


                        var objCgg_res_fase = new FrmCgg_res_fase('update',recordPrincipal,myRecordFase);
                        objCgg_res_fase.closeHandler(function(){
                            });
                        objCgg_res_fase.loadData();
                        objCgg_res_fase.show();

                    }catch(inErr){
                        alert(inErr);
                    }
                }
            }
    },{
        text : 'Eliminar fase',
        iconCls: 'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({
                    title:'Administraci\u00f3n de procesos y fases', 
                    msg:'Est\u00e1 seguro de eliminar?<br>No se puede eliminar fases que tienen fases hijas o siguientes.', 
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_res_fase,
                    icon: Ext.MessageBox.QUESTION
                    });
                function SWRCgg_res_fase(btn){
                    if (btn=='yes'){
                        try{
                            function CallBackCgg_res_fase(r){
                                if(r=='true'){
                                    Ext.Msg.show({
                                        title:'Administraci\u00f3n de procesos y fases',
                                        msg: 'La informaci\u00f3n de fase ha sido eliminada.<br>Refresque el diagrama de proceso, por favor.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                        
                                }else{
                                    Ext.Msg.show({
                                        title:'Administraci\u00f3n de procesos y fases',
                                        msg: 'La informaci\u00f3n de fase no ha podido ser eliminada.<br>'+ERR_MESSAGE+'<br>Error:'+r,
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
                            }                                
                        var param = new SOAPClientParameters();
                        param.add('inCrfas_codigo',myCrfas_codigo);
                        SOAPClient.invoke(urlCgg_res_fase_general_end,"delete",param, true, CallBackCgg_res_fase);
                    }catch(inErr){
                    //winFrmListadoCgg_res_fase.getEl().unmask();
                    }
                }
            }
    }
}
}]
});

var elTempDivMenu=Ext.get("divMenu");
elTempDivMenu.applyStyles("position:absolute;left:"+(this.getX()+50)+"px;top:"+(this.getY()+50)+"px;");
ctxMenuEnd.show(Ext.get('divMenu'),'br');
}

