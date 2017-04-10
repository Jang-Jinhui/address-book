package sample.command;


import sample.dao.UserDao;
import sample.domain.User;


public class AddCommand implements Command {

    private static UserDao userDao = new UserDao();


    @Override
    public void execute() {
        System.out.println("Add user.");

        User user = new User();
        user.setName(Command.input("name"));
        user.setZipcode(Command.input("zipcode"));
        user.setAddress(Command.input("address"));
        user.setEmail(Command.input("email"));

        userDao.save(user);
    }
}
