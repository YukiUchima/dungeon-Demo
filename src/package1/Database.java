<<<<<<< HEAD:src/package01/Database.java
//<<<<<<< HEAD
package package01;

import javax.swing.*;

import package03.SuperWeapon;

import java.sql.*;

public class Database {
    private static Connection c = null;
    private static Statement stmt = null;
    static RoomGame gm = new RoomGame();
    static UI ui = new UI();
    static  VisibilityManager vm = new VisibilityManager(ui);
    

    public static void main(String[] args){


        //connect to database
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/adventuredb",
                    "postgres", "alassafi2001");
            System.out.println("Connected to the database.");

        }
        catch(Exception excp){
            excp.printStackTrace();
            System.err.println(excp.getClass().getName() + ": " + excp.getMessage());
            System.exit(0);
        }

/*
		//create login table
		try {
			stmt = c.createStatement();
			String sql = "create table IF NOT EXISTS userInfo (USERNAME VARCHAR(20), " +
                    "PASSWORD VARCHAR(20), currentHealth INTEGER, currentLocation VARCHAR(20));";
		    stmt.executeUpdate(sql);
			
		    stmt.close();
			c.close();
			
			System.out.println("Table has been created");
		}
		catch(Exception excp) {
			excp.printStackTrace();
			System.err.println(excp.getClass().getName() + ": " + excp.getMessage());
			System.exit(0);
		}
		
		*/

    }
    
   
    public static void signUp(String user, String pass) {
    	//int signUpSuccess = 1;
        try {
        	
            stmt = c.createStatement();

            String SQL = "SELECT * FROM userInfo where username ='" + user +"'";
            ResultSet rs = stmt.executeQuery(SQL);

            //check if username already exists in database
            if (rs.next()) {
                JFrame signUpFailure = new JFrame();
                JOptionPane.showMessageDialog(signUpFailure, "Username already taken. Please try again.");
                //signUpSuccess = 0;
            }
            //if username does not already exist, add user info to database
            else {
                c.setAutoCommit(false);
                PreparedStatement st = c.prepareStatement("INSERT INTO userInfo(USERNAME, PASSWORD) VALUES(?,?)");
                st.setString(1, user);
                st.setString(2, pass);
                st.executeUpdate();
                
                st.close();
                c.commit();
                c.close();
                
                System.out.println("Added elements to table");
                //signUpSuccess = 1;
            }
        }
        catch(Exception excp){
            excp.printStackTrace();
            System.err.println(excp.getClass().getName() + ": " + excp.getMessage());
            System.exit(0);
        }
        //return signUpSuccess;

    }
    public static void logIn(String user, String pass) {
    	//int signInSuccess = 0;
        try {
            stmt = c.createStatement();

            String SQL = "SELECT * FROM userInfo where username ='" + user + "'AND password ='" + pass + "'";
            ResultSet rs = stmt.executeQuery(SQL);

            JFrame loginSuccess = new JFrame();

            //if user input matches database, login is successful
            if(rs.next()) {
                
                int hp = rs.getInt("currentHealth");
                String location = rs.getString("currentLocation");
                
                Player.setHP(hp);
				Story.selectPosition(location);
                
                
                
                rs.close();
                stmt.close();
                c.close();
                
                System.out.println("User info retrieved and set");
                //signInSuccess = 1;
                
            }
            //username or password do not match database
            else {
                JOptionPane.showMessageDialog(loginSuccess, "Username or password was not recognized. Please try again.");
                
                //signInSuccess = 0;
                
            }

        }
        catch(Exception excp){
            excp.printStackTrace();
            System.err.println(excp.getClass().getName() + ": " + excp.getMessage());
            System.exit(0);
        }
        //return signInSuccess;

    }
  
    
    public static void save(String user, String pass, String location, int hp) {
    	 try {
    		c.setAutoCommit(false);
    		stmt = c.createStatement();
    		String sql = "UPDATE userinfo set currentLocation = '" + location + 
    				"', currentHealth = '" + hp + "'WHERE username = '" + user + "' AND password = '" + pass + "'";
    		stmt.executeUpdate(sql);
    		c.commit();
    		
    		System.out.println("User information has been saved");
    		
    		
            stmt.close();
            c.close();
    		 
    	 }
    	 catch(Exception excp){
             excp.printStackTrace();
             System.err.println(excp.getClass().getName() + ": " + excp.getMessage());
             System.exit(0);
         }

    }

}

