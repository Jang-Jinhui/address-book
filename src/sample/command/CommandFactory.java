package sample.command;


public class CommandFactory {

    public static Command getCommand(String command) {
        switch (command) {
        case "1":
            return new AddCommand();
        case "2":
            return new ListCommand();
        case "3":
            return new InfoCommand();
        default:
            return null;
        }
    }
}
