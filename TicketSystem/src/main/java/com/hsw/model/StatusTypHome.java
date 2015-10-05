package com.hsw.model;
// Generated 01.10.2015 14:24:38 by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class StatusTyp.
 * @see com.hsw.model.StatusTyp
 * @author Hibernate Tools
 */
@Stateless
public class StatusTypHome {

	private static final Log log = LogFactory.getLog(StatusTypHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(StatusTyp transientInstance) {
		log.debug("persisting StatusTyp instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(StatusTyp persistentInstance) {
		log.debug("removing StatusTyp instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public StatusTyp merge(StatusTyp detachedInstance) {
		log.debug("merging StatusTyp instance");
		try {
			StatusTyp result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public StatusTyp findById(Integer id) {
		log.debug("getting StatusTyp instance with id: " + id);
		try {
			StatusTyp instance = entityManager.find(StatusTyp.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
