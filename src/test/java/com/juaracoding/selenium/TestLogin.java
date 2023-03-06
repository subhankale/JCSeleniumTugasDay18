package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestLogin {
    WebDriver driver;
    @BeforeClass
    public void  setUp(){
        System.setProperty("webdriver.chrome.driver", "c:\\juaracoding\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String url = "https://shop.demoqa.com/my-account/";
        driver.get(url);
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");
    }

    @Test(priority = 1)
    public void testInvalidLogin(){
        delay(1);
        //step action
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Subhan");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Subhanbule88");
        driver.findElement(By.xpath("//button[@name='login']")).click();
        //step veryfy
        String txtInvalidLogin = driver.findElement(By.xpath("//ul[@role='alert']")).getText();
        Assert.assertEquals(txtInvalidLogin,"ERROR: The username or password you entered is incorrect. Lost your password?");
    }

    @Test(priority = 2)
    public void testValidLogin(){
        //step action
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Subhan");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Subhanbule8");
        driver.findElement(By.xpath("//button[@name='login']")).click();
        //step veryfy
        String txtInvalidLogin = driver.findElement(By.xpath("//ul[@role='alert']")).getText();
        Assert.assertEquals(txtInvalidLogin,"Dashboard");
    }


    @AfterClass
    public  void quitBrowser(){
        delay(3);
        driver.quit();
        System.out.println("Quit Browser");
    }
    static  void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}