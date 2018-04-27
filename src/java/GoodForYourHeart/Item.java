package GoodForYourHeart;


import Database.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;


/**
 *
 * @author christopher1
 */
public class Item implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String itemCode;
    private String name;
    private String catalogCategory;
    private String tagline;
    private String description;
    private double rating;
    private double price;
    private int numRatings;
    
    
    
    public Item() {
        itemCode = "";
        name = "";
        catalogCategory = "";
        tagline = "";
        description = "";
        rating = 0.0;
        price = 0.0;
    }
    public Item(String itemCode, String name, String category, String tagline, String description,
            int rating, double price) {
        this.itemCode = itemCode;
        this.name = name;
        this.catalogCategory = category;
        this.tagline = tagline;
        this.description = description;
        this.rating = rating;
        this.price = price;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatalogCategory() {
        return catalogCategory;
    }

    public void setCatalogCategory(String catalogCategory) {
        this.catalogCategory = catalogCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }
    
    public void updateRating(double rating) {
        this.numRatings += 1;
        this.rating -= this.rating / this.numRatings;
        this.rating += rating / this.numRatings;
        this.rating = Double.parseDouble(new DecimalFormat("##.#").format(this.rating));
    }
    
    public void changeRating(double rating) {
        this.rating -= this.rating / this.numRatings;
        this.rating += rating / this.numRatings;
        this.rating = Double.parseDouble(new DecimalFormat("##.#").format(this.rating));
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
    public String getImageUrl(String itemCode) {
        return itemCode + ".jpg";
    }

    public String getPrice() {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        String priceAsString = format.format(price).substring(1);
        return priceAsString;
    }
   

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumRatings() {
        return numRatings;
    }

    public void setNumRatings(int numRatings) {
        this.numRatings = numRatings;
    }
    public void changeSQLRating(double rating) {
        this.rating -= this.rating / this.numRatings;
        this.rating += rating / this.numRatings;
        this.rating= Double.parseDouble(new DecimalFormat("##.#").format(this.rating));

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "UPDATE Item SET Rating = ? WHERE ItemCode = ?";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, itemCode);
            ps.setDouble(2, this.rating);
            ps.executeUpdate();
            
        } catch(SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement in: " + "Item.changeRating()");
            System.out.println("ERROR: Could not execute SQL statement: " + se);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public void updateSQLRating(double rating) {
        this.numRatings += 1;
        this.rating -= this.rating / this.numRatings;
        this.rating += rating / this.numRatings;
        this.rating= Double.parseDouble(new DecimalFormat("##.#").format(this.rating));

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "UPDATE Item SET Rating = ?, NumRatings = ? WHERE ItemCode = ?";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setDouble(1, this.rating);
            ps.setInt(2, this.numRatings);
            ps.setString(3, itemCode);
            ps.executeUpdate();
            
        } catch(SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement in: " + "Item.updateRating()");
            System.out.println("ERROR: Could not execute SQL statement: " + se);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
}
