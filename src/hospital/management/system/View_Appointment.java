
package hospital.management.system;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;


public class View_Appointment extends JFrame{
         JTable table;
     View_Appointment(){
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 800, 500);
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);
        add(panel);
        
        JLabel titleLabel = new JLabel("View Appointment");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
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
            String q = "select * from appointments";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }
         
         setUndecorated(true);
         setSize(800, 500);
       setLocation(400, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
        
    
    public static void main(String[] args) {
        new View_Appointment();
    }
}
