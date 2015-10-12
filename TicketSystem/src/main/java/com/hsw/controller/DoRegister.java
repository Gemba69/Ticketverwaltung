package com.hsw.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.realm.RealmBase;

import com.hsw.controller.EntityManager.EntityManagerFactoryUtil;
import com.hsw.controller.EntityManager.EntityManagerUtil;
import com.hsw.model.Role;
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
		
		EntityManager em = EntityManagerFactoryUtil.createEntityManager();

		User newUser = new User();
		newUser.setVorname(firstname);
		newUser.setNachname(surname);
		newUser.setUsername(username);
		newUser.setPasswort(RealmBase.Digest(password, "md5", "utf-8"));
		newUser.setEmail(email);
		
		Role role = em.find(Role.class, "member");
		Set<Role> roles = new HashSet<Role>(0);
		roles.add(role);
		newUser.setRoles(roles);
                
		if(!(containsUsername(newUser)||containsEmail(newUser))){
			EntityManagerUtil.persistInstance(newUser);
			response.sendRedirect("home?view=self");
		} else {
			request.setAttribute("failwarning", true);
			request.setAttribute("username", newUser.getUsername());
			RequestDispatcher view = request.getRequestDispatcher("register.jsp");
			view.forward(request, response);
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
        
        private boolean containsEmail(User user){
            if(EntityManagerFactoryUtil.createEntityManager().createQuery("SELECT u FROM User u WHERE u.email = :mail",User.class).setParameter("mail", user.getEmail()).getResultList().isEmpty()){
                return false;
            }
            return true;
        }
        
        private boolean containsUsername(User user){
            if(EntityManagerFactoryUtil.createEntityManager().createQuery("SELECT u FROM User u WHERE u.username = :uname",User.class).setParameter("uname", user.getUsername()).getResultList().isEmpty()){
                return false;
            }
            return true;
        }
}
