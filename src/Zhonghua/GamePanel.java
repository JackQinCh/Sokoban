/*
 *  Copyright (C) 2015 Zhonghua Qin
 *  @filename GamePanel.java 
 *  @author Zhonghua Qin
 *  @datetime Nov 28, 2015  6:24:30 PM
 *  @version 1.0
 *  @Description
 */
package Zhonghua;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 * Sokoban game panel
 * @author Zhonghua Qin
 */
public class GamePanel extends JPanel {
    private final GameController controller;
    private static final int FRAMES = 60;

    /**
     * GamePanel Constructor
     */
    public GamePanel() {
	controller = new GameController(this);
        
        DisplayThread displayThread = new DisplayThread();
        
        displayThread.start();
        
    }

    /**
     * Get game controller
     * @return GameController
     */
    GameController getController() {
	return controller;
    }

    /**
     * keyPressed event
     * @param e KeyEvent
     */
    void keyPressed(KeyEvent e) {
	controller.move(e.getKeyCode());
    }

    /**
     * new game
     */
    void newGame() {
	controller.newGame();
    }

    /**
     * next stage
     */
    void nextStage() {
	controller.nextStage();
    }

    /**
     * previous stage
     */
    void backStage() {
	controller.backStage();
    }

    /**
     * set stage
     * @param n int
     */
    void setStage(int n) {
	controller.setStage(n);
    }

    /**
     * save game 
     */
    void saveGame() {
	controller.saveGame();
    }

    /**
     * load game
     */
    void loadGame() {
	controller.loadGame();
    }

    /**
     * set theme
     * @param theme int
     */
    void setTheme(int theme) {
	controller.setTheme(theme);
    }
    
    private class DisplayThread extends Thread{
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

    /**
     * paint method
     * @param g Graphics
     */
    @Override
    public void paint(Graphics g) {
        controller.draw((Graphics2D)g);
    }

}
