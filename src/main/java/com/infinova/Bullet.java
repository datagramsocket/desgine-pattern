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
    private int speed = 1;
    private TankFrame tankFrame;
    private boolean alive = true;

    public void paint(Graphics g){
        System.out.println("Bullet thread id:" + Thread.currentThread().getId());
        Color color = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x, y, 10, 10);
        g.setColor(color);
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

        if(!alive){
            tankFrame.bulletList.remove(this);
        }
    }
}
