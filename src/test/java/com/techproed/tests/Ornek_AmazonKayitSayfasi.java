package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ornek_AmazonKayitSayfasi extends TestBase {
    //1) Mouse'u moveToElement() method'unu kullanarak Account & Lists webelementinin
    // uzerine goturun
    //2) 'Start here' linkine tiklayin
    @Test
    public void test01(){
        driver.get("http://amazon.com");
        WebElement webElement = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        //mouse'u webelemtin zerine gotrelim..
        actions.moveToElement(webElement);
        //xpath==> //*[.='Start here.'] seklinde de burayu bulabiliriz
        WebElement startHereLink = driver.findElement(By.partialLinkText("Start here."));
        startHereLink.click();
        //3.Adim: sayfanin title'i Amazon Registration ise testiniz basarili olsun.
        //assertTrue ile ==> Assert.assertTrue("driver.getTitle().equals("Amazon Registration")
        //assertFalse ile ==> Assert.assertFalse("!driver.getTitle().equals("Amazon Registration"));
        //assertEquals ile
        Assert.assertEquals(driver.getTitle(), "Amazon Registration");
    }
    @Test (dependsOnMethods = "test01")
    public void test02(){
        WebElement isim = driver.findElement(By.id("ap_customer_name"));
        isim.sendKeys("Fatma Yasar");
        driver.findElement(By.id("ap_email")).sendKeys("ftmysr0905@gmail.com");
        driver.findElement(By.id("ap_password")).sendKeys("Fy001369.");
        driver.findElement(By.id("ap_password_check")).sendKeys("Fy001369.");
        driver.findElement(By.id("continue")).click();


    }
}
