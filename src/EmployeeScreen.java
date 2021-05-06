import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class EmployeeScreen  extends JFrame {
	JLabel Movie_entry,Ticket_res,Res_del,del_movie,Welcome_msg,Employye_tool;
	JButton insert_mv,ticket_res,res_del,movie_del,back;
	JPanel Panel,panel1,panel2,panel3,panel4;
	JFrame JFrame = this;
	

	EmployeeScreen(){
		Panel = new JPanel(new BorderLayout());
			panel1 =  new JPanel();
				panel2 = new JPanel(new GridLayout(4,2,10,10));
					panel3 =  new JPanel(new BorderLayout());
						panel4 = new JPanel();
							panel4.setBackground(Color.white);
						

		Movie_entry =  new JLabel("Movie Entry:");
			Ticket_res =  new JLabel("Ticket Reservation:");
				Res_del =  new JLabel("Reservation Delete");
					del_movie =  new JLabel("Delete Movie");	
						Welcome_msg =  new JLabel("");
							Employye_tool =  new JLabel("EMPLOYEE TOOLS",Employye_tool.CENTER);
		
	    insert_mv = new JButton("INSERT MOVIE");
	    	ticket_res = new JButton("TICKET RES");
	    	
	    		res_del =  new JButton("DEL.RESERVATION");
	 	  			movie_del = new JButton("DELETE MOVIE");	    			
	    				back =  new JButton("Log out");
	    					
	    					
	   panel1.setBackground(Color.white); 
	   panel1.setPreferredSize(new Dimension(50,50));
	    panel1.add(Employye_tool,panel1.CENTER_ALIGNMENT);
	    		
	    			Panel.add(panel1,BorderLayout.NORTH);
	    		
	    
	   panel2.setBackground(Color.white);
	    panel2.add(Movie_entry);
	    	panel2.add(insert_mv);
	    		panel2.add(Ticket_res);
	    			panel2.add(ticket_res);
	    				panel2.add(Res_del);
	    					panel2.add(res_del);
	    						panel2.add(del_movie);
	    							panel2.add(movie_del);
	    							
	    panel4.add(panel2);
	    
	    Panel.add(panel4,BorderLayout.CENTER);
	    
	    
	    
	    panel3.setBackground(Color.white);
		panel3.add(back,BorderLayout.WEST);
		Panel.add(panel3,BorderLayout.SOUTH);
	    
		ButtonListener listener = new ButtonListener();
		insert_mv.addActionListener(listener);
		ticket_res.addActionListener(listener);
		res_del.addActionListener(listener);
		movie_del.addActionListener(listener);
		back.addActionListener(listener);
		
		ImageIcon  icon = new ImageIcon("cinema-logo_23-2147503279.jpg");
		this.setSize(400,300);
		this.setIconImage(icon.getImage());
		this.setContentPane(Panel);
		
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Employee's tools screen");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
	}
	

	class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			if ( e.getSource().equals(insert_mv) ) {
				new AddMovie();
			}
			if ( e.getSource().equals(ticket_res) ){
				new BookTicketGUI();
			}
			if ( e.getSource().equals(res_del) ) {
				
			}
			if ( e.getSource().equals(movie_del) ) {
				new DeleteMovieFrame();
			}
			if ( e.getSource().equals(back) ) {
				JFrame.dispose();
				new EmployeeLogIn();
			}
		
		}
	}
	

}
