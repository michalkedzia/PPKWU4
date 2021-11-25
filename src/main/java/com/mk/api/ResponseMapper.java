package com.mk.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseMapper {

    public static StringResponse fromJsonToStringResponse(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, StringResponse.class);
    }

    public static StringResponse fromXmlToStringResponse(String xml) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(xml, StringResponse.class);
    }

    public static StringResponse fromCsvToStringResponse(String csv) {
        List<String> csvList = Arrays.asList(csv.split("\n"));
        List<String> parametersName = Arrays.asList(csvList.get(0).split(","));
        List<String> parameters = Arrays.asList(csvList.get(1).split(","));
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < parametersName.size(); i++) {
            map.put(parametersName.get(i), parameters.get(i));
        }
        StringResponse stringResponse = new StringResponse();
        stringResponse.setParameter(map.get("parameter"));
        stringResponse.setDigits(Long.valueOf(map.get("digits")));
        stringResponse.setUpperCase(Long.valueOf(map.get("upperCase")));
        stringResponse.setLowerCase(Long.valueOf(map.get("lowerCase")));
        stringResponse.setWhitespace(Long.valueOf(map.get("whitespace")));
        stringResponse.setSpecialCharacters(Long.valueOf(map.get("specialCharacters")));
        return stringResponse;
    }

    public static StringResponse fromTextToStringResponse(String text) {
        List<String> list = Arrays.asList(text.split("\n"));
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            List<String> row = Arrays.asList(list.get(i).replaceAll(":", "").split(" "));
            map.put(row.get(0), row.get(1));
        }
        StringResponse stringResponse = new StringResponse();
        stringResponse.setParameter(map.get("parameter"));
        stringResponse.setDigits(Long.valueOf(map.get("digits")));
        stringResponse.setUpperCase(Long.valueOf(map.get("upperCase")));
        stringResponse.setLowerCase(Long.valueOf(map.get("lowerCase")));
        stringResponse.setWhitespace(Long.valueOf(map.get("whitespace")));
        stringResponse.setSpecialCharacters(Long.valueOf(map.get("specialCharacters")));
        return stringResponse;
    }
}
