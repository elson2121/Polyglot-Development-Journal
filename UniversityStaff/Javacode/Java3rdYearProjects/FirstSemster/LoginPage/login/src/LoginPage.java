import javax.swing.*;
import java.awt.*; // You MUST import this for Colors and Fonts

public class LoginPage {
    public LoginPage() {
        JFrame frame = new JFrame("Login");
        frame.setSize(400, 500);
        frame.setLayout(null);

        // CSS: .background { background-color: #f0f0f0; }
        frame.getContentPane().setBackground(new Color(240, 240, 240));

        // Create a Label
        JLabel title = new JLabel("Login Here");
        title.setBounds(100, 30, 200, 40);

        // CSS: .title { font-size: 24px; font-weight: bold; color: #333; }
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(new Color(51, 51, 51));
        frame.add(title);

        // Create a Styled Button
        JButton loginBtn = new JButton("Submit");
        loginBtn.setBounds(100, 150, 150, 40);

        // CSS: .button { background-color: blue; color: white; border-radius: 5px; }
        loginBtn.setBackground(new Color(0, 102, 204));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFocusable(false); // Removes the ugly dotted line around text
        loginBtn.setBorder(BorderFactory.createEmptyBorder()); // CSS: border: none;

        frame.add(loginBtn);
        frame.setVisible(true);

    }
}