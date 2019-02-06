package com.example.Trains;

import com.example.Railway.Train;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Version {
    private @GeneratedValue @Id Long id;
    private Train train;

    Version(Train train){
        this.train = train;
    }

    Version(){
        train = null;
    };

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}





