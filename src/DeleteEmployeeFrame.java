import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class DeleteEmployeeFrame extends JFrame implements ActionListener {
	private JButton DELETE,Back;
	private JLabel Username,Password,Title;
	private JTextField UserName1;
	private JPasswordField Password1;
	private JPanel Panel,panel1,panel2,panel3;
	private JFrame frame = this;
	
	DeleteEmployeeFrame(){
		Panel = new JPanel(new BorderLayout());
		panel1 =  new JPanel();
		panel2 = new JPanel(new FlowLayout());
		panel3 = new JPanel( new BorderLayout());
		
		DELETE =  new JButton("Δαγραφή");
		DELETE.setPreferredSize(new Dimension(100,30));
		Back = new JButton("Πίσω");

		
		Username = new JLabel("Username:");
		Password = new JLabel("Password:");
		Title = new JLabel("Καταχώρηση Πληροφοριών Υπαλλήλου");
			
			
		UserName1= new JTextField(30);
		Password1 = new JPasswordField(30);
			
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
		Panel.add(panel3,BorderLayout.SOUTH);

		DELETE.addActionListener(this);
		Back.addActionListener(this);
		
		
		
		ImageIcon  icon = new ImageIcon("cinema_logo.jpg");
		this.setSize(400,300);
		this.setIconImage(icon.getImage());
		this.setContentPane(Panel);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Διαγραφή Λογαρισμού Χρήστη");
		this.setDefaultCloseOperation(MainFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		String userID = UserName1.getText();
		String password = String.valueOf(Password1.getPassword());
		if (e.getSource().equals(DELETE)){
			if(Database.allCredentials.containsKey(userID)) {
				if(Database.allCredentials.get(userID).equals(password)) {
					Database.allCredentials.remove(userID);
					Database.storeData();
					JOptionPane.showMessageDialog(null,"Ο υπάλληλος διαγράφηκε επιτυχώς");
				}
				else {
					JOptionPane.showMessageDialog(null,"Λανθασμένο Username ή Password");
				}
			}
			else {
				JOptionPane.showMessageDialog(null,"Λανθασμένο Username");
			}
		}
		if (e.getSource().equals(Back)){
			frame.dispose();
		}
		
	}
}
