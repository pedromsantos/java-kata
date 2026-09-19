package org.kata.solid.ocp;

public class CarEngineWebView {
    private String html = "";

    public void fillWith(CarEngineViewModel viewModel) {
        this.html = "<div>" + viewModel.rpm() + " rpm, " + viewModel.temperature() + "C</div>";
    }

    public String getHtml() {
        return html;
    }
}
