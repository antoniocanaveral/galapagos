/**
 *FUNCION QUE PERMITE CREAR UN FORMULARIO PARA ACTUALIZAR LAS CLAVES DE USUARIO
 *@param inUser USUARIO
 *@param inOP COMPRUEBA SI DEBE O NO INGRESAR LA CLAVE ANTERIOR
 */
function FrmCgg_tct_reporte_finaniero(inUser){	
	var inReportName ='rptReporteFinancieroEspeciesTCT';
	var inReportFolder = '/Reports/sii/tct';
	var urlReport = null;
	 var params = null;
	
    var btnAceptarUsuarioAC = new Ext.Button({
        id:'btnAceptarUsuarioAC',
        text:'Aceptar',
        iconCls:'iconAceptar',
        tooltip:'Visualiza su reporte',
        handler:function (){
        	 var tmp1='{';
             if(pnlUsuarioAC.getForm().isValid()==false){
                 return;
             }
             
             for(var i =0;i<params.length;i++){                    
                 if(Ext.isBoolean(params[i].paramValue) || Ext.isNumber(params[i].paramValue)){
                     tmp1 += params[i].paramName+":"+params[i].paramValue+",";
                 }else{                        
                     tmp1 += params[i].paramName+":'"+params[i].paramValue+"',";
                 }                   
             }
             tmp1=tmp1.substring(0,tmp1.length-1)+'}';
             tmp1=eval('('+tmp1+')');
             urlReport = new Reporte(inReportName,inReportFolder,tmp1).getUrl();
             window.open(urlReport);                     
			
        }
    });


	
    var btnCancelarUsuarioAC = new Ext.Button({
        id:'btnCancelarUsuarioAC',
        text: 'Cerrar',
        iconCls: 'iconSalir',
        tooltip:'Cierra el formulario actual',     
        handler:function (){
            winUsuarioAC.close();
			
        }
    });
	
	var pnlUsuarioAC = new Ext.form.FormPanel({
		autoHeigth:true,
		frame:true,
		 items:[{
	            xtype:'label',
	            fieldLabel:'hola',
	            text:'hola'
	        }]
	});
	
    var winFrmCgg_tct_reporte_finaniero = new Ext.Window({
        id:'winFrmCgg_tct_reporte_finaniero',
        title:'Criterio de reporte',
        iconCls:'iconReporte',
        width:400,
        minWidth:400, 
        autoHeight:true,
        constrain:true,
        tbar: getPanelTitulo('Criterio de reporte', 'Este formulario le permite establecer los criterios para su reporte.'),
        items:[pnlUsuarioAC],
        modal:true,
        bbar:[btnAceptarUsuarioAC,'->',btnCancelarUsuarioAC]

    });
	
    /**
     *FUNCION MIEMBRO QUE DEVUELVE LA VENTANA winFrmCgg_tct_reporte_finaniero
     * @returns VENTANA winFrmCgg_tct_reporte_finaniero.
     */ 
    this.getWindow = function(){
        return winFrmCgg_tct_reporte_finaniero;
    };
	
	   /**
     *Agrega parametros o componentes visuales al formulario actual.
     */
    this.addParams = function(inParams){
        if(Ext.isArray(inParams)==true){
            var comps= [];
            var total = inParams.length-1;
            params=inParams;
            pnlUsuarioAC.removeAll();
            for(var i=total;i>=0;i--){
                var param = inParams[i];                

                try{
                    if(param.required == undefined || param.required == null){
                        param.required = false;
                    }
                    
                }catch(inErr){
                    param.prototype.required=true;
                }
                
                try{
                    if(param.value == undefined || param.value == null){
                        param.value = "";
                    }
                    
                }catch(inErr){
                    param.prototype.value='';
                }

                if(param.required==true){
                    param.label = param.label+'*';
                }

                switch(param.type){
                  case 'date':                        
                        comps[i] = {
                            id:'dt'+param.paramName,
                            fieldLabel:param.label,
                            xtype:'datefield',                            
                            value: param.value ? param.value : new Date(),
                            name:param.paramName,
                            allowBlank:!param.required,
                            blankText:'Establezca el valor, por favor.',
                        	listeners:{
                                change:changeHandler
                            }
                            
                        };
                        break;
        
                  case 'combo':
                      comps[i] = {
                          id:'cbx'+param.paramName,
                          fieldLabel:param.label,
                          xtype:'combo',
                          anchor:'80%',
                          name:param.paramName,
                          allowBlank:!param.required,
                          store:param.value,
                          mode: 'local',
                          forceSelection:true,
                          editable:false,
                          triggerAction:'all',
                          selectOnFocus:true,
                          listeners:{
                              change:changeHandler
                          }
                      };
                      break;
                }                
            }    
            pnlUsuarioAC.add(comps);            
            pnlUsuarioAC.doLayout();            
            winFrmCgg_tct_reporte_finaniero.doLayout();
        }        
    };
    
    
    function findParam(inParamName){
        var result = null;
        for(var i=0;i<params.length;i++){
            if(params[i].paramName == inParamName){
                result = params[i];
            }
        }
        return result;
    }
    
    function changeHandler(inThis, inNewValue, inOldValue){
        var tmpParam = findParam(inThis.name);
        if(inThis.getXType()=='combo'||inThis.getXType()=='textfield'){
            tmpParam.paramValue =inNewValue;
        }else{
            tmpParam.paramValue = inNewValue.toString('yyyyMMdd');
        }
    }
}

