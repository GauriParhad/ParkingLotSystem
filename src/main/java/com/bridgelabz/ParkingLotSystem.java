package com.bridgelabz;

public class ParkingLotSystem {
    private  int actualCapacity;
    private int currentCapacity;
    private Object vehicle;
    private ParkingLotOwner owner;

    public ParkingLotSystem(int capacity){
        this.currentCapacity = 0;
        this.actualCapacity = capacity;
    }
    public boolean registerOwner(ParkingLotOwner owner) {
        this.owner = owner;
        return true;
    }

    public void setCapacity(int capacity) {
        this.actualCapacity = capacity;
    }

    public void park(Object vehicle) throws ParkingLotException {
        if (this.currentCapacity == this.actualCapacity){
            owner.capacityIsFull();
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
