package com.gms.ticketsystem.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class Stop {
    private Long stopNo;
    private String stopName;
    private Long noOfPassengers;

    public Long getStopNo() {
        return stopNo;
    }

    public void setStopNo(Long stopNo) {
        this.stopNo = stopNo;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public Long getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(Long noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }
}
