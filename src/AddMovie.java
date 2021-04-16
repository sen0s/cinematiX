import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddMovie {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Insert Movie");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLocation(300,200);
        JPanel panel = (JPanel) frame.getContentPane();
        panel.setLayout(null);

        JLabel label1 = new JLabel("Movie Insert");
        label1.setFont(new Font("Tahoma", Font.BOLD, 23));
        panel.add(label1);
        Dimension size1 = label1.getPreferredSize();
        label1.setBounds(100, 20, size1.width, size1.height);

        JLabel label2 = new JLabel("Movie's name: ");
        panel.add(label2);
        Dimension size2 = label2.getPreferredSize();
        label2.setBounds(40, 90, size2.width, size2.height);

        JLabel label3 = new JLabel("type of movie: ");
        panel.add(label3);
        Dimension size3 = label3.getPreferredSize();
        label3.setBounds(40, 130, size3.width, size3.height);

        JLabel label4 = new JLabel("duration: ");
        panel.add(label4);
        Dimension size4 = label4.getPreferredSize();
        label4.setBounds(67, 165, size4.width, size4.height);

        JTextField tf1 = new JTextField();
        tf1.setLocation(150, 88);
        tf1.setSize(150, 25);
        panel.add(tf1);

        JTextField tf2 = new JTextField();
        tf2.setLocation(150, 160);
        tf2.setSize(150, 25);
        panel.add(tf2);

        JComboBox comboBox = new JComboBox();
        comboBox.setLocation(150, 125);
        comboBox.setSize(150, 25);
        panel.add(comboBox);

        JButton button1 = new JButton("Insert Movie");
        button1.setLocation(150, 200);
        button1.setSize(150,25);
        panel.add(button1);

        JButton button2 = new JButton("back");
        button2.setLocation(10, 300);
        button2.setSize(80,25);
        panel.add(button2);

        JButton button3 = new JButton("Exit");
        button3.setLocation(310, 300);
        button3.setSize(80,25);
        panel.add(button3);


        frame.setVisible(true);

    }

}

