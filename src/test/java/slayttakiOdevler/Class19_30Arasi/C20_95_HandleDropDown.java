package slayttakiOdevler.Class19_30Arasi;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;

public class C20_95_HandleDropDown extends TestBase {
    /*
    1.http://zero.webappsecurity.com/ Adresine gidin 2. Sign in butonuna basin
3. Login kutusuna “username” yazin
4. Password kutusuna “password.” yazin
5. Sign in tusuna basin
6. Pay Bills sayfasina gidin
7. “Purchase Foreign Currency” tusuna basin
8. “Currency” drop down menusunden Eurozone’u secin
9. “amount” kutusuna bir sayi girin
10.“US Dollars” in secilmedigini test edin
11.“Selected currency” butonunu secin
12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin 13.“Foreign currency cash was successfully purchased.” yazisinin ciktigini
kontrol edin.
     */


    @Test
    public void test01() {


        //1.http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();

        //3. Login kutusuna “username” yazin
        WebElement login = driver.findElement(By.id("user_login"));
        login.sendKeys("username");

        //4. Password kutusuna “password.” yazin
        WebElement password = driver.findElement(By.id("user_password"));
        password.sendKeys("password.");


        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //6. Pay Bills sayfasina gidin
        //7. “Purchase Foreign Currency” tusuna basin
        //8. “Currency” drop down menusunden Eurozone’u secin
        //9. “amount” kutusuna bir sayi girin
        //10.“US Dollars” in secilmedigini test edin
        //11.“Selected currency” butonunu secin
        //12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin 13.“Foreign currency cash was successfully purchased.” yazisinin ciktigini
        //kontrol edin.
    }
}
