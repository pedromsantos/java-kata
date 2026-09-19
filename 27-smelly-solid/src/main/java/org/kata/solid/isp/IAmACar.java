package org.kata.solid.isp;

record Location(double lat, double lng) {}

// ISP violation: gasoline and electric refuelling are mutually exclusive
// capabilities bundled into one fat interface -- no single car honestly
// supports both.
public interface IAmACar {
    void goTo(Location location);

    void refillGasoline(double gallons);

    void refillElectricity(double kiloWatts);

    int currentMileage();
}
