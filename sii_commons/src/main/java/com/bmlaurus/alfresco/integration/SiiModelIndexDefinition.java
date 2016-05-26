package com.bmlaurus.alfresco.integration;

import java.io.Serializable;
import java.util.List;

/**
 * Created by acanaveral on 26/5/16.
 */
public class SiiModelIndexDefinition implements Serializable {

    private static final long serialVersionUID = 7258424703897064170L;

    private String name;
    private String description;
    private List<SiiModelIndexItem> itemList;
}
