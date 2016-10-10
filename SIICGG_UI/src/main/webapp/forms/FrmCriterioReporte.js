/**
 *Crea el formulario de seleccion y establecimiento de criterio para la visalizacion de reportes.
 *@param inReportName Nombre de reporte.
 *@param inReportFolder Directorio del reporte en jasperserver.
 *@param inParams Parametros del reporte.
 */
function FrmCriterioReporte(inReportName,inReportFolder,inParams){

    var urlReport = null;
    var params = null;
    var title = null;
    
    if(inParams!==null && inParams!==undefined){
    // this.addParams(inParams);
    }

    var pnlCriterioReporte = new Ext.form.FormPanel({        
        autoHeigth:true,
        frame:true,
        items:[{
            xtype:'label',
            fieldLabel:'hola',
            text:'hola'
        }]
    });

    /**
 *Crea una ventana para el objecto FrmCriterioReporte.
 */
    var winFrmCriterioReporte = new Ext.Window({
        id:'winFrmCriterioReporte',
        title:title ? 'Criterio de reporte - '+title:'Criterio de reporte' ,
        iconCls:'iconReporte',
        width:400,
        minWidth:400, 
        autoHeight:true,
        constrain:true,
        tbar: getPanelTitulo('Criterio de reporte', 'Este formulario le permite establecer los criterios para su reporte.'),
        items:[pnlCriterioReporte],                
        modal:true,
        bbar: [{
            text:'Aceptar',
            id:"btnVerReporte",
            tooltip:'Visualiza su reporte',
            iconCls:'iconAceptar',
            handler:function(){                                                                
                var tmp1='{';
                if(pnlCriterioReporte.getForm().isValid()==false){
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
        }/*,{
            text:'Cancelar',
            id:"btnCancelar",            
            iconCls:'iconAceptar',
            tooltip:'Visualiza el reporte',
            handler:function(){
                pnlCriterioReporte.getForm().clearInvalid();
                pnlCriterioReporte.getForm().reset();                
            }
        }*/,'->',{
            text: 'Cerrar',
            iconCls: 'iconSalir',
            tooltip:'Cierra el formulario actual',            
            handler:function(){
                winFrmCriterioReporte.close();
            }
        }]
    });

    /**
 *Devuelve la ventada del objecto FrmCriterioReporte.
 */
    this.getWindow = function(){
        return winFrmCriterioReporte;
    }

    this.getTitle = function(inTitle){
        title = inTitle;
    }

    /*{
 *  objectName:Nombre de un objeto que contenga internamente un store y un columnmodel.
 *  label:Titulo del campo,
 *  valueField:Columna del valor a seleccionar,
 *  displayField:Columna del valor a desplegar,
 *  paramName:Nombre del parametro del reporte,
 *  paramValue:Vacio por defecto,
 *  type:Tipo del control
 * }*/

    /**
     *Agrega parametros o componentes visuales al formulario actual.
     */
    this.addParams = function(inParams){
        if(Ext.isArray(inParams)==true){
            var comps= [];
            var total = inParams.length-1;
            params=inParams;
            pnlCriterioReporte.removeAll();
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
                    case 'input':
                        comps[i] = {
                            id:'txt'+param.paramName,
                            fieldLabel:param.label,
                            xtype:'textfield',
                            anchor:'80%',
                            name:param.paramName,
                            allowBlank:!param.required,
                            value:param.value,
                            listeners:{
                                change:changeHandler
                            }
                        };
                        param.paramValue = param.value;
                        break;
                    case 'direct':
                        comps[i] = {
                            id:'txt'+param.paramName,
                            fieldLabel:param.label,
                            xtype:'textfield',
                            anchor:'80%',
                            name:param.paramName,                            
                            readOnly:true,
                            value:param.value
                        };                        
                        break;
                    case 'hidden':
                        comps[i] = {
                            id:'txt'+param.paramName,
                            fieldLabel:'none',
                            xtype:'textfield',                            
                            name:param.paramName,                                                        
                            value:param.value,
                            hidden:true
                        };                        
                        break;
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
                    case 'number':
                        comps[i] ={
                            id:'sp'+param.paramName,
                            fieldLabel:param.label,
                            xtype:'spinnerfield',
                            name:param.paramName,
                            value: param.value ? param.value : 0,
                            allowBlank:!param.required,
                            blankText:'Establezca el valor, por favor.',                            
                            listeners:{
                                change:changeHandler
                            }
                        };
                        break;
                    case 'searchable':
                        comps[i] = {
                            xtype:'panel',
                            layout:'column',
                            anchor:'98%',
                            items:[{
                                columnWidth:.93,
                                layout:'form',
                                anchor:'100%',
                                items:[{
                                    xtype:'textfield',
                                    readOnly:true,
                                    id:'txt'+param.paramName,
                                    allowBlank:!param.required,
                                    blankText:'Establezca el valor, por favor.',
                                    anchor:'100%',
                                    fieldLabel:param.label,
                                    value:param.value
                                }]
                            },{
                                columnWidth:.07,
                                layout:'form',
                                items:[{
                                    xtype:'button',
                                    iconCls:'iconBuscar',
                                    id:'btn'+param.paramName,
                                    name:param.paramName,
                                    handler:function(inBtn,inEvent){
                                        var tmpParam = findParam(inBtn.name);
                                        var tmpData = tmpParam.objectName;
                                        tmpData = eval('new '+tmpData+'()');

                                        var objBusqueda = new DlgBusqueda(tmpData.getStore(),tmpData.getColumnModel());
                                        objBusqueda.closeHandler(function(){
                                            var tmpRecord = objBusqueda.getSelectedRow();
                                            if(tmpRecord!=null && tmpRecord!=undefined){

                                                var tmpColumns = '';
                                                if(tmpParam.displayField.indexOf('|')>=0){
                                                    var tmpCol = tmpParam.displayField.split('|');
                                                    for(var i=0;i<tmpCol.length;i++){
                                                        tmpColumns += "tmpRecord.get('"+tmpCol[i]+"')+' '+";
                                                    }
                                                    tmpColumns  = tmpColumns.substring(0,tmpColumns.length-1); 
                                                }else{
                                                    tmpColumns += "tmpRecord.get('"+tmpParam.displayField+"')";
                                                }

                                                Ext.getCmp('txt'+tmpParam.paramName).setValue(eval(tmpColumns));
                                                tmpParam.paramValue =tmpRecord.get(tmpParam.valueField);
                                            }
                                        });
                                        objBusqueda.show();
                                    }
                                }]
                            }]
                        };
                        break;
                    case 'searchablenopagin':
                        comps[i] = {
                            xtype:'panel',
                            layout:'column',
                            anchor:'98%',
                            items:[{
                                columnWidth:.93,
                                layout:'form',
                                anchor:'100%',
                                items:[{
                                    xtype:'textfield',
                                    readOnly:true,
                                    id:'txt'+param.paramName,
                                    allowBlank:!param.required,
                                    blankText:'Establezca el valor, por favor.',
                                    anchor:'100%',
                                    fieldLabel:param.label,
                                    value:param.value
                                }]
                            },{
                                columnWidth:.07,
                                layout:'form',
                                items:[{
                                    xtype:'button',
                                    iconCls:'iconBuscar',
                                    id:'btn'+param.paramName,
                                    name:param.paramName,
                                    handler:function(inBtn,inEvent){
                                        var tmpParam = findParam(inBtn.name);
                                        var tmpData = tmpParam.objectName;
                                        tmpData = eval('new '+tmpData+'()');

                                        var objBusqueda = new DlgBusquedaNoPaginado(tmpData.getStore(),tmpData.getColumnModel(),false);
                                        objBusqueda.closeHandler(function(){
                                            var tmpRecord = objBusqueda.getSelectedRow();
                                            if(tmpRecord!=null && tmpRecord!=undefined){

                                                var tmpColumns = '';
                                                if(tmpParam.displayField.indexOf('|')>=0){
                                                    var tmpCol = tmpParam.displayField.split('|');
                                                    for(var i=0;i<tmpCol.length;i++){
                                                        tmpColumns += "tmpRecord.get('"+tmpCol[i]+"')+' '+";
                                                    }
                                                    tmpColumns  = tmpColumns.substring(0,tmpColumns.length-1);
                                                }else{
                                                    tmpColumns += "tmpRecord.get('"+tmpParam.displayField+"')";
                                                }

                                                Ext.getCmp('txt'+tmpParam.paramName).setValue(eval(tmpColumns));
                                                tmpParam.paramValue =tmpRecord.get(tmpParam.valueField);
                                            }
                                        });
                                        objBusqueda.show();
                                    }
                                }]
                            }]
                        };
                        break;
                }                
            }    
            pnlCriterioReporte.add(comps);            
            pnlCriterioReporte.doLayout();            
            winFrmCriterioReporte.doLayout();                    
        }        
    }

    /**
     *Obtiene la url completa del reporte.
     */
    this.getUrlReport = function(){
        return urlReport;
    }

    /**
     *Obtiene un parametro de la coleccion de parametros visuales de criterio de reporte.
     *@param inParamName Nombre del parametro.
     *@return Parametro.
     */
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
            tmpParam.paramValue = inNewValue.toString('yyyy-MM-dd');
        }
    }

}

