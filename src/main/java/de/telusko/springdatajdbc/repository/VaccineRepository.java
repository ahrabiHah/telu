package de.telusko.springdatajdbc.repository;


import de.telusko.springdatajdbc.model.Vaccine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRepository extends CrudRepository<Vaccine,Integer> {




}
