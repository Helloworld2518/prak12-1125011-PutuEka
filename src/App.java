import model.User;

public class App {
    public static void main(String[] args) throws Exception {
        User sendTest = new User("Putu Eka");
        User receiveTest = new User("Rini");

        sendTest.sendMessage(receiveTest, "Testing Boss");
        receiveTest.receiveMessage(sendTest, "Testing 2 Boss");

        sendTest.addContact(receiveTest, sendTest);
        receiveTest.sendGropuMessage("Test");
    }
}
