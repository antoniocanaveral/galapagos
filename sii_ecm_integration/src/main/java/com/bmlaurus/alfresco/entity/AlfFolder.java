package com.bmlaurus.alfresco.entity;

/**
 * Created by acanaveral on 27/4/16.
 */
public class AlfFolder {
    private String name;
    private String title;
    private String description;
    private String type;
    private AlfNode node;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AlfNode getNode() {
        return node;
    }

    public void setNode(AlfNode node) {
        this.node = node;
    }

    public AlfFolder(String name, String title, String description) {
        this.name = name;
        this.title = title;
        this.description = description;
        this.type = "cm:folder";
    }
}
