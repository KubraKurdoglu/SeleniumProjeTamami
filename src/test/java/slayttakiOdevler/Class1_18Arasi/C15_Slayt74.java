package slayttakiOdevler.Class1_18Arasi;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    public void test01() throws InterruptedException {

        //1-C01_TekrarTesti isimli bir class olusturun
        //2- https://www.google.com/ adresine gidin
        driver.navigate().to("https://www.google.com/");



        //3- cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("(//div[@role='none'])[12]")).click();

        //4.Sayfa basliginin “Google” ifadesi icerdigini test edin
        String sayfaBasligi = driver.getTitle();
        System.out.println("sayfaBasligi = " + sayfaBasligi);
        assertTrue(sayfaBasligi.contains("Google"));


        //5. Arama cubuguna “Nutella” yazip aratin
        WebElement aramaKutusu = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        aramaKutusu.sendKeys("Nutella");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@class='gNO89b'])[2]")).click();


        //6. Bulunan sonuc sayisini yazdirin
        /*
       String sonuc =  driver.findElement(By.id("result-stats")).getText();
        System.out.println(sonuc.split(" ")[1]);

         */
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@id='result-stats']"));

        //  System.out.println(sonucYazisi.getText());

        String arr[] = sonucYazisi.getText().split(" ");

        String sonuc = arr[1];

        System.out.println(sonuc);


        //7. sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

        /*
        Bu Java kodu, bir String değişkeni olan "sonuc" içindeki sayısal olmayan karakterleri kaldırmak için kullanılır.

replaceAll() metodu, bir String içindeki belirtilen bir düzenli ifadeyi (regex) arar ve bu ifadeyi,
belirtilen bir String ile değiştirir. Burada kullanılan "\D" ifadesi,
 sayısal olmayan tüm karakterleri ifade eder. Yani, bu kodda, String değişkeni olan "sonuc" içindeki
 tüm sayısal olmayan karakterler "\D" ifadesiyle eşleştirilir ve bunlar boş bir String ile değiştirilir.
 Böylece, "sonucc" değişkeni, "sonuc" değişkeninin sadece rakamlar içeren bir kopyasını içerir.
         */

        String sonucc = sonuc.replaceAll("\\D","");

        if(Integer.parseInt(sonucc)>100000000){
            System.out.println("Sonuc sayisi 100000000'dan fazla");
        }else{
            System.out.println("Sonuc sayisi 100000000'dan fazla degil");
        }

        //8. Sayfayi kapatin
        driver.quit();



    }





}
