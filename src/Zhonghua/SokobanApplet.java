/*
 *  Copyright (C) 2015 Zhonghua Qin
 *  @filename SokobanApplet.java 
 *  @author Zhonghua Qin
 *  @datetime Dec 1, 2015  5:45:11 PM
 *  @version 1.0
 *  @Description
 */
package Zhonghua;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JApplet;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author Zhonghua Qin
 */
public class SokobanApplet extends JApplet implements KeyListener{

    // Variables declaration - do not modify                     
    private GamePanel gamePanel;
    // End of variables declaration 
    
    
    /**
     * Initialization method that will be called after the applet is loaded into the browser.
     */
    public void init() {
	// TODO start asynchronous download of heavy resources
	add(initMenu(), BorderLayout.NORTH);
	
	gamePanel = new GamePanel();
	add(gamePanel, BorderLayout.CENTER);
	
	addKeyListener(this);
	setFocusable(true);
	
    }

    // TODO overwrite start(), stop() and destroy() methods
    
    private JMenuBar initMenu(){
	JMenuBar menu = new JMenuBar();
	
//	JMenu menuFile = new JMenu("File");
//	JMenuItem saveItem = new JMenuItem("Save");
//	saveItem.addActionListener((ActionEvent e) -> {
//	    gamePanel.saveGame();
//	});
//	JMenuItem loadItem = new JMenuItem("Load");
//	loadItem.addActionListener((ActionEvent e) -> {
//	    gamePanel.loadGame();
//	});
//	menuFile.add(saveItem);
//	menuFile.add(loadItem);
//	menu.add(menuFile);
	
        JMenu menuCommand = new JMenu("Command");
        JMenuItem newGameItem = new JMenuItem("New Game");
	newGameItem.addActionListener((ActionEvent e) -> {
	    gamePanel.newGame();
	});
        JMenuItem nextStageItem = new JMenuItem("Next Stage");
	nextStageItem.addActionListener((ActionEvent e) -> {
	    gamePanel.nextStage();
	});
        JMenuItem preStageItem = new JMenuItem("Previous Stage");
	preStageItem.addActionListener((ActionEvent e) -> {
	    gamePanel.backStage();
	});
	menuCommand.add(newGameItem);
	menuCommand.add(nextStageItem);
	menuCommand.add(preStageItem);
	
        JMenu menuStage = new JMenu("Stages");
        JMenuItem selectStageItem = new JMenuItem("1~20");
	selectStageItem.addActionListener((ActionEvent e) -> {
	    String s = JOptionPane.showInputDialog("Input Stage",gamePanel.getController().getCurrentStage()+1);
	System.out.println(s);
	try{
	    int n = Integer.parseInt(s);
	    System.out.println(n);
	    if (n>=1 && n<=20){
		gamePanel.setStage(n);
	    }else {
		JOptionPane.showMessageDialog(gamePanel,"The number must in [1,20] range.");
	    }
	}catch (NumberFormatException e2){
	    JOptionPane.showMessageDialog(gamePanel,"Please input number.");
	}
	});
	menuStage.add(selectStageItem);
	
	menu.add(menuCommand);
	menu.add(menuStage);
	
	return menu;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
	gamePanel.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
