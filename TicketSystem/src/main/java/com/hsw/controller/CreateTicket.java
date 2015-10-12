package com.hsw.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
 * Servlet implementation class CreateTicket
 */
@WebServlet("/CreateTicket")
public class CreateTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTicket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String ticketName = request.getParameter("ticketName");
		String project_code = request.getParameter("projectCode");
		String beschreibung = request.getParameter("description");
		String statusString = request.getParameter("statusType");
		String priorityString = request.getParameter("priority");
		//TODO
		User ticket_issuer = (User) request.getSession().getAttribute("user");
		
		EntityManager em = EntityManagerFactoryUtil.createEntityManager();
		
		
		StatusTyp ticketStatus = em.find(StatusTyp.class, statusString);
		Project project = em.find(Project.class, project_code);
		int counter = project.getProjectCounter() + 1;
		int priority = Integer.parseInt(priorityString);
		TicketId id = new TicketId(project.getProjectCode(), counter);
		
		
		Ticket newTicket = new Ticket(id, project, ticketStatus, ticket_issuer, ticketName, priority);
		
		EntityManagerUtil.persistInstance(newTicket);
		project.setProjectCounter(counter);
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
