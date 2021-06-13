import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DeleteScreeningFrame extends JFrame {
	JPanel panel;
	JLabel  Select,title,date;
	JComboBox<String> Movies;
	JComboBox<String> Dates;
	JFrame JFrame = this;
	JButton DELETE,LOGOUT;
	
	DeleteScreeningFrame() {
		panel = new JPanel();
		panel  =  new JPanel();
		panel.setLayout(null);
		
		// TODO Auto-generated constructor stub
		title =  new JLabel("Συμπληρώστε τα παρακάτω");
		panel.add(title);
		title.setBounds(90,10,250,25);
		
		Select =  new JLabel("Επιλογή Ταινίας:");
		Movies = new JComboBox<String>();
		for(Movie movie:Database.allMovies) {
			String title = movie.getTitle();
			Movies.addItem(title);
		}
		Movies.setSelectedIndex(0);
		Movies.setPreferredSize(new Dimension(50,25));
		panel.add(Select);
		panel.add(Movies);
		Select.setBounds(50,60,100,25);
		Movies.setBounds(170, 60, 100, 25);
		
		date = new JLabel("Ημερ/νία:");
		panel.add(date);
		date.setBounds(50,120,250,25);
		
		Dates = new JComboBox<String>();
		panel.add(Dates);
		Dates.setBounds(170, 120, 100, 25);
		Movies.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stubF
				Dates.removeAllItems();
				Movie moviesel = Database.getMovieFromTitle((String)Movies.getSelectedItem());
				Set<String> keys = moviesel.getScreenings().keySet();
				for(String key:keys) {
					System.out.println();
					Dates.addItem(key);
				}
			}
		});
		
		DELETE = new JButton("Διαγραφή");
		panel.add(DELETE);
		DELETE.setBounds(200,180,100,25);
		
		LOGOUT =  new JButton("Πίσω");
		panel.add(LOGOUT);
		LOGOUT.setBounds(60,180,100,25);
		
		DELETE.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try{
					Movie MovieSel =  Database.getMovieFromTitle((String)Movies.getSelectedItem());
				
					String Date = (String)Dates.getSelectedItem();
					System.out.println(Date);
					MovieSel.delscreen(Date);
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
