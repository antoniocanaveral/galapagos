
function loadPreguntasFrecuentes(){	
	//var codigoModulo = 'CWMOD1';
	var btnEnviar = $("btnEnviar");
	var txtPregunta = $("txtPregunta");
	var cont = 1;
	//var tbodyPregunta = tblPregunta.tBodies[0];
	btnEnviar.onclick = function(){
		function CallBackCgg_web_ingreso_pregunta(r){			
			if(r=="true"){
				grdPreguntas.reload();
				/*var fila =tbodyPregunta.insertRow(-1);
				var celda= fila.insertCell(-1);				
				cont++;
				celda.innerHTML = txtPregunta.value;*/
			}
		}	
		var param = new SOAPClientParameters();
		param.add('inCwmod_codigo',$("txtCodigoModulo").value);
		param.add('inCwprg_pregunta',txtPregunta.value);
		param.add('inCwprg_respuesta','');
		param.add('inCwprg_observacion','');
		param.add('inCwprg_prioridad',1);		
		SOAPClient.invoke(URL_WS+"PublicWS/Cgg_web_preguntas","insert",param, true, CallBackCgg_web_ingreso_pregunta);
	}
	
	
	var colTablePregunta=[		
		{name:'CWPRG_PREGUNTA',width:"100%",
			renderer:function(v,r){
				tmpFecha = new Date(r.CWPRG_FECHA_INSERT);
				var months_c = ['Ene','Feb','Mar','Abr','May','Jun','Jul','Ago','Sep','Oct','Nov','Dic'];
				var f_day = tmpFecha.getDate();
				var f_month = tmpFecha.getMonth();
				var f_year = tmpFecha.getFullYear();
				var f_hora = tmpFecha.getHours();
				var f_minuto = tmpFecha.getMinutes();
				return '<table> <tr><td style="border-bottom:0px"><table style="width:120px;font-size:11"><tr><td style="border-bottom:0 solid #cccccc;">'+f_day+' '+ months_c[f_month]+', '+f_year+' '+f_hora+':'+f_minuto+'</td></tr><tr></tr></table></td>'+
				'<td valign="top" style="border-bottom:0px"><div class="clsPregunta"><b>'+v+'</b></div><div class="clsRespuesta">'+ r.CWPRG_RESPUESTA +'</div></td></tr></table>';				
			}
		}		
		
	];

	var grdPreguntas = new bsxTable({
		id:"grdPreguntas",
		renderTo:"divListadoPreguntas",
		width:"100%",
		height:"450",
		webService:{
			url:URL_WS+"PublicWS/Cgg_web_preguntas",
			method:"selectPageDirectByModulo",
			reader:{
				totalCountName:"totalCount",
				dataSetName:"dataSet"
			},
			params:[
				{name:"start",value:0},
				{name:"limit",value:RECORD_PAGE},
				{name:"sort",value:"CWPRG_FECHA_INSERT"},
				{name:"dir",value:"desc"},
				{name:"keyword",value:""},
				{name:"format",value:"JSON"},		
				{name:"inCwmod_codigo",value:$("txtCodigoModulo").value}
			]
		},
		columns:colTablePregunta,
		pagin:true,	
		events:{
			load:function(){
				setHeightForm();
			}
		}
	});
	grdPreguntas.show();
	grdPreguntas.reload();
	setHeightForm();
	
}
	