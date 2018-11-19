package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Admin extends Page {

    By tfPagesLocator = By.id("pagesNumbers");
    By bPreviousLocator = By.id("Previous");
    By bNextLocator = By.id("Next");


    public Admin(WebDriver driver) {
        super(driver);

        // Check that we're on the right page.
        if (!"Admin page".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the correct page, you're on: " + driver.getCurrentUrl());
        }
    }

    public String numberOfPages(){
        return driver.findElements(tfPagesLocator).get(driver.findElements(tfPagesLocator).size() -1).getText();
    }

}
