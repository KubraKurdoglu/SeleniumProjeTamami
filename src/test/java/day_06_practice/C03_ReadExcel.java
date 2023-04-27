package day_06_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class C03_ReadExcel {

    // Ulkeler dosyasındaki 3.satırdaki indexin, 3.sutunundaki indexinin
    // "Cezayir" oldugunu test eden method olusturunuz

    int satirNoIdx = 3;
    int sutunNoIdx = 3;

    @Test
    public void text01() throws IOException {

        int satirNoIdx = 3;
        int sutunNoIdx = 3;

        String actuelData = banaDataGetir(satirNoIdx, sutunNoIdx);
        String expectedData = "Cezayir";


        assertEquals(expectedData, actuelData);

    }

    public String banaDataGetir(int satirNoIdx, int sutunNoIdx) throws IOException {

        String dosyaYolu = "src/main/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //Ulkeler dosyasini bizim isitemimize getirdik.

        Workbook workbook = WorkbookFactory.create(fis);
        //Dosyayi workbook' a atadik

        String istenenData = workbook.getSheet("Sayfa1").getRow(satirNoIdx).getCell(sutunNoIdx).toString();

        //toString()==> yaptik, cunku yukardaki kodun parantezden sonraki kismi bize "cell" veriyor
        //onu String yaptik boylece

        return istenenData;
    }

}
