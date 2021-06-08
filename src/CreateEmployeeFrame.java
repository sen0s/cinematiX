import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

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
	private JButton create , back,exit;
	private String man,woman,nonofabove;
	private JFrame frame;
	HashMap<String,String> logininfo = new HashMap<String,String>();
	IDandPasswords idandPasswords = new IDandPasswords();
	
	
	
	CreateEmployeeFrame(){
		
		//������������ string
		man = "Man";
		woman = "Woman";
		nonofabove =  "None Of The Above";
		
		//������������ panels ��� ���������� layout ��� color
		
		Panel = new JPanel();
			Panel1 =  new JPanel();
				Panel2 =  new JPanel();
					Panel3 =  new JPanel();	
						Panel4 =  new JPanel();
							Panel5 =  new  JPanel();
								Panel6 = new JPanel();
									Panel7 = new JPanel();

		//�����������  ��� ������ ��� color , size  ��� layout
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
		
		//������������ ��� JLabel,JButton,JTextField,ComboBox
		//JLabel
		name =  new JLabel("Name");
			surname = new JLabel("Surname");
				phone_number =  new JLabel("Phone_Number");
					username =  new JLabel("UserName");
						password = new JLabel("Password");
							Gender = new JLabel("Gender");
								Infos =  new JLabel(" Insert following info's");
								
		//JButton
		create =  new JButton("CREATE");
			back =  new JButton("Back");
				exit =  new JButton("Exit");
		
		//JTextField
		Name =  new JTextField();	
		 Surname =  new  JTextField();
		 	Phone_Number =  new JTextField();
		 		Username =  new JTextField();
		 			Password = new JPasswordField();
		 			
		frame = this; 			
		 //ComboBox
		 Option =  new JComboBox<String>();
		 
			//���������� ������� ����� combobox
			Option.addItem(man);
				Option.addItem(woman);
					Option.addItem(nonofabove);
					
		
		 //������� ��� ���������(buttons ���) �� �� panels
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
				Panel5.add(exit,BorderLayout.EAST);
		
		//������� ������ Panels
		//������� ��� panel1 �� �� ����� Panel
		Panel.add(Panel1,BorderLayout.NORTH);
			Panel.add(Panel2,BorderLayout.WEST);
				Panel.add(Panel3,BorderLayout.CENTER);
					Panel.add(Panel4,BorderLayout.EAST);
						Panel.add(Panel5,BorderLayout.SOUTH);
		//Panel7  �� �� Panel5
		
		//������� Panel6 �� �� Panel3
		Panel3.add(Panel6,Panel3.CENTER_ALIGNMENT);
		//PANEL7 ME PANEL5
		Panel5.add(Panel7,BorderLayout.NORTH);
		
		create.addActionListener(this);
		back.addActionListener(this);
		exit.addActionListener(this);
		ImageIcon  icon = new ImageIcon("cinema_logo.jpg");
		
		this.setSize(350,350);
		this.setIconImage(icon.getImage());
		this.setContentPane(Panel);
		this.setVisible(true);
		
		this.setResizable(false);
		this.setTitle("Entrance Frame");
		this.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
	}
	
	
	
	 @Override
	 public void actionPerformed(ActionEvent e) {
		String userID = Username.getText();
		String password = String.valueOf(Password.getPassword());
		if (e.getSource().equals(create))
		{
			idandPasswords.AddInfo(userID, password);
			JOptionPane.showMessageDialog(null,"Employee added succesfully!!!"); 
		}
		if(e.getSource().equals(back))
		{
			frame.dispose();
		}
		if(e.getSource().equals(exit))
		{
			frame.dispose();
		}
	  } 
	
	 
	
}
