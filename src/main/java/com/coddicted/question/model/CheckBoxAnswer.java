package com.coddicted.question.model;

import lombok.Data;

import java.util.List;

@Data
public class CheckBoxAnswer implements Answer {
    private List<String> valueList;
    private List<Integer> defaultOptions;
    private List<Integer> correctOptions;
    private String explanation;
}
