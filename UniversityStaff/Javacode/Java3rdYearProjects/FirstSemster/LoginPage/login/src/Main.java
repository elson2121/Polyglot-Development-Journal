import ui.LoginPage;
import java.util.ArrayList;

public class Main {
    // This acts like a global "Database" in memory
    public static ArrayList<String> userList = new ArrayList<>();

    public static void main(String[] args) {
        // Pre-fill with one user
        userList.add("John Doe");

        new LoginPage();
    }
}