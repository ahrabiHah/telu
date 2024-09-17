package secondproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import secondproject.model.Vaccine;

public interface VaRepo extends JpaRepository<Vaccine, Long> {

    Iterable<Vaccine> findByVaccineCompany(String name);
}
