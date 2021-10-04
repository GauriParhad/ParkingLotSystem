package com.bridgelabz;

public class ParkingLotSystem {
    private Object vehicle;

    public void park(Object vehicle) throws ParkingLotException {
        if(this.vehicle != null)
            throw new ParkingLotException("Parking Lot is Full");
        else
            this.vehicle = vehicle;
        throw new ParkingLotException("Vehicle is Parked ");
    }


    public boolean unPark(Object vehicle) throws ParkingLotException {
        if (vehicle == null)
            return false;

        if (this.vehicle.equals(vehicle)) {
            this.vehicle=null;
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

    public ParkingLotSystem(){
    }

    public  park(Object o) {
        return true;
    }
}
