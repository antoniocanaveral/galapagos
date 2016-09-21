package com.bmlaurus.csv;

import com.bmlaurus.invoker.BackendInvoker;
import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by acanaveral on 1/9/16.
 */
public class MasBuscadosImporter{



    public MasBuscadosImporter(String parentPath){
        File parent = new File(parentPath);
        if(parent.exists() && parent.isDirectory()){
            for(File arch: parent.listFiles()){
                if(arch.isFile()){
                    String result = parseFile(arch.getPath());
                    if(result!=null && result.trim().equals("{true}"))
                        arch.delete();
                }
            }
        }

    }


    private String parseFile(String filePath){
        FileReader inFile = null;
        try {
            inFile = new FileReader(filePath);
            CSVReader reader = new CSVReader(inFile);
            List<String[]> records = reader.readAll();
            StringBuilder jsonBuilder = new StringBuilder();
            jsonBuilder.append("[");
            for(String[] record:records){
                MasBuscados mb = new MasBuscados(record[0],record[1],record[2],record[3],record[4],record[5],record[6]);
                jsonBuilder.append(mb.toString());
                jsonBuilder.append(",");
            }
            jsonBuilder.replace(jsonBuilder.length()-1,jsonBuilder.length(),"]");

            BackendInvoker backendInvoker = new BackendInvoker();
            return backendInvoker.invokeBackendServlet("MasBuscadosImporterSVR","POST",jsonBuilder.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "{false}";
    }



}
