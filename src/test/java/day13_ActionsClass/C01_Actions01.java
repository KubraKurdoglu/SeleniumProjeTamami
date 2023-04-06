package day13_ActionsClass;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.*;

public class C01_Actions01 extends TestBase {
            /*
        https://the-internet.herokuapp.com/context_menu  sitesine gidin
        Kutuya sağ tıklayın
        Alert'te cikan yazinin "You selected a context menu" oldugunu test edin
        Tamam diyerek alert'i kapatın
         */

    @Test
    public void actionsTest(){

        //https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //        Kutuya sağ tıklayın

        //Sag tiklayabilmek icin contextClick() methoduna ihtiyacimiz var
        //bunun icin Action objesi olusturamay ihtiyacimiz var

        //Kutuya sag tiklayabilmek icin once bir Action objesi olusturmak gerkiyor
        //1.Adim: Actions objesi olustur
        Actions actions = new Actions(driver);

        //2.Adim:
        WebElement kutu = driver.findElement(By.id("hot-spot"));

        //3.Adim: Islemi Uygulayin
        actions.contextClick(kutu).perform();

        //ici bos olan click() ve diger uygulamalar bir onceki islemden devam etmek icin kullaniliyor

        //        Alert'te cikan yazinin "You selected a context menu" oldugunu test edin
        String alertYazisi = driver.switchTo().alert().getText();
        assertEquals("You selected a context menu", alertYazisi);

        //        Tamam diyerek alert'i kapatın

        driver.switchTo().alert().accept();
    }
}
