package hospital.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    JLabel username, password;
    JTextField user;
    JPasswordField pass; 
    JButton login, cancel, signup;

    Login() {
        JPanel panel = new JPanel();
        panel.setBounds(50, 30, 300, 300);
        panel.setLayout(null);
        panel.setBackground(new Color(240, 248, 255));
        add(panel);

        username = new JLabel("Username");
        username.setBounds(20, 30, 100, 30);
        username.setFont(new Font("Segoe UI", Font.BOLD, 16));
        username.setForeground(Color.BLACK);
        panel.add(username);

        user = new JTextField();
        user.setBounds(130, 30, 150, 30);
        user.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(user);

        password = new JLabel("Password");
        password.setBounds(20, 90, 100, 30);
        password.setFont(new Font("Segoe UI", Font.BOLD, 16));
        password.setForeground(Color.BLACK);
        panel.add(password);

        pass = new JPasswordField();
        pass.setBounds(130, 90, 150, 30);
        panel.add(pass);

        login = new JButton("Login");
        login.setBounds(20, 160, 120, 35);
        login.setFont(new Font("Segoe UI", Font.BOLD, 14));
        login.setForeground(Color.WHITE);
        login.setBackground(new Color(51, 153, 255));
        login.setFocusPainted(false);
        login.setBorderPainted(false);
        login.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        login.addActionListener(this);
        panel.add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(160, 160, 120, 35);
        cancel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(new Color(255, 77, 77));
        cancel.setFocusPainted(false);
        cancel.setBorderPainted(false);
        cancel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        cancel.addActionListener(this);
        panel.add(cancel);
        
        signup = new JButton("Signup");
        signup.setBounds(90, 220, 120, 35);
        signup.setFont(new Font("Segoe UI", Font.BOLD, 14));
        signup.setForeground(Color.WHITE);
        signup.setBackground(new Color(153, 255, 153));
        signup.setFocusPainted(false);
        signup.setBorderPainted(false);
        signup.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        signup.addActionListener(this);
        panel.add(signup);

        ImageIcon loginIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image image1 = loginIcon.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon(image1);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(380, 50, 250, 250);
        add(label);

        getContentPane().setBackground(new Color(224, 255, 255));
        setSize(700, 400);
        setLocation(400, 200);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login) {
            try {
                conn c = new conn();
                String user1 = user.getText();
                String pass1 = new String(pass.getPassword());

                String q = "select * from signup where ID ='" + user1 + "' and pw ='" + pass1 + "'";
                ResultSet result = c.statement.executeQuery(q);

                if (result.next()) {
                    new Project();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }

            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }
        if (e.getSource() == signup) {
               new Signup();
               setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
