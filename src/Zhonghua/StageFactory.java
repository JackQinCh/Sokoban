/*
 *  Copyright (C) 2015 Zhonghua Qin
 *  @filename StageFactory.java 
 *  @author Zhonghua Qin
 *  @datetime Nov 29, 2015  6:53:07 PM
 *  @version 1.0
 *  @Description
 */
package Zhonghua;

/**
 * Stage data factory.
 * @author Zhonghua Qin
 */
public final class StageFactory {
    private static final int[][] stage1 = {
        {9, 9, 9, 9, 9, 9},
        {9, 1, 1, 1, 1, 1},
        {1, 1, 0, 0, 0, 1},
        {1, 6, 3, 0, 0, 1},
        {1, 1, 1, 1, 1, 1},
        {9, 9, 9, 9, 9, 9}
    };
    private static final int[][] stage2 = {
        {9, 9, 9, 9, 9, 9},
        {1, 1, 1, 1, 1, 1},
        {1, 5, 5, 2, 2, 1},
        {1, 0, 3, 3, 5, 1},
        {1, 4, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1}
    };
    private static final int[][] stage3 = {
        {1, 1, 1, 1, 1, 1},
        {1, 0, 2, 0, 0, 1},
        {1, 0, 3, 4, 0, 1},
        {1, 0, 1, 3, 2, 1},
        {1, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1}
    };
    private static final int[][] stage4 = {
        {1, 1, 1, 1, 1, 1},
        {1, 0, 2, 0, 0, 1},
        {1, 0, 3, 4, 0, 1},
        {1, 0, 1, 3, 2, 1},
        {1, 0, 3, 0, 2, 1},
        {1, 1, 1, 1, 1, 1}
    };
    private static final int[][] stage5 = {
        {1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 1},
        {1, 0, 3, 4, 2, 1},
        {1, 0, 1, 3, 2, 1},
        {1, 0, 3, 0, 2, 1},
        {1, 1, 1, 1, 1, 1}
    };
    private static final int[][] stage6 = {
        {1, 1, 1, 1, 1, 1},
        {1, 0, 0, 2, 0, 1},
        {1, 0, 3, 4, 0, 1},
        {1, 2, 1, 3, 0, 1},
        {1, 0, 3, 0, 2, 1},
        {1, 1, 1, 1, 1, 1}
    };
    private static final int[][] stage7 = {
        {1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 1},
        {1, 2, 3, 4, 0, 1},
        {1, 2, 1, 3, 0, 1},
        {1, 2, 3, 0, 0, 1},
        {1, 1, 1, 1, 1, 1}
    };
    private static final int[][] stage8 = {
        {1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 1},
        {1, 2, 3, 2, 0, 1},
        {1, 0, 1, 3, 0, 1},
        {1, 2, 3, 4, 0, 1},
        {1, 1, 1, 1, 1, 1}
    };
    private static final int[][] stage9 = {
        {1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 2, 1},
        {1, 2, 3, 0, 0, 1},
        {1, 0, 1, 3, 4, 1},
        {1, 2, 3, 0, 0, 1},
        {1, 1, 1, 1, 1, 1}
    };
    private static final int[][] stage10 = {
        {1, 1, 1, 1, 1, 1},
        {1, 0, 2, 0, 0, 1},
        {1, 2, 3, 0, 0, 1},
        {1, 0, 1, 3, 4, 1},
        {1, 2, 3, 0, 0, 1},
        {1, 1, 1, 1, 1, 1}
    };
    private static final int[][] stage11 = {
        {1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 2, 1},
        {1, 2, 3, 2, 0, 1},
        {1, 0, 1, 3, 3, 1},
        {1, 2, 3, 0, 4, 1},
        {1, 1, 1, 1, 1, 1}
    };
    private static final int[][] stage12 = {
        {1, 1, 1, 1, 1, 1},
        {1, 0, 0, 2, 2, 1},
        {1, 2, 3, 0, 0, 1},
        {1, 0, 1, 3, 3, 1},
        {1, 2, 3, 0, 4, 1},
        {1, 1, 1, 1, 1, 1}
    };
    private static final int[][] stage13 = {
        {1, 1, 1, 1, 1, 1},
        {1, 0, 2, 0, 2, 1},
        {1, 2, 3, 0, 0, 1},
        {1, 0, 1, 3, 3, 1},
        {1, 2, 3, 0, 4, 1},
        {1, 1, 1, 1, 1, 1}
    };
    private static final int[][] stage14 = {
        {1, 1, 1, 1, 1, 1},
        {1, 0, 2, 0, 2, 1},
        {1, 0, 3, 0, 0, 1},
        {1, 2, 1, 3, 3, 1},
        {1, 2, 3, 0, 4, 1},
        {1, 1, 1, 1, 1, 1}
    };
    private static final int[][] stage15 = {
        {1, 1, 1, 1, 1, 9},
        {1, 2, 6, 0, 1, 9},
        {1, 0, 0, 3, 1, 1},
        {1, 0, 3, 0, 0, 1},
        {1, 1, 0, 0, 0, 1},
        {9, 1, 1, 1, 1, 1}
    };
    private static final int[][] stage16 = {
        {1, 1, 1, 1, 1, 1},
        {1, 6, 5, 0, 0, 1},
        {1, 2, 3, 0, 0, 1},
        {1, 0, 3, 0, 0, 1},
        {1, 1, 1, 0, 0, 1},
        {9, 9, 1, 1, 1, 1}
    };
    private static final int[][] stage17 = {
        {1, 1, 1, 1, 1, 1},
        {1, 2, 2, 6, 2, 1},
        {1, 3, 3, 3, 3, 1},
        {1, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1}
    };
    private static final int[][] stage18 = {
        {9, 1, 1, 1, 1, 1},
        {9, 1, 4, 2, 2, 1},
        {1, 1, 3, 5, 3, 1},
        {1, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1}
    };
    private static final int[][] stage19 = {
        {1, 1, 1, 1, 1, 9},
        {1, 2, 2, 0, 1, 9},
        {1, 0, 4, 3, 1, 1},
        {1, 0, 3, 0, 0, 1},
        {1, 1, 0, 0, 0, 1},
        {9, 1, 1, 1, 1, 1}
    };
    private static final int[][] stage20 = {
        {1, 1, 1, 1, 1, 1},
        {1, 0, 0, 2, 2, 1},
        {1, 0, 3, 0, 0, 1},
        {1, 0, 3, 5, 0, 1},
        {1, 1, 4, 0, 1, 1},
        {9, 1, 1, 1, 1, 9}
    };
    
    
    private static final int [][][] stages = {
	stage1, stage2,	 stage3, stage4, stage5,
	stage6, stage7,	 stage8, stage9, stage10,
	stage11, stage12, stage13, stage14, stage15,
	stage16, stage17, stage18, stage19, stage20
    };

    /**
     * get stages data
     * @return int[][][]
     */
    public static int[][][] getStages() {
	return stages;
    }
}
