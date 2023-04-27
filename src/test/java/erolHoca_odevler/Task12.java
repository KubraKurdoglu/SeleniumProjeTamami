package erolHoca_odevler;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Random;

public class Task12 extends TestBase {

    //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
    //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
    //Sonucu konsola yazdırıp
    //Sonucun doğrulamasını yapalım


    @Test
    public void test01() {

        //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
        driver.navigate().to("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        WebElement calculator = driver.findElement(By.xpath("//div[@id='calculator']"));

        Faker faker =new Faker();

        int num1 = faker.number().numberBetween(10, 99);
        int num2 = faker.number().numberBetween(10, 99);

        System.out.println(num1);
        System.out.println(num2);



        //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
        //Sonucu konsola yazdırıp
        //Sonucun doğrulamasını yapalım






    }
}
