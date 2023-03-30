package day_02_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C01 {
    public static void main(String[] args) {


        // https://www.amazon.com/ adresine gidin
        // arama kutusunun, tagName'inin 'input' oldugunu test ediniz
        // arama kutusunun, name attribute'nun degerinin 'field-keywords' oldugunu test edin
        // sayfayi kapatiniz

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");



        // arama kutusunun, tagName'inin 'input' oldugunu test ediniz
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        String actuelTagName = aramaKutusu.getTagName();

        String expectedTagName = "input";

        if(expectedTagName.equals(actuelTagName)){
            System.out.println("TagName input");
        }else{
            System.out.println("TagName input degil");
        }


        // arama kutusunun, name attribute'nun degerinin 'field-keywords' oldugunu test edin

        String actuelNameDegerei = aramaKutusu.getAttribute("name");
        String expectedNameDegeri = "field-keywords";


        if(expectedNameDegeri.equals(actuelNameDegerei)){
            System.out.println("name attirubute'nin degeri 'fields-keyword' dur");
        }else {
            System.out.println("name attirubute'nin degeri 'fields-keyword' degildir");
        }


        // sayfayi kapatiniz

        driver.close();





    }
}
