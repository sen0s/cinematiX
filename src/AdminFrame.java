import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AdminFrame extends JFrame{
	
	

	private JLabel createLabel;
	private JButton createBtn;
	private JLabel deleteLabel;
	private JButton deleteBtn;
	private JLabel statLabel;
	private JButton statBtn;
	private JButton logoutBtn;
	private JPanel panel;
	private JFrame frame;
	
	
	public AdminFrame()
	{
		panel = new JPanel();
		createLabel = new JLabel("Δημιουργία νέου λογαρισμού χρήστη");
		createBtn = new JButton("Δημιουργία");
		deleteLabel = new JLabel("Διαγραφή λογαρισμού χρήστη");
		deleteBtn = new JButton("Διαγραφή");
		statLabel = new JLabel("Εμφάνιση στατιστικής ανάλυσης");
		statBtn = new JButton("Εμφάνιση");
		logoutBtn = new JButton("Logout");
		frame = this;

		panel.setLayout(null);

		panel.add(createLabel);
		createLabel.setBounds(10,10,210,25);

		panel.add(createBtn);
		createBtn.setBounds(230,10,100,25);

		panel.add(deleteLabel);
		panel.add(deleteBtn);
		deleteLabel.setBounds(10,45,170,25);
		deleteBtn.setBounds(190,45,100,25);

		panel.add(statLabel);
		panel.add(statBtn);
		statLabel.setBounds(10,80,180,25);
		statBtn.setBounds(200,80,100,25);

		panel.add(logoutBtn);
		logoutBtn.setBounds(10,128,100,25);
		

		
		ButtonListener listener = new ButtonListener();
		createBtn.addActionListener(listener);
		deleteBtn.addActionListener(listener);
		statBtn.addActionListener(listener);
		logoutBtn.addActionListener(listener);



		this.setVisible(true);
		this.setResizable(false);
		this.setSize(400,200);
		this.setTitle("Παράθυρο Διαχειριστή");
		this.setContentPane(panel);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	
	class ButtonListener implements ActionListener {


		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if (e.getSource().equals(createBtn))
			{

			}
			else if (e.getSource().equals(deleteBtn))
			{

			}
			else if (e.getSource().equals(statBtn))
			{

			}
			else if (e.getSource().equals(logoutBtn))
			{
				frame.dispose();
			}
		
			
			
			
			
		}
		
		
		
	}
	

}
