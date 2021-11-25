package com.mk.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2")
public class RestFormatAPI {

    @Autowired
    public RestService restService;

    //    coDostajeUser/coWsyłamyDoZadania3
    @GetMapping("/text/{format}/{parameter}" )
    public String responseAsText(@PathVariable("format") String format, @PathVariable("parameter") String parameter) throws JsonProcessingException {
        return ResponseMapper.fromXmlToStringResponse(restService.getStringInformation(parameter,format)) ;
//        return ResponseMapper.fromJsonToStringResponse(restService.getStringInformation(parameter,format)) ;
    }

    @GetMapping("/json/{format}{parameter}")
    public String responseAsJSON(@PathVariable("format") String format, @PathVariable("parameter") String parameter) {
        return restService.getStringInformation(parameter,format)  + " " + "json";
    }

    @GetMapping(value = "/xml/{format}/{parameter}", produces = MediaType.APPLICATION_XML_VALUE)
    public String responseAsXML(@PathVariable("format") String format, @PathVariable("parameter") String parameter) {
        return restService.getStringInformation(parameter,format)  + " " + "xml";
    }

    @GetMapping("/csv/{format}/{parameter}")
    public String responseAsCSV(@PathVariable("format") String format, @PathVariable("parameter") String parameter) {
        return restService.getStringInformation(parameter,format)  + " " + "csv";
    }
}
