package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ShowTime {
    private Movie movie;
    private LocalDateTime startTime;
    private int rowCapacity;
    private int colCapacity;
    private ArrayList<Seat> seatList;

    public ShowTime(LocalDateTime startTime, int rowCapacity, int colCapacity, Movie m) {
        if (rowCapacity > 5 || colCapacity > 10) {
            System.err.println("Row Capacity Limit: 5. Col Capacity Limit: 10");
            System.exit(0);
        }
        this.startTime = startTime;
        this.rowCapacity = rowCapacity;
        this.colCapacity = colCapacity;
        this.movie = m;
        m.addShowTime(this);
        seatList = new ArrayList<Seat>();
    }

    // Getters and Setters
    public ArrayList<Seat> getSeatList() {
        return seatList;
    }

    public int getColCapacity() {
        return colCapacity;
    }

    public int getRowCapacity() {
        return rowCapacity;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void createSeats() {
        for (int i = 0; i < rowCapacity; i++) {
            for (int j = 0; j < colCapacity; j++) {
                seatList.add(new Seat(i, j, 20, this));
            }
        }
    }

    @Override
    public String toString() {
        return startTime.getMonth().getValue() + "/" + startTime.getDayOfMonth() + "/" + startTime.getYear() + ", "
                + startTime.getHour() + ":" + startTime.getMinute();
    }
}
