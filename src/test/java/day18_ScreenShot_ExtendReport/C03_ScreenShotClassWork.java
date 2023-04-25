package day18_ScreenShot_ExtendReport;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_ScreenShotClassWork extends TestBase {

    @Test
    public void classWork() {
        //Techpro education sayfasina gidin
        //sayfanin resmini alin
        //arama bolumune "java" aratin
        //ve sonuc yazisinin resmini alin
        // yeni bir sekmede amazon a gidelim
        //sayfanin resmini alalim
        //arama bolumunde "iphone" aratalim
        //ve sonuc yazisinin resmini alalim


        //Techpro education sayfasina gidin
        driver.get("https://techproeducation.com");
        bekle(3);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//Reklamı kapatıyorum


        //sayfanin resmini alin
        tumSayfaResmi();

        //Arama bölümünde java aratalım
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("java", Keys.ENTER);


        //ve sonuc yazisinin resmini alin
        WebElement sonucYazisi = driver.findElement(By.xpath("//h1"));
        webElementResmi(sonucYazisi);

        // yeni bir sekmede amazon a gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");


        //sayfanin resmini alalim
        tumSayfaResmi();

        //arama bolumunde "iphone" aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);


        //ve sonuc yazisinin resmini alalim
        WebElement sonucYazisi2 = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        webElementResmi(sonucYazisi2);//method kullanarak webelementin resmini aldik


        //techpro sayfasina gecelim ve sayfa resmini alalim
        window(0);
        tumSayfaResmi();

    }
}
