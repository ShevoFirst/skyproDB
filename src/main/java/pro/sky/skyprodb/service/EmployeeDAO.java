package pro.sky.skyprodb.service;

import pro.sky.skyprodb.model.Employee;

import java.awt.*;
import java.util.List;

public interface EmployeeDAO {
    //создание
    void create(Employee employee);
    //получение по id
    Employee readById(long id);
    //получение всех объектов
    List<Employee> readAll();
    void update(Employee employee);
    void delete(Employee employee);
}
