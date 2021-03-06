package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Home extends Page {

    public Home(WebDriver driver) {
        super(driver);

        // Check that we're on the right page.
        if (!"PROJET AMT 2018".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the correct page, you're on: " + driver.getCurrentUrl());
        }
    }

}
