package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Iframe_Test {
    private WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void iframeTest1(){
        driver.get("http://the-internet.herokuapp.com/iframe");
        //iframe'e gecis yapalim
        //index ile gecis yapalim
        driver.switchTo().frame(0);
        //iframe'i bulalim
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear(); // eski yaziyi silelim
        paragraf.sendKeys("Merhaba iframe"); // yazisini gonderelim
    }
    @Test
    public void iframeTest2(){
        driver.get("http://the-internet.herokuapp.com/iframe");
        //id attribute kullanarak gecis yapalim, string olarak
        driver.switchTo().frame("mce_0_ifr");
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear(); // eski yaziyi silelim
        paragraf.sendKeys("Merhaba iframe"); // yazisini gonderelim

    }
    @Test
    public void iframeTest3(){
        driver.get("http://the-internet.herokuapp.com/iframe");
        //iframe'e webelement ile gecis yapalim
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear(); // eski yaziyi silelim
        paragraf.sendKeys("Merhaba iframe"); // yazisini gonderelim
    }
    @Test
    public void iframeTest4(){
        driver.get("http://the-internet.herokuapp.com/iframe");
        //iframe'e gecis yapalim
        //index ile gecis yapalim
        driver.switchTo().frame(0);
        //iframe'i bulalim
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear(); // eski yaziyi silelim
        paragraf.sendKeys("Merhaba iframe"); // yazisini gonderelim

        //iframe'den cikis yapalim ve sayfaya gecis yapalim ve sayfada bir islem yapalim
        //iframe'den cikis yapmak icin 2 yontem var
        //1)driver.switchTo().defaultContent();
        driver.switchTo().defaultContent();// iframe'den cikis yaptik
        driver.switchTo().parentFrame();
        WebElement seleniumLink = driver.findElement(By.partialLinkText("Elemental Selenium"));
        seleniumLink.click();
    }
}
