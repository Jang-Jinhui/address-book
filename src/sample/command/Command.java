package sample.command;


import java.util.Scanner;


public interface Command {

    void execute();


    public static String input(String title) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print(title + ": ");
            return scanner.nextLine();
        }
    }
}
