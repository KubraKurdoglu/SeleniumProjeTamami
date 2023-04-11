package day15_FileUpload_Waits;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class C01_FileUpload extends TestBase {

    /*
https://the-internet.herokuapp.com/upload adresine gidin
logo.jpeg dosyasını yükleyin(uopload)
"File Uploaded!" textinin görüntülendiğini test edin
*/

    ///-------------Selenium'da windows islemlerini yapamiyoruz, bunun icn baska bir programa ihtiyac var
    //Selenium ile Driver uzerinde islem yapabiliyoruz

    @Test
    public void fileUploadTest(){
        driver.get("https://the-internet.herokuapp.com/upload");
        //dosyanin adresini (path), sendkeys ile istedigimiz yere gonderebiliriz.

        WebElement chooseFile = driver.findElement(By.xpath("//input[@id='file-upload']"));
        bekle(3);

        chooseFile.sendKeys(System.getProperty("user.home")+"/Downloads/logo.jpeg ");
        //gonderilecek dosyanin adresini choosefile butonuna senKeys() metodu ile yaziyoruz.
        //Bu sekilde gonderilecek dosya secilmis olur


        WebElement fileUploadButton = driver.findElement(By.id("file-submit"));
        fileUploadButton.click();
        ///Users/kubra/Downloads/logo.jpeg


        //"File Uploaded!" textinin görüntülendiğini test edin
        WebElement fileuploadedText = driver.findElement(By.xpath("//h3"));
       assertTrue(fileuploadedText.isDisplayed());

    }
}
