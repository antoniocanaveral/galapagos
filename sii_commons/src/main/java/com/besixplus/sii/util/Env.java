package com.besixplus.sii.util;

import com.besixplus.sii.exception.EnvironmentVariableNotDefinedException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
}
