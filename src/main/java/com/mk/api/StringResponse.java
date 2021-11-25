package com.mk.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;

public class StringResponse {
    private String parameter;
    private int length;
    private Long digits;
    private Long upperCase;
    private Long lowerCase;
    private Long whitespace;

    public String getParameter() {
        return parameter;
    }

    public StringResponse() {
    }

    public StringResponse(String parameter, int length, Long digits, Long upperCase, Long lowerCase, Long whitespace, Long specialCharacters) {
        this.parameter = parameter;
        this.length = length;
        this.digits = digits;
        this.upperCase = upperCase;
        this.lowerCase = lowerCase;
        this.whitespace = whitespace;
        this.specialCharacters = specialCharacters;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Long getDigits() {
        return digits;
    }

    public void setDigits(Long digits) {
        this.digits = digits;
    }

    public Long getUpperCase() {
        return upperCase;
    }

    public void setUpperCase(Long upperCase) {
        this.upperCase = upperCase;
    }

    public Long getLowerCase() {
        return lowerCase;
    }

    public void setLowerCase(Long lowerCase) {
        this.lowerCase = lowerCase;
    }

    public Long getWhitespace() {
        return whitespace;
    }

    public void setWhitespace(Long whitespace) {
        this.whitespace = whitespace;
    }

    public Long getSpecialCharacters() {
        return specialCharacters;
    }

    public void setSpecialCharacters(Long specialCharacters) {
        this.specialCharacters = specialCharacters;
    }

    private Long specialCharacters;

    public StringResponse(String parameter) {
        this.parameter = parameter;
        this.length = parameter.length();
        this.digits = 0L;
        this.upperCase = 0L;
        this.lowerCase = 0L;
        this.whitespace = 0L;
        this.specialCharacters = 0L;
    }

    public void addDigit() {
        this.digits++;
    }

    public void addUpperCase() {
        this.upperCase++;
    }

    public void addLowerCase() {
        this.lowerCase++;
    }

    public void addWhitespace() {
        this.whitespace++;
    }

    public void addSpecialCharacter() {
        this.specialCharacters++;
    }

    public String toText() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("parameter: ");
        stringBuilder.append(parameter);
        stringBuilder.append("\n");
        stringBuilder.append("digits: ");
        stringBuilder.append(digits);
        stringBuilder.append("\n");
        stringBuilder.append("upperCase: ");
        stringBuilder.append(upperCase);
        stringBuilder.append("\n");
        stringBuilder.append("lowerCase: ");
        stringBuilder.append(lowerCase);
        stringBuilder.append("\n");
        stringBuilder.append("whitespace: ");
        stringBuilder.append(whitespace);
        stringBuilder.append("\n");
        stringBuilder.append("specialCharacters: ");
        stringBuilder.append(specialCharacters);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "StringResponse{" +
                "parameter='" + parameter + '\'' +
                ", length=" + length +
                ", digits=" + digits +
                ", upperCase=" + upperCase +
                ", lowerCase=" + lowerCase +
                ", whitespace=" + whitespace +
                ", specialCharacters=" + specialCharacters +
                '}';
    }

    public String toCSV() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("parameter,");
        stringBuilder.append("digits,");
        stringBuilder.append("upperCase,");
        stringBuilder.append("lowerCase,");
        stringBuilder.append("whitespace,");
        stringBuilder.append("specialCharacters");
        stringBuilder.append("\n");
        stringBuilder.append(parameter);
        stringBuilder.append(",");
        stringBuilder.append(digits);
        stringBuilder.append(",");
        stringBuilder.append(upperCase);
        stringBuilder.append(",");
        stringBuilder.append(lowerCase);
        stringBuilder.append(",");
        stringBuilder.append(whitespace);
        stringBuilder.append(",");
        stringBuilder.append(specialCharacters);
        return stringBuilder.toString();
    }

    public String toJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toXML() throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.writeValueAsString(this);
    }
}
