package control.guis;

import control.components.*;

import javax.swing.*;
import java.awt.*;

public class MainCanvas extends JPanel implements Runnable {

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
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, GUI.WIDTH_FRAME, GUI.HEIGHT_FRAME);
    }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }

    public void setOnBackToMenuListener(IBackToMenu onBackToMenuListener) {
        this.onBackToMenuListener = onBackToMenuListener;
    }
}
