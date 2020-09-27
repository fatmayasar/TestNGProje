package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class ActionClassTest extends TestBase {
    @Test
    public void sagTiklama(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement element = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        //Bir webelemnt'e sag tiklamak icn bu kodu kullaniriz
        //actions class ile islem yaparsaniz  herseferinde "perform" yapmak zorundayiz
        actions.contextClick(element).perform();
    }
    @Test
    public void ciftTiklama(){
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        WebElement button = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
        //bir webelement'e 2 kere tiklamak icin
        Actions actions = new Actions(driver);
        actions.doubleClick(button).perform();
    }
    @Test
    public void hoverOver(){
        driver.get("http://amazon.com");
        WebElement menu = driver.findElement(By.id("nav-lisk-accountList"));
        //mouse'u istedigimiz webelemente goturmek icin
        Actions actions = new Actions(driver);
        actions.moveToElement(menu).perform();
    }
    @Test
    public void asagiYukari(){
        driver.get("http://amazon.com");
        //mouse'u asagi yone kaydirmak icin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actions.sendKeys(Keys.END).perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actions.sendKeys(Keys.PAGE_UP).perform();

    }


}
