package model;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * This class represents a Movie  
 * @author Ahmed Amer, Yassin Bayoumy, Bikramjeet Singh Atwal
 * @version 1.0
 * @since November 29, 2020
 */
public class Movie {
    private String title;
    private String genre;
    private String synopsys;
    private boolean isReleased;
    private ImageIcon poster;
    private ArrayList<ShowTime> showTimeList;

    /**
     * This is the constructor of Movie whic takes in all the various details of a movie 
     * and creates a new Movie
     * @param title String representing the title of the Movie
     * @param genre String representing the genre of the Movie
     * @param synopsys String representing the synopsys(summary) of the Movie
     * @param posterLocation String representing the locaton where the poster(image) of Movie is stored
     */
    public Movie(String title, String genre, String synopsys, ImageIcon poster) {
        this.title = title;
        this.genre = genre;
        this.synopsys = synopsys;
        isReleased = false;
        this.poster = poster;
        showTimeList = new ArrayList<ShowTime>();
    }

    // Getters and Setters

    /**
     * getter function which returns the title of the Movie
     * @return returns String representing the title of the Movie
     */
    public String getTitle() {
        return title;
    }

    /**
     * This function is used to release a Movie by setting the isReleased of 
     * type boolean to true
     */
    public void releaseMovie() {
        isReleased = true;
    }

    /**
     * This function checks if the Movie has been released or not
     * @return boolean which represents if the Movie is released(true) or not(false)
     */
    public boolean isReleased() {
        return isReleased;
    }

    /**
     * setter function used to set the title of the Movie to the title of type String
     * which is passed as an argument
     * @param title String representing the title of the Movie
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * getter function used to get the genre of the Movie
     * @return returns String representing the genre of the Movie
     */
    public String getGenre() {
        return genre;
    }

    /**
     * setter function which sets the genre of the Movie to the genre of type String
     * which is passed as an argument
     * @param genre String representing the genre of the Movie
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    /**
     * getter function which gets the synopsys of the Movie
     * @return returns String representing the synopsys of the Movie
     */
    public String getSynopsys() {
        return synopsys;
    }

    /**
     * setter function used to set the synopys of the Movie to the synopys of type String which
     * is passed as an argument  
     * @param synopsys String representing the desired synopys to be set for the Movie 
     */
    public void setSynopsys(String synopsys) {
        this.synopsys = synopsys;
    }

    /**
     * getter function used to get the poster of the Movie
     * @return returns poster of type ImageIcon representing the poster of the Movie
     */
    public ImageIcon getPoster() {
        return poster;
    }

    /**
     * setter function which sets the poster of the Movie as the newPoster which is passed as an argument 
     * @param newPoster ImageIcon representing the desired poster for the Movie
     */
    public void setPoster(ImageIcon newPoster) {// add from loaded image
        poster = newPoster;
    }

    /**
     * setter function used to set the location of the poster of the Movie to the newPosterLocation 
     * which is passed as an argument
     * @param newPosterLocation String representing the location where the poster of the Movie is present.
     */
    public void setPoster(String newPosterLocation) {// add from file system
        poster = new ImageIcon(newPosterLocation);
    }

    /**
     * getter function used to get the ArrayList of ShowTime(s) for the Movie
     * @return returns ArrayList representing the list of all the ShowTime(s) of the Movie
     */
    public ArrayList<ShowTime> getShowTimeList() {
        return showTimeList;
    }

    /**
     * this function is used for adding a ShowTime of the Movie to the showTimeList 
     * which represents list of all the ShowTime(s)
     * @param st this is an object of type ShowTime representing the show time for the Movie
     */
    public void addShowTime(ShowTime st) {
        showTimeList.add(st);
        if (showTimeList.size() > 10) {
            System.err.println("Max ShowTime Amount: 10");
            System.exit(0);
        }
    }

    @Override
    /**
     * This function is used to get the title and genre of the Movie 
     * @return returns a String representing the title and genre of the movie
     */
    public String toString() {
        return title + ", " + genre;
    }
}
