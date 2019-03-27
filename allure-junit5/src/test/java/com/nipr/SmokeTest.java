package com.nipr;

import com.codeborne.selenide.Config;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Attachment;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

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
    @Attachment(value = "PageScreenshot", type = "image/png")
    public void smokeTestAsBlocker() {
        Configuration.browser = "firefox";
        String expectedTitle = "Identify Licensee - My NIPR";
        open("https://pdb.nipr.com/my-nipr/frontend/identify-licensee");
        Assertions.assertEquals(expectedTitle, title());
        screenshot("PageScreenshot");

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
