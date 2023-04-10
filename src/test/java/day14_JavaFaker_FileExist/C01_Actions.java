package day14_JavaFaker_FileExist;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {

            /*
        "https://techproeducation.com/" gidin
        İlk kelime SHIFT tuşuna basılı şekilde, ikinci kelime basılmadan "TECHPRO education" araması yapın.
         */

    @Test
    public void actionTest(){
       // "https://techproeducation.com/" gidin
        driver.get("https://techproeducation.com/");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//Reklami kapatmak icin
       // İlk kelime SHIFT tuşuna basılı şekilde, ikinci kelime basılmadan "TECHPRO education" araması yapın.

        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@name='s']"));

        Actions actions = new Actions(driver);

        actions.
                keyDown(aramaKutusu, Keys.SHIFT).//Arama kutusu üzerinde SHIFT tuşuna basılı tut
                sendKeys("techpro").//SHIFT basılı şekilde "techpro" yazısını gönder
                keyUp(Keys.SHIFT).//SHIFT tuşuna basma işlemini sonlandır
                sendKeys(" education"+Keys.ENTER).//SHIFT tuşuna basmadan "education" kelimesini yolla ve ENMTER tuşuna bas.
                build().
                perform();
        //aramaKUtusu' na gel shift'e bas, "techpro" yu gonder, shift'ten kaldirmak icin de "Keys.Up" yapiyoruz
    }
}
