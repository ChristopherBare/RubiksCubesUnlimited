/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import GoodForYourHeart.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author christopher
 */
@WebServlet(name = "ProfileController", urlPatterns = {"/ProfileController"})
public class ProfileController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ItemDB itemDB = new ItemDB();
        UserDB userDB = new UserDB();
        ItemRating itemRating = new ItemRating();
        ArrayList<Item> items = itemDB.getCubes();
        ArrayList<User> users = userDB.getUsers();
        List<ItemRating> userFavorites = new ArrayList<>();
        List<ItemRating> userCart = new ArrayList<>();
        HttpSession session = request.getSession();
        boolean redirect = true;

        session.setMaxInactiveInterval(0);

        String action = request.getParameter("action");
        String itemCode = request.getParameter("itemCode");
        String url = "/wishlist.jsp";

        //User and user profile in the session
        User user = (User) session.getAttribute("theUser");
        if (user == null) {
            user = users.get(0);
        }
        UserProfile userProfile = (UserProfile) session.getAttribute("currentProfile");

        //Sign in and sign out functions
        if (action != null && action.equals("signout")) {
            session.removeAttribute("currentProfile");
            session.removeAttribute("theUser");
            user = null;
            url = "/index.jsp";
        }
        if (action != null && (action.equals("signin"))) {
            userProfile = new UserProfile(user);
            session.setAttribute("theUser", user);
            session.setAttribute("currentProfile", userProfile);
            if (action.equals("signin")) {
                url = "/wishlist.jsp";
            }
        }
        if (userProfile != null) {
            userFavorites = userProfile.getItemRatings();
            userCart = userProfile.getCart();
        }
        if (userProfile != null) {
            if (action != null && !action.equals("")) {

                if (action.equals("save")) {
                    url = "/wishlist.jsp";
                    for (Item i : items) {
                        if (i.getItemCode().equals(itemCode)) {
                            userProfile.addItem(new ItemRating(i, 0, false));
                        }
                    }
                }

                if (action.equals("cart")) {
                    url = "/cart.jsp";
                    for (Item i : items) {
                        if (i.getItemCode().equals(itemCode)) {
                            userProfile.addItemToCart(new ItemRating(i, 0, false));
                        }
                    }
                }

                if (action.equals("moveToCart")) {
                    url = "/cart.jsp";

                    for (ItemRating i : userFavorites) {
                        if (i.getItem().getItemCode().equals(itemCode)) {
                            itemRating = i;
                        }
                    }

                    userProfile.removeItem(itemRating);
                    userProfile.addItemToCart(itemRating);
                }

                if (action.equals("moveToWishlist")) {

                    url = "/wishlist.jsp";
                    for (ItemRating i : userCart) {
                        if (i.getItem().getItemCode().equals(itemCode)) {
                            itemRating = i;
                        }
                    }

                    userProfile.removeItemFromCart(itemRating);
                    userProfile.addItem(itemRating);
                }
                if (action.equals("delete")) {
                    url = "/wishlist.jsp";
                    for (ItemRating i : userFavorites) {
                        if (i.getItem().getItemCode().equals(itemCode)) {
                            itemRating = i;
                        }
                    }
                    userProfile.removeItem(itemRating);
                }

                if (action.equals("deleteFromCart")) {
                    url = "/cart.jsp";
                    for (ItemRating i : userCart) {
                        if (i.getItem().getItemCode().equals(itemCode)) {
                            itemRating = i;
                        }
                    }
                    userProfile.deleteItemFromCart(itemRating);
                }
                
                if (action.equals("removeFromCart")) {
                    url = "/cart.jsp";
                    for (ItemRating i : userCart) {
                        if (i.getItem().getItemCode().equals(itemCode)) {
                            itemRating = i;
                        }
                    }
                    userProfile.removeItemFromCart(itemRating);
                }

                if (action.equals("roRate")) {
                    url = "/feedback.jsp";
                    for (Item i : items) {
                        if (i.getItemCode().equals(itemCode)) {
                            request.setAttribute("item", i);
                            if (userProfile.containsItem(i)) {
                                request.setAttribute("userRating", userProfile.getItemRating(i));
                                request.setAttribute("listened", userProfile.getMadeIT(i));
                            }
                        }

                    }

                    if (action.equals("rate")) {
                        url = "/item.jsp";
                        for (Item i : items) {
                            //=== RATING HANDLER ===//

                            if (itemCode.equals(i.getItemCode()) && request.getParameter("userRating") != null) {

                                //Create variables to get the user's rating
                                int rating = 0;
                                String userRating = request.getParameter("userRating");
                                String message = null;

                                //Use the userRating to assign a numeric value to rating
                                for (int x = 1; x < 6; x++) {
                                    if (userRating.equals(Integer.toString(x))) {
                                        rating = x;
                                    }
                                }

                                //If the profile exists...
                                if (userProfile != null) {
                                    boolean notInFavorites = true;

                                    for (ItemRating iR : userFavorites) //If the user has the item in their list
                                    {
                                        if (iR.getItem().getItemCode().equals(i.getItemCode())) {

                                            //Update personal rating
                                            iR.setRating(rating);

                                            //Change item overall rating if the user has already rated
                                            if (iR.getRating() != 0) {
                                                i.changeSQLRating(rating);
                                            } //Otherwise create a new rating for the item
                                            else {
                                                i.updateSQLRating(rating);
                                            }

                                            //Since the item was already in their favorites list, 
                                            //set this flag to false so the item doesnt get added again
                                            notInFavorites = false;
                                        }
                                    }
                                    //User does not have this item in favorites
                                    if (notInFavorites) {
                                        userProfile.addItem(new ItemRating(i, rating, true));
                                        i.updateSQLRating(rating);
                                    }
                                } else {
                                    message = "Sorry, you must be signed in to rate items!";
                                }

                                break;
                            }
                        }
                    }
                }

                if (action.equals("confirmUpdate")) {
                    url = "/wishlist.jsp";

                    Item item = null;
                    for (Item i : items) {
                        if (i.getItemCode().equals(itemCode)) {
                            item = i;
                        }
                    }

                    String userRatingString = request.getParameter("userRating");
                    int userRating = 0;
                    for (int x = 1; x < 6; x++) {
                        if (userRatingString.equals(Integer.toString(x))) {
                            userRating = x;
                        }
                    }

                    String listenedString = request.getParameter("listened");
                    boolean listened = listenedString.equals("true");

                    boolean updated = false;
                    for (ItemRating i : userFavorites) {
                        if (i.getItem().getItemCode().equals(itemCode)) {
                            i.setRating(userRating);
                            i.setMadeIT(listened);
                            updated = true;
                        }
                    }

                    if (!updated) {
                        userProfile.addItem(new ItemRating(item, userRating, listened));
                    }

                }
            }
        }

        session.setAttribute("theUser", user);

        if (redirect) {
            response.sendRedirect(request.getContextPath() + url);
        } else {
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
