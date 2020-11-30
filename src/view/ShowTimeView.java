package view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.Movie;
import model.ShowTime;

/**
 * The ShowTimeView is a class extending JPanel used to display the showTimeView to the user for them to pick the appropriate Showtime.
 * @author Ahmed Amer, Yassin Bayoumy, Bikramjeet
 * @version 1.0
 * @since November 29, 2020
 */
public class ShowTimeView extends javax.swing.JPanel {
    //member variables
        Movie theMovie;

        /**
         * The Constructor for the ShowTimeView class that takes in a Movie object as an argument to represent the showtimes for it. The class
         * will initialize the member variable and call the initComponents method responsible for initializing the JPanel components and setting them up.
         * @param theMovie The Movie that the Showtimes need to be displayed for.
         */
        public ShowTimeView(Movie theMovie) {
                this.theMovie = theMovie;
                initComponents();

                image_scaler(theMovie.getPoster(), moviePicture, 160, 200);

                ArrayList<ShowTime> stList = theMovie.getShowTimeList();
                int i = 0;
                for (; i < stList.size(); i++) {
                showTimeButtons[i].setText(stList.get(i).toString());
                }
                for (; i < 10; i++) {
                showTimeButtons[i].setVisible(false);
                }
                setPreferredSize(new Dimension(850, 480));
        }

        /**
         * The image_scaller method is a method that takes in an ImageIcon object and resizes it to fit inside of a specified
         * JLabel with the specified width and height.
         * @param icon The ImageIcon needed to be resized.
         * @param to The JLabel where the icon will be placed.
         * @param width The width of the scalled image.
         * @param height The height of the scalled image.
         */
        public void image_scaler(ImageIcon icon, JLabel to, int width, int height) {
                Image img = icon.getImage();
                Image imgScalled = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                icon = new ImageIcon(imgScalled);
                to.setIcon(icon);
        }

        /**
         * The initComponents method is used to initilaize all of the JPanel components as well as format and add them to 
         * the JPanel
         */
        private void initComponents() {
                //initialize the components
                title = new javax.swing.JLabel();
                moviePicture = new javax.swing.JLabel();
                movieInfo = new javax.swing.JLabel();
                seperator = new javax.swing.JSeparator();
                showTimeButtons = new javax.swing.JButton[10];
                backButton = new javax.swing.JButton();

                //setup JPanel
                setBackground(new java.awt.Color(255, 153, 204));

                //Assign and format the Components
                title.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
                title.setText("Pick A Showtime\n");
                title.setToolTipText("");

                moviePicture.setText("jLabel1");
                moviePicture.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                moviePicture.setPreferredSize(new Dimension(160, 200));

                movieInfo.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
                movieInfo.setText("<html>\nMovie Title:  " + theMovie.getTitle() + "<br />\nGenre : " + theMovie.getGenre()
                        + "<br />\nSynopsys: " + theMovie.getSynopsys() + "<br/>\n</html>");
                movieInfo.setToolTipText("");
                movieInfo.setVerticalAlignment(javax.swing.SwingConstants.TOP);

                seperator.setBackground(new java.awt.Color(0, 0, 0));

                for (int i = 0; i < showTimeButtons.length; i++) {
                showTimeButtons[i] = new javax.swing.JButton();
                showTimeButtons[i].setBackground(new java.awt.Color(255, 204, 204));
                showTimeButtons[i].setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
                showTimeButtons[i]
                        .setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                showTimeButtons[i].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                }

                backButton.setBackground(new java.awt.Color(255, 204, 204));
                backButton.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
                backButton.setText("Back");
                backButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

                //Setup the layout and add the components to the JPanel
                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                                                layout.createSequentialGroup()
                                                        .addComponent(moviePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 160,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18).addComponent(movieInfo))
                                        .addComponent(seperator).addGroup(layout.createSequentialGroup().addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                                                        .createSequentialGroup()
                                                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(276, 276, 276).addComponent(title))
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addComponent(showTimeButtons[0],
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(showTimeButtons[1],
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(showTimeButtons[2],
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(showTimeButtons[3],
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18).addComponent(
                                                                        showTimeButtons[4],
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addComponent(showTimeButtons[5],
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(showTimeButtons[6],
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(showTimeButtons[7],
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(showTimeButtons[8],
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18).addComponent(showTimeButtons[9],
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 8, Short.MAX_VALUE)))
                                        .addContainerGap()));
                layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                        .createSequentialGroup().addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(moviePicture, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(movieInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(
                                seperator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(showTimeButtons[0], javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(showTimeButtons[1], javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(showTimeButtons[2], javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(showTimeButtons[3], javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(showTimeButtons[4], javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(showTimeButtons[5], javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(showTimeButtons[6], javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(showTimeButtons[7], javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(showTimeButtons[8], javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(showTimeButtons[9], javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(65, Short.MAX_VALUE)));
        }

        // Variables representing the JPanel Components
        private javax.swing.JLabel movieInfo;
        private javax.swing.JLabel moviePicture;
        private javax.swing.JSeparator seperator;
        private javax.swing.JButton showTimeButtons[];
        private javax.swing.JButton backButton;
        private javax.swing.JLabel title;
        
        /**
         * The addShowTimeListeners method takes in an ArrayList of type ActionListeners that will be added to each button
         * representing a different showtime.
         * @param e An ArrayList of type ActionListener. Each ACtionListener is appropiately assigned to a button
         */
        public void addShowTimeListeners(ArrayList<ActionListener> e) {
                for (int i = 0; i < e.size(); i++) {
                showTimeButtons[i].addActionListener(e.get(i));
                }
        }

        /**
         * The addBackListener method takes in an ActionListener that will be added to the backButton. The ActionListener will
         * listen for the user to click the backButton.
         * @param e The ActionListener that will listen to the backButton.
         */
        public void addBackListener(ActionListener e) {
                backButton.addActionListener(e);
        }

        /**
         * The getter method getShowTime returns a ShowTime from the showtime list given an index.
         * @param i index for the showtime to be accessed.
         * @return The Showtime that the user picked.
         */
        public ShowTime getShowTime(int i) {
                return theMovie.getShowTimeList().get(i);
        }
}
