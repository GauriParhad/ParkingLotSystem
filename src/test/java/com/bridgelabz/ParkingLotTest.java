package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ParkingLotTest {
    ParkingLotSystem parkingLotSystem = null;
    Object vehicle = null;

    @BeforeEach
    public void SetUp() throws Exception {
        vehicle = new Object();
        ParkingLotSystem parkingLotSystem = new ParkingLotSystem();
    }


    @Test
    public void givenVehicle_WhenParked_ShouldReturnTrue() {
        try {
            parkingLotSystem.park(vehicle);
            boolean isParked = parkingLotSystem.isVehicleParked(vehicle);
            Assertions.assertTrue(isParked);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenVehicle_WhenAlreadyParked_ShouldReturnFalse() {
        try {
            parkingLotSystem.park(vehicle);
            parkingLotSystem.park(new Object());
        } catch (ParkingLotException e) {
            Assertions.assertEquals("Parking Lot is Full", e.getMessage());
            e.printStackTrace();
        }
    }


    @Test
    public void givenVehicle_WhenUnparked_ShouldReturnTrue() {
        try {
            parkingLotSystem.park(vehicle);
            boolean isUnparked = parkingLotSystem.unPark(vehicle);
            Assertions.assertTrue(isUnparked);

        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }
}
        

