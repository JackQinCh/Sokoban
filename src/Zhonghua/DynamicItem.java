/*
 *  Copyright (C) 2015 Zhonghua Qin
 *  @filename DynamicItem.java 
 *  @author Zhonghua Qin
 *  @datetime Nov 29, 2015  10:09:33 AM
 *  @version 1.0
 *  @Description
 */
package Zhonghua;

import java.awt.Image;

/**
 * Sokoban map item model
 * @author Zhonghua Qin
 */
public class DynamicItem {
    Image image;
    int x;
    int y;
    int tmpX;
    int tmpY;
    int dX;
    int dY;
    private int wide;
    private int heigh;

    public int getWide() {
	return wide;
    }

    public int getHeigh() {
	return heigh;
    }

    public DynamicItem(Image image, int x, int y, int dX, int dY, int wide, int heigh) {
	this.image = image;
	this.x = x;
	this.y = y;
	this.tmpX = x;
	this.tmpY = y;
	this.dX = dX;
	this.dY = dY;
	this.wide = wide;
	this.heigh = heigh;
    }

}
