package com.coddicted.question.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = OneLineAnswer.class, name = "oneLine"),
        @JsonSubTypes.Type(value = OneWordAnswer.class, name = "oneWord"),
        @JsonSubTypes.Type(value = RadioButtonAnswer.class, name = "radioButton"),
        @JsonSubTypes.Type(value = CheckBoxAnswer.class, name = "checkBox"),
})
public interface Answer {

}
