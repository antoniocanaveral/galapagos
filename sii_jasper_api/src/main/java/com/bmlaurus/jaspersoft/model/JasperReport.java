package com.bmlaurus.jaspersoft.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by acanaveral on 16/5/16.
 */
public class JasperReport extends  BaseRestModel implements Serializable {

    public static final String CONTROL_POPUP = "popupScreen";
    public static final String CONTROL_SEPARATE_PAGE = "separatePage";
    public static final String CONTROL_TOP_PAGE = "topOfPage";
    public static final String CONTROL_INPAGE = "inPage";

    private Date creationDate;
    private String description;
    private String label;
    private long permissionMask;
    private Date updateDate;
    private String uri;
    private long version;

    private boolean alwaysPromptControls;
    private String controlsLayout;
    private String inputControlRenderingView;
    private String reportRenderingView;

    private DataSource dataSource;
    private Query query;
    private Jrxml jrxml;
    private List<InputControl> inputControls;
    private List<Resource> resources;

    public JasperReport() {
        super("application/repository.reportUnit+json");
        controlsLayout = CONTROL_POPUP;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public long getPermissionMask() {
        return permissionMask;
    }

    public void setPermissionMask(long permissionMask) {
        this.permissionMask = permissionMask;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public boolean isAlwaysPromptControls() {
        return alwaysPromptControls;
    }

    public void setAlwaysPromptControls(boolean alwaysPromptControls) {
        this.alwaysPromptControls = alwaysPromptControls;
    }

    public String getControlsLayout() {
        return controlsLayout;
    }

    public void setControlsLayout(String controlsLayout) {
        this.controlsLayout = controlsLayout;
    }

    public String getInputControlRenderingView() {
        return inputControlRenderingView;
    }

    public void setInputControlRenderingView(String inputControlRenderingView) {
        this.inputControlRenderingView = inputControlRenderingView;
    }

    public String getReportRenderingView() {
        return reportRenderingView;
    }

    public void setReportRenderingView(String reportRenderingView) {
        this.reportRenderingView = reportRenderingView;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public Jrxml getJrxml() {
        return jrxml;
    }

    public void setJrxml(Jrxml jrxml) {
        this.jrxml = jrxml;
    }

    public List<InputControl> getInputControls() {
        return inputControls;
    }

    public void setInputControls(List<InputControl> inputControls) {
        this.inputControls = inputControls;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public static class DataSource implements Serializable{

        private DataSourceReference dataSourceReference;

        public DataSource(String uri) {
            DataSourceReference reference = new DataSourceReference(uri);
            this.dataSourceReference = reference;
        }

        private class DataSourceReference implements Serializable{
            private String uri;

            public DataSourceReference(String uri) {
                this.uri = uri;
            }
        }
    }

    public static class Query implements Serializable{

        private QueryReference queryReference;

        public Query(String uri) {
            QueryReference reference = new QueryReference(uri);
            this.queryReference = reference;
        }

        private class QueryReference implements Serializable{
            private String uri;

            public QueryReference(String uri) {
                this.uri = uri;
            }
        }
    }

    public static class Jrxml implements Serializable{

        private JrxmlReference jrxmlFileReference;

        public Jrxml(String uri) {
            JrxmlReference reference = new JrxmlReference(uri);
            this.jrxmlFileReference = reference;
        }

        private class JrxmlReference implements Serializable{
            private String uri;

            public JrxmlReference(String uri) {
                this.uri = uri;
            }
        }
    }

    public static class InputControl implements Serializable{

        private InputControlReference inputControlReference;

        public InputControl(String uri) {
            InputControlReference reference = new InputControlReference(uri);
            this.inputControlReference = reference;
        }

        private class InputControlReference implements Serializable{
            private String uri;

            public InputControlReference(String uri) {
                this.uri = uri;
            }
        }
    }

    public static class Resource implements Serializable{

        private FileResource resource;



        private class FileResource implements Serializable{
            private String name;
            private FileReference fileReference;

            public FileResource(String name, String uri) {
                this.name = name;
                this.fileReference = new FileReference(uri);
            }
        }

        private class FileReference implements Serializable{
            private String uri;

            public FileReference(String uri) {
                this.uri = uri;
            }
        }
    }

}
