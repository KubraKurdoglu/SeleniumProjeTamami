package day11_Alert_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class C01_IFrame extends TestBase {

    //testBase class'indaki implicitly wait, driver'i her kullanisimizda, etkili oluyor

            /*
        https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        Kalın yazının "Editor" kelimesimi içerdiğini doğrulayınız
        Textbox içindeki yazıyı siliniz.
        Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
         */

    @Test
    public void iFrame01(){
        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");


        //        Kalın yazının "Editor" kelimesimi içerdiğini doğrulayınız
        String sayfaBaslik = driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
        //gettext() kullandi cunku String'e cevirip kontrol edebilir
        assertTrue(sayfaBaslik.contains("Editor"));//Editor icerdigi icin test gececk



        //driver.findElement(By.xpath("//p[.='Your content goes here.']")).clear();
        //bu bir webelementi oldugu icin direk clear methodu ile silebilirsin
        //yada bir webelementine atipta silebilirsin, bu daha cok tavsiye edilir


        // "NoSuchElement" hatasi  almamak icin , once IFrame ye gitmelisin
        //baska bir "iFrame", once iframe gitmelisin


        WebElement iFrame = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrame);
        //driver.switchTo().frame(0);==> bu sekilde de yazilabilir.


        //        Textbox içindeki yazıyı siliniz.
        WebElement textBox = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        textBox.clear();



        //        Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");


        //        Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        //WebElement defaultpage(varsayilan pencere) icinde oldugu icin once driver'i iFrame disina
        //yani sayfamiza almaliyiz
        driver.switchTo().parentFrame();

        WebElement elementalSelenium = driver.findElement(By.linkText("Elemental Selenium"));
        assertTrue(elementalSelenium.isDisplayed());

    }
}
