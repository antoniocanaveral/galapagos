package com.bmlaurus.jaspersoft.services;

import com.bmlaurus.jaspersoft.BaseAPI;
import com.bmlaurus.jaspersoft.model.Role;
import com.bmlaurus.jaspersoft.model.User;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;

import java.util.List;

/**
 * Created by acanaveral on 13/5/16.
 */
public class UserService extends BaseAPI {

    private final String USERS_URI = "/users";

    public void verifyUser(){
        try {
            HttpGet get = new HttpGet();
            get.setHeader("Content_Type","application/json");
            get.setHeader("Accept", "application/json");

            httpRes = sendRequest(get, USERS_URI+"/"+config.getProperty("SII_NAME"),null);
            if(validateRequest(httpRes)) {
                if (httpRes.getStatusLine().getStatusCode() == HttpStatus.SC_NOT_FOUND) {
                    releaseConnection(httpRes);
                    createUser();
                } else {
                    User exinting = getEntity(httpRes, User.class);
                    log.info("User exists: " + exinting.toString());
                    releaseConnection(httpRes);
                }
            }

        }catch (Exception e){
            log.error(e);
        }
    }

    private void createUser(){
        User user = null;
        try {
            user =  new User(config.getProperty("SII_FULL_NAME"),config.getProperty("SII_NAME"),config.getProperty("SII_PASSW"));
            user.setEnabled(true);
            user.setEmailAddress(config.getProperty("SII_EMAIL"));
            if(config.getProperty("SII_ROLES")!=null){
                List<Role> roles = getGsonEngine().getGson().fromJson(config.getProperty("SII_ROLES"), List.class);
                user.setRoles(roles);
            }

            HttpPut putUser = new HttpPut();
            putUser.setHeader(User.HDR_CONTENT_TYPE, user.getConten_type());
            putUser.setHeader("Accept", "application/json");

            putUser.setEntity(new StringEntity(getGsonEngine().getGson().toJson(user)));

            httpRes = sendRequest(putUser, USERS_URI+"/"+config.getProperty("SII_NAME"),null);
            if(validateRequest(httpRes)) {
                if (httpRes.getStatusLine().getStatusCode() == HttpStatus.SC_CREATED
                        || httpRes.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    User created = getEntity(httpRes, User.class);
                    log.info("User created: " + created.toString());
                } else
                    log.error(httpRes.getStatusLine().getReasonPhrase());
            }
        }catch (Exception e){
            log.error(e);
        }finally {
            releaseConnection(httpRes);
        }
    }
}
