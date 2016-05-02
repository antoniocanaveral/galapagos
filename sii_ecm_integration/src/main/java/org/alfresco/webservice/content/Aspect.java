package org.alfresco.webservice.content;


public class Aspect {

  protected String aspect_name = "";
  protected String aspect_domain = "";
  protected String[] property_names;
  protected String[] property_values;

  public Aspect(String aspect_name, String aspect_domain, String[] property_names,
      String[] property_values) {
    this.aspect_name = aspect_name;
    this.aspect_domain = aspect_domain;
    this.property_names = property_names;
    this.property_values = property_values;

  }

  public String getAspect_name() {
    return aspect_name;
  }

  public void setAspect_name(String aspect_name) {
    this.aspect_name = aspect_name;
  }

  public String getAspect_domain() {
    return aspect_domain;
  }

  public void setAspect_domain(String aspect_domain) {
    this.aspect_domain = aspect_domain;
  }

  public String[] getProperty_names() {
    return property_names;
  }

  public String[] getProperty_names_as_array() {
    return property_names;
  }

  public void setProperty_names(String[] property_names) {
    this.property_names = property_names;
  }

  public String[] getProperty_values() {
    return property_values;
  }

  public String[] getProperty_values_as_array() {
    return (String[]) property_values;
  }

  public void setProperty_values(String[] property_values) {
    this.property_values = property_values;
  }

}
