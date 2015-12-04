/*
 *  Copyright (C) 2015 Zhonghua Qin
 *  @filename GreenTheme.java 
 *  @author Zhonghua Qin
 *  @datetime Dec 2, 2015  9:59:14 PM
 *  @version 1.0
 *  @Description
 */
package Zhonghua;

import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 * Green Theme
 * @author Zhonghua Qin
 */
public class GreenTheme extends Theme{
    @Override
    protected void initItems() {
	this.name = "Green";
	URL imgURL = getClass().getResource("R/images/Wall_Beige.png");
	try{
	    wallImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/GroundGravel_Grass.png");
	try{
	    floorImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/Crate_Yellow.png");
	try{
	    boxImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/Crate_Gray.png");
	try{
	    boxCompletedImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/EndPoint_Gray.png");
	try{
	    targetImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}
