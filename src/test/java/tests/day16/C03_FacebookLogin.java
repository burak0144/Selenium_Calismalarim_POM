package tests.day16;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C03_FacebookLogin {
    @Test
    public void pozitifLogin() {
        // 1 - https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");
        FacebookPage facebookPage = new FacebookPage();
        // 2- POM’a uygun olarak email, sifre kutularini ve giris yap
        // butonunu locate edin
        // 3- Faker class’ini kullanarak email ve sifre degerlerini
        // yazdirip, giris butonuna basin
        Faker faker=new Faker();
        facebookPage.emailKutusu.sendKeys(faker.internet().emailAddress());
        facebookPage.passKutusu.sendKeys(faker.internet().password());
        facebookPage.loginButonu.click();
        // 4- Basarili giris yapilamadigini test edin



        try {
            String actualText = facebookPage.girisYapilamadi.getText();
            Assert.assertTrue(actualText.contains("Facebook"));
        } catch (Exception e) {
            String acturalText2 = facebookPage.getGirisYapilamadiEvetBendim.getText();
            Assert.assertTrue(acturalText2.contains("Evet, Devam Et"));
        }

    }
}
