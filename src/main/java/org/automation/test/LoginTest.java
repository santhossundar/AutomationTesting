package org.automation.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    private WebDriver driver;
    private String url = "https://demo.guru99.com/insurance/v1/index.php";
    private String email = "xanesa1387@larland.com";
    private String password = "Password123";

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void login(){
        driver.get(url);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.name("submit")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"content\"]//h4")));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class=\"content\"]//h4")).getText(), email);
    }

    @AfterTest
    public void teardown(){
        driver.close();
        driver.quit();
    }
}
