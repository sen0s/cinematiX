import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Database {

    public static ArrayList<Movie> allMovies = new ArrayList<>();
    public static ArrayList<Reservation> allReservations = new ArrayList<>();
    public static ArrayList<Room> allRooms = new ArrayList<>();
    public static HashMap<String, String> employeeCredentials = new HashMap<>();
    public static HashMap<String, String> adminCredentials = new HashMap<>();
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
}
