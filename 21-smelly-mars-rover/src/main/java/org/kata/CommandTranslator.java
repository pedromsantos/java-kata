package org.kata;

public class CommandTranslator {
    private static String lastLanguage = "EN";

    public String translate(String command, String language) {
        CommandTranslator.lastLanguage = language;

        if (language.equals("EN")) return command;
        if (language.equals("ES")) return translateSpanish(command);
        if (language.equals("FR")) return translateFrench(command);
        if (language.equals("PT")) return translatePortuguese(command);
        if (language.equals("IT")) return translateItalian(command);

        return command;
    }

    public String translateSequence(String commands, String language) {
        StringBuilder result = new StringBuilder();
        for (char command : commands.toCharArray()) {
            result.append(translate(String.valueOf(command), language));
        }
        return result.toString();
    }

    public String getLastLanguageUsed() {
        return CommandTranslator.lastLanguage;
    }

    private String translateSpanish(String command) {
        if (command.equals("I")) return "L";
        if (command.equals("D")) return "R";
        if (command.equals("A")) return "M";
        return command;
    }

    private String translateFrench(String command) {
        if (command.equals("G")) return "L";
        if (command.equals("D")) return "R";
        if (command.equals("A")) return "M";
        return command;
    }

    private String translatePortuguese(String command) {
        if (command.equals("E")) return "L";
        if (command.equals("D")) return "R";
        if (command.equals("A")) return "M";
        return command;
    }

    private String translateItalian(String command) {
        if (command.equals("S")) return "L";
        if (command.equals("D")) return "R";
        if (command.equals("A")) return "M";
        return command;
    }
}
