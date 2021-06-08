import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Serializable {

    private String RoomID;
    private int capacity;
    private ArrayList<Boolean> seats;

    public Room(String RoomID,int capacity) {

        this.capacity =  capacity;
        this.RoomID =  RoomID;

        this.seats = new ArrayList<>();
        for(int i=0;i<capacity;i++) {
            this.seats.add(true); //True σημαινει οτι η θεση ειναι αρχικα αδεια
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

