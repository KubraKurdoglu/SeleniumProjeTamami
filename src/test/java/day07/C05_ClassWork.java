package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_ClassWork {
    /*
        a.Verilen web sayfasına gidin.
        https://the-internet.herokuapp.com/checkboxes
        b.Checkbox1 ve checkbox2 elementlerini locate edin.
        c.Checkbox1 seçili değilse onay kutusunu tıklayın
        d.Checkbox2 seçili değilse onay kutusunu tıklayın
     */

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01(){
        //Verilen web sayfasına gidin.
        driver.get("https://the-internet.herokuapp.com/checkboxes");


        //Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        //Checkbox1 seçili değilse onay kutusunu tıklayın
        System.out.println("checkbox1 secili mi? " + checkbox1.isSelected());
        System.out.println("checkbox2 secili mi? " + checkbox2.isSelected());

        //Checkbox1 seçili değilse onay kutusunu tıklayın(onay kutusu dedigi checkbox 1)
        if (!checkbox1.isSelected()){//===>bunun anlami secili degilse tikla
            checkbox1.click();
        }

        //Checkbox2 seçili değilse onay kutusunu tıklayın

        if (!checkbox2.isSelected()){// yine burda da ayni sekilde kutu2 secili degilse tikla
            checkbox2.click();
        }

    }
}
