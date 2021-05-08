import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AdminGUI extends JFrame{
	
	
	private JLabel WelcomeBackL;
	private JLabel AdminToolsL;
	private JLabel CreateL;
	private JButton CreateB;
	private JLabel DeleteL;
	private JButton DeleteB;
	private JLabel StatisticsL;
	private JButton StatisticsB;
	private JButton BackB;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JFrame frame;
	
	
	public AdminGUI()
	{

		WelcomeBackL = new JLabel("Welcome back!!!");
		AdminToolsL = new JLabel("Admin tools");
		CreateL = new JLabel("Create an employee account:");
		CreateB = new JButton("Create");
		DeleteL = new JLabel("Delete empoyee's account:");
		DeleteB = new JButton("Delete");
		StatisticsL = new JLabel("Show statistics of cinema:");
		StatisticsB = new JButton("Stats");
		BackB = new JButton("Log out");
		panel_1 = new JPanel();
		panel_2 = new JPanel();
		panel_3 = new JPanel();
		panel_4 = new JPanel();
		frame = new JFrame();
	
		Font font_1 = new Font(null, Font.BOLD,20);
		WelcomeBackL.setFont(font_1);
		Font font_2 = new Font(null, Font.BOLD,18);
		AdminToolsL.setFont(font_2);
		
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		panel_1.add(WelcomeBackL);
		WelcomeBackL.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(Box.createRigidArea(new Dimension(0, 30)));
		panel_1.add(AdminToolsL);
		AdminToolsL.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(Box.createRigidArea(new Dimension(0, 20)));
		
	
		panel_2.setLayout(new BorderLayout());
		panel_2.add(BackB, BorderLayout.WEST);
		
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		panel_3.add(CreateL);
		panel_3.add(Box.createRigidArea(new Dimension(0, 20)));
		panel_3.add(DeleteL);
		panel_3.add(Box.createRigidArea(new Dimension(0, 20)));
		panel_3.add(StatisticsL);
		
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		panel_4.add(CreateB);
		panel_4.add(Box.createRigidArea(new Dimension(0, 12)));
		panel_4.add(DeleteB);
		panel_4.add(Box.createRigidArea(new Dimension(0, 12)));
		panel_4.add(StatisticsB);
		
		ButtonListener listener = new ButtonListener();
		CreateB.addActionListener(listener);
		DeleteB.addActionListener(listener);
		StatisticsB.addActionListener(listener);
		BackB.addActionListener(listener);
		
		frame.add(panel_1, BorderLayout.NORTH);
		frame.add(panel_3, BorderLayout.WEST);
		frame.add(panel_4, BorderLayout.EAST);
		frame.add(panel_2, BorderLayout.SOUTH);

		

	
		
		
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(400,360);
		frame.setTitle("Admin Screen");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}
	
	class ButtonListener implements ActionListener {


		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if (e.getSource().equals(CreateB))
			{
               new CreateEmployee();
			}
			else if (e.getSource().equals(DeleteB))
			{
               new DeleteEmployee();
			}
			else if (e.getSource().equals(StatisticsB))
			{

			}
			else if (e.getSource().equals(BackB))
			{
				frame.dispose();
				new AdminLoginFrame();
			}
		
			
			
			
			
		}
		
		
		
	}
	

}
