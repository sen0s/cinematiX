import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class CreateEmployeeFrame extends JFrame implements ActionListener {

	private JPanel Panel,Panel1,Panel2,Panel3,Panel4,Panel5,Panel6,Panel7;
	private JLabel name,surname,phone_number,UserName,Password,Gender,Infos;
	private JTextField text1,text2,text3,text4,text5;
	private JComboBox<String> Option;
	private JButton create , back,exit;
	private String man,woman,nonofabove;
	
	
	
	CreateEmployeeFrame(){
		//αρχικοποιηση string
		man = "Man";
		woman = "Woman";
		nonofabove =  "None Of The Above";
		
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
		name =  new JLabel("Name");
			surname = new JLabel("Surname");
				phone_number =  new JLabel("Phone_Number");
					UserName =  new JLabel("UserName");
						Password = new JLabel("Password");
							Gender = new JLabel("Gender");
								Infos =  new JLabel(" Insert following info's");
								
		//JButton
		create =  new JButton("CREATE");
			back =  new JButton("Back");
				exit =  new JButton("Exit");
		
		//JTextField
		text1 =  new JTextField();	
		 text2 =  new  JTextField();
		 	text3 =  new JTextField();
		 		text4 =  new JTextField();
		 			text5 = new JTextField();
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
			Panel6.add(text1);
				Panel6.add(surname);
		 			Panel6.add(text2);
						Panel6.add(phone_number);
							Panel6.add(text3);
								Panel6.add(UserName);
									Panel6.add(text4);
										Panel6.add(Password);
											Panel6.add(text5);
												Panel6.add(Gender);
													Panel6.add(Option);
														Panel7.setBackground(Color.white);
		Panel7.add(create,Panel7.CENTER_ALIGNMENT);
		
		//Panel5
			Panel5.add(back,BorderLayout.WEST);
				Panel5.add(exit,BorderLayout.EAST);
		
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
		
		
		
		 
		ImageIcon  icon = new ImageIcon("cinema-logo_23-2147503279.jpg");
		
		this.setSize(350,350);
		this.setIconImage(icon.getImage());
		this.setContentPane(Panel);
		this.setVisible(true);
		
		this.setResizable(false);
		this.setTitle("Entrance Frame");
		this.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
