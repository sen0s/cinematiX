
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;


public class AdminFrame extends JFrame implements ActionListener{
	
	

	private JLabel createLabel;
	private JButton createBtn;
	private JLabel deleteLabel;
	private JButton deleteBtn;
	private JLabel statLabel;
	private JButton statBtn;
	private JLabel createRoomLabel;
	private JButton createRoomBtn;
	private JLabel deleteRoomLabel;
	private JButton deleteRoomBtn;
	private JButton logoutBtn;
	private JPanel panel;
	private JFrame frame;
	

	
	
	public AdminFrame()
	{
	
		panel = new JPanel();
		createLabel = new JLabel("���������� ���� ���������� ������");
		createBtn = new JButton("����������");
		deleteLabel = new JLabel("�������� ���������� ������");
		deleteBtn = new JButton("��������");
		statLabel = new JLabel("�������� ����������� ��������");
		createRoomLabel = new JLabel("���������� ���� ��������");
		createRoomBtn = new JButton("����������");
		deleteRoomLabel = new JLabel("�������� ���������� ��������");
		deleteRoomBtn = new JButton("��������");
		statBtn = new JButton("��������");
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
		deleteBtn.setBounds(230,45,100,25);

		panel.add(createRoomLabel);
		panel.add(createRoomBtn);
		createRoomLabel.setBounds(10,80,180,25);
		createRoomBtn.setBounds(230,80,100,25);

		panel.add(deleteRoomLabel);
		panel.add(deleteRoomBtn);
		deleteRoomLabel.setBounds(10, 120, 180,25);
		deleteRoomBtn.setBounds(230, 120,100, 25);

		panel.add(statLabel);
		panel.add(statBtn);
//		statLabel.setBounds();
//		statBtn.setBounds();

		panel.add(logoutBtn);
		logoutBtn.setBounds(10,160,100,25);
		

		
		//ButtonListener listener = new ButtonListener();
		createBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		statBtn.addActionListener(this);
		logoutBtn.addActionListener(this);
		createRoomBtn.addActionListener(this);
		deleteRoomBtn.addActionListener(this);

		ImageIcon icon = new ImageIcon("cinema_logo.jpg");
		this.setIconImage(icon.getImage());

		this.setVisible(true);
		this.setResizable(false);
		this.setSize(400,250);
		this.setTitle("�������� �����������");
		this.setContentPane(panel);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Database.storeData();
			}
		});

	}
	
	


		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if (e.getSource().equals(createBtn))
			{
                new CreateEmployeeFrame(); 
			}
			else if (e.getSource().equals(deleteBtn))
			{
                 new DeleteEmployeeFrame();
			}
			else if (e.getSource().equals(statBtn))
			{

			}
			else if (e.getSource().equals(logoutBtn))
			{
				frame.dispose();
			}
			else if(e.getSource().equals(createRoomBtn)){
				new AddRoomFrame();
			}
			else if(e.getSource().equals(deleteRoomBtn)){
				new DeleteRoomFrame();
			}
	 }
}
