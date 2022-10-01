package tests.day17;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_SingletonPattern {
    @Test
    public void test01() {
        // singleton pattern:  bir class'dan birden fazla obje uretilmesine
        // izin vermeyen bir pattern olarak kabul gormustur

        // biz Driver class'ini driver uretmek uzere kullaniyoruz
        // ancak driver class'inda driver isminde bir instance variable da var
        // ve biz obje ureterek bu instance driver'a ulasabiliriz

        //Driver driver1=new Driver();
       // driver1.getDriver().get(ConfigReader.getProperty("AmazonUrl"));


        // SingletonPattern kabul gormus bir pattern'dir
        // amac bir class'dan obje uretilmemesini saglamaktir
        // bunun icin singleton pattern'de koruyacagimiz class'da
        // parametresiz bir constructor
        // olusturur ve bu constructor'u private yapariz.

         /*
        SingletonPattern : tekli kullanım demektir. Bir class'ın farklı class'lardan
        obje oluşturarak kullanımını engellemektir.
         */
        //Singleton Pattern -> tekli kullanim, bir class'in farkli class'lardan
// obje olusturularak kullanimini engellemek icin kullanilir.
// Bunu saglamak icin yapmamiz gereken sey oldukca basit
// obje olusturmak icin kullanilan constructor'i private yaptiginizda
// baska class'larda Driver class'indan obje olusturulmasi mumkun OLAMAZ
    }
}