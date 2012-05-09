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

public class count18 extends JFrame implements
        ActionListener, MouseListener,KeyListener {

    Timer timer;
    JLabel m;
    int alrt;
    int count;
    int secs = 0;
    int mins = 0;
    int hrs;
    int mts;
    int s;
            
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public count18(int hours, int minutes, int seconds,int ohours,int ominutes,int oseconds,int oalert_time) {
        count = 2 * (hours * 3600 + minutes * 60 + seconds);
        hrs=ohours;
        alrt = oalert_time;
        mts=ominutes;
        s=oseconds;
        int lmin=alrt/60;
        int lsec=alrt%60;
        String lsecs;
        if (lsec<=10) 
          lsecs=  "0"+Integer.toString(lsec);
        else
          lsecs=  Integer.toString(lsec);
       m= new JLabel("0"+lmin + ":"+lsecs , JLabel.CENTER);
        
        setExtendedState(MAXIMIZED_BOTH);
        setBounds(0, 0, screenSize.width, screenSize.height);
        setResizable(false);
        setUndecorated(true);
        add(m);
        m.setFont(new Font("LCD2", Font.BOLD, 520));
        m.setForeground(Color.RED);
        m.setBounds(screenSize.width / 2 - 300, screenSize.height / 2 - 175, 600, 350);
        m.addMouseListener(this);
        addKeyListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.black);
        timer = new Timer(500, this);
        timer.start();
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            timer.stop();

            count17 count17 = new count17(hrs, mts, s, alrt);
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
if(count>=0)
{if(!(count%2==0)){m.setForeground(Color.red);
        }else{m.setForeground(Color.BLACK);}
    
    int counts=count/2;
    mins=(int)(counts/60);
    secs=counts-(mins*60);
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
        }
    }
    }}
