package com.automation.tests;

import com.automation.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AlertTests extends BaseTest {
    private static final String ALERT_URL = "https://demo.automationtesting.in/Alerts.html";
    private static final String FULL_NAME = "Didro Sharashidze";

    @Test(description = "Test alert with text input and verify submitted text")
    public void testAlertWithTextInput() {
        driver.get(ALERT_URL);

        // Wait for page to load and select the alert with textbox tab
        WebElement alertTab = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[contains(text(), 'Alert with Textbox')]")
                )
        );
        alertTab.click();

        // Wait for the button to appear and click it
        WebElement triggerAlertBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("promptButton")
                )
        );
        triggerAlertBtn.click();

        // Wait for alert to be present and switch to it
        org.openqa.selenium.Alert alert = wait.until(
                ExpectedConditions.alertIsPresent()
        );

        // Send the name and surname to the alert
        alert.sendKeys(FULL_NAME);

        // Accept the alert
        alert.accept();

        // Wait for the result message to appear
        WebElement resultElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.id("demo1")
                )
        );

        // Verify that the text we sent is displayed in the result
        String resultText = resultElement.getText();
        assertEquals(resultText, FULL_NAME, 
                "Result should contain the name provided in the alert");

        // Additional assertion to ensure result is not empty
        assertTrue(resultElement.isDisplayed(), "Result element should be visible");
    }
}
