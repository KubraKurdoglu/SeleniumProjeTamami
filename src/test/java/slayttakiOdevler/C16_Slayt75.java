package slayttakiOdevler;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C16_Slayt75 extends TestBase {

    /*
1.Bir class oluşturun : CheckBoxTest
2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
a. Verilen web sayfasına gidin.
https://the-internet.herokuapp.com/checkboxes
b. Checkbox1 ve checkbox2 elementlerini locate edin.
c. Checkbox1 seçili değilse onay kutusunu tıklayın
d. Checkbox2 seçili değilse onay kutusunu tıklayın
     */

    @Test
    public void test01() throws InterruptedException {


        //https://the-internet.herokuapp.com/checkboxes
        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
        Thread.sleep(2000);

        //b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement ckeckbox1 =driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2 =driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        //c. Checkbox1 seçili değilse onay kutusunu tıklayın
        ckeckbox1.click();
        Thread.sleep(2000);

        //d. Checkbox2 seçili değilse onay kutusunu tıklayın

        //!!!!!!Checkbox2 ==> ye tiklamana gerek yok cunku, zaten tiklanmis, ikinci kez tiklayinca "tik" kalkiyor
        //her iki checkbox'i ayni anda secebiliyorsun

       // checkbox2.click();




    }










}
