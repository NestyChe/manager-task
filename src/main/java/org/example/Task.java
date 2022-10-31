package org.example;

import java.util.ArrayList;
import java.util.List;

public class Task {


    private String descriptionTask;
    private boolean done;
    private final String identifier;
    private static int count = 0;

    public static List<Task> list = new ArrayList<>();

    public Task(String description) {
        count += 1;
        this.descriptionTask = description;
        this.identifier = String.valueOf(count);

    }

    public void setDescriptionTask(String descriptionTask) {
        this.descriptionTask = descriptionTask;
    }
    public String getTask() {
        return descriptionTask;
    }

    public boolean getStates() {
        return done;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void invertState() {
        done = !done;
    }


    @Override
    public String toString() {
        return String.format("%s. [%s] %s ", identifier, (done ? "X" : " "), descriptionTask);
    }
}
