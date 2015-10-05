package com.hsw.controller.dbSession;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	
	public static boolean persistInstance(Object entity) {
		
		EntityManager em = EntityManagerFactoryUtil.createEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		
		return true;
		
	}
}


