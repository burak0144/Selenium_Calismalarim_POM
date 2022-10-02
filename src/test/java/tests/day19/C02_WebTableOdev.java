package tests.day19;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.HotelRoomAdminWebTables;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class C02_WebTableOdev {
    HotelRoomAdminWebTables hotelRoomAdminWebTables;
    //Bir class oluşturun : D18_WebTables

    @Test
    public void login() {
        //● login( ) metodun oluşturun ve oturum açın.
    //● https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
    //○ Username : manager ○ Password : Manager1!
        Driver.getDriver().get(ConfigReader.getProperty("HMCRoomUrl"));

        hotelRoomAdminWebTables=new HotelRoomAdminWebTables();
        hotelRoomAdminWebTables.bekle(3);
        Actions actions=new Actions(Driver.getDriver());

        actions.click(hotelRoomAdminWebTables.userName)
                .sendKeys(ConfigReader.getProperty("HMCRoomUsername"))
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("HMCRoomPassword"))
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
    }

    @Test(dependsOnMethods ="login" )
    public void table() {
    //● table( ) metodu oluşturun
    //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun.//thead//tr//th
        System.out.println("==============sutun sayisi");
        hotelRoomAdminWebTables=new HotelRoomAdminWebTables();
        List<WebElement>sutunList=hotelRoomAdminWebTables.sutunList;
        System.out.println("sutun sayisi :"+sutunList.size());

    //○ Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
          //tbody/tr (satirlar)
          ////thead//tr[1]  (basliklar)
        System.out.println("===========tum body ve basliklar");
        System.out.println(hotelRoomAdminWebTables.basliklar.getText());
        hotelRoomAdminWebTables.satirlar.forEach(t-> System.out.println(t.getText()));
        Driver.closeDriver();


    }

    @Test(dependsOnMethods ="login" )
    public void printRows() {
        hotelRoomAdminWebTables=new HotelRoomAdminWebTables();
    //● printRows( ) metodu oluşturun
    //○ table body’sinde bulunan toplam satir(row) sayısını bulun.//tbody/tr
        System.out.println("=============body'de ki satir sayisi");
        System.out.println("body'deki satir sayisi :"+hotelRoomAdminWebTables.satirlar.size());
        //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        System.out.println("============satirlar");
        hotelRoomAdminWebTables.satirlar.forEach(t-> System.out.println(t.getText()));
    //○ 4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println(hotelRoomAdminWebTables.satirlar.get(3).getText());
        Driver.closeDriver();
    }



    @Test(dependsOnMethods ="login" )
    public void printCells() {

    //● printCells( ) metodu oluşturun //td
    //○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        System.out.println("=============hucre sayisi");
        hotelRoomAdminWebTables=new HotelRoomAdminWebTables();
        System.out.println("hucre sayisi :"+hotelRoomAdminWebTables.hucreler.size());
        //○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        hotelRoomAdminWebTables.hucreler.forEach(t-> System.out.println(t.getText()));
        Driver.closeDriver();
}

    @Test(dependsOnMethods ="login" )
    public void printColumns() {
        //● printColumns( ) metodu oluşturun
        //○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
        System.out.println("============toplam sutun sayisi");
        hotelRoomAdminWebTables=new HotelRoomAdminWebTables();
        System.out.println("toplam column sayisi :"+hotelRoomAdminWebTables.sutunList.size());
        //○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        System.out.println("=============table tablosundaki sutunlar");
        hotelRoomAdminWebTables.sutunList.forEach(t-> System.out.println(t.getText()));
        //○ 5.column daki elementleri konsolda yazdırın.
        System.out.println("=================5.sutundaki elementler");
        hotelRoomAdminWebTables.xSutunundakiElementler(5);
        Driver.closeDriver();
    }
}