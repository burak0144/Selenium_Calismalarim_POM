package tests.day25;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DataProvider {
    @DataProvider
    public static Object[][] aranacakKelimeler() {
        return new Object[][]{{"java"},{"selenium"},{"samsung"},{"iphone"}};
    }

    @Test(dataProvider = "aranacakKelimeler")
    public void test01(String kelimeler) {
        AmazonPage amazonPage = new AmazonPage();
        //amazona gidelim
        Driver.getDriver().get("https://www.amazon.com");
        //java, selenium, samsung ve iphone icin arama yapalim
        amazonPage.amazonAramaKutusu.sendKeys(kelimeler, Keys.ENTER);
        //sonuclarin aradigimiz kelime icerdigini test edelim
        String actualKelime = amazonPage.sonucYazisiElementi.getText();
        Assert.assertTrue(actualKelime.contains(kelimeler));
        //sayfayi kapatalim
        Driver.closeDriver();
    }
}