import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddMovieFrame extends JInternalFrame {

    private Movie newMovie;
    private ArrayList<Movie> movies = new ArrayList<>();

    public AddMovieFrame() {

        newMovie = new Movie();

        JFrame frame = new JFrame("Καταχώρηση Ταινίας");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLocation(300, 200);
        JPanel panel = (JPanel) frame.getContentPane();
        panel.setLayout(null);

        JLabel label1 = new JLabel("Συμπληρώστε τα παρακάτω στοιχεία");
        panel.add(label1);
        Dimension size1 = label1.getPreferredSize();
        label1.setBounds(100, 20, size1.width, size1.height);

        JLabel label2 = new JLabel("Όνομα: ");
        panel.add(label2);
        Dimension size2 = label2.getPreferredSize();
        label2.setBounds(95, 90, size2.width, size2.height);

        JLabel label3 = new JLabel("Είδος: ");
        panel.add(label3);
        Dimension size3 = label3.getPreferredSize();
        label3.setBounds(95, 130, size3.width, size3.height);

        JLabel label4 = new JLabel("Διάρκεια: ");
        panel.add(label4);
        Dimension size4 = label4.getPreferredSize();
        label4.setBounds(85, 165, size4.width, size4.height);

        JTextField tfTitle = new JTextField();
        tfTitle.setLocation(150, 88);
        tfTitle.setSize(150, 25);
        panel.add(tfTitle);

        JTextField tfDuration = new JTextField();
        tfDuration.setLocation(150, 160);
        tfDuration.setSize(150, 25);
        panel.add(tfDuration);

        String[] genres =  {"Action","Comedy","Drama","Fantasy","Horror","Mystery","Romance","Thriller"};
        JComboBox comboBox = new JComboBox(genres);
        comboBox.setLocation(150, 125);
        comboBox.setSize(150, 25);
        panel.add(comboBox);

        JButton buttonInsert = new JButton("Καταχώρηση");
        buttonInsert.setLocation(150, 200);
        buttonInsert.setSize(150, 25);
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

                    JOptionPane.showMessageDialog(null, "Η ταινία καταχωρήθηκε επιτυχώς");

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

