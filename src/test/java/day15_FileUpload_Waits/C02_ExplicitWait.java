package day15_FileUpload_Waits;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class C02_ExplicitWait extends TestBase {

     /*
https://the-internet.herokuapp.com/dynamic_loading/1
Start buttonuna tıklayın
Hello World! Yazının sitede oldugunu test edin
 */


    @Test
    public void emplicitlyWait(){
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıklayın
        //driver.findElement(By.id("start")).click();//tiklamayacak cunku orda gizli bir oge var
        //burdaki "id" bir ust class'i temsil ettigi icin "id" ile alamadi
        //bu nednele ordaki yazinin xpath'ini aldi hoca. id'ye gore daha genis bir alani locate etmis oldu
        //sirasiyla hiyerarsiye uyarak yapti
        //===> yeni bir xpath yazim seklli gosterdi. parent'ten child'a xpath yazdi
        //div[@id='start']/button==> bu xpath ile yapti


        //Start buttonuna tıklayın
        driver.findElement(By.xpath("//div[@id='start']/button")).click();

//       assertTrue( driver.findElement(By.xpath("//div[@id='finish']//h4")).isDisplayed()); //Burada implcit wait kullanıldı


        //Hello World! Yazının sitede oldugunu test edin
        //Implicit wait ile test geçmedi. Explicit wait kullanacağız:
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement helloWorldText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));

        assertTrue(helloWorldText.isDisplayed());






    }
}
