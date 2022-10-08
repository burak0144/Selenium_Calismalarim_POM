package tests.day25;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProvider {

    @DataProvider
    public static Object[][] kullanicilar() {
        return new Object[][]{{"berk@gmail.com", "23432"}, {"karanfil@gmail.com", "234234"}, {"kara@hotmail.com", "323452"}};
    }

    @Test(dataProvider = "kullanicilar")
    public void testName(String userEmail, String password) {

        //https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get("https://www.bluerentalcars.com/");
        //login butonuna bas
        BrcPage brcPage = new BrcPage();
        brcPage.ilkLogin.click();
        //Data provider ile 3 farklı userEmail ve 3 farklı password girelim
        brcPage.email.sendKeys(userEmail);
        brcPage.password.sendKeys(password);
        //-login butonuna tiklayin
        brcPage.login.click();

        //Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(brcPage.login.isDisplayed());
    Driver.closeDriver();
    }
}
