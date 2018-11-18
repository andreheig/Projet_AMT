package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Login extends Page {

    By tfEmailLocator = By.id("loginEmail");
    By tfPasswordLocator = By.id("loginPassword");
    By bSigninLocator = By.id("loginSubmit");

    public Login(WebDriver driver) {
        super(driver);

        // Check that we're on the right page.
        if (!"Log-in AMT 2018".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the correct page, you're on: " + driver.getCurrentUrl());
        }
    }

    public Login typeEmailAddress(String email) {
        driver.findElement(tfEmailLocator).sendKeys(email);
        return this;
    }

    public Login typePassword(String password) {
        driver.findElement(tfPasswordLocator).sendKeys(password);
        return this;
    }

    public Page submitForm(Class<? extends Page> expectedPageClass) {
        driver.findElement(bSigninLocator).click();
        Page targetPage = null;
        try {
            targetPage = expectedPageClass.getConstructor(WebDriver.class).newInstance(driver);
        } catch (Exception ex) {
            Logger.getLogger(Page.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Exception when using reflection: " + ex.getMessage());
        }
        return targetPage;
    }

    public Page submitFormExpectingFailure() {
        driver.findElement(bSigninLocator).click();
        return this; //new LoginPage(driver);
    }
}
