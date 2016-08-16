package com.bmlaurus.jaspersoft;

import com.bmlaurus.jaspersoft.model.ErrorMessage;
import com.bmlaurus.json.GsonEngine;
import com.bmlaurus.json.GsonEngineImp;
import com.google.gson.JsonSyntaxException;
import com.jaspersoft.jasperserver.rest.BasePublicAPI;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by acanaveral on 12/5/16.
 */
public class BaseAPI extends BasePublicAPI {

    private final String JASPER_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    private GsonEngine gsonEngine;

    public BaseAPI(HttpContext httpContext){
        super(httpContext);
        Map<String,Object> typeAdapters = new HashMap<>();
        gsonEngine = new GsonEngineImp(null, JASPER_DATE_FORMAT);
    }

    public BaseAPI() {
        Map<String,Object> typeAdapters = new HashMap<>();
        gsonEngine = new GsonEngineImp(null, JASPER_DATE_FORMAT);
    }

    public GsonEngine getGsonEngine() {
        return gsonEngine;
    }

    public void setGsonEngine(GsonEngine gsonEngine) {
        this.gsonEngine = gsonEngine;
    }

    public <T> T getEntity(HttpResponse response, Class<T> clazz) throws IOException{
        T jsonObj = null;
        if(response!=null) {
            String obj = EntityUtils.toString(response.getEntity());
            try{
                jsonObj = gsonEngine.getGson().fromJson(obj, clazz);
            } catch (JsonSyntaxException ex){
                log.error(obj);
            }
        }
        return jsonObj;
    }

    public boolean validateRequest(HttpResponse request) {
        boolean valid = true;
        if(request.getStatusLine().getStatusCode() ==  HttpStatus.SC_BAD_REQUEST){
            valid = false;
            ErrorMessage errorMessage = null;
            try {
                errorMessage = getEntity(request, ErrorMessage.class);
                log.error(errorMessage.getErrorCode() + " : " + errorMessage.getMessage() + "\n" + errorMessage.getParameters());
            } catch (IOException e) {
                log.error(e);
            }

        }
        return valid;
    }
}
