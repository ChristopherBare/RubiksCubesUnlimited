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
public class User {

    private int userID;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean admin;

    
    public User() {
    }
    
    public User(User user) {
        this.setFirstName(user.getFirstName());
        this.setLastName(lastName);
        this.setAdmin(admin);
        
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsAdmin() {
        return UserDB.checkAdmin(this.userID);
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    

}
