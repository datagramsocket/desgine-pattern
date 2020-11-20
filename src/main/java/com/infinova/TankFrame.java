package com.infinova;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class TankFrame extends Frame {
    private Tank tank = new Tank(this);
    public ArrayList<Bullet> bulletList = new ArrayList();
    public static final int GAME_WIDTH = 500;
    public static  final int GAME_HEIGHT = 500;

    public TankFrame(){
        this.setBounds(0, 0, GAME_WIDTH, GAME_HEIGHT);
        this.setVisible(true);
        this.setTitle("Tank");
        this.addWindowListener(new MyWindowAdapter());
        this.addKeyListener(new MyKeyListener());

    }

    @Override
    public void paint(Graphics g) {
        System.out.println("size:" + bulletList.size());
        tank.paint(g);
        Iterator<Bullet> iterator = bulletList.iterator();
        while(iterator.hasNext()){
            Bullet bullet = iterator.next();
            if(!bullet.isAlive()){
                iterator.remove();
            }
            bullet.paint(g);
        }
    }

    Image offScreenImage = null;
    /**
     * 防止闪烁代码
     * */
    @Override
    public void update(Graphics g) {
        if(offScreenImage == null){
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics graphics = offScreenImage.getGraphics();
        Color color = graphics.getColor();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0, GAME_WIDTH, GAME_HEIGHT);
        graphics.setColor(color);
        paint(graphics);
        g.drawImage(offScreenImage, 0, 0, null);

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
                case KeyEvent.VK_CONTROL:
                    tank.fire();
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
