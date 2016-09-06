package com.besixplus.sii.ws;

import com.bmlaurus.db.MasBuscadosData;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by acanaveral on 1/9/16.
 */
@WebService()
@SOAPBinding(style= SOAPBinding.Style.RPC)
public class MasBuscados implements Serializable {

    @WebMethod
    public String consultarMB(
        @WebParam(name="inIdentificacion")String identificacion
    ){
        String result = "false";
        Connection connection = com.besixplus.sii.db.ManagerConnection.getConnection();
        try {
            if(MasBuscadosData.exists(connection,identificacion))
                result = "true";
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
