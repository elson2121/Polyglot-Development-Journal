import javax.swing.*;

public class RegisterPage {
    public RegisterPage() {
        JFrame frame = new JFrame("Register Page");
        frame.setSize(300, 250);
        frame.setLayout(null);

        JLabel label = new JLabel("Create Account");
        label.setBounds(100, 10, 150, 25);
        frame.add(label);

        // Add your buttons and fields here similarly...

        frame.setVisible(true);
    }
}