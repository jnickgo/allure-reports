package com.nipr;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Epic("Identify Applicant")
@Feature("Identify Individual")
public class StepsTest {

    private String lastName = "Jones";
    private String taxNum = "023-32-0112";

    @BeforeEach
    public void setUp() {
        Configuration.browser = "firefox";
    }

    @Step("Navigate to the landing page")
    public void navigateToLandingPage() {

        open("https://pdb.nipr.com/my-nipr/frontend/identify-licensee");
    }

    @Step("Enter Last Name and Tax Number")
    public void enterLastNameAndTaxNum() {

        $("#root > div > main > div.PanelBody-sc-1h1ua0r-0.panel-body.ktmuOZ > div > div:nth-child(1) > button").click();
        $("input[value='TAX_ID']").click();
        $("#lastName").sendKeys(lastName);
        $("#ssn").sendKeys(taxNum);
    }

    @Step("Accept User Agreement")
    public void acceptAggreement() {

        $(By.name("useAgreementAccepted")).click();
    }

    @Story("Login with Valid Last Name and Tax Num")
    @Test
    public void loginWithValidLastNameAndTaxNum() {

        navigateToLandingPage();
        enterLastNameAndTaxNum();
        acceptAggreement();
    }



}
