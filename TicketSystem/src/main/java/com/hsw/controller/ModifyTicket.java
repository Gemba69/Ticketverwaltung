package com.hsw.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsw.controller.EntityManager.EntityManagerFactoryUtil;
import com.hsw.controller.EntityManager.EntityManagerUtil;
import com.hsw.model.Project;
import com.hsw.model.StatusTyp;
import com.hsw.model.Ticket;
import com.hsw.model.TicketId;
import com.hsw.model.User;

/**
 * Servlet implementation class ModifyTicket
 */
@WebServlet("/ModifyTicket")
public class ModifyTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifyTicket() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = EntityManagerFactoryUtil.createEntityManager();

		int ticketId = Integer.parseInt(request.getParameter("ticketId"));
		String projectCode = request.getParameter("projectCode");
		
		String status = request.getParameter("ticketStatus");
		String priority = request.getParameter("priority");
		String issuer = request.getParameter("issuer");
		
		StatusTyp ticketStatus = em.find(StatusTyp.class, status);
		int ticketPriority = Integer.parseInt(priority);
		User ticketIssuer = null;
		for (User u : (List<User>)request.getServletContext().getAttribute("users")) {
			if (u.getUsername().equals(issuer))
				ticketIssuer = u;
		}
		em.getTransaction().begin();
		Ticket ticket = em.find(Ticket.class, new TicketId(projectCode, ticketId));
		ticket.setStatusTyp(ticketStatus);
		ticket.setUserByTicketIssuer(ticketIssuer);
		ticket.setTicketPriorität(ticketPriority);
		em.getTransaction().commit();

		EntityManagerFactoryUtil.refreshProjectList(request.getServletContext());		
		response.sendRedirect("home?view=" + request.getSession().getAttribute("lastViewParam"));
	}

}
