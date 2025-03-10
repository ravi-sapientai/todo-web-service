package com.bmuschko.todo.webservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("personal")
public class PersonalToDoItem extends BaseTodoItem {
    private String location;
    private String category;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return super.toString() + " [Location: " + location + ", Category: " + category + "]";
    }
} 