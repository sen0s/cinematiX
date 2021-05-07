import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteMovie extends JFrame {

    private ArrayList<String> moviesTitle = new ArrayList<>();

    public static void main(String[] args) {
        new DeleteMovie();
    }

    public DeleteMovie(){

        for (int i=0; i<AllMovies.allMovies.size(); i++){
            moviesTitle.add(AllMovies.allMovies.get(i).getTitle());
        }

        JFrame frame = new JFrame("Delete Movie");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 250);
        frame.setLocation(450, 250);
        JPanel panel = (JPanel) frame.getContentPane();
        panel.setLayout(null);

        JLabel label1 = new JLabel("Movie's Title: ");
        label1.setFont(new Font("Verdana", Font.PLAIN, 20));
        panel.add(label1);
        Dimension size1 = label1.getPreferredSize();
        label1.setBounds(20, 25, size1.width, size1.height);

        JButton DeleteButton = new JButton("Delete");
        DeleteButton.setLocation(300, 150);
        DeleteButton.setSize(100, 30);
        panel.add(DeleteButton);

       String[] array = moviesTitle.toArray(new String[AllMovies.allMovies.size()]);
        JComboBox comboBox = new JComboBox(array);
        comboBox.setLocation(170, 25);
        comboBox.setSize(150, 25);
        panel.add(comboBox);


        DeleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    String title = String.valueOf(comboBox.getSelectedItem());

                    comboBox.removeItem(title);

                    for(int i=0; i<AllMovies.allMovies.size(); i++){
                        if(AllMovies.allMovies.get(i).getTitle() == title){
                            AllMovies.allMovies.remove(i);
                            JOptionPane.showMessageDialog(null, "Movie deleted Successfully");
                        }
                    }



                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1);
                }
            }

        });







        frame.setVisible(true);
    }

}