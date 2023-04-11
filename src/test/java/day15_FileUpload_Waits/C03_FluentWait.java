package day15_FileUpload_Waits;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class C03_FluentWait extends TestBase {

            /*
        https://the-internet.herokuapp.com/dynamic_loading/1
        Start buttonuna tıklayın
        Hello World! Yazının sitede oldugunu test edin
         */

    @Test
    public void fluentWaitTest(){

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");


        //        Start buttonuna tıklayın
        driver.findElement(By.xpath("//div[@id='start']/button")).click();

        //        Hello World! Yazının sitede oldugunu test edin
        //buranin bir onceki class'tan tek farki "wait" objesini olusturuken bazi kurallar konulacak olmasi.
        //Fulent wait'in Explicit wait'ten(WebDriverWait'ten) farki "wait" objesinin olusturulmasinda ortaya cikar.
        //Fluent wait'te bir explicit wait'tir, ozel durumlarda kullanilir.


        Wait<WebDriver> wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(30)).//Max bekleme süresi
                        pollingEvery(Duration.ofSeconds(3)).//Deneme aralıkları: Her 3 saniyede bir bulma denemesi yapar
                        withMessage("Ignore Exception").//Mesaj yazdırılabilir: Zorunlu değil.
                        ignoring(TimeoutException.class);//Exception handle edilebilir: zorunlu değil.


        //20 saniyeye kadar her ucer saniyede bir bu bekleme suresi burda olacak
        //toplmada 20 saniyeye kadar, ucer saniyelik aralilarla elementi bulmaya calisacak
        WebElement helloWorldText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));

        assertTrue(helloWorldText.isDisplayed());




    }

}
