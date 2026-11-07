import model.ChatRoom;
import model.User;

public class App {
    public static void main(String[] args) throws Exception {
        User sendTest = new User("Putu Eka");
        User receiveTest = new User("Rini");

        sendTest.sendMessage(receiveTest, "Testing Boss");
        receiveTest.receiveMessage(sendTest, "Testing 2 Boss");

        // sendTest.addContact(receiveTest);
        // receiveTest.sendGropuMessage("Test");

        ChatRoom roomChat = new ChatRoom("Eka Room");
        sendTest.setChatRoom(roomChat);
        receiveTest.setChatRoom(roomChat);

        roomChat.sendBroadcast(sendTest, "Test BroadCast");
        sendTest.sendPrivate(receiveTest, "rahasia Bosss");

        roomChat.addBadWord("jelek");
        roomChat.sendBroadcast(sendTest, "JELEK");

        
    }
}
