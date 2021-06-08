import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.*;

public class DeleteScreeningFrame extends JFrame implements ActionListener {
	JPanel panel;
	JLabel  Select,title,date;
	JComboBox<String> Movies;
	JComboBox<Date> Dates;
	JFrame JFrame = this;
	JButton DELETE,LOGOUT;
	
	DeleteScreeningFrame() {
		panel = new JPanel();
		panel  =  new JPanel();
		panel.setLayout(null);
		
		// TODO Auto-generated constructor stub
		title =  new JLabel("SELECT THE FOLLOWING INFO'S");
		panel.add(title);
		title.setBounds(90,10,250,25);
		
		Select =  new JLabel("Select Movie:");
		Movies = new JComboBox<String>();
		for(Movie movie:Database.allMovies) {
			String title = movie.getTitle();
			Movies.addItem(title);
		}
		Movies.setPreferredSize(new Dimension(50,25));
		panel.add(Select);
		panel.add(Movies);
		Select.setBounds(50,60,100,25);
		Movies.setBounds(170, 60, 100, 25);
		
		
		date = new JLabel("Delete Date:");
		panel.add(date);
		date.setBounds(50,120,250,25);
		
		Dates = new JComboBox<Date>();
		panel.add(Dates);
		Dates.setBounds(170, 120, 100, 25);
		
		DELETE = new JButton("DELETE");
		panel.add(DELETE);
		DELETE.setBounds(140,180,100,25);
		
		LOGOUT =  new JButton("Logout");
		panel.add(LOGOUT);
		LOGOUT.setBounds(140,220,100,25);
		
		DELETE.addActionListener(this);
		LOGOUT.addActionListener(this);

		ImageIcon icon = new ImageIcon("cinema_logo.jpg");
		this.setIconImage(icon.getImage());
		
		this.setSize(400,300);
		//this.setIconImage(icon.getImage());
		this.setContentPane(panel);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Ακύρωση Προβολής");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
	}
	
	
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			if ( e.getSource().equals(LOGOUT) ) {
				JFrame.dispose();
			}
	}

}
