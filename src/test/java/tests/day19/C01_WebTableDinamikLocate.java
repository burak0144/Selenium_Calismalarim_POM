package tests.day19;

import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import pages.HotelMyCampPageWebTables;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_WebTableDinamikLocate {
    // 3 test methodu olusturalim
    HotelMyCampPage hotelMyCampPage;
    HotelMyCampPageWebTables hotelMyCampPageWebTables;

    @Test
    public void satirYazdirTesti() {
   // 1. method satir numarasi verdigimde bana o satirdaki datalari yazdirsin
        hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.girisYap();
        hotelMyCampPageWebTables=new HotelMyCampPageWebTables();
        // 4. satiri yazdir   //tbody//tr[4]  index olarak 3
        hotelMyCampPageWebTables.satirYazdir(3);
    }

    @Test
    public void hucreGetirTesti() {
        // 2. method satir no ve data numarasi girdigimde verdigim datayi dondersin
        hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.girisYap();
        hotelMyCampPageWebTables=new HotelMyCampPageWebTables();
        //4. satirin 3. datasini getir
        //DIMAMIK XPATH YAZARKEN 1'E 1 HANGI SATIR SUTUN ISTENIYORSA YAZILIR CUNKU BURADA
        //XPATH ALINIRKEN  //tbody//tr[x]//td[y] ' DE INDEX'E BAKILMAZ
        //AMA GET() METHODUNU KULLANDIGIMIZDA INDEX DEVREYE GIRER VE BI USTTEKI ORNEKTE OLDUGU GIBI
        //ISTEDIGI SATIRIN GET() 'TE BIR EKSIGI YAZILIR77
        System.out.println("istediginiz satirdaki istediginiz hucre :"+hotelMyCampPageWebTables.hucreGetir(4, 3));
    }

    @Test
    public void sutunYazdirTesti() {
        // 3. sutun numarasi verdigimde bana tum sutun'u yazdirsin
        hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.girisYap();
        hotelMyCampPageWebTables=new HotelMyCampPageWebTables();
        hotelMyCampPageWebTables.sutunYazdir(3);
}
}