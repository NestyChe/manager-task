package org.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Commands {

    private static final Logger logger = LoggerFactory.getLogger(Commands.class.getName());

    public void add(String descriptionTask) {
        if (descriptionTask.isEmpty()){
            ExceptionTask.descriptionExcept();
        }
        Task.list.add(new Task(descriptionTask));
    }

    public void search (String substring) {
        if (substring.isEmpty()) ExceptionTask.descriptionExcept();
        else Task.list.stream().filter(t -> t.getTask().contains(substring)).forEach(System.out::println);
    }
    public void print(String descriptionTask) {
        if (!descriptionTask.equals("all") & !descriptionTask.isEmpty()) {
            System.err.println("wrong tag");
            return;
        }
        if (descriptionTask.isEmpty()) Task.list.stream().filter(task -> !task.getStates()).forEach(System.out::println);
        else Task.list.forEach(System.out::println);
    }
    public void toggle(String identifier) {
        action(identifier, id -> {
            Task task = findTask(identifier);
            logger.debug("States was: {}", task.getStates());
            task.invertState();
            logger.debug("Output, status has become: {}", task.getStates());
            return true;
        });
    }

    public void delete(String identifier) {
        action(identifier, id -> Task.list.remove(findTask(identifier)));
    }

    public  void edit (String descriptionTask) {
        String identifier = null;
        try {
            int indexSpace = descriptionTask.indexOf(" ");
            identifier = descriptionTask.substring(0, indexSpace);
            String newDescription = descriptionTask.substring(indexSpace);
            findTask(identifier).setDescriptionTask(newDescription);
        } catch (StringIndexOutOfBoundsException exception) {
            ExceptionTask.descriptionExcept();
        } catch (NoSuchElementException exception) {
            ExceptionTask.wrongInputExcept(identifier, exception);
        }
    }

    public void quit() {
        System.exit(0);
    }

    private void action (String id, Predicate<String> action) {
        if (id.isEmpty()) {
            ExceptionTask.descriptionExcept();
            return;
        }
        try {
            action.test(id);
        } catch (NoSuchElementException exception) {
            ExceptionTask.wrongInputExcept(id, exception);
        }
    }

    private Task findTask(String id) {
         return Task.list.stream()
                .filter(o -> o.getIdentifier().equals(id))
                .findFirst().orElseThrow();
    }
}
