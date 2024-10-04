package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Appointment {

    private static final String URL = "jdbc:mysql://localhost:3306/hospital_management_system";
    private static final String USER = "root";
    private static final String PASSWORD = "Maurya@2005";

    public Appointment() {
        createBookAppointmentUI();
    }

    private void createBookAppointmentUI() {
        JFrame frame = new JFrame("Book Appointment");
        JPanel bookAppointmentPanel = new JPanel();
        bookAppointmentPanel.setLayout(new GridBagLayout());
        bookAppointmentPanel.setBackground(new Color(240, 248, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Book Appointment");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(70, 130, 180));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        bookAppointmentPanel.add(titleLabel, gbc);

        JLabel patientIdLabel = new JLabel("Enter Patient ID:");
        JLabel doctorIdLabel = new JLabel("Enter Doctor ID:");
        JLabel appointmentDateLabel = new JLabel("Enter Appointment Date (YYYY-MM-DD):");

        JTextField patientIdField = new JTextField(15);
        JTextField doctorIdField = new JTextField(15);
        JTextField appointmentDateField = new JTextField(15);

        JButton submitBookApp = new JButton("Submit");
        submitBookApp.setBackground(new Color(70, 130, 180));
        submitBookApp.setForeground(Color.WHITE);
        submitBookApp.setFont(new Font("Arial", Font.BOLD, 14));

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 1;
        bookAppointmentPanel.add(patientIdLabel, gbc);
        gbc.gridx = 1;
        bookAppointmentPanel.add(patientIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        bookAppointmentPanel.add(doctorIdLabel, gbc);
        gbc.gridx = 1;
        bookAppointmentPanel.add(doctorIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        bookAppointmentPanel.add(appointmentDateLabel, gbc);
        gbc.gridx = 1;
        bookAppointmentPanel.add(appointmentDateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        bookAppointmentPanel.add(submitBookApp, gbc);

        JLabel imageLabel = new JLabel(new ImageIcon(getClass().getResource("/icon/appointment.png")));
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 5;
        bookAppointmentPanel.add(imageLabel, gbc);
        
        frame.setUndecorated(true);
        frame.add(bookAppointmentPanel);
        frame.setSize(1000, 500);
        frame. setLocation(400, 100);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        submitBookApp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patientIdText = patientIdField.getText();
                String doctorIdText = doctorIdField.getText();
                String appointmentDateInput = appointmentDateField.getText();

                if (patientIdText.isEmpty() || doctorIdText.isEmpty() || appointmentDateInput.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "All fields must be filled out.");
                    return;
                }

                try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                    String patientId = patientIdText;
                    int doctorId = Integer.parseInt(doctorIdText);

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                    dateFormat.setLenient(false);
                    Date appointmentDate = dateFormat.parse(appointmentDateInput);
                    String insertQuery = "INSERT INTO appointments (patient_id, doctor_id, appointment_date) VALUES (?, ?, ?)";

                    try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                        preparedStatement.setString(1, patientId);
                        preparedStatement.setInt(2, doctorId);
                        preparedStatement.setString(3, dateFormat.format(appointmentDate));

                        preparedStatement.executeUpdate();
                        JOptionPane.showMessageDialog(frame, "Appointment booked successfully!");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid Patient or Doctor ID. Please enter numeric values.");
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid date format. Please enter date as YYYY-MM-DD.");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Database error: " + ex.getMessage());
                    ex.printStackTrace();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error while booking appointment: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });
    }
}
