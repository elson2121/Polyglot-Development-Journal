package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage {
    // We define the frame at the class level so the logic can "see" it to close it
    private JFrame frame;

    public LoginPage() {
        // 1. Create the Window (The Container)
        frame = new JFrame("Login - Notification System");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Absolute positioning (Like 'position: absolute')
        frame.getContentPane().setBackground(new Color(245, 245, 245));

        // 2. Title Label
        JLabel title = new JLabel("Login", SwingConstants.CENTER);
        title.setBounds(100, 30, 200, 40);
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setForeground(new Color(44, 62, 80));
        frame.add(title);

        // 3. Username Input
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 100, 100, 30);
        frame.add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(50, 130, 280, 35);
        userField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        frame.add(userField);

        // 4. Password Input
        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 180, 100, 30);
        frame.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(50, 210, 280, 35);
        passField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        frame.add(passField);

        // 5. Login Button (The Logic Trigger)
        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(50, 280, 280, 45);
        loginBtn.setBackground(new Color(52, 152, 219)); // Blue color
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFont(new Font("Arial", Font.BOLD, 16));
        loginBtn.setFocusable(false);
        frame.add(loginBtn);

        // 6. Register Redirect Button
        JButton registerBtn = new JButton("Don't have an account? Register");
        registerBtn.setBounds(50, 340, 280, 30);
        registerBtn.setForeground(Color.GRAY);
        registerBtn.setBorderPainted(false);
        registerBtn.setContentAreaFilled(false);
        frame.add(registerBtn);

        // --- THE LOGIC PART ---

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String typedUser = userField.getText();
                String typedPass = new String(passField.getPassword());

                // Check for Admin Credentials
                if (typedUser.equals("admin") && typedPass.equals("ela12")) {
                    JOptionPane.showMessageDialog(frame, "Admin Login Success!");
                    frame.dispose(); // Close login window
                    new Dashboard(true); // Open dashboard as Admin
                }
                // Check if the user exists in our list (from Main)
                else {
                    // This is a simple fallback for now
                    JOptionPane.showMessageDialog(frame, "Invalid Credentials", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        registerBtn.addActionListener(e -> {
            frame.dispose();
            new RegisterPage(); // Moves to RegisterPage component
        });

        // Make it visible at the end
        frame.setLocationRelativeTo(null); // Center the window on screen
        frame.setVisible(true);
    }
}