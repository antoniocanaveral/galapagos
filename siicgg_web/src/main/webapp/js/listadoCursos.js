function loadListadoCursos(){	
	/*;
	*/
	var con = 1;
	var txtUsuario=$("txtUsuario");
	//alert(txtUsuario.value);
	var codigoCurso = "";
	var tipoCurso = "";
	var nombreCurso = "";
	var tipoResidente = "";
	var cbxTipoCurso = new bsxComboBox({
		id:"cbxTipoCurso",
		width:150,
		renderTo:"tdTipoCurso",		
		displayField:"CDTCR_NOMBRE",
		valueField:"CDTCR_CODIGO",
		webService:{
			url:URL_WS+"PublicWS/Cgg_dhu_tipo_curso",
			method:"selectAll",
			params:[{name:"format",value:"JSON"}]
		},
		events:{
			load:function(){
				grdCurso.setParam(
					"inCdtcr_codigo",cbxTipoCurso.dom.value
				);
				grdCurso.show();
				grdCurso.reload();
			}
		}
	});
	cbxTipoCurso.reload();
	function recorrer(o){
			var a='';
		if(o.constructor==Array)
			a+='[';
		if(o.constructor==Object)
			a+='{';
		for(var i in o){
			if(o.constructor!=Array)
				a+=i+':';
			if(o[i].constructor==Object){
				recorrer(o[i]);
			}else if(o[i].constructor==Array){
				recorrer(o[i]);
			}else if(o[i].constructor==String){
				a+='"'+o[i]+'",';
			}else{
				a+=o[i]+',';
			}
				
		}
		if(o.constructor==Object)
			a+='},';
		if(o.constructor==Array)
			a+='],';
		return a.substr(0,a.length-1).split(',}').join('}').split(',]').join(']');
	}
	function fnPreRegistro(a,b,c){
		showForm($("FrmPreRegistroCurso"));
		fnLlenarDatosPreRegistro(a,b,c);
	}
	function fnLlenarDatosPreRegistro(r,s,t){
		var userObject;	
		var url = URL_WS+"SessionManager?request=userobject";
		new Ajax.Request(url, {
			method: 'get',
			asynchronous : false,
			onSuccess: function(transport) {
				userObject = eval("("+transport.responseText+")");
			},
			onFailure: function(transport) {
				alert(transport);
			}
		});
		var codigoUsuario=userObject.CUSU_CODIGO;
		var codigoPersona = userObject.CRPER_CODIGO;
		var cedulaPersona = userObject.CRPER_NUM_DOC_IDENTIFIC;
		var txtCodigoCurso = r;//r.CDCUR_CODIGO;
		var txtTipoResidente = s;//.CDTCR_TIPO_RESIDENTE;
		var nombreCurso = t;//.CDCUR_DESCRIPCION
		var swPreregistro = true;
		var cursoSelect ="";
	
		
		var FrmListadoCurso = $("FrmListadoCurso");
		var frmPreRegistroCurso = $("frmPreRegistroCurso");
		var btnSalirCurso = $("btnSalirCurso");
		
		
		function CallBackSelectDatos(v){
			//alert(v);		
			return;
			var a = eval('('+v+')');
			if(a.length>0){			
				if (a[0].CODIGO=='04' && txtTipoResidente != 0){
					swPreregistro = false;
					alert('NO se puede inscribir al curso por ser residente temporal');
				}
			}
			
		}
		var param = new SOAPClientParameters();				
		param.add('inCrper_num_doc_identific',cedulaPersona);						
		param.add('format','JSON');		
		SOAPClient.invoke(URL_WS+"Cgg_dhu_asistente_curso","selectAsistenteResidente",param, true, CallBackSelectDatos);
		
		
		var btnBuscar = $("btnBuscar");
		
		
		var cbxSectorProductivo = new bsxComboBox({
			id:"cbxSectorProductivo",
			width:150,
			renderTo:"tdSectorProductivo",		
			displayField:"CSCTP_NOMBRE",
			valueField:"CSCTP_CODIGO",
			webService:{
				url:URL_WS+"Cgg_sector_productivo",
				method:"selectAll",
				params:[{name:"format",value:"JSON"}]
			}		
		});	
		cbxSectorProductivo.reload();
		
		$("tdNombrePersona").innerHTML = userObject.CRPER_NOMBRES + ' ' + userObject.CRPER_APELLIDO_PATERNO + ' ' + userObject.CRPER_APELLIDO_MATERNO
		$("tdCedulaIdentidad").innerHTML = cedulaPersona;//userObject.CRPER_NUM_DOC_IDENTIFIC;
		$("tdCursoPreRegistrar").innerHTML = t;//r.CDCUR_DESCRIPCION;
		//alert(r);
		
		$("btnGuardar").onclick = function(){
			if(swPreregistro == true){
				try{
					function CallBackCgg_dhu_asistente_curso(r){
						//alert(r);
						if(r == "true"){
							alert("La informaci\u00F3n a sido almacenada correctamente");
							frmPreRegistroCurso.reset();						
						}else{
							alert("La informaci\u00F3n no se pudo almacenar");
						}
						document.location = 'listadoCurso.jsp';
					}
					var param = new SOAPClientParameters();
					param.add('inCrper_codigo',codigoPersona);
					param.add('inCdcur_codigo',txtCodigoCurso.value);
					param.add('inCsctp_codigo',cbxSectorProductivo.dom.value);
					param.add('inCusu_codigo',codigoUsuario);
					param.add('inCdasc_actividad_realizada',txtActividad.value);
					param.add('inCdasc_nota_final',null);
					param.add('inCdasc_numero_certificado',null);
					param.add('inCdasc_fecha_emision_certificado',null);
					param.add('inCdasc_estado_inscripcion',0);////
					param.add('inCdasc_aprobado',3);
					SOAPClient.invoke(URL_WS+"Cgg_dhu_asistente_curso",'insert',param, true, CallBackCgg_dhu_asistente_curso);
				}catch(inErr){
					alert(inErr);
				}
			}
		}
		
	}
	$("btnCancelar").onclick = function(){
		btnSalirAll($("FrmPreRegistroCurso"));
	}
	
	var colTable=[	  
		{width:20,renderer:function(){
				return con++;
			}
		},
		{name:'CDCUR_DESCRIPCION',title:'Curso',width:280},  		
		{name:'CDITR_NOMBRE',title:'Instituci\u00F3n',width:130},		
		{name:'CCTN_NOMBRE',title:'Cant\u00f3n',width:80},	
		{name:'CDCUR_FECHA_INICIO',title:'F. Inicio',width:70,
			renderer:function(v){
				return v?v.split(" ")[0]:'No establecida'
			}
		},		
		{width:20,renderer:function(v,r){
				if (r.TMP_INSCRITO>0){
					return "<div class='aplicado' title='Pre-inscrito'></div>";//'Inscrito';
				}else{
				return '';
				}
			}
		},
		{name:'CSCTP_NOMBRE',width:70,renderer:function(v,r){
				r = JSON.stringify(r);
				r=r.replace(/[ ]+/g,'¶');
				var tipoCurso = cbxTipoCurso.dom.options[cbxTipoCurso.dom.selectedIndex].text;
				//return '<a href=detalleCurso.jsp?datos='+r+'&tipoCurso='+tipoCurso+'>Ver mas...</a>';
				return '<div class=divBtnAplicar onclick= document.location=\'detalleCurso.jsp?datos='+r+'&tipoCurso='+tipoCurso+'\'>Detalle</div>'
			}
		},
		/*{width:70,hidden:(txtUsuario.value=="false")?true:false,renderer:function(v,r){				
				var param = new SOAPClientParameters();
				param.add('in_Cdcur_codigo',r.CDCUR_CODIGO);
				var a = SOAPClient.invoke(URL_WS+"PublicWS/Cgg_dhu_curso","numeroInscrito",param, false,null);
				var tmpNumeroAsistente=Math.round(((r.CDCUR_NUMERO_ASISTENTE)-(a)));
				if(tmpNumeroAsistente>0){
					var a = "<div class='divBtnAplicar' id = 'btnRegistrar"+(con-1)+"')>Pre-registrar</div>"; 					
					return a;
				}else{
					return '';
				}
			}
		},*/
		
		{name:'CSCTP_NOMBRE',title:'Sector productivo',width:150,hidden:true},
		{name:'CRPER_INSTRUCTOR',title:'Cordinador',width:150,hidden:true},
		{name:'CDCUR_CODIGO',title:'Codigo',width:150,hidden:true},
		{name:'CDTCR_CODIGO',title:'Codigo',width:150,hidden:true},
		{name:'CDTCR_NOMBRE',title:'Tipo curso',width:150,hidden:true},
		{name:'CCTN_CODIGO',title:'Codigo',width:150,hidden:true},
		{name:'CSCTP_CODIGO',title:'Codigo',width:150,hidden:true},
		{name:'CISLA_CODIGO',title:'Codigo',width:150,hidden:true},
		{name:'CISLA_NOMBRE',title:'Isla',width:150,hidden:true},
		{name:'CDITR_CODIGO',title:'Codigo',width:150,hidden:true},
		{name:'CRPER_CODIGO',title:'Codigo',width:150,hidden:true},
		
		{name:'CDCUR_FECHA_PREVISTA_INICIO',title:'Fecha Inicio',width:150,hidden:true},
		{name:'CDCUR_FECHA_CULMINACION',title:'Fecha culminacion',width:150,hidden:true},
		{name:'CDCUR_FECHA_PREVISTA_CULMINACION',title:'Fecha prevista culminacion',width:150,hidden:true}		  
	  
	];
	

	var grdCurso = new bsxTable({
		id:"grdCurso",
		renderTo:"divGrdListadoCursos",
		width:"700",
		height:"300",
		webService:{
			url:URL_WS+"PublicWS/Cgg_dhu_curso",
			method:"selectCursoInscripcionByTipo",//selectCursoInscripcion",
			reader:{
				totalCountName:"totalCount",
				dataSetName:"dataSet"
			},
			params:[
				{name:"start",value:"0"},
				{name:"limit",value:RECORD_PAGE},
				{name:"sort",value:"CDCUR_CODIGO"},
				{name:"dir",value:"ASC"},
				{name:"keyword",value:""},
				{name:"format",value:"JSON"},
				{name:"inCdtcr_codigo",value:cbxTipoCurso.dom.value}
			]
		},
		columns:colTable,
		pagin:true,	
		search:true,
		events:{
			selectedRow:function(t,ds,i){
				codigoCurso = ds.CDCUR_CODIGO;
				tipoResidente = ds.CDTCR_TIPO_RESIDENTE;				
				nombreCurso = ds.CDCUR_DESCRIPCION;
				//alert(cursoSelect.CDCUR_DESCRIPCION);
			},
			load:function(){
				countCurs = con-1;
				con=1;
				fnCrearEventos(countCurs);
				//alert(countCurs);
				
			}
		}
	});
	function fnCrearEventos(total){
		for(i=1;i<=total;i++){
			var nombreBtn = "btnRegistrar"+i;
			var btnPreIngreso = document.getElementById(nombreBtn);
			btnPreIngreso.onclick = function(){
				alert(codigoCurso);
				return;
				fnPreRegistro(/*cursoSelect);*/codigoCurso,tipoResidente,nombreCurso);
				//alert(cursoSelect.CDCUR_CODIGO);
			}
		}
	}
	cbxTipoCurso.dom.onchange = function(){	
		grdCurso.setParam(
			"inCdtcr_codigo",cbxTipoCurso.dom.value
		);
		con = 1;
		grdCurso.reload();
	}
	function btnSalirAll(frm){
		$("divBgModal").style.display="none";
		frm.style.display="none";			
	}
	function showForm(frm){
		document.getElementById("divBgModal").style.display="block";
		frm.style.display="block";	
	}
	setHeightForm(500);
}
	