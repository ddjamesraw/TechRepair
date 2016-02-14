package by.bsuir.ddjames.techrepair.dao.impl;

import by.bsuir.ddjames.techrepair.dao.entity.Order;
import by.bsuir.ddjames.techrepair.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

public class OrderDao extends EntityDao<Order> {
    
    public OrderDao() {
        super(new Order());
    }
    
    public List<Order> getByLogin(String login) {
        try {
            session = HibernateUtil.openSession();
            session.beginTransaction();
            List<Order> list = session.createCriteria(Order.class).list();
            session.getTransaction().commit();
            if(list.isEmpty()) {
                return null;
            } else {
                List<Order> result = new ArrayList<>();
                for(Order it: list) {
                    if(it.getClient().getLogin().equals(login)) {
                        result.add(it);
                    }
                }
                return result;
            }
        } catch (HibernateException e) {
            this.session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }
}
