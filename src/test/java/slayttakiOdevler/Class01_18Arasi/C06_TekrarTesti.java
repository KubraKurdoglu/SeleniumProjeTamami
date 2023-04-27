package slayttakiOdevler.Class01_18Arasi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.*;

public class C06_TekrarTesti {
    /*
    1. Yeni bir class olusturun (TekrarTesti)
2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru URL'yi yazdırın.
4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/ 5. Youtube sayfasina geri donun
6. Sayfayi yenileyin
7. Amazon sayfasina donun
8. Sayfayi tamsayfa yapin
9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa doğru başlığı(Actual Title) yazdırın.
10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru URL'yi yazdırın
11.Sayfayi kapatin
     */
    static WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void test01() {


        //1. Yeni bir class olusturun (TekrarTesti)
        //2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın (verify),
        // eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.get("https://www.youtube.com");
        String sayfaBasligi = driver.getTitle();
        if (sayfaBasligi.equals("youtube")){
            System.out.println("sayfa basligi dogru");
        }


        //3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru URL'yi yazdırın.
        boolean bb = driver.getCurrentUrl().contains("youtube");
        if (bb==true){
            System.out.println("baslik 'youtube' iceriyor");
        }else{
            System.out.println("Sayfa URL'si: "+driver.getCurrentUrl());
        }
        //4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.get("https://www.amazon.com/ ");

        // 5. Youtube sayfasina geri donun
        driver.navigate().back();

        //6. Sayfayi yenileyin
        driver.navigate().refresh();

        //7. Amazon sayfasina donun
        driver.navigate().back();

        //8. Sayfayi tamsayfa yapin
        driver.manage().window().maximize();

        //9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
        // Yoksa doğru başlığı(Actual Title) yazdırın.
        System.out.println(driver.getTitle());

        assertFalse( (driver.getTitle()).contains("Amazon"));

        //10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru URL'yi yazdırın

        String mevcutURL = driver.getCurrentUrl();
        System.out.println(driver.getCurrentUrl());

        assertFalse(mevcutURL.equals("https://www.amazon.com/"));

        //11.Sayfayi kapatin
        driver.quit();
    }
}
