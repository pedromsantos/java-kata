package org.kata.solid.isp;

public class ElectricCar implements IAmACar {
    private int mileage = 0;
    private double batteryKiloWatts = 0;

    @Override
    public void goTo(Location location) {
        this.mileage += 1;
        System.out.println("Driving to " + location.lat() + ", " + location.lng());
    }

    @Override
    public void refillGasoline(double gallons) {
        throw new UnsupportedOperationException("Electric cars don't take gasoline");
    }

    @Override
    public void refillElectricity(double kiloWatts) {
        this.batteryKiloWatts += kiloWatts;
    }

    @Override
    public int currentMileage() {
        return mileage;
    }
}
