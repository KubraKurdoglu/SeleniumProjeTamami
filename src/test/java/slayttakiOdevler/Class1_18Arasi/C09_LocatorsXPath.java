package slayttakiOdevler.Class1_18Arasi;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C09_LocatorsXPath extends TestBase {

    /*
        1- https://the-internet.herokuapp.com/add_remove_elements/ adresine
        gidin
        2- Add Element butonuna basin
        3. Delete butonu’nun gorunur oldugunu test edin
        4. Delete tusuna basin
        5. “Add/Remove Elements” yazisinin gorunur oldugunu test edin
     */

    @Test
    public void test01() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        Thread.sleep(2000);
        WebElement buttonDelete = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        System.out.println("Delete Butonu Gorunur mu?: "+buttonDelete.isDisplayed());
        driver.findElement(By.xpath("//button[@onclick='deleteElement()']")).click();
        System.out.println("Add/Remove Elements yazisi gorunur mu? "+driver.findElement(By.xpath("//h3")).isDisplayed());

    }

}
