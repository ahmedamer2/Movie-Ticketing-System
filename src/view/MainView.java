package view;

/**
 * The Main view class is a class extending JPanel and is used to present the welcome screen for the user. In this screen the user can
 * either login, register or continue as a guest. 
 * @author Ahmed Amer, Yassin Bayoumy, Bikramjeet
 * @version 1.0
 * @since November 29, 2020
 */
public class MainView extends javax.swing.JPanel {

        /**
         * The default constructor for the MainView class. The Constructor only performs one function which is calling the initComponents method.
         * Using this method, all of the JPanel components are initialized.
         */
        public MainView() {
                initComponents();
        }

        /**
         * The initCompoinents method initializes, adds, formats and manages all the JPanel components that will be added to the view.
         */
        private void initComponents() {
                //initialize the components needed for the Panel
                title = new javax.swing.JLabel();
                continueButton = new javax.swing.JButton();
                loginButton = new javax.swing.JButton();
                registerButton = new javax.swing.JButton();
                exitButton = new javax.swing.JButton();

                //set up the JPanel
                setBackground(new java.awt.Color(255, 153, 204));
                setBorder(new javax.swing.border.MatteBorder(null));
                setToolTipText("Welcome!");
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
                setName("Movie Booking App"); // NOI18N
                setPreferredSize(new java.awt.Dimension(850, 480));

                //assign, format and give values to the Components
                title.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
                title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                title.setText("Movie Ticket Purchasing App");
                title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

                continueButton.setBackground(new java.awt.Color(255, 204, 204));
                continueButton.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
                continueButton.setText("Continue As A Guest");
                continueButton.setToolTipText("Browse the Movie Catalogue");
                continueButton.setBorder(
                                javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                continueButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                continueButton.setSelected(true);

                loginButton.setBackground(new java.awt.Color(255, 204, 204));
                loginButton.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
                loginButton.setText("Login");
                loginButton.setToolTipText("Login to your account");
                loginButton.setBorder(
                                javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

                registerButton.setBackground(new java.awt.Color(255, 204, 204));
                registerButton.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
                registerButton.setText("Register");
                registerButton.setToolTipText("Register for a new account");
                registerButton.setBorder(
                                javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

                exitButton.setBackground(new java.awt.Color(255, 204, 204));
                exitButton.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
                exitButton.setText("Exit");
                exitButton.setBorder(
                                javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                exitButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                exitButtonActionPerformed(evt);
                        }
                });

                //Setup the Layout for the components in the JPanel and add them
                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(209, 209, 209)
                                                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 360,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                194, Short.MAX_VALUE)
                                                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(registerButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                220,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(loginButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                220,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(continueButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                220,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));
                layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                                layout.createSequentialGroup().addContainerGap(34, Short.MAX_VALUE).addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 118,
                                                                Short.MAX_VALUE)
                                                .addGroup(layout.createSequentialGroup().addComponent(exitButton,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29,
                                                                Short.MAX_VALUE)
                                                .addComponent(continueButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(79, 79, 79)));

                loginButton.getAccessibleContext().setAccessibleDescription("");
                registerButton.getAccessibleContext().setAccessibleDescription("");
        }

        /**
         * The exitButtonActionPerformed takes in an ActionEvent that is already setup in the initComponents method. The exit button
         * is responsible for closing the app down.
         * @param evt The ActionEvent assigned to it in the initComponents method.
         */
        private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
        }
        /**
         * The addLoginListener method takes one ActionListener as an argument and adds it to the loginButton.
         * The assigned ActionListener will then listen for the user to click the loginButton which takes them to the login page.
         * @param listener The ActionListener listening for the user to click the loginButton
         */
        public void addLoginListener(java.awt.event.ActionListener listener) {
                loginButton.addActionListener(listener);
        }
        /**
         * The addRegisterListener method takes in one ActionListener as an argument and assigns it to the registerButton.
         * The assigned ActionListener will then listen for the user to click the registerButton which takes them to the registration page
         * @param listener The ActionListener that will be assigned to the registerButton.
         */
        public void addRegisterListener(java.awt.event.ActionListener listener) {
                registerButton.addActionListener(listener);
        }

        /**
         * The addContinueListener method takes in one ActionListener as an argument and assigns it to the continueButton.
         * The assigned ActionListener will then listen for the user to click the continueButton which takes them to the guest main page.
         * @param listener the ActionListener that will be assigned to the loginButton
         */
        public void addContinueListener(java.awt.event.ActionListener listener) {
                continueButton.addActionListener(listener);
        }

        // Variables for the JPanel components
        private javax.swing.JButton loginButton;
        private javax.swing.JButton registerButton;
        private javax.swing.JLabel title;
        private javax.swing.JButton continueButton;
        private javax.swing.JButton exitButton;
        

}
