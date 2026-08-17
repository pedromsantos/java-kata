package org.kata;

public class MissionLog {
    private final CommandTranslator translator;
    private final TelemetryPort telemetry;

    public MissionLog(CommandTranslator translator, TelemetryPort telemetry) {
        this.translator = translator;
        this.telemetry = telemetry;
    }

    public String logTranslatedSequence(String commands, String language) {
        String translated = translator.translateSequence(commands, language);
        telemetry.record(language + ":" + commands + "->" + translated);
        return translated;
    }
}
