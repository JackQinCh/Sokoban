/*
 *  Copyright (C) 2015 Zhonghua Qin
 *  @filename GameController.java 
 *  @author Zhonghua Qin
 *  @datetime Nov 29, 2015  8:50:21 AM
 *  @version 1.0
 *  @Description
 */
package Zhonghua;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Zhonghua Qin
 */
public class GameController {
    
    GamePanel gamePanel;
    
    protected static final int FLOOR = 0;
    protected static final int WALL = 1;
    protected static final int TARGET = 2;
    protected static final int BOX = 3;
    protected static final int PLAYER = 4;
    protected static final int OUTSIDE = 9;
    
    protected static final int BLOCK = 55;
    protected static final int MAPSIZE = 6;
    protected static final int PLAYER_W = BLOCK * 2/3;
    protected static final int PLAYER_H = BLOCK;
    protected static final int TARGET_W = BLOCK * 2/3;
    
    private final int[][] stage1 = {
        {9, 9, 9, 9, 9, 9},
        {9, 1, 1, 1, 1, 1},
        {1, 1, 0, 0, 0, 1},
        {1, 2, 4, 3, 0, 1},
        {1, 1, 1, 1, 1, 1},
        {9, 9, 9, 9, 9, 9}
    };
    private final int[][] stage2 = {
        {9, 9, 9, 9, 9, 9},
        {9, 1, 1, 1, 1, 1},
        {1, 1, 0, 0, 0, 1},
        {1, 2, 4, 3, 0, 1},
        {1, 1, 1, 1, 1, 1},
        {9, 9, 9, 9, 9, 9}
    };
    private final int[][] stage3 = {
        {9, 9, 9, 9, 9, 9},
        {9, 1, 1, 1, 1, 1},
        {1, 1, 0, 0, 0, 1},
        {1, 2, 4, 3, 0, 1},
        {1, 1, 1, 1, 1, 1},
        {9, 9, 9, 9, 9, 9}
    };
    
    private int [][][] stages = {
	stage1,
	stage2,
	stage3
    };
    
    protected int [][] map = new int[MAPSIZE][MAPSIZE];
    private int currentStage;
    protected List<DynamicItem> box = new LinkedList();
    private List<DynamicItem> targets = new LinkedList();
    protected DynamicItem player;
    
    private Theme theme;

    public GameController(GamePanel gamePanel) {
	this.gamePanel = gamePanel;
	
	theme = new Theme();
	
	currentStage = 0;
	initGame();
    }

    private void initGame() {
	for (int i = 0; i < MAPSIZE; i++) {
	    for (int j = 0; j < MAPSIZE; j++) {
		map[i][j] = stages[currentStage][i][j];
	    }
	}
	
	for (int i = 0; i < MAPSIZE; i++) {
	    for (int j = 0; j < MAPSIZE; j++) {
		switch (map[i][j]) {
		    case PLAYER:
			player = new DynamicItem(theme.getPlayerDownImages().get(0),
				j, i,
				j*BLOCK+(BLOCK-PLAYER_W)/2,
				i*BLOCK+(BLOCK-PLAYER_H)/2, 
				PLAYER_W, PLAYER_H);
			break;
		    case BOX:
			box.add(new DynamicItem(theme.getBoxImages().get(0), j, i, j*BLOCK, i*BLOCK, BLOCK, BLOCK));
			break;
		    case TARGET:
			targets.add(new DynamicItem(theme.getTargetImages().get(0),
				j, i,
				j*BLOCK+(BLOCK-TARGET_W)/2, 
				i*BLOCK+(BLOCK-TARGET_W)/2, TARGET_W, TARGET_W));
			break;
		    case PLAYER+TARGET:
			player = new DynamicItem(theme.getPlayerDownImages().get(0),
				j, i,
				j*BLOCK+(BLOCK-PLAYER_W)/2,
				i*BLOCK+(BLOCK-PLAYER_H)/2, 
				PLAYER_W, PLAYER_H);
			targets.add(new DynamicItem(theme.getTargetImages().get(0),
				j, i,
				j*BLOCK+(BLOCK-TARGET_W)/2, 
				i*BLOCK+(BLOCK-TARGET_W)/2, TARGET_W, TARGET_W));
			break;
		    case BOX+TARGET:
			box.add(new DynamicItem(theme.getBoxImages().get(0), j, i, j*BLOCK, i*BLOCK, BLOCK, BLOCK));
			targets.add(new DynamicItem(theme.getTargetImages().get(0),
				j, i,
				j*BLOCK+(BLOCK-TARGET_W)/2, 
				i*BLOCK+(BLOCK-TARGET_W)/2, TARGET_W, TARGET_W));
			break;
		    default:
			break;
		}
	    }
	}
	System.out.println("Player X:"+player.x+", Y:"+player.y);
    }
    
