package tests.day18;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import pages.HotelMyCampPageWebTables;

import java.util.List;

public class C02_WebTables {
    HotelMyCampPageWebTables hotelMyCampPageWebTables;

    @Test
    public void loginT() {

        //● login( ) metodun oluşturun ve oturum açın.
        //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        //○ Username : manager
        //○ Password : Manager1!
        hotelMyCampPageWebTables= new HotelMyCampPageWebTables();
        hotelMyCampPageWebTables.girisYap();
    }

    @Test(dependsOnMethods ="loginT" )
    public void table() {

    //● table( ) metodu oluşturun
    //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. //thead//tr[1]//th
        System.out.println("============header yani sutun sayisi");
      List<WebElement> headerDataList=hotelMyCampPageWebTables.headerBirinciSatirDatalar;
        System.out.println("tablodaki sutun sayisi  = " + headerDataList.size());

        // header kisminda birinci satir ve altindaki datalari locate edelim
    //      //thead//tr[1]//th"
        System.out.println("============Header kismindaki 1. satir");
        for (WebElement w:headerDataList
             ) {
            System.out.println(w.getText());
        }
      //  headerDataList.forEach(t-> System.out.println(t.getText()));
    //○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
    // //table basliklarla birlikte yazdirir  yada   //tbody basliksiz butun table yazar
        System.out.println("==========tum datalar tek String halinde");
       WebElement tumBody=hotelMyCampPageWebTables.tumBodyveHeader;
        System.out.println(tumBody.getText());
    // eger body'i tek bir webelement olarak locate edersek
    // icindeki tum datalari gettext() ile yazdirabiliriz
    // ancak bu durumda bu elementler ayri ayri degil body'nin icindeki tek bir String'in parcalari olurlar
    // dolayisiyla bu elementlere tek tek ulasmamiz mumkun olmaz
    // sadece contains methodu ile body'de olup olmadiklarini test ederiz

    // eger her datayi ayri ayri almak istersek
    ////tbody//tr//td yada //tbody//td   sekline locate edip bir list'e atabiliriz.
        System.out.println("==========tum datalar ayri ayri");
        List<WebElement>tumBodyList=hotelMyCampPageWebTables.tumBodyDatalarList;
        tumBodyList.forEach(t-> System.out.println(t.getText()));
}

    @Test(priority = 2,dependsOnMethods = "loginT")
    public void printRows() {

    //● printRows( ) metodu oluşturun //tr

    //○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        //sayet baslik larla alacak olsaydik //tr olurdu ama body'de dedigi icin //tbody//tr
        System.out.println("==============satirlarin boyutu");
      List<WebElement>satirlarList=hotelMyCampPageWebTables.satirlarListesi;
        System.out.println("satirlarListesinin Boyutu = " + satirlarList.size());
        //listeyi burayada alabiliriz almadan da yazdirilir

        System.out.println("============page sayfasindan direkt yazdirilir");
        System.out.println(hotelMyCampPageWebTables.satirlarListesi.size());
        //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        System.out.println("================satirlar listesi");
        satirlarList.forEach(t-> System.out.println(t.getText()));

    //○ 4.satirdaki(row) elementleri konsolda yazdırın
        System.out.println("============4.satir");
        System.out.println("4.satir = " + satirlarList.get(3).getText());
        //index 0 dan basladigindan dolayi 4.satir 3.index'te olur
    }
}