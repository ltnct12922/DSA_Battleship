package control.guis;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainCanvas extends JPanel implements KeyListener {

    Thread thread; 
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

        this.addKeyListener(this);
    // frame.pack();
    // frame.setVisible(true);
        //this.setEndGame(false);
        this.setSize(GUI.WIDTH_FRAME, GUI.HEIGHT_FRAME);
    }
 
    public void start() {
        gamePanel = new GamePanel(difficultyChoice);
        add(gamePanel);
        thread.start();
    }
    // public void paintComponent(Graphics g) {
    //     g.setColor(Color.BLACK);
    //     g.fillRect(0, 0, GUI.WIDTH_FRAME, GUI.HEIGHT_FRAME);
    // }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        gamePanel.handleInput(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
