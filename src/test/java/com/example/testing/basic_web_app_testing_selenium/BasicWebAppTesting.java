package com.example.testing.basic_web_app_testing_selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class BasicWebAppTesting {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the path of the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testHomePageTitle() {
        // Navigate to the web application
        driver.get("https://demo.seleniumeasy.com");

        // Get the title of the web page
        String title = driver.getTitle();

        // Assert the title
        assertEquals("Selenium Easy - Best Demo website to practice Selenium Webdriver Online", title);
    }

    @Test
    public void testSingleInputField() {
        // Navigate to the Simple Form Demo page
        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");

        // Find the input field and enter a message
        WebElement messageField = driver.findElement(By.id("user-message"));
        messageField.sendKeys("Hello Selenium!");

        // Find and click the 'Show Message' button
        WebElement showMessageButton = driver.findElement(By.cssSelector("button[onclick='showInput();']"));
        showMessageButton.click();

        // Get the displayed message
        WebElement displayedMessage = driver.findElement(By.id("display"));

        // Assert the message
        assertEquals("Hello Selenium!", displayedMessage.getText());
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}

