package org.kata.solid.srp;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

record Location(double lat, double lng) {}

// SRP violation: Car mixes domain behaviour (mileage/travel) with a
// persistence concern (save) -- two different reasons to change bundled
// into one class.
public class Car {
    private int mileage = 0;
    private Location location = new Location(0, 0);

    public int currentMileage() {
        return mileage;
    }

    public void travelTo(Location location) {
        this.location = location;
        this.mileage += 1;
    }

    public void save() {
        String row = "{\"mileage\":" + mileage
                + ",\"location\":{\"lat\":" + location.lat()
                + ",\"lng\":" + location.lng() + "}}";
        try {
            Files.writeString(Path.of("/tmp/car.json"), row);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
