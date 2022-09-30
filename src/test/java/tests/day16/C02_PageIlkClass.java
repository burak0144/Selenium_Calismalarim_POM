package tests.day16;


import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageIlkClass {
    @Test
    public void test01() {

        Driver.getDriver().get("https://amazon.com");
        // arama kutusuna "Nutella" yazip aratalim
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("Nutella", Keys.ENTER);
        // arama sonuclarinin "Nutella" icerdigini test edelim
        String actualSonucStr=amazonPage.sonucYazisiElementi.getText();
        Assert.assertTrue(actualSonucStr.contains("Nutella"));

        Driver.closeDriver();
}
    @Test
    public void test02() {
        //amazona gidelim
        Driver.getDriver().get("https://www.amazon.com");
        //java icin arama yapalim
       AmazonPage amazonPage=new AmazonPage();
       amazonPage.amazonAramaKutusu.sendKeys("java",Keys.ENTER);
        //sonucun java icerdigini teset edelim
        String sonucYazisiStr=amazonPage.sonucYazisiElementi.getText();
        Assert.assertTrue(sonucYazisiStr.contains("java"));
        Driver.closeDriver();

    }
}