package org.kata.connascence.meaning;

import java.util.ArrayList;
import java.util.List;

// Connascence of Meaning: "1"/"2"/"3"/"4" only mean bike/car/train/bus by
// an unstated convention shared between the caller and this switch --
// nothing in the code documents or enforces the mapping.
public class TransportSelector {
    private final List<String> selected = new ArrayList<>();

    public void setTransport(String transport) {
        switch (transport) {
            case "1" -> selected.add("bike");
            case "2" -> selected.add("car");
            case "3" -> selected.add("train");
            case "4" -> selected.add("bus");
            default -> throw new IllegalArgumentException("Unknown transport code: " + transport);
        }
    }
}
