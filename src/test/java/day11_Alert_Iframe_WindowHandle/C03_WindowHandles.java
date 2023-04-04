package day11_Alert_Iframe_WindowHandle;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class C03_WindowHandles extends TestBase {
    /*
    https://the-internet.herokuapp.com/windows adresine gidin.
    İlk sayfanın ID'sini(Window Handle değerini) alın.
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
    public void windowhandles(){


        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows ");

        //    İlk sayfanın ID'sini(Window Handle değerini) alın.
        String ilkSayfaWindowHandle = driver.getWindowHandle();

        //    Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement sayfaTexti = driver.findElement(By.xpath("//h3"));
        assertEquals("Opening a new window", sayfaTexti.getText());

        //    Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

        String actuelTitle = driver.getTitle();
        assertEquals("The Internet", actuelTitle);

        //    "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        //    Açılan pencereye geçin.

        /*
            Eger bir butona click yaptigimizda bizim kontrolumuz disinda yeni bir pencere aciliyorsa
         o pencere icindeki web elementleri handle edebilmem icin switchto() methodu ile gecis yapmam gerekir.
         Fakat kontrolumuz disinda acildigi icin handle degerini bilmedigimiz icin tum acilan pencereleri
         getWindowHandles methodunu kullanarak bir SET'e assig ederiz. Yada ArrayList'e assign ederiz.
         (Set'ler unique oluyor)
         */
        //Burada amaç kontrolumuz dışında açılan pencereye geçiş yapmak
        // 2 ayrı yöntem var set kullanarak veya ArrayList ile çalışabiliriz.

        //1.YONTEM
        Set<String> tumPencereler = driver.getWindowHandles();
        for(String w: tumPencereler){
            if (!w.equals(ilkSayfaWindowHandle)){
                driver.switchTo().window(w);
            }
        }//burda amac bizim kontrolumuz disinda acilan pencereye gecis yapmak
        //2. YONTEM

        List<String> tumwindowHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tumwindowHandles.get(1));


        //    Açılan yeni pencerenin sayfa başlığının(title) “New Window” olduğunu doğrulayın.
        String gercekBaslik = driver.getTitle();
        assertEquals("New Window", gercekBaslik);
        String ikinciSayfaHandleDegeri = driver.getWindowHandle();

        //    Bir önceki pencereye dönüp sayfa başlığının “The Internet” olduğunu  doğrulayın.

        driver.switchTo().window(ilkSayfaWindowHandle);
        assertEquals("The Internet", driver.getTitle());
        bekle(2000);


        //    2. pencereye tekrar geçin.
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        bekle(2000);


        //    1. pencereye tekrar dönün.
        driver.switchTo().window(ilkSayfaWindowHandle);
        bekle(2000);
    }
}
