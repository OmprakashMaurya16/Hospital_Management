package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project extends JFrame implements ActionListener {

    JLabel welcome, welcome2, welcome1;
    JPanel panel1, panel2;
    JButton b1, b2, b3, b4, b5, b6, b7, b8;
    Splash splash;
    private JFrame currentWindow;

    Project() {
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(300, 0, 1400, 900);
        panel1.setBackground(Color.WHITE);
        add(panel1);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(0, 0, 300, 900);
        panel2.setBackground(new Color(34, 45, 50));
        add(panel2);

        splash = new Splash();
        splash.setBounds(0, 0, 1300, 900);
        panel1.add(splash);

        welcome = new JLabel("Welcome TO");
        welcome.setBounds(75, 20, 200, 40);
        welcome.setFont(new Font("Segoe UI", Font.BOLD, 18));
        welcome.setForeground(Color.WHITE);
        panel2.add(welcome);

        welcome2 = new JLabel("Hospital Management");
        welcome2.setBounds(30, 50, 250, 40);
        welcome2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        welcome2.setForeground(Color.WHITE);
        panel2.add(welcome2);

        welcome1 = new JLabel("System");
        welcome1.setBounds(90, 80, 200, 40);
        welcome1.setFont(new Font("Segoe UI", Font.BOLD, 18));
        welcome1.setForeground(Color.WHITE);
        panel2.add(welcome1);

        b1 = createButton("Add Patient", 150);
        panel2.add(b1);

        b2 = createButton("Patient Info", 220);
        panel2.add(b2);

        b3 = createButton("Update Details", 290);
        panel2.add(b3);

        b4 = createButton("Book Appointment", 360);
        panel2.add(b4);

        b5 = createButton("View Appointment", 430);
        panel2.add(b5);

        b6 = createButton("View Doctor", 500);
        panel2.add(b6);

        b7 = createButton("Room", 570);
        panel2.add(b7);

        b8 = createButton("Log Out", 640);
        panel2.add(b8);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JButton createButton(String text, int yPos) {
        JButton button = new JButton(text);
        button.setBounds(20, yPos, 260, 45);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setForeground(Color.BLACK);
        button.setBackground(new Color(173, 216, 230));
        button.setFocusPainted(false);
        button.addActionListener(this);
        return button;
    }

    public static void main(String args[]) {
        new Project();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (currentWindow != null) {
            currentWindow.dispose();
        }
        if (e.getSource() == b1) {
            currentWindow = new New_Patient();
        } else if (e.getSource() == b2) {
            currentWindow = new Patient_Info();
        } else if (e.getSource() == b3) {
            currentWindow = new Update();
        } else if (e.getSource() == b4) {
            new Appointment();
        } else if (e.getSource() == b5) {
            currentWindow = new View_Appointment();
        } else if (e.getSource() == b6) {
            currentWindow = new Doctor();
        } else if (e.getSource() == b7) {
            currentWindow = new Room();
        } else if (e.getSource() == b8) {
            setVisible(false);
            new Login();
        }
    }
}
