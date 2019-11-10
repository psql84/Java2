package ru.gb.jtwo.lone.online.circles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainCircles extends JFrame {

    /*
    * Полностью разобраться с кодом
	* Прочитать методичку к следующему уроку
	* Написать класс Бэкграунд, изменяющий цвет канвы в зависимости от времени
	*  * Реализовать добавление новых кружков по клику используя ТОЛЬКО массивы
	*  ** Реализовать по клику другой кнопки удаление кружков (никаких эррейЛист)
    * */


    /*  И так:
    1. Создал клас Background. Там 5 цветов выбор рандомом... Клас росширяет GameCanvas
    (чесно метод Timer нагуглил сам пытаюсь розобратся в принципи действия его)
    2-3 Ну не стал мудрить ввел переменную которая отслеживает клики мыши
    Левая +1 Правая -1 ограничение не меньше 0 не больше длины масива
    методы update и render работают с масивом только до количества кликов

     */

    private static final int POS_X = 600;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    Sprite[] sprites = new Sprite[10];
    private int colClik =1;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");

        //GameCanvas canvas = new GameCanvas(this);
        Background background = new Background(this);
        add(background, BorderLayout.CENTER);

        background.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getButton()==MouseEvent.BUTTON1){
                if(colClik<sprites.length){
                    colClik++;
                    //System.out.println(colClik);
                }}
                if(e.getButton()==MouseEvent.BUTTON3){
                    if(colClik>0){
                        colClik--;
                        System.out.println(colClik);
                    }}
            }
        });
        initApplication();

        setVisible(true);
    }

    private void initApplication() {

                  //  sprites[0] = new Ball();

        for (int i = 0; i < sprites.length; i++) {

           sprites[i] =new Ball();
        }
    }

    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < colClik; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < colClik; i++) {
            sprites[i].render(canvas, g);
        }
    }
}
