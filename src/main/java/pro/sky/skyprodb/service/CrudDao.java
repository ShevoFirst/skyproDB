package pro.sky.skyprodb.service;

import pro.sky.skyprodb.model.Employee;

import java.math.BigInteger;
import java.util.List;

public  interface CrudDao<T extends Employee> {

    //создание
    void create(T employee);

    Object readById(BigInteger id);

    //получение всех объектов
    List<T> readAll();
    void update(T employee);
    void deleteById(BigInteger id);
    Integer getCountOfEmployees();
    Integer getMediumAgeByEmployee();
    List<Employee> GetFiveYoungestEmployees();

    List<Employee> getAllEmployees(Integer page, Integer size);
}
