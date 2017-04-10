package sample.command;


public class ListCommand implements Command {

    @Override
    public void execute() {
        System.out.println("List user.");
    }
}
