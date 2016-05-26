package com.bmlaurus.alfresco.integration;

import java.io.Serializable;
import java.util.List;

/**
 * Created by acanaveral on 26/5/16.
 */
public class SiiModelFile implements Serializable{

    private static final long serialVersionUID = 4847214993952598944L;

    private String fileName;
    private String fileDescription;
    private String fileRepository;
    private boolean overrideName;
    private List<SiiModelIndexDefinition> indexDefinitionList;
}
