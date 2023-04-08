package day13_ActionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_AyniDersErolHocaIle extends TestBase {
    /*
    https://jqueryui.com/droppable/ adresine gidin
    "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
     */


    //Asagida da her iki test ayni islemi farkli yollarla yapiyor
    @Test
    public void test01() {
        https:
//jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable");

//        "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        //Sayfada iFrame olduğu için "switch" yapıyoruz:
        driver.switchTo().frame(0);//bir tane eleman oldugu icin, index'i sifir yazdik.

        WebElement dragSource = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropTarget = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragSource, dropTarget).perform();
    }

    @Test
    public void test02() {
        https:
//jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable");

//        "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        //Sayfada iFrame olduğu için "switch" yapıyoruz:
        driver.switchTo().frame(0);//bir tane eleman oldugu icin, index'i sifir yazdik.

        WebElement dragSource = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropTarget = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(dragSource).//Elementi tutup bekler
                moveToElement(dropTarget).//Mouse'yi elementin uzerine tasir
                release().//Mouse'yi serbest birakir
                perform();
    }

    @Test
    public void test03() {
        https:
//jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable");

//        "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        //Sayfada iFrame olduğu için "switch" yapıyoruz:
        driver.switchTo().frame(0);//bir tane eleman oldugu icin, index'i sifir yazdik.

        WebElement dragSource = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropTarget = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(dragSource).moveByOffset(84, 28).//webelementi istedigimiz yere kpyzr
                release().perform();
    }
}