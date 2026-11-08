package model;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private List<String> badWords = new ArrayList<>();
    private String roomName;
    private User admin;
    public List<User> members = new ArrayList<>();
    private List<String> chatHistory = new ArrayList<>();
    private List<User> mutedUsers = new ArrayList<>(); 

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

        if (isMuted(sender)) {
            System.out.println("User " + sender.getName() + " sedang di-mute, tidak bisa mengirim pesan.");
            return;
        }
        
        String safeMessage = filterMessage(message);
        chatHistory.add(sender.getName() + ": " + safeMessage);

        for (User mb: members){
            mb.receiveMessage(sender, safeMessage);
        }
    }

    public void sendPrivateMessage(User sender, User recipientName, String message){
        if (isMuted(sender)) {
            System.out.println("User " + sender.getName() + " sedang di-mute, tidak bisa mengirim pesan.");
            return;
        }
        System.out.println("ChatRomm -> General (Private " + sender.getName() + " -> " + recipientName.getName() + " ): " + message);
        recipientName.receiveMessage(sender, message);  
    }

    public void addBadWord(String word){
        badWords.add(word);
    }

    public void muteUser(User master, User target) {

        if (master != admin) {
            System.out.println("Maaf, " + master.getName() + " bukan admin, tidak bisa mute user lain.");
            return;
        }

        if (!members.contains(target)) {
            System.out.println("User " + target.getName() + " tidak ada di room ini.");
            return;
        }

        if (!mutedUsers.contains(target)) {
            mutedUsers.add(target);
            System.out.println("User " + target.getName() + " berhasil di-mute oleh admin " + master.getName());
        } else {
            System.out.println("User " + target.getName() + " sudah di-mute.");
        }
    }

     public void unmuteUser(User master, User target) {

        if (master != admin) {
            System.out.println("Maaf, " + master.getName() + " bukan admin jadi tidak bisa unmute user lain.");
            return;
        }

        if (mutedUsers.contains(target)) {
            mutedUsers.remove(target);
            System.out.println("User " + target.getName() + " berhasil di-unmute oleh admin " + master.getName());
        } else {
            System.out.println("User " + target.getName() + " tidak sedang di-mute.");
        }
    }

    public boolean isMuted(User user) {
        return mutedUsers.contains(user);
    }

    public void showHistory() {
        System.out.println("Riwayat Chat " + roomName);
        for (String history : chatHistory) {
            System.out.println(history);
        }
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
