package selenium.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewApp extends Page {

    By tfNewAppNameLocator = By.id("newAppName");
    By tfNewAppDescLocator = By.id("newAppDesc");
    By bNewAppSubmitLocator = By.id("newAppSubmit");


    public NewApp(WebDriver driver) {
        super(driver);

        // Check that we're on the right page.
        if (!"New application".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the correct page, you're on: " + driver.getCurrentUrl());
        }
    }
    public NewApp typeAppName() {
        Faker faker = new Faker();
        String name = faker.book().title();
        driver.findElement(tfNewAppNameLocator).sendKeys(name);
        return this;
    }

    public NewApp typeAppDescription(int descSize) {
        Faker faker = new Faker();
        String desc = "";
        for (int i = 0; i < descSize; ++i){
            desc += (faker.lorem().word() + " ");
        }
        driver.findElement(tfNewAppDescLocator).sendKeys(desc);
        return this;
    }

    public Page submitForm(Class<? extends Page> expectedPageClass) {
        driver.findElement(bNewAppSubmitLocator).click();
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
