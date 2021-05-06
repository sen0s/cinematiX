import javax.swing.*;

public class DeleteMovieFrame extends JFrame {

	private JPanel panel;
	private JLabel titlePrompt;
	private JTextField movieTitle;
	private JButton deleteBtn;
	
	
	public DeleteMovieFrame() {
		ImageIcon icon = new ImageIcon("delete (1).png");
		panel = new JPanel();
		titlePrompt = new JLabel("Τίτλος ταινίας");
		movieTitle = new JTextField(20);
		deleteBtn = new JButton(icon);
		
		panel.add(titlePrompt);
		panel.add(movieTitle);
		panel.add(deleteBtn);
		
		this.setContentPane(panel);
		this.setVisible(true);
		this.setSize(400, 200);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
}
