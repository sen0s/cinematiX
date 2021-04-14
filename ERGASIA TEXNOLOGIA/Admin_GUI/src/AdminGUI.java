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
	
	
	private JLabel WelcomeBackL = new JLabel("Welcome back!!!"
			);
	private JLabel AdminToolsL = new JLabel("Admin tools");
	private JLabel CreateL = new JLabel("Create an employee account:");
	private JButton CreateB = new JButton("Create");
	private JLabel DeleteL = new JLabel("Delete empoyee's account:");
	private JButton DeleteB = new JButton("Delete");
	private JLabel StatisticsL = new JLabel("Show statistics of cinema:");
	private JButton StatisticsB = new JButton("Stats");
	private JButton BackB = new JButton("Back");
	private JPanel panel_1 = new JPanel();
	private JPanel panel_2 = new JPanel();
	private JPanel panel_3 = new JPanel();
	private JPanel panel_4 = new JPanel();
	private JFrame frame = new JFrame();
	
	
	public AdminGUI()
	{
	
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
		frame.setDefaultCloseOperation(AdminGUI.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}
	
	class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if (e.getSource().equals(CreateB))
			{
				
			}
			else if (e.getSource().equals(DeleteB))
			{
				
			}
			else if (e.getSource().equals(StatisticsB))
			{
				
			}
			else if (e.getSource().equals(BackB))
			{
				frame.setVisible(false);
			}
		
			
			
			
			
		}
		
		
		
	}
	

}
