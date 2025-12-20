package ui;
import javax.swing.*;
import java.awt.*;

public class Dashboard {
    public Dashboard(boolean isAdmin) {
        JFrame frame = new JFrame(isAdmin ? "Admin Dashboard" : "User Dashboard");
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // Header
        JLabel welcome = new JLabel("Welcome " + (isAdmin ? "Administrator" : "User"), SwingConstants.CENTER);
        welcome.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(welcome, BorderLayout.NORTH);

        // Center Content: User List
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String u : Main.userList) { listModel.addElement(u); }
        JList<String> displayList = new JList<>(listModel);
        frame.add(new JScrollPane(displayList), BorderLayout.CENTER);

        // Sidebar / Admin Panel
        if (isAdmin) {
            JPanel adminPanel = new JPanel();
            adminPanel.setLayout(new BoxLayout(adminPanel, BoxLayout.Y_AXIS));
            adminPanel.setBackground(Color.LIGHT_GRAY);

            JTextField newUserField = new JTextField();
            JButton addBtn = new JButton("Add User");

            addBtn.addActionListener(e -> {
                String name = newUserField.getText();
                if(!name.isEmpty()) {
                    Main.userList.add(name);
                    listModel.addElement(name);
                    newUserField.setText("");
                }
            });

            adminPanel.add(new JLabel("Admin Actions:"));
            adminPanel.add(newUserField);
            adminPanel.add(addBtn);
            frame.add(adminPanel, BorderLayout.EAST);
        }

        frame.setVisible(true);
    }
}