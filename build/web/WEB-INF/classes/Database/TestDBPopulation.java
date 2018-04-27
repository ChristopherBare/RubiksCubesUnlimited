/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import GoodForYourHeart.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Totally not Hunter
 */
public class TestDBPopulation {
    
//    public static void populateDatabaseWithTestUsers() {
//        for (int i=0; i<10; i++) {
//            User user = new User();
//            user.setUserID("000000000"+Integer.toString(i));
//            user.setFirstName("TestUser"+Integer.toString(i));
//            user.setLastName("TestUser"+Integer.toString(i));
//            user.setEmail("TestUser@"+Integer.toString(i)+".com");
//            user.setPassword("test");
//        }
//    }
    
    public static void populateDatabaseWithTestReviews() {
        for (int i=0; i<20; i++) {
            User user = new User();
            user.setUserID(i);
            UserProfile userProfile = new UserProfile(user);
            int random1 = (int) (Math.random() * 6);
            int random2 = (int) ((Math.random() * 6)+6);
            for (int j = random1; j<random2; j++) {
                ItemRating itemRating = new ItemRating();
                itemRating.setItem(ItemDB.getCubes().get(j));
                itemRating.setRating(2 + ((int) (Math.random() * 4)));
                itemRating.setMadeIT(false);
                //userProfile.addSQLRating(itemRating);
            }
        }
    }
    
    public static void removeTestRatings() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        ArrayList<ItemRating> items = new ArrayList<>();
        String query = "DELETE FROM Rated WHERE UserID = ?";

        try {
            for (int i=0; i<20; i++) {
                ps = connection.prepareStatement(query);
                ps.setString(1, Integer.toString(i));
                ps.executeUpdate();
            }
        } catch(SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement in: " + "TestDBPopulation.removeTestRatings()");
            System.out.println("ERROR: Could not execute SQL statement: " + se);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}
