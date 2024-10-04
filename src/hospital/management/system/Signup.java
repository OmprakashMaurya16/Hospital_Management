package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener {

    JLabel name, gender, username, password;
    JTextField nametext, user;
    JPasswordField pass; 
    JButton signup, back;
    JComboBox<String> genderChoice;

    public Signup() {
        JPanel panel = new JPanel();
        panel.setBounds(400, 20, 320, 330);
        panel.setLayout(null);
        panel.setBackground(new Color(240, 248, 255));
        add(panel);

        name = new JLabel("Name");
        name.setBounds(20, 20, 100, 30);
        name.setFont(new Font("Segoe UI", Font.BOLD, 16));
        panel.add(name);

        nametext = new JTextField();
        nametext.setBounds(130, 20, 150, 30);
        panel.add(nametext);

        gender = new JLabel("Gender");
        gender.setBounds(20, 80, 100, 30);
        gender.setFont(new Font("Segoe UI", Font.BOLD, 16));
        panel.add(gender);

        genderChoice = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        genderChoice.setBounds(130, 80, 150, 30);
        genderChoice.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(genderChoice);

        username = new JLabel("Username");
        username.setBounds(20, 140, 100, 30);
        username.setFont(new Font("Segoe UI", Font.BOLD, 16));
        panel.add(username);

        user = new JTextField();
        user.setBounds(130, 140, 150, 30);
        panel.add(user);

        password = new JLabel("Password");
        password.setBounds(20, 200, 100, 30);
        password.setFont(new Font("Segoe UI", Font.BOLD, 16));
        panel.add(password);

        pass = new JPasswordField(); 
        pass.setBounds(130, 200, 150, 30);
        panel.add(pass);

        signup = new JButton("Sign Up");
        signup.setBounds(40, 270, 110, 35);
        signup.setFont(new Font("Segoe UI", Font.BOLD, 14));
        signup.setForeground(Color.WHITE);
        signup.setBackground(new Color(34, 139, 34));
        signup.setFocusPainted(false);
        signup.setBorderPainted(false);
        signup.addActionListener(this);
        panel.add(signup);

        back = new JButton("Back");
        back.setBounds(170, 270, 110, 35);
        back.setFont(new Font("Segoe UI", Font.BOLD, 14));
        back.setForeground(Color.WHITE);
        back.setBackground(new Color(255, 69, 58));
        back.setFocusPainted(false);
        back.setBorderPainted(false);
        back.addActionListener(this);
        panel.add(back);

        ImageIcon signupIcon = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i1 = signupIcon.getImage().getScaledInstance(350, 400, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i1);
        JLabel label = new JLabel(image);
        label.setBounds(0, 5, 350, 350);
        add(label);

        getContentPane().setBackground(new Color(217,242,239,255));
        setSize(750, 400);
        setLocation(450, 150);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new Login();
            setVisible(false);
        }
        if (e.getSource() == signup) {
            String name1 = nametext.getText();
            String gender1 = genderChoice.getSelectedItem().toString();
            String user1 = user.getText();
            String pass1 = new String(pass.getPassword());

            try {
                conn c = new conn();
                String query = "INSERT INTO signup (ID_Name, Gender, ID, PW) VALUES ('" + name1 + "', '" + gender1 + "', '" + user1 + "', '" + pass1 + "')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Signup Successful!");
                new Login();
                setVisible(false);
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
