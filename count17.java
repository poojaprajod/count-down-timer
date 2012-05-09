/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package starttimer;


import java.awt.event.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


public class count17 extends JFrame implements
MouseListener,ActionListener,KeyListener{
Timer timer;
JLabel m=new JLabel("00"+":"+"00",JLabel.CENTER);
int alrt;
int count;
int secs = 0;
int mins = 0;
int hrs,mts,s;
Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
public count17(int hours,int minutes,int seconds,int alert_time) {
    hrs=hours;
    mts=minutes;
    s=seconds;
    count=hrs*3600+mts*60+s;
    alrt=alert_time;
setExtendedState(MAXIMIZED_BOTH);
setUndecorated(true);
setBounds(0,0,screenSize.width, screenSize.height);
setResizable(false);
add(m);
m.setFont(new Font("LCD2", Font.BOLD, 520));
m.setForeground(Color.RED);
m.setBounds(screenSize.width/2-300, screenSize.height/2-175,600,350);
m.addMouseListener(this);
 addKeyListener(this);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
getContentPane().setBackground(Color.black);
timer=new Timer(1000,this);

setVisible(true);
}


    @Override
public void mouseClicked(MouseEvent e) {
        if(e.getClickCount()==1){timer.start();}
        
        if(e.getClickCount()==2){
        count=hrs*3600+mts*60+s;
            timer.restart();
            timer.stop();
    m.setText("00"+":"+"00");}
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
        SwingUtilities.invokeLater(new Update());
    }

    @Override
    public void keyTyped(KeyEvent e) {
    
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode()==KeyEvent.VK_ESCAPE){
     System.exit(1);
     }}

    @Override
    public void keyReleased(KeyEvent e) {
      
    }

class Update implements Runnable {
        @Override
public void run() {

if(count>alrt)
{
    mins=(int)(count/60);
    secs=count-(mins*60);
    if(mins<10){
        if(secs<10){
     m.setText("0"+mins+":"+"0"+secs);
 }
 else{
            String sec=Integer.toString(secs);
            m.setText("0"+mins+":"+secs);}
       // mvalue.setText("0"+(mins+1)+);
    }else{
        if(secs<10){
     m.setText(mins+":"+"0"+secs);
 }
 else{
            String sec=Integer.toString(secs);
            m.setText(mins+":"+secs);}}

 --count;
}
else 
{
   timer.stop();
 
     int  minut=alrt/60;
    int  scnd=alrt%60;
   
   count18 alert=new count18(0,minut,scnd,hrs,mts,s,alrt);
    setVisible(false);
   

}
        }}}


