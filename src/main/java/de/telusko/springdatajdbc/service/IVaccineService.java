package de.telusko.springdatajdbc.service;


import de.telusko.springdatajdbc.model.Vaccine;

public interface IVaccineService {

    public void registerVaccineInformation(Vaccine vaccine);

    public Iterable<Vaccine> registerMaltiVaccineInformation(Iterable<Vaccine> vaccines);

    public Long getCount();

    public Boolean checkAvalibality(Integer id);

    public Iterable<Vaccine> getAllVaccinInfo();

    public Vaccine getVaccinById(Integer id);

    public String deletebyId(Integer id);


    Iterable<Vaccine> findByVaccineCompany(String name);
}
