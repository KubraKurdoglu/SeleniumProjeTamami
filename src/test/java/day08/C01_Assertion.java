package day08;

import com.google.common.primitives.Booleans;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class C01_Assertion {


    //yukarda assert yaparken false, true icin ayri ayri import istiyor
    //bunun t-yerine yildiz koyarak tum assert class'larini import edebilirsin
    //import static org.junit.Assert.*;

    /*
            1)https://amazon.com adresinegidin
            2)Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleriyapin
            ○ title Test  => Sayfa başlığının “Amazon” kelimesini icerip icermedigini test edin
            ○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
            ○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
            ○ wrongTitleTest => Sayfa basliginin “amazon” icermedigini dogrulayin
     */

    WebDriver driver ;//Scope dan dolayi burda olusturduk

    @Before

    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");


    }

    @After
    public void tearDown() throws InterruptedException {
        driver.close();
        Thread.sleep(3000);// uc saniye bekleyecek

    }

    @Test//title Test  => Sayfa başlığının “Amazon” kelimesini icerip icermedigini test edin

    public void test01(){
        String actualTitle  = driver.getTitle();//driver'dan gelen asil datadir her zaman
        String expectedTitle = "Amazon";

        Boolean iceriyorMu = actualTitle.contains(expectedTitle);

        assertTrue(iceriyorMu);

    }

    @Test //image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
    public void test02(){
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        boolean  gorunurMu = logo.isDisplayed();
        assertTrue(gorunurMu);

        // hic boolean kullanmadan asagidaki gibi de kullanilabilir. bu biraz sirket kulturune bagli
        //assertTrue(logo.isDisplayed());
    }

    @Test

    public void test03(){
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        assertTrue(searchBox.isEnabled());
    }


    @Test

    public void test04(){
        String actuelTitle = driver.getTitle();
        String expectedTitle = "amazon";//buraya dogru basligi yazsaydin "assertion error" verecekti

        assertFalse(actuelTitle.equals(expectedTitle));

        //yukardaki konu bu sekilde de cozulebilir

        /*
        String gercekBaslik = driver.getTitle();
        String beklenenBaslik = "amazon";
        Assert.assertFalse("Gercek Baslik Amazon",gercekBaslik.contains(beklenenBaslik));

         */


    }
}
