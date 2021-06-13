import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Database {

    public static ArrayList<Movie> allMovies = new ArrayList<>();
    public static ArrayList<Reservation> allReservations = new ArrayList<>();
    public static ArrayList<Room> allRooms = new ArrayList<>();
    public static HashMap<String, String> allCredentials = new HashMap<>();
    public static HashMap<LocalDateTime, String> timetable = new HashMap<>();

    public static Movie getMovieFromTitle(String title){
        Movie selectedMovie = null;

        for (Movie m : allMovies){
            if (title.equals(m.getTitle())){
                selectedMovie = m;
                break;
            }
        }

        return selectedMovie;
    }

    public static Room getRoomFromID(String ID) {
        Room selectedRoom = null;

        for(Room r : allRooms){
            if (ID.equals(r.getRoomID())){
                selectedRoom = r;
                break;
            }
        }

        return selectedRoom;
    }
    
    public static Reservation getReservationFromID(UUID ID) {
    	Reservation selectedReservation = null;

        for(Reservation r : allReservations){
            if (ID == r.getReservationID()){
            	selectedReservation = r;
                break;
            }
        }

        return selectedReservation;
    }

    public static void storeData() {
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

            FileOutputStream credentialsOut = new FileOutputStream("allCredentials.ser");
            credentialsOut.write("".getBytes());
            ObjectOutputStream cOut = new ObjectOutputStream(credentialsOut);
            cOut.writeObject(Database.allCredentials);

            mOut.close();
            moviesOut.close();

            rOut.close();
            roomsOut.close();

            resOut.close();
            reservationsOut.close();

            cOut.close();
            credentialsOut.close();
        }
        catch(IOException i) {
            i.printStackTrace();
        }
    }

    public static void readData() {
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

            FileInputStream credentialsIn = new FileInputStream("allCredentials.ser");
            ObjectInputStream cIn = new ObjectInputStream(credentialsIn);
            Database.allCredentials = (HashMap<String, String>)cIn.readObject();

            mIn.close();
            moviesIn.close();

            rIn.close();
            roomsIn.close();

            resIn.close();
            reservationsIn.close();

            cIn.close();
            credentialsIn.close();
        }
        catch(IOException i) {
            System.out.println("An error occured when reading Data...");
            //i.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
