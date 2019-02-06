package com.example.Trains;


import com.example.Counter.Counter;
import com.example.Railway.Train;
import com.example.Response.AnswerResponse;
import com.example.Response.MyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;


@RestController

public class TrainServiceController {

    @Autowired
    private final VersionRepository repository;

    TrainServiceController(VersionRepository repository){
        this.repository = repository;
    }

    @PostMapping(path = "/train/{size}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> all(@PathVariable String size){
        Integer sizeValue;
        Version version;
        try{
            sizeValue = Integer.parseInt(size);
            Train train = new Train(sizeValue);
            version = new Version(train);
            version = repository.save(version);
        } catch (Exception e){
            return new ResponseEntity<>(
                    new MyResponse(false, null, "Incorrect input"),
                    HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(
                new MyResponse(true, version.getId().longValue(), "Correct input"),
                HttpStatus.OK);
    }

    @GetMapping(path = "/answer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> newSeat(@PathVariable String id) {
        Version version;
        Integer answer;

        try {
            Long idValue = Long.parseLong(id);
            version = repository.findById(idValue).get();
            answer = Counter.findSizeOfTrain(version.getTrain().getRoot());
        }catch (Exception e){
            return new ResponseEntity<>(
                    new AnswerResponse(false,null,"Incorrect input"),
                    HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(
                new AnswerResponse(true, answer,"Correct input"),
                HttpStatus.BAD_REQUEST);
    }

}
