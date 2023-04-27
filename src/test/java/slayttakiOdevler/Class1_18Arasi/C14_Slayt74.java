package slayttakiOdevler.Class1_18Arasi;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C14_Slayt74 extends TestBase {


    //!!!!!!!!!!!!!!!!!!!!!!SITE GUVENLI DEGIL DEDIGI ICIN KALDI BIR NOKTADA

    /*
    1.http://zero.webappsecurity.com sayfasina gidin
    2. Signin buttonuna tiklayin
    3.Loginalanine “username”yazdirin
    4. Password alanine “password” yazdirin
    5. Sign in buttonuna tiklayin
    6. Pay Bills sayfasina gidin
    7. amount kismina yatirmak istediginiz herhangi bir miktari yazin 8. tarih kismina “2020-09-10” yazdirin
    9. Pay buttonuna tiklayin
    10.“The payment was successfully submitted.” mesajinin ciktigini control edin
     */

    @Test
    public void test01(){

        //1.http://zero.webappsecurity.com sayfasina gidin
        driver.navigate().to("http://zero.webappsecurity.com");


        //    2. Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();

        //    3.Login alanine “username”yazdirin
        WebElement login = driver.findElement(By.id("user_login"));
        login.sendKeys("username");

        //    4. Password alanine “password” yazdirin
        WebElement password = driver.findElement(By.id("user_password"));
        password.sendKeys("password");


        //    5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //    6. Pay Bills sayfasina gidin
        //    7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //    8. tarih kismina “2020-09-10” yazdirin
        //    9. Pay buttonuna tiklayin
        //    10.“The payment was successfully submitted.” mesajinin ciktigini control edin



    }
}
