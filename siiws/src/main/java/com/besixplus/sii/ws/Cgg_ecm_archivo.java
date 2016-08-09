package com.besixplus.sii.ws;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;
import com.google.gson.Gson;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPFaultException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by acanaveral on 8/8/16.
 */
/**
 * CLASE Cgg_ecm_archivo
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_ecm_archivo POR MEDIO DE SERVICIOS WEB.
 *
 * @author BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style= SOAPBinding.Style.RPC)
public class Cgg_ecm_archivo implements Serializable {

    private static final long serialVersionUID = 1561615879;
    private Messages myInfoMessages = new Messages(Messages.Types.Info);
    @Resource
    WebServiceContext wctx;

    /**
     * INSERTA UN REGISTRO EN LA TABLA Cgg_ecm_archivo.
     * @param in_objEcmch OBJETO JSON QUE REPRESENTA UN Cgg_ecm_archivo
     * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
     * @throws SOAPException
     */
    @WebMethod
    public String insert(
            @WebParam(name="in_objEcmch")String in_objEcmch
    ) throws SOAPException{
        String res = "true";
        HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
        com.besixplus.sii.objects.Cgg_ecm_archivo obj = new com.besixplus.sii.objects.Cgg_ecm_archivo();

        obj = new Gson().fromJson(in_objEcmch, com.besixplus.sii.objects.Cgg_ecm_archivo.class);
        obj.setECMCH_CODIGO("KEYGEN");
        obj.setECMCH_ESTADO(true);
        obj.setECMCH_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
        obj.setECMCH_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

        try{
            Connection con = ManagerConnection.getConnection();
            if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
                con.close();
                throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
            }
            res = new com.bmlaurus.db.Cgg_ecm_archivo(obj).save(con);
            con.close();
            if(!res.equals("true"))
                throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
        }catch(SQLException inException){
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
            throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
        }
        return res;
    }

    /**
     * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_ecm_archivo EN UNA ESTRUCTRA JSON o XML.
     * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
     * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
     */
    @WebMethod
    public String selectAll(
            @WebParam(name="format")String format
    ){
        HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
        HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
        List<com.besixplus.sii.objects.Cgg_ecm_archivo> obj = null;
        StringBuilder outCadena = null;
        com.besixplus.sii.misc.Formatter tmpFormat = null;
        try{
            Connection con = ManagerConnection.getConnection();
            if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
                con.close();
                tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
                return null;
            }
            con.setAutoCommit(!ManagerConnection.isDeployed());
            obj = com.bmlaurus.db.Cgg_ecm_archivo.selectAll(con, tmpRequest.getUserPrincipal().getName());
            tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
            outCadena = tmpFormat.getData();
            con.close();
        }catch(SQLException inException){
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
            try {
                tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return inException.getMessage();
        }catch (Exception inException){
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
            try {
                tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return inException.getMessage();
        }
        if (obj != null)
            return outCadena.toString();
        return null;
    }

    /**
     * OBTIENE LOS REGISTROS DE LA TABLA Cgg_ecm_archivo EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
     * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
     * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
     * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
     * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
     * @param keyword CRITERIO DE BUSQUEDA.
     * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
     * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
     */
    @WebMethod
    public String selectPage(
            @WebParam(name="start")int start,
            @WebParam(name="limit")int limit,
            @WebParam(name="sort")String sort,
            @WebParam(name="dir")String dir,
            @WebParam(name="keyword")String keyword,
            @WebParam(name="format")String format
    ){
        HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
        HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
        ArrayList<com.besixplus.sii.objects.Cgg_ecm_archivo> obj = null;
        StringBuilder outCadena = null;
        com.besixplus.sii.misc.Formatter tmpFormat = null;
        int tmpCount = 0;
        try{
            Connection con = ManagerConnection.getConnection();
            if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
                con.close();
                tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
                return null;
            }
            tmpCount = com.bmlaurus.db.Cgg_ecm_archivo.selectCount(con, keyword);
            con.setAutoCommit(!ManagerConnection.isDeployed());
            obj = com.bmlaurus.db.Cgg_ecm_archivo.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
            tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
            outCadena = tmpFormat.getData();
            con.close();
        }catch(SQLException inException){
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
            try {
                tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return inException.getMessage();
        }catch (Exception inException){
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
            try {
                tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return inException.getMessage();
        }
        if (obj != null)
            if( format.toUpperCase().equals("JSON"))
                return "{\"totalCount\":\""+tmpCount+"\",\"dataSet\":"+outCadena.toString()+"}";
            else
                return outCadena.insert(outCadena.indexOf("<dataSet>")+9,"<totalCount>"+tmpCount+"</totalCount>").toString();
        return null;
    }

    /**
     * OBTIENE LOS REGISTROS DE LA TABLA Cgg_ecm_archivo EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
     * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
     * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
     * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
     * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
     * @param keyword CRITERIO DE BUSQUEDA.
     * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
     * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
     */
    @WebMethod
    public String selectPageDirect(
            @WebParam(name="start")int start,
            @WebParam(name="limit")int limit,
            @WebParam(name="sort")String sort,
            @WebParam(name="dir")String dir,
            @WebParam(name="keyword")String keyword,
            @WebParam(name="format")String format
    ){
        HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
        HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
        ArrayList<HashMap<String,Object>> obj = null;
        StringBuilder outCadena = null;
        com.besixplus.sii.misc.Formatter tmpFormat = null;
        int tmpCount = 0;
        try{
            Connection con = ManagerConnection.getConnection();
            if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
                con.close();
                tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
                return null;
            }
            tmpCount = com.bmlaurus.db.Cgg_ecm_archivo.selectCount(con, keyword);
            con.setAutoCommit(!ManagerConnection.isDeployed());
            obj = com.bmlaurus.db.Cgg_ecm_archivo.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
            tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
            outCadena = tmpFormat.getData();
            con.close();
        }catch(SQLException inException){
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
            try {
                tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return inException.getMessage();
        }catch (Exception inException){
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
            try {
                tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return inException.getMessage();
        }
        if (obj != null)
            if( format.toUpperCase().equals("JSON"))
                return "{\"totalCount\":\""+tmpCount+"\",\"dataSet\":"+outCadena.toString()+"}";
            else
                return outCadena.insert(outCadena.indexOf("<dataSet>")+9,"<totalCount>"+tmpCount+"</totalCount>").toString();
        return null;
    }


    /**
     * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_ecm_archivo.
     * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
     * @throws SOAPException
     */
    @WebMethod
    public String update(
            @WebParam(name="in_objEcmch")String in_objEcmch
    ) throws SOAPException{
        String res = "true";
        HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
        com.besixplus.sii.objects.Cgg_ecm_archivo obj = new com.besixplus.sii.objects.Cgg_ecm_archivo();

        obj = new Gson().fromJson(in_objEcmch, com.besixplus.sii.objects.Cgg_ecm_archivo.class);
        obj.setECMCH_ESTADO(true);
        obj.setECMCH_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

        try{
            Connection con = ManagerConnection.getConnection();
            if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
                con.close();
                throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
            }
            res = new com.bmlaurus.db.Cgg_ecm_archivo(obj).save(con);
            con.close();
            if(!res.equals("true"))
                throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
        }catch(SQLException inException){
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
            throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
        }
        return res;
    }


    /**
     * SELECCIONA UN REGISTRO EN LA TABLA Cgg_ecm_archivo EN UN A ESTRUCTURA JSON o XML.
     * @param inEcmch_codigo Ecmch_codigo
     * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
     * @return String REGISTRO SELECCIONADO.
     */
    @WebMethod
    public String select(
            @WebParam(name="inEcmch_codigo")String inEcmch_codigo,
            @WebParam(name="format")String format
    ){
        com.besixplus.sii.misc.Formatter tmpFormat = null;
        HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
        HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
        com.besixplus.sii.objects.Cgg_ecm_archivo tmpObj = new com.besixplus.sii.objects.Cgg_ecm_archivo();
        tmpObj.setECMCH_CODIGO(inEcmch_codigo);
        try{
            Connection con = ManagerConnection.getConnection();
            if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
                con.close();
                tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
                return null;
            }
            con.setAutoCommit(!ManagerConnection.isDeployed());
            tmpObj = new com.bmlaurus.db.Cgg_ecm_archivo(tmpObj).select(con);
            ArrayList<com.besixplus.sii.objects.Cgg_ecm_archivo> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_ecm_archivo>();
            tmpArray.add(tmpObj);
            tmpFormat = new com.besixplus.sii.misc.Formatter(format, tmpArray);
            con.close();
        }catch(SQLException inException){
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
            try {
                tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return inException.getMessage();
        }catch (Exception inException){
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
            try {
                tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return inException.getMessage();
        }
        if (tmpObj != null)
            return tmpFormat.getData().toString();
        return null;
    }


    /**
     * ELIMINA UN REGISTRO EN LA TABLA Cgg_ecm_archivo.
     * @param inEcmch_codigo IDENTIFICADOR UNICO DE REGISTRO DE COLOR
     * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
     */
    @WebMethod
    public String delete(
            @WebParam(name="inEcmch_codigo")String inEcmch_codigo
    ){
        boolean outResult = true;
        HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
        HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
        com.besixplus.sii.objects.Cgg_ecm_archivo tmpObj = new com.besixplus.sii.objects.Cgg_ecm_archivo();
        tmpObj.setECMCH_CODIGO(inEcmch_codigo);
        try{
            Connection con = ManagerConnection.getConnection();
            if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
                con.close();
                tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
                return null;
            }
            outResult = new com.bmlaurus.db.Cgg_ecm_archivo(tmpObj).delete(con);
            con.close();
        }catch(SQLException inException){
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
            try {
                tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return inException.getMessage();
        }catch (Exception inException){
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
            try {
                tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return inException.getMessage();
        }
        return new Boolean(outResult).toString();
    }

}