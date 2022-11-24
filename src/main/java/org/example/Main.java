package org.example;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class.getName());
    static Commands commands = new Commands();

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        org.apache.logging.log4j.core.config.Configurator.setLevel(LogManager.getRootLogger(),
                Level.valueOf(args[0].toUpperCase()));
        while(in.hasNext()) {
            String command = in.next();
            String task = in.nextLine().trim();
            logger.debug("User input: {} {}", command, task);
            if (command.equals("add")) {
                commands.add(task);
            } else if (command.equals("quit")) {
                commands.quit();
            } else if (!Task.list.isEmpty()) {

                switch (command) {
                    case "search":
                        commands.search(task);
                        break;
                    case "print":
                        commands.print(task);
                        break;
                    case "toggle":
                        commands.toggle(task);
                        break;
                    case "edit":
                        commands.edit(task);
                        break;
                    case "delete":
                        commands.delete(task);
                        break;
                    default:
                        logger.error("unknown command");
                        System.err.println("unknown command");
                        break;
                }
            } else {
                logger.error("task list empty");
                System.err.println("please, save task");
            }
        }
    }
}