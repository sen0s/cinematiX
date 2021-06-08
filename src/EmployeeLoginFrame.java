import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

public class EmployeeLoginFrame extends JFrame {
	private JButton loginBtn, abortBtn;
	private JLabel usernameLabel, passwordLabel;
	private JTextField userIDField = new JTextField();;
	private JPasswordField userPasswordField = new JPasswordField();
	private JPanel panel;
	private JFrame frame = this;
	private ButtonListener listener;
	HashMap<String,String> logininfo = new HashMap<String,String>();
	 
	
	EmployeeLoginFrame(HashMap<String,String> loginInfoOriginal){
		
		logininfo = loginInfoOriginal;

		panel = new JPanel();
		panel.setLayout(null);
		listener = new ButtonListener();


		loginBtn = new JButton("�������");
		panel.add(loginBtn);
		loginBtn.setBounds(10,70,90,25);
		loginBtn.addActionListener(listener);

		abortBtn = new JButton("�����");
		panel.add(abortBtn);
		abortBtn.setBounds(120,70,80,25);
		abortBtn.addActionListener(listener);

		usernameLabel = new JLabel("����� ������");
		panel.add(usernameLabel);
		usernameLabel.setBounds(10,10,90,25);

		passwordLabel = new JLabel("�����������");
		panel.add(passwordLabel);
		passwordLabel.setBounds(10,40,80,25);

		userIDField = new JTextField();
		panel.add(userIDField);
		userIDField.setBounds(105,13,150,20);

		
		panel.add(userPasswordField);
		userPasswordField.setBounds(105,43,120,20);
		
		ImageIcon  icon = new ImageIcon("cinema_logo.jpg");
		this.setSize(350, 150);
		this.setIconImage(icon.getImage());
		this.setContentPane(panel);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("������� ���������");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
	}

	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if ( e.getSource().equals(loginBtn) ){
				String userID = userIDField.getText();
				String password = String.valueOf(userPasswordField.getPassword());
				if(logininfo.containsKey(userID)) {
					if(logininfo.get(userID).equals(password)) {
						frame.dispose();
						new EmployeeFrame();
					}
			    }
				else {
					JOptionPane.showMessageDialog(null, "Wrong Password or ID");
				}
			
	         }
			 if ( e.getSource().equals(abortBtn) ){
				frame.dispose();
			 }

		}
	}
}
