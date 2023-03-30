package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class C01_MavenIlkTest {
    /*
        https://www.amazon.com/ sayfasına gidelim
        Arama kutusunu locate edelim
        “Samsung headphones” ile arama yapalım
        Bulunan sonuç sayısını yazdıralım
        İlk ürünü tıklayalım
        Sayfadaki tüm başlıkları yazdıralım
     */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //burda direk driver objesi olustirmadan da get diyerek devam edilebilir
        //ama obje yi tekrar tekrar kullanacagimiz icin, obje ilusturmak daha mantikli



        //https://www.amazon.com/ sayfasına gidelim
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();

        //Arama kutusunu locate edelim
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));



        //“Samsung headphones” ile arama yapalım
        aramaKutusu.sendKeys("Samsung headphones");//istersek submit yerine buraya de keys.ENTER azabilirdik
        aramaKutusu.submit();///Enter'a submit ile basmis olduk


        //Bulunan sonuç yazisini yazdıralım
        WebElement aramasonucu=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        System.out.println("aramasonucu: " +aramasonucu.getText());

        //İlk ürünü tıklayalım
        // WebElement ilkUrun= driver.findElement(By.xpath("(//img[@class='s-image'])[1)"));
        //ilkUrun.click();//tiklayalim deidigi icin "click" yazdi
        //Tum arama sonucu urunleri list icine koyup ilk elemani tikliyoruz


        List<WebElement> urunListesi= driver.findElements(By.xpath("//img[@class='s-image']"));
        urunListesi.get(0).click();

        //Sayfadaki tüm başlıkları yazdıralım
        //basliklari yazdir dedigi icin, basliklar "h" ile basliyor "//h" ile arama yaptiriyoruz
        //h1 ile , sitede baktik bir sonuc var


        List<WebElement> basliklar= driver.findElements(By.xpath("//h1"));
        //tek tek yazdirma yerine foreach ile yazdirmak daha mantikli

        for (WebElement w: basliklar){//webelement yazdik cunku aldigimiz seyler bu turde
            System.out.println(w.getText());
        }
        /*
        About this item
        Warranty & Support
        Feedback
        (sonuc boyle, bunlar basliklar)
         */

        //BAZI SIRKETLERDE DAHA KISSA KOD YAZILMASI ISTENEBILIR. YANI FOREACH KULLANMAMAK GEREKEBILIR
        //BU DUURMDA LAMBDA KULLANILABILIR

        basliklar.forEach(t-> System.out.println(t.getText()));
        // basliklar.stream()==> ilk basta boyle yazdi hoca, sonra stream'i kaldirdi
        //stream da ayni sonucu verir


        //sayfayi kapatiniz
        driver.close();

    }
}
