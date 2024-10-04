package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class New_Patient extends JFrame implements ActionListener {

    JComboBox<String> idTypeComboBox;
    JTextField numberField, nameField, diseaseField, depositField;
    JRadioButton maleRadioButton, femaleRadioButton;
    JLabel dateLabel;
    JButton addButton, backButton;

    New_Patient() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(225, 245, 254);
                Color color2 = new Color(195, 233, 236);
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setBounds(5, 5, 840, 540);
        panel.setLayout(null);
        add(panel);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
        Image image = icon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        JLabel label = new JLabel(new ImageIcon(image));
        label.setBounds(500, 80, 300, 300);
        panel.add(label);

        JLabel titleLabel = new JLabel("NEW PATIENT FORM");
        titleLabel.setBounds(118, 11, 260, 53);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        titleLabel.setForeground(Color.BLACK);
        panel.add(titleLabel);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(40, 90, 200, 15);
        idLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        idLabel.setForeground(Color.GRAY);
        panel.add(idLabel);

        idTypeComboBox = new JComboBox<>(new String[]{"Aadhar Card", "Voter Id", "Driving License"});
        idTypeComboBox.setBounds(180, 85, 200, 25);
        idTypeComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
        panel.add(idTypeComboBox);

        JLabel numberLabel = new JLabel("Number:");
        numberLabel.setBounds(40, 135, 250, 25);
        numberLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        numberLabel.setForeground(Color.GRAY);
        panel.add(numberLabel);

        numberField = new JTextField();
        numberField.setBounds(180, 130, 200, 25);
        panel.add(numberField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(40, 175, 200, 15);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        nameLabel.setForeground(Color.GRAY);
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(180, 170, 200, 25);
        panel.add(nameField);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(40, 215, 200, 15);
        genderLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        genderLabel.setForeground(Color.GRAY);
        panel.add(genderLabel);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        maleRadioButton.setForeground(Color.GRAY);
        maleRadioButton.setBounds(180, 215, 70, 15);
        maleRadioButton.setBackground(new Color(195, 233, 236));
        panel.add(maleRadioButton);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        femaleRadioButton.setForeground(Color.GRAY);
        femaleRadioButton.setBounds(260, 215, 100, 15);
        femaleRadioButton.setBackground(new Color(195, 233, 236));
        panel.add(femaleRadioButton);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        JLabel diseaseLabel = new JLabel("Disease:");
        diseaseLabel.setBounds(40, 255, 200, 15);
        diseaseLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        diseaseLabel.setForeground(Color.GRAY);
        panel.add(diseaseLabel);

        diseaseField = new JTextField();
        diseaseField.setBounds(180, 250, 200, 25);
        panel.add(diseaseField);

        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(40, 295, 200, 15);
        dateLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        dateLabel.setForeground(Color.GRAY);
        panel.add(dateLabel);

        Date date1 = new Date();
        this.dateLabel = new JLabel(" " + date1);
        this.dateLabel.setBounds(180, 295, 300, 15);
        this.dateLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        this.dateLabel.setForeground(Color.BLACK);
        panel.add(this.dateLabel);

        JLabel depositLabel = new JLabel("Deposit:");
        depositLabel.setBounds(40, 335, 200, 15);
        depositLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        depositLabel.setForeground(Color.GRAY);
        panel.add(depositLabel);

        depositField = new JTextField();
        depositField.setBounds(180, 330, 200, 25);
        panel.add(depositField);

        addButton = new JButton("ADD");
        addButton.setBounds(80, 390, 130, 30);
        addButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        addButton.setForeground(Color.WHITE);
        addButton.setBackground(new Color(76, 175, 80));
        addButton.setBorderPainted(false);
        addButton.addActionListener(this);
        panel.add(addButton);

        backButton = new JButton("Back");
        backButton.setBounds(280, 390, 130, 30);
        backButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(255, 87, 34));
        backButton.setBorderPainted(false);
        backButton.addActionListener(this);
        panel.add(backButton);

        setUndecorated(true);
        setSize(850, 500);
        setLocation(400, 100);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new New_Patient();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            conn c = new conn();
            String radioBtn = null;
            if (maleRadioButton.isSelected()) {
                radioBtn = "Male";
            } else if (femaleRadioButton.isSelected()) {
                radioBtn = "Female";
            }
            String idType = (String) idTypeComboBox.getSelectedItem();
            String number = numberField.getText();
            String name = nameField.getText();
            String gender = radioBtn;
            String disease = diseaseField.getText();
            String date = this.dateLabel.getText();
            String deposit = depositField.getText();

            try {
                String q = "INSERT INTO patient_info (ID, Number, Name, Gender, Patient_Disease, Time ,Deposite) " +
        "VALUES ('" + idType + "', '" + number + "', '" + name + "', '" + gender + "', '" + disease + "', '" + date + "','"+ deposit+"')";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Patient Added Successfully!");
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
}
