package model;

public class User{
    private String name;
    ChatRoom chatRoom;

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
        System.out.println("(" + this.getName() + ") " + "Menerima pesan dari: " + sender.getName() + " isi Pesan: " + message);
    }

    // public void addContact(User user){
    //     contacts.add(user);
    //     user.contacts.add(this);
    //     System.out.println("Kontak " + user.getName() + " Berhasil ditambah!");
    // }

    // public void sendGropuMessage(String message){
    //     for (User cts: contacts){
    //         sendMessage(cts, message);
    //         System.out.println("Mengirim ke kontak " + cts.getName());
    //     }
    // }

    public void setChatRoom(ChatRoom room){
        this.chatRoom = room;
        chatRoom.registerUser(this);
    }

    public void sendPrivate(User recipientName, String message){
        System.out.println(this.getName() + " Mengirim Pesan Private ke: " + recipientName.getName());
        chatRoom.sendPrivateMessage(this, recipientName, message);
    }
}