package pro.sky.skyprodb.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.skyprodb.model.Employee;
import pro.sky.skyprodb.dao.HibernateSessionFactoryUtil;
import pro.sky.skyprodb.repository.EmployeeRepository;

import java.util.List;
@Service
public class CrudDaoImpl implements CrudDao {
    private EmployeeRepository employeeRepository;

    public CrudDaoImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public CrudDaoImpl() {
    }

    @Override
    public void create(Object obj) {
        /*try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(obj);
            transaction.commit();
        }*/
        employeeRepository.save(((Employee) obj));
    }

    @Override
    public Object readById(long id, Class a) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(a.getClass(), id);
        }
    }

    @Override
    public List<Employee> readAll() {
        List<Employee> employees = (List<Employee>)  HibernateSessionFactoryUtil
                .getSessionFactory().openSession().createQuery("From Employee").list();
        return employees;
    }

    @Override
    public void update(Object employee) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public void delete(Object employee) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }

}
