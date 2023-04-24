package day21_JSExecutor;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class C01_JSExecutor_Click extends TestBase {

    /*
        Eğer bir web sayfasının HTML kodları tamamen yada kısmen JavaScript kullanılarak oluşturulduysa
     o sayfaya müdahale etmek için genellikle JavaScriptExecutor arayüzünü kullanmak gerekir.
        Bu durumda, sayfayı manipüle etmek veya etkileşimde bulunmak için standart WebDriver komutları
     yetersiz kalabilir. Bu nedenle JSExecutor arayüzü, sayfanın JS kodlarına doğrudan erişebilir.
        Ancak, mümkünse WebDriver'in sunduğu standart yöntemlerle sorunları çözmek her zaman daha iyidir.
     Çünkü JS kullanımı, sayfanın daha yavaş yüklenmesine neden olabili.
    */
    /*
    http://www.uitestpractice.com/Students/Form sayfasına git
    Formu doldur
    Submit tuşuna tıkla
    Sayfa adresinin "http://www.uitestpractice.com/Students/Form?optradio=on" olduğunu doğrula.
    */

    @Test
    public void test01(){
        //http://www.uitestpractice.com/Students/Form sayfasına git
        driver.get("http://www.uitestpractice.com/Students/Form");

        //    Formu doldur
        Faker faker = new Faker();
        WebElement firstName = driver.findElement(By.id("firstname"));
        firstName.sendKeys(faker.name().firstName(),  Keys.TAB, faker.name().lastName(),Keys.TAB,Keys.TAB,Keys.TAB,
                Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB);

        //    Submit tuşuna tıkla
        WebElement submit = driver.findElement(By.xpath("//*[text()='Submit']"));

        try {
            submit.click();//normal click yap, dogru locate ettin yine de calismadi ise
        } catch (Exception e) {//o zaman java script le yazilmis olabilir, asagidaki kod devreye girer
            JavascriptExecutor js =(JavascriptExecutor) driver;
            js.executeScript("arguments[0].click()", submit);
        }

        //!!!!!!!!!!!!!!!! ElementClickInterceptedException==> bu hatada, ya sectigin yerin tiklanmasi gereken kismini degil
        //disardaki cerceveyi yaptin, yada calistigin sayfa JavaScript il olusturulmustur ve JSExecutor kullanman
        //gerekiyordur. Bu soruda da bu nedenle hata verdi, kodun bu kismindan sonra duzeltilecek

        //"arguments[0].click()"==> bu kisim hep ayni, dogru yazman cok onemli


        //    Sayfa adresinin "http://www.uitestpractice.com/Students/Form?optradio=on" olduğunu doğrula.
        //sayfa adresi dogru olmadigi icin "notEquals" yaptik
        assertNotEquals("http://www.uitestpractice.com/Students/Form?optradio=on", driver.getCurrentUrl());

    }
}
