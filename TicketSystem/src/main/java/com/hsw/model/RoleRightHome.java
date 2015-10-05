package com.hsw.model;
// Generated 01.10.2015 14:24:38 by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class RoleRight.
 * @see com.hsw.model.RoleRight
 * @author Hibernate Tools
 */
@Stateless
public class RoleRightHome {

	private static final Log log = LogFactory.getLog(RoleRightHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(RoleRight transientInstance) {
		log.debug("persisting RoleRight instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(RoleRight persistentInstance) {
		log.debug("removing RoleRight instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public RoleRight merge(RoleRight detachedInstance) {
		log.debug("merging RoleRight instance");
		try {
			RoleRight result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RoleRight findById(RoleRightId id) {
		log.debug("getting RoleRight instance with id: " + id);
		try {
			RoleRight instance = entityManager.find(RoleRight.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
