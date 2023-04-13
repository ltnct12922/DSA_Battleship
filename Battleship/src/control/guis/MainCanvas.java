package control.guis;

import control.components.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainCanvas extends JPanel implements Runnable, KeyListener {

    public static int animationClock = 0;
    public static AudioPlayer audioPlayer;

    private long sleepTime = 20;
    Thread thread;
    private boolean endGame;
    public IBackToMenu onBackToMenuListener;

    public MainCanvas() {
        this.setEndGame(false);
        this.setSize(GUI.WIDTH_FRAME, GUI.HEIGHT_FRAME);
    }

    public void start() {
        thread.start();
        audioPlayer.playSound(AudioPlayer.GAME_START);
    }


    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        while (!isEndGame()) {
            animationClock++;
            if (animationClock == 2147483647)
                animationClock = 0;
            // Repaint
            repaint();
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, GUI.WIDTH_FRAME, GUI.HEIGHT_FRAME);
    }

    private void drawRightMenu(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(800, 0, 200, 544);
        g.translate(800, 0);
        g.setColor(Color.WHITE);
        g.translate(0, 0);
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public boolean isEndGame() {
        return endGame;
    }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }

    public void setOnBackToMenuListener(IBackToMenu onBackToMenuListener) {
        this.onBackToMenuListener = onBackToMenuListener;
    }
}
