package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class HotelMyCampPageWebTables {
   public HotelMyCampPageWebTables(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement ilkLoginLinki;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement userNameBox;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@id='btnSubmit']")
    public WebElement loginButonu;

    @FindBy(xpath = "//thead//tr[1]//th")
    public List<WebElement> headerBirinciSatirDatalar;

    @FindBy(xpath = "//tbody//tr//td")
    public List<WebElement> tumBodyDatalarList;

    @FindBy(xpath = "//table")
    public WebElement tumBodyveHeader;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satirlarListesi;


    public void girisYap(){
        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        hotelMyCampPage.giris1.click();
        hotelMyCampPage.giris2.click();
        ilkLoginLinki.click();
        userNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        loginButonu.click();
    }

    public void satirYazdir(int satir){
        System.out.println(satir+1+".satirdaki datalar =>>"+satirlarListesi.get(satir).getText());
    }

    public String hucreGetir(int satir,int sutun) {
        //tbody//tr[x]//td[y]
       String dinamikHucrexPath="//tbody//tr["+satir+"]//td["+sutun+"]";
       WebElement dinamikHucreWE=Driver.getDriver().findElement(By.xpath(dinamikHucrexPath));
       String hucreDatasi=dinamikHucreWE.getText();

        return hucreDatasi;
    }

    public void sutunYazdir(int sutun) {
        int satirSayisi=satirlarListesi.size();

        for (int i = 1; i <=satirSayisi ; i++) {

            System.out.println(hucreGetir(i,sutun));

        }

    }
}

