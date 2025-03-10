package com.bmuschko.todo.webservice.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("work")
public class WorkToDoItem extends BaseTodoItem {
    private String projectCode;
    private Priority priority;

    public enum Priority {
        LOW, MEDIUM, HIGH
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return super.toString() + " [Project: " + projectCode + ", Priority: " + priority + "]";
    }
} 