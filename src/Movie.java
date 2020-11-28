package view;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Movie {
    private String title;
    private String genre;
    private String synopsys;
    private boolean isReleased;
    private ImageIcon poster;
    private ArrayList<ShowTime> showTimeList;

    public Movie(String title, String genre, String synopsys, String posterLocation) {
        this.title = title;
        this.genre = genre;
        this.synopsys = synopsys;
        isReleased = false;
        poster = new ImageIcon(posterLocation);
        showTimeList = new ArrayList<ShowTime>();
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void releaseMovie() {
        isReleased = true;
    }

    public boolean isReleased() {
        return isReleased;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSynopsys() {
        return synopsys;
    }

    public void setSynopsys(String synopsys) {
        this.synopsys = synopsys;
    }
    
    public ImageIcon getPoster(){
        return poster;
    }
    
    public void setPoster(ImageIcon newPoster){//add from loaded image
        poster = newPoster;
    }
    public void setPoster(String newPosterLocation){//add from file system
        poster = new ImageIcon(newPosterLocation);
    }

    public ArrayList<ShowTime> getShowTimeList() {
        return showTimeList;
    }

    public void addShowTime(ShowTime st) {
        showTimeList.add(st);
    }

    @Override
    public String toString() {
        return title + ", " + genre;
    }
}
