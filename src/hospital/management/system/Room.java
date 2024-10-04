package hospital.management.system;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class Room extends JFrame {
    JTable table;

    public Room() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 600, 450);
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);
        add(panel);

        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table.setBackground(new Color(240, 248, 255));
        table.setRowHeight(30);
        table.setFillsViewportHeight(true);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 70, 650, 350);
        panel.add(scrollPane);

        try {
            conn c = new conn();
            String q = "SELECT room_no AS 'Room No', availability AS 'Availability', price AS 'Price', room_type AS 'Room Type' FROM room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel l1 = new JLabel("Room Information");
        l1.setBounds(20, 30, 200, 20);
        l1.setFont(new Font("Tahoma", Font.BOLD, 16));
        l1.setForeground(new Color(0, 51, 102));
        panel.add(l1);

        setUndecorated(true);
        setSize(670, 450);
        setLocation(400, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Room();
    }
}
