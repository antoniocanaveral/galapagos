package com.jaspersoft.jasperserver.rest;

import com.besixplus.sii.util.Env;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by acanaveral on 12/5/16.
 */
public abstract class BasePublicAPI {

    protected Log log;
    protected Properties config;
    private boolean isV2;

    protected HttpRequestBase httpReqCE;
    protected HttpResponse httpRes;

    private HttpClient httpClient;
    private HttpContext httpContext;
    private CookieStore cookieStore;

    public BasePublicAPI() {
        initBaseAPI();
        httpContext = new BasicHttpContext();
        httpContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
    }

    public BasePublicAPI(HttpContext httpContext){
        initBaseAPI();
        this.httpContext = httpContext;
    }

    private void initBaseAPI(){
        PropertyConfigurator.configure(Env.getExternalProperties("loggin/log4j.properties"));
        log = LogFactory.getLog(getClass());
        config = Env.getExternalProperties("jasper/config.properties");
        if(config.getProperty("REST_VERSION").equals("v2"))
            isV2=true;

        httpClient = new DefaultHttpClient();
        cookieStore = new BasicCookieStore();
    }


    public HttpContext getHttpContext() {
        return httpContext;
    }

    public boolean loginToServer() {
        System.out.println("called loginToServer()");
        boolean isLoged = false;
        //building the request parameters
        List<NameValuePair> ce_qparams = new ArrayList<NameValuePair>();
        ce_qparams.add(new BasicNameValuePair(config.getProperty("PARAMETER_USERNAME"), config.getProperty("USER_NAME")));
        ce_qparams.add(new BasicNameValuePair(config.getProperty("PARAM_PASSWORD"), config.getProperty("PASSWORD")));

        try {
            httpReqCE = new HttpPost();
            boolean versionHandler = isV2;
            isV2 = false;
            httpRes = sendRequest(httpReqCE, config.getProperty("SERVICE_LOGIN"), ce_qparams);
            isV2 = versionHandler;
            //consuming the content to close the stream
            IOUtils.toString(httpRes.getEntity().getContent());
            isLoged = true;
        }
        catch (Exception e) {
            log.error(e);
        }
        return isLoged;
    }

    public void logOut(){
        try {
            HttpGet req = new HttpGet();
            req.setURI(createURI(config.getProperty("SERVER_HANDLE")+"/logout.html",null));
            log.info("Login Out");
            //Liberamos porsiacaso
            releaseConnection(httpRes);
            httpRes = httpClient.execute(req, httpContext);
            log.info("response status line: " + httpRes.getStatusLine());

            httpClient = new DefaultHttpClient();
            cookieStore = new BasicCookieStore();
            httpContext = new BasicHttpContext();
            httpContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
        } catch (Exception e) {
            log.error(e);
        }
    }

    public void releaseConnection (HttpResponse res){
        InputStream is = null;
        try {
            is = res.getEntity().getContent();
            is.close();
        } catch (IOException e) {
            log.error(e);
        }
    }

    protected HttpResponse sendRequest(HttpRequestBase req, String service, List<NameValuePair> qparams) throws Exception
    {
        if(!isV2)
            req.setURI(createURI(config.getProperty("BASE_REST_URL")+service, qparams));
        else
            req.setURI(createURI(config.getProperty("BASE_REST_URL_V2")+service, qparams));

        log.info("req method: "+req.getMethod());

        httpRes = httpClient.execute(req, httpContext);
        log.info("response status line: " + httpRes.getStatusLine());
        return httpRes;
    }

    private URI createURI(String path, List<NameValuePair> qparams) throws Exception{
        path = path.replace(" ","%20");
        URI uri;
        if (qparams!=null)
            uri = URIUtils.createURI(config.getProperty("SCHEME"), config.getProperty("HOST"), Integer.valueOf(config.getProperty("PORT")), path, URLEncodedUtils.format(qparams, "UTF-8"), null);
        else
            uri = (new URL(config.getProperty("SCHEME"), config.getProperty("HOST"), Integer.valueOf(config.getProperty("PORT")), path)).toURI();

        log.info("sending Request. url: " +uri.toString());
        return uri;
    }

}
