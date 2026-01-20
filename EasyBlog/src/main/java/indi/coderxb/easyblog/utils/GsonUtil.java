/**
 * GsonUtil.java   2016年1月27日 下午8:35:32 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2016 xuebing.Li. All rights reserved.
 * 
 */
package indi.coderxb.easyblog.utils;

import java.lang.reflect.Type;
import java.util.Date;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class GsonUtil {

    public static <T> String toJson(T t) {
        if (t == null)
            return null;
        Gson gson = new Gson();
        return gson.toJson(t);
    }

    public static <T> String toJsonExcludeField(T t) {
        if (t == null)
            return null;
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().enableComplexMapKeySerialization()
            .setDateFormat("yyyy-MM-dd HH:mm:ss.SSS").create();
        return gson.toJson(t);
    }

    public static <T> T formJson(String jsonString, Class<T> clazz) {
        if (jsonString == null)
            return null;
        Gson gson = new Gson();
        return gson.fromJson(jsonString, clazz);
    }

    public static <T> T formJson(String jsonString, String key, Class<T> clazz) {
        if (jsonString == null)
            return null;
        JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
        JsonElement jsonElement = jsonObject.get(key);
        if (!jsonElement.isJsonObject()) {
            throw new IllegalArgumentException("parse json is not a json object");
        }
        Gson gson = new Gson();
        return gson.fromJson(jsonElement, clazz);
    }

    public static <T> T formJsonForLongDate(String jsonString, Class<T> clazz) {
        JsonSerializer<Date> ser = new JsonSerializer<Date>(){
            @Override
            public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
                return src == null ? null : new JsonPrimitive(src.getTime());
            }
        };

        JsonDeserializer<Date> deser = new JsonDeserializer<Date>(){
            @Override
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {
                return json == null ? null : new Date(json.getAsLong());
            }
        };

        if (jsonString == null)
            return null;
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, ser).registerTypeAdapter(Date.class, deser)
            .create();
        return gson.fromJson(jsonString, clazz);
    }

}
