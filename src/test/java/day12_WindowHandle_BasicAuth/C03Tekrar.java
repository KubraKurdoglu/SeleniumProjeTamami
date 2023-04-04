package day12_WindowHandle_BasicAuth;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;
import java.util.Set;

import static org.junit.Assert.*;

public class C03Tekrar extends TestBase {
    /*
    1-Amazon anasayfaya gidin
    2-tum cookie’leri listeleyin
    3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
    4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
    5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
    6-eklediginiz cookie’nin sayfaya eklendigini test edin
    7-ismi skin olan cookie’yi silin ve silindigini test edin
    8-tum cookie’leri silin ve silindigini test edin
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



        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");

        //    2-tum cookie’leri listeleyin
        Set<Cookie> allCookies = driver.manage().getCookies();

        for (Cookie w:allCookies) {
            System.out.println(w);
            System.out.println(w.getName());

        }
        //2.YOL lambda
        //allCookies.stream().forEach(t-> System.out.println(t.getName()));

        //    3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin

        //1.YOL
        if (allCookies.size()>5){
            System.out.println("Cookies sayisi 5 den buyuktur");
        }else{
            System.out.println("Cookies sayisi 5'den buyuk degildir");
        }

        //2.YOL
        int tumCookiesSayisi = allCookies.size();
        assertTrue(tumCookiesSayisi>5);

        //    4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String cookiesValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        assertEquals("USD", cookiesValue);

        //    5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie newCookie = new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(newCookie);

        //    6-eklediginiz cookie’nin sayfaya eklendigini test edin
        String newCookiesValue = driver.manage().getCookieNamed("en sevdigim cookie").getValue();
        assertEquals("cikolatali", newCookiesValue);
        //simdi "size" ini alacagiz ve ilk size ile karsilastirma yapacagiz
        System.out.println("tum cookies'lerin size'i: "+allCookies.size());

        //    7-ismi skin olan cookie’yi silin ve silindigini test edin
        int skinSilinmedenOnceSize = driver.manage().getCookies().size();
        driver.manage().deleteCookieNamed("skin");
        int skinSilinmedenSonraSize = driver.manage().getCookies().size();
        assertEquals(1, (skinSilinmedenOnceSize-skinSilinmedenSonraSize));

        //    8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        assertEquals(0,driver.manage().getCookies().size());

    }


}
