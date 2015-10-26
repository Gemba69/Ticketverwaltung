package com.hsw.controller.EntityManager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.hsw.Database.DatabaseTester;
import com.hsw.model.Project;
import com.hsw.model.StatusTyp;
import com.hsw.model.User;

@WebListener
public class EntityManagerFactoryUtil implements ServletContextListener {

    private static EntityManagerFactory emf;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        DatabaseTester databaseTester = new DatabaseTester();
        if(!databaseTester.databaseExsists("ticketverwaltung")){
            databaseTester.create("ticketverwaltung");
        }
        emf = Persistence.createEntityManagerFactory("ticketsystem");
        refreshProjectList(event.getServletContext());
        refreshStatusList(event.getServletContext());
        refreshUserList(event.getServletContext());
    }


    @Override
    public void contextDestroyed(ServletContextEvent event) {
        emf.close();
    }

    public static EntityManager createEntityManager() {
        if (emf == null) {
            throw new IllegalStateException("Context is not initialized yet.");
        }

        return emf.createEntityManager();
    }
    
    public static void refreshProjectList(ServletContext c) {
    	EntityManager em = createEntityManager();
    	List<Project> projects = em.createQuery("SELECT p FROM Project p", Project.class).getResultList();
    	c.setAttribute("projectList", projects);
    }
    
    public static void refreshUserList(ServletContext c) {
    	EntityManager em = createEntityManager();
    	List<User> users = em.createQuery("SELECT u FROM User u", User.class).getResultList();
    	c.setAttribute("users", users);
    }
    
    public static void refreshStatusList(ServletContext c) {
    	EntityManager em = createEntityManager();
    	List<StatusTyp> stati = em.createQuery("SELECT s FROM StatusTyp s", StatusTyp.class).getResultList();
    	c.setAttribute("statusTypes", stati);
    }

}