package com.hsw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsw.controller.EntityManager.EntityManagerUtil;
import com.hsw.model.Project;
import com.hsw.model.User;

/**
 * Servlet implementation class CreateTicket
 */
@WebServlet("/CreateProject")
public class CreateProject extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProject() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String projectName = request.getParameter("projectName");
        String projectCode = request.getParameter("projectCode");
        String projectDesc = request.getParameter("projectDesc");
        User projectOwner = (User)request.getSession().getAttribute("user");
        Project newProject = new Project();

        newProject.setProjectCode(projectCode);
        newProject.setProjectDesc(projectDesc);
        newProject.setProjectName(projectName);
        newProject.setUser(projectOwner);
        newProject.setProjectCounter(0);
        
        ((List<Project>)request.getServletContext().getAttribute("projectList")).add(newProject);

        EntityManagerUtil.persistInstance(newProject);
        
		response.sendRedirect("home?view=" + request.getSession().getAttribute("lastViewParam"));
    }

}
