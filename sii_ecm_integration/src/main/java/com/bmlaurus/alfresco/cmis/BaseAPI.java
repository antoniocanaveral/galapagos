package com.bmlaurus.alfresco.cmis;

import com.bmlaurus.virtual.VirtualCache;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson.JacksonFactory;
import org.apache.chemistry.opencmis.client.api.Repository;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.api.SessionFactory;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.enums.BindingType;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by acanaveral on 28/4/16.
 */
public class BaseAPI extends BasePublicAPI {
    /**
     * Change these to match your environment
     */
    //public static final String CMIS_URL = "/public/cmis/versions/1.0/atom";
    public static final String CMIS_URL = "/public/cmis/versions/1.1/atom";

    public static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    public static final JsonFactory JSON_FACTORY = new JacksonFactory();

    private HttpRequestFactory requestFactory;

    public String getAtomPubURL(HttpRequestFactory requestFactory) {
        String alfrescoAPIUrl = getAlfrescoAPIUrl();
        String atomPubURL = null;

        try {
            atomPubURL = alfrescoAPIUrl + getHomeNetwork() + CMIS_URL;
        } catch (IOException ioe) {
            System.out.println("Warning: Couldn't determine home network, defaulting to -default-");
            atomPubURL = alfrescoAPIUrl + "-default-" + CMIS_URL;
        }

        return atomPubURL;
    }

    /**
     * Gets a CMIS Session by connecting to the local Alfresco server.
     *
     * @return Session
     */
    public Session getCmisSession() {
        if (PublicConnection.cmisSession == null) {
            // default factory implementation
            SessionFactory factory = SessionFactoryImpl.newInstance();
            Map<String, String> parameter = new HashMap<String, String>();

            // connection settings
            parameter.put(SessionParameter.ATOMPUB_URL, getAtomPubURL(getRequestFactory()));
            parameter.put(SessionParameter.BINDING_TYPE, BindingType.ATOMPUB.value());
            parameter.put(SessionParameter.AUTH_HTTP_BASIC, "true");
            parameter.put(SessionParameter.USER, getUsername());
            parameter.put(SessionParameter.PASSWORD, getPassword());
            //parameter.put(SessionParameter.OBJECT_FACTORY_CLASS, "org.alfresco.cmis.client.impl.AlfrescoObjectFactoryImpl");

            List<Repository> repositories = factory.getRepositories(parameter);

            PublicConnection.cmisSession = repositories.get(0).createSession();
            System.out.println("----- [Building Alfresco Session] -----");
        }
        return PublicConnection.cmisSession;
    }

    public void disconnect(){
        //PublicConnection.cmisSession.clear();
        System.out.println("----- [Alfresco Session] Cleared! -----");
    }

    /**
     * Uses basic authentication to create an HTTP request factory.
     *
     * @return HttpRequestFactory
     */
    public HttpRequestFactory getRequestFactory() {
        if (this.requestFactory == null) {
            this.requestFactory = HTTP_TRANSPORT.createRequestFactory(new HttpRequestInitializer() {

                public void initialize(HttpRequest request) throws IOException {
                    request.setParser(new JsonObjectParser(new JacksonFactory()));
                    request.getHeaders().setBasicAuthentication(getUsername(), getPassword());
                }
            });
        }
        return this.requestFactory;
    }

    public String getAlfrescoAPIUrl() {
        String host = VirtualCache.getConfig(VirtualCache.PROP_ALFRESCO_CONF).getProperty("host");
        return host + "/api/";
    }

    public String getUsername() {
        return VirtualCache.getConfig(VirtualCache.PROP_ALFRESCO_CONF).getProperty("username");
    }

    public String getPassword() {
        return VirtualCache.getConfig(VirtualCache.PROP_ALFRESCO_CONF).getProperty("password");
    }

    public String getDefaultDescription(){return VirtualCache.getConfig(VirtualCache.PROP_ALFRESCO_CONF).getProperty("folder_description");}
}
