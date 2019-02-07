package com.example.counter;

import com.example.counter.Counter;
import com.example.data.VersionRepository;
import com.example.railway.Train;
import com.example.railway.Version;
import org.springframework.stereotype.Service;


@Service
public class Logic {

    private final VersionRepository repository;

    public Logic(VersionRepository repository) {
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
