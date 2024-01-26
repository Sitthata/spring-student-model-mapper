package sit.example.int204springapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.example.int204springapi.models.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByOfficeId(Integer id);
}
