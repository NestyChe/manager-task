package org.example;

import java.util.Scanner;


public class Main {

    static Commands commands = new Commands();

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String command = in.next();
            String task = in.nextLine().trim();
            if (command.equals("add")) {
                commands.add(task);
            } else if (command.equals("quit")) {
                commands.quit();
            } else if (commands.hasTask()) {

                switch (command) {
                    case "print":
                        commands.print(task);
                        break;
                    case "toggle":
                        commands.toggle(task);
                        break;
                    default:
                        System.err.println("unknown command");
                        break;
                }
            } else {
                System.err.println("please, save task");
            }
        }
    }
}