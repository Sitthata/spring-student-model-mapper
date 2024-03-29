package sit.example.int204springapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.example.int204springapi.models.Office;


import java.util.List;
import java.util.Optional;

public interface OfficeRepository extends JpaRepository<Office, Integer> {
    Optional<List<Office>> findByCityContains(String city);
}
