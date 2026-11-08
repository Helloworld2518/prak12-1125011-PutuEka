import model.ChatRoom;
import model.User;

public class App {
    public static void main(String[] args) throws Exception {
        User sendTest = new User("Putu Eka");
        User receiveTest = new User("Rini");

        // sendTest.sendMessage(receiveTest, "Testing Boss");
        // receiveTest.receiveMessage(sendTest, "Testing 2 Boss");

        // sendTest.addContact(receiveTest);
        // receiveTest.sendGropuMessage("Test");

        // ChatRoom roomChat = new ChatRoom("Eka Room");
        // sendTest.setChatRoom(roomChat);
        // receiveTest.setChatRoom(roomChat);

        // roomChat.sendBroadcast(sendTest, "Test BroadCast");
        // sendTest.sendPrivate(receiveTest, "rahasia Bosss");

        // roomChat.addBadWord("jelek");
        // roomChat.sendBroadcast(sendTest, "JELEK");

        User ayah = new User("Ayah");
        User ibu = new User ("ibu");
        User eka = new User("eka");

        ChatRoom general = new ChatRoom("General");
        ChatRoom Sports = new ChatRoom("Sports");
        ayah.setChatRoom(Sports);
        ayah.setChatRoom(general);
        ibu.setChatRoom(Sports);
        ibu.setChatRoom(general);
        eka.setChatRoom(Sports);
        eka.setChatRoom(general);

        Sports.addBadWord("Ronaldo is Goat");
        general.addBadWord("jelek bos");

        general.removeUser(ibu, ayah);
    }
}
