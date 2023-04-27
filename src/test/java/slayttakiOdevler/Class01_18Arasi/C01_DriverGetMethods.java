package slayttakiOdevler.Class01_18Arasi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_DriverGetMethods {


    // Amazon sayfasina gidelim. https://www.amazon.com/
    //4. Sayfa basligini(title) yazdirin
    //5. Sayfa basliginin “Amazon” icerdigini test edin
    //6. Sayfa adresini(url) yazdirin
    //7. Sayfa url’inin “amazon” icerdigini test edin.
    //8. Sayfa handle degerini yazdirin
    //9. Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin 10.Sayfayi kapatin.
    static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01(){
        driver.get("https://www.amazon.com/");
        String title = driver.getTitle();
        if (title.contains("Amazon")){
            System.out.println("Title Amazon iceriyor");
        }else {
            System.out.println("Title 'Amazon' icermiyor");
        }


        //6. Sayfa adresini(url) yazdirin

        String sayfaURL=driver.getCurrentUrl();
        System.out.println("Sayfanin URL'si: "+sayfaURL);

        //7. Sayfa url’inin “amazon” icerdigini test edin.
        if (sayfaURL.contains("amazon")){
            System.out.println("URL 'amazon' iceriyor");
        }else {
            System.out.println("URL 'amazon' icermiyor");
        }

        //8. Sayfa handle degerini yazdirin
        System.out.println("Sayfanin handle degeri: "+driver.getWindowHandle());

        //9. Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin
        String HTMLkodlari = driver.getPageSource();
        System.out.println("Sayfanin kodlari: "+HTMLkodlari);

        if (HTMLkodlari.contains("Gateway")){
            System.out.println("Gateway iceriyor");
        }else {
            System.out.println("Gateway icermiyor");
        }

        // 10.Sayfayi kapatin.
        driver.close();
    }

}
