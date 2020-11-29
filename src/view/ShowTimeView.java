import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;

public class ShowTimeView {
    
    JFrame frame;
    JLabel label;
    JButton [] buttons=new JButton[3];
    JPanel panel;
    
    

    public ShowTimeView()
    {
        frame=new JFrame();
        panel=new JPanel();
    }

    void start()
    {
        frame.setLayout(null);
        frame.setSize(850,480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        panel.setLayout(null);
        panel.setSize(840,470);
        panel.setBackground(Color.GREEN);

        label=new JLabel();
        label.setSize(350, 400);
        ImageIcon imageIcon = new ImageIcon("/Users/bikramjeetsinghatwal/Documents/GitHub/ENSF-480-Project/src/Images/poster1.jpg"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(350, 400,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back
        label.setIcon(imageIcon);
        label.setLocation(40, 40);
        
        int x= 420,y=200;
        for(int i=0;i<3;i++)
        { 
            buttons[i]=new JButton();
            buttons[i].setBackground(Color.GREEN);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
        buttons[i].setText("10:15");
        buttons[i].setSize(80,55);
        buttons[i].setLocation(x, y);
        addListener(buttons[i]);
        panel.add(buttons[i]);
        x+=90;
        }

        panel.add(label);
        frame.add(panel);
        panel.setVisible(true);
        frame.setVisible(true);
    }

    void addListener(JButton button)
    { 
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<3;i++)
                buttons[i].setBackground(Color.GREEN);
                button.setBackground(Color.RED);
                System.out.println( button.getText());            
            }
         });  
    }



    public static void main(String[] args) {
        ShowTimeView sTimeView=new ShowTimeView();
        sTimeView.start();
    }
}
