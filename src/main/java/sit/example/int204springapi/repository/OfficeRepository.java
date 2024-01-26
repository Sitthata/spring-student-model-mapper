package sit.example.int204springapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.example.int204springapi.models.Office;

public interface OfficeRepository extends JpaRepository<Office, Integer> {
}
