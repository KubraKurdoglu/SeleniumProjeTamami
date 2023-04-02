package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public abstract class TestBase {//abstract yapmasakta olurmus, obje olusturulmasin diye yaptik dedi hoca
        //TestBase class'indan obje olusturmanin onune gecilmesi icin abstract yapilabilir
        //Orn: TestBase base=new TestBase();
        //Bu class'a extend ettigimiz test classlarinda ulasabiliriz.
        //cunku testbase de bir obje olusturusak, yanlislikla bu class yerine onu cagirabiliriz


    protected static WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    public static void bekle(int saniye) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Alert Accept
    public void alertAccept(){//static yapmadi, cunku kullanack class ile parent-child iliskisi olacak.gerek yok
        driver.switchTo().alert().accept();
    }


    //Alert Dismiss
    public void alertDismiss(){//static yapmadi, cunku kullanack class ile parent-child iliskisi olacak.gerek yok
        driver.switchTo().alert().dismiss();
    }

    //Alert getText()
    public void alertText(){
    driver.switchTo().alert().getText();
    }


    //Alert promptBox()
    public void alertPromptBox(String text){
        driver.switchTo().alert().getText();
    }

    //DropDown VisibleText
    /*
        Select select2 = new Select(gun);
        select2.selectByVisibleText("7");

        //ddmVisibleText(gun,"7"); --> Yukarıdaki kullanım yerine sadece method ile handle edebilirim
     */
    public static void ddmVisibleText(WebElement ddm, String secenek){
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }

    //DropDown Index
    public static void ddmIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }
    //DropDown Value
    public static void ddmValue(WebElement ddm,String secenek){
        Select select = new Select(ddm);
        select.selectByValue(secenek);
    }



}
