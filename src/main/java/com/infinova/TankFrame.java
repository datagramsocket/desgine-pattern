package com.infinova;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    public TankFrame(){
        this.setBounds(0, 0, 500, 500);
        this.setVisible(true);
        this.addWindowListener(new MyWindowAdapter());
        this.addKeyListener(new MyKeyListener());
    }

    private int x;
    private int y;
    private Dir dir = Dir.DOWN;
    private int speed = 10;


    @Override
    public void paint(Graphics g) {
        g.fillRect(x, y,50,50);
        switch(dir){
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
        }
    }



    public class MyWindowAdapter extends WindowAdapter{

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    public class MyKeyListener implements KeyListener {

        private boolean bl, br, bu, bd;

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()){
                case KeyEvent.VK_UP:
                    bu = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = true;
                    break;
                case KeyEvent.VK_LEFT:
                    bl = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = true;
                    break;
                default:
                    break;
            }
            setTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()){
                case KeyEvent.VK_UP:
                    bu = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = false;
                    break;
                case KeyEvent.VK_LEFT:
                    bl = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = false;
                    break;
                default:
                    break;
            }
            setTankDir();
        }

        public void setTankDir(){
            if(bl) dir = Dir.LEFT;
            if(br) dir = Dir.RIGHT;
            if(bu) dir = Dir.UP;
            if(bd) dir = Dir.DOWN;

        }
    }
}
