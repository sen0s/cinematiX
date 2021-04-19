import java.util.UUID;

public class Reservation {

    private Movie movie;
    //private Room room;
    private int seatNumber;
    private String ticketType;
    private UUID reservationID;

    public Reservation(Movie movie, int seatNumber, String ticketType) {
        this.movie = movie;
        this.seatNumber = seatNumber;
        this.ticketType = ticketType;
        this.reservationID = UUID.randomUUID();
    }

    public void printInfo() {
        System.out.println("Reservation (" + reservationID + ")");
        System.out.println("<------------------------------------------------>");
        System.out.println("Movie: " + movie.getTitle());
        System.out.println("Seat: " + seatNumber);
    }



}
