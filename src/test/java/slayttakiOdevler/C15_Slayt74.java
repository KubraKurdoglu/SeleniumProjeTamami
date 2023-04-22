package slayttakiOdevler;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.*;

public class C15_Slayt74 extends TestBase {
    /*
1-C01_TekrarTesti isimli bir class olusturun
2- https://www.google.com/ adresine gidin 3- cookies uyarisini kabul ederek kapatin
4.Sayfa basliginin “Google” ifadesi icerdigini test edin
5. Arama cubuguna “Nutella” yazip aratin
6. Bulunan sonuc sayisini yazdirin
7. sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
8. Sayfayi kapatin
     */

    @Test
    public void test01(){

        //1-C01_TekrarTesti isimli bir class olusturun
        //2- https://www.google.com/ adresine gidin
        driver.navigate().to("https://www.google.com/");



        //3- cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("//button[@id='L2AGLb']"));

        //4.Sayfa basliginin “Google” ifadesi icerdigini test edin
        String sayfaBasligi = driver.getTitle();
        System.out.println("sayfaBasligi = " + sayfaBasligi);
        assertTrue(sayfaBasligi.contains("Google"));


        //5. Arama cubuguna “Nutella” yazip aratin
        WebElement aramaKutusu = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        aramaKutusu.sendKeys("Nutella");

        //6. Bulunan sonuc sayisini yazdirin
        //7. sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        //8. Sayfayi kapatin



    }





}
