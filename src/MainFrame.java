import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import javax.swing.*;



public class MainFrame  extends JFrame {
	
	// ������ ��� �������� ��������� ��� �� ���������� ��� �� gui 
	private JPanel mainPanel, panel1, panel2, panel3;
	private JLabel title;
	private JButton employeeLoginBtn, adminLoginBtn, exitBtn;
	private ButtonListener listener;
	public int String;
	IDandPasswords idandPasswords = new IDandPasswords();
	
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
		
		this.setSize(280,180);
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
		    	
				new EmployeeLoginFrame(idandPasswords.getLoginInfo());
			}
			if ( e.getSource().equals(adminLoginBtn) ){
				new AdminLoginFrame();
			}
			if ( e.getSource().equals(exitBtn) ){

				try {
					FileOutputStream moviesOut = new FileOutputStream("allMovies.ser");
					moviesOut.write("".getBytes());
					ObjectOutputStream mOut = new ObjectOutputStream(moviesOut);
					mOut.writeObject(Database.allMovies);

					FileOutputStream roomsOut = new FileOutputStream("allRooms.ser");
					roomsOut.write("".getBytes());
					ObjectOutputStream rOut = new ObjectOutputStream(roomsOut);
					rOut.writeObject(Database.allRooms);

					FileOutputStream reservationsOut = new FileOutputStream("allReservations.ser");
					reservationsOut.write("".getBytes());
					ObjectOutputStream resOut = new ObjectOutputStream(reservationsOut);
					resOut.writeObject(Database.allReservations);

					mOut.close();
					moviesOut.close();

					rOut.close();
					roomsOut.close();

					resOut.close();
					reservationsOut.close();
				}
				catch(IOException i) {
					i.printStackTrace();
				}

				System.exit(1);
			}
		}
	}

}
