package by.bsuir.ddjames.techrepair.dao.impl;

import by.bsuir.ddjames.techrepair.controller.commands.ShowCommentsCommand;
import by.bsuir.ddjames.techrepair.dao.AbstractDao;
import by.bsuir.ddjames.techrepair.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public abstract class EntityDao <Entity extends Serializable> implements AbstractDao<Entity> {

	protected Class<?> entityClass;
	protected Session session;
	
	public EntityDao (Entity obj) {
		this.entityClass = obj.getClass();
	}
	
	@Override
	public Long create (Entity obj) {
		Long id = null;
                try {
			this.session = HibernateUtil.openSession();
			this.session.beginTransaction();
                        id = (Long) this.session.save(obj);
                        this.session.getTransaction().commit();
		} catch (Exception e) {
                        Logger.getLogger(EntityDao.class.getName()).log(Level.SEVERE, null, e);
			this.session.getTransaction().rollback();
		} finally {
                    session.close();
                }
		return id;
	}

	@Override
	public void delete (Entity obj) {
		try {
			this.session = HibernateUtil.openSession();
			this.session.beginTransaction();
			this.session.delete(obj);
			this.session.getTransaction().commit();
		} catch (Exception e) {
			this.session.getTransaction().rollback();
		} finally {
                        session.close();
                }
	}

	@Override
	public void update (Entity obj) {
		try {
			this.session = HibernateUtil.openSession();
			this.session.beginTransaction();
			this.session.update(obj);
			this.session.getTransaction().commit();
		} catch (Exception e) {
                        e.printStackTrace();
			this.session.getTransaction().rollback();
		} finally {
                        session.close();
                }
	}

	@Override
	@SuppressWarnings("unchecked")
	public Entity getById (Long entityId) {
		Entity entity = null;
		try {
			this.session = HibernateUtil.openSession();
			this.session.beginTransaction();
        		List<Entity> list = null;
			list = this.session.createCriteria(entityClass).add(Restrictions.eq("id", entityId)).list();
                        if(list.size()>0) {
        			entity = list.get(0);
                        }
			this.session.getTransaction().commit();
		} catch (HibernateException e) {
			this.session.getTransaction().rollback();
		} finally {
                    
                }
		return entity;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Entity> getAll () {
		List<Entity> list = null;
		try {
			this.session = HibernateUtil.openSession();
                        this.session.beginTransaction();
			list = this.session.createCriteria(entityClass).list();
 			this.session.getTransaction().commit();
                } catch (HibernateException e) {
			this.session.getTransaction().rollback();
		} finally {
                        session.close();
                }
		return list;
	}
}