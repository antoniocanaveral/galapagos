package com.bmlaurus.jaspersoft.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by acanaveral on 10/7/16.
 */
public class ReportParameters implements Serializable {
    private List<Parameter> reportParameter;

    public ReportParameters(List<Parameter> reportParameter) {
        this.reportParameter = reportParameter;
    }

    public List<Parameter> getReportParameter() {
        return reportParameter;
    }

    public void setReportParameter(List<Parameter> reportParameter) {
        this.reportParameter = reportParameter;
    }
}
