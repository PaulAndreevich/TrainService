package com.example.Trains;


import com.example.Counter.Counter;
import com.example.Railway.Train;
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
        Version resultVer;

        try{
            sizeValue = Integer.parseInt(size);
            Train train = new Train(sizeValue);
            Version version = new Version(train);
            resultVer = repository.save(version);
            //repository.flush();
        } catch (Exception e){
            return new ResponseEntity<>(
                    new MyResponse(false, null, "Incorrect input"),
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(
                new MyResponse(true, resultVer.getId().longValue(), "Correct input"),
                HttpStatus.OK);
    }

    @GetMapping(path = "/answer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> newSeat() {
        Version version = repository.findById(1l).get();
       return new ResponseEntity<>(
                new MyResponse(true, null, String.valueOf(Counter.findSizeOfTrain(version.getTrain().getRoot()))),
                HttpStatus.OK);

    }

}
