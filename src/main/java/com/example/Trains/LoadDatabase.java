package com.example.Trains;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(VersionRepository repository) throws Exception{
        return args -> {
            /*log.info("Preloading" + repository.save(new Seat(1L,1,true)));
            log.info("Preloading" + repository.save(new Seat(2L,2,true)));
            log.info("Preloading" + repository.save(new Seat(3L,3,true)));
            log.info("Preloading" + repository.save(new Seat(4L,4,true)));
            log.info("Preloading" + repository.save(new Seat(5L,5,true)));
            log.info("Preloading" + repository.save(new Seat(6L,6,false)));
            log.info("Preloading" + repository.save(new Seat(7L,7,true)));
            log.info("Preloading" + repository.save(new Seat(8L,8,false)));
            log.info("Preloading" + repository.save(new Seat(9L,9,false)));
            log.info("Preloading" + repository.save(new Seat(10L,10,false)));*/
        };
    }
}
