package day_04_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class C01_Iframe extends TestBase {

    // https://html.com/tags/iframe sayfasına gidiniz
    // Videoyu görecek kadar asagiya ininiz
    // Videoyu izlemek icin Play tusuna basiniz
    // Videoyu calistirdiginizi test ediniz
    // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
    @Test
    public void test01() throws InterruptedException {

        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");

        // Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);

        // Videoyu izlemek icin Play tusuna basiniz
        //(video frame icinde o nedenle "iframe " kullanmaliyiz)

        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);

        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();


        // Videoyu calistirdiginizi test ediniz
        //videonun calsitigini anlamak icin video kisminda, youtube yazdigini gormek lazim
        //yada video acildiginda, video ile ilgili ayarlar vs. gorunuyordur oaralari locate edebilirsin
        WebElement youtubeYazisi = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        assertTrue(youtubeYazisi.isDisplayed());


        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz

        //bunun icin once iframe den cikmak gerekiyor

        driver.switchTo().parentFrame();
        WebElement powerYazisi = driver.findElement(By.xpath("//span[@id='Powerful_but_easy_to_misuse']"));
        assertTrue(powerYazisi.isDisplayed());
    }
}
