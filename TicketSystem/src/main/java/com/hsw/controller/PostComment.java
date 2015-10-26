package com.hsw.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsw.controller.EntityManager.EntityManagerFactoryUtil;
import com.hsw.controller.EntityManager.EntityManagerUtil;
import com.hsw.model.Comment;
import com.hsw.model.Project;
import com.hsw.model.Ticket;
import com.hsw.model.TicketId;
import com.hsw.model.User;

/**
 * Servlet implementation class PostComment
 */
@WebServlet("/PostComment")
public class PostComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostComment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int ticketId = Integer.parseInt(request.getParameter("ticketId"));
		String projectCode = request.getParameter("projectCode");
		TicketId id = new TicketId(projectCode, ticketId);
		String comment = request.getParameter("comment");

		List<Project> projects = (List<Project>) request.getServletContext().getAttribute("projectList");
		User user = (User) request.getSession().getAttribute("user");
		Ticket ticket = null;// = EntityManagerFactoryUtil.createEntityManager().find(Ticket.class, id);
		for (Project p : projects) {
			if (p.getProjectCode().equals(projectCode)) {
				for (Ticket t : p.getTickets()) {
					if (t.getId().getTicketId() == ticketId) {
						ticket = t;
					}
				}
			}
		}

		Comment newComment = new Comment(ticket, user, comment);
		ticket.getComments().add(newComment);
		EntityManagerUtil.persistInstance(newComment);
		response.sendRedirect("home?view=" + request.getSession().getAttribute("lastViewParam"));
	}

}
