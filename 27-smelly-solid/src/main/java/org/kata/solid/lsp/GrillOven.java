package org.kata.solid.lsp;

public class GrillOven extends Oven {
    @Override
    public void cook(String food) {
        System.out.println("Grilling " + food);
    }
}
