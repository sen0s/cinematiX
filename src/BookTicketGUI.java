import java.awt.*;

import javax.swing.*;

import com.formdev.flatlaf.FlatLightLaf;

public class BookTicketGUI extends JFrame {
	
	//private ArrayLit<Movie> filmList = new ArrayList<Movie>();
	private String name;
	
	
	private JLabel movieL = new JLabel("     Ταινία: ");
	private JLabel roomL = new JLabel(" Αίθουσα: ");
	private JLabel seatL = new JLabel("       Θέση: ");
	private JLabel nameL = new JLabel(" Ονoμ/μο: ");
	private JComboBox movies = new JComboBox();
	private JComboBox seats = new JComboBox();
	private JButton backButton = new JButton("’κυρο");
	private JButton bookButton = new JButton("Κράτηση");
	private JTextField roomField= new JTextField(" ");
	private JTextField nameField= new JTextField(" ");
	private JCheckBox normalT = new JCheckBox("Κανονικό");
	private JCheckBox childT = new JCheckBox("Παιδικό");
	private JCheckBox studentT = new JCheckBox("Φοιτητικό");
	private JCheckBox multiT = new JCheckBox("Πολυτεκνικο");
	private JPanel panel_1 = new JPanel();
	private JPanel panel_2 = new JPanel();
	private JPanel panel_3 = new JPanel();
	private JFrame frame = new JFrame();
	
	private ImageIcon img= new ImageIcon("ticket icon.png");
	
	
	public BookTicketGUI() {
		
		
		
		Container contentPane = this.getContentPane();
	
        contentPane.setLayout(new GridLayout(6, 2));
        contentPane.add(movieL, BorderLayout.EAST);
        contentPane.add(movies);
        contentPane.add(roomL, BorderLayout.EAST);
        contentPane.add(roomField);
        
        contentPane.add(seatL, BorderLayout.EAST);
        contentPane.add(seats);
        contentPane.add(nameL, BorderLayout.EAST);
        contentPane.add(nameField);
        
        contentPane.add(normalT);
        contentPane.add(childT);
        contentPane.add(studentT);
        contentPane.add(multiT);
        
        panel_3.setLayout(new BorderLayout());
		panel_3.add(backButton, BorderLayout.WEST);
		panel_3.add(bookButton, BorderLayout.EAST);
		
        frame.add(contentPane, BorderLayout.NORTH);
		frame.add(panel_3, BorderLayout.SOUTH);
		

		/*
		ButtonListener listener = new ButtonListener();
		bookButton.addActionListener(listener);
		backButton.addActionListener(listener);
		*/
		
		frame.setIconImage(img.getImage());
		
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(500,230);
		frame.setTitle("Κράτηση Εισητηρίου");
		//.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setDefaultCloseOperation(BookTicketGUI.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}
	
	class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if ( e.getSource().equals(bookButton) ){
				
			}
			else if ( e.getSource().equals(backButton) ){
				//new First_Gui();
			}
		}
		
	}
	
	class CheckboxAction extends AbstractAction {
	    public CheckboxAction(String text) {
	        super(text);
	    }
	 
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        JCheckBox cbLog = (JCheckBox) e.getSource();
	        if (cbLog.isSelected()) {
	            
	        } 
	    }
	}
}
