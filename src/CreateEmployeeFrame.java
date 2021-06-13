import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class CreateEmployeeFrame extends JFrame implements ActionListener {

	private JPanel Panel,Panel1,Panel2,Panel3,Panel4,Panel5,Panel6,Panel7;
	private JLabel name,surname,phone_number,username,password,Gender,Infos;
	private JTextField Name,Surname,Phone_Number,Username;
	private JPasswordField Password;
	private JComboBox<String> Option;
	private JButton create , back;
	private String man,woman,nonofabove;
	private JFrame frame;
	//HashMap<String,String> logininfo = new HashMap<String,String>();
	//IDandPasswords idandPasswords = new IDandPasswords();
	
	
	
	CreateEmployeeFrame(){
		
		//αρχικοποιηση string
		man = "’νδρας";
		woman = "Γυναίκα";
		nonofabove =  "’λλο";
		
		//αρχικοποιηση panels και καθορισμος layout και color
		
		Panel = new JPanel();
			Panel1 =  new JPanel();
				Panel2 =  new JPanel();
					Panel3 =  new JPanel();	
						Panel4 =  new JPanel();
							Panel5 =  new  JPanel();
								Panel6 = new JPanel();
									Panel7 = new JPanel();

		//τροποποιηση  των πανελσ για color , size  και layout
		//Color
		Panel1.setBackground(Color.white);
			Panel2.setBackground(Color.white);
				Panel3.setBackground(Color.white);
					Panel3.setPreferredSize(new Dimension(50,50));
						Panel4.setBackground(Color.white);
							Panel5.setBackground(Color.white);
								Panel6.setBackground(Color.white);
		//layouts 
		Panel.setLayout(new BorderLayout());
			Panel6.setLayout(new GridLayout(6,2,10,10));
				Panel5.setLayout(new BorderLayout());
		
		//αρχικοποιηση των JLabel,JButton,JTextField,ComboBox
		//JLabel
		name =  new JLabel("Όνομα");
			surname = new JLabel("Επίθετο");
				phone_number =  new JLabel("Τηλέφωνο");
					username =  new JLabel("Username");
						password = new JLabel("Password");
							Gender = new JLabel("Φύλο");
								Infos =  new JLabel(" Καταχώρηση Στοιχείων Υπαλλήλου");
								
		//JButton
		create =  new JButton("Δημιουργία");
			back =  new JButton("Πίσω");
		
		//JTextField
		Name =  new JTextField();	
		 Surname =  new  JTextField();
		 	Phone_Number =  new JTextField();
		 		Username =  new JTextField();
		 			Password = new JPasswordField();
		 			
		frame = this; 			
		 //ComboBox
		 Option =  new JComboBox<String>();
		 
			//καθορισμος πιθανων τιμων combobox
			Option.addItem(man);
				Option.addItem(woman);
					Option.addItem(nonofabove);
					
		
		 //Σύνδεση των στοιχειων(buttons κλπ) με τα panels
		 //panel1
		 Panel1.add(Infos,Panel1.CENTER_ALIGNMENT);	
		 //panel6		
		 Panel6.add(name);
			Panel6.add(Name);
				Panel6.add(surname);
		 			Panel6.add(Surname);
						Panel6.add(phone_number);
							Panel6.add(Phone_Number);
								Panel6.add(username);
									Panel6.add(Username);
										Panel6.add(password);
											Panel6.add(Password);
												Panel6.add(Gender);
													Panel6.add(Option);
														Panel7.setBackground(Color.white);
		Panel7.add(create,Panel7.CENTER_ALIGNMENT);
		
		//Panel5
			Panel5.add(back,BorderLayout.WEST);
		
		//συνδεση μεταξυ Panels
		//συνδεση του panel1 με το κυριο Panel
		Panel.add(Panel1,BorderLayout.NORTH);
			Panel.add(Panel2,BorderLayout.WEST);
				Panel.add(Panel3,BorderLayout.CENTER);
					Panel.add(Panel4,BorderLayout.EAST);
						Panel.add(Panel5,BorderLayout.SOUTH);
		//Panel7  με το Panel5
		
		//συνδεση Panel6 με το Panel3
		Panel3.add(Panel6,Panel3.CENTER_ALIGNMENT);
		//PANEL7 ME PANEL5
		Panel5.add(Panel7,BorderLayout.NORTH);
		
		create.addActionListener(this);
		back.addActionListener(this);
		ImageIcon  icon = new ImageIcon("cinema_logo.jpg");
		
		this.setSize(350,350);
		this.setIconImage(icon.getImage());
		this.setContentPane(Panel);
		this.setVisible(true);
		
		this.setResizable(false);
		this.setTitle("Δημιουργία Λογαριασμού Χρήστη");
		this.setDefaultCloseOperation(MainFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	
	
	
	 @Override
	 public void actionPerformed(ActionEvent e) {
		String userID = Username.getText();
		String password = String.valueOf(Password.getPassword());
		if (e.getSource().equals(create))
		{
			Database.allCredentials.put(userID, password);
//			idandPasswords.AddInfo(userID, password);
			JOptionPane.showMessageDialog(null,"Ο υπάλληλος προστέθηκε με επιτυχία");
		}
		if(e.getSource().equals(back))
		{
			frame.dispose();
		}
	  } 
	
	 
	
}
