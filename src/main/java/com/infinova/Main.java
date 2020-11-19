package com.infinova;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {
        TankFrame tankFrame = new TankFrame();
        tankFrame.setBounds(0, 0, 500, 500);
        tankFrame.setVisible(true);
        tankFrame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
