package pro.sky.skyprodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import pro.sky.skyprodb.model.City;
import pro.sky.skyprodb.model.Employee;
import pro.sky.skyprodb.repository.EmployeeRepository;
import pro.sky.skyprodb.service.CrudDaoImpl;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SkyproDbApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkyproDbApplication.class, args);/*
        CrudDaoImpl crudDao = new CrudDaoImpl();
        crudDao.create(new Employee("Андрей","RRFAS","МУЖ",21,new City("Мулловка")));
        System.out.println(crudDao.readAll());*/
    }
}
