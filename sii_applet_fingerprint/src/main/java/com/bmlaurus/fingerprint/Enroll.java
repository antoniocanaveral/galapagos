package com.bmlaurus.fingerprint;

import com.bmlaurus.fingerprint.data.FingerData;
import com.bmlaurus.fingerprint.data.FingerDetail;
import com.bmlaurus.nbio.api.Device;
import com.bmlaurus.nbio.api.export.ExportImgHandler;
import com.google.gson.Gson;
import netscape.javascript.JSObject;

import java.applet.Applet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by acanaveral on 18/8/16.
 */
public class Enroll extends Applet{

    @Override
    public void init() {
        super.init();
        int userID = 0;
        String identificationID = null;
        try{
            userID = new Integer(getParameter("userID"));
            identificationID = getParameter("identificationID");
            if(userID==0 || identificationID==null){
                callbackMethod("showMessage", "Los paramtros no han sido definidos");
                return;
            }
        }catch (Exception e){
            callbackMethod("showMessage", "Los paramtros no han sido definidos");
            return;
        }

        Device bpt = new Device();
        //Iniciamos los dispositivos
        if(bpt.initDevice()){
            //Configuramos la ventana de enrolamiento sin Welcome y en primer plano
            bpt.configureEnrollment().hideWelcomeWindow();
            //Ejecutamos enroll
            Map<String,List> enrollementData = bpt.enroll(userID);
            if(enrollementData!=null) {
                FingerData data = new FingerData();
                String dataToSave = (String) enrollementData.get(Device.DATA_TYPE_TEXT).get(0);
                data.setUserId(userID);
                data.setIdentification(identificationID);
                data.setTextData(dataToSave);
                List<FingerDetail> details = new ArrayList<>();
                FingerDetail dataDetail = new FingerDetail();
                for(ExportImgHandler img: (List<ExportImgHandler>) enrollementData.get(Device.DATA_TYPE_AUDIT)){
                    if(img.getSample()==0){//Obtenemos las imagenes del primer sampler.
                        dataDetail.setFingerID(img.getFingerID());
                        dataDetail.setFingerImg(img.getBase64Img());
                        details.add(dataDetail);
                    }
                }
                data.setDetail(details);
                callbackMethod("storeEnrollment", new Gson().toJson(data));
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
