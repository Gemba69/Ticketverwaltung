package com.hsw.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsw.controller.EntityManager.EntityManagerUtil;
import com.hsw.model.User;

/**
 * Servlet implementation class DoRegister
 */
@WebServlet("/DoRegister")
public class DoRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String firstname = request.getParameter("firstname");
		String surname = request.getParameter("surname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		User newUser = new User();
		newUser.setVorname(firstname);
		newUser.setNachname(surname);
		newUser.setUsername(username);
		newUser.setPasswort(password);
		newUser.setEmail(email);
		

		try {
			EntityManagerUtil.persistInstance(newUser);
			response.sendRedirect("login.jsp");
		} catch (Exception e) {
			String result = "User exisitert bereits oder fehlerhafte Eingabe";
			request.setAttribute("failwarning", result);
			RequestDispatcher view = request.getRequestDispatcher("register.jsp");
			view.forward(request, response);
			
			//response.sendRedirect("register.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
