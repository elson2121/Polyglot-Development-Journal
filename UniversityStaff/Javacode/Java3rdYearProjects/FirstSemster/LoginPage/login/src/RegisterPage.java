import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPage {
    public RegisterPage() {
        // Create the window
        JFrame frame = new JFrame("Register Account");
        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(245, 245, 245));

        // Title
        JLabel title = new JLabel("Create Account");
        title.setBounds(100, 20, 200, 40);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        frame.add(title);

        // 1. Full Name Field
        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setBounds(50, 80, 100, 30);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 80, 180, 30);
        frame.add(nameField);

        // 2. Email Field
        JLabel emailLabel = new JLabel("Email Address:");
        emailLabel.setBounds(50, 130, 100, 30);
        frame.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(150, 130, 180, 30);
        frame.add(emailField);

        // 3. Password Field
        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 180, 100, 30);
        frame.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(150, 180, 180, 30);
        frame.add(passField);

        // 4. Register Button
        JButton registerBtn = new JButton("Register Now");
        registerBtn.setBounds(100, 250, 200, 40);
        registerBtn.setBackground(new Color(46, 204, 113)); // Emerald Green
        registerBtn.setForeground(Color.WHITE);
        registerBtn.setFocusable(false);
        frame.add(registerBtn);

        // 5. Back to Login Link
        JButton backToLogin = new JButton("Already have an account? Login");
        backToLogin.setBounds(50, 310, 300, 30);
        backToLogin.setForeground(Color.BLUE);
        backToLogin.setBorderPainted(false);
        backToLogin.setContentAreaFilled(false);
        frame.add(backToLogin);

        // Logic to switch back to Login
        backToLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close register window
                new LoginPage(); // Open login window
            }
        });

        frame.setVisible(true);
    }
}