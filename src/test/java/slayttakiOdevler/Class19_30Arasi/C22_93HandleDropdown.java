package slayttakiOdevler.Class19_30Arasi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C22_93HandleDropdown extends TestBase {

    /*
● https://the-internet.herokuapp.com/dropdown adresine gidin.
1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
4.Tüm dropdown değerleri(value) yazdırın
5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
False yazdırın.
     */

    @Test
    public void test01() throws InterruptedException {

        //● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement options = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(options);
        List<WebElement> optionList = select.getOptions();



        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println("option 2: "+optionList.get(2).getText());

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println("option 1: "+optionList.get(1).getText());

        //4.Tüm dropdown değerleri(value) yazdırın
        for (WebElement w:optionList){
            System.out.println(w.getText());
        }
        //optionList.forEach(t-> System.out.println(t.getText()));

        //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        //False yazdırın.
        int size = optionList.size();
        if (size==4){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
        /*
        int count=0;
        for (WebElement w:optionList){

            count++;
        }
        System.out.println(count);
         */



    }
}
