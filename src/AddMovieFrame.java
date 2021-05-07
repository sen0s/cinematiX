import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class AddMovieFrame extends JInternalFrame {

    JButton buttonInsert;
    JButton buttonExit;
    JButton buttonBack;
    JTextField tfTitle;
    JTextField tfDuration;
    JComboBox comboBox;

    private Movie newMovie;
    private ArrayList<Movie> movies = new ArrayList<>();
    private JInternalFrame frame = this;

   /* public static void main(String[] args) {
        new AddMovie();

    }*/

    public AddMovieFrame() {

        newMovie = new Movie();

        JFrame frame = new JFrame("Insert Movie");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLocation(300, 200);
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

        tfTitle = new JTextField();
        tfTitle.setLocation(150, 88);
        tfTitle.setSize(150, 25);
        panel.add(tfTitle);

        tfDuration = new JTextField();
        tfDuration.setLocation(150, 160);
        tfDuration.setSize(150, 25);
        panel.add(tfDuration);

        String[] genres =  {"Action","Comedy","Drama","Fantasy","Horror","Mystery","Romance","Thriller"};
        comboBox = new JComboBox(genres);
        comboBox.setLocation(150, 125);
        comboBox.setSize(150, 25);
        panel.add(comboBox);

        buttonInsert = new JButton("Insert Movie");
        buttonInsert.setLocation(150, 200);
        buttonInsert.setSize(150, 25);
        panel.add(buttonInsert);

        buttonExit = new JButton("Exit");
        buttonExit.setLocation(310, 300);
        buttonExit.setSize(80, 25);
        panel.add(buttonExit);

        buttonBack = new JButton("back");
        buttonBack.setLocation(10, 300);
        buttonBack.setSize(80, 25);
        panel.add(buttonBack);

        buttonInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    String title, duration, genre;

                    title = tfTitle.getText();
                    duration = tfDuration.getText();
                    genre = (String) comboBox.getSelectedItem();
                    newMovie = new Movie(title,duration,genre);
                    movies.add(newMovie);

                    JOptionPane.showMessageDialog(null, "Movie inserted Successfully");

                    tfTitle.setText("");
                    tfDuration.setText("");


                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1);
                }
            }
        });

        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent f) {
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }



}

