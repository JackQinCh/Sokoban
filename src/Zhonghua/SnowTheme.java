/*
 *  Copyright (C) 2015 Zhonghua Qin
 *  @filename NewClass.java 
 *  @author Zhonghua Qin
 *  @datetime Dec 2, 2015  6:15:31 PM
 *  @version 1.0
 *  @Description
 */
package Zhonghua;

import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author Zhonghua Qin
 */
public class SnowTheme extends Theme{

    @Override
    protected void initItems() {
	this.name = "Snow";
	URL imgURL = getClass().getResource("R/images/Wall_Gray.png");
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
	imgURL = getClass().getResource("R/images/CrateDark_Brown.png");
	try{
	    boxImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/Crate_Red.png");
	try{
	    boxCompletedImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	imgURL = getClass().getResource("R/images/EndPoint_Red.png");
	try{
	    targetImages.add(ImageIO.read(imgURL));
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
    
}
