package ru.gb.jtwo.lone.online.circles;

import java.awt.*;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Background extends GameCanvas {
Color [] colors=new Color[5];

    public Background(MainCircles gameController) {
        super(gameController);
       //setBackground(col());
        col();
    }

    private void  col() {
        colors[0]=Color.BLACK;
        colors[1]=Color.YELLOW;
        colors[2]=Color.GRAY;
        colors[3]=Color.GREEN;
        colors[4]=Color.WHITE;

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                int i = (int) (Math.random() * 5);
                setBackground(colors[i]);

            }
        },0,1500);

        }
    }



