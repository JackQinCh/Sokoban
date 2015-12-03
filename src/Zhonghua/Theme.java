/*
 *  Copyright (C) 2015 Zhonghua Qin
 *  @filename Theme.java 
 *  @author Zhonghua Qin
 *  @datetime Nov 29, 2015  9:38:04 AM
 *  @version 1.0
 *  @Description
 */
package Zhonghua;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author Zhonghua Qin
 */
public class Theme {
    protected String name = "Default theme";
    protected List<Image> playerUpImages = new ArrayList<>();
    protected List<Image> playerDownImages = new ArrayList<>();
    protected List<Image> playerLeftImages = new ArrayList<>();
    protected List<Image> playerRightImages = new ArrayList<>();
    protected List<Image> wallImages = new ArrayList<>();
    protected List<Image> floorImages = new ArrayList<>();
    protected List<Image> boxImages = new ArrayList<>();
    protected List<Image> boxCompletedImages = new ArrayList<>();
    protected List<Image> targetImages = new ArrayList<>();
    
    public static final Theme[] themes = {
	new Theme(),
	new SnowTheme()
    };
    
    static enum Themes{
	DEFAULT
    }
    
    public static Theme newTheme(int t){
	return themes[t];
    }
    
    public String getName() {
	return name;
    }

    public List<Image> getWallImages() {
	return wallImages;
    }

    public List<Image> getFloorImages() {
	return floorImages;
    }

    public List<Image> getBoxImages() {
	return boxImages;
    }
    public List<Image> getBoxCompletedImages() {
	return boxCompletedImages;
    }

    public List<Image> getTargetImages() {
	return targetImages;
    }

    public List<Image> getPlayerUpImages() {
	return playerUpImages;
    }

    public List<Image> getPlayerDownImages() {
	return playerDownImages;
    }

    public List<Image> getPlayerLeftImages() {
	return playerLeftImages;
    }

    public List<Image> getPlayerRightImages() {
	return playerRightImages;
    }

    protected Theme() {
	initItems();
	initPlayer();
	
    }

    protected void initItems() {
	URL imgURL = getClass().getResource("R/images/Wall_Brown.png");
	try{
	    wallImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/GroundGravel_Dirt.png");
	try{
	    floorImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/Crate_Beige.png");
	try{
	    boxImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/Crate_Blue.png");
	try{
	    boxCompletedImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/EndPoint_Blue.png");
	try{
	    targetImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    protected void initPlayer() {
	URL imgURL;
	//Player Up
	imgURL = getClass().getResource("R/images/Character7.png");
	try{
	    playerUpImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/Character8.png");
	try{
	    playerUpImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/Character7.png");
	try{
	    playerUpImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/Character9.png");
	try{
	    playerUpImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/Character7.png");
	try{
	    playerUpImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	//Player Down
	imgURL = getClass().getResource("R/images/Character4.png");
	try{
	    playerDownImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/Character5.png");
	try{
	    playerDownImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/Character4.png");
	try{
	    playerDownImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/Character6.png");
	try{
	    playerDownImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/Character4.png");
	try{
	    playerDownImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	//Player Left
	imgURL = getClass().getResource("R/images/Character1.png");
	try{
	    playerLeftImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/Character10.png");
	try{
	    playerLeftImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/Character1.png");
	try{
	    playerLeftImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/Character10.png");
	try{
	    playerLeftImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/Character1.png");
	try{
	    playerLeftImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	//Player Right
	imgURL = getClass().getResource("R/images/Character2.png");
	try{
	    playerRightImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/Character3.png");
	try{
	    playerRightImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/Character2.png");
	try{
	    playerRightImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/Character3.png");
	try{
	    playerRightImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/Character2.png");
	try{
	    playerRightImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}
