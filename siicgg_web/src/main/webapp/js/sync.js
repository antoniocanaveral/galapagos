/*Function que se carga al iniciar el sitio web*/
function loadSync(){

    loadFecha();    

    /**
 * Manejador de evento click boton btnRequirimiento.
 */
    $('btnRequerimiento').observe('click',function(inEvent){

        $('divRequerimiento').removeClassName('testIcon');
        $('divRequerimiento').addClassName('cargandoIcon');

        $('txtLog').value = "Evaluando requerimientos necesarios.\n";
        $('txtLog').value += "  Cache para trabajo fuera de linea.\n";

        if(Modernizr.applicationcache == true){
            $('txtLog').value += "      Se acepta cache para el navegador web.\n";
        }else{
            $('txtLog').value += "      No acepta cache para el navegador web.\n";
        }

        $('txtLog').value += "  Repositorio para el navegador.\n";
        if(Modernizr.websqldatabase == true){
            $('txtLog').value += "      Se acepta repositorio para el navegador web.\n";
        }else{
            $('txtLog').value += "      No acepta repositorio para el navegador web.\n";
        }

        if(Modernizr.applicationcache == true && Modernizr.websqldatabase == true){
            $('divRequerimiento').removeClassName('cargandoIcon');
            $('divRequerimiento').addClassName('okIcon');
            $('btnRecurso').disabled = false;
            $('btnRecurso').fire('click',null);
        }else{
            $('divRequerimiento').removeClassName('cargandoIcon');
            $('divRequerimiento').addClassName('noValidIcon');
            $('btnRecurso').disabled = false;
        }
    });

    $('btnRecurso').observe('click',function(inEvent){
        //TEST DE CACHE
        $('divRecurso').removeClassName('testIcon');
        $('divRecurso').addClassName('cargandoIcon');

        $('txtLog').value += "\nVerificando cache de recursos previos y nuevos.\n";
        $('txtLog').value += "  Actualizando cache de recursos.\n";
        var appCache = window.applicationCache;

        if(appCache.status ==1){
            $('divRecurso').removeClassName('cargandoIcon');
            $('divRecurso').addClassName('okIcon');
            $('txtLog').value += "  Recursos descargados y actualizados.\n";
        }else if(appCache.status == 0){
            $('divRecurso').removeClassName('cargandoIcon');
            $('divRecurso').addClassName('noValidIcon');
            $('txtLog').value += "  No se puedo descargar los recursos.\n";
        }       
    });

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

function expresionUrlImage(v){
    var spanId = document.getElementById("iconUser");
    //return "url(image/"+spanId.id+".png)";
    /*alert("");*/
    return "url(image/cgg.png)";
}
