package tests.day19;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelRoomAdminWebTables;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_WebTableOdev {
    HotelRoomAdminWebTables hotelRoomAdminWebTables;
    //WebTables class’ini kullanin.

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
    public void printData() {
        //1. Bir metod oluşturun : printData(int row, int column);
        //a. Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu
        //hücredeki(cell) veriyi yazdırmalıdır.
        hotelRoomAdminWebTables=new HotelRoomAdminWebTables();
        hotelRoomAdminWebTables.printData(3,5);
      Driver.closeDriver();
    }

    @Test(dependsOnMethods ="login" )
    public void printDataTest() {
        //2. Baska bir Test metodu oluşturun: printDataTest( );
    //a. Ve bu metodu printData( ) methodunu cagirmak icin kullanin.
    //b. Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
    //c. yazdirilan datanin olmasi gereken dataya esit oldugunu test edin
        hotelRoomAdminWebTables=new HotelRoomAdminWebTables();

       String actualData=hotelRoomAdminWebTables.printData(3,5);
       String expectedData="USA";
        Assert.assertEquals(actualData,expectedData);
}
}