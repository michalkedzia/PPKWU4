package com.mk.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class RestService {
    final String uri = "http://localhost:8081/api/v1/{format}/{parameter}";

    public String getStringInformation(String parameter, String format) {
        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("format", format);
        uriVariables.put("parameter", parameter);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class, uriVariables);
        return result;
    }

//    public String getResponseAsText(String parameter) {
//        StringResponse stringResponse = getStringInformation(parameter);
//        return stringResponse.toText();
//    }
//
//    public String getResponseAsJSON(String parameter) {
//        Gson gson = new Gson();
//        StringResponse stringResponse = getStringInformation(parameter);
//        return gson.toJson(stringResponse);
//    }
//
//    public String getResponseAsXML(String parameter) throws JsonProcessingException {
//        XmlMapper xmlMapper = new XmlMapper();
//        return xmlMapper.writeValueAsString(getStringInformation(parameter));
//    }
//
//    public String getResponseAsCSV(String parameter) {
//        StringResponse stringResponse = getStringInformation(parameter);
//        return stringResponse.toCSV();
//    }
}
