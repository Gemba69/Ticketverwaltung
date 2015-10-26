package com.hsw.filters;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.hsw.controller.EntityManager.EntityManagerFactoryUtil;
import com.hsw.model.User;

/**
 * Servlet Filter implementation class UserFilter
 */
@WebFilter(filterName = "UserFilter", urlPatterns = {"/home"})
public class UserFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UserFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		if (httpRequest.getSession(false).getAttribute("user") == null) {
			EntityManager em = EntityManagerFactoryUtil.createEntityManager();
			User user = em.find(User.class, httpRequest.getRemoteUser());
			httpRequest.getSession().setAttribute("user", user);
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
