import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Database {

    public static ArrayList<Movie> allMovies = new ArrayList<>();
    public static ArrayList<Reservation> allReservations = new ArrayList<>();
    public static HashMap<String, String> employeeCredentials = new HashMap<>();
    public static HashMap<String, String> adminCredentials = new HashMap<>();
    public static HashMap<LocalDateTime, String> timetable = new HashMap<>();


}
