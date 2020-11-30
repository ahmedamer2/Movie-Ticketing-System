package view;

/**
 * The RegisterView class extends JPanel and is used to present the registration screen for the user to register.
 * @author Ahmed Amer, Yassin Bayoumy, Bikramjeet
 * @version 1.0
 * @since November 29, 2020
 */
public class RegisterView extends javax.swing.JPanel {

        /**
         * The default constructor for the RegisterView class that calls the initComponents method used to initialize the JPanel components
         */
        public RegisterView() {
                initComponents();
        }

        /**
         * The initComoponents method is used to initialize the JPanel components needed to display to the user. It wil format, resize and the layout
         * the components correctly
         */
        private void initComponents() {
                //initialize the JPanel components
                title = new javax.swing.JLabel();
                emailTitle = new javax.swing.JLabel();
                emailField = new javax.swing.JTextField();
                passwordTitle = new javax.swing.JLabel();
                passwordField = new javax.swing.JPasswordField();
                registerButton = new javax.swing.JButton();
                cancelButton = new javax.swing.JButton();

                //setup the JPanel
                setBackground(new java.awt.Color(255, 153, 204));
                setBorder(new javax.swing.border.MatteBorder(null));

                //assign values and formating to the JPanel components
                title.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
                title.setText("Become a Registered User!");

                emailTitle.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
                emailTitle.setText("Email Address:");

                emailField.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
                emailField.setBorder(javax.swing.BorderFactory.createEtchedBorder());

                passwordTitle.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
                passwordTitle.setText("Password:");

                passwordField.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
                passwordField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                passwordField.setCaretColor(new java.awt.Color(255, 255, 255));

                registerButton.setBackground(new java.awt.Color(255, 204, 204));
                registerButton.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
                registerButton.setText("Register");
                registerButton.setToolTipText("Register!");
                registerButton.setBorder(
                                javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

                cancelButton.setBackground(new java.awt.Color(255, 204, 204));
                cancelButton.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
                cancelButton.setText("Cancel");
                cancelButton.setToolTipText("Go back to main screen");
                cancelButton.setBorder(
                                javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));


                //setup the layout and add the components to the JPanel
                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(title)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup().addContainerGap(308, Short.MAX_VALUE).addGroup(
                                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(cancelButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                232,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(registerButton,
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
                                                .addGap(0, 308, Short.MAX_VALUE)));
                layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(title)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69,
                                                                Short.MAX_VALUE)
                                                .addComponent(emailTitle)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18).addComponent(passwordTitle)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(79, Short.MAX_VALUE)));
        }

        /**
         * The addCancelListener method takes in an ActionListener that is added to the cancelButton and will
         * listen for the user to click the cancel button.
         * @param listener The ActionListener that will listen to the cancelButton
         */
        public void addCancelListener(java.awt.event.ActionListener listener) {
                cancelButton.addActionListener(listener);
        }

        /**
         * The addRegisterListener method takes in an ActionListener that is added to the registerButton and 
         * will listen for the user to click the registerButton.
         * @param listener The ActionListener that will listen to the registerButton
         */
        public void addRegisterListener(java.awt.event.ActionListener listener) {
                registerButton.addActionListener(listener);
        }

        /**
         * The getter method getEamil is used to return the email that the user enters inside of the emailField.
         * @return A String representing the email of the user entered.
         */
        public String getEmail() {
                return emailField.getText();
        }

        /**
         * The getter method getPadd is used to return the password that the user enters into the passwordField.
         * @return A String representing the password the user entered.
         */
        public String getPass() {
                return new String(passwordField.getPassword());
        }

        // Variables for the JPanel components
        private javax.swing.JButton cancelButton;
        private javax.swing.JLabel title;
        private javax.swing.JTextField emailField;
        private javax.swing.JLabel emailTitle;
        private javax.swing.JPasswordField passwordField;
        private javax.swing.JLabel passwordTitle;
        private javax.swing.JButton registerButton;
        
}
