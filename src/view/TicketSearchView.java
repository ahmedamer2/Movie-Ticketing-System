package view;

/**
 * The TicketSearchView class is a class extending JPanel used to present the search for a ticket view 
 * a user sees when searching by ticket id if they want to cancel their ticket.
 * @author Ahmed Amer, Yassin Bayoumy, Bikramjeet
 * @version 1.0
 * @since November 29, 2020
 */
public class TicketSearchView extends javax.swing.JPanel {

        /**
         * The Constructor for the TicketSearchView used to call the initComponents method that will 
         * initialize all of the JPanel components and format them properly.
         */
        public TicketSearchView() {
                initComponents();
        }

        /**
         * The init components method is used to initilaize, format and add the JPanel components 
         * to the JPanel.
         */
        private void initComponents() {

                //Initilize the JPanel components
                Title = new javax.swing.JLabel();
                ticketIDTitle = new javax.swing.JLabel();
                ticketIDField = new javax.swing.JTextField();
                searchButton = new javax.swing.JButton();
                CancelButton = new javax.swing.JButton();

                //Setup the JPanel
                setBackground(new java.awt.Color(255, 153, 204));
                setBorder(new javax.swing.border.MatteBorder(null));
                setPreferredSize(new java.awt.Dimension(850, 480));

                //Assign and format the JPanel components
                Title.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
                Title.setText("Enter the ID of the ticket that you want to Cancel");

                ticketIDTitle.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
                ticketIDTitle.setText("Ticket ID:");

                ticketIDField.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
                ticketIDField.setBorder(javax.swing.BorderFactory.createEtchedBorder());

                searchButton.setBackground(new java.awt.Color(255, 204, 204));
                searchButton.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
                searchButton.setText("Search Ticket");
                searchButton.setToolTipText("Search for the ticket to cancel");
                searchButton.setBorder(
                                javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

                CancelButton.setBackground(new java.awt.Color(255, 204, 204));
                CancelButton.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
                CancelButton.setText("Cancel");
                CancelButton.setToolTipText("Go back to main screen");
                CancelButton.setBorder(
                                javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Title)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup().addContainerGap(308, Short.MAX_VALUE).addGroup(
                                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(CancelButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                232,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(searchButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                232,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(ticketIDField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                232,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(ticketIDTitle,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                232,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 308, Short.MAX_VALUE)));
                layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Title)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69,
                                                                Short.MAX_VALUE)
                                                .addComponent(ticketIDTitle)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ticketIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(79, Short.MAX_VALUE)));
        }

        /**
         * The addCancelListener method takes in an ActionListener object that is added to the cancelButton. The ActionListener
         * will listen for the user to click the cancelButton.
         * @param listener The ActionListener that is added to the cancelButton
         */
        public void addCancelListener(java.awt.event.ActionListener listener) {
                CancelButton.addActionListener(listener);
        }

        /**
         * The addSearchButtonListener method adds an ActionListener object to the searchButton. The ActionListener will
         * listen for the user to click the search button.
         * @param listener The ActionListener added to the searchButton.
         */
        public void addSearchListener(java.awt.event.ActionListener listener) {
                searchButton.addActionListener(listener);
        }

        /**
         * The getter method getTicketID returns the ticket Id that the user enetered into the ticketIDField.
         * @return A String Representing the Id of the ticket the user wishes to find for cancellation.
         */
        public String getTicketID() {
                return ticketIDField.getText();
        }

        // Variables for the JPanel components
        private javax.swing.JButton CancelButton;
        private javax.swing.JLabel Title;
        private javax.swing.JTextField ticketIDField;
        private javax.swing.JLabel ticketIDTitle;
        private javax.swing.JButton searchButton;
}
