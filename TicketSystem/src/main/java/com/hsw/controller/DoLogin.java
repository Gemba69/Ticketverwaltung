package com.hsw.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hsw.controller.dbSession.DBSessionFactory;
import com.hsw.controller.dbSession.EntityManagerUtil;
import com.hsw.model.User;
import com.hsw.model.UserHome;

/**
 * Servlet implementation class DoLogin
 */
@WebServlet("/DoLogin")
public class DoLogin extends HttpServlet {
	
	//@PersistenceContext
	//private EntityManagerFactory emf = EntityManagerUtil.getEntityManagerFactory();
//	@PersistenceUnit(unitName="ticketsystem")
//	private EntityManagerFactory emf;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */	
	
    public DoLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    //Session session = SessionFactoryUtil.getInstance().getCurrentSession();
		
		SessionFactory sessionFactory = DBSessionFactory.getSessionfactory();
		sessionFactory.openSession();

		HttpSession httpSession = request.getSession();

		//EntityManager em = this.emf.createEntityManager();
		
		
		UserHome userHome = new UserHome();
//		
//		EntityManager entityManager = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
		
		
		User user = new User("bluhn", "admin123", "bluhn@web.de", "Benjamin", "Luhn", 1);
		User user2 = new User("test", "test", "test", "test","test", 1);
		
//		em.getTransaction( ).begin();
//		em.persist(user);
//		em.getTransaction().commit();
//		em.close();
		
		//em.persist(user);
		
		userHome.persist(user);
		
		//entityManager.persist(user);
		//userHome.persist(user);
		
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
