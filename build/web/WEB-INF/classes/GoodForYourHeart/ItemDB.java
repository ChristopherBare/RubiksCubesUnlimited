/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoodForYourHeart;

import Database.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author christopher1
 */
public class ItemDB {

    public static void createItemTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//3x3
    public static Item addItem(String itemCode, String name, String category, double rating, double price, int numRatings, String description, String tagline) {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        Item item = new Item();
        String query = "INSERT INTO item VALUES (?, ?, ?, ?, ?, ?, ?)";
        ResultSet rs = null;
        
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            
            ps.setString(1, itemCode);
            ps.setString(2, name);
            ps.setString(3, category);
            ps.setDouble(4, rating);
            ps.setDouble(5, price);
            ps.setInt(6, numRatings);
            ps.setString(7, description);
            ps.setString(8, tagline);

            ps.executeUpdate();
            
        } catch(SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement in: " + "ItemDB.getAllItems()");
            System.out.println("ERROR: Could not execute SQL statement: " + se);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return item;
    }

    public static Item addCube(Item item) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "INSERT INTO Item (`ItemCode`, `Name`, `Category`, `Rating`, `Price`, `NumRatings`, `Description`) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        ResultSet rs = null;
        
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            
            ps.setString(1, item.getItemCode());
            ps.setString(2, item.getName());
            ps.setString(3, item.getCatalogCategory());
            ps.setDouble(4, item.getRating());
            ps.setString(5, item.getPrice());
            ps.setDouble(6, item.getNumRatings());
            ps.setString(7, item.getDescription());
            ps.setString(8, item.getTagline());
            ps.executeUpdate();
            
        } catch(SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement in: " + "ItemDB.getAllItems()");
            System.out.println("ERROR: Could not execute SQL statement: " + se);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return item;
    }

    public static Item getCube(String itemCode) {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        Item item = new Item();
        String query = "SELECT * FROM Item WHERE ItemCode = " + itemCode;
        ResultSet rs = null;
        
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                item.setItemCode(rs.getString("itemCode"));
                item.setName(rs.getString("name"));
                item.setCatalogCategory(rs.getString("catelogCategory"));
                item.setRating((int) rs.getDouble("rating"));
                item.setPrice(rs.getDouble("price"));
                item.setNumRatings(rs.getInt("numRatings"));
                item.setDescription(rs.getString("description"));
                item.setTagline(rs.getString("tagline"));
            }
            
        } catch(SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement in: " + "ItemDB.getAllItems()");
            System.out.println("ERROR: Could not execute SQL statement: " + se);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return item;
    }
    
    public static ArrayList<Item> getCubes() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        ArrayList<Item> items = new ArrayList<>();
        String query = "SELECT * FROM Item ";
        ResultSet rs = null;
        
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                Item item = new Item();
                item.setItemCode(rs.getString("itemCode"));
                item.setName(rs.getString("name"));
                item.setCatalogCategory(rs.getString("catelogCategory"));
                item.setRating((int) rs.getDouble("rating"));
                item.setPrice(rs.getDouble("price"));
                item.setNumRatings(rs.getInt("numRatings"));
                item.setDescription(rs.getString("description"));
                item.setTagline(rs.getString("tagline"));
                items.add(item);
            }
            
        } catch(SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement in: " + "ItemDB.getAllItems()");
            System.out.println("ERROR: Could not execute SQL statement: " + se);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return items;
    }

    public static ArrayList<Item> getAllCubesInCategory(String category) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        ArrayList<Item> items = new ArrayList<>();
        String query = "SELECT * FROM Item WHERE Category = ?";
        ResultSet rs = null;
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, category);
            rs = ps.executeQuery();
            User user = null;
            if (rs.next()) {
                Item item = new Item();
                item.setItemCode(rs.getString("itemCode"));
                item.setName(rs.getString("name"));
                item.setCatalogCategory(rs.getString("catelogCategory"));
                item.setRating((int) rs.getDouble("rating"));
                item.setPrice(rs.getDouble("price"));
                item.setNumRatings(rs.getInt("numRatings"));
                item.setDescription(rs.getString("description"));
                item.setTagline(rs.getString("tagline"));
                items.add(item);
            }
            return items;
        } catch(SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement in: " + "ItemDB.getAllItems()");
            System.out.println("ERROR: Could not execute SQL statement: " + se);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static List getCategories() {
        List categoryCodes = new ArrayList();

        Statement statement = DbConnection.getNewStatement();
        ResultSet resultSet = null;

        String category;
        int i = 0;
        try {

            resultSet = statement.executeQuery(
                    "SELECT DISTINCT category FROM ITEM");

            while (resultSet.next()) {
                category = resultSet.getString("catelogCategory");
                categoryCodes.add(category);
                System.out.println("Found category in ITEM table: " + category);
            }
        } catch (SQLException se) {
            System.out.println("ERROR: Could not exicute SQL statement in: " + "ItemDB.getAllItems()");
            System.out.println("ERROR: Could not exicute SQL statement: " + se);
            return null;
        }

        return categoryCodes;
    }

    public static boolean exists(String itemCode) {
        Item p = getCube(itemCode);
        if (p != null) {
            return true;
        } else {
            return false;
        }
    }


}
