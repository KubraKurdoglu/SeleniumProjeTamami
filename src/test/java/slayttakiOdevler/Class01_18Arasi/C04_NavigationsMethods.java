package slayttakiOdevler.Class01_18Arasi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_NavigationsMethods {


    static WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    //1.Yeni bir Class olusturalim.C07_ManageWindowSet

    @Test
    public void test01(){
        //2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");

        //3. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("sayfanin konumu: "+driver.manage().window().getSize());
        System.out.println("sayfanin boyutlari: "+driver.manage().window().getPosition());

        //4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        driver.manage().window().setSize(new Dimension(800,500));

        //5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        System.out.println("sayfanin yeni boyutlari: " +driver.manage().window().getSize());

        //8. Sayfayi kapatin
        driver.close();


    }

}
