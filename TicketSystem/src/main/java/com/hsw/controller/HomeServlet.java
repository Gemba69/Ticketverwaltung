/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hsw.controller;

import com.hsw.model.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
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
@WebServlet(name = "HomeServlet", urlPatterns = { "/home" })
public class HomeServlet extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Herr Mertens, wundern sie sich nicht: Diese Methode ist in eine
		// Monstrosität mutiert. Sie hat klein, elegant und schön
		// angefangen, doch nun ist sie das Grauen der Menschheit. Die Magic hat
		// sie in invertiertes Alpecin verwandelt. Doping nicht für Haare. Nur
		// nicht für die Haare.

		TitleString title = null;
		ServletContext sc = request.getServletContext();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Project> projects = (List<Project>) sc.getAttribute("projectList");

		String viewParam = request.getParameter("view");
		if (viewParam == null)
			viewParam = "self";

		request.getSession().setAttribute("lastViewParam", viewParam);

		switch (viewParam) {
		case "self":
			title = TitleString.SELF;
			break;
		case "all":
			title = TitleString.ALL;
			break;
		case "open":
			title = TitleString.OPEN;
			break;
		case "close":
			title = TitleString.CLOSED;
			break;
		case "in work":
			title = TitleString.INWORK;
			break;
		case "selfopen":
			title = TitleString.SELFOPEN;
			break;
		case "selfclose":
			title = TitleString.SELFCLOSED;
			break;
		case "selfinwork":
			title = TitleString.SELFINWORK;
			break;
		case "projects":
			title = TitleString.PROJECTS;
			break;
		default:
			title = TitleString.SELF;
		}

		String titleAppendix = "";
		String projectCode = request.getParameter("project");
		if (projectCode != null)
			titleAppendix = " von Projekt " + projectCode;
		request.setAttribute("title", title.getTitle() + titleAppendix);

		if (title != TitleString.PROJECTS) {
			List<Project> returnProjects = new ArrayList<>();
			for (Project p : projects) {
				List<Ticket> returnTickets = new ArrayList<>();
				if (projectCode == null || p.getProjectCode().equals(projectCode)) {
					for (Ticket t : p.getTickets()) {
						if (t.getUserByTicketIssuer() != null && t.getUserByTicketIssuer().equals(user)
								&& title == TitleString.SELF
								|| t.getUserByTicketIssuer() != null && t.getStatusTyp().getStatus().equals("open")
										&& t.getUserByTicketIssuer().equals(user) && title == TitleString.SELFOPEN
								|| t.getUserByTicketIssuer() != null && t.getStatusTyp().getStatus().equals("done")
										&& t.getUserByTicketIssuer().equals(user) && title == TitleString.SELFCLOSED
								|| t.getUserByTicketIssuer() != null && t.getStatusTyp().getStatus().equals("in work")
										&& t.getUserByTicketIssuer().equals(user) && title == TitleString.SELFINWORK
								|| title == TitleString.ALL
								|| t.getStatusTyp().getStatus().equals("open") && title == TitleString.OPEN
								|| t.getStatusTyp().getStatus().equals("done") && title == TitleString.CLOSED
								|| t.getStatusTyp().getStatus().equals("in work") && title == TitleString.INWORK) {
							returnTickets.add(t);
						}
					}
				}
				if (!returnTickets.isEmpty()) {
					Project pr = new Project(p.getProjectCode(), p.getUser(), p.getProjectName(),
							p.getProjectCounter());
					pr.setProjectDesc(p.getProjectDesc());
					for (Ticket ti : returnTickets) {
						pr.getTickets().add(ti);
					}
					returnProjects.add(pr);
				}
			}
			request.setAttribute("projectList", returnProjects);
			request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
		} else {
			request.setAttribute("projectList", projects);
			request.getRequestDispatcher("WEB-INF/projects.jsp").forward(request, response);
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on
	// the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
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
