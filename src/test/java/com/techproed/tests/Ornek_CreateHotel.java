package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ornek_CreateHotel extends TestBase {
    /*
    1-Bir method olusturun:createHotel
    2-http://www.fhctrip-qa.com/admin/HotelAdmin/Create adresine gidin
    3-Username textbox ve password metin kutularini locate edin ve asagidaki verileri girin
      a) Username:manager2
      b) Password:Man1ager2!
    4-Login butonun tiklayin
    5-Acilan sayfadaki tum metin kutularina istediginiz verileri girin
      (en sondaki dropdown'a dikkat edin)
    6-save butonuna tiklayin
    7-"Hotel was inserted succesfully" textinin gorundugunu dogrulayin
    8-OK butonuna tiklayin

     */
    @BeforeMethod
    public void giris(){
        driver.get("http://www.fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);

    }
    @Test
    public void hitelCreate(){
        WebElement code = driver.findElement(By.id("Code"));
        WebElement name = driver.findElement(By.id("Name"));
        WebElement address = driver.findElement(By.id("Address"));
        WebElement phone = driver.findElement(By.id("Phone"));
        WebElement email = driver.findElement(By.id("Email"));
        WebElement idGroup = driver.findElement(By.id("IDGroup"));
        WebElement save = driver.findElement(By.id("btnSubmit"));

        code.sendKeys("12345");
        name.sendKeys("fy");
        address.sendKeys("Istanbul");
        phone.sendKeys("123456789");
        email.sendKeys("fy@gmail.com");

        Select select = new Select(idGroup);
        select.selectByIndex(2);

        save.click();

        //WebElement basariliYazisi = driver.findElement(By.className("bootbox-body"));
        //Bu durumda hata aliriz cunku beklenen  yaziyi goremedik bunu gorebilmek icin expilicitWait koymamiz lazim

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement basariliYazisi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));

        Assert.assertTrue(basariliYazisi.isDisplayed());




    }


}
