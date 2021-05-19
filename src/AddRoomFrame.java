import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoomFrame extends JFrame {

    private JPanel panel;
    private JLabel roomIDLabel;
    private JTextField roomIDField;
    private JLabel roomCapacityLabel;
    private JTextField roomCapacityField;
    private JButton addRoomBtn;
    private ButtonListener listener;

    public AddRoomFrame() {
        panel = new JPanel();
        roomIDLabel = new JLabel("Αναγρνωριστικό αίθουσας");
        roomIDField = new JTextField(10);
        roomCapacityLabel = new JLabel("Χωρητικότητα αίθουσας");
        roomCapacityField = new JTextField(5);
        addRoomBtn = new JButton("Προσθήκη");
        listener = new ButtonListener();


        panel.add(roomIDLabel);
        panel.add(roomIDField);
        panel.add(roomCapacityLabel);
        panel.add(roomCapacityField);
        panel.add(addRoomBtn);

        addRoomBtn.addActionListener(listener);

        this.setVisible(true);
        this.setSize(400, 400);
        this.setContentPane(panel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(addRoomBtn)){
                String roomID = roomIDField.getText();
                int roomCapacity = Integer.parseInt(roomCapacityField.getText());
                Database.allRooms.add(new Room(roomID, roomCapacity));
                JOptionPane.showMessageDialog(null, "Room created Successfully");
            }
        }
    }

}
