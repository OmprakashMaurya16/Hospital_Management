package hospital.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class Update extends JFrame implements ActionListener {

    JLabel label1, label2, label3, label4, label5, label6;
    JTextField t1, t2, t3, t4;
    JButton b1, update;
    JComboBox<String> choice;

    public Update() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 765, 450);
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
        Image image = imageicon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(450, 40, 300, 300);
        panel.add(label);

        label1 = new JLabel("Update Patient Details");
        label1.setBounds(150, 20, 300, 30);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(new Color(0, 51, 102));
        panel.add(label1);

        label2 = new JLabel("Select Name:");
        label2.setBounds(25, 90, 120, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);

        choice = new JComboBox<>();
        choice.setBounds(180, 90, 200, 25);
        panel.add(choice);

        try {
            conn c = new conn();
            String q = "select * from patient_info";
            ResultSet resultSet = c.statement.executeQuery(q);
            while (resultSet.next()) {
                choice.addItem(resultSet.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        label3 = new JLabel("Number:");
        label3.setBounds(25, 130, 150, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label3);

        t1 = new JTextField();
        t1.setBounds(180, 130, 200, 25);
        panel.add(t1);

        label4 = new JLabel("IN Time:");
        label4.setBounds(25, 170, 150, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label4);

        t2 = new JTextField();
        t2.setBounds(180, 170, 200, 25);
        panel.add(t2);

        label5 = new JLabel("Amount Paid:");
        label5.setBounds(25, 210, 150, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label5);

        t3 = new JTextField();
        t3.setBounds(180, 210, 200, 25);
        panel.add(t3);

        label6 = new JLabel("Amount Pending:");
        label6.setBounds(25, 250, 150, 20);
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label6);

        t4 = new JTextField();
        t4.setBounds(180, 250, 200, 25);
        t4.setEditable(false);
        panel.add(t4);

        b1 = new JButton("CHECK");
        b1.setBounds(80, 300, 150, 30);
        b1.setFont(new Font("Tahoma", Font.BOLD, 16));
        b1.setBackground(new Color(0, 153, 204));
        b1.setForeground(Color.WHITE);
        panel.add(b1);
        b1.addActionListener(this);

        update = new JButton("UPDATE");
        update.setBounds(300, 300, 150, 30);
        update.setFont(new Font("Tahoma", Font.BOLD, 16));
        update.setBackground(new Color(0, 153, 204));
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(this);
        
        
        setUndecorated(true);
        setSize(775, 450);
        setLayout(null);
        setLocation(400, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Update();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String id = (String) choice.getSelectedItem();
            String q = "Select * from patient_info where Name = '" + id + "'";
            try {
                conn c = new conn();
                ResultSet resultSet = c.statement.executeQuery(q);
                while (resultSet.next()) {
                    t1.setText(resultSet.getString("Number"));
                    t2.setText(resultSet.getString("Time"));
                    t3.setText(resultSet.getString("Deposite"));
                }

                ResultSet resultSet1 = c.statement.executeQuery("select * from patient_info where Number ='" + t1.getText() + "'");
                while (resultSet1.next()) {
                    int amountPaid = 10000 - Integer.parseInt(t3.getText());
                    t4.setText(String.valueOf(Math.max(amountPaid, 0)));
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == update) {
            try {
                conn c = new conn();
                String name = (String) choice.getSelectedItem();
                String time = t2.getText();
                String amountPaid = t3.getText();

                String q = "UPDATE patient_info SET Time = '" + time + "', Deposite = '" + amountPaid + "' WHERE Name = '" + name + "'";
                c.statement.executeUpdate(q);

                JOptionPane.showMessageDialog(null, "Updated Successfully");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
