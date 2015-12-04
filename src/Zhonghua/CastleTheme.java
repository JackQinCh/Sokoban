/*
 *  Copyright (C) 2015 Zhonghua Qin
 *  @filename CastleTheme.java 
 *  @author Zhonghua Qin
 *  @datetime Dec 2, 2015  9:20:04 PM
 *  @version 1.0
 *  @Description
 */
package Zhonghua;

import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 * Castle Theme
 * @author Zhonghua Qin
 */
public class CastleTheme extends Theme{
    @Override
    protected void initItems() {
	this.name = "Castle";
	URL imgURL = getClass().getResource("R/images/Wall_Black.png");
	try{
	    wallImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/GroundGravel_Concrete.png");
	try{
	    floorImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/Crate_Black.png");
	try{
	    boxImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/Crate_Purple.png");
	try{
	    boxCompletedImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/EndPoint_Purple.png");
	try{
	    targetImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}
