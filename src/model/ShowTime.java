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

    public void addSeat(Seat s) {
        if (s.getRow() < rowCapacity && s.getCol() < colCapacity)
            seatList.add(s);
    }

    @Override
    public String toString() {
        return startTime.getMonth().getValue() + "/" + startTime.getDayOfMonth() + "/" + startTime.getYear() + ", "
                + startTime.getHour() + ":" + startTime.getMinute();
    }
}
