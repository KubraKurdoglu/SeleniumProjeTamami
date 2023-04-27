package day_06_practice;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_ScreenShot extends TestBase {

    // https://www.teknosa.com/ adresine gidin
    // arama cubuguna oppo yazip enter'a basınız
    // sonuc yazısını yazdiriniz
    // ilk urunun fotografını cekin
    // cikan ilk urune tiklayiniz
    // sepete ekleyiniz butonu gorununceye kadar iki PAGE_DOWN sayfayı asagiya kaydirin
    // sepete ekleyiniz
    // sepetim'e git tilayiniz
    // "Siparis Ozeti" webelementinin text'ini yazdiriniz
    // Alisverisi tamamlayiniz
    // "Teknosa'ya hos geldiniz" webelementinin text'ini yazdiriniz

    @Test
    public void test01() throws IOException, InterruptedException {
        // https://www.teknosa.com/ adresine gidin
        driver.navigate().to("https://www.teknosa.com/");
        Thread.sleep(2000);

        try {
            driver.findElement(By.id("ins-editable-button-1580496494")).click();
        } catch (Exception e) {
            System.out.println("Cookies cikmadi yoluna devam et");;
        }
        bekle(3);

        // arama cubuguna oppo yazip enter'a basınız
      driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys("oppo", Keys.ENTER);


        // sonuc yazısını yazdiriniz
       WebElement sonucyazisi = driver.findElement(By.xpath("//div[@class='plp-panel-block1']"));
        System.out.println("Sonuc Yazisi :"+sonucyazisi.getText());

        // ilk urunun fotografını cekin

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMDDhhmmss");
        String tarih = date.format(dtf);
        WebElement ilkUrun = driver.findElement(By.xpath("(//a[@class='prd-link gowitPlp-js'])[1]"));

        File kayit = new File("target/ekranGoruntusuPractice/tumSayfa" +tarih+".jpeg");
        File geciciDosya = ilkUrun.getScreenshotAs(OutputType.FILE);

        //amacimiz gecici file dosyasina fotografi kaydetmek, sonra da tumsayfa dosyasina kaydetmek
        //onu da asagida yapiyoruz

        FileUtils.copyFile(geciciDosya, kayit);
        bekle(2);




        // cikan ilk urune tiklayiniz
        ilkUrun.click();
        bekle(2);

        // sepete ekleyiniz butonu gorununceye kadar iki PAGE_DOWN sayfayı asagiya kaydirin
        Actions actions = new Actions(driver);
        WebElement sepeteEkle = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        actions.clickAndHold().perform();
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        bekle(4);

        // sepete ekleyiniz
        driver.findElement(By.xpath("//button[@id='addToCartButton']")).click();
        sepeteEkle.click();
        bekle(2);

        // sepetim'e git tilayiniz
        driver.findElement(By.xpath("//span[text()='Sepetime Git']")).click();
        bekle(2);

        // "Siparis Ozeti" webelementinin text'ini yazdiriniz
        System.out.println("siparis ozeti: "+driver.findElement(By.xpath("//div[@class='cart-sum-title']")).getText());

        // Alisverisi tamamlayiniz
        driver.findElement(By.xpath("//span[text()='Alışverişi Tamamla']")).click();

        // "Teknosa'ya hos geldiniz" webelementinin text'ini yazdiriniz
        System.out.println("hosgeldiniz yazisi: " +driver.findElement(By.xpath("//div[@class='lrp-title']")).getText());
    }
}
