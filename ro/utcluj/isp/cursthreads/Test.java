/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.utcluj.isp.cursthreads;

import java.util.logging.Level;
import java.util.logging.Logger;

class A implements Runnable{
    public void run(){
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(A.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Thread A is working...");
        }
    }
}

class B extends Thread{
    public void run(){
        while(true){
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(B.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Thread B is working...");
        }
    }
}


/**
 *
 * @author mihai.hulea
 */
public class Test {
    public static void main(String[] args) {
        A a1 = new A();
        new Thread(a1).start();
        
        B b1 = new B();
        b1.start();
        
                B b2 = new B();
        b2.start();
        
                B b3 = new B();
        b3.start();
        
//        try {
//            b1.join();
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
