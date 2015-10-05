package com.hsw.model;
// Generated 01.10.2015 14:24:38 by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Right.
 * @see com.hsw.model.Right
 * @author Hibernate Tools
 */
@Stateless
public class RightHome {

	private static final Log log = LogFactory.getLog(RightHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Right transientInstance) {
		log.debug("persisting Right instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Right persistentInstance) {
		log.debug("removing Right instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Right merge(Right detachedInstance) {
		log.debug("merging Right instance");
		try {
			Right result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Right findById(Integer id) {
		log.debug("getting Right instance with id: " + id);
		try {
			Right instance = entityManager.find(Right.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
