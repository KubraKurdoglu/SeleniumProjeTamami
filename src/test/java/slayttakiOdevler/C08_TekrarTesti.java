package slayttakiOdevler;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C08_TekrarTesti extends TestBase {

        /*
    1.Bir class oluşturun : AmazonSearchTest
    2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
    a.web sayfasına gidin. https://www.amazon.com/
    b. Search(ara) “city bike”
    c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
    d. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
         */

    @Test
    public void test01(){
        //a.web sayfasına gidin. https://www.amazon.com/

        driver.navigate().to("https://www.amazon.com/");

        //    b. Search(ara) “city bike”
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("city bike", Keys.ENTER);

        //    c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        WebElement result = driver.findElement(By.xpath("//div[@class='sg-col-inner']"));
        System.out.println("sonuc sayiyisi: " +result.getText().split(" ")[2]);


        //    d. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();



    }
}
