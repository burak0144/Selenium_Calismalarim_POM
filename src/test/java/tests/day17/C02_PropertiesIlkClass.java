package tests.day17;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_PropertiesIlkClass {
    @Test
    public void positiveLoginTesti() {
        // Hotelmycamp sitesine positive login testini POM' a tam uygun olarak yapiniz.

        //     https://www.hotelmycamp.com/  adresine git
        //Driver.getDriver().get("buraya yapistirmak icin, properties dosyasina git HMCUrl'e karsilik gelen degeri getir..");
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        //     Login butonuna bas
        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.giris1.click();
        hotelMyCampPage.giris2.click();
        hotelMyCampPage.ilkLoginLinki.click();
        //     test data username: manager ,
        hotelMyCampPage.userNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        //     test data password: Manager1!
        hotelMyCampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        hotelMyCampPage.loginButonu.click();
        hotelMyCampPage.bekle(4);
        //     Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(hotelMyCampPage.basariliGirisYazisiElementi.isDisplayed());
        Driver.closeDriver();
    }
}
