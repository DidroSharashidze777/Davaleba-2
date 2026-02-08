package com.automation.tests;

import com.automation.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FormTests extends BaseTest {
    private static final String FORM_URL = "https://demoqa.com/automation-practice-form";

    @Test(description = "Test filling practice form and verifying submission")
    public void testFormFillAndSubmit() {
        driver.get(FORM_URL);

        // Fill First Name
        WebElement firstNameField = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("firstName"))
        );
        firstNameField.sendKeys("Didro");

        // Fill Last Name
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        lastNameField.sendKeys("Sharashidze");

        // Fill Email
        WebElement emailField = driver.findElement(By.id("userEmail"));
        emailField.sendKeys("didro.sharashidze@automation.com");

        // Select Gender - Male
        WebElement maleGender = driver.findElement(By.id("gender-radio-1"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", maleGender);

        // Fill Mobile Number
        WebElement mobileField = driver.findElement(By.id("userNumber"));
        mobileField.sendKeys("1234567890");

        // Fill Date of Birth (using JavaScript to set date)
        WebElement dateField = driver.findElement(By.id("dateOfBirthInput"));
        ((JavascriptExecutor) driver).executeScript(
                "document.getElementById('dateOfBirthInput').value = '01/01/1990';"
        );

        // Select Subjects
        WebElement subjectInput = driver.findElement(By.id("subjectsInput"));
        subjectInput.sendKeys("English");
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[@class='subjects-auto-complete__option'][contains(text(), 'English')]")
        )).click();

        // Select Hobbies - Sports
        WebElement sportsCheckbox = driver.findElement(By.id("hobbies-checkbox-1"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sportsCheckbox);

        // Fill Current Address
        WebElement addressField = driver.findElement(By.id("currentAddress"));
        addressField.sendKeys("123 Test Street, Test City, TC 12345");

        // Select State (using Select dropdown)
        WebElement stateInput = driver.findElement(By.id("state"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", stateInput);
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[@class='select-option'][contains(text(), 'NCR')]")
        )).click();

        // Select City
        WebElement cityInput = driver.findElement(By.id("city"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cityInput);
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[@class='select-option'][contains(text(), 'Delhi')]")
        )).click();

        // Submit Form
        WebElement submitBtn = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();

        // Verify Modal is displayed
        WebElement modal = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.className("modal-dialog"))
        );
        assertTrue(modal.isDisplayed(), "Modal should be displayed after form submission");

        // Verify submitted data in the modal
        String modalText = driver.findElement(By.className("modal-body")).getText();

        assertTrue(modalText.contains("Didro"), "First name should be in modal");
        assertTrue(modalText.contains("Sharashidze"), "Last name should be in modal");
        assertTrue(modalText.contains("didro.sharashidze@automation.com"), "Email should be in modal");
        assertTrue(modalText.contains("Male"), "Gender should be in modal");
        assertTrue(modalText.contains("1234567890"), "Mobile number should be in modal");
        assertTrue(modalText.contains("English"), "Subject should be in modal");
        assertTrue(modalText.contains("Sports"), "Hobbies should be in modal");
        assertTrue(modalText.contains("123 Test Street"), "Address should be in modal");
        assertTrue(modalText.contains("NCR"), "State should be in modal");
        assertTrue(modalText.contains("Delhi"), "City should be in modal");
    }
}
