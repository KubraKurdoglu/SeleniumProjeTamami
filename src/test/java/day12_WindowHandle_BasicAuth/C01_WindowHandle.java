package day12_WindowHandle_BasicAuth;

import org.junit.Test;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class C01_WindowHandle extends TestBase {
    /*
    https://www.techproeducation.com adresine gidiniz
    Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
    Tab 2'de https://www.youtube.com sayfasını açınız
    Tab 3'te https://www.linkedin.com sayfasını açınız
    techproeducation sayfasına geçiniz
    youtube sayfasına geçiniz
    linkedIn sayfasına geçiniz
     */

    @Test
    public void newTabTest() throws InterruptedException {
        // https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

        //    Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın

        assertEquals("Techpro Education | Online It Courses & Bootcamps", driver.getTitle());

        //    Tab 2'de https://www.youtube.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.youtube.com ");
        //yukardaki bize bir driver veriyor, bununla da direk gidilebilir youtube'a

        //sayfa basliginin YouTube oldugunu dogrulayiniz
        assertEquals("YouTube", driver.getTitle());

        //    Tab 3'te https://www.linkedin.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.linkedin.com");
        
        //sayfa basliginin LinkedIn icerdigini dogrulayiniz
        assertTrue(driver.getTitle().contains("LinkedIn"));

        
        //tum sayflarin birlikte windowHandles larini labiliriz dedi hoca
        //Window Handle Set'ini bir List icerisine aliyoruz'
        //List'ler bir interface, onlardan obje olusturamiyoruz
        //burda ArrayList'in icerisine Set'i koyacak
        

        List<String> windowHandleList = new ArrayList<>(driver.getWindowHandles());
        System.out.println("windowHandleList = " + windowHandleList);
        //windowHandleList = [0C76AC68D315AF3121DBBCFDFE223929, 50C2836AC063559254FD2841AC4DB578, 33F1ADA4A33596EB3176DA2FC7D0837F]
        
        //Liste ile indeks kullanarak ilgili wo-indiwHnadle degerine uasabiliriz:
        //    techproeducation sayfasına geçiniz
        Thread.sleep(3000);
        driver.switchTo().window(windowHandleList.get(0));//handle list'ten O. index'teki elemana gitti

        //    youtube sayfasına geçiniz
        Thread.sleep(3000);
        driver.switchTo().window(windowHandleList.get(1));//handle list'ten 1. index'teki elemana gitti

        //    linkedIn sayfasına geçiniz
        Thread.sleep(3000);
        driver.switchTo().window(windowHandleList.get(2));//handle list'ten 2. index'teki elemana gitti

    }

    //*****************************
    //yukardaki uygulamalarin dah kisa olanini yapacagiz

    @Test
    public void newTabTest02() throws InterruptedException {

        //https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

        //    Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        assertEquals("Techpro Education | Online It Courses & Bootcamps",driver.getTitle());

        //    Tab 2'de https://www.youtube.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.youtube.com");
        assertTrue(driver.getTitle().contains("YouTube"));

        //    Tab 3'te "https://www.linkedin.com" sayfasını açınız
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.linkedin.com");
        assertTrue(driver.getTitle().contains("LinkedIn"));


        //    techproeducation sayfasına geçiniz
        Thread.sleep(2000);
        switchToWindow(0);

        //    youtube sayfasına geçiniz
        Thread.sleep(2000);
        switchToWindow(1)
        ;
        //    linkedIn sayfasına geçiniz
        Thread.sleep(3000);
        switchToWindow(2);














    }

}
