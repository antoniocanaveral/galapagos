package com.bmlaurus.job;

import java.io.Serializable;

/**
 * Created by acanaveral on 1/7/16.
 */
public class BaseTrigger implements Serializable{
    //{'type':'SimpleTrigger', 'name':'MailTrigger', 'group':'MailGroup', 'repeatCount':-1, 'repeatInterval':'1'}

    public static String TYPE_SIMPLE   =   "SIMPLE";
    public static String TYPE_CRON     =   "CRON";

    private String type;
    private String name;
    private String group;
    private String cronExpression;
    private int repeatCount;
    private int repeatInterval;

    public BaseTrigger(String type, String name, String group) {
        this.type = type;
        this.name = name;
        this.group = group;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public int getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    public int getRepeatInterval() {
        return repeatInterval;
    }

    public void setRepeatInterval(int repeatInterval) {
        this.repeatInterval = repeatInterval;
    }
}
