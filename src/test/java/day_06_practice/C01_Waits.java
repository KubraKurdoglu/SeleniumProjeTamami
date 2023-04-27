package day_06_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

import static org.junit.Assert.*;

public class C01_Waits extends TestBase {

    // https://the-internet.herokuapp.com/dynamic_controls adresine gidiniz
    // Textbox'in etkin olmadıgını(enable) test edin
    // Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    // It's enable! mesajının goruntulendigini test edin
    // Textbox'in etkin oldugunu(enable) test edin


    @Test
    public void test01() {
        // https://the-internet.herokuapp.com/dynamic_controls adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Textbox'in etkin olmadıgını(enable) test edin
       WebElement textBox = driver.findElement(By.xpath("//*[@type='text']"));
       assertFalse(textBox.isEnabled());

        // Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        WebElement enableButton = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        enableButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));//burasi max sure
        //amac textBox in enable olmasi ama sure 20 saniyeyi gecmemeli, burda 20 yi bu nedenle yazdik
        //eger testBase class'indaki implicitly wait'i degistirip 1 yapsaydik dahi, yukardaki kod sayesinde
        //yine de calismasini bekleyecekti
        wait.until(ExpectedConditions.elementToBeClickable(enableButton));//beklelen sart gereceklesene "E KADAR(until)" Bekle.
        //isVisibility()'i kullanmadik, cunku bir elementin gorunmesi, tiklanabildigi anlamina gelmez


        /*
        Daha fazla abekleme suresi gerektiren belirli WebElement'ler icin "Wait" kullanilir.
         */


        // It's enable! mesajının goruntulendigini test edin

        WebElement itsEnableYazisi = driver.findElement(By.id("message"));
        assertTrue(itsEnableYazisi.isDisplayed());

        // Textbox'in etkin oldugunu(enable) test edin
        assertTrue(textBox.isEnabled());








    }
}
