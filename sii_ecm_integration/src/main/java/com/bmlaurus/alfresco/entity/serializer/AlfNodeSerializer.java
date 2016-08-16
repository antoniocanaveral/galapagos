package com.bmlaurus.alfresco.entity.serializer;

import com.bmlaurus.alfresco.entity.AlfNode;
import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by acanaveral on 28/4/16.
 */
public class AlfNodeSerializer implements JsonSerializer<AlfNode>{

    public JsonElement serialize(AlfNode src, Type typeOfSrc,
                                 JsonSerializationContext context) {
        if (src != null) {
            JsonObject element = new JsonObject();
            element.addProperty("nodeRef", src.getNodeRef());
            element.addProperty("site", src.getSite());
            element.addProperty("container", src.getContainer());
            return element;
        }
        return JsonNull.INSTANCE;
    }
}