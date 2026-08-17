package org.kata;

import java.lang.reflect.Method;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(OrderAnnotation.class)
class CommandTranslatorTest {
    private static final CommandTranslator sharedTranslator = new CommandTranslator();
    private static int callCount = 0;

    @Test
    @Order(1)
    void test1() {
        callCount++;
        String result = sharedTranslator.translate("I", "ES");
        assertThat(result).isNotNull();
    }

    @Test
    @Order(2)
    void shouldWork() {
        assertThat(callCount).isGreaterThan(0);
        assertThat(sharedTranslator.getLastLanguageUsed()).isEqualTo("ES");
    }

    @Test
    void translatesAndLogsAndReportsLastLanguageAndHandlesUnknownLanguageAndSequences() {
        CommandTranslator t = new CommandTranslator();
        assertThat(t.translate("G", "FR")).isEqualTo("L");
        assertThat(t.translate("D", "FR")).isEqualTo("R");
        assertThat(t.translate("A", "FR")).isEqualTo("M");
        assertThat(t.translate("Z", "FR")).isEqualTo("Z");
        assertThat(t.translateSequence("GDA", "FR")).isEqualTo("LRM");
        assertThat(t.getLastLanguageUsed()).isEqualTo("FR");
        assertThat(t.translate("X", "XX")).isEqualTo("X");
    }

    @Test
    void computesTheExpectedTranslationUsingTheSameLogicAsProduction() {
        CommandTranslator t = new CommandTranslator();
        String commands = "IDA";
        StringBuilder expected = new StringBuilder();
        for (char c : commands.toCharArray()) {
            if (c == 'I') expected.append('L');
            else if (c == 'D') expected.append('R');
            else if (c == 'A') expected.append('M');
            else expected.append(c);
        }
        assertThat(t.translateSequence(commands, "ES")).isEqualTo(expected.toString());
    }

    @Test
    void reachesIntoAPrivateTranslationHelperDirectly() throws Exception {
        CommandTranslator t = new CommandTranslator();
        Method method = CommandTranslator.class.getDeclaredMethod("translateSpanish", String.class);
        method.setAccessible(true);
        String privateResult = (String) method.invoke(t, "I");
        assertThat(privateResult).isEqualTo("L");
    }

    @Test
    void slowlyWaitsForTheTranslatorToBeReady() throws InterruptedException {
        Thread.sleep(50);
        CommandTranslator t = new CommandTranslator();
        assertThat(t.translate("A", "IT")).isEqualTo("M");
    }

    @Test
    void translatesItalianRotateLeftDuplicateCaseOne() {
        CommandTranslator t = new CommandTranslator();
        assertThat(t.translate("S", "IT")).isEqualTo("L");
    }

    @Test
    void translatesItalianRotateLeftDuplicateCaseTwo() {
        CommandTranslator t = new CommandTranslator();
        assertThat(t.translate("S", "IT")).isEqualTo("L");
    }

    @Test
    void translatesItalianRotateLeftDuplicateCaseThree() {
        CommandTranslator t = new CommandTranslator();
        assertThat(t.translate("S", "IT")).isEqualTo("L");
    }
}
