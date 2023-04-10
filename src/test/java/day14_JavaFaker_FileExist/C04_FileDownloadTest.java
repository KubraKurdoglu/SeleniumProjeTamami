package day14_JavaFaker_FileExist;

import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertTrue;

public class C04_FileDownloadTest extends TestBase {

        /*
     "https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
     "b10 all test cases" dosyasını indirin
      Dosyanın başarıyla indirilip indirilmediğini test edin.
     */

    @Test
    public void fileDowloadTest() throws InterruptedException {

        // " "https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
        //     "b10 all test cases" dosyasını indirin
        //      Dosyanın başarıyla indirilip indirilmediğini test edin."   adresine gidin

        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //     "b10 all test cases" dosyasını indirin

        driver.findElement(By.linkText("b10 all test cases, code.docx")).click();
        Thread.sleep(2000);

        //      Dosyanın başarıyla indirilip indirilmediğini test edin.

        String filePath = System.getProperty("user.home")+"/Downloads/b10 all test cases, code.docx";
                                    ///Users/kubra==>bu kismi dinamik hale getirdi

        boolean isExist = Files.exists(Path.of(filePath));
        assertTrue(isExist);




    }
    //hocanin yazdigi kod
    /*
      @Test
    public void fileDownloadTest(){
//        "https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

//        "b10 all test cases" dosyasını indirin
        driver.findElement(By.linkText("b10 all test cases, code.docx")).click();
        bekle(2);

//        Dosyanın başarıyla indirilip indirilmediğini test edin.
        String filePath = System.getProperty("user.home")+"/Downloads/b10 all test cases, code.docx";
                                  //C:\Users\TechProEd

        boolean isExist = Files.exists(Path.of(filePath));
        assertTrue(isExist);
    }
     */

}
