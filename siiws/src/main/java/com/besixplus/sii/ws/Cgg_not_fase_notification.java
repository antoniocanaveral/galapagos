package com.besixplus.sii.ws;

import com.besixplus.sii.db.ManagerConnection;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by acanaveral on 4/7/16.
 */
@WebService()
@SOAPBinding(style= SOAPBinding.Style.RPC)
public class Cgg_not_fase_notification implements Serializable {

    @Resource
    WebServiceContext wctx;

    /**
     * DESPLIEGA LOS MENSAJES DE UNA FASE
     * @param inCrfas_codigo IDENTIFICATIVO DE LA FASE
     * @return String REGISTRO SELECCIONADO.
     */
    @WebMethod
    public String selectByFase(
            @WebParam(name="inCrfas_codigo")String inCrfas_codigo
    ){
        com.besixplus.sii.misc.Formatter tmpFormat = null;
        HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
        HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
        com.besixplus.sii.objects.Cgg_not_fase_notificacion tmpObj = new com.besixplus.sii.objects.Cgg_not_fase_notificacion();
        tmpObj.setCrfas_codigo(inCrfas_codigo);
        tmpObj.setNtfn_usuario_insert(tmpRequest.getUserPrincipal().getName());
        tmpObj.setNtfn_usuario_update(tmpRequest.getUserPrincipal().getName());
        try{
            Connection con = ManagerConnection.getConnection();
            if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
                con.close();
                tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
                return null;
            }
            con.setAutoCommit(!ManagerConnection.isDeployed());
            ArrayList<com.besixplus.sii.objects.Cgg_not_fase_notificacion> tmpArray = new com.besixplus.sii.db.Cgg_not_fase_notificacion(tmpObj).selectByFase(con);
            tmpFormat = new com.besixplus.sii.misc.Formatter("JSON", tmpArray);
            con.close();
        }catch(SQLException inException){
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
            return inException.getMessage();
        }catch (Exception inException){
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
            return inException.getMessage();
        }
        if (tmpObj != null)
            return tmpFormat.getData().toString().toUpperCase();
        return null;
    }

    /**
     * ELIMINA UN REGISTRO EN LA TABLA Cgg_not_fase_notificacion.
     * @param inCrpro_codigo PROCESO
     * @param inCrfas_codigo FASE
     * @param inNtml_codigo MENSAJE
     * @param inNtfn_destinatario DESTINATARIO
     * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
     */
    @WebMethod
    public String deleteTrusted(
            @WebParam(name="inCrpro_codigo")String inCrpro_codigo,
            @WebParam(name="inCrfas_codigo")String inCrfas_codigo,
            @WebParam(name="inNtml_codigo")String inNtml_codigo,
            @WebParam(name="inNtfn_destinatario")String inNtfn_destinatario
    ){
        boolean outResult = true;
        HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
        HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
        com.besixplus.sii.objects.Cgg_not_fase_notificacion tmpObj = new com.besixplus.sii.objects.Cgg_not_fase_notificacion();
        tmpObj.setCrpro_codigo(inCrpro_codigo);
        tmpObj.setCrfas_codigo(inCrfas_codigo);
        tmpObj.setNtml_codigo(inNtml_codigo);
        tmpObj.setNtfn_destinatario(inNtfn_destinatario);
        try{
            Connection con = ManagerConnection.getConnection();
            if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
                con.close();
                tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
                return null;
            }
            outResult = new com.besixplus.sii.db.Cgg_not_fase_notificacion(tmpObj).deleteTrusted(con);
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
