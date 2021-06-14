import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import java.util.ArrayList;

public class AddMovieFrame extends JInternalFrame {

    public static void main(String[] args) {
        new AddMovieFrame();
    }

    private Movie newMovie;
    private ArrayList<Movie> movies = new ArrayList<>();

    public AddMovieFrame() {

        newMovie = new Movie();

        JFrame frame = new JFrame("Εισαγωγή ταινίας");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(550, 300));
        frame.getContentPane().setBackground(new Color(6, 62, 53));
        frame.pack();
        frame.setVisible(true);
        frame.setSize(450, 420);
        frame.setLocation(300, 200);

        JPanel panel = (JPanel) frame.getContentPane();
        panel.setLayout(null);

        JLabel label1 = new JLabel("Εισαγωγή ταινίας", JLabel.CENTER);
        label1.setFont(new Font("tag",Font.BOLD, 20));
        label1.setPreferredSize(new Dimension(250, 50));
        label1.setForeground(new Color(150, 90, 40));
      //  label1.setBackground(new Color(100, 20, 70));
        Border border = BorderFactory.createLineBorder(new Color(100, 90, 50));
        label1.setBorder(border);
        panel.add(label1);
        Dimension size1 = label1.getPreferredSize();
        label1.setBounds(77, 20, size1.width, size1.height);

        JLabel label2 = new JLabel("Τίτλος: ");
        label2.setFont(new Font("title", Font.BOLD, 15));
        label2.setForeground(new Color(150, 90, 40));
        panel.add(label2);
        Dimension size2 = label2.getPreferredSize();
        label2.setBounds(87, 95, size2.width, size2.height);

        JLabel label3 = new JLabel("Είδος: ");
        label3.setFont(new Font("type", Font.BOLD, 15));
        label3.setForeground(new Color(150, 90, 40));
        panel.add(label3);
        Dimension size3 = label3.getPreferredSize();
        label3.setBounds(91, 135, size3.width, size3.height);

        JLabel label4 = new JLabel("Διάρκεια: ");
        label4.setFont(new Font("type", Font.BOLD, 15));
        label4.setForeground(new Color(150, 90, 40));
        panel.add(label4);
        Dimension size4 = label4.getPreferredSize();
        label4.setBounds(71, 175, size4.width, size4.height);

        JTextField tfTitle = new JTextField();
        tfTitle.setLocation(150, 95);
        tfTitle.setSize(150, 25);
        panel.add(tfTitle);

        JTextField tfDuration = new JTextField();
        tfDuration.setLocation(150, 175);
        tfDuration.setSize(150, 25);
        panel.add(tfDuration);

        String[] genres =  {"Action","Comedy","Drama","Fantasy","Horror","Mystery","Romance","Thriller"};
        JComboBox comboBox = new JComboBox(genres);
        comboBox.setLocation(150, 135);
        comboBox.setSize(150, 25);
        panel.add(comboBox);

        JButton buttonInsert = new JButton("Εισαγωγή");
        buttonInsert.setLocation(170, 230);
        buttonInsert.setSize(100, 25);
        panel.add(buttonInsert);

        JButton buttonBack = new JButton("Πίσω");
        buttonBack.setLocation(30, 300);
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

                    Database.allMovies.add(newMovie);
                    Database.storeData();

                    JOptionPane.showMessageDialog(null, "Η ταινία εισήχθη με επιτυχία");

                    tfTitle.setText("");
                    tfDuration.setText("");


                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1);
                }
            }
        });

        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });


        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }



}
