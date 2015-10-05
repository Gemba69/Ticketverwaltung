package com.hsw.controller.dbSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DBSessionFactory {
	
	private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	/**
	 * @return the sessionfactory
	 */
	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
}
