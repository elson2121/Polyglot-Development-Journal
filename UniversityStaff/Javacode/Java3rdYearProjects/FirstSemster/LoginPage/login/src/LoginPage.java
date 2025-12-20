import javax.swing.*; // Importing UI components

public class LoginPage {
    // This is the "constructor" - it runs when you call 'new LoginPage()'
    public LoginPage() {
        JFrame frame = new JFrame("Login Page");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Manual positioning

        JLabel label = new JLabel("Username:");
        label.setBounds(20, 20, 80, 25);
        frame.add(label);

        JTextField userText = new JTextField();
        userText.setBounds(100, 20, 160, 25);
        frame.add(userText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 80, 80, 25);
        frame.add(loginButton);

        frame.setVisible(true); // This makes the window pop up
    }
}