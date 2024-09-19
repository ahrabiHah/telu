package de.telusko.springdatajdbc.repository;


import de.telusko.springdatajdbc.model.Vaccine;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Integer>, CrudRepository<Vaccine, Integer> {

    //findBy--propertyname--keyword

    List<Vaccine> findByVaccineCostLessThan(Double cost);

    List<Vaccine> findByVaccineCostBetween(Double lowerBound, Double upperBound);

    @Query("from Vaccine  where vaccineCompany=:nameCompany ")
    public List<Vaccine> searchByVaccineCompany(@Param("nameCompany") String nameCompany);

    @Query("from Vaccine  where vaccineName IN(:Company1,:Company2) ")
    public List<Vaccine> searchByVaccineCompanyName(@Param("Company1") String com1, @Param("Company2") String com2);

    @Query("select vaccineName from  Vaccine where vaccineCost between :minP and :maxP")
    public List<String> searchByVaccineCostRange(Double minP, Double maxP);


    @Transactional
    @Modifying
    @Query("update Vaccine  set vaccineCost=:newPrice where vaccineName=:name")
    public int updateVaccineInfo(Double newPrice,String name);



}
