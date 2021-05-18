import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteRoomFrame extends JFrame {

    private JPanel panel;
    private JLabel label;
    private JComboBox comboBox;
    private JButton removeBtn;
    private ArrayList<String> roomIDs;
    ButtonListener listener;

    public DeleteRoomFrame() {
        roomIDs = new ArrayList<>();

        for(Room r : Database.allRooms){
            roomIDs.add(r.getRoomID());
        }

        panel = new JPanel();
        label = new JLabel("�������� �� �������������");
        removeBtn = new JButton("��������");
        listener = new ButtonListener();

        String[] array = roomIDs.toArray(new String[Database.allRooms.size()]);
        comboBox = new JComboBox(array);

        panel.add(label);
        panel.add(comboBox);
        panel.add(removeBtn);

        removeBtn.addActionListener(listener);

        this.setVisible(true);
        this.setSize(400, 400);
        this.setContentPane(panel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(removeBtn)){
                String ID = String.valueOf(comboBox.getSelectedItem());

                for (Room r : Database.allRooms){
                    if (ID.equals(r.getRoomID())){
                        Database.allRooms.remove(r);
                        comboBox.removeItem(ID);
                        JOptionPane.showMessageDialog(null, "Room deleted Successfully");
                        break;
                    }
                }
            }
        }
    }

}