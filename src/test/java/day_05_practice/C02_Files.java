package day_05_practice;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class C02_Files {

    //selenium websayfalarını test eder, selenium bilgisayarlarımızdaki dosyalara müdahale veya kontrol edemez.
    // Bu yüzden bilgisayarımızda bir kontrol yaparken Java kullanırız.

    // Desktop(masaustu)'da bir text dosyası olusturun
    // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin

    //testBase'ye extend etmedi cunku buna ihtiyac yok, bilgisyaradaki bir dosyanin varligina bakacagiz

    @Test

    public void test01(){

        //Oncelikle dosya yolunu kopyaladik
        ///Users/kubra/Desktop/Text

        String farkliKisim = System.getProperty("user.home");//burasi her bilgisyarada farkli olan kismi verir
        System.out.println(farkliKisim);
        String ayniKisim  = "/Desktop/Text";
        //==>/Users/kubra/Desktop/Text

        String dosyaYolu = farkliKisim+ayniKisim;

        assertTrue(Files.exists((Paths.get(dosyaYolu))));


    }
}
