package com.example.Trains;

import com.example.Counter.Counter;
import com.example.Railway.Train;
import org.springframework.stereotype.Service;


@Service
public class Logic {

    private final VersionRepository repository;

    Logic(VersionRepository repository) {
        this.repository = repository;
    }

    public Long createTrain(int size){
        Version version;
        Train train = new Train(size);
        version = new Version(train);
        version = repository.save(version);
        return version.getId().longValue();
    }

    public Integer findTrainLength(Long id){
        Version version = repository.findById(id).get();
        return Counter.findSizeOfTrain(version.getTrain().getRoot());
    }



}
