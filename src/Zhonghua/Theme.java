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
 * Theme class and theme static factory
 * @author Zhonghua Qin
 */
public class Theme {

    /**
     *name
     */
    protected String name = "Default";

    /**
     * playerUpImages
     */
    protected List<Image> playerUpImages = new ArrayList<>();

    /**
     * playerDownImages
     */
    protected List<Image> playerDownImages = new ArrayList<>();

    /**
     * playerLeftImages
     */
    protected List<Image> playerLeftImages = new ArrayList<>();

    /**
     * playerRightImages
     */
    protected List<Image> playerRightImages = new ArrayList<>();

    /**
     * wallImages
     */
    protected List<Image> wallImages = new ArrayList<>();

    /**
     * floorImages
     */
    protected List<Image> floorImages = new ArrayList<>();

    /**
     * boxImages
     */
    protected List<Image> boxImages = new ArrayList<>();

    /**
     * boxCompletedImages
     */
    protected List<Image> boxCompletedImages = new ArrayList<>();

    /**
     * targetImages
     */
    protected List<Image> targetImages = new ArrayList<>();
    /**
     * themes
     */
    public static final Theme[] themes = {
	new Theme(),
	new SnowTheme(),
	new CastleTheme(),
	new GreenTheme()
    };
    
    /**
     * new theme with index
     * @param t index
     * @return Theme
     */
    public static Theme newTheme(int t){
	return themes[t];
    }
    
    /**
     * Get name
     * @return 
     */
    public String getName() {
	return name;
    }

    /**
     * Get wall images
     * @return List of Image
     */
    public List<Image> getWallImages() {
	return wallImages;
    }

    /**
     * Get floor images
     * @return List of Image
     */
    public List<Image> getFloorImages() {
	return floorImages;
    }
    
    /**
     * Get box images
     * @return List of Image
     */
    public List<Image> getBoxImages() {
	return boxImages;
    }
    /**
     * Get completed box images
     * @return List of Images
     */
    public List<Image> getBoxCompletedImages() {
	return boxCompletedImages;
    }

    /**
     * Get target Images
     * @return List of Image
     */
    public List<Image> getTargetImages() {
	return targetImages;
    }

    /**
     * Get player up images
     * @return List of image
     */
    public List<Image> getPlayerUpImages() {
	return playerUpImages;
    }

    /**
     * Get player down images
     * @return List of image
     */
    public List<Image> getPlayerDownImages() {
	return playerDownImages;
    }

    /**
     * Get player left images
     * @return List of image
     */
    public List<Image> getPlayerLeftImages() {
	return playerLeftImages;
    }

    /**
     * Get player right images
     * @return List of image
     */
    public List<Image> getPlayerRightImages() {
	return playerRightImages;
    }

    /**
     * Constructor
     */
    protected Theme() {
	initItems();
	initPlayer();
	
    }

    /**
     * Initial Items res
     */
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

    /**
     * Initial player res
     */
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
