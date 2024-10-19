package org.example.service;

import lombok.Getter;

import java.util.Map;
import java.util.TreeMap;

@Getter
public class ParkingRate {

    private Map<Integer, Double> rateCard;

    public ParkingRate() {
        rateCard = new TreeMap<>();
    }

    public double calculateFee(int hours) {
        double fee = 0;
        for(int h : rateCard.keySet()) {
            fee += rateCard.get(h);
            hours -= h;
            if (hours <= 0)
                break;
        }
        return fee;
    }

}
