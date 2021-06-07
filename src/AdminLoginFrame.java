import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class AdminLoginFrame extends JFrame {
	private JButton loginBtn, abortBtn;
	private JLabel usernameLabel, passwordLabel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JPanel panel;
	private JFrame frame = this;
	private ButtonListener listener;

	
	AdminLoginFrame() {
		panel = new JPanel();
		panel.setLayout(null);

		loginBtn = new JButton("Είσοδος");
		panel.add(loginBtn);
		loginBtn.setBounds(10,70,90,25);

		abortBtn = new JButton("’κυρο");
		panel.add(abortBtn);
		abortBtn.setBounds(120,70,80,25);

		usernameLabel = new JLabel("Όνομα Χρήστη");
		panel.add(usernameLabel);
		usernameLabel.setBounds(10,10,90,25);

		passwordLabel = new JLabel("Συνθηματικό");
		panel.add(passwordLabel);
		passwordLabel.setBounds(10,40,80,25);

		usernameField = new JTextField();
		panel.add(usernameField);
		usernameField.setBounds(105,13,150,20);

		passwordField = new JPasswordField();
		panel.add(passwordField);
		passwordField.setBounds(105,43,120,20);




		listener = new ButtonListener();
		loginBtn.addActionListener(listener);
		abortBtn.addActionListener(listener);



		ImageIcon icon = new ImageIcon("cinema_logo.jpg");
		this.setSize(350, 150);
		this.setIconImage(icon.getImage());
		this.setContentPane(panel);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Είσοδος Διαχειριστή");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
		
	class ButtonListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				String userID = usernameField.getText();
				String password = String.valueOf(passwordField.getPassword());
				if ( e.getSource().equals(loginBtn) ){
					if(userID.equals("Admin") && password.equals("111"))
					{
					 new AdminFrame();
					 frame.dispose();
					}
					else
					{
					  JOptionPane.showMessageDialog(null, "Wrong Password or ID");
					}
				}
				if ( e.getSource().equals(abortBtn) ){
					frame.dispose();
				}

			}
	}
}
