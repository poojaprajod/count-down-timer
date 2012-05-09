package starttimer;

import java.awt.event.*;

import java.awt.*;
import javax.swing.*;


public class starttimer extends JFrame implements
MouseListener,ActionListener,KeyListener {
JLabel ted=new JLabel("TEDx NITCalicut",SwingConstants.CENTER);
JLabel clabel=new JLabel("CountDown Timer",JLabel.CENTER);

Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
public starttimer() {
setExtendedState(MAXIMIZED_BOTH);
setBounds(0,0,screenSize.width, screenSize.height);
setUndecorated(true);

add(ted);
add(clabel);
ted.setBounds(100, 50, screenSize.width-200, 300);
ted.setFont(new Font("Serif", Font.BOLD, 130));
ted.setForeground(Color.RED);
clabel.setFont(new Font("LCD2", Font.BOLD, 100));
clabel.setForeground(Color.RED);
clabel.setBounds(screenSize.width/2-300, screenSize.height/2-175,600,350);
addMouseListener(this);
 addKeyListener(this);

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
getContentPane().setBackground(Color.black);
setVisible(true);


}

    
    
    public static void main(String[] args){
       new starttimer();
    }

    @Override
public void mouseClicked(MouseEvent e) {
if(e.getClickCount()==1){
    count17 counter = new count17(0,18,0,120);
       setVisible(false);
}
    }
    @Override
    public void mousePressed(MouseEvent e) {
     
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
   
    }

    @Override
    public void keyTyped(KeyEvent e) {
      
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode()==KeyEvent.VK_ESCAPE){
     System.exit(1);
     }
         
  }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
}
