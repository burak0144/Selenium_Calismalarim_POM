package tests.day19;

import org.testng.annotations.Test;
import pages.DemoqaWebTables;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_WebTableDemoqa {
    @Test
    public void testName() {

//Bir Class olusturun D19_WebtablesHomework
    //1. “https://demoqa.com/webtables” sayfasina gidin
     Driver.getDriver().get(ConfigReader.getProperty("DemoqaUrl"));
    //2. Headers da bulunan department isimlerini yazdirin
    //  normalde //thead//th olurdu ancak bu tablo class isimleri ile organize edilmis
        DemoqaWebTables demoqaWebTables = new DemoqaWebTables();
        System.out.println("=============basliklar");
        demoqaWebTables.basliklar.forEach(t-> System.out.println(t.getText()));

        //3. sutunun basligini yazdirin
        System.out.println("======3.sutunun basligi");
        System.out.println(demoqaWebTables.basliklar.get(2).getText());

        //4. Tablodaki tum datalari yazdirin
        System.out.println("===========tum datalar");
      // demoqaWebTables.dataList.forEach(t-> System.out.println(t.getText()));
        //bos datalarida yazdiriyor
        System.out.println("=======2.yol");
        System.out.println(demoqaWebTables.datalar.getText());

        //5. Tabloda kac cell (data) oldugunu yazdirin
        System.out.println("===========data size");
        System.out.println(demoqaWebTables.dataList.size());

        //6. Tablodaki satir sayisini yazdirin
        System.out.println("============satir sayisi");
        System.out.println(demoqaWebTables.satirList.size());
        //7. Tablodaki sutun sayisini yazdirin
        System.out.println("==========sutun sayisi");
    //farkli yollardan hesaplanabilir ama biz hucre sayisi /satir sayisi yapalim
        System.out.println(demoqaWebTables.dataList.size() / demoqaWebTables.satirList.size());
        //8. Tablodaki 3.kolonu yazdirin
        System.out.println("==========3.kolon");
       demoqaWebTables.xKolonuYazdir(3);
    //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        System.out.println("=========First Name'i Kierra olan kisinin Salary'si");
      demoqaWebTables.getSalary("Kierra");
    //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini
    //girdigimde bana datayi yazdirsin
        System.out.println("==========satir ve sutun verip cell yazdir");
        demoqaWebTables.getCell(3,5);
}
}