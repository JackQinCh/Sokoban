/*
 *  Copyright (C) 2015 Zhonghua Qin
 *  @filename GamePanel.java 
 *  @author Zhonghua Qin
 *  @datetime Nov 28, 2015  6:24:30 PM
 *  @version 1.0
 *  @Description
 */
package Zhonghua;

import Zhonghua.GamePanel.DisplayThread;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Zhonghua Qin
 */
public class GamePanel extends JPanel {
    private final GameController controller;
    private static final int FRAMES = 60;

    public GamePanel() {
	controller = new GameController(this);
        
        DisplayThread displayThread = new DisplayThread();
        
        displayThread.start();
        
    }

    public void keyPressed(KeyEvent e) {
	controller.move(e.getKeyCode());
    }

    void newGame() {
	controller.newGame();
    }

    void nextStage() {
	controller.nextStage();
    }
    
    class DisplayThread extends Thread{
	@Override
	public void run() {
	    while (true) {		
                repaint();
		try {
		    Thread.sleep(1000/FRAMES);
		} catch (InterruptedException ex) {
		    Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
		}
	    }
	}
    }

    @Override
    public void paint(Graphics g) {
        controller.draw((Graphics2D)g);
    }

}
