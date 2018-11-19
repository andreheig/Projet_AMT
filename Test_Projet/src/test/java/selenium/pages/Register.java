package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Register extends Page {

    By tfFirstNameLocator = By.id("registerFirstName");
    By tfLastNameLocator = By.id("registerLastName");
    By tfEmailLocator = By.id("registerEmail");
    By tfPasswordLocator = By.id("registerPassword");
    By tfPassword2Locator = By.id("registerPassword2");
    By bRegisterLocator = By.id("registerSubmit");


    public Register(WebDriver driver) {
        super(driver);

        // Check that we're on the right page.
        if (!"Inscription".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the correct page, you're on: " + driver.getCurrentUrl());
        }

    }

    public Register typeFirstName(String firstName) {
        driver.findElement(tfFirstNameLocator).sendKeys(firstName);
        return this;
    }

    public Register typeLastName(String lastName) {
        driver.findElement(tfLastNameLocator).sendKeys(lastName);
        return this;
    }

    public Register typeEmailAddress(String email) {
        driver.findElement(tfEmailLocator).sendKeys(email);
        return this;
    }

    public Register typePassword(String password) {
        driver.findElement(tfPasswordLocator).sendKeys(password);
        return this;
    }

    public Register typePasswordConfirmation(String password) {
        driver.findElement(tfPassword2Locator).sendKeys(password);
        return this;
    }

    public Page submitForm(Class<? extends Page> expectedPageClass) {
        driver.findElement(bRegisterLocator).click();
        Page targetPage = null;
        try {
            targetPage = expectedPageClass.getConstructor(WebDriver.class).newInstance(driver);
        } catch (Exception ex) {
            Logger.getLogger(Page.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Exception when using reflection: " + ex.getMessage());
        }
        return targetPage;
    }

}