    public void draw(Graphics2D g2d){
	g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	
        //Background
        for (int i = 0; i < MAPSIZE; i++)
            for (int j = 0; j < MAPSIZE; j++) {
		if (map[i][j] == WALL) {
		    g2d.drawImage(theme.getWallImages().get(0), j*BLOCK, i*BLOCK, BLOCK, BLOCK, null);
		}else{
		    g2d.drawImage(theme.getFloorImages().get(0), j*BLOCK, i*BLOCK, BLOCK, BLOCK, null);
		}
            }
	
	//Dynamic items
	for (DynamicItem target : targets) {
	    g2d.drawImage(target.image, target.dX, target.dY, target.getWide(), target.getHeigh(), null);
	}
	for (DynamicItem b : box) {
	    g2d.drawImage(b.image, b.dX, b.dY, b.getWide(), b.getHeigh(), null);
	}
	g2d.drawImage(player.image, player.dX, player.dY, player.getWide(), player.getHeigh(), null);
    }
    
    private boolean isPlaying = false;
    private Timer timer;
    private void playAnimation(DynamicItem item, List<Image> frames, Point distancePoint, int cycle, int time){
	isPlaying = true;
	timer = new Timer();
	
	List<Image> allFrames = new LinkedList<>();
	if (frames.size() > 1) {
	    List<Image> midFrames = new LinkedList<>();
	    midFrames.addAll(frames);
	    midFrames.remove(midFrames.size()-1);
	    
	    for (int i = 0; i < cycle; i++) {
		allFrames.addAll(midFrames);
	    }
	    allFrames.add(frames.get(frames.size()-1));
	}else{
	    for (int i = 0; i < cycle; i++) {
		allFrames.addAll(frames);
	    }
	}
	
	int spanT = time/allFrames.size();
	int startX = item.dX;
	int startY = item.dY;
	double spanX = ((double)distancePoint.x)/(allFrames.size()-1);
	double spanY = ((double)distancePoint.y)/(allFrames.size()-1);
	
	timer.schedule(new TimerTask() {
	    int n = 0;
	    @Override
	    public void run() {
		item.image = allFrames.get(n);
		item.dX = startX + (int)(spanX*n);
		item.dY = startY + (int)(spanY*n);
		n++;
		if (n == allFrames.size()) {
		    isPlaying = false;
		    cancel();
		}
	    }
	}, 0, spanT);
    }
    private void stopAnimation(){
	if (timer != null) {
	    timer.cancel();
	}
    }
    
    public void move(int direction){
	if (isPlaying) {
	    return;
	}
	int newX;
        int newY;
        int crossX;
        int crossY;
	List<Image> framesImages = new ArrayList<>();
        switch(direction){
            case KeyEvent.VK_UP:
                System.out.println("Up");
                newX = player.x;
                newY = player.y - 1;
                crossX = newX;
                crossY = newY - 1;
		framesImages.addAll(theme.getPlayerUpImages());
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("Down");
                newX = player.x;
                newY = player.y + 1;
                crossX = newX;
                crossY = newY + 1;
		framesImages.addAll(theme.getPlayerDownImages());
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("Left");
                newX = player.x - 1;
                newY = player.y;
                crossX = newX - 1;
                crossY = newY;
		framesImages.addAll(theme.getPlayerLeftImages());
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("Right");
                newX = player.x + 1;
                newY = player.y;
                crossX = newX + 1;
                crossY = newY;
		framesImages.addAll(theme.getPlayerRightImages());
                break;
            default:
                return;
        }
        if (map[newY][newX] == FLOOR || map[newY][newX] == TARGET) {
            map[newY][newX] += PLAYER;
            map[player.y][player.x] -= PLAYER;
	    //Move
	    playAnimation(player, framesImages, 
		    new Point((newX - player.x)*BLOCK, (newY - player.y)*BLOCK), 2, 1000);
	    player.x = newX;
            player.y = newY;
        }else if(map[newY][newX] == BOX){
	    DynamicItem boxT = null;
	    for (DynamicItem b : box) {
		if (b.x == newX && b.y == newY) {
		    boxT = b;
		}
	    }
            if (map[crossY][crossX] == FLOOR || map[crossY][crossX] == TARGET) {
                map[crossY][crossX] += BOX;
                map[newY][newX] = map[newY][newX] - BOX + PLAYER;
                map[player.y][player.x] -= PLAYER;
		//Move
		playAnimation(boxT, theme.getBoxImages(), 
		    new Point((crossX - boxT.x)*BLOCK, (crossY - boxT.y)*BLOCK), 5*2, 1000);
		boxT.x = crossX;
		boxT.y = crossY;
		playAnimation(player, framesImages, 
		    new Point((newX - player.x)*BLOCK, (newY - player.y)*BLOCK), 2, 1000);
                player.x = newX;
                player.y = newY;
            }
        }
    }
    
    protected void newGame(){
	stopAnimation();
	initGame();
    }
}