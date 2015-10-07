/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hsw.controller;

import com.hsw.model.real.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jonas
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

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
        TitleString title = null;
        
        ServletContext sc = request.getServletContext();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Project> projects = (List<Project>) sc.getAttribute("projectList");
        
        switch (request.getParameter("view")) {
            case "self": title = TitleString.SELF; break;
            case "all": title = TitleString.ALL; break;
            case "open": title = TitleString.OPEN; break;
            case "close": title = TitleString.CLOSED; break;
            case "in work": title = TitleString.INWORK; break;
            case "selfopen": title = TitleString.SELFOPEN; break;
            case "selfclose": title = TitleString.SELFCLOSED; break;
            case "selfinwork": title = TitleString.SELFINWORK; break;
        }
        
        List<Project> returnProjects = new ArrayList<>();
        for (Project p : projects) {
            List<Ticket> returnTickets = new ArrayList<>();
            for (Ticket t : p.getTickets()) {
                if (t.getTicketIssuer() != null && t.getTicketIssuer().equals(user) && title == TitleString.SELF) {
                    returnTickets.add(t);
                }
                if (t.getTicketIssuer() != null && t.getTicketStatus().getStatus().equals("open") && t.getTicketIssuer().equals(user) && title == TitleString.SELFOPEN){
                	returnTickets.add(t);
                }
                if (t.getTicketIssuer() != null && t.getTicketStatus().getStatus().equals("done") && t.getTicketIssuer().equals(user) && title == TitleString.SELFCLOSED){
                	returnTickets.add(t);
                } 
                if (t.getTicketIssuer() != null && t.getTicketStatus().getStatus().equals("in work") && t.getTicketIssuer().equals(user) && title == TitleString.SELFINWORK){
                	returnTickets.add(t);
                } 
                if (title == TitleString.ALL) {
                    returnTickets.add(t);
                }
                if (t.getTicketStatus().getStatus().equals("open") && title == TitleString.OPEN){
                	returnTickets.add(t);
                }
                if (t.getTicketStatus().getStatus().equals("done") && title == TitleString.CLOSED){
                	returnTickets.add(t);
                } 
                if (t.getTicketStatus().getStatus().equals("in work") && title == TitleString.INWORK){
                	returnTickets.add(t);
                } 
            }
            if (!returnTickets.isEmpty()) {
                Project pr = new Project(p.getProjectId(), p.getProjectName(), p.getProjectDesc(), p.getProjectOwner());
                for (Ticket ti : returnTickets) {
                    pr.getTickets().add(ti);
                }
                returnProjects.add(pr);
            }
        }       
        request.setAttribute("projectList", returnProjects);
        request.setAttribute("title", title.getTitle());
        request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
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