/**
 *Funcion prototipo. Permite mostrar la ventana winFrmCgg_tct_reporte_finaniero desde una instancia.
 */
FrmCgg_tct_reporte_finaniero.prototype.show = function(){
 var dsTipoEspecie1= [['CKESP6','TCT TRANSEUNTE'],['CKESP4','TCT no valorada'],['CKESP3','TCT TURISTAS']];
 var dsPuntoVenta= [['CKPVT7','AEROPUERTO BALTRA'],['CKPVT2','AEROPUERTO GUAYAQUIL'],['CKPVT8','AEROPUERTO ISABELA'],['CKPVT1','AEROPUERTO QUITO '],['CKPVT6','AEROPUERTO SAN CRISTOBAL'],['CKPVT10','OFICINA QUITO'],['CKPVT9','PUERTO AYORA - SANTA CRUZ'],['CKPVT5','RESIDENCIA ISABELA'],['CKPVT3','RESIDENCIA SAN CRISTOBAL'],['CKPVT4','RESIDENCIA SANTA CRUZ']];
 var params = [];
     
     params[0]={
         label:'Fecha inicio',
         paramName:'P_FECHA_INICIAL',
         paramValue:CURRENT_DATE.toString('yyyyMMdd'),
         type:'date'
     };

     params[1]={
         label:'Fecha fin',
         paramName:'P_FECHA_FINAL',
         paramValue:CURRENT_DATE.toString('yyyyMMdd'),
         type:'date'
     };
  	 
     params[2]={
  			 label:'Punto de venta',
             paramName:'P_CKPVT_CODIGO',
             value:dsPuntoVenta,
			 paramValue:'',
             type:'combo'
     };
     params[3]=
     {
    		 label:'Tipo de especie',
             paramName:'P_CKESP_CODIGO',
             value:dsTipoEspecie1,
			 paramValue:'',
             type:'combo'
     };
     
    this.addParams(params);
    this.getWindow().show();
   
}

/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_tct_reporte_finaniero desde una instancia.
 */
FrmCgg_tct_reporte_finaniero.prototype.close = function(){
    this.getWindow().close();
}

/**
 *Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_tct_reporte_finaniero,
 *con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_tct_reporte_finaniero.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}

/**
 *Funcion prototipo. Permite establecer el codigo de la persona
 *@param inCrper_codigo codigo de persona
 */
FrmCgg_tct_reporte_finaniero.prototype.setCrper_codigo = function(inCrper_codigo){
	this.setCrper_codigo(inCrper_codigo);
}

FrmCriterioReporte.prototype.addParams = function(inParams){
    this.addParams(inParams);
}