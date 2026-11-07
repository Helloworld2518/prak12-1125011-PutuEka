package model;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private List<String> badWords = new ArrayList<>();
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
            mb.receiveMessage(sender, filterMessage(message));
        }
    }

    public void sendPrivateMessage(User sender, User recipientName, String message){
        System.out.println("ChatRomm -> General (Private " + sender.getName() + " -> " + recipientName.getName() + " ): " + message);
        recipientName.receiveMessage(sender, message);  
    }

    public void addBadWord(String word){
        badWords.add(word);
    }

    public String filterMessage(String message){
        message = message.toLowerCase();
        String[] arrmsg = message.split(" ");
        String safeTulisan = "";

        for (String msg: arrmsg){
            if (badWords.contains(msg)){
                msg = "***";
            }
            safeTulisan = safeTulisan + msg + " ";
        }

        return safeTulisan;
    }
}
