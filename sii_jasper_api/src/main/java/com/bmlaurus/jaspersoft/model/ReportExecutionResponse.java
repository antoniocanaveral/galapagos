package com.bmlaurus.jaspersoft.model;

import java.util.List;

/**
 * Created by acanaveral on 9/7/16.
 */
public class ReportExecutionResponse{
    private String status;
    private int totalPages;
    private String requestId;
    private String reportURI;
    private List<Export> exports;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getReportURI() {
        return reportURI;
    }

    public void setReportURI(String reportURI) {
        this.reportURI = reportURI;
    }

    public List<Export> getExports() {
        return exports;
    }

    public void setExports(List<Export> exports) {
        this.exports = exports;
    }

    public class Export{
        private String id;
        private String status;
        private Resource outputResource;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Resource getOutputResource() {
            return outputResource;
        }

        public void setOutputResource(Resource outputResource) {
            this.outputResource = outputResource;
        }
    }

    public class Resource{
        private String contentType;
        private String fileName;
        private boolean outputFinal;

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public boolean isOutputFinal() {
            return outputFinal;
        }

        public void setOutputFinal(boolean outputFinal) {
            this.outputFinal = outputFinal;
        }
    }
}
