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


        VaccineService vaccineService= container.getBean(VaccineService.class);
        int roe=vaccineService.deleteaccineInfo(900.0,1000.0);

        if (roe!=0){
            System.out.println("Updated success"+ roe);
        }else {
            System.out.println("Not Updated");
        }
        container.close();
    }

}
