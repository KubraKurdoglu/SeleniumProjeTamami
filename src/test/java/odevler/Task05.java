package odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.codec.http.TooLongHttpContentException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task05 {

    /*
    -http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
    -Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
    -Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
    -Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
    -Çıkan alert'te iptal butonuna basınız
    -Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
    -Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
    -Çıkan mesajı konsola yazdırınız
    -Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız

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
    public void test01() throws InterruptedException {
        //-http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        //-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız

        driver.get("http://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();
        Thread.sleep(2000);

        //Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
    }

    @Test
    public void test02() throws InterruptedException {
        //-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız

        driver.get("http://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("(//a[@data-toggle='tab'])[2]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        //    -Çıkan alert'te iptal butonuna basınız

        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);

        //-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
        driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
        driver.findElement(By.xpath("//button[@onclick='promptbox()']")).click();

        //    -Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
        driver.switchTo().alert().sendKeys("Kubra");
        driver.switchTo().alert().accept();


        WebElement demo = driver.findElement(By.xpath("//p[@id='demo1']"));
        Assert.assertEquals("Hello Kubra How are you today", demo.getText());

    }

}
