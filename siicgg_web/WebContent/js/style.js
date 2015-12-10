var divCargando;
var RolUsuario;
/*Function que se carga al iniciar el sitio web*/
function loadInit(){
    var txtUsuario = document.getElementById("txtUsuario");
    if (txtUsuario.value!="false"){
        function CallBackRolUsuario(r){
            RolUsuario = r;
        }
        SOAPClient.invoke(URL_WS+"Cgg_gem_vacante", "getRolUsuario", null, false, CallBackRolUsuario);
    }
    divCargando = document.getElementById("divCargando");
    loadFecha();
    loadSeleccionModulo();
    var divLogin = document.getElementById("divLogin");
    var divUsuario = document.getElementById("divUsuario");
    var pnlGestionEmpleo = document.getElementById("pnlGestionEmpleo");
    pnlGestionEmpleo.style.display="none";
    var txtUsuario = document.getElementById("txtUsuario");
    var btnAcceso = document.getElementById("btnAcceso");
    if (txtUsuario.value=="false"){
        btnAcceso.innerHTML="Conectar";
        divLogin.className = "login";
        divUsuario.innerHTML = "Desconectado";
        btnAcceso.onclick=function(){
            window.location="PrivateWS/SessionWeb";
        }
    }else{
        btnAcceso.innerHTML="Desconectar";
        divLogin.style.cssText = "background-color:#E6EFC2;border-color:#C1D573";
        divUsuario.innerHTML = "Bienvenido <b>"+ txtUsuario.value+"</b>";
        btnAcceso.onclick=function(){
            window.location="PrivateWS/SessionWeb?request=logout";
        }
    }
    divCargando.style.visibility="hidden";
}
function loadFecha(){
    var fecha = new Date();
    var days = ['Domingo','Lunes','Martes','Mi&eacute;rcoles','Jueves','Viernes','S&aacute;bado'];
    var months = ['Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'];
    var months_c = ['Ene','Feb','Mar','Abr','May','Jun','Jul','Ago','Sep','Oct','Nov','Dic'];
    var f_day = fecha.getDay();
    var f_date = fecha.getDate();
    var f_month = fecha.getMonth();
    var f_year = fecha.getFullYear();
    document.getElementById("divFecha").innerHTML=days[f_day] +", "+f_date+ " de " + months_c[f_month] + " de " + f_year;
}

function loadSeleccionModulo(){
    var arrDivs=[];
    function moduloOnClick(){
        for (k=0;k<arrDivs.length;k++)arrDivs[k].component.className="noSelect";
        this.className="select";
        divCargando.style.visibility="visible";
        for (k=0;k<arrDivs.length;k++)
            if (arrDivs[k].component.id == this.id){
                setOptionModuloSeleccionado(this.id);
                document.getElementById("iFrameBody").src=arrDivs[k].page;
            }
    }
    arrDivs.push({component:document.getElementById("divInicio"),page:"bienvenida.jsp"});
    arrDivs.push({component:document.getElementById("divGestEmpleo"),page:"gestionEmpleo.jsp"});
    arrDivs.push({component:document.getElementById("divComunRadial"),page:"comunicadoRadial.jsp"});
    arrDivs.push({component:document.getElementById("divResoluciones"),page:"bienvenida.jsp"});
    arrDivs.push({component:document.getElementById("divUsuarios"),page:"usuarios.jsp"});
    arrDivs.push({component:document.getElementById("divTramitesResidencia"),page:""}); //page:" consultaTramite Formulario.jsp"});
    for (k=0; k<arrDivs.length;k++)arrDivs[k].component.onclick=moduloOnClick;
}

function setOptionModuloSeleccionado(idModulo){
    if(idModulo == "divGestEmpleo"){
        pnlGestionEmpleo.style.display="block";
        document.getElementById("btnRegistroEmpresa").onclick=function(){document.getElementById("iFrameBody").src="registroDatosEmpresa.jsp";}
        document.getElementById("loading").style.display="none";
        if (txtUsuario.value!="false"){
            document.getElementById("btnHojaVida").onclick=function(){document.getElementById("iFrameBody").src="hojaVida.jsp";}
            document.getElementById("btnDenunciaSugerencia").onclick=function(){document.getElementById("iFrameBody").src="denunciaSugerencia.jsp";}
            document.getElementById("btnSubscripcionCargos").onclick=function(){document.getElementById("iFrameBody").src="subscripcionCargo.jsp";}
            document.getElementById("btnAplicaciones").onclick=function(){document.getElementById("iFrameBody").src="ofertasByUsuario.jsp";}
            document.getElementById("btnActivarCuenta").onclick=function(){document.getElementById("iFrameBody").src="activarCuentaGestionEmpleo.jsp";}
            document.getElementById("btnBuscarEmpleo").onclick=function(){document.getElementById("iFrameBody").src="gestionEmpleo.jsp";}
            document.getElementById("btnCambiarClave").onclick=function(){document.getElementById("iFrameBody").src="cambiarContrasenia.jsp";}

            if (RolUsuario == "CSROL_GEAPL"){
                document.getElementById("btnBuscarEmpleo").style.display="block";
                document.getElementById("btnHojaVida").style.display="block";
                document.getElementById("btnAplicaciones").style.display="block";
                document.getElementById("btnDenunciaSugerencia").style.display="block";
                document.getElementById("btnSubscripcionCargos").style.display="block";
                document.getElementById("btnCambiarClave").style.display="block";
            }else{
                document.getElementById("btnActivarCuenta").style.display="block";
            }
        }else
            document.getElementById("btnRegistroEmpresa").style.display="block";
        //pnlGestionEmpleo.style.display="none";
    }else{
        pnlGestionEmpleo.style.display="none";
    }
}


function tramitesSubmenuClick()
{
    document.getElementById("btnIngresoTramites").onclick=function(){
        document.getElementById("iFrameBody").src="Formulario.jsp";
        document.getElementById("divTramitesResidencia").className="select";
        divCargando.style.visibility="visible";
        hideMenu();
    }
    document.getElementById("btnConsultaTramites").onclick=function(){
        document.getElementById("iFrameBody").src="consultaTramite.jsp";
        document.getElementById("divTramitesResidencia").className="select";
        divCargando.style.visibility="visible";
        hideMenu();
    }
    document.getElementById("btnRequisitosTramites").onclick=function(){
        document.getElementById("iFrameBody").src="tramiteVehiculo.jsp";
        document.getElementById("divTramitesResidencia").className="select";
        divCargando.style.visibility="visible";
        hideMenu();
    }
}

function showMenu() {
    document.getElementById("subMenuResidencia").style.display="block";
    tramitesSubmenuClick();
}
function hideMenu() {
    document.getElementById("subMenuResidencia").style.display="none";
}



function setHeightForm() {
    parent.document.getElementById('iFrameBody').height = document['body'].offsetHeightForm;
}