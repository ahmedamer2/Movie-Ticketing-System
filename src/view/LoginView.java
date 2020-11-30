package view;

/**
 * The class LoginView is a class extending JPanel made to present the LoginView for the user. This class will be called
 * when the user presses the login button. 
 * @author Ahmed Amer, Yassin Bayoumy, Bikramjeet
 * @version 1.0
 * @since November 29, 2020
 */
public class LoginView extends javax.swing.JPanel {

        /**
         * The Default constructor for the LoginView that has the initComponents method used to initialize the components to be used by the JPanel.
         */
        public LoginView() {
                initComponents();
        }

        /**
         * The initComponents method will initialize all of the components used for the LoginView. It will handle the layout and initilization
         * of all the components.
         */
        private void initComponents() {
                //initialize Components
                title = new javax.swing.JLabel();
                emailField = new javax.swing.JTextField();
                emailTitle = new javax.swing.JLabel();
                passwordTitle = new javax.swing.JLabel();
                passwordField = new javax.swing.JPasswordField();
                loginButton = new javax.swing.JButton();
                cancelButton = new javax.swing.JButton();

                //setup the JPanel
                setBackground(new java.awt.Color(255, 153, 204));
                setBorder(new javax.swing.border.MatteBorder(null));
                setForeground(new java.awt.Color(255, 255, 255));
                setPreferredSize(new java.awt.Dimension(850, 480));

                //Initialize all components with appropriate fonts, text and borders
                title.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
                title.setText("Welcome Back Please Login to Continue");

                emailField.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
                emailField.setBorder(javax.swing.BorderFactory.createEtchedBorder());

                emailTitle.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
                emailTitle.setText("Email Address:");

                passwordTitle.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
                passwordTitle.setText("Password:");

                passwordField.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
                passwordField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                passwordField.setCaretColor(new java.awt.Color(255, 255, 255));

                loginButton.setBackground(new java.awt.Color(255, 204, 204));
                loginButton.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
                loginButton.setText("Login");
                loginButton.setToolTipText("Login!");
                loginButton.setBorder(
                                javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

                cancelButton.setBackground(new java.awt.Color(255, 204, 204));
                cancelButton.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
                cancelButton.setText("Cancel");
                cancelButton.setToolTipText("Go back to main screen");
                cancelButton.setBorder(
                                javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

                //Setup the layout for the JPanel and add all the components
                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(title)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap(308, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(cancelButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                232,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(loginButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                232,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(passwordField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                232,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(passwordTitle,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                232,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(emailField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                232,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(emailTitle,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                232,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(308, Short.MAX_VALUE)));
                layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(title)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75,
                                                                Short.MAX_VALUE)
                                                .addComponent(emailTitle)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18).addComponent(passwordTitle)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(37, 37, 37)
                                                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(74, Short.MAX_VALUE)));
        }
        /**
         * The addLoginListener method will take in an ActionListener as an argument that will be used to listen for the user to 
         * click on the loginButton.
         * @param listener The ActionListener that will listen for the loginButton to be pressed
         */
        public void addLoginListener(java.awt.event.ActionListener listener) {
                loginButton.addActionListener(listener);
        }

        /**
         * The addCancelListener class is made to add an ActionListener to the cancelButton.
         * @param listener The ActionListener used to listen for the cancelButton to be pressed.
         */
        public void addCancelListener(java.awt.event.ActionListener listener) {
                cancelButton.addActionListener(listener);
        }

        /**
         * The getter method getEmail will return the email entered by the user. 
         * @return A String representing the email of the user attempting to login.
         */
        public String getEmail() {
                return emailField.getText();
        }

        /**
         * The getter method getPass will return the password entered by the user and return it as a string.
         * @return The String that holds the Password of the user
         */
        public String getPass() {
                return new String(passwordField.getPassword());
        }

        // Variables for components to be used
        private javax.swing.JButton cancelButton;
        private javax.swing.JLabel title;
        private javax.swing.JTextField emailField;
        private javax.swing.JLabel emailTitle;
        private javax.swing.JButton loginButton;
        private javax.swing.JPasswordField passwordField;
        private javax.swing.JLabel passwordTitle;

}
