package day_03_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.*;

public class C04_RadioButton {

    // https://demo.guru99.com/test/radio.html adresine gidin
    // radiobutton elementlerini locate edin
    // option2'yi secin
    // option2 elementlerinin secili oldugunu Test edin
    // option1 elementlerinin secili olmadıgını test edin
    // option3 elementlerinin secili olmadıgını test edin
    static WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void name() {

        // https://demo.guru99.com/test/radio.html adresine gidin
        driver.get("https://demo.guru99.com/test/radio.html");




        // radiobutton elementlerini locate edin
        WebElement option1 = driver.findElement(By.xpath("//input[@id='vfb-7-1']"));
        WebElement option2 = driver.findElement(By.xpath("//input[@id='vfb-7-2']"));
        WebElement option3 = driver.findElement(By.xpath("//input[@id='vfb-7-3']"));

        // option2'yi secin
        option2.click();


        // option2 elementlerinin secili oldugunu Test edin
        assertTrue(option2.isSelected());


        // option1 elementlerinin secili olmadıgını test edin
        assertFalse(option1.isSelected());


        // option3 elementlerinin secili olmadıgını test edin
        assertFalse(option3.isSelected());

    }

}
