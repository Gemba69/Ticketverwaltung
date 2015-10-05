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
 * Home object for domain model class TicketTag.
 * @see com.hsw.testmodel.TicketTag
 * @author Hibernate Tools
 */
public class TicketTagHome {

	private static final Log log = LogFactory.getLog(TicketTagHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(TicketTag transientInstance) {
		log.debug("persisting TicketTag instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TicketTag instance) {
		log.debug("attaching dirty TicketTag instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TicketTag instance) {
		log.debug("attaching clean TicketTag instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TicketTag persistentInstance) {
		log.debug("deleting TicketTag instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TicketTag merge(TicketTag detachedInstance) {
		log.debug("merging TicketTag instance");
		try {
			TicketTag result = (TicketTag) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TicketTag findById(com.hsw.testmodel.TicketTagId id) {
		log.debug("getting TicketTag instance with id: " + id);
		try {
			TicketTag instance = (TicketTag) sessionFactory.getCurrentSession().get("com.hsw.testmodel.TicketTag", id);
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

	public List findByExample(TicketTag instance) {
		log.debug("finding TicketTag instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.hsw.testmodel.TicketTag")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
