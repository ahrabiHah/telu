package de.telusko.springdatajdbc;

import de.telusko.springdatajdbc.model.Vaccine;
import de.telusko.springdatajdbc.service.IVaccineService;
import de.telusko.springdatajdbc.service.impl.VaccineService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDataJdbcApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext container = SpringApplication.run(SpringDataJdbcApplication.class, args);


        IVaccineService service = container.getBean(VaccineService.class);

        Vaccine v1 = new Vaccine("Covaxin", "Hesham GmBh", 11230.1d);
        Vaccine v2 = new Vaccine("Phizer", "AG", 1220.1d);
        Vaccine v3 = new Vaccine("Spuutnik", "Russland", 1220.1d);
        service.registerVaccineInformation(v1);
        System.out.println("___________________registerVaccineInformation________________________________");
        List<Vaccine> vaccines = new ArrayList<>();
        vaccines.add(v1);
        vaccines.add(v2);
        vaccines.add(v3);
        service.registerMaltiVaccineInformation(vaccines).forEach(System.out::println);
        System.out.println("______________________registerMaltiVaccineInformation_____________________________");

        Long co = service.getCount();
        System.out.println("Num of Vaccin " + co);
        System.out.println("______________________getCount_____________________________");

        int id = 153;
        Boolean state = service.checkAvalibality(id);

        if (state) {
            System.out.println("is avlaibale and id : " + id);
        }
        System.out.println("state not found " + id);
        System.out.println("____________________checkAvalibality_______________________________");

        service.getAllVaccinInfo().forEach(System.out::println);
        System.out.println("________________________getAllVaccinInfo________________________");

        Vaccine vaccine = service.getVaccinById(id);
        System.out.println(vaccine);


        System.out.println("__________________getVaccinById__________________________");

        String status= service.deletebyId(id);
        System.out.println(status);

        System.out.println("__________________deletebyId__________________________");

    }

}
