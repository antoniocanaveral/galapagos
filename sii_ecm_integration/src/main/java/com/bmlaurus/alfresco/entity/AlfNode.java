package com.bmlaurus.alfresco.entity;

/**
 * Created by acanaveral on 28/4/16.
 */
public class AlfNode {
    private String nodeRef;
    private String site;
    private String container;

    public String getNodeRef() {
        return nodeRef;
    }

    public void setNodeRef(String nodeRef) {
        this.nodeRef = nodeRef;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }
}
