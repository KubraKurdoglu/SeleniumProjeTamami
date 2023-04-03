package day11_Alert_Iframe_WindowHandle;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class C02_WindowHandle extends TestBase {
      /*
    https://the-internet.herokuapp.com/windows adresine gidin.
    İlk sayfanın ID'sini alın.
    Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    "Click Here" butonuna tıklayın.
    Açılan pencereye geçin.
    Açılan yeni pencerenin sayfa başlığının(title) “New Window” olduğunu doğrulayın.
    Bir önceki pencereye dönüp sayfa başlığının “The Internet” olduğunu  doğrulayın.
    2. pencereye tekrar geçin.
    1. pencereye tekrar dönün.
     */

    @Test
    public void windowHandle() {
//        https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

//        İlk sayfanın ID'sini alın.
        String window1Handle = driver.getWindowHandle();
        System.out.println("window1Handle = " + window1Handle);

//        Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement window1Text = driver.findElement(By.xpath("//h3[.='Opening a new window']"));
        assertEquals("Opening a new window", window1Text.getText());

//        Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
//        "Click Here" butonuna tıklayın.
//        Açılan pencereye geçin.
//        Açılan yeni pencerenin sayfa başlığının(title) “New Window” olduğunu doğrulayın.
//        Bir önceki pencereye dönüp sayfa başlığının “The Internet” olduğunu  doğrulayın.
//        2. pencereye tekrar geçin.
//        1. pencereye tekrar dönün.


    }
}