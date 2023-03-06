package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestAddCart {
    WebDriver driver;
    String pathChromeDriver = "C:\\juaracoding\\chromedriver.exe";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", pathChromeDriver);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String url = "https://shop.demoqa.com/product/";
        driver.get(url);
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");
    }
    @AfterClass
    public void quitBrowser() {
        delay(3);
        driver.quit();
        System.out.println("Quit Browser");
    }

    @Test
    public  void testAddProduct() {
        delay(1);
        //step action
        driver.findElement(By.cssSelector(".custom-logo:nth-child(1)")).click();
        driver.findElement(By.cssSelector(".post-1491 h3 > a")).click();
        driver.findElement(By.id("pa_color")).click();
        {
            WebElement dropdown = driver.findElement(By.id("pa_color"));
            dropdown.findElement(By.xpath("//option[. = 'Grey']")).click();
        }
        driver.findElement(By.id("pa_size")).click();
        {
            WebElement dropdown = driver.findElement(By.id("pa_size"));
            dropdown.findElement(By.xpath("//option[. = '42']")).click();
        }
        driver.findElement(By.cssSelector(".icon_plus")).click();
        driver.findElement(By.cssSelector(".single_add_to_cart_button")).click();
        driver.findElement(By.linkText("View cart")).click();
    }

    static  void delay(long detik) {
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
