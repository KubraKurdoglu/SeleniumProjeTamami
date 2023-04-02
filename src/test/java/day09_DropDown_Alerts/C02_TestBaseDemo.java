package day09_DropDown_Alerts;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C02_TestBaseDemo extends TestBase {

    @Test
    public void test01(){
        //techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");

        //Basligin "Bootcamp" icerip icermedigini test edin
        String actuelTitle = driver.getTitle();
        String expectedTitle = "Bootcamp";
        Assert.assertTrue(actuelTitle.contains(expectedTitle));


    }

}
