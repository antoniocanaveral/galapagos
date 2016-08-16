package com.jaspersoft.jasperserver.rest.sample;

import org.apache.commons.io.FileUtils;
import org.apache.tika.Tika;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by acanaveral on 6/6/16.
 */
public class ImportOldData {

    private static final String DEST_PATH="/Users/acanaveral/Desktop/test";

    @Test
    public void ImportData(){
        try {
            String strSQL = "select r.name, r.label,fr.data,fr.file_type,rf.uri, rf.name as folder_name,rf.label as folder_label\n" +
                    "from jiresource r\n" +
                    "join jifileresource fr on r.id = fr.id\n" +
                    "join jiresourcefolder rf on rf.id = r.parent_folder\n" +
                    "order by rf.uri";
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(strSQL);
            ResultSet results = stmt.executeQuery();
            String targetFile;
            while (results.next()) {
                InputStream streamData = results.getBinaryStream("data");//new ByteArrayInputStream(data);
                String mimeGuess = gueesExtention(streamData);//".jrxml";
                String fileName = results.getString("name");
                String type = results.getString("file_type");
                if(fileName.endsWith(type))
                    fileName = fileName.replace("_"+type,"")+mimeGuess;
                else
                    fileName = fileName+mimeGuess;
                targetFile = DEST_PATH + results.getString("uri")+"/"+fileName;
                File dest = new File(targetFile);
                FileUtils.copyInputStreamToFile(streamData, dest);
            }
            results.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
        Properties prop = new Properties();
        prop.put("user", "postgres");
        prop.put("password","postgres");
        prop.put("ApplicationName", "Importer");
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/jasperserver", prop);
    }

    private static String gueesExtention(InputStream stream) throws IOException {
        Map<String,String> extentions = new HashMap<>();
        extentions.put("application/xml",".jrxml");
        extentions.put("image/gif",".gif");
        extentions.put("image/jpeg",".jpeg");
        extentions.put("image/png",".png");

        Tika tika = new Tika();
        String mime = tika.detect(stream);
        if(extentions.containsKey(mime))
            return extentions.get(mime);

        return ".jrxml";
    }
}
