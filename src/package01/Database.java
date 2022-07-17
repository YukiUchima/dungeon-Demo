package package01;

import javax.swing.*;
import java.sql.*;

public class Database {
    private static Connection c = null;
    private static Statement stmt = null;

    public void initializeDatabase(){


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


		//create login table
		try {
			stmt = c.createStatement();
			String sql = "create table IF NOT EXISTS userInfo (user_id serial NOT NULL, USERNAME VARCHAR(20), " +
                    "PASSWORD VARCHAR(20), currentHealth INTEGER, currentWeapon VARCHAR(20) );";
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

    }
    public static void signUp(String user, String pass) {
        try {
            stmt = c.createStatement();

            String SQL = "SELECT * FROM userInfo where username ='" + user +"'";
            ResultSet rs = stmt.executeQuery(SQL);

            //check if username already exists in database
            if (rs.next()) {
                JFrame signUpFailure = new JFrame();
                JOptionPane.showMessageDialog(signUpFailure, "Username already taken. Please try again.");
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
            }
        }
        catch(Exception excp){
            excp.printStackTrace();
            System.err.println(excp.getClass().getName() + ": " + excp.getMessage());
            System.exit(0);
        }

    }
    public static void logIn(String user, String pass) {
        try {
            stmt = c.createStatement();

            String SQL = "SELECT * FROM userInfo where username ='" + user + "'AND password ='" + pass + "'";
            ResultSet rs = stmt.executeQuery(SQL);

            JFrame loginSuccess = new JFrame();

            //if user input matches database, login is successful
            if(rs.next()) {
                JOptionPane.showMessageDialog(loginSuccess, "Login was successful.");
            }
            //username or password do not match database
            else {
                JOptionPane.showMessageDialog(loginSuccess, "Username or password was not recognized. Please try again.");
            }

        }
        catch(Exception excp){
            excp.printStackTrace();
            System.err.println(excp.getClass().getName() + ": " + excp.getMessage());
            System.exit(0);
        }

    }
}
