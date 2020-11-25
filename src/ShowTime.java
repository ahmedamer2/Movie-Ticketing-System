import java.time.LocalDateTime;
import java.util.ArrayList;

public class ShowTime {
    private LocalDateTime startTime;
    private ArrayList<Seat> seatList;

    public ShowTime(LocalDateTime startTime, ArrayList<Seat> seatList) {
        this.startTime = startTime;
        this.seatList = seatList;
    }

    // Getters and Setters
    public ArrayList<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(ArrayList<Seat> seatList) {
        this.seatList = seatList;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
}
