package pro.sky.skyprodb.dao;

import pro.sky.skyprodb.model.Employee;

import java.awt.*;
import java.util.List;

public interface EmployeeDAO {
    //создание
    void create(Employee employee);
    //получение по id
    Employee readById(int id);
    //получение всех объектов
    List<Employee> readAll();
    void updateById(int id,String first_name);
    void deleteById(int id);
}
