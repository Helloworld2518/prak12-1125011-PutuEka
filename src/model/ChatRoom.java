package model;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private List<String> badWords = new ArrayList<>();
    private String roomName;
    private User admin;
    public List<User> members = new ArrayList<>();

    public ChatRoom(String roomName) {
        this.roomName = roomName;
    }
    
    public void registerUser(User user){
        if (!members.contains(user)){
            members.add(user);
            if (admin == null){
                admin = user;
                user.setAdmin(true);
            }
        }
        
        System.out.println("Berhasil Menambahkan user: " + user.getName());
    }

    public User getAdmin(){
        return admin;
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

    public void removeUser(User user, User master){
        if (master == admin){
            members.remove(user);
            System.out.println("User " + user.getName() + " Berhasil dihapus");
        }
        else{
            System.out.println("anda bukan admin");
        }
    }
}
