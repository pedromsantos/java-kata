package org.kata;

public interface Output {
    void printPlay(int x, int y, String player);

    void printWinner(String player);

    void printError(String errorMessage);
}
