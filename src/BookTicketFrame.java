import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class BookTicketFrame extends JFrame {
	
	//private ArrayLit<Movie> filmList = new ArrayList<Movie>();
	private String name;
	
	
	private JLabel movieL;
	private JLabel roomL;
	private JLabel seatL;
	private JLabel nameL;
	private JComboBox movies;
	private JComboBox seats;
	private JButton backButton;
	private JButton bookButton;
	private JComboBox roomsCombo;
	private JTextField nameField;
	private JRadioButton normalT;
	private JRadioButton childT;
	private JRadioButton studentT;
	private JRadioButton multiT;
	private JPanel panel;
	private JFrame frame = new JFrame();
    private ArrayList<String> roomIDs = new ArrayList<>();
	
	private ImageIcon img= new ImageIcon("ticket icon.png");

    private ArrayList<String> moviesTitle = new ArrayList<>();
	
	
	public BookTicketFrame() {

        for (Movie m : Database.allMovies){
            moviesTitle.add(m.getTitle());
        }

        for(Room r : Database.allRooms){
            roomIDs.add(r.getRoomID());
        }

        movieL = new JLabel("Ταινία: ");
        roomL = new JLabel("Αίθουσα: ");
        seatL = new JLabel("Θέση: ");
        nameL = new JLabel("Ονoμ/μο: ");
        String[] array = moviesTitle.toArray(new String[Database.allMovies.size()]);
        movies = new JComboBox(array);
        backButton = new JButton("Πίσω");
        bookButton = new JButton("Κράτηση");
        String[] array1 = roomIDs.toArray(new String[Database.allRooms.size()]);
        roomsCombo = new JComboBox(array1);

        nameField= new JTextField("");
        normalT = new JRadioButton("Κανονικό");
        childT = new JRadioButton("Παιδικό");
        studentT = new JRadioButton("Φοιτητικό");
        multiT = new JRadioButton("Πολυτεκνικο");

        seats = new JComboBox();
		
		ButtonListener listener = new ButtonListener();
		bookButton.addActionListener(listener);
		backButton.addActionListener(listener);

        roomsCombo.addActionListener(listener);
		
		frame.setIconImage(img.getImage());
		
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(450,450);
		frame.setTitle("Κράτηση Εισητηρίου");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = (JPanel) frame.getContentPane();
        panel.setLayout(null);
        
        panel.add(movieL);
        Dimension size1 = movieL.getPreferredSize();
        movieL.setBounds(100, 10, size1.width, size1.height);
        
        panel.add(roomL);
        Dimension size2 = roomL.getPreferredSize();
        roomL.setBounds(100, 40, size2.width, size2.height);
        
        panel.add(seatL);
        Dimension size3 = seatL.getPreferredSize();
        seatL.setBounds(100, 70, size3.width, size3.height);
        
        panel.add(nameL);
        Dimension size4 = nameL.getPreferredSize();
        nameL.setBounds(100, 100, size4.width, size4.height);
        
        movies.setLocation(200, 10);
        movies.setSize(200, 20);
        panel.add(movies);
        
        roomsCombo.setLocation(200, 40);
        roomsCombo.setSize(200, 20);
        panel.add(roomsCombo);
        
        seats.setLocation(200, 70);
        seats.setSize(200, 20);
        panel.add(seats);
        
        nameField.setLocation(200, 100);
        nameField.setSize(200, 20);
        panel.add(nameField);
        
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(normalT);
        buttonGroup.add(childT);
        buttonGroup.add(studentT);
        buttonGroup.add(multiT);
        
        normalT.setLocation(10, 200);
        normalT.setSize(100, 20);
        panel.add(normalT);
        childT.setLocation(120, 200);
        childT.setSize(100, 20);
        panel.add(childT);
        studentT.setLocation(230, 200);
        studentT.setSize(100, 20);
        panel.add(studentT);
        multiT.setLocation(340, 200);
        multiT.setSize(100, 20);
        panel.add(multiT);
        
        backButton.setLocation(80, 320);
        backButton.setSize(100, 25);
        panel.add(backButton);
        
        bookButton.setLocation(250, 320);
        bookButton.setSize(100, 25);
        panel.add(bookButton);
	}
	
	class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if ( e.getSource().equals(bookButton)) {
			    // Get movie from JComboBox
                //String movie = String.valueOf(movies.getSelectedItem());
			    Movie selectedMovie = Database.getMovieFromTitle((String)movies.getSelectedItem());
                //String room = String.valueOf(roomsCombo.getSelectedItem());
                Room selectedRoom = Database.getRoomFromID((String)roomsCombo.getSelectedItem());
                //int selectedSeat = Integer.parseInt(seatL.getText());

                String ticketType;
                if(normalT.isSelected()){
                    ticketType = "normal";
                }
                else if (childT.isSelected()){
                    ticketType = "child";
                }
                else if (studentT.isSelected()){
                    ticketType = "student";
                }
                else{
                    ticketType = "multi";
                }

                Database.allReservations.add(new Reservation(selectedMovie, 2, ticketType, selectedRoom));
                JOptionPane.showMessageDialog(null, "Η κράτηση πραγματοποιήθηκε!");
			}
			else if ( e.getSource().equals(backButton) ){
				frame.dispose();
			}
			else if(e.getSource().equals(roomsCombo)){
                Room selectedRoom = Database.getRoomFromID((String)roomsCombo.getSelectedItem());
                System.out.println(selectedRoom.getRoomID());
                ArrayList<Integer> empty = selectedRoom.getEmptySeats();
//                for (Integer i : empty){
//                    System.out.println("Seats No: " + i);
//                }
                String[] array = new String[empty.size()];
                for(int j =0;j<empty.size();j++){

                    array[j] = String.valueOf(empty.get(j));
                    seats.addItem(array[j]);

                }
                seats.setSelectedIndex(0);
            }
		}
		
	}
	
}
