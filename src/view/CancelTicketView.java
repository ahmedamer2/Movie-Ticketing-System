package view;

import model.Ticket;

/**
 * The Class CancelTicketView is a class extending JPanel that is made for the Cancellation view. This view will be constructed and called when the user
 * whishes to cancel a ticket that they have previously purchased.
 * @author Ahmed Amer, Yassin Bayoumy, Bikramjeet
 * @version 1.0
 * @since November 29, 2020
 * 
 */
public class CancelTicketView extends javax.swing.JPanel {

        private Ticket ticket;
        private boolean isRegistered;

        /**
         * Constructor for the CancelTicketView that takes in a Ticket and a boolean flag representing a person being logged in. The constructor will 
         * initialize the class variables then call the initComponents function to initialize all JPanel components.
         * @param t The ticket that will be Cancelled
         * @param isRegistered A boolean flag representing login status false if is a guest
         */
        public CancelTicketView(Ticket t, boolean isRegistered) {
                this.isRegistered = isRegistered;
                ticket = t;
                initComponents();
                //sets email field invisible if the person is logged in (i.e the email is already known)
                if (isRegistered) {
                        emailTextField.setVisible(false);
                        email.setVisible(false);
                }
        }

        /**
         * The method initComponents is made to initilaize all components that will be applied to the JPanel. The class will handle all formating and
         * object placement.
         */
        private void initComponents() {

                //initialize the components needed
                title = new javax.swing.JLabel();
                email = new javax.swing.JLabel();
                emailTextField = new javax.swing.JTextField();
                confirmButton = new javax.swing.JButton();
                cancelButton = new javax.swing.JButton();
                ticketInfo = new javax.swing.JLabel();

                //setup JPanel
                setBackground(new java.awt.Color(255, 153, 204));
                setPreferredSize(new java.awt.Dimension(850, 480));

                //Assign all the components and choose the correct fonts
                title.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
                title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                title.setText("Confirm Ticket Cancellation");

                email.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
                email.setText("Email");

                emailTextField.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

                confirmButton.setBackground(new java.awt.Color(255, 204, 204));
                confirmButton.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
                confirmButton.setText("Confirm Cancellation");
                confirmButton.setToolTipText("Cancel your ticket");
                confirmButton.setBorder(
                                javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                confirmButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                confirmButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                confirmButton.setSelected(true);

                cancelButton.setBackground(new java.awt.Color(255, 204, 204));
                cancelButton.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
                cancelButton.setText("Cancel");
                cancelButton.setToolTipText("Go back to main view");
                cancelButton.setBorder(
                                javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                cancelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                cancelButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                cancelButton.setSelected(true);

                ticketInfo.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

                String ticketID = ticket.getTicketID();
                String movieTitle = ticket.getSeat().getShowTime().getMovie().getTitle();
                // mm/dd/yyyy 10:30pm
                String showTime = ticket.getSeat().getShowTime().toString();
                char seatCol = (char) (ticket.getSeat().getCol() + 65);
                String seatPos = ticket.getSeat().getRow() + ", " + seatCol;
                double redeem_amount = ticket.getSeat().getPrice();
                if (!isRegistered)
                        redeem_amount *= 0.85;

                ticketInfo.setText("<html>\n" + "Ticket ID: " + ticketID + "<br />\n" + "Movie Title: " + movieTitle
                                + "<br />\n" + "ShowTime: " + showTime + "<br />\n" + "Seat: " + seatPos
                                + "<br />\n<br />\n<b>Redeem Amount: $" + redeem_amount + "<b/><br />\n</html>"); // NOI18N
                ticketInfo.setVerticalAlignment(javax.swing.SwingConstants.TOP);

                //This code handles the layout for the JPanel and places the components appropriately.
                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(title,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(email,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(emailTextField))
                                                .addGap(270, 270, 270))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(117, 117, 117)
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(ticketInfo)
                                                                .addGroup(layout.createSequentialGroup().addComponent(
                                                                                confirmButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                220,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                185, Short.MAX_VALUE)
                                                                                .addComponent(cancelButton,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                220,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(108, 108, 108)));
                layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup().addContainerGap().addComponent(title)
                                                .addGap(29, 29, 29)
                                                .addComponent(ticketInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 149,
                                                                Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(email)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(confirmButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                62,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(cancelButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                62,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(112, 112, 112)));
        }

        /**
         * The method addCancelListener will take in an ActionListener as an argument and assign it to the 
         * cancelButton which will bring the user back to the main screen.
         * @param listener The ActionListener that will listen for the cancelButton press
         */
        public void addCancelListener(java.awt.event.ActionListener listener) {
                cancelButton.addActionListener(listener);
        }

        /**
         * The method confirmListener will take in an ActionListener as an argument and assign it to the confirmButton
         * which will confirm the cancellation of their ticket.
         * @param listener An ActionListener that willl listen for the confirmButton press
         */
        public void addConfirmListener(java.awt.event.ActionListener listener) {
                confirmButton.addActionListener(listener);
        }

        /**
         * The function getEmail will return the email that the ticket cancellation will be sent to. This method is only called if
         * the user is not logged in
         * @return A String representing the email of the user.
         */
        public String getEmail() {
                return emailTextField.getText();
        }

        /**
         * The getter function getTicket will return the Ticket being used for the cancellation. 
         * @return An object of type Ticket representing the ticket to be cancelled
         */
        public Ticket getTicket() {
                return ticket;
        }

        // Variables for component declaration 
        private javax.swing.JButton cancelButton;
        private javax.swing.JButton confirmButton;
        private javax.swing.JLabel email;
        private javax.swing.JTextField emailTextField;
        private javax.swing.JLabel ticketInfo;
        private javax.swing.JLabel title;
}
