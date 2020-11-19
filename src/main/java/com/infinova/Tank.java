package com.infinova;

import java.awt.*;

public class Tank {

    public Tank(TankFrame tankFrame){
        this.tankFrame = tankFrame;
    }
    public TankFrame tankFrame;
    private int x;
    private int y;
    private Dir dir = Dir.DOWN;
    private int speed = 10;

    private boolean moving = false;

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g){
        System.out.println("Tank thread id:" + Thread.currentThread().getId());
        Color color = g.getColor();
        g.setColor(Color.yellow);
        g.fillRect(x, y,50,50);
        g.setColor(color);
        mvoe();
    }

    private void mvoe() {
        if(!moving) return;
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

    public void fire(){
        tankFrame.bulletList.add(new Bullet(x, y, dir, tankFrame));
    }
}
