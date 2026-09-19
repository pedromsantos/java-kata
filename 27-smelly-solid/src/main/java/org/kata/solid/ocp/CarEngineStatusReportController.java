package org.kata.solid.ocp;

// OCP violation: every new report format needs a new method on this
// controller (and a new concrete view class) -- the controller must be
// edited, not extended, to add a case.
public class CarEngineStatusReportController {
    private final CarEngineViewModel viewModel;

    public CarEngineStatusReportController(CarEngineViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public CarEngineWebView displayEngineStatusReport() {
        CarEngineWebView webView = new CarEngineWebView();
        webView.fillWith(viewModel);
        return webView;
    }

    public CarEnginePrintView printEngineStatusReport() {
        CarEnginePrintView printView = new CarEnginePrintView();
        printView.fillWith(viewModel);
        return printView;
    }
}
