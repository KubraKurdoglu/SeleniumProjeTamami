package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        //Thread.sleep(3000);
        //driver.quit();
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

    //SwitchTo : sayfalar arasi gecis methodu
    //herhangi bir return olmayacak o nedenle void
    //driver'in bulundugu yerde, tum driver'larin handlel'lerini aliyor
    //bu sayede istedigimiz yerden aliyoruz
    //Index sifirdan baslar, girilen index'teki windowhandle degerini alarak o sayfaya gecis yapar

    /*
    public static void switchToWindow(int sayfaIndeksi){
        List<String> windowHandleList = new ArrayList<>(driver.getWindowHandles());

    }

     */

    //SwitchToWindow1
    public static void switchToWindow(int sayi) {
        List<String> tumWindowHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tumWindowHandles.get(sayi));
    }

    //bir pencereden digerine gecmek icin kullaniyoruz bu methodu
    public static void window(int sayi){
        driver.switchTo().window(driver.getWindowHandles().toArray()[sayi].toString());

    }

    public static void tumSayfaResmi(){
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutPut/screenshot"+tarih+".png";
        TakesScreenshot ts =(TakesScreenshot) driver;
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //WebElemnet ScreenShot Alma
    public static void webElementResmi(WebElement element){
        String date = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/webElementScreenShot"+date+".png";
        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    //Bu method ile herhangi bir elemente JS Executer kullanarak ekranı kaydırma yapabilirim:
    public void scrollIntoView(WebElement element){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);

    }


}
