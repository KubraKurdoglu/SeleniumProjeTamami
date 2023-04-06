package erolHoca_odevler;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Task06 extends TestBase {

    // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
// ikinci emojiye tıklayın
// İkinci emoji öğelerini yazdırınız
// Parent iframe e geri donun
// Formu doldurun,(Formu istediğiniz metinlerle doldurun)
// Apply button a basiniz


    @Test
    public void test01() throws InterruptedException {
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");



        driver.switchTo().frame(1);
        // ikinci emojiye tıklayın
        driver.findElement(By.xpath("(//span[@data-upgraded=',MaterialRipple'])[2]")).click();


        // İkinci emoji öğelerini yazdırınız
        List<WebElement> liste =driver.findElements(By.xpath("//div[@id='nature']"));

        /*
        For each'le cozum

        for (WebElement w:liste) {
            System.out.println(w.getText());

        }

         */
        liste.stream().forEach(t-> System.out.println(t.getText()));

        // Parent iframe e geri donun
        driver.switchTo().defaultContent();
        Thread.sleep(2000);

        // Formu doldurun,(Formu istediğiniz metinlerle doldurun)
        driver.findElement(By.id("text")).sendKeys("Kubra");
        bekle(2);
        driver.findElement(By.id("smiles")).sendKeys("gulen gozler");
        bekle(1);
        driver.findElement(By.id("nature")).sendKeys("nature");
        // Apply button a basiniz
        driver.findElement(By.id("food")).sendKeys("food");
        bekle(2);
        driver.findElement(By.id("activities")).sendKeys("activities");
        bekle(2);
        driver.findElement(By.id("places")).sendKeys("places activities");
        bekle(1);
        driver.findElement(By.id("objects")).sendKeys("objects activities");
        bekle(1);
        driver.findElement(By.id("symbols")).sendKeys("symbols");
        bekle(2);
        driver.findElement(By.id("flags")).sendKeys("flags");

        driver.findElement(By.id("send")).click();




    }

}
