package day09_DropDown_Alerts;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_Alerts extends TestBase {

    /*
    https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
    Bir metod olusturun: acceptAlert
    1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
    Bir metod olusturun: dismissAlert
    2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    “successfuly” icermedigini test edin.
    Bir metod olusturun: sendKeysAlert
    3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
     */

    @Test
    //Bir metod olusturun: acceptAlert
    public void acceptAlerts() throws InterruptedException {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(4000);

        //cikan "okey" yada "tamam" butonuna basmak icin
        driver.switchTo().//gecmek, degistirmek
                alert().//Alert'e gecis yapti
                accept();//Cikan uyarida "okey" "tamam" butonuna basti


        // “You successfully clicked an alert” oldugunu test edin.
        //!!!==>String actuelText = driver.findElement(By.xpath("//*[@id='result']"))==>boyle yazdim once
        //hata verdi cunku, string'e atarsan getText() ile strin'e cevirmen gerekiyor

        String actuelText = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedText = "You successfully clicked an alert";
        Assert.assertEquals(expectedText, actuelText);

    }


    //Bir metod olusturun: dismissAlert

    @Test
    public void dismissAlert() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //    2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
        Thread.sleep(4000);
        driver.switchTo().alert().dismiss();

        //    “successfuly” icermedigini test edin.
        Thread.sleep(4000);
        String actualText = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedText = "successfuly";
        Assert.assertFalse(actualText.contains(expectedText));
    }

    @Test

    public void sendKeysAlert() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        // 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Kubra");
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        WebElement result = driver.findElement(By.cssSelector("p[id='result']"));
        Assert.assertTrue(result.getText().contains("Kubra"));
    }




}
