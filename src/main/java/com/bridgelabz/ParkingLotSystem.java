package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotSystem {
    private int actualCapacity;
    private int currentCapacity;
    private Object vehicle;
    private List<ParkingLotObserver> observers;


    public ParkingLotSystem(int capacity) {
        this.observers = new ArrayList<>();
        this.currentCapacity = 0;
        this.actualCapacity = capacity;
    }

    public boolean registerParkingLotObserver(ParkingLotObserver observer) {
        this.observers.add(observer);
    }

    public void registerSecurity(AirportSecurity airportSecurity) {
        this.security = airportSecurity;
    }

    public void setCapacity(int capacity) {
        this.actualCapacity = capacity;
    }

    public void park(Object vehicle) throws ParkingLotException {
        if (this.currentCapacity == this.actualCapacity) {
            for(ParkingLotObserver observer: observers){
                observer.capacityIsFull();
            }

            throw new ParkingLotException("Parking Lot is Full");
        }
        this.currentCapacity++;
        this.vehicle = vehicle;
    }


    public boolean unPark(Object vehicle) throws ParkingLotException {
        if (vehicle == null)
            return false;

        if (this.vehicle.equals(vehicle)) {
            this.vehicle = null;
            return true;
        }
        return false;
    }


    public boolean isVehicleParked(Object vehicle) {
        if (this.vehicle.equals(vehicle)) {
            return true;
        }
        return false;
    }
}
