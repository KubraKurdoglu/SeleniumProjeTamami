package slayttakiOdevler;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.*;

public class C05_NavigationsMethods extends TestBase {



    /*
    .Yeni bir class olusturalim (Homework)
2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook” oldugunu dogrulayin (verify),
 degilse dogru basligi yazdirin.
3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
4.https://www.walmart.com/ sayfasina gidin.
5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
6. Tekrar “facebook” sayfasina donun 7. Sayfayi yenileyin
8.Sayfayi tam sayfa (maximize) yapin
9.9.Browser’i kapatin
     */

    @Test
    public void test01() throws InterruptedException {
        //2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title)
        // “facebook” oldugunu dogrulayin (verify),
        // degilse dogru basligi yazdirin.

        driver.navigate().to("https://www.facebook.com");
        //driver.findElement(By.xpath("//.[@id='u_0_d_Wp'")).click();
        String sayfaBasligi = driver.getTitle();
        System.out.println(sayfaBasligi);
        if (sayfaBasligi.contains("facebook")){
            System.out.println("sayfa basligi dogru");
        }else {
            System.out.println("sayfa basligi dogru degil");
        }

        //3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.

       String mevcutURL = driver.getCurrentUrl();
        if (mevcutURL.contains("facebook")){
            System.out.println("URL 'facebook' iceriyor");
        }else {
            driver.getCurrentUrl();
        }

       //
        //4.https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com/ ");

        //5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String sayfabasligi2 = driver.getTitle();
        System.out.println(sayfabasligi2);
        assertTrue(sayfabasligi2.contains("Walmart.com"));

        //6. Tekrar “facebook” sayfasina donun 7. Sayfayi yenileyin
        driver.navigate().back();

        //8.Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();
        Thread.sleep(2000);

        //9.9.Browser’i kapatin
        driver.quit();

    }







}
