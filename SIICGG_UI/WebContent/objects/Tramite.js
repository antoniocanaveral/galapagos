/**
 * Funcion. Establece un objecto para agrupamiento de varios opciones de que se aplican a los tramites.
 * @param inCrtra_codigo Codigo de tramite.
 */
function Tramite(inCrtra_codigo){
    var crtraCodigo = inCrtra_codigo;

    /**
     * Funcion. Verifica si el usuario especificado puede inciar un tramite del tipo de solicitud especificado.
     * @param inCrtst_codigo Codigo de tipo de solicitud de tramite.
     * @param inCusuCodigo Codigo de usuario que desea iniciar el tramite.
     * @return Verdadero / Falso.
     */
    this.iniciaTipoSolicitudTramite = function(inCrtst_codigo,inCusuCodigo){
        var flagInicia = false;
        var scpIniciaTramite = new SOAPClientParameters();
        scpIniciaTramite.add('inCrtst_codigo',inCrtst_codigo);
        scpIniciaTramite.add('inCusu_codigo',inCusuCodigo);
        var tmpIniciaTramite = null;
        try{
            tmpIniciaTramite = SOAPClient.invoke(URL_WS+'Cgg_res_tipo_solicitud_tramite', 'iniciaTipoSolicitudTramite', scpIniciaTramite, false, null);
            if(tmpIniciaTramite == '1'){
                flagInicia = true;
            }
        }catch(inErr){
            flagInicia = false;
        }
        return flagInicia;
    }
}

/**
 * Funcion prototypada. Verifica si el usuario especificado puede inciar un tramite del tipo de solicitud especificado.
 * @param inCrtst_codigo Codigo de tipo de solicitud de tramite.
 * @param inCusuCodigo Codigo de usuario que desea iniciar el tramite.
 * @return Verdadero / Falso.
 */
Tramite.prototype.iniciaTramite = function(inCrtst_codigo,inCusuCodigo){
    return this.iniciaTipoSolicitudTramite(inCrtst_codigo, inCusuCodigo);
}



