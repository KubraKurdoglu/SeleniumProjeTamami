package day_03_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Alert {

    //http://demo.guru99.com/test/delete_customer.php adresine gidin
    //customer id kısmına 53920 yazın
    //submit butonuna tıklayın
    //cıkan alert mesajını yazdırın
    //alerti kabul edin
    //cıkan 2. alert mesajını yazdırın
    //cıkan 2. alerti kabul edin

    static WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){
        //driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        //http://demo.guru99.com/test/delete_customer.php adresine gidin
        driver.get("http://demo.guru99.com/test/delete_customer.php");
        Thread.sleep(3000);

        //customer id kısmına 53920 yazın
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("53920");


        //submit butonuna tıklayın
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(2000);

        //cıkan alert mesajını yazdırın
        String  alertMesaji = driver.switchTo().alert().getText();
        System.out.println("birinci alert yazisi: " +alertMesaji);
        Thread.sleep(2000);

        //alerti kabul edin
        driver.switchTo().alert().accept();
        Thread.sleep(2000);


        //cıkan 2. alert mesajını yazdırın

        String ikinciAlertYazisi = driver.switchTo().alert().getText();
        System.out.println("ikinciAlertYazisi = " + ikinciAlertYazisi);


        //cıkan 2. alerti kabul edin
        driver.switchTo().alert().accept();


    }
}
