package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;

public class ExceptionTask {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionTask.class.getName());
    public static void descriptionExcept(){
        logger.error("Пустое значение id");
        System.err.println("input description");
    }

    public static void wrongInputExcept(String id, NoSuchElementException exception){
        logger.error("Нет задачи с таким  id: {} и exception: {}", id, exception.getLocalizedMessage());
        System.err.println("wrong id, no task with this id");
    }
}
