package de.telusko.springdatajdbc.repository;

import de.telusko.springdatajdbc.model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaRepo extends JpaRepository<Vaccine , Long> {

    Iterable<Vaccine> findByVaccineCompany(String name);
}
