/*
 *  Copyright (C) 2015 Zhonghua Qin
 *  @filename SQLManager.java 
 *  @author Zhonghua Qin
 *  @datetime Dec 2, 2015  2:29:38 PM
 *  @version 1.0
 *  @Description
 */
package Zhonghua;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Zhonghua Qin
 */
public class SQLManager {
    private static final String USER = "zq42";
    private static final String PASSWORD = "VBT6clKp";
    private static final String SERVER = "jdbc:mysql://sql2.njit.edu:3306/zq42";
    private static final String MYSQLDRIVER = "com.mysql.jdbc.Driver";
    
    private SQLManager(){
    }
    
    public static void save(int[][] map){
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
	
	String mapString = mapToString(map);
	System.out.println(mapString);
	
	try {
	    Class.forName("com.mysql.jdbc.Driver").newInstance();
	    System.out.println("Successfully import MySQL driver!");
	    System.out.println("Connecting...");
	    connection = DriverManager.getConnection(SERVER, USER, PASSWORD);
	    System.out.println("Successfully connect NJIT MySQL server!");
	    statement = connection.createStatement();
	    rs = statement.executeQuery("SELECT * FROM Sokoban");
	    statement.executeUpdate("TRUNCATE Sokoban");
	    statement.execute("insert into Sokoban (map) values('"+mapString+"')");
	    
	    rs.close();
	    
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
	    System.out.println("SQL error.");
	}
	
    }
    
    public static int[][] load(){
	int[][] map = new int[GameController.MAPSIZE][GameController.MAPSIZE];
	
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
	
	String mapString = "";
	
	try {
	    Class.forName("com.mysql.jdbc.Driver").newInstance();
	    System.out.println("Successfully import MySQL driver!");
	    System.out.println("Connecting...");
	    connection = DriverManager.getConnection(SERVER, USER, PASSWORD);
	    System.out.println("Successfully connect NJIT MySQL server!");
	    statement = connection.createStatement();
	    rs = statement.executeQuery("SELECT * FROM Sokoban");
	    while (rs.next()) {
		mapString = rs.getString("map");
		System.out.println(mapString);
	    }
	    
	    rs.close();
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
	    System.out.println("Can't connect to NJIT MySQL server.");
	}
	
	if (mapString.equals("")) {
	    return null;
	}
	
	return stringToMap(mapString);
    }
    
    private static String mapToString(int[][] map){
	String mapString = "";
	for (int i = 0; i < GameController.MAPSIZE; i++) {
	    for (int j = 0; j < GameController.MAPSIZE; j++) {
		mapString += String.valueOf(map[i][j]) + ",";
	    }
	}
	mapString = mapString.substring(0, mapString.length()-1);
	
	return mapString;
    }
    
    private static int [][] stringToMap(String mapString){
	int[][] map = new int[GameController.MAPSIZE][GameController.MAPSIZE];
	
	String[] mapStrings = mapString.split(",");
	for (int i = 0; i < GameController.MAPSIZE; i++) {
	    for (int j = 0; j < GameController.MAPSIZE; j++) {
		map[i][j] = Integer.valueOf(mapStrings[i*GameController.MAPSIZE + j]);
	    }
	}
	return map;
    }
}
