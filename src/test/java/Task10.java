import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class Task10 extends TestBase {

    //https://www.selenium.dev/downloads/ adresine gidelim
    //Sayfanın resmini alalım
    //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
    //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
    //Documentation webelementinin resmini alalım
    //All versions available in Downloads altında Latest stable release olan linki tıklayalım
    //Açılan pencerede chromedriver'i indirelim
    //Driver'in indiğini doğrulayalım
    //İndirmiş olduğumuz dosyayı silelim
    //Silindiğini doğrulayalım
    //Not: Bu task'in her adımı için Html rapor oluşturalım(Extent Report)


    @Test
    public void test01(){
        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");

        //Sayfanın resmini alalım
        tumSayfaResmi();

        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        WebElement Browser = driver.findElement(By.xpath("(//h2)[8]"));
        scrollIntoView(Browser);
        bekle(3);

        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        driver.findElement(By.xpath("//button[@data-target='#supported-browsers']")).click();
        WebElement documentation =driver.findElement(By.xpath("(//a[text()='documentation'])[5]"));
        documentation.click();


        //Documentation webelementinin resmini alalım
        WebElement cHDDocumentation = driver.findElement(By.id("yDmH0d"));
        webElementResmi(cHDDocumentation);

        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        bekle(3);
        driver.findElement(By.xpath("//span[text()='Tamam']")).click();
        driver.findElement(By.xpath("(//a[@class='XqQF9c'])[5]")).click();




        //Açılan pencerede chromedriver'i indirelim


        switchToWindow(1);
        driver.findElement(By.xpath("//a[@href='/112.0.5615.49/chromedriver_mac64.zip']")).click();


        //Driver'in indiğini doğrulayalım

        String userHOME = System.getProperty("user.home");
        boolean isExist = Files.exists(Paths.get(userHOME +"/Downloads/chromedriver_mac64.zip"));
        assertTrue(isExist);



        //İndirmiş olduğumuz dosyayı silelim

        File indirilen=new File(userHOME + "/Downloads/chromedriver_mac64.zip");
        indirilen.delete();

        //Silindiğini doğrulayalım
        assertFalse(Files.exists(Path.of(userHOME + "/Downloads/chromedriver_mac64.zip")));

        //Not: Bu task'in her adımı için Html rapor oluşturalım(Extent Report)












    }

}
