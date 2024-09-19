package de.telusko.springdatajdbc.service.impl;

import de.telusko.springdatajdbc.model.Vaccine;
import de.telusko.springdatajdbc.repository.VaccineRepository;
import de.telusko.springdatajdbc.service.IVaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VaccineService implements IVaccineService {


    @Autowired
    private final VaccineRepository vaccineRepository;

    public VaccineService(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

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
    public Vaccine searchVaccinById(Integer id) {

        return vaccineRepository.getReferenceById(id);
    }
    @Override
    public Iterable<Vaccine> searchVaccinByIds(Iterable<Integer> ids) {
        // Use the repository to find all vaccines with the given IDs
        return vaccineRepository.findAllById(ids); // Returns an Iterable of Vaccines
    }

    @Override
    public Iterable<Vaccine> searchVaccinByVaccines(Iterable<Vaccine> vaccines) {
        List<Vaccine> resultList = new ArrayList<>();

        for (Vaccine vaccine : vaccines) {
            // Create an example for each vaccine
            Example<Vaccine> vaccineExample = Example.of(vaccine);

            // Find matching vaccines and add them to the result list
            Iterable<Vaccine> foundVaccines = vaccineRepository.findAll(vaccineExample);
            foundVaccines.forEach(resultList::add); // Add all found results to the list
        }

        return resultList;
    }

    @Override
    public List<Vaccine> searchVaccinByVaccin(Vaccine vaccine) {
        Example<Vaccine> vaccineExample = Example.of(vaccine);
        return vaccineRepository.findAll(vaccineExample); // Return all matching vaccines
    }

    @Override
    public String removeVaccinesByIds(Iterable<Integer> ids) {
        List<Vaccine> list=vaccineRepository.findAllById(ids);

        if (list.size()!=0){
            vaccineRepository.deleteAllByIdInBatch(ids);
            return "records deleted the ids";
        }
        return "Failed";

    }

    @Override
    public String removeVaccinesByIdsCrud(Iterable<Integer> ids) {
        List<Vaccine> list=vaccineRepository.findAllById(ids);
        long idsCount = ids.spliterator().getExactSizeIfKnown(); // Get the number of input ids

        if (list.size() == idsCount) {
            vaccineRepository.deleteAllByIdInBatch(ids);
            return " Crud records deleted the ids" ;
        }
        return "Failed CRUD delete";

    }

    @Override
    public List<Vaccine> findByVaccineCostLessThan(Double vaccinCost) {
        return vaccineRepository.findByVaccineCostLessThan(vaccinCost); // Use the corrected method name
    }

    @Override
    public Iterable<Vaccine> findVaccineByVaccineCostNear(Double vaccinCost,Double and) {
        return vaccineRepository.findByVaccineCostBetween(vaccinCost,and); // Use the corrected method name
    }

    @Override
    public Iterable<Vaccine> getAllVaccin() {
        // Use the built-in findAll() method to retrieve all vaccines
        return vaccineRepository.findAll();
    }

    @Override
    public List<Vaccine> searchByVaccineCompany(String nameCompany) {
        return vaccineRepository.searchByVaccineCompany(nameCompany);
    }

    @Override
    public List<Vaccine> searchByVaccineCompanyName(String com1, String com2) {
        return vaccineRepository.searchByVaccineCompanyName(com1,com2);
    }

    @Override
    public List<String> searchByVaccineCostRange(Double minP, Double maxP) {
        return vaccineRepository.searchByVaccineCostRange(minP,maxP);
    }

    @Override
    public int updateVaccineInfo(Double newPrice,String name){

        return vaccineRepository.updateVaccineInfo(newPrice,name);
    }


}
