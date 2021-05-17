import java.util.UUID;

public class Reservation {
    static int total = 0;
    private Movie movie;
    private Room room;
    private int seatNumber;
    private String ticketType;
    private UUID reservationID;

    public Reservation(Movie movie, int seatNumber, String ticketType,Room room) {
        this.movie = movie;
        this.seatNumber = seatNumber;
        this.ticketType = ticketType;
        this.reservationID = UUID.randomUUID();
        this.room =  room;
        total++;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public Movie getMovie() {
        return movie;
    }

    public Room getRoom() {
        return room;
    }

    public UUID getReservationID() {
        return reservationID;
    }

    public void setReservationID(UUID reservationID) {
        this.reservationID = reservationID;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public void printInfo() {
        System.out.println("Reservation (" + reservationID + ")");
        System.out.println("<------------------------------------------------>");
        System.out.println("Movie: " + movie.getTitle());
        System.out.println("Seat: " + seatNumber);
    }



}
