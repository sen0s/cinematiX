import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainFrame  extends JFrame implements ActionListener{
	
	// Δηλωση των γραφικων στοιχειων που θα χρειαστουν για το gui 
	private JPanel Panel ,Panel1,Panel2,Panel3,Panel4,Panel5,Panel6;
	private JLabel field1,field2,field3;
	private JButton Login1,Login2,EXIT;
	
	
	MainFrame(){
		/* 
		 	δεσμευση-αρχικοποιηση των JPanels  
			αναθεση βασικων ιδιοτητων οπως το χρωμα του back ground
			καθορισμος layouts και οπου χρειαζεται καθορισμος μεγεθους
		 */
		
		Panel  = new JPanel();
			Panel.setLayout(new BorderLayout(20,20));
				Panel.setBackground(Color.white);
		Panel1 =  new JPanel();
			Panel1.setBackground(Color.white);
		Panel2 = new JPanel();
			Panel2.setBackground(Color.white);
		Panel3 = new JPanel();
			Panel3.setBackground(Color.white);
		Panel4 = new JPanel();
			Panel4.setBackground(Color.white);
					Panel4.setPreferredSize(new Dimension(50, 50));
		Panel5 = new JPanel();
			Panel5.setLayout(new GridLayout(2,2,10,10));
				Panel5.setBackground(Color.white);
		Panel6 = new JPanel();
			Panel6.setBackground(Color.white);
				Panel6.setPreferredSize(new Dimension(50,50));
			/*
			 δεσμευση-αρχικοποιηση των JButtons και καθορισμος του text-size  
			 */
				Login1 = new JButton("Staff Log In");
				Login1.setPreferredSize(new Dimension(40,40));
				Login2 = new JButton("Admin Log In");
				EXIT =  new JButton("EXIT");
			/*
			 * δεσμευση-αρχικοποιηση των JLables και καθοριμσος των ΤΧΤ-FOREGROUND-BACKGROUND 	
			 */
			field1 = new JLabel();
				field1.setBackground(Color.white);
					field1.setText("      WELCOME TO THE CINEMA MANAGMENT SYSTEM");
						field1.setForeground(Color.black);
			
			field2 = new JLabel();
				field2.setBackground(Color.white);		
					field2.setText("MEMBER OF STAFF ");
						field2.setForeground(Color.black);
					
			field3 = new JLabel();
				field3.setBackground(Color.white);
					field3.setText("ADMINISTRATOR ");
						field3.setForeground(Color.black);
		/*
		 Προσθηκη γραφικων στοιχειων στα αντιστοιχα JPanel και καθορισμος θεσης 
		 */
			Panel1.add(field1,Panel1.CENTER_ALIGNMENT);
				Panel5.add(field2);
					Panel5.add(Login1);
						Panel5.add(field3);
							Panel5.add(Login2);
								Panel6.add(EXIT,Panel6.CENTER_ALIGNMENT);
			
		/*
		 * ΠΡΟΣΘΗΚΗ ΤΩΝ PANEL1-6 ΣΤΟΝ ΚΥΡΙΟ ΠΑΝΕΛ (JPANEL
		 */
			Panel.add(Panel1,BorderLayout.NORTH	);
				Panel.add(Panel3,BorderLayout.WEST);
					Panel.add(Panel2,BorderLayout.EAST);	
						Panel.add(Panel6,BorderLayout.SOUTH);
							Panel4.add(Panel5/*,Panel4.CENTER_ALIGNMENT*/);
								Panel.add(Panel4,BorderLayout.CENTER);
		
		ImageIcon  icon = new ImageIcon("cinema-logo_23-2147503279.jpg");
		
		this.setSize(350,320);
		this.setIconImage(icon.getImage());
		this.setContentPane(Panel);
		this.setVisible(true);
		
		this.setResizable(false);
		this.setTitle("Entrance Frame");
		this.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent arg0) {
		
	}

}
