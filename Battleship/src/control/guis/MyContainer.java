package control.guis;

import java.awt.CardLayout;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.io.IOException;


import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyContainer extends JPanel implements IActionShowGame, IBackToMenu, KeyListener{
    public static final String PLAY = "PLAY";
    public static final String MENU = "MENU";
    private MainCanvas mainCanvas;
    private PanelMenu panelMenu;
    private CardLayout cardLayout;
    private GamePanel gamePanel;
    public MyContainer() throws IOException {
        initPanel();
        initComponents();
        addComponents();
    }

    private void initPanel() {
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        setSize(GUI.WIDTH_FRAME, GUI.HEIGHT_FRAME);
    }

    private void initComponents() throws IOException {
        panelMenu = new PanelMenu();

        panelMenu.setiActionShowGame(this);
    }

    private void addComponents() {

        add(panelMenu, MENU);
        cardLayout.show(this, MENU);
    }

    @Override
    public void showGame() {
        // mainCanvas = new MainCanvas();
        // mainCanvas.setOnBackToMenuListener(this);
        // add(mainCanvas, PLAY);
        // cardLayout.show(this, PLAY);
        // mainCanvas.requestFocus();
        // mainCanvas.start();
        String[] options = new String[] {"Easy", "Medium", "Hard"};
        String message = "Easy will make moves entirely randomly,\nMedium will focus on areas where it finds ships,"
                + "\nand Hard will make smarter choices over Medium.";
        int difficultyChoice = JOptionPane.showOptionDialog(null, message,
                "Choose an AI Difficulty",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);

        JFrame frame = new JFrame("Battleship");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        gamePanel = new GamePanel(difficultyChoice);
        frame.getContentPane().add(gamePanel);

        frame.addKeyListener(this);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void backToMenu() {
        cardLayout.show(this, MENU);
        this.remove(mainCanvas);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        gamePanel.handleInput(e.getKeyCode());
    }

  
    @Override
    public void keyTyped(KeyEvent e) {}
 
    @Override
    public void keyReleased(KeyEvent e) {}
}
