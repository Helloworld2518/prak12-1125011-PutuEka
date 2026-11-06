package model;
import java.util.*;

public class User{
    private String name;
    public List<User> contacts = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void sendMessage(User receiver, String message){
        System.out.println("Hallo: " + receiver.getName() + " Pesan: " + message);
    }

    public void receiveMessage(User sender, String message){
        System.out.println("Menerima pesan dari: " + sender.getName() + " isi Pesan: " + message);
    }

    public void addContact(User user, User sender){
        contacts.add(user);
        user.contacts.add(sender);
        System.out.println("Kontak " + user.getName() + " Berhasil ditambah!");
    }

    public void sendGropuMessage(String message){
        for (User cts: contacts){
            sendMessage(cts, message);
            System.out.println("Mengirim ke kontak " + cts.getName());
        }
    }
}