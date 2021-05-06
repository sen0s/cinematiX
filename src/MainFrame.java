import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainFrame  extends JFrame {
	
	// ������ ��� �������� ��������� ��� �� ���������� ��� �� gui 
	private JPanel mainPanel, panel1, panel2, panel3;
	private JLabel title;
	private JButton employeeLoginBtn, adminLoginBtn, exitBtn;
	private ButtonListener listener;
	
	MainFrame(){
		/*
		 * ��������-������������ ��� JPanels
		 * ������� ������� ��������� ���� �� ����� ��� back ground
		 * ���������� layouts ��� ���� ���������� ���������� ��������
		 */

		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout(20,20));
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

		title = new JLabel();
		title.setText("������� ����������� ��������������");
		title.setForeground(Color.black);

		/*
		 * �������� �������� ��������� ��� ���������� JPanel ��� ���������� �����
		 */

		panel1.add(title, panel1.CENTER_ALIGNMENT);

		panel2.add(employeeLoginBtn);
		panel2.add(adminLoginBtn);

		panel3.add(exitBtn, panel3.CENTER_ALIGNMENT);
			
		/*
		 * �������� ��� PANEL1-6 ���� ����� ����� (JPanel)
		 */

		mainPanel.add(panel1, BorderLayout.NORTH);
		mainPanel.add(panel2, BorderLayout.CENTER);
		mainPanel.add(panel3, BorderLayout.SOUTH);


		employeeLoginBtn.addActionListener(listener);
		adminLoginBtn.addActionListener(listener);
		exitBtn.addActionListener(listener);
		
		ImageIcon icon = new ImageIcon("cinema_logo.jpg");
		
		this.setSize(350,200);
		this.setIconImage(icon.getImage());
		this.setContentPane(mainPanel);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("������� ������");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
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
				System.exit(1);
			}
		}
	}

}
