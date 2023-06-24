package pro.sky.skyprodb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pro.sky.skyprodb.model.Employee;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, BigInteger>, PagingAndSortingRepository<Employee,BigInteger> {
    @Query(value = "SELECT COUNT(*) FROM employee;", nativeQuery = true)
    Integer getCountEmployees();
    @Query(value = "SELECT AVG(age) FROM employee;", nativeQuery = true)
    Integer getMediumAgeByEmployee();
    @Query(value = "SELECT * FROM employee ORDER BY age ASC LIMIT 5;", nativeQuery = true)
    List<Employee> GetFiveYoungestEmployees();
    @Query(value = "FROM Employee")
    List<Employee> findAllByPageRequest(PageRequest pageRequest);
}
