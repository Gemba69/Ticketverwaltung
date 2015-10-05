package com.hsw.model;
// Generated 01.10.2015 14:24:38 by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Ticket.
 * @see com.hsw.model.Ticket
 * @author Hibernate Tools
 */
@Stateless
public class TicketHome {

	private static final Log log = LogFactory.getLog(TicketHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Ticket transientInstance) {
		log.debug("persisting Ticket instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Ticket persistentInstance) {
		log.debug("removing Ticket instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Ticket merge(Ticket detachedInstance) {
		log.debug("merging Ticket instance");
		try {
			Ticket result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Ticket findById(Integer id) {
		log.debug("getting Ticket instance with id: " + id);
		try {
			Ticket instance = entityManager.find(Ticket.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
