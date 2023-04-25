package day18_ScreenShot_ExtendReport;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_WebElementScreenShot extends TestBase {


    @Test
    public void test01() throws IOException {
        //Amazon sayfasina gidiniz
        driver.get("https://amazon.com");

        //Arama bolumune Iphone aratiniz
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);


        //Sonuc yazisinin resmini aliniz
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));

        String date = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/webElementScreenShot"+date+".png";
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

        /*
        Sadece bir webelementin resmini almak istersek, FileUtils.copyFile() methoduyla locate ettigimiz
        webElementi getscreenshotAs() methodu kullanarak resmini alabiliriz

         */







    }
}
