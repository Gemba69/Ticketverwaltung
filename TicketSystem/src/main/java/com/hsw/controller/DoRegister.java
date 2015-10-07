package com.hsw.controller;

import com.hsw.controller.dbSession.EntityManagerUtil;
import com.hsw.model.Role;
import com.hsw.model.User;
import com.hsw.model.UserRole;
import com.hsw.model.UserRoleId;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.realm.RealmBase;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String password = RealmBase.Digest("asdf", "md5", "utf-8");
            User user = new User("jonas", password, "jonas.poeppelmann@gmail.com", "Jonas", "Pöppelmann");
            Role role = new Role("admin", "administrator");
            UserRole ur = new UserRole(new UserRoleId("jonas", "admin"));
            EntityManagerUtil.persistInstance(user);
            EntityManagerUtil.persistInstance(role);
            EntityManagerUtil.persistInstance(ur);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
