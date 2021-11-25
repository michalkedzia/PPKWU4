package com.mk.api;

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
        return restTemplate.getForObject(uri, String.class, uriVariables);
    }
}
