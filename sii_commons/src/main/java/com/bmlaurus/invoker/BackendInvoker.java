package com.bmlaurus.invoker;

import com.bmlaurus.invoker.utils.Config;
import org.apache.commons.io.IOUtils;

import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Properties;

/**
 * Created by acanaveral on 13/7/16.
 */
public class BackendInvoker {

    private Properties config = Config.getConfig();

    public String invokeBackendServlet(String servletName, String method, String payload) throws Exception, IOException {
        String result = null;

        URL siiServlet =  null;
        try{
            siiServlet = new URL("https://localhost:8443/siiws/"+servletName);
            if(config!=null){
                if(config.getProperty("SII_URL")!=null)
                    siiServlet = new URL(config.getProperty("SII_URL")+servletName);

                Authenticator.setDefault (new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication (config.getProperty("username"), config.getProperty("password").toCharArray());
                    }
                });
            }
            HttpURLConnection servletConnection = (HttpURLConnection) siiServlet.openConnection();
            servletConnection.setRequestMethod(method); //"POST"
            servletConnection.setDoOutput(true);
            servletConnection.setDoInput(true);
            servletConnection.setRequestProperty("Content-Type", "application/json");
            servletConnection.setRequestProperty("Accept", "application/json");

            OutputStreamWriter objOut = new OutputStreamWriter(servletConnection.getOutputStream());
            objOut.write(payload);
            objOut.flush();
            objOut.close();

            InputStream response = servletConnection.getInputStream();

            result = IOUtils.toString(response, "UTF-8");

        }catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }

    static {
        disableSslVerification();
    }

    private static void disableSslVerification() {
        try
        {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }
            };

            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };

            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }


}
