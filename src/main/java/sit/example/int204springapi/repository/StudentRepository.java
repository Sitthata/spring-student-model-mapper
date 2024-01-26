package sit.example.int204springapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.example.int204springapi.models.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
