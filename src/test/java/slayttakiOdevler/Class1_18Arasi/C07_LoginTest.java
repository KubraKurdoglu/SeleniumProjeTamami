package slayttakiOdevler.Class1_18Arasi;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C07_LoginTest extends TestBase {

    /*

a. http://a.testaddressbook.com adresine gidiniz.
b.  log in butonuna basin
c. email textbox,password textbox, and  log in button elementlerini locate ediniz..
d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (log in)buttonunu tıklayın:
i. Username : testtechproed@gmail.com
ii. Password : Test1234!
e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
3. Sayfada kac tane link oldugunu bulun.
     */

    @Test
    public void test01() throws InterruptedException {


        //a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");
        Thread.sleep(2000);
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//a")).click();
        driver.findElement(By.id("onetrust-reject-all-handler")).click();



        //b. Log in butonuna basin
        driver.findElement(By.linkText("Log in")).click();



        //c. email textbox,password textbox, and Log in button elementlerini locate ediniz..

       WebElement email= driver.findElement(By.id("email"));
        WebElement password =driver.findElement(By.name("password"));
        driver.findElement(By.name("commit"));//locate alirken baktim "unique" idi.


        // d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (log in)buttonunu tıklayın:
        //i. Username : testtechproed@gmail.com
        driver.findElement(By.id("email")).sendKeys("testtechproed@gmail.com");
        //ii. Password : Test1234!
        driver.findElement(By.name("password")).sendKeys("Test1234!");
        driver.findElement(By.xpath("//button[text()='Log In']")).click();

        //e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        if (email.equals("testtechproed@gmail.com")){
            System.out.println("expected ile actuel esit");
        }else {
            System.out.println("expected ile actuel esit degil");
        }

        //f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).

        //3. Sayfada kac tane link oldugunu bulun.









    }


}
