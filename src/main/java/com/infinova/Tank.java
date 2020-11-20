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

        //Color color = g.getColor();
        //g.setColor(Color.yellow);
        switch (dir){
            case UP:
                g.drawImage(ResourceManager.tankU, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceManager.tankL, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.tankD, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.tankR, x, y, null);
                break;
        }
        //g.fillRect(x, y,50,50);
        //g.setColor(color);
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
        tankFrame.bulletList.add(new Bullet(x + ResourceManager.tankD.getWidth()/2, y + + ResourceManager.tankD.getHeight()/2, dir, tankFrame));
    }
}
