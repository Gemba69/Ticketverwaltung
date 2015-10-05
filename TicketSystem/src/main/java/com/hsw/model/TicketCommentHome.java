package com.hsw.model;
// Generated 01.10.2015 14:24:38 by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TicketComment.
 * @see com.hsw.model.TicketComment
 * @author Hibernate Tools
 */
@Stateless
public class TicketCommentHome {

	private static final Log log = LogFactory.getLog(TicketCommentHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TicketComment transientInstance) {
		log.debug("persisting TicketComment instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TicketComment persistentInstance) {
		log.debug("removing TicketComment instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TicketComment merge(TicketComment detachedInstance) {
		log.debug("merging TicketComment instance");
		try {
			TicketComment result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TicketComment findById(TicketCommentId id) {
		log.debug("getting TicketComment instance with id: " + id);
		try {
			TicketComment instance = entityManager.find(TicketComment.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
