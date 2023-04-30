package forGitHup;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GithupDolsun extends TestBase {

        // 1- https://www.amazon.com sayfasina gidelim
        // 2- url'in 'amazon' icerdigini test edelim
        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        // 4- title'in 'Best Buy' icerdigini test edelim
        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        // 6- arama sonuclarının 'Java' icerdigini test edelim
        // 7- ikinci sayfaya(bestbuy) donelim
        // 8- logonun gorundugunu test edelim

        @Test
        public void test01() throws InterruptedException {
            // 1- https://www.amazon.com sayfasina gidelim
            driver.get("https://www.amazon.com");
            String amazonHandleDegeri = driver.getWindowHandle();

            // 2- url'in 'amazon' icerdigini test edelim

            String amazonURL =driver.getCurrentUrl();
            assertTrue(amazonURL.contains("amazon"));

            // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
            driver.switchTo().newWindow(WindowType.WINDOW);
            driver.get("https://www.bestbuy.com");
            String bestBuyHandle =driver.getWindowHandle();

            // 4- title'in 'Best Buy' icerdigini test edelim
            String bestBuyTitle =driver.getCurrentUrl();
            assertFalse(bestBuyTitle.contains("Best Buy"));

            // 5- ilk sayfaya(amazon) donup sayfada java aratalım
            //ilk sayfaya donebilmke icin, ilk sayfanin handle degerini bilmem ve onu parantez icine yazmam lazim
            //yukarda amazon'a gittigmiz kismin altinada handle degerini bulduk

            driver.switchTo().window(amazonHandleDegeri);
            driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java"+ Keys.ENTER);
            Thread.sleep(2000);

            // 6- arama sonuclarının 'Java' icerdigini test edelim
            WebElement aramaSonucu = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
            assertTrue(aramaSonucu.getText().contains("Java"));
            Thread.sleep(2000);


            // 7- ikinci sayfaya(bestbuy) donelim
            driver.switchTo().window(bestBuyHandle);

            // 8- logonun gorundugunu test edelim
            WebElement logo = driver.findElement(By.xpath("(//img[@class='logo'])[2]"));
            assertTrue(logo.isDisplayed());
            Thread.sleep(2000);




        }
    }


