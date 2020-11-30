package view;

import model.RegisteredUser;

/**
 * The class MainAppView extends JPanel and is used to persent the view to the user when they either login or if they continue as a guest
 * @author Ahmed Amer, Yassin Bayoumy, Bikramjeet
 * @version 1.0
 * @since November 29, 2020
 */
public class MainAppView extends javax.swing.JPanel {

        private RegisteredUser user;

        /**
         * The Constructor used to initialize the class variables and initialize all the JPanel components
         * @param u  A RegisteredUser class that will hold the information about a registered user. null if the user is not logged in.
         */
        public MainAppView(RegisteredUser u) {
                user = u;
                initComponents();
        }

        /**
         * The initCompoinents method initializes, adds, formats and manages all the JPanel components that will be added to the view.
         */
        private void initComponents() {
                //initialize components
                title = new javax.swing.JLabel();
                browseButton = new javax.swing.JButton();
                cancelTicketButton = new javax.swing.JButton();
                loginStatusLabel = new javax.swing.JLabel();

                //sets up the JPanel
                setBackground(new java.awt.Color(255, 153, 204));
                setPreferredSize(new java.awt.Dimension(850, 480));

                //Assigns all of the Compenents with values and proper formating
                title.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
                title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                title.setText("Movie Ticket Purchasing App");

                browseButton.setBackground(new java.awt.Color(255, 204, 204));
                browseButton.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
                browseButton.setText("Browse Movies");
                browseButton.setToolTipText("Browse the Movie Catalogue");
                browseButton.setBorder(
                                javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                browseButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                browseButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                browseButton.setSelected(true);

                cancelTicketButton.setBackground(new java.awt.Color(255, 204, 204));
                cancelTicketButton.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
                cancelTicketButton.setText("Cancel Ticket");
                cancelTicketButton.setToolTipText("Cancel A Ticket You Previously Purchased");
                cancelTicketButton.setBorder(
                                javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                cancelTicketButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                cancelTicketButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                cancelTicketButton.setSelected(true);

                loginStatusLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
                if (user != null)
                        loginStatusLabel.setText("Logged in as: " + user.getEmail());
                else
                        loginStatusLabel.setText("Logged in as: Guest");


                //sets up the layout and adds the components to the JPanel.
                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(loginStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 241,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18).addComponent(title).addGap(260, 260, 260))
                                .addGroup(layout.createSequentialGroup().addGap(310, 310, 310).addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(cancelTicketButton,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 220,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(browseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 220,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));
                layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(loginStatusLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(111, 111, 111)
                                                .addComponent(browseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(54, 54, 54)
                                                .addComponent(cancelTicketButton,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 62,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(146, Short.MAX_VALUE)));
        }
        /**
         * The addCancelTicketListener method takes in an ActionListener object as an argument which will be used to be added to the cancelTicketButton
         * @param listener The ActionListener that will monitor the cancelButton.
         */
        public void addCancelTicketListener(java.awt.event.ActionListener listener) {
                cancelTicketButton.addActionListener(listener);
        }

        /**
         * The addMoviesListener method takes in an ActionListener as an argument which will be used to be added to the browseButton.
         * @param listener
         */
        public void addMoviesListener(java.awt.event.ActionListener listener) {
                browseButton.addActionListener(listener);
        }

        // Variables for the JPanel components
        private javax.swing.JButton browseButton;
        private javax.swing.JButton cancelTicketButton;
        private javax.swing.JLabel title;
        private javax.swing.JLabel loginStatusLabel;
        
}
