/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author 15877
 */
public class TicketSearchView extends javax.swing.JPanel {

    /**
     * Creates new form RegisterView
     */
    public TicketSearchView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        Title = new javax.swing.JLabel();
        ticketIDTitle = new javax.swing.JLabel();
        ticketIDField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 153, 204));
        setBorder(new javax.swing.border.MatteBorder(null));

        Title.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        Title.setText("Enter the ID of the ticket that you want to Cancel");

        ticketIDTitle.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        ticketIDTitle.setText("Ticket ID:");

        ticketIDField.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        ticketIDField.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        searchButton.setBackground(new java.awt.Color(255, 204, 204));
        searchButton.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        searchButton.setText("Search Ticket");
        searchButton.setToolTipText("Search for the ticket to cancel");
        searchButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        CancelButton.setBackground(new java.awt.Color(255, 204, 204));
        CancelButton.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        CancelButton.setText("Cancel");
        CancelButton.setToolTipText("Go back to main screen");
        CancelButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(Title)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup().addContainerGap(308, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 232,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 232,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ticketIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 232,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ticketIDTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 232,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 308, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(Title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(ticketIDTitle).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ticketIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18).addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(79, Short.MAX_VALUE)));
    }// </editor-fold>

    public void addCancelListener(java.awt.event.ActionListener listener) {
        CancelButton.addActionListener(listener);
    }

    public void addSearchListener(java.awt.event.ActionListener listener) {
        searchButton.addActionListener(listener);
    }

    public String getTicketID() {
        return ticketIDField.getText();
    }

    // Variables declaration - do not modify
    private javax.swing.JButton CancelButton;
    private javax.swing.JLabel Title;
    private javax.swing.JTextField ticketIDField;
    private javax.swing.JLabel ticketIDTitle;
    private javax.swing.JButton searchButton;
    // End of variables declaration
}
