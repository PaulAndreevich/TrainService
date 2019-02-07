package com.example.railway;

import com.example.railway.Train;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Version {
    private @GeneratedValue @Id Long id;
    private Train train;

    public Version(Train train){
        this.train = train;
    }

    public Version(){
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





