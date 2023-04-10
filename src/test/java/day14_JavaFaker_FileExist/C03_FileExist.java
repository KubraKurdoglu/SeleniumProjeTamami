package day14_JavaFaker_FileExist;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class C03_FileExist {

             /*
        Masaüstünde "logo.jpeg" dosyası oluşturun.
        Bu dosyanın varlığını doğrulayın.
         */
    @Test
    public void fileExistTest(){

        String userDirectory = System.getProperty("user.dir");

        //IDE proje yolunu dinamik olarak verir
        String userHOME = System.getProperty("user.home");///Users/kubra/(kullanici adi, braya kadar olan kismi verecek)

        //dosya uzantilari her bilgisayarda farkli ldugu icin "dynamique" bir kod yazdi hoca


       boolean isExist= Files.exists(Paths.get(userHOME+ "/Downloads/logo.jpeg"));
        System.out.println("isExist = " + isExist);
        //assertTrue(isExist);

        /*
        Fail ise: dosya masaustunde degildir
                  dosya adi yanlistir
                  arada onedrive gibi extra dosyalar vardir
         */
    }
}
