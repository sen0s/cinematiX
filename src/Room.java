import java.io.Serializable;

public class Room implements Serializable {
    private String RoomID;
    private int capacity;
    private Database database;

    public Room(String RoomID,int capacity) {
    this.capacity =  capacity;
    this.RoomID =  RoomID;
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

    public boolean checkCapacity(){
        if(getEmptySeats() == 0)
            return false;//επιστροφη false  οταν ενα room ειναι γεματο
        else
            return true;//αν εχει κενες θεσεις επιστρεφει true
    }

    public  int getEmptySeats(){
        int ReservedSeats=0;
        for(Reservation reservations:database.allReservations){
            if(reservations.getRoom().getRoomID() == this.getRoomID()){
                ReservedSeats ++;
            }

        }

        return (capacity-ReservedSeats);
    }
}

