package control.guis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class PanelMenu extends JPanel implements ActionListener {
    private static final String ACTION_PLAY = "ACTION_PLAY";
    private static final String ACTION_EXIT = "ACTION_EXIT";
    static String name;


    private JButton btnPlay;
    private JButton btnExit;
    private IActionShowGame iActionShowGame;

    private Image bg = new ImageIcon(MyContainer.class.getResource("/res/images/bground.jpg")).getImage().getScaledInstance(
            GUI.WIDTH_FRAME, GUI.HEIGHT_FRAME, Image.SCALE_DEFAULT);

    public PanelMenu() {
        initPanel();
        initComponents();
        addComponents();
    }
    public void setiActionShowGame(IActionShowGame iActionShowGame) {
        this.iActionShowGame = iActionShowGame;
    }
    private void initPanel() {
        setLayout(null);
    }
    private void initComponents() {
        Image btPlay = new ImageIcon(MyContainer.class.getResource("/res/images/play.jpg")).getImage().getScaledInstance(
                110, 35, Image.SCALE_SMOOTH);

        Image btExit = new ImageIcon(MyContainer.class.getResource("/res/images/exit.jpg")).getImage().getScaledInstance(
                110, 35, Image.SCALE_SMOOTH);

        btnPlay = new JButton();
        btnPlay.setBounds(200, 450, 100, 35);
        btnPlay.setText("Play");
        btnPlay.setIcon(new ImageIcon(btPlay));
        btnPlay.setActionCommand(ACTION_PLAY);
        btnPlay.addActionListener(this);

        btnExit = new JButton();
        btnExit.setBounds(320, 450, 100, 35);
        btnExit.setText("Exit");
        btnExit.setIcon(new ImageIcon(btExit));
        btnExit.setActionCommand(ACTION_EXIT);
        btnExit.addActionListener(this);
    }

    private void addComponents() {
        add(btnPlay);
        add(btnExit);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Font f = new Font("Georgia", Font.ITALIC, 30);
        g.setFont(f);
        g.drawImage(bg, 0, 0, null);
        g.drawString("Credit: NATT (HCMIU)", 620, 540);
        setForeground(Color.yellow);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = e.getActionCommand();
        switch (id) {
            case ACTION_PLAY:
                System.out.println("Enter your name");
                name= JOptionPane.showInputDialog("Please enter Username!");
                String message=String.format("Welcome %s to Battleship",name);
                JOptionPane.showMessageDialog(null, message);
                System.out.println("play");
                iActionShowGame.showGame();
                break;

            case ACTION_EXIT:
                System.out.println("Exit");
                int result = JOptionPane.showConfirmDialog(null, "Are you sure ?", "thoát", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
                break;
        }
    }
}
