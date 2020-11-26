package com.infinova;

import java.awt.*;

public class Bullet {

    public Bullet(int x, int y, Dir dir, TankFrame tankFrame){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    private int x;
    private int y;
    private Dir dir;
    private int speed = 20;
    private TankFrame tankFrame;
    private boolean alive = true;

    public boolean isAlive() {
        return alive;
    }


    public void paint(Graphics g){
        switch (dir){
            case UP:
                g.drawImage(ResourceManager.bulletU, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceManager.bulletL, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.bulletD, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.bulletR, x, y, null);
                break;
        }
        move();
    }

    private void move() {
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
        if(x<0 || y<0 || x>TankFrame.GAME_WIDTH || y>TankFrame.GAME_HEIGHT) alive=false;
    }
}
