package com.bmlaurus.alfresco.aspects;

import com.bmlaurus.alfresco.utils.PropertyIds;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public abstract class Aspect {
  protected final String prefix = "sii";

  abstract public String getAspectName();
  abstract public List<AspectProperty> toProperties();

  public static void addAspectProperty(LinkedHashMap<String, Object> props, String aspectId, String propertyId, Serializable propertyValue){
    ArrayList<String> secIds = new ArrayList<String>();
    if(props.get(PropertyIds.SECONDARY_OBJECT_TYPE_IDS)!=null){
      ArrayList<String> currentAspects = (ArrayList<String>) props.get(PropertyIds.SECONDARY_OBJECT_TYPE_IDS);
      for(String prop: currentAspects){
        secIds.add(prop);
      }
      if(!currentAspects.contains(aspectId))
        secIds.add(aspectId);
      props.replace(PropertyIds.SECONDARY_OBJECT_TYPE_IDS, secIds);
    }else{
      secIds.add(aspectId);
      props.put(PropertyIds.SECONDARY_OBJECT_TYPE_IDS, secIds);
    }

    if(props.get(propertyId)==null)
      props.put(propertyId, propertyValue);
    else
      props.replace(propertyId, propertyValue);
  }

}
