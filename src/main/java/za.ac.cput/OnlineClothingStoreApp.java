package za.ac.cput;

import com.sun.tools.javac.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication

public class OnlineClothingStoreApp {
    public static void main(String[] args){
        SpringApplication.run(OnlineClothingStoreApp.class, args);
    }
}
