package com.mk.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2")
public class RestFormatAPI {

    public static final String TEXT_FORMAT = "text";
    public static final String CSV_FORMAT = "csv";
    public static final String JSON_FORMAT = "json";
    public static final String XML_FORMAT = "xml";

    @Autowired
    public RestService restService;

    //    coDostajeUser/coWsyłamyDoZadania3
    @GetMapping("/text/{format}/{parameter}")
    public String responseAsText(@PathVariable("format") String format, @PathVariable("parameter") String parameter) throws JsonProcessingException {
        switch (format) {
            case TEXT_FORMAT: {
                return ResponseMapper.fromTextToStringResponse(restService.getStringInformation(parameter, format)).toText();
            }
            case CSV_FORMAT: {
                return ResponseMapper.fromCsvToStringResponse(restService.getStringInformation(parameter, format)).toText();
            }
            case XML_FORMAT: {
                return ResponseMapper.fromXmlToStringResponse(restService.getStringInformation(parameter, format)).toText();
            }
            case JSON_FORMAT: {
                return ResponseMapper.fromJsonToStringResponse(restService.getStringInformation(parameter, format)).toText();
            }
            default: {
                return "Invalid data.";
            }
        }
    }

    @GetMapping("/json/{format}/{parameter}")
    public String responseAsJSON(@PathVariable("format") String format, @PathVariable("parameter") String parameter) throws JsonProcessingException {
        switch (format) {
            case TEXT_FORMAT: {
                return ResponseMapper.fromTextToStringResponse(restService.getStringInformation(parameter, format)).toJSON();
            }
            case CSV_FORMAT: {
                return ResponseMapper.fromCsvToStringResponse(restService.getStringInformation(parameter, format)).toJSON();
            }
            case XML_FORMAT: {
                return ResponseMapper.fromXmlToStringResponse(restService.getStringInformation(parameter, format)).toJSON();
            }
            case JSON_FORMAT: {
                return ResponseMapper.fromJsonToStringResponse(restService.getStringInformation(parameter, format)).toJSON();
            }
            default: {
                return "Invalid data.";
            }
        }
    }

    @GetMapping(value = "/xml/{format}/{parameter}", produces = MediaType.APPLICATION_XML_VALUE)
    public String responseAsXML(@PathVariable("format") String format, @PathVariable("parameter") String parameter) throws JsonProcessingException {
        switch (format) {
            case TEXT_FORMAT: {
                return ResponseMapper.fromTextToStringResponse(restService.getStringInformation(parameter, format)).toXML();
            }
            case CSV_FORMAT: {
                return ResponseMapper.fromCsvToStringResponse(restService.getStringInformation(parameter, format)).toXML();
            }
            case XML_FORMAT: {
                return ResponseMapper.fromXmlToStringResponse(restService.getStringInformation(parameter, format)).toXML();
            }
            case JSON_FORMAT: {
                return ResponseMapper.fromJsonToStringResponse(restService.getStringInformation(parameter, format)).toXML();
            }
            default: {
                return "Invalid data.";
            }
        }
    }

    @GetMapping("/csv/{format}/{parameter}")
    public String responseAsCSV(@PathVariable("format") String format, @PathVariable("parameter") String parameter) throws JsonProcessingException {

        switch (format) {
            case TEXT_FORMAT: {
                return ResponseMapper.fromTextToStringResponse(restService.getStringInformation(parameter, format)).toCSV();
            }
            case CSV_FORMAT: {
                return ResponseMapper.fromCsvToStringResponse(restService.getStringInformation(parameter, format)).toCSV();
            }
            case XML_FORMAT: {
                return ResponseMapper.fromXmlToStringResponse(restService.getStringInformation(parameter, format)).toCSV();
            }
            case JSON_FORMAT: {
                return ResponseMapper.fromJsonToStringResponse(restService.getStringInformation(parameter, format)).toCSV();
            }
            default: {
                return "Invalid data.";
            }
        }

    }
}
