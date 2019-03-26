package com.nipr;

import io.qameta.allure.Attachment;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Nick Gover
 */
public class SmokeTest
{

    /**
     *
     */
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Attachment(value = "Page screenshot", type = "image/png")
    public void smokeTestAsBlocker() {

    }

    /**
     *
     */
    @Test
    @Severity(SeverityLevel.TRIVIAL)
    public void smokeTestAsTrivial() {

    }

    /**
     *
     */
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void smokeTestAsCritical() {

    }

    /**
     *
     */
    @Test
    @Severity(SeverityLevel.MINOR)
    public void smokeTestAsMinor() {

    }

    /**
     *
     */
    @Test
    @Severity(SeverityLevel.NORMAL)
    public void smokeTestAsNormal() {

    }

}
