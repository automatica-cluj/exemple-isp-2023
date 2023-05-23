package automatica.ssatr.exemple.curs.designpatterns.bahavioral;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

/**
 * @author radu.miron
 */

class Alarm {
    private PropertyChangeSupport propertyChangeSupport;
    private boolean ring;

    public Alarm() {
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void addObserver(PropertyChangeListener observer) {
        this.propertyChangeSupport.addPropertyChangeListener(observer);
    }

    public void startStop() {
        propertyChangeSupport.firePropertyChange("change", this.ring, !this.ring);
        this.ring = !this.ring;
    }
}

class TextMonitor implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if ((Boolean) propertyChangeEvent.getNewValue()) {
            System.out.println("Brrrr!!!!!");
        }
    }
}

class UiMonitor extends JFrame implements PropertyChangeListener {
    public UiMonitor() throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 300);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if ((Boolean) propertyChangeEvent.getNewValue()) {
            JLabel label = new JLabel("Brrrr!!!!!");
            label.setBounds(new Random().nextInt(250) + 10, new Random().nextInt(250) + 10, 100, 20);
            this.add(label);
            this.repaint();
        }
    }
}

public class ObserverTestPropertyChangeSupport {
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
