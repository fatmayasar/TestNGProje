package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssert_Test {
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }@Test
    public void test1(){
        driver.get("http://amazon.com");
        String baslik = driver.getTitle();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertFalse(baslik.contains("Amazon"));
        softAssert.assertTrue(baslik.contains("Car"));
        softAssert.assertEquals("online", baslik);
        //Bu haliyle test edersek testimiz passed olur ama 3 tane testin 2 si yanlis aslinda
        //ama 1i dogru olunca digerlerini de passed yapiyor.
        //Buna engel olmak icin softAssert.assertAll() methodunu kullanalim

        softAssert.assertAll();
        //bu durumda testlerin tumu basarili ise ancak testimiz passed olur

    }
    @Test
    public void test02(){

        driver.get("http://a.testaddressbook.com/sign_in");
        SoftAssert softAssert = new SoftAssert();

        WebElement emailKutusu = driver.findElement(By.id("session_email"));
        emailKutusu.sendKeys("testtechproed@gmail.com");

        WebElement sifreKutusu = driver.findElement(By.id("session_password"));
        sifreKutusu.sendKeys("Test1234!");

        WebElement signInButton = driver.findElement(By.name("commit"));
        signInButton.click();

        WebElement sigOutLinki = driver.findElement(By.partialLinkText("Sign Out"));
        boolean gorunuyorMu = sigOutLinki.isDisplayed();

        softAssert.assertAll();//kesinlikle olmali
                               //ayni hardAssert'taki gibi(Assert.assertTrue())



    }

}
