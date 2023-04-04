package slayttakiOdevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;

public class Cookies extends TestBase {


    /*

Class: Cookies
Method: handleCookies Amazona git
1.toplam cookie sayisini bul 3. Bir Cookie yi smiyle bul
4. Yeni bir cookie ekle
5. Bir Cookie yi ismiyle sil
6. Tum cookie leri sil

     */
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01(){
        driver.navigate().to("https://amazon.com");

        //1.toplam cookie sayisini bul
        System.out.println("Cookies sayisi: "+driver.manage().getCookies().size());

        // 3. Bir Cookie yi smiyle bul

        System.out.print(driver.manage().getCookies());
        driver.manage().getCookieNamed(" skin");


        //4. Yeni bir cookie ekle
        Cookie newCookies = new Cookie("Kubra", "Kurdoglu");
        driver.manage().addCookie(newCookies);
        System.out.println("Cookies'in yeni size'i: "+driver.manage().getCookies().size());

        //5. Bir Cookie yi ismiyle sil

        driver.manage().deleteCookieNamed("sameSite");
        System.out.println("bir tane silindikten sonra cookies size: "+driver.manage().getCookies().size());

        //6. Tum cookie leri sil
        driver.manage().deleteAllCookies();
        System.out.println("cookies'lerin son size'i: "+driver.manage().getCookies().size());


    }

}
