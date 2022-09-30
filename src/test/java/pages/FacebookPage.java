package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {
   public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(name="email")
    public WebElement emailKutusu;

    @FindBy(id="pass")
    public WebElement passKutusu;

    @FindBy(name = "login")
    public WebElement loginButonu;

    @FindBy(className = "_9ay7")
    public WebElement girilemediYazisiElementi;

    @FindBy(xpath = "//div[text()=\"Facebook'a Giriş Yap\"]")
    public WebElement girisYapilamadi;

    @FindBy(xpath = "//button[text()='Evet, Devam Et']")
    public WebElement getGirisYapilamadiEvetBendim;


    public void bekle (int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
