package secondproject.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import secondproject.model.Vaccine;

@Repository
public interface VaccineRepository extends CrudRepository<Vaccine,Integer> {




}
