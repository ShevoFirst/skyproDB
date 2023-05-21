package pro.sky.skyprodb.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import pro.sky.skyprodb.model.Employee;
import pro.sky.skyprodb.dao.HibernateSessionFactoryUtil;

import java.sql.Connection;
import java.util.List;
@Service
public class EmployeeDaoImpl implements EmployeeDAO {
    @Override
    public void create(Employee employee) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    @Override
    public Employee readById(long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class,id);
    }

    @Override
    public List<Employee> readAll() {
        List<Employee> employees = (List<Employee>)  HibernateSessionFactoryUtil
                .getSessionFactory().openSession().createQuery("From Employee").list();
        return employees;
    }

    @Override
    public void update(Employee employee) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public void delete(Employee employee) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }
}
