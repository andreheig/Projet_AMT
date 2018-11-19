package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Dev extends Page {

    By tfPagesLocator = By.id("pagesNumbers");
    By bNewAppLocator = By.id("newApp");
    By bPreviousLocator = By.id("Previous");
    By bNextLocator = By.id("Next");

    public Dev(WebDriver driver) {
        super(driver);

        // Check that we're on the right page.
        if (!"Applications".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the correct page, you're on: " + driver.getCurrentUrl() + " with title: " + driver.getTitle());

        }
    }

    public String numberOfPages(){

        return driver.findElements(tfPagesLocator).get(driver.findElements(tfPagesLocator).size() -1).getText();
    }

    public Page createApplication(Class<? extends Page> expectedPageClass) {
        driver.findElement(bNewAppLocator).click();
        Page targetPage = null;
        try {
            targetPage = expectedPageClass.getConstructor(WebDriver.class).newInstance(driver);
        } catch (Exception ex) {
            Logger.getLogger(Page.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Exception when using reflection: " + ex.getMessage());
        }
        return targetPage;
    }

    public Page PreviousNavigation(Class<? extends Page> expectedPageClass) {
        driver.findElement(bPreviousLocator).click();
        Page targetPage = null;
        try {
            targetPage = expectedPageClass.getConstructor(WebDriver.class).newInstance(driver);
        } catch (Exception ex) {
            Logger.getLogger(Page.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Exception when using reflection: " + ex.getMessage());
        }
        return targetPage;
    }

    public Page NextNavigation(Class<? extends Page> expectedPageClass) {
        driver.findElement(bNextLocator).click();
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
