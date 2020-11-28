import java.util.ArrayList;

public class Movie {
    private String title;
    private String genre;
    private String synopsys;
    private boolean isReleased;
    private ArrayList<ShowTime> showTimeList;

    public Movie(String title, String genre, String synopsys) {
        this.title = title;
        this.genre = genre;
        this.synopsys = synopsys;
        isReleased = false;
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
