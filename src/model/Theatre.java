package model;

import java.util.ArrayList;

public class Theatre {
    private Address address;
    String name;
    ArrayList<Movie> movieList;

    public Theatre(String name, Address address, ArrayList<Movie> movieList) {
        this.address = address;
        this.name = name;
        this.movieList = movieList;
    }

    // Getters and Setters
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public String toString() {
        return name + ", " + address.toString();
    }
}
