package com.bmlaurus.jaspersoft.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by acanaveral on 1/8/16.

 "type":"text|number|date|dateTime|time",
 "pattern":"{pattern}",
 "maxValue":"{maxValue}",
 "strictMax":"true|false",
 "minValue":"{minValue}",
 "strictMin":"true|false"
 "maxLength":"{maxLengthInteger}"
 */
public class JasperDataType extends  BaseRestModel implements Serializable {

    public static String TYPE_TEXT="text";
    public static String TYPE_NUMBER="number";
    public static String TYPE_DATE="date";
    public static String TYPE_DATE_TIME="dateTime";
    public static String TYPE_TIME="time";

    private Date creationDate;
    private String description;
    private String label;
    private long permissionMask;
    private Date updateDate;
    private String uri;
    private long version;
    private String type;
    private String pattern;
    private String maxValue;
    private String strictMax;
    private String minValue;
    private String strictMin;
    private String maxLength;

    public JasperDataType() {
        super("application/repository.dataType+json");
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    public String getStrictMax() {
        return strictMax;
    }

    public void setStrictMax(String strictMax) {
        this.strictMax = strictMax;
    }

    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getStrictMin() {
        return strictMin;
    }

    public void setStrictMin(String strictMin) {
        this.strictMin = strictMin;
    }

    public String getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(String maxLength) {
        this.maxLength = maxLength;
    }
}
