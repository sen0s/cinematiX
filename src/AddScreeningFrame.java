import java.awt.Dimension;
import java.awt.event.*;
import java.sql.Date;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Calendar;

public class AddScreeningFrame  extends JFrame {
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
		 Calendar cal = Calendar.getInstance();
		 int res = cal.getActualMaximum(Calendar.DATE);
		 
		panel  =  new JPanel();
		panel.setLayout(null);
		Movies = new JComboBox<>();
		Hour = new JComboBox<>();
		Month = new JComboBox<>();
		Rooms = new JComboBox<>();

		Tile =  new JLabel("Συμπληρώστε τα παρακάτω στοιχεία");
		panel.add(Tile);
		Tile.setBounds(120,10,250,25);
		
		SelectMovie =  new JLabel("Διάλεξε Ταινία");
		Movies = new JComboBox<String>();
		for(Movie movie:Database.allMovies) {
			String title = movie.getTitle();
			Movies.addItem(title);
		}
		Movies.setSelectedIndex(0);
		Movies.setPreferredSize(new Dimension(50,25));
		panel.add(SelectMovie);
		panel.add(Movies);
		SelectMovie.setBounds(40,60,100,25);
		Movies.setBounds(170, 60, 100, 25);
		
		
		Hour_Month  =  new JLabel("Ωρα/Μερα-" + currentdate.getMonth());
		Hour = new JComboBox<String>();
		Hour.setPreferredSize(new Dimension(50,25));
		Hour.addItem("17");
		Hour.addItem("19");
		Hour.addItem("21");
		Hour.addItem("23");
		Hour.setSelectedIndex(0);
		Month =  new JComboBox<String>();
		
		Month.setPreferredSize(new Dimension(50,25));
		int day;
		day = currentdate.getDayOfMonth();
		int resu = res-day;

		for(int i=0;i<=resu;i++) {	
				String DAY = Integer.toString(day);
				Month.addItem(DAY);
				day++;
			
		}
		panel.add(Hour);
		panel.add(Hour_Month);
		panel.add(Month);
		Hour_Month.setBounds(40,120,250,25);
		Hour.setBounds(170, 120, 100, 25);
		Month.setBounds(300, 120, 100, 25);
		
		ROOM =  new JLabel("Επιλογή Αίθουσας");
		panel.add(ROOM);
		
		Rooms =  new JComboBox<String>();
		for(Room room:Database.allRooms) {
			String roomid = room.getRoomID();
			Rooms.addItem(roomid);
		}
		
		panel.add(Rooms);
		ROOM.setBounds(40, 180, 250, 25);
		Rooms.setBounds(170, 180, 100, 25);
		
		AddScreening =  new JButton("Προσθήκη Προβολής");
		panel.add(AddScreening);
		AddScreening.setBounds(250,300,160,25);
		
		Logout =  new JButton("Πίσω");
			panel.add(Logout);
			Logout.setBounds(80,300,100,25);
		
		AddScreening.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					Movie moviesel = Database.getMovieFromTitle((String)Movies.getSelectedItem());
					System.out.println(moviesel.getTitle());
					Room roomsel = Database.getRoomFromID((String)Rooms.getSelectedItem());
					String hour = (String)Hour.getSelectedItem();
					String day = (String)Month.getSelectedItem();

					int flag = 0;
					String datesel1 = Integer.toString(currentdate.getYear())+"/"+Integer.toString(currentdate.getMonthValue())+"/"+day+" Hour:"+hour+":00";
					System.out.println(datesel1);
							for(String date:roomsel.getScreenings()) {
								if(date.equals(datesel1)) {
									flag=1;
								}
							}
								if(flag==0) {
									moviesel.AddScreening(datesel1, roomsel);
									roomsel.AddDateScreening(datesel1);
									Database.storeData();
									JOptionPane.showMessageDialog(null, "Επιτυχής προσθήκη προβολής");
									dispose();
								}
								else {
									JOptionPane.showMessageDialog(null,"Υπάρχη προβολή στην Αίθουσα την συγκεκριμένη ημερομηνία");
								}
							}
					
			catch(Exception e1) {
				JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		Logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame.dispose();
			}
		});
		
		
		this.setSize(500,400);
		//this.setIconImage(icon.getImage());
		this.setContentPane(panel);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Προσθήκη Προβολής");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
	}

	
}
