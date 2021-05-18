import java.util.ArrayList;

public class Room {
	public static ArrayList<Room> Rooms =  new ArrayList<Room>();
    private String RoomID;
    private int capacity;
    private int freeseats;
    private Database database;
    private boolean Seats[];
    private int FreeSeats[];

    public Room(String RoomID,int capacity) {
    this.capacity =  capacity;
    freeseats =  capacity;
    this.RoomID =  RoomID;
    for(int i=0;i<capacity;i++) {
    	Seats[i] = true;//True σημαινει οτι η θεση ειναι αρχικα αδεια
    }
    
    Rooms.add(this);
    }

    public int getCapacity() {
        return capacity;
    }

    public String getRoomID() {
        return RoomID;
    }

    public static ArrayList<Room> getRooms() {
		return Rooms;
	}

	public static void setRooms(ArrayList<Room> rooms) {
		Rooms = rooms;
	}

	public int getFreeseats() {
		return freeseats;
	}

	public void setFreeseats(int freeseats) {
		this.freeseats = freeseats;
	}

	public boolean[] getSeats() {
		return Seats;
	}

	public void setSeats(boolean[] seats) {
		Seats = seats;
	}

	public int[] getFreeSeats() {
		return FreeSeats;
	}

	public void setFreeSeats(int[] freeSeats) {
		FreeSeats = freeSeats;
	}

	public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setRoomID(String roomID) {
        RoomID = roomID;
    }

    public boolean checkCapacity(){
        if(getEmptySeats() == 0)
            return false;
        else
            return true;
    }

    public  int getEmptySeats(){
        int ReservedSeats=0;
        for(Reservation reservations:database.allReservations){
            if(reservations.getRoom().getRoomID() == this.getRoomID()){
                ReservedSeats ++;
            }

        }
        
        freeseats =  capacity - ReservedSeats;
        
        return freeseats;
    }
    
    public void NumberOfFreeSeats() {
    	int j=0;
    	for(int i=0;i<capacity;i++) {
    		if(Seats[i] == true) {
    			FreeSeats[j] = i;
    			j++;
    		}
    	}
    }
}

