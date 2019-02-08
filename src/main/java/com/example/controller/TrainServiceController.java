package com.example.controller;


import com.example.logger.Log;
import com.example.response.AnswerResponse;
import com.example.response.MyResponse;
import com.example.data.VersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.logging.Level;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;


@RestController
public class TrainServiceController {

    @Autowired
    private Logic logic;

    private Log log;


    TrainServiceController(VersionRepository repository) throws IOException {
        this.logic = new Logic(repository);
        this.log = new Log("log.txt");
        this.log.logger.setLevel(Level.ALL);
    }

    @PostMapping(path = "/train/{size}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> setTrainSize(@PathVariable String size){
        Integer sizeValue;
        Long resultID;
        log.logger.info("Trying to create train of size:" + size);
        try{
            sizeValue = Integer.parseInt(size);
            if (sizeValue <= 0) {
                throw new Exception();
            }
            resultID = logic.createTrain(sizeValue);
        } catch (Exception e){
            log.logger.warning("Incorrect input of train size:" + size);
            return new ResponseEntity<>(
                    new MyResponse(false, null, "Incorrect input"),
                    HttpStatus.BAD_REQUEST);
        }

        log.logger.info("Train with size " + size + " was successfully created!");
        return new ResponseEntity<>(
                new MyResponse(true,resultID, "Correct input"),
                HttpStatus.OK);
    }

    @GetMapping(path = "/answer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTrainLength(@PathVariable String id) {
        Integer answer = null;
        log.logger.info("/answer/" + id + " Trying to find the length of the train with ID:" + id);
        try {
            Long idValue = Long.parseLong(id);
            answer = logic.findTrainLength(idValue);
        }catch (Exception e){
            log.logger.warning("Incorrect input of ID: " + id + "(Version of has not been found or the ID is not an Integer)");
            return new ResponseEntity<>(
                    new AnswerResponse(false,null,"Incorrect input"),
                    HttpStatus.BAD_REQUEST);
        }

        log.logger.info("Size of train with version ID:" + id + " was successfully calculated!");
        return new ResponseEntity<>(
                new AnswerResponse(true, answer,"Correct input"),
                HttpStatus.OK);
    }

}
