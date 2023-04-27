package slayttakiOdevler.Class1_18Arasi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.*;

public class C18_Slayt87 {
    /*
1)Bir class oluşturun: YoutubeAssertions
2) https://www.youtube.com adresine gidin
3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
=> Sayfa başlığının “YouTube” oldugunu test edin
=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     */

    WebDriver driver;
    @Before
    public void setUp(){

    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



}

    @Test
    public void test01(){

        //2) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape__fill'])[13]")).click();

        //3) Aşağıdaki adimları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
        //=> Sayfa başlığının “YouTube” oldugunu test edin
        String sayfaBasligi = driver.getTitle();
        assertEquals("YouTube" , sayfaBasligi);

        //=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement logo = driver.findElement(By.id("logo-icon"));
        assertTrue(logo.isDisplayed());


        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox = driver.findElement(By.id("search"));
        assertTrue(searchBox.isEnabled());


        //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        assertNotEquals("youtube", sayfaBasligi);

    }




}
