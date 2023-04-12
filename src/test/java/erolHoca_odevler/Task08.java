package erolHoca_odevler;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task08 extends TestBase {
    //  -https://jqueryui.com/slider/#colorpicker adrese gidiniz
    //  -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
    //   -Sarı olduğunu test edelim

    @Test
    public void test01() throws InterruptedException {
        //(//span[@tabindex='0'])[2]


        //  -https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");

        //  -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        driver.switchTo().frame(0);

        Actions actions = new Actions(driver);
        WebElement kirmizi =driver.findElement(By.xpath("//div[@id='red']"));
        WebElement yesil =driver.findElement(By.xpath("//div[@id='green']"));
        WebElement mavi =driver.findElement(By.xpath("//div[@id='blue']"));




        actions.dragAndDropBy(kirmizi, 150, 0).release().build().perform();
        actions.dragAndDropBy(yesil, -150, 0).release().build().perform();
        actions.dragAndDropBy(mavi, -150, 0).release().build().perform();
        Thread.sleep(2000);


        //   -Sarı olduğunu test edelim


        actions.dragAndDropBy(yesil, 150, 0).release().build().perform();
        bekle(2);
        actions.dragAndDropBy(mavi, -150, 0).release().build().perform();
        bekle(2);



        WebElement sariMi = driver.findElement(By.xpath("//div[@id='swatch']"));
       String backgroundColor = sariMi.getCssValue("background-color");



       if(backgroundColor.equals("rgb(255, 255, 0)")){
           System.out.println("sari oldu");
       }else {
           System.out.println("sari olmadi");
       }




    }
}
