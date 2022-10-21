package org.example;

public class Task {
    private final String descriptionTask;
    private final char states;
    private int identifier;

    public Task(String description) {
        this.descriptionTask = description;
        this.identifier += 1;
        this.states = ' ';
    }


    public Task( int identifier, char states, String description) {
        this.descriptionTask = description;
        this.states = states;
        this.identifier = identifier;
    }

    public String getTasks() {
        return descriptionTask;
    }

    public char getStates() {
        return states;
    }

    public int getIdentifier() {
        return identifier;
    }

    @Override
    public String toString() {
        return identifier + ". [" + states + "] " + descriptionTask;
    }
}
