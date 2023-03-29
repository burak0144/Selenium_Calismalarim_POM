package tests.day16;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_HotelMyCampPositiveLogin {
    @Test
    public void pozitifLoginTesti() {

    //    1 ) Bir Class olustur : PositiveTest
    //    2) Bir test method olustur positiveLoginTest()
    //    https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get("https://www.hotelmycamp.com/");
    //    login butonuna bas
        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.giris1.click();
        hotelMyCampPage.giris2.click();
        hotelMyCampPage.ilkLoginLinki.click();
    //    test data username: manager ,
     //   hotelMyCampPage.userNameBox.sendKeys("manager");
        hotelMyCampPage.userNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
    //    test data password : Manager1!
        hotelMyCampPage.passwordBox.sendKeys("Manager1!");
        hotelMyCampPage.loginButonu.click();
    //    Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        String actualText=hotelMyCampPage.basariliGirisYazisiElementi.getText();
        Assert.assertTrue(actualText.contains("LISTOFUSERS"));

        //UI da gorunen yazilmalidir "LISTOFUSERS"
}
}