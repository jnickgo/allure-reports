package com.nipr.types;

import io.qameta.allure.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Nick Gover
 */
@Epic("Verify Numbers")
@Feature("First Number equals One")
@Severity(SeverityLevel.NORMAL) // you can apply the severity level to all test methods in a class.
public class FlakyTest {

    private int firstNumber = 1;

    @Tag("flaky")
    @Flaky
    @Test
    public void sometimesThisTestIsFlaky() {

        assertEquals(2, firstNumber, "Number doesn't match.");
    }

    @Tag("flaky")
    @Flaky
    @Test
    public void sometimesThisTestIsNotFlaky() {

        assertEquals(1, firstNumber, "Number doesn't match.");
    }
}
