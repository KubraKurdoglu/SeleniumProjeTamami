package erolHoca_odevler;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Task07 extends TestBase {
    /*
        - http://szimek.github.io/signature_pad/ sayfasına gidiniz
        - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        - Çizimden sonra clear butonuna basınız
        - Sayfayi kapatiniz
     */

    @Test
    public void test01(){

        driver.get("http://szimek.github.io/signature_pad/");
        WebElement yaziTahtasi = driver.findElement(By.xpath("//canvas"));
        Actions actions = new Actions(driver).clickAndHold(yaziTahtasi);

        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(-5,-5);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(0,5);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(5,0);
        }
        actions.release().build().perform();

        /*
        //- http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

        //        - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.xpath("//canvas[@width='1328']"));


        actions.clickAndHold(source).
                moveByOffset(388,34).clickAndHold(source).
                moveByOffset(50,100).moveByOffset(90,78).release().build().perform();



         */


        //        - Çizimden sonra clear butonuna basınız
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        bekle(3);

        //        - Sayfayi kapatiniz
        //driver.quit();


    }

}
