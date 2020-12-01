package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * This class represents the ShowTime of the Movie in the Theatre and store all of its details
 * @author Ahmed Amer, Yassin Bayoumy, Bikramjeet Singh Atwal
 * @version 1.0
 * @since November 29, 2020
 */
public class ShowTime {
    private Movie movie;
    private LocalDateTime startTime;
    private int rowCapacity;
    private int colCapacity;
    private ArrayList<Seat> seatList;

    /**
     * This is contructor of ShowTime which takes in all the details of the ShowTime and creates a new ShowTime
     * @param startTime this is a variable of type LocalDateTime representing the start time of the show time
     * @param rowCapacity this is a variable of type int representing the row capacity of the show time
     * @param colCapacity this is a variable of type int representing the coloumn capacity of the show time
     * @param m this is an object of type Movie representing the Movie to which the show time belongs
     */
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
    /**
     * getter function used to get the list of all the seats in the ShowTime
     * @return returns an ArrayList of type Seat representing seatList in the ShowTime
     */
    public ArrayList<Seat> getSeatList() {
        return seatList;
    }

    /**
     * getter function used to get the colCapacity of ShowTime
     * @return returns a variable of type int representing the coloumn capacity of ShowTime
     */
    public int getColCapacity() {
        return colCapacity;
    }

    /**
     * getter function used to get the rowCapacity of ShowTime
     * @return returns a variable of type int representing the row capacity of ShowTime
     */
    public int getRowCapacity() {
        return rowCapacity;
    }
    
    /**
     * getter function used to get the startTime of ShowTime
     * @return returns a variable of type LocalDateTime representing the start time of ShowTime
     */
    public LocalDateTime getStartTime() {
        return startTime;
    }

    /**
     * setter function used to set the startTime of ShowTime to startTime passed as an argument
     * @param startTime this is a variable of type LocalDateTime representing the start time of ShowTime
     */
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    /**
     * getter function used to get the movie of ShowTime
     * @return returns an object of type Movie representing the Movie of ShowTime
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * This function is used to create Seat(s) in a ShowTime by adding  a new Seat to then seatList
     */
    public void createSeats() {
        for (int i = 0; i < rowCapacity; i++) {
            for (int j = 0; j < colCapacity; j++) {
                seatList.add(new Seat(i, j, 20, this));
            }
        }
    }

    @Override
    /**
     * This functions is used to get all the details of the ShowTime
     * @return returns String representing the details of the ShowTime
     */
    public String toString() {
        return startTime.getMonth().getValue() + "/" + startTime.getDayOfMonth() + "/" + startTime.getYear() + ", "
                + startTime.getHour() + ":" + startTime.getMinute();
    }
}
