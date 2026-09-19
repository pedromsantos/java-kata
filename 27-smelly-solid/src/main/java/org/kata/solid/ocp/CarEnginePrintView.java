package org.kata.solid.ocp;

public class CarEnginePrintView {
    private String text = "";

    public void fillWith(CarEngineViewModel viewModel) {
        this.text = "RPM: " + viewModel.rpm() + ", Temp: " + viewModel.temperature();
    }

    public String getText() {
        return text;
    }
}
