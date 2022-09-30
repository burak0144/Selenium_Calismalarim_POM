package tests.day16;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_HotelMyCampNegativeLogin {
    @Test
    public void NegativeLoginTest() {
        //1 ) Bir Class olustur : NegativeTest
        //2) Bir test method olustur NegativeLoginTest()
        //https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        //login butonuna bas
        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.ilkLoginLinki.click();
        //test data username: manager1 ,
        hotelMyCampPage.userNameBox.sendKeys(ConfigReader.getProperty("HMCWrongUsername"));
        //test data password : manager1!
        hotelMyCampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCWrongPassword"));
        hotelMyCampPage.loginButonu.click();
        //Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hotelMyCampPage.girisYapilamadiYaziElementi.isDisplayed());

    }

}
