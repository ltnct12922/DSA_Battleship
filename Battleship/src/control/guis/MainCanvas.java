package control.guis;

import control.components.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainCanvas extends JPanel implements Runnable, KeyListener {

    public static AudioPlayer audioPlayer;
    private long sleepTime = 20;
    Thread thread;
    private boolean endGame;
    public IBackToMenu onBackToMenuListener;
    private GamePanel gamePanel;
    private int difficultyChoice;

    public MainCanvas() {String[] options = new String[] {"Easy", "Medium", "Hard"};
    String message = "Easy will make moves entirely randomly,\nMedium will focus on areas where it finds ships,"
            + "\nand Hard will make smarter choices over Medium.";
    difficultyChoice = JOptionPane.showOptionDialog(null, message,
            "Choose an AI Difficulty",
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
            null, options, options[0]);

    // JFrame frame = new JFrame("Battleship");
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame.setResizable(false);

    
    // frame.getContentPane().add(gamePanel);

    // frame.addKeyListener(this);
    // frame.pack();
    // frame.setVisible(true);
        this.setEndGame(false);
        this.setSize(GUI.WIDTH_FRAME, GUI.HEIGHT_FRAME);
    }

    public void start() {
        gamePanel = new GamePanel(difficultyChoice);
        add(gamePanel);
        thread.start();
        audioPlayer.playSound(AudioPlayer.GAME_START);
    }


    @Override
    public void run() {
    }

    // public void paintComponent(Graphics g) {
    //     g.setColor(Color.BLACK);
    //     g.fillRect(0, 0, GUI.WIDTH_FRAME, GUI.HEIGHT_FRAME);
    // }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }

    public void setOnBackToMenuListener(IBackToMenu onBackToMenuListener) {
        this.onBackToMenuListener = onBackToMenuListener;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
