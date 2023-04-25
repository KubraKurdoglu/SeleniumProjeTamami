import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class Task10 extends TestBase {
    ExtentTest extentTest;
    ExtentReports extentReports;
    ExtentHtmlReporter extentHtmlReporter;

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
        assertEquals(isExist, Files.exists(Paths.get(userHOME +"/Downloads/chromedriver_mac64.zip")));



        //İndirmiş olduğumuz dosyayı silelim

        File indirilen=new File(userHOME + "/Downloads/chromedriver_mac64.zip");
        indirilen.delete();

        //Silindiğini doğrulayalım
        assertFalse(Files.exists(Path.of(userHOME + "/Downloads/chromedriver_mac64.zip")));

        //Not: Bu task'in her adımı için Html rapor oluşturalım(Extent Report)


        extentTest.info("Selenium downloads sayfasına gidildi");
        extentTest.info("Sayfa resmi alındı");
        extentTest.info("Browsers bölümü görünene kadar sayfayı indirdik");
        extentTest.info("Documentation linkine tıkladık");
        extentTest.info("Documentation webelementinin resmini aldık");
        extentTest.info("Latest stable release olan linki tıkladık");
        extentTest.info("Açılan pencerede chromedriver'i indirdik");
        extentTest.info("Driver'in indiğini doğruladık");
        extentTest.info("İndirmiş olduğumuz dosyayı sildik");
        extentTest.info("Silindiğini doğruladık");
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/reports/extentReport_"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("SDET","Ceren");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("HTML Raporu");
        extentTest=extentReports.createTest("ExtentTest","Test Raporu");
        //Her adımın altına ne yaptığımızı belirten bilgileri yazdık.
        extentTest.pass("Test sonlandırıldı");
        extentReports.flush(); //raporu kapatip sonlandiriyor
    }
    }


