import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel( new FlatLightLaf() );
		} catch( Exception ex ) {
			System.err.println( "Failed to initialize LaF" );
		}

		try {
			FileInputStream moviesIn = new FileInputStream("allMovies.ser");
			ObjectInputStream mIn = new ObjectInputStream(moviesIn);
			Database.allMovies = (ArrayList<Movie>)mIn.readObject();

			FileInputStream roomsIn = new FileInputStream("allRooms.ser");
			ObjectInputStream rIn = new ObjectInputStream(roomsIn);
			Database.allRooms = (ArrayList<Room>)rIn.readObject();

			FileInputStream reservationsIn = new FileInputStream("allReservations.ser");
			ObjectInputStream resIn = new ObjectInputStream(reservationsIn);
			Database.allReservations = (ArrayList<Reservation>)resIn.readObject();

			mIn.close();
			moviesIn.close();

			rIn.close();
			roomsIn.close();

			resIn.close();
			reservationsIn.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

		for (Room r : Database.allRooms){
			System.out.println("Room ID: " + r.getRoomID() + ", Room capacity: " + r.getCapacity());
		}

		for (Reservation r : Database.allReservations){
			r.print();
		}

		new MainFrame();
	}

}
