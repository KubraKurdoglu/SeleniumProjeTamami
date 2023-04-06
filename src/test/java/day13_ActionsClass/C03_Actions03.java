package day13_ActionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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



        //         Sayfanın üst tarafına gidin
        bekle(3);
        actions.sendKeys(Keys.PAGE_UP).perform();
        bekle(3);
        actions.sendKeys(Keys.ARROW_UP).perform();

    }
}
