import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CreateEmployee extends JFrame implements ActionListener {

	CreateEmployee(){

		
		
		ImageIcon  icon = new ImageIcon("cinema-logo_23-2147503279.jpg");
		
		this.setSize(350,320);
		this.setIconImage(icon.getImage());
		this.setContentPane(Panel);
		this.setVisible(true);
		
		this.setResizable(false);
		this.setTitle("Entrance Frame");
		this.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
