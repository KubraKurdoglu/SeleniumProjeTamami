package slayttakiOdevler.Class01_18Arasi;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class C11_LocatorsXpath extends TestBase {

    /*
    1-C01_TekrarTesti isimli bir class olusturun
    2- https://www.amazon.com/ adresine gidin
    3- Browseri tam sayfa yapin(before da yapiyor)
    4.- Sayfayi “refresh” yapin
    5. Sayfa basliginin “Spend less” ifadesi icerdigini test edin
    6. Gift Cards sekmesine basin
    7. Birthday butonuna basin
    8. Best Seller bolumunden ilk urunu tiklayin
    9. Gift card details’den 25 $’i secin
    10-Urun ucretinin 25$ oldugunu test edin 10-Sayfayi kapatin
     */

    @Test
    public void test01(){
        //2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //    3- Browseri tam sayfa yapin(Before da yapiyor)
        //    4.- Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //    5. Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        System.out.println("Baslik 'SpendLess' iceriyor mu? = " + driver.getTitle().contains("Spend less"));


        //    6. Gift Cards sekmesine basin
        driver.findElement(By.xpath("//a[text()='Gift Cards']")).click();


        //    7. Birthday butonuna basin
        driver.findElement(By.xpath("//img[@alt='Birthday']")).click();

        //    8. Best Seller bolumunden ilk urunu tiklayin

        driver.findElement(By.xpath("//img[@alt='Amazon.com eGift Card']")).click();

        //    9. Gift card details’den 25 $’i secin
        driver.findElement(By.xpath("(//button[@id='gc-mini-picker-amount-1'])[1]")).click();





        //    10-Urun ucretinin 25$ oldugunu test edin
        WebElement urununUcreti =driver.findElement(By.xpath("(//button[@id='gc-mini-picker-amount-1'])[1]"));
        System.out.println(urununUcreti.getText());
        String ucret ="$25";
        assertEquals(ucret, urununUcreti.getText());



    }

}
