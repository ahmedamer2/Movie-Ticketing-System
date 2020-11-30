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
    public Movie(String title, String genre, String synopsys, String posterLocation) {
        this.title = title;
        this.genre = genre;
        this.synopsys = synopsys;
        isReleased = false;
        poster = new ImageIcon(posterLocation);
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
     * setter the function used to set the title of the Movie to the title of type String
     * which is passed as an argument
     * @param title String representing the title of the Movie
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return returns String 
     */
    public String getGenre() {
        return genre;
    }

    /**
     * setter the function used to set the title of the Movie to the title of type String
     * which is passed as an argument
     * @param genre String representing the title of the Movie
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSynopsys() {
        return synopsys;
    }

    public void setSynopsys(String synopsys) {
        this.synopsys = synopsys;
    }

    public ImageIcon getPoster() {
        return poster;
    }

    public void setPoster(ImageIcon newPoster) {// add from loaded image
        poster = newPoster;
    }

    public void setPoster(String newPosterLocation) {// add from file system
        poster = new ImageIcon(newPosterLocation);
    }

    public ArrayList<ShowTime> getShowTimeList() {
        return showTimeList;
    }

    public void addShowTime(ShowTime st) {
        showTimeList.add(st);
        if (showTimeList.size() > 10) {
            System.err.println("Max ShowTime Amount: 10");
            System.exit(0);
        }
    }

    @Override
    public String toString() {
        return title + ", " + genre;
    }
}
