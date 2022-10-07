package tests.day22;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class C01_TestNGReports extends TestBaseRapor {
    //TestNG'de rapor alabilmek icin oncelikle TestBaseRapor clasina extends etmeliyiz
    //bu sekilde @Test annotation'undan once @BeforeTest calisir
    //extentTestReports ile test report olusturulup extentTest'e atariz
    //extentTest ile info methoduyla bilgi verilir
    //extentTest ile pass methoduyla testin pass oldugu rapor edilir
    //extentTest ile fail methoduyla testin fail oldugu rapor edilir ve ss goruntu alinir
    //browserda acabilmek icin de explorer dosyasi acildiginda ss alindigi raporla birlikte gorulecektir
    //ss sadece test fail oldugunda alinir
    @Test
    public void windowHandlereusableTest() throws IOException {
       extentTest=extentReports.createTest("Window Handle","title ile 2.sayfaya giris yapildigi test edildi");
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
       extentTest.info("herokuapp sayfasina gidildi");
        Driver.getDriver().findElement(By.xpath("(//a[@target='_blank'])[1]")).click();
       extentTest.info("yeni window linkine tiklandi");
        ReusableMethods.switchToWindow("New Window");
       extentTest.info("resuable method kullanarak acilan 2.sayfaya gecildi");
        String expectedTitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);
        extentTest.pass("title'in expected title ile ayni oldugu test edildi");

      // String expectedTitle2="New Window2";
      // Assert.assertEquals(actualTitle,expectedTitle2);
      // extentTest.fail("title'in expected title ile ayni olmadigi test edildi");
      //requreimenta gore sonuc fail oluyorsa raporda fail vermek icin yukardaki gibi islem yapip
        //ss alinabilinir



    }
}
