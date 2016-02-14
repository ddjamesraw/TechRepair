package by.bsuir.ddjames.techrepair.dao.impl;

import by.bsuir.ddjames.techrepair.dao.entity.Client;
import by.bsuir.ddjames.techrepair.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

public class ClientDao extends EntityDao<Client> {
    
    public ClientDao() {
        super(new Client());
    }
    
    public Client getByLogin(String login) {
        Client client = null;
        try {
            session = HibernateUtil.openSession();
            session.beginTransaction();
            List<Client> list = session.createCriteria(Client.class).add(Restrictions.eq("login", login)).list();
            if (!list.isEmpty()) {
                client = list.get(0);
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            this.session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return client;
    }
}
