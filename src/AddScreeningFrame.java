import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Calendar;

public class AddScreeningFrame  extends JFrame implements ActionListener{
	JLabel Tile,SelectMovie,Hour_Month,SelectOptions,ROOM;
	JButton AddScreening,Logout;
	JComboBox<String> Movies;
	JComboBox<String> Hour;
	JComboBox<String> Month;
	JComboBox<String> Rooms;
	JPanel  panel;
	JFrame  JFrame = this;
	
	AddScreeningFrame(){
		 LocalDate currentdate = LocalDate.now();
		panel  =  new JPanel();
		panel.setLayout(null);
		Movies = new JComboBox<>();
		Hour = new JComboBox<>();
		Month = new JComboBox<>();
		Rooms = new JComboBox<>();

		Tile =  new JLabel("”’Ã–À«—Ÿ”≈ ‘¡ –¡—¡ ¡‘Ÿ ”‘œ…◊≈…¡");
		panel.add(Tile);
		Tile.setBounds(120,10,250,25);
		
		SelectMovie =  new JLabel("ƒÈ‹ÎÂÓÂ ‘·ÈÌﬂ·");
		Movies = new JComboBox<String>();
		for(Movie movie:Database.allMovies) {
			String title = movie.getTitle();
			Movies.addItem(title);
		}
		Movies.setPreferredSize(new Dimension(50,25));
		panel.add(SelectMovie);
		panel.add(Movies);
		SelectMovie.setBounds(40,60,100,25);
		Movies.setBounds(170, 60, 100, 25);
		
		
		Hour_Month  =  new JLabel("Select Hour/Month:");
		Hour = new JComboBox<String>();
		Hour.setPreferredSize(new Dimension(50,25));
		Hour.addItem("17");
		Hour.addItem("19");
		Hour.addItem("21");
		Hour.addItem("23");
		Month =  new JComboBox<String>();
		Hour.setPreferredSize(new Dimension(50,25));
			
		Month.addItem("Month");
		panel.add(Hour);
		panel.add(Hour_Month);
		panel.add(Month);
		Hour_Month.setBounds(40,120,250,25);
		Hour.setBounds(170, 120, 100, 25);
		Month.setBounds(300, 120, 100, 25);
		
		ROOM =  new JLabel("Select Room");
		panel.add(ROOM);
		
		Rooms =  new JComboBox<String>();
		for(Room room:Database.allRooms) {
			String roomid = room.getRoomID();
			Rooms.addItem(roomid);
		}
		
		panel.add(Rooms);
		ROOM.setBounds(40, 180, 250, 25);
		Rooms.setBounds(170, 180, 100, 25);
		
		AddScreening =  new JButton("AddScreening");
		panel.add(AddScreening);
		AddScreening.setBounds(155,240,140,25);
		
		Logout =  new JButton("Logout");
			panel.add(Logout);
			Logout.setBounds(170,300,100,25);
		
		AddScreening.addActionListener(this);
		Logout.addActionListener(this);

		ImageIcon icon = new ImageIcon("cinema_logo.jpg");
		this.setIconImage(icon.getImage());
		
		
		this.setSize(500,400);
		//this.setIconImage(icon.getImage());
		this.setContentPane(panel);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("–·Ò‹ËıÒÔ ’·ÎÎﬁÎÔı");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(Logout)){
			JFrame.dispose();
		}
		
	}
	
}