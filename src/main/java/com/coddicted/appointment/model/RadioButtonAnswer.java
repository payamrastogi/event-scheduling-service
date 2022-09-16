package com.coddicted.appointment.model;

import lombok.Data;

import java.util.List;

@Data
public class RadioButtonAnswer implements Answer {
    private List<String> valueList;
    private int defaultOption;
    private int correctOptions;
    private String explanation;
}
