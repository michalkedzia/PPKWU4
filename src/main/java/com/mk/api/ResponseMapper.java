package com.mk.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;

public class ResponseMapper {

    public static String fromJsonToStringResponse(String json){
        Gson gson = new Gson();
        return gson.fromJson(json,StringResponse.class).toString();
    }

    public static String fromXmlToStringResponse(String xml) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        StringResponse value = xmlMapper.readValue(xml, StringResponse.class);
        return value.toString();
    }

    public static String fromCsvToStringResponse(String json){
        return "";
    }

    public static String fromTextToStringResponse(String json){
        return "";
    }
}
