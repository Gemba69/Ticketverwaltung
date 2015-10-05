package com.hsw.testmodel;
// Generated 30.09.2015 14:41:58 by Hibernate Tools 4.0.0

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class TicketComment.
 * @see com.hsw.testmodel.TicketComment
 * @author Hibernate Tools
 */
public class TicketCommentHome {

	private static final Log log = LogFactory.getLog(TicketCommentHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(TicketComment transientInstance) {
		log.debug("persisting TicketComment instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TicketComment instance) {
		log.debug("attaching dirty TicketComment instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TicketComment instance) {
		log.debug("attaching clean TicketComment instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TicketComment persistentInstance) {
		log.debug("deleting TicketComment instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TicketComment merge(TicketComment detachedInstance) {
		log.debug("merging TicketComment instance");
		try {
			TicketComment result = (TicketComment) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TicketComment findById(com.hsw.testmodel.TicketCommentId id) {
		log.debug("getting TicketComment instance with id: " + id);
		try {
			TicketComment instance = (TicketComment) sessionFactory.getCurrentSession()
					.get("com.hsw.testmodel.TicketComment", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TicketComment instance) {
		log.debug("finding TicketComment instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.hsw.testmodel.TicketComment")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
