import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import javax.swing.*;



public class MainFrame  extends JFrame {
	
	// ������ ��� �������� ��������� ��� �� ���������� ��� �� gui 
	private JPanel mainPanel, panel1, panel2, panel3;
	private JLabel title;
	private JButton employeeLoginBtn, adminLoginBtn, exitBtn;
	private ButtonListener listener;
	public int String;
	private JFrame frame = this;
	//IDandPasswords idandPasswords = new IDandPasswords();
	
	MainFrame(){
		/*
		 * ��������-������������ ��� JPanels
		 * ������� ������� ��������� ���� �� ����� ��� back ground
		 * ���������� layouts ��� ���� ���������� ���������� ��������
		 */

		mainPanel = new JPanel();
		panel1 =  new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		listener = new ButtonListener();
	

		/*
		 * ��������-������������ ��� JButtons ��� ���������� ��� text-size
		 */

		employeeLoginBtn = new JButton("������� ���������");
		adminLoginBtn = new JButton("������� �����������");
		exitBtn =  new JButton("������");

		/*
		 * ��������-������������ ��� JLabels ��� ���������� ��� ���-FOREGROUND-BACKGROUND
		 */

		title = new JLabel("������� ����������� ��������������");


		/*
		 * �������� �������� ��������� ��� ���������� JPanel ��� ���������� �����
		 */

		mainPanel.setLayout(null);
		panel1.setPreferredSize(new Dimension(280,25));
		panel1.setBounds(0,0,280,25);
		panel2.setBounds(0,35,280,70);
		panel3.setBounds(0,110,280,30);

		panel1.add(title);

		panel2.add(employeeLoginBtn);
		panel2.add(adminLoginBtn);

		panel3.add(exitBtn);
			
		/*
		 * �������� ��� PANEL1-6 ���� ����� ����� (JPanel)
		 */

		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);


		employeeLoginBtn.addActionListener(listener);
		adminLoginBtn.addActionListener(listener);
		exitBtn.addActionListener(listener);
		
		ImageIcon icon = new ImageIcon("cinema_logo.jpg");
		this.setIconImage(icon.getImage());

		this.setSize(280,180);
		this.setContentPane(mainPanel);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("������� ������");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(MainFrame.DO_NOTHING_ON_CLOSE);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				if (JOptionPane.showConfirmDialog(frame,
					"����� �������� ��� ������ �� �������� ���� �� ��������;",
					"�������� ���������;",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
						Database.storeData();
						System.exit(0);
				}

			}
		});
		
	}
	
	class ButtonListener implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e) {
			
		    if ( e.getSource().equals(employeeLoginBtn) ){
				new EmployeeLoginFrame();
			}
			if ( e.getSource().equals(adminLoginBtn) ){
				new AdminLoginFrame();
			}
			if ( e.getSource().equals(exitBtn) ){
				if (JOptionPane.showConfirmDialog(frame,
						"����� �������� ��� ������ �� �������� ���� �� ��������;",
						"�������� ���������;",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
					Database.storeData();
					System.exit(0);
				}
			}
		}
	}

}
