package com.besixplus.sii.util;

import com.bmlaurus.exception.EnvironmentVariableNotDefinedException;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by acanaveral on 28/4/16.
 */
public class Env {

    public static final String SII_HOME = "SII_HOME";

    public static String getHomePath() throws EnvironmentVariableNotDefinedException {
        String SIIHome = System.getProperty("sii.home");

        if (SIIHome == null || SIIHome.length() <= 0) {
            throw new EnvironmentVariableNotDefinedException(Env.SII_HOME);
        }

        return SIIHome;
    }

    public static FileInputStream getExternalResource(String resourcePath) throws FileNotFoundException, EnvironmentVariableNotDefinedException {
        File searchFile = new File(getHomePath()+File.separator+resourcePath);
        if(searchFile.exists()){
            return new FileInputStream(searchFile);
        }else
            return null;
    }

    public static Properties getExternalProperties(String resourcePath){
        Properties props = null;
        try{
            FileInputStream fis = getExternalResource(resourcePath);
            props = new Properties();
            props.load(fis);
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            props = null;
        } catch (EnvironmentVariableNotDefinedException e) {
            e.printStackTrace();
        }

        return props;
    }

    public static URL[] getRuleClassPath() throws EnvironmentVariableNotDefinedException, MalformedURLException {
        List<URL> ruleFiles = new ArrayList<>();
        File dir = new File(getHomePath()+File.separator+"rules");
        if(dir.isDirectory()){
            for(File item:dir.listFiles()){
                if(item.isFile()){
                    ruleFiles.add(item.toURI().toURL());
                }
            }
        }
        URL[] urls = null;
        if(ruleFiles.size()>0) {
            urls = new URL[ruleFiles.size()];
            urls = ruleFiles.toArray(urls);
        }
        return urls;
    }

    public static String loadExternalScripts(String resourcePath){
        StringBuffer script = new StringBuffer();
        Properties lister = getExternalProperties(resourcePath);
        if(lister!=null){
            String scripts_to_load = lister.getProperty("index_javascript");
            String [] loader;
            if(scripts_to_load.contains(",")){
                loader = scripts_to_load.split(",");
            }else{
                loader = new String[]{scripts_to_load};
            }
            script.append("<script type=\"text/javascript\">\n");
            for(String file:loader){
                try {
                    FileInputStream resource = getExternalResource(file);

                    BufferedReader tmpBR = new BufferedReader(new InputStreamReader(resource));
                    String tmpLine = null;
                    while ((tmpLine = tmpBR.readLine()) != null) {
                        script.append(tmpLine+"\n");
                    }
                    tmpBR.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (EnvironmentVariableNotDefinedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            script.append("</script>");
        }
        return script.toString();
    }
}
