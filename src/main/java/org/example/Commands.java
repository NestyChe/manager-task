package org.example;

public class Commands {
    private Task task;

    public void add(String descriptionTask) {
        if (descriptionTask.length() == 0){
            System.err.println("input task");
            return;
        }
        task = new Task(descriptionTask);
    }

    public void print(String descriptionTask) {
        if (descriptionTask.equals("all")) {
            System.out.println(task.toString());
        } else if (descriptionTask.equals("")) {
            System.out.println(task.getStates() == ' ' ? task.toString() : "");
        } else {
            System.err.println("wrong tag");
        }
    }
    public void toggle(String descriptionTask) {
        try {
            int identifier = Integer.parseInt(descriptionTask);
            if (task.getIdentifier() == identifier)
                task = task.getStates() == 'X'
                        ? new Task(task.getIdentifier(), ' ', task.getTasks())
                        : new Task(task.getIdentifier(), 'X', task.getTasks());
            else System.err.println("wrong identifier");
        } catch (NumberFormatException exception) {
            System.err.println("input one numeric identifier");
        }
        //}
    }

    public void quit() {
        System.exit(0);
    }

    public boolean hasTask() {
        return task != null;
    }
}
