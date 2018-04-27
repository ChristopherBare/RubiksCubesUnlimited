/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoodForYourHeart;

import java.util.*;
import Database.*;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

/**
 *
 * @author christopher1
 */
public class UserDB {

    public static boolean addUser(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "INSERT INTO User (`userID`, `firstName`, `lastName`, `email`, 'password')"
                + "VALUES (?, ?, ?, ?, ?)";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, user.getUserID());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getPassword());
            ps.executeUpdate();
            
        } catch (SQLException se) {
            if (((se.getErrorCode() == 30000) && ("23505".equals(se.getSQLState())))) 
                System.out.println("ERROR: Could not insert record into USER; dup primary key: " + user.getUserID());
            else
                System.out.println("ERROR: Could not add row to USER table: " + user.getUserID() + " " + se.getCause());
            return false;
        }catch (Exception e) {
            System.out.println("ERROR: Could not add row to USER table: " + user.getUserID());
            return false;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        System.out.println("Added user to USER table: " + user.getUserID());
        return true;
    }

    public static User getUser(String userID) {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        User user = new User();
        String query = "SELECT * FROM User WHERE userID ='" + userID;
        ResultSet rs = null;
        
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                user.setUserID(rs.getInt("userID"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
            }
            
        } catch(SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement in: " + "UserDB.getAllUsers()");
            System.out.println("ERROR: Could not execute SQL statement: " + se);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
        return user;
    }
    
    public static ArrayList<User> getUsers() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        ArrayList<User> users = new ArrayList<>();
        String query = "SELECT * FROM User ";
        ResultSet rs = null;
        
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt("userID"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
            
        } catch(SQLException se) {
            System.out.println("ERROR: Could not exicute SQL statement in: " + "UserDB.getAllUsers()");
            System.out.println("ERROR: Could not exicute SQL statement: " + se);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return users;
    }
    
    
    public static boolean validateUser(String email, String password) throws NoSuchAlgorithmException, UnsupportedEncodingException, SQLException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM User WHERE email=? and password=?";
        ResultSet rs = null;
        boolean exists = false;
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, Hash.SHA_256(password));
            rs = ps.executeQuery();
            exists = rs.next();
            
        } catch(SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement in: " + "UserDB.validateUser()");
            System.out.println("ERROR: Could not execute SQL statement: " + se);
            return false;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        System.out.println(exists);
        return exists;
    }
    
    public static User getUserByEmail(String email) {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        User user = null;
        String query = "SELECT * FROM User WHERE email = ?";
        ResultSet rs = null;
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                user = new User();
                user.setUserID(rs.getInt("UserID"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
            }
            
        } catch(SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement in: " + "UserDB.getUserByEmail()");
            System.out.println("ERROR: Could not execute SQL statement: " + se);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
        return user;
    }
    
    public static User getUserByID(String userID) {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        User user = null;
        String query = "SELECT * FROM User WHERE userID = ?";
        ResultSet rs = null;
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, userID);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                user = new User();
                user.setUserID(rs.getInt("userID"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
            }
            
        } catch(SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement in: " + "UserDB.getUserByID()");
            System.out.println("ERROR: Could not execute SQL statement: " + se);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
        return user;
    }
    
    public static boolean checkAdmin(int userID) {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        boolean Admin = false;
        String query = "SELECT * FROM Admin WHERE userID = ?";
        ResultSet rs = null;
        
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            
            if(rs.next()) {
                Admin = true;
            }
            
        } catch(SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement in: " + "UserDB.checkAdmin()");
            System.out.println("ERROR: Could not execute SQL statement: " + se);
            
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
        return Admin;
    }
}
