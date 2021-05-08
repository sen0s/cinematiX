import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class DeleteEmployeeFrame extends JFrame implements ActionListener {
	private JButton DELETE,Back,Exit;
	private JLabel Username,Password,Title;
	private JTextField UserName1,Password1;
	private JPanel Panel,panel1,panel2,panel3;
	
	DeleteEmployeeFrame(){
		Panel = new JPanel(new BorderLayout());
			panel1 =  new JPanel();
				panel2 = new JPanel(new FlowLayout());
					panel3 = new JPanel( new BorderLayout());
		
		DELETE =  new JButton("DELETE");
			DELETE.setPreferredSize(new Dimension(100,30));
			Back = new JButton("Back");
				Exit = new JButton("Exit");
		
		Username = new JLabel("Username:");
			Password = new JLabel("Password:");
				Title = new JLabel(" INSERT THE FOLLOWNIF INFO'S");
			
			
		UserName1= new JTextField("Ånter the username");
			Password1 = new JTextField("Enter the password");
			
		panel1.setBackground(Color.white);
			panel1.add(Title,panel1.CENTER_ALIGNMENT);
				panel1.setPreferredSize(new Dimension(50,50));		
					Panel.add(panel1,BorderLayout.NORTH);
	
		panel2.setBackground(Color.white);
			panel2.add(Username);
				panel2.add(UserName1);	
					panel2.add(Password);
						panel2.add(Password1);
							panel2.add(DELETE);
								Panel.add(panel2,BorderLayout.CENTER);
								
		panel3.setBackground(Color.white);
			panel3.add(Back,BorderLayout.WEST);
				panel3.add(Exit,BorderLayout.EAST);
					Panel.add(panel3,BorderLayout.SOUTH);
		
		
		
		
		ImageIcon  icon = new ImageIcon("cinema-logo_23-2147503279.jpg");
		this.setSize(400,300);
		this.setIconImage(icon.getImage());
		this.setContentPane(Panel);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("DELETE EMPLOYEE FROM SERVER");
		this.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);	
}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
