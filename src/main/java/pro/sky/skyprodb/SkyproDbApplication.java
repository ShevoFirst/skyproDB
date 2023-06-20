package pro.sky.skyprodb;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import pro.sky.skyprodb.model.City;
import pro.sky.skyprodb.service.CrudDao;
import pro.sky.skyprodb.model.Employee;
import pro.sky.skyprodb.service.CrudDaoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SkyproDbApplication {

    public static void main(String[] args) {

        CrudDaoImpl crudDao = new CrudDaoImpl();
        City city = new City("Урюпинск");
        Employee employee = new Employee("Дмитрий", "Донсков","муж",38,city);
        crudDao.create(employee);
        crudDao.delete(employee);
        System.out.println(crudDao.readAll());
    }
}
