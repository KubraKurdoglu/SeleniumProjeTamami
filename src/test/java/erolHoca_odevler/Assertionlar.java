package erolHoca_odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assertionlar {


    /*
        1)https://www.youtube.com adresine gidin
        2)Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
        => Sayfa başlığının “YouTube” oldugunu test edin
        =>
        ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     */
    static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test02(){

        //Sayfa başlığının “YouTube” oldugunu test edin
        driver.get("https://youtube.com");
        System.out.println("sayfanin basligi: "+driver.getTitle());
        driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape__fill'])[13]")).click();
        driver.findElement(By.xpath("(//span[@jsname='V67aGc'])[7]")).click();

        //YouTube resminin görüntülendiğini (isDisplayed()) test edin

        WebElement logo =driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[4]"));
        System.out.println("Logo gorunuyor mu: "+logo.isDisplayed());




    }

    @Test
    public void test03(){
        driver.get("https://youtube.com");
        //asagidakiler cocikies ler icin

        driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape__fill'])[13]")).click();
        driver.findElement(By.xpath("(//span[@jsname='V67aGc'])[7]")).click();
        //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='search']"));
        System.out.println("arama kutusu gorunuyor mu: "+searchBox.isEnabled());
    }


    @After
    public void tearDown() throws InterruptedException {
        driver.close();
        Thread.sleep(2000);
    }


}
