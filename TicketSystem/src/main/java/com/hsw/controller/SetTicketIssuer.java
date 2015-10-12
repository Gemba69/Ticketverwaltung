package com.hsw.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsw.controller.EntityManager.EntityManagerFactoryUtil;
import com.hsw.model.Ticket;
import com.hsw.model.TicketId;
import com.hsw.model.User;

/**
 * Servlet implementation class SetTicketIssuer
 */
@WebServlet("/SetTicketIssuer")
public class SetTicketIssuer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetTicketIssuer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String projectCode = request.getParameter("projectCode");
		int ticketId = Integer.parseInt(request.getParameter("ticketID"));
		String newTicketIssuerString = request.getParameter("ticketIssuer");
		
		
		EntityManager em = EntityManagerFactoryUtil.createEntityManager();

		User newTicketIssuer = em.find(User.class, newTicketIssuerString);
		TicketId ticketID = new TicketId(projectCode, ticketId);
		Ticket ticket = em.find(Ticket.class, ticketID);
		ticket.setUserByTicketIssuer(newTicketIssuer);
		em.flush();
		
		response.sendRedirect("home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
