import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EmployeeLoginFrame extends JFrame {
	private JButton loginBtn, abortBtn;
	private JLabel usernameLabel, passwordLabel;
	private JTextField usernameField, passwordField;
	private JPanel panel;
	private JFrame frame = this;
	private ButtonListener listener;
	
	EmployeeLoginFrame(){

		panel = new JPanel(new BorderLayout());
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

		usernameField = new JTextField();
		panel.add(usernameField);
		usernameField.setBounds(105,13,150,20);

		passwordField = new JTextField();
		panel.add(passwordField);
		passwordField.setBounds(90,43,120,20);
		
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
				new EmployeeFrame();
				frame.dispose();
			}
			if ( e.getSource().equals(abortBtn) ){
				frame.dispose();
			}
		}
	}
}