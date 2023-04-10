package slayttakiOdevler;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C12_RelativeLocator extends TestBase {

    /*
    1.) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin
    2.) Berlin’i 3 farkli relative locator ile locate
    edin
    3 ) Relative locator’larin dogru calistigini test edin

     */

    @Test
    public void test01(){

        // https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin
        driver.navigate().to("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");


        // Berlin’i 3 farkli relative locator ile locate edin
        /*
        driver.findElement(By.id("pid7_thumb"));
        driver.findElement(By.xpath("(//img[@class='ui-li-thumb'])[7]"));
        driver.findElement(By.xpath("//img[@src='bots/sl-berlin-bot.png']"));
        */



        // Relative locator’larin dogru calistigini test edin





    }
}
