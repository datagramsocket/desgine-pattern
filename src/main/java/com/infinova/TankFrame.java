package com.infinova;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    private Tank tank = new Tank();

    public TankFrame(){
        this.setBounds(0, 0, 500, 500);
        this.setVisible(true);
        this.setTitle("Tank");
        this.addWindowListener(new MyWindowAdapter());
        this.addKeyListener(new MyKeyListener());
    }




    @Override
    public void paint(Graphics g) {
        tank.paint(g);
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
            if(!bl && !br && !bu && !bd){
                tank.setMoving(false);
            }else{
                if(bl) tank.setDir(Dir.LEFT);
                if(br) tank.setDir(Dir.RIGHT);
                if(bu) tank.setDir(Dir.UP);
                if(bd) tank.setDir(Dir.DOWN);
                tank.setMoving(true);
            }
        }
    }
}
