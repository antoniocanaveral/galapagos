package com.bmlaurus.fingerprint;

import com.bmlaurus.nbio.api.Device;
import com.bmlaurus.nbio.api.util.Utils;
import netscape.javascript.JSObject;

import java.applet.Applet;
import java.util.List;
import java.util.Map;

/**
 * Created by acanaveral on 18/8/16.
 */
public class Enroll extends Applet{

    @Override
    public void init() {
        super.init();

        Device bpt = new Device();

        //Iniciamos los dispositivos
        if(bpt.initDevice()){
            //Configuramos la ventana de enrolamiento sin Welcome y en primer plano
            bpt.configureEnrollment().hideWelcomeWindow();
            //Ejecutamos enroll
            Map<String,List> enrollementData = bpt.enroll(new Integer(getParameter("UserID")));
            if(enrollementData!=null) {
                String dataToSave = (String) enrollementData.get(Device.DATA_TYPE_TEXT).get(0);
                callbackMethod("storeEnrollment", dataToSave);
                for(byte[] img: (List<byte[]>) enrollementData.get(Device.DATA_TYPE_IMAGE))
                    callbackMethod("storeImage",Utils.getBase64Image(img));

                callbackMethod("showMessage", "Datos Biometricos Capturados");
            }else {
                callbackMethod("showMessage", bpt.getErrorInterceptor().getMessage());
            }
        }
        bpt.closeAndDispose();
    }


    public void callbackMethod(String functionName, String argument) {
        JSObject win = JSObject.getWindow(this);
        win.call(functionName, new Object[] { argument });
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
