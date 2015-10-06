package com.hsw.controller;

import com.hsw.controller.EntityManager.EntityManagerFactoryUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsw.controller.EntityManager.EntityManagerUtil;
import com.hsw.model.Project;
import com.hsw.model.Ticket;

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
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int projectId = (int) request.getAttribute("projectId");
        String projectName = (String) request.getAttribute("projectName");
        String projectCode = (String) request.getAttribute("projectCode");
        String projectDesc = (String) request.getAttribute("projectDesc");
        String projectOwner = (String) request.getAttribute("projectOwner");
        Project newProject = new Project();

        newProject.setProjectCode(projectCode);
        newProject.setProjectDesc(projectDesc);
        newProject.setProjectId(projectId);
        newProject.setProjectName(projectName);
        newProject.setProjectOwner(projectOwner);

        EntityManagerUtil.persistInstance(newProject);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
