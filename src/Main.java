import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;

public class Main {

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel( new FlatLightLaf() );
		} catch( Exception ex ) {
			System.err.println( "Failed to initialize LaF" );
		}

		Database.readData();

//		for (Room r : Database.allRooms){
//			System.out.println("Room ID: " + r.getRoomID() + ", Room capacity: " + r.getCapacity());
//		}
//
//		for (Reservation r : Database.allReservations){
//			r.print();
//		}

		new MainFrame();
	}

}
