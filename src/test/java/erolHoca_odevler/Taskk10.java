package erolHoca_odevler;

public class Taskk10 {
    /*
    //https://www.selenium.dev/downloads/ adresine gidelim
//Sayfanın resmini alalım
//Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
//Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
//Documentation webelementinin resmini alalım
//All versions available in Downloads altında Latest stable release olan linki tıklayalım
//Açılan pencerede chromedriver'i indirelim
//Driver'in indiğini doğrulayalım
//İndirmiş olduğumuz dosyayı silelim
//Silindiğini doğrulayalım
//Not: Bu task'in her adımı için Html rapor oluşturalım(Extent Report)
    ExtentTest extentTest;
    ExtentReports extentReports;
    ExtentHtmlReporter extentHtmlReporter;
    @Test
    public void test01() {
        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");
        extentTest.info("Selenium downloads sayfasına gidildi");
        //Sayfanın resmini alalım
        tumSayfaResmi();
        extentTest.info("Sayfa resmi alındı");
        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        WebElement Browser = driver.findElement(By.xpath("(//h2)[8]"));
        scrollIntoView(Browser);
        extentTest.info("Browsers bölümü görünene kadar sayfayı indirdik");
        bekle(3);
        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        driver.findElement(By.xpath("//button[@data-target='#supported-browsers']")).click();
        WebElement documentation = driver.findElement(By.xpath("(//a[text()='documentation'])[5]"));
        documentation.click();
        extentTest.info("Documentation linkine tıkladık");
        //Documentation webelementinin resmini alalım
        WebElement cHDDocumentation = driver.findElement(By.id("yDmH0d"));
        webElementResmi(cHDDocumentation);
        extentTest.info("Documentation webelementinin resmini aldık");
        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        bekle(3);
        driver.findElement(By.xpath("(//a[@class='XqQF9c'])[5]")).click();
        extentTest.info("Latest stable release olan linki tıkladık");
        //Açılan pencerede chromedriver'i indirelim
        switchToWindow(1);
        driver.findElement(By.xpath("//a[text()='chromedriver_win32.zip']")).click();
        extentTest.info("Açılan pencerede chromedriver'i indirdik");
        //Driver'in indiğini doğrulayalım
        String userHOME = System.getProperty("user.home");
        boolean isExist = Files.exists(Paths.get(userHOME +"/Desktop/chromedriver.exe"));
        assertTrue(isExist);
        extentTest.info("Driver'in indiğini doğruladık");
        //İndirmiş olduğumuz dosyayı silelim
        File indirilen=new File(userHOME + "/Desktop/chromedriver.exe");
        indirilen.delete();
        extentTest.info("İndirmiş olduğumuz dosyayı sildik");
        //Silindiğini doğrulayalım
        assertFalse(Files.exists(Path.of(userHOME + "/Desktop/chromedriver.exe")));
        extentTest.info("Silindiğini doğruladık");
        //Not: Bu task'in her adımı için Html rapor oluşturalım(Extent Report)
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/reports/extentReport_"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("SDET","Ceren");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("HTML Raporu");
        extentTest=extentReports.createTest("ExtentTest","Test Raporu");
        //Her adımın altına ne yaptığımızı belirten bilgileri yazdık.
        extentTest.pass("Test sonlandırıldı");
        extentReports.flush(); //raporu kapatip sonlandiriyor
    }

     */
}
