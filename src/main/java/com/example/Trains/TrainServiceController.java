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
    private Logic logic;

    TrainServiceController(VersionRepository repository){
        this.logic = new Logic(repository);
    }

    @PostMapping(path = "/train/{size}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> setTrainSize(@PathVariable String size){
        Integer sizeValue;
        Long resultID;
        try{
            sizeValue = Integer.parseInt(size);
            resultID = logic.createTrain(sizeValue);
        } catch (Exception e){
            return new ResponseEntity<>(
                    new MyResponse(false, null, "Incorrect input"),
                    HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(
                new MyResponse(true,resultID, "Correct input"),
                HttpStatus.OK);
    }

    @GetMapping(path = "/answer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTrainLength(@PathVariable String id) {
        Integer answer = null;
        try {
            Long idValue = Long.parseLong(id);
            answer = logic.findTrainLength(idValue);
        }catch (Exception e){
            return new ResponseEntity<>(
                    new AnswerResponse(false,null,"Incorrect input"),
                    HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(
                new AnswerResponse(true, answer,"Correct input"),
                HttpStatus.OK);
    }

}