//=======
=======
package package1;
>>>>>>> e4b81770071cb1e2cdaad117485d187231564dd6:src/package1/Database.java
//package package01;
//
//import javax.swing.*;
//import java.sql.*;
//
////  Database table:
////  USERNAME, currentHealth, currentWeapon
//public class Database {
//    private static Connection c = null;
//    private static Statement stmt = null;
//
//    Player player = new Player();
//
//    public void initializeDatabase() {
//
//
//        connect to database
//        try {
//            Class.forName("org.postgresql.Driver");
//            c = DriverManager.getConnection(
//                    "jdbc:postgresql://localhost:5432/adventuredb",
//                    "postgres", "password");
//            System.out.println("Connected to the database.");
//
//        }
//        catch(Exception excp){
//            excp.printStackTrace();
//            System.err.println(excp.getClass().getName() + ": " + excp.getMessage());
//            System.exit(0);
//        }
//        System.out.println("DATABASE INITIALIZED");
//
//        create login table
//		try {
//			stmt = c.createStatement();
//			String sql = "create table IF NOT EXISTS userInfo (user_id serial NOT NULL, USERNAME VARCHAR(20), " +
//                    "PASSWORD VARCHAR(20), currentHealth INTEGER, currentWeapon VARCHAR(20) );";
//		    stmt.executeUpdate(sql);
//			stmt.close();
//			c.close();
//			System.out.println("Table has been created");
//		}
//		catch(Exception excp) {
//			excp.printStackTrace();
//			System.err.println(excp.getClass().getName() + ": " + excp.getMessage());
//			System.exit(0);
//		}
//
//    }
//
//    public static void signUp(String user, String pass) {
//        try {
//            stmt = c.createStatement();
//
//            String SQL = "SELECT * FROM userInfo where username ='" + user +"'";
//            ResultSet rs = stmt.executeQuery(SQL);
//
//            //check if username already exists in database
//            if (rs.next()) {
//                JFrame signUpFailure = new JFrame();
//                JOptionPane.showMessageDialog(signUpFailure, "Username already taken. Please try again.");
//            }
//            //if username does not already exist, add user info to database
//            else {
//                c.setAutoCommit(false);
//                PreparedStatement st = c.prepareStatement("INSERT INTO userInfo(USERNAME, PASSWORD) VALUES(?,?)");
//                st.setString(1, user);
//                st.setString(2, pass);
//                st.executeUpdate();
//                st.close();
//                c.commit();
//                c.close();
//                System.out.println("Added elements to table");
//            }
//        }
//        catch(Exception excp){
//            excp.printStackTrace();
//            System.err.println(excp.getClass().getName() + ": " + excp.getMessage());
//            System.exit(0);
//        }
//        System.out.println("SIGN UP COMPLETED");
//
//    }
//
//    public static void logIn(String user, String pass) {
//        System.out.println("LOGGED IN SUCCESSFUL");
//        try {
//            stmt = c.createStatement();
//
//            String SQL = "SELECT * FROM userInfo where username ='" + user + "'AND password ='" + pass + "'";
//            ResultSet rs = stmt.executeQuery(SQL);
//
//            JFrame loginSuccess = new JFrame();
//
//            //if user input matches database, login is successful
//            if(rs.next()) {
//                JOptionPane.showMessageDialog(loginSuccess, "Login was successful.");
//            }
//            //username or password do not match database
//            else {
//                JOptionPane.showMessageDialog(loginSuccess, "Username or password was not recognized. Please try again.");
//            }
//
//        }
//        catch(Exception excp){
//            excp.printStackTrace();
//            System.err.println(excp.getClass().getName() + ": " + excp.getMessage());
//            System.exit(0);
//        }
//
//    }
//
//
//    public static void saveGame(int curHlth, String curWpn) {
//        player.hp = curHlth;
//
//        System.out.println("GAME SAVED");
//
//        try{
//            stmt = c.createStatement();
//
//        String SQL = "UPDATE userInfo SET currentHealth=" + curHlth + ", currentWeapon=" + curWpn "" + +
//            "WHERE username ='" + user;
//            String SQL = "SELECT * FROM userInfo where username ='" + user + "'AND password ='" + pass + "'";
//            ResultSet rs = stmt.executeQuery(SQL);
//
//            JFrame loginSuccess = new JFrame();
//
//            //if user input matches database, login is successful
//            if(rs.next()) {
//                JOptionPane.showMessageDialog(loginSuccess, "Login was successful.");
//            }
//            //username or password do not match database
//            else {
//                JOptionPane.showMessageDialog(loginSuccess, "Username or password was not recognized. Please try again.");
//            }
//
//        }
//        catch(Exception excp){
//            excp.printStackTrace();
//            System.err.println(excp.getClass().getName() + ": " + excp.getMessage());
//            System.exit(0);
//        }
//        }
//    }
//}
//>>>>>>> branch 'master' of https://github.com/YukiUchima/dungeon-Demo.git
