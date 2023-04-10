package day14_JavaFaker_FileExist;

import com.github.javafaker.Faker;
import org.junit.Test;
import utilities.TestBase;

public class C02_JavaFaker {

    //java faker'i kullanabilmek icin faker kutuphanesine ihtiyac var

    @Test
    public void javaFakerTest(){

        //Faker ile iki yolla sahte veri uretebiliyoruz
        //1.Faker objesi olustur
        Faker faker = new Faker();

        //2. Yada Faker.instance() static methodu ile baslayabiliriz.
        Faker.instance();//bu sekilde de kullanbilirz
        //yukardaki static bir method oldugu icin onu da kullanabiliriz

        //Firstname yazdirin
        System.out.println(faker.name().firstName());
        //Tetslerde data kullanmaya DDL deniyor

        //lastName yazdirin
        System.out.println(Faker.instance().name().lastName());

        //Kullanici adi yazdiralim

        System.out.println(Faker.instance().name().username());
        //System.out.println(faker.name().username()); ==> buda olabilir

        System.out.println(faker.funnyName().name());//funnyName==> funynama objesi dondurdugu icin name' e atadi


        //meslek isimi yazdiralim
        System.out.println(faker.name().title());

        //sehir ismi yazdiralim

        System.out.println(faker.address().city());

        //eyalet yazdirin

        System.out.println(faker.address().state());

        //full adres yazdirin
        System.out.println(faker.address().fullAddress());

        //cep numarasi yazdirin
        System.out.println(faker.phoneNumber().cellPhone());

        //email yazdirin

        System.out.println(faker.internet().emailAddress());


        //posta kodu yazdirin
        System.out.println(faker.address().zipCode());

        //rastgele 15 haneli numara yazdirin
        System.out.println(faker.number().numberBetween(1,10000000));


    }
}
