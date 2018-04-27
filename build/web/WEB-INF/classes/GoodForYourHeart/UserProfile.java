/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoodForYourHeart;

import java.util.*;

/**
 *
 * @author christopher1
 */
public class UserProfile {

    private User userID;
    private ArrayList<ItemRating> itemRatings = new ArrayList<>();
    private ArrayList<ItemRating> cart = new ArrayList<>();
    private ArrayList<ItemRating> ratedItems = new ArrayList<>();
    private HashMap<String, Integer> cartHash = new HashMap<>();
    private double cartSub;
    private double cartTotes;
    private int cartItemTotal;
    private double tax = 9.43;

    public UserProfile() {
        userID = new User();
        itemRatings = new ArrayList<>();
        ratedItems = new ArrayList<>();
        cart = new ArrayList<>();
    }

    public UserProfile(User userID) {
        this.userID = userID;
        this.itemRatings = new ArrayList<>();
        this.ratedItems = new ArrayList<>();
        this.cart = new ArrayList<>();
    }

    public void addItem(ItemRating item) {
        boolean alreadyExists = false;
        for (ItemRating i : itemRatings) {
            if (i.getItem().getItemCode().equals(item.getItem().getItemCode())) {
                alreadyExists = true;
            }
        }
        if (!alreadyExists) {
            itemRatings.add(item);
        }
    }
    
    public void addRating(ItemRating item) {
        boolean alreadyExists = false;
        for (ItemRating i : ratedItems) {
            if (i.getItem().getItemCode().equals(item.getItem().getItemCode())) {
                alreadyExists = true;
            }
        }
        if (!alreadyExists) {
            ratedItems.add(item);
        }
    }

    public void removeItem(ItemRating item) {
        if (itemRatings.contains(item)) {
            itemRatings.remove(item);
        }
    }

    public void addItemToCart(ItemRating item) {
        boolean alreadyExists = false;
        int quantity = 1;
        for (ItemRating i : cart) {
            if (i.getItem().getItemCode().equals(item.getItem().getItemCode())) {
                quantity += cartHash.get(i.getItem().getItemCode());
                cartHash.replace(i.getItem().getItemCode(), quantity);
                alreadyExists = true;
            }
        }
        if (!alreadyExists) {
            cart.add(item);
            cartHash.put(item.getItem().getItemCode(), quantity);
        }

        cartItemTotal += 1;
        cartSub += Double.parseDouble(item.getItem().getPrice());
    }

    public void removeItemFromCart(ItemRating item) {
        int quantity = 0;
        boolean removed = false;

        for (ItemRating i : cart) {
            quantity = cartHash.get(i.getItem().getItemCode());
            if (i.getItem().getItemCode().equals(item.getItem().getItemCode()) && quantity > 1) {
                cartHash.replace(i.getItem().getItemCode(), (quantity - 1));
                removed = true;
            }
        }

        if (removed) {
            cartItemTotal -= 1;
            cartSub -= Double.parseDouble(item.getItem().getPrice());
        }
    }

    public void deleteItemFromCart(ItemRating item) {
        int quantity = 0;
        ItemRating toRemove = null;

        for (ItemRating i : cart) {
            if (i.getItem().getItemCode().equals(item.getItem().getItemCode())) {
                quantity = cartHash.get(i.getItem().getItemCode());
                cartHash.remove(i.getItem().getItemCode());
                toRemove = i;
            }
        }

        cart.remove(toRemove);
        cartItemTotal -= quantity;
        cartSub -= Double.parseDouble(item.getItem().getPrice()) * quantity;
    }

    public HashMap<String, Integer> getCartHash() {
        return cartHash;
    }

    public double getCartSub() {
        return cartSub;
    }

    public double getCartTotes() {
        return cartTotes;
    }

    public int getCartItemTotal() {
        return cartItemTotal;
    }

    public double getTax() {
        return tax;
    }
    
    public ArrayList<ItemRating> getItemRatings() {
        return itemRatings;
    }

    public ArrayList<ItemRating> getCart() {
        return cart;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public void emptyProfile() {
        for (ItemRating i : itemRatings) {
            if (itemRatings.contains(i)) {
                itemRatings = null;
            }
        }
    }

    public double getItemRating(Item item) {
        double rating = -1;
        for (ItemRating i : itemRatings) {
            if (i.getItem().getItemCode().equals(item.getItemCode())) {
                rating = i.getRating();
            }
        }
        return rating;
    }

    public boolean getMadeIT(Item item) {
        boolean purchased = false;
        for (ItemRating i : itemRatings) {
            if (i.getItem().getItemCode().equals(item.getItemCode())) {
                purchased = i.getMadeIT();
            }
        }
        return purchased;
    }

    public boolean containsItem(Item item) {
        boolean contains = false;
        for (ItemRating i : itemRatings) {
            if (i.getItem().getItemCode().equals(item.getItemCode())) {
                contains = true;
            }
        }
        return contains;
    }

    public ArrayList<ItemRating> getRatedItems() {
        return ratedItems;
    }

    public void setRatedItems(ArrayList<ItemRating> ratedItems) {
        this.ratedItems = ratedItems;
    }
    
}
