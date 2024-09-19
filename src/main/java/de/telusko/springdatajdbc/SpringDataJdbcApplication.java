package de.telusko.springdatajdbc;

import de.telusko.springdatajdbc.model.Vaccine;
import de.telusko.springdatajdbc.repository.VaccineRepository;
import de.telusko.springdatajdbc.service.IVaccineService;
import de.telusko.springdatajdbc.service.impl.VaccineService;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringDataJdbcApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext container = SpringApplication.run(SpringDataJdbcApplication.class, args);


//        IVaccineService service = container.getBean(VaccineService.class);
//        service.findByVaccineCostLessThan(1000d).forEach(v-> System.out.println("the Vaccin "+v.getVaccineName()+" with cost less than "+v.getVaccineCost()));


        IVaccineService service = container.getBean(VaccineService.class);



        container.close();
    }

}
