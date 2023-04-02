package odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task03 {

    //-BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
//-Before methodunda http://www.google.com adresine gidin
//-Üç farklı test methodu ile;
//-arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
//-arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
//-arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
//-NOT: Çıkan sonuç sayılarını After methodunda yazdırınız
//-AfterClass ile kapatın

    static WebDriver driver;

    @BeforeClass
    public static void beforeClass(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Before
    public void setUp()  {
        driver.get("http://www.google.com");
        driver.findElement(By.xpath("//div [@class='QS5gu sy4vM']")).click();
    }


    //-arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test01() throws InterruptedException {
        WebElement aramaKutusu =  driver.findElement(By.xpath("//input[@class='gLFyf']"));
        aramaKutusu.sendKeys("The God Father", Keys.ENTER);


        WebElement sonuc = driver.findElement(By.xpath("//div [@id='result-stats']"));
        System.out.println("baba sonuc "+sonuc.getText().split(" ")[1]);

    }


    //-arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin

    @Test
    public void test02() throws InterruptedException {
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@class='gLFyf']"));
        aramaKutusu.sendKeys("Lord of the Rings", Keys.ENTER);


        WebElement sonuc= driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println("lord of the rings sonuc "+sonuc.getText().split(" ")[1]);//239.000.000


    }

    ////-arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test03(){
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@class='gLFyf']"));
        aramaKutusu.sendKeys("Kill Bill", Keys.ENTER);


        WebElement sonuc = driver.findElement(By.xpath("//body[@jsmodel='hspDDf']"));
        System.out.println("kill bill sonuc" + sonuc.getText().split(" ")[2]);

    }



    @After
    public void close() {
        driver.close();
    }



}
