package pro.sky.skyprodb.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.skyprodb.model.Employee;

import java.math.BigInteger;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, BigInteger> {

}
