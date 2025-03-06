package com.bmuschko.todo.webservice.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "type"
    )
    @JsonSubTypes({
            @JsonSubTypes.Type(value = WorkToDoItem.class, name = "work"),
            @JsonSubTypes.Type(value = PersonalToDoItem.class, name = "personal")
    })
    public class BaseTodoItem {
        // ... existing ToDoItem fields and methods ...
    }

