package pro.sky.skyprodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pro.sky.skyprodb.model.Employee;
import pro.sky.skyprodb.repository.EmployeeRepository;

import java.math.BigInteger;
import java.util.List;
@Service
public class CrudEmloyeeDaoImpl implements CrudDao {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Object readById(BigInteger id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List readAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(BigInteger id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Integer getCountOfEmployees() {
        return employeeRepository.getCountEmployees();
    }

    @Override
    public Integer getMediumAgeByEmployee() {
        return employeeRepository.getMediumAgeByEmployee();
    }

    @Override
    public List<Employee> GetFiveYoungestEmployees() {
        return employeeRepository.GetFiveYoungestEmployees();
    }

    @Override
    public List<Employee> getAllEmployees(Integer page, Integer size) {
        if (page>50 || page<=0){
            page = 50;
        }
        PageRequest pageRequest = PageRequest.of(page-1,size);
        return employeeRepository.findAllByPageRequest(pageRequest);
    }

}
