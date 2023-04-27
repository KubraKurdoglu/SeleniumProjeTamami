package day20_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class C01_ExcelRead {
    @Test
    public void excelReadTest() throws IOException {

    /*
    Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
    3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
    Kullanılan satır sayısın bulun
    Ülke-Başkent şeklinde verileri yazdırın
     */
        //Excel dosyasindan bir veri okuyabilmemiz icin


        //1. Dosya yolunu aliriz
        String dosyaYolu = "/Users/kubra/IdeaProjects/B129SeleniumMavenJunit/src/test/java/resources/Capitals.xlsx";
        String dosyaYolu1 = "/Users/kubra/Desktop/Capitals.xlsx";// bu dosya yolunu kullandim
        String dosyaYolu2 = "Capitals.xlsx";

        //2-Dosyayi okuyabilmek icin onu akisa almamiz gerekiyor
        FileInputStream fis = new FileInputStream(dosyaYolu1);

        //3- java ortaminda bir excel dosyasi olusturmamiz gerekir
        Workbook workbook = WorkbookFactory.create(fis);//create(fis) ile excel de bu dosyayi okuruz.

        //4-Excel'deki hangi sayfayi mudahale edeceksek, onu secmemiz gerekir.
        Sheet sheet = workbook.getSheet("Sheet1");

        //5- Satir(row) secmemiz gerekir
        Row row = sheet.getRow(0);//1.satir cunku "index" sifirdan baslar

        //6-Hucreyi secmemiz gerekir
        Cell cell = row.getCell(0);//1.sutun cunku "Index" sifirdan baslar
        System.out.println(cell);

        //NOTE:==> veri yazarken ve okurken Excel dosyasinin kapali olmasi lazim
        //yoksa hata alirsin. kapali oldugunu renginin kirmizi olmadigidan anlarsin

    }

    @Test
    public void test01() throws IOException {
        FileInputStream fis = new FileInputStream("/Users/kubra/Desktop/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);

        //1.satir 1.sutun icin
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(0).toString());

        //Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın

        //1.YOL
        Sheet sheet = workbook.getSheet("Sheet1");
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(1);
        System.out.println("1.satir 2. sutun bilgisi: " + cell);

        //2.YOL
        //1.satir 2.sutun icin
        System.out.println("1.satir 2. sutun bilgisi: " + workbook.getSheet("Sheet1").getRow(0).getCell(1).toString());


        //3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        String satir3sutun1 = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println("satir3sutun1 = " + satir3sutun1);
        assertEquals("France", satir3sutun1);

        //Kullanilan satir sayisini bulun
        System.out.println("Son satir sayisi " + workbook.getSheet("Sheet1").getLastRowNum());

        //Excel tablosundaki son satir saysini getSheet("Sheet1") ile belirledikten sonra getLastRowNum()
        //methodu kullanabiliriz
        System.out.println(workbook.getSheet("Sheet1").getPhysicalNumberOfRows());


        //Excel tablosunda kullanilan satir sayisini getPhysicalNumberOfRows() methodu ile alabiliriz

        System.out.println("Son sutun sayisi " + workbook.getSheet("Sheet1").getRow(0).getLastCellNum());
        System.out.println("Kullanilan sutun sayisi: " + workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells());


        //Ülke-Başkent şeklinde verileri yazdırın

        Map<String, String> ulkeVeBaskentler = new HashMap<>();

        for (int index = 0; index < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); index++) {
            String ulke = workbook.getSheet("Sheet1").getRow(index).getCell(0).toString();
            String baskent = workbook.getSheet("Sheet1").getRow(index).getCell(1).toString();
            ulkeVeBaskentler.put(ulke, baskent + "\n");

        }
        System.out.println("ulkeVeBaskentler = " + ulkeVeBaskentler);


    }

    @Test
    public void readExcelTest4() throws IOException {
        FileInputStream fis = new FileInputStream("/Users/kubra/Desktop/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        //Ülke-Başkent şeklinde verileri yazdırın
        for (int i = 0; i < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); i++) {
            for (int j = 0; j < workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells(); j++) {
                System.out.print(workbook.getSheet("Sheet1").getRow(i).getCell(j) + "\t");
            }
            System.out.println();
        }


    }
}
