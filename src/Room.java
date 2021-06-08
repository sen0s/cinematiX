import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class Room implements Serializable {

    private String RoomID;
    public HashMap<Date, Movie> getScreenings() {
		return Screenings;
	}

	public void setScreenings(HashMap<Date, Movie> screenings) {
		Screenings = screenings;
	}

	private int capacity;
    private ArrayList<Boolean> seats;
    private HashMap<Date,Room> Reservation;
    private HashMap<Date,Movie> Screenings;
    
    public ArrayList<Boolean> getSeats() {
		return seats;
	}

	public void setSeats(ArrayList<Boolean> seats) {
		this.seats = seats;
	}

	public HashMap<Date, Room> getReservation() {
		return Reservation;
	}

	public void setReservation(HashMap<Date, Room> reservation) {
		Reservation = reservation;
	}

	public Room (String RoomID,int capacity) {

        this.capacity =  capacity;
        this.RoomID =  RoomID;

        this.seats = new ArrayList<>();
        for(int i=0;i<capacity;i++) {
            this.seats.add(true); //True ΟƒΞ·ΞΌΞ±ΞΉΞ½ΞµΞΉ ΞΏΟ„ΞΉ Ξ· ΞΈΞµΟƒΞ· ΞµΞΉΞ½Ξ±ΞΉ Ξ±Ο�Ο‡ΞΉΞΊΞ± Ξ±Ξ΄ΞµΞΉΞ±
        }

    }

    public int getCapacity() {
        return capacity;
    }

    public String getRoomID() {
        return RoomID;
    }

	public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setRoomID(String roomID) {
        RoomID = roomID;
    }

    public void reserveSeat(int seatNumber) {
        seats.set(seatNumber-1, false);
    }

    public ArrayList<Integer> getEmptySeats() {
        ArrayList<Integer> emptySeats = new ArrayList<>();

        for (int i=0;i<seats.size();i++){
            if (seats.get(i) == true){
                emptySeats.add(i+1);
            }
        }

        return emptySeats;
    }

}

