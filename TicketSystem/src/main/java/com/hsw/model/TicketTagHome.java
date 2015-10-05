package com.hsw.model;
// Generated 01.10.2015 14:24:38 by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TicketTag.
 * @see com.hsw.model.TicketTag
 * @author Hibernate Tools
 */
@Stateless
public class TicketTagHome {

	private static final Log log = LogFactory.getLog(TicketTagHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TicketTag transientInstance) {
		log.debug("persisting TicketTag instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TicketTag persistentInstance) {
		log.debug("removing TicketTag instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TicketTag merge(TicketTag detachedInstance) {
		log.debug("merging TicketTag instance");
		try {
			TicketTag result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TicketTag findById(TicketTagId id) {
		log.debug("getting TicketTag instance with id: " + id);
		try {
			TicketTag instance = entityManager.find(TicketTag.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
