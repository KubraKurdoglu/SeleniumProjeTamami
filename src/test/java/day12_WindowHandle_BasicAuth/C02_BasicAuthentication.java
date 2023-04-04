package day12_WindowHandle_BasicAuth;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class C02_BasicAuthentication extends TestBase {


    @Test
    public void test01(){

        //https://the-internet.herokuapp.com/basic_auth
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //linkin basina "@" koydu sonra "kullaniciadi:sifre" formatinda sifre ve kullanici adini yazdi
        //yani soyle "admin:admin"==> bununla ilgili karsiniza bir sey cikmaz dedi hoca
        //cunku bu "basic authentication" isteyen yerlerde karsimiza cikarmis

        //simdi dogrulama yapacagiz

        //paragrafin "Congratulations" kelimesi icerdigini dogrulayiniz

        String paragraf = driver.findElement(By.xpath("//p")).getText();
        assertTrue(paragraf.contains("Congratulations"));


    }

}
