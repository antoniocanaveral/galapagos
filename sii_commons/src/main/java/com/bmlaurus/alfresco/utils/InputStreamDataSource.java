package com.bmlaurus.alfresco.utils;

import javax.activation.DataSource;
import javax.activation.MimetypesFileTypeMap;
import java.io.*;

/**
 * Created by acanaveral on 30/5/16.
 */
public class InputStreamDataSource implements DataSource{
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private String name;
    private String mime;

    public InputStreamDataSource(InputStream inputStream, String name, String mimeType) {
        consturctor(inputStream,name);
        this.mime = mimeType;
    }

    public InputStreamDataSource(InputStream inputStream, String name) {
        consturctor(inputStream,name);
    }

    private void consturctor(InputStream inputStream, String name){
        this.name = name;
        try {
            int nRead;
            byte[] data = new byte[16384];
            while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }

            buffer.flush();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getContentType() {
        if(mime != null)
            return mime;
        MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
        mimeTypesMap.addMimeTypes("text/plain txt");
        mimeTypesMap.addMimeTypes("application/pdf pdf");
        return mimeTypesMap.getContentType(name);
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(buffer.toByteArray());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        throw new IOException("Read-only data");
    }
}
