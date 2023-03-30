package day07;

import org.junit.*;

public class C04_BeforeClassAfterClass {

    /*
    @BeforeClass ve @AfterClass notasynlari sadece static methodlar ile calisir.

     */

    @BeforeClass
    public static void setUp(){
        System.out.println("Tum testlerden once bir kez calisir");
        System.out.println("=========");
    }

    @AfterClass
    public static void tearDown(){
        System.out.println("Her testen sonra bir kez calisir");//bunu nereye yazarsan yaz tum testlerden sonra calisir
        System.out.println("=========");
    }

    @Before
    public void setUp01(){
        System.out.println("her testen once calisir");

    }


    @After

    public void tearDown01(){
        System.out.println("Her testen sonra calisir");
    }


    @Test
    public void test01(){

        System.out.println("Ilk Test");
        System.out.println("=========");
    }

    @Test
    public void test02(){

        System.out.println("Ikinci Test");
        System.out.println("=========");
    }

    @Test
    public void test03(){

        System.out.println("Ucuncu Test");
        System.out.println("=========");
    }








}
