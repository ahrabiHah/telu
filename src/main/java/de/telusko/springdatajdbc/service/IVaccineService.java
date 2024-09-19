package de.telusko.springdatajdbc.service;


import de.telusko.springdatajdbc.model.Vaccine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IVaccineService {

    public void registerVaccineInformation(Vaccine vaccine);

    public Iterable<Vaccine> registerMaltiVaccineInformation(Iterable<Vaccine> vaccines);

    public Long getCount();

    public Boolean checkAvalibality(Integer id);

    public Iterable<Vaccine> getAllVaccinInfo();

    public Vaccine getVaccinById(Integer id);

    public String deletebyId(Integer id);


    public Vaccine searchVaccinById(Integer id);
    public Iterable<Vaccine> searchVaccinByIds(Iterable<Integer> id);
    public Iterable<Vaccine> searchVaccinByVaccines(Iterable<Vaccine> id);
    public List<Vaccine> searchVaccinByVaccin(Vaccine id);

    public String removeVaccinesByIds(Iterable<Integer> ids );

    public String removeVaccinesByIdsCrud(Iterable<Integer> ids );

    public List<Vaccine> findByVaccineCostLessThan(Double vaccinCost);
    Iterable<Vaccine> findVaccineByVaccineCostNear(Double cost,Double and);

    Iterable<Vaccine> getAllVaccin();

    public List<Vaccine> searchByVaccineCompany(@Param("name") String nameCompany);

    public List<Vaccine> searchByVaccineCompanyName(@Param("Company1") String com1, @Param("Company2") String com2);

    public List<String> searchByVaccineCostRange(Double minP, Double maxP);

    public int updateVaccineInfo(Double newPrice,String name);
    public int deleteaccineInfo(Double minP,double maxP);


}
