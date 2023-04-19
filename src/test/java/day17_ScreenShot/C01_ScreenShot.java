package day17_ScreenShot;

import net.bytebuddy.build.Plugin;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShot extends TestBase {

    @Test
    public void test01() throws IOException {
        /*
        Tum ekran goruntsunu Selenium'dan gelen getScreenShotAs() methodu ile aliriz.
        Bu method selenium'daki TakesScreenShot arayuz(interface) inden gelir

         */

        //Techpro education sayfasina gidelim
        driver.get("https://techproeducation.com");

        //1.ADIM
        //ilk olarak sayfanin dosyayi nereye kaydedecegimizi belirtmemiz  gerekiyor

        String dosyaYolu = "TestOutPut/screenshot.png";
        /*
        hoca ilk b yontemle yapti ama pom.xml in ustune geldi screen shot
         //String dosyaYolu = "screenShot.png";
         */


        /*
        proje seviyesinde new directory deyip screenshot lari oaray kaydedebiliriz.
        ve dosyanin adini TestOutput yapariz. path'ini alip ekelriz.
        asagida path=target, ve dosya adi da screenShot
        String dosyaYolu2 = "TestOutPut/ScreenShotscreenShot.png";
         */



        //2.ADIM
        //TakeScreenShot arayuzunden obje olusturmak
        TakesScreenshot ts =(TakesScreenshot) driver;

        //3.ADIM
        /*
        FileUtils class'i file nesneleri ile birlikte kullanabileceginiz methodlar icerir.
        Bu methodlari kullanarak dosyalri okuma, yazm a, silme ve kopyalama islemlerini cok daha kolay
        yapabiliriz
         */



        // Ekran resmini projemize katalim
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));

    }

    @Test
    public void test02() throws IOException {
        driver.get("https://techproeducation.com");
        //Kaydettigimiz ekran resmi her seferinde ayni dosyanin uzerine ayzmamasi icin
        // dosya isminden sonra her seferinde bir tarih atayabiliriz.
        //bunu yapmak icin

        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutPut/screenshot"+tarih+".png";
        TakesScreenshot ts =(TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
    }
}
