package model;

public class User{
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    void sendMessage(User receiver, String message){
        System.out.println("Hallo: " + receiver.getName() + "Pesan: " + message);
    }

    void receiveMessage(User sender, String message){
        System.out.println("Menerima pesan dari: " + sender + "isi Pesan: " + message);
    }
}