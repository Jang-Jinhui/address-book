package sample;


import sample.service.AddressBookService;


public class Main {

    public static void main(String[] args) {
        new AddressBookService().start();
        
        System.out.println("Finish...");
    }
}
