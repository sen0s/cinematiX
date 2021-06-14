import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.*;

public class DeleteReservationFrame extends JFrame {

	JPanel panel;
	JLabel  Select,title,Room1,seats1,movie1;
	JComboBox<UUID> Reservations;
	JTextField Room,seats,movie;
	JFrame JFrame = this;
	JButton DELETE,LOGOUT;
	
	public DeleteReservationFrame() {
		panel = new JPanel();
		panel  =  new JPanel();
		panel.setLayout(null);
		
		title =  new JLabel("Συμπληρώστε τα παρακάτω");
		panel.add(title);
		title.setBounds(90,10,250,25);
		
		Select =  new JLabel("Επιλογή Kάτησης:");
		Reservations = new JComboBox<UUID>();
		for(Reservation reserv:Database.allReservations) {
			UUID title = reserv.getReservationID();
			Reservations.addItem(title);
		}
		Reservations.setSelectedIndex(0);
		Reservations.setPreferredSize(new Dimension(50,25));
		panel.add(Select);
		panel.add(Reservations);
		Select.setBounds(50,60,100,25);
		Reservations.setBounds(170, 60, 100, 25);
		Reservations.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Reservation Reservation1 =  Database.getReservationFromID((UUID)Reservations.getSelectedItem());
				
				Room.setText(Reservation1.getRoom().getRoomID());
				seats.setText(Integer.toString(Reservation1.getSeatNumber()));
				movie.setText(Reservation1.getMovie().getTitle());
			}
		});
		Room1 = new JLabel("Αίθουσα:");
		Room = new JTextField();
		panel.add(Room1);
		panel.add(Room);
		Room1.setBounds(50, 100, 100, 25);
		Room.setBounds(170,100,100,25);
		
		seats1 = new JLabel("Θέση:");
		seats = new JTextField();
		panel.add(seats);
		panel.add(seats1);
		seats1.setBounds(50, 140, 100, 25);
		seats.setBounds(170, 140, 100, 25);
		
		movie1  =  new JLabel("Ταινία:");
		movie = new  JTextField();
		panel.add(movie);
		panel.add(movie1);
		movie1.setBounds(50, 180, 100, 25);
		movie.setBounds(170, 180, 100, 25);
		
		DELETE = new JButton("Διαγραφή");
		panel.add(DELETE);
		DELETE.setBounds(200,220,100,25);
		
		LOGOUT =  new JButton("Πίσω");
		panel.add(LOGOUT);
		LOGOUT.setBounds(60,220,100,25);
		

		DELETE.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try{
					Reservation Reservation1 =  Database.getReservationFromID((UUID)Reservations.getSelectedItem());
				
					Room.setText(Reservation1.getRoom().getRoomID());
					seats.setText(Integer.toString(Reservation1.getSeatNumber()));
					System.out.println(Reservation1);
					Database.allReservations.remove(Reservation1);
					Database.storeData();
					JOptionPane.showMessageDialog(null,"Επυτυχής Διαγραφή");
					new EmployeeFrame();
		}catch(Exception e1) {
			JOptionPane.showMessageDialog(null,e1);
			}
		}
			
				});
		LOGOUT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame.dispose();
				
			}
		});
		
		this.setSize(400,300);
		//this.setIconImage(icon.getImage());
		this.setContentPane(panel);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Παράθυρο Υπαλλήλου");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
	}

}
