package day18_ScreenShot;

import org.junit.Test;
import utilities.TestBase;

public class C01_ScreenShot extends TestBase {

    @Test
    public void screenShotTest01(){
        //Techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");

        //sayfanin resmini alalim
        tumSayfaResmi();

        //sonra amazon sayfasina gidelim
        driver.get("https://amazon.com");


        //Amazon sayfasinin ekran goruntusunu alalim
        tumSayfaResmi();//method kullanarak tum ekran resmini aldik




    }


}
