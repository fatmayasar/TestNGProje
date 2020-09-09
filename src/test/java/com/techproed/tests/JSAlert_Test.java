package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSAlert_Test {
    private WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void jsAlertTest(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
    //  <button onclick="jsAlert()">Click for JS Alert</button>
        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        button.click();
        //karsimiza simple alert cikiyor
        //alert'e gecis yapalim ve uzrinde islem yapalim
        //alert'in icerdigi mesaji alalim ve ekrana yazdiralim
        //bunun icin getText() kullanilir
        String alertMesji = driver.switchTo().alert().getText();
        System.out.println(alertMesji);
        //alert'te OK butonuna tiklayip onaylayalim accept() methodu ile
        driver.switchTo().alert().accept();

    }
    @Test
    public void jsConfirmTest(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        //OK ve CANCEL butonu var
        //bottonu bulup tiklayalim
        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        button.click();

        String mesaj = driver.switchTo().alert().getText();
        System.out.println(mesaj);
        //CANCEL'e tiklayalim
        driver.switchTo().alert().dismiss();


    }
    @Test
    public void jsPromptTest(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        WebElement button = driver.findElement(By.xpath("//button[@oclick='jsPrompt']"));
        button.click();

        String mesaj = driver.switchTo().alert().getText();
        System.out.println(mesaj);

        driver.switchTo().alert().sendKeys("Merhaba TestNG");
        driver.switchTo().alert().accept();
    }
}
