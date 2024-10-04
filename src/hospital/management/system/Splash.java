package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash extends JPanel {
    private JLabel label;
    private int fontSize = 12;
    private Timer timer;

    public Splash() {
        setLayout(new BorderLayout());
        label = new JLabel("Welcome To Hospital Management System");
        label.setFont(new Font("Arial", Font.BOLD, fontSize));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(new Color(0, 51, 102));
        add(label, BorderLayout.CENTER);

        setPreferredSize(new Dimension(1300, 900));
        setBackground(Color.WHITE);

        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fontSize += 2;
                label.setFont(new Font("Arial", Font.BOLD, fontSize));

                if (fontSize >= 48) {
                    timer.stop();
                    showImage();
                }
            }
        });

        timer.start();
    }

    private void showImage() {
        ImageIcon imageicon = new ImageIcon(getClass().getResource("/icon/splash.jpg"));
        Image image = imageicon.getImage().getScaledInstance(1300, 900, Image.SCALE_DEFAULT);
        ImageIcon imageicone1 = new ImageIcon(image);
        
        JLabel imageLabel = new JLabel(imageicone1);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(imageLabel, BorderLayout.CENTER);

        remove(label);
        revalidate();
        repaint();
    }
}
