package control.guis;

import java.awt.CardLayout;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JPanel;

public class MyContainer extends JPanel implements IActionShowGame, KeyListener{
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
        mainCanvas = new MainCanvas();
        add(mainCanvas, PLAY);
        cardLayout.show(this, PLAY);
        mainCanvas.requestFocus();
        mainCanvas.start();
        
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
