import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class Room implements Serializable {

    private String RoomID;
    private int capacity;
    private ArrayList<Boolean> seats;
    private HashMap<String,Room> Reservation;
    private ArrayList<String> Screenings;
    

	public Room (String RoomID,int capacity) {
		Screenings = new ArrayList<String>();
		Reservation = new HashMap<String,Room>();
        this.capacity =  capacity;
        this.RoomID =  RoomID;

        this.seats = new ArrayList<>();
        for(int i=0;i<capacity;i++) {
            this.seats.add(true); 
        }

        for(Boolean b : seats) {
            System.out.println(b);
        }
    }
	  public ArrayList<String> getScreenings() {
			return Screenings;
		}

		public void setScreenings(ArrayList<String> screenings) {
			Screenings = screenings;
		}
		
		public void AddDateScreening(String date) {
			Screenings.add(date);
		}
	    public ArrayList<Boolean> getSeats() {
			return seats;
		}

		public void setSeats(ArrayList<Boolean> seats) {
			this.seats = seats;
		}

		public HashMap<String, Room> getReservation() {
			return Reservation;
		}

		public void setReservation(HashMap<String, Room> reservation) {
			Reservation = reservation;
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
        seats.add(seatNumber, false);
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

