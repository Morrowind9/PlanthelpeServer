package byr.win.planthelper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "byr.win.planthelper.dao")
//@ComponentScan(basePackages = "byr.win.planthelper.controller")
public class PlanthelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlanthelperApplication.class, args);
    }

}
