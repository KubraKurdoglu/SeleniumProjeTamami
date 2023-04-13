package day16_Exceptions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilities.TestBase;

public class C03_NullPointerException extends TestBase {

    //Butun class'larin default degerleri "null" dir. cunku classs'lar non-primitive'dir


    WebDriver driver;
    Faker faker;
    Integer number;
    String name;

    //WebDriver==> non primitive bir data, bu class'ta on abir deger atamasi yapilmadigi icin
    //NullPointer hatasi verdi.
    @Test
    public void nullPointerExceptionTest1(){
        driver.get("https://www.techproeducation.com");
    }

    @Test
    public void nullPointerExceptionTest2(){

        //faker= new Faker();
        System.out.println(faker.number().numberBetween(1,10));//java.lang.NullPointerException

        /*
        String name = null;
        System.out.println(name.charAt(0));//nullpointerexception verecek, bu exception java dan gelir

         */
    }

    @Test
    public void nullPointerExceptionTest3(){

        System.out.println(number+6);//java.lang.NullPointerException

    }


    @Test
    public void nullPointerExceptionTest4(){
        //name = "Ali";
        System.out.println(name.charAt(0));
    }

}
