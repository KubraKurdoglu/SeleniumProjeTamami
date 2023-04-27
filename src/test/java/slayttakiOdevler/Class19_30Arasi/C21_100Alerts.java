package slayttakiOdevler.Class19_30Arasi;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class C21_100Alerts extends TestBase {
    /*
    https://testcenter.techproeducation.com/index.php?page=javascript-alerts
adresine gidin.
● Bir metod olusturun: acceptAlert
○1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
“You successfully clicked an alert” oldugunu test edin.
● Bir metod olusturun: dismissAlert
○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result
mesajının “You clicked: Cancel” oldugunu test edin.
● Bir metod olusturun: sendKeysAlert
○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve
result mesajında isminizin görüntülendiğini doğrulayın.
     */


    @Test
    public void test01() {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts
        //adresine gidin.

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //● Bir metod olusturun: acceptAlert
        //○1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //“You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();
        driver.switchTo().alert().accept();
        bekle(2);
        WebElement result = driver.findElement(By.xpath("//p[text()='You successfully clicked an alert']"));
        bekle(1);
        assertEquals("You successfully clicked an alert", result.getText());
    }

    @Test
    public void dismiss() {




         //● Bir metod olusturun: dismissAlert
        //○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result
        //mesajının “You clicked: Cancel” oldugunu test edin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]")).click();
        driver.switchTo().alert().dismiss();
        WebElement result2 =  driver.findElement(By.id("result"));
        assertEquals("You clicked: Cancel", result2.getText());

        }

    @Test
    public void sendKeys() {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //● Bir metod olusturun: sendKeysAlert
        //○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]")).click();
        driver.switchTo().alert().sendKeys("Kubra");
        driver.switchTo().alert().accept();

        //result mesajında isminizin görüntülendiğini doğrulayın.
        WebElement result3 =  driver.findElement(By.id("result"));
        assertEquals("You entered: Kubra", result3.getText());

    }


}
