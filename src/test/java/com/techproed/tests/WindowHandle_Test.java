package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandle_Test extends TestBase {

    @Test
    public void cokluPencereTest(){
        driver.get("https://the-internet.herokuapp.com/windows");
        String sayfaninHandle = driver.getWindowHandle();
        System.out.println(sayfaninHandle);
        driver.findElement(By.partialLinkText("Click Here")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> tumPenceler = driver.getWindowHandles();
        for(String handle : tumPenceler){
            System.out.println(handle);
        }
        //son sayfanin handle alalim
        String sonSayfaHandle = (String)((tumPenceler.toArray())[tumPenceler.size()-1]);
        System.out.println(sonSayfaHandle);

        //array[0]
        //tumPenceler.toArray()
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object[] array = (Object []) tumPenceler.toArray();
        String ikinciSayfaHandle = array[array.length-1].toString();
        System.out.println(ikinciSayfaHandle);
        //driver.switchTo().window(istedigimiz sayfa);  ya gidebiliriz
        driver.switchTo().window(sayfaninHandle);

    }
}
