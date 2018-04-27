/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoodForYourHeart;

/**
 *
 * @author christopher1
 */
public class ItemRating {
    private Item item;
    private int rating;
    private boolean madeIT;

    public ItemRating() {
    }

    public ItemRating(Item item, int rating, boolean madeIT) {
        this.item = item;
        this.rating = rating;
        this.madeIT = madeIT;
    }
    

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean getMadeIT() {
        return madeIT;
    }

    public void setMadeIT(boolean madeIT) {
        this.madeIT = madeIT;
    }

    
    
    
}
