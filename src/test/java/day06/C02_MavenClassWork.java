package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenClassWork {
      /*
    http://zero.webappsecurity.com sayfasına gidin
    Signin buttonuna tıklayın
    Login alanına  "username" yazdırın
    Password alanına "password" yazdırın
    Sign in buttonuna tıklayın
    Pay Bills sayfasına gidin
    Amount kısmına yatırmak istediğiniz herhangi bir miktarı yazın
    Date kısmına "2023-03-27" yazdırın
    Pay buttonuna tıklayın
    "The payment was successfully submitted." mesajının çıktığını kontrol edin
     */

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//        http://zero.webappsecurity.com sayfasına gidin
        driver.get("http://zero.webappsecurity.com");

//        Signin buttonuna tıklayın
        driver.findElement(By.id("signin_button")).click();

//        Login alanına  "username" yazdırın
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

//        Password alanına "password" yazdırın
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

//        Sign in buttonuna tıklayın
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.navigate().back();

//        Pay Bills sayfasına gidin
//        Amount kısmına yatırmak istediğiniz herhangi bir miktarı yazın
//        Date kısmına "2023-03-27" yazdırın
//        Pay buttonuna tıklayın
//        "The payment was successfully submitted." mesajının çıktığını kontrol edin
//        Sayfayı kapatın



    }
}

