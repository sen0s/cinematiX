import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoomFrame extends JFrame {

    private JPanel panel;
    private JLabel roomIDLabel,Title;
    private JTextField roomIDField;
    private JLabel roomCapacityLabel;
    private JTextField roomCapacityField;
    private JButton addRoomBtn, back;
    private JFrame frame = this;
    private ButtonListener listener;

    public AddRoomFrame() {
        panel = new JPanel();
        panel.setLayout(null);
        Title = new JLabel("ΣΥΜΠΛΗΡΩΣΗ ΣΤΟΙΧΕΙΩΝ");
        roomIDLabel = new JLabel("Αναγρνωριστικό αίθουσας");
        roomIDField = new JTextField(10);
        roomCapacityLabel = new JLabel("Χωρητικότητα αίθουσας");
        roomCapacityField = new JTextField(5);
        addRoomBtn = new JButton("Προσθήκη");
        back = new JButton("Πίσω");
        listener = new ButtonListener();

        panel.add(Title);
        panel.add(roomIDLabel);
        panel.add(roomIDField);
        panel.add(roomCapacityLabel);
        panel.add(roomCapacityField);
        panel.add(addRoomBtn);
        panel.add(back);
        
        Title.setBounds(110, 10, 200, 20);
        roomIDLabel.setBounds(40, 60, 200, 25);
        roomIDField.setBounds(200, 60, 120, 25);
        roomCapacityLabel.setBounds(40,110,200,25);
        roomCapacityField.setBounds(200, 110, 120, 25);
        addRoomBtn.setBounds(120, 160, 110, 25);
        back.setBounds(0, 336, 70, 25);
        addRoomBtn.addActionListener(listener);
        back.addActionListener(listener);

        ImageIcon icon = new ImageIcon("cinema_logo.jpg");
        this.setIconImage(icon.getImage());

        this.setVisible(true);
        this.setSize(400, 400);
        this.setContentPane(panel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Δημιουργία Αίθουσας");
    }

    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(addRoomBtn)){
                String roomID = roomIDField.getText();
                int roomCapacity = Integer.parseInt(roomCapacityField.getText());
                Database.allRooms.add(new Room(roomID, roomCapacity));
                Database.storeData();
                JOptionPane.showMessageDialog(null, "Η αίθουσα δημιουργήθηκε επιτυχώς");
            }
            if (e.getSource().equals(back)){
    			frame.dispose();
    		}
        }
    }

}
