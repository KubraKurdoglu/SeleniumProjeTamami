package day10_Alert_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_AlertMethods extends TestBase {
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
        bekle(4);

        //cikan "okey" yada "tamam" butonuna basmak icin
        alertAccept();
       bekle(4);


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
        bekle(4);
        alertDismiss();

        //    “successfuly” icermedigini test edin.
        bekle(4);
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
        bekle(4);
        alertPromptBox("Kubra");
        alertAccept();
        bekle(4);
        WebElement result = driver.findElement(By.cssSelector("p[id='result']"));
        Assert.assertTrue(result.getText().contains("Kubra"));
        System.out.println(result.getText());
    }

}
