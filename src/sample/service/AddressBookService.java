package sample.service;


import java.util.Objects;
import java.util.Scanner;

import sample.command.Command;
import sample.command.CommandFactory;


public class AddressBookService {

    private void help() {
        System.out.println("1. Add");
        System.out.println("2. List");
        System.out.println("3. Info");
        System.out.println(".exit");
    }


    public void start() {
        help();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print(">> ");
                String inputCmd = scanner.nextLine();

                if (".exit".equals(inputCmd)) {
                    break;
                }

                Command command = CommandFactory.getCommand(inputCmd);
                if (Objects.isNull(command)) {
                    help();
                    continue;
                }
                command.execute();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
