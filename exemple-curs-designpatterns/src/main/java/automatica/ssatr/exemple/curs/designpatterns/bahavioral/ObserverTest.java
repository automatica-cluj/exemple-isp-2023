/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package automatica.ssatr.exemple.curs.designpatterns.bahavioral;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

/**
 * @author radu.miron
 */

class Alarm extends Observable {
    boolean ring;

    public void startStop() {
        this.ring = !this.ring;
        this.setChanged();
        this.notifyObservers(ring);
    }
}

class TextMonitor implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if ((Boolean) arg) {
            System.out.println("Brrrr!!!!!");
        }
    }
}

class UiMonitor extends JFrame implements Observer {
    public UiMonitor() throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 300);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        if ((Boolean) arg) {
            JLabel label = new JLabel("Brrrr!!!!!");
            label.setBounds(new Random().nextInt(250) + 10, new Random().nextInt(250) + 10, 100, 20);
            this.add(label);
            this.repaint();
        }
    }
}

public class ObserverTest {
    public static void main(String[] args) throws InterruptedException {
        Alarm alarm = new Alarm();
        TextMonitor textMonitor = new TextMonitor();
        UiMonitor uiMonitor = new UiMonitor();

        alarm.addObserver(textMonitor);
        alarm.addObserver(uiMonitor);

        while (true) {
            Thread.sleep(1000);
            alarm.startStop();
        }
    }
}

