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
			ObjectInputStream in = new ObjectInputStream(moviesIn);
			Database.allMovies = (ArrayList<Movie>)in.readObject();


			in.close();
			moviesIn.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

		new MainFrame();
	}

}
