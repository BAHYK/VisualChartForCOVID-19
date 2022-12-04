package edu.finance.visualchartforcovid19;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("edu.finance.visualchartforcovid19.dao")
public class VisualChartForCovid19Application {

    public static void main(String[] args){
        SpringApplication.run(VisualChartForCovid19Application.class, args);
    }

}
