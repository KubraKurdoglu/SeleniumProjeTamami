package day09_DropDown_Alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class C01_DropDown {

    /*
    -DropDown Nedir: alt basliklarin  oldugu acilir menu.
    -DropDown nasil automate edilir?
        a-DropDown menuyu ilk olarak automete ederiz.
        b-Select objesi olustururuz
        c-Select objesinin dropdown menu webelementinin icerigine ve seceneklerine
        erisim saglamasi icin SELECT sinifina arguman olarak locate ettigimiz
        webelementi koyariz.

        SYNTAX: Select select = new Select(ddm webelement);

       d-Select Class'i, sadece <select> tag'i olusturulmus dropdown menulere uygumanabilir
       e- Select objesi ddm'yi handle edebilmke icin 3 method kullanir
            -selectByIndex()==> ddm deki elemente gorunur metin ile ulasmak icin kullanilir
            -selectByVisibletext()==> Index ile ulasmak icin kullanilir(index 0'dan baslar)
            -selectByValue()==>elementin degeri ile ulasmak icin kullanilir(option tag'indaki deger ile)
            ornegin (value=year) gibi
       f-getOptions()->Locate ettiğimiz ddm'deki tüm seçenekleri bize döndürür

       g-getFirstSelectedOption()->Ddm'deki en son seçili kalan ilk seçeneği bize döndürür



           DropDown Nasıl Automate Edilir;
    ➢ Adim1: Dropdown menuyu herhangi bir locator ile locate edin.
                       WebElement ddm=driver.findElement(By.id("value of id"));
    ➢ Adim 2: Yeni bir "Select" objesi olusturun ve daha once locate ettigimiz WebElement'i parametre olarak yeni objeye ekleyin
                       Select options=new Select(ddm);
    ➢ Adim 3: Select class'indan kullanabileceginiz 3 yontemden biriyle dropdown menusundeki elemananlardan istediginizi secin
                      options.selectByIndex(1);
     */

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void test02() {
        /*
        //1.YOL
        //a. Tüm eyalet isimlerini yazdıralım
        WebElement tumEyaletler = driver.findElement(By.cssSelector("select[id='state']"));
        Select select = new Select(tumEyaletler);
        List<WebElement> stateList = select.getOptions();//Bütün options taglarını getir
        //for (WebElement w:stateList) {
        //    System.out.println(w.getText());
        // }
        stateList.forEach(t-> System.out.println(t.getText()));
         */
        //a. Tüm eyalet isimlerini yazdıralım
        //2.YOL
        List<WebElement> tumEyaletler = driver.findElements(By.xpath("//*[@id='state']//option"));
        System.out.println(tumEyaletler.get(2).getText());//Alaska(ikinci indeex'teki elemani yazdirdi)
        System.out.println("*****************************");
        tumEyaletler.forEach(t-> System.out.println(t.getText()));


        //b. Sayfadaki tüm ddm lerdeki tüm seçenekleri(option) konsolda yazdırınız
        System.out.println("******************************");
        List<WebElement> eyaletlerList = driver.findElements(By.tagName("option"));//BURAYA SELECT DE YAZABILIRIZ
        //tum hepsini al dedigi icin tum "option'lari aldi
        eyaletlerList.forEach(t-> System.out.println(t.getText()));
        System.out.println(tumEyaletler.size());//52
    }
    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }


}
