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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ticketName = request.getParameter("ticketName");
		String projectCode = request.getParameter("projectCode");
		String description = request.getParameter("description");
		String statusString = "offen"; //TODO: hard coding entfernen
		String priorityString = request.getParameter("priority");
		User ticketAuthor = (User) request.getSession().getAttribute("user");
		
		EntityManager em = EntityManagerFactoryUtil.createEntityManager();
		
		
		StatusTyp ticketStatus = em.find(StatusTyp.class, statusString);
		Project project = em.find(Project.class, projectCode);
	
		int counter = project.getProjectCounter() + 1;
		int priority = Integer.parseInt(priorityString);
		TicketId id = new TicketId(project.getProjectCode(), counter);
		
		
		Ticket newTicket = new Ticket(id, project, ticketStatus, ticketAuthor, ticketName, priority);
		newTicket.setTicketDesc(description);

		EntityManagerUtil.persistInstance(newTicket);

		System.out.println(newTicket.getTicketName());
		em.getTransaction().begin();
		project.setProjectCounter(counter);
		project.getTickets().add(newTicket);
		em.getTransaction().commit();
		EntityManagerFactoryUtil.refreshProjectList(request.getServletContext());		
		
		response.sendRedirect("home?view=" + request.getSession().getAttribute("lastViewParam"));
	}

}
