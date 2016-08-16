package com.bmlaurus.job;

import java.io.Serializable;

/**
 * Created by acanaveral on 1/7/16.
 */
public class BaseJob implements Serializable{
    //{'name':'SendMailJob','group':'MailGroup','className':'SendMailJob','trigger'
    private String name;
    private String group;
    private String className;
    private BaseTrigger trigger;

    public BaseJob(String name, String group, String className) {
        this.name = name;
        this.group = group;
        this.className = className;
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public BaseTrigger getTrigger() {
        return trigger;
    }

    public void setTrigger(BaseTrigger trigger) {
        this.trigger = trigger;
    }
}
