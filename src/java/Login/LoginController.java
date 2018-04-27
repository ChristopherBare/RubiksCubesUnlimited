/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import GoodForYourHeart.User;
import GoodForYourHeart.UserDB;
import GoodForYourHeart.UserProfile;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.errors.ValidationException;

/**
 *
 * @author christopher
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException, UnsupportedEncodingException, SQLException {
        HttpSession session = request.getSession();
        String url = "store";
        String message = "empty quotes";
        String action = request.getParameter("action");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (action != null && action.equals("signin")) {
            try {
                email = ESAPI.validator().getValidInput("email", email, "Email", 50, false);
                password = ESAPI.validator().getValidInput("password", password, "SafeString", 50, false);
            } catch (ValidationException ve) {
                System.out.println(ve);
            } catch (Exception e) {
                System.out.println(e);
            }

            if (UserDB.validateUser(email, password)) {
                User user = UserDB.getUserByEmail(email);
                session.setAttribute("theUser", user);
                UserProfile profile = new UserProfile(user);
                session.setAttribute("currentProfile", profile);

            }
        } else if (action != null && action.equals("signout")) {
            session.removeAttribute("theUser");
            session.removeAttribute("currentProfile");
            url = "/index.jsp";
        } else if (action != null && action.equals("signup")) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String confirm = request.getParameter("confirm");

            if (password != confirm) {
                System.out.println("Passwords didn't match.");
            } else if (password == confirm) {
                User user = new User();
                //Generate random UserID and check it against other users in DB
                int random = (int) (Math.random() * 1000000000);
                while (UserDB.getUserByID(Integer.toString(random)) != null) {
                    random = (int) (Math.random() * 1000000000);
                }
                user.setUserID(random);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setEmail(email);
                user.setPassword(password);
                UserDB.addUser(user);
                session.setAttribute("theUser", user);
                UserProfile profile = new UserProfile(user);
                session.setAttribute("currentProfile", profile);
            }

        }
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
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
            throws ServletException, IOException, UnsupportedEncodingException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            throws ServletException, IOException, UnsupportedEncodingException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
