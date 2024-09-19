package de.telusko.springdatajdbc.repository;


import de.telusko.springdatajdbc.model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine,Integer> , CrudRepository<Vaccine,Integer> {

    //findBy--propertyname--keyword

  List<Vaccine> findByVaccineCostLessThan(Double cost);

  List<Vaccine> findByVaccineCostBetween(Double lowerBound, Double upperBound);





}
