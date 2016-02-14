package by.bsuir.ddjames.techrepair.dao.impl;

import by.bsuir.ddjames.techrepair.dao.entity.Employee;
import by.bsuir.ddjames.techrepair.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

public class EmployeeDao extends EntityDao<Employee> {
    
    public EmployeeDao() {
        super(new Employee());
    }
    
    public Employee getByLogin(String login) {
        Employee employee = null;
        try {
            session = HibernateUtil.openSession();
            session.beginTransaction();
            List<Employee> list = session.createCriteria(Employee.class).add(Restrictions.eq("login", login)).list();
            if(!list.isEmpty()) {
                employee = list.get(0);
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            this.session.getTransaction().rollback();
        } finally {
            session.close();
        }
    return employee;
    }
}
