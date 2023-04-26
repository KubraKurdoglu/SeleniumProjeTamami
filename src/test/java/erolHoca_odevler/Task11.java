package erolHoca_odevler;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task11  {


 /*
-İki tane test methodu oluşturalım
-İlkinde masaüstünde java ile data.xlsx isimli bir dosya oluşturalım
-Birinci satır birinci hücreye email ve ikinci hücreye password
-ikinci satır birinci hücreye evren.techproed@gmail.com ve ikinci hücreye asdfgh yazdıralım
-Dosyayı kaydedelim
-İkinci methodda https://www.bluerentalcars.com/ adresine gidip
-Excel dosyasından aldığımız kullanıcı bilgileri ile login olalım
-Login olduğumuzu doğrulayalım
 */

    @Test
    public void test01() throws IOException {
        Workbook workbook = WorkbookFactory.create(new FileInputStream("/Users/kubra/IdeaProjects/B129SeleniumMavenJunit" +
                "/src/main/resources/java ile data.xlsx"));

        Sheet sheet1 = workbook.getSheet("Feuil1");

        Cell yeniHucreEamil = sheet1.getRow(0).createCell(0);
        yeniHucreEamil.setCellValue("Email");

        Cell yeniHucrePassWord = sheet1.getRow(0).createCell(1);
        yeniHucrePassWord.setCellValue("PassWord");

        sheet1.getRow(1).createCell(0).setCellValue("evren.techproed@gmail.com");
        sheet1.getRow(1).createCell(1).setCellValue("asdfgh");

        FileOutputStream fileOutputStream = new FileOutputStream("/Users/kubra/IdeaProjects/B129SeleniumMavenJunit" +
                "/src/main/resources/java ile data.xlsx");
        workbook.write(fileOutputStream);

    }
}
