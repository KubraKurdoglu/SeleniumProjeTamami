package slayttakiOdevler.Class01_18Arasi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C10_AddRemoveElement {

    /*


a. Verilen web sayfasına gidin. http://a.testaddressbook.com/ sign_in
b. Locate email textbox
c. Locate password textbox ve
d. Locate signin button
e. Asagidaki kullanıcı adını ve şifreyi girin ve sign in düğmesini
tıklayın
i. Username : testtechproed@gmail.com ii. Password : Test1234!
NOT: cssSelector kullanarak elementleri locate ediniz.
     */
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
        driver.quit();
    }

    @Test
    public void test01() {


    }

}
