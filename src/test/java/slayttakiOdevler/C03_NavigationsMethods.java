package slayttakiOdevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_NavigationsMethods {
    /*
        1.Yeni bir Class olusturalim.C06_ManageWindow
        2. Amazon soyfasina gidelim. https://www.amazon.com/
        3. Sayfanin konumunu ve boyutlarini yazdirin
        4. Sayfayi simge durumuna getirin
        5. simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        6. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        7. Sayfayi fullscreen yapin
        8. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        9. Sayfayi kapatin
     */
    static WebDriver driver;
    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


    }
    @Test
    public void test01() throws InterruptedException {
        //2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //3.Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("sayfanin boyutlari: "+driver.manage().window().getSize());
        System.out.println("sayfanin konumu: "+driver.manage().window().getPosition());

        //        4. Sayfayi simge durumuna getirin
        driver.manage().window().minimize();
        Thread.sleep(3000);

        //        5. simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        driver.manage().window().maximize();

        //        6. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        driver.manage().window().getSize();

        //        7. Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();

        //        8. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        driver.manage().window().getSize();

        //        9. Sayfayi kapatin
        driver.close();
    }
}
