package hospital.management.system;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class Patient_Info extends JFrame {

    JTable table;

    public Patient_Info() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 1000, 600);
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);
        add(panel);

        JLabel titleLabel = new JLabel("Patient Information");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(51, 51, 51));
        titleLabel.setBounds(300, 10, 300, 30);
        panel.add(titleLabel);

        table = new JTable();
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(30);
        table.setGridColor(new Color(220, 220, 220));
        table.setSelectionBackground(new Color(173, 216, 230));
        table.setSelectionForeground(new Color(0, 0, 0));

        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font("Segoe UI", Font.BOLD, 16));
        tableHeader.setBackground(new Color(0, 123, 255));
        tableHeader.setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 50, 780, 400);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        panel.add(scrollPane);

        try {
            conn c = new conn();
            String q = "select * from patient_info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        setUndecorated(true);
        setSize(800, 600);
        setLocation(400, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    public static void main(String[] args) {
        new Patient_Info();
    }
}