/**
 * Agrega parametros a un formulario.
 * @param inParams Coleccion de parametros de criterio del reporte.
 * El parametro debe estar definido de la siguiente manera:
 * {
 *  objectName:Nombre de un objeto que contenga internamente un store y un columnmodel.
 *  label:Titulo del campo,
 *  valueField:Columna del valor a seleccionar,
 *  displayField:Columna del valor a desplegar,
 *  paramName:Nombre del parametro del reporte,
 *  paramValue:Vacio por defecto,
 *  value:valor por defecto,
 *  type:Tipo del control,
 *  required:true/false
 * }
 */
FrmCriterioReporte.prototype.addParams = function(inParams){
    this.addParams(inParams);
}

/**
 * Obtiene la url completa del reporte.
 */
FrmCriterioReporte.prototype.getUrl = function(){
    return this.getUrlReport();
}

/**
 * Muestra el formulario.
 */
FrmCriterioReporte.prototype.show = function(){
    this.getWindow().show();
}

/**
 * Estable una funcion para manejar el cierre del formulario.
 * @parama inFunctionHandler Funcion.
 */
FrmCriterioReporte.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}

/**
 * Establece el titulo del formulario.
 */
FrmCriterioReporte.prototype.setTitle = function(inTitle){
    this.setTitle(inTitle);
}