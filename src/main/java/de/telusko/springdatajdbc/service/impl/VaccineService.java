package de.telusko.springdatajdbc.service.impl;

import de.telusko.springdatajdbc.model.Vaccine;
import de.telusko.springdatajdbc.repository.VaRepo;
import de.telusko.springdatajdbc.repository.VaccineRepository;
import de.telusko.springdatajdbc.service.IVaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VaccineService implements IVaccineService {


    @Autowired
    private VaccineRepository vaccineRepository;

    @Autowired
    private VaRepo vaRepo;

    @Override
    public void registerVaccineInformation(Vaccine vaccine) {

        Vaccine vac = vaccineRepository.save(vaccine);


    }

    @Override
    public Iterable<Vaccine> registerMaltiVaccineInformation(Iterable<Vaccine> vaccines) {

        return vaccineRepository.saveAll(vaccines); // Save all vaccines in one go

    }

    @Override
    public Long getCount() {
        return vaccineRepository.count(); // Returns the total count of Vaccine entities

    }

    @Override
    public Boolean checkAvalibality(Integer id) {
        return vaccineRepository.existsById(id);
    }

    @Override
    public Iterable<Vaccine> getAllVaccinInfo() {
        return vaccineRepository.findAll();
    }

    @Override
    public Vaccine getVaccinById(Integer id) {

        //optional is containter to check
        Optional<Vaccine> vaccine = vaccineRepository.findById(id);

        if (vaccine.isPresent()){
            return vaccine.get();
        }else {
            return new Vaccine();
        }

    }

    @Override
    public String deletebyId(Integer id) {

        Optional<Vaccine>vaccine= vaccineRepository.findById(id);

        if (vaccine.isPresent()){
             vaccineRepository.deleteById(id);
            return "Vaccine with id: " + id + " is deleted";
        }else {
            return  "no Vaccin with Id " +id+ "was found";
        }

    }
    @Override
    public Iterable<Vaccine> findByVaccineCompany(String name) {
        return vaRepo.findByVaccineCompany(name); // Returns vaccines by company name
    }
}
