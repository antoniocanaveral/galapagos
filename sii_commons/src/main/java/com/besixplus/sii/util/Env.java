package com.besixplus.sii.util;

import com.bmlaurus.exception.EnvironmentVariableNotDefinedException;
import org.apache.commons.io.IOUtils;

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

    private static FileInputStream getExternalResource(String resourcePath) throws FileNotFoundException, EnvironmentVariableNotDefinedException {
        File searchFile = new File(getHomePath()+File.separator+resourcePath);
        if(searchFile.exists()){
            return new FileInputStream(searchFile);
        }else
            return null;
    }

    public static String getStringResource(String resourcePath){
        FileInputStream fis = null;
        StringWriter writer = null;
        String theString = null;
        try{
            fis = getExternalResource(resourcePath);
            writer = new StringWriter();
            IOUtils.copy(fis, writer, "UTF-8");
            theString = writer.toString();
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (EnvironmentVariableNotDefinedException e) {
            e.printStackTrace();
        }finally {
            try {
                if(writer!=null)
                    writer.close();
                if(fis!=null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return theString;
    }

    public static Properties getExternalProperties(String resourcePath){
        Properties props = null;
        FileInputStream fis = null;
        try{
            fis = getExternalResource(resourcePath);
            props = new Properties();
            props.load(fis);
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            props = null;
        } catch (EnvironmentVariableNotDefinedException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fis!=null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return props;
    }
    public static URL[] resolveClassPath(String basePath) throws EnvironmentVariableNotDefinedException, MalformedURLException {
        List<URL> ruleFiles = new ArrayList<>();
        File dir = new File(getHomePath()+File.separator+basePath);
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
                    resource.close();
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
