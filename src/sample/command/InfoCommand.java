package sample.command;


public class InfoCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Info user.");
    }
}
