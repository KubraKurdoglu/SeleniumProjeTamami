package day13_ActionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions04 extends TestBase {
     /*
    https://jqueryui.com/droppable/ adresine gidin
    "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
     */


    //ASAGISAKI HER IKI TEST METHODU DA AYNI ISLEMI YAPIYOR, IKINCIDE ISLEMLERI KENDIMIZ SIRA ILE BELIRTMIS
    //OLUYORUZ
    //ILK YINTEM DAH COK TERCIH EDILIYOR. CUNKU IKINCIDE ISLEMLERI KENDIMIZ YAPIYORUZ

    @Test
    public void actionsTest(){
//        https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable");

//        "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        //Sayfada iFrame olduğu için "switch" yapıyoruz:
        driver.switchTo().frame(0);

        //Kaynak ve hedef web elementlerini locate ediyoruz:
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,target).perform();//dragAndDrop() methodu kaynak elemanı hedef eleman üzerine bırakır.

    }

    @Test
    public void actionsTest02(){
        //        https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable");

//        "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        //Sayfada iFrame olduğu için "switch" yapıyoruz:
        driver.switchTo().frame(0);

        //Kaynak ve hedef web elementlerini locate ediyoruz:
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.
                clickAndHold(source).//Webelement i tilar ve tutar
                moveToElement(target).//mouse'yi bir webelement uzerine tasir
                release().//release methodu tiklanip tutulan maouse'yi birakir
                perform();
    }

    @Test
    public void actionsTest03(){
//        https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable");

//        "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        //Sayfada iFrame olduğu için "switch" yapıyoruz:
        driver.switchTo().frame(0);

        //Kaynak(source) ve hedef(target) web elementlerini locate ediyoruz:
        WebElement source = driver.findElement(By.id("draggable"));


        Actions actions = new Actions(driver);
        //tikla, tut, su koordinata gelince birak
        // bu islemleri yapacagiz

        actions.clickAndHold(source).moveByOffset(388,34).release().build().perform();
        //moveByOffset()==> bu method ile istedigimiz yere tasiyabiliyourz


    }
}
