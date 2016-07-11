package com.bmlaurus.jaspersoft.model;

/**
 * Created by acanaveral on 9/7/16.
 */
public class ReportExecution extends BaseRestModel {

    private String reportUnitUri;
    private boolean async;
    private boolean freshData;
    private boolean saveDataSnapshot;
    private String outputFormat;
    private boolean interactive;
    private ReportParameters parameters;


    public ReportExecution() {
        super("application/json");
        //Load Defaults
        this.async = false;
        this.freshData = false;
        this.saveDataSnapshot = false;
        this.outputFormat = "pdf";
        this.interactive = false;
    }

    public String getReportUnitUri() {
        return reportUnitUri;
    }

    public void setReportUnitUri(String reportUnitUri) {
        this.reportUnitUri = reportUnitUri;
    }

    public boolean isAsync() {
        return async;
    }

    public void setAsync(boolean async) {
        this.async = async;
    }

    public boolean isFreshData() {
        return freshData;
    }

    public void setFreshData(boolean freshData) {
        this.freshData = freshData;
    }

    public boolean isSaveDataSnapshot() {
        return saveDataSnapshot;
    }

    public void setSaveDataSnapshot(boolean saveDataSnapshot) {
        this.saveDataSnapshot = saveDataSnapshot;
    }

    public String getOutputFormat() {
        return outputFormat;
    }

    public void setOutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
    }

    public boolean isInteractive() {
        return interactive;
    }

    public void setInteractive(boolean interactive) {
        this.interactive = interactive;
    }

    public ReportParameters getParameters() {
        return parameters;
    }

    public void setParameters(ReportParameters parameters) {
        this.parameters = parameters;
    }
}
