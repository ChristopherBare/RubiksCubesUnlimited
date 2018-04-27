/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import GoodForYourHeart.Item;
import GoodForYourHeart.ItemDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author christopher1
 */
@WebServlet("/store")
public class CatalogController extends HttpServlet {
    
    
    
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
            throws ServletException, IOException {
        ItemDB itemDB = new ItemDB();
        List<Item> cubes = ItemDB.getCubes();
        String itemCode = request.getParameter("itemCode");
        Item item = null;
        String url = "/item.jsp";
        String store = "/store.jsp";
        
        for(Item i : cubes) {
            if (validateParameter(itemCode)) {
                if (itemCode.equals(i.getItemCode())) {
                    request.setAttribute("item", i);
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                    break;
                }
            }
        }
        
        
        
        if (itemCode == null || itemCode == "") {
//            url = "/store.jsp";
//            request.setAttribute("cubes", cubes);
//            for (Item i : cubes) {
//                request.setAttribute(item.getItemCode(), i);
            //}
            
            request.setAttribute("cubes", cubes);
            getServletContext().getRequestDispatcher(store).forward(request, response);
        }
        
        
    }
    
    
    public boolean validateParameter(String itemCode)
    {
        boolean goodBoi = true;
        if (itemCode == null || itemCode == "") {
            goodBoi = false;
        }
        return goodBoi;
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
