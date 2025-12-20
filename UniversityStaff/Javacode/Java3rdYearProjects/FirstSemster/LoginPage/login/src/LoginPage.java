import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage {
    public LoginPage() {
        JFrame frame = new JFrame("Login Page");
        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 1. Username Field
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 100, 100, 30);
        frame.add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(150, 100, 150, 30);
        frame.add(userField);

        // 2. Password Field (shows dots instead of letters)
        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 150, 100, 30);
        frame.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(150, 150, 150, 30);
        frame.add(passField);

        // 3. Login Button
        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(150, 220, 100, 40);
        loginBtn.setBackground(new Color(0, 102, 204));
        loginBtn.setForeground(Color.WHITE);
        frame.add(loginBtn);

        // 4. "Go to Register" Button (The Navigation)
        JButton goToRegister = new JButton("Don't have an account? Register");
        goToRegister.setBounds(50, 300, 300, 30);
        goToRegister.setBorderPainted(false);
        goToRegister.setContentAreaFilled(false);
        goToRegister.setForeground(Color.BLUE); // Make it look like a link
        frame.add(goToRegister);

        // THE LOGIC: What happens when you click "Register"
        goToRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();      // 1. Close the Login window
                new RegisterPage();   // 2. Open the RegisterPage
            }
        });

        frame.setVisible(true);
    }
}