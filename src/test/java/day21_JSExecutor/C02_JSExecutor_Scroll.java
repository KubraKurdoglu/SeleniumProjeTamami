package day21_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JSExecutor_Scroll extends TestBase {
    /*
    Techpro education ana sayfasına git
    "We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
    Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
    Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
    Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
     */

    JavascriptExecutor js;
    @Test
    public void jsExecutorScrollTest() throws InterruptedException {


        //Techpro education ana sayfasına git
        driver.navigate().to("https://www.techproeduvation.com");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();



        //    "We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        WebElement weOffer = driver.findElement(By.xpath("//*[text()='we offer']"));
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", weOffer);
        Thread.sleep(2000);



        //    Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement enrollFree = driver.findElement(By.xpath("//*[text()='Enroll Free Course']"));
        /*
        js = (JavascriptExecutor) driver;
        js.executeAsyncScript("arguments[0].scrollIntoView(true);", enrollFree);
         */

        //Bu yukarda, yorum icindeki kod yerine, asagidaki methodu kullanabiliriz
        scrollIntoView(enrollFree);
        tumSayfaResmi();

        //    Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement whyUs=driver.findElement(By.xpath("//*[text()='WHY US?']"));
        scrollIntoView(whyUs);
        bekle(2);
        tumSayfaResmi();


        //    Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        scrollIntoView(enrollFree);
        tumSayfaResmi();



        //Sayfawi en alta scroll yapalim
        //"document.body"==> sayfanin tamami demek
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight");

        //bunu yerine asagidaki methodu da kullanabilirisin
        //scrollEnd();


        //Sayfayi  en uste scroll yapalim
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight");

        //bunun yerine asagidaki emthodu da kullanabiliriz
        //scrollHome();


    }





    //js.executeScript("window.scrollTo(0,-500)");
}
