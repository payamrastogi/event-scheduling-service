package com.coddicted.question.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "tags")
public class Tag {
    @Id
    private String id;
    private String value;
    private String description;
    private boolean isActive;
}
