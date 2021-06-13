import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteMovieFrame extends JFrame {

    private ArrayList<String> moviesTitle = new ArrayList<>();
    
    public DeleteMovieFrame(){

        for (int i = 0; i< Database.allMovies.size(); i++){
            moviesTitle.add(Database.allMovies.get(i).getTitle());
        }

        JFrame frame = new JFrame("�������� �������");
        frame.setSize(500, 250);
        frame.setLocation(450, 250);
        JPanel panel = (JPanel) frame.getContentPane();
        panel.setLayout(null);

        JLabel label1 = new JLabel("������ �������: ");
        label1.setFont(new Font("Verdana", Font.PLAIN, 20));
        panel.add(label1);
        Dimension size1 = label1.getPreferredSize();
        label1.setBounds(20, 25, size1.width, size1.height);

        JButton DeleteButton = new JButton("��������");
        DeleteButton.setLocation(330, 150);
        DeleteButton.setSize(100, 30);
        panel.add(DeleteButton);


        JButton buttonBack = new JButton("����");
        buttonBack.setLocation(20, 150);
        buttonBack.setSize(100, 30);
        panel.add(buttonBack);

        String[] array = moviesTitle.toArray(new String[Database.allMovies.size()]);

        JComboBox comboBox = new JComboBox(array);
        comboBox.setLocation(170, 25);
        comboBox.setSize(150, 25);
        panel.add(comboBox);


        DeleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    String title = String.valueOf(comboBox.getSelectedItem());

                    comboBox.removeItem(title);

                    for(int i = 0; i< Database.allMovies.size(); i++){
                        if(Database.allMovies.get(i).getTitle() == title){
                            Database.allMovies.remove(i);
                            JOptionPane.showMessageDialog(null, "� ������ ���������� ��������");
                        }
                    }

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