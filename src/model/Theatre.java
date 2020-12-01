package model;

import java.util.ArrayList;

/**
 * This class the represents Theatre in which the Movie is being played and stores 
 * all the details of the Theatre
 * @author Ahmed Amer, Yassin Bayoumy, Bikramjeet Singh Atwal
 * @version 1.0
 * @since November 29, 2020
 */
public class Theatre {
    private Address address;
    String name;
    ArrayList<Movie> movieList;

    /**
     * This is a constructor of Theatre which takes in all the details of the Theatre and 
     * creates a new Theatre
     * @param name String representing the name of the Theatre 
     * @param address This is an object of type Address representing the address of the Theatre  
     * @param movieList This is an ArrayList of Movie representing the Movie(s) being played in the Theatre
     */
    public Theatre(String name, Address address, ArrayList<Movie> movieList) {
        this.address = address;
        this.name = name;
        this.movieList = movieList;
    }

    // Getters and Setters
    
    /**
     *getter function used to get the address of the Theatre
     * @return returns an object of type Address representing the address of the Theatre 
     */
    public Address getAddress() {
        return address;
    }

    /**
     * setter function used to set the address of the Theatre to the address passed as an argument
     * @param address this is an an object of type Address representing the address of the Theatre
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     *getter function used to get the name of the Theatre
     * @return returns String representing the name of the Theatre 
     */
    public String getName() {
        return name;
    }

    /**
     * setter function used to set the name of the Theatre to the name passed as an argument
     * @param name String representing the name of the Theatre
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *getter function used to get the movieList of the Theatre
     * @return returns an ArrayList of type Movie representing the Movie(s) of the Theatre 
     */
    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    /**
     * setter function used to set the movieList of the Theatre to the movieList passed as an argument
     * @param movieList this is an an ArrayList of type Movie representing the address of the Theatre
     */
    public void setMovieList(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    /**
     * this functions is used to get name and address of the theatre
     * @return String representing the name and address of the Theatre
     */
    public String toString() {
        return name + ", " + address.toString();
    }
}
