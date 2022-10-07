package tests.day21;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.HepsiburadaPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.IOException;

public class C02_Odev {
    Actions actions;
    HepsiburadaPage hepsiburadaPage;
    @Test
    public void testName() throws IOException {
        //Hepsiburada sayfasına gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));
        //Elektronik altında bilgisayar/tablet altındaki tüm linkleri tıklayalım
        //Her linkten sonra o sayfaya gittimizi test edelim ve o sayfanız resmini alalım
        //Sayfayı kapatalım

       hepsiburadaPage=new HepsiburadaPage();
       actions=new Actions(Driver.getDriver());


       hepsiburadaPage.weList();

      Driver.getDriver().close();
}
}