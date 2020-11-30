package view;

import model.Movie;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * The MovieView class is a class extending JPanel intended to display the moies for the user to choose from. The movies listed will have a title and a 
 * picture for the person to choose. 
 * @author Ahmed Amer, Yassin Bayoumy, Bikramjeet
 * @version 1.0
 * @since November 29, 2020
 */
public class MovieView extends JPanel {
    //member variables needed for logic
    private ArrayList<Movie> movieList;
    private int rows;
    private boolean isRegistered;

    /**
     * A Constructor for MovieView that takes in an ArrayList of type Movies as well as a boolean flag indicating whether the user 
     * is logged in or it is a guest using the app. The Constructor will initilize the member variables appropriately and call the init 
     * components method that initilizes the JPanel components. The Constructor will also set the exclusive movies to be invisible to ordinary users.
     * @param movies An ArrayList of type Movie that holds the list of movies needed to be displayed to the screen
     * @param isRegistered The boolean flag indicating whether the user is a logged in "RegisteredUser" or an "OrdinaryUser". True if logged in.
     */
    public MovieView(ArrayList<Movie> movies, boolean isRegistered) {
        movieList = movies;
        this.isRegistered = isRegistered;
        rows = movieList.size() / 3;
        if (movieList.size() % 3 == 1)
            rows++;

        moviesDisplayed = new JLabel[movieList.size()];

        initComponents();
        for (int k = 0; k < movieList.size(); k++) {
            image_scaler(movieList.get(k).getPoster(), moviesDisplayed[k], 200, 275);
        }

    }
    /**
     * The image_scaller method is a method used to scale a normal sized image down to fit inside of a JPanel. The caller has to specify
     * the ImageIcon needed to be scalled down, the JLabel to place the scalled image inside, the width of the JLabel and the height of the JLabel.
     * @param icon      An ImageIcon class that holds the image needed to be scalled
     * @param to        The JLabel for the scalled image to be placed inside
     * @param width     The width of the JLabel
     * @param height    The height of the JLabel
     */
    public void image_scaler(ImageIcon icon, JLabel to, int width, int height) {
        Image img = icon.getImage();
        Image imgScalled = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        icon = new ImageIcon(imgScalled);
        to.setIcon(icon);
    }
    /**
    * The initCompoinents method initializes, adds, formats and manages all the JPanel components that will be added to the view.
    */
    private void initComponents() {
        // initialize components
        title = new JLabel();
        backButton = new JLabel();
        imageContainer = new JPanel();
        imageScroller = new JScrollPane();
        for (int i = 0; i < movieList.size(); i++) {
            moviesDisplayed[i] = new JLabel();

        }

        // setup components
        // main JPanel
        setBackground(new java.awt.Color(255, 153, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(850, 480));
        // backButton
        backButton.setToolTipText("Go back");
        backButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backButton.setMaximumSize(new java.awt.Dimension(30, 30));
        backButton.setMinimumSize(new java.awt.Dimension(30, 30));
        backButton.setPreferredSize(new java.awt.Dimension(30, 30));

        // scroll pane
        imageScroller.setBackground(new java.awt.Color(255, 153, 204));
        imageScroller.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        imageScroller.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        imageScroller.getVerticalScrollBar().setUnitIncrement(16);

        // inner jpanel
        imageContainer.setBackground(new java.awt.Color(255, 153, 204));
        imageContainer.setPreferredSize(new java.awt.Dimension(790, +(rows * 335)));

        // title
        title.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Pick the Movie You Want to View");

        for (int i = 0; i < movieList.size(); i++) {
            moviesDisplayed[i]
                    .setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            moviesDisplayed[i].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            moviesDisplayed[i].setPreferredSize(new java.awt.Dimension(200, 300));
            moviesDisplayed[i].setFont(new java.awt.Font("Comic Sans MS", 0, 12));
            moviesDisplayed[i].setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            moviesDisplayed[i].setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

            if (!movieList.get(i).isReleased())
                moviesDisplayed[i].setText(movieList.get(i).getTitle() + " (Exclusive)");
            else
                moviesDisplayed[i].setText(movieList.get(i).getTitle());
        }
        int i = 0;

        while (i < movieList.size()) {
            if (!movieList.get(i).isReleased() && !isRegistered) {
                i++;
                continue;
            }
            imageContainer.add(moviesDisplayed[i]);
            i++;
        }

        // add components to the main JPanel
        imageScroller.setViewportView(imageContainer);
        layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addContainerGap()
                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup().addGap(58, 58, 58).addComponent(imageScroller,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap()));

        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(title))
                        .addGap(18, 18, 18)
                        .addComponent(imageScroller, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)));

        ImageIcon back = new ImageIcon("src\\Images\\backButton.png");
        image_scaler(back, backButton, 30, 30);

    }

    /**
     * The addBackListener method takes in an MouseListener argument that is added to the backButton. The MouseListener
     * will be monitoring the user to press on the backButton.
     * @param e A MouseListener class used to listen to the backButton
     */
    public void addBackListener(MouseListener e) {
        backButton.addMouseListener(e);
    }
    /**
     * The addMovieListeners method takes in an ArrayList of type MouseListeners. Each MouseListeners is assigned to the 
     * different JLabels holding the movie icons. Each MouseListener monitors the appropriate movie the user clicks on.
     * @param e An ArrayList of MouseListeners
     */
    public void addMovieListners(ArrayList<MouseListener> e) {
        for (int i = 0; i < moviesDisplayed.length; i++) {
            moviesDisplayed[i].addMouseListener(e.get(i));
        }
    }

    /**
     * The getter method getMovie will return the movie from the passed movie list at a given index.
     * @param i The index that is to be returned
     * @return An Object of type Movie
     */
    public Movie getMovie(int i) {
        return movieList.get(i);
    }

    //Variables used for JPanel components.
    private JLabel[] moviesDisplayed;
    private JLabel backButton;
    private JScrollPane imageScroller;
    private JLabel title;
    private JPanel imageContainer;
    private GroupLayout layout;

}