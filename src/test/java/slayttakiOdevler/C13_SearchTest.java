package slayttakiOdevler;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C13_SearchTest extends TestBase {

    /*
    1. https://www.amazon.com/ sayfasina gidelim 2. arama kutusunu locate edelim
    3. “Samsung headphones” ile arama yapalim 4. Bulunan sonuc sayisini yazdiralim
    5. Ilk urunu tiklayalim
    6. Sayfadaki tum basliklari yazdiralim
     */
    @Test
    public void test01(){

        //1. https://www.amazon.com/ sayfasina gidelim
        driver.navigate().to("https://www.amazon.com/");

        // 2. arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        //3. “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);

        // 4. Bulunan sonuc sayisini yazdiralim
        WebElement sonucSayisi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucSayisi.getText().split(" "));

        //5. Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

        //6. Sayfadaki tum basliklari yazdiralim

        //driver.findElements(By.tagName("h1")).forEach(t-> System.out.println(t.getText()));
        List<WebElement> basliklar=driver.findElements(By.tagName("h1"));
        for (WebElement w: basliklar){

            System.out.println(w.getText());
        }

    }
}
