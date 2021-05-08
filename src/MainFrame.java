import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.*;

public class MainFrame  extends JFrame {
	
	// Δηλωση των γραφικων στοιχειων που θα χρειαστουν για το gui 
	private JPanel mainPanel, panel1, panel2, panel3;
	private JLabel title;
	private JButton employeeLoginBtn, adminLoginBtn, exitBtn;
	private ButtonListener listener;
	
	MainFrame(){
		/*
		 * δεσμευση-αρχικοποιηση των JPanels
		 * αναθεση βασικων ιδιοτητων οπως το χρωμα του back ground
		 * καθορισμος layouts και οπου χρειαζεται καθορισμος μεγεθους
		 */

		mainPanel = new JPanel();
		panel1 =  new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		listener = new ButtonListener();

		/*
		 * δεσμευση-αρχικοποιηση των JButtons και καθορισμος του text-size
		 */

		employeeLoginBtn = new JButton("Είσοδος Υπαλλήλου");
		adminLoginBtn = new JButton("Είσοδος Διαχειριστή");
		exitBtn =  new JButton("Έξοδος");

		/*
		 * δεσμευση-αρχικοποιηση των JLabels και καθοριμσος των ΤΧΤ-FOREGROUND-BACKGROUND
		 */

		title = new JLabel("Σύστημα Διαχείρησης Κινιματογράφου");


		/*
		 * Προσθηκη γραφικων στοιχειων στα αντιστοιχα JPanel και καθορισμος θεσης
		 */

		mainPanel.setLayout(null);
		panel1.setPreferredSize(new Dimension(280,25));
		panel1.setBounds(0,0,280,25);
		panel2.setBounds(0,35,280,70);
		panel3.setBounds(0,110,280,30);

		panel1.add(title);

		panel2.add(employeeLoginBtn);
		panel2.add(adminLoginBtn);

		panel3.add(exitBtn);
			
		/*
		 * ΠΡΟΣΘΗΚΗ ΤΩΝ PANEL1-6 ΣΤΟΝ ΚΥΡΙΟ ΠΑΝΕΛ (JPanel)
		 */

		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);


		employeeLoginBtn.addActionListener(listener);
		adminLoginBtn.addActionListener(listener);
		exitBtn.addActionListener(listener);
		
		ImageIcon icon = new ImageIcon("cinema_logo.jpg");
		
		this.setSize(280,180);
		this.setIconImage(icon.getImage());
		this.setContentPane(mainPanel);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Είσοδος Χρήστη");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			if ( e.getSource().equals(employeeLoginBtn) ){
				new EmployeeLoginFrame();
			}
			if ( e.getSource().equals(adminLoginBtn) ){
				new AdminLoginFrame();
			}
			if ( e.getSource().equals(exitBtn) ){

				try {
					FileOutputStream moviesOut = new FileOutputStream("allMovies.ser");
					moviesOut.write("".getBytes());
					ObjectOutputStream out = new ObjectOutputStream(moviesOut);
					out.writeObject(Database.allMovies);

					out.close();
					moviesOut.close();
				}
				catch(IOException i) {
					i.printStackTrace();
				}

				System.exit(1);
			}
		}
	}

}
