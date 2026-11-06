package model;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private String roomName;
    public List<User> members = new ArrayList<>();

    public ChatRoom(String roomName) {
        this.roomName = roomName;
    }
    
    public void registerUser(User user){
        members.add(user);
        System.out.println("Berhasil Menambahkan user: " + user.getName());
    }

    public void sendBroadcast(User sender, String message){
        for (User mb: members){
            mb.receiveMessage(sender, message);
        }
    }

    public void sendPrivateMessage(User sender, User recipientName, String message){
        System.out.println("ChatRomm -> General (Private " + sender.getName() + " -> " + recipientName.getName() + " ): " + message);
        recipientName.receiveMessage(sender, message);  
    }
}
