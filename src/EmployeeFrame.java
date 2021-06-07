import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EmployeeFrame extends JFrame {
	JLabel AddScreening,DeleteScreening,newMovieLabel, newReservationLabel, delReservationLabel, delMovieLabel;
	JButton newMovieBtn,AddScreeeningBtn,DelScreeningBtn,newReservationBtn, delReservationBtn, delMovieBtn, logoutBtn;
	JPanel panel;
	JFrame JFrame = this;
	

	EmployeeFrame(){
		panel = new JPanel();
		panel.setLayout(null);

						

		newMovieLabel =  new JLabel("Καταχώρηση νέας ταινίας");
		newMovieBtn = new JButton("Καταχώρηση");
		newMovieBtn.setPreferredSize(new Dimension(50,25));
		panel.add(newMovieLabel);
		panel.add(newMovieBtn);
		newMovieLabel.setBounds(10,10,160,25);
		newMovieBtn.setBounds(170,10,120,25);

		newReservationLabel =  new JLabel("Νέα κράτηση");
		newReservationBtn = new JButton("Κράτηση");
		newReservationBtn.setPreferredSize(new Dimension(50,25));
		panel.add(newReservationLabel);
		panel.add(newReservationBtn);
		newReservationLabel.setBounds(10,45,80,25);
		newReservationBtn.setBounds(170,45,100,25);

		delReservationLabel =  new JLabel("Ακύρωση κράτησης");
		delReservationBtn =  new JButton("Ακύρωση");
		delReservationBtn.setPreferredSize(new Dimension(50,25));
		panel.add(delReservationLabel);
		panel.add(delReservationBtn);
		delReservationLabel.setBounds(10,80,120,25);
		delReservationBtn.setBounds(170,80,100,25);

		delMovieLabel =  new JLabel("Διαγραφή ταινίας");
		delMovieBtn = new JButton("Διαγραφή");
		delMovieBtn.setPreferredSize(new Dimension(50,25));
		panel.add(delMovieLabel);
		panel.add(delMovieBtn);
		delMovieLabel.setBounds(10,115,100,25);
		delMovieBtn.setBounds(170,115,100,25);
		
		AddScreening =  new JLabel("Προσθήκη προβολής");
		AddScreeeningBtn =  new JButton("Προσθήκη");
		AddScreeeningBtn.setPreferredSize(new Dimension(50,25));
		panel.add(AddScreening);
		panel.add(AddScreeeningBtn);
		AddScreening.setBounds(10, 150, 180, 25);
		AddScreeeningBtn.setBounds(170, 150, 100, 25);
		
		
		DeleteScreening =  new JLabel("Διαγραφή  προβολής");
		DelScreeningBtn =  new JButton("Διαγραφή");
		DelScreeningBtn.setPreferredSize(new Dimension(50,25));
		panel.add(DeleteScreening);
		panel.add(DelScreeningBtn);
		DeleteScreening.setBounds(10, 185, 180, 25);
		DelScreeningBtn.setBounds(170, 185, 100, 25);
		
		
	    logoutBtn =  new JButton("Logout");
		panel.add(logoutBtn);
		logoutBtn.setBounds(10,220,100,25);
	    					


	    		

	    
		ButtonListener listener = new ButtonListener();
		newMovieBtn.addActionListener(listener);
		newReservationBtn.addActionListener(listener);
		delReservationBtn.addActionListener(listener);
		delMovieBtn.addActionListener(listener);
		AddScreeeningBtn.addActionListener(listener);
		DelScreeningBtn.addActionListener(listener);
		logoutBtn.addActionListener(listener);
		
		ImageIcon  icon = new ImageIcon("cinema_logo.jpg");
		this.setSize(400,300);
		this.setIconImage(icon.getImage());
		this.setContentPane(panel);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Παράθυρο Υπαλλήλου");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
	}
	

	class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			if ( e.getSource().equals(newMovieBtn) ) {
				new AddMovieFrame();
			}
			if ( e.getSource().equals(newReservationBtn) ){
				new BookTicketFrame();
			}
			if ( e.getSource().equals(delReservationBtn) ) {
				
			}
			if ( e.getSource().equals(delMovieBtn) ) {
				new DeleteMovieFrame();
			}
			if(e.getSource().equals(AddScreeeningBtn)) {
//				new AddScreeningFrame();
			}
			if(e.getSource().equals(DelScreeningBtn)) {
	//			new DeleteScreeningFrame();
			}
			if ( e.getSource().equals(logoutBtn) ) {
				JFrame.dispose();
			}
		
		}
	}
	

	}
