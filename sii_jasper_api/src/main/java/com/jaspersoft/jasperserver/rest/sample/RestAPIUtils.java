package com.jaspersoft.jasperserver.rest.sample;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.junit.Assert;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.jaspersoft.jasperserver.rest.sample.Consts.*;

public class RestAPIUtils {
		
	private HttpClient httpClient;
	private	CookieStore cookieStore;
	private HttpContext httpContext;
		
	protected HttpRequestBase httpReqCE;
	
	protected HttpRequestBase tempHttpReq;
	protected HttpResponse httpRes;
	
	private final Log log = LogFactory.getLog(getClass());
	
	protected void putSampleFolder() throws Exception{
    	tempHttpReq = new HttpPut();
    	sendAndAssert(tempHttpReq, RESOURCE+"/JUNIT_NEW_FOLDER", RESOURCES_LOCAL_PATH + SAMPLE_FOLDER_RD, HttpStatus.SC_CREATED);
    }
	
	protected void deleteSampleFolder() throws Exception{
    	tempHttpReq = new HttpDelete();
    	sendAndAssert(tempHttpReq, RESOURCE+"/JUNIT_NEW_FOLDER", RESOURCES_LOCAL_PATH + SAMPLE_FOLDER_RD, HttpStatus.SC_CREATED);
    }
	
	public RestAPIUtils(){
		httpClient = new DefaultHttpClient();
    	cookieStore = new BasicCookieStore();
    	httpContext = new BasicHttpContext();
    	httpContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
	}
	
	public void tearDown() throws Exception{
    	//releasing the related streams
    	if (httpRes.getEntity().getContent().available()!=0){
    		httpRes.getEntity().getContent();
    	}
    	httpClient.getConnectionManager().closeExpiredConnections();
	}
	
	public void loginToServer() {
		System.out.println("called loginToServer()");
    	//building the request parameters
    	List<NameValuePair> ce_qparams = new ArrayList<NameValuePair>();
    	ce_qparams.add(new BasicNameValuePair(PARAMETER_USERNAME, USER_NAME));
    	ce_qparams.add(new BasicNameValuePair(PARAM_PASSWORD, PASSWORD));
    	
    	try {
    		httpReqCE = new HttpPost();
    		httpRes = sendRequest(httpReqCE, SERVICE_LOGIN, ce_qparams, false);
			
    		//consuming the content to close the stream
			IOUtils.toString(httpRes.getEntity().getContent());
    	}
    	catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* SERVICE FUNCTION */	
    protected HttpResponse sendAndAssert(HttpRequestBase req, String service, String rdPath, int expectedStatus) throws Exception{
    	//building the body
		BasicHttpEntity reqEntity = new BasicHttpEntity();
		
		//appending the file descriptor from a file 
		reqEntity.setContent(new FileInputStream(rdPath));
		
		((HttpEntityEnclosingRequestBase)req).setEntity(reqEntity);
		
		
		//executing the request
		return sendAndAssert(req, service, expectedStatus);
		
	}
    
    protected HttpResponse sendAndAssert(HttpRequestBase req, String service, int expectedStatus) throws Exception{
    	httpRes = sendRequest(req, service, null, false);
    	Assert.assertTrue("basic response check did not pass", isValidResposnse(expectedStatus));
    	return httpRes;
    }
    
    // send a request to the CE server
	protected HttpResponse sendRequest(HttpRequestBase req, String service, List<NameValuePair> qparams,
			boolean isV2) throws Exception
    {
    	if(!isV2)
    		req.setURI(createURI(BASE_REST_URL+service, qparams));
    	else 
    		req.setURI(createURI(BASE_REST_URL_V2+service, qparams));
    		
    	log.info("req method: "+req.getMethod());
    	
    	httpRes = httpClient.execute(req, httpContext);
    	log.info("response status line: "+httpRes.getStatusLine());
    	return httpRes;
    }
		        
    private URI createURI(String path, List<NameValuePair> qparams) throws Exception{
    	URI uri;
    	if (qparams!=null)
	    	uri = URIUtils.createURI(SCHEME, HOST, PORT, path, URLEncodedUtils.format(qparams, "UTF-8"), null);
	    else
	    	uri = (new URL(SCHEME, HOST, PORT, path)).toURI(); 
    	
    	log.info("sending Request. url: " +uri.toString());
	    return uri;
    }
    
    protected boolean isValidResposnse() throws Exception{
    	return isValidResposnse(HttpStatus.SC_OK);
    }
    
    protected boolean isValidResposnse(int expected_respose_code) throws Exception{
    	return 	httpRes.getStatusLine().getStatusCode()==expected_respose_code;
    }
    
    protected boolean isValidResposnse(HttpResponse res, int expected_respose_code) throws Exception{
    	return 	httpRes.getStatusLine().getStatusCode()==expected_respose_code;
    }
    
    public void releaseConnection (HttpResponse res) throws Exception{
    	InputStream is = res.getEntity().getContent();
    	is.close();
    }
}
