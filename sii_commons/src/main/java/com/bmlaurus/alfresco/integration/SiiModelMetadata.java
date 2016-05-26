package com.bmlaurus.alfresco.integration;

import java.io.Serializable;
import java.util.List;

/**
 * Created by acanaveral on 26/5/16.
 */
public class SiiModelMetadata implements Serializable{

    private static final long serialVersionUID = 7731771760501150148L;

    private String tableName;
    private String recordID;
    private String filter;

    private String filesRepository;///Usado cuando no es una lista y la entrada es libre.

    private boolean isList;
    private List<SiiModelFile> fileList;

}
