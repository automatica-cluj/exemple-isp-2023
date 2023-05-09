package ro.utcluj.isp.cursthreads.cronometru;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cronometru extends Observable implements Runnable{

    private long t;
    private boolean active=true;
    private boolean paused=false;
    
    @Override
    public void run() {
        while(active){
            if(!paused){
                t++;
                setChanged();
                notifyObservers(new Long(t));
                System.out.println("t="+t);             
            }else{
                synchronized(this){
                    try {
                        wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Cronometru.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }//.else
            
            
              try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Cronometru.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    
    
    public void pauseCrono(){
        System.out.println("PAUSE");
        paused = true;
    }
    
    public void resumeCrono(){
        System.out.println("RESUME");
        synchronized(this){
            paused = false;
            notify();
        }
    }
    
    public void resetCrono(){
        System.out.println("RESET");
        t = 0;
    }
    
    
    public static void startAppCrono(){
        Cronometru c = new Cronometru();
        Thread thr = new Thread(c);
     
        
        CronometruJFrame ui = new CronometruJFrame();
        c.addObserver(ui);
        ui.setVisible(true);
        
        ui.setCronometru(c);
        
        thr.start();
    }
    
    public static void main(String[] args) {
        startAppCrono();
        startAppCrono();
        startAppCrono();
        startAppCrono();
        startAppCrono();
        
    }
    
}
