package day13_ActionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C03_Actions03 extends TestBase {
          /*
        https://techproeducation.com adresine gidin
         Sayfanın alt tarafına gidin
         Sayfanın üst tarafına gidin
         */

    @Test
    public void actionsTest(){
        //https://techproeducation.com adresine gidin
        driver.get("https://techproeducation.com ");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklami kapatmak icin

        //         Sayfanın alt tarafına gidin
        Actions actions = new Actions(driver);

        bekle(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        bekle(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        bekle(2);
        actions.sendKeys(Keys.ARROW_DOWN).perform();//bu yukardakinden daha az asagi aliyor
        bekle(2);
        actions.sendKeys(Keys.ARROW_DOWN).perform();//perform uygulamazsan actions calismaz.

    //Bu yukardakileri iki kere yapmasinin nedeni, bir kere PAGE_DOWN veya PAGE_UP yaptigin zaman
        //bir scroll miktarinca cikiyor yada iniyorsun, iki kere suruklemis oldu yani.

        //         Sayfanın üst tarafına gidin
        bekle(3);
        actions.sendKeys(Keys.PAGE_UP).perform();
        bekle(3);
        actions.sendKeys(Keys.ARROW_UP).perform();

    }

    @Test
    public void test02(){
        //Amazon anasayfasina gidiniz
        driver.get("https://www.amazon.com");

        //Arama kutusunda "s" harfi buyuk olacak sekilde Samsung yazisi aratalim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchthebox"));
        aramaKutusu.sendKeys(Keys.SHIFT, "s", "a", Keys.SHIFT, "msung" , Keys.ENTER);//SAmsung

        //Birinci sefer Shift'e basista, Shift'ten ikinci kez yazarak kaldirmadigimiz muddetce
        //Shift'e basili kalacaktir.

    }
}
