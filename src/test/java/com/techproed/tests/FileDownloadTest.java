package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadTest extends TestBase {
    @Test
    public void dosyaVarMi(){
        //bulundugumuz dosyanin yolunu bulalim
        System.out.println(System.getProperty("user.dir"));

        //Dosyamizin ana klasorunu bulmak icin
        System.out.println(System.getProperty("user.home"));

        //Bir dosyanin  var olup olmadigini kontrol edelim
        String kullaniciDosyaYolu = System.getProperty("user.dir");
        String pomxmlDosyaYolu = kullaniciDosyaYolu + "/pom.xml";
        boolean varMi = Files.exists(Paths.get(pomxmlDosyaYolu));
        Assert.assertTrue(varMi);

    }
    @Test
    public void dosyaUpload(){
        //bilgisayardan websayfasina dosya yukleme
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement dosyaSecmeButonu =driver.findElement(By.id("file-upload"));

        //yuklemek istedigimiz dosyanin (path) dosya yolunu ekleyelim
        dosyaSecmeButonu.sendKeys("C:\\Users\\user\\Music");
        //upload butonunu bulup click yapalim ve dosyamizi yukeleyelim
        WebElement uploadButonu = driver.findElement(By.id("file-submit"));
        uploadButonu.click();
        WebElement fileUploadYazisi =driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadYazisi.isDisplayed());
    }
    @Test
    public void dosyaDownload(){
        driver.get("http://the-internet.herokuapp.com/download");
        WebElement amsterdamLinki = driver.findElement(By.partialLinkText("Amsterdam.jpg"));
        amsterdamLinki.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean varMi = Files.exists(Paths.get("C:/Users/user/Downloads/Amsterdam.jpg"));
        Assert.assertTrue(varMi);
    }

}
